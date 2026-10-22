package com.android.server.blob;

import android.app.blob.BlobHandle;
import android.app.blob.IBlobCommitCallback;
import android.app.blob.IBlobStoreSession;
import android.content.Context;
import android.os.Binder;
import android.os.FileUtils;
import android.os.LimitExceededException;
import android.os.ParcelFileDescriptor;
import android.os.ParcelableException;
import android.os.RemoteException;
import android.os.RevocableFileDescriptor;
import android.os.Trace;
import android.os.storage.StorageManager;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.text.format.Formatter;
import android.util.ExceptionUtils;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class BlobStoreSession extends IBlobStoreSession.Stub {
    static final int STATE_ABANDONED = 2;
    static final int STATE_CLOSED = 0;
    static final int STATE_COMMITTED = 3;
    static final int STATE_OPENED = 1;
    static final int STATE_VERIFIED_INVALID = 5;
    static final int STATE_VERIFIED_VALID = 4;
    private final BlobAccessMode mBlobAccessMode;
    private IBlobCommitCallback mBlobCommitCallback;
    private final BlobHandle mBlobHandle;
    private final Context mContext;
    private final long mCreationTimeMs;
    private byte[] mDataDigest;
    private final BlobStoreManagerService.SessionStateChangeListener mListener;
    private final String mOwnerPackageName;
    private final int mOwnerUid;
    private final ArrayList<RevocableFileDescriptor> mRevocableFds;
    private File mSessionFile;
    private final long mSessionId;
    private final Object mSessionLock;
    private int mState;

    public static /* synthetic */ void $r8$lambda$vgJTVPNERH2uGjZcWRFuZ1Pfb8U(BlobStoreSession r0, RevocableFileDescriptor r1, IOException r2) {
        r0.lambda$trackRevocableFdLocked$0(r1, r2);
    }

    private BlobStoreSession(Context context, long sessionId, BlobHandle blobHandle, int ownerUid, String ownerPackageName, long creationTimeMs, BlobStoreManagerService.SessionStateChangeListener listener) {
        this.mSessionLock = new Object();
        this.mRevocableFds = new ArrayList();
        this.mState = 0;
        this.mBlobAccessMode = new BlobAccessMode();
        this.mContext = context;
        this.mBlobHandle = blobHandle;
        this.mSessionId = sessionId;
        this.mOwnerUid = ownerUid;
        this.mOwnerPackageName = ownerPackageName;
        this.mCreationTimeMs = creationTimeMs;
        this.mListener = listener;
    }

    BlobStoreSession(Context context, long sessionId, BlobHandle blobHandle, int ownerUid, String ownerPackageName, BlobStoreManagerService.SessionStateChangeListener listener) {
        this(context, sessionId, blobHandle, ownerUid, ownerPackageName, System.currentTimeMillis(), listener);
    }

    public BlobHandle getBlobHandle() {
        return this.mBlobHandle;
    }

    public long getSessionId() {
        return this.mSessionId;
    }

    public int getOwnerUid() {
        return this.mOwnerUid;
    }

    public String getOwnerPackageName() {
        return this.mOwnerPackageName;
    }

    boolean hasAccess(int callingUid, String callingPackageName) {
        if (this.mOwnerUid == callingUid) goto L5;
    L7:
        return false;
    L5:
        if (this.mOwnerPackageName.equals(callingPackageName) == false) goto L7;
        return true;
    }

    void open() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isFinalized() == true) goto L12;
        this.mState = 1;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Not allowed to open session with state: " + stateToString(this.mState));     // Catch: Throwable -> L9
    }

    int getState() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        int r1 = this.mState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void sendCommitCallbackResult(int result) {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        this.mBlobCommitCallback.onResult(result);     // Catch: Throwable -> L6 RemoteException -> L8
    L10:
        this.mBlobCommitCallback = null;     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        Slog.d(BlobStoreConfig.TAG, "Error sending the callback result", e);     // Catch: Throwable -> L6
        goto L10
    }

    BlobAccessMode getBlobAccessMode() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        BlobAccessMode r1 = this.mBlobAccessMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isFinalized() {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 3) goto L12;
        if (this.mState == 2) goto L12;
        boolean r1 = false;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L12:
        r1 = true;
        goto L13
    }

    boolean isExpired() {
        long lastModifiedTimeMs = getSessionFile().lastModified();
        if (lastModifiedTimeMs != 0) goto L5;
        long r2 = this.mCreationTimeMs;
    L7:
        return BlobStoreConfig.hasSessionExpired(r2);
    L5:
        r2 = lastModifiedTimeMs;
        goto L7
    }

    public ParcelFileDescriptor openWrite(long offsetBytes, long lengthBytes) {
        Preconditions.checkArgumentNonnegative(offsetBytes, "offsetBytes must not be negative");
        assertCallerIsOwner();
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L24:
        e = move-exception;
        throw e;
    L5:
        if (this.mState != 1) goto L27;
        monitor-exit(r0);     // Catch: Throwable -> L24
        FileDescriptor fd = null;
        fd = openWriteInternal(offsetBytes, lengthBytes);     // Catch: IOException -> L21
        RevocableFileDescriptor revocableFd = new RevocableFileDescriptor(this.mContext, fd, BlobStoreUtils.getRevocableFdHandler());     // Catch: IOException -> L21
        Object r3 = this.mSessionLock;     // Catch: IOException -> L21
        monitor-enter(r3);     // Catch: IOException -> L21
    L15:
        th = move-exception;
        throw th;     // Catch: IOException -> L21
    L11:
        if (this.mState != 1) goto L17;
        trackRevocableFdLocked(revocableFd);     // Catch: Throwable -> L15
        ParcelFileDescriptor r2 = revocableFd.getRevocableFileDescriptor();     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        return r2;
    L17:
        IoUtils.closeQuietly(fd);     // Catch: Throwable -> L15
        throw new IllegalStateException("Not allowed to write in state: " + stateToString(this.mState));     // Catch: Throwable -> L15
    L21:
        e = move-exception;
        IoUtils.closeQuietly(fd);
        throw ExceptionUtils.wrap(e);
    L27:
        throw new IllegalStateException("Not allowed to write in state: " + stateToString(this.mState));     // Catch: Throwable -> L24
    }

    private FileDescriptor openWriteInternal(long offsetBytes, long lengthBytes) throws IOException {
        File sessionFile = getSessionFile();     // Catch: ErrnoException -> L11
        if (sessionFile == null) goto L18;
        FileDescriptor fd = Os.open(sessionFile.getPath(), OsConstants.O_CREAT | OsConstants.O_RDWR, FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT);     // Catch: ErrnoException -> L11
        if (offsetBytes <= 0) goto L14;
        long curOffset = Os.lseek(fd, offsetBytes, OsConstants.SEEK_SET);     // Catch: ErrnoException -> L11
        if (curOffset == offsetBytes) goto L14;
        throw new IllegalStateException("Failed to seek " + offsetBytes + "; curOffset=" + offsetBytes);     // Catch: ErrnoException -> L11
    L14:
        if (lengthBytes <= 0) goto L16;
        ((StorageManager) this.mContext.getSystemService(StorageManager.class)).allocateBytes(fd, lengthBytes);     // Catch: ErrnoException -> L11
    L16:
        return fd;
    L18:
        throw new IllegalStateException("Couldn't get the file for this session");     // Catch: ErrnoException -> L11
    L11:
        e = move-exception;
        throw e.rethrowAsIOException();
    }

    public ParcelFileDescriptor openRead() {
        assertCallerIsOwner();
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 1) goto L35;
        if (BlobStoreConfig.shouldUseRevocableFdForReads() == false) goto L41;
        monitor-exit(r0);     // Catch: Throwable -> L11
        FileDescriptor fd = null;
        fd = openReadInternal();     // Catch: IOException -> L31
        RevocableFileDescriptor revocableFd = new RevocableFileDescriptor(this.mContext, fd);     // Catch: IOException -> L31
        Object r3 = this.mSessionLock;     // Catch: IOException -> L31
        monitor-enter(r3);     // Catch: IOException -> L31
    L25:
        th = move-exception;
        throw th;     // Catch: IOException -> L31
    L21:
        if (this.mState != 1) goto L27;
        trackRevocableFdLocked(revocableFd);     // Catch: Throwable -> L25
        ParcelFileDescriptor r2 = revocableFd.getRevocableFileDescriptor();     // Catch: Throwable -> L25
        monitor-exit(r3);     // Catch: Throwable -> L25
        return r2;
    L27:
        IoUtils.closeQuietly(fd);     // Catch: Throwable -> L25
        throw new IllegalStateException("Not allowed to read in state: " + stateToString(this.mState));     // Catch: Throwable -> L25
    L31:
        e = move-exception;
        IoUtils.closeQuietly(fd);
        throw ExceptionUtils.wrap(e);
    L41:
        ParcelFileDescriptor r1 = new ParcelFileDescriptor(openReadInternal());     // Catch: Throwable -> L11 IOException -> L13
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L13:
        e = move-exception;
        throw ExceptionUtils.wrap(e);     // Catch: Throwable -> L11
    L35:
        throw new IllegalStateException("Not allowed to read in state: " + stateToString(this.mState));     // Catch: Throwable -> L11
    }

    private FileDescriptor openReadInternal() throws IOException {
        File sessionFile = getSessionFile();     // Catch: ErrnoException -> L6
        if (sessionFile == null) goto L9;
        FileDescriptor fd = Os.open(sessionFile.getPath(), OsConstants.O_RDONLY, 0);     // Catch: ErrnoException -> L6
        return fd;
    L9:
        throw new IllegalStateException("Couldn't get the file for this session");     // Catch: ErrnoException -> L6
    L6:
        e = move-exception;
        throw e.rethrowAsIOException();
    }

    public long getSize() {
        return getSessionFile().length();
    }

    public void allowPackageAccess(String packageName, byte[] certificate) {
        assertCallerIsOwner();
        packageName.getClass();
        boolean r2 = false;
        if (packageName.length() > 223) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "packageName is longer than 223 chars");
        certificate.getClass();
        if (certificate.length > 32) goto L9;
        r2 = true;
    L9:
        Preconditions.checkArgument(r2, "certificate is longer than 32 chars");
        Object r1 = this.mSessionLock;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (this.mState != 1) goto L23;
        if (this.mBlobAccessMode.getAllowedPackagesCount() >= BlobStoreConfig.getMaxPermittedPackages()) goto L21;
        this.mBlobAccessMode.allowPackageAccess(packageName, certificate);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L21:
        throw new ParcelableException(new LimitExceededException("Too many packages permitted to access the blob: " + this.mBlobAccessMode.getAllowedPackagesCount()));     // Catch: Throwable -> L18
    L23:
        throw new IllegalStateException("Not allowed to change access type in state: " + stateToString(this.mState));     // Catch: Throwable -> L18
    L5:
        r0 = false;
        goto L6
    }

    public void allowSameSignatureAccess() {
        assertCallerIsOwner();
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 1) goto L12;
        this.mBlobAccessMode.allowSameSignatureAccess();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Not allowed to change access type in state: " + stateToString(this.mState));     // Catch: Throwable -> L9
    }

    public void allowPublicAccess() {
        assertCallerIsOwner();
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 1) goto L12;
        this.mBlobAccessMode.allowPublicAccess();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Not allowed to change access type in state: " + stateToString(this.mState));     // Catch: Throwable -> L9
    }

    public boolean isPackageAccessAllowed(String packageName, byte[] certificate) {
        assertCallerIsOwner();
        packageName.getClass();
        Preconditions.checkByteArrayNotEmpty(certificate, "certificate");
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 1) goto L12;
        boolean r1 = this.mBlobAccessMode.isPackageAccessAllowed(packageName, certificate);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("Not allowed to get access type in state: " + stateToString(this.mState));     // Catch: Throwable -> L9
    }

    public boolean isSameSignatureAccessAllowed() {
        assertCallerIsOwner();
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 1) goto L12;
        boolean r1 = this.mBlobAccessMode.isSameSignatureAccessAllowed();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("Not allowed to get access type in state: " + stateToString(this.mState));     // Catch: Throwable -> L9
    }

    public boolean isPublicAccessAllowed() {
        assertCallerIsOwner();
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 1) goto L12;
        boolean r1 = this.mBlobAccessMode.isPublicAccessAllowed();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("Not allowed to get access type in state: " + stateToString(this.mState));     // Catch: Throwable -> L9
    }

    public void close() {
        closeSession(0, false);
    }

    public void abandon() {
        closeSession(2, true);
    }

    public void commit(IBlobCommitCallback callback) {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        this.mBlobCommitCallback = callback;     // Catch: Throwable -> L7
        closeSession(3, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void closeSession(int state, boolean sendCallback) {
        assertCallerIsOwner();
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 1) goto L13;
        if (state != 0) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Not allowed to delete or abandon a session with state: " + stateToString(this.mState));     // Catch: Throwable -> L9
    L13:
        this.mState = state;     // Catch: Throwable -> L9
        revokeAllFds();     // Catch: Throwable -> L9
        if (sendCallback == false) goto L16;
        this.mListener.onStateChanged(this);     // Catch: Throwable -> L9
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    void computeDigest() {
        Trace.traceBegin(524288, "computeBlobDigest-i" + this.mSessionId + "-l" + getSessionFile().length());     // Catch: Throwable -> L5 Throwable -> L7
        this.mDataDigest = FileUtils.digest(getSessionFile(), this.mBlobHandle.algorithm);     // Catch: Throwable -> L5 Throwable -> L7
    L4:
        Trace.traceEnd(524288);
        return;
    L5:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    L7:
        e = move-exception;
        Slog.e(BlobStoreConfig.TAG, "Error computing the digest", e);     // Catch: Throwable -> L5
        goto L4
    }

    void verifyBlobData() {
        Object r1 = this.mSessionLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDataDigest != null) goto L7;
    L11:
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L9
        r2.append("Digest of the data (");     // Catch: Throwable -> L9
        if (this.mDataDigest != null) goto L14;
        String r3 = "null";
    L15:
        r2.append(r3);     // Catch: Throwable -> L9
        r2.append(") didn't match the given BlobHandle.digest (");     // Catch: Throwable -> L9
        r2.append(BlobHandle.safeDigest(this.mBlobHandle.digest));     // Catch: Throwable -> L9
        r2.append(")");     // Catch: Throwable -> L9
        Slog.d(BlobStoreConfig.TAG, r2.toString());     // Catch: Throwable -> L9
        this.mState = 5;     // Catch: Throwable -> L9
        FrameworkStatsLog.write(FrameworkStatsLog.BLOB_COMMITTED, getOwnerUid(), this.mSessionId, getSize(), 3);     // Catch: Throwable -> L9
        sendCommitCallbackResult(1);     // Catch: Throwable -> L9
    L16:
        this.mListener.onStateChanged(this);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L14:
        r3 = BlobHandle.safeDigest(this.mDataDigest);     // Catch: Throwable -> L9
        goto L15
    L7:
        if (Arrays.equals(this.mDataDigest, this.mBlobHandle.digest) == false) goto L11;
        this.mState = 4;     // Catch: Throwable -> L9
        goto L16
    }

    void destroy() {
        revokeAllFds();
        getSessionFile().delete();
    }

    private void revokeAllFds() {
        ArrayList<RevocableFileDescriptor> r0 = this.mRevocableFds;
        monitor-enter(r0);
        int i = this.mRevocableFds.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L9;
        this.mRevocableFds.get(i).revoke();     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mRevocableFds.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void trackRevocableFdLocked(final RevocableFileDescriptor revocableFd) {
        ArrayList<RevocableFileDescriptor> r0 = this.mRevocableFds;
        monitor-enter(r0);
        this.mRevocableFds.add(revocableFd);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        revocableFd.addOnCloseListener(new BlobStoreSession$$ExternalSyntheticLambda0(this, revocableFd));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$trackRevocableFdLocked$0(RevocableFileDescriptor revocableFd, IOException e) {
        ArrayList<RevocableFileDescriptor> r0 = this.mRevocableFds;
        monitor-enter(r0);
        this.mRevocableFds.remove(revocableFd);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    File getSessionFile() {
        if (this.mSessionFile != null) goto L6;
        this.mSessionFile = BlobStoreConfig.prepareBlobFile(this.mSessionId);
    L6:
        return this.mSessionFile;
    }

    static String stateToString(int state) {
        switch(state) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        Slog.wtf(BlobStoreConfig.TAG, "Unknown state: " + state);
        return "<unknown>";
    L5:
        return "<verified_invalid>";
    L7:
        return "<verified_valid>";
    L9:
        return "<committed>";
    L11:
        return "<abandoned>";
    L13:
        return "<opened>";
    L15:
        return "<closed>";
    }

    public String toString() {
        return "BlobStoreSession {id:" + this.mSessionId + ",handle:" + this.mBlobHandle + ",uid:" + this.mOwnerUid + ",pkg:" + this.mOwnerPackageName + "}";
    }

    private void assertCallerIsOwner() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.mOwnerUid) goto L6;
        return;
    L6:
        throw new SecurityException(this.mOwnerUid + " is not the session owner");
    }

    void dump(IndentingPrintWriter fout, BlobStoreManagerService.DumpArgs dumpArgs) {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        fout.println("state: " + stateToString(this.mState));     // Catch: Throwable -> L7
        fout.println("ownerUid: " + this.mOwnerUid);     // Catch: Throwable -> L7
        fout.println("ownerPkg: " + this.mOwnerPackageName);     // Catch: Throwable -> L7
        fout.println("creation time: " + BlobStoreUtils.formatTime(this.mCreationTimeMs));     // Catch: Throwable -> L7
        fout.println("size: " + Formatter.formatFileSize(this.mContext, getSize(), 8));     // Catch: Throwable -> L7
        fout.println("blobHandle:");     // Catch: Throwable -> L7
        fout.increaseIndent();     // Catch: Throwable -> L7
        this.mBlobHandle.dump(fout, dumpArgs.shouldDumpFull());     // Catch: Throwable -> L7
        fout.decreaseIndent();     // Catch: Throwable -> L7
        fout.println("accessMode:");     // Catch: Throwable -> L7
        fout.increaseIndent();     // Catch: Throwable -> L7
        this.mBlobAccessMode.dump(fout);     // Catch: Throwable -> L7
        fout.decreaseIndent();     // Catch: Throwable -> L7
        fout.println("Open fds: #" + this.mRevocableFds.size());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void writeToXml(XmlSerializer out) throws IOException {
        Object r0 = this.mSessionLock;
        monitor-enter(r0);
        XmlUtils.writeLongAttribute(out, "id", this.mSessionId);     // Catch: Throwable -> L7
        XmlUtils.writeStringAttribute(out, "p", this.mOwnerPackageName);     // Catch: Throwable -> L7
        XmlUtils.writeIntAttribute(out, "u", this.mOwnerUid);     // Catch: Throwable -> L7
        XmlUtils.writeLongAttribute(out, "crt", this.mCreationTimeMs);     // Catch: Throwable -> L7
        out.startTag(null, "bh");     // Catch: Throwable -> L7
        this.mBlobHandle.writeToXml(out);     // Catch: Throwable -> L7
        out.endTag(null, "bh");     // Catch: Throwable -> L7
        out.startTag(null, "am");     // Catch: Throwable -> L7
        this.mBlobAccessMode.writeToXml(out);     // Catch: Throwable -> L7
        out.endTag(null, "am");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static BlobStoreSession createFromXml(XmlPullParser in, int version, Context context, BlobStoreManagerService.SessionStateChangeListener stateChangeListener) throws IOException, XmlPullParserException {
        long sessionId = XmlUtils.readLongAttribute(in, "id");
        String ownerPackageName = XmlUtils.readStringAttribute(in, "p");
        int ownerUid = XmlUtils.readIntAttribute(in, "u");
        if (version < 5) goto L5;
        long creationTimeMs = XmlUtils.readLongAttribute(in, "crt");
    L6:
        int depth = in.getDepth();
        BlobHandle blobHandle = null;
        BlobAccessMode blobAccessMode = null;
    L8:
        if (XmlUtils.nextElementWithin(in, depth) == false) goto L16;
        if ("bh".equals(in.getName()) == true) goto L11;
        if ("am".equals(in.getName()) == false) goto L8;
        blobAccessMode = BlobAccessMode.createFromXml(in);
        goto L8
    L11:
        blobHandle = BlobHandle.createFromXml(in);
        goto L8
    L16:
        if (blobHandle != null) goto L19;
        Slog.wtf(BlobStoreConfig.TAG, "blobHandle should be available");
        return null;
    L19:
        if (blobAccessMode != null) goto L22;
        Slog.wtf(BlobStoreConfig.TAG, "blobAccessMode should be available");
        return null;
    L22:
        BlobStoreSession blobStoreSession = new BlobStoreSession(context, sessionId, blobHandle, ownerUid, ownerPackageName, creationTimeMs, stateChangeListener);
        blobStoreSession.mBlobAccessMode.allow(blobAccessMode);
        return blobStoreSession;
    L5:
        creationTimeMs = System.currentTimeMillis();
        goto L6
    }
}
