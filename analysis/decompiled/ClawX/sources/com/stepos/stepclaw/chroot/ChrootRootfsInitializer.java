package com.stepos.stepclaw.chroot;

import a6.f0;
import a6.i0;
import a6.r0;
import a6.z;
import a8.b;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import b5.a0;
import c5.m;
import c5.o;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.chroot.InstalledVersions;
import com.stepos.stepclaw.chroot.UpgradeRunPhase;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import com.stepos.stepclaw.provider.contract.OperationResult;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import com.stepos.stepclaw.runtime.RuntimeShellCommandRunner;
import com.stepos.stepclaw.runtime.ShellCommandResult;
import d6.u;
import d6.v;
import d6.w;
import d6.y;
import h5.e;
import h6.d;
import i6.a;
import i6.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import m5.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p5.p;
import u5.f;
import x5.h;
import x5.j;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ¬\u00012\u00020\u0001:\u0004\u00ad\u0001¬\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010\u000fJ\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u000fJ\u000f\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010\u000fJ\u000f\u0010#\u001a\u00020\u001cH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b%\u0010\u001eJ\u000f\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010&J\u001f\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010,\u001a\u0004\u0018\u00010\u00122\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u0004\u0018\u00010\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00105\u001a\u00020\u001c2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\rH\u0002¢\u0006\u0004\b9\u0010\u000fJ\u000f\u0010:\u001a\u00020\u001cH\u0002¢\u0006\u0004\b:\u0010$J\u000f\u0010;\u001a\u00020\u001cH\u0002¢\u0006\u0004\b;\u0010$J\u0017\u0010>\u001a\u00020\u00122\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\r2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b@\u0010AJ\u0019\u0010C\u001a\u00020\u001c2\b\b\u0002\u0010B\u001a\u00020\rH\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020\r2\u0006\u0010E\u001a\u00020\u0012H\u0002¢\u0006\u0004\bF\u0010GJ'\u0010K\u001a\u00020J2\u0006\u0010=\u001a\u00020<2\u0006\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020\u0012H\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u001cH\u0002¢\u0006\u0004\bO\u0010$J\u001f\u0010P\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020<2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\bR\u0010NJ\u0017\u0010S\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\bS\u0010NJ\u000f\u0010T\u001a\u00020\u001cH\u0002¢\u0006\u0004\bT\u0010$J\u001f\u0010W\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020\u0012H\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u001cH\u0002¢\u0006\u0004\bY\u0010$J\u000f\u0010Z\u001a\u00020\u001cH\u0002¢\u0006\u0004\bZ\u0010$J\u0017\u0010[\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020*H\u0002¢\u0006\u0004\b[\u0010\\J\u001f\u0010`\u001a\u0004\u0018\u00010_2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00120]H\u0002¢\u0006\u0004\b`\u0010aJ\u0017\u0010b\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\bb\u0010NJ\u000f\u0010c\u001a\u00020\u001cH\u0002¢\u0006\u0004\bc\u0010$J\u000f\u0010d\u001a\u00020\rH\u0002¢\u0006\u0004\bd\u0010\u000fJ\u001f\u0010e\u001a\u00020\r2\u0006\u0010=\u001a\u00020<2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\be\u0010fJ\u001f\u0010g\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020<2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bg\u0010QJ\u0017\u0010i\u001a\u00020\u00012\u0006\u0010h\u001a\u00020\u0001H\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010m\u001a\u00020\r2\u0006\u0010l\u001a\u00020kH\u0002¢\u0006\u0004\bm\u0010nJ\u001f\u0010r\u001a\u00020o2\u0006\u0010p\u001a\u00020o2\u0006\u0010q\u001a\u00020oH\u0002¢\u0006\u0004\br\u0010sJ\u001f\u0010v\u001a\u00020\r2\u0006\u0010t\u001a\u00020o2\u0006\u0010u\u001a\u00020oH\u0002¢\u0006\u0004\bv\u0010wJ\u001f\u0010y\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00122\u0006\u0010q\u001a\u00020\u0012H\u0002¢\u0006\u0004\by\u0010zJ\u001f\u0010{\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\u0012H\u0002¢\u0006\u0004\b{\u0010zJ\u0017\u0010}\u001a\u00020\r2\u0006\u0010|\u001a\u00020\u0012H\u0002¢\u0006\u0004\b}\u0010GJ\u0017\u0010~\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b~\u0010\u001eJ\u000f\u0010\u007f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u007f\u0010$J\u0011\u0010\u0080\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b\u0080\u0001\u0010$J\u0012\u0010\u0081\u0001\u001a\u00020\u001cH\u0082@¢\u0006\u0005\b\u0081\u0001\u0010\u0011J\u0012\u0010\u0082\u0001\u001a\u00020JH\u0082@¢\u0006\u0005\b\u0082\u0001\u0010\u0011J\u0012\u0010\u0083\u0001\u001a\u00020\u001cH\u0082@¢\u0006\u0005\b\u0083\u0001\u0010\u0011J,\u0010\u0086\u0001\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020<2\u0007\u0010\u0084\u0001\u001a\u00020\r2\u0007\u0010\u0085\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0011\u0010\u0088\u0001\u001a\u00020\rH\u0002¢\u0006\u0005\b\u0088\u0001\u0010\u000fJ-\u0010\u008b\u0001\u001a\u00020\u00122\u0007\u0010\u0089\u0001\u001a\u00020\u00122\u0007\u0010\u008a\u0001\u001a\u00020\u00122\u0007\u0010\u0085\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J#\u0010\u008d\u0001\u001a\u00020\r2\u0006\u0010U\u001a\u00020*2\u0007\u0010\u0085\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010\u008f\u0001R\u001d\u0010\u0005\u001a\u00020\u00048\u0001X\u0080\u0004¢\u0006\u000f\n\u0005\b\u0005\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R/\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0001X\u0080\u0004¢\u0006\u000f\n\u0005\b\b\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R/\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00068\u0001X\u0080\u0004¢\u0006\u000f\n\u0005\b\n\u0010\u0093\u0001\u001a\u0006\b\u0096\u0001\u0010\u0095\u0001R\u001f\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010\u0097\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R$\u0010\u009c\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010\u009b\u00018\u0006¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001e\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0097\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010\u009a\u0001R#\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u009b\u00018\u0006¢\u0006\u0010\n\u0006\b¡\u0001\u0010\u009d\u0001\u001a\u0006\b¢\u0001\u0010\u009f\u0001R\u001f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u00030£\u00010\u0097\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010\u009a\u0001R$\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u00030£\u00010\u009b\u00018\u0006¢\u0006\u0010\n\u0006\b¥\u0001\u0010\u009d\u0001\u001a\u0006\b¦\u0001\u0010\u009f\u0001R\u0019\u0010§\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001f\u0010«\u0001\u001a\u000b ©\u0001*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bª\u0001\u0010&¨\u0006®\u0001"}, d2 = {"Lcom/stepos/stepclaw/chroot/ChrootRootfsInitializer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "Lkotlin/Function2;", "Lcom/stepos/stepclaw/chroot/UserDataManager;", "userDataManagerFactory", "Lcom/stepos/stepclaw/chroot/OpenClawPackageInstaller;", "packageInstallerFactory", "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Lp5/p;Lp5/p;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "requiresGatewayRestart", "()Z", "initialize", "(Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "apkTgzPath", "chrootInstallShaPath", "expectedVersion", "installedVersion", "shouldInstallByFingerprint$step_runtime_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "shouldInstallByFingerprint", "Lcom/stepos/stepclaw/chroot/AssetManifest;", "manifest", "Lb5/a0;", "performBinaryUpgrade$step_runtime_release", "(Lcom/stepos/stepclaw/chroot/AssetManifest;)V", "performBinaryUpgrade", "isGatewayPackagePresent", "isOpenclawMjsValid", "hasGatewayTgzAsset", "installOpenClawFromAssets", "()V", "installGatewayFromAssets", "()Ljava/lang/String;", "apkSha", "apkShaMismatch", "(Ljava/lang/String;Ljava/lang/String;)Z", "Ljava/io/File;", "file", "sha256OfFile", "(Ljava/io/File;)Ljava/lang/String;", "assetPath", "sha256OfAsset", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/security/MessageDigest;", "md", "Ljava/io/InputStream;", "input", "updateDigestFromStream", "(Ljava/security/MessageDigest;Ljava/io/InputStream;)V", "writeInstallFingerprint", "(Ljava/lang/String;)V", "fingerprintMismatchTriggersInstall", "unlockWatcherScriptsForUpdate", "lockWatcherScriptsAfterInstall", "Lcom/stepos/stepclaw/chroot/RootfsFileHelper;", "bootstrap", "readInstalledGatewayVersion", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;)Ljava/lang/String;", "readPreserveWorkspaceFiles", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;)Z", "forceOverwrite", "deployWorkspaceFilesFromAssets", "(Z)V", "filename", "isWorkspaceMemoryAsset", "(Ljava/lang/String;)Z", "assetPrefix", "targetDir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deployAssetDirRecursive", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;Ljava/lang/String;Ljava/lang/String;)I", "deployPromptTemplatesFromAssets", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;)V", "clearPairingState", "maybeDeployWorkspaceForNewApkBuild", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;Lcom/stepos/stepclaw/chroot/AssetManifest;)V", "checkForMountedUpgrades", "checkForUpgrades", "reconcileManagedExtensions", "target", "extensionId", "ensureManagedExtensionTrustedOwnership", "(Ljava/io/File;Ljava/lang/String;)V", "ensurePluginRuntimeDepsOwnership", "quarantineRootOwnedPluginRuntimeDeps", "prepareManagedExtensionForReplace", "(Ljava/io/File;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "command", "Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "runRootfsMaintenanceCommand", "(Ljava/util/List;)Lcom/stepos/stepclaw/runtime/ShellCommandResult;", "deploySubAgentsFromAssets", "migratePluginsConfig", "isNetworkConnected", "performFullReInit", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;Lcom/stepos/stepclaw/chroot/AssetManifest;)Z", "performGatewayUpgrade", "value", "deepCloneJsonValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lorg/json/JSONArray;", "arr", "isAllPrimitives", "(Lorg/json/JSONArray;)Z", "Lorg/json/JSONObject;", "user", "asset", "mergeJSONObjectPreferUser", "(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;", "config", "bundled", "ensureMissingAgentEntriesFromBundled", "(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z", "existing", "mergeOpenclawJsonPreferUser", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "mergeAuthProfilesPreferUser", "raw", "isParseableOpenclawJson", "performConfigUpgrade", "validateProviderAuthConsistency", "saveInstalledVersions", "ensureConfigExists", "injectBuiltinConfig", "ensureAuxiliaryConfigExists", "overwriteExisting", "logPrefix", "deployAuxiliaryConfigAssets", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;ZLjava/lang/String;)V", "readSafetyPolicyEnabledFromAssets", "rawContent", "targetSecurity", "overrideExecApprovalsSecurity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "ensureAuxiliaryConfigReadable", "(Ljava/io/File;Ljava/lang/String;)Z", "Landroid/content/Context;", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "getRuntimeConfig$step_runtime_release", "()Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "Lp5/p;", "getUserDataManagerFactory$step_runtime_release", "()Lp5/p;", "getPackageInstallerFactory$step_runtime_release", "Ld6/u;", "Lcom/stepos/stepclaw/chroot/ChrootRootfsInitializer$State;", "_state", "Ld6/u;", "Ld6/w;", "state", "Ld6/w;", "getState", "()Ld6/w;", "_progress", "progress", "getProgress", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase;", "_upgradeRunPhase", "upgradeRunPhase", "getUpgradeRunPhase", "runtimeRestartRequired", "Z", "kotlin.jvm.PlatformType", "getFilesDir", "filesDir", "Companion", "State", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChrootRootfsInitializer {
    private static final String AUTH_PROFILES_ASSET = "openclaw/auth-profiles.json";
    private static final String CONFIG_ASSET = "openclaw/openclaw.json";
    private static final String EXEC_APPROVALS_ASSET = "openclaw/exec-approvals.json";
    private static final String EXTENSIONS_ASSET_PREFIX = "openclaw/extensions";
    private static final String GATEWAY_TGZ_ASSET = "openclaw/openclaw.tgz";
    private static final String INSTALL_SHA_REL = "usr/local/lib/node_modules/openclaw/.openclaw-install.sha256";
    private static final String MANAGED_EXTENSION_MARKER = ".stepclaw-from-apk";
    private static final String MANIFEST_ASSET = "openclaw/manifest.json";
    private static final String PROMPT_TEMPLATES_ASSET_PREFIX = "openclaw/prompt-templates";
    private static final String SAFETY_POLICIES_ASSET = "openclaw/safety-policies.json";
    private static final String TAG = "ChrootRootfsInitializer";
    private static final String WATCHER_SCRIPTS_DIR = "usr/local/lib/node_modules/openclaw/skills/safety-watcher-cron/scripts";
    private static final String WORKSPACE_ASSET_PREFIX = "openclaw/workspace";
    private static final String WORKSPACE_DEFAULTS_REL = "root/.openclaw/workspace/_defaults";
    private static final String WORKSPACE_MEMORY_TOP_LEVEL = "MEMORY.md";
    private final u _progress;
    private final u _state;
    private final u _upgradeRunPhase;
    private final Context context;
    private final p packageInstallerFactory;
    private final w progress;
    private final OpenClawRuntimeConfig runtimeConfig;
    private boolean runtimeRestartRequired;
    private final w state;
    private final w upgradeRunPhase;
    private final p userDataManagerFactory;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final a initializeMutex = new c();

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.chroot.ChrootRootfsInitializer$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends n implements p {
        public AnonymousClass1(Object obj) {
            super(2, obj, Companion.class, "defaultUserDataManager", "defaultUserDataManager$step_runtime_release(Landroid/content/Context;Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;)Lcom/stepos/stepclaw/chroot/UserDataManager;", 0);
        }

        @Override // p5.p
        public final UserDataManager invoke(Context p02, OpenClawRuntimeConfig p12) {
            kotlin.jvm.internal.p.e(p02, "p0");
            kotlin.jvm.internal.p.e(p12, "p1");
            return ((Companion) this.receiver).defaultUserDataManager$step_runtime_release(p02, p12);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.chroot.ChrootRootfsInitializer$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends kotlin.jvm.internal.a implements p {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(2, OpenClawPackageInstaller.class, "<init>(Landroid/content/Context;Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V");
        }

        @Override // p5.p
        public final OpenClawPackageInstaller invoke(Context p02, OpenClawRuntimeConfig p12) {
            kotlin.jvm.internal.p.e(p02, "p0");
            kotlin.jvm.internal.p.e(p12, "p1");
            return new OpenClawPackageInstaller(p02, p12, null, null, null, null, 60, null);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0019R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0019¨\u0006("}, d2 = {"Lcom/stepos/stepclaw/chroot/ChrootRootfsInitializer$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, "Lb5/a0;", "logOtaVerbose", "(Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tr", "logOtaVerboseW", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "Lcom/stepos/stepclaw/chroot/UserDataManager;", "defaultUserDataManager$step_runtime_release", "(Landroid/content/Context;Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;)Lcom/stepos/stepclaw/chroot/UserDataManager;", "defaultUserDataManager", "Li6/a;", "initializeMutex", "Li6/a;", "TAG", "Ljava/lang/String;", "GATEWAY_TGZ_ASSET", "MANIFEST_ASSET", "CONFIG_ASSET", "AUTH_PROFILES_ASSET", "EXEC_APPROVALS_ASSET", "SAFETY_POLICIES_ASSET", "INSTALL_SHA_REL", "WATCHER_SCRIPTS_DIR", "WORKSPACE_ASSET_PREFIX", "EXTENSIONS_ASSET_PREFIX", "PROMPT_TEMPLATES_ASSET_PREFIX", "MANAGED_EXTENSION_MARKER", "WORKSPACE_DEFAULTS_REL", "WORKSPACE_MEMORY_TOP_LEVEL", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ShellCommandResult defaultUserDataManager$lambda$0(List cmd) {
            kotlin.jvm.internal.p.e(cmd, "cmd");
            return RuntimeShellCommandRunner.INSTANCE.execute(cmd, 10L);
        }

        public static /* synthetic */ void logOtaVerboseW$default(Companion companion, String str, Throwable th, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                th = null;
            }
            companion.logOtaVerboseW(str, th);
        }

        public final UserDataManager defaultUserDataManager$step_runtime_release(Context context, OpenClawRuntimeConfig runtimeConfig) {
            kotlin.jvm.internal.p.e(context, "context");
            kotlin.jvm.internal.p.e(runtimeConfig, "runtimeConfig");
            return new UserDataManager(context, runtimeConfig, new z(20), null, null, 24, null);
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logOtaVerbose(String message) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logOtaVerboseW(String message, Throwable tr) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/chroot/ChrootRootfsInitializer$State;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "CHECKING", "READY", "EXTRACTING", "ERROR", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ i5.a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State CHECKING = new State("CHECKING", 0);
        public static final State READY = new State("READY", 1);
        public static final State EXTRACTING = new State("EXTRACTING", 2);
        public static final State ERROR = new State("ERROR", 3);

        private static final /* synthetic */ State[] $values() {
            return new State[]{CHECKING, READY, EXTRACTING, ERROR};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = a.a.F(stateArr$values);
        }

        private State(String str, int i8) {
        }

        public static i5.a getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.chroot.ChrootRootfsInitializer$ensureAuxiliaryConfigExists$2", f = "ChrootRootfsInitializer.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.chroot.ChrootRootfsInitializer$ensureAuxiliaryConfigExists$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p {
        int label;

        public AnonymousClass2(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return ChrootRootfsInitializer.this.new AnonymousClass2(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws JSONException, IOException {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            ChrootRootfsInitializer chrootRootfsInitializer = ChrootRootfsInitializer.this;
            chrootRootfsInitializer.deployAuxiliaryConfigAssets(RootfsFileHelper.INSTANCE.forMountedRootfs(chrootRootfsInitializer.getRuntimeConfig()), false, "Config self-heal");
            return a0.f883a;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.chroot.ChrootRootfsInitializer", f = "ChrootRootfsInitializer.kt", l = {1942, 1947, 1948}, m = "ensureConfigExists", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.chroot.ChrootRootfsInitializer$ensureConfigExists$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00081 extends h5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00081(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChrootRootfsInitializer.this.ensureConfigExists(this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.chroot.ChrootRootfsInitializer", f = "ChrootRootfsInitializer.kt", l = {2116, 153}, m = "initialize", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.chroot.ChrootRootfsInitializer$initialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00091 extends h5.c {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00091(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChrootRootfsInitializer.this.initialize(this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.chroot.ChrootRootfsInitializer$injectBuiltinConfig$2", f = "ChrootRootfsInitializer.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.chroot.ChrootRootfsInitializer$injectBuiltinConfig$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00102 extends h5.i implements p {
        int label;

        public C00102(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return ChrootRootfsInitializer.this.new C00102(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00102) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws IOException {
            int i8;
            BufferedReader bufferedReader;
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            RootfsFileHelper rootfsFileHelperForMountedRootfs = RootfsFileHelper.INSTANCE.forMountedRootfs(ChrootRootfsInitializer.this.getRuntimeConfig());
            try {
                InputStream inputStreamOpen = ChrootRootfsInitializer.this.context.getAssets().open(ChrootRootfsInitializer.CONFIG_ASSET);
                kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
                try {
                    String strC = k4.z.C(bufferedReader);
                    bufferedReader.close();
                    rootfsFileHelperForMountedRootfs.writeRootfsFile("root/.openclaw/openclaw.json", strC);
                    Log.i(ChrootRootfsInitializer.TAG, "Injected native openclaw.json from APK assets");
                } finally {
                }
            } catch (IOException e9) {
                Log.w(ChrootRootfsInitializer.TAG, "No openclaw.json in APK assets", e9);
            }
            try {
                InputStream inputStreamOpen2 = ChrootRootfsInitializer.this.context.getAssets().open(ChrootRootfsInitializer.AUTH_PROFILES_ASSET);
                kotlin.jvm.internal.p.d(inputStreamOpen2, "open(...)");
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen2, x5.a.f6276a), 8192);
                try {
                    String strC2 = k4.z.C(bufferedReader);
                    bufferedReader.close();
                    ChrootRootfsInitializer.this.getRuntimeConfig().resolveRootfsPath("root/.openclaw/agents/main/agent").mkdirs();
                    rootfsFileHelperForMountedRootfs.writeRootfsFile("root/.openclaw/agents/main/agent/auth-profiles.json", strC2);
                    i8 = Log.i(ChrootRootfsInitializer.TAG, "Injected auth-profiles.json from APK assets");
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (IOException unused) {
                i8 = Log.i(ChrootRootfsInitializer.TAG, "No auth-profiles.json in APK assets (optional)");
            }
            return new Integer(i8);
        }
    }

    public ChrootRootfsInitializer(Context context, OpenClawRuntimeConfig runtimeConfig, p userDataManagerFactory, p packageInstallerFactory) {
        kotlin.jvm.internal.p.e(context, "context");
        kotlin.jvm.internal.p.e(runtimeConfig, "runtimeConfig");
        kotlin.jvm.internal.p.e(userDataManagerFactory, "userDataManagerFactory");
        kotlin.jvm.internal.p.e(packageInstallerFactory, "packageInstallerFactory");
        this.context = context;
        this.runtimeConfig = runtimeConfig;
        this.userDataManagerFactory = userDataManagerFactory;
        this.packageInstallerFactory = packageInstallerFactory;
        y yVarA = d6.z.a(State.CHECKING);
        this._state = yVarA;
        this.state = yVarA;
        y yVarA2 = d6.z.a(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        this._progress = yVarA2;
        this.progress = yVarA2;
        y yVarA3 = d6.z.a(UpgradeRunPhase.Idle.INSTANCE);
        this._upgradeRunPhase = yVarA3;
        this.upgradeRunPhase = new v(yVarA3);
    }

    private final boolean apkShaMismatch(String apkSha, String chrootInstallShaPath) {
        String string;
        try {
            string = x5.n.T1(l.E0(new File(chrootInstallShaPath), x5.a.f6276a)).toString();
        } catch (Exception unused) {
            string = null;
        }
        return !kotlin.jvm.internal.p.a(apkSha, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkForMountedUpgrades(RootfsFileHelper bootstrap) throws Throwable {
        AssetManifest assetManifestFromAssets = AssetManifest.INSTANCE.fromAssets(this.context);
        if (assetManifestFromAssets == null) {
            Log.w(TAG, "[OTA] assets/openclaw/manifest.json missing — skip OTA / gateway deploy");
            INSTANCE.logOtaVerbose("[OTA-MOUNTED] manifest.json missing — skip OTA detection");
            return;
        }
        if (this.runtimeConfig.getForceUpdate()) {
            Log.i(TAG, "[OTA] forceUpdate=true (BuildConfig.DEBUG) — full APK asset redeploy (deps+gateway+skills+extensions+workspace+config+binary patches)");
            StepClawStartupTiming stepClawStartupTiming = StepClawStartupTiming.INSTANCE;
            long jMark = stepClawStartupTiming.mark();
            if (performFullReInit(bootstrap, assetManifestFromAssets)) {
                performConfigUpgrade(assetManifestFromAssets);
                if (!assetManifestFromAssets.getBinaryPatches().isEmpty()) {
                    performBinaryUpgrade$step_runtime_release(assetManifestFromAssets);
                }
                this.runtimeRestartRequired = true;
                Log.i(TAG, "[OTA] forceUpdate: full redeploy finished");
                UpgradeTelemetry upgradeTelemetry = UpgradeTelemetry.INSTANCE;
                String filesDir = getFilesDir();
                kotlin.jvm.internal.p.d(filesDir, "<get-filesDir>(...)");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ExtensionCallContract.OP, "force_asset_redeploy");
                jSONObject.put("result", ConfigIpcContract.KEY_OK);
                jSONObject.put("manifest", upgradeTelemetry.manifestSummary(assetManifestFromAssets));
                upgradeTelemetry.appendAudit(filesDir, jSONObject);
            } else {
                Log.w(TAG, "[OTA] forceUpdate: performFullReInit failed — retry on next init (debug still forces)");
            }
            stepClawStartupTiming.logPhase("mounted_force_update_full_redeploy", jMark, null);
            return;
        }
        InstalledVersions.Companion companion = InstalledVersions.INSTANCE;
        String filesDir2 = getFilesDir();
        kotlin.jvm.internal.p.d(filesDir2, "<get-filesDir>(...)");
        InstalledVersions installedVersionsLoad = companion.load(filesDir2);
        if (installedVersionsLoad == null) {
            Log.i(TAG, "[OTA] files/installed-versions.json missing — performFullReInit (gateway+skills+…)");
            INSTANCE.logOtaVerbose("[OTA-MOUNTED] no installed-versions.json — initial APK asset deploy (performFullReInit)");
            StepClawStartupTiming stepClawStartupTiming2 = StepClawStartupTiming.INSTANCE;
            long jMark2 = stepClawStartupTiming2.mark();
            performFullReInit(bootstrap, assetManifestFromAssets);
            stepClawStartupTiming2.logPhase("mounted_initial_asset_deploy", jMark2, null);
            return;
        }
        String gatewayVersion = assetManifestFromAssets.getGatewayVersion();
        String gatewayVersion2 = installedVersionsLoad.getGatewayVersion();
        boolean zIsGatewayPackagePresent = isGatewayPackagePresent();
        StringBuilder sbV = b.v("[OTA] checkForUpgrades entry gateway=", gatewayVersion, " installedRecord=", gatewayVersion2, " packageOnDisk=");
        sbV.append(zIsGatewayPackagePresent);
        Log.i(TAG, sbV.toString());
        checkForUpgrades(bootstrap);
    }

    private final void checkForUpgrades(RootfsFileHelper bootstrap) throws Throwable {
        StepClawStartupTiming stepClawStartupTiming;
        int i8;
        Object obj;
        String str;
        String str2;
        StepClawStartupTiming stepClawStartupTiming2;
        StepClawStartupTiming stepClawStartupTiming3 = StepClawStartupTiming.INSTANCE;
        long jMark = stepClawStartupTiming3.mark();
        Companion companion = INSTANCE;
        companion.logOtaVerbose("[OTA] checkForUpgrades start");
        try {
            AssetManifest assetManifestFromAssets = AssetManifest.INSTANCE.fromAssets(this.context);
            if (assetManifestFromAssets == null) {
                Companion.logOtaVerboseW$default(companion, "[OTA] manifest.json missing or invalid under assets/openclaw/ — skip OTA detection", null, 2, null);
                stepClawStartupTiming2 = stepClawStartupTiming3;
                i8 = 4;
                obj = null;
                str = "checkForUpgrades_total";
                str2 = null;
            } else {
                String gatewayVersion = assetManifestFromAssets.getGatewayVersion();
                long j4 = jMark;
                try {
                    companion.logOtaVerbose("[OTA] env check (APK): gateway=" + gatewayVersion + " rootfs=" + assetManifestFromAssets.getRootfsVersion() + " config=" + assetManifestFromAssets.getConfigVersion() + " buildTs=" + assetManifestFromAssets.getBuildTimestamp());
                    InstalledVersions.Companion companion2 = InstalledVersions.INSTANCE;
                    String filesDir = getFilesDir();
                    kotlin.jvm.internal.p.d(filesDir, "<get-filesDir>(...)");
                    InstalledVersions installedVersionsLoad = companion2.load(filesDir);
                    if (installedVersionsLoad == null) {
                        companion.logOtaVerbose("[OTA] no installed-versions.json — legacy/missing record → performFullReInit");
                        long jMark2 = stepClawStartupTiming3.mark();
                        performFullReInit(bootstrap, assetManifestFromAssets);
                        stepClawStartupTiming2 = stepClawStartupTiming3;
                        stepClawStartupTiming2.logPhase("upgrade_performFullReInit", jMark2, null);
                        i8 = 4;
                        obj = null;
                        str = "checkForUpgrades_total";
                        str2 = null;
                    } else {
                        String gatewayVersion2 = installedVersionsLoad.getGatewayVersion();
                        int gatewayAppliedApkVersionCode = installedVersionsLoad.getGatewayAppliedApkVersionCode();
                        j4 = j4;
                        companion.logOtaVerbose("[OTA] env check (device): gateway=" + gatewayVersion2 + " gatewayApkVc=" + gatewayAppliedApkVersionCode + " rootfs=" + installedVersionsLoad.getRootfsVersion() + " config=" + installedVersionsLoad.getConfigVersion());
                        boolean zNeedsGatewayUpgrade = installedVersionsLoad.needsGatewayUpgrade(assetManifestFromAssets);
                        boolean zIsGatewayPackagePresent = isGatewayPackagePresent();
                        boolean z = false;
                        boolean z2 = zIsGatewayPackagePresent && !zNeedsGatewayUpgrade && fingerprintMismatchTriggersInstall();
                        boolean z8 = zNeedsGatewayUpgrade || !zIsGatewayPackagePresent || z2;
                        Log.i(TAG, "[OTA] gateway deploy decision: needGateway=" + z8 + " (versionUpgrade=" + zNeedsGatewayUpgrade + " packageOnDisk=" + zIsGatewayPackagePresent + " fingerprintMismatch=" + z2 + ")");
                        boolean zNeedsConfigUpgrade = installedVersionsLoad.needsConfigUpgrade(assetManifestFromAssets);
                        if (z8 || zNeedsConfigUpgrade) {
                            if (z8) {
                                if (assetManifestFromAssets.getApkVersionCode() != 0 && installedVersionsLoad.getGatewayAppliedApkVersionCode() != assetManifestFromAssets.getApkVersionCode()) {
                                    z = true;
                                }
                                boolean zA = kotlin.jvm.internal.p.a(installedVersionsLoad.getGatewayVersion(), assetManifestFromAssets.getGatewayVersion());
                                d5.c cVarP = a.a.p();
                                if (!zIsGatewayPackagePresent) {
                                    cVarP.add("missing_gateway_package");
                                }
                                if (!zA) {
                                    cVarP.add("gatewayVersion");
                                }
                                if (z) {
                                    cVarP.add("apkVersionCode");
                                }
                                if (z2) {
                                    cVarP.add("fingerprintMismatch");
                                }
                                String strA0 = m.A0(a.a.e(cVarP), "+", null, null, null, 62);
                                if (strA0.length() == 0) {
                                    strA0 = "?";
                                }
                                Log.i(TAG, "[OTA] APPLY gateway_upgrade " + installedVersionsLoad.getGatewayVersion() + " → " + assetManifestFromAssets.getGatewayVersion() + " trigger=" + strA0);
                                companion.logOtaVerbose("[OTA] APPLY gateway_upgrade " + installedVersionsLoad.getGatewayVersion() + " → " + assetManifestFromAssets.getGatewayVersion() + " (apkVc " + installedVersionsLoad.getGatewayAppliedApkVersionCode() + "→" + assetManifestFromAssets.getApkVersionCode() + ", trigger=" + strA0 + ")");
                                long jMark3 = stepClawStartupTiming3.mark();
                                performGatewayUpgrade(bootstrap, assetManifestFromAssets);
                                stepClawStartupTiming = stepClawStartupTiming3;
                                stepClawStartupTiming.logPhase("upgrade_performGatewayUpgrade", jMark3, null);
                            } else {
                                stepClawStartupTiming = stepClawStartupTiming3;
                            }
                            if (zNeedsConfigUpgrade) {
                                companion.logOtaVerbose("[OTA] APPLY config_upgrade " + installedVersionsLoad.getConfigVersion() + " → " + assetManifestFromAssets.getConfigVersion());
                                long jMark4 = stepClawStartupTiming.mark();
                                performConfigUpgrade(assetManifestFromAssets);
                                stepClawStartupTiming.logPhase("upgrade_performConfigUpgrade", jMark4, null);
                            }
                        } else {
                            Log.i(TAG, "[OTA] No partial upgrades needed (gateway/config match manifest)");
                            companion.logOtaVerbose("[OTA] no partial upgrades: gateway/config match");
                            stepClawStartupTiming = stepClawStartupTiming3;
                        }
                        maybeDeployWorkspaceForNewApkBuild(bootstrap, assetManifestFromAssets);
                        deployPromptTemplatesFromAssets(bootstrap);
                        deploySubAgentsFromAssets(bootstrap);
                        if (!assetManifestFromAssets.getBinaryPatches().isEmpty()) {
                            long jMark5 = stepClawStartupTiming.mark();
                            performBinaryUpgrade$step_runtime_release(assetManifestFromAssets);
                            stepClawStartupTiming.logPhase("upgrade_performBinaryUpgrade", jMark5, null);
                        }
                        companion.logOtaVerbose("[OTA] checkForUpgrades done (incremental steps evaluated)");
                        i8 = 4;
                        obj = null;
                        str = "checkForUpgrades_total";
                        str2 = null;
                        stepClawStartupTiming2 = stepClawStartupTiming;
                    }
                    jMark = j4;
                } catch (Throwable th) {
                    th = th;
                    jMark = j4;
                    StepClawStartupTiming.logPhase$default(StepClawStartupTiming.INSTANCE, "checkForUpgrades_total", jMark, null, 4, null);
                    throw th;
                }
            }
            StepClawStartupTiming.logPhase$default(stepClawStartupTiming2, str, jMark, str2, i8, obj);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final String chrootInstallShaPath() {
        String absolutePath = this.runtimeConfig.resolveRootfsPath(INSTALL_SHA_REL).getAbsolutePath();
        kotlin.jvm.internal.p.d(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    private final void clearPairingState() {
        for (File file : c5.n.k0(this.runtimeConfig.resolveRootfsPath("root/.openclaw/nodes"), this.runtimeConfig.resolveRootfsPath("root/.openclaw/devices"))) {
            for (String str : c5.n.k0("paired.json", "pending.json")) {
                File file2 = new File(file, str);
                if (file2.exists()) {
                    file2.delete();
                    Log.i(TAG, "Cleared pairing state: " + file.getName() + "/" + str);
                }
            }
        }
    }

    private final Object deepCloneJsonValue(Object value) {
        return value instanceof JSONObject ? new JSONObject(((JSONObject) value).toString()) : value instanceof JSONArray ? new JSONArray(((JSONArray) value).toString()) : value;
    }

    private final int deployAssetDirRecursive(RootfsFileHelper bootstrap, String assetPrefix, String targetDir) throws IOException {
        String absolutePath = this.runtimeConfig.getRootfsRoot().getAbsolutePath();
        String[] list = this.context.getAssets().list(assetPrefix);
        if (list == null) {
            list = new String[0];
        }
        int iDeployAssetDirRecursive = 0;
        for (String str : list) {
            kotlin.jvm.internal.p.b(str);
            if (!x5.u.c1(str, ".", false)) {
                String strO = b.o(assetPrefix, "/", str);
                String strO2 = b.o(targetDir, "/", str);
                String[] list2 = this.context.getAssets().list(strO);
                if (list2 == null || list2.length == 0) {
                    InputStream inputStreamOpen = this.context.getAssets().open(strO);
                    kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
                    try {
                        String strC = k4.z.C(bufferedReader);
                        bufferedReader.close();
                        bootstrap.writeRootfsFile(strO2, strC);
                        iDeployAssetDirRecursive++;
                    } finally {
                    }
                } else {
                    new File(b.o(absolutePath, "/", strO2)).mkdirs();
                    iDeployAssetDirRecursive += deployAssetDirRecursive(bootstrap, strO, strO2);
                }
            }
        }
        return iDeployAssetDirRecursive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void deployAuxiliaryConfigAssets(com.stepos.stepclaw.chroot.RootfsFileHelper r13, boolean r14, java.lang.String r15) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.ChrootRootfsInitializer.deployAuxiliaryConfigAssets(com.stepos.stepclaw.chroot.RootfsFileHelper, boolean, java.lang.String):void");
    }

    private final void deployPromptTemplatesFromAssets(RootfsFileHelper bootstrap) {
        new File(b.n(this.runtimeConfig.getRootfsRoot().getAbsolutePath(), "/root/.openclaw/workspace/.prompt-templates")).mkdirs();
        try {
            int iDeployAssetDirRecursive = deployAssetDirRecursive(bootstrap, PROMPT_TEMPLATES_ASSET_PREFIX, "root/.openclaw/workspace/.prompt-templates");
            if (iDeployAssetDirRecursive > 0) {
                Log.i(TAG, "Prompt templates: deployed " + iDeployAssetDirRecursive + " file(s) → root/.openclaw/workspace/.prompt-templates");
            }
        } catch (Exception e9) {
            b.y("Failed to deploy prompt templates: ", e9.getMessage(), TAG);
        }
    }

    private final void deploySubAgentsFromAssets(RootfsFileHelper bootstrap) throws IOException {
        String strC;
        try {
            String[] list = this.context.getAssets().list(RootfsFileHelperKt.SUB_AGENTS_ASSET_PREFIX);
            if (list == null) {
                list = new String[0];
            }
            if (list.length == 0) {
                Log.d(TAG, "deploySubAgentsFromAssets: no sub-agents bundled — skipped");
                return;
            }
            for (String str : list) {
                String str2 = "openclaw/sub-agents/" + str;
                this.runtimeConfig.resolveRootfsPath("root/.openclaw/agents/" + str + "/sessions").mkdirs();
                AssetManager assets = this.context.getAssets();
                kotlin.jvm.internal.p.d(assets, "getAssets(...)");
                RootfsFileHelperKt.deployAssetTreeToRootfs(bootstrap, assets, str2, "root/.openclaw/agents/" + str + "/agent");
                for (String str3 : RootfsFileHelperKt.getSUB_AGENT_WORKSPACE_FILES()) {
                    try {
                        InputStream inputStreamOpen = this.context.getAssets().open(str2 + "/" + str3);
                        kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
                        try {
                            strC = k4.z.C(bufferedReader);
                            bufferedReader.close();
                        } finally {
                        }
                    } catch (Exception unused) {
                        strC = null;
                    }
                    if (strC != null) {
                        bootstrap.writeRootfsFile("root/.openclaw/workspace-" + str + "/" + str3, strC);
                    }
                }
                Log.i(TAG, "deploySubAgentsFromAssets: deployed sub-agent '" + str + "'");
            }
        } catch (Exception e9) {
            b.y("Failed to deploy sub-agents: ", e9.getMessage(), TAG);
        }
    }

    private final void deployWorkspaceFilesFromAssets(boolean forceOverwrite) throws IOException {
        RootfsFileHelper rootfsFileHelperForMountedRootfs = RootfsFileHelper.INSTANCE.forMountedRootfs(this.runtimeConfig);
        if (!forceOverwrite && readPreserveWorkspaceFiles(rootfsFileHelperForMountedRootfs)) {
            Log.i(TAG, "stepclaw.preserveWorkspaceFiles=true — skip workspace asset deploy");
            return;
        }
        String absolutePath = this.runtimeConfig.getRootfsRoot().getAbsolutePath();
        new File(b.n(absolutePath, "/root/.openclaw/workspace/_defaults")).mkdirs();
        new File(b.n(absolutePath, "/root/.openclaw/workspace")).mkdirs();
        try {
            String[] list = this.context.getAssets().list(WORKSPACE_ASSET_PREFIX);
            if (list == null) {
                list = new String[0];
            }
            for (String str : list) {
                kotlin.jvm.internal.p.b(str);
                if (!x5.u.c1(str, ".", false)) {
                    InputStream inputStreamOpen = this.context.getAssets().open("openclaw/workspace/" + str);
                    kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
                    try {
                        String strC = k4.z.C(bufferedReader);
                        bufferedReader.close();
                        rootfsFileHelperForMountedRootfs.writeRootfsFile(WORKSPACE_DEFAULTS_REL + "/" + str, strC);
                        String str2 = "root/.openclaw/workspace/" + str;
                        if (!new File(absolutePath + "/" + str2).exists() || forceOverwrite) {
                            rootfsFileHelperForMountedRootfs.writeRootfsFile(str2, strC);
                            Log.d(TAG, "Deployed workspace file" + (forceOverwrite ? " (force)" : " (missing-only)") + ": " + str);
                        } else {
                            Log.d(TAG, "Skipped workspace overwrite (user file present): " + str);
                        }
                    } finally {
                    }
                }
            }
            if (list.length == 0) {
                return;
            }
            Log.i(TAG, "Workspace: " + list.length + " asset(s); _defaults refreshed (" + (forceOverwrite ? "force-overwrite" : "missing-only") + ")");
        } catch (Exception e9) {
            b.y("Failed to deploy workspace files: ", e9.getMessage(), TAG);
        }
    }

    public static /* synthetic */ void deployWorkspaceFilesFromAssets$default(ChrootRootfsInitializer chrootRootfsInitializer, boolean z, int i8, Object obj) throws IOException {
        if ((i8 & 1) != 0) {
            z = false;
        }
        chrootRootfsInitializer.deployWorkspaceFilesFromAssets(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object ensureAuxiliaryConfigExists(f5.c cVar) {
        h6.e eVar = r0.f210a;
        Object objA = i0.A(d.f3059c, new AnonymousClass2(null), cVar);
        return objA == g5.a.f2984a ? objA : a0.f883a;
    }

    private final boolean ensureAuxiliaryConfigReadable(File target, String logPrefix) {
        ShellCommandResult shellCommandResultExecute;
        try {
            target.setReadable(true, false);
        } catch (Exception unused) {
        }
        try {
            shellCommandResultExecute = RuntimeShellCommandRunner.INSTANCE.execute(c5.n.k0("chmod", "644", target.getAbsolutePath()), 10L);
        } catch (Exception e9) {
            Log.w(TAG, logPrefix + ": chmod " + target.getName() + " failed", e9);
        }
        if (shellCommandResultExecute.getExitCode() == 0) {
            Log.d(TAG, logPrefix + ": chmod 644 " + target.getName());
            return true;
        }
        Log.w(TAG, logPrefix + ": chmod " + target.getName() + " failed: " + shellCommandResultExecute.getStderr());
        return target.canRead();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object ensureConfigExists(f5.c r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.stepos.stepclaw.chroot.ChrootRootfsInitializer.C00081
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.stepclaw.chroot.ChrootRootfsInitializer$ensureConfigExists$1 r0 = (com.stepos.stepclaw.chroot.ChrootRootfsInitializer.C00081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.chroot.ChrootRootfsInitializer$ensureConfigExists$1 r0 = new com.stepos.stepclaw.chroot.ChrootRootfsInitializer$ensureConfigExists$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            b5.a0 r3 = b5.a0.f883a
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L4c
            if (r2 == r6) goto L44
            if (r2 == r5) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r12 = r0.L$0
            java.io.File r12 = (java.io.File) r12
            a.a.c0(r13)
            goto L90
        L34:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3c:
            java.lang.Object r2 = r0.L$0
            java.io.File r2 = (java.io.File) r2
            a.a.c0(r13)
            goto L85
        L44:
            java.lang.Object r12 = r0.L$0
            java.io.File r12 = (java.io.File) r12
            a.a.c0(r13)
            goto L72
        L4c:
            a.a.c0(r13)
            com.stepos.stepclaw.runtime.OpenClawRuntimeConfig r13 = r12.runtimeConfig
            java.lang.String r2 = "root/.openclaw/agents/main/agent/auth-profiles.json"
            java.io.File r13 = r13.resolveRootfsPath(r2)
            boolean r2 = r13.exists()
            if (r2 == 0) goto L73
            long r8 = r13.length()
            r10 = 10
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 <= 0) goto L73
            r0.L$0 = r7
            r0.label = r6
            java.lang.Object r12 = r12.ensureAuxiliaryConfigExists(r0)
            if (r12 != r1) goto L72
            goto L8f
        L72:
            return r3
        L73:
            java.lang.String r13 = "ChrootRootfsInitializer"
            java.lang.String r2 = "Config files missing from rootfs — re-injecting from bundled asset"
            android.util.Log.i(r13, r2)
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r13 = r12.injectBuiltinConfig(r0)
            if (r13 != r1) goto L85
            goto L8f
        L85:
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r12 = r12.ensureAuxiliaryConfigExists(r0)
            if (r12 != r1) goto L90
        L8f:
            return r1
        L90:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.ChrootRootfsInitializer.ensureConfigExists(f5.c):java.lang.Object");
    }

    private final void ensureManagedExtensionTrustedOwnership(File target, String extensionId) {
        String stderr;
        String absolutePath = target.getAbsolutePath();
        for (List<String> list : c5.l.S(new List[]{c5.l.S(new String[]{"/system/bin/chown", "-R", "0:0", absolutePath}), c5.l.S(new String[]{"/system/bin/chmod", "-R", "go-w", absolutePath}), c5.l.S(new String[]{"/system/bin/chmod", "-R", "a+rX", absolutePath})})) {
            ShellCommandResult shellCommandResultRunRootfsMaintenanceCommand = runRootfsMaintenanceCommand(list);
            if (shellCommandResultRunRootfsMaintenanceCommand == null || shellCommandResultRunRootfsMaintenanceCommand.getExitCode() != 0) {
                String str = list.get(0);
                kotlin.jvm.internal.p.d(str, "get(...)");
                String str2 = str;
                String strM1 = x5.n.M1(str2, '/', str2);
                if (shellCommandResultRunRootfsMaintenanceCommand == null || (stderr = shellCommandResultRunRootfsMaintenanceCommand.getStderr()) == null) {
                    stderr = "command unavailable";
                }
                StringBuilder sbV = b.v("reconcileManagedExtensions: ", strM1, " failed for ", extensionId, ": ");
                sbV.append(stderr);
                Log.w(TAG, sbV.toString());
            }
        }
    }

    private final boolean ensureMissingAgentEntriesFromBundled(JSONObject config, JSONObject bundled) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        String strOptString;
        JSONObject jSONObjectOptJSONObject = bundled.optJSONObject("agents");
        if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("list")) == null) {
            return false;
        }
        JSONObject jSONObjectOptJSONObject2 = config.optJSONObject("agents");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
            config.put("agents", jSONObjectOptJSONObject2);
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("list");
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
            jSONObjectOptJSONObject2.put("list", jSONArrayOptJSONArray2);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jSONArrayOptJSONArray2.length();
        for (int i8 = 0; i8 < length; i8++) {
            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i8);
            String string = (jSONObjectOptJSONObject3 == null || (strOptString = jSONObjectOptJSONObject3.optString("id")) == null) ? null : x5.n.T1(strOptString).toString();
            if (string == null) {
                string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
        int length2 = jSONArrayOptJSONArray.length();
        boolean z = false;
        for (int i9 = 0; i9 < length2; i9++) {
            JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i9);
            if (jSONObjectOptJSONObject4 != null) {
                String strOptString2 = jSONObjectOptJSONObject4.optString("id");
                kotlin.jvm.internal.p.d(strOptString2, "optString(...)");
                String string2 = x5.n.T1(strOptString2).toString();
                if (string2.length() != 0 && !linkedHashSet.contains(string2)) {
                    jSONArrayOptJSONArray2.put(new JSONObject(jSONObjectOptJSONObject4.toString()));
                    linkedHashSet.add(string2);
                    Log.i(TAG, "Injected missing bundled agent '" + string2 + "' into openclaw.json");
                    z = true;
                }
            }
        }
        return z;
    }

    private final void ensurePluginRuntimeDepsOwnership() {
        String stderr;
        File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath("root/.openclaw/plugin-runtime-deps");
        if (!fileResolveRootfsPath.isDirectory()) {
            INSTANCE.logOtaVerbose("[OTA] ensurePluginRuntimeDepsOwnership: plugin-runtime-deps not present, skip");
            return;
        }
        ShellCommandResult shellCommandResultRunRootfsMaintenanceCommand = runRootfsMaintenanceCommand(c5.n.k0("/system/bin/chown", "-R", "system:system", fileResolveRootfsPath.getAbsolutePath()));
        if (shellCommandResultRunRootfsMaintenanceCommand != null && shellCommandResultRunRootfsMaintenanceCommand.getExitCode() == 0) {
            Log.i(TAG, "ensurePluginRuntimeDepsOwnership: chown -R system:system " + fileResolveRootfsPath.getAbsolutePath() + " ok");
            return;
        }
        Integer numValueOf = shellCommandResultRunRootfsMaintenanceCommand != null ? Integer.valueOf(shellCommandResultRunRootfsMaintenanceCommand.getExitCode()) : null;
        if (shellCommandResultRunRootfsMaintenanceCommand == null || (stderr = shellCommandResultRunRootfsMaintenanceCommand.getStderr()) == null) {
            stderr = "<n/a>";
        }
        Log.w(TAG, "ensurePluginRuntimeDepsOwnership: chown failed (exit=" + numValueOf + ", stderr=" + stderr + ")");
    }

    private final boolean fingerprintMismatchTriggersInstall() throws NoSuchAlgorithmException, IOException {
        String strSha256OfAsset = sha256OfAsset(GATEWAY_TGZ_ASSET);
        if (strSha256OfAsset == null) {
            return false;
        }
        return apkShaMismatch(strSha256OfAsset, chrootInstallShaPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFilesDir() {
        return this.context.getFilesDir().getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasGatewayTgzAsset() throws IOException {
        try {
            this.context.getAssets().open(GATEWAY_TGZ_ASSET).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object injectBuiltinConfig(f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new C00102(null), cVar);
    }

    private final void installGatewayFromAssets(AssetManifest manifest) throws InterruptedException, NoSuchAlgorithmException, IOException {
        installOpenClawFromAssets();
        InstalledVersions.Companion companion = InstalledVersions.INSTANCE;
        String filesDir = getFilesDir();
        kotlin.jvm.internal.p.d(filesDir, "<get-filesDir>(...)");
        companion.save(filesDir, new InstalledVersions(manifest.getGatewayVersion(), manifest.getApkVersionCode(), manifest.getRootfsVersion(), manifest.getConfigVersion(), manifest.getBuildTimestamp()));
        this.runtimeRestartRequired = true;
    }

    private final void installOpenClawFromAssets() throws InterruptedException, NoSuchAlgorithmException, IOException {
        unlockWatcherScriptsForUpdate();
        ((OpenClawPackageInstaller) this.packageInstallerFactory.invoke(this.context, this.runtimeConfig)).installFromAssets();
        writeInstallFingerprint(chrootInstallShaPath());
        lockWatcherScriptsAfterInstall();
    }

    private final boolean isAllPrimitives(JSONArray arr) throws JSONException {
        int length = arr.length();
        for (int i8 = 0; i8 < length; i8++) {
            Object obj = arr.get(i8);
            if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isGatewayPackagePresent() {
        return ((OpenClawPackageInstaller) this.packageInstallerFactory.invoke(this.context, this.runtimeConfig)).isInstalledPackageValid();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean isNetworkConnected() throws java.lang.ClassNotFoundException {
        /*
            r3 = this;
            r0 = 1
            java.lang.String r1 = "org.robolectric.Robolectric"
            java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L7
            goto L11
        L7:
            java.lang.String r1 = android.os.Build.FINGERPRINT
            java.lang.String r2 = "robolectric"
            boolean r1 = kotlin.jvm.internal.p.a(r1, r2)
            if (r1 == 0) goto L12
        L11:
            return r0
        L12:
            r1 = 0
            android.content.Context r3 = r3.context     // Catch: java.lang.Exception -> L22
            java.lang.String r2 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r2)     // Catch: java.lang.Exception -> L22
            boolean r2 = r3 instanceof android.net.ConnectivityManager     // Catch: java.lang.Exception -> L22
            if (r2 == 0) goto L24
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3     // Catch: java.lang.Exception -> L22
            goto L25
        L22:
            r3 = move-exception
            goto L4a
        L24:
            r3 = 0
        L25:
            if (r3 == 0) goto L49
            android.net.Network r2 = r3.getActiveNetwork()     // Catch: java.lang.Exception -> L22
            if (r2 != 0) goto L2e
            goto L49
        L2e:
            android.net.NetworkCapabilities r3 = r3.getNetworkCapabilities(r2)     // Catch: java.lang.Exception -> L22
            if (r3 != 0) goto L35
            return r1
        L35:
            r2 = 12
            boolean r2 = r3.hasCapability(r2)     // Catch: java.lang.Exception -> L22
            if (r2 == 0) goto L46
            r2 = 16
            boolean r3 = r3.hasCapability(r2)     // Catch: java.lang.Exception -> L22
            if (r3 == 0) goto L46
            goto L47
        L46:
            r0 = r1
        L47:
            r1 = r0
            goto L55
        L49:
            return r1
        L4a:
            java.lang.String r3 = r3.getMessage()
            java.lang.String r0 = "Failed to check network connectivity: "
            java.lang.String r2 = "ChrootRootfsInitializer"
            a8.b.y(r0, r3, r2)
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.ChrootRootfsInitializer.isNetworkConnected():boolean");
    }

    private final boolean isOpenclawMjsValid() throws IOException {
        File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath("usr/local/lib/node_modules/openclaw/openclaw.mjs");
        if (fileResolveRootfsPath.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileResolveRootfsPath);
                try {
                    String line = new BufferedReader(new InputStreamReader(fileInputStream, x5.a.f6276a), 8192).readLine();
                    fileInputStream.close();
                    if (line != null && x5.u.c1(line, "#!/usr/bin/env node", false)) {
                        return true;
                    }
                } finally {
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private final boolean isParseableOpenclawJson(String raw) {
        try {
            new JSONObject(raw);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean isWorkspaceMemoryAsset(String filename) {
        return kotlin.jvm.internal.p.a(filename, WORKSPACE_MEMORY_TOP_LEVEL) || x5.u.c1(filename, "memory/", false) || filename.equals("memory");
    }

    private final void lockWatcherScriptsAfterInstall() throws InterruptedException {
        String absolutePath = this.runtimeConfig.resolveRootfsPath(WATCHER_SCRIPTS_DIR).getAbsolutePath();
        ArrayList arrayList = new ArrayList();
        arrayList.add(absolutePath + "/audit.sh");
        arrayList.add(absolutePath + "/_common.sh");
        arrayList.add(absolutePath + "/interval.sh");
        arrayList.add(absolutePath + "/daily.sh");
        arrayList.add(absolutePath + "/audit.sh.sha256");
        File[] fileArrListFiles = new File(b.n(absolutePath, "/briefing-items")).listFiles();
        int i8 = 0;
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String absolutePath2 = file.getAbsolutePath();
                kotlin.jvm.internal.p.d(absolutePath2, "getAbsolutePath(...)");
                arrayList.add(absolutePath2);
            }
        }
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            String str = (String) obj;
            if (new File(str).exists()) {
                try {
                    int iWaitFor = Runtime.getRuntime().exec(new String[]{"chattr", "+i", str}).waitFor();
                    if (iWaitFor != 0) {
                        Log.w(TAG, "[Watcher] chattr +i " + str + " exit=" + iWaitFor + " (continuing; SHA256 check remains)");
                    } else {
                        Log.i(TAG, "[Watcher] chattr +i locked: " + str);
                    }
                } catch (Exception e9) {
                    Log.w(TAG, "[Watcher] chattr +i failed for " + str + ": " + e9.getMessage());
                }
            }
        }
    }

    private final void maybeDeployWorkspaceForNewApkBuild(RootfsFileHelper bootstrap, AssetManifest manifest) throws IOException {
        if (x5.n.t1(manifest.getBuildTimestamp())) {
            return;
        }
        InstalledVersions.Companion companion = InstalledVersions.INSTANCE;
        String filesDir = getFilesDir();
        kotlin.jvm.internal.p.d(filesDir, "<get-filesDir>(...)");
        InstalledVersions installedVersionsLoad = companion.load(filesDir);
        if (installedVersionsLoad == null || kotlin.jvm.internal.p.a(manifest.getBuildTimestamp(), installedVersionsLoad.getAppliedManifestBuildTimestamp())) {
            return;
        }
        if (readPreserveWorkspaceFiles(bootstrap)) {
            INSTANCE.logOtaVerbose("[OTA] skip workspace_bundle (stepclaw.preserveWorkspaceFiles=true; appliedManifestBuildTimestamp not advanced)");
            return;
        }
        INSTANCE.logOtaVerbose("[OTA] APPLY workspace_bundle buildTimestamp=" + installedVersionsLoad.getAppliedManifestBuildTimestamp() + " → " + manifest.getBuildTimestamp());
        StepClawStartupTiming stepClawStartupTiming = StepClawStartupTiming.INSTANCE;
        long jMark = stepClawStartupTiming.mark();
        deployWorkspaceFilesFromAssets$default(this, false, 1, null);
        deployPromptTemplatesFromAssets(RootfsFileHelper.INSTANCE.forMountedRootfs(this.runtimeConfig));
        stepClawStartupTiming.logPhase("upgrade_workspace_bundle_by_build_ts", jMark, null);
        String filesDir2 = getFilesDir();
        kotlin.jvm.internal.p.d(filesDir2, "<get-filesDir>(...)");
        companion.save(filesDir2, InstalledVersions.copy$default(installedVersionsLoad, null, 0, null, null, manifest.getBuildTimestamp(), 15, null));
    }

    private final String mergeAuthProfilesPreferUser(String existing, String bundled) throws JSONException {
        JSONObject jSONObject = new JSONObject(existing);
        JSONObject jSONObject2 = new JSONObject(bundled);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("profiles");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("profiles");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
        }
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        kotlin.jvm.internal.p.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject3.put(next, jSONObjectOptJSONObject.getJSONObject(next));
        }
        Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
        kotlin.jvm.internal.p.d(itKeys2, "keys(...)");
        while (itKeys2.hasNext()) {
            String next2 = itKeys2.next();
            if (!jSONObject3.has(next2)) {
                jSONObject3.put(next2, jSONObjectOptJSONObject2.getJSONObject(next2));
                Log.i(TAG, "[OTA] auth-profiles merge: injected new profile '" + next2 + "' from APK");
            }
        }
        jSONObject.put("profiles", jSONObject3);
        if (jSONObject2.has("version")) {
            jSONObject.put("version", jSONObject2.get("version"));
        }
        String string = jSONObject.toString(2);
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }

    private final JSONObject mergeJSONObjectPreferUser(JSONObject user, JSONObject asset) throws JSONException {
        JSONObject jSONObject = new JSONObject(user.toString());
        Iterator<String> itKeys = asset.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (jSONObject.has(next)) {
                Object obj = jSONObject.get(next);
                Object obj2 = asset.get(next);
                if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                    jSONObject.put(next, mergeJSONObjectPreferUser((JSONObject) obj, (JSONObject) obj2));
                } else if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
                    JSONArray jSONArray = (JSONArray) obj2;
                    if (isAllPrimitives(jSONArray)) {
                        JSONArray jSONArray2 = (JSONArray) obj;
                        f fVarR0 = k4.v.r0(0, jSONArray2.length());
                        ArrayList arrayList = new ArrayList(o.n0(fVarR0, 10));
                        Iterator it = fVarR0.iterator();
                        while (true) {
                            u5.e eVar = (u5.e) it;
                            if (!eVar.f5668c) {
                                break;
                            }
                            arrayList.add(jSONArray2.get(eVar.nextInt()).toString());
                        }
                        Set setR0 = m.R0(arrayList);
                        JSONArray jSONArray3 = new JSONArray(jSONArray2.toString());
                        int length = jSONArray.length();
                        for (int i8 = 0; i8 < length; i8++) {
                            if (!setR0.contains(jSONArray.get(i8).toString())) {
                                jSONArray3.put(jSONArray.get(i8));
                            }
                        }
                        jSONObject.put(next, jSONArray3);
                    }
                }
            } else {
                Object obj3 = asset.get(next);
                kotlin.jvm.internal.p.d(obj3, "get(...)");
                jSONObject.put(next, deepCloneJsonValue(obj3));
            }
        }
        return jSONObject;
    }

    private final String mergeOpenclawJsonPreferUser(String existing, String asset) throws JSONException {
        JSONObject jSONObject = new JSONObject(existing);
        JSONObject jSONObject2 = new JSONObject(asset);
        JSONObject jSONObjectMergeJSONObjectPreferUser = mergeJSONObjectPreferUser(jSONObject, jSONObject2);
        ensureMissingAgentEntriesFromBundled(jSONObjectMergeJSONObjectPreferUser, jSONObject2);
        String string = jSONObjectMergeJSONObjectPreferUser.toString(2);
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ab A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02db A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ef A[Catch: Exception -> 0x00f3, TRY_ENTER, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ff A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0312 A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x036c A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03d2 A[Catch: Exception -> 0x03d7, TRY_ENTER, TryCatch #6 {Exception -> 0x03d7, blocks: (B:143:0x03be, B:146:0x03d2, B:150:0x03dd, B:152:0x03e3, B:156:0x03ed, B:158:0x03f4, B:160:0x0406, B:162:0x040e, B:164:0x0415, B:166:0x0423, B:168:0x0429, B:169:0x0431, B:171:0x0436, B:172:0x043f, B:174:0x0449, B:175:0x0450, B:177:0x0456, B:190:0x047b, B:191:0x047e, B:140:0x03ac, B:188:0x0479), top: B:208:0x03ac, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03e3 A[Catch: Exception -> 0x03d7, TryCatch #6 {Exception -> 0x03d7, blocks: (B:143:0x03be, B:146:0x03d2, B:150:0x03dd, B:152:0x03e3, B:156:0x03ed, B:158:0x03f4, B:160:0x0406, B:162:0x040e, B:164:0x0415, B:166:0x0423, B:168:0x0429, B:169:0x0431, B:171:0x0436, B:172:0x043f, B:174:0x0449, B:175:0x0450, B:177:0x0456, B:190:0x047b, B:191:0x047e, B:140:0x03ac, B:188:0x0479), top: B:208:0x03ac, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03f4 A[Catch: Exception -> 0x03d7, TryCatch #6 {Exception -> 0x03d7, blocks: (B:143:0x03be, B:146:0x03d2, B:150:0x03dd, B:152:0x03e3, B:156:0x03ed, B:158:0x03f4, B:160:0x0406, B:162:0x040e, B:164:0x0415, B:166:0x0423, B:168:0x0429, B:169:0x0431, B:171:0x0436, B:172:0x043f, B:174:0x0449, B:175:0x0450, B:177:0x0456, B:190:0x047b, B:191:0x047e, B:140:0x03ac, B:188:0x0479), top: B:208:0x03ac, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0449 A[Catch: Exception -> 0x03d7, TryCatch #6 {Exception -> 0x03d7, blocks: (B:143:0x03be, B:146:0x03d2, B:150:0x03dd, B:152:0x03e3, B:156:0x03ed, B:158:0x03f4, B:160:0x0406, B:162:0x040e, B:164:0x0415, B:166:0x0423, B:168:0x0429, B:169:0x0431, B:171:0x0436, B:172:0x043f, B:174:0x0449, B:175:0x0450, B:177:0x0456, B:190:0x047b, B:191:0x047e, B:140:0x03ac, B:188:0x0479), top: B:208:0x03ac, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0499 A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04ae A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x043f A[EDGE_INSN: B:245:0x043f->B:172:0x043f BREAK  A[LOOP:9: B:157:0x03f2->B:171:0x0436], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ea A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0144 A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015b A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a0 A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0202 A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x021d A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0237 A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x026b A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x027a A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0295 A[Catch: Exception -> 0x00f3, TryCatch #9 {Exception -> 0x00f3, blocks: (B:6:0x004e, B:36:0x00e4, B:38:0x00ea, B:41:0x00f6, B:43:0x00fc, B:44:0x0114, B:46:0x011b, B:47:0x012a, B:49:0x0135, B:50:0x013e, B:52:0x0144, B:54:0x0151, B:55:0x0155, B:57:0x015b, B:59:0x0181, B:75:0x01fc, B:77:0x0202, B:78:0x020b, B:79:0x0217, B:81:0x021d, B:83:0x022d, B:84:0x0231, B:86:0x0237, B:88:0x023e, B:89:0x024a, B:90:0x025f, B:92:0x026b, B:93:0x0274, B:95:0x027a, B:96:0x0283, B:97:0x028f, B:99:0x0295, B:101:0x02a1, B:102:0x02a5, B:104:0x02ab, B:106:0x02b2, B:107:0x02be, B:108:0x02d3, B:110:0x02db, B:112:0x02e7, B:115:0x02ef, B:118:0x02f9, B:120:0x02ff, B:122:0x0312, B:123:0x031e, B:125:0x0324, B:127:0x0332, B:128:0x0336, B:130:0x033c, B:132:0x0343, B:133:0x034f, B:134:0x0364, B:136:0x036c, B:194:0x0499, B:195:0x04ae, B:192:0x047f, B:62:0x01a0, B:63:0x01a4, B:65:0x01aa, B:67:0x01b8, B:68:0x01c1, B:70:0x01c7, B:72:0x01d4, B:73:0x01d8, B:48:0x012f, B:35:0x00dc), top: B:216:0x004e }] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r14v30, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v32, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r38v0, types: [com.stepos.stepclaw.chroot.ChrootRootfsInitializer] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r7v3, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void migratePluginsConfig() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.ChrootRootfsInitializer.migratePluginsConfig():void");
    }

    private final String overrideExecApprovalsSecurity(String rawContent, String targetSecurity, String logPrefix) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(rawContent);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("defaults");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            String strOptString = jSONObjectOptJSONObject.optString("security", "(unset)");
            jSONObjectOptJSONObject.put("security", targetSecurity);
            jSONObject.put("defaults", jSONObjectOptJSONObject);
            if (!kotlin.jvm.internal.p.a(strOptString, targetSecurity)) {
                Log.i(TAG, logPrefix + ": exec-approvals.security override: " + strOptString + " → " + targetSecurity);
            }
            String string = jSONObject.toString(2);
            kotlin.jvm.internal.p.b(string);
            return string;
        } catch (Exception e9) {
            Log.w(TAG, logPrefix + ": failed to override exec-approvals.security (" + e9 + "); falling back to APK default");
            return rawContent;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106 A[Catch: Exception -> 0x00d5, IOException -> 0x00dc, TryCatch #7 {Exception -> 0x00d5, blocks: (B:26:0x00b2, B:46:0x00f5, B:48:0x0106, B:49:0x0109, B:64:0x0136, B:66:0x0157, B:68:0x016a, B:84:0x01b1, B:86:0x01c6, B:88:0x01dc, B:74:0x0188, B:75:0x018e, B:83:0x01aa, B:81:0x01a6, B:82:0x01a9, B:30:0x00cf, B:63:0x012f, B:44:0x00ee, B:59:0x0124, B:60:0x0127), top: B:120:0x004f, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016a A[Catch: Exception -> 0x00d5, IOException -> 0x01aa, TRY_LEAVE, TryCatch #9 {IOException -> 0x01aa, blocks: (B:64:0x0136, B:66:0x0157, B:68:0x016a, B:74:0x0188, B:75:0x018e, B:81:0x01a6, B:82:0x01a9), top: B:122:0x0136, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018e A[Catch: Exception -> 0x00d5, IOException -> 0x01aa, TRY_LEAVE, TryCatch #9 {IOException -> 0x01aa, blocks: (B:64:0x0136, B:66:0x0157, B:68:0x016a, B:74:0x0188, B:75:0x018e, B:81:0x01a6, B:82:0x01a9), top: B:122:0x0136, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c6 A[Catch: Exception -> 0x00d5, TryCatch #7 {Exception -> 0x00d5, blocks: (B:26:0x00b2, B:46:0x00f5, B:48:0x0106, B:49:0x0109, B:64:0x0136, B:66:0x0157, B:68:0x016a, B:84:0x01b1, B:86:0x01c6, B:88:0x01dc, B:74:0x0188, B:75:0x018e, B:83:0x01aa, B:81:0x01a6, B:82:0x01a9, B:30:0x00cf, B:63:0x012f, B:44:0x00ee, B:59:0x0124, B:60:0x0127), top: B:120:0x004f, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void performConfigUpgrade(com.stepos.stepclaw.chroot.AssetManifest r28) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.ChrootRootfsInitializer.performConfigUpgrade(com.stepos.stepclaw.chroot.AssetManifest):void");
    }

    private final boolean performFullReInit(RootfsFileHelper bootstrap, AssetManifest manifest) throws JSONException {
        Companion companion = INSTANCE;
        companion.logOtaVerbose("[OTA] performFullReInit begin (npm install openclaw + workspace assets)");
        if (!isNetworkConnected()) {
            if (isGatewayPackagePresent()) {
                Log.w(TAG, "[OTA] Offline and gateway package is already present on disk; skipping performFullReInit to prevent npm install hang");
                return true;
            }
            Log.e(TAG, "[OTA] Offline and gateway package is not present on disk. Cannot perform initial installation without internet connectivity.");
            throw new IllegalStateException("Offline and gateway package is not present on disk. Cannot perform initial installation without internet connectivity.");
        }
        try {
            y yVar = (y) this._progress;
            yVar.getClass();
            yVar.c(null, "Installing OpenClaw…");
            installOpenClawFromAssets();
            y yVar2 = (y) this._progress;
            yVar2.getClass();
            yVar2.c(null, "Deploying workspace…");
            deployWorkspaceFilesFromAssets(this.runtimeConfig.getForceUpdate());
            deployPromptTemplatesFromAssets(bootstrap);
            deploySubAgentsFromAssets(bootstrap);
            migratePluginsConfig();
            clearPairingState();
            saveInstalledVersions();
            this.runtimeRestartRequired = true;
            UpgradeTelemetry upgradeTelemetry = UpgradeTelemetry.INSTANCE;
            String filesDir = getFilesDir();
            kotlin.jvm.internal.p.d(filesDir, "<get-filesDir>(...)");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ExtensionCallContract.OP, "full_reinit");
            jSONObject.put("result", ConfigIpcContract.KEY_OK);
            jSONObject.put("manifest", upgradeTelemetry.manifestSummary(manifest));
            upgradeTelemetry.appendAudit(filesDir, jSONObject);
            companion.logOtaVerbose("[OTA] performFullReInit complete");
            return true;
        } catch (Exception e9) {
            Log.e(TAG, "[OTA] performFullReInit failed", e9);
            UpgradeTelemetry upgradeTelemetry2 = UpgradeTelemetry.INSTANCE;
            String filesDir2 = getFilesDir();
            kotlin.jvm.internal.p.d(filesDir2, "<get-filesDir>(...)");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ExtensionCallContract.OP, "full_reinit");
            jSONObject2.put("result", "fail");
            String message = e9.getMessage();
            if (message == null) {
                message = "unknown";
            }
            jSONObject2.put("error", message);
            jSONObject2.put("manifest", upgradeTelemetry2.manifestSummary(manifest));
            upgradeTelemetry2.appendAudit(filesDir2, jSONObject2);
            return false;
        }
    }

    private final void performGatewayUpgrade(RootfsFileHelper bootstrap, AssetManifest manifest) throws JSONException {
        InstalledVersions.Companion companion = InstalledVersions.INSTANCE;
        String filesDir = getFilesDir();
        kotlin.jvm.internal.p.d(filesDir, "<get-filesDir>(...)");
        InstalledVersions installedVersionsLoad = companion.load(filesDir);
        if (installedVersionsLoad == null) {
            installedVersionsLoad = new InstalledVersions((String) null, 0, (String) null, (String) null, (String) null, 31, (i) null);
        }
        if (!installedVersionsLoad.needsGatewayUpgrade(manifest) && isGatewayPackagePresent()) {
            Log.i(TAG, "[OTA] performGatewayUpgrade skipped (manifest matches and package.json on disk)");
            INSTANCE.logOtaVerbose("[OTA] gateway_upgrade skipped (already at manifest gateway/apkVc and package.json on disk)");
            return;
        }
        if (!isNetworkConnected()) {
            if (isGatewayPackagePresent()) {
                Log.w(TAG, "[OTA] Offline: skipped gateway upgrade to avoid npm install hang");
                return;
            } else {
                Log.e(TAG, "[OTA] Offline and gateway package is not present on disk. Cannot perform gateway upgrade/install without internet connectivity.");
                throw new IllegalStateException("Offline and gateway package is not present on disk. Cannot perform gateway upgrade/install without internet connectivity.");
            }
        }
        String gatewayVersion = installedVersionsLoad.getGatewayVersion();
        try {
            Log.i(TAG, "[OTA] performGatewayUpgrade: calling installOpenClawFromAssets (from=" + gatewayVersion + ")");
            y yVar = (y) this._progress;
            yVar.getClass();
            yVar.c(null, "Upgrading OpenClaw…");
            installGatewayFromAssets(manifest);
            migratePluginsConfig();
            UpgradeTelemetry upgradeTelemetry = UpgradeTelemetry.INSTANCE;
            String filesDir2 = getFilesDir();
            kotlin.jvm.internal.p.d(filesDir2, "<get-filesDir>(...)");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ExtensionCallContract.OP, "gateway_upgrade");
            jSONObject.put("result", ConfigIpcContract.KEY_OK);
            jSONObject.put("fromGateway", gatewayVersion);
            jSONObject.put("toGateway", manifest.getGatewayVersion());
            upgradeTelemetry.appendAudit(filesDir2, jSONObject);
            INSTANCE.logOtaVerbose("[OTA] gateway_upgrade finished (record updated to " + manifest.getGatewayVersion() + ")");
        } catch (Exception e9) {
            Log.e(TAG, "[OTA] gateway_upgrade failed, will retry next launch", e9);
            UpgradeTelemetry upgradeTelemetry2 = UpgradeTelemetry.INSTANCE;
            String filesDir3 = getFilesDir();
            kotlin.jvm.internal.p.d(filesDir3, "<get-filesDir>(...)");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ExtensionCallContract.OP, "gateway_upgrade");
            jSONObject2.put("result", "fail");
            String message = e9.getMessage();
            if (message == null) {
                message = "unknown";
            }
            jSONObject2.put("error", message);
            jSONObject2.put("fromGateway", gatewayVersion);
            jSONObject2.put("toGateway", manifest.getGatewayVersion());
            upgradeTelemetry2.appendAudit(filesDir3, jSONObject2);
        }
    }

    private final void prepareManagedExtensionForReplace(File target) {
        String absolutePath = target.getAbsolutePath();
        Iterator it = c5.n.k0(c5.n.k0("/system/bin/chown", "-R", "1000:1000", absolutePath), c5.n.k0("/system/bin/chmod", "-R", "u+rwX", absolutePath)).iterator();
        while (it.hasNext()) {
            runRootfsMaintenanceCommand((List) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [c5.s] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.util.ArrayList] */
    public final void quarantineRootOwnedPluginRuntimeDeps() {
        ?? arrayList;
        String stderr;
        boolean zRenameTo;
        String stdout;
        String string;
        File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath("root/.openclaw/plugin-runtime-deps");
        if (!fileResolveRootfsPath.isDirectory()) {
            INSTANCE.logOtaVerbose("[OTA] quarantineRootOwnedPluginRuntimeDeps: dir absent, skip");
            return;
        }
        File[] fileArrListFiles = fileResolveRootfsPath.listFiles();
        if (fileArrListFiles != null) {
            arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    String name = file.getName();
                    kotlin.jvm.internal.p.d(name, "getName(...)");
                    if (x5.u.c1(name, "openclaw-", false)) {
                        arrayList.add(file);
                    }
                }
            }
        } else {
            arrayList = s.f1092a;
        }
        if (arrayList.isEmpty()) {
            INSTANCE.logOtaVerbose("[OTA] quarantineRootOwnedPluginRuntimeDeps: no version dirs, skip");
            return;
        }
        for (File file2 : arrayList) {
            ShellCommandResult shellCommandResultRunRootfsMaintenanceCommand = runRootfsMaintenanceCommand(c5.l.S(new String[]{"/system/bin/stat", "-c", "%u", file2.getAbsolutePath()}));
            Integer numD1 = (shellCommandResultRunRootfsMaintenanceCommand == null || (stdout = shellCommandResultRunRootfsMaintenanceCommand.getStdout()) == null || (string = x5.n.T1(stdout).toString()) == null) ? null : x5.u.d1(string);
            if (numD1 == null) {
                String name2 = file2.getName();
                Integer numValueOf = shellCommandResultRunRootfsMaintenanceCommand != null ? Integer.valueOf(shellCommandResultRunRootfsMaintenanceCommand.getExitCode()) : null;
                if (shellCommandResultRunRootfsMaintenanceCommand == null || (stderr = shellCommandResultRunRootfsMaintenanceCommand.getStderr()) == null) {
                    stderr = "<n/a>";
                }
                Log.w(TAG, "quarantineRootOwnedPluginRuntimeDeps: stat failed for " + name2 + " (exit=" + numValueOf + " stderr=" + stderr + "); leaving as-is");
            } else if (numD1.intValue() != 0) {
                INSTANCE.logOtaVerbose("[OTA] quarantineRootOwnedPluginRuntimeDeps: " + file2.getName() + " owner uid=" + numD1 + " (not root), ok");
            } else {
                String str = ".quarantine-" + file2.getName() + "-" + System.currentTimeMillis();
                try {
                    zRenameTo = file2.renameTo(new File(fileResolveRootfsPath, str));
                } catch (Exception e9) {
                    Log.w(TAG, "quarantineRootOwnedPluginRuntimeDeps: rename threw for " + file2.getName(), e9);
                    zRenameTo = false;
                }
                if (zRenameTo) {
                    Log.w(TAG, b.q("[OTA] quarantined root-owned plugin-runtime-deps subdir: ", file2.getName(), " -> ", str, "; gateway will rebuild as system uid on next boot"));
                } else {
                    Log.w(TAG, "[OTA] quarantineRootOwnedPluginRuntimeDeps: rename failed for " + file2.getAbsolutePath() + " (parent owner/perm wrong? will retry next boot)");
                }
            }
        }
    }

    private final String readInstalledGatewayVersion(RootfsFileHelper bootstrap) {
        String str;
        String rootfsFile = bootstrap.readRootfsFile("usr/local/lib/node_modules/openclaw/package.json");
        if (rootfsFile == null) {
            return "<not installed>";
        }
        Pattern patternCompile = Pattern.compile("\"version\"\\s*:\\s*\"([^\"]+)\"");
        kotlin.jvm.internal.p.d(patternCompile, "compile(...)");
        Matcher matcher = patternCompile.matcher(rootfsFile);
        kotlin.jvm.internal.p.d(matcher, "matcher(...)");
        j jVarA = x.e.a(matcher, 0, rootfsFile);
        return (jVarA == null || (str = (String) ((h) jVarA.a()).get(1)) == null) ? "<unknown>" : str;
    }

    private final boolean readPreserveWorkspaceFiles(RootfsFileHelper bootstrap) {
        String rootfsFile = bootstrap.readRootfsFile("root/.openclaw/openclaw.json");
        if (rootfsFile == null) {
            return false;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(rootfsFile).optJSONObject("stepclaw");
            if (jSONObjectOptJSONObject == null) {
                return false;
            }
            return jSONObjectOptJSONObject.optBoolean("preserveWorkspaceFiles", false);
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean readSafetyPolicyEnabledFromAssets() throws IOException {
        try {
            InputStream inputStreamOpen = this.context.getAssets().open(SAFETY_POLICIES_ASSET);
            kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
            try {
                String strC = k4.z.C(bufferedReader);
                bufferedReader.close();
                return new JSONObject(strC).optBoolean(ExtensionCallContract.ENABLED, false);
            } finally {
            }
        } catch (Exception e9) {
            b.y("deployAuxiliaryConfigAssets: failed to read safety-policies.enabled: ", e9.getMessage(), TAG);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reconcileManagedExtensions() throws IOException {
        try {
            String[] list = this.context.getAssets().list(EXTENSIONS_ASSET_PREFIX);
            if (list == null) {
                list = new String[0];
            }
            if (list.length == 0) {
                INSTANCE.logOtaVerbose("[OTA] reconcileManagedExtensions: no extension assets");
                return;
            }
            RootfsFileHelper rootfsFileHelperForMountedRootfs = RootfsFileHelper.INSTANCE.forMountedRootfs(this.runtimeConfig);
            int i8 = 0;
            for (String str : list) {
                if (!kotlin.jvm.internal.p.a(str, "user")) {
                    File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath("root/.openclaw/extensions/" + str);
                    File file = new File(fileResolveRootfsPath, MANAGED_EXTENSION_MARKER);
                    if (this.runtimeConfig.getForceUpdate() || !fileResolveRootfsPath.exists() || file.exists()) {
                        if (fileResolveRootfsPath.exists()) {
                            prepareManagedExtensionForReplace(fileResolveRootfsPath);
                        }
                        if (fileResolveRootfsPath.exists() && !l.z0(fileResolveRootfsPath)) {
                            Log.w(TAG, "reconcileManagedExtensions: could not fully remove stale " + str + "; overwriting files");
                        }
                        AssetManager assets = this.context.getAssets();
                        kotlin.jvm.internal.p.d(assets, "getAssets(...)");
                        RootfsFileHelperKt.deployAssetTreeToRootfs(rootfsFileHelperForMountedRootfs, assets, "openclaw/extensions/" + str, "root/.openclaw/extensions/" + str);
                        rootfsFileHelperForMountedRootfs.writeRootfsFile("root/.openclaw/extensions/" + str + "/.stepclaw-from-apk", "apk\n");
                        kotlin.jvm.internal.p.b(str);
                        ensureManagedExtensionTrustedOwnership(fileResolveRootfsPath, str);
                        i8++;
                    } else {
                        INSTANCE.logOtaVerbose("[OTA] reconcileManagedExtensions: skip user-owned or unmarked extension " + str);
                    }
                }
            }
            INSTANCE.logOtaVerbose("[OTA] reconcileManagedExtensions: deployed " + i8 + " managed extension(s)");
        } catch (Exception e9) {
            b.y("reconcileManagedExtensions failed: ", e9.getMessage(), TAG);
        }
    }

    private final ShellCommandResult runRootfsMaintenanceCommand(List<String> command) {
        try {
            return RuntimeShellCommandRunner.INSTANCE.execute(command, 10L);
        } catch (Exception unused) {
            return null;
        }
    }

    private final void saveInstalledVersions() {
        AssetManifest assetManifestFromAssets = AssetManifest.INSTANCE.fromAssets(this.context);
        if (assetManifestFromAssets == null) {
            return;
        }
        InstalledVersions.Companion companion = InstalledVersions.INSTANCE;
        String filesDir = getFilesDir();
        kotlin.jvm.internal.p.d(filesDir, "<get-filesDir>(...)");
        companion.save(filesDir, new InstalledVersions(assetManifestFromAssets.getGatewayVersion(), assetManifestFromAssets.getApkVersionCode(), assetManifestFromAssets.getRootfsVersion(), assetManifestFromAssets.getConfigVersion(), assetManifestFromAssets.getBuildTimestamp()));
        Companion companion2 = INSTANCE;
        String gatewayVersion = assetManifestFromAssets.getGatewayVersion();
        int apkVersionCode = assetManifestFromAssets.getApkVersionCode();
        String rootfsVersion = assetManifestFromAssets.getRootfsVersion();
        String configVersion = assetManifestFromAssets.getConfigVersion();
        StringBuilder sbU = b.u("[OTA] wrote installed-versions.json: gateway=", apkVersionCode, gatewayVersion, " gatewayApkVc=", " rootfs=");
        sbU.append(rootfsVersion);
        sbU.append(" config=");
        sbU.append(configVersion);
        companion2.logOtaVerbose(sbU.toString());
    }

    private final String sha256OfAsset(String assetPath) throws NoSuchAlgorithmException, IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            InputStream inputStreamOpen = this.context.getAssets().open(assetPath);
            try {
                kotlin.jvm.internal.p.b(messageDigest);
                kotlin.jvm.internal.p.b(inputStreamOpen);
                updateDigestFromStream(messageDigest, inputStreamOpen);
                inputStreamOpen.close();
                byte[] bArrDigest = messageDigest.digest();
                kotlin.jvm.internal.p.d(bArrDigest, "digest(...)");
                return c5.l.h0(bArrDigest, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, new z(19), 30);
            } finally {
            }
        } catch (Exception e9) {
            Log.w(TAG, "sha256OfAsset failed for " + assetPath + ": " + e9.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence sha256OfAsset$lambda$1(byte b9) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
    }

    private final String sha256OfFile(File file) throws NoSuchAlgorithmException, IOException {
        if (!file.exists()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                kotlin.jvm.internal.p.b(messageDigest);
                updateDigestFromStream(messageDigest, fileInputStream);
                fileInputStream.close();
                byte[] bArrDigest = messageDigest.digest();
                kotlin.jvm.internal.p.d(bArrDigest, "digest(...)");
                return c5.l.h0(bArrDigest, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, new z(18), 30);
            } finally {
            }
        } catch (Exception e9) {
            Log.w(TAG, "sha256OfFile failed for " + file.getAbsolutePath() + ": " + e9.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence sha256OfFile$lambda$1(byte b9) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
    }

    private final void unlockWatcherScriptsForUpdate() throws InterruptedException {
        String absolutePath = this.runtimeConfig.resolveRootfsPath(WATCHER_SCRIPTS_DIR).getAbsolutePath();
        ArrayList arrayList = new ArrayList();
        arrayList.add(absolutePath + "/audit.sh");
        arrayList.add(absolutePath + "/_common.sh");
        arrayList.add(absolutePath + "/interval.sh");
        arrayList.add(absolutePath + "/daily.sh");
        arrayList.add(absolutePath + "/audit.sh.sha256");
        File[] fileArrListFiles = new File(b.n(absolutePath, "/briefing-items")).listFiles();
        int i8 = 0;
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String absolutePath2 = file.getAbsolutePath();
                kotlin.jvm.internal.p.d(absolutePath2, "getAbsolutePath(...)");
                arrayList.add(absolutePath2);
            }
        }
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            String str = (String) obj;
            if (new File(str).exists()) {
                try {
                    Runtime.getRuntime().exec(new String[]{"chattr", "-i", str}).waitFor();
                } catch (Exception unused) {
                }
            }
        }
    }

    private final void updateDigestFromStream(MessageDigest md, InputStream input) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i8 = input.read(bArr);
            if (i8 <= 0) {
                return;
            } else {
                md.update(bArr, 0, i8);
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x034f A[Catch: Exception -> 0x0074, TryCatch #9 {Exception -> 0x0074, blocks: (B:3:0x0010, B:6:0x0024, B:9:0x0030, B:26:0x007b, B:28:0x008d, B:29:0x0092, B:33:0x00a4, B:35:0x00aa, B:43:0x00bf, B:45:0x00c5, B:51:0x00d4, B:54:0x00f1, B:67:0x0159, B:69:0x015f, B:72:0x0169, B:75:0x0175, B:77:0x017b, B:81:0x0188, B:83:0x0191, B:85:0x01a7, B:86:0x01b7, B:88:0x01bd, B:90:0x01e4, B:93:0x020f, B:95:0x0219, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:104:0x0245, B:106:0x0249, B:108:0x024f, B:110:0x0255, B:112:0x025c, B:116:0x0267, B:119:0x0270, B:121:0x0276, B:122:0x027e, B:124:0x0284, B:125:0x028c, B:155:0x0345, B:157:0x034f, B:159:0x0355, B:161:0x035b, B:163:0x0361, B:176:0x03b3, B:177:0x03b6, B:179:0x03c8, B:180:0x03e5, B:182:0x03eb, B:127:0x02db, B:153:0x0334, B:59:0x00fd, B:61:0x0113, B:66:0x0123, B:63:0x0119, B:65:0x0120, B:22:0x006f, B:164:0x037e, B:166:0x039d, B:174:0x03af, B:175:0x03b2, B:165:0x0399, B:172:0x03ad, B:10:0x0035, B:12:0x0058, B:20:0x006b, B:21:0x006e), top: B:201:0x0010, inners: #4, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03c8 A[Catch: Exception -> 0x0074, LOOP:2: B:178:0x03c6->B:179:0x03c8, LOOP_END, TryCatch #9 {Exception -> 0x0074, blocks: (B:3:0x0010, B:6:0x0024, B:9:0x0030, B:26:0x007b, B:28:0x008d, B:29:0x0092, B:33:0x00a4, B:35:0x00aa, B:43:0x00bf, B:45:0x00c5, B:51:0x00d4, B:54:0x00f1, B:67:0x0159, B:69:0x015f, B:72:0x0169, B:75:0x0175, B:77:0x017b, B:81:0x0188, B:83:0x0191, B:85:0x01a7, B:86:0x01b7, B:88:0x01bd, B:90:0x01e4, B:93:0x020f, B:95:0x0219, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:104:0x0245, B:106:0x0249, B:108:0x024f, B:110:0x0255, B:112:0x025c, B:116:0x0267, B:119:0x0270, B:121:0x0276, B:122:0x027e, B:124:0x0284, B:125:0x028c, B:155:0x0345, B:157:0x034f, B:159:0x0355, B:161:0x035b, B:163:0x0361, B:176:0x03b3, B:177:0x03b6, B:179:0x03c8, B:180:0x03e5, B:182:0x03eb, B:127:0x02db, B:153:0x0334, B:59:0x00fd, B:61:0x0113, B:66:0x0123, B:63:0x0119, B:65:0x0120, B:22:0x006f, B:164:0x037e, B:166:0x039d, B:174:0x03af, B:175:0x03b2, B:165:0x0399, B:172:0x03ad, B:10:0x0035, B:12:0x0058, B:20:0x006b, B:21:0x006e), top: B:201:0x0010, inners: #4, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03eb A[Catch: Exception -> 0x0074, TRY_LEAVE, TryCatch #9 {Exception -> 0x0074, blocks: (B:3:0x0010, B:6:0x0024, B:9:0x0030, B:26:0x007b, B:28:0x008d, B:29:0x0092, B:33:0x00a4, B:35:0x00aa, B:43:0x00bf, B:45:0x00c5, B:51:0x00d4, B:54:0x00f1, B:67:0x0159, B:69:0x015f, B:72:0x0169, B:75:0x0175, B:77:0x017b, B:81:0x0188, B:83:0x0191, B:85:0x01a7, B:86:0x01b7, B:88:0x01bd, B:90:0x01e4, B:93:0x020f, B:95:0x0219, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:104:0x0245, B:106:0x0249, B:108:0x024f, B:110:0x0255, B:112:0x025c, B:116:0x0267, B:119:0x0270, B:121:0x0276, B:122:0x027e, B:124:0x0284, B:125:0x028c, B:155:0x0345, B:157:0x034f, B:159:0x0355, B:161:0x035b, B:163:0x0361, B:176:0x03b3, B:177:0x03b6, B:179:0x03c8, B:180:0x03e5, B:182:0x03eb, B:127:0x02db, B:153:0x0334, B:59:0x00fd, B:61:0x0113, B:66:0x0123, B:63:0x0119, B:65:0x0120, B:22:0x006f, B:164:0x037e, B:166:0x039d, B:174:0x03af, B:175:0x03b2, B:165:0x0399, B:172:0x03ad, B:10:0x0035, B:12:0x0058, B:20:0x006b, B:21:0x006e), top: B:201:0x0010, inners: #4, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fd A[Catch: Exception -> 0x0074, TryCatch #9 {Exception -> 0x0074, blocks: (B:3:0x0010, B:6:0x0024, B:9:0x0030, B:26:0x007b, B:28:0x008d, B:29:0x0092, B:33:0x00a4, B:35:0x00aa, B:43:0x00bf, B:45:0x00c5, B:51:0x00d4, B:54:0x00f1, B:67:0x0159, B:69:0x015f, B:72:0x0169, B:75:0x0175, B:77:0x017b, B:81:0x0188, B:83:0x0191, B:85:0x01a7, B:86:0x01b7, B:88:0x01bd, B:90:0x01e4, B:93:0x020f, B:95:0x0219, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:104:0x0245, B:106:0x0249, B:108:0x024f, B:110:0x0255, B:112:0x025c, B:116:0x0267, B:119:0x0270, B:121:0x0276, B:122:0x027e, B:124:0x0284, B:125:0x028c, B:155:0x0345, B:157:0x034f, B:159:0x0355, B:161:0x035b, B:163:0x0361, B:176:0x03b3, B:177:0x03b6, B:179:0x03c8, B:180:0x03e5, B:182:0x03eb, B:127:0x02db, B:153:0x0334, B:59:0x00fd, B:61:0x0113, B:66:0x0123, B:63:0x0119, B:65:0x0120, B:22:0x006f, B:164:0x037e, B:166:0x039d, B:174:0x03af, B:175:0x03b2, B:165:0x0399, B:172:0x03ad, B:10:0x0035, B:12:0x0058, B:20:0x006b, B:21:0x006e), top: B:201:0x0010, inners: #4, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0119 A[Catch: Exception -> 0x0074, TryCatch #9 {Exception -> 0x0074, blocks: (B:3:0x0010, B:6:0x0024, B:9:0x0030, B:26:0x007b, B:28:0x008d, B:29:0x0092, B:33:0x00a4, B:35:0x00aa, B:43:0x00bf, B:45:0x00c5, B:51:0x00d4, B:54:0x00f1, B:67:0x0159, B:69:0x015f, B:72:0x0169, B:75:0x0175, B:77:0x017b, B:81:0x0188, B:83:0x0191, B:85:0x01a7, B:86:0x01b7, B:88:0x01bd, B:90:0x01e4, B:93:0x020f, B:95:0x0219, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:104:0x0245, B:106:0x0249, B:108:0x024f, B:110:0x0255, B:112:0x025c, B:116:0x0267, B:119:0x0270, B:121:0x0276, B:122:0x027e, B:124:0x0284, B:125:0x028c, B:155:0x0345, B:157:0x034f, B:159:0x0355, B:161:0x035b, B:163:0x0361, B:176:0x03b3, B:177:0x03b6, B:179:0x03c8, B:180:0x03e5, B:182:0x03eb, B:127:0x02db, B:153:0x0334, B:59:0x00fd, B:61:0x0113, B:66:0x0123, B:63:0x0119, B:65:0x0120, B:22:0x006f, B:164:0x037e, B:166:0x039d, B:174:0x03af, B:175:0x03b2, B:165:0x0399, B:172:0x03ad, B:10:0x0035, B:12:0x0058, B:20:0x006b, B:21:0x006e), top: B:201:0x0010, inners: #4, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0120 A[Catch: Exception -> 0x0074, TryCatch #9 {Exception -> 0x0074, blocks: (B:3:0x0010, B:6:0x0024, B:9:0x0030, B:26:0x007b, B:28:0x008d, B:29:0x0092, B:33:0x00a4, B:35:0x00aa, B:43:0x00bf, B:45:0x00c5, B:51:0x00d4, B:54:0x00f1, B:67:0x0159, B:69:0x015f, B:72:0x0169, B:75:0x0175, B:77:0x017b, B:81:0x0188, B:83:0x0191, B:85:0x01a7, B:86:0x01b7, B:88:0x01bd, B:90:0x01e4, B:93:0x020f, B:95:0x0219, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:104:0x0245, B:106:0x0249, B:108:0x024f, B:110:0x0255, B:112:0x025c, B:116:0x0267, B:119:0x0270, B:121:0x0276, B:122:0x027e, B:124:0x0284, B:125:0x028c, B:155:0x0345, B:157:0x034f, B:159:0x0355, B:161:0x035b, B:163:0x0361, B:176:0x03b3, B:177:0x03b6, B:179:0x03c8, B:180:0x03e5, B:182:0x03eb, B:127:0x02db, B:153:0x0334, B:59:0x00fd, B:61:0x0113, B:66:0x0123, B:63:0x0119, B:65:0x0120, B:22:0x006f, B:164:0x037e, B:166:0x039d, B:174:0x03af, B:175:0x03b2, B:165:0x0399, B:172:0x03ad, B:10:0x0035, B:12:0x0058, B:20:0x006b, B:21:0x006e), top: B:201:0x0010, inners: #4, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0191 A[Catch: Exception -> 0x0074, TryCatch #9 {Exception -> 0x0074, blocks: (B:3:0x0010, B:6:0x0024, B:9:0x0030, B:26:0x007b, B:28:0x008d, B:29:0x0092, B:33:0x00a4, B:35:0x00aa, B:43:0x00bf, B:45:0x00c5, B:51:0x00d4, B:54:0x00f1, B:67:0x0159, B:69:0x015f, B:72:0x0169, B:75:0x0175, B:77:0x017b, B:81:0x0188, B:83:0x0191, B:85:0x01a7, B:86:0x01b7, B:88:0x01bd, B:90:0x01e4, B:93:0x020f, B:95:0x0219, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:104:0x0245, B:106:0x0249, B:108:0x024f, B:110:0x0255, B:112:0x025c, B:116:0x0267, B:119:0x0270, B:121:0x0276, B:122:0x027e, B:124:0x0284, B:125:0x028c, B:155:0x0345, B:157:0x034f, B:159:0x0355, B:161:0x035b, B:163:0x0361, B:176:0x03b3, B:177:0x03b6, B:179:0x03c8, B:180:0x03e5, B:182:0x03eb, B:127:0x02db, B:153:0x0334, B:59:0x00fd, B:61:0x0113, B:66:0x0123, B:63:0x0119, B:65:0x0120, B:22:0x006f, B:164:0x037e, B:166:0x039d, B:174:0x03af, B:175:0x03b2, B:165:0x0399, B:172:0x03ad, B:10:0x0035, B:12:0x0058, B:20:0x006b, B:21:0x006e), top: B:201:0x0010, inners: #4, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bd A[Catch: Exception -> 0x0074, TryCatch #9 {Exception -> 0x0074, blocks: (B:3:0x0010, B:6:0x0024, B:9:0x0030, B:26:0x007b, B:28:0x008d, B:29:0x0092, B:33:0x00a4, B:35:0x00aa, B:43:0x00bf, B:45:0x00c5, B:51:0x00d4, B:54:0x00f1, B:67:0x0159, B:69:0x015f, B:72:0x0169, B:75:0x0175, B:77:0x017b, B:81:0x0188, B:83:0x0191, B:85:0x01a7, B:86:0x01b7, B:88:0x01bd, B:90:0x01e4, B:93:0x020f, B:95:0x0219, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:104:0x0245, B:106:0x0249, B:108:0x024f, B:110:0x0255, B:112:0x025c, B:116:0x0267, B:119:0x0270, B:121:0x0276, B:122:0x027e, B:124:0x0284, B:125:0x028c, B:155:0x0345, B:157:0x034f, B:159:0x0355, B:161:0x035b, B:163:0x0361, B:176:0x03b3, B:177:0x03b6, B:179:0x03c8, B:180:0x03e5, B:182:0x03eb, B:127:0x02db, B:153:0x0334, B:59:0x00fd, B:61:0x0113, B:66:0x0123, B:63:0x0119, B:65:0x0120, B:22:0x006f, B:164:0x037e, B:166:0x039d, B:174:0x03af, B:175:0x03b2, B:165:0x0399, B:172:0x03ad, B:10:0x0035, B:12:0x0058, B:20:0x006b, B:21:0x006e), top: B:201:0x0010, inners: #4, #12 }] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void validateProviderAuthConsistency() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.ChrootRootfsInitializer.validateProviderAuthConsistency():void");
    }

    private final void writeInstallFingerprint(String chrootInstallShaPath) throws NoSuchAlgorithmException, IOException {
        String strSha256OfAsset = sha256OfAsset(GATEWAY_TGZ_ASSET);
        if (strSha256OfAsset == null) {
            Log.w(TAG, "[OTA] writeInstallFingerprint skipped: cannot hash openclaw/openclaw.tgz");
            return;
        }
        try {
            File file = new File(chrootInstallShaPath);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            l.G0(file, strSha256OfAsset.concat("\n"), x5.a.f6276a);
            INSTANCE.logOtaVerbose("[OTA] install fingerprint written: " + file.getAbsolutePath());
        } catch (Exception e9) {
            b.y("[OTA] write install fingerprint failed: ", e9.getMessage(), TAG);
        }
    }

    /* renamed from: getPackageInstallerFactory$step_runtime_release, reason: from getter */
    public final p getPackageInstallerFactory() {
        return this.packageInstallerFactory;
    }

    public final w getProgress() {
        return this.progress;
    }

    /* renamed from: getRuntimeConfig$step_runtime_release, reason: from getter */
    public final OpenClawRuntimeConfig getRuntimeConfig() {
        return this.runtimeConfig;
    }

    public final w getState() {
        return this.state;
    }

    public final w getUpgradeRunPhase() {
        return this.upgradeRunPhase;
    }

    /* renamed from: getUserDataManagerFactory$step_runtime_release, reason: from getter */
    public final p getUserDataManagerFactory() {
        return this.userDataManagerFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v4, types: [i6.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initialize(f5.c r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.stepos.stepclaw.chroot.ChrootRootfsInitializer.C00091
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.stepclaw.chroot.ChrootRootfsInitializer$initialize$1 r0 = (com.stepos.stepclaw.chroot.ChrootRootfsInitializer.C00091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.chroot.ChrootRootfsInitializer$initialize$1 r0 = new com.stepos.stepclaw.chroot.ChrootRootfsInitializer$initialize$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r9 = r0.L$0
            i6.a r9 = (i6.a) r9
            a.a.c0(r10)     // Catch: java.lang.Throwable -> L30
            goto L75
        L30:
            r10 = move-exception
            goto L84
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            i6.a r5 = (i6.a) r5
            a.a.c0(r10)
            r10 = r5
            goto L5a
        L45:
            a.a.c0(r10)
            i6.a r10 = com.stepos.stepclaw.chroot.ChrootRootfsInitializer.initializeMutex
            r0.L$0 = r10
            r0.I$0 = r3
            r0.label = r5
            i6.c r10 = (i6.c) r10
            java.lang.Object r2 = r10.c(r0)
            if (r2 != r1) goto L59
            goto L71
        L59:
            r2 = r3
        L5a:
            h6.e r5 = a6.r0.f210a     // Catch: java.lang.Throwable -> L80
            h6.d r5 = h6.d.f3059c     // Catch: java.lang.Throwable -> L80
            com.stepos.stepclaw.chroot.ChrootRootfsInitializer$initialize$2$1 r7 = new com.stepos.stepclaw.chroot.ChrootRootfsInitializer$initialize$2$1     // Catch: java.lang.Throwable -> L80
            r7.<init>(r9, r6)     // Catch: java.lang.Throwable -> L80
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L80
            r0.I$0 = r2     // Catch: java.lang.Throwable -> L80
            r0.I$1 = r3     // Catch: java.lang.Throwable -> L80
            r0.label = r4     // Catch: java.lang.Throwable -> L80
            java.lang.Object r9 = a6.i0.A(r5, r7, r0)     // Catch: java.lang.Throwable -> L80
            if (r9 != r1) goto L72
        L71:
            return r1
        L72:
            r8 = r10
            r10 = r9
            r9 = r8
        L75:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L30
            r10.getClass()     // Catch: java.lang.Throwable -> L30
            i6.c r9 = (i6.c) r9
            r9.e(r6)
            return r10
        L80:
            r9 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
        L84:
            i6.c r9 = (i6.c) r9
            r9.e(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.ChrootRootfsInitializer.initialize(f5.c):java.lang.Object");
    }

    public final void performBinaryUpgrade$step_runtime_release(AssetManifest manifest) throws IOException {
        kotlin.jvm.internal.p.e(manifest, "manifest");
        if (manifest.getBinaryPatches().isEmpty()) {
            return;
        }
        Log.i(TAG, "Deploying " + manifest.getBinaryPatches().size() + " binary patch(es)");
        for (Map.Entry<String, String> entry : manifest.getBinaryPatches().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(value);
            File parentFile = fileResolveRootfsPath.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            InputStream inputStreamOpen = this.context.getAssets().open(key);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileResolveRootfsPath);
                try {
                    kotlin.jvm.internal.p.b(inputStreamOpen);
                    k4.v.u(inputStreamOpen, fileOutputStream);
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    fileResolveRootfsPath.setExecutable(true, false);
                    Log.i(TAG, "Binary patched: " + value);
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    k4.z.h(inputStreamOpen, th);
                    throw th2;
                }
            }
        }
    }

    /* renamed from: requiresGatewayRestart, reason: from getter */
    public final boolean getRuntimeRestartRequired() {
        return this.runtimeRestartRequired;
    }

    public final boolean shouldInstallByFingerprint$step_runtime_release(String apkTgzPath, String chrootInstallShaPath, String expectedVersion, String installedVersion) {
        String strSha256OfFile;
        kotlin.jvm.internal.p.e(apkTgzPath, "apkTgzPath");
        kotlin.jvm.internal.p.e(chrootInstallShaPath, "chrootInstallShaPath");
        kotlin.jvm.internal.p.e(expectedVersion, "expectedVersion");
        if (installedVersion == null || !expectedVersion.equals(installedVersion) || (strSha256OfFile = sha256OfFile(new File(apkTgzPath))) == null) {
            return true;
        }
        return apkShaMismatch(strSha256OfFile, chrootInstallShaPath);
    }

    public /* synthetic */ ChrootRootfsInitializer(Context context, OpenClawRuntimeConfig openClawRuntimeConfig, p pVar, p pVar2, int i8, i iVar) {
        this(context, (i8 & 2) != 0 ? OpenClawRuntimeConfig.INSTANCE.fromContext(context) : openClawRuntimeConfig, (i8 & 4) != 0 ? new AnonymousClass1(INSTANCE) : pVar, (i8 & 8) != 0 ? AnonymousClass3.INSTANCE : pVar2);
    }
}
