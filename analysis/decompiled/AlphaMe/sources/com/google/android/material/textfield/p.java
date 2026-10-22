package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.C0200f0;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class p extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11061a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f11062b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11063c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f11064d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ r f11065e;

    public p(r rVar, int i4, TextView textView, int i5, TextView textView2) {
        this.f11065e = rVar;
        this.f11061a = i4;
        this.f11062b = textView;
        this.f11063c = i5;
        this.f11064d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        C0200f0 c0200f0;
        int i4 = this.f11061a;
        r rVar = this.f11065e;
        rVar.f11082n = i4;
        rVar.f11080l = null;
        TextView textView = this.f11062b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f11063c == 1 && (c0200f0 = rVar.f11086r) != null) {
                c0200f0.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f11064d;
        if (textView2 != null) {
            textView2.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f11064d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(Property.DEFAULT_FLOAT_VALUE);
        }
    }
}
