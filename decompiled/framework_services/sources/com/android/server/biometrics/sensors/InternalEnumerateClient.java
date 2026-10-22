package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.os.IBinder;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class InternalEnumerateClient<T> extends HalClientMonitor<T> implements EnumerateConsumer {
    private static final String TAG = "Biometrics/InternalEnumerateClient";
    private final int[] mEnrolledIdsFrameworkArray;
    private final List<Integer> mEnrolledIdsHalList;
    private List<? extends BiometricAuthenticator.Identifier> mEnrolledList;
    private final int mInitialEnrolledSize;
    private boolean mIsDanglingFramework;
    private boolean mIsDanglingHal;
    private List<BiometricAuthenticator.Identifier> mUnknownHALTemplates;
    private BiometricUtils mUtils;

    protected abstract int getModality();

    protected InternalEnumerateClient(Context context, Supplier<T> lazyDaemon, IBinder token, int userId, String owner, List<? extends BiometricAuthenticator.Identifier> enrolledList, BiometricUtils utils, int sensorId, BiometricLogger logger, BiometricContext biometricContext) {
        super(context, lazyDaemon, token, null, userId, owner, 0, sensorId, logger, biometricContext, false);
        this.mUnknownHALTemplates = new ArrayList();
        this.mEnrolledIdsHalList = new ArrayList();
        this.mEnrolledList = enrolledList;
        this.mInitialEnrolledSize = this.mEnrolledList.size();
        this.mUtils = utils;
        this.mEnrolledIdsFrameworkArray = new int[this.mInitialEnrolledSize];
        int i = 0;
    L4:
        if (i >= this.mInitialEnrolledSize) goto L7;
        this.mEnrolledIdsFrameworkArray[i] = this.mEnrolledList.get(i).getBiometricId();
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.biometrics.sensors.EnumerateConsumer
    public void onEnumerationResult(BiometricAuthenticator.Identifier identifier, int remaining) {
        if (identifier == null) goto L4;
        this.mEnrolledIdsHalList.add(Integer.valueOf(identifier.getBiometricId()));
    L4:
        handleEnumeratedTemplate(identifier);
        if (remaining != 0) goto L8;
        this.mIsDanglingHal = !this.mUnknownHALTemplates.isEmpty();
        this.mIsDanglingFramework = !this.mEnrolledList.isEmpty();
        doTemplateCleanup();
        logEnumerationResult();
        this.mCallback.onClientFinished(this, true);
        return;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    private void handleEnumeratedTemplate(BiometricAuthenticator.Identifier identifier) {
        if (identifier != null) goto L6;
        Slog.d(TAG, "Null identifier");
        return;
    L6:
        Slog.v(TAG, "handleEnumeratedTemplate: " + identifier.getBiometricId());
        boolean matched = false;
        int i = 0;
    L8:
        if (i >= this.mEnrolledList.size()) goto L13;
        if (this.mEnrolledList.get(i).getBiometricId() == identifier.getBiometricId()) goto L11;
        i = i + 1;
        goto L8
    L11:
        this.mEnrolledList.remove(i);
        matched = true;
    L13:
        if (matched == false) goto L15;
    L17:
        Slog.v(TAG, "Matched: " + matched);
        return;
    L15:
        if (identifier.getBiometricId() == 0) goto L17;
        this.mUnknownHALTemplates.add(identifier);
        goto L17
    }

    private void doTemplateCleanup() {
        if (this.mEnrolledList != null) goto L6;
        Slog.d(TAG, "Null enrolledList");
        return;
    L6:
        List<String> names = new ArrayList();
        int i = 0;
    L8:
        if (i >= this.mEnrolledList.size()) goto L11;
        BiometricAuthenticator.Identifier identifier = this.mEnrolledList.get(i);
        names.add(identifier.getName().toString());
        Slog.e(TAG, "doTemplateCleanup(): Removing dangling template from framework: " + identifier.getBiometricId() + " " + identifier.getName());
        this.mUtils.removeBiometricForUser(getContext(), getTargetUserId(), identifier.getBiometricId());
        getLogger().logOnUnEnrolled(getTargetUserId(), 2, identifier.getBiometricId());
        getLogger().logUnknownEnrollmentInFramework();
        i = i + 1;
        goto L8
    L11:
        if (names.isEmpty() == true) goto L13;
        sendDanglingNotification(names);
    L13:
        this.mEnrolledList.clear();
    }

    private void logEnumerationResult() {
        if (this.mIsDanglingFramework == false) goto L8;
        if (this.mIsDanglingHal == false) goto L8;
        int result = 4;
    L14:
        int[] idsHalArray = listToArray(this.mEnrolledIdsHalList);
        getLogger().logOnEnumerated(getTargetUserId(), result, idsHalArray, this.mEnrolledIdsFrameworkArray);
        return;
    L8:
        if (this.mIsDanglingFramework == false) goto L11;
        result = 3;
        goto L14
    L11:
        if (this.mIsDanglingHal == false) goto L13;
        result = 2;
        goto L14
    L13:
        result = 1;
        goto L14
    }

    private int[] listToArray(List<Integer> ids) {
        int size = ids.size();
        int[] array = new int[size];
        int i = 0;
    L3:
        if (i >= size) goto L6;
        array[i] = ids.get(i).intValue();
        i = i + 1;
        goto L3
    L6:
        return array;
    }

    public List<BiometricAuthenticator.Identifier> getUnknownHALTemplates() {
        return this.mUnknownHALTemplates;
    }

    public void sendDanglingNotification(List<String> identifierNames) {
        if (identifierNames.isEmpty() == true) goto L10;
        Slog.e(TAG, "sendDanglingNotification(): initial enrolledSize=" + this.mInitialEnrolledSize + ", after clean up size=" + this.mEnrolledList.size());
        if (this.mEnrolledList.size() != this.mInitialEnrolledSize) goto L7;
        boolean allIdentifiersDeleted = true;
    L8:
        BiometricNotificationUtils.showBiometricReEnrollNotification(getContext(), identifierNames, allIdentifiersDeleted, getModality());
        return;
    L7:
        allIdentifiersDeleted = false;
        goto L8
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 6;
    }
}
