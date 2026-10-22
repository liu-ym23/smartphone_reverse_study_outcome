package x9;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.SharedMemory;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import lb.n;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends ObjectInputStream {
        @Override // java.io.ObjectInputStream
        public final Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
            kotlin.jvm.internal.g.c(objectStreamClass);
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, DeepBinderInternal.class.getClassLoader());
            kotlin.jvm.internal.g.e(cls, "forName(...)");
            return cls;
        }
    }

    public static byte[] a(int i10, Object obj) throws IOException {
        if (!(obj instanceof byte[])) {
            Parcel parcelObtain = Parcel.obtain();
            kotlin.jvm.internal.g.e(parcelObtain, "obtain(...)");
            c(parcelObtain, obj, i10);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            kotlin.jvm.internal.g.c(bArrMarshall);
            return bArrMarshall;
        }
        Parcel parcelObtain2 = Parcel.obtain();
        kotlin.jvm.internal.g.e(parcelObtain2, "obtain(...)");
        try {
            parcelObtain2.writeInt(1113150533);
            parcelObtain2.writeInt(((byte[]) obj).length);
            byte[] bArrMarshall2 = parcelObtain2.marshall();
            parcelObtain2.recycle();
            kotlin.jvm.internal.g.c(bArrMarshall2);
            byte[] bArr = (byte[]) obj;
            int length = bArrMarshall2.length;
            int length2 = bArr.length;
            byte[] bArrCopyOf = Arrays.copyOf(bArrMarshall2, length + length2);
            System.arraycopy(bArr, 0, bArrCopyOf, length, length2);
            kotlin.jvm.internal.g.c(bArrCopyOf);
            return bArrCopyOf;
        } catch (Exception unused) {
            parcelObtain2.recycle();
            return (byte[]) obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object b(Parcel parcel, int i10) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NegativeArraySizeException {
        Parcelable.Creator<?> creator;
        int i11 = parcel.readInt();
        String str = q9.a.f11629a;
        Object[] objArr = null;
        if (i11 != -1) {
            if (i11 == 0) {
                byte[] bArrCreateByteArray = parcel.createByteArray();
                kotlin.jvm.internal.g.c(bArrCreateByteArray);
                return new String(bArrCreateByteArray, gc.a.f9106b);
            }
            if (i11 == 1) {
                return Integer.valueOf(parcel.readInt());
            }
            if (i11 == 2) {
                if (i10 < 1) {
                    return parcel.readHashMap(DeepBinderInternal.class.getClassLoader());
                }
                try {
                    Object objNewInstance = Class.forName(parcel.readString()).newInstance();
                    kotlin.jvm.internal.g.d(objNewInstance, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any?, kotlin.Any?>");
                    Map mapB = k.b(objNewInstance);
                    parcel.readMap(mapB, DeepBinderInternal.class.getClassLoader());
                    return mapB;
                } catch (Exception unused) {
                    return parcel.readHashMap(DeepBinderInternal.class.getClassLoader());
                }
            }
            if (i11 == 3) {
                return parcel.readBundle(DeepBinderInternal.class.getClassLoader());
            }
            if (i11 == 4) {
                return parcel.readParcelable(DeepBinderInternal.class.getClassLoader());
            }
            if (i11 == 5) {
                return Short.valueOf((short) parcel.readInt());
            }
            if (i11 == 6) {
                return Long.valueOf(parcel.readLong());
            }
            if (i11 == 7) {
                return Float.valueOf(parcel.readFloat());
            }
            if (i11 == 8) {
                return Double.valueOf(parcel.readDouble());
            }
            int i12 = 0;
            if (i11 == 9) {
                return Boolean.valueOf(parcel.readInt() == 1);
            }
            if (i11 == 10) {
                return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            }
            if (i11 == 11) {
                if (i10 < 1) {
                    return parcel.readArrayList(DeepBinderInternal.class.getClassLoader());
                }
                try {
                    Object objNewInstance2 = Class.forName(parcel.readString()).newInstance();
                    kotlin.jvm.internal.g.d(objNewInstance2, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                    List listA = k.a(objNewInstance2);
                    parcel.readList(listA, DeepBinderInternal.class.getClassLoader());
                    return listA;
                } catch (Exception unused2) {
                    return parcel.readArrayList(DeepBinderInternal.class.getClassLoader());
                }
            }
            if (i11 == 12) {
                return parcel.readSparseArray(DeepBinderInternal.class.getClassLoader());
            }
            if (i11 == 13) {
                return parcel.createByteArray();
            }
            if (i11 == 14) {
                return parcel.createStringArray();
            }
            if (i11 == 15) {
                return parcel.readStrongBinder();
            }
            if (i11 == 16) {
                String string = parcel.readString();
                int i13 = parcel.readInt();
                try {
                    n9.e eVarA = n9.e.f10682e.a();
                    kotlin.jvm.internal.g.c(string);
                    Class<?> clsB = eVarA.b(string);
                    if (clsB == null) {
                        throw new RuntimeException("Cannot find class: ".concat(string));
                    }
                    HashMap<String, Parcelable.Creator<?>> map = g.f13768a;
                    synchronized (map) {
                        try {
                            String name = clsB.getName();
                            Parcelable.Creator<?> creator2 = map.get(name);
                            if (creator2 == null) {
                                Field declaredField = clsB.getDeclaredField("CREATOR");
                                declaredField.setAccessible(true);
                                Object obj = declaredField.get(null);
                                kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type android.os.Parcelable.Creator<*>");
                                creator2 = (Parcelable.Creator) obj;
                                map.put(name, creator2);
                            }
                            creator = creator2;
                        } finally {
                        }
                    }
                    Object[] objArrNewArray = creator.newArray(i13);
                    while (i12 < i13) {
                        objArrNewArray[i12] = creator.createFromParcel(parcel);
                        i12++;
                    }
                    return objArrNewArray;
                } catch (IPCException e10) {
                    throw new RuntimeException(e10);
                }
            }
            if (i11 == 17) {
                int i14 = parcel.readInt();
                if (i14 >= 0) {
                    String string2 = parcel.readString();
                    if (string2 == null || string2.length() == 0) {
                        objArr = new Object[i14];
                        while (i12 < i14) {
                            objArr[i12] = b(parcel, i10);
                            i12++;
                        }
                    } else {
                        try {
                            Class<?> clsB2 = n9.e.f10682e.a().b(string2);
                            if (clsB2 == null) {
                                throw new ClassNotFoundException("Cannot find class: ".concat(string2));
                            }
                            Object objNewInstance3 = Array.newInstance(clsB2, i14);
                            kotlin.jvm.internal.g.d(objNewInstance3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                            objArr = (Object[]) objNewInstance3;
                            for (int i15 = 0; i15 < i14; i15++) {
                                objArr[i15] = b(parcel, i10);
                            }
                        } catch (Exception e11) {
                            IPCLog.INSTANCE.w("SerializeUtils", a0.a.k("Failed to restore array type: ", string2, ", fallback to Object array"), e11);
                            objArr = new Object[i14];
                            while (i12 < i14) {
                                objArr[i12] = b(parcel, i10);
                                i12++;
                            }
                        }
                    }
                }
                return objArr;
            }
            if (i11 == 18) {
                return parcel.createIntArray();
            }
            if (i11 == 19) {
                return parcel.createLongArray();
            }
            if (i11 == 20) {
                return Byte.valueOf(parcel.readByte());
            }
            if (i11 == 21) {
                try {
                    return new a(new ByteArrayInputStream(parcel.createByteArray())).readObject();
                } catch (IOException unused3) {
                    throw new RuntimeException("Parcelable encountered IOException reading a Serializable object");
                } catch (ClassNotFoundException unused4) {
                    throw new RuntimeException("Parcelable encountered ClassNotFoundException reading a Serializable object");
                }
            }
            if (i11 == 22) {
                return parcel.readSparseBooleanArray();
            }
            if (i11 == 23) {
                return parcel.createBooleanArray();
            }
            if (i11 != 24) {
                if (i11 == 25) {
                    return parcel.readPersistableBundle(DeepBinderInternal.class.getClassLoader());
                }
                if (i11 == 26) {
                    return parcel.readSize();
                }
                if (i11 == 27) {
                    return parcel.readSizeF();
                }
                if (i11 == 28) {
                    return parcel.createDoubleArray();
                }
                throw new RuntimeException("Parcel " + parcel + ": Unmarshalling unknown type code " + i11 + " at offset " + (parcel.dataPosition() - 4));
            }
            String string3 = parcel.readString();
            int i16 = parcel.readInt();
            if (i16 >= 0) {
                try {
                    n9.e eVarA2 = n9.e.f10682e.a();
                    kotlin.jvm.internal.g.c(string3);
                    Class<?> clsB3 = eVarA2.b(string3);
                    if (clsB3 == null) {
                        clsB3 = CharSequence.class;
                    }
                    Object objNewInstance4 = Array.newInstance(clsB3, i16);
                    kotlin.jvm.internal.g.d(objNewInstance4, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence?>");
                    CharSequence[] charSequenceArr = (CharSequence[]) objNewInstance4;
                    for (int i17 = 0; i17 < i16; i17++) {
                        charSequenceArr[i17] = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                    }
                    return charSequenceArr;
                } catch (Exception unused5) {
                    CharSequence[] charSequenceArr2 = new CharSequence[i16];
                    while (i12 < i16) {
                        charSequenceArr2[i12] = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                        i12++;
                    }
                    return charSequenceArr2;
                }
            }
        }
        return null;
    }

    public static void c(Parcel parcel, Object obj, int i10) throws IOException {
        if (obj == null) {
            String str = q9.a.f11629a;
            parcel.writeInt(-1);
            return;
        }
        if (obj instanceof Size) {
            parcel.writeInt(26);
            parcel.writeSize((Size) obj);
            return;
        }
        if (obj instanceof SizeF) {
            parcel.writeInt(27);
            parcel.writeSizeF((SizeF) obj);
            return;
        }
        if (obj instanceof PersistableBundle) {
            parcel.writeInt(25);
            parcel.writePersistableBundle((PersistableBundle) obj);
            return;
        }
        if (obj instanceof String) {
            parcel.writeInt(0);
            byte[] bytes = ((String) obj).getBytes(gc.a.f9106b);
            kotlin.jvm.internal.g.e(bytes, "getBytes(...)");
            parcel.writeByteArray(bytes);
            return;
        }
        if (obj instanceof Integer) {
            parcel.writeInt(1);
            parcel.writeInt(((Number) obj).intValue());
            return;
        }
        if (obj instanceof Map) {
            parcel.writeInt(2);
            if (i10 >= 1) {
                parcel.writeString(obj.getClass().getName());
            }
            parcel.writeMap(k.b(obj));
            return;
        }
        if (obj instanceof Bundle) {
            parcel.writeInt(3);
            parcel.writeBundle((Bundle) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            parcel.writeInt(4);
            parcel.writeParcelable((Parcelable) obj, 0);
            return;
        }
        if (obj instanceof Short) {
            parcel.writeInt(5);
            parcel.writeInt(((Number) obj).shortValue());
            return;
        }
        if (obj instanceof Long) {
            parcel.writeInt(6);
            parcel.writeLong(((Number) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            parcel.writeInt(7);
            parcel.writeFloat(((Number) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            parcel.writeInt(8);
            parcel.writeDouble(((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Boolean) {
            parcel.writeInt(9);
            parcel.writeInt(((Boolean) obj).booleanValue() ? 1 : 0);
            return;
        }
        if (obj instanceof CharSequence) {
            parcel.writeInt(10);
            TextUtils.writeToParcel((CharSequence) obj, parcel, 0);
            return;
        }
        if (obj instanceof List) {
            parcel.writeInt(11);
            if (i10 >= 1) {
                parcel.writeString(obj.getClass().getName());
            }
            parcel.writeList(k.a(obj));
            return;
        }
        if (obj instanceof SparseArray) {
            parcel.writeInt(12);
            parcel.writeSparseArray((SparseArray) obj);
            return;
        }
        if (obj instanceof boolean[]) {
            parcel.writeInt(23);
            parcel.writeBooleanArray((boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            parcel.writeInt(13);
            parcel.writeByteArray((byte[]) obj);
            return;
        }
        boolean z = obj instanceof Object[];
        if (z && (((Object[]) obj) instanceof String[])) {
            parcel.writeInt(14);
            parcel.writeStringArray((String[]) obj);
            return;
        }
        if (z) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof CharSequence[]) {
                parcel.writeInt(24);
                Class<?> componentType = obj.getClass().getComponentType();
                parcel.writeString(componentType != null ? componentType.getName() : "");
                parcel.writeInt(objArr.length);
                for (Object obj2 : objArr) {
                    TextUtils.writeToParcel((CharSequence) obj2, parcel, 0);
                }
                return;
            }
        }
        if (obj instanceof IBinder) {
            parcel.writeInt(15);
            parcel.writeStrongBinder((IBinder) obj);
            return;
        }
        if (z) {
            Object[] objArr2 = (Object[]) obj;
            for (Object obj3 : objArr2) {
                if (obj3 instanceof Parcelable) {
                }
            }
            parcel.writeInt(16);
            Class<?> componentType2 = obj.getClass().getComponentType();
            parcel.writeString(componentType2 != null ? componentType2.getName() : "");
            parcel.writeInt(objArr2.length);
            for (Object obj4 : objArr2) {
                Parcelable parcelable = obj4 instanceof Parcelable ? (Parcelable) obj4 : null;
                if (parcelable != null) {
                    parcelable.writeToParcel(parcel, 0);
                }
            }
            return;
        }
        if (obj instanceof int[]) {
            parcel.writeInt(18);
            parcel.writeIntArray((int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            parcel.writeInt(19);
            parcel.writeLongArray((long[]) obj);
            return;
        }
        if (obj instanceof Byte) {
            parcel.writeInt(20);
            parcel.writeByte(((Number) obj).byteValue());
            return;
        }
        if (obj instanceof double[]) {
            parcel.writeInt(28);
            parcel.writeDoubleArray((double[]) obj);
            return;
        }
        if (obj.getClass().isArray()) {
            parcel.writeInt(17);
            Object[] objArr3 = (Object[]) obj;
            parcel.writeInt(objArr3.length);
            Class<?> componentType3 = objArr3.getClass().getComponentType();
            parcel.writeString(componentType3 != null ? componentType3.getName() : "");
            for (Object obj5 : objArr3) {
                c(parcel, obj5, i10);
            }
            return;
        }
        if (!(obj instanceof Serializable)) {
            throw new RuntimeException("Parcel: unable to marshal value " + obj);
        }
        parcel.writeInt(21);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                n nVar = n.f10413a;
                objectOutputStream.close();
                parcel.writeByteArray(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                y.q(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    public static Object d(ClassLoader classLoader, Parcel parcel, int i10) throws Throwable {
        SharedMemory sharedMemory;
        ByteBuffer byteBufferMapReadOnly;
        byte[] bArr;
        int i11;
        if (parcel.readInt() != 1) {
            return b(parcel, i10);
        }
        Parcelable parcelable = parcel.readParcelable(classLoader);
        ByteBuffer byteBuffer = null;
        if (parcelable == null) {
            parcelable = null;
        }
        try {
            if (parcelable == null) {
                bArr = null;
            } else {
                try {
                    sharedMemory = (SharedMemory) parcelable;
                    byteBufferMapReadOnly = sharedMemory.mapReadOnly();
                } catch (Exception e10) {
                    e = e10;
                }
                try {
                    bArr = new byte[byteBufferMapReadOnly.limit()];
                    byteBufferMapReadOnly.get(bArr);
                    sharedMemory.close();
                    SharedMemory.unmap(byteBufferMapReadOnly);
                    byteBufferMapReadOnly.clear();
                    try {
                        SharedMemory.unmap(byteBufferMapReadOnly);
                        byteBufferMapReadOnly.clear();
                    } catch (Exception unused) {
                        n nVar = n.f10413a;
                    }
                } catch (Exception e11) {
                    e = e11;
                    IPCLog.INSTANCE.w("SharedMemory", "[getDataFromFileDescriptor] Failed to decode big data", "exception", e);
                    e.printStackTrace();
                    throw new RuntimeException("OS above 8.0 big data decode error", e);
                } catch (Throwable th) {
                    th = th;
                    byteBuffer = byteBufferMapReadOnly;
                    if (byteBuffer != null) {
                        try {
                            SharedMemory.unmap(byteBuffer);
                            byteBuffer.clear();
                        } catch (Exception unused2) {
                            n nVar2 = n.f10413a;
                        }
                    }
                    throw th;
                }
            }
            if (bArr == null) {
                return null;
            }
            if (bArr.length >= 8) {
                Parcel parcelObtain = Parcel.obtain();
                kotlin.jvm.internal.g.e(parcelObtain, "obtain(...)");
                try {
                    parcelObtain.unmarshall(bArr, 0, Math.min(8, bArr.length));
                    parcelObtain.setDataPosition(0);
                    if (parcelObtain.readInt() == 1113150533 && (i11 = parcelObtain.readInt()) >= 0 && i11 == bArr.length - 8) {
                        byte[] bArrU = b1.u(bArr, 8, bArr.length);
                        parcelObtain.recycle();
                        return bArrU;
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    parcelObtain.recycle();
                    throw th2;
                }
                parcelObtain.recycle();
            }
            Parcel parcelObtain2 = Parcel.obtain();
            kotlin.jvm.internal.g.e(parcelObtain2, "obtain(...)");
            parcelObtain2.unmarshall(bArr, 0, bArr.length);
            parcelObtain2.setDataPosition(0);
            Object objB = b(parcelObtain2, i10);
            parcelObtain2.recycle();
            return objB;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void e(Parcel parcel, Object obj, int i10, int i11) throws IOException {
        if ((obj instanceof byte[]) && ((byte[]) obj).length > 49152) {
            parcel.writeInt(1);
            parcel.writeParcelable(w9.f.a(a(i10, obj)), i11);
            return;
        }
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        c(parcel, obj, i10);
        if (parcel.dataSize() > 49152) {
            parcel.setDataSize(iDataPosition);
            parcel.setDataPosition(iDataPosition);
            parcel.writeInt(1);
            parcel.writeParcelable(w9.f.a(a(i10, obj)), i11);
        }
    }
}
