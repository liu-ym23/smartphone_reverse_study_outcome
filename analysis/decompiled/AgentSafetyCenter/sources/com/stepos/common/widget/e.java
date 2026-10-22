package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends View.BaseSavedState {
    public static final Parcelable.Creator<e> CREATOR = new android.support.v4.os.a(7);

    /* renamed from: c, reason: collision with root package name */
    public boolean f2682c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2683f;

    /* renamed from: g, reason: collision with root package name */
    public int f2684g;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2684g);
        parcel.writeInt(this.f2682c ? 1 : 0);
        parcel.writeInt(this.f2683f ? 1 : 0);
    }
}
