package com.stepos.core.ota.push;

import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import com.stepos.core.ota.push.OtaPushEligibility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AutoUpdatePushLogic {
    private static final int CHARGING_MIN_BATTERY = 15;
    public static final AutoUpdatePushLogic INSTANCE = new AutoUpdatePushLogic();
    private static final int UNCHARGED_MIN_BATTERY = 50;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Check {
        private final String detail;
        private final String name;
        private final boolean pass;

        public Check(String name, boolean z, String detail) {
            g.f(name, "name");
            g.f(detail, "detail");
            this.name = name;
            this.pass = z;
            this.detail = detail;
        }

        public static /* synthetic */ Check copy$default(Check check, String str, boolean z, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = check.name;
            }
            if ((i10 & 2) != 0) {
                z = check.pass;
            }
            if ((i10 & 4) != 0) {
                str2 = check.detail;
            }
            return check.copy(str, z, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final boolean component2() {
            return this.pass;
        }

        public final String component3() {
            return this.detail;
        }

        public final Check copy(String name, boolean z, String detail) {
            g.f(name, "name");
            g.f(detail, "detail");
            return new Check(name, z, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Check)) {
                return false;
            }
            Check check = (Check) obj;
            return g.b(this.name, check.name) && this.pass == check.pass && g.b(this.detail, check.detail);
        }

        public final String getDetail() {
            return this.detail;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getPass() {
            return this.pass;
        }

        public int hashCode() {
            return this.detail.hashCode() + ai.onnxruntime.a.f(this.name.hashCode() * 31, 31, this.pass);
        }

        public String toString() {
            String str = this.name;
            boolean z = this.pass;
            return ai.onnxruntime.a.o(d.m("Check(name=", str, ", pass=", ", detail=", z), this.detail, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ForceEnv {
        private final boolean ctaGranted;
        private final long freeBytes;
        private final long minFreeBytes;
        private final boolean wifiValidated;

        public ForceEnv(boolean z, boolean z3, long j10, long j11) {
            this.ctaGranted = z;
            this.wifiValidated = z3;
            this.freeBytes = j10;
            this.minFreeBytes = j11;
        }

        public static /* synthetic */ ForceEnv copy$default(ForceEnv forceEnv, boolean z, boolean z3, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z = forceEnv.ctaGranted;
            }
            if ((i10 & 2) != 0) {
                z3 = forceEnv.wifiValidated;
            }
            if ((i10 & 4) != 0) {
                j10 = forceEnv.freeBytes;
            }
            if ((i10 & 8) != 0) {
                j11 = forceEnv.minFreeBytes;
            }
            long j12 = j11;
            return forceEnv.copy(z, z3, j10, j12);
        }

        public final boolean component1() {
            return this.ctaGranted;
        }

        public final boolean component2() {
            return this.wifiValidated;
        }

        public final long component3() {
            return this.freeBytes;
        }

        public final long component4() {
            return this.minFreeBytes;
        }

        public final ForceEnv copy(boolean z, boolean z3, long j10, long j11) {
            return new ForceEnv(z, z3, j10, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForceEnv)) {
                return false;
            }
            ForceEnv forceEnv = (ForceEnv) obj;
            return this.ctaGranted == forceEnv.ctaGranted && this.wifiValidated == forceEnv.wifiValidated && this.freeBytes == forceEnv.freeBytes && this.minFreeBytes == forceEnv.minFreeBytes;
        }

        public final boolean getCtaGranted() {
            return this.ctaGranted;
        }

        public final long getFreeBytes() {
            return this.freeBytes;
        }

        public final long getMinFreeBytes() {
            return this.minFreeBytes;
        }

        public final boolean getWifiValidated() {
            return this.wifiValidated;
        }

        public int hashCode() {
            return Long.hashCode(this.minFreeBytes) + a0.a.c(ai.onnxruntime.a.f(Boolean.hashCode(this.ctaGranted) * 31, 31, this.wifiValidated), this.freeBytes, 31);
        }

        public String toString() {
            boolean z = this.ctaGranted;
            boolean z3 = this.wifiValidated;
            long j10 = this.freeBytes;
            long j11 = this.minFreeBytes;
            StringBuilder sb2 = new StringBuilder("ForceEnv(ctaGranted=");
            sb2.append(z);
            sb2.append(", wifiValidated=");
            sb2.append(z3);
            sb2.append(", freeBytes=");
            sb2.append(j10);
            return a0.a.d(j11, ", minFreeBytes=", ")", sb2);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SilentEnv {
        private final int batteryPct;
        private final long candidateBytes;
        private final boolean charging;
        private final boolean ctaFirmware;
        private final boolean ctaGranted;
        private final long freeBytes;
        private final long maxUnchargedBytes;
        private final long maxUnchargedMs;
        private final long minFreeBytes;
        private final boolean screenOff;
        private final boolean switchOn;
        private final long unchargedBytesSoFar;
        private final long unchargedElapsedMs;
        private final boolean wifiValidated;

        public SilentEnv(boolean z, boolean z3, boolean z10, boolean z11, boolean z12, int i10, boolean z13, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.switchOn = z;
            this.ctaGranted = z3;
            this.ctaFirmware = z10;
            this.wifiValidated = z11;
            this.charging = z12;
            this.batteryPct = i10;
            this.screenOff = z13;
            this.freeBytes = j10;
            this.minFreeBytes = j11;
            this.candidateBytes = j12;
            this.unchargedBytesSoFar = j13;
            this.unchargedElapsedMs = j14;
            this.maxUnchargedBytes = j15;
            this.maxUnchargedMs = j16;
        }

        public static /* synthetic */ SilentEnv copy$default(SilentEnv silentEnv, boolean z, boolean z3, boolean z10, boolean z11, boolean z12, int i10, boolean z13, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i11, Object obj) {
            long j17;
            long j18;
            boolean z14 = (i11 & 1) != 0 ? silentEnv.switchOn : z;
            boolean z15 = (i11 & 2) != 0 ? silentEnv.ctaGranted : z3;
            boolean z16 = (i11 & 4) != 0 ? silentEnv.ctaFirmware : z10;
            boolean z17 = (i11 & 8) != 0 ? silentEnv.wifiValidated : z11;
            boolean z18 = (i11 & 16) != 0 ? silentEnv.charging : z12;
            int i12 = (i11 & 32) != 0 ? silentEnv.batteryPct : i10;
            boolean z19 = (i11 & 64) != 0 ? silentEnv.screenOff : z13;
            long j19 = (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? silentEnv.freeBytes : j10;
            long j20 = (i11 & 256) != 0 ? silentEnv.minFreeBytes : j11;
            long j21 = (i11 & VadSessionManager.FRAME_BYTES) != 0 ? silentEnv.candidateBytes : j12;
            boolean z20 = z14;
            boolean z21 = z15;
            long j22 = (i11 & 1024) != 0 ? silentEnv.unchargedBytesSoFar : j13;
            long j23 = (i11 & 2048) != 0 ? silentEnv.unchargedElapsedMs : j14;
            long j24 = (i11 & 4096) != 0 ? silentEnv.maxUnchargedBytes : j15;
            if ((i11 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0) {
                j18 = j24;
                j17 = silentEnv.maxUnchargedMs;
            } else {
                j17 = j16;
                j18 = j24;
            }
            return silentEnv.copy(z20, z21, z16, z17, z18, i12, z19, j19, j20, j21, j22, j23, j18, j17);
        }

        public final boolean component1() {
            return this.switchOn;
        }

        public final long component10() {
            return this.candidateBytes;
        }

        public final long component11() {
            return this.unchargedBytesSoFar;
        }

        public final long component12() {
            return this.unchargedElapsedMs;
        }

        public final long component13() {
            return this.maxUnchargedBytes;
        }

        public final long component14() {
            return this.maxUnchargedMs;
        }

        public final boolean component2() {
            return this.ctaGranted;
        }

        public final boolean component3() {
            return this.ctaFirmware;
        }

        public final boolean component4() {
            return this.wifiValidated;
        }

        public final boolean component5() {
            return this.charging;
        }

        public final int component6() {
            return this.batteryPct;
        }

        public final boolean component7() {
            return this.screenOff;
        }

        public final long component8() {
            return this.freeBytes;
        }

        public final long component9() {
            return this.minFreeBytes;
        }

        public final SilentEnv copy(boolean z, boolean z3, boolean z10, boolean z11, boolean z12, int i10, boolean z13, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
            return new SilentEnv(z, z3, z10, z11, z12, i10, z13, j10, j11, j12, j13, j14, j15, j16);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SilentEnv)) {
                return false;
            }
            SilentEnv silentEnv = (SilentEnv) obj;
            return this.switchOn == silentEnv.switchOn && this.ctaGranted == silentEnv.ctaGranted && this.ctaFirmware == silentEnv.ctaFirmware && this.wifiValidated == silentEnv.wifiValidated && this.charging == silentEnv.charging && this.batteryPct == silentEnv.batteryPct && this.screenOff == silentEnv.screenOff && this.freeBytes == silentEnv.freeBytes && this.minFreeBytes == silentEnv.minFreeBytes && this.candidateBytes == silentEnv.candidateBytes && this.unchargedBytesSoFar == silentEnv.unchargedBytesSoFar && this.unchargedElapsedMs == silentEnv.unchargedElapsedMs && this.maxUnchargedBytes == silentEnv.maxUnchargedBytes && this.maxUnchargedMs == silentEnv.maxUnchargedMs;
        }

        public final int getBatteryPct() {
            return this.batteryPct;
        }

        public final long getCandidateBytes() {
            return this.candidateBytes;
        }

        public final boolean getCharging() {
            return this.charging;
        }

        public final boolean getCtaFirmware() {
            return this.ctaFirmware;
        }

        public final boolean getCtaGranted() {
            return this.ctaGranted;
        }

        public final long getFreeBytes() {
            return this.freeBytes;
        }

        public final long getMaxUnchargedBytes() {
            return this.maxUnchargedBytes;
        }

        public final long getMaxUnchargedMs() {
            return this.maxUnchargedMs;
        }

        public final long getMinFreeBytes() {
            return this.minFreeBytes;
        }

        public final boolean getScreenOff() {
            return this.screenOff;
        }

        public final boolean getSwitchOn() {
            return this.switchOn;
        }

        public final long getUnchargedBytesSoFar() {
            return this.unchargedBytesSoFar;
        }

        public final long getUnchargedElapsedMs() {
            return this.unchargedElapsedMs;
        }

        public final boolean getWifiValidated() {
            return this.wifiValidated;
        }

        public int hashCode() {
            return Long.hashCode(this.maxUnchargedMs) + a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.batteryPct, ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.f(Boolean.hashCode(this.switchOn) * 31, 31, this.ctaGranted), 31, this.ctaFirmware), 31, this.wifiValidated), 31, this.charging), 31), 31, this.screenOff), this.freeBytes, 31), this.minFreeBytes, 31), this.candidateBytes, 31), this.unchargedBytesSoFar, 31), this.unchargedElapsedMs, 31), this.maxUnchargedBytes, 31);
        }

        public String toString() {
            boolean z = this.switchOn;
            boolean z3 = this.ctaGranted;
            boolean z10 = this.ctaFirmware;
            boolean z11 = this.wifiValidated;
            boolean z12 = this.charging;
            int i10 = this.batteryPct;
            boolean z13 = this.screenOff;
            long j10 = this.freeBytes;
            long j11 = this.minFreeBytes;
            long j12 = this.candidateBytes;
            long j13 = this.unchargedBytesSoFar;
            long j14 = this.unchargedElapsedMs;
            long j15 = this.maxUnchargedBytes;
            long j16 = this.maxUnchargedMs;
            StringBuilder sb2 = new StringBuilder("SilentEnv(switchOn=");
            sb2.append(z);
            sb2.append(", ctaGranted=");
            sb2.append(z3);
            sb2.append(", ctaFirmware=");
            sb2.append(z10);
            sb2.append(", wifiValidated=");
            sb2.append(z11);
            sb2.append(", charging=");
            sb2.append(z12);
            sb2.append(", batteryPct=");
            sb2.append(i10);
            sb2.append(", screenOff=");
            sb2.append(z13);
            sb2.append(", freeBytes=");
            sb2.append(j10);
            a0.a.s(j11, ", minFreeBytes=", ", candidateBytes=", sb2);
            sb2.append(j12);
            a0.a.s(j13, ", unchargedBytesSoFar=", ", unchargedElapsedMs=", sb2);
            sb2.append(j14);
            a0.a.s(j15, ", maxUnchargedBytes=", ", maxUnchargedMs=", sb2);
            return ai.onnxruntime.a.m(sb2, j16, ")");
        }
    }

    private AutoUpdatePushLogic() {
    }

    public static /* synthetic */ OtaPushEligibility.Skip decideEligibility$default(AutoUpdatePushLogic autoUpdatePushLogic, int i10, int i11, boolean z, boolean z3, boolean z10, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            z3 = false;
        }
        if ((i12 & 16) != 0) {
            z10 = false;
        }
        return autoUpdatePushLogic.decideEligibility(i10, i11, z, z3, z10);
    }

    public final boolean allPass(List<Check> checks) {
        g.f(checks, "checks");
        if (checks.isEmpty()) {
            return true;
        }
        Iterator<T> it = checks.iterator();
        while (it.hasNext()) {
            if (!((Check) it.next()).getPass()) {
                return false;
            }
        }
        return true;
    }

    public final boolean batchThrottleAllowed(boolean z, long j10, long j11) {
        return z || j10 >= j11;
    }

    public final OtaPushEligibility.Skip decideEligibility(int i10, int i11, boolean z, boolean z3, boolean z10) {
        if (z10) {
            return OtaPushEligibility.Skip.USER_UNINSTALLED;
        }
        if (z3) {
            if (i10 > 0) {
                return OtaPushEligibility.Skip.UP_TO_DATE;
            }
            if (z) {
                return OtaPushEligibility.Skip.IN_PROGRESS;
            }
            return null;
        }
        if (i10 <= 0) {
            return OtaPushEligibility.Skip.NOT_INSTALLED;
        }
        if (1 <= i11 && i11 <= i10) {
            return OtaPushEligibility.Skip.UP_TO_DATE;
        }
        if (z) {
            return OtaPushEligibility.Skip.IN_PROGRESS;
        }
        return null;
    }

    public final List<String> failedNames(List<Check> checks) {
        g.f(checks, "checks");
        ArrayList arrayList = new ArrayList();
        for (Object obj : checks) {
            if (!((Check) obj).getPass()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(m.Z(arrayList, 10));
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            arrayList2.add(((Check) obj2).getName());
        }
        return arrayList2;
    }

    public final List<Check> forceChecks(ForceEnv env) {
        g.f(env, "env");
        long j10 = 1024;
        return m.b0(new Check("cta_granted", env.getCtaGranted(), "granted=" + env.getCtaGranted()), new Check("wifi_validated", env.getWifiValidated(), "wifi=" + env.getWifiValidated()), new Check("free_space", env.getFreeBytes() >= env.getMinFreeBytes(), ai.onnxruntime.a.m(ai.onnxruntime.a.q((env.getFreeBytes() / j10) / j10, "free=", "MB need="), (env.getMinFreeBytes() / j10) / j10, "MB")));
    }

    public final List<Check> silentChecks(SilentEnv env) {
        g.f(env, "env");
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new Check("wifi_auto_update_switch", env.getSwitchOn(), "on=" + env.getSwitchOn()));
        arrayList.add(new Check("cta_granted", env.getCtaGranted(), "granted=" + env.getCtaGranted()));
        arrayList.add(new Check("not_cta_firmware", env.getCtaFirmware() ^ true, "firmwareMode=" + env.getCtaFirmware()));
        arrayList.add(new Check("wifi_validated", env.getWifiValidated(), "wifi=" + env.getWifiValidated()));
        boolean z = env.getCharging() && env.getBatteryPct() > 15;
        boolean z3 = !env.getCharging() && env.getBatteryPct() > 50 && env.getUnchargedElapsedMs() <= env.getMaxUnchargedMs();
        boolean z10 = z || z3;
        arrayList.add(new Check("power_battery", z10, "charging=" + env.getCharging() + " bat=" + env.getBatteryPct() + " screenOff=" + env.getScreenOff() + "(不参与门禁) unchargedElapsedMs=" + env.getUnchargedElapsedMs() + " (5a=" + z + " 5b=" + z3 + ")"));
        long candidateBytes = env.getCandidateBytes() + env.getUnchargedBytesSoFar();
        boolean z11 = env.getCharging() || candidateBytes <= env.getMaxUnchargedBytes();
        boolean charging = env.getCharging();
        long j10 = 1024;
        long maxUnchargedBytes = (env.getMaxUnchargedBytes() / j10) / j10;
        StringBuilder sb2 = new StringBuilder("charging=");
        sb2.append(charging);
        sb2.append(" projected=");
        sb2.append((candidateBytes / j10) / j10);
        arrayList.add(new Check("uncharged_bytes_budget", z11, a0.a.d(maxUnchargedBytes, "MB limit=", "MB", sb2)));
        arrayList.add(new Check("free_space", env.getFreeBytes() >= env.getMinFreeBytes(), ai.onnxruntime.a.m(ai.onnxruntime.a.q((env.getFreeBytes() / j10) / j10, "free=", "MB need="), (env.getMinFreeBytes() / j10) / j10, "MB")));
        return arrayList;
    }
}
