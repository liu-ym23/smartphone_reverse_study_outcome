package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import e0.a0;
import g.v;
import j1.h;
import p1.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class CheckableImageButton extends v implements Checkable {

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f1318g = {R.attr.state_checked};
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1319e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1320f;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.stepos.stepclaw.R.attr.imageButtonStyle);
        this.f1319e = true;
        this.f1320f = true;
        a0.e(this, new h(this, 1));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i8) {
        return this.d ? View.mergeDrawableStates(super.onCreateDrawableState(i8 + 1), f1318g) : super.onCreateDrawableState(i8);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f3000a);
        setChecked(aVar.f4662c);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f4662c = this.d;
        return aVar;
    }

    public void setCheckable(boolean z) {
        if (this.f1319e != z) {
            this.f1319e = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.f1319e || this.d == z) {
            return;
        }
        this.d = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.f1320f = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f1320f) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.d);
    }
}
