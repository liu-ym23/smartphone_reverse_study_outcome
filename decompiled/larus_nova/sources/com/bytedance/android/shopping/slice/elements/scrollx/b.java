package com.bytedance.android.shopping.slice.elements.scrollx;

import android.view.View;
import android.view.ViewConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f183327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f183328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f183329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f183330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f183331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f183332f;

    public static final class a {
    }

    static {
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f183332f = r100;
        this.f183327a = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    }
}
