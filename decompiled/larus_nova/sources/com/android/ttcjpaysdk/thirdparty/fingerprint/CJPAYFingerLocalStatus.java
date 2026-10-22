package com.android.ttcjpaysdk.thirdparty.fingerprint;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class CJPAYFingerLocalStatus {
    private final boolean hasEnrolledFingerprints;
    private final boolean isHardwareDetected;
    private final boolean mIsEmptyIv;
    private final boolean mIsEmptyToken;
    private final boolean mIsJailBroken;
    private final boolean mIsLowVersion;
    private final boolean mIsSupportFingerprint;

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.thirdparty.fingerprint.CJPAYFingerLocalStatus$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private boolean hasEnrolledFingerprints;
        private boolean isHardwareDetected;
        private boolean mIsEmptyIv;
        private boolean mIsEmptyToken;
        private boolean mIsJailBroken;
        private boolean mIsLowVersion;
        private boolean mIsSupportFingerprint;

        public Builder() {
        }

        public CJPAYFingerLocalStatus build() {
            return new CJPAYFingerLocalStatus(this, null);
        }

        public static /* synthetic */ boolean access$000(Builder r100) {
            return r100.mIsSupportFingerprint;
        }

        public static /* synthetic */ boolean access$100(Builder r100) {
            return r100.mIsJailBroken;
        }

        public static /* synthetic */ boolean access$200(Builder r100) {
            return r100.mIsEmptyToken;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.mIsEmptyIv;
        }

        public static /* synthetic */ boolean access$400(Builder r100) {
            return r100.mIsLowVersion;
        }

        public static /* synthetic */ boolean access$500(Builder r100) {
            return r100.hasEnrolledFingerprints;
        }

        public static /* synthetic */ boolean access$600(Builder r100) {
            return r100.isHardwareDetected;
        }

        public Builder setEmptyIv(boolean r100) {
            this.mIsEmptyIv = r100;
            return this;
        }

        public Builder setEmptyToken(boolean r100) {
            this.mIsEmptyToken = r100;
            return this;
        }

        public Builder setHardwareDetected(boolean r100) {
            this.isHardwareDetected = r100;
            return this;
        }

        public Builder setHasEnrolledFingerprints(boolean r100) {
            this.hasEnrolledFingerprints = r100;
            return this;
        }

        public Builder setJailBroken(boolean r100) {
            this.mIsJailBroken = r100;
            return this;
        }

        public Builder setLowVersion(boolean r100) {
            this.mIsLowVersion = r100;
            return this;
        }

        public Builder setSupportFingerprint(boolean r100) {
            this.mIsSupportFingerprint = r100;
            return this;
        }
    }

    public boolean enableFingerprint() {
        if (this.mIsSupportFingerprint == true) goto L5;
    L13:
        return false;
    L5:
        if (this.mIsJailBroken == true) goto L13;
        if (this.mIsEmptyToken == true) goto L13;
        if (this.mIsEmptyIv == true) goto L13;
        if (this.mIsLowVersion == true) goto L13;
        return true;
    }

    public boolean supportBio() {
        if (this.mIsSupportFingerprint == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mIsJailBroken == true) goto L9;
        if (this.mIsLowVersion == true) goto L9;
        return true;
    }

    public Map<String, Object> toMap() {
        HashMap r100 = new HashMap();
        r100.put("isSupportFingerprint", Boolean.valueOf(this.mIsSupportFingerprint));
        r100.put("isJailBroken", Boolean.valueOf(this.mIsJailBroken));
        r100.put("isEmptyToken", Boolean.valueOf(this.mIsEmptyToken));
        r100.put("isEmptyIv", Boolean.valueOf(this.mIsEmptyIv));
        r100.put("isLowVersion", Boolean.valueOf(this.mIsLowVersion));
        r100.put("hasEnrolledFingerprints", Boolean.valueOf(this.hasEnrolledFingerprints));
        r100.put("isHardwareDetected", Boolean.valueOf(this.isHardwareDetected));
        return r100;
    }

    public boolean isEmptyIv() {
        return this.mIsEmptyIv;
    }

    public boolean isEmptyToken() {
        return this.mIsEmptyToken;
    }

    public boolean isJailBroken() {
        return this.mIsJailBroken;
    }

    public boolean isLowVersion() {
        return this.mIsLowVersion;
    }

    public boolean isSupportFingerprint() {
        return this.mIsSupportFingerprint;
    }

    private CJPAYFingerLocalStatus(Builder r100) {
        this.mIsSupportFingerprint = Builder.access$000(r100);
        this.mIsJailBroken = Builder.access$100(r100);
        this.mIsEmptyToken = Builder.access$200(r100);
        this.mIsEmptyIv = Builder.access$300(r100);
        this.mIsLowVersion = Builder.access$400(r100);
        this.hasEnrolledFingerprints = Builder.access$500(r100);
        this.isHardwareDetected = Builder.access$600(r100);
    }

    public /* synthetic */ CJPAYFingerLocalStatus(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
