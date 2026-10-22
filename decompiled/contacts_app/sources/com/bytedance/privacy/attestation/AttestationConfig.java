package com.bytedance.privacy.attestation;

import com.bytedance.privacy.exception.BdPrivacyException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class AttestationConfig {
    private final String customInfo;
    private final boolean devHealthStatusRequired;
    private final boolean[] requestedIdFlags;

    /* JADX INFO: renamed from: com.bytedance.privacy.attestation.AttestationConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String customInfo;
        private boolean devHealthStatusRequired;
        private final boolean[] requestedIdFlags;

        public Builder() {
            this.requestedIdFlags = new boolean[IdType.values().length];
            this.devHealthStatusRequired = false;
        }

        static /* synthetic */ boolean[] access$000(Builder r0) {
            return r0.requestedIdFlags;
        }

        static /* synthetic */ String access$100(Builder r0) {
            return r0.customInfo;
        }

        static /* synthetic */ boolean access$200(Builder r0) {
            return r0.devHealthStatusRequired;
        }

        public Builder requestId(IdType r3) {
            this.requestedIdFlags[r3.ordinal()] = true;
            return this;
        }

        public Builder requestIds(IdType... r6) {
            int r0 = r6.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            IdType r2 = r6[r1];
            this.requestedIdFlags[r2.ordinal()] = true;
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder customInfo(String r3) throws BdPrivacyException {
            if (r3 == null) goto L12;
            if (r3.isEmpty() == true) goto L12;
            if (r3.getBytes(StandardCharsets.UTF_8).length > 1024) goto L10;
            this.customInfo = r3;
            return this;
        L10:
            throw new BdPrivacyException("customInfo too long (max 1024 bytes)");
        L12:
            throw new BdPrivacyException("customInfo must not be null or empty");
        }

        public Builder requestDeviceHealthStatus() {
            this.devHealthStatusRequired = true;
            return this;
        }

        public AttestationConfig build() {
            return new AttestationConfig(this, null);
        }
    }

    public static final enum IdType extends Enum<IdType> {
        private static final /* synthetic */ IdType[] $VALUES = null;
        public static final IdType RPDID = null;
        public static final IdType RPUID = null;
        public static final IdType UDID = null;

        private static /* synthetic */ IdType[] $values() {
            return new IdType[]{UDID, RPDID, RPUID};
        }

        static {
            UDID = new IdType("UDID", 0);
            RPDID = new IdType("RPDID", 1);
            RPUID = new IdType("RPUID", 2);
            $VALUES = $values();
        }

        private IdType(String r1, int r2) {
            super(r1, r2);
        }

        public static IdType valueOf(String r1) {
            return (IdType) Enum.valueOf(IdType.class, r1);
        }

        public static IdType[] values() {
            return (IdType[]) $VALUES.clone();
        }
    }

    /* synthetic */ AttestationConfig(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    private AttestationConfig(Builder r2) {
        this.requestedIdFlags = (boolean[]) Builder.access$000(r2).clone();
        this.customInfo = Builder.access$100(r2);
        this.devHealthStatusRequired = Builder.access$200(r2);
    }

    public boolean isIdRequested(IdType r1) {
        return this.requestedIdFlags[r1.ordinal()];
    }

    public String getCustomInfo() {
        return this.customInfo;
    }

    public boolean isDevHealthStatusRequired() {
        return this.devHealthStatusRequired;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AttestationConfig{requestedIds=[");
        IdType[] r1 = IdType.values();
        int r2 = r1.length;
        boolean r3 = true;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L10;
        IdType r6 = r1[r5];
        if (this.requestedIdFlags[r6.ordinal()] == false) goto L9;
        if (r3 == true) goto L8;
        r0.append(", ");
    L8:
        r0.append(r6.name());
        r3 = false;
    L9:
        r5 = r5 + 1;
        goto L3
    L10:
        r0.append("]");
        if (this.customInfo == null) goto L13;
        r0.append(", customInfo='").append(this.customInfo).append('\'');
    L13:
        r0.append(", devHealthStatusRequired=").append(this.devHealthStatusRequired);
        r0.append('}');
        return r0.toString();
    }
}
