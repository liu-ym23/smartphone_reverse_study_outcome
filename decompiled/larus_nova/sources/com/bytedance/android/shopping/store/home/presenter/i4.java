package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f184198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f184199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f184200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f184201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f184202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f184203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f184204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f184205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f184206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f184207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f184208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f184209l;

    public final void a() {
        this.f184198a = wg.a.c(this.f184208k);
        this.f184199b = wg.a.c(this.f184209l);
        this.f184200c = this.f184208k.getWidth();
        this.f184201d = this.f184208k.getHeight();
        this.f184202e = this.f184209l.getWidth();
        this.f184203f = this.f184209l.getHeight();
        int[] r100 = this.f184198a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("originLocationInScreen");
    L5:
        this.f184204g = r100[0] + (this.f184200c / 2);
        int[] r101 = this.f184198a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("originLocationInScreen");
    L8:
        this.f184205h = r101[1] - (this.f184201d / 2);
        int[] r102 = this.f184199b;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("targetLocationInScreen");
    L11:
        this.f184206i = r102[0] + (this.f184202e / 2);
        int[] r103 = this.f184199b;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("targetLocationInScreen");
    L14:
        this.f184207j = r103[1] - (this.f184203f / 2);
        View r104 = this.f184208k;
        if ((r104 instanceof AppCompatTextView) == false) goto L17;
        ((AppCompatTextView) r104).getTextSize();
    L17:
        View r105 = this.f184209l;
        if ((r105 instanceof AppCompatTextView) == false) goto L21;
        ((AppCompatTextView) r105).getTextSize();
        return;
    }

    public i4(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "originView");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        this.f184208k = r100;
        this.f184209l = r101;
        a();
    }
}
