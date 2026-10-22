package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.stepos.common.widget.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1098c implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3800a;

    public /* synthetic */ C1098c(int i) {
        this.f3800a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f3800a) {
            case 0:
                return new AbsSpinner$SavedState(parcel);
            case 1:
                return new CustomTimePicker$SavedState(parcel);
            case 2:
                return new ProgressBar$SavedState(parcel);
            default:
                return new SkipPosSeekBar$SavedState(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f3800a) {
            case 0:
                return new AbsSpinner$SavedState[i];
            case 1:
                return new CustomTimePicker$SavedState[i];
            case 2:
                return new ProgressBar$SavedState[i];
            default:
                return new SkipPosSeekBar$SavedState[i];
        }
    }
}
