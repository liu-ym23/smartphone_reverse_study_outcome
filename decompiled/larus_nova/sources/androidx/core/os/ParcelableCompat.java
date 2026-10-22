package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes17.dex */
public final class ParcelableCompat {

    public static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
        private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> r100) {
            this.mCallbacks = r100;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel r100) {
            return this.mCallbacks.createFromParcel(r100, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int r100) {
            return this.mCallbacks.newArray(r100);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel r100, ClassLoader r101) {
            return this.mCallbacks.createFromParcel(r100, r101);
        }
    }

    private ParcelableCompat() {
    }

    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> r100) {
        return new ParcelableCompatCreatorHoneycombMR2(r100);
    }
}
