package com.bytedance.android.shopping.yata.biz.popup.behavior;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes14.dex */
class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f187545a;

    public class a implements Parcelable.ClassLoaderCreator<SavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            return new SavedState(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new SavedState[r100];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
            return new SavedState(r100);
        }
    }

    static {
        CREATOR = new a();
    }

    public SavedState(Parcel r100) {
        super(r100);
        this.f187545a = r100.readInt();
    }

    public SavedState(Parcelable r100, int r101) {
        super(r100);
        this.f187545a = r101;
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f187545a);
    }
}
