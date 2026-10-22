package com.bytedance.android.livesdk.widget.schedule.v2;

import android.os.Handler;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends AbsLiveWidgetLoadTaskScheduler implements a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f162136w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h80.d<c> f162137x;

    @Override // com.bytedance.android.livesdk.widget.schedule.v2.AbsLiveWidgetLoadTaskScheduler, rv2.a
    public final void I() {
        if (this.f162136w.S8() == true) goto L5;
        return;
    L5:
        if ((!this.f162114f) == false) goto L10;
        super.I();
        f.e("onPartShow and direct loadP0Task");
        this.f162117i.run();
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.schedule.v2.AbsLiveWidgetLoadTaskScheduler, rv2.a
    public final void K() {
        if (this.f162136w.S8() == true) goto L5;
        return;
    L5:
        if ((!this.f162114f) == false) goto L10;
        super.K();
        f.e("onContinueShow");
        d();
        this.f162119k.run();
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.schedule.v2.AbsLiveWidgetLoadTaskScheduler, rv2.a
    public final void M() {
        if (this.f162136w.S8() == true) goto L5;
        return;
    L5:
        if ((!this.f162114f) == false) goto L10;
        super.M();
        f.e("onDirectCompleteShow");
        this.f162117i.run();
        this.f162119k.run();
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.schedule.v2.a
    public final boolean a() {
        return !this.f162113e;
    }

    @Override // com.bytedance.android.livesdk.widget.schedule.v2.a
    public final void b() {
        if (this.f162111c == false) goto L6;
        ((Handler) this.f162109a.getValue()).post(this.f162121m);
        ((Handler) this.f162109a.getValue()).post(this.f162123o);
        ((Handler) this.f162109a.getValue()).post(this.f162125q);
        return;
    }

    public final void d() {
        if (this.f162136w.S8() == false) goto L18;
        boolean r100 = true;
        if ((!this.f162114f) == true) goto L8;
        return;
    L8:
        if (this.f162111c == true) goto L10;
    L12:
        r100 = false;
    L13:
        if (r100 == true) goto L15;
        return;
    L15:
        if (this.f162110b == true) goto L20;
        this.f162136w.XZ(this.f162137x.get().f162134a);
        f.e("update p0 widget");
        return;
    L20:
        return;
    L10:
        if (this.f162112d == false) goto L12;
    }

    @Override // rv2.a
    public final void x() {
        if (this.f162136w.S8() == true) goto L5;
        return;
    L5:
        if ((!this.f162114f) == false) goto L10;
        this.f162112d = true;
        d();
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.schedule.v2.AbsLiveWidgetLoadTaskScheduler, rv2.a
    public final void onDestroy() {
        super.onDestroy();
        f.e(LiveCommonConstants.REASON_ON_DEDTROY);
    }

    public d(b r100, h80.d r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetLoadStep");
        Intrinsics.checkNotNullParameter(r101, "interactionRoomSupplier");
        super(r100, r101);
        this.f162136w = r100;
        this.f162137x = r101;
    }
}
