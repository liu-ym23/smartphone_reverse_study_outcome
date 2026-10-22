package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.ReplaceWith;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public final class BundleCompat {

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static <T> T getParcelable(Bundle r100, String r101, Class<T> r102) {
            return (T) r100.getParcelable(r101, r102);
        }

        public static <T> T[] getParcelableArray(Bundle r100, String r101, Class<T> r102) {
            return (T[]) r100.getParcelableArray(r101, r102);
        }

        public static <T> ArrayList<T> getParcelableArrayList(Bundle r100, String r101, Class<? extends T> r102) {
            return r100.getParcelableArrayList(r101, r102);
        }

        public static <T extends Serializable> T getSerializable(Bundle r100, String r101, Class<T> r102) {
            return (T) r100.getSerializable(r101, r102);
        }

        public static <T> SparseArray<T> getSparseParcelableArray(Bundle r100, String r101, Class<? extends T> r102) {
            return r100.getSparseParcelableArray(r101, r102);
        }
    }

    private BundleCompat() {
    }

    @ReplaceWith(expression = "bundle.getBinder(key)")
    public static IBinder getBinder(Bundle r100, String r101) {
        return r100.getBinder(r101);
    }

    public static <T> T getParcelable(Bundle r100, String r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r103 = (T) r100.getParcelable(r101);
        if (r102.isInstance(r103) == true) goto L11;
        return null;
    L11:
        return r103;
    L5:
        return (T) Api33Impl.getParcelable(r100, r101, r102);
    }

    public static Parcelable[] getParcelableArray(Bundle r100, String r101, Class<? extends Parcelable> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) Api33Impl.getParcelableArray(r100, r101, r102);
    L7:
        return r100.getParcelableArray(r101);
    }

    public static <T> ArrayList<T> getParcelableArrayList(Bundle r100, String r101, Class<? extends T> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getParcelableArrayList(r100, r101, r102);
    L7:
        return r100.getParcelableArrayList(r101);
    }

    public static <T extends Serializable> T getSerializable(Bundle r100, String r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r103 = (T) r100.getSerializable(r101);
        if (r102.isInstance(r103) == true) goto L11;
        return null;
    L11:
        return r103;
    L5:
        return (T) Api33Impl.getSerializable(r100, r101, r102);
    }

    public static <T> SparseArray<T> getSparseParcelableArray(Bundle r100, String r101, Class<? extends T> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getSparseParcelableArray(r100, r101, r102);
    L7:
        return r100.getSparseParcelableArray(r101);
    }

    @ReplaceWith(expression = "bundle.putBinder(key, binder)")
    public static void putBinder(Bundle r100, String r101, IBinder r102) {
        r100.putBinder(r101, r102);
    }
}
