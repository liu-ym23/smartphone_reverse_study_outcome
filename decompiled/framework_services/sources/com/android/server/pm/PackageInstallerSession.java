package com.android.server.pm;

import android.R;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyEventLogger;
import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.compat.CompatChanges;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.ArchivedPackageParcel;
import android.content.pm.Checksum;
import android.content.pm.DataLoaderManager;
import android.content.pm.DataLoaderParams;
import android.content.pm.DataLoaderParamsParcel;
import android.content.pm.IDataLoader;
import android.content.pm.IDataLoaderStatusListener;
import android.content.pm.IOnChecksumsReadyListener;
import android.content.pm.IPackageInstallObserver2;
import android.content.pm.IPackageInstallerSession;
import android.content.pm.IPackageInstallerSessionFileSystemConnector;
import android.content.pm.InstallSourceInfo;
import android.content.pm.InstallationFile;
import android.content.pm.InstallationFileParcel;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.SigningDetails;
import android.content.pm.dex.DexMetadataHelper;
import android.content.pm.parsing.ApkLite;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.PackageLite;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.content.pm.verify.domain.DomainSet;
import android.content.res.ApkAssets;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.ULocale;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileBridge;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ParcelableException;
import android.os.RevocableFileDescriptor;
import android.os.SELinux;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.incremental.IStorageHealthListener;
import android.os.incremental.IncrementalFileStorages;
import android.os.incremental.IncrementalManager;
import android.os.incremental.PerUidReadTimeouts;
import android.os.incremental.StorageHealthCheckParams;
import android.os.storage.StorageManager;
import android.provider.DeviceConfig;
import android.service.persistentdata.PersistentDataBlockManager;
import android.system.ErrnoException;
import android.system.Int64Ref;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.EventLog;
import android.util.ExceptionUtils;
import android.util.IntArray;
import android.util.Log;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.apk.ApkSignatureVerifier;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.content.InstallLocationUtils;
import com.android.internal.content.NativeLibraryHelper;
import com.android.internal.hidden_from_bootclasspath.com.android.art.flags.Flags;
import com.android.internal.os.SomeArgs;
import com.android.internal.security.VerityUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.am.IProcessIntercept;
import com.android.server.art.ArtManagedInstallFileHelper;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.pm.dex.DexManager;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.zte.performance.mindsync.MindSyncManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import libcore.io.IoUtils;
import libcore.util.EmptyArray;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInstallerSession extends IPackageInstallerSession.Stub {
    private static final String APEX_FILE_EXTENSION = ".apex";
    static final int APP_METADATA_FILE_ACCESS_MODE = 416;
    private static final String ATTR_ABI_OVERRIDE = "abiOverride";
    private static final String ATTR_APPLICATION_ENABLED_SETTING_PERSISTENT = "applicationEnabledSettingPersistent";

    @Deprecated
    private static final String ATTR_APP_ICON = "appIcon";
    private static final String ATTR_APP_LABEL = "appLabel";
    private static final String ATTR_APP_PACKAGE_NAME = "appPackageName";
    private static final String ATTR_CHECKSUM_KIND = "checksumKind";
    private static final String ATTR_CHECKSUM_VALUE = "checksumValue";
    private static final String ATTR_COMMITTED = "committed";
    private static final String ATTR_COMMITTED_MILLIS = "committedMillis";
    private static final String ATTR_CREATED_MILLIS = "createdMillis";
    private static final String ATTR_DATALOADER_ARGUMENTS = "dataLoaderArguments";
    private static final String ATTR_DATALOADER_CLASS_NAME = "dataLoaderClassName";
    private static final String ATTR_DATALOADER_PACKAGE_NAME = "dataLoaderPackageName";
    private static final String ATTR_DATALOADER_TYPE = "dataLoaderType";
    private static final String ATTR_DESTROYED = "destroyed";
    private static final String ATTR_DOMAIN = "domain";
    private static final String ATTR_INITIATING_PACKAGE_NAME = "installInitiatingPackageName";
    private static final String ATTR_INSTALLER_ATTRIBUTION_TAG = "installerAttributionTag";
    private static final String ATTR_INSTALLER_PACKAGE_NAME = "installerPackageName";
    private static final String ATTR_INSTALLER_PACKAGE_UID = "installerPackageUid";
    private static final String ATTR_INSTALLER_UID = "installerUid";
    private static final String ATTR_INSTALL_FLAGS = "installFlags";
    private static final String ATTR_INSTALL_LOCATION = "installLocation";
    private static final String ATTR_INSTALL_REASON = "installRason";
    private static final String ATTR_IS_APPLIED = "isApplied";
    private static final String ATTR_IS_DATALOADER = "isDataLoader";
    private static final String ATTR_IS_FAILED = "isFailed";
    private static final String ATTR_IS_READY = "isReady";
    private static final String ATTR_LENGTH_BYTES = "lengthBytes";
    private static final String ATTR_LOCATION = "location";
    private static final String ATTR_METADATA = "metadata";
    private static final String ATTR_MODE = "mode";
    private static final String ATTR_MULTI_PACKAGE = "multiPackage";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_ORIGINATING_PACKAGE_NAME = "installOriginatingPackageName";
    private static final String ATTR_ORIGINATING_UID = "originatingUid";
    private static final String ATTR_ORIGINATING_URI = "originatingUri";
    private static final String ATTR_PACKAGE_SOURCE = "packageSource";
    private static final String ATTR_PARENT_SESSION_ID = "parentSessionId";
    private static final String ATTR_PREPARED = "prepared";
    private static final String ATTR_REFERRER_URI = "referrerUri";
    private static final String ATTR_SEALED = "sealed";
    private static final String ATTR_SESSION_ERROR_CODE = "errorCode";
    private static final String ATTR_SESSION_ERROR_MESSAGE = "errorMessage";
    private static final String ATTR_SESSION_ID = "sessionId";
    private static final String ATTR_SESSION_STAGE_CID = "sessionStageCid";
    private static final String ATTR_SESSION_STAGE_DIR = "sessionStageDir";
    private static final String ATTR_SIGNATURE = "signature";
    private static final String ATTR_SIZE_BYTES = "sizeBytes";
    private static final String ATTR_STAGED_SESSION = "stagedSession";
    private static final String ATTR_UPDATED_MILLIS = "updatedMillis";
    private static final String ATTR_UPDATE_OWNER_PACKAGE_NAME = "updateOwnererPackageName";
    private static final String ATTR_USER_ID = "userId";
    private static final String ATTR_VOLUME_UUID = "volumeUuid";
    static final String DEFAULT_APPSTORE = "com.obric.appstore";
    private static final long DEFAULT_APP_METADATA_BYTE_SIZE_LIMIT = 32000;
    private static final long DEFAULT_PRE_VERIFIED_DOMAINS_COUNT_LIMIT = 1000;
    private static final long DEFAULT_PRE_VERIFIED_DOMAIN_LENGTH_LIMIT = 256;
    private static final int[] EMPTY_CHILD_SESSION_ARRAY = null;
    private static final InstallationFile[] EMPTY_INSTALLATION_FILE_ARRAY = null;
    private static final int INCREMENTAL_STORAGE_BLOCKED_TIMEOUT_MS = 2000;
    private static final int INCREMENTAL_STORAGE_UNHEALTHY_MONITORING_MS = 60000;
    private static final int INCREMENTAL_STORAGE_UNHEALTHY_TIMEOUT_MS = 7000;
    private static final int INVALID_TARGET_SDK_VERSION = Integer.MAX_VALUE;
    private static final boolean LOGD = true;
    private static final int MSG_INSTALL = 3;
    private static final int MSG_ON_NATIVE_LIBS_EXTRACTED = 7;
    private static final int MSG_ON_PACKAGE_INSTALLED = 4;
    private static final int MSG_ON_SESSION_SEALED = 1;
    private static final int MSG_PRE_APPROVAL_REQUEST = 6;
    private static final int MSG_SESSION_VALIDATION_FAILURE = 5;
    private static final int MSG_STREAM_VALIDATE_AND_COMMIT = 2;
    private static final long PRE_APPROVAL_WITH_UPDATE_OWNERSHIP_FIX = 293644536;
    private static final String PROPERTY_APP_METADATA_BYTE_SIZE_LIMIT = "app_metadata_byte_size_limit";
    private static final String PROPERTY_NAME_INHERIT_NATIVE = "pi.inherit_native_on_dont_kill";
    private static final String PROPERTY_PRE_VERIFIED_DOMAINS_COUNT_LIMIT = "pre_verified_domains_count_limit";
    private static final String PROPERTY_PRE_VERIFIED_DOMAIN_LENGTH_LIMIT = "pre_verified_domain_length_limit";
    private static final String REMOVE_MARKER_EXTENSION = ".removed";
    private static final long SILENT_INSTALL_ALLOWED = 325888262;
    private static final String SYSTEM_DATA_LOADER_PACKAGE = "android";
    private static final String TAG = "PackageInstallerSession";
    private static final String TAG_AUTO_REVOKE_PERMISSIONS_MODE = "auto-revoke-permissions-mode";
    static final String TAG_CHILD_SESSION = "childSession";
    private static final String TAG_DENY_PERMISSION = "deny-permission";
    private static final String TAG_GRANTED_RUNTIME_PERMISSION = "granted-runtime-permission";
    private static final String TAG_GRANT_PERMISSION = "grant-permission";
    static final String TAG_PRE_VERIFIED_DOMAINS = "preVerifiedDomains";
    static final String TAG_SESSION = "session";
    static final String TAG_SESSION_CHECKSUM = "sessionChecksum";
    static final String TAG_SESSION_CHECKSUM_SIGNATURE = "sessionChecksumSignature";
    static final String TAG_SESSION_FILE = "sessionFile";
    private static final String TAG_WHITELISTED_RESTRICTED_PERMISSION = "whitelisted-restricted-permission";
    private static final long THROW_EXCEPTION_COMMIT_WITH_IMMUTABLE_PENDING_INTENT = 240618202;
    private static final int USER_ACTION_NOT_NEEDED = 0;
    private static final int USER_ACTION_PENDING_APK_PARSING = 2;
    private static final int USER_ACTION_REQUIRED = 1;
    private static final int USER_ACTION_REQUIRED_UPDATE_OWNER_REMINDER = 3;
    private static final FileFilter sAddedApkFilter = null;
    private static final FileFilter sAddedFilter = null;
    private static final FileFilter sArtManagedFilter = null;
    private static final FileFilter sRemovedFilter = null;
    private final int MAX_INSTALL_DURATION;
    private long committedMillis;
    final long createdMillis;
    private final AtomicInteger mActiveCount;
    private final ArrayList<FileBridge> mBridges;
    private final PackageInstallerService.InternalCallback mCallback;
    private final ArrayMap<String, PerFileChecksum> mChecksums;
    private final SparseArray<PackageInstallerSession> mChildSessions;
    private float mClientProgress;
    private final AtomicBoolean mCommitted;
    private final Context mContext;
    private volatile boolean mDataLoaderFinished;
    private AtomicBoolean mDependencyInstallerEnabled;
    private volatile boolean mDestroyed;
    private final ArrayList<RevocableFileDescriptor> mFds;
    private final ArraySet<FileEntry> mFiles;
    private String mFinalMessage;
    private int mFinalStatus;
    private final Handler mHandler;
    private final Handler.Callback mHandlerCallback;
    private boolean mHasAppMetadataFile;
    private boolean mHasDeviceAdminReceiver;
    private IncrementalFileStorages mIncrementalFileStorages;
    private float mIncrementalProgress;
    private File mInheritedFilesBase;
    private final InstallDependencyHelper mInstallDependencyHelper;
    private InstallSource mInstallSource;
    private final Installer mInstaller;
    private volatile int mInstallerUid;
    private float mInternalProgress;
    private boolean mIsPerfLockAcquired;
    private final Object mLock;
    private AtomicInteger mMissingSharedLibraryCount;
    private final String mOriginalInstallerPackageName;
    private final int mOriginalInstallerUid;
    private PackageLite mPackageLite;
    private String mPackageName;
    private int mParentSessionId;
    private Runnable mPendingAbandonCallback;
    private BoostFramework mPerfBoostInstall;
    private boolean mPermissionsManuallyAccepted;
    private final PackageManagerService mPm;
    private DomainSet mPreVerifiedDomains;
    private PackageInstaller.PreapprovalDetails mPreapprovalDetails;
    private IntentSender mPreapprovalRemoteStatusReceiver;
    private final AtomicBoolean mPreapprovalRequested;
    private boolean mPrepared;
    private float mProgress;
    private final Object mProgressLock;
    private IntentSender mRemoteStatusReceiver;
    private float mReportedProgress;
    private File mResolvedBaseFile;
    private final List<File> mResolvedInheritedFiles;
    private final List<String> mResolvedInstructionSets;
    private final List<String> mResolvedNativeLibPaths;
    private final List<File> mResolvedStagedFiles;
    private boolean mSealed;
    private boolean mSessionApplied;
    private int mSessionErrorCode;
    private String mSessionErrorMessage;
    private boolean mSessionFailed;
    private final PackageSessionProvider mSessionProvider;
    private boolean mSessionReady;
    private boolean mShouldBeSealed;
    private SigningDetails mSigningDetails;
    private final SilentUpdatePolicy mSilentUpdatePolicy;
    private boolean mStageDirInUse;
    final StagedSession mStagedSession;
    private final StagingManager mStagingManager;
    private final AtomicBoolean mTransactionLock;
    private final Set<IntentSender> mUnarchivalListeners;
    private int mUnarchivalStatus;
    private Boolean mUserActionRequired;
    private int mUserActionRequirement;
    private int mValidatedTargetSdk;
    private boolean mVerificationInProgress;
    private long mVersionCode;
    final PackageInstaller.SessionParams params;
    final int sessionId;
    final String stageCid;
    final File stageDir;
    private long updatedMillis;
    final int userId;

    static class FileEntry {
        private final InstallationFile mFile;
        private final int mIndex;

        FileEntry(int index, InstallationFile file) {
            this.mIndex = index;
            this.mFile = file;
        }

        int getIndex() {
            return this.mIndex;
        }

        InstallationFile getFile() {
            return this.mFile;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof FileEntry) == true) goto L5;
            return false;
        L5:
            FileEntry rhs = (FileEntry) obj;
            if (this.mFile.getLocation() == rhs.mFile.getLocation()) goto L8;
            return false;
        L8:
            if (TextUtils.equals(this.mFile.getName(), rhs.mFile.getName()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mFile.getLocation()), this.mFile.getName()});
        }
    }

    private final class FileSystemConnector extends IPackageInstallerSessionFileSystemConnector.Stub {
        final Set<String> mAddedFiles;
        final /* synthetic */ PackageInstallerSession this$0;

        FileSystemConnector(PackageInstallerSession r4, List<InstallationFileParcel> addedFiles) {
            this.this$0 = r4;
            this.mAddedFiles = new ArraySet();
            Iterator<InstallationFileParcel> r5 = addedFiles.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            InstallationFileParcel file = r5.next();
            this.mAddedFiles.add(file.name);
            goto L4
        }

        public void writeData(String name, long offsetBytes, long lengthBytes, ParcelFileDescriptor incomingFd) {
            if (incomingFd == null) goto L18;
            if (this.mAddedFiles.contains(name) == false) goto L16;
            PackageInstallerSession.m6766$$Nest$mdoWriteInternal(this.this$0, name, offsetBytes, lengthBytes, incomingFd);     // Catch: IOException -> L9
            return;
        L9:
            e = move-exception;
            IOException e = e;
        L14:
            throw ExceptionUtils.wrap(e);
        L11:
            e = move-exception;
            e = e;
            goto L14
        L16:
            throw new SecurityException("File name is not in the list of added files.");
        L18:
            throw new IllegalArgumentException("incomingFd can't be null");
        }
    }

    private static class InstallResult {
        public final Bundle extras;
        public final PackageInstallerSession session;

        InstallResult(PackageInstallerSession session, Bundle extras) {
            this.session = session;
            this.extras = extras;
        }
    }

    static class PerFileChecksum {
        private final Checksum[] mChecksums;
        private final byte[] mSignature;

        PerFileChecksum(Checksum[] checksums, byte[] signature) {
            this.mChecksums = checksums;
            this.mSignature = signature;
        }

        Checksum[] getChecksums() {
            return this.mChecksums;
        }

        byte[] getSignature() {
            return this.mSignature;
        }
    }

    public class StagedSession implements StagingManager.StagedSession {
        final /* synthetic */ PackageInstallerSession this$0;

        public static /* synthetic */ boolean $r8$lambda$EG0DOq77RO1tsJg3PLcV7kYVcXU(Predicate r0, PackageInstallerSession r1) {
            return lambda$sessionContains$1(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$p-_-ekLFHxve4wJ-yS3OsaUAzjU, reason: not valid java name */
        public static /* synthetic */ boolean m6786$r8$lambda$p_ekLFHxve4wJyS3OsaUAzjU(StagingManager.StagedSession r0) {
            return lambda$containsApexSession$0(r0);
        }

        public StagedSession(PackageInstallerSession this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public List<StagingManager.StagedSession> getChildSessions() {
            if (this.this$0.params.isMultiPackage == false) goto L5;
            Object r0 = PackageInstallerSession.m6755$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int size = PackageInstallerSession.m6751$$Nest$fgetmChildSessions(this.this$0).size();     // Catch: Throwable -> L11
            List<StagingManager.StagedSession> childSessions = new ArrayList(size);     // Catch: Throwable -> L11
            int i = 0;
        L9:
            if (i >= size) goto L14;
            childSessions.add(((PackageInstallerSession) PackageInstallerSession.m6751$$Nest$fgetmChildSessions(this.this$0).valueAt(i)).mStagedSession);     // Catch: Throwable -> L11
            i = i + 1;     // Catch: Throwable -> L11
            goto L9
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return childSessions;
        L11:
            th = move-exception;
            throw th;
        L5:
            return Collections.EMPTY_LIST;
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public PackageInstaller.SessionParams sessionParams() {
            return this.this$0.params;
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean isMultiPackage() {
            return this.this$0.params.isMultiPackage;
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean isApexSession() {
            if ((this.this$0.params.installFlags & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public int sessionId() {
            return this.this$0.sessionId;
        }

        private static /* synthetic */ boolean lambda$containsApexSession$0(StagingManager.StagedSession s) {
            return s.isApexSession();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean containsApexSession() {
            return sessionContains(new PackageInstallerSession$StagedSession$$ExternalSyntheticLambda0());
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public String getPackageName() {
            return this.this$0.getPackageName();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public void setSessionReady() {
            this.this$0.setSessionReady();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public void setSessionFailed(int errorCode, String errorMessage) {
            this.this$0.setSessionFailed(errorCode, errorMessage);
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public void setSessionApplied() {
            PackageInstallerSession.m6781$$Nest$msetSessionApplied(this.this$0);
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean containsApkSession() {
            return this.this$0.containsApkSession();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public CompletableFuture<Void> installSession() {
            PackageInstallerSession.m6761$$Nest$massertCallerIsOwnerOrRootOrSystem(this.this$0);
            PackageInstallerSession.m6762$$Nest$massertNotChild(this.this$0, "StagedSession#installSession");
            if (isCommitted() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            Preconditions.checkArgument(r0);
            return PackageInstallerSession.m6775$$Nest$minstall(this.this$0);
        L5:
            if (isSessionReady() == false) goto L7;
            r0 = true;
            goto L8
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean hasParentSessionId() {
            return this.this$0.hasParentSessionId();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public int getParentSessionId() {
            return this.this$0.getParentSessionId();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean isCommitted() {
            return this.this$0.isCommitted();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean isInTerminalState() {
            return PackageInstallerSession.m6776$$Nest$misInTerminalState(this.this$0);
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean isDestroyed() {
            return this.this$0.isDestroyed();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public long getCommittedMillis() {
            return this.this$0.getCommittedMillis();
        }

        private static /* synthetic */ boolean lambda$sessionContains$1(Predicate filter, PackageInstallerSession s) {
            return filter.test(s.mStagedSession);
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean sessionContains(final Predicate<StagingManager.StagedSession> filter) {
            return this.this$0.sessionContains(new PackageInstallerSession$StagedSession$$ExternalSyntheticLambda1(filter));
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean isSessionReady() {
            return this.this$0.isSessionReady();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean isSessionApplied() {
            return this.this$0.isSessionApplied();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public boolean isSessionFailed() {
            return this.this$0.isSessionFailed();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public void abandon() {
            this.this$0.abandon();
        }

        @Override // com.android.server.pm.StagingManager.StagedSession
        public void verifySession() {
            PackageInstallerSession.m6761$$Nest$massertCallerIsOwnerOrRootOrSystem(this.this$0);
            if (isCommittedAndNotInTerminalState() == false) goto L6;
            PackageInstallerSession.m6782$$Nest$mverify(this.this$0);
            return;
        }

        private boolean isCommittedAndNotInTerminalState() {
            String errorMsg = null;
            if (isCommitted() == true) goto L6;
            errorMsg = TextUtils.formatSimple("The session %d should be committed", new Object[]{Integer.valueOf(this.this$0.sessionId)});
        L18:
            if (errorMsg == null) goto L21;
            Slog.e(PackageInstallerSession.TAG, "verifySession error: " + errorMsg);
            setSessionFailed(-110, errorMsg);
            PackageInstallerSession.m6779$$Nest$monSessionVerificationFailure(this.this$0, -110, errorMsg);
            return false;
        L21:
            return true;
        L6:
            if (isSessionApplied() == false) goto L9;
            errorMsg = TextUtils.formatSimple("The session %d has applied", new Object[]{Integer.valueOf(this.this$0.sessionId)});
            goto L18
        L9:
            if (isSessionFailed() == false) goto L18;
            Object r1 = PackageInstallerSession.m6755$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            errorMsg = TextUtils.formatSimple("The session %d has failed with error: %s", new Object[]{Integer.valueOf(this.this$0.sessionId), PackageInstallerSession.m6757$$Nest$fgetmSessionErrorMessage(this.this$0)});     // Catch: Throwable -> L15
            monitor-exit(r1);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }
    }

    @interface UserActionRequirement {
    }

    /* JADX INFO: renamed from: $r8$lambda$-04BFDHl71Bjvir8RL_BbNz1WNc, reason: not valid java name */
    public static /* synthetic */ String m6746$r8$lambda$04BFDHl71Bjvir8RL_BbNz1WNc(Context r0) {
        return lambda$getDeviceOwnerInstalledPackageMsg$12(r0);
    }

    public static /* synthetic */ void $r8$lambda$HPvoMZE2VaXivMm0AtPBYRVIuVU(PackageInstallerSession r0, int r1, String r2) {
        r0.lambda$verifyNonStaged$5(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$I3lTjoSGPMiYESIPpNWbAws1gqQ(PackageInstallerSession r0) {
        return lambda$addChildSessionId$9(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$PRZKug1BDQz1xwL3EtGP0yZAlPw(IntentSender r0, PackageInstallerSession r1) {
        return lambda$sendPendingUserActionIntentIfNeeded$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XErf_7mksmN97ma-bUYdB489ggk, reason: not valid java name */
    public static /* synthetic */ String m6747$r8$lambda$XErf_7mksmN97mabUYdB489ggk(Context r0) {
        return lambda$getDeviceOwnerInstalledPackageMsg$11(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZfLnYigbG-epa27yQiQwgcHMEno, reason: not valid java name */
    public static /* synthetic */ void m6748$r8$lambda$ZfLnYigbGepa27yQiQwgcHMEno(PackageInstallerSession r0, int r1, long r2, PendingIntent r4) {
        r0.lambda$reportUnarchivalStatus$10(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$_9uu2JsAeqFlF-CRdPv1b3cu40g, reason: not valid java name */
    public static /* synthetic */ void m6749$r8$lambda$_9uu2JsAeqFlFCRdPv1b3cu40g(PackageInstallerSession r0, String r1) {
        r0.lambda$onSystemDataLoaderUnrecoverable$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$_ZrC3BU0LxXDPhU_02tt6EZqxQo(PackageInstallerSession r0) {
        return lambda$containsApkSession$7(r0);
    }

    public static /* synthetic */ void $r8$lambda$cpaSBsGhfR1fLiMwWccyIWaSU48(PackageInstallerSession r0, Int64Ref r1, long r2) {
        r0.lambda$doWriteInternal$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$k4uYTLMSN8eYNrDmB7HXdTeo7EA(PackageInstallerSession r0) {
        r0.lambda$abandon$8();
    }

    public static /* synthetic */ void $r8$lambda$p4YVzobEqJBvKqGc5Apq_VHJF3U(PackageInstallerSession r0, int r1, String r2) {
        r0.lambda$verifyNonStaged$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$sgs9lih_2X72Fvgn_V2bv0bceLI(PackageInstallerSession r0, List r1, Void r2, Throwable r3) {
        r0.lambda$install$6(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$yrLDLyazwoJTU-aHGVk8zMZ-Nxc, reason: not valid java name */
    public static /* synthetic */ void m6750$r8$lambda$yrLDLyazwoJTUaHGVk8zMZNxc(PackageInstallerSession r0) {
        r0.lambda$runExtractNativeLibraries$3();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmChildSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m6751$$Nest$fgetmChildSessions(PackageInstallerSession r0) {
        return r0.mChildSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6752$$Nest$fgetmContext(PackageInstallerSession r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataLoaderFinished, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6753$$Nest$fgetmDataLoaderFinished(PackageInstallerSession r0) {
        return r0.mDataLoaderFinished;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDestroyed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6754$$Nest$fgetmDestroyed(PackageInstallerSession r0) {
        return r0.mDestroyed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6755$$Nest$fgetmLock(PackageInstallerSession r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProgressLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6756$$Nest$fgetmProgressLock(PackageInstallerSession r0) {
        return r0.mProgressLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionErrorMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6757$$Nest$fgetmSessionErrorMessage(PackageInstallerSession r0) {
        return r0.mSessionErrorMessage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageSessionProvider m6758$$Nest$fgetmSessionProvider(PackageInstallerSession r0) {
        return r0.mSessionProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDataLoaderFinished, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6759$$Nest$fputmDataLoaderFinished(PackageInstallerSession r0, boolean r1) {
        r0.mDataLoaderFinished = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIncrementalProgress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6760$$Nest$fputmIncrementalProgress(PackageInstallerSession r0, float r1) {
        r0.mIncrementalProgress = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$massertCallerIsOwnerOrRootOrSystem, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6761$$Nest$massertCallerIsOwnerOrRootOrSystem(PackageInstallerSession r0) {
        r0.assertCallerIsOwnerOrRootOrSystem();
    }

    /* JADX INFO: renamed from: -$$Nest$massertNotChild, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6762$$Nest$massertNotChild(PackageInstallerSession r0, String r1) {
        r0.assertNotChild(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcomputeProgressLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6763$$Nest$mcomputeProgressLocked(PackageInstallerSession r0, boolean r1) {
        r0.computeProgressLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchSessionSealed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6764$$Nest$mdispatchSessionSealed(PackageInstallerSession r0) {
        r0.dispatchSessionSealed();
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchSessionValidationFailure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6765$$Nest$mdispatchSessionValidationFailure(PackageInstallerSession r0, int r1, String r2) {
        r0.dispatchSessionValidationFailure(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoWriteInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ParcelFileDescriptor m6766$$Nest$mdoWriteInternal(PackageInstallerSession r0, String r1, long r2, long r4, ParcelFileDescriptor r6) {
        return r0.doWriteInternal(r1, r2, r4, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDataLoader, reason: not valid java name */
    static /* bridge */ /* synthetic */ IDataLoader m6767$$Nest$mgetDataLoader(PackageInstallerSession r0, int r1) {
        return r0.getDataLoader(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRemoteStatusReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntentSender m6768$$Nest$mgetRemoteStatusReceiver(PackageInstallerSession r0) {
        return r0.getRemoteStatusReceiver();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleDependencyResolutionFailure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6769$$Nest$mhandleDependencyResolutionFailure(PackageInstallerSession r0, PackageManagerException r1) {
        r0.handleDependencyResolutionFailure(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleInstall, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6770$$Nest$mhandleInstall(PackageInstallerSession r0) {
        r0.handleInstall();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnNativeLibsExtracted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6771$$Nest$mhandleOnNativeLibsExtracted(PackageInstallerSession r0) {
        r0.handleOnNativeLibsExtracted();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePreapprovalRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6772$$Nest$mhandlePreapprovalRequest(PackageInstallerSession r0) {
        r0.handlePreapprovalRequest();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSessionSealed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6773$$Nest$mhandleSessionSealed(PackageInstallerSession r0) {
        r0.handleSessionSealed();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStreamValidateAndCommit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6774$$Nest$mhandleStreamValidateAndCommit(PackageInstallerSession r0) {
        r0.handleStreamValidateAndCommit();
    }

    /* JADX INFO: renamed from: -$$Nest$minstall, reason: not valid java name */
    static /* bridge */ /* synthetic */ CompletableFuture m6775$$Nest$minstall(PackageInstallerSession r0) {
        return r0.install();
    }

    /* JADX INFO: renamed from: -$$Nest$misInTerminalState, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6776$$Nest$misInTerminalState(PackageInstallerSession r0) {
        return r0.isInTerminalState();
    }

    /* JADX INFO: renamed from: -$$Nest$misInstallerDeviceOwnerOrAffiliatedProfileOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6777$$Nest$misInstallerDeviceOwnerOrAffiliatedProfileOwner(PackageInstallerSession r0) {
        return r0.isInstallerDeviceOwnerOrAffiliatedProfileOwner();
    }

    /* JADX INFO: renamed from: -$$Nest$monSessionValidationFailure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6778$$Nest$monSessionValidationFailure(PackageInstallerSession r0, int r1, String r2) {
        r0.onSessionValidationFailure(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monSessionVerificationFailure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6779$$Nest$monSessionVerificationFailure(PackageInstallerSession r0, int r1, String r2) {
        r0.onSessionVerificationFailure(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monSystemDataLoaderUnrecoverable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6780$$Nest$monSystemDataLoaderUnrecoverable(PackageInstallerSession r0) {
        r0.onSystemDataLoaderUnrecoverable();
    }

    /* JADX INFO: renamed from: -$$Nest$msetSessionApplied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6781$$Nest$msetSessionApplied(PackageInstallerSession r0) {
        r0.setSessionApplied();
    }

    /* JADX INFO: renamed from: -$$Nest$mverify, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6782$$Nest$mverify(PackageInstallerSession r0) {
        r0.verify();
    }

    /* JADX INFO: renamed from: -$$Nest$smisAppMetadata, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6783$$Nest$smisAppMetadata(File r0) {
        return isAppMetadata(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smsendOnPackageInstalled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6784$$Nest$smsendOnPackageInstalled(Context r0, IntentSender r1, int r2, boolean r3, int r4, String r5, int r6, boolean r7, String r8, Bundle r9) {
        sendOnPackageInstalled(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: -$$Nest$smsendPendingStreaming, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6785$$Nest$smsendPendingStreaming(Context r0, IntentSender r1, int r2, String r3) {
        sendPendingStreaming(r0, r1, r2, r3);
    }

    static {
        EMPTY_CHILD_SESSION_ARRAY = EmptyArray.INT;
        EMPTY_INSTALLATION_FILE_ARRAY = new InstallationFile[0];
        sAddedApkFilter = new AnonymousClass1();
        sAddedFilter = new AnonymousClass2();
        sRemovedFilter = new AnonymousClass3();
        sArtManagedFilter = new AnonymousClass4();
    }

    static boolean isDataLoaderInstallation(PackageInstaller.SessionParams params) {
        if (params.dataLoaderParams == null) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isSystemDataLoaderInstallation(PackageInstaller.SessionParams params) {
        if (isDataLoaderInstallation(params) == true) goto L7;
        return false;
    L7:
        return "android".equals(params.dataLoaderParams.getComponentName().getPackageName());
    }

    static boolean isArchivedInstallation(int installFlags) {
        if ((134217728 & installFlags) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isDataLoaderInstallation() {
        return isDataLoaderInstallation(this.params);
    }

    private boolean isStreamingInstallation() {
        if (isDataLoaderInstallation() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.params.dataLoaderParams.getType() != 1) goto L7;
        return true;
    }

    private boolean isIncrementalInstallation() {
        if (isDataLoaderInstallation() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.params.dataLoaderParams.getType() != 2) goto L7;
        return true;
    }

    private boolean isSystemDataLoaderInstallation() {
        return isSystemDataLoaderInstallation(this.params);
    }

    private boolean isArchivedInstallation() {
        return isArchivedInstallation(this.params.installFlags);
    }

    private boolean isInstallerDeviceOwnerOrAffiliatedProfileOwner() {
        assertNotLocked("isInstallerDeviceOwnerOrAffiliatedProfileOwner");
        if (this.userId == UserHandle.getUserId(getInstallerUid())) goto L5;
        return false;
    L5:
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        if (dpmi != null) goto L8;
        return false;
    L8:
        if (dpmi.canSilentlyInstallPackage(getInstallSource().mInstallerPackageName, this.mInstallerUid) == false) goto L12;
        return true;
    L12:
        return false;
    }

    static boolean isEmergencyInstallerEnabled(String packageName, Computer snapshot, int userId, int installerUid) {
        PackageStateInternal ps = snapshot.getPackageStateInternal(packageName);
        if (ps != null) goto L5;
    L26:
        return false;
    L5:
        if (ps.getPkg() == null) goto L26;
        if (ps.isSystem() == false) goto L26;
        int uid = UserHandle.getUid(userId, ps.getAppId());
        String emergencyInstaller = ps.getPkg().getEmergencyInstaller();
        if (emergencyInstaller != null) goto L12;
    L25:
        return false;
    L12:
        if (ArrayUtils.contains(snapshot.getPackagesForUid(installerUid), emergencyInstaller) == false) goto L25;
        if (snapshot.checkUidPermission("android.permission.INSTALL_PACKAGES", uid) == 0) goto L22;
        if (snapshot.checkUidPermission("android.permission.INSTALL_PACKAGE_UPDATES", uid) == 0) goto L22;
        if (snapshot.checkUidPermission("android.permission.INSTALL_SELF_UPDATES", uid) == 0) goto L22;
        return false;
    L22:
        if (snapshot.checkUidPermission("android.permission.EMERGENCY_INSTALL_PACKAGES", installerUid) != 0) goto L27;
        return true;
    L27:
        return false;
    }

    private int computeUserActionRequirement() {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L8:
        th = th;
    L189:
        throw th;
    L185:
        th = th;
        goto L189
    L5:
        if (this.mPermissionsManuallyAccepted == false) goto L11;
        monitor-exit(r2);     // Catch: Throwable -> L8
        return 0;
    L11:
        if (this.mPackageName == null) goto L14;
        String packageName = this.mPackageName;     // Catch: Throwable -> L8
    L19:
        boolean hasDeviceAdminReceiver = this.mHasDeviceAdminReceiver;     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        if ((this.params.installFlags & 1024) == 0) goto L24;
    L27:
        boolean r0 = true;
    L28:
        boolean forceUserActionPrompt = r0;
        if (forceUserActionPrompt == false) goto L31;
        int r1 = 1;
    L32:
        int userActionNotTypicallyNeededResponse = r1;
        Computer snapshot = this.mPm.snapshotComputer();
        if (snapshot.checkUidPermission("android.permission.INSTALL_PACKAGES", this.mInstallerUid) != 0) goto L35;
        boolean r3 = true;
    L36:
        boolean isInstallPermissionGranted = r3;
        if (snapshot.checkUidPermission("android.permission.INSTALL_SELF_UPDATES", this.mInstallerUid) != 0) goto L39;
        boolean r4 = true;
    L40:
        boolean isSelfUpdatePermissionGranted = r4;
        if (snapshot.checkUidPermission("android.permission.INSTALL_PACKAGE_UPDATES", this.mInstallerUid) != 0) goto L43;
        boolean r5 = true;
    L44:
        boolean isUpdatePermissionGranted = r5;
        if (snapshot.checkUidPermission("android.permission.UPDATE_PACKAGES_WITHOUT_USER_ACTION", this.mInstallerUid) != 0) goto L47;
        boolean r6 = true;
    L48:
        boolean isUpdateWithoutUserActionPermissionGranted = r6;
        if (snapshot.checkUidPermission("android.permission.INSTALL_DPC_PACKAGES", this.mInstallerUid) != 0) goto L51;
        boolean r7 = true;
    L52:
        boolean isInstallDpcPackagesPermissionGranted = r7;
        if (snapshot.checkUidPermission("android.permission.INSTALL_DEPENDENCY_SHARED_LIBRARIES", this.mInstallerUid) != 0) goto L55;
        boolean isInstallDependencyPackagesPermissionGranted = true;
    L56:
        int targetPackageUid = snapshot.getPackageUid(packageName, 4294967296L, this.userId);
        if (targetPackageUid == (-1)) goto L59;
    L62:
        boolean r8 = true;
    L63:
        boolean isUpdate = r8;
        String r9 = null;
        if (isUpdate == false) goto L66;
        InstallSourceInfo r10 = snapshot.getInstallSourceInfo(packageName, this.userId);
    L67:
        InstallSourceInfo existingInstallSourceInfo = r10;
        if (existingInstallSourceInfo == null) goto L70;
        String existingInstallerPackageName = existingInstallSourceInfo.getInstallingPackageName();
    L72:
        if (existingInstallSourceInfo == null) goto L75;
        r9 = existingInstallSourceInfo.getUpdateOwnerPackageName();
    L75:
        String existingUpdateOwnerPackageName = r9;
        if (isUpdate == true) goto L78;
    L80:
        boolean r11 = false;
    L81:
        boolean isInstallerOfRecord = r11;
        boolean isUpdateOwner = TextUtils.equals(existingUpdateOwnerPackageName, getInstallerPackageName());
        if (targetPackageUid != this.mInstallerUid) goto L84;
        boolean r12 = true;
    L85:
        boolean isSelfUpdate = r12;
        boolean isEmergencyInstall = isEmergencyInstallerEnabled(packageName, snapshot, this.userId, this.mInstallerUid);
        boolean isSdkOrStaticLibraryInstall = false;
        Object r13 = this.mLock;
        monitor-enter(r13);
    L177:
        th = th;
    L194:
        monitor-exit(r13);     // Catch: Throwable -> L181
        throw th;
    L181:
        th = th;
        goto L194
    L88:
        if (this.mPackageLite != null) goto L187;
    L99:
        monitor-exit(r13);     // Catch: Throwable -> L177
        if (isInstallPermissionGranted == true) goto L111;
        if (isUpdatePermissionGranted == false) goto L103;
        if (isUpdate == true) goto L111;
    L103:
        if (isSelfUpdatePermissionGranted == false) goto L105;
        if (isSelfUpdate == true) goto L111;
    L105:
        if (isInstallDpcPackagesPermissionGranted == false) goto L107;
        if (hasDeviceAdminReceiver == true) goto L111;
    L107:
        if (isInstallDependencyPackagesPermissionGranted == false) goto L110;
        if (isSdkOrStaticLibraryInstall == true) goto L111;
    L110:
        boolean isPermissionGranted = false;
    L113:
        if (this.mInstallerUid != 0) goto L115;
        boolean isInstallerRoot = true;
    L116:
        boolean isPermissionGranted2 = isPermissionGranted;
        boolean isInstallerRoot2 = isInstallerRoot;
        if (this.mInstallerUid != 1000) goto L119;
        boolean isInstallerSystem = true;
    L120:
        boolean isInstallerSystem2 = isInstallerSystem;
        if (this.mInstallerUid != 2000) goto L123;
        boolean isInstallerShell = true;
    L125:
        if ((this.params.installFlags & 67108864) == 0) goto L127;
        boolean isFromManagedUserOrProfile = true;
    L129:
        if (PackageManagerService.isUpdateOwnershipEnforcementAvailable() == false) goto L132;
        if (existingUpdateOwnerPackageName == null) goto L132;
        boolean isUpdateOwnershipEnforcementEnabled = true;
    L133:
        boolean isInstallerShell2 = isInstallerShell;
        if ((this.params.installFlags & 1073741824) == 0) goto L136;
        boolean isInstallUnarchive = true;
    L137:
        if (isInstallerRoot2 == true) goto L148;
        if (isInstallerSystem2 == true) goto L148;
        if (isInstallerDeviceOwnerOrAffiliatedProfileOwner() == true) goto L147;
        if (isEmergencyInstall == true) goto L147;
        if (isInstallUnarchive == true) goto L147;
        boolean isFromManagedUserOrProfile2 = isFromManagedUserOrProfile;
        if (DEFAULT_APPSTORE.equals(getInstallerPackageName()) == true) goto L149;
        boolean noUserActionNecessary = false;
    L151:
        if (noUserActionNecessary == false) goto L153;
        return userActionNotTypicallyNeededResponse;
    L153:
        if (isUpdateOwnershipEnforcementEnabled == true) goto L155;
    L161:
        if (isPermissionGranted2 == false) goto L164;
        return userActionNotTypicallyNeededResponse;
    L164:
        if (snapshot.isInstallDisabledForPackage(getInstallerPackageName(), this.mInstallerUid, this.userId) == false) goto L167;
        return 1;
    L167:
        if (this.params.requireUserAction != 2) goto L176;
        if (isUpdateWithoutUserActionPermissionGranted == false) goto L176;
        if (isUpdateOwnershipEnforcementEnabled == false) goto L172;
        if (isUpdateOwner == true) goto L175;
    L173:
        if (isSelfUpdate == false) goto L176;
    L175:
        return 2;
    L172:
        if (isInstallerOfRecord == true) goto L175;
    L176:
        return 1;
    L155:
        if (isApexSession() == true) goto L161;
        if (isUpdateOwner == true) goto L161;
        if (isInstallerShell2 == true) goto L161;
        if (isFromManagedUserOrProfile2 == true) goto L161;
        return 3;
    L149:
        noUserActionNecessary = true;
    L147:
        isFromManagedUserOrProfile2 = isFromManagedUserOrProfile;
    L148:
        isFromManagedUserOrProfile2 = isFromManagedUserOrProfile;
        goto L149
    L136:
        isInstallUnarchive = false;
    L132:
        isUpdateOwnershipEnforcementEnabled = false;
        goto L133
    L127:
        isFromManagedUserOrProfile = false;
        goto L129
    L123:
        isInstallerShell = false;
        goto L125
    L119:
        isInstallerSystem = false;
        goto L120
    L115:
        isInstallerRoot = false;
    L111:
        isPermissionGranted = true;
        goto L113
    L187:
    L95:
        th = th;
        goto L194
    L90:
        if (this.mPackageLite.isIsSdkLibrary() == true) goto L97;
        if (this.mPackageLite.isIsStaticLibrary() == true) goto L97;
        boolean r14 = false;
    L98:
        isSdkOrStaticLibraryInstall = r14;
    L97:
        r14 = true;
        goto L98
    L84:
        r12 = false;
        goto L85
    L78:
        if (Objects.equals(existingInstallerPackageName, getInstallerPackageName()) == false) goto L80;
        r11 = true;
        goto L81
    L70:
        existingInstallerPackageName = null;
        goto L72
    L66:
        r10 = null;
        goto L67
    L59:
        if (isApexSession() == true) goto L62;
        r8 = false;
        goto L63
    L55:
        isInstallDependencyPackagesPermissionGranted = false;
        goto L56
    L51:
        r7 = false;
        goto L52
    L47:
        r6 = false;
        goto L48
    L43:
        r5 = false;
        goto L44
    L39:
        r4 = false;
        goto L40
    L35:
        r3 = false;
        goto L36
    L31:
        r1 = 0;
        goto L32
    L24:
        if (this.params.requireUserAction == 1) goto L27;
        r0 = false;
        goto L28
    L14:
        if (this.mPreapprovalRequested.get() == true) goto L16;
    L18:
        packageName = null;
        goto L19
    L16:
        if (this.mPreapprovalDetails == null) goto L18;
        packageName = this.mPreapprovalDetails.getPackageName();     // Catch: Throwable -> L8
        goto L19
    }

    private void updateUserActionRequirement(int requirement) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserActionRequirement = requirement;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public PackageInstallerSession(PackageInstallerService.InternalCallback callback, Context context, PackageManagerService pm, PackageSessionProvider sessionProvider, SilentUpdatePolicy silentUpdatePolicy, Looper looper, StagingManager stagingManager, int sessionId, int userId, int installerUid, InstallSource installSource, PackageInstaller.SessionParams params, long createdMillis, long committedMillis, File stageDir, String stageCid, InstallationFile[] files, ArrayMap<String, PerFileChecksum> checksums, boolean prepared, boolean committed, boolean destroyed, boolean sealed, int[] childSessionIds, int parentSessionId, boolean isReady, boolean isFailed, boolean isApplied, int sessionErrorCode, String sessionErrorMessage, DomainSet preVerifiedDomains, InstallDependencyHelper installDependencyHelper) {
        this.mPerfBoostInstall = null;
        this.mIsPerfLockAcquired = false;
        this.MAX_INSTALL_DURATION = 20000;
        this.mActiveCount = new AtomicInteger();
        this.mLock = new Object();
        this.mTransactionLock = new AtomicBoolean(false);
        this.mProgressLock = new Object();
        this.mClientProgress = 0.0f;
        this.mInternalProgress = 0.0f;
        this.mProgress = 0.0f;
        this.mReportedProgress = -1.0f;
        this.mIncrementalProgress = 0.0f;
        this.mPrepared = false;
        this.mSealed = false;
        this.mShouldBeSealed = false;
        this.mPreapprovalRequested = new AtomicBoolean(false);
        this.mCommitted = new AtomicBoolean(false);
        this.mStageDirInUse = false;
        this.mVerificationInProgress = false;
        this.mPermissionsManuallyAccepted = false;
        this.mFds = new ArrayList();
        this.mBridges = new ArrayList();
        this.mChildSessions = new SparseArray();
        this.mDependencyInstallerEnabled = new AtomicBoolean();
        this.mMissingSharedLibraryCount = new AtomicInteger();
        this.mFiles = new ArraySet();
        this.mChecksums = new ArrayMap();
        this.mSessionErrorCode = 0;
        this.mHasAppMetadataFile = false;
        this.mResolvedStagedFiles = new ArrayList();
        this.mResolvedInheritedFiles = new ArrayList();
        this.mResolvedInstructionSets = new ArrayList();
        this.mResolvedNativeLibPaths = new ArrayList();
        this.mUnarchivalListeners = new ArraySet();
        this.mDestroyed = false;
        this.mDataLoaderFinished = false;
        this.mValidatedTargetSdk = Integer.MAX_VALUE;
        this.mUnarchivalStatus = -1;
        this.mHandlerCallback = new AnonymousClass5(this);
        this.mCallback = callback;
        this.mContext = context;
        this.mPm = pm;
        if (this.mPm == null) goto L5;
        Installer r15 = this.mPm.mInstaller;
    L6:
        this.mInstaller = r15;
        this.mSessionProvider = sessionProvider;
        this.mSilentUpdatePolicy = silentUpdatePolicy;
        this.mHandler = new Handler(looper, this.mHandlerCallback);
        this.mStagingManager = stagingManager;
        this.mInstallDependencyHelper = installDependencyHelper;
        this.sessionId = sessionId;
        this.userId = userId;
        this.mOriginalInstallerUid = installerUid;
        this.mInstallerUid = installerUid;
        installSource.getClass();
        this.mInstallSource = installSource;
        this.mOriginalInstallerPackageName = this.mInstallSource.mInstallerPackageName;
        this.params = params;
        this.createdMillis = createdMillis;
        this.updatedMillis = createdMillis;
        this.committedMillis = committedMillis;
        this.stageDir = stageDir;
        this.stageCid = stageCid;
        this.mShouldBeSealed = sealed;
        if (childSessionIds == null) goto L13;
        int r1 = childSessionIds.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L13;
        int childSessionId = childSessionIds[r3];
        this.mChildSessions.put(childSessionId, null);
        r3 = r3 + 1;
        r1 = r1;
    L13:
        this.mParentSessionId = parentSessionId;
        if (files == null) goto L23;
        this.mFiles.ensureCapacity(files.length);
        int i = 0;
        int size = files.length;
    L16:
        if (i >= size) goto L23;
        InstallationFile file = files[i];
        int size2 = size;
        if (this.mFiles.add(new FileEntry(i, file)) == false) goto L21;
        i = i + 1;
        size = size2;
        goto L16
    L21:
        throw new IllegalArgumentException("Trying to add a duplicate installation file");
    L23:
        if (checksums == null) goto L26;
        this.mChecksums.putAll(checksums);
    L26:
        if (params.isMultiPackage == true) goto L37;
        if (stageDir != null) goto L29;
        boolean r2 = true;
    L30:
        if (stageCid != null) goto L32;
        boolean r4 = true;
    L33:
        if (r2 != r4) goto L37;
        throw new IllegalArgumentException("Exactly one of stageDir or stageCid stage must be set");
    L32:
        r4 = false;
        goto L33
    L29:
        r2 = false;
    L37:
        this.mPrepared = prepared;
        this.mCommitted.set(committed);
        this.mDestroyed = destroyed;
        this.mSessionReady = isReady;
        this.mSessionApplied = isApplied;
        this.mSessionFailed = isFailed;
        this.mSessionErrorCode = sessionErrorCode;
        if (sessionErrorMessage == null) goto L40;
        String r5 = sessionErrorMessage;
    L41:
        this.mSessionErrorMessage = r5;
        if (params.isStaged == false) goto L44;
        StagedSession r6 = new StagedSession(this);
    L45:
        this.mStagedSession = r6;
        this.mPreVerifiedDomains = preVerifiedDomains;
        if (isDataLoaderInstallation() == false) goto L59;
        if (isApexSession() == true) goto L57;
        if (isSystemDataLoaderInstallation() == false) goto L59;
        if (this.mContext.checkCallingOrSelfPermission("com.android.permission.USE_SYSTEM_DATA_LOADERS") == 0) goto L59;
        throw new SecurityException("You need the com.android.permission.USE_SYSTEM_DATA_LOADERS permission to use system data loaders");
    L57:
        throw new IllegalArgumentException("DataLoader installation of APEX modules is not allowed.");
    L59:
        if (isIncrementalInstallation() == false) goto L66;
        if (IncrementalManager.isAllowed() == true) goto L66;
        throw new IllegalArgumentException("Incremental installation not allowed.");
    L66:
        if (isArchivedInstallation() == true) goto L68;
        return;
    L68:
        if (params.mode != 1) goto L77;
        if (isStreamingInstallation() == false) goto L75;
        if (isSystemDataLoaderInstallation() == false) goto L75;
        return;
    L75:
        throw new IllegalArgumentException("Archived installation can only use Streaming System DataLoader.");
    L77:
        throw new IllegalArgumentException("Archived installation can only be full install.");
    L44:
        r6 = null;
        goto L45
    L40:
        r5 = "";
        goto L41
    L5:
        r15 = null;
        goto L6
    }

    PackageInstallerHistoricalSession createHistoricalSession() {
        Object r2 = this.mProgressLock;
        monitor-enter(r2);
        float progress = this.mProgress;     // Catch: Throwable -> L14
        float clientProgress = this.mClientProgress;     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        Object r3 = this.mLock;
        monitor-enter(r3);
        PackageInstallerHistoricalSession r4 = new PackageInstallerHistoricalSession(this.sessionId, this.userId, this.mOriginalInstallerUid, this.mOriginalInstallerPackageName, this.mInstallSource, this.mInstallerUid, this.createdMillis, this.updatedMillis, this.committedMillis, this.stageDir, this.stageCid, clientProgress, progress, isCommitted(), isPreapprovalRequested(), this.mSealed, this.mPermissionsManuallyAccepted, this.mStageDirInUse, this.mDestroyed, this.mFds.size(), this.mBridges.size(), this.mFinalStatus, this.mFinalMessage, this.params, this.mParentSessionId, getChildSessionIdsLocked(), this.mSessionApplied, this.mSessionFailed, this.mSessionReady, this.mSessionErrorCode, this.mSessionErrorMessage, this.mPreapprovalDetails, this.mPreVerifiedDomains, this.mPackageName);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        return r4;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    private boolean shouldScrubData(int callingUid) {
        if (callingUid >= 10000) goto L5;
    L7:
        return false;
    L5:
        if (getInstallerUid() == callingUid) goto L7;
        return true;
    }

    public PackageInstaller.SessionInfo generateInfoForCaller(boolean includeIcon, int callingUid) {
        return generateInfoInternal(includeIcon, shouldScrubData(callingUid));
    }

    public PackageInstaller.SessionInfo generateInfoScrubbed(boolean includeIcon) {
        return generateInfoInternal(includeIcon, true);
    }

    private PackageInstaller.SessionInfo generateInfoInternal(boolean includeIcon, boolean scrubData) {
        PackageInstaller.SessionInfo info = new PackageInstaller.SessionInfo();
        Object r1 = this.mProgressLock;
        monitor-enter(r1);
        float progress = this.mProgress;     // Catch: Throwable -> L53
        monitor-exit(r1);     // Catch: Throwable -> L53
        Object r3 = this.mLock;
        monitor-enter(r3);
        info.sessionId = this.sessionId;     // Catch: Throwable -> L15
        info.userId = this.userId;     // Catch: Throwable -> L15
        info.installerPackageName = this.mInstallSource.mInstallerPackageName;     // Catch: Throwable -> L15
        info.installerAttributionTag = this.mInstallSource.mInstallerAttributionTag;     // Catch: Throwable -> L15
        info.resolvedBaseCodePath = null;     // Catch: Throwable -> L15
        boolean r4 = false;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.READ_INSTALLED_SESSION_PATHS") != 0) goto L19;
        File file = this.mResolvedBaseFile;     // Catch: Throwable -> L15
        if (file != null) goto L17;
        List<File> addedFiles = getAddedApksLocked();     // Catch: Throwable -> L15
        if (addedFiles.size() <= 0) goto L17;
        file = addedFiles.get(0);     // Catch: Throwable -> L15
    L17:
        if (file == null) goto L19;
        info.resolvedBaseCodePath = file.getAbsolutePath();     // Catch: Throwable -> L15
    L19:
        info.progress = progress;     // Catch: Throwable -> L15
        info.sealed = this.mSealed;     // Catch: Throwable -> L15
        info.isCommitted = isCommitted();     // Catch: Throwable -> L15
        info.isPreapprovalRequested = isPreapprovalRequested();     // Catch: Throwable -> L15
        if (this.mActiveCount.get() <= 0) goto L22;
        r4 = true;
    L22:
        info.active = r4;     // Catch: Throwable -> L15
        info.mode = this.params.mode;     // Catch: Throwable -> L15
        info.installReason = this.params.installReason;     // Catch: Throwable -> L15
        info.installScenario = this.params.installScenario;     // Catch: Throwable -> L15
        info.sizeBytes = this.params.sizeBytes;     // Catch: Throwable -> L15
        if (this.mPreapprovalDetails == null) goto L26;
        String r2 = this.mPreapprovalDetails.getPackageName();     // Catch: Throwable -> L15
    L29:
        info.appPackageName = r2;     // Catch: Throwable -> L15
        if (includeIcon == false) goto L39;
        if (this.mPreapprovalDetails != null) goto L34;
    L36:
        Bitmap r5 = this.params.appIcon;     // Catch: Throwable -> L15
    L37:
        info.appIcon = r5;     // Catch: Throwable -> L15
        goto L39
    L34:
        if (this.mPreapprovalDetails.getIcon() == null) goto L36;
        r5 = this.mPreapprovalDetails.getIcon();     // Catch: Throwable -> L15
    L39:
        if (this.mPreapprovalDetails == null) goto L41;
        CharSequence r6 = this.mPreapprovalDetails.getLabel();     // Catch: Throwable -> L15
    L42:
        info.appLabel = r6;     // Catch: Throwable -> L15
        info.installLocation = this.params.installLocation;     // Catch: Throwable -> L15
        if (scrubData == true) goto L45;
        info.originatingUri = this.params.originatingUri;     // Catch: Throwable -> L15
    L45:
        info.originatingUid = this.params.originatingUid;     // Catch: Throwable -> L15
        if (scrubData == true) goto L48;
        info.referrerUri = this.params.referrerUri;     // Catch: Throwable -> L15
    L48:
        info.grantedRuntimePermissions = this.params.getLegacyGrantedRuntimePermissions();     // Catch: Throwable -> L15
        info.whitelistedRestrictedPermissions = this.params.whitelistedRestrictedPermissions;     // Catch: Throwable -> L15
        info.autoRevokePermissionsMode = this.params.autoRevokePermissionsMode;     // Catch: Throwable -> L15
        info.installFlags = this.params.installFlags;     // Catch: Throwable -> L15
        info.rollbackLifetimeMillis = this.params.rollbackLifetimeMillis;     // Catch: Throwable -> L15
        info.rollbackImpactLevel = this.params.rollbackImpactLevel;     // Catch: Throwable -> L15
        info.isMultiPackage = this.params.isMultiPackage;     // Catch: Throwable -> L15
        info.isStaged = this.params.isStaged;     // Catch: Throwable -> L15
        info.rollbackDataPolicy = this.params.rollbackDataPolicy;     // Catch: Throwable -> L15
        info.parentSessionId = this.mParentSessionId;     // Catch: Throwable -> L15
        info.childSessionIds = getChildSessionIdsLocked();     // Catch: Throwable -> L15
        info.isSessionApplied = this.mSessionApplied;     // Catch: Throwable -> L15
        info.isSessionReady = this.mSessionReady;     // Catch: Throwable -> L15
        info.isSessionFailed = this.mSessionFailed;     // Catch: Throwable -> L15
        info.setSessionErrorCode(this.mSessionErrorCode, this.mSessionErrorMessage);     // Catch: Throwable -> L15
        info.createdMillis = this.createdMillis;     // Catch: Throwable -> L15
        info.updatedMillis = this.updatedMillis;     // Catch: Throwable -> L15
        info.requireUserAction = this.params.requireUserAction;     // Catch: Throwable -> L15
        info.installerUid = this.mInstallerUid;     // Catch: Throwable -> L15
        info.packageSource = this.params.packageSource;     // Catch: Throwable -> L15
        info.applicationEnabledSettingPersistent = this.params.applicationEnabledSettingPersistent;     // Catch: Throwable -> L15
        info.pendingUserActionReason = userActionRequirementToReason(this.mUserActionRequirement);     // Catch: Throwable -> L15
        info.isAutoInstallingDependenciesEnabled = this.params.isAutoInstallDependenciesEnabled;     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        return info;
    L41:
        r6 = this.params.appLabel;     // Catch: Throwable -> L15
        goto L42
    L26:
        if (this.mPackageName == null) goto L28;
        r2 = this.mPackageName;     // Catch: Throwable -> L15
        goto L29
    L28:
        r2 = this.params.appPackageName;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L53:
        th = move-exception;
        throw th;
    }

    public boolean isPrepared() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mPrepared;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isSealed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mSealed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isPreapprovalRequested() {
        return this.mPreapprovalRequested.get();
    }

    boolean isCommitted() {
        return this.mCommitted.get();
    }

    boolean isDestroyed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDestroyed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isInTerminalState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionApplied == true) goto L12;
        if (this.mSessionFailed == true) goto L12;
        boolean r1 = false;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L12:
        r1 = true;
        goto L13
    }

    public boolean isStagedAndInTerminalState() {
        if (this.params.isStaged == true) goto L5;
    L7:
        return false;
    L5:
        if (isInTerminalState() == false) goto L7;
        return true;
    }

    private void assertNotLocked(String cookie) {
        if (Thread.holdsLock(this.mLock) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(cookie + " is holding mLock");
    }

    private void assertSealed(String cookie) {
        if (isSealed() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(cookie + " before sealing");
    }

    private void assertPreparedAndNotPreapprovalRequestedLocked(String cookie) {
        assertPreparedAndNotSealedLocked(cookie);
        if (isPreapprovalRequested() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(cookie + " not allowed after requesting");
    }

    private void assertPreparedAndNotSealedLocked(String cookie) {
        assertPreparedAndNotCommittedOrDestroyedLocked(cookie);
        if (this.mSealed == true) goto L6;
        return;
    L6:
        throw new SecurityException(cookie + " not allowed after sealing");
    }

    private void assertPreparedAndNotCommittedOrDestroyedLocked(String cookie) {
        assertPreparedAndNotDestroyedLocked(cookie);
        if (isCommitted() == true) goto L6;
        return;
    L6:
        throw new SecurityException(cookie + " not allowed after commit");
    }

    private void assertPreparedAndNotDestroyedLocked(String cookie) {
        if (this.mPrepared == false) goto L10;
        if (this.mDestroyed == true) goto L8;
        return;
    L8:
        throw new SecurityException(cookie + " not allowed after destruction");
    L10:
        throw new IllegalStateException(cookie + " before prepared");
    }

    private void setClientProgressLocked(float progress) {
        if (this.mClientProgress != 0.0f) goto L5;
        boolean forcePublish = true;
    L6:
        this.mClientProgress = progress;
        computeProgressLocked(forcePublish);
        return;
    L5:
        forcePublish = false;
        goto L6
    }

    public void setClientProgress(float progress) {
        assertCallerIsOwnerOrRoot();
        Object r0 = this.mProgressLock;
        monitor-enter(r0);
        setClientProgressLocked(progress);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addClientProgress(float progress) {
        assertCallerIsOwnerOrRoot();
        Object r0 = this.mProgressLock;
        monitor-enter(r0);
        setClientProgressLocked(this.mClientProgress + progress);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void computeProgressLocked(boolean forcePublish) {
        if (isIncrementalInstallation() == true) goto L5;
    L10:
        this.mProgress = MathUtils.constrain(this.mClientProgress * 0.8f, 0.0f, 0.8f) + MathUtils.constrain(this.mInternalProgress * 0.2f, 0.0f, 0.2f);
    L11:
        if (forcePublish == false) goto L13;
    L14:
        this.mReportedProgress = this.mProgress;
        this.mCallback.onSessionProgressChanged(this, this.mProgress);
        return;
    L13:
        if ((this.mProgress - this.mReportedProgress) >= 0.01d) goto L14;
        return;
    L5:
        if (isCommitted() == false) goto L10;
        if ((this.mIncrementalProgress - this.mProgress) < 0.01d) goto L11;
        this.mProgress = this.mIncrementalProgress;
        goto L11
    }

    public String[] getNames() {
        assertCallerIsOwnerRootOrVerifier();
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertPreparedAndNotDestroyedLocked("getNames");     // Catch: Throwable -> L7
        if (isCommitted() == true) goto L9;
        String[] names = getNamesLocked();     // Catch: Throwable -> L7
    L10:
        String[] r2 = ArrayUtils.removeString(names, PackageManagerService.APP_METADATA_FILE_NAME);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        names = getStageDirContentsLocked();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private String[] getStageDirContentsLocked() {
        if (this.stageDir == null) goto L5;
        String[] result = this.stageDir.list();
        if (result == null) goto L9;
        return result;
    L9:
        return EmptyArray.STRING;
    L5:
        return EmptyArray.STRING;
    }

    private String[] getNamesLocked() {
        if (isDataLoaderInstallation() == false) goto L5;
        InstallationFile[] files = getInstallationFilesLocked();
        String[] result = new String[files.length];
        int i = 0;
        int size = files.length;
    L7:
        if (i >= size) goto L10;
        result[i] = files[i].getName();
        i = i + 1;
        goto L7
    L10:
        return result;
    L5:
        return getStageDirContentsLocked();
    }

    private InstallationFile[] getInstallationFilesLocked() {
        InstallationFile[] result = new InstallationFile[this.mFiles.size()];
        Iterator<FileEntry> r1 = this.mFiles.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        FileEntry fileEntry = r1.next();
        result[fileEntry.getIndex()] = fileEntry.getFile();
        goto L4
    L6:
        return result;
    }

    private static ArrayList<File> filterFiles(File parent, String[] names, FileFilter filter) {
        ArrayList<File> result = new ArrayList(names.length);
        int r1 = names.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String name = names[r2];
        File file = new File(parent, name);
        if (filter.accept(file) == false) goto L7;
        result.add(file);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return result;
    }

    private List<File> getAddedApksLocked() {
        String[] names = getNamesLocked();
        return filterFiles(this.stageDir, names, sAddedApkFilter);
    }

    private List<String> getArtManagedFilePathsLocked() {
        String[] names = getNamesLocked();
        ArrayList<String> result = new ArrayList(names.length);
        int r2 = names.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        String name = names[r3];
        File file = new File(this.stageDir, name);
        if (sArtManagedFilter.accept(file) == false) goto L7;
        result.add(file.getPath());
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return result;
    }

    private void enableFsVerityToAddedApksWithIdsig() throws PackageManagerException {
        List<File> files = getAddedApksLocked();     // Catch: IOException -> L9
        Iterator<File> r1 = files.iterator();     // Catch: IOException -> L9
    L4:
        if (r1.hasNext() == false) goto L13;
        File file = r1.next();     // Catch: IOException -> L9
        if (new File(file.getPath() + ".idsig").exists() == false) goto L4;
        VerityUtils.setUpFsverity(file.getPath());     // Catch: IOException -> L9
        goto L4
    L13:
        return;
    L9:
        e = move-exception;
        throw new PrepareFailure(-118, "Failed to enable fs-verity to verify with idsig: " + e);
    }

    private List<ApkLite> getAddedApkLitesLocked() throws PackageManagerException {
        if (isArchivedInstallation() == true) goto L13;
        List<File> files = getAddedApksLocked();
        List<ApkLite> result = new ArrayList(files.size());
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        int i = 0;
        int size = files.size();
    L5:
        if (i >= size) goto L12;
        ParseResult<ApkLite> parseResult = ApkLiteParseUtils.parseApkLite(input.reset(), files.get(i), 32);
        if (parseResult.isError() == true) goto L10;
        result.add((ApkLite) parseResult.getResult());
        i = i + 1;
        goto L5
    L10:
        throw new PackageManagerException(parseResult.getErrorCode(), parseResult.getErrorMessage(), parseResult.getException());
    L12:
        return result;
    L13:
        InstallationFile[] files2 = getInstallationFilesLocked();
        List<ApkLite> result2 = new ArrayList(files2.length);
        int i2 = 0;
        int size2 = files2.length;
    L14:
        if (i2 >= size2) goto L39;
        File file = new File(this.stageDir, files2[i2].getName());
        if (sAddedApkFilter.accept(file) == false) goto L28;
        PackageManagerShellCommandDataLoader.Metadata metadata = PackageManagerShellCommandDataLoader.Metadata.fromByteArray(files2[i2].getMetadata());     // Catch: IOException -> L35
        if (metadata.getMode() != 4) goto L34;
        ArchivedPackageParcel archPkg = metadata.getArchivedPackage();
        if (archPkg == null) goto L32;
        if (archPkg.packageName == null) goto L30;
        if (archPkg.signingDetails == null) goto L30;
        result2.add(new ApkLite(file.getAbsolutePath(), archPkg));
    L30:
        throw new PackageManagerException(-22, "ArchivedPackage does not contain required info: " + file);
    L32:
        throw new PackageManagerException(-22, "Metadata does not contain ArchivedPackage: " + file);
    L34:
        throw new PackageManagerException(-22, "File metadata is not for ARCHIVED package: " + file);
    L35:
        e = move-exception;
        throw new PackageManagerException(-110, "Failed to ", e);
    L28:
        i2 = i2 + 1;
        goto L14
    L39:
        return result2;
    }

    private List<File> getRemovedFilesLocked() {
        String[] names = getNamesLocked();
        return filterFiles(this.stageDir, names, sRemovedFilter);
    }

    public void setChecksums(String name, Checksum[] checksums, byte[] signature) {
        if (checksums.length != 0) goto L5;
        return;
    L5:
        String initiatingPackageName = getInstallSource().mInitiatingPackageName;
        if (PackageManagerServiceUtils.isInstalledByAdb(initiatingPackageName) == true) goto L8;
        String installerPackageName = initiatingPackageName;
    L10:
        if (TextUtils.isEmpty(installerPackageName) == true) goto L46;
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        appOps.checkPackage(Binder.getCallingUid(), installerPackageName);
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        AndroidPackage callingInstaller = pmi.getPackage(installerPackageName);
        if (callingInstaller == null) goto L44;
        if (signature != null) goto L15;
    L21:
        int r5 = checksums.length;
        int r6 = 0;
    L22:
        if (r6 >= r5) goto L30;
        Checksum checksum = checksums[r6];
        if (checksum.getValue() == null) goto L29;
        if (checksum.getValue().length > 64) goto L29;
        r6 = r6 + 1;
    L29:
        throw new IllegalArgumentException("Invalid checksum.");
    L30:
        assertCallerIsOwnerOrRoot();
        Object r7 = this.mLock;
        monitor-enter(r7);
        assertPreparedAndNotCommittedOrDestroyedLocked("addChecksums");     // Catch: Throwable -> L37
        if (this.mChecksums.containsKey(name) == true) goto L40;
        this.mChecksums.put(name, new PerFileChecksum(checksums, signature));     // Catch: Throwable -> L37
        monitor-exit(r7);     // Catch: Throwable -> L37
        return;
    L40:
        throw new IllegalStateException("Duplicate checksums.");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L15:
        if (signature.length == 0) goto L21;
        ApkChecksums.verifySignature(checksums, signature);     // Catch: Throwable -> L18
    L18:
        e = move-exception;
        throw new IllegalArgumentException("Can't verify signature: " + e.getMessage(), e);
    L44:
        throw new IllegalStateException("Can't obtain calling installer's package.");
    L46:
        throw new IllegalStateException("Installer package is empty.");
    L8:
        installerPackageName = getInstallSource().mInstallerPackageName;
        goto L10
    }

    public void requestChecksums(String name, int optional, int required, List trustedInstallers, IOnChecksumsReadyListener onChecksumsReadyListener) {
        assertCallerIsOwnerRootOrVerifier();
        File file = new File(this.stageDir, name);
        if (PackageManagerServiceUtils.isInstalledByAdb(getInstallSource().mInitiatingPackageName) == false) goto L5;
        String installerPackageName = getInstallSource().mInstallerPackageName;
    L19:
        this.mPm.requestFileChecksums(file, installerPackageName, optional, required, trustedInstallers, onChecksumsReadyListener);     // Catch: FileNotFoundException -> L11
        return;
    L11:
        e = move-exception;
        FileNotFoundException e = e;
    L16:
        throw new ParcelableException(e);
    L13:
        e = move-exception;
        e = e;
        goto L16
    L5:
        installerPackageName = getInstallSource().mInitiatingPackageName;
        goto L19
    }

    public void removeSplit(String splitName) {
        if (isDataLoaderInstallation() == true) goto L22;
        if (TextUtils.isEmpty(this.params.appPackageName) == true) goto L20;
        assertCallerIsOwnerOrRoot();
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertPreparedAndNotCommittedOrDestroyedLocked("removeSplit");     // Catch: Throwable -> L12
        createRemoveSplitMarkerLocked(splitName);     // Catch: Throwable -> L12 IOException -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        e = move-exception;
        throw ExceptionUtils.wrap(e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalStateException("Must specify package name to remove a split");
    L22:
        throw new IllegalStateException("Cannot remove splits in a data loader installation session.");
    }

    private static String getRemoveMarkerName(String name) {
        String markerName = name + REMOVE_MARKER_EXTENSION;
        if (FileUtils.isValidExtFilename(markerName) == false) goto L6;
        return markerName;
    L6:
        throw new IllegalArgumentException("Invalid marker: " + markerName);
    }

    private void createRemoveSplitMarkerLocked(String splitName) throws IOException {
        File target = new File(this.stageDir, getRemoveMarkerName(splitName));     // Catch: ErrnoException -> L4
        target.createNewFile();     // Catch: ErrnoException -> L4
        Os.chmod(target.getAbsolutePath(), 0);     // Catch: ErrnoException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsIOException();
    }

    private void assertShellOrSystemCalling(String operation) {
        switch(Binder.getCallingUid()) {
            case 0: goto L7;
            case 1000: goto L7;
            case 2000: goto L7;
            default: goto L5;
        };
    L7:
        return;
    L5:
        throw new SecurityException(operation + " only supported from shell or system");
    }

    private void assertCanWrite(boolean reverseMode) {
        if (isDataLoaderInstallation() == true) goto L15;
        assertCallerIsOwnerOrRoot();
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertPreparedAndNotSealedLocked("assertCanWrite");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (reverseMode == false) goto L18;
        assertShellOrSystemCalling("Reverse mode");
        return;
    L18:
        return;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalStateException("Cannot write regular files in a data loader installation session.");
    }

    private File getTmpAppMetadataFile() {
        return new File(Environment.getDataAppDirectory(this.params.volumeUuid), this.sessionId + "-" + PackageManagerService.APP_METADATA_FILE_NAME);
    }

    private File getStagedAppMetadataFile() {
        return new File(this.stageDir, PackageManagerService.APP_METADATA_FILE_NAME);
    }

    private static boolean isAppMetadata(String name) {
        return name.endsWith(PackageManagerService.APP_METADATA_FILE_NAME);
    }

    private static boolean isAppMetadata(File file) {
        return isAppMetadata(file.getName());
    }

    public ParcelFileDescriptor getAppMetadataFd() {
        assertCallerIsOwnerOrRoot();
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertPreparedAndNotCommittedOrDestroyedLocked("getAppMetadataFd");     // Catch: Throwable -> L9
        if (this.mHasAppMetadataFile == true) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L20:
        ParcelFileDescriptor r1 = openReadInternalLocked(PackageManagerService.APP_METADATA_FILE_NAME);     // Catch: Throwable -> L9 IOException -> L14
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L14:
        e = move-exception;
        throw ExceptionUtils.wrap(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void removeAppMetadata() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasAppMetadataFile == false) goto L9;
        getStagedAppMetadataFile().delete();     // Catch: Throwable -> L7
        this.mHasAppMetadataFile = false;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    static long getAppMetadataSizeLimit() {
        long token = Binder.clearCallingIdentity();
        long r2 = DeviceConfig.getLong("package_manager_service", PROPERTY_APP_METADATA_BYTE_SIZE_LIMIT, DEFAULT_APP_METADATA_BYTE_SIZE_LIMIT);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public ParcelFileDescriptor openWriteAppMetadata() {
        assertCallerIsOwnerOrRoot();
        Object r1 = this.mLock;
        monitor-enter(r1);
        assertPreparedAndNotSealedLocked("openWriteAppMetadata");     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        ParcelFileDescriptor fd = doWriteInternal(PackageManagerService.APP_METADATA_FILE_NAME, 0, -1, null);     // Catch: IOException -> L17
        Object r3 = this.mLock;     // Catch: IOException -> L17
        monitor-enter(r3);     // Catch: IOException -> L17
        this.mHasAppMetadataFile = true;     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        return fd;
    L14:
        th = move-exception;
        throw th;     // Catch: IOException -> L17
    L17:
        e = move-exception;
        throw ExceptionUtils.wrap(e);
    L23:
        e = th;
    L31:
        throw e;
    L27:
        e = th;
        goto L31
    }

    public ParcelFileDescriptor openWrite(String name, long offsetBytes, long lengthBytes) {
        assertCanWrite(false);
    L19:
        e = e;
    L22:
        throw ExceptionUtils.wrap(e);
    L4:
        if (this.mPerfBoostInstall == null) goto L27;
    L9:
        if (this.mPerfBoostInstall == null) goto L25;
        if (this.mIsPerfLockAcquired == true) goto L25;
        this.mPerfBoostInstall.perfHint(4232, null, 20000, -1);     // Catch: IOException -> L7
        this.mIsPerfLockAcquired = true;     // Catch: IOException -> L7
    L7:
        e = e;
    L25:
        return doWriteInternal(name, offsetBytes, lengthBytes, null);
    L17:
        e = e;
        goto L22
    L27:
        this.mPerfBoostInstall = new BoostFramework();     // Catch: IOException -> L7
        goto L9
    }

    public void write(String name, long offsetBytes, long lengthBytes, ParcelFileDescriptor fd) {
        if (fd == null) goto L4;
        boolean r0 = true;
    L5:
        assertCanWrite(r0);
        doWriteInternal(name, offsetBytes, lengthBytes, fd);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw ExceptionUtils.wrap(e);
    L4:
        r0 = false;
        goto L5
    }

    public void stageViaHardLink(String path) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1000) goto L24;
        File target = new File(path);
        File source = new File(this.stageDir, target.getName());
        String sourcePath = source.getAbsolutePath();
        Os.link(path, sourcePath);     // Catch: IOException -> L7 ErrnoException -> L9
        Os.chmod(sourcePath, 420);     // Catch: IOException -> L7 ErrnoException -> L9
    L12:
        if (SELinux.restorecon(source) == false) goto L15;
        return;
    L15:
        throw new IOException("Can't relabel file: " + source);     // Catch: IOException -> L7
    L7:
        e = move-exception;
        Os.unlink(sourcePath);     // Catch: Exception -> L19
    L21:
        Exception ignored = ExceptionUtils.wrap(e);
        throw ignored;
    L20:
        Slog.d(TAG, "Failed to unlink session file: " + sourcePath);
    L9:
        e = move-exception;
        e.rethrowAsIOException();     // Catch: IOException -> L7
        goto L12
    L24:
        throw new SecurityException("link() can only be run by the system");
    }

    private ParcelFileDescriptor openTargetInternal(String path, int flags, int mode) throws IOException, ErrnoException {
        FileDescriptor fd = Os.open(path, flags, mode);
        return new ParcelFileDescriptor(fd);
    }

    private ParcelFileDescriptor createRevocableFdInternal(RevocableFileDescriptor fd, ParcelFileDescriptor pfd) throws IOException {
        int releasedFdInt = pfd.detachFd();
        FileDescriptor releasedFd = new FileDescriptor();
        releasedFd.setInt$(releasedFdInt);
        fd.init(this.mContext, releasedFd);
        return fd.getRevocableFileDescriptor();
    }

    private ParcelFileDescriptor doWriteInternal(String name, long offsetBytes, long lengthBytes, ParcelFileDescriptor incomingFd) throws IOException {
        Object r5 = this.mLock;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (PackageInstaller.ENABLE_REVOCABLE_FD == false) goto L9;
        RevocableFileDescriptor fd = new RevocableFileDescriptor();     // Catch: Throwable -> L7
        this.mFds.add(fd);     // Catch: Throwable -> L7
        RevocableFileDescriptor fd2 = fd;
        FileBridge bridge = null;
    L10:
        monitor-exit(r5);     // Catch: Throwable -> L7
    L26:
        e = move-exception;
        throw e.rethrowAsIOException();
    L12:
        if (FileUtils.isValidExtFilename(name) == false) goto L92;
        long identity = Binder.clearCallingIdentity();     // Catch: ErrnoException -> L26
        File target = new File(this.stageDir, name);     // Catch: Throwable -> L88
    L17:
        Binder.restoreCallingIdentity(identity);     // Catch: ErrnoException -> L26
        if (name.equals(PackageManagerService.APP_METADATA_FILE_NAME) == false) goto L20;
        int r0 = 416;
    L21:
        int mode = r0;
        ParcelFileDescriptor targetPfd = openTargetInternal(target.getAbsolutePath(), OsConstants.O_CREAT | OsConstants.O_WRONLY, mode);     // Catch: ErrnoException -> L26
        Os.chmod(target.getAbsolutePath(), mode);     // Catch: ErrnoException -> L26
        if (this.stageDir == null) goto L30;
        if (lengthBytes <= 0) goto L30;
        ((StorageManager) this.mContext.getSystemService(StorageManager.class)).allocateBytes(targetPfd.getFileDescriptor(), lengthBytes, InstallLocationUtils.translateAllocateFlags(this.params.installFlags));     // Catch: ErrnoException -> L26
    L30:
        if (offsetBytes <= r9) goto L32;
        Os.lseek(targetPfd.getFileDescriptor(), offsetBytes, OsConstants.SEEK_SET);     // Catch: ErrnoException -> L26
    L32:
        if (incomingFd == null) goto L83;
        final Int64Ref last = new Int64Ref(0);     // Catch: Throwable -> L67
        ParcelFileDescriptor targetPfd2 = targetPfd;
        FileUtils.copy(incomingFd.getFileDescriptor(), targetPfd.getFileDescriptor(), lengthBytes, null, new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new PackageInstallerSession$$ExternalSyntheticLambda10(this, last));     // Catch: Throwable -> L57
        IoUtils.closeQuietly(targetPfd2);     // Catch: ErrnoException -> L26
        IoUtils.closeQuietly(incomingFd);     // Catch: ErrnoException -> L26
        Object r6 = this.mLock;     // Catch: ErrnoException -> L26
        monitor-enter(r6);     // Catch: ErrnoException -> L26
    L49:
        th = move-exception;
        throw th;     // Catch: ErrnoException -> L26
    L47:
        if (PackageInstaller.ENABLE_REVOCABLE_FD == false) goto L51;
        this.mFds.remove(fd2);     // Catch: Throwable -> L49
    L52:
        monitor-exit(r6);     // Catch: Throwable -> L49
        return null;
    L51:
        bridge.forceClose();     // Catch: Throwable -> L49
        this.mBridges.remove(bridge);     // Catch: Throwable -> L49
    L57:
        th = th;
    L69:
        IoUtils.closeQuietly(targetPfd2);     // Catch: ErrnoException -> L26
        IoUtils.closeQuietly(incomingFd);     // Catch: ErrnoException -> L26
        Object r7 = this.mLock;     // Catch: ErrnoException -> L26
        monitor-enter(r7);     // Catch: ErrnoException -> L26
    L74:
        th = move-exception;
        throw th;     // Catch: ErrnoException -> L26
    L72:
        if (PackageInstaller.ENABLE_REVOCABLE_FD == false) goto L76;
        this.mFds.remove(fd2);     // Catch: Throwable -> L74
    L77:
        monitor-exit(r7);     // Catch: Throwable -> L74
        throw th;     // Catch: ErrnoException -> L26
    L76:
        bridge.forceClose();     // Catch: Throwable -> L74
        this.mBridges.remove(bridge);     // Catch: Throwable -> L74
    L59:
        th = th;
    L61:
        th = th;
        targetPfd2 = targetPfd;
    L63:
        th = th;
        targetPfd2 = targetPfd;
    L65:
        th = th;
        targetPfd2 = targetPfd;
    L67:
        th = th;
        targetPfd2 = targetPfd;
        goto L69
    L83:
        if (PackageInstaller.ENABLE_REVOCABLE_FD == true) goto L85;
        bridge.setTargetFile(targetPfd);     // Catch: ErrnoException -> L26
        bridge.start();     // Catch: ErrnoException -> L26
        return bridge.getClientSocket();
    L85:
        return createRevocableFdInternal(fd2, targetPfd);
    L20:
        r0 = 420;
    L88:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: ErrnoException -> L26
        throw th;     // Catch: ErrnoException -> L26
    L92:
        throw new IllegalArgumentException("Invalid name: " + name);     // Catch: ErrnoException -> L26
    L9:
        FileBridge bridge2 = new FileBridge();     // Catch: Throwable -> L7
        this.mBridges.add(bridge2);     // Catch: Throwable -> L7
        fd2 = null;
        bridge = bridge2;
        goto L10
    }

    private /* synthetic */ void lambda$doWriteInternal$0(Int64Ref last, long progress) {
        if (this.params.sizeBytes <= 0) goto L12;
        long delta = progress - last.value;
        last.value = progress;
        Object r2 = this.mProgressLock;
        monitor-enter(r2);
        setClientProgressLocked(this.mClientProgress + (delta / this.params.sizeBytes));     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public ParcelFileDescriptor openRead(String name) {
        if (isDataLoaderInstallation() == true) goto L18;
        assertCallerIsOwnerOrRoot();
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertPreparedAndNotCommittedOrDestroyedLocked("openRead");     // Catch: Throwable -> L10
        ParcelFileDescriptor r1 = openReadInternalLocked(name);     // Catch: Throwable -> L10 IOException -> L12
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L12:
        e = move-exception;
        throw ExceptionUtils.wrap(e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L18:
        throw new IllegalStateException("Cannot read regular files in a data loader installation session.");
    }

    private ParcelFileDescriptor openReadInternalLocked(String name) throws IOException {
    L6:
        e = move-exception;
        throw e.rethrowAsIOException();
    L3:
        if (FileUtils.isValidExtFilename(name) == false) goto L9;
        File target = new File(this.stageDir, name);     // Catch: ErrnoException -> L6
        FileDescriptor targetFd = Os.open(target.getAbsolutePath(), OsConstants.O_RDONLY, 0);     // Catch: ErrnoException -> L6
        return new ParcelFileDescriptor(targetFd);
    L9:
        throw new IllegalArgumentException("Invalid name: " + name);     // Catch: ErrnoException -> L6
    }

    private void assertCallerIsOwnerRootOrVerifier() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
        return;
    L5:
        if (callingUid != this.mInstallerUid) goto L8;
        return;
    L8:
        if (isSealed() == false) goto L13;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.PACKAGE_VERIFICATION_AGENT") != 0) goto L13;
        return;
    L13:
        throw new SecurityException("Session does not belong to uid " + callingUid);
    }

    private void assertCallerIsOwnerOrRoot() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
        return;
    L5:
        if (callingUid != this.mInstallerUid) goto L8;
        return;
    L8:
        throw new SecurityException("Session does not belong to uid " + callingUid);
    }

    private void assertCallerIsOwnerOrRootOrSystem() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
        return;
    L5:
        if (callingUid != this.mInstallerUid) goto L7;
        return;
    L7:
        if (callingUid != 1000) goto L10;
        return;
    L10:
        throw new SecurityException("Session does not belong to uid " + callingUid);
    }

    private void assertNoWriteFileTransfersOpenLocked() {
        Iterator<RevocableFileDescriptor> r0 = this.mFds.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        RevocableFileDescriptor fd = r0.next();
        if (fd.isRevoked() == true) goto L4;
        throw new SecurityException("Files still open");
    L10:
        Iterator<FileBridge> r1 = this.mBridges.iterator();
    L12:
        if (r1.hasNext() == false) goto L18;
        FileBridge bridge = r1.next();
        if (bridge.isClosed() == true) goto L12;
        throw new SecurityException("Files still open");
    }

    public void commit(IntentSender statusReceiver, boolean forTransfer) {
        if (this.mIsPerfLockAcquired == true) goto L5;
    L7:
        assertNotChild("commit");
        boolean throwsExceptionCommitImmutableCheck = CompatChanges.isChangeEnabled(THROW_EXCEPTION_COMMIT_WITH_IMMUTABLE_PENDING_INTENT, Binder.getCallingUid());
        if (throwsExceptionCommitImmutableCheck == false) goto L15;
        if (statusReceiver.isImmutable() == false) goto L15;
        throw new IllegalArgumentException("The commit() status receiver should come from a mutable PendingIntent");
    L15:
        if (markAsSealed(statusReceiver, forTransfer) == true) goto L18;
        return;
    L18:
        if (isMultiPackage() == false) goto L39;
        Object r2 = this.mLock;
        monitor-enter(r2);
        boolean sealFailed = false;
        int i = this.mChildSessions.size() - 1;     // Catch: Throwable -> L28
    L23:
        if (i < 0) goto L31;
        if (this.mChildSessions.valueAt(i).markAsSealed(null, forTransfer) == true) goto L27;
        sealFailed = true;
    L27:
        i = i - 1;     // Catch: Throwable -> L28
        goto L23
    L31:
        if (sealFailed == false) goto L35;
        monitor-exit(r2);     // Catch: Throwable -> L28
        return;
    L35:
        monitor-exit(r2);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L39:
        Object r3 = this.mLock;
        monitor-enter(r3);
    L48:
        th = move-exception;
        throw th;
    L42:
        if (this.mHasAppMetadataFile == false) goto L52;
        File appMetadataFile = getStagedAppMetadataFile();     // Catch: Throwable -> L48
        long sizeLimit = getAppMetadataSizeLimit();     // Catch: Throwable -> L48
        if (appMetadataFile.length() <= sizeLimit) goto L46;
        appMetadataFile.delete();     // Catch: Throwable -> L48
        this.mHasAppMetadataFile = false;     // Catch: Throwable -> L48
        throw new IllegalArgumentException("App metadata size exceeds the maximum allowed limit of " + sizeLimit);     // Catch: Throwable -> L48
    L46:
        if (isIncrementalInstallation() == false) goto L52;
        appMetadataFile.renameTo(getTmpAppMetadataFile());     // Catch: Throwable -> L48
    L52:
        monitor-exit(r3);     // Catch: Throwable -> L48
        dispatchSessionSealed();
        return;
    L5:
        if (this.mPerfBoostInstall == null) goto L7;
        this.mPerfBoostInstall.perfLockRelease();
        this.mIsPerfLockAcquired = false;
        goto L7
    }

    public void seal() {
        assertNotChild("seal");
        assertCallerIsOwnerOrRoot();
        sealInternal();     // Catch: PackageManagerException -> L8
        Iterator<PackageInstallerSession> r0 = getChildSessions().iterator();     // Catch: PackageManagerException -> L8
    L5:
        if (r0.hasNext() == false) goto L11;
        PackageInstallerSession child = r0.next();     // Catch: PackageManagerException -> L8
        child.sealInternal();     // Catch: PackageManagerException -> L8
        goto L5
    L11:
        return;
    L8:
        e = move-exception;
        throw new IllegalStateException("Package is not valid", e);
    }

    private void sealInternal() throws PackageManagerException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        sealLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public List<String> fetchPackageNames() {
        assertNotChild("fetchPackageNames");
        assertCallerIsOwnerOrRoot();
        List<PackageInstallerSession> sessions = getSelfOrChildSessions();
        ArrayList<String> result = new ArrayList(sessions.size());
        Iterator<PackageInstallerSession> r2 = sessions.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        PackageInstallerSession s = r2.next();
        result.add(s.fetchPackageName());
        goto L4
    L6:
        return result;
    }

    private String fetchPackageName() {
        assertSealed("fetchPackageName");
        Object r0 = this.mLock;
        monitor-enter(r0);
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();     // Catch: Throwable -> L13
        List<File> addedFiles = getAddedApksLocked();     // Catch: Throwable -> L13
        Iterator<File> r3 = addedFiles.iterator();     // Catch: Throwable -> L13
    L6:
        if (r3.hasNext() == false) goto L19;
        File addedFile = r3.next();     // Catch: Throwable -> L13
        ParseResult<ApkLite> result = ApkLiteParseUtils.parseApkLite(input.reset(), addedFile, 0);     // Catch: Throwable -> L13
        if (result.isError() == true) goto L17;
        ApkLite apk = (ApkLite) result.getResult();     // Catch: Throwable -> L13
        String packageName = apk.getPackageName();     // Catch: Throwable -> L13
        if (packageName == null) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return packageName;
    L17:
        throw new IllegalStateException("Can't parse package for session=" + this.sessionId, result.getException());     // Catch: Throwable -> L13
    L19:
        throw new IllegalStateException("Can't fetch package name for session=" + this.sessionId);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void dispatchSessionSealed() {
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void handleSessionSealed() {
        assertSealed("dispatchSessionSealed");
        this.mCallback.onSessionSealedBlocking(this);
        dispatchStreamValidateAndCommit();
    }

    private void dispatchStreamValidateAndCommit() {
        this.mHandler.obtainMessage(2).sendToTarget();
    }

    private void handleStreamValidateAndCommit() {
        boolean allSessionsReady = true;
        Iterator<PackageInstallerSession> r1 = getChildSessions().iterator();     // Catch: PackageManagerException -> L7
    L5:
        if (r1.hasNext() == false) goto L9;
        PackageInstallerSession child = r1.next();     // Catch: PackageManagerException -> L7
        allSessionsReady = allSessionsReady & child.streamValidateAndCommit();     // Catch: PackageManagerException -> L7
        goto L5
    L9:
        if (allSessionsReady == true) goto L11;
        return;
    L11:
        if (streamValidateAndCommit() == false) goto L21;
        this.mHandler.obtainMessage(3).sendToTarget();     // Catch: PackageManagerException -> L7
        return;
    L21:
        return;
    L7:
        e = move-exception;
        String msg = ExceptionUtils.getCompleteMessage(e);
        destroy(msg);
        dispatchSessionFinished(e.error, msg, null);
        maybeFinishChildSessions(e.error, msg);
    }

    private void handlePreapprovalRequest() {
        if (sendPendingUserActionIntentIfNeeded(true) == false) goto L5;
        return;
    L5:
        dispatchSessionPreapproved();
    }

    private static boolean isSecureFrpInstallAllowed(Context context, int callingUid) {
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        String[] systemInstaller = pmi.getKnownPackageNames(2, 0);
        AndroidPackage callingInstaller = pmi.getPackage(callingUid);
        if (callingInstaller == null) goto L8;
        if (ArrayUtils.contains(systemInstaller, callingInstaller.getPackageName()) == false) goto L8;
        return false;
    L8:
        if (context.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isInstallationAllowed(PackageStateInternal psi) {
        if (psi != null) goto L5;
    L16:
        return true;
    L5:
        if (psi.getPkg() == null) goto L16;
        if (psi.getPkg().isUpdatableSystem() == false) goto L11;
        return true;
    L11:
        if (this.mOriginalInstallerUid != 0) goto L14;
        Slog.w(TAG, "Overriding updatableSystem because the installer is root: " + psi.getPackageName());
        return true;
    L14:
        return false;
    }

    private static boolean isArchivedInstallationAllowed(PackageStateInternal psi) {
        if (psi != null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isIncrementalInstallationAllowed(PackageStateInternal psi) {
        if (psi != null) goto L5;
    L14:
        return true;
    L5:
        if (psi.getPkg() == null) goto L14;
        if (psi.isSystem() == false) goto L10;
    L12:
        return false;
    L10:
        if (psi.isUpdatedSystemApp() == true) goto L12;
        return true;
    }

    private boolean markAsSealed(IntentSender statusReceiver, boolean forTransfer) {
        if (statusReceiver == null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Preconditions.checkState(r2, "statusReceiver can't be null for the root session");
        assertCallerIsOwnerOrRoot();
        Object r3 = this.mLock;
        monitor-enter(r3);
        assertPreparedAndNotDestroyedLocked("commit of session " + this.sessionId);     // Catch: Throwable -> L22
        assertNoWriteFileTransfersOpenLocked();     // Catch: Throwable -> L22
        PersistentDataBlockManager pdbManager = (PersistentDataBlockManager) this.mContext.getSystemService(PersistentDataBlockManager.class);     // Catch: Throwable -> L22
        if (pdbManager != null) goto L14;
        boolean isSecureFrpEnabled = false;
    L16:
        if (isSecureFrpEnabled == true) goto L18;
    L24:
        if (forTransfer == false) goto L31;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INSTALL_PACKAGES", null);     // Catch: Throwable -> L22
        if (this.mInstallerUid == this.mOriginalInstallerUid) goto L29;
    L32:
        setRemoteStatusReceiver(statusReceiver);     // Catch: Throwable -> L22
        if (this.mSealed == false) goto L46;
        monitor-exit(r3);     // Catch: Throwable -> L22
        return true;
    L46:
        sealLocked();     // Catch: Throwable -> L22 PackageManagerException -> L39
        monitor-exit(r3);     // Catch: Throwable -> L22
        return true;
    L41:
        return false;
    L29:
        throw new IllegalArgumentException("Session has not been transferred");     // Catch: Throwable -> L22
    L31:
        if (this.mInstallerUid == this.mOriginalInstallerUid) goto L32;
        throw new IllegalArgumentException("Session has been transferred");     // Catch: Throwable -> L22
    L18:
        if (isSecureFrpInstallAllowed(this.mContext, Binder.getCallingUid()) == true) goto L24;
        throw new SecurityException("Can't install packages while in secure FRP");     // Catch: Throwable -> L22
    L14:
        isSecureFrpEnabled = pdbManager.isFactoryResetProtectionActive();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L5:
        if (hasParentSessionId() == true) goto L8;
        r2 = false;
        goto L9
    }

    private boolean streamValidateAndCommit() throws PackageManagerException {
        Object r0 = this.mLock;     // Catch: Throwable -> L44 PackageManagerException -> L46
        monitor-enter(r0);     // Catch: Throwable -> L44 PackageManagerException -> L46
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44 PackageManagerException -> L46
    L5:
        if (isCommitted() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L11:
        if (this.params.isMultiPackage == true) goto L21;
        if (prepareDataLoaderLocked() == true) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L17:
        if (isApexSession() == false) goto L19;
        validateApexInstallLocked();     // Catch: Throwable -> L8
        goto L21
    L19:
        validateApkInstallLocked();     // Catch: Throwable -> L8
    L21:
        if (this.mDestroyed == true) goto L41;
        if (isIncrementalInstallation() == true) goto L33;
        Object r1 = this.mProgressLock;     // Catch: Throwable -> L8
        monitor-enter(r1);     // Catch: Throwable -> L8
        this.mClientProgress = 1.0f;     // Catch: Throwable -> L30
        computeProgressLocked(true);     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L33:
        this.mActiveCount.incrementAndGet();     // Catch: Throwable -> L8
        if (this.mCommitted.compareAndSet(false, true) == false) goto L39;
        this.committedMillis = System.currentTimeMillis();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L39:
        throw new PackageManagerException(-110, TextUtils.formatSimple("The mCommitted of session %d should be false originally", new Object[]{Integer.valueOf(this.sessionId)}));     // Catch: Throwable -> L8
    L41:
        throw new PackageManagerException(-110, "Session destroyed");     // Catch: Throwable -> L8
    L46:
        e = move-exception;
        throw e;
    L44:
        e = move-exception;
        throw new PackageManagerException(e);
    }

    private List<PackageInstallerSession> getChildSessionsLocked() {
        List<PackageInstallerSession> childSessions = Collections.EMPTY_LIST;
        if (isMultiPackage() == false) goto L7;
        int size = this.mChildSessions.size();
        childSessions = new ArrayList(size);
        int i = 0;
    L5:
        if (i >= size) goto L7;
        childSessions.add(this.mChildSessions.valueAt(i));
        i = i + 1;
    L7:
        return childSessions;
    }

    List<PackageInstallerSession> getChildSessions() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<PackageInstallerSession> r1 = getChildSessionsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private List<PackageInstallerSession> getSelfOrChildSessions() {
        if (isMultiPackage() == false) goto L6;
        return getChildSessions();
    L6:
        return Collections.singletonList(this);
    }

    private void sealLocked() throws PackageManagerException {
        assertNoWriteFileTransfersOpenLocked();     // Catch: Throwable -> L4
        assertPreparedAndNotDestroyedLocked("sealing of session " + this.sessionId);     // Catch: Throwable -> L4
        this.mSealed = true;     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw onSessionValidationFailure(new PackageManagerException(e));
    }

    private PackageManagerException onSessionValidationFailure(PackageManagerException e) {
        onSessionValidationFailure(e.error, ExceptionUtils.getCompleteMessage(e));
        return e;
    }

    private void onSessionValidationFailure(int error, String detailMessage) {
        destroyInternal("Failed to validate session, error: " + error + ", " + detailMessage);
        dispatchSessionFinished(error, detailMessage, null);
    }

    private void onSessionVerificationFailure(int error, String msg) {
        Slog.e(TAG, "Failed to verify session " + this.sessionId);
        dispatchSessionFinished(error, msg, null);
        maybeFinishChildSessions(error, msg);
    }

    private void onSessionDependencyResolveFailure(int error, String msg) {
        Slog.e(TAG, "Failed to resolve dependency for session " + this.sessionId);
        dispatchSessionFinished(error, msg, null);
        maybeFinishChildSessions(error, msg);
    }

    private void onSystemDataLoaderUnrecoverable() {
        final String packageName = getPackageName();
        if (TextUtils.isEmpty(packageName) == false) goto L5;
        return;
    L5:
        this.mHandler.post(new PackageInstallerSession$$ExternalSyntheticLambda0(this, packageName));
    }

    private /* synthetic */ void lambda$onSystemDataLoaderUnrecoverable$1(String packageName) {
        if (this.mPm.deletePackageX(packageName, -1, 0, 2, true) == 1) goto L6;
        Slog.e(TAG, "Failed to uninstall package with failed dataloader: " + packageName);
        return;
    }

    void onAfterSessionRead(SparseArray<PackageInstallerSession> allSessions) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mChildSessions.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L14;
        int childSessionId = this.mChildSessions.keyAt(i);     // Catch: Throwable -> L9
        PackageInstallerSession childSession = allSessions.get(childSessionId);     // Catch: Throwable -> L9
        if (childSession == null) goto L11;
        this.mChildSessions.setValueAt(i, childSession);     // Catch: Throwable -> L9
    L12:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L11:
        Slog.e(TAG, "Child session not existed: " + childSessionId);     // Catch: Throwable -> L9
        this.mChildSessions.removeAt(i);     // Catch: Throwable -> L9
        goto L12
    L14:
        if (this.mShouldBeSealed == true) goto L16;
    L45:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        if (isStagedAndInTerminalState() == true) goto L45;
        sealLocked();     // Catch: Throwable -> L9 PackageManagerException -> L28
        if (isMultiPackage() == true) goto L40;
        if (isStaged() == false) goto L40;
        if (isCommitted() == false) goto L40;
        if (hasParentSessionId() == false) goto L30;
        PackageInstallerSession root = allSessions.get(getParentSessionId());     // Catch: Throwable -> L9 PackageManagerException -> L28
    L32:
        if (root != null) goto L34;
    L43:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L34:
        if (root.isStagedAndInTerminalState() == true) goto L43;
        if (isApexSession() == false) goto L38;
        validateApexInstallLocked();     // Catch: Throwable -> L9 PackageManagerException -> L28
        goto L43
    L38:
        validateApkInstallLocked();     // Catch: Throwable -> L9 PackageManagerException -> L28
        goto L43
    L30:
        root = this;
    L40:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L28:
        e = move-exception;
        Slog.e(TAG, "Package not valid", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void markUpdated() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.updatedMillis = System.currentTimeMillis();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void transfer(String packageName) {
        Preconditions.checkArgument(!TextUtils.isEmpty(packageName));
        Computer snapshot = this.mPm.snapshotComputer();
        ApplicationInfo newOwnerAppInfo = snapshot.getApplicationInfo(packageName, 0, this.userId);
        if (newOwnerAppInfo == null) goto L31;
        if (snapshot.checkUidPermission("android.permission.INSTALL_PACKAGES", newOwnerAppInfo.uid) != 0) goto L29;
        if (this.params.areHiddenOptionsSet() == false) goto L27;
        Object r3 = this.mLock;
        monitor-enter(r3);
        assertCallerIsOwnerOrRoot();     // Catch: Throwable -> L19
        assertPreparedAndNotSealedLocked("transfer");     // Catch: Throwable -> L19
        sealLocked();     // Catch: Throwable -> L19 PackageManagerException -> L21
        this.mInstallerUid = newOwnerAppInfo.uid;     // Catch: Throwable -> L19
        this.mInstallSource = InstallSource.create(packageName, null, packageName, this.mInstallerUid, packageName, null, this.params.packageSource);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        return;
    L21:
        e = move-exception;
        throw new IllegalStateException("Package is not valid", e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        PackageManagerException e = th;
    L24:
        monitor-exit(r3);     // Catch: Throwable -> L17
        throw e;
    L19:
        th = move-exception;
        e = th;
        goto L24
    L27:
        throw new SecurityException("Can only transfer sessions that use public options");
    L29:
        throw new SecurityException("Destination package " + packageName + " does not have the android.permission.INSTALL_PACKAGES permission");
    L31:
        throw new ParcelableException(new PackageManager.NameNotFoundException(packageName));
    }

    private static boolean checkUserActionRequirement(PackageInstallerSession session, IntentSender target) {
        if (session.isMultiPackage() == false) goto L5;
        return false;
    L5:
        int userActionRequirement = session.computeUserActionRequirement();
        session.updateUserActionRequirement(userActionRequirement);
        if (userActionRequirement != 1) goto L8;
    L26:
        session.sendPendingUserActionIntent(target);
        return true;
    L8:
        if (userActionRequirement == 3) goto L26;
        if (session.isApexSession() == false) goto L13;
    L25:
        return false;
    L13:
        if (userActionRequirement != 2) goto L25;
        if (isTargetSdkConditionSatisfied(session) == true) goto L19;
        session.sendPendingUserActionIntent(target);
        return true;
    L19:
        if (session.params.requireUserAction != 2) goto L25;
        if (session.mSilentUpdatePolicy.isSilentUpdateAllowed(session.getInstallerPackageName(), session.getPackageName()) == true) goto L24;
        session.sendPendingUserActionIntent(target);
        return true;
    L24:
        session.mSilentUpdatePolicy.track(session.getInstallerPackageName(), session.getPackageName());
        goto L25
    }

    private static boolean isTargetSdkConditionSatisfied(PackageInstallerSession session) {
        Object r0 = session.mLock;
        monitor-enter(r0);
        int validatedTargetSdk = session.mValidatedTargetSdk;     // Catch: Throwable -> L17
        String packageName = session.mPackageName;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        ApplicationInfo appInfo = new ApplicationInfo();
        appInfo.packageName = packageName;
        appInfo.targetSdkVersion = validatedTargetSdk;
        IPlatformCompat platformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
        if (validatedTargetSdk != Integer.MAX_VALUE) goto L20;
        return false;
    L20:
        if (platformCompat.isChangeEnabled(SILENT_INSTALL_ALLOWED, appInfo) == false) goto L25;
        return true;
    L25:
        return false;
    L12:
        e = move-exception;
        Log.e(TAG, "Failed to get a response from PLATFORM_COMPAT_SERVICE", e);
        return false;
    L17:
        th = move-exception;
        throw th;
    }

    private static int userActionRequirementToReason(int requirement) {
        switch(requirement) {
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 2;
    }

    private boolean sendPendingUserActionIntentIfNeeded(boolean forPreapproval) {
        if (isCommitted() == false) goto L5;
        assertNotChild("PackageInstallerSession#sendPendingUserActionIntentIfNeeded");
    L5:
        if (forPreapproval == false) goto L7;
        final IntentSender statusReceiver = getPreapprovalRemoteStatusReceiver();
    L9:
        return sessionContains(new PackageInstallerSession$$ExternalSyntheticLambda12(statusReceiver));
    L7:
        statusReceiver = getRemoteStatusReceiver();
        goto L9
    }

    private static /* synthetic */ boolean lambda$sendPendingUserActionIntentIfNeeded$2(IntentSender statusReceiver, PackageInstallerSession s) {
        return checkUserActionRequirement(s, statusReceiver);
    }

    private void handleInstall() {
        if (isInstallerDeviceOwnerOrAffiliatedProfileOwner() == false) goto L5;
        DevicePolicyEventLogger.createEvent(112).setAdmin(getInstallSource().mInstallerPackageName).write();
    L5:
        boolean wasUserActionIntentSent = sendPendingUserActionIntentIfNeeded(false);
        if (this.mUserActionRequired != null) goto L8;
        this.mUserActionRequired = Boolean.valueOf(wasUserActionIntentSent);
    L8:
        if (wasUserActionIntentSent == false) goto L12;
        deactivate();
        return;
    L12:
        if (this.mUserActionRequired.booleanValue() == false) goto L35;
        activate();
    L35:
        List<PackageInstallerSession> children = getChildSessions();     // Catch: PackageManagerException -> L20
        if (isMultiPackage() == false) goto L23;
        Iterator<PackageInstallerSession> r2 = children.iterator();     // Catch: PackageManagerException -> L20
    L18:
        if (r2.hasNext() == false) goto L27;
        PackageInstallerSession child = r2.next();     // Catch: PackageManagerException -> L20
        child.prepareInheritedFiles();     // Catch: PackageManagerException -> L20
        child.parseApk();     // Catch: PackageManagerException -> L20
    L27:
        if (this.mVerificationInProgress == false) goto L30;
        Slog.w(TAG, "Verification is already in progress for session " + this.sessionId);
        return;
    L30:
        this.mVerificationInProgress = true;
        if (this.params.isStaged == false) goto L33;
        this.mStagedSession.verifySession();
        return;
    L33:
        verify();
        return;
    L23:
        prepareInheritedFiles();     // Catch: PackageManagerException -> L20
        parseApk();     // Catch: PackageManagerException -> L20
    L20:
        e = move-exception;
        String completeMsg = ExceptionUtils.getCompleteMessage(e);
        String errorMsg = PackageManager.installStatusToString(e.error, completeMsg);
        setSessionFailed(e.error, errorMsg);
        onSessionVerificationFailure(e.error, errorMsg);
        goto L27
    }

    private void verify() {
        runExtractNativeLibraries();
    }

    private void handleOnNativeLibsExtracted() {
        verifyNonStaged();     // Catch: PackageManagerException -> L4
        return;
    L4:
        e = move-exception;
        String completeMsg = ExceptionUtils.getCompleteMessage(e);
        String errorMsg = PackageManager.installStatusToString(e.error, completeMsg);
        setSessionFailed(e.error, errorMsg);
        onSessionVerificationFailure(e.error, errorMsg);
    }

    private void runExtractNativeLibraries() {
        IoThread.getHandler().post(new PackageInstallerSession$$ExternalSyntheticLambda13(this));
    }

    private /* synthetic */ void lambda$runExtractNativeLibraries$3() {
        List<PackageInstallerSession> children = getChildSessions();     // Catch: PackageManagerException -> L8
        if (isMultiPackage() == false) goto L11;
        Iterator<PackageInstallerSession> r1 = children.iterator();     // Catch: PackageManagerException -> L8
    L6:
        if (r1.hasNext() == false) goto L12;
        PackageInstallerSession child = r1.next();     // Catch: PackageManagerException -> L8
        child.extractNativeLibraries();     // Catch: PackageManagerException -> L8
    L12:
        this.mHandler.obtainMessage(7).sendToTarget();     // Catch: PackageManagerException -> L8
        return;
    L11:
        extractNativeLibraries();     // Catch: PackageManagerException -> L8
    L8:
        e = move-exception;
        String completeMsg = ExceptionUtils.getCompleteMessage(e);
        String errorMsg = PackageManager.installStatusToString(e.error, completeMsg);
        setSessionFailed(e.error, errorMsg);
        onSessionVerificationFailure(e.error, errorMsg);
    }

    private IntentSender getRemoteStatusReceiver() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IntentSender r1 = this.mRemoteStatusReceiver;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void setRemoteStatusReceiver(IntentSender remoteStatusReceiver) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRemoteStatusReceiver = remoteStatusReceiver;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private IntentSender getPreapprovalRemoteStatusReceiver() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IntentSender r1 = this.mPreapprovalRemoteStatusReceiver;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void setPreapprovalRemoteStatusReceiver(IntentSender remoteStatusReceiver) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPreapprovalRemoteStatusReceiver = remoteStatusReceiver;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void prepareInheritedFiles() throws PackageManagerException {
        if (isApexSession() == false) goto L5;
        return;
    L5:
        if (this.params.mode != 2) goto L71;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L10:
        if (this.mStageDirInUse == true) goto L58;
        if (this.mDestroyed == true) goto L56;
        if (this.mSealed == false) goto L54;
        List<File> fromFiles = this.mResolvedInheritedFiles;     // Catch: Throwable -> L22 IOException -> L24
        File toDir = this.stageDir;     // Catch: Throwable -> L22 IOException -> L24
        String tempPackageName = toDir.getName();     // Catch: Throwable -> L22 IOException -> L24
        Slog.d(TAG, "Inherited files: " + this.mResolvedInheritedFiles);     // Catch: Throwable -> L22 IOException -> L24
        if (this.mResolvedInheritedFiles.isEmpty() == true) goto L27;
        if (this.mInheritedFilesBase != null) goto L27;
        throw new IllegalStateException("mInheritedFilesBase == null");     // Catch: Throwable -> L22 IOException -> L24
    L27:
        if (isLinkPossible(fromFiles, toDir) == true) goto L29;
        copyFiles(fromFiles, toDir);     // Catch: Throwable -> L22 IOException -> L24
    L49:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L29:
        if (this.mResolvedInstructionSets.isEmpty() == true) goto L32;
        File oatDir = new File(toDir, "oat");     // Catch: Throwable -> L22 IOException -> L24
        createOatDirs(tempPackageName, this.mResolvedInstructionSets, oatDir);     // Catch: Throwable -> L22 IOException -> L24
    L32:
        if (this.mResolvedNativeLibPaths.isEmpty() == true) goto L46;
        Iterator<String> r4 = this.mResolvedNativeLibPaths.iterator();     // Catch: Throwable -> L22 IOException -> L24
    L35:
        if (r4.hasNext() == false) goto L46;
        String libPath = r4.next();     // Catch: Throwable -> L22 IOException -> L24
        int splitIndex = libPath.lastIndexOf(47);     // Catch: Throwable -> L22 IOException -> L24
        if (splitIndex < 0) goto L45;
        if (splitIndex >= (libPath.length() - 1)) goto L45;
        String libDirPath = libPath.substring(1, splitIndex);     // Catch: Throwable -> L22 IOException -> L24
        File libDir = new File(toDir, libDirPath);     // Catch: Throwable -> L22 IOException -> L24
        if (libDir.exists() == true) goto L44;
        NativeLibraryHelper.createNativeLibrarySubdir(libDir);     // Catch: Throwable -> L22 IOException -> L24
    L44:
        String archDirPath = libPath.substring(splitIndex + 1);     // Catch: Throwable -> L22 IOException -> L24
        NativeLibraryHelper.createNativeLibrarySubdir(new File(libDir, archDirPath));     // Catch: Throwable -> L22 IOException -> L24
    L45:
        Slog.e(TAG, "Skipping native library creation for linking due to invalid path: " + libPath);     // Catch: Throwable -> L22 IOException -> L24
    L46:
        linkFiles(tempPackageName, fromFiles, toDir, this.mInheritedFilesBase);     // Catch: Throwable -> L22 IOException -> L24
    L24:
        e = move-exception;
        throw new PackageManagerException(-4, "Failed to inherit existing install", e);     // Catch: Throwable -> L22
    L54:
        throw new PackageManagerException(-110, "Session not sealed");     // Catch: Throwable -> L22
    L56:
        throw new PackageManagerException(-110, "Session destroyed");     // Catch: Throwable -> L22
    L58:
        throw new PackageManagerException(-110, "Session files in use");     // Catch: Throwable -> L22
    }

    private void markStageDirInUseLocked() throws PackageManagerException {
        if (this.mDestroyed == true) goto L7;
        this.mStageDirInUse = true;
        return;
    L7:
        throw new PackageManagerException(-110, "Session destroyed");
    }

    private void parseApk() throws PackageManagerException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mStageDirInUse == true) goto L35;
        if (this.mDestroyed == true) goto L33;
        if (this.mSealed == false) goto L31;
        if (this.mPackageName == null) goto L29;
        if (this.mSigningDetails == null) goto L27;
        if (this.mResolvedBaseFile == null) goto L25;
        if (isApexSession() == true) goto L21;
        this.mPackageLite = getOrParsePackageLiteLocked(this.stageDir, 0);     // Catch: Throwable -> L19
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L21:
        this.mPackageLite = getOrParsePackageLiteLocked(this.mResolvedBaseFile, 0);     // Catch: Throwable -> L19
        goto L22
    L25:
        throw new PackageManagerException(-110, "Session no resolved base file");     // Catch: Throwable -> L19
    L27:
        throw new PackageManagerException(-110, "Session no signing data");     // Catch: Throwable -> L19
    L29:
        throw new PackageManagerException(-110, "Session no package name");     // Catch: Throwable -> L19
    L31:
        throw new PackageManagerException(-110, "Session not sealed");     // Catch: Throwable -> L19
    L33:
        throw new PackageManagerException(-110, "Session destroyed");     // Catch: Throwable -> L19
    L35:
        throw new PackageManagerException(-110, "Session files in use");     // Catch: Throwable -> L19
    }

    private void extractNativeLibraries() throws PackageManagerException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackageLite != null) goto L7;
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L7:
        if (isApexSession() == true) goto L27;
        Object r1 = this.mProgressLock;     // Catch: Throwable -> L16
        monitor-enter(r1);     // Catch: Throwable -> L16
        this.mInternalProgress = 0.5f;     // Catch: Throwable -> L24
        computeProgressLocked(true);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        File libDir = new File(this.stageDir, "lib");     // Catch: Throwable -> L16
        if (mayInheritNativeLibs() == true) goto L19;
        NativeLibraryHelper.removeNativeBinariesFromDirLI(libDir, true);     // Catch: Throwable -> L16
    L19:
        if (isArchivedInstallation() == false) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L22:
        extractNativeLibraries(this.mPackageLite, libDir, this.params.abiOverride);     // Catch: Throwable -> L16
        goto L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    }

    private void verifyNonStaged() throws PackageManagerException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        markStageDirInUseLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mSessionProvider.getSessionVerifier().verify(this, new PackageInstallerSession$$ExternalSyntheticLambda5(this));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$verifyNonStaged$5(final int error, final String msg) {
        this.mHandler.post(new PackageInstallerSession$$ExternalSyntheticLambda11(this, error, msg));
    }

    private /* synthetic */ void lambda$verifyNonStaged$4(int error, String msg) {
        if (dispatchPendingAbandonCallback() == false) goto L6;
        return;
    L6:
        if (error != 1) goto L8;
        onVerificationComplete();
        return;
    L8:
        onSessionVerificationFailure(error, msg);
    }

    private CompletableFuture<Void> install() {
        final List<CompletableFuture<InstallResult>> futures = installNonStaged();
        CompletableFuture<InstallResult>[] arr = new CompletableFuture[futures.size()];
        return CompletableFuture.allOf((CompletableFuture[]) futures.toArray(arr)).whenComplete(new PackageInstallerSession$$ExternalSyntheticLambda8(this, futures));
    }

    private /* synthetic */ void lambda$install$6(List futures, Void r, Throwable t) {
        if (t != null) goto L30;
        setSessionApplied();
        ArrayList<String> multiPackageWarnings = new ArrayList();
        if (isMultiPackage() == false) goto L16;
        Iterator r1 = futures.iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        CompletableFuture<InstallResult> f = (CompletableFuture) r1.next();
        InstallResult result = f.join();
        if (result.session == this) goto L7;
        if (result.extras == null) goto L7;
        ArrayList<String> childWarnings = result.extras.getStringArrayList("android.content.pm.extra.WARNINGS");
        if (ArrayUtils.isEmpty(childWarnings) == true) goto L7;
        multiPackageWarnings.addAll(childWarnings);
    L16:
        Iterator r2 = futures.iterator();
    L18:
        if (r2.hasNext() == false) goto L46;
        CompletableFuture<InstallResult> f2 = (CompletableFuture) r2.next();
        InstallResult result2 = f2.join();
        Bundle extras = result2.extras;
        if (isMultiPackage() == false) goto L28;
        if (result2.session != this) goto L28;
        if (multiPackageWarnings.isEmpty() == true) goto L28;
        if (extras != null) goto L27;
        extras = new Bundle();
    L27:
        extras.putStringArrayList("android.content.pm.extra.WARNINGS", multiPackageWarnings);
    L28:
        reportInstallPackageEvent(result2);
        result2.session.dispatchSessionFinished(1, "Session installed", extras);
        goto L18
    L46:
        return;
    L30:
        PackageManagerException e = (PackageManagerException) t.getCause();
        setSessionFailed(e.error, PackageManager.installStatusToString(e.error, e.getMessage()));
        dispatchSessionFinished(e.error, e.getMessage(), null);
        maybeFinishChildSessions(e.error, e.getMessage());
    }

    private List<CompletableFuture<InstallResult>> installNonStaged() {
        List<CompletableFuture<InstallResult>> futures = new ArrayList();     // Catch: PackageManagerException -> L10
        CompletableFuture<InstallResult> future = new CompletableFuture();     // Catch: PackageManagerException -> L10
        futures.add(future);     // Catch: PackageManagerException -> L10
        InstallingSession installingSession = createInstallingSession(future);     // Catch: PackageManagerException -> L10
        if (isMultiPackage() == false) goto L17;
        List<PackageInstallerSession> childSessions = getChildSessions();     // Catch: PackageManagerException -> L10
        List<InstallingSession> installingChildSessions = new ArrayList(childSessions.size());     // Catch: PackageManagerException -> L10
        int i = 0;
    L6:
        if (i >= childSessions.size()) goto L14;
        PackageInstallerSession session = childSessions.get(i);     // Catch: PackageManagerException -> L10
        CompletableFuture<InstallResult> future2 = new CompletableFuture();     // Catch: PackageManagerException -> L10
        futures.add(future2);     // Catch: PackageManagerException -> L10
        InstallingSession installingChildSession = session.createInstallingSession(future2);     // Catch: PackageManagerException -> L10
        if (installingChildSession == null) goto L12;
        installingChildSessions.add(installingChildSession);     // Catch: PackageManagerException -> L10
    L12:
        i = i + 1;     // Catch: PackageManagerException -> L10
        goto L6
    L14:
        if (installingChildSessions.isEmpty() == true) goto L19;
        installingSession.getClass();     // Catch: PackageManagerException -> L10
        installingSession.installStage(installingChildSessions);     // Catch: PackageManagerException -> L10
    L19:
        return futures;
    L17:
        if (installingSession == null) goto L19;
        installingSession.installStage();     // Catch: PackageManagerException -> L10
    L10:
        e = move-exception;
        List<CompletableFuture<InstallResult>> futures2 = new ArrayList();
        futures2.add(CompletableFuture.failedFuture(e));
        return futures2;
    }

    private void sendPendingUserActionIntent(IntentSender target) {
        if (isPreapprovalRequested() == true) goto L5;
    L7:
        boolean isPreapproval = false;
    L9:
        if (isPreapproval == false) goto L11;
        String r2 = "android.content.pm.action.CONFIRM_PRE_APPROVAL";
    L12:
        Intent intent = new Intent(r2);
        intent.setPackage(this.mPm.getPackageInstallerPackageName());
        intent.putExtra("android.content.pm.extra.SESSION_ID", this.sessionId);
        sendOnUserActionRequired(this.mContext, target, this.sessionId, intent);
        return;
    L11:
        r2 = "android.content.pm.action.CONFIRM_INSTALL";
        goto L12
    L5:
        if (isCommitted() == true) goto L7;
        isPreapproval = true;
        goto L9
    }

    private void onVerificationComplete() {
        if (isStaged() == false) goto L7;
        this.mStagingManager.commitSession(this.mStagedSession);
        sendUpdateToRemoteStatusReceiver(1, "Session staged", null, false);
        return;
    L7:
        if (this.params.isAutoInstallDependenciesEnabled == true) goto L9;
    L11:
        install();
        return;
    L9:
        if (isMultiPackage() == true) goto L11;
        this.mDependencyInstallerEnabled.set(true);
        resolveLibraryDependenciesIfNeeded();
    }

    private void resolveLibraryDependenciesIfNeeded() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        List<SharedLibraryInfo> missingLibraries = new ArrayList();     // Catch: Throwable -> L8
        List<SharedLibraryInfo> missingLibraries2 = this.mInstallDependencyHelper.getMissingSharedLibraries(this.mPackageLite);     // Catch: Throwable -> L8 Exception -> L10 PackageManagerException -> L12
        List<SharedLibraryInfo> missingLibraries3 = missingLibraries2;
    L18:
        this.mMissingSharedLibraryCount.set(missingLibraries3.size());     // Catch: Throwable -> L8
        this.mInstallDependencyHelper.resolveLibraryDependenciesIfNeeded(missingLibraries3, this.mPackageLite, this.mPm.snapshotComputer(), this.userId, this.mHandler, new AnonymousClass6(this));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        e = move-exception;
        handleDependencyResolutionFailure(new PackageManagerException(-9, e.getMessage()));     // Catch: Throwable -> L8
    L17:
        missingLibraries3 = missingLibraries;
    L12:
        e = move-exception;
        handleDependencyResolutionFailure(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void handleDependencyResolutionFailure(PackageManagerException e) {
        String completeMsg = ExceptionUtils.getCompleteMessage(e);
        setSessionFailed(e.error, completeMsg);
        onSessionDependencyResolveFailure(e.error, completeMsg);
        PackageMetrics.onDependencyInstallationFailure(this.sessionId, getPackageName(), e.error, this.mInstallerUid, this.params, this.mMissingSharedLibraryCount.get());
    }

    private InstallingSession createInstallingSession(final CompletableFuture<InstallResult> future) throws PackageManagerException {
        Object r3 = this.mLock;
        monitor-enter(r3);
    L94:
        th = move-exception;
        throw th;
    L5:
        if (this.mSealed == false) goto L97;
        markStageDirInUseLocked();     // Catch: Throwable -> L94
        monitor-exit(r3);     // Catch: Throwable -> L94
        if (isMultiPackage() == false) goto L12;
        future.complete(new InstallResult(this, null));
    L17:
        IPackageInstallObserver2.Stub r0 = new AnonymousClass7(this, future);
        if ((this.params.installFlags & 64) == 0) goto L20;
        UserHandle user = UserHandle.ALL;
    L22:
        if (this.params.isStaged == false) goto L25;
        this.params.installFlags |= 2097152;
    L25:
        if (isMultiPackage() == false) goto L27;
    L40:
        Object r4 = this.mLock;
        monitor-enter(r4);
        InstallingSession r5 = new InstallingSession(this.sessionId, this.stageDir, r0, this.params, this.mInstallSource, user, this.mSigningDetails, this.mInstallerUid, this.mPackageLite, this.mPreVerifiedDomains, this.mPm, this.mHasAppMetadataFile, this.mDependencyInstallerEnabled.get(), this.mMissingSharedLibraryCount.get());     // Catch: Throwable -> L68
        monitor-exit(r4);     // Catch: Throwable -> L68
        return r5;
    L70:
        th = th;
        Object r18 = r4;
    L92:
        monitor-exit(r18);     // Catch: Throwable -> L68
        throw th;
    L72:
        th = th;
        r18 = r4;
    L74:
        th = th;
        r18 = r4;
    L76:
        th = th;
        r18 = r4;
    L78:
        th = th;
        r18 = r4;
    L80:
        th = th;
        r18 = r4;
    L82:
        th = th;
        r18 = r4;
    L84:
        th = th;
        r18 = r4;
    L86:
        th = th;
        r18 = r4;
    L88:
        th = th;
        r18 = r4;
    L90:
        th = th;
        r18 = r4;
    L68:
        th = th;
        goto L92
    L27:
        if (isApexSession() == true) goto L40;
        Object r6 = this.mLock;
        monitor-enter(r6);
    L33:
        th = move-exception;
        throw th;
    L31:
        if (this.mPackageLite != null) goto L35;
        Slog.wtf(TAG, "Session: " + this.sessionId + ". Don't have a valid PackageLite.");     // Catch: Throwable -> L33
    L35:
        this.mPackageLite = getOrParsePackageLiteLocked(this.stageDir, 0);     // Catch: Throwable -> L33
        monitor-exit(r6);     // Catch: Throwable -> L33
        goto L40
    L20:
        user = new UserHandle(this.userId);
        goto L22
    L12:
        if (isApexSession() == false) goto L17;
        if (this.params.isStaged == false) goto L17;
        future.complete(new InstallResult(this, null));
        return null;
    L97:
        throw new PackageManagerException(-110, "Session not sealed");     // Catch: Throwable -> L94
    }

    private PackageLite getOrParsePackageLiteLocked(File packageFile, int flags) throws PackageManagerException {
        if (this.mPackageLite != null) goto L5;
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<PackageLite> result = ApkLiteParseUtils.parsePackageLite(input, packageFile, flags);
        if (result.isError() == true) goto L11;
        return (PackageLite) result.getResult();
    L11:
        throw new PackageManagerException(-110, result.getErrorMessage(), result.getException());
    L5:
        return this.mPackageLite;
    }

    private static void maybeRenameFile(File from, File to) throws PackageManagerException {
        if (from.equals(to) == false) goto L5;
        return;
    L5:
        if (from.renameTo(to) == false) goto L8;
        return;
    L8:
        throw new PackageManagerException(-110, "Could not rename file " + from + " to " + to);
    }

    private void logDataLoaderInstallationSession(int returnCode) {
        String packageName = getPackageName();
        if ((this.params.installFlags & 32) != 0) goto L5;
        String r1 = packageName;
    L6:
        String packageNameToLog = r1;
        long currentTimestamp = System.currentTimeMillis();
        if (returnCode == 1) goto L9;
        int packageUid = -1;
    L10:
        FrameworkStatsLog.write(263, isIncrementalInstallation(), packageNameToLog, currentTimestamp - this.createdMillis, returnCode, getApksSize(packageName), packageUid);
        return;
    L9:
        packageUid = this.mPm.snapshotComputer().getPackageUid(packageName, 0, this.userId);
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    private long getApksSize(String packageName) {
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        PackageStateInternal ps = pmi.getPackageStateInternal(packageName);
        if (ps != null) goto L5;
        return 0;
    L5:
        File apkDirOrPath = ps.getPath();
        if (apkDirOrPath != null) goto L9;
        return 0;
    L9:
        if (apkDirOrPath.isFile() == false) goto L15;
        if (apkDirOrPath.getName().toLowerCase().endsWith(".apk") == false) goto L15;
        return apkDirOrPath.length();
    L15:
        if (apkDirOrPath.isDirectory() == true) goto L17;
        return 0;
    L17:
        File[] files = apkDirOrPath.listFiles();
        long apksSize = 0;
        int i = 0;
    L19:
        if (i >= files.length) goto L25;
        if (files[i].getName().toLowerCase().endsWith(".apk") == false) goto L23;
        apksSize = apksSize + files[i].length();
    L23:
        i = i + 1;
        goto L19
    L25:
        return apksSize;
    }

    private boolean mayInheritNativeLibs() {
        if (SystemProperties.getBoolean(PROPERTY_NAME_INHERIT_NATIVE, true) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.params.mode != 2) goto L9;
        if ((this.params.installFlags & 1) == 0) goto L9;
        return true;
    }

    boolean isApexSession() {
        if ((this.params.installFlags & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean sessionContains(Predicate<PackageInstallerSession> filter) {
        if (isMultiPackage() == false) goto L5;
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<PackageInstallerSession> childSessions = getChildSessionsLocked();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        Iterator<PackageInstallerSession> r1 = childSessions.iterator();
    L12:
        if (r1.hasNext() == false) goto L18;
        PackageInstallerSession child = r1.next();
        if (filter.test(child) == false) goto L12;
        return true;
    L18:
        return false;
    L20:
        th = move-exception;
        throw th;
    L5:
        return filter.test(this);
    }

    private static /* synthetic */ boolean lambda$containsApkSession$7(PackageInstallerSession s) {
        return !s.isApexSession();
    }

    boolean containsApkSession() {
        return sessionContains(new PackageInstallerSession$$ExternalSyntheticLambda4());
    }

    private void validateApexInstallLocked() throws PackageManagerException {
        List<File> addedFiles = getAddedApksLocked();
        if (addedFiles.isEmpty() == true) goto L26;
        if (ArrayUtils.size(addedFiles) > 1) goto L24;
        File addedFile = addedFiles.get(0);
        String sourceName = addedFile.getName();
        if (sourceName.endsWith(APEX_FILE_EXTENSION) == false) goto L9;
        String targetName = sourceName;
    L11:
        if (FileUtils.isValidExtFilename(targetName) == false) goto L22;
        File targetFile = new File(this.stageDir, targetName);
        resolveAndStageFileLocked(addedFile, targetFile, null, List.of());
        this.mResolvedBaseFile = targetFile;
        this.mPackageName = null;
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<ApkLite> ret = ApkLiteParseUtils.parseApkLite(input.reset(), this.mResolvedBaseFile, 32);
        if (ret.isError() == true) goto L20;
        ApkLite apk = (ApkLite) ret.getResult();
        if (this.mPackageName != null) goto L17;
        this.mPackageName = apk.getPackageName();
        this.mVersionCode = apk.getLongVersionCode();
    L17:
        this.mSigningDetails = apk.getSigningDetails();
        this.mHasDeviceAdminReceiver = apk.isHasDeviceAdminReceiver();
        return;
    L20:
        throw new PackageManagerException(ret.getErrorCode(), ret.getErrorMessage(), ret.getException());
    L22:
        throw new PackageManagerException(-2, "Invalid filename: " + targetName);
    L9:
        targetName = sourceName + APEX_FILE_EXTENSION;
        goto L11
    L24:
        throw new PackageManagerException(-2, "Too many files for apex install");
    L26:
        throw new PackageManagerException(-2, TextUtils.formatSimple("Session: %d. No packages staged in %s", new Object[]{Integer.valueOf(this.sessionId), this.stageDir.getAbsolutePath()}));
    }

    private PackageLite validateApkInstallLocked() throws PackageManagerException {
        this.mPackageLite = null;
        this.mPackageName = null;
        this.mVersionCode = -1;
        this.mSigningDetails = SigningDetails.UNKNOWN;
        this.mResolvedBaseFile = null;
        this.mResolvedStagedFiles.clear();
        this.mResolvedInheritedFiles.clear();
        PackageInfo pkgInfo = this.mPm.snapshotComputer().getPackageInfo(this.params.appPackageName, 67108928, this.userId);
        int r5 = -2;
        if (this.params.mode != 2) goto L10;
        if (pkgInfo == null) goto L9;
        if (pkgInfo.applicationInfo != null) goto L10;
    L9:
        throw new PackageManagerException(-2, "Missing existing base package");
    L10:
        List<File> removedFiles = getRemovedFilesLocked();
        List<String> removeSplitList = new ArrayList();
        if (removedFiles.isEmpty() == true) goto L17;
        Iterator<File> r8 = removedFiles.iterator();
    L14:
        if (r8.hasNext() == false) goto L17;
        File removedFile = r8.next();
        String fileName = removedFile.getName();
        removeSplitList.add(fileName.substring(0, fileName.length() - REMOVE_MARKER_EXTENSION.length()));
    L17:
        if (isIncrementalInstallation() == true) goto L19;
        enableFsVerityToAddedApksWithIdsig();
    L19:
        List<ApkLite> addedFiles = getAddedApkLitesLocked();
        if (addedFiles.isEmpty() == true) goto L22;
    L28:
        List<String> artManagedFilePaths = getArtManagedFilePathsLocked();
        ArraySet<String> stagedSplits = new ArraySet();
        ArraySet<String> stagedSplitTypes = new ArraySet();
        ArraySet<String> requiredSplitTypes = new ArraySet();
        ArrayMap<String, ApkLite> splitApks = new ArrayMap();
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        Iterator<ApkLite> r16 = addedFiles.iterator();
        ApkLite baseApk = null;
    L30:
        if (r16.hasNext() == false) goto L70;
        ApkLite apk = r16.next();
        if (stagedSplits.add(apk.getSplitName()) == false) goto L69;
        if (apk.isUpdatableSystem() == true) goto L41;
        if (this.mOriginalInstallerUid != 0) goto L39;
        Slog.w(TAG, "Overriding updatableSystem because the installer is root for: " + apk.getPackageName());
        goto L41
    L39:
        throw new PackageManagerException(r5, "Non updatable system package can't be installed or updated");
    L41:
        if (this.mPackageName != null) goto L45;
        this.mPackageName = apk.getPackageName();
        this.mVersionCode = apk.getLongVersionCode();
    L45:
        if (this.mSigningDetails != SigningDetails.UNKNOWN) goto L47;
        this.mSigningDetails = apk.getSigningDetails();
    L47:
        this.mHasDeviceAdminReceiver = apk.isHasDeviceAdminReceiver();
        assertApkConsistentLocked(String.valueOf(apk), apk);
        String targetName = ApkLiteParseUtils.splitNameToFileName(apk);
        if (FileUtils.isValidExtFilename(targetName) == false) goto L67;
        if (apk.getInstallLocation() == (-1)) goto L57;
        String installerPackageName = getInstallerPackageName();
        if (installerPackageName == null) goto L56;
        List<File> removedFiles2 = removedFiles;
        if (this.params.installLocation == apk.getInstallLocation()) goto L58;
        Slog.wtf(TAG, installerPackageName + " drops manifest attribute android:installLocation in " + targetName + " for " + this.mPackageName);
    L58:
        File targetFile = new File(this.stageDir, targetName);
        if (isArchivedInstallation() == true) goto L62;
        File sourceFile = new File(apk.getPath());
        resolveAndStageFileLocked(sourceFile, targetFile, apk.getSplitName(), artManagedFilePaths);
    L62:
        if (apk.getSplitName() != null) goto L64;
        this.mResolvedBaseFile = targetFile;
        baseApk = apk;
    L65:
        CollectionUtils.addAll(requiredSplitTypes, apk.getRequiredSplitTypes());
        CollectionUtils.addAll(stagedSplitTypes, apk.getSplitTypes());
        removedFiles = removedFiles2;
        r5 = -2;
        goto L30
    L64:
        splitApks.put(apk.getSplitName(), apk);
        goto L65
    L56:
        removedFiles2 = removedFiles;
        goto L58
    L57:
        removedFiles2 = removedFiles;
        goto L58
    L67:
        throw new PackageManagerException(-2, "Invalid filename: " + targetName);
    L69:
        throw new PackageManagerException(-2, "Split " + apk.getSplitName() + " was defined multiple times");
    L70:
        verifySdmSignatures(artManagedFilePaths, this.mSigningDetails);
        if (removeSplitList.size() <= 0) goto L89;
        if (pkgInfo == null) goto L88;
        Iterator<String> r0 = removeSplitList.iterator();
    L75:
        if (r0.hasNext() == false) goto L82;
        String splitName = r0.next();
        if (ArrayUtils.contains(pkgInfo.splitNames, splitName) == true) goto L75;
        throw new PackageManagerException(-2, "Split not found: " + splitName);
    L82:
        if (this.mPackageName != null) goto L85;
        this.mPackageName = pkgInfo.packageName;
        this.mVersionCode = pkgInfo.getLongVersionCode();
    L85:
        if (this.mSigningDetails != SigningDetails.UNKNOWN) goto L89;
        this.mSigningDetails = unsafeGetCertsWithoutVerification(pkgInfo.applicationInfo.sourceDir);
        goto L89
    L88:
        throw new PackageManagerException(-2, "Missing existing base package for " + this.mPackageName);
    L89:
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        PackageStateInternal existingPkgSetting = pmi.getPackageStateInternal(this.mPackageName);
        if (isInstallationAllowed(existingPkgSetting) == false) goto L330;
        if (isArchivedInstallation() == false) goto L103;
        if (isArchivedInstallationAllowed(existingPkgSetting) == false) goto L101;
        if (this.mPm.mInstallerService.mPackageArchiver.verifySupportsUnarchival(getInstallSource().mInstallerPackageName, this.userId) == true) goto L103;
        throw new PackageManagerException(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Installer has to support unarchival in order to install archived packages.");
    L101:
        throw new PackageManagerException(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Archived installation of this package is not allowed.");
    L103:
        if (isIncrementalInstallation() == false) goto L105;
        File r1 = getTmpAppMetadataFile();
    L106:
        File stagedAppMetadataFile = r1;
        if (this.mHasAppMetadataFile == false) goto L114;
        if (stagedAppMetadataFile.exists() == true) goto L114;
        throw new PackageManagerException(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "App metadata file expected but not found in " + this.stageDir.getAbsolutePath());
    L114:
        if (isIncrementalInstallation() == false) goto L148;
        if (isIncrementalInstallationAllowed(existingPkgSetting) == false) goto L145;
        if (this.mHasAppMetadataFile == false) goto L148;
        File appMetadataFile = getTmpAppMetadataFile();
        IncrementalFileStorages incrementalFileStorages = getIncrementalFileStorages();
    L338:
    L333:
        incrementalFileStorages.makeFile(PackageManagerService.APP_METADATA_FILE_NAME, Files.readAllBytes(appMetadataFile.toPath()), 416);     // Catch: Throwable -> L126 IOException -> L128
    L125:
        appMetadataFile.delete();
    L128:
        e = e;
    L139:
        Slog.e(TAG, "Failed to write app metadata to incremental storage", e);     // Catch: Throwable -> L126
    L132:
        e = e;
    L130:
        th = th;
    L141:
        appMetadataFile.delete();
        throw th;
    L126:
        th = th;
    L136:
        e = e;
    L134:
        th = th;
        goto L141
    L145:
        throw new PackageManagerException(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Incremental installation of this package is not allowed.");
    L148:
        if (this.mInstallerUid == this.mOriginalInstallerUid) goto L157;
        if (TextUtils.isEmpty(this.mPackageName) == true) goto L155;
        if (this.mPackageName.equals(this.mOriginalInstallerPackageName) == true) goto L157;
    L155:
        throw new PackageManagerException(-23, "Can only transfer sessions that update the original installer");
    L157:
        if (this.mChecksums.isEmpty() == false) goto L328;
        if (this.params.mode == 1) goto L161;
        ApplicationInfo appInfo = pkgInfo.applicationInfo;
        ParseResult<PackageLite> pkgLiteResult = ApkLiteParseUtils.parsePackageLite(input.reset(), new File(appInfo.getCodePath()), 0);
        if (pkgLiteResult.isError() == true) goto L326;
        PackageLite existing = (PackageLite) pkgLiteResult.getResult();
        assertPackageConsistentLocked("Existing", existing.getPackageName(), existing.getLongVersionCode());
        SigningDetails signingDetails = unsafeGetCertsWithoutVerification(existing.getBaseApkPath());
        if (this.mSigningDetails.signaturesMatchExactly(signingDetails) == false) goto L324;
        if (this.mResolvedBaseFile != null) goto L189;
        this.mResolvedBaseFile = new File(appInfo.getBaseCodePath());
        inheritFileLocked(this.mResolvedBaseFile, artManagedFilePaths);
        CollectionUtils.addAll(requiredSplitTypes, existing.getBaseRequiredSplitTypes());
    L191:
        boolean existingSplitReplacedOrRemoved = false;
        if (ArrayUtils.isEmpty(existing.getSplitNames()) == true) goto L203;
        int i = 0;
    L195:
        if (i >= existing.getSplitNames().length) goto L202;
        String splitName2 = existing.getSplitNames()[i];
        boolean existingSplitReplacedOrRemoved2 = existingSplitReplacedOrRemoved;
        File splitFile = new File(existing.getSplitApkPaths()[i]);
        boolean splitRemoved = removeSplitList.contains(splitName2);
        boolean splitReplaced = stagedSplits.contains(splitName2);
        if (splitReplaced == true) goto L200;
        if (splitRemoved == true) goto L200;
        inheritFileLocked(splitFile, artManagedFilePaths);
        CollectionUtils.addAll(requiredSplitTypes, existing.getRequiredSplitTypes()[i]);
        CollectionUtils.addAll(stagedSplitTypes, existing.getSplitTypes()[i]);
        existingSplitReplacedOrRemoved = existingSplitReplacedOrRemoved2;
    L201:
        i = i + 1;
    L200:
        existingSplitReplacedOrRemoved = true;
        goto L201
    L202:
        boolean existingSplitReplacedOrRemoved3 = existingSplitReplacedOrRemoved;
    L204:
        if (existingSplitReplacedOrRemoved3 == true) goto L206;
    L208:
        File packageInstallDir = new File(appInfo.getBaseCodePath()).getParentFile();
        this.mInheritedFilesBase = packageInstallDir;
        File oatDir = new File(packageInstallDir, "oat");
        if (oatDir.exists() == false) goto L231;
        File[] archSubdirs = oatDir.listFiles();
        if (archSubdirs == null) goto L231;
        if (archSubdirs.length <= 0) goto L231;
        String[] instructionSets = InstructionSets.getAllDexCodeInstructionSets();
        int r2 = archSubdirs.length;
        int r3 = 0;
    L216:
        if (r3 >= r2) goto L231;
        File archSubDir = archSubdirs[r3];
        int r34 = r3;
        if (ArrayUtils.contains(instructionSets, archSubDir.getName()) == true) goto L220;
        int r35 = r2;
    L227:
        r3 = r34 + 1;
        r2 = r35;
        goto L216
    L220:
        File[] files = archSubDir.listFiles();
        if (files == null) goto L226;
        r35 = r2;
        if (files.length == 0) goto L227;
        this.mResolvedInstructionSets.add(archSubDir.getName());
        this.mResolvedInheritedFiles.addAll(Arrays.asList(files));
        goto L227
    L226:
        r35 = r2;
    L231:
        if (mayInheritNativeLibs() == true) goto L233;
    L269:
        boolean r19 = false;
    L271:
        if (existing.isSplitRequired() == false) goto L292;
        int existingSplits = ArrayUtils.size(existing.getSplitNames());
        if (existingSplits != removeSplitList.size()) goto L275;
        boolean allSplitsRemoved = true;
    L276:
        boolean r9 = true;
        if (stagedSplits.size() == 1) goto L279;
    L281:
        boolean onlyBaseFileStaged = r19;
    L283:
        if (allSplitsRemoved == false) goto L288;
        if (stagedSplits.isEmpty() == true) goto L291;
        if (onlyBaseFileStaged == false) goto L288;
    L291:
        throw new PackageManagerException(-28, "Missing split for " + this.mPackageName);
    L288:
        if (stagedSplitTypes.containsAll(requiredSplitTypes) == false) goto L291;
    L293:
        PackageLite packageLite = existing;
    L294:
        assertPreapprovalDetailsConsistentIfNeededLocked(packageLite, pkgInfo);
        if (packageLite.isUseEmbeddedDex() == false) goto L308;
        Iterator<File> r4 = this.mResolvedStagedFiles.iterator();
    L298:
        if (r4.hasNext() == false) goto L308;
        File file = r4.next();
        if (file.getName().endsWith(".apk") == false) goto L298;
        if (DexManager.auditUncompressedDexInApk(file.getPath()) == true) goto L298;
        throw new PackageManagerException(-2, "Some dex are not uncompressed and aligned correctly for " + this.mPackageName);
    L308:
        if (this.mInstallerUid != 2000) goto L310;
        boolean isInstallerShell = r9;
    L311:
        if (isInstallerShell == true) goto L313;
    L321:
        this.mValidatedTargetSdk = packageLite.getTargetSdk();
        return packageLite;
    L313:
        if (isIncrementalInstallation() == false) goto L321;
        if (this.mIncrementalFileStorages == null) goto L321;
        if (packageLite.isDebuggable() == true) goto L321;
        if (packageLite.isProfileableByShell() == true) goto L321;
        this.mIncrementalFileStorages.disallowReadLogs();
        goto L321
    L310:
        isInstallerShell = r19;
        goto L311
    L279:
        if (stagedSplits.contains(null) == false) goto L281;
        onlyBaseFileStaged = true;
        goto L283
    L275:
        allSplitsRemoved = r19;
        goto L276
    L292:
        r9 = true;
        goto L293
    L233:
        if (removeSplitList.isEmpty() == false) goto L269;
        r19 = false;
        File[] libDirs = {new File(packageInstallDir, "lib"), new File(packageInstallDir, "lib64")};
        int r10 = libDirs.length;
        int r6 = 0;
    L235:
        if (r6 >= r10) goto L271;
        File libDir = libDirs[r6];
        if (libDir.exists() == true) goto L239;
        packageInstallDir = packageInstallDir;
    L267:
        r6 = r6 + 1;
        packageInstallDir = packageInstallDir;
        goto L235
    L239:
        if (libDir.isDirectory() == true) goto L241;
        packageInstallDir = packageInstallDir;
        goto L267
    L241:
        List<String> libDirsToInherit = new ArrayList();
        List<File> libFilesToInherit = new ArrayList();
        File[] r7 = libDir.listFiles();
        int r11 = r7.length;
        int r12 = 0;
    L242:
        if (r12 >= r11) goto L257;
        int r37 = r11;
        File archSubDir2 = r7[r12];
        if (archSubDir2.isDirectory() == true) goto L335;
        int r38 = r12;
        List<String> libDirsToInherit2 = libDirsToInherit;
        List<File> libFilesToInherit2 = libFilesToInherit;
    L254:
        r12 = r38 + 1;
        libFilesToInherit = libFilesToInherit2;
        r11 = r37;
        libDirsToInherit = libDirsToInherit2;
        goto L242
    L335:
        String relLibPath = getRelativePath(archSubDir2, packageInstallDir);     // Catch: IOException -> L255
        r38 = r12;
        File[] files2 = archSubDir2.listFiles();
        if (files2 != null) goto L250;
        libDirsToInherit2 = libDirsToInherit;
        libFilesToInherit2 = libFilesToInherit;
        goto L254
    L250:
        if (files2.length != 0) goto L252;
        libDirsToInherit2 = libDirsToInherit;
        libFilesToInherit2 = libFilesToInherit;
        goto L254
    L252:
        List<String> libDirsToInherit3 = libDirsToInherit;
        libDirsToInherit3.add(relLibPath);
        libDirsToInherit2 = libDirsToInherit3;
        libFilesToInherit2 = libFilesToInherit;
        libFilesToInherit2.addAll(Arrays.asList(files2));
    L255:
        e = move-exception;
        List<String> libDirsToInherit4 = libDirsToInherit;
        List<File> libFilesToInherit3 = libFilesToInherit;
        Slog.e(TAG, "Skipping linking of native library directory!", e);
        libDirsToInherit4.clear();
        libFilesToInherit3.clear();
    L258:
        Iterator<String> r13 = libDirsToInherit4.iterator();
    L260:
        if (r13.hasNext() == false) goto L265;
        String subDir = r13.next();
        Iterator<String> r36 = r13;
        if (this.mResolvedNativeLibPaths.contains(subDir) == true) goto L264;
        this.mResolvedNativeLibPaths.add(subDir);
    L264:
        r13 = r36;
        goto L260
    L265:
        this.mResolvedInheritedFiles.addAll(libFilesToInherit3);
        goto L267
    L257:
        libDirsToInherit4 = libDirsToInherit;
        libFilesToInherit3 = libFilesToInherit;
        goto L258
    L206:
        if ((this.params.installFlags & 4096) == 0) goto L208;
        this.params.setDontKillApp(false);
        goto L208
    L203:
        existingSplitReplacedOrRemoved3 = false;
        goto L204
    L189:
        if ((this.params.installFlags & 4096) == 0) goto L191;
        EventLog.writeEvent(1397638484, "219044664");
        this.params.setDontKillApp(false);
        goto L191
    L324:
        throw new PackageManagerException(-2, "Existing signatures are inconsistent");
    L326:
        throw new PackageManagerException(-110, pkgLiteResult.getErrorMessage(), pkgLiteResult.getException());
    L161:
        if (stagedSplits.contains(null) == false) goto L180;
        if ((this.params.installFlags & 4096) == 0) goto L166;
        EventLog.writeEvent(1397638484, "219044664");
        this.params.setDontKillApp(false);
    L166:
        if (baseApk.isSplitRequired() == true) goto L168;
    L174:
        ParseResult<PackageLite> pkgLiteResult2 = ApkLiteParseUtils.composePackageLiteFromApks(input.reset(), this.stageDir, baseApk, splitApks, true);
        if (pkgLiteResult2.isError() == true) goto L178;
        this.mPackageLite = (PackageLite) pkgLiteResult2.getResult();
        packageLite = this.mPackageLite;
        r19 = false;
        r9 = true;
        goto L294
    L178:
        throw new PackageManagerException(pkgLiteResult2.getErrorCode(), pkgLiteResult2.getErrorMessage(), pkgLiteResult2.getException());
    L168:
        if (stagedSplits.size() <= 1) goto L173;
        if (stagedSplitTypes.containsAll(requiredSplitTypes) == true) goto L174;
    L173:
        throw new PackageManagerException(-28, "Missing split for " + this.mPackageName);
    L180:
        throw new PackageManagerException(-2, "Full install must include a base package");
    L328:
        throw new PackageManagerException(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Invalid checksum name(s): " + String.join(",", this.mChecksums.keySet()));
    L105:
        r1 = getStagedAppMetadataFile();
        goto L106
    L330:
        throw new PackageManagerException(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Installation of this package is not allowed.");
    L22:
        if (removeSplitList.size() == 0) goto L27;
        if (this.mHasAppMetadataFile == false) goto L28;
    L27:
        throw new PackageManagerException(-2, TextUtils.formatSimple("Session: %d. No packages staged in %s", new Object[]{Integer.valueOf(this.sessionId), this.stageDir.getAbsolutePath()}));
    }

    private void stageFileLocked(File origFile, File targetFile) throws PackageManagerException {
        this.mResolvedStagedFiles.add(targetFile);
        maybeRenameFile(origFile, targetFile);
    }

    private void maybeStageV4SignatureLocked(File origFile, File targetFile) throws PackageManagerException {
        File originalSignature = new File(origFile.getPath() + ".idsig");
        if (originalSignature.exists() == false) goto L6;
        File stagedSignature = new File(targetFile.getPath() + ".idsig");
        stageFileLocked(originalSignature, stagedSignature);
        return;
    }

    private void maybeStageDexMetadataLocked(File origFile, File targetFile) throws PackageManagerException {
        File dexMetadataFile = DexMetadataHelper.findDexMetadataForFile(origFile);
        if (dexMetadataFile != null) goto L6;
        return;
    L6:
        if (FileUtils.isValidExtFilename(dexMetadataFile.getName()) == false) goto L10;
        File targetDexMetadataFile = new File(this.stageDir, DexMetadataHelper.buildDexMetadataPathForApk(targetFile.getName()));
        stageFileLocked(dexMetadataFile, targetDexMetadataFile);
        return;
    L10:
        throw new PackageManagerException(-2, "Invalid filename: " + dexMetadataFile);
    }

    private void maybeStageArtManagedInstallFilesLocked(File origFile, File targetFile, List<String> artManagedFilePaths) throws PackageManagerException {
        Iterator r0 = ArtManagedInstallFileHelper.filterPathsForApk(artManagedFilePaths, origFile.getPath()).iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        String path = (String) r0.next();
        File artManagedFile = new File(path);
        if (FileUtils.isValidExtFilename(artManagedFile.getName()) == false) goto L18;
        File targetArtManagedFile = new File(ArtManagedInstallFileHelper.getTargetPathForApk(path, targetFile.getPath()));
        stageFileLocked(artManagedFile, targetArtManagedFile);
        if (artManagedFile.equals(targetArtManagedFile) == true) goto L4;
        int i = 0;
    L11:
        if (i >= artManagedFilePaths.size()) goto L4;
        if (artManagedFilePaths.get(i).equals(path) == false) goto L15;
        artManagedFilePaths.set(i, targetArtManagedFile.getAbsolutePath());
    L15:
        i = i + 1;
        goto L11
    L18:
        throw new PackageManagerException(-2, "Invalid filename: " + artManagedFile);
    }

    private IncrementalFileStorages getIncrementalFileStorages() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IncrementalFileStorages r1 = this.mIncrementalFileStorages;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void storeBytesToInstallationFile(String localPath, String absolutePath, byte[] bytes) throws IOException {
        IncrementalFileStorages incrementalFileStorages = getIncrementalFileStorages();
        if (isIncrementalInstallation() == false) goto L7;
        if (incrementalFileStorages == null) goto L7;
        incrementalFileStorages.makeFile(localPath, bytes, UnixStat.DEFAULT_LINK_PERM);
        return;
    L7:
        FileUtils.bytesToFile(absolutePath, bytes);
    }

    private void maybeStageDigestsLocked(File origFile, File targetFile, String splitName) throws PackageManagerException {
        PerFileChecksum perFileChecksum = this.mChecksums.get(origFile.getName());
        if (perFileChecksum != null) goto L5;
        return;
    L5:
        this.mChecksums.remove(origFile.getName());
        Checksum[] checksums = perFileChecksum.getChecksums();
        if (checksums.length != 0) goto L8;
        return;
    L8:
        String targetDigestsPath = ApkChecksums.buildDigestsPathForApk(targetFile.getName());
        File targetDigestsFile = new File(this.stageDir, targetDigestsPath);
        ByteArrayOutputStream os = new ByteArrayOutputStream();     // Catch: Throwable -> L25 IOException -> L27
        ApkChecksums.writeChecksums(os, checksums);     // Catch: Throwable -> L15
        byte[] signature = perFileChecksum.getSignature();     // Catch: Throwable -> L15
        if (signature != null) goto L13;
    L17:
        storeBytesToInstallationFile(targetDigestsPath, targetDigestsFile.getAbsolutePath(), os.toByteArray());     // Catch: Throwable -> L15
        stageFileLocked(targetDigestsFile, targetDigestsFile);     // Catch: Throwable -> L15
        if (signature == null) goto L29;
        if (signature.length == 0) goto L29;
        String targetDigestsSignaturePath = ApkChecksums.buildSignaturePathForDigests(targetDigestsPath);     // Catch: Throwable -> L15
        File targetDigestsSignatureFile = new File(this.stageDir, targetDigestsSignaturePath);     // Catch: Throwable -> L15
        storeBytesToInstallationFile(targetDigestsSignaturePath, targetDigestsSignatureFile.getAbsolutePath(), signature);     // Catch: Throwable -> L15
        stageFileLocked(targetDigestsSignatureFile, targetDigestsSignatureFile);     // Catch: Throwable -> L15
        os.close();     // Catch: Throwable -> L25 Throwable -> L25 IOException -> L27
        return;
    L29:
        os.close();     // Catch: Throwable -> L25 Throwable -> L25 IOException -> L27
        return;
    L13:
        if (signature.length <= 0) goto L17;
        ApkChecksums.verifySignature(checksums, signature);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        os.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: Throwable -> L25 Throwable -> L25 IOException -> L27
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 Throwable -> L25 IOException -> L27
    L27:
        e = move-exception;
        throw new PackageManagerException(-4, "Failed to store digests for " + this.mPackageName, e);
    L25:
        e = move-exception;
        throw new PackageManagerException(GnssNative.GeofenceCallbacks.GEOFENCE_STATUS_ERROR_INVALID_TRANSITION, "Failed to verify digests' signature for " + this.mPackageName, e);
    }

    private void resolveAndStageFileLocked(File origFile, File targetFile, String splitName, List<String> artManagedFilePaths) throws PackageManagerException {
        stageFileLocked(origFile, targetFile);
        if (VerityUtils.isFsVeritySupported() == false) goto L6;
        maybeStageV4SignatureLocked(origFile, targetFile);
    L6:
        if (Flags.artServiceV3() == false) goto L8;
        maybeStageArtManagedInstallFilesLocked(origFile, targetFile, artManagedFilePaths);
    L9:
        maybeStageDigestsLocked(origFile, targetFile, splitName);
        return;
    L8:
        maybeStageDexMetadataLocked(origFile, targetFile);
        goto L9
    }

    private void maybeInheritV4SignatureLocked(File origFile) {
        File v4SignatureFile = new File(origFile.getPath() + ".idsig");
        if (v4SignatureFile.exists() == false) goto L6;
        this.mResolvedInheritedFiles.add(v4SignatureFile);
        return;
    }

    private void inheritFileLocked(File origFile, List<String> artManagedFilePaths) {
        this.mResolvedInheritedFiles.add(origFile);
        maybeInheritV4SignatureLocked(origFile);
        if (Flags.artServiceV3() == false) goto L9;
        Iterator r0 = ArtManagedInstallFileHelper.filterPathsForApk(artManagedFilePaths, origFile.getPath()).iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        String path = (String) r0.next();
        File artManagedFile = new File(path);
        this.mResolvedInheritedFiles.add(artManagedFile);
    L12:
        File digestsFile = ApkChecksums.findDigestsForFile(origFile);
        if (digestsFile == null) goto L19;
        this.mResolvedInheritedFiles.add(digestsFile);
        File signatureFile = ApkChecksums.findSignatureForDigests(digestsFile);
        if (signatureFile == null) goto L20;
        this.mResolvedInheritedFiles.add(signatureFile);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        File dexMetadataFile = DexMetadataHelper.findDexMetadataForFile(origFile);
        if (dexMetadataFile == null) goto L12;
        this.mResolvedInheritedFiles.add(dexMetadataFile);
        goto L12
    }

    private void assertApkConsistentLocked(String tag, ApkLite apk) throws PackageManagerException {
        assertPackageConsistentLocked(tag, apk.getPackageName(), apk.getLongVersionCode());
        if (this.mSigningDetails.signaturesMatchExactly(apk.getSigningDetails()) == false) goto L6;
        return;
    L6:
        throw new PackageManagerException(-2, tag + " signatures are inconsistent");
    }

    private void assertPackageConsistentLocked(String tag, String packageName, long versionCode) throws PackageManagerException {
        if (this.mPackageName.equals(packageName) == false) goto L17;
        if (this.params.appPackageName == null) goto L12;
        if (this.params.appPackageName.equals(packageName) == true) goto L12;
        throw new PackageManagerException(-2, tag + " specified package " + this.params.appPackageName + " inconsistent with " + packageName);
    L12:
        if (this.mVersionCode != versionCode) goto L15;
        return;
    L15:
        throw new PackageManagerException(-2, tag + " version code " + versionCode + " inconsistent with " + this.mVersionCode);
    L17:
        throw new PackageManagerException(-2, tag + " package " + packageName + " inconsistent with " + this.mPackageName);
    }

    private void assertPreapprovalDetailsConsistentIfNeededLocked(PackageLite packageLite, PackageInfo info) throws PackageManagerException {
        if (this.mPreapprovalDetails != null) goto L5;
        return;
    L5:
        if (isPreapprovalRequested() == true) goto L8;
        return;
    L8:
        if (TextUtils.equals(this.mPackageName, this.mPreapprovalDetails.getPackageName()) == false) goto L31;
        PackageManager packageManager = this.mContext.getPackageManager();
        if (info == null) goto L12;
        PackageInfo existingPackageInfo = info;
    L13:
        CharSequence appLabel = this.mPreapprovalDetails.getLabel();
        if (existingPackageInfo == null) goto L18;
        ApplicationInfo existingAppInfo = existingPackageInfo.applicationInfo;
        CharSequence existingAppLabel = packageManager.getApplicationLabel(existingAppInfo);
        if (TextUtils.equals(appLabel, existingAppLabel) == false) goto L18;
        return;
    L18:
        PackageInfo packageInfoFromApk = packageManager.getPackageArchiveInfo(packageLite.getPath(), PackageManager.PackageInfoFlags.of(0));
        if (packageInfoFromApk == null) goto L29;
        List<String> filePaths = packageLite.getAllApkPaths();
        ULocale appLocale = this.mPreapprovalDetails.getLocale();
        ApplicationInfo appInfo = packageInfoFromApk.applicationInfo;
        boolean appLabelMatched = false;
        int i = filePaths.size() - 1;
    L21:
        if (i < 0) goto L24;
        if (appLabelMatched == true) goto L24;
        appLabelMatched = appLabelMatched | TextUtils.equals(getAppLabel(filePaths.get(i), appLocale, appInfo), appLabel);
        i = i - 1;
    L24:
        if (appLabelMatched == false) goto L27;
        return;
    L27:
        throw new PackageManagerException(-110, this.mPreapprovalDetails + " inconsistent with app label");
    L29:
        throw new PackageManagerException(-2, "Failure to obtain package info from APK files.");
    L12:
        existingPackageInfo = this.mPm.snapshotComputer().getPackageInfo(this.mPackageName, 0, this.userId);
        goto L13
    L31:
        throw new PackageManagerException(-110, this.mPreapprovalDetails + " inconsistent with " + this.mPackageName);
    }

    private CharSequence getAppLabel(String path, ULocale locale, ApplicationInfo appInfo) throws PackageManagerException {
        Resources pRes = this.mContext.getResources();
        AssetManager assetManager = new AssetManager();
        Configuration config = new Configuration(pRes.getConfiguration());
        ApkAssets apkAssets = ApkAssets.loadFromPath(path);     // Catch: IOException -> L6
        assetManager.setApkAssets(new ApkAssets[]{apkAssets}, false);
        config.setLocale(locale.toLocale());
        Resources res = new Resources(assetManager, pRes.getDisplayMetrics(), config);
        return TextUtils.trimToSize(tryLoadingAppLabel(res, appInfo), 1000);
    L8:
        throw new PackageManagerException(-2, "Failure to get resources from package archive " + path);
    }

    private CharSequence tryLoadingAppLabel(Resources res, ApplicationInfo info) {
        CharSequence label = null;
        if (info.labelRes != 0) goto L14;
    L7:
        if (label == null) goto L9;
        return label;
    L9:
        if (info.nonLocalizedLabel == null) goto L11;
        CharSequence label2 = info.nonLocalizedLabel;
    L13:
        return label2;
    L11:
        label2 = info.packageName;
        goto L13
    L14:
        label = res.getText(info.labelRes).toString().trim();     // Catch: Resources.NotFoundException -> L6
        goto L7
    }

    private SigningDetails unsafeGetCertsWithoutVerification(String path) throws PackageManagerException {
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<SigningDetails> result = ApkSignatureVerifier.unsafeGetCertsWithoutVerification(input, path, 1);
        if (result.isError() == true) goto L7;
        return (SigningDetails) result.getResult();
    L7:
        throw new PackageManagerException(-2, "Couldn't obtain signatures from APK : " + path);
    }

    private static boolean isLinkPossible(List<File> fromFiles, File toDir) {
        StructStat toStat = Os.stat(toDir.getAbsolutePath());     // Catch: ErrnoException -> L11
        Iterator<File> r2 = fromFiles.iterator();     // Catch: ErrnoException -> L11
    L5:
        if (r2.hasNext() == false) goto L13;
        File fromFile = r2.next();     // Catch: ErrnoException -> L11
        StructStat fromStat = Os.stat(fromFile.getAbsolutePath());     // Catch: ErrnoException -> L11
        if (fromStat.st_dev == toStat.st_dev) goto L5;
        return false;
    L13:
        return true;
    L11:
        e = move-exception;
        Slog.w(TAG, "Failed to detect if linking possible: " + e);
        return false;
    }

    private static void verifySdmSignatures(List<String> artManagedFilePaths, SigningDetails expectedSigningDetails) throws PackageManagerException {
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        Iterator<String> r1 = artManagedFilePaths.iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        String path = r1.next();
        if (path.endsWith(".sdm") == false) goto L4;
        ParseResult<SigningDetails> verified = ApkSignatureVerifier.verify(input, path, 3);
        if (verified.isError() == true) goto L16;
        if (expectedSigningDetails.signaturesMatchExactly((SigningDetails) verified.getResult()) == true) goto L4;
        throw new PackageManagerException(-2, "SDM signatures are inconsistent with APK");
    L16:
        throw new PackageManagerException(-2, "Failed to verify SDM signatures");
    }

    public int getInstallerUid() {
        return this.mInstallerUid;
    }

    public String getPackageName() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mPackageName;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getUpdatedMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.updatedMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    long getCommittedMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.committedMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    String getInstallerPackageName() {
        return getInstallSource().mInstallerPackageName;
    }

    String getInstallerAttributionTag() {
        return getInstallSource().mInstallerAttributionTag;
    }

    InstallSource getInstallSource() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        InstallSource r1 = this.mInstallSource;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    SigningDetails getSigningDetails() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SigningDetails r1 = this.mSigningDetails;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    PackageLite getPackageLite() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageLite r1 = this.mPackageLite;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean getUserActionRequired() {
        if (this.mUserActionRequired != null) goto L5;
        Slog.wtf(TAG, "mUserActionRequired should not be null.");
        return false;
    L5:
        return this.mUserActionRequired.booleanValue();
    }

    private static String getRelativePath(File file, File base) throws IOException {
        String pathStr = file.getAbsolutePath();
        String baseStr = base.getAbsolutePath();
        if (pathStr.contains("/.") == true) goto L11;
        if (pathStr.startsWith(baseStr) == false) goto L9;
        return pathStr.substring(baseStr.length());
    L9:
        throw new IOException("File: " + pathStr + " outside base: " + baseStr);
    L11:
        throw new IOException("Invalid path (was relative) : " + pathStr);
    }

    private void createOatDirs(String packageName, List<String> instructionSets, File fromDir) throws PackageManagerException {
        Iterator<String> r0 = instructionSets.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String instructionSet = r0.next();
        this.mInstaller.createOatDir(packageName, fromDir.getAbsolutePath(), instructionSet);     // Catch: Installer.InstallerException -> L8
    L8:
        e = move-exception;
        throw PackageManagerException.from(e);
    }

    private void linkFile(String packageName, String relativePath, String fromBase, String toBase) throws IOException {
        IncrementalFileStorages incrementalFileStorages = getIncrementalFileStorages();     // Catch: Throwable -> L7
        if (incrementalFileStorages != null) goto L5;
    L9:
        this.mInstaller.linkFile(packageName, relativePath, fromBase, toBase);     // Catch: Throwable -> L7
        return;
    L5:
        if (incrementalFileStorages.makeLink(relativePath, fromBase, toBase) == false) goto L9;
        return;
    L7:
        e = move-exception;
        throw new IOException("failed linkOrCreateDir(" + relativePath + ", " + fromBase + ", " + toBase + ")", e);
    }

    private void linkFiles(String packageName, List<File> fromFiles, File toDir, File fromDir) throws IOException {
        Iterator<File> r0 = fromFiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        File fromFile = r0.next();
        String relativePath = getRelativePath(fromFile, fromDir);
        String fromBase = fromDir.getAbsolutePath();
        String toBase = toDir.getAbsolutePath();
        linkFile(packageName, relativePath, fromBase, toBase);
        goto L4
    L6:
        Slog.d(TAG, "Linked " + fromFiles.size() + " files into " + toDir);
    }

    private static void copyFiles(List<File> fromFiles, File toDir) throws IOException {
        File[] r0 = toDir.listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        File file = r0[r2];
        if (file.getName().endsWith(".tmp") == false) goto L8;
        file.delete();
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        Iterator<File> r3 = fromFiles.iterator();
    L11:
        if (r3.hasNext() == false) goto L25;
        File fromFile = r3.next();
        File tmpFile = File.createTempFile("inherit", ".tmp", toDir);
        Slog.d(TAG, "Copying " + fromFile + " to " + tmpFile);
        if (FileUtils.copyFile(fromFile, tmpFile) == false) goto L24;
        Os.chmod(tmpFile.getAbsolutePath(), 420);     // Catch: ErrnoException -> L20
        File toFile = new File(toDir, fromFile.getName());
        Slog.d(TAG, "Renaming " + tmpFile + " to " + toFile);
        if (tmpFile.renameTo(toFile) == true) goto L11;
        throw new IOException("Failed to rename " + tmpFile + " to " + toFile);
    L22:
        throw new IOException("Failed to chmod " + tmpFile);
    L24:
        throw new IOException("Failed to copy " + fromFile + " to " + tmpFile);
    L25:
        Slog.d(TAG, "Copied " + fromFiles.size() + " files into " + toDir);
    }

    private void extractNativeLibraries(PackageLite packageLite, File libDir, String abiOverride) throws PackageManagerException {
        packageLite.getClass();
        NativeLibraryHelper.Handle handle = null;
        handle = NativeLibraryHelper.Handle.create(packageLite);     // Catch: Throwable -> L10 IOException -> L12
        int res = NativeLibraryHelper.copyNativeBinariesWithOverride(handle, libDir, abiOverride, isIncrementalInstallation());     // Catch: Throwable -> L10 IOException -> L12
        if (res != 1) goto L9;
        IoUtils.closeQuietly(handle);
        return;
    L9:
        throw new PackageManagerException(res, "Failed to extract native libraries, res=" + res);     // Catch: Throwable -> L10 IOException -> L12
    L10:
        th = move-exception;
        IoUtils.closeQuietly(handle);
        throw th;
    L12:
        e = move-exception;
        throw new PackageManagerException(-110, "Failed to extract native libraries", e);     // Catch: Throwable -> L10
    }

    void setPermissionsResult(boolean accepted) {
        if (isSealed() == true) goto L10;
        if (isPreapprovalRequested() == true) goto L10;
        throw new SecurityException("Must be sealed to accept permissions");
    L10:
        if (hasParentSessionId() == true) goto L12;
    L14:
        PackageInstallerSession root = this;
    L16:
        if (accepted == false) goto L30;
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mPermissionsManuallyAccepted = true;     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        Handler r2 = root.mHandler;
        if (isCommitted() == false) goto L25;
        int r3 = 3;
    L26:
        r2.obtainMessage(r3).sendToTarget();
        return;
    L25:
        r3 = 6;
    L27:
        th = move-exception;
        throw th;
    L30:
        root.destroy("User rejected permissions");
        root.dispatchSessionFinished(-115, "User rejected permissions", null);
        root.maybeFinishChildSessions(-115, "User rejected permissions");
        return;
    L12:
        if (isCommitted() == false) goto L14;
        root = this.mSessionProvider.getSession(getParentSessionId());
        goto L16
    }

    public void open() throws IOException {
        activate();
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean wasPrepared = this.mPrepared;     // Catch: Throwable -> L9
        if (this.mPrepared == false) goto L7;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (wasPrepared == true) goto L23;
        this.mCallback.onSessionPrepared(this);
        return;
    L23:
        return;
    L7:
        if (this.stageDir == null) goto L12;
        PackageInstallerService.prepareStageDir(this.stageDir);     // Catch: Throwable -> L9
    L13:
        this.mPrepared = true;     // Catch: Throwable -> L9
        goto L16
    L12:
        if (this.params.isMultiPackage == true) goto L13;
        throw new IllegalArgumentException("stageDir must be set");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void activate() {
        if (this.mActiveCount.getAndIncrement() != 0) goto L6;
        this.mCallback.onSessionActiveChanged(this, true);
        return;
    }

    public void close() {
        closeInternal(true);
    }

    private void closeInternal(boolean checkCaller) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (checkCaller == true) goto L13;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L6
        deactivate();
        return;
    L6:
        th = move-exception;
        throw th;
    L13:
        assertCallerIsOwnerOrRoot();     // Catch: Throwable -> L6
        goto L8
    }

    private void deactivate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int activeCount = this.mActiveCount.decrementAndGet();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (activeCount != 0) goto L14;
        this.mCallback.onSessionActiveChanged(this, false);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void maybeFinishChildSessions(int returnCode, String msg) {
        Iterator<PackageInstallerSession> r0 = getChildSessions().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PackageInstallerSession child = r0.next();
        child.dispatchSessionFinished(returnCode, msg, null);
        goto L4
    }

    private void assertNotChild(String cookie) {
        if (hasParentSessionId() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(cookie + " can't be called on a child session, id=" + this.sessionId + " parentId=" + getParentSessionId());
    }

    private boolean dispatchPendingAbandonCallback() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mStageDirInUse == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        this.mStageDirInUse = false;     // Catch: Throwable -> L8
        Runnable callback = this.mPendingAbandonCallback;     // Catch: Throwable -> L8
        this.mPendingAbandonCallback = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (callback == null) goto L15;
        callback.run();
        return true;
    L15:
        return false;
    }

    public void abandon() {
        if (this.mIsPerfLockAcquired == true) goto L5;
    L7:
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertNotChild("abandon");     // Catch: Throwable -> L13
        assertCallerIsOwnerOrRootOrSystem();     // Catch: Throwable -> L13
        if (isInTerminalState() == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        this.mDestroyed = true;     // Catch: Throwable -> L13
        Runnable r = new PackageInstallerSession$$ExternalSyntheticLambda3(this);     // Catch: Throwable -> L13
        if (this.mStageDirInUse == false) goto L20;
        this.mPendingAbandonCallback = r;     // Catch: Throwable -> L13
        this.mCallback.onSessionChanged(this);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L13
        long token = Binder.clearCallingIdentity();
        r.run();     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(token);
        return;
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mPerfBoostInstall == null) goto L7;
        this.mPerfBoostInstall.perfLockRelease();
        this.mIsPerfLockAcquired = false;
        goto L7
    }

    private /* synthetic */ void lambda$abandon$8() {
        assertNotLocked("abandonStaged");
        if (isStaged() == true) goto L5;
    L7:
        destroy("Session was abandoned");
        dispatchSessionFinished(-115, "Session was abandoned", null);
        maybeFinishChildSessions(-115, "Session was abandoned because the parent session is abandoned");
        return;
    L5:
        if (isCommitted() == false) goto L7;
        this.mStagingManager.abortCommittedSession(this.mStagedSession);
        goto L7
    }

    public boolean isMultiPackage() {
        return this.params.isMultiPackage;
    }

    public boolean isStaged() {
        return this.params.isStaged;
    }

    public int getInstallFlags() {
        return this.params.installFlags;
    }

    public DataLoaderParamsParcel getDataLoaderParams() {
        getDataLoaderParams_enforcePermission();
        if (this.params.dataLoaderParams != null) goto L7;
        return null;
    L7:
        return this.params.dataLoaderParams.getData();
    }

    public void addFile(int location, String name, long lengthBytes, byte[] metadata, byte[] signature) {
        addFile_enforcePermission();
        if (isDataLoaderInstallation() == false) goto L30;
        if (isStreamingInstallation() == false) goto L10;
        if (location == 0) goto L10;
        throw new IllegalArgumentException("Non-incremental installation only supports /data/app placement: " + name);
    L10:
        if (metadata == null) goto L28;
        if (FileUtils.isValidExtFilename(name) == false) goto L26;
        Object r1 = this.mLock;
        monitor-enter(r1);
        assertCallerIsOwnerOrRoot();     // Catch: Throwable -> L19
        assertPreparedAndNotSealedLocked("addFile");     // Catch: Throwable -> L19
        if (this.mFiles.add(new FileEntry(this.mFiles.size(), new InstallationFile(location, name, lengthBytes, metadata, signature))) == false) goto L22;
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L22:
        throw new IllegalArgumentException("File already added: " + name);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L26:
        throw new IllegalArgumentException("Invalid name: " + name);
    L28:
        throw new IllegalArgumentException("DataLoader installation requires valid metadata: " + name);
    L30:
        throw new IllegalStateException("Cannot add files to non-data loader installation session.");
    }

    public void removeFile(int location, String name) {
        removeFile_enforcePermission();
        if (isDataLoaderInstallation() == false) goto L25;
        if (TextUtils.isEmpty(this.params.appPackageName) == true) goto L23;
        Object r1 = this.mLock;
        monitor-enter(r1);
        assertCallerIsOwnerOrRoot();     // Catch: Throwable -> L18
        assertPreparedAndNotSealedLocked("removeFile");     // Catch: Throwable -> L18
        if (this.mFiles.add(new FileEntry(this.mFiles.size(), new InstallationFile(location, getRemoveMarkerName(name), -1, null, null))) == false) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L17:
        throw new IllegalArgumentException("File already removed: " + name);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Throwable r12 = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw r12;
    L18:
        th = move-exception;
        r12 = th;
        goto L20
    L23:
        throw new IllegalStateException("Must specify package name to remove a split");
    L25:
        throw new IllegalStateException("Cannot add files to non-data loader installation session.");
    }

    private boolean prepareDataLoaderLocked() throws PackageManagerException {
        if (isDataLoaderInstallation() == true) goto L6;
        return true;
    L6:
        if (this.mDataLoaderFinished == false) goto L8;
        return true;
    L8:
        final List<InstallationFileParcel> addedFiles = new ArrayList();
        final List<String> removedFiles = new ArrayList();
        InstallationFile[] files = getInstallationFilesLocked();
        int r0 = files.length;
        int r3 = 0;
    L9:
        if (r3 >= r0) goto L17;
        InstallationFile file = files[r3];
        if (sAddedFilter.accept(new File(this.stageDir, file.getName())) == false) goto L14;
        addedFiles.add(file.getData());
    L16:
        r3 = r3 + 1;
        goto L9
    L14:
        if (sRemovedFilter.accept(new File(this.stageDir, file.getName())) == false) goto L16;
        String name = file.getName().substring(0, file.getName().length() - REMOVE_MARKER_EXTENSION.length());
        removedFiles.add(name);
        goto L16
    L17:
        final DataLoaderParams params = this.params.dataLoaderParams;
        final boolean manualStartAndDestroy = !isIncrementalInstallation();
        final boolean systemDataLoader = isSystemDataLoaderInstallation();
        IDataLoaderStatusListener.Stub r1 = new AnonymousClass8(this, systemDataLoader, manualStartAndDestroy, addedFiles, params, removedFiles);
        if (manualStartAndDestroy == true) goto L63;
        PerUidReadTimeouts[] perUidReadTimeouts = this.mPm.getPerUidReadTimeouts(this.mPm.snapshotComputer());
        StorageHealthCheckParams healthCheckParams = new StorageHealthCheckParams();
        healthCheckParams.blockedTimeoutMs = 2000;
        healthCheckParams.unhealthyTimeoutMs = INCREMENTAL_STORAGE_UNHEALTHY_TIMEOUT_MS;
        healthCheckParams.unhealthyMonitoringMs = 60000;
        IStorageHealthListener.Stub r11 = new AnonymousClass9(this, systemDataLoader);
        PackageInfo pkgInfo = this.mPm.snapshotComputer().getPackageInfo(this.params.appPackageName, 0, this.userId);     // Catch: IOException -> L58
        if (pkgInfo != null) goto L73;
    L28:
        File inheritedDir = null;
    L29:
        if (this.mIncrementalFileStorages == null) goto L75;
        int r2 = -20;
        boolean r16 = false;
        this.mIncrementalFileStorages.startLoading(params, r1, healthCheckParams, r11, perUidReadTimeouts);     // Catch: IOException -> L54
    L53:
        return r16;
    L54:
        e = e;
    L61:
        throw new PackageManagerException(r2, e.getMessage(), e.getCause());
    L56:
        e = e;
        goto L61
    L75:
        r2 = -20;
        r16 = false;
        this.mIncrementalFileStorages = IncrementalFileStorages.initialize(this.mContext, this.stageDir, inheritedDir, params, r1, healthCheckParams, r11, addedFiles, perUidReadTimeouts, new AnonymousClass10(this));     // Catch: IOException -> L40
    L40:
        e = e;
    L42:
        e = e;
    L44:
        e = e;
        r2 = -20;
    L46:
        e = e;
        r2 = -20;
        goto L61
    L73:
    L26:
        e = e;
        r2 = -20;
        goto L61
    L23:
        if (pkgInfo.applicationInfo == null) goto L28;
        inheritedDir = new File(pkgInfo.applicationInfo.getCodePath()).getParentFile();     // Catch: IOException -> L26
    L58:
        e = e;
        r2 = -20;
        goto L61
    L63:
        if (getDataLoaderManager().bindToDataLoader(this.sessionId, params.getData(), 0, r1) == false) goto L66;
        return false;
    L66:
        throw new PackageManagerException(-20, "Failed to initialize data loader");
    }

    private DataLoaderManager getDataLoaderManager() throws PackageManagerException {
        DataLoaderManager dataLoaderManager = (DataLoaderManager) this.mContext.getSystemService(DataLoaderManager.class);
        if (dataLoaderManager == null) goto L6;
        return dataLoaderManager;
    L6:
        throw new PackageManagerException(-20, "Failed to find data loader manager service");
    }

    private IDataLoader getDataLoader(int dataLoaderId) throws PackageManagerException {
        IDataLoader dataLoader = getDataLoaderManager().getDataLoader(dataLoaderId);
        if (dataLoader == null) goto L6;
        return dataLoader;
    L6:
        throw new PackageManagerException(-20, "Failure to obtain data loader");
    }

    private void dispatchSessionValidationFailure(int error, String detailMessage) {
        this.mHandler.obtainMessage(5, error, -1, detailMessage).sendToTarget();
    }

    private int[] getChildSessionIdsLocked() {
        int size = this.mChildSessions.size();
        if (size == 0) goto L5;
        int[] childSessionIds = new int[size];
        int i = 0;
    L7:
        if (i >= size) goto L10;
        childSessionIds[i] = this.mChildSessions.keyAt(i);
        i = i + 1;
        goto L7
    L10:
        return childSessionIds;
    L5:
        return EMPTY_CHILD_SESSION_ARRAY;
    }

    public int[] getChildSessionIds() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int[] r1 = getChildSessionIdsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean canBeAddedAsChild(int parentCandidate) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (hasParentSessionId() == false) goto L12;
        if (this.mParentSessionId == parentCandidate) goto L12;
    L16:
        boolean r1 = false;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        if (isCommitted() == true) goto L16;
        if (this.mDestroyed == true) goto L16;
        r1 = true;
        goto L17
    }

    private void acquireTransactionLock() {
        if (this.mTransactionLock.compareAndSet(false, true) == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Concurrent access not supported");
    }

    private void releaseTransactionLock() {
        this.mTransactionLock.compareAndSet(true, false);
    }

    public void addChildSessionId(int childSessionId) {
        if (this.params.isMultiPackage == false) goto L64;
        PackageInstallerSession childSession = this.mSessionProvider.getSession(childSessionId);
        if (childSession == null) goto L62;
        if (childSession.params.isMultiPackage == true) goto L60;
        if (this.params.isStaged != childSession.params.isStaged) goto L58;
        if (this.params.getEnableRollback() != childSession.params.getEnableRollback()) goto L56;
        boolean hasAPEX = true;
        if (containsApkSession() == false) goto L15;
    L18:
        boolean hasAPK = true;
    L20:
        if (sessionContains(new PackageInstallerSession$$ExternalSyntheticLambda9()) == true) goto L26;
        if (childSession.isApexSession() == true) goto L26;
        hasAPEX = false;
    L26:
        if (this.params.isStaged == true) goto L65;
        if (hasAPK == false) goto L65;
        if (hasAPEX == false) goto L65;
        throw new IllegalStateException("Mix of APK and APEX is not supported for non-staged multi-package session");
    L65:
        acquireTransactionLock();     // Catch: Throwable -> L49
        childSession.acquireTransactionLock();     // Catch: Throwable -> L49
        if (childSession.canBeAddedAsChild(this.sessionId) == false) goto L52;
        Object r3 = this.mLock;     // Catch: Throwable -> L49
        monitor-enter(r3);     // Catch: Throwable -> L49
        assertCallerIsOwnerOrRoot();     // Catch: Throwable -> L41
        assertPreparedAndNotSealedLocked("addChildSessionId");     // Catch: Throwable -> L41
        int indexOfSession = this.mChildSessions.indexOfKey(childSessionId);     // Catch: Throwable -> L41
        if (indexOfSession < 0) goto L43;
        monitor-exit(r3);     // Catch: Throwable -> L41
        releaseTransactionLock();
        childSession.releaseTransactionLock();
        return;
    L43:
        childSession.setParentSessionId(this.sessionId);     // Catch: Throwable -> L41
        this.mChildSessions.put(childSessionId, childSession);     // Catch: Throwable -> L41
        monitor-exit(r3);     // Catch: Throwable -> L41
        releaseTransactionLock();
        childSession.releaseTransactionLock();
        return;
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L52:
        throw new IllegalStateException("Unable to add child session " + childSessionId + " as it is in an invalid state.");     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        releaseTransactionLock();
        childSession.releaseTransactionLock();
        throw th;
    L15:
        if (childSession.isApexSession() == false) goto L18;
        hasAPK = false;
        goto L20
    L56:
        throw new IllegalStateException("Multipackage Inconsistency: session " + childSession.sessionId + " and session " + this.sessionId + " have inconsistent rollback settings");
    L58:
        throw new IllegalStateException("Multipackage Inconsistency: session " + childSession.sessionId + " and session " + this.sessionId + " have inconsistent staged settings");
    L60:
        throw new IllegalStateException("Multi-session " + childSessionId + " can't be a child.");
    L62:
        throw new IllegalStateException("Unable to add child session " + childSessionId + " as it does not exist.");
    L64:
        throw new IllegalStateException("Single-session " + this.sessionId + " can't have child.");
    }

    private static /* synthetic */ boolean lambda$addChildSessionId$9(PackageInstallerSession s) {
        return s.isApexSession();
    }

    public void removeChildSessionId(int sessionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertCallerIsOwnerOrRoot();     // Catch: Throwable -> L8
        assertPreparedAndNotSealedLocked("removeChildSessionId");     // Catch: Throwable -> L8
        int indexOfSession = this.mChildSessions.indexOfKey(sessionId);     // Catch: Throwable -> L8
        if (indexOfSession >= 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        PackageInstallerSession session = this.mChildSessions.valueAt(indexOfSession);     // Catch: Throwable -> L8
        acquireTransactionLock();     // Catch: Throwable -> L15
        session.acquireTransactionLock();     // Catch: Throwable -> L15
        session.setParentSessionId(-1);     // Catch: Throwable -> L15
        this.mChildSessions.removeAt(indexOfSession);     // Catch: Throwable -> L15
        releaseTransactionLock();     // Catch: Throwable -> L8
        session.releaseTransactionLock();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        th = move-exception;
        releaseTransactionLock();     // Catch: Throwable -> L8
        session.releaseTransactionLock();     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    void setParentSessionId(int parentSessionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (parentSessionId == (-1)) goto L13;
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mParentSessionId == (-1)) goto L13;
        throw new IllegalStateException("The parent of " + this.sessionId + " is alreadyset to " + this.mParentSessionId);     // Catch: Throwable -> L11
    L13:
        this.mParentSessionId = parentSessionId;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    boolean hasParentSessionId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mParentSessionId == (-1)) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public int getParentSessionId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mParentSessionId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void dispatchSessionFinished(int returnCode, String msg, Bundle extras) {
        boolean isNewInstall = false;
        if (isPreapprovalRequested() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        sendUpdateToRemoteStatusReceiver(returnCode, msg, extras, r0);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mFinalStatus = returnCode;     // Catch: Throwable -> L28
        this.mFinalMessage = msg;     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        if (returnCode != 1) goto L14;
        boolean success = true;
    L15:
        if (extras != null) goto L17;
    L18:
        isNewInstall = true;
    L19:
        if (success == false) goto L24;
        if (isNewInstall == false) goto L24;
        if (this.mPm.mInstallerService.okToSendBroadcasts() == false) goto L24;
        this.mPm.sendSessionCommitBroadcast(generateInfoScrubbed(true), this.userId);
    L24:
        this.mCallback.onSessionFinished(this, success);
        if (isDataLoaderInstallation() == false) goto L33;
        logDataLoaderInstallationSession(returnCode);
        return;
    L33:
        return;
    L17:
        if (extras.getBoolean("android.intent.extra.REPLACING") == true) goto L19;
    L14:
        success = false;
    L28:
        th = move-exception;
        throw th;
    L5:
        if (isCommitted() == true) goto L7;
        r0 = true;
        goto L8
    }

    private void sendUpdateToRemoteStatusReceiver(int returnCode, String msg, Bundle extras, boolean forPreapproval) {
        if (forPreapproval == false) goto L4;
        IntentSender statusReceiver = getPreapprovalRemoteStatusReceiver();
    L6:
        if (statusReceiver == null) goto L15;
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = getPackageName();
        args.arg2 = msg;
        args.arg3 = extras;
        args.arg4 = statusReceiver;
        args.argi1 = returnCode;
        if (isPreapprovalRequested() == true) goto L10;
    L12:
        int r2 = 0;
    L13:
        args.argi2 = r2;
        this.mHandler.obtainMessage(4, args).sendToTarget();
        return;
    L10:
        if (isCommitted() == true) goto L12;
        r2 = 1;
        goto L13
    L15:
        return;
    L4:
        statusReceiver = getRemoteStatusReceiver();
        goto L6
    }

    private void dispatchSessionPreapproved() {
        IntentSender target = getPreapprovalRemoteStatusReceiver();
        Intent intent = new Intent();
        intent.putExtra("android.content.pm.extra.SESSION_ID", this.sessionId);
        intent.putExtra("android.content.pm.extra.STATUS", 0);
        intent.putExtra("android.content.pm.extra.PRE_APPROVAL", true);
        BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L5
        options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L5
        target.sendIntent(this.mContext, 0, intent, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L5
        return;
    }

    public void requestUserPreapproval(PackageInstaller.PreapprovalDetails details, IntentSender statusReceiver) {
        validatePreapprovalRequest(details, statusReceiver);
        if (PackageManagerService.isPreapprovalRequestAvailable() == true) goto L6;
        sendUpdateToRemoteStatusReceiver(-129, "Request user pre-approval is currently not available.", null, true);
        return;
    L6:
        dispatchPreapprovalRequest();
    }

    private void validatePreapprovalRequest(PackageInstaller.PreapprovalDetails details, IntentSender statusReceiver) {
        assertCallerIsOwnerOrRoot();
        if (isMultiPackage() == true) goto L16;
        if (statusReceiver == null) goto L14;
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertPreparedAndNotSealedLocked("request of session " + this.sessionId);     // Catch: Throwable -> L10
        this.mPreapprovalDetails = details;     // Catch: Throwable -> L10
        setPreapprovalRemoteStatusReceiver(statusReceiver);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalArgumentException("Status receiver cannot be null.");
    L16:
        throw new IllegalStateException("Session " + this.sessionId + " is a parent of multi-package session and requestUserPreapproval on the parent session isn't supported.");
    }

    private void dispatchPreapprovalRequest() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertPreparedAndNotPreapprovalRequestedLocked("dispatchPreapprovalRequest");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        markAsPreapprovalRequested();
        this.mHandler.obtainMessage(6).sendToTarget();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void markAsPreapprovalRequested() {
        this.mPreapprovalRequested.set(true);
    }

    public boolean isApplicationEnabledSettingPersistent() {
        return this.params.applicationEnabledSettingPersistent;
    }

    public boolean isRequestUpdateOwnership() {
        if ((this.params.installFlags & 33554432) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setPreVerifiedDomains(DomainSet preVerifiedDomains) {
        if (this.mInstallerUid != 0) goto L5;
    L8:
        boolean exemptFromPermissionChecks = true;
    L9:
        if (exemptFromPermissionChecks == true) goto L23;
        Computer snapshot = this.mPm.snapshotComputer();
        if (snapshot.checkUidPermission("android.permission.ACCESS_INSTANT_APPS", this.mInstallerUid) != 0) goto L22;
        ComponentName instantAppInstallerComponent = snapshot.getInstantAppInstallerComponent();
        if (instantAppInstallerComponent == null) goto L20;
        if (instantAppInstallerComponent.getPackageName().equals(getInstallerPackageName()) == true) goto L23;
        throw new SecurityException("Only the instant app installer can call this API.");
    L20:
        throw new IllegalStateException("Instant app installer is not available. Only the instant app installer can call this API.");
    L22:
        throw new SecurityException("You need android.permission.ACCESS_INSTANT_APPS permission to set pre-verified domains.");
    L23:
        long preVerifiedDomainsCountLimit = getPreVerifiedDomainsCountLimit();
        if (preVerifiedDomains.getDomains().size() > preVerifiedDomainsCountLimit) goto L42;
        long preVerifiedDomainLengthLimit = getPreVerifiedDomainLengthLimit();
        Iterator r5 = preVerifiedDomains.getDomains().iterator();
    L27:
        if (r5.hasNext() == false) goto L33;
        String domain = (String) r5.next();
        if (domain.length() <= preVerifiedDomainLengthLimit) goto L27;
        throw new IllegalArgumentException("Pre-verified domain: [" + domain + " ] exceeds maximum length allowed: " + preVerifiedDomainLengthLimit);
    L33:
        Object r6 = this.mLock;
        monitor-enter(r6);
        assertCallerIsOwnerOrRoot();     // Catch: Throwable -> L38
        assertPreparedAndNotSealedLocked("setPreVerifiedDomains");     // Catch: Throwable -> L38
        this.mPreVerifiedDomains = preVerifiedDomains;     // Catch: Throwable -> L38
        monitor-exit(r6);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        throw th;
    L42:
        throw new IllegalArgumentException("The number of pre-verified domains have exceeded the maximum of " + preVerifiedDomainsCountLimit);
    L5:
        if (this.mInstallerUid == 2000) goto L8;
        exemptFromPermissionChecks = false;
        goto L9
    }

    private static long getPreVerifiedDomainsCountLimit() {
        long token = Binder.clearCallingIdentity();
        long r2 = DeviceConfig.getLong("package_manager_service", PROPERTY_PRE_VERIFIED_DOMAINS_COUNT_LIMIT, 1000);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private static long getPreVerifiedDomainLengthLimit() {
        long token = Binder.clearCallingIdentity();
        long r2 = DeviceConfig.getLong("package_manager_service", PROPERTY_PRE_VERIFIED_DOMAIN_LENGTH_LIMIT, 256);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public DomainSet getPreVerifiedDomains() {
        assertCallerIsOwnerOrRoot();
        Object r0 = this.mLock;
        monitor-enter(r0);
        assertPreparedAndNotCommittedOrDestroyedLocked("getPreVerifiedDomains");     // Catch: Throwable -> L7
        DomainSet r1 = this.mPreVerifiedDomains;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setSessionReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == true) goto L15;
        if (this.mSessionFailed == true) goto L15;
        this.mSessionReady = true;     // Catch: Throwable -> L13
        this.mSessionApplied = false;     // Catch: Throwable -> L13
        this.mSessionFailed = false;     // Catch: Throwable -> L13
        this.mSessionErrorCode = 0;     // Catch: Throwable -> L13
        this.mSessionErrorMessage = "";     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        this.mCallback.onSessionChanged(this);
        return;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    void setSessionFailed(int errorCode, String errorMessage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == true) goto L15;
        if (this.mSessionFailed == true) goto L15;
        this.mSessionReady = false;     // Catch: Throwable -> L13
        this.mSessionApplied = false;     // Catch: Throwable -> L13
        this.mSessionFailed = true;     // Catch: Throwable -> L13
        this.mSessionErrorCode = errorCode;     // Catch: Throwable -> L13
        this.mSessionErrorMessage = errorMessage;     // Catch: Throwable -> L13
        Slog.d(TAG, "Marking session " + this.sessionId + " as failed: " + errorMessage);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        destroy("Session marked as failed: " + errorMessage);
        this.mCallback.onSessionChanged(this);
        return;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private void setSessionApplied() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == true) goto L15;
        if (this.mSessionFailed == true) goto L15;
        this.mSessionReady = false;     // Catch: Throwable -> L13
        this.mSessionApplied = true;     // Catch: Throwable -> L13
        this.mSessionFailed = false;     // Catch: Throwable -> L13
        this.mSessionErrorCode = 1;     // Catch: Throwable -> L13
        this.mSessionErrorMessage = "";     // Catch: Throwable -> L13
        Slog.d(TAG, "Marking session " + this.sessionId + " as applied");     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        destroy(null);
        this.mCallback.onSessionChanged(this);
        return;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    boolean isSessionReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mSessionReady;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isSessionApplied() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mSessionApplied;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isSessionFailed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mSessionFailed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int getSessionErrorCode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mSessionErrorCode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    String getSessionErrorMessage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mSessionErrorMessage;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void registerUnarchivalListener(IntentSender intentSender) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUnarchivalListeners.add(intentSender);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Set<IntentSender> getUnarchivalListeners() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet r1 = new ArraySet(this.mUnarchivalListeners);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void reportUnarchivalStatus(final int status, int unarchiveId, final long requiredStorageBytes, final PendingIntent userActionIntent) {
        if (getUnarchivalStatus() != (-1)) goto L9;
        this.mUnarchivalStatus = status;
        this.mPm.mHandler.post(new PackageInstallerSession$$ExternalSyntheticLambda6(this, status, requiredStorageBytes, userActionIntent));
        if (status == 0) goto L10;
        Binder.withCleanCallingIdentity(new PackageInstallerSession$$ExternalSyntheticLambda7(this));
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException(TextUtils.formatSimple("Unarchival status for ID %s has already been set or a session has been created for it already by the caller.", new Object[]{Integer.valueOf(unarchiveId)}));
    }

    private /* synthetic */ void lambda$reportUnarchivalStatus$10(int status, long requiredStorageBytes, PendingIntent userActionIntent) {
        this.mPm.mInstallerService.mPackageArchiver.notifyUnarchivalListener(status, getInstallerPackageName(), this.params.appPackageName, requiredStorageBytes, userActionIntent, getUnarchivalListeners(), this.userId);
    }

    int getUnarchivalStatus() {
        return this.mUnarchivalStatus;
    }

    private void destroy(String reason) {
        destroyInternal(reason);
        Iterator<PackageInstallerSession> r0 = getChildSessions().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PackageInstallerSession child = r0.next();
        child.destroyInternal(reason);
        goto L4
    }

    private void destroyInternal(String reason) {
        if (reason == null) goto L4;
        Slog.i(TAG, "Session [" + this.sessionId + "] was destroyed because of [" + reason + "]");
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSealed = true;     // Catch: Throwable -> L10
        if (this.params.isStaged == true) goto L12;
        this.mDestroyed = true;     // Catch: Throwable -> L10
    L12:
        Iterator<RevocableFileDescriptor> r1 = this.mFds.iterator();     // Catch: Throwable -> L10
    L14:
        if (r1.hasNext() == false) goto L16;
        RevocableFileDescriptor fd = r1.next();     // Catch: Throwable -> L10
        fd.revoke();     // Catch: Throwable -> L10
        goto L14
    L16:
        Iterator<FileBridge> r2 = this.mBridges.iterator();     // Catch: Throwable -> L10
    L18:
        if (r2.hasNext() == false) goto L20;
        FileBridge bridge = r2.next();     // Catch: Throwable -> L10
        bridge.forceClose();     // Catch: Throwable -> L10
        goto L18
    L20:
        IncrementalFileStorages incrementalFileStorages = this.mIncrementalFileStorages;     // Catch: Throwable -> L10
        this.mIncrementalFileStorages = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (incrementalFileStorages == null) goto L27;
        incrementalFileStorages.cleanUpAndMarkComplete();     // Catch: Installer.InstallerException -> L24
    L30:
        return;
    L27:
        if (this.stageDir == null) goto L40;
        String tempPackageName = this.stageDir.getName();     // Catch: Installer.InstallerException -> L24
        this.mInstaller.rmPackageDir(tempPackageName, this.stageDir.getAbsolutePath());     // Catch: Installer.InstallerException -> L24
        return;
    L40:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        dumpLocked(pw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void dumpLocked(IndentingPrintWriter pw) {
        pw.println("Session " + this.sessionId + ":");
        pw.increaseIndent();
        pw.printPair("userId", Integer.valueOf(this.userId));
        pw.printPair("mOriginalInstallerUid", Integer.valueOf(this.mOriginalInstallerUid));
        pw.printPair("mOriginalInstallerPackageName", this.mOriginalInstallerPackageName);
        pw.printPair(ATTR_INSTALLER_PACKAGE_NAME, this.mInstallSource.mInstallerPackageName);
        pw.printPair(ATTR_INITIATING_PACKAGE_NAME, this.mInstallSource.mInitiatingPackageName);
        pw.printPair(ATTR_ORIGINATING_PACKAGE_NAME, this.mInstallSource.mOriginatingPackageName);
        pw.printPair("mInstallerUid", Integer.valueOf(this.mInstallerUid));
        pw.printPair(ATTR_CREATED_MILLIS, Long.valueOf(this.createdMillis));
        pw.printPair(ATTR_UPDATED_MILLIS, Long.valueOf(this.updatedMillis));
        pw.printPair(ATTR_COMMITTED_MILLIS, Long.valueOf(this.committedMillis));
        pw.printPair("stageDir", this.stageDir);
        pw.printPair("stageCid", this.stageCid);
        pw.println();
        this.params.dump(pw);
        Object r0 = this.mProgressLock;
        monitor-enter(r0);
        float clientProgress = this.mClientProgress;     // Catch: Throwable -> L11
        float progress = this.mProgress;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        pw.printPair("mClientProgress", Float.valueOf(clientProgress));
        pw.printPair("mProgress", Float.valueOf(progress));
        pw.printPair("mCommitted", this.mCommitted);
        pw.printPair("mPreapprovalRequested", this.mPreapprovalRequested);
        pw.printPair("mSealed", Boolean.valueOf(this.mSealed));
        pw.printPair("mPermissionsManuallyAccepted", Boolean.valueOf(this.mPermissionsManuallyAccepted));
        pw.printPair("mStageDirInUse", Boolean.valueOf(this.mStageDirInUse));
        pw.printPair("mDestroyed", Boolean.valueOf(this.mDestroyed));
        pw.printPair("mFds", Integer.valueOf(this.mFds.size()));
        pw.printPair("mBridges", Integer.valueOf(this.mBridges.size()));
        pw.printPair("mFinalStatus", Integer.valueOf(this.mFinalStatus));
        pw.printPair("mFinalMessage", this.mFinalMessage);
        pw.printPair("params.isMultiPackage", Boolean.valueOf(this.params.isMultiPackage));
        pw.printPair("params.isStaged", Boolean.valueOf(this.params.isStaged));
        pw.printPair("mParentSessionId", Integer.valueOf(this.mParentSessionId));
        pw.printPair("mChildSessionIds", getChildSessionIdsLocked());
        pw.printPair("mSessionApplied", Boolean.valueOf(this.mSessionApplied));
        pw.printPair("mSessionFailed", Boolean.valueOf(this.mSessionFailed));
        pw.printPair("mSessionReady", Boolean.valueOf(this.mSessionReady));
        pw.printPair("mSessionErrorCode", Integer.valueOf(this.mSessionErrorCode));
        pw.printPair("mSessionErrorMessage", this.mSessionErrorMessage);
        pw.printPair("mPreapprovalDetails", this.mPreapprovalDetails);
        if (this.mPreVerifiedDomains == null) goto L9;
        pw.printPair("mPreVerifiedDomains", this.mPreVerifiedDomains);
    L9:
        pw.println();
        pw.decreaseIndent();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static void sendOnUserActionRequired(Context context, IntentSender target, int sessionId, Intent intent) {
        if (target != null) goto L5;
        Slog.e(TAG, "Missing receiver for pending user action.");
        return;
    L5:
        Intent fillIn = new Intent();
        fillIn.putExtra("android.content.pm.extra.SESSION_ID", sessionId);
        fillIn.putExtra("android.content.pm.extra.STATUS", -1);
        fillIn.putExtra("android.content.pm.extra.PRE_APPROVAL", "android.content.pm.action.CONFIRM_PRE_APPROVAL".equals(intent.getAction()));
        fillIn.putExtra("android.intent.extra.INTENT", intent);
        BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L12
        options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L12
        target.sendIntent(context, 0, fillIn, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L10
        return;
    L20:
        return;
    }

    private static void sendOnPackageInstalled(Context context, IntentSender target, int sessionId, boolean showNotification, int userId, String basePackageName, int returnCode, boolean isPreapproval, String msg, Bundle extras) {
        boolean update = true;
        if (1 != returnCode) goto L14;
        if (showNotification == false) goto L14;
        if (extras != null) goto L7;
    L9:
        update = false;
    L10:
        Notification notification = PackageInstallerService.buildSuccessNotification(context, getDeviceOwnerInstalledPackageMsg(context, update), basePackageName, userId);
        if (notification == null) goto L14;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.notify(basePackageName, 21, notification);
        goto L14
    L7:
        if (extras.getBoolean("android.intent.extra.REPLACING") == false) goto L9;
    L14:
        Intent fillIn = new Intent();
        fillIn.putExtra("android.content.pm.extra.PACKAGE_NAME", basePackageName);
        fillIn.putExtra("android.content.pm.extra.SESSION_ID", sessionId);
        fillIn.putExtra("android.content.pm.extra.STATUS", PackageManager.installStatusToPublicStatus(returnCode));
        fillIn.putExtra("android.content.pm.extra.STATUS_MESSAGE", PackageManager.installStatusToString(returnCode, msg));
        fillIn.putExtra("android.content.pm.extra.LEGACY_STATUS", returnCode);
        fillIn.putExtra("android.content.pm.extra.PRE_APPROVAL", isPreapproval);
        if (extras == null) goto L26;
        String existing = extras.getString("android.content.pm.extra.FAILURE_EXISTING_PACKAGE");
        if (TextUtils.isEmpty(existing) == true) goto L19;
        fillIn.putExtra("android.content.pm.extra.OTHER_PACKAGE_NAME", existing);
    L19:
        ArrayList<String> warnings = extras.getStringArrayList("android.content.pm.extra.WARNINGS");
        if (ArrayUtils.isEmpty(warnings) == true) goto L26;
        fillIn.putStringArrayListExtra("android.content.pm.extra.WARNINGS", warnings);
    L26:
        BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L24
        options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L24
        target.sendIntent(context, 0, fillIn, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L24
        return;
    }

    private static String getDeviceOwnerInstalledPackageMsg(final Context context, boolean update) {
        DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        if (update == false) goto L6;
        return dpm.getResources().getString("Core.PACKAGE_UPDATED_BY_DO", new PackageInstallerSession$$ExternalSyntheticLambda1(context));
    L6:
        return dpm.getResources().getString("Core.PACKAGE_INSTALLED_BY_DO", new PackageInstallerSession$$ExternalSyntheticLambda2(context));
    }

    private static /* synthetic */ String lambda$getDeviceOwnerInstalledPackageMsg$11(Context context) {
        return context.getString(R.string.permdesc_uwb_ranging);
    }

    private static /* synthetic */ String lambda$getDeviceOwnerInstalledPackageMsg$12(Context context) {
        return context.getString(R.string.permdesc_use_sip);
    }

    private static void sendPendingStreaming(Context context, IntentSender target, int sessionId, String cause) {
        if (target != null) goto L5;
        Slog.e(TAG, "Missing receiver for pending streaming status.");
        return;
    L5:
        Intent intent = new Intent();
        intent.putExtra("android.content.pm.extra.SESSION_ID", sessionId);
        intent.putExtra("android.content.pm.extra.STATUS", -2);
        if (TextUtils.isEmpty(cause) == true) goto L8;
        intent.putExtra("android.content.pm.extra.STATUS_MESSAGE", "Staging Image Not Ready [" + cause + "]");
    L20:
        BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L15
        options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L15
        target.sendIntent(context, 0, intent, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L13
        return;
    L23:
        return;
    L17:
        return;
    L8:
        intent.putExtra("android.content.pm.extra.STATUS_MESSAGE", "Staging Image Not Ready");
        goto L20
    }

    private static void writePermissionsLocked(TypedXmlSerializer out, PackageInstaller.SessionParams params) throws IOException {
        ArrayMap<String, Integer> permissionStates = params.getPermissionStates();
        int index = 0;
    L4:
        if (index >= permissionStates.size()) goto L11;
        String permissionName = permissionStates.keyAt(index);
        Integer state = permissionStates.valueAt(index);
        if (state.intValue() != 1) goto L8;
        String tag = TAG_GRANT_PERMISSION;
    L9:
        out.startTag(null, tag);
        XmlUtils.writeStringAttribute(out, "name", permissionName);
        out.endTag(null, tag);
        index = index + 1;
        goto L4
    L8:
        tag = TAG_DENY_PERMISSION;
        goto L9
    }

    private static void writeWhitelistedRestrictedPermissionsLocked(TypedXmlSerializer out, List<String> whitelistedRestrictedPermissions) throws IOException {
        if (whitelistedRestrictedPermissions == null) goto L6;
        int permissionCount = whitelistedRestrictedPermissions.size();
        int i = 0;
    L4:
        if (i >= permissionCount) goto L8;
        out.startTag(null, TAG_WHITELISTED_RESTRICTED_PERMISSION);
        XmlUtils.writeStringAttribute(out, "name", whitelistedRestrictedPermissions.get(i));
        out.endTag(null, TAG_WHITELISTED_RESTRICTED_PERMISSION);
        i = i + 1;
        goto L4
    L8:
        return;
    }

    private static void writeAutoRevokePermissionsMode(TypedXmlSerializer out, int mode) throws IOException {
        out.startTag(null, TAG_AUTO_REVOKE_PERMISSIONS_MODE);
        out.attributeInt(null, "mode", mode);
        out.endTag(null, TAG_AUTO_REVOKE_PERMISSIONS_MODE);
    }

    private static File buildAppIconFile(int sessionId, File sessionsDir) {
        return new File(sessionsDir, "app_icon." + sessionId + ".png");
    }

    void write(TypedXmlSerializer out, File sessionsDir) throws IOException {
        Object r3 = this.mLock;
        monitor-enter(r3);
    L32:
        th = th;
    L81:
        monitor-exit(r3);     // Catch: Throwable -> L32
        throw th;
    L10:
        th = th;
        goto L81
    L5:
        if (this.mDestroyed == true) goto L7;
    L12:
        out.startTag(null, TAG_SESSION);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_SESSION_ID, this.sessionId);     // Catch: Throwable -> L10
        out.attributeInt(null, "userId", this.userId);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_INSTALLER_PACKAGE_NAME, this.mInstallSource.mInstallerPackageName);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_INSTALLER_PACKAGE_UID, this.mInstallSource.mInstallerPackageUid);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_UPDATE_OWNER_PACKAGE_NAME, this.mInstallSource.mUpdateOwnerPackageName);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_INSTALLER_ATTRIBUTION_TAG, this.mInstallSource.mInstallerAttributionTag);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_INSTALLER_UID, this.mInstallerUid);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_INITIATING_PACKAGE_NAME, this.mInstallSource.mInitiatingPackageName);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_ORIGINATING_PACKAGE_NAME, this.mInstallSource.mOriginatingPackageName);     // Catch: Throwable -> L10
        out.attributeLong(null, ATTR_CREATED_MILLIS, this.createdMillis);     // Catch: Throwable -> L10
        out.attributeLong(null, ATTR_UPDATED_MILLIS, this.updatedMillis);     // Catch: Throwable -> L10
        out.attributeLong(null, ATTR_COMMITTED_MILLIS, this.committedMillis);     // Catch: Throwable -> L10
        if (this.stageDir == null) goto L16;
        XmlUtils.writeStringAttribute(out, ATTR_SESSION_STAGE_DIR, this.stageDir.getAbsolutePath());     // Catch: Throwable -> L10
    L16:
        if (this.stageCid == null) goto L18;
        XmlUtils.writeStringAttribute(out, ATTR_SESSION_STAGE_CID, this.stageCid);     // Catch: Throwable -> L10
    L18:
        XmlUtils.writeBooleanAttribute(out, ATTR_PREPARED, this.mPrepared);     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_COMMITTED, isCommitted());     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_DESTROYED, this.mDestroyed);     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_SEALED, this.mSealed);     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_MULTI_PACKAGE, this.params.isMultiPackage);     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_STAGED_SESSION, this.params.isStaged);     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_IS_READY, this.mSessionReady);     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_IS_FAILED, this.mSessionFailed);     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_IS_APPLIED, this.mSessionApplied);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_PACKAGE_SOURCE, this.params.packageSource);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_SESSION_ERROR_CODE, this.mSessionErrorCode);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_SESSION_ERROR_MESSAGE, this.mSessionErrorMessage);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_PARENT_SESSION_ID, this.mParentSessionId);     // Catch: Throwable -> L10
        out.attributeInt(null, "mode", this.params.mode);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_INSTALL_FLAGS, this.params.installFlags);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_INSTALL_LOCATION, this.params.installLocation);     // Catch: Throwable -> L10
        out.attributeLong(null, ATTR_SIZE_BYTES, this.params.sizeBytes);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_APP_PACKAGE_NAME, this.params.appPackageName);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_APP_LABEL, this.params.appLabel);     // Catch: Throwable -> L10
        XmlUtils.writeUriAttribute(out, ATTR_ORIGINATING_URI, this.params.originatingUri);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_ORIGINATING_UID, this.params.originatingUid);     // Catch: Throwable -> L10
        XmlUtils.writeUriAttribute(out, ATTR_REFERRER_URI, this.params.referrerUri);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_ABI_OVERRIDE, this.params.abiOverride);     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_VOLUME_UUID, this.params.volumeUuid);     // Catch: Throwable -> L10
        out.attributeInt(null, ATTR_INSTALL_REASON, this.params.installReason);     // Catch: Throwable -> L10
        XmlUtils.writeBooleanAttribute(out, ATTR_APPLICATION_ENABLED_SETTING_PERSISTENT, this.params.applicationEnabledSettingPersistent);     // Catch: Throwable -> L10
        if (this.params.dataLoaderParams == null) goto L21;
        boolean r0 = true;
    L22:
        boolean isDataLoader = r0;
        XmlUtils.writeBooleanAttribute(out, ATTR_IS_DATALOADER, isDataLoader);     // Catch: Throwable -> L10
        if (isDataLoader == false) goto L25;
        out.attributeInt(null, ATTR_DATALOADER_TYPE, this.params.dataLoaderParams.getType());     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_DATALOADER_PACKAGE_NAME, this.params.dataLoaderParams.getComponentName().getPackageName());     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_DATALOADER_CLASS_NAME, this.params.dataLoaderParams.getComponentName().getClassName());     // Catch: Throwable -> L10
        XmlUtils.writeStringAttribute(out, ATTR_DATALOADER_ARGUMENTS, this.params.dataLoaderParams.getArguments());     // Catch: Throwable -> L10
    L25:
        writePermissionsLocked(out, this.params);     // Catch: Throwable -> L10
        writeWhitelistedRestrictedPermissionsLocked(out, this.params.whitelistedRestrictedPermissions);     // Catch: Throwable -> L10
        writeAutoRevokePermissionsMode(out, this.params.autoRevokePermissionsMode);     // Catch: Throwable -> L10
        File appIconFile = buildAppIconFile(this.sessionId, sessionsDir);     // Catch: Throwable -> L32
        if (this.params.appIcon != null) goto L35;
        if (appIconFile.exists() == false) goto L35;
        appIconFile.delete();     // Catch: Throwable -> L32
    L51:
        int[] childSessionIds = getChildSessionIdsLocked();     // Catch: Throwable -> L32
        int r9 = childSessionIds.length;     // Catch: Throwable -> L32
        int r10 = 0;
    L52:
        if (r10 >= r9) goto L54;
        int childSessionId = childSessionIds[r10];     // Catch: Throwable -> L32
        out.startTag(null, TAG_CHILD_SESSION);     // Catch: Throwable -> L32
        out.attributeInt(null, ATTR_SESSION_ID, childSessionId);     // Catch: Throwable -> L32
        out.endTag(null, TAG_CHILD_SESSION);     // Catch: Throwable -> L32
        r10 = r10 + 1;     // Catch: Throwable -> L32
        goto L52
    L54:
        InstallationFile[] files = getInstallationFilesLocked();     // Catch: Throwable -> L32
        int r11 = files.length;     // Catch: Throwable -> L32
        int r12 = 0;
    L55:
        if (r12 >= r11) goto L57;
        InstallationFile file = files[r12];     // Catch: Throwable -> L32
        out.startTag(null, TAG_SESSION_FILE);     // Catch: Throwable -> L32
        out.attributeInt(null, "location", file.getLocation());     // Catch: Throwable -> L32
        XmlUtils.writeStringAttribute(out, "name", file.getName());     // Catch: Throwable -> L32
        out.attributeLong(null, ATTR_LENGTH_BYTES, file.getLengthBytes());     // Catch: Throwable -> L32
        XmlUtils.writeByteArrayAttribute(out, ATTR_METADATA, file.getMetadata());     // Catch: Throwable -> L32
        XmlUtils.writeByteArrayAttribute(out, ATTR_SIGNATURE, file.getSignature());     // Catch: Throwable -> L32
        out.endTag(null, TAG_SESSION_FILE);     // Catch: Throwable -> L32
        r12 = r12 + 1;     // Catch: Throwable -> L32
        goto L55
    L57:
        int i = 0;
        int isize = this.mChecksums.size();     // Catch: Throwable -> L32
    L58:
        if (i >= isize) goto L63;
        String fileName = this.mChecksums.keyAt(i);     // Catch: Throwable -> L32
        PerFileChecksum perFileChecksum = this.mChecksums.valueAt(i);     // Catch: Throwable -> L32
        Checksum[] checksums = perFileChecksum.getChecksums();     // Catch: Throwable -> L32
        int r15 = checksums.length;     // Catch: Throwable -> L32
        int r5 = 0;
    L60:
        if (r5 >= r15) goto L62;
        Checksum checksum = checksums[r5];     // Catch: Throwable -> L32
        out.startTag(null, TAG_SESSION_CHECKSUM);     // Catch: Throwable -> L32
        XmlUtils.writeStringAttribute(out, "name", fileName);     // Catch: Throwable -> L32
        out.attributeInt(null, ATTR_CHECKSUM_KIND, checksum.getType());     // Catch: Throwable -> L32
        XmlUtils.writeByteArrayAttribute(out, ATTR_CHECKSUM_VALUE, checksum.getValue());     // Catch: Throwable -> L32
        out.endTag(null, TAG_SESSION_CHECKSUM);     // Catch: Throwable -> L32
        r5 = r5 + 1;     // Catch: Throwable -> L32
        isDataLoader = isDataLoader;
        goto L60
    L62:
        i = i + 1;     // Catch: Throwable -> L32
        goto L58
    L63:
        int i2 = 0;
        int isize2 = this.mChecksums.size();     // Catch: Throwable -> L32
    L64:
        if (i2 >= isize2) goto L73;
        String fileName2 = this.mChecksums.keyAt(i2);     // Catch: Throwable -> L32
        PerFileChecksum perFileChecksum2 = this.mChecksums.valueAt(i2);     // Catch: Throwable -> L32
        byte[] signature = perFileChecksum2.getSignature();     // Catch: Throwable -> L32
        if (signature == null) goto L71;
        if (signature.length == 0) goto L71;
        out.startTag(null, TAG_SESSION_CHECKSUM_SIGNATURE);     // Catch: Throwable -> L32
        XmlUtils.writeStringAttribute(out, "name", fileName2);     // Catch: Throwable -> L32
        XmlUtils.writeByteArrayAttribute(out, ATTR_SIGNATURE, signature);     // Catch: Throwable -> L32
        out.endTag(null, TAG_SESSION_CHECKSUM_SIGNATURE);     // Catch: Throwable -> L32
    L71:
        i2 = i2 + 1;     // Catch: Throwable -> L32
        goto L64
    L73:
        if (this.mPreVerifiedDomains == null) goto L78;
        Iterator r4 = this.mPreVerifiedDomains.getDomains().iterator();     // Catch: Throwable -> L32
    L76:
        if (r4.hasNext() == false) goto L78;
        String domain = (String) r4.next();     // Catch: Throwable -> L32
        out.startTag(null, TAG_PRE_VERIFIED_DOMAINS);     // Catch: Throwable -> L32
        XmlUtils.writeStringAttribute(out, "domain", domain);     // Catch: Throwable -> L32
        out.endTag(null, TAG_PRE_VERIFIED_DOMAINS);     // Catch: Throwable -> L32
    L78:
        monitor-exit(r3);     // Catch: Throwable -> L32
        out.endTag(null, TAG_SESSION);
        return;
    L35:
        if (this.params.appIcon == null) goto L51;
        if (appIconFile.lastModified() == this.params.appIconLastModified) goto L51;
        Slog.w(TAG, "Writing changed icon " + appIconFile);     // Catch: Throwable -> L32
        FileOutputStream os = null;
        os = new FileOutputStream(appIconFile);     // Catch: Throwable -> L43 IOException -> L45
        this.params.appIcon.compress(Bitmap.CompressFormat.PNG, 90, os);     // Catch: Throwable -> L43 IOException -> L45
    L41:
        IoUtils.closeQuietly(os);     // Catch: Throwable -> L32
        this.params.appIconLastModified = appIconFile.lastModified();     // Catch: Throwable -> L32
        goto L51
    L43:
        th = move-exception;
        IoUtils.closeQuietly(os);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L45:
        e = move-exception;
        Slog.w(TAG, "Failed to write icon " + appIconFile + ": " + e.getMessage());     // Catch: Throwable -> L43
        goto L41
    L21:
        r0 = false;
        goto L22
    L7:
        if (this.params.isStaged == true) goto L12;
        monitor-exit(r3);     // Catch: Throwable -> L10
    }

    private static boolean isStagedSessionStateValid(boolean isReady, boolean isApplied, boolean isFailed) {
        if (isReady == true) goto L5;
        if (isApplied == true) goto L5;
        if (isFailed == true) goto L5;
    L14:
        return true;
    L5:
        if (isReady == false) goto L8;
        if (isApplied == true) goto L8;
        if (isFailed == false) goto L14;
    L8:
        if (isReady == true) goto L11;
        if (isApplied == false) goto L11;
        if (isFailed == false) goto L14;
    L11:
        if (isReady == true) goto L15;
        if (isApplied == true) goto L15;
        if (isFailed == true) goto L14;
    L15:
        return false;
    }

    public static PackageInstallerSession readFromXml(TypedXmlPullParser in, PackageInstallerService.InternalCallback callback, Context context, PackageManagerService pm, Looper installerThread, StagingManager stagingManager, File sessionsDir, PackageSessionProvider sessionProvider, SilentUpdatePolicy silentUpdatePolicy, InstallDependencyHelper installDependencyHelper) throws IOException, XmlPullParserException {
        String r2 = ATTR_SESSION_ID;
        int sessionId = in.getAttributeInt(null, ATTR_SESSION_ID);
        int userId = in.getAttributeInt(null, "userId");
        String installerPackageName = XmlUtils.readStringAttribute(in, ATTR_INSTALLER_PACKAGE_NAME);
        int installPackageUid = in.getAttributeInt(null, ATTR_INSTALLER_PACKAGE_UID, -1);
        String updateOwnerPackageName = XmlUtils.readStringAttribute(in, ATTR_UPDATE_OWNER_PACKAGE_NAME);
        String installerAttributionTag = XmlUtils.readStringAttribute(in, ATTR_INSTALLER_ATTRIBUTION_TAG);
        int installerUid = in.getAttributeInt(null, ATTR_INSTALLER_UID, pm.snapshotComputer().getPackageUid(installerPackageName, 8192, userId));
        String installInitiatingPackageName = XmlUtils.readStringAttribute(in, ATTR_INITIATING_PACKAGE_NAME);
        String installOriginatingPackageName = XmlUtils.readStringAttribute(in, ATTR_ORIGINATING_PACKAGE_NAME);
        long createdMillis = in.getAttributeLong(null, ATTR_CREATED_MILLIS);
        in.getAttributeLong(null, ATTR_UPDATED_MILLIS);
        long committedMillis = in.getAttributeLong(null, ATTR_COMMITTED_MILLIS, 0);
        String stageDirRaw = XmlUtils.readStringAttribute(in, ATTR_SESSION_STAGE_DIR);
        if (stageDirRaw == null) goto L5;
        File stageDir = new File(stageDirRaw);
    L6:
        String stageCid = XmlUtils.readStringAttribute(in, ATTR_SESSION_STAGE_CID);
        boolean prepared = in.getAttributeBoolean(null, ATTR_PREPARED, true);
        boolean committed = in.getAttributeBoolean(null, ATTR_COMMITTED, false);
        boolean destroyed = in.getAttributeBoolean(null, ATTR_DESTROYED, false);
        boolean sealed = in.getAttributeBoolean(null, ATTR_SEALED, false);
        int parentSessionId = in.getAttributeInt(null, ATTR_PARENT_SESSION_ID, -1);
        PackageInstaller.SessionParams params = new PackageInstaller.SessionParams(-1);
        params.isMultiPackage = in.getAttributeBoolean(null, ATTR_MULTI_PACKAGE, false);
        params.isStaged = in.getAttributeBoolean(null, ATTR_STAGED_SESSION, false);
        params.mode = in.getAttributeInt(null, "mode");
        params.installFlags = in.getAttributeInt(null, ATTR_INSTALL_FLAGS);
        params.installLocation = in.getAttributeInt(null, ATTR_INSTALL_LOCATION);
        params.sizeBytes = in.getAttributeLong(null, ATTR_SIZE_BYTES);
        params.appPackageName = XmlUtils.readStringAttribute(in, ATTR_APP_PACKAGE_NAME);
        params.appIcon = XmlUtils.readBitmapAttribute(in, ATTR_APP_ICON);
        params.appLabel = XmlUtils.readStringAttribute(in, ATTR_APP_LABEL);
        params.originatingUri = XmlUtils.readUriAttribute(in, ATTR_ORIGINATING_URI);
        params.originatingUid = in.getAttributeInt(null, ATTR_ORIGINATING_UID, -1);
        params.referrerUri = XmlUtils.readUriAttribute(in, ATTR_REFERRER_URI);
        params.abiOverride = XmlUtils.readStringAttribute(in, ATTR_ABI_OVERRIDE);
        params.volumeUuid = XmlUtils.readStringAttribute(in, ATTR_VOLUME_UUID);
        params.installReason = in.getAttributeInt(null, ATTR_INSTALL_REASON);
        params.packageSource = in.getAttributeInt(null, ATTR_PACKAGE_SOURCE);
        params.applicationEnabledSettingPersistent = in.getAttributeBoolean(null, ATTR_APPLICATION_ENABLED_SETTING_PERSISTENT, false);
        if (in.getAttributeBoolean(null, ATTR_IS_DATALOADER, false) == false) goto L10;
        params.dataLoaderParams = new DataLoaderParams(in.getAttributeInt(null, ATTR_DATALOADER_TYPE), new ComponentName(XmlUtils.readStringAttribute(in, ATTR_DATALOADER_PACKAGE_NAME), XmlUtils.readStringAttribute(in, ATTR_DATALOADER_CLASS_NAME)), XmlUtils.readStringAttribute(in, ATTR_DATALOADER_ARGUMENTS));
    L10:
        File appIconFile = buildAppIconFile(sessionId, sessionsDir);
        if (appIconFile.exists() == false) goto L13;
        params.appIcon = BitmapFactory.decodeFile(appIconFile.getAbsolutePath());
        params.appIconLastModified = appIconFile.lastModified();
    L13:
        boolean isReady = in.getAttributeBoolean(null, ATTR_IS_READY, false);
        boolean isFailed = in.getAttributeBoolean(null, ATTR_IS_FAILED, false);
        boolean isApplied = in.getAttributeBoolean(null, ATTR_IS_APPLIED, false);
        int sessionErrorCode = in.getAttributeInt(null, ATTR_SESSION_ERROR_CODE, 0);
        String sessionErrorMessage = XmlUtils.readStringAttribute(in, ATTR_SESSION_ERROR_MESSAGE);
        if (isStagedSessionStateValid(isReady, isApplied, isFailed) == false) goto L114;
        List<String> legacyGrantedRuntimePermissions = new ArrayList();
        ArraySet<String> grantPermissions = new ArraySet();
        ArraySet<String> denyPermissions = new ArraySet();
        List<String> whitelistedRestrictedPermissions = new ArrayList();
        IntArray childSessionIds = new IntArray();
        List<InstallationFile> files = new ArrayList();
        ArrayMap<String, List<Checksum>> checksums = new ArrayMap();
        ArrayMap<String, byte[]> signatures = new ArrayMap();
        ArraySet<String> preVerifiedDomainSet = new ArraySet();
        int outerDepth = in.getDepth();
        int autoRevokePermissionsMode = 3;
    L16:
        updateOwnerPackageName = updateOwnerPackageName;
        int type = in.next();
        installerAttributionTag = installerAttributionTag;
        if (type == 1) goto L81;
        sessionId = sessionId;
        if (type == 3) goto L21;
    L24:
        if (type == 3) goto L80;
        if (type == 4) goto L80;
        String r8 = in.getName();
        switch(r8.hashCode()) {
            case -1558680102: goto L59;
            case -1361644609: goto L56;
            case -606495946: goto L53;
            case -43804892: goto L50;
            case -22892238: goto L47;
            case 158177050: goto L44;
            case 641551609: goto L41;
            case 1529564053: goto L38;
            case 1620305696: goto L35;
            case 1658008624: goto L32;
            default: goto L61;
        };
    L61:
        byte r9 = -1;
    L62:
        int outerDepth2 = outerDepth;
        switch(r9) {
            case 0: goto L77;
            case 1: goto L76;
            case 2: goto L75;
            case 3: goto L74;
            case 4: goto L73;
            case 5: goto L72;
            case 6: goto L71;
            case 7: goto L67;
            case 8: goto L66;
            case 9: goto L65;
            default: goto L64;
        };
    L64:
        List<String> whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        ArrayMap<String, byte[]> signatures2 = signatures;
        ArraySet<String> preVerifiedDomainSet2 = preVerifiedDomainSet;
        IntArray childSessionIds2 = childSessionIds;
        List<InstallationFile> files2 = files;
    L78:
        whitelistedRestrictedPermissions = whitelistedRestrictedPermissions2;
        preVerifiedDomainSet = preVerifiedDomainSet2;
        files = files2;
        childSessionIds = childSessionIds2;
        outerDepth = outerDepth2;
        signatures = signatures2;
        goto L16
    L65:
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        preVerifiedDomainSet2.add(XmlUtils.readStringAttribute(in, "domain"));
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        files2 = files;
        signatures2 = signatures;
        childSessionIds2 = childSessionIds;
        goto L78
    L66:
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        String fileName1 = XmlUtils.readStringAttribute(in, "name");
        byte[] signature = XmlUtils.readByteArrayAttribute(in, ATTR_SIGNATURE);
        ArrayMap<String, byte[]> signatures3 = signatures;
        signatures3.put(fileName1, signature);
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        childSessionIds2 = childSessionIds;
        signatures2 = signatures3;
        files2 = files;
        goto L78
    L67:
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        ArrayMap<String, byte[]> signatures4 = signatures;
        String fileName = XmlUtils.readStringAttribute(in, "name");
        Checksum checksum = new Checksum(in.getAttributeInt(null, ATTR_CHECKSUM_KIND, 0), XmlUtils.readByteArrayAttribute(in, ATTR_CHECKSUM_VALUE));
        ArrayMap<String, List<Checksum>> checksums2 = checksums;
        List<Checksum> fileChecksums = checksums2.get(fileName);
        if (fileChecksums != null) goto L70;
        fileChecksums = new ArrayList();
        checksums2.put(fileName, fileChecksums);
    L70:
        fileChecksums.add(checksum);
        signatures2 = signatures4;
        checksums = checksums2;
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        childSessionIds2 = childSessionIds;
        files2 = files;
        goto L78
    L71:
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        signatures2 = signatures;
        files2 = files;
        files2.add(new InstallationFile(in.getAttributeInt(null, "location", 0), XmlUtils.readStringAttribute(in, "name"), in.getAttributeLong(null, ATTR_LENGTH_BYTES, -1), XmlUtils.readByteArrayAttribute(in, ATTR_METADATA), XmlUtils.readByteArrayAttribute(in, ATTR_SIGNATURE)));
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        childSessionIds2 = childSessionIds;
        goto L78
    L72:
        signatures2 = signatures;
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        files2 = files;
        childSessionIds2 = childSessionIds;
        childSessionIds2.add(in.getAttributeInt(null, r2, -1));
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        goto L78
    L73:
        signatures2 = signatures;
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        childSessionIds2 = childSessionIds;
        files2 = files;
        int autoRevokePermissionsMode2 = in.getAttributeInt(null, "mode");
        autoRevokePermissionsMode = autoRevokePermissionsMode2;
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        goto L78
    L74:
        signatures2 = signatures;
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        childSessionIds2 = childSessionIds;
        files2 = files;
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        whitelistedRestrictedPermissions2.add(XmlUtils.readStringAttribute(in, "name"));
        goto L78
    L75:
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        signatures2 = signatures;
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        childSessionIds2 = childSessionIds;
        files2 = files;
        denyPermissions.add(XmlUtils.readStringAttribute(in, "name"));
        goto L78
    L76:
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        signatures2 = signatures;
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        childSessionIds2 = childSessionIds;
        files2 = files;
        grantPermissions.add(XmlUtils.readStringAttribute(in, "name"));
        goto L78
    L77:
        whitelistedRestrictedPermissions2 = whitelistedRestrictedPermissions;
        signatures2 = signatures;
        preVerifiedDomainSet2 = preVerifiedDomainSet;
        childSessionIds2 = childSessionIds;
        files2 = files;
        legacyGrantedRuntimePermissions.add(XmlUtils.readStringAttribute(in, "name"));
        goto L78
    L32:
        if (r8.equals(TAG_DENY_PERMISSION) == false) goto L61;
        r9 = 2;
        goto L62
    L35:
        if (r8.equals(TAG_GRANT_PERMISSION) == false) goto L61;
        r9 = 1;
        goto L62
    L38:
        if (r8.equals(TAG_AUTO_REVOKE_PERMISSIONS_MODE) == false) goto L61;
        r9 = 4;
        goto L62
    L41:
        if (r8.equals(TAG_SESSION_CHECKSUM) == false) goto L61;
        r9 = 7;
        goto L62
    L44:
        if (r8.equals(TAG_WHITELISTED_RESTRICTED_PERMISSION) == false) goto L61;
        r9 = 3;
        goto L62
    L47:
        if (r8.equals(TAG_SESSION_FILE) == false) goto L61;
        r9 = 6;
        goto L62
    L50:
        if (r8.equals(TAG_PRE_VERIFIED_DOMAINS) == false) goto L61;
        r9 = 9;
        goto L62
    L53:
        if (r8.equals(TAG_GRANTED_RUNTIME_PERMISSION) == false) goto L61;
        r9 = 0;
        goto L62
    L56:
        if (r8.equals(TAG_SESSION_CHECKSUM_SIGNATURE) == false) goto L61;
        r9 = 8;
        goto L62
    L59:
        if (r8.equals(TAG_CHILD_SESSION) == false) goto L61;
        r9 = 5;
    L80:
        whitelistedRestrictedPermissions = whitelistedRestrictedPermissions;
        preVerifiedDomainSet = preVerifiedDomainSet;
        files = files;
        childSessionIds = childSessionIds;
        outerDepth = outerDepth;
        signatures = signatures;
        goto L16
    L21:
        if (in.getDepth() > outerDepth) goto L24;
    L82:
        int outerDepth3 = legacyGrantedRuntimePermissions.size();
        if (outerDepth3 <= 0) goto L85;
        params.setPermissionStates(legacyGrantedRuntimePermissions, Collections.emptyList());
    L87:
        if (whitelistedRestrictedPermissions.size() <= 0) goto L89;
        params.whitelistedRestrictedPermissions = whitelistedRestrictedPermissions;
    L89:
        params.autoRevokePermissionsMode = autoRevokePermissionsMode;
        if (childSessionIds.size() <= 0) goto L95;
        int[] childSessionIdsArray = new int[childSessionIds.size()];
        int i = 0;
        int size = childSessionIds.size();
    L92:
        if (i >= size) goto L97;
        childSessionIdsArray[i] = childSessionIds.get(i);
        i = i + 1;
    L97:
        if (files.isEmpty() == true) goto L99;
        InstallationFile[] fileArray = (InstallationFile[]) files.toArray(EMPTY_INSTALLATION_FILE_ARRAY);
        InstallationFile[] fileArray2 = fileArray;
    L101:
        if (checksums.isEmpty() == true) goto L106;
        ArrayMap<String, PerFileChecksum> checksumsMap = new ArrayMap(checksums.size());
        int i2 = 0;
        int isize = checksums.size();
    L103:
        if (i2 >= isize) goto L105;
        ArrayMap<String, List<Checksum>> checksums3 = checksums;
        int[] childSessionIdsArray2 = childSessionIdsArray;
        String fileName2 = checksums3.keyAt(i2);
        List<Checksum> perFileChecksum = checksums3.valueAt(i2);
        List<String> whitelistedRestrictedPermissions3 = whitelistedRestrictedPermissions;
        byte[] perFileSignature = signatures.get(fileName2);
        checksumsMap.put(fileName2, new PerFileChecksum((Checksum[]) perFileChecksum.toArray(new Checksum[perFileChecksum.size()]), perFileSignature));
        i2 = i2 + 1;
        autoRevokePermissionsMode = autoRevokePermissionsMode;
        childSessionIdsArray = childSessionIdsArray2;
        whitelistedRestrictedPermissions = whitelistedRestrictedPermissions3;
        legacyGrantedRuntimePermissions = legacyGrantedRuntimePermissions;
        goto L103
    L105:
        int[] childSessionIdsArray3 = childSessionIdsArray;
        int autoRevokePermissionsMode3 = autoRevokePermissionsMode;
        ArrayMap<String, PerFileChecksum> checksumsMap2 = checksumsMap;
    L108:
        if (preVerifiedDomainSet.isEmpty() == false) goto L110;
        DomainSet preVerifiedDomains = null;
    L111:
        InstallSource installSource = InstallSource.create(installInitiatingPackageName, installOriginatingPackageName, installerPackageName, installPackageUid, updateOwnerPackageName, installerAttributionTag, params.packageSource);
        return new PackageInstallerSession(callback, context, pm, sessionProvider, silentUpdatePolicy, installerThread, stagingManager, sessionId, userId, installerUid, installSource, params, createdMillis, committedMillis, stageDir, stageCid, fileArray2, checksumsMap2, prepared, committed, destroyed, sealed, childSessionIdsArray3, parentSessionId, isReady, isFailed, isApplied, sessionErrorCode, sessionErrorMessage, preVerifiedDomains, installDependencyHelper);
    L110:
        preVerifiedDomains = new DomainSet(preVerifiedDomainSet);
        goto L111
    L106:
        childSessionIdsArray3 = childSessionIdsArray;
        autoRevokePermissionsMode3 = autoRevokePermissionsMode;
        checksumsMap2 = null;
        goto L108
    L99:
        fileArray2 = null;
        goto L101
    L95:
        childSessionIdsArray = EMPTY_CHILD_SESSION_ARRAY;
        goto L97
    L85:
        params.setPermissionStates(grantPermissions, denyPermissions);
        goto L87
    L81:
        sessionId = sessionId;
        goto L82
    L114:
        throw new IllegalArgumentException("Can't restore staged session with invalid state.");
    L5:
        stageDir = null;
        goto L6
    }

    private void reportInstallPackageEvent(InstallResult result) {
        if (MindSyncManager.ZTE_FEATURE_MINDSYNC == false) goto L24;
        PackageInstallerSession installedSession = result.session;     // Catch: Exception -> L11
        if (installedSession == null) goto L26;
        String installedPkgName = installedSession.getPackageName();     // Catch: Exception -> L11
        if (TextUtils.isEmpty(installedPkgName) == true) goto L27;
        InstallSource installedInstallSource = installedSession.getInstallSource();     // Catch: Exception -> L11
        String installFrom = null;
        String initiatingPkgName = null;
        if (installedInstallSource == null) goto L14;
        installFrom = installedInstallSource.mOriginatingPackageName;     // Catch: Exception -> L11
        initiatingPkgName = installedInstallSource.mInitiatingPackageName;     // Catch: Exception -> L11
    L14:
        if (TextUtils.isEmpty(installFrom) == false) goto L18;
        installFrom = initiatingPkgName;
        if (TextUtils.equals("com.android.shell", installFrom) == false) goto L18;
        installFrom = "usb";
    L18:
        Slog.d(TAG, "install pkg:" + installedPkgName + ", installFrom:" + installFrom + ", initiatingPkgName" + initiatingPkgName);     // Catch: Exception -> L11
        Bundle bundle = new Bundle();     // Catch: Exception -> L11
        bundle.putString("event", "app_install_new");     // Catch: Exception -> L11
        bundle.putString("install_from", installFrom);     // Catch: Exception -> L11
        bundle.putString("package_name", installedPkgName);     // Catch: Exception -> L11
        bundle.putBoolean("is_upgrade", false);     // Catch: Exception -> L11
        MindSyncManager.Trigger.installEvent(bundle);     // Catch: Exception -> L11
        return;
    L27:
        return;
    L26:
        return;
    L11:
        exp = move-exception;
        Slog.e(TAG, "report install event Exception : " + exp);
        return;
    }
}
