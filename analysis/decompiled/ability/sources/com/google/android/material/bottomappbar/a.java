package com.google.android.material.bottomappbar;

import android.view.View;

/* loaded from: classes3.dex */
public final class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar$Behavior f2302a;

    public a(BottomAppBar$Behavior bottomAppBar$Behavior) {
        this.f2302a = bottomAppBar$Behavior;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        if (this.f2302a.l.get() != null) {
            throw new ClassCastException();
        }
        view.removeOnLayoutChangeListener(this);
    }
}
