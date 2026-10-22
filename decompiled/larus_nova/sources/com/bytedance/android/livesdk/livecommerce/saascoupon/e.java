package com.bytedance.android.livesdk.livecommerce.saascoupon;

import android.content.Context;
import bl2.g;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnimController;
import com.ss.android.lark.utils.statistics.PerfLog;
import el2.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f152869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SaasCouponService f152870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f152871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ el.b f152872d;

    public e(k r100, SaasCouponService r101, g r102, el.b r103) {
        this.f152869a = r100;
        this.f152870b = r101;
        this.f152871c = r102;
        this.f152872d = r103;
    }

    public final com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a a(Context r110, int r111, String r112, BottomRightAnimController r113, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.b r114, ef.a r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "animController");
        Intrinsics.checkNotNullParameter(r114, "viewProvider");
        Intrinsics.checkNotNullParameter(r210, "cardManager");
        g r100 = this.f152871c;
        el.b r101 = this.f152872d;
        k r102 = this.f152869a;
        gf.a r115 = new gf.a(r111);
        Function0<LiveRoomParams> r103 = this.f152870b.f152841o;
        if (r103 == null) goto L5;
        LiveRoomParams r104 = r103.invoke();
    L6:
        com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a r105 = new com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a(r110, r100, r101, r112, r113, r114, r102, r115, r104, ((Boolean) this.f152870b.f152840n.getValue()).booleanValue(), r210);
        this.f152870b.f152838l = r105;
        return r105;
    L5:
        r104 = null;
        goto L6
    }
}
