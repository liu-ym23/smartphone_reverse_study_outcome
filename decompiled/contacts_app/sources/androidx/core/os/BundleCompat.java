package androidx.core.os;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BundleCompat {

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T getParcelable(Bundle r0, String r1, Class<T> r2) {
            return (T) r0.getParcelable(r1, r2);
        }

        static <T> T[] getParcelableArray(Bundle r0, String r1, Class<T> r2) {
            return (T[]) r0.getParcelableArray(r1, r2);
        }

        static <T> ArrayList<T> getParcelableArrayList(Bundle r0, String r1, Class<? extends T> r2) {
            return r0.getParcelableArrayList(r1, r2);
        }

        static <T> SparseArray<T> getSparseParcelableArray(Bundle r0, String r1, Class<? extends T> r2) {
            return r0.getSparseParcelableArray(r1, r2);
        }
    }

    private BundleCompat() {
    }

    public static <T> T getParcelable(Bundle r1, String r2, Class<T> r3) {
        if (BuildCompat.isAtLeastU() == true) goto L5;
        T r4 = (T) r1.getParcelable(r2);
        if (r3.isInstance(r4) == true) goto L11;
        return null;
    L11:
        return r4;
    L5:
        return (T) Api33Impl.getParcelable(r1, r2, r3);
    }

    public static Parcelable[] getParcelableArray(Bundle r1, String r2, Class<? extends Parcelable> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return (Parcelable[]) Api33Impl.getParcelableArray(r1, r2, r3);
    L7:
        return r1.getParcelableArray(r2);
    }

    public static <T> ArrayList<T> getParcelableArrayList(Bundle r1, String r2, Class<? extends T> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.getParcelableArrayList(r1, r2, r3);
    L7:
        return r1.getParcelableArrayList(r2);
    }

    public static <T> SparseArray<T> getSparseParcelableArray(Bundle r1, String r2, Class<? extends T> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.getSparseParcelableArray(r1, r2, r3);
    L7:
        return r1.getSparseParcelableArray(r2);
    }
}
