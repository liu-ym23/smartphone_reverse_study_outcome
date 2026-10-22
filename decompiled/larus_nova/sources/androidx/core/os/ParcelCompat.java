package androidx.core.os;

import android.os.BadParcelableException;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public final class ParcelCompat {

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void writeBoolean(Parcel r100, boolean r101) {
            r100.writeBoolean(r101);
        }

        public static <T extends Parcelable> List<T> readParcelableList(Parcel r100, List<T> r101, ClassLoader r102) {
            return r100.readParcelableList(r101, r102);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static Parcelable.Creator<?> readParcelableCreator(Parcel r100, ClassLoader r101) {
            return r100.readParcelableCreator(r101);
        }
    }

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static <T> T[] readArray(Parcel r100, ClassLoader r101, Class<T> r102) {
            return (T[]) r100.readArray(r101, r102);
        }

        public static <T> ArrayList<T> readArrayList(Parcel r100, ClassLoader r101, Class<? extends T> r102) {
            return r100.readArrayList(r101, r102);
        }

        public static <T extends Parcelable> T readParcelable(Parcel r100, ClassLoader r101, Class<T> r102) {
            return (T) r100.readParcelable(r101, r102);
        }

        public static <T> T[] readParcelableArray(Parcel r100, ClassLoader r101, Class<T> r102) {
            return (T[]) r100.readParcelableArray(r101, r102);
        }

        public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r100, ClassLoader r101, Class<T> r102) {
            return r100.readParcelableCreator(r101, r102);
        }

        public static <T extends Serializable> T readSerializable(Parcel r100, ClassLoader r101, Class<T> r102) {
            return (T) r100.readSerializable(r101, r102);
        }

        public static <T> SparseArray<T> readSparseArray(Parcel r100, ClassLoader r101, Class<? extends T> r102) {
            return r100.readSparseArray(r101, r102);
        }

        public static <V, K> HashMap<K, V> readHashMap(Parcel r100, ClassLoader r101, Class<? extends K> r102, Class<? extends V> r103) {
            return r100.readHashMap(r101, r102, r103);
        }

        public static <T> void readList(Parcel r100, List<? super T> r101, ClassLoader r102, Class<T> r103) {
            r100.readList(r101, r102, r103);
        }

        public static <T> List<T> readParcelableList(Parcel r100, List<T> r101, ClassLoader r102, Class<T> r103) {
            return r100.readParcelableList(r101, r102, r103);
        }

        public static <K, V> void readMap(Parcel r100, Map<? super K, ? super V> r101, ClassLoader r102, Class<K> r103, Class<V> r104) {
            r100.readMap(r101, r102, r103, r104);
        }
    }

    private ParcelCompat() {
    }

    public static boolean readBoolean(Parcel r100) {
        if (r100.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void writeBoolean(Parcel r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        Api29Impl.writeBoolean(r100, r101);
        return;
    L5:
        r100.writeInt(r101 ? 1 : 0);
    }

    public static <T> Object[] readArray(Parcel r100, ClassLoader r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readArray(r100, r101, r102);
    L7:
        return r100.readArray(r101);
    }

    public static <T> ArrayList<T> readArrayList(Parcel r100, ClassLoader r101, Class<? extends T> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readArrayList(r100, r101, r102);
    L7:
        return r100.readArrayList(r101);
    }

    public static <T extends Parcelable> T readParcelable(Parcel r100, ClassLoader r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r103 = (T) r100.readParcelable(r101);
        if (r103 != null) goto L9;
    L13:
        return r103;
    L9:
        if (r102.isInstance(r103) == true) goto L13;
        throw new BadParcelableException("Parcelable " + r103.getClass() + " is not a subclass of required class " + r102.getName() + " provided in the parameter");
    L5:
        return (T) Api33Impl.readParcelable(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] readParcelableArray(Parcel r100, ClassLoader r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T[] r103 = (T[]) r100.readParcelableArray(r101);
        if (r102.isAssignableFrom(Parcelable.class) == false) goto L9;
        return r103;
    L9:
        T[] r104 = (T[]) ((Object[]) Array.newInstance(r102, r103.length));
        int r105 = 0;
    L11:
        if (r105 >= r103.length) goto L16;
        r104[r105] = r102.cast(r103[r105]);     // Catch: ClassCastException -> L14
        r105 = r105 + 1;
    L15:
        throw new BadParcelableException("Parcelable at index " + r105 + " is not a subclass of required class " + r102.getName() + " provided in the parameter");
    L16:
        return r104;
    L5:
        return (T[]) Api33Impl.readParcelableArray(r100, r101, r102);
    }

    public static <T> Parcelable[] readParcelableArrayTyped(Parcel r100, ClassLoader r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) Api33Impl.readParcelableArray(r100, r101, r102);
    L7:
        return r100.readParcelableArray(r101);
    }

    public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r100, ClassLoader r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readParcelableCreator(r100, r101, r102);
    L7:
        return (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(r100, r101);
    }

    public static <T extends Serializable> T readSerializable(Parcel r100, ClassLoader r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return (T) Api33Impl.readSerializable(r100, r101, r102);
    L7:
        return (T) r100.readSerializable();
    }

    public static <T> SparseArray<T> readSparseArray(Parcel r100, ClassLoader r101, Class<? extends T> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readSparseArray(r100, r101, r102);
    L7:
        return r100.readSparseArray(r101);
    }

    public static <K, V> HashMap<K, V> readHashMap(Parcel r100, ClassLoader r101, Class<? extends K> r102, Class<? extends V> r103) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readHashMap(r100, r101, r102, r103);
    L7:
        return r100.readHashMap(r101);
    }

    public static <T> void readList(Parcel r100, List<? super T> r101, ClassLoader r102, Class<T> r103) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api33Impl.readList(r100, r101, r102, r103);
        return;
    L5:
        r100.readList(r101, r102);
    }

    public static <T> List<T> readParcelableList(Parcel r100, List<T> r101, ClassLoader r102, Class<T> r103) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readParcelableList(r100, r101, r102, r103);
    L7:
        return Api29Impl.readParcelableList(r100, r101, r102);
    }

    public static <K, V> void readMap(Parcel r100, Map<? super K, ? super V> r101, ClassLoader r102, Class<K> r103, Class<V> r104) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api33Impl.readMap(r100, r101, r102, r103, r104);
        return;
    L5:
        r100.readMap(r101, r102);
    }
}
