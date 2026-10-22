package com.stepos.widget.toggle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.SwitchCompat;
import g.C0728a;
import h.C0744a;
import j4.g;
import j4.k;
import l3.C0846d;
import l3.C0847e;
import l3.f;
import s3.l;

/* loaded from: classes.dex */
public class StepOSSwitch extends SwitchCompat {

    /* renamed from: a0, reason: collision with root package name */
    private boolean f16349a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f16350b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f16351c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f16352d0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.g(context, "context");
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        k.g(motionEvent, "event");
        boolean z5 = this.f16349a0;
        this.f16349a0 = true;
        try {
            return super.onTouchEvent(motionEvent);
        } finally {
            this.f16349a0 = z5;
        }
    }

    public final boolean r() {
        return this.f16349a0 || this.f16350b0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z5) {
        if (!this.f16351c0 && ((this.f16349a0 || this.f16350b0) && this.f16352d0 && isChecked() != z5)) {
            l.f20292a.c(this);
        }
        boolean z6 = this.f16351c0;
        this.f16351c0 = true;
        try {
            super.setChecked(z5);
        } finally {
            this.f16351c0 = z6;
        }
    }

    public final void setCheckedWithHapticFeedback(boolean z5) {
        boolean z6 = this.f16350b0;
        this.f16350b0 = true;
        try {
            setChecked(z5);
        } finally {
            this.f16350b0 = z6;
        }
    }

    public final void setSwitchHapticFeedbackEnabled(boolean z5) {
        this.f16352d0 = z5;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    public /* synthetic */ StepOSSwitch(Context context, AttributeSet attributeSet, int i5, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? C0728a.f16819P : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSwitch(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        k.g(context, "context");
        this.f16352d0 = true;
        setBackground(null);
        setTrackDrawable(C0744a.b(context, f.f18404j));
        setThumbDrawable(C0744a.b(context, f.f18403i));
        setTrackTintList(C0744a.a(context, C0846d.f18317x));
        setThumbTintList(C0744a.a(context, C0846d.f18316w));
        setShowText(false);
        setSwitchMinWidth(getResources().getDimensionPixelSize(C0847e.f18357f0));
    }
}
