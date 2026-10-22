package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricAuthenticator.Identifier;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class BiometricUserState<T extends BiometricAuthenticator.Identifier> {
    private static final String ATTR_INVALIDATION = "authenticatorIdInvalidation_attr";
    private static final String TAG = "UserState";
    private static final String TAG_INVALIDATION = "authenticatorIdInvalidation_tag";
    protected final ArrayList<T> mBiometrics;
    protected final Context mContext;
    protected final File mFile;
    protected boolean mInvalidationInProgress;
    private boolean mIsInvalidBiometricState;
    private final Runnable mWriteStateRunnable;

    /* JADX INFO: renamed from: $r8$lambda$W8_x1sHMCJUIrLJhCzwjYeneU-8, reason: not valid java name */
    public static /* synthetic */ void m2622$r8$lambda$W8_x1sHMCJUIrLJhCzwjYeneU8(BiometricUserState r0) {
        r0.doWriteStateInternal();
    }

    protected abstract void doWriteState(TypedXmlSerializer r1) throws Exception;

    protected abstract String getBiometricsTag();

    protected abstract ArrayList<T> getCopy(ArrayList<T> r1);

    protected abstract int getNameTemplateResource();

    protected abstract void parseBiometricsLocked(TypedXmlPullParser r1) throws IOException, XmlPullParserException;

    private void doWriteStateInternal() {
        AtomicFile destination = new AtomicFile(this.mFile);
        FileOutputStream out = null;
        out = destination.startWrite();     // Catch: Throwable -> L6
        TypedXmlSerializer serializer = Xml.resolveSerializer(out);     // Catch: Throwable -> L6
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Throwable -> L6
        serializer.startDocument(null, true);     // Catch: Throwable -> L6
        serializer.startTag(null, TAG_INVALIDATION);     // Catch: Throwable -> L6
        serializer.attributeBoolean(null, ATTR_INVALIDATION, this.mInvalidationInProgress);     // Catch: Throwable -> L6
        serializer.endTag(null, TAG_INVALIDATION);     // Catch: Throwable -> L6
        doWriteState(serializer);     // Catch: Throwable -> L6
        serializer.endDocument();     // Catch: Throwable -> L6
        destination.finishWrite(out);     // Catch: Throwable -> L6
        IoUtils.closeQuietly(out);
        return;
    L6:
        t = move-exception;
        Slog.e(TAG, "Failed to write settings, restoring backup", t);     // Catch: Throwable -> L9
        destination.failWrite(out);     // Catch: Throwable -> L9
        throw new IllegalStateException("Failed to write to file: " + this.mFile.toString(), t);     // Catch: Throwable -> L9
    L9:
        t = move-exception;
        IoUtils.closeQuietly(out);
        throw t;
    }

    public BiometricUserState(Context context, int userId, String fileName) {
        this.mBiometrics = new ArrayList();
        this.mIsInvalidBiometricState = false;
        this.mWriteStateRunnable = new BiometricUserState$$ExternalSyntheticLambda0(this);
        this.mFile = getFileForUser(userId, fileName);
        this.mContext = context;
        monitor-enter(this);
        readStateSyncLocked();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setInvalidationInProgress(boolean invalidationInProgress) {
        monitor-enter(this);
        this.mInvalidationInProgress = invalidationInProgress;     // Catch: Throwable -> L6
        scheduleWriteStateLocked();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean isInvalidationInProgress() {
        monitor-enter(this);
        boolean r0 = this.mInvalidationInProgress;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void addBiometric(T identifier) {
        monitor-enter(this);
        this.mBiometrics.add(identifier);     // Catch: Throwable -> L6
        scheduleWriteStateLocked();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void removeBiometric(int biometricId) {
        monitor-enter(this);
        int i = 0;
    L16:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (i >= this.mBiometrics.size()) goto L12;
        if (this.mBiometrics.get(i).getBiometricId() == biometricId) goto L8;
        i = i + 1;     // Catch: Throwable -> L9
        goto L16
    L8:
        this.mBiometrics.remove(i);     // Catch: Throwable -> L9
        scheduleWriteStateLocked();     // Catch: Throwable -> L9
    L12:
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    public void renameBiometric(int biometricId, CharSequence name) {
        monitor-enter(this);
        int i = 0;
    L16:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (i >= this.mBiometrics.size()) goto L12;
        if (this.mBiometrics.get(i).getBiometricId() == biometricId) goto L8;
        i = i + 1;     // Catch: Throwable -> L9
        goto L16
    L8:
        BiometricAuthenticator.Identifier identifier = this.mBiometrics.get(i);     // Catch: Throwable -> L9
        identifier.setName(name);     // Catch: Throwable -> L9
        scheduleWriteStateLocked();     // Catch: Throwable -> L9
    L12:
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    public List<T> getBiometrics() {
        monitor-enter(this);
        ArrayList<T> r0 = getCopy(this.mBiometrics);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public String getUniqueName() {
        int guess = 1;
    L3:
        String name = this.mContext.getString(getNameTemplateResource(), new Object[]{Integer.valueOf(guess)});
        if (isUnique(name) == true) goto L5;
        guess = guess + 1;
        goto L3
    L5:
        return name;
    }

    public boolean isInvalidBiometricState() {
        return this.mIsInvalidBiometricState;
    }

    public void deleteBiometricFile() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mFile.exists() == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L10:
        if (this.mFile.delete() == false) goto L12;
        Slog.i(TAG, this.mFile + " is deleted successfully");     // Catch: Throwable -> L7
    L13:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L12:
        Slog.i(TAG, "Failed to delete " + this.mFile);     // Catch: Throwable -> L7
        goto L13
    }

    private boolean isUnique(String name) {
        Iterator<T> r0 = this.mBiometrics.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        T identifier = r0.next();
        if (identifier.getName().equals(name) == false) goto L4;
        return false;
    L10:
        return true;
    }

    private File getFileForUser(int userId, String fileName) {
        return new File(Environment.getUserSystemDirectory(userId), fileName);
    }

    private void scheduleWriteStateLocked() {
        AsyncTask.execute(this.mWriteStateRunnable);
    }

    private void readStateSyncLocked() {
        if (this.mFile.exists() == true) goto L19;
        return;
    L19:
        FileInputStream in = new FileInputStream(this.mFile);     // Catch: FileNotFoundException -> L16
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L9 Throwable -> L11
        parseStateLocked(parser);     // Catch: Throwable -> L9 Throwable -> L11
        IoUtils.closeQuietly(in);
        return;
    L11:
        e = move-exception;
        throw new IllegalStateException("Failed parsing settings file: " + this.mFile, e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        IoUtils.closeQuietly(in);
        throw th;
    L16:
        fnfe = move-exception;
        Slog.i(TAG, "No fingerprint state", fnfe);
        this.mIsInvalidBiometricState = true;
    }

    private void parseStateLocked(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L21;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals(getBiometricsTag()) == true) goto L16;
        if (tagName.equals(TAG_INVALIDATION) == false) goto L3;
        this.mInvalidationInProgress = parser.getAttributeBoolean(null, ATTR_INVALIDATION);
        goto L3
    L16:
        parseBiometricsLocked(parser);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }
}
