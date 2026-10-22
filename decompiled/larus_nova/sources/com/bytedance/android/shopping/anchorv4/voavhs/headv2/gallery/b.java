package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.graphics.RectF;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f169277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f169278b;

    public static final class a {
    }

    static {
    }

    public abstract boolean a(int r100);

    public void b(RectF r100) {
    }

    public void c(boolean r100) {
    }

    public void d(boolean r100) {
    }

    public b(View r100, m0 r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f169277a = r100;
        this.f169278b = r101;
    }
}
