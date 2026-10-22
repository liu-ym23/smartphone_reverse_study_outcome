package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class VSPlayerService$createGestureViewManager$manager$1 extends ko1.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ bq1.a f118288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ View f118289o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f118290p;

    @Override // ko1.b, ko1.c
    public final boolean b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "resetType");
        return this.f118288n.c(r100, new VSPlayerService$createGestureViewManager$manager$1$resetPlayerView$1(this, r100));
    }

    @Override // ko1.b, ko1.c
    public final boolean c(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.f118288n.a(r100, new VSPlayerService$createGestureViewManager$manager$1$handleOnTouchEvent$1(this, r100));
    }

    @Override // ko1.b
    public final void d(boolean r100) {
        this.f118288n.b(r100, new VSPlayerService$createGestureViewManager$manager$1$isInZoomStateChange$1(this));
    }

    public static final /* synthetic */ boolean f(VSPlayerService$createGestureViewManager$manager$1 r100, MotionEvent r101) {
        return super.c(r101);
    }

    public static final /* synthetic */ void g(VSPlayerService$createGestureViewManager$manager$1 r100, boolean r101) {
        super.d(r101);
    }

    public static final /* synthetic */ boolean h(VSPlayerService$createGestureViewManager$manager$1 r100, String r101) {
        return super.b(r101);
    }

    public VSPlayerService$createGestureViewManager$manager$1(com.bytedance.android.livesdk.chatroom.vs.gesture.g r100, View r101, ViewGroup r102, Context r110, View r111, ViewGroup r112) {
        this.f118288n = r100;
        this.f118289o = r101;
        this.f118290p = r102;
        super(r110, r111, r112, null, null);
    }
}
