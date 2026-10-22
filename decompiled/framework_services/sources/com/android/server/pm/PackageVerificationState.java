package com.android.server.pm;

import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes2.dex */
class PackageVerificationState {
    private final SparseBooleanArray mExtendedTimeoutUids;
    private boolean mHasOptionalVerifier;
    private boolean mOptionalVerificationComplete;
    private boolean mOptionalVerificationPassed;
    private int mOptionalVerifierUid;
    private boolean mRequiredVerificationComplete;
    private boolean mRequiredVerificationPassed;
    private final SparseBooleanArray mRequiredVerifierUids;
    private boolean mSufficientVerificationComplete;
    private boolean mSufficientVerificationPassed;
    private final SparseBooleanArray mSufficientVerifierUids;
    private final SparseBooleanArray mUnrespondedRequiredVerifierUids;
    private final VerifyingSession mVerifyingSession;

    PackageVerificationState(VerifyingSession verifyingSession) {
        this.mVerifyingSession = verifyingSession;
        this.mSufficientVerifierUids = new SparseBooleanArray();
        this.mRequiredVerifierUids = new SparseBooleanArray();
        this.mUnrespondedRequiredVerifierUids = new SparseBooleanArray();
        this.mExtendedTimeoutUids = new SparseBooleanArray();
        this.mRequiredVerificationComplete = false;
        this.mRequiredVerificationPassed = true;
    }

    VerifyingSession getVerifyingSession() {
        return this.mVerifyingSession;
    }

    void addRequiredVerifierUid(int uid) {
        this.mRequiredVerifierUids.put(uid, true);
        this.mUnrespondedRequiredVerifierUids.put(uid, true);
    }

    boolean checkRequiredVerifierUid(int uid) {
        return this.mRequiredVerifierUids.get(uid, false);
    }

    void addSufficientVerifier(int uid) {
        this.mSufficientVerifierUids.put(uid, true);
    }

    public void addOptionalVerifier(int uid) {
        this.mOptionalVerifierUid = uid;
        this.mHasOptionalVerifier = true;
    }

    boolean checkSufficientVerifierUid(int uid) {
        return this.mSufficientVerifierUids.get(uid, false);
    }

    void setVerifierResponseOnTimeout(int uid, int code) {
        if (checkRequiredVerifierUid(uid) == true) goto L5;
        return;
    L5:
        this.mSufficientVerifierUids.clear();
        if (this.mUnrespondedRequiredVerifierUids.get(uid, false) == false) goto L9;
        setVerifierResponse(uid, code);
        return;
    }

    void setVerifierResponse(int uid, int code) {
        if (this.mRequiredVerifierUids.get(uid) == false) goto L12;
        switch(code) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L5;
        };
    L5:
        this.mRequiredVerificationPassed = false;
        this.mUnrespondedRequiredVerifierUids.clear();
        this.mSufficientVerifierUids.clear();
        this.mExtendedTimeoutUids.clear();
        goto L8
    L6:
        this.mSufficientVerifierUids.clear();
    L8:
        this.mExtendedTimeoutUids.delete(uid);
        this.mUnrespondedRequiredVerifierUids.delete(uid);
        if (this.mUnrespondedRequiredVerifierUids.size() != 0) goto L27;
        this.mRequiredVerificationComplete = true;
        return;
    L27:
        return;
    L12:
        if (this.mHasOptionalVerifier == false) goto L20;
        if (uid != this.mOptionalVerifierUid) goto L20;
        this.mOptionalVerificationComplete = true;
        switch(code) {
            case 1: goto L18;
            default: goto L17;
        };
    L17:
        this.mOptionalVerificationPassed = false;
        return;
    L18:
        this.mOptionalVerificationPassed = true;
        return;
    L20:
        if (this.mSufficientVerifierUids.get(uid) == false) goto L31;
        if (code != 1) goto L23;
        this.mSufficientVerificationPassed = true;
        this.mSufficientVerificationComplete = true;
    L23:
        this.mSufficientVerifierUids.delete(uid);
        if (this.mSufficientVerifierUids.size() != 0) goto L32;
        this.mSufficientVerificationComplete = true;
        return;
    L32:
        return;
    }

    void passRequiredVerification() {
        if (this.mUnrespondedRequiredVerifierUids.size() > 0) goto L7;
        this.mRequiredVerificationPassed = true;
        this.mRequiredVerificationComplete = true;
        return;
    L7:
        throw new RuntimeException("Required verifiers still present.");
    }

    boolean isVerificationComplete() {
        if (this.mRequiredVerifierUids.size() <= 0) goto L8;
        if (this.mRequiredVerificationComplete == true) goto L8;
        return false;
    L8:
        if (this.mHasOptionalVerifier == false) goto L13;
        if (this.mOptionalVerificationComplete == true) goto L13;
        return false;
    L13:
        if (this.mSufficientVerifierUids.size() != 0) goto L17;
        return true;
    L17:
        return this.mSufficientVerificationComplete;
    }

    boolean isInstallAllowed() {
        if (this.mRequiredVerifierUids.size() <= 0) goto L10;
        if (this.mRequiredVerificationComplete == true) goto L7;
    L8:
        return false;
    L7:
        if (this.mRequiredVerificationPassed == false) goto L8;
    L10:
        if (this.mHasOptionalVerifier == false) goto L15;
        if (this.mOptionalVerificationPassed == true) goto L15;
        return false;
    L15:
        if (this.mSufficientVerificationComplete == true) goto L17;
        return true;
    L17:
        return this.mSufficientVerificationPassed;
    }

    boolean extendTimeout(int uid) {
        if (checkRequiredVerifierUid(uid) == true) goto L5;
        return false;
    L5:
        if (timeoutExtended(uid) == true) goto L11;
        this.mExtendedTimeoutUids.append(uid, true);
        return true;
    L11:
        return false;
    }

    boolean timeoutExtended(int uid) {
        return this.mExtendedTimeoutUids.get(uid, false);
    }

    boolean areAllVerificationsComplete() {
        return isVerificationComplete();
    }
}
