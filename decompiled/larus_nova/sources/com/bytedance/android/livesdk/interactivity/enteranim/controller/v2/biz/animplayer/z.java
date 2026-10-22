package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.u0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.EnterAnimAppLogger;
import com.bytedance.android.livesdk.message.model.pg;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z implements com.bytedance.android.livesdk.interactivity.enteranim.utils.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f136730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h3 f136731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u0 f136732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f136733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BaseWindScreenAnimEnterTrayView f136734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a0 f136735f;

    public final void a() {
        if (this.f136731b.getShowTime() <= 0) goto L5;
        long r100 = System.currentTimeMillis() - this.f136731b.getShowTime();
        EnterAnimAppLogger.e(this.f136731b, r100);
    L5:
        this.f136733d.removeView(this.f136734e);
        ((v72.c.a) this.f136730a).a();
        com.bytedance.android.livesdk.interactivity.enteranim.utils.k r101 = this.f136735f.f136635c;
        h3 r102 = this.f136731b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "message");
        com.bytedance.android.livesdk.interactivity.common.enterAnim.b.f136555a.getClass();
        if (r102 == null) goto L10;
        pg.c r103 = r102.M();
        if (r103 == null) goto L10;
        boolean r104 = com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.a(r103);
    L11:
        if (r104 == true) goto L13;
        return;
    L13:
        if (r101.f136798b != null) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r101.f136797a, r102) == false) goto L17;
        r101.f136797a = null;
        ALogger.d("EnterAnimExtraHeightUpdater", "on end special enter anim extra height: 0");
        r101.f136798b.put("data_special_enter_anim_extra_height", 0);
        return;
    L17:
        ALogger.d("EnterAnimExtraHeightUpdater", "current show is not this end, ignore");
        return;
    L10:
        r104 = false;
        goto L11
    }

    public final void b() {
        a r100 = this.f136730a;
        if (r100 == null) goto L5;
        ((v72.c.a) r100).b();
    L5:
        com.bytedance.android.livesdk.interactivity.enteranim.utils.k r101 = this.f136735f.f136635c;
        h3 r102 = this.f136731b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "message");
        if (r101.f136798b == null) goto L16;
        com.bytedance.android.livesdk.interactivity.common.enterAnim.b.f136555a.getClass();
        if (r102 == null) goto L12;
        pg.c r103 = r102.M();
        if (r103 == null) goto L12;
        boolean r104 = com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.a(r103);
    L13:
        if (r104 == false) goto L17;
        r101.f136797a = r102;
        int r105 = s1.f(7.0f);
        ALogger.d("EnterAnimExtraHeightUpdater", "special enter anim extra height: 7");
        r101.f136798b.put("data_special_enter_anim_extra_height", Integer.valueOf(r105));
        return;
    L17:
        return;
    L12:
        r104 = false;
        goto L13
    }

    public z(a0 r100, a r101, h3 r102, u0 r103, ViewGroup r104, BaseWindScreenAnimEnterTrayView r105) {
        this.f136735f = r100;
        this.f136730a = r101;
        this.f136731b = r102;
        this.f136732c = r103;
        this.f136733d = r104;
        this.f136734e = r105;
    }
}
