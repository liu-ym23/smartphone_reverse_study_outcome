package com.android.server.profcollect;

import android.provider.DeviceConfig;
import android.util.Log;
import com.android.internal.os.BackgroundThread;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes3.dex */
final class Utils {
    private static final int TRACE_COOLDOWN_SECONDS = 30;
    private static Instant lastTraceTime;

    public static /* synthetic */ void $r8$lambda$4AnkZ4N7v4pVtjALMTgogVI3G5o(IProfCollectd r0, String r1) {
        lambda$traceSystem$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$CkNXgWI7XkRgi2n7sB3S2tP_TnQ(IProfCollectd r0, String r1, String r2, int r3) {
        lambda$traceProcess$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$EqRtQPpuJSNDaHKUtkHeBHTn2C0(IProfCollectd r0, String r1) {
        lambda$traceSystem$1(r0, r1);
    }

    Utils() {
    }

    static {
        lastTraceTime = Instant.EPOCH;
    }

    static boolean withFrequency(String configName, int defaultFrequency) {
        int threshold = DeviceConfig.getInt("profcollect_native_boot", configName, defaultFrequency);
        int randomNum = ThreadLocalRandom.current().nextInt(100);
        if (randomNum >= threshold) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean traceSystem(final IProfCollectd iprofcollectd, final String eventName) {
        if (checkPrerequisites(iprofcollectd) == true) goto L6;
        return false;
    L6:
        BackgroundThread.get().getThreadHandler().post(new Utils$$ExternalSyntheticLambda2(iprofcollectd, eventName));
        return true;
    }

    private static /* synthetic */ void lambda$traceSystem$0(IProfCollectd iprofcollectd, String eventName) {
        iprofcollectd.trace_system(eventName);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Log.e(ProfcollectForwardingService.LOG_TAG, "Failed to initiate trace: " + e.getMessage());
    }

    static boolean traceSystem(final IProfCollectd iprofcollectd, final String eventName, int delayMs) {
        if (checkPrerequisites(iprofcollectd) == true) goto L6;
        return false;
    L6:
        BackgroundThread.get().getThreadHandler().postDelayed(new Utils$$ExternalSyntheticLambda0(iprofcollectd, eventName), delayMs);
        return true;
    }

    private static /* synthetic */ void lambda$traceSystem$1(IProfCollectd iprofcollectd, String eventName) {
        iprofcollectd.trace_system(eventName);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Log.e(ProfcollectForwardingService.LOG_TAG, "Failed to initiate trace: " + e.getMessage());
    }

    static boolean traceProcess(final IProfCollectd iprofcollectd, final String eventName, final String processName, final int durationMs) {
        if (checkPrerequisites(iprofcollectd) == true) goto L6;
        return false;
    L6:
        BackgroundThread.get().getThreadHandler().post(new Utils$$ExternalSyntheticLambda1(iprofcollectd, eventName, processName, durationMs));
        return true;
    }

    private static /* synthetic */ void lambda$traceProcess$2(IProfCollectd iprofcollectd, String eventName, String processName, int durationMs) {
        iprofcollectd.trace_process(eventName, processName, durationMs);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        Log.e(ProfcollectForwardingService.LOG_TAG, "Failed to initiate trace: " + e.getMessage());
    }

    private static boolean isInCooldownOrReset() {
        if (Instant.now().isBefore(lastTraceTime.plusSeconds(30)) == true) goto L6;
        lastTraceTime = Instant.now();
        return false;
    L6:
        return true;
    }

    private static boolean checkPrerequisites(IProfCollectd iprofcollectd) {
        if (iprofcollectd != null) goto L6;
        return false;
    L6:
        if (isInCooldownOrReset() == false) goto L9;
        return false;
    L9:
        if (ProfcollectForwardingService.sVerityEnforced == true) goto L11;
        return false;
    L11:
        if (ProfcollectForwardingService.sAdbActive == false) goto L13;
        return false;
    L13:
        if (ProfcollectForwardingService.sIsInteractive == true) goto L15;
        return false;
    L15:
        if (ProfcollectForwardingService.sIsBatteryLow == true) goto L21;
        return true;
    L21:
        return false;
    }
}
