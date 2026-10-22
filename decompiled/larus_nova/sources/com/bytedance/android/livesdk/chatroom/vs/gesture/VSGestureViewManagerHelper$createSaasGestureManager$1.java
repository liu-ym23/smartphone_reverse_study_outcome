package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class VSGestureViewManagerHelper$createSaasGestureManager$1 extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ View f117690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f117691m;

    @Override // com.bytedance.android.livesdk.chatroom.vs.gesture.b, ko1.c
    public final boolean b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "resetType");
        ko1.c r101 = VSGestureViewManagerHelper.f117687a;
        g r102 = VSGestureViewManagerHelper.f117688b;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.c(r100, new VSGestureViewManagerHelper$createSaasGestureManager$1$resetPlayerView$1(this, r100));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.gesture.b, ko1.c
    public final boolean c(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ko1.c r101 = VSGestureViewManagerHelper.f117687a;
        g r102 = VSGestureViewManagerHelper.f117688b;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.a(r100, new VSGestureViewManagerHelper$createSaasGestureManager$1$handleOnTouchEvent$1(this, r100));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.gesture.b
    public final void d(boolean r100) {
        ko1.c r101 = VSGestureViewManagerHelper.f117687a;
        g r102 = VSGestureViewManagerHelper.f117688b;
        if (r102 == null) goto L6;
        r102.b(r100, new VSGestureViewManagerHelper$createSaasGestureManager$1$isInZoomStateChange$1(this));
        return;
    }

    public static final /* synthetic */ boolean e(VSGestureViewManagerHelper$createSaasGestureManager$1 r100, MotionEvent r101) {
        return super.c(r101);
    }

    public static final /* synthetic */ boolean f(VSGestureViewManagerHelper$createSaasGestureManager$1 r100, String r101) {
        return super.b(r101);
    }

    public VSGestureViewManagerHelper$createSaasGestureManager$1(View r100, ViewGroup r101, Context r102, View r103, ViewGroup r104) {
        this.f117690l = r100;
        this.f117691m = r101;
        super(r102, r103, r104);
    }
}
