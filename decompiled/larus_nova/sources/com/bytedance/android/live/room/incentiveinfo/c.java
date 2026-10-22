package com.bytedance.android.live.room.incentiveinfo;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements u81.e {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // u81.e
    public final void a() {
    }

    @Override // u81.e
    public final void b() {
    }

    @Override // u81.e
    public final Animation c() {
        TranslateAnimation r100 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.0f, 1, -1.0f);
        r100.setDuration(500);
        r100.setFillAfter(true);
        return r100;
    }

    @Override // u81.e
    public final Animation d() {
        TranslateAnimation r100 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 1.0f, 1, 0.0f);
        r100.setDuration(500);
        r100.setFillAfter(true);
        return r100;
    }

    public final void e(View r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "enterView");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter(r100, "enterView");
        Intrinsics.checkNotNullParameter(r101, "listener");
    }
}
