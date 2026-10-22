package com.bytedance.android.livesdk.widget.rangeseekbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f161978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f161979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f161980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f161981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f161982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f161983f;

    public class a implements Parcelable.Creator<SavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SavedState createFromParcel(Parcel r100) {
            return new SavedState(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SavedState[] newArray(int r100) {
            return new SavedState[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SavedState(Parcel r100) {
        super(r100);
        this.f161978a = r100.readFloat();
        this.f161979b = r100.readFloat();
        this.f161980c = r100.readFloat();
        this.f161981d = r100.readInt();
        this.f161982e = r100.readFloat();
        this.f161983f = r100.readFloat();
    }

    public SavedState(Parcelable r100) {
        super(r100);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.f161978a);
        r100.writeFloat(this.f161979b);
        r100.writeFloat(this.f161980c);
        r100.writeInt(this.f161981d);
        r100.writeFloat(this.f161982e);
        r100.writeFloat(this.f161983f);
    }
}
