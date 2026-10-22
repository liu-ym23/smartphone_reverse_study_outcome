package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable r100) {
            super(r100);
        }
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public abstract boolean readBoolean();

    public abstract Bundle readBundle();

    public abstract byte[] readByteArray();

    public abstract CharSequence readCharSequence();

    public abstract double readDouble();

    public abstract boolean readField(int r100);

    public abstract float readFloat();

    public abstract int readInt();

    public abstract long readLong();

    public abstract <T extends Parcelable> T readParcelable();

    public abstract String readString();

    public abstract IBinder readStrongBinder();

    public abstract void setOutputField(int r100);

    public void setSerializationFlags(boolean r100, boolean r101) {
    }

    public abstract void writeBoolean(boolean r100);

    public abstract void writeBundle(Bundle r100);

    public abstract void writeByteArray(byte[] r100);

    public abstract void writeByteArray(byte[] r100, int r101, int r102);

    public abstract void writeCharSequence(CharSequence r100);

    public abstract void writeDouble(double r100);

    public abstract void writeFloat(float r100);

    public abstract void writeInt(int r100);

    public abstract void writeLong(long r100);

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(Parcelable r100);

    public abstract void writeString(String r100);

    public abstract void writeStrongBinder(IBinder r100);

    public abstract void writeStrongInterface(IInterface r100);

    public Serializable readSerializable() {
        String r100 = readString();
        if (r100 != null) goto L6;
        return null;
    L6:
        final ByteArrayInputStream r101 = new ByteArrayInputStream(readByteArray());
        return (Serializable) new AnonymousClass1(this, r101).readObject();
    L12:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + r100 + ")", e);
    L9:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + r100 + ")", e);
    }

    private int readExceptionCode() {
        return readInt();
    }

    public boolean[] readBooleanArray() {
        int r100 = readInt();
        if (r100 >= 0) goto L6;
        return null;
    L6:
        boolean[] r101 = new boolean[r100];
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L13;
        if (readInt() == 0) goto L11;
        boolean r103 = true;
    L12:
        r101[r102] = r103;
        r102 = r102 + 1;
        goto L7
    L11:
        r103 = false;
        goto L12
    L13:
        return r101;
    }

    public double[] readDoubleArray() {
        int r100 = readInt();
        if (r100 >= 0) goto L6;
        return null;
    L6:
        double[] r101 = new double[r100];
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L9;
        r101[r102] = readDouble();
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public float[] readFloatArray() {
        int r100 = readInt();
        if (r100 >= 0) goto L6;
        return null;
    L6:
        float[] r101 = new float[r100];
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L9;
        r101[r102] = readFloat();
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public int[] readIntArray() {
        int r100 = readInt();
        if (r100 >= 0) goto L6;
        return null;
    L6:
        int[] r101 = new int[r100];
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L9;
        r101[r102] = readInt();
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public long[] readLongArray() {
        int r100 = readInt();
        if (r100 >= 0) goto L6;
        return null;
    L6:
        long[] r101 = new long[r100];
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L9;
        r101[r102] = readLong();
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String r100 = readString();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (T) readFromParcel(r100, createSubParcel());
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> r100) throws ClassNotFoundException {
        Class r101 = this.mParcelizerCache.get(r100.getName());
        if (r101 != null) goto L6;
        Class r102 = INVOKESTATIC_androidx_versionedparcelable_VersionedParcel_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String.format("%s.%sParcelizer", new Object[]{r100.getPackage().getName(), r100.getSimpleName()}), false, r100.getClassLoader());
        this.mParcelizerCache.put(r100.getName(), r102);
        return r102;
    L6:
        return r101;
    }

    private Method getReadMethod(String r100) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method r101 = this.mReadCache.get(r100);
        if (r101 != null) goto L6;
        System.currentTimeMillis();
        Method r102 = INVOKESTATIC_androidx_versionedparcelable_VersionedParcel_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[]{VersionedParcel.class});
        this.mReadCache.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public static Throwable getRootCause(Throwable r100) {
    L3:
        if (r100.getCause() == null) goto L5;
        r100 = r100.getCause();
        goto L3
    L5:
        return r100;
    }

    private <T> int getType(T r100) {
        if ((r100 instanceof String) == false) goto L7;
        return 4;
    L7:
        if ((r100 instanceof Parcelable) == false) goto L11;
        return 2;
    L11:
        if ((r100 instanceof VersionedParcelable) == false) goto L15;
        return 1;
    L15:
        if ((r100 instanceof Serializable) == false) goto L19;
        return 3;
    L19:
        if ((r100 instanceof IBinder) == false) goto L23;
        return 5;
    L23:
        if ((r100 instanceof Integer) == false) goto L27;
        return 7;
    L27:
        if ((r100 instanceof Float) == false) goto L31;
        return 8;
    L31:
        throw new IllegalArgumentException(r100.getClass().getName().concat(" cannot be VersionedParcelled"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method getWriteMethod(Class r100) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method r101 = this.mWriteCache.get(r100.getName());
        if (r101 != null) goto L6;
        Class r102 = findParcelClass(r100);
        System.currentTimeMillis();
        Method r103 = r102.getDeclaredMethod("write", new Class[]{r100, VersionedParcel.class});
        this.mWriteCache.put(r100.getName(), r103);
        return r103;
    L6:
        return r101;
    }

    private <T, S extends Collection<T>> S readCollection(S r100) {
        int r101 = readInt();
        if (r101 >= 0) goto L5;
        return null;
    L5:
        if (r101 == 0) goto L30;
        int r102 = readInt();
        if (r101 >= 0) goto L10;
        return null;
    L10:
        if (r102 != 1) goto L12;
    L28:
        if (r101 <= 0) goto L30;
        r100.add(readVersionedParcelable());
        r101 = r101 - 1;
        goto L28
    L12:
        if (r102 != 2) goto L14;
    L26:
        if (r101 <= 0) goto L30;
        r100.add(readParcelable());
        r101 = r101 - 1;
        goto L26
    L14:
        if (r102 != 3) goto L16;
    L24:
        if (r101 <= 0) goto L30;
        r100.add(readSerializable());
        r101 = r101 - 1;
        goto L24
    L16:
        if (r102 != 4) goto L18;
    L22:
        if (r101 <= 0) goto L30;
        r100.add(readString());
        r101 = r101 - 1;
        goto L22
    L18:
        if (r102 != 5) goto L30;
    L20:
        if (r101 <= 0) goto L30;
        r100.add(readStrongBinder());
        r101 = r101 - 1;
    L30:
        return r100;
    }

    private <T> void writeCollection(Collection<T> r100) {
        if (r100 != null) goto L5;
        writeInt(-1);
        return;
    L5:
        int r101 = r100.size();
        writeInt(r101);
        if (r101 <= 0) goto L38;
        int r102 = getType(r100.iterator().next());
        writeInt(r102);
        switch(r102) {
            case 1: goto L34;
            case 2: goto L30;
            case 3: goto L26;
            case 4: goto L22;
            case 5: goto L18;
            case 6: goto L46;
            case 7: goto L14;
            case 8: goto L10;
            default: goto L46;
        };
    L10:
        Iterator<T> r103 = r100.iterator();
    L12:
        if (r103.hasNext() == false) goto L47;
        writeFloat(((Float) r103.next()).floatValue());
        goto L12
    L47:
        return;
    L14:
        Iterator<T> r104 = r100.iterator();
    L16:
        if (r104.hasNext() == false) goto L48;
        writeInt(((Integer) r104.next()).intValue());
        goto L16
    L48:
        return;
    L18:
        Iterator<T> r105 = r100.iterator();
    L20:
        if (r105.hasNext() == false) goto L49;
        writeStrongBinder((IBinder) r105.next());
        goto L20
    L49:
        return;
    L22:
        Iterator<T> r106 = r100.iterator();
    L24:
        if (r106.hasNext() == false) goto L50;
        writeString((String) r106.next());
        goto L24
    L50:
        return;
    L26:
        Iterator<T> r107 = r100.iterator();
    L28:
        if (r107.hasNext() == false) goto L51;
        writeSerializable((Serializable) r107.next());
        goto L28
    L51:
        return;
    L30:
        Iterator<T> r108 = r100.iterator();
    L32:
        if (r108.hasNext() == false) goto L52;
        writeParcelable((Parcelable) r108.next());
        goto L32
    L52:
        return;
    L34:
        Iterator<T> r109 = r100.iterator();
    L36:
        if (r109.hasNext() == false) goto L53;
        writeVersionedParcelable((VersionedParcelable) r109.next());
        goto L36
    L53:
        return;
    L46:
        return;
    }

    private void writeSerializable(Serializable r100) {
        if (r100 != null) goto L5;
        writeString(null);
        return;
    L5:
        String r101 = r100.getClass().getName();
        writeString(r101);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        ObjectOutputStream r103 = new ObjectOutputStream(r102);     // Catch: IOException -> L8
        r103.writeObject(r100);     // Catch: IOException -> L8
        r103.close();     // Catch: IOException -> L8
        writeByteArray(r102.toByteArray());     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + r101 + ")", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable r100) {
        writeString(findParcelClass(r100.getClass()).getName());
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(r100.getClass().getSimpleName().concat(" does not have a Parcelizer"), e);
    }

    public <T> T[] readArray(T[] r100) {
        int r101 = readInt();
        if (r101 >= 0) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList(r101);
        if (r101 == 0) goto L32;
        int r103 = readInt();
        if (r101 >= 0) goto L11;
        return null;
    L11:
        if (r103 != 1) goto L13;
    L29:
        if (r101 <= 0) goto L32;
        r102.add(readVersionedParcelable());
        r101 = r101 - 1;
        goto L29
    L13:
        if (r103 != 2) goto L15;
    L27:
        if (r101 <= 0) goto L32;
        r102.add(readParcelable());
        r101 = r101 - 1;
        goto L27
    L15:
        if (r103 != 3) goto L17;
    L25:
        if (r101 <= 0) goto L32;
        r102.add(readSerializable());
        r101 = r101 - 1;
        goto L25
    L17:
        if (r103 != 4) goto L19;
    L23:
        if (r101 <= 0) goto L32;
        r102.add(readString());
        r101 = r101 - 1;
        goto L23
    L19:
        if (r103 != 5) goto L32;
    L21:
        if (r101 <= 0) goto L32;
        r102.add(readStrongBinder());
        r101 = r101 - 1;
    L32:
        return (T[]) r102.toArray(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeArray(T[] r100) {
        if (r100 != 0) goto L5;
        writeInt(-1);
        return;
    L5:
        int r101 = r100.length;
        writeInt(r101);
        if (r101 <= 0) goto L28;
        int r102 = 0;
        int r103 = getType(r100[0]);
        writeInt(r103);
        if (r103 != 1) goto L10;
    L26:
        if (r102 >= r101) goto L39;
        writeVersionedParcelable((VersionedParcelable) r100[r102]);
        r102 = r102 + 1;
        goto L26
    L39:
        return;
    L10:
        if (r103 != 2) goto L12;
    L24:
        if (r102 >= r101) goto L38;
        writeParcelable((Parcelable) r100[r102]);
        r102 = r102 + 1;
        goto L24
    L38:
        return;
    L12:
        if (r103 != 3) goto L14;
    L22:
        if (r102 >= r101) goto L37;
        writeSerializable((Serializable) r100[r102]);
        r102 = r102 + 1;
        goto L22
    L37:
        return;
    L14:
        if (r103 != 4) goto L16;
    L20:
        if (r102 >= r101) goto L36;
        writeString((String) r100[r102]);
        r102 = r102 + 1;
        goto L20
    L36:
        return;
    L16:
        if (r103 != 5) goto L34;
    L18:
        if (r102 >= r101) goto L35;
        writeStrongBinder((IBinder) r100[r102]);
        r102 = r102 + 1;
        goto L18
    L35:
        return;
    L34:
        return;
    }

    public void writeBooleanArray(boolean[] r100) {
        if (r100 == null) goto L6;
        int r101 = r100.length;
        writeInt(r101);
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        writeInt(r100[r102] ? 1 : 0);
        r102 = r102 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeDoubleArray(double[] r100) {
        if (r100 == null) goto L6;
        int r101 = r100.length;
        writeInt(r101);
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        writeDouble(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeFloatArray(float[] r100) {
        if (r100 == null) goto L6;
        int r101 = r100.length;
        writeInt(r101);
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        writeFloat(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeIntArray(int[] r100) {
        if (r100 == null) goto L6;
        int r101 = r100.length;
        writeInt(r101);
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        writeInt(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeLongArray(long[] r100) {
        if (r100 == null) goto L6;
        int r101 = r100.length;
        writeInt(r101);
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        writeLong(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeVersionedParcelable(VersionedParcelable r100) {
        if (r100 != null) goto L5;
        writeString(null);
        return;
    L5:
        writeVersionedParcelableCreator(r100);
        VersionedParcel r101 = createSubParcel();
        writeToParcel(r100, r101);
        r101.closeField();
    }

    private Exception createException(int r100, String r101) {
        switch(r100) {
            case -9: goto L20;
            case -8: goto L4;
            case -7: goto L18;
            case -6: goto L16;
            case -5: goto L14;
            case -4: goto L12;
            case -3: goto L10;
            case -2: goto L8;
            case -1: goto L6;
            default: goto L4;
        };
    L4:
        return new RuntimeException("Unknown exception code: " + r100 + " msg " + r101);
    L6:
        return new SecurityException(r101);
    L8:
        return new BadParcelableException(r101);
    L10:
        return new IllegalArgumentException(r101);
    L12:
        return new NullPointerException(r101);
    L14:
        return new IllegalStateException(r101);
    L16:
        return new NetworkOnMainThreadException();
    L18:
        return new UnsupportedOperationException(r101);
    L20:
        return (Exception) readParcelable();
    }

    private <T> void writeCollection(Collection<T> r100, int r101) {
        setOutputField(r101);
        writeCollection(r100);
    }

    public <T> T[] readArray(T[] r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return (T[]) readArray(r100);
    }

    public boolean readBoolean(boolean r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readBooleanArray();
    }

    public Bundle readBundle(Bundle r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readBundle();
    }

    public byte readByte(byte r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return (byte) (readInt() & 255);
    }

    public byte[] readByteArray(byte[] r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readByteArray();
    }

    public char[] readCharArray(char[] r100, int r101) {
        if (readField(r101) == true) goto L5;
        return r100;
    L5:
        int r102 = readInt();
        if (r102 >= 0) goto L9;
        return null;
    L9:
        char[] r103 = new char[r102];
        int r104 = 0;
    L10:
        if (r104 >= r102) goto L12;
        r103[r104] = (char) readInt();
        r104 = r104 + 1;
        goto L10
    L12:
        return r103;
    }

    public CharSequence readCharSequence(CharSequence r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readCharSequence();
    }

    public double readDouble(double r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readDouble();
    }

    public double[] readDoubleArray(double[] r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readDoubleArray();
    }

    public Exception readException(Exception r100, int r101) {
        if (readField(r101) == true) goto L5;
        return r100;
    L5:
        int r102 = readExceptionCode();
        if (r102 != 0) goto L8;
        return r100;
    L8:
        return readException(r102, readString());
    }

    public float readFloat(float r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readFloat();
    }

    public float[] readFloatArray(float[] r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readFloatArray();
    }

    public <T extends VersionedParcelable> T readFromParcel(String r100, VersionedParcel r101) {
        return (T) getReadMethod(r100).invoke(null, new Object[]{r101});
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L17:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L7:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L10:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L16;
        throw ((RuntimeException) e.getCause());
    L16:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public int readInt(int r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readInt();
    }

    public int[] readIntArray(int[] r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readIntArray();
    }

    public <T> List<T> readList(List<T> r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return (List) readCollection(new ArrayList());
    }

    public long readLong(long r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readLong();
    }

    public long[] readLongArray(long[] r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> r100, int r101) {
        if (readField(r101) == true) goto L5;
        return r100;
    L5:
        int r102 = readInt();
        if (r102 >= 0) goto L9;
        return null;
    L9:
        ArrayMap r103 = new ArrayMap();
        if (r102 != 0) goto L12;
        return r103;
    L12:
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        readCollection(r104);
        readCollection(r105);
        int r106 = 0;
    L13:
        if (r106 >= r102) goto L15;
        r103.put(ListProtector.get(r104, r106), ListProtector.get(r105, r106));
        r106 = r106 + 1;
        goto L13
    L15:
        return r103;
    }

    public <T extends Parcelable> T readParcelable(T r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return (T) readParcelable();
    }

    public <T> Set<T> readSet(Set<T> r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return (Set) readCollection(new ArraySet());
    }

    public Size readSize(Size r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new Size(readInt(), readInt());
    }

    public SizeF readSizeF(SizeF r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new SizeF(readFloat(), readFloat());
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray r100, int r101) {
        if (readField(r101) == true) goto L5;
        return r100;
    L5:
        int r102 = readInt();
        if (r102 >= 0) goto L9;
        return null;
    L9:
        SparseBooleanArray r103 = new SparseBooleanArray(r102);
        int r104 = 0;
    L10:
        if (r104 >= r102) goto L12;
        r103.put(readInt(), readBoolean());
        r104 = r104 + 1;
        goto L10
    L12:
        return r103;
    }

    public String readString(String r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readString();
    }

    public IBinder readStrongBinder(IBinder r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T r100, int r101) {
        if (readField(r101) == true) goto L6;
        return r100;
    L6:
        return (T) readVersionedParcelable();
    }

    public <T> void writeArray(T[] r100, int r101) {
        setOutputField(r101);
        writeArray(r100);
    }

    public void writeBoolean(boolean r100, int r101) {
        setOutputField(r101);
        writeBoolean(r100);
    }

    public void writeBooleanArray(boolean[] r100, int r101) {
        setOutputField(r101);
        writeBooleanArray(r100);
    }

    public void writeBundle(Bundle r100, int r101) {
        setOutputField(r101);
        writeBundle(r100);
    }

    public void writeByte(byte r100, int r101) {
        setOutputField(r101);
        writeInt(r100);
    }

    public void writeByteArray(byte[] r100, int r101) {
        setOutputField(r101);
        writeByteArray(r100);
    }

    public void writeCharArray(char[] r100, int r101) {
        setOutputField(r101);
        if (r100 == null) goto L7;
        int r102 = r100.length;
        writeInt(r102);
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        writeInt(r100[r103]);
        r103 = r103 + 1;
        goto L5
    L10:
        return;
    L7:
        writeInt(-1);
    }

    public void writeCharSequence(CharSequence r100, int r101) {
        setOutputField(r101);
        writeCharSequence(r100);
    }

    public void writeDouble(double r100, int r101) {
        setOutputField(r101);
        writeDouble(r100);
    }

    public void writeDoubleArray(double[] r100, int r101) {
        setOutputField(r101);
        writeDoubleArray(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception r100, int r101) {
        setOutputField(r101);
        if (r100 != 0) goto L7;
        writeNoException();
        return;
    L7:
        if ((r100 instanceof Parcelable) == false) goto L12;
        if (r100.getClass().getClassLoader() != Parcelable.class.getClassLoader()) goto L12;
        int r102 = -9;
    L33:
        writeInt(r102);
        if (r102 == 0) goto L36;
        writeString(r100.getMessage());
        if (r102 != (-9)) goto L46;
        writeParcelable((Parcelable) r100);
        return;
    L46:
        return;
    L36:
        if ((r100 instanceof RuntimeException) == false) goto L40;
        throw ((RuntimeException) r100);
    L40:
        throw new RuntimeException(r100);
    L12:
        if ((r100 instanceof SecurityException) == false) goto L15;
        r102 = -1;
        goto L33
    L15:
        if ((r100 instanceof BadParcelableException) == false) goto L18;
        r102 = -2;
        goto L33
    L18:
        if ((r100 instanceof IllegalArgumentException) == false) goto L21;
        r102 = -3;
        goto L33
    L21:
        if ((r100 instanceof NullPointerException) == false) goto L24;
        r102 = -4;
        goto L33
    L24:
        if ((r100 instanceof IllegalStateException) == false) goto L27;
        r102 = -5;
        goto L33
    L27:
        if ((r100 instanceof NetworkOnMainThreadException) == false) goto L30;
        r102 = -6;
        goto L33
    L30:
        if ((r100 instanceof UnsupportedOperationException) == false) goto L32;
        r102 = -7;
        goto L33
    L32:
        r102 = 0;
        goto L33
    }

    public void writeFloat(float r100, int r101) {
        setOutputField(r101);
        writeFloat(r100);
    }

    public void writeFloatArray(float[] r100, int r101) {
        setOutputField(r101);
        writeFloatArray(r100);
    }

    public void writeInt(int r100, int r101) {
        setOutputField(r101);
        writeInt(r100);
    }

    public void writeIntArray(int[] r100, int r101) {
        setOutputField(r101);
        writeIntArray(r100);
    }

    public <T> void writeList(List<T> r100, int r101) {
        writeCollection(r100, r101);
    }

    public void writeLong(long r100, int r101) {
        setOutputField(r101);
        writeLong(r100);
    }

    public void writeLongArray(long[] r100, int r101) {
        setOutputField(r101);
        writeLongArray(r100);
    }

    public <K, V> void writeMap(Map<K, V> r100, int r101) {
        setOutputField(r101);
        if (r100 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r102 = r100.size();
        writeInt(r102);
        if (r102 != 0) goto L9;
        return;
    L9:
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        Iterator<Map.Entry<K, V>> r105 = r100.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        Map.Entry<K, V> r106 = r105.next();
        r103.add(r106.getKey());
        r104.add(r106.getValue());
        goto L11
    L13:
        writeCollection(r103);
        writeCollection(r104);
    }

    public void writeParcelable(Parcelable r100, int r101) {
        setOutputField(r101);
        writeParcelable(r100);
    }

    public void writeSerializable(Serializable r100, int r101) {
        setOutputField(r101);
        writeSerializable(r100);
    }

    public <T> void writeSet(Set<T> r100, int r101) {
        writeCollection(r100, r101);
    }

    public void writeSize(Size r100, int r101) {
        setOutputField(r101);
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        writeBoolean(r102);
        if (r100 == null) goto L10;
        writeInt(r100.getWidth());
        writeInt(r100.getHeight());
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void writeSizeF(SizeF r100, int r101) {
        setOutputField(r101);
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        writeBoolean(r102);
        if (r100 == null) goto L10;
        writeFloat(r100.getWidth());
        writeFloat(r100.getHeight());
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void writeSparseBooleanArray(SparseBooleanArray r100, int r101) {
        setOutputField(r101);
        if (r100 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r102 = r100.size();
        writeInt(r102);
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        writeInt(r100.keyAt(r103));
        writeBoolean(r100.valueAt(r103));
        r103 = r103 + 1;
        goto L7
    }

    public void writeString(String r100, int r101) {
        setOutputField(r101);
        writeString(r100);
    }

    public void writeStrongBinder(IBinder r100, int r101) {
        setOutputField(r101);
        writeStrongBinder(r100);
    }

    public void writeStrongInterface(IInterface r100, int r101) {
        setOutputField(r101);
        writeStrongInterface(r100);
    }

    public <T extends VersionedParcelable> void writeToParcel(T r100, VersionedParcel r101) {
        getWriteMethod(r100.getClass()).invoke(null, new Object[]{r100, r101});     // Catch: ClassNotFoundException -> L4 NoSuchMethodException -> L7 InvocationTargetException -> L10 IllegalAccessException -> L17
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L17:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L7:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L10:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L16;
        throw ((RuntimeException) e.getCause());
    L16:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public void writeVersionedParcelable(VersionedParcelable r100, int r101) {
        setOutputField(r101);
        writeVersionedParcelable(r100);
    }

    private Exception readException(int r100, String r101) {
        return createException(r100, r101);
    }

    public VersionedParcel(ArrayMap<String, Method> r100, ArrayMap<String, Method> r101, ArrayMap<String, Class> r102) {
        this.mReadCache = r100;
        this.mWriteCache = r101;
        this.mParcelizerCache = r102;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_versionedparcelable_VersionedParcel_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public void writeByteArray(byte[] r100, int r101, int r102, int r103) {
        setOutputField(r103);
        writeByteArray(r100, r101, r102);
    }
}
