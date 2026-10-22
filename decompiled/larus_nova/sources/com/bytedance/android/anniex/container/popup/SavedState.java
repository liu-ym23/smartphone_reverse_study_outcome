package com.bytedance.android.anniex.container.popup;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SavedState;", "Landroidx/customview/view/AbsSavedState;", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class SavedState extends AbsSavedState {
    public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40483a;

    public static final class a implements Parcelable.ClassLoaderCreator<SavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "inParcel");
            return new SavedState(r100, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new SavedState[r100];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
            Intrinsics.checkNotNullParameter(r100, "inParcel");
            return new SavedState(r100, r101);
        }
    }

    public static final class b {
    }

    static {
        CREATOR = new a();
    }

    public SavedState(Parcel r100, ClassLoader r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        super(r100, r101);
        this.f40483a = r100.readInt();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f40483a);
    }

    public SavedState(Parcelable r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "superState");
        super(r100);
        this.f40483a = r101;
    }
}
