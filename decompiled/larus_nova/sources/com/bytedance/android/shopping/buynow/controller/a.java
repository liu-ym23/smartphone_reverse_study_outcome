package com.bytedance.android.shopping.buynow.controller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f170818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f170819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f170820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f170821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f170822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BuyNowViewModel f170823f;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.buynow.controller.a$a, reason: collision with other inner class name */
    public static final class C2565a {
    }

    static {
    }

    public final void a() {
        int r100 = com.bytedance.android.shopping.buynow.utils.b.f171205a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(this.f170823f) == true) goto L6;
        this.f170820c.setVisibility(0);
        return;
    }

    public a(View r100, View r101, RecyclerView r102, BuyNowViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "titleContainer");
        Intrinsics.checkNotNullParameter(r101, "addressStickyContainer");
        Intrinsics.checkNotNullParameter(r102, "bodyContainer");
        Intrinsics.checkNotNullParameter(r103, "buyNowViewModel");
        this.f170820c = r100;
        this.f170821d = r101;
        this.f170822e = r102;
        this.f170823f = r103;
    }
}
