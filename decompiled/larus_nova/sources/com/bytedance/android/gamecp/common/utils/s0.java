package com.bytedance.android.gamecp.common.utils;

import android.view.Choreographer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s0 {

    public static final class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f57300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f57301b;

        public a(int r100, Function0 r101) {
            this.f57300a = r100;
            this.f57301b = r101;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            s0.a(this.f57300a - 1, this.f57301b);
        }
    }

    public static final void a(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 > 0) goto L5;
        r101.invoke();
        return;
    L5:
        Choreographer.getInstance().postFrameCallback(new a(r100, r101));
    }
}
