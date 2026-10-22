package com.android.server.biometrics.log;

import android.hardware.biometrics.AuthenticateOptions;
import android.hardware.biometrics.common.AuthenticateReason;
import android.hardware.biometrics.common.OperationContext;
import android.hardware.biometrics.common.OperationState;
import android.hardware.face.FaceAuthenticateOptions;
import android.hardware.fingerprint.FingerprintAuthenticateOptions;

/* JADX INFO: loaded from: classes.dex */
public class OperationContextExt {
    private final OperationContext mAidlContext;
    private int mDockState;
    private int mFoldState;
    private final boolean mIsBP;
    private boolean mIsDisplayOn;
    private final boolean mIsMandatoryBiometrics;
    private int mOrientation;
    private BiometricContextSessionInfo mSessionInfo;

    public OperationContextExt(boolean isBP) {
        this(new OperationContext(), isBP, 0);
    }

    public OperationContextExt(boolean isBP, boolean isMandatoryBiometrics) {
        this(new OperationContext(), isBP, 0, isMandatoryBiometrics);
    }

    public OperationContextExt(boolean isBP, int modality, boolean isMandatoryBiometrics) {
        this(new OperationContext(), isBP, modality, isMandatoryBiometrics);
    }

    public OperationContextExt(OperationContext context, boolean isBP, int modality) {
        this(context, isBP, modality, false);
    }

    public OperationContextExt(OperationContext context, boolean isBP, int modality, boolean isMandatoryBiometrics) {
        this.mIsDisplayOn = false;
        this.mDockState = 0;
        this.mOrientation = 0;
        this.mFoldState = 0;
        this.mAidlContext = context;
        this.mIsBP = isBP;
        this.mIsMandatoryBiometrics = isMandatoryBiometrics;
        if (modality != 2) goto L6;
        OperationContext r0 = this.mAidlContext;
        r0.operationState = OperationState.fingerprintOperationState(new OperationState.FingerprintOperationState());
        return;
    L6:
        if (modality != 8) goto L10;
        OperationContext r1 = this.mAidlContext;
        r1.operationState = OperationState.faceOperationState(new OperationState.FaceOperationState());
        return;
    }

    public OperationContext toAidlContext() {
        return this.mAidlContext;
    }

    public OperationContext toAidlContext(AuthenticateOptions options) {
        if ((options instanceof FaceAuthenticateOptions) == false) goto L7;
        return toAidlContext((FaceAuthenticateOptions) options);
    L7:
        if ((options instanceof FingerprintAuthenticateOptions) == false) goto L11;
        return toAidlContext((FingerprintAuthenticateOptions) options);
    L11:
        throw new IllegalStateException("Authenticate options are invalid.");
    }

    public OperationContext toAidlContext(FaceAuthenticateOptions options) {
        OperationContext r0 = this.mAidlContext;
        r0.authenticateReason = AuthenticateReason.faceAuthenticateReason(getAuthReason(options));
        OperationContext r1 = this.mAidlContext;
        r1.wakeReason = getWakeReason(options);
        return this.mAidlContext;
    }

    public OperationContext toAidlContext(FingerprintAuthenticateOptions options) {
        if (options.getVendorReason() == null) goto L5;
        OperationContext r0 = this.mAidlContext;
        r0.authenticateReason = AuthenticateReason.vendorAuthenticateReason(options.getVendorReason());
    L6:
        OperationContext r1 = this.mAidlContext;
        r1.wakeReason = getWakeReason(options);
        return this.mAidlContext;
    L5:
        OperationContext r2 = this.mAidlContext;
        r2.authenticateReason = AuthenticateReason.fingerprintAuthenticateReason(getAuthReason(options));
        goto L6
    }

