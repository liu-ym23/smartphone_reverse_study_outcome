package com.bytedance.android.ec.store.utils.playable.controller;

import android.graphics.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class RestrictMarginAreaProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Integer> f48673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f48674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f48675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Integer> f48676d;

    public static final class Companion {
        public static Function0 a() {
            return RestrictMarginAreaProcessor$Companion$defaultMarginProvider$1.INSTANCE;
        }
    }

    static {
    }

    public final void a(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        r100.left += this.f48673a.invoke().intValue();
        r100.top += this.f48674b.invoke().intValue();
        r100.right -= this.f48675c.invoke().intValue();
        r100.bottom -= this.f48676d.invoke().intValue();
    }

    public RestrictMarginAreaProcessor(Function0<Integer> r100, Function0<Integer> r101, Function0<Integer> r102, Function0<Integer> r103) {
        Intrinsics.checkNotNullParameter(r100, "leftProvider");
        Intrinsics.checkNotNullParameter(r101, "topProvider");
        Intrinsics.checkNotNullParameter(r102, "rightProvider");
        Intrinsics.checkNotNullParameter(r103, "bottomProvider");
        this.f48673a = r100;
        this.f48674b = r101;
        this.f48675c = r102;
        this.f48676d = r103;
    }
}
