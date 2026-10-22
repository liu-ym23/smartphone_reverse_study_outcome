package com.google.android.material.appbar;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AppBarLayout$BaseBehavior$$ExternalSyntheticLambda1 implements View.OnKeyListener {
    public final /* synthetic */ AppBarLayout.BaseBehavior f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ AppBarLayout f$2;

    public /* synthetic */ AppBarLayout$BaseBehavior$$ExternalSyntheticLambda1(AppBarLayout.BaseBehavior r1, View r2, AppBarLayout r3) {
        this.f$0 = r1;
        this.f$1 = r2;
        this.f$2 = r3;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r7, int r8, KeyEvent r9) {
        return this.f$0.m241xbbc7fdd1(this.f$1, this.f$2, r7, r8, r9);
    }
}