    private int getAuthReason(FaceAuthenticateOptions options) {
        switch(options.getAuthenticateReason()) {
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 10;
    L8:
        return 9;
    L10:
        return 8;
    L12:
        return 7;
    L14:
        return 6;
    L16:
        return 5;
    L18:
        return 4;
    L20:
        return 3;
    L22:
        return 2;
    L24:
        return 1;
    }

    private int getWakeReason(FaceAuthenticateOptions options) {
        switch(options.getWakeReason()) {
            case 1: goto L20;
            case 4: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 10: goto L12;
            case 15: goto L10;
            case 16: goto L8;
            case 17: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 9;
    L8:
        return 8;
    L10:
        return 7;
    L12:
        return 6;
    L14:
        return 4;
    L16:
        return 3;
    L18:
        return 2;
    L20:
        return 1;
    }

    private int getAuthReason(FingerprintAuthenticateOptions options) {
        return 0;
    }

    private int getWakeReason(FingerprintAuthenticateOptions options) {
        return 0;
    }

    public int getId() {
        return this.mAidlContext.id;
    }

    public int getOrderAndIncrement() {
        BiometricContextSessionInfo info = this.mSessionInfo;
        if (info != null) goto L7;
        return -1;
    L7:
        return info.getOrderAndIncrement();
    }

    public byte getReason() {
        return this.mAidlContext.reason;
    }

    public int getWakeReason() {
        return this.mAidlContext.wakeReason;
    }

    public boolean isDisplayOn() {
        return this.mIsDisplayOn;
    }

    public boolean isAod() {
        return this.mAidlContext.isAod;
    }

    public int getDisplayState() {
        return this.mAidlContext.displayState;
    }

    public boolean isCrypto() {
        return this.mAidlContext.isCrypto;
    }

    public int getDockState() {
        return this.mDockState;
    }

    public int getFoldState() {
        return this.mFoldState;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public OperationState getOperationState() {
        return this.mAidlContext.operationState;
    }

    public boolean getIsMandatoryBiometrics() {
        return this.mIsMandatoryBiometrics;
    }

    OperationContextExt update(BiometricContext biometricContext, boolean isCrypto) {
        OperationContext r0 = this.mAidlContext;
        r0.isAod = biometricContext.isAod();
        OperationContext r1 = this.mAidlContext;
        r1.displayState = toAidlDisplayState(biometricContext.getDisplayState());
        OperationContext r2 = this.mAidlContext;
        r2.foldState = toAidlFoldState(biometricContext.getFoldState());
        this.mAidlContext.isCrypto = isCrypto;
        if (this.mAidlContext.operationState != null) goto L5;
    L7:
        setFirstSessionId(biometricContext);
        this.mIsDisplayOn = biometricContext.isDisplayOn();
        this.mDockState = biometricContext.getDockedState();
        this.mFoldState = biometricContext.getFoldState();
        this.mOrientation = biometricContext.getCurrentRotation();
        return this;
    L5:
        if (this.mAidlContext.operationState.getTag() != 0) goto L7;
        OperationState.FingerprintOperationState r3 = this.mAidlContext.operationState.getFingerprintOperationState();
        r3.isHardwareIgnoringTouches = biometricContext.isHardwareIgnoringTouches();
        goto L7
    }

    private static int toAidlDisplayState(int state) {
        switch(state) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 4;
    L7:
        return 3;
    L9:
        return 2;
    L11:
        return 1;
    }

    private static int toAidlFoldState(int state) {
        switch(state) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    }

    private void setFirstSessionId(BiometricContext biometricContext) {
        if (this.mIsBP == false) goto L8;
        this.mSessionInfo = biometricContext.getBiometricPromptSessionInfo();
        if (this.mSessionInfo == null) goto L12;
        OperationContext r0 = this.mAidlContext;
        r0.id = this.mSessionInfo.getId();
        this.mAidlContext.reason = 1;
        return;
    L12:
        this.mAidlContext.id = 0;
        this.mAidlContext.reason = 0;
        return;
    L8:
        this.mSessionInfo = biometricContext.getKeyguardEntrySessionInfo();
        if (this.mSessionInfo == null) goto L12;
        OperationContext r1 = this.mAidlContext;
        r1.id = this.mSessionInfo.getId();
        this.mAidlContext.reason = 2;
    }
}
