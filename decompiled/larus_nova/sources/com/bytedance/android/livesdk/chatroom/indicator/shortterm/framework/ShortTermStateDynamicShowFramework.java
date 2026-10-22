package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.s0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p;
import com.bytedance.android.livesdkapi.sti.framework.IShortTermStateDynamicShowFramework;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ju1.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ShortTermStateDynamicShowFramework implements IShortTermStateDynamicShowFramework {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<n> f106610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f106611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public bu0.b f106612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f106613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MiddlewareRoomContext f106614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f106615f;

    @Override // com.bytedance.android.livesdkapi.sti.framework.IShortTermStateDynamicShowFramework
    public final void onDestory() {
        IShortTermStateDynamicShowFramework.DefaultImpls.onDestory(this);
        this.f106611b.dispose();
        this.f106611b.clear();
    }

    public ShortTermStateDynamicShowFramework(Context r100, MiddlewareRoomContext r110, DataCenter r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "roomContext");
        Intrinsics.checkNotNullParameter(r111, "dataCenter");
        this.f106614e = r110;
        this.f106615f = r111;
        PropertyOwner<n> r101 = null;
        if (r110 == null) goto L9;
        j<IDynamicStrategyContext> r112 = r110.getDynamicStrategy();
        if (r112 == null) goto L9;
        IDynamicStrategyContext r113 = r112.getValue();
        if (r113 == null) goto L9;
        PropertyOwner<n> r114 = r113.getStrategy("short_touch_tempstate_lottery_activity");
    L10:
        if (r110 == null) goto L16;
        j<IDynamicStrategyContext> r102 = r110.getDynamicStrategy();
        if (r102 == null) goto L16;
        IDynamicStrategyContext r103 = r102.getValue();
        if (r103 == null) goto L16;
        PropertyOwner<n> r104 = r103.getStrategy("short_touch_tempstate_lottery_interest");
    L17:
        if (r110 == null) goto L23;
        j<IDynamicStrategyContext> r105 = r110.getDynamicStrategy();
        if (r105 == null) goto L23;
        IDynamicStrategyContext r106 = r105.getValue();
        if (r106 == null) goto L23;
        PropertyOwner<n> r107 = r106.getStrategy("short_touch_tempstate_redpack_interest");
    L24:
        if (r110 == null) goto L30;
        j<IDynamicStrategyContext> r108 = r110.getDynamicStrategy();
        if (r108 == null) goto L30;
        IDynamicStrategyContext r109 = r108.getValue();
        if (r109 == null) goto L30;
        PropertyOwner<n> r115 = r109.getStrategy("short_touch_tempstate_redpack_behavior");
    L31:
        this.f106610a = r115;
        if (r110 == null) goto L38;
        j<IDynamicStrategyContext> r116 = r110.getDynamicStrategy();
        if (r116 == null) goto L38;
        IDynamicStrategyContext r117 = r116.getValue();
        if (r117 == null) goto L38;
        PropertyOwner<n> r118 = r117.getStrategy("short_touch_tempstate_redpack_entry_type");
    L39:
        if (r110 == null) goto L45;
        j<IDynamicStrategyContext> r119 = r110.getDynamicStrategy();
        if (r119 == null) goto L45;
        IDynamicStrategyContext r120 = r119.getValue();
        if (r120 == null) goto L45;
        PropertyOwner<n> r121 = r120.getStrategy("short_touch_tempstate_redpack_match_amunt");
    L46:
        if (r110 == null) goto L52;
        j<IDynamicStrategyContext> r122 = r110.getDynamicStrategy();
        if (r122 == null) goto L52;
        IDynamicStrategyContext r123 = r122.getValue();
        if (r123 == null) goto L52;
        r101 = r123.getStrategy("short_touch_tempstate_redpack_user_wish_tobuy");
    L52:
        Boolean r124 = s0.f65404a.getValue();
        CompositeDisposable r125 = new CompositeDisposable();
        this.f106611b = r125;
        this.f106613d = new Handler(Looper.getMainLooper());
        if (r114 == null) goto L57;
        Disposable r126 = p.a(r114, new AnonymousClass1(this));
        if (r126 == null) goto L57;
        RxUtilKt.c(r126, r125);
    L57:
        if (r104 == null) goto L61;
        Disposable r127 = p.a(r104, new AnonymousClass2(this));
        if (r127 == null) goto L61;
        RxUtilKt.c(r127, r125);
    L61:
        Disposable r128 = xs2.b.a().b(bu0.a.class).subscribe(new i(this));
        if (r128 == null) goto L64;
        RxUtilKt.c(r128, r125);
    L64:
        if (r107 == null) goto L68;
        Disposable r129 = p.a(r107, new AnonymousClass3(this));
        if (r129 == null) goto L68;
        RxUtilKt.c(r129, r125);
    L68:
        if (r115 == null) goto L73;
        Disposable r130 = p.a(r115, new AnonymousClass4(this));
        if (r130 == null) goto L73;
        RxUtilKt.c(r130, r125);
    L73:
        if (r124.booleanValue() == false) goto L86;
        if (r118 == null) goto L78;
        Disposable r131 = p.a(r118, new AnonymousClass5(this));
        if (r131 == null) goto L78;
        RxUtilKt.c(r131, r125);
    L78:
        if (r121 == null) goto L82;
        Disposable r132 = p.a(r121, new AnonymousClass6(this));
        if (r132 == null) goto L82;
        RxUtilKt.c(r132, r125);
    L82:
        if (r101 == null) goto L86;
        Disposable r133 = p.a(r101, new AnonymousClass7(this));
        if (r133 == null) goto L86;
        RxUtilKt.c(r133, r125);
    L86:
        Disposable r134 = xs2.b.a().b(y90.a.class).subscribe(new h(this));
        if (r134 == null) goto L90;
        RxUtilKt.c(r134, r125);
        return;
    L90:
        return;
    L45:
        r121 = null;
    L38:
        r118 = null;
    L30:
        r115 = null;
    L23:
        r107 = null;
    L16:
        r104 = null;
    L9:
        r114 = null;
        goto L10
    }

    public static final void a(final ShortTermStateDynamicShowFramework r100, final String r101, Object r110) {
        r100.getClass();
        if (r110 == null) goto L29;
        boolean r102 = false;
        if ((r110 instanceof Integer) == false) goto L9;
        r102 = !Intrinsics.areEqual(r110, 0);
    L11:
        ALogger.d("ShortTermStateDynamic", "key = " + r101 + " value = " + r102);
        if (r102 == false) goto L14;
        UtilityKotlinExtentionsKt.s(0, false, false, new ShortTermStateDynamicShowFramework$onShortTermStateChanged$1(r100, r101), 7);
    L14:
        if (r102 == true) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(r101, "short_touch_tempstate_redpack_interest") == false) goto L18;
    L19:
        bu0.b r103 = r100.f106612c;
        if (r103 == null) goto L22;
        r103.a();
    L22:
        DataCenter r104 = r100.f106615f;
        if (r104 == null) goto L28;
        r104.put("data_redpack_interest_count", 0L);
        return;
    L28:
        return;
    L18:
        if (Intrinsics.areEqual(r101, "short_touch_tempstate_redpack_behavior") == true) goto L19;
        return;
    L9:
        if ((r110 instanceof Boolean) == false) goto L11;
        r102 = ((Boolean) r110).booleanValue();
        goto L11
    }
}
