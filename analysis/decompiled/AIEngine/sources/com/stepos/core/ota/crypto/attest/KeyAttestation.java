package com.stepos.core.ota.crypto.attest;

import ai.onnxruntime.a;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import h0.e;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeyAttestation {
    private final SecurityLevel attestationSecurityLevel;
    private final long attestationVersion;
    private final byte[] challenge;
    private final SecurityLevel keymasterSecurityLevel;
    private final long keymasterVersion;
    private final AuthorizationList softwareEnforced;
    private final AuthorizationList teeEnforced;
    private final String uniqueIdHex;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AttestationApplicationId {
        private final List<PackageInfo> packages;
        private final List<String> signatureDigestsHex;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class PackageInfo {
            private final String packageName;
            private final long version;

            public PackageInfo(String packageName, long j10) {
                g.f(packageName, "packageName");
                this.packageName = packageName;
                this.version = j10;
            }

            public static /* synthetic */ PackageInfo copy$default(PackageInfo packageInfo, String str, long j10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = packageInfo.packageName;
                }
                if ((i10 & 2) != 0) {
                    j10 = packageInfo.version;
                }
                return packageInfo.copy(str, j10);
            }

            public final String component1() {
                return this.packageName;
            }

            public final long component2() {
                return this.version;
            }

            public final PackageInfo copy(String packageName, long j10) {
                g.f(packageName, "packageName");
                return new PackageInfo(packageName, j10);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PackageInfo)) {
                    return false;
                }
                PackageInfo packageInfo = (PackageInfo) obj;
                return g.b(this.packageName, packageInfo.packageName) && this.version == packageInfo.version;
            }

            public final String getPackageName() {
                return this.packageName;
            }

            public final long getVersion() {
                return this.version;
            }

            public int hashCode() {
                return Long.hashCode(this.version) + (this.packageName.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sbL = d.l("PackageInfo(packageName=", this.version, this.packageName, ", version=");
                sbL.append(")");
                return sbL.toString();
            }
        }

        public AttestationApplicationId(List<PackageInfo> packages, List<String> signatureDigestsHex) {
            g.f(packages, "packages");
            g.f(signatureDigestsHex, "signatureDigestsHex");
            this.packages = packages;
            this.signatureDigestsHex = signatureDigestsHex;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AttestationApplicationId copy$default(AttestationApplicationId attestationApplicationId, List list, List list2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = attestationApplicationId.packages;
            }
            if ((i10 & 2) != 0) {
                list2 = attestationApplicationId.signatureDigestsHex;
            }
            return attestationApplicationId.copy(list, list2);
        }

        public final List<PackageInfo> component1() {
            return this.packages;
        }

        public final List<String> component2() {
            return this.signatureDigestsHex;
        }

        public final AttestationApplicationId copy(List<PackageInfo> packages, List<String> signatureDigestsHex) {
            g.f(packages, "packages");
            g.f(signatureDigestsHex, "signatureDigestsHex");
            return new AttestationApplicationId(packages, signatureDigestsHex);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AttestationApplicationId)) {
                return false;
            }
            AttestationApplicationId attestationApplicationId = (AttestationApplicationId) obj;
            return g.b(this.packages, attestationApplicationId.packages) && g.b(this.signatureDigestsHex, attestationApplicationId.signatureDigestsHex);
        }

        public final List<PackageInfo> getPackages() {
            return this.packages;
        }

        public final List<String> getSignatureDigestsHex() {
            return this.signatureDigestsHex;
        }

        public int hashCode() {
            return this.signatureDigestsHex.hashCode() + (this.packages.hashCode() * 31);
        }

        public String toString() {
            return "AttestationApplicationId(packages=" + this.packages + ", signatureDigestsHex=" + this.signatureDigestsHex + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AuthorizationList {
        private final Long algorithm;
        private final AttestationApplicationId attestationApplicationId;
        private final List<Long> digests;
        private final Long ecCurve;
        private final Long keySize;
        private final boolean noAuthRequired;
        private final Long origin;
        private final Long osPatchLevel;
        private final Long osVersion;
        private final List<Integer> otherTags;
        private final List<Long> paddings;
        private final List<Long> purposes;
        private final RootOfTrust rootOfTrust;

        public AuthorizationList() {
            this(null, null, null, null, null, null, false, null, null, null, null, null, null, 8191, null);
        }

        public static /* synthetic */ AuthorizationList copy$default(AuthorizationList authorizationList, List list, Long l10, Long l11, List list2, List list3, Long l12, boolean z, Long l13, Long l14, Long l15, RootOfTrust rootOfTrust, AttestationApplicationId attestationApplicationId, List list4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = authorizationList.purposes;
            }
            return authorizationList.copy(list, (i10 & 2) != 0 ? authorizationList.algorithm : l10, (i10 & 4) != 0 ? authorizationList.keySize : l11, (i10 & 8) != 0 ? authorizationList.digests : list2, (i10 & 16) != 0 ? authorizationList.paddings : list3, (i10 & 32) != 0 ? authorizationList.ecCurve : l12, (i10 & 64) != 0 ? authorizationList.noAuthRequired : z, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? authorizationList.origin : l13, (i10 & 256) != 0 ? authorizationList.osVersion : l14, (i10 & VadSessionManager.FRAME_BYTES) != 0 ? authorizationList.osPatchLevel : l15, (i10 & 1024) != 0 ? authorizationList.rootOfTrust : rootOfTrust, (i10 & 2048) != 0 ? authorizationList.attestationApplicationId : attestationApplicationId, (i10 & 4096) != 0 ? authorizationList.otherTags : list4);
        }

        public final List<Long> component1() {
            return this.purposes;
        }

        public final Long component10() {
            return this.osPatchLevel;
        }

        public final RootOfTrust component11() {
            return this.rootOfTrust;
        }

        public final AttestationApplicationId component12() {
            return this.attestationApplicationId;
        }

        public final List<Integer> component13() {
            return this.otherTags;
        }

        public final Long component2() {
            return this.algorithm;
        }

        public final Long component3() {
            return this.keySize;
        }

        public final List<Long> component4() {
            return this.digests;
        }

        public final List<Long> component5() {
            return this.paddings;
        }

        public final Long component6() {
            return this.ecCurve;
        }

        public final boolean component7() {
            return this.noAuthRequired;
        }

        public final Long component8() {
            return this.origin;
        }

        public final Long component9() {
            return this.osVersion;
        }

        public final AuthorizationList copy(List<Long> purposes, Long l10, Long l11, List<Long> digests, List<Long> paddings, Long l12, boolean z, Long l13, Long l14, Long l15, RootOfTrust rootOfTrust, AttestationApplicationId attestationApplicationId, List<Integer> otherTags) {
            g.f(purposes, "purposes");
            g.f(digests, "digests");
            g.f(paddings, "paddings");
            g.f(otherTags, "otherTags");
            return new AuthorizationList(purposes, l10, l11, digests, paddings, l12, z, l13, l14, l15, rootOfTrust, attestationApplicationId, otherTags);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AuthorizationList)) {
                return false;
            }
            AuthorizationList authorizationList = (AuthorizationList) obj;
            return g.b(this.purposes, authorizationList.purposes) && g.b(this.algorithm, authorizationList.algorithm) && g.b(this.keySize, authorizationList.keySize) && g.b(this.digests, authorizationList.digests) && g.b(this.paddings, authorizationList.paddings) && g.b(this.ecCurve, authorizationList.ecCurve) && this.noAuthRequired == authorizationList.noAuthRequired && g.b(this.origin, authorizationList.origin) && g.b(this.osVersion, authorizationList.osVersion) && g.b(this.osPatchLevel, authorizationList.osPatchLevel) && g.b(this.rootOfTrust, authorizationList.rootOfTrust) && g.b(this.attestationApplicationId, authorizationList.attestationApplicationId) && g.b(this.otherTags, authorizationList.otherTags);
        }

        public final Long getAlgorithm() {
            return this.algorithm;
        }

        public final AttestationApplicationId getAttestationApplicationId() {
            return this.attestationApplicationId;
        }

        public final List<Long> getDigests() {
            return this.digests;
        }

        public final Long getEcCurve() {
            return this.ecCurve;
        }

        public final Long getKeySize() {
            return this.keySize;
        }

        public final boolean getNoAuthRequired() {
            return this.noAuthRequired;
        }

        public final Long getOrigin() {
            return this.origin;
        }

        public final Long getOsPatchLevel() {
            return this.osPatchLevel;
        }

        public final Long getOsVersion() {
            return this.osVersion;
        }

        public final List<Integer> getOtherTags() {
            return this.otherTags;
        }

        public final List<Long> getPaddings() {
            return this.paddings;
        }

        public final List<Long> getPurposes() {
            return this.purposes;
        }

        public final RootOfTrust getRootOfTrust() {
            return this.rootOfTrust;
        }

        public int hashCode() {
            int iHashCode = this.purposes.hashCode() * 31;
            Long l10 = this.algorithm;
            int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
            Long l11 = this.keySize;
            int iB = e.b(this.paddings, e.b(this.digests, (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31, 31), 31);
            Long l12 = this.ecCurve;
            int iF = a.f((iB + (l12 == null ? 0 : l12.hashCode())) * 31, 31, this.noAuthRequired);
            Long l13 = this.origin;
            int iHashCode3 = (iF + (l13 == null ? 0 : l13.hashCode())) * 31;
            Long l14 = this.osVersion;
            int iHashCode4 = (iHashCode3 + (l14 == null ? 0 : l14.hashCode())) * 31;
            Long l15 = this.osPatchLevel;
            int iHashCode5 = (iHashCode4 + (l15 == null ? 0 : l15.hashCode())) * 31;
            RootOfTrust rootOfTrust = this.rootOfTrust;
            int iHashCode6 = (iHashCode5 + (rootOfTrust == null ? 0 : rootOfTrust.hashCode())) * 31;
            AttestationApplicationId attestationApplicationId = this.attestationApplicationId;
            return this.otherTags.hashCode() + ((iHashCode6 + (attestationApplicationId != null ? attestationApplicationId.hashCode() : 0)) * 31);
        }

        public String toString() {
            return "AuthorizationList(purposes=" + this.purposes + ", algorithm=" + this.algorithm + ", keySize=" + this.keySize + ", digests=" + this.digests + ", paddings=" + this.paddings + ", ecCurve=" + this.ecCurve + ", noAuthRequired=" + this.noAuthRequired + ", origin=" + this.origin + ", osVersion=" + this.osVersion + ", osPatchLevel=" + this.osPatchLevel + ", rootOfTrust=" + this.rootOfTrust + ", attestationApplicationId=" + this.attestationApplicationId + ", otherTags=" + this.otherTags + ")";
        }

        public AuthorizationList(List<Long> purposes, Long l10, Long l11, List<Long> digests, List<Long> paddings, Long l12, boolean z, Long l13, Long l14, Long l15, RootOfTrust rootOfTrust, AttestationApplicationId attestationApplicationId, List<Integer> otherTags) {
            g.f(purposes, "purposes");
            g.f(digests, "digests");
            g.f(paddings, "paddings");
            g.f(otherTags, "otherTags");
            this.purposes = purposes;
            this.algorithm = l10;
            this.keySize = l11;
            this.digests = digests;
            this.paddings = paddings;
            this.ecCurve = l12;
            this.noAuthRequired = z;
            this.origin = l13;
            this.osVersion = l14;
            this.osPatchLevel = l15;
            this.rootOfTrust = rootOfTrust;
            this.attestationApplicationId = attestationApplicationId;
            this.otherTags = otherTags;
        }

        public AuthorizationList(List list, Long l10, Long l11, List list2, List list3, Long l12, boolean z, Long l13, Long l14, Long l15, RootOfTrust rootOfTrust, AttestationApplicationId attestationApplicationId, List list4, int i10, kotlin.jvm.internal.e eVar) {
            this((i10 & 1) != 0 ? EmptyList.f10001a : list, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : l11, (i10 & 8) != 0 ? EmptyList.f10001a : list2, (i10 & 16) != 0 ? EmptyList.f10001a : list3, (i10 & 32) != 0 ? null : l12, (i10 & 64) != 0 ? false : z, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? null : l13, (i10 & 256) != 0 ? null : l14, (i10 & VadSessionManager.FRAME_BYTES) != 0 ? null : l15, (i10 & 1024) != 0 ? null : rootOfTrust, (i10 & 2048) == 0 ? attestationApplicationId : null, (i10 & 4096) != 0 ? EmptyList.f10001a : list4);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class RootOfTrust {
        private final boolean deviceLocked;
        private final String verifiedBootHashHex;
        private final String verifiedBootKeyHex;
        private final VerifiedBootState verifiedBootState;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class VerifiedBootState {
            private static final /* synthetic */ sb.a $ENTRIES;
            private static final /* synthetic */ VerifiedBootState[] $VALUES;
            public static final Companion Companion;

            /* renamed from: id, reason: collision with root package name */
            private final int f7540id;
            public static final VerifiedBootState VERIFIED = new VerifiedBootState("VERIFIED", 0, 0);
            public static final VerifiedBootState SELF_SIGNED = new VerifiedBootState("SELF_SIGNED", 1, 1);
            public static final VerifiedBootState UNVERIFIED = new VerifiedBootState("UNVERIFIED", 2, 2);
            public static final VerifiedBootState FAILED = new VerifiedBootState("FAILED", 3, 3);
            public static final VerifiedBootState UNKNOWN = new VerifiedBootState(FailStage.UNKNOWN, 4, -1);

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            public static final class Companion {
                public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                    this();
                }

                public final VerifiedBootState of(long j10) {
                    VerifiedBootState next;
                    Iterator<VerifiedBootState> it = VerifiedBootState.getEntries().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (next.getId() == ((int) j10)) {
                            break;
                        }
                    }
                    VerifiedBootState verifiedBootState = next;
                    return verifiedBootState == null ? VerifiedBootState.UNKNOWN : verifiedBootState;
                }

                private Companion() {
                }
            }

            private static final /* synthetic */ VerifiedBootState[] $values() {
                return new VerifiedBootState[]{VERIFIED, SELF_SIGNED, UNVERIFIED, FAILED, UNKNOWN};
            }

            static {
                VerifiedBootState[] verifiedBootStateArr$values = $values();
                $VALUES = verifiedBootStateArr$values;
                $ENTRIES = kotlin.enums.a.a(verifiedBootStateArr$values);
                Companion = new Companion(null);
            }

            private VerifiedBootState(String str, int i10, int i11) {
                this.f7540id = i11;
            }

            public static sb.a<VerifiedBootState> getEntries() {
                return $ENTRIES;
            }

            public static VerifiedBootState valueOf(String str) {
                return (VerifiedBootState) Enum.valueOf(VerifiedBootState.class, str);
            }

            public static VerifiedBootState[] values() {
                return (VerifiedBootState[]) $VALUES.clone();
            }

            public final int getId() {
                return this.f7540id;
            }
        }

        public RootOfTrust(String verifiedBootKeyHex, boolean z, VerifiedBootState verifiedBootState, String str) {
            g.f(verifiedBootKeyHex, "verifiedBootKeyHex");
            g.f(verifiedBootState, "verifiedBootState");
            this.verifiedBootKeyHex = verifiedBootKeyHex;
            this.deviceLocked = z;
            this.verifiedBootState = verifiedBootState;
            this.verifiedBootHashHex = str;
        }

        public static /* synthetic */ RootOfTrust copy$default(RootOfTrust rootOfTrust, String str, boolean z, VerifiedBootState verifiedBootState, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = rootOfTrust.verifiedBootKeyHex;
            }
            if ((i10 & 2) != 0) {
                z = rootOfTrust.deviceLocked;
            }
            if ((i10 & 4) != 0) {
                verifiedBootState = rootOfTrust.verifiedBootState;
            }
            if ((i10 & 8) != 0) {
                str2 = rootOfTrust.verifiedBootHashHex;
            }
            return rootOfTrust.copy(str, z, verifiedBootState, str2);
        }

        public final String component1() {
            return this.verifiedBootKeyHex;
        }

        public final boolean component2() {
            return this.deviceLocked;
        }

        public final VerifiedBootState component3() {
            return this.verifiedBootState;
        }

        public final String component4() {
            return this.verifiedBootHashHex;
        }

        public final RootOfTrust copy(String verifiedBootKeyHex, boolean z, VerifiedBootState verifiedBootState, String str) {
            g.f(verifiedBootKeyHex, "verifiedBootKeyHex");
            g.f(verifiedBootState, "verifiedBootState");
            return new RootOfTrust(verifiedBootKeyHex, z, verifiedBootState, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RootOfTrust)) {
                return false;
            }
            RootOfTrust rootOfTrust = (RootOfTrust) obj;
            return g.b(this.verifiedBootKeyHex, rootOfTrust.verifiedBootKeyHex) && this.deviceLocked == rootOfTrust.deviceLocked && this.verifiedBootState == rootOfTrust.verifiedBootState && g.b(this.verifiedBootHashHex, rootOfTrust.verifiedBootHashHex);
        }

        public final boolean getDeviceLocked() {
            return this.deviceLocked;
        }

        public final String getVerifiedBootHashHex() {
            return this.verifiedBootHashHex;
        }

        public final String getVerifiedBootKeyHex() {
            return this.verifiedBootKeyHex;
        }

        public final VerifiedBootState getVerifiedBootState() {
            return this.verifiedBootState;
        }

        public int hashCode() {
            int iHashCode = (this.verifiedBootState.hashCode() + a.f(this.verifiedBootKeyHex.hashCode() * 31, 31, this.deviceLocked)) * 31;
            String str = this.verifiedBootHashHex;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.verifiedBootKeyHex;
            boolean z = this.deviceLocked;
            VerifiedBootState verifiedBootState = this.verifiedBootState;
            String str2 = this.verifiedBootHashHex;
            StringBuilder sbM = d.m("RootOfTrust(verifiedBootKeyHex=", str, ", deviceLocked=", ", verifiedBootState=", z);
            sbM.append(verifiedBootState);
            sbM.append(", verifiedBootHashHex=");
            sbM.append(str2);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SecurityLevel {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ SecurityLevel[] $VALUES;
        public static final Companion Companion;

        /* renamed from: id, reason: collision with root package name */
        private final int f7541id;
        public static final SecurityLevel SOFTWARE = new SecurityLevel("SOFTWARE", 0, 0);
        public static final SecurityLevel TRUSTED_ENVIRONMENT = new SecurityLevel("TRUSTED_ENVIRONMENT", 1, 1);
        public static final SecurityLevel STRONG_BOX = new SecurityLevel("STRONG_BOX", 2, 2);
        public static final SecurityLevel UNKNOWN = new SecurityLevel(FailStage.UNKNOWN, 3, -1);

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                this();
            }

            public final SecurityLevel of(long j10) {
                SecurityLevel next;
                Iterator<SecurityLevel> it = SecurityLevel.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.getId() == ((int) j10)) {
                        break;
                    }
                }
                SecurityLevel securityLevel = next;
                return securityLevel == null ? SecurityLevel.UNKNOWN : securityLevel;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ SecurityLevel[] $values() {
            return new SecurityLevel[]{SOFTWARE, TRUSTED_ENVIRONMENT, STRONG_BOX, UNKNOWN};
        }

        static {
            SecurityLevel[] securityLevelArr$values = $values();
            $VALUES = securityLevelArr$values;
            $ENTRIES = kotlin.enums.a.a(securityLevelArr$values);
            Companion = new Companion(null);
        }

        private SecurityLevel(String str, int i10, int i11) {
            this.f7541id = i11;
        }

        public static sb.a<SecurityLevel> getEntries() {
            return $ENTRIES;
        }

        public static SecurityLevel valueOf(String str) {
            return (SecurityLevel) Enum.valueOf(SecurityLevel.class, str);
        }

        public static SecurityLevel[] values() {
            return (SecurityLevel[]) $VALUES.clone();
        }

        public final int getId() {
            return this.f7541id;
        }
    }

    public KeyAttestation(long j10, SecurityLevel attestationSecurityLevel, long j11, SecurityLevel keymasterSecurityLevel, byte[] challenge, String uniqueIdHex, AuthorizationList softwareEnforced, AuthorizationList teeEnforced) {
        g.f(attestationSecurityLevel, "attestationSecurityLevel");
        g.f(keymasterSecurityLevel, "keymasterSecurityLevel");
        g.f(challenge, "challenge");
        g.f(uniqueIdHex, "uniqueIdHex");
        g.f(softwareEnforced, "softwareEnforced");
        g.f(teeEnforced, "teeEnforced");
        this.attestationVersion = j10;
        this.attestationSecurityLevel = attestationSecurityLevel;
        this.keymasterVersion = j11;
        this.keymasterSecurityLevel = keymasterSecurityLevel;
        this.challenge = challenge;
        this.uniqueIdHex = uniqueIdHex;
        this.softwareEnforced = softwareEnforced;
        this.teeEnforced = teeEnforced;
    }

    public static /* synthetic */ KeyAttestation copy$default(KeyAttestation keyAttestation, long j10, SecurityLevel securityLevel, long j11, SecurityLevel securityLevel2, byte[] bArr, String str, AuthorizationList authorizationList, AuthorizationList authorizationList2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = keyAttestation.attestationVersion;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            securityLevel = keyAttestation.attestationSecurityLevel;
        }
        return keyAttestation.copy(j12, securityLevel, (i10 & 4) != 0 ? keyAttestation.keymasterVersion : j11, (i10 & 8) != 0 ? keyAttestation.keymasterSecurityLevel : securityLevel2, (i10 & 16) != 0 ? keyAttestation.challenge : bArr, (i10 & 32) != 0 ? keyAttestation.uniqueIdHex : str, (i10 & 64) != 0 ? keyAttestation.softwareEnforced : authorizationList, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? keyAttestation.teeEnforced : authorizationList2);
    }

    public final long component1() {
        return this.attestationVersion;
    }

    public final SecurityLevel component2() {
        return this.attestationSecurityLevel;
    }

    public final long component3() {
        return this.keymasterVersion;
    }

    public final SecurityLevel component4() {
        return this.keymasterSecurityLevel;
    }

    public final byte[] component5() {
        return this.challenge;
    }

    public final String component6() {
        return this.uniqueIdHex;
    }

    public final AuthorizationList component7() {
        return this.softwareEnforced;
    }

    public final AuthorizationList component8() {
        return this.teeEnforced;
    }

    public final KeyAttestation copy(long j10, SecurityLevel attestationSecurityLevel, long j11, SecurityLevel keymasterSecurityLevel, byte[] challenge, String uniqueIdHex, AuthorizationList softwareEnforced, AuthorizationList teeEnforced) {
        g.f(attestationSecurityLevel, "attestationSecurityLevel");
        g.f(keymasterSecurityLevel, "keymasterSecurityLevel");
        g.f(challenge, "challenge");
        g.f(uniqueIdHex, "uniqueIdHex");
        g.f(softwareEnforced, "softwareEnforced");
        g.f(teeEnforced, "teeEnforced");
        return new KeyAttestation(j10, attestationSecurityLevel, j11, keymasterSecurityLevel, challenge, uniqueIdHex, softwareEnforced, teeEnforced);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyAttestation)) {
            return false;
        }
        KeyAttestation keyAttestation = (KeyAttestation) obj;
        return this.attestationVersion == keyAttestation.attestationVersion && this.attestationSecurityLevel == keyAttestation.attestationSecurityLevel && this.keymasterVersion == keyAttestation.keymasterVersion && this.keymasterSecurityLevel == keyAttestation.keymasterSecurityLevel && g.b(this.challenge, keyAttestation.challenge) && g.b(this.uniqueIdHex, keyAttestation.uniqueIdHex) && g.b(this.softwareEnforced, keyAttestation.softwareEnforced) && g.b(this.teeEnforced, keyAttestation.teeEnforced);
    }

    public final SecurityLevel getAttestationSecurityLevel() {
        return this.attestationSecurityLevel;
    }

    public final long getAttestationVersion() {
        return this.attestationVersion;
    }

    public final byte[] getChallenge() {
        return this.challenge;
    }

    public final SecurityLevel getKeymasterSecurityLevel() {
        return this.keymasterSecurityLevel;
    }

    public final long getKeymasterVersion() {
        return this.keymasterVersion;
    }

    public final AuthorizationList getSoftwareEnforced() {
        return this.softwareEnforced;
    }

    public final AuthorizationList getTeeEnforced() {
        return this.teeEnforced;
    }

    public final String getUniqueIdHex() {
        return this.uniqueIdHex;
    }

    public int hashCode() {
        return this.teeEnforced.hashCode() + ((this.softwareEnforced.hashCode() + v1.d.a((Arrays.hashCode(this.challenge) + ((this.keymasterSecurityLevel.hashCode() + a0.a.c((this.attestationSecurityLevel.hashCode() + (Long.hashCode(this.attestationVersion) * 31)) * 31, this.keymasterVersion, 31)) * 31)) * 31, 31, this.uniqueIdHex)) * 31);
    }

    public String toString() {
        long j10 = this.attestationVersion;
        SecurityLevel securityLevel = this.attestationSecurityLevel;
        long j11 = this.keymasterVersion;
        SecurityLevel securityLevel2 = this.keymasterSecurityLevel;
        String string = Arrays.toString(this.challenge);
        String str = this.uniqueIdHex;
        AuthorizationList authorizationList = this.softwareEnforced;
        AuthorizationList authorizationList2 = this.teeEnforced;
        StringBuilder sb2 = new StringBuilder("KeyAttestation(attestationVersion=");
        sb2.append(j10);
        sb2.append(", attestationSecurityLevel=");
        sb2.append(securityLevel);
        a0.a.s(j11, ", keymasterVersion=", ", keymasterSecurityLevel=", sb2);
        sb2.append(securityLevel2);
        sb2.append(", challenge=");
        sb2.append(string);
        sb2.append(", uniqueIdHex=");
        sb2.append(str);
        sb2.append(", softwareEnforced=");
        sb2.append(authorizationList);
        sb2.append(", teeEnforced=");
        sb2.append(authorizationList2);
        sb2.append(")");
        return sb2.toString();
    }
}
