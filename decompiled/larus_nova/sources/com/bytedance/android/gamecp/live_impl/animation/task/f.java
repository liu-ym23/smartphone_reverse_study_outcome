package com.bytedance.android.gamecp.live_impl.animation.task;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.bytedance.android.gamecp.live_impl.GamePromoteRoomController;
import com.bytedance.android.gamecp.live_impl.animation.CardAnimationEvent;
import com.bytedance.android.gamecp.live_impl.card.p;
import com.bytedance.android.gamecp.live_impl.preview.CardAnimationControllerPreView;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animation f57821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Animation f57822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f57823i;

    @Override // com.bytedance.android.gamecp.live_impl.animation.task.g
    public final void a() {
        if (b.a(this.f57823i, this.f57811c) == true) goto L5;
        c();
        return;
    L5:
        if (com.bytedance.android.gamecp.live_impl.preview.e.b(this.f57814f.f57913u) == false) goto L12;
        CardAnimationControllerPreView r100 = this.f57814f;
        GamePromoteRoomController r101 = com.bytedance.android.gamecp.live_impl.preview.e.a(r100.f57911s, r100.f57912t, r100.f57913u);
        if (r101 == null) goto L12;
        if (r101.f57751q == true) goto L12;
        c();
        return;
    L12:
        CardAnimationControllerPreView r102 = this.f57814f;
        p r103 = r102.c();
        if (r103 == null) goto L35;
        View r104 = r103.getView();
        if (this.f57814f.f57913u != ILiveRoomControllerProvider.ProviderSource.DEFAULT) goto L18;
        ScaleAnimation r105 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 1.0f);
    L19:
        this.f57821g = r105;
        r105.setInterpolator(new c());
        Animation r106 = this.f57821g;
        if (r106 == null) goto L22;
        r106.setFillAfter(true);
    L22:
        Animation r107 = this.f57821g;
        if (r107 == null) goto L25;
        r107.setDuration(280);
    L25:
        Animation r108 = this.f57821g;
        if (r108 == null) goto L28;
        r108.setAnimationListener(new d(this, r102));
    L28:
        Animation r109 = this.f57821g;
        if (r109 == null) goto L33;
        r104.startAnimation(r109);
        return;
    L33:
        return;
    L18:
        r105 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 1.0f);
        goto L19
    }

    public final void c() {
        CardAnimationControllerPreView r100 = this.f57814f;
        p r101 = r100.c();
        if (r101 != null) goto L9;
        CardAnimationEvent r102 = r100.f57903k;
        if (r102 == null) goto L7;
        r102.c(CardAnimationEvent.State.EVENT_END);
    L7:
        r100.m(true);
        return;
    L9:
        ILiveRoomViewHandler r103 = r100.d();
        if (r103 == null) goto L12;
        r103.requestDismiss(r101);
    L12:
        r100.j();
        b();
    }

    @Override // com.bytedance.android.gamecp.live_impl.animation.task.g
    public final void cancelAnimation() {
        Animation r100 = this.f57821g;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        Animation r101 = this.f57822h;
        if (r101 == null) goto L9;
        r101.cancel();
        return;
    }

    public f(int r100, Function0 r101, CardAnimationControllerPreView r102) {
        Intrinsics.checkNotNullParameter(r102, "controller");
        super(null, r101, r102);
        this.f57823i = r100;
    }
}
