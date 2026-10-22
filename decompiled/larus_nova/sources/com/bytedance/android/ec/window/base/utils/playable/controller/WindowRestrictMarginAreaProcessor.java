package com.bytedance.android.ec.window.base.utils.playable.controller;

import android.graphics.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class WindowRestrictMarginAreaProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Integer> f49733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f49734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f49735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Integer> f49736d;

    public static final class Companion {
        public static Function0 a() {
            return WindowRestrictMarginAreaProcessor$Companion$defaultMarginProvider$1.INSTANCE;
        }
    }

    static {
    }

    public final void a(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        r100.left += this.f49733a.invoke().intValue();
        r100.top += this.f49734b.invoke().intValue();
        r100.right -= this.f49735c.invoke().intValue();
        r100.bottom -= this.f49736d.invoke().intValue();
    }

    public WindowRestrictMarginAreaProcessor(Function0<Integer> r100, Function0<Integer> r101, Function0<Integer> r102, Function0<Integer> r103) {
        Intrinsics.checkNotNullParameter(r100, "leftProvider");
        Intrinsics.checkNotNullParameter(r101, "topProvider");
        Intrinsics.checkNotNullParameter(r102, "rightProvider");
        Intrinsics.checkNotNullParameter(r103, "bottomProvider");
        this.f49733a = r100;
        this.f49734b = r101;
        this.f49735c = r102;
        this.f49736d = r103;
    }
}
