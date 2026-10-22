package com.google.android.material.bottomappbar;

import J3.c;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public final class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10404a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10405b;

    public /* synthetic */ a(int i4, Object obj) {
        this.f10404a = i4;
        this.f10405b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = this.f10404a;
        Object obj = this.f10405b;
        switch (i12) {
            case 0:
                ((BottomAppBar$Behavior) obj).getClass();
                throw null;
            case 1:
                c.a((c) obj);
                return;
            default:
                View view2 = (View) view.getParent();
                int i13 = (int) (((Toolbar) obj).getResources().getDisplayMetrics().density * 56.0f);
                int i14 = i6 - i4;
                if (i14 < i13) {
                    int i15 = (i13 - i14) / 2;
                    view2.setTouchDelegate(new TouchDelegate(new Rect(i4 - i15, i5, i6 + i15, i7), view));
                    return;
                }
                return;
        }
    }
}
