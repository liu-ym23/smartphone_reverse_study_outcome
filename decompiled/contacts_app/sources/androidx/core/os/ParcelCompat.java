package androidx.core.os;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelCompat {

    static class Api29Impl {
        private Api29Impl() {
        }

        static <T extends Parcelable> List<T> readParcelableList(Parcel r0, List<T> r1, ClassLoader r2) {
            return r0.readParcelableList(r1, r2);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Parcelable.Creator<?> readParcelableCreator(Parcel r0, ClassLoader r1) {
            return r0.readParcelableCreator(r1);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T extends Serializable> T readSerializable(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T) r0.readSerializable(r1, r2);
        }

        static <T extends Parcelable> T readParcelable(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T) r0.readParcelable(r1, r2);
        }

        static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r0, ClassLoader r1, Class<T> r2) {
            return r0.readParcelableCreator(r1, r2);
        }

        static <T> T[] readParcelableArray(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T[]) r0.readParcelableArray(r1, r2);
        }

        static <T> List<T> readParcelableList(Parcel r0, List<T> r1, ClassLoader r2, Class<T> r3) {
            return r0.readParcelableList(r1, r2, r3);
        }

        static <T> void readList(Parcel r0, List<? super T> r1, ClassLoader r2, Class<T> r3) {
            r0.readList(r1, r2, r3);
        }

        static <T> ArrayList<T> readArrayList(Parcel r0, ClassLoader r1, Class<? extends T> r2) {
            return r0.readArrayList(r1, r2);
        }

        static <T> T[] readArray(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T[]) r0.readArray(r1, r2);
        }

        static <T> SparseArray<T> readSparseArray(Parcel r0, ClassLoader r1, Class<? extends T> r2) {
            return r0.readSparseArray(r1, r2);
        }

        static <K, V> void readMap(Parcel r0, Map<? super K, ? super V> r1, ClassLoader r2, Class<K> r3, Class<V> r4) {
            r0.readMap(r1, r2, r3, r4);
        }

        static <V, K> HashMap<K, V> readHashMap(Parcel r0, ClassLoader r1, Class<? extends K> r2, Class<? extends V> r3) {
            return r0.readHashMap(r1, r2, r3);
        }
    }

    public static boolean readBoolean(Parcel r0) {
        if (r0.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void writeBoolean(Parcel r0, boolean r1) {
        r0.writeInt(r1 ? 1 : 0);
    }

    public static <T> void readList(Parcel r1, List<? super T> r2, ClassLoader r3, Class<T> r4) {
        if (BuildCompat.isAtLeastU() == false) goto L5;
        Api33Impl.readList(r1, r2, r3, r4);
        return;
    L5:
        r1.readList(r2, r3);
    }

    public static <T> ArrayList<T> readArrayList(Parcel r1, ClassLoader r2, Class<? extends T> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readArrayList(r1, r2, r3);
    L7:
        return r1.readArrayList(r2);
    }

    public static <T> Object[] readArray(Parcel r1, ClassLoader r2, Class<T> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readArray(r1, r2, r3);
    L7:
        return r1.readArray(r2);
    }

    public static <T> SparseArray<T> readSparseArray(Parcel r1, ClassLoader r2, Class<? extends T> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readSparseArray(r1, r2, r3);
    L7:
        return r1.readSparseArray(r2);
    }

    public static <K, V> void readMap(Parcel r1, Map<? super K, ? super V> r2, ClassLoader r3, Class<K> r4, Class<V> r5) {
        if (BuildCompat.isAtLeastU() == false) goto L5;
        Api33Impl.readMap(r1, r2, r3, r4, r5);
        return;
    L5:
        r1.readMap(r2, r3);
    }

    public static <K, V> HashMap<K, V> readHashMap(Parcel r1, ClassLoader r2, Class<? extends K> r3, Class<? extends V> r4) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readHashMap(r1, r2, r3, r4);
    L7:
        return r1.readHashMap(r2);
    }

    public static <T extends Parcelable> T readParcelable(Parcel r2, ClassLoader r3, Class<T> r4) {
        if (BuildCompat.isAtLeastU() == true) goto L5;
        T r5 = (T) r2.readParcelable(r3);
        if (r5 != null) goto L9;
    L13:
        return r5;
    L9:
        if (r4.isInstance(r5) == true) goto L13;
        throw new BadParcelableException("Parcelable " + r5.getClass() + " is not a subclass of required class " + r4.getName() + " provided in the parameter");
    L5:
        return (T) Api33Impl.readParcelable(r2, r3, r4);
    }

    public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r1, ClassLoader r2, Class<T> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readParcelableCreator(r1, r2, r3);
    L7:
        return (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static <T> T[] readParcelableArray(Parcel r2, ClassLoader r3, Class<T> r4) {
        if (BuildCompat.isAtLeastU() == true) goto L5;
        Parcelable[] r5 = r2.readParcelableArray(r3);
        if (r4.isAssignableFrom(Parcelable.class) == true) goto L9;
        T[] r6 = (T[]) ((Object[]) Array.newInstance(r4, r5.length));
        int r0 = 0;
    L12:
        if (r0 >= r5.length) goto L17;
        r6[r0] = r4.cast(r5[r0]);     // Catch: ClassCastException -> L15
        r0 = r0 + 1;
    L16:
        throw new BadParcelableException("Parcelable at index " + r0 + " is not a subclass of required class " + r4.getName() + " provided in the parameter");
    L17:
        return r6;
    L9:
        return (T[]) r5;
    L5:
        return (T[]) Api33Impl.readParcelableArray(r2, r3, r4);
    }

    public static <T> Parcelable[] readParcelableArrayTyped(Parcel r1, ClassLoader r2, Class<T> r3) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return (Parcelable[]) Api33Impl.readParcelableArray(r1, r2, r3);
    L7:
        return r1.readParcelableArray(r2);
    }

    public static <T> List<T> readParcelableList(Parcel r1, List<T> r2, ClassLoader r3, Class<T> r4) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readParcelableList(r1, r2, r3, r4);
    L7:
        return Api29Impl.readParcelableList(r1, r2, r3);
    }

    public static <T extends Serializable> T readSerializable(Parcel r1, ClassLoader r2, Class<T> r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return (T) Api33Impl.readSerializable(r1, r2, r3);
    L7:
        return (T) r1.readSerializable();
    }

    private ParcelCompat() {
    }
}
