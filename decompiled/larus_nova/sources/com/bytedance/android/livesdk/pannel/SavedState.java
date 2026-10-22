package com.bytedance.android.livesdk.pannel;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes11.dex */
class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f154329a;

    public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            return new SavedState(r100, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new SavedState[r100];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
            return new SavedState(r100, r101);
        }
    }

    static {
        CREATOR = new a();
    }

    public SavedState(Parcel r100, ClassLoader r101) {
        super(r100, r101);
        this.f154329a = r100.readInt();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f154329a);
    }

    public SavedState(Parcelable r100, int r101) {
        super(r100);
        this.f154329a = r101;
    }
}
