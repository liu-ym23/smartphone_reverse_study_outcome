package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* renamed from: com.stepos.common.widget.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0486b implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11889a;

    public /* synthetic */ C0486b(int i4) {
        this.f11889a = i4;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        switch (this.f11889a) {
            case 0:
                AbsSpinner$SavedState absSpinner$SavedState = new AbsSpinner$SavedState(parcel);
                absSpinner$SavedState.f11441a = parcel.readLong();
                absSpinner$SavedState.f11442b = parcel.readInt();
                return absSpinner$SavedState;
            case 1:
                return new View.BaseSavedState(parcel) { // from class: com.stepos.common.widget.CustomTimePicker$SavedState
                    public static final Parcelable.Creator<CustomTimePicker$SavedState> CREATOR = new C0486b(1);

                    /* renamed from: a, reason: collision with root package name */
                    public final int f11504a;

                    /* renamed from: b, reason: collision with root package name */
                    public final int f11505b;

                    /* renamed from: c, reason: collision with root package name */
                    public final int f11506c;

                    /* renamed from: d, reason: collision with root package name */
                    public final int f11507d;

                    /* renamed from: e, reason: collision with root package name */
                    public final int f11508e;

                    /* renamed from: f, reason: collision with root package name */
                    public final int f11509f;

                    /* renamed from: g, reason: collision with root package name */
                    public final int f11510g;

                    {
                        super(parcel);
                        this.f11504a = parcel.readInt();
                        this.f11505b = parcel.readInt();
                        this.f11506c = parcel.readInt();
                        this.f11507d = parcel.readInt();
                        this.f11508e = parcel.readInt();
                        this.f11509f = parcel.readInt();
                        this.f11510g = parcel.readInt();
                    }

                    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i4) {
                        super.writeToParcel(parcel2, i4);
                        parcel2.writeInt(this.f11504a);
                        parcel2.writeInt(this.f11505b);
                        parcel2.writeInt(this.f11506c);
                        parcel2.writeInt(this.f11507d);
                        parcel2.writeInt(this.f11508e);
                        parcel2.writeInt(this.f11509f);
                        parcel2.writeInt(this.f11510g);
                    }
                };
            case 2:
                ProgressBar$SavedState progressBar$SavedState = new ProgressBar$SavedState(parcel);
                progressBar$SavedState.f11731a = parcel.readInt();
                progressBar$SavedState.f11732b = parcel.readInt();
                return progressBar$SavedState;
            default:
                SkipPosSeekBar$SavedState skipPosSeekBar$SavedState = new SkipPosSeekBar$SavedState(parcel);
                skipPosSeekBar$SavedState.f11782a = parcel.readInt();
                return skipPosSeekBar$SavedState;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f11889a) {
            case 0:
                return new AbsSpinner$SavedState[i4];
            case 1:
                return new CustomTimePicker$SavedState[i4];
            case 2:
                return new ProgressBar$SavedState[i4];
            default:
                return new SkipPosSeekBar$SavedState[i4];
        }
    }
}
