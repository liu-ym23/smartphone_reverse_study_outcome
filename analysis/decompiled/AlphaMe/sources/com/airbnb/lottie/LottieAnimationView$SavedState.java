package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
class LottieAnimationView$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<LottieAnimationView$SavedState> CREATOR = new C0401f();

    /* renamed from: a, reason: collision with root package name */
    public String f4534a;

    /* renamed from: b, reason: collision with root package name */
    public int f4535b;

    /* renamed from: c, reason: collision with root package name */
    public float f4536c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4537d;

    /* renamed from: e, reason: collision with root package name */
    public String f4538e;

    /* renamed from: f, reason: collision with root package name */
    public int f4539f;

    /* renamed from: g, reason: collision with root package name */
    public int f4540g;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.f4534a);
        parcel.writeFloat(this.f4536c);
        parcel.writeInt(this.f4537d ? 1 : 0);
        parcel.writeString(this.f4538e);
        parcel.writeInt(this.f4539f);
        parcel.writeInt(this.f4540g);
    }
}
