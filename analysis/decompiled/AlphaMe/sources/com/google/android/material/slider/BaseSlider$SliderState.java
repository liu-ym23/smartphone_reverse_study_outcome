package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
class BaseSlider$SliderState extends View.BaseSavedState {
    public static final Parcelable.Creator<BaseSlider$SliderState> CREATOR = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public float f10901a;

    /* renamed from: b, reason: collision with root package name */
    public float f10902b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f10903c;

    /* renamed from: d, reason: collision with root package name */
    public float f10904d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10905e;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeFloat(this.f10901a);
        parcel.writeFloat(this.f10902b);
        parcel.writeList(this.f10903c);
        parcel.writeFloat(this.f10904d);
        parcel.writeBooleanArray(new boolean[]{this.f10905e});
    }
}
