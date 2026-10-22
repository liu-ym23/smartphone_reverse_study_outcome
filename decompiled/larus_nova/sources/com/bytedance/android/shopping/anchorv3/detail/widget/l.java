package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f164929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f164930b;

    public abstract View c(LayoutInflater r100);

    public void d() {
    }

    public void e() {
    }

    public final View b() {
        View r100 = this.f164929a;
        if (r100 != null) goto L5;
        this.f164929a = c(LayoutInflater.from(this.f164930b));
    L11:
        View r101 = this.f164929a;
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof ViewGroup) == true) goto L8;
        r102 = null;
    L8:
        ViewGroup r103 = (ViewGroup) r102;
        if (r103 == null) goto L11;
        r103.removeView(r100);
        goto L11
    }

    public l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f164930b = r100;
    }
}
