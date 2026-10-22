package com.bytedance.android.livesdk.interactivity.zdanmaku;

import android.content.Context;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCombinedAnimTrayView;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCommonAnimTrayView;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseWindScreenAnimEnterTrayView f141630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h3 f141631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<d, Unit> f141632c;

    /* JADX WARN: Multi-variable type inference failed */
    public d(h3 r100, Function1<? super d, Unit> r101, Context r102, BarrageWidgetContext r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "renderEndCallBack");
        this.f141631b = r100;
        this.f141632c = r101;
        if (r102 == null) goto L49;
        IMiddlewareUserService r104 = (IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class);
        k32.d r105 = new k32.d(r100, r104.user().n(), r104.user().b().getRealNickName(), r104.user().b().getAvatarUrl());
        int r106 = 0;
        if (r105.a() == false) goto L7;
        WindScreenCombinedAnimTrayView r107 = new WindScreenCombinedAnimTrayView(r102, null, 6, r106);
        r107.setConfigSceneInterceptor(new com.bytedance.android.livesdk.interactivity.common.enterAnim.b());
        r107.f136516a = new WindScreenCombinedAnimTrayView.a(new CombinedTextDanmakuData$getTrayView$1(this));
        BaseWindScreenAnimEnterTrayView r108 = r107;
    L13:
        this.f141630a = r108;
        if (r103 == null) goto L22;
        n<p22.i> r109 = r103.getNormalDanmakuSettingConfig();
        if (r109 == null) goto L22;
        p22.i r110 = r109.getValue();
        if (r110 == null) goto L22;
        p22.i.a r111 = r110.f527406d;
        if (r111 == null) goto L22;
        float r112 = r111.f527407a;
    L23:
        r108.setTextSize(r112);
        BaseWindScreenAnimEnterTrayView r113 = this.f141630a;
        if (r113 != null) goto L26;
    L45:
        BaseWindScreenAnimEnterTrayView r114 = this.f141630a;
        if (r114 == null) goto L50;
        r114.R5(r105);
        return;
    L50:
        return;
    L26:
        if (r103 == null) goto L34;
        n<p22.i> r115 = r103.getNormalDanmakuSettingConfig();
        if (r115 == null) goto L34;
        p22.i r116 = r115.getValue();
        if (r116 == null) goto L34;
        p22.i.a r117 = r116.f527406d;
        if (r117 == null) goto L34;
        int r118 = r117.f527408b;
    L35:
        if (r103 == null) goto L43;
        n<p22.i> r119 = r103.getNormalDanmakuSettingConfig();
        if (r119 == null) goto L43;
        p22.i r120 = r119.getValue();
        if (r120 == null) goto L43;
        p22.i.a r121 = r120.f527406d;
        if (r121 == null) goto L43;
        int r122 = r121.f527408b;
    L44:
        r113.U5(r118, r122);
    L43:
        r122 = UtilityKotlinExtentionsKt.i(22);
    L34:
        r118 = UtilityKotlinExtentionsKt.i(22);
    L22:
        r112 = UtilityKotlinExtentionsKt.m(14);
        goto L23
    L7:
        WindScreenCommonAnimTrayView r123 = new WindScreenCommonAnimTrayView(r102);
        r123.f136516a = new com.bytedance.android.livesdk.interactivity.common.enterAnim.a(new CombinedTextDanmakuData$getTrayView$2(this));
        List<py.k> r124 = r100.N();
        if (r124 == null) goto L12;
        py.k r125 = (py.k) ListProtector.get(r124, 0);
        if (r125 == null) goto L12;
        a1.k(r125).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r123));
    L12:
        r108 = r123;
        goto L13
    }
}
