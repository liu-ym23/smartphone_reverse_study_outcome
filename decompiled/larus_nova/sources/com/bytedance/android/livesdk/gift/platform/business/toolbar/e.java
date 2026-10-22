package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.EffectGameStatus;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import i12.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends zr2.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f130203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f130204c;

    public static final class a {
    }

    static {
    }

    @Override // zr2.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
    }

    @Override // zr2.b
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        zy0.d r101 = null;
        ay1.b.B0.setValue(null, ay1.b.f16675a[94], Boolean.FALSE);
        i12.e r102 = o.b();
        if (r102 == null) goto L5;
        Object r103 = com.bytedance.android.scope.m.f163449e.d(r102, l02.e.class);
    L6:
        l02.e r104 = (l02.e) r103;
        if (r104 == null) goto L10;
        EffectGameStatus r105 = r104.f506856a;
        if (r105 == null) goto L10;
    L11:
        i12.e r106 = o.b();
        if (r106 == null) goto L14;
        Object r107 = com.bytedance.android.scope.m.f163449e.d(r106, l02.e.class);
    L15:
        l02.e r108 = (l02.e) r107;
        if (r108 == null) goto L18;
        Integer r109 = r108.f506857b;
    L20:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(this.f130204c) == false) goto L41;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L33
        d r111 = (d) GsonHelper.get().fromJson(this.f130204c, d.class);     // Catch: Throwable -> L33
        if (r105 == EffectGameStatus.RUNNING) goto L24;
    L28:
        String r112 = r111.c();     // Catch: Throwable -> L33
        if (r112 == null) goto L31;
        r101 = com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.c.a(this.f130203b, r112);     // Catch: Throwable -> L33
    L31:
        Object r113 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L33
    L36:
        if (Result.m9452exceptionOrNullimpl(r113) == null) goto L42;
        int r114 = x8.a.f562881a;
        x8.a.b("ToolbarGameEffectBehavior", "parse extra error, extra: " + this.f130204c, false);
        return;
    L42:
        return;
    L24:
        if (Intrinsics.areEqual(r109, r111.a()) == false) goto L28;
        String r115 = r111.b();     // Catch: Throwable -> L33
        if (r115 == null) goto L31;
        r101 = com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.c.a(this.f130203b, r115);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L41:
        return;
    L18:
        r109 = null;
        goto L20
    L14:
        r107 = null;
    L10:
        r105 = EffectGameStatus.IDLE;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public e(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f130203b = r100;
        this.f130204c = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zr2.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        View r102 = r100.findViewById(R.id.red_dot);
        if (((Boolean) ay1.b.B0.getValue(null, ay1.b.f16675a[94])).booleanValue() == false) goto L5;
        UIUtils.setViewVisibility(r102, 0);
        return;
    L5:
        UIUtils.setViewVisibility(r102, 8);
    }
}
