package com.android.ttcjpaysdk.integrated.counter.launch;

import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ9\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/launch/ParallelLaunchLogger;", "", "()V", "LINK_LEGACY", "", "LINK_PARALLEL", "LINK_PARALLEL_FALLBACK", "TAG", "elapsedSince", "", "startAt", "(J)Ljava/lang/Long;", "logStage", "", "launchId", "stage", "elapsed", "detail", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ParallelLaunchLogger {
    public static final ParallelLaunchLogger INSTANCE = null;
    public static final String LINK_LEGACY = "legacy";
    public static final String LINK_PARALLEL = "parallel";
    public static final String LINK_PARALLEL_FALLBACK = "parallel_fallback";
    private static final String TAG = "ParallelLaunch";

    static {
        INSTANCE = new ParallelLaunchLogger();
    }

    private ParallelLaunchLogger() {
    }

    public final Long elapsedSince(long r100) {
        if (r100 > 0) goto L7;
        return null;
    L7:
        return Long.valueOf(System.currentTimeMillis() - r100);
    }

    public final void logStage(String r100, String r101, Long r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r103, "detail");
        Intrinsics.checkNotNullParameter(r104, "link");
        if (r100 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        if (r102 == null) goto L14;
        String r106 = "elapsed=" + r102.longValue() + "ms";
        if (r106 == null) goto L14;
    L15:
        CJLogger.d(TAG, "[ParallelLaunch][link=" + r104 + "][launchId=" + r100 + "][stage=" + r101 + "] " + r106 + ", detail=" + r103);
        return;
    L14:
        r106 = "elapsed=NA";
        goto L15
    L5:
        if (r100.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public static /* synthetic */ void logStage$default(ParallelLaunchLogger r100, String r101, String r102, Long r103, String r110, String r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = LINK_PARALLEL;
    L5:
        r100.logStage(r101, r102, r103, r110, r111);
    }
}
