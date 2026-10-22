package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.settings.config.k0;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PSMessageHeatState f140316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f140317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f140318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PSMessageHeatState f140319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f140320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f140321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Queue<Integer> f140322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f140323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k0 f140324i;

    public static final class a {
    }

    static {
    }

    public final boolean a(PSMessageHeatState r100) {
        if (this.f140318c != this.f140324i.heatStatusChangeThreshold) goto L10;
        boolean r101 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f140331a;
        String r102 = "当前计数为" + this.f140318c + "，热度状态从" + this.f140316a.name() + "切换到" + r100.name() + ", 重置计数和记录状态";
        Intrinsics.checkNotNullParameter(r102, "successReason");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f140331a == false) goto L8;
        ALogger.e("PS_MESSAGE_HEAT", r102);
    L8:
        ALogger.i("PS_MESSAGE_HEAT", "heat state transform from " + this.f140316a.name() + " to " + r100.name() + ", reset record status");
        this.f140316a = r100;
        this.f140318c = 0;
        this.f140319d = null;
        return true;
    L10:
        boolean r103 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f140331a;
        String r104 = "状态更新失败，当前计数为" + this.f140318c + ", 切换状态计数阈值为" + this.f140324i.heatStatusChangeThreshold;
        Intrinsics.checkNotNullParameter(r104, "failReason");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f140331a == false) goto L14;
        ALogger.e("PS_MESSAGE_HEAT", r104);
    L14:
        return false;
    }

    public l(int r100, k0 r101) {
        Intrinsics.checkNotNullParameter(r101, "heatConfig");
        this.f140324i = r101;
        this.f140320e = true;
        int r102 = r101.chatCountDuration;
        int r103 = r101.heatStatusCalculateInterval;
        if (r103 > 0) goto L5;
        r103 = 5;
    L5:
        this.f140321f = Math.max(1, r102 / r103);
        this.f140322g = new ArrayDeque();
        if (r101.heatStateMockValue == 0) goto L27;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L27;
        PSMessageHeatState.a r104 = PSMessageHeatState.Companion;
        int r105 = r101.heatStateMockValue;
        r104.getClass();
        PSMessageHeatState[] r106 = PSMessageHeatState.values();
        int r107 = r106.length;
        int r108 = 0;
    L10:
        if (r108 >= r107) goto L18;
        PSMessageHeatState r109 = r106[r108];
        if (r109.getValue() != r105) goto L14;
        boolean r110 = true;
    L15:
        if (r110 == true) goto L19;
        r108 = r108 + 1;
    L19:
        if (r109 != null) goto L21;
        r109 = PSMessageHeatState.NORMAL;
    L21:
        this.f140316a = r109;
        boolean r111 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f140331a;
        Intrinsics.checkNotNullParameter(r109, "heatState");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f140331a == false) goto L25;
        ALogger.e("PS_MESSAGE_HEAT", "mock的热度状态为" + r109);
    L25:
        this.f140323h = true;
        return;
    L14:
        r110 = false;
        goto L15
    L18:
        r109 = null;
    L27:
        if (r100 < r101.acuHotThreshold) goto L30;
        PSMessageHeatState r112 = PSMessageHeatState.HOT;
    L33:
        this.f140316a = r112;
        ALogger.i("PS_MESSAGE_HEAT", "init user count is " + r100 + ", heat state is " + this.f140316a.name());
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.c(this.f140316a, r100);
        this.f140323h = false;
        return;
    L30:
        if (r100 >= r101.acuColdThreshold) goto L32;
        r112 = PSMessageHeatState.COLD;
        goto L33
    L32:
        r112 = PSMessageHeatState.NORMAL;
        goto L33
    }
}
