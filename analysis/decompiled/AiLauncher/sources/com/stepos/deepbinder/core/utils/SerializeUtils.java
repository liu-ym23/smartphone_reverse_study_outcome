package com.stepos.deepbinder.core.utils;

import La.C0953c;
import Y8.t;
import Z8.C1168p;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.cache.TypeCache;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.parser.ParameterWrapperParser;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.SharedMemory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import l9.b;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J5\u0010#\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J7\u0010'\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/deepbinder/core/utils/SerializeUtils;", "", "<init>", "()V", "", SingleFileBundle.KEY_BYTES, "", "version", "decode", "([BI)Ljava/lang/Object;", "obj", "encode", "(Ljava/lang/Object;I)[B", "Landroid/os/Parcel;", "parcel", "internalReadFromParcel", "(Landroid/os/Parcel;I)Ljava/lang/Object;", "LY8/t;", "internalWriteToParcel", "(Landroid/os/Parcel;Ljava/lang/Object;I)V", "", "readArray", "(Landroid/os/Parcel;I)[Ljava/lang/Object;", "array", "writeArray", "(Landroid/os/Parcel;[Ljava/lang/Object;I)V", "Ljava/lang/ClassLoader;", "classLoader", "readFromParcel", "(Ljava/lang/ClassLoader;Landroid/os/Parcel;I)Ljava/lang/Object;", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "readParameterWrapperArray", "(Landroid/os/Parcel;I)[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "parameterWrappers", "flags", "writeParameterWrapperArray", "(Landroid/os/Parcel;[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;II)V", "", "useSharedMemory", "writeToParcel", "(Landroid/os/Parcel;Ljava/lang/Object;IIZ)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerializeUtils {
    public static final SerializeUtils INSTANCE = new SerializeUtils();

    private SerializeUtils() {
    }

    private final Object decode(byte[] bytes, int version) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NegativeArraySizeException {
        int i10;
        if (bytes == null) {
            return null;
        }
        if (bytes.length >= 8) {
            Parcel parcelObtain = Parcel.obtain();
            p.h(parcelObtain, "obtain(...)");
            try {
                parcelObtain.unmarshall(bytes, 0, Math.min(8, bytes.length));
                parcelObtain.setDataPosition(0);
                if (parcelObtain.readInt() == 1113150533 && (i10 = parcelObtain.readInt()) >= 0 && i10 == bytes.length - 8) {
                    byte[] bArrO = C1168p.o(bytes, 8, bytes.length);
                    parcelObtain.recycle();
                    return bArrO;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
            parcelObtain.recycle();
        }
        Parcel parcelObtain2 = Parcel.obtain();
        p.h(parcelObtain2, "obtain(...)");
        parcelObtain2.unmarshall(bytes, 0, bytes.length);
        parcelObtain2.setDataPosition(0);
        Object objInternalReadFromParcel = this.internalReadFromParcel(parcelObtain2, version);
        parcelObtain2.recycle();
        return objInternalReadFromParcel;
    }

    private final byte[] encode(Object obj, int version) throws IOException {
        if (!(obj instanceof byte[])) {
            Parcel parcelObtain = Parcel.obtain();
            p.h(parcelObtain, "obtain(...)");
            internalWriteToParcel(parcelObtain, obj, version);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            p.f(bArrMarshall);
            return bArrMarshall;
        }
        Parcel parcelObtain2 = Parcel.obtain();
        p.h(parcelObtain2, "obtain(...)");
        try {
            parcelObtain2.writeInt(1113150533);
            parcelObtain2.writeInt(((byte[]) obj).length);
            byte[] bArrMarshall2 = parcelObtain2.marshall();
            parcelObtain2.recycle();
            p.f(bArrMarshall2);
            return C1168p.E(bArrMarshall2, (byte[]) obj);
        } catch (Exception unused) {
            parcelObtain2.recycle();
            return (byte[]) obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object internalReadFromParcel(Parcel parcel, int version) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NegativeArraySizeException {
        Parcelable.Creator creator;
        int i10 = parcel.readInt();
        if (i10 == Constants.INSTANCE.getVAL_NULL()) {
            return null;
        }
        if (i10 == 0) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            p.f(bArrCreateByteArray);
            return new String(bArrCreateByteArray, C0953c.UTF_8);
        }
        if (i10 == 1) {
            return Integer.valueOf(parcel.readInt());
        }
        if (i10 == 2) {
            if (version < 1) {
                return parcel.readHashMap(DeepBinderInternal.class.getClassLoader());
            }
            try {
                Object objNewInstance = Class.forName(parcel.readString()).newInstance();
                p.g(objNewInstance, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any?, kotlin.Any?>");
                Map mapD = z.d(objNewInstance);
                parcel.readMap(mapD, DeepBinderInternal.class.getClassLoader());
                return mapD;
            } catch (Exception unused) {
                return parcel.readHashMap(DeepBinderInternal.class.getClassLoader());
            }
        }
        if (i10 == 3) {
            return parcel.readBundle(DeepBinderInternal.class.getClassLoader());
        }
        if (i10 == 4) {
            return parcel.readParcelable(DeepBinderInternal.class.getClassLoader());
        }
        if (i10 == 5) {
            return Short.valueOf((short) parcel.readInt());
        }
        if (i10 == 6) {
            return Long.valueOf(parcel.readLong());
        }
        if (i10 == 7) {
            return Float.valueOf(parcel.readFloat());
        }
        if (i10 == 8) {
            return Double.valueOf(parcel.readDouble());
        }
        int i11 = 0;
        if (i10 == 9) {
            return Boolean.valueOf(parcel.readInt() == 1);
        }
        if (i10 == 10) {
            return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
        if (i10 == 11) {
            if (version < 1) {
                return parcel.readArrayList(DeepBinderInternal.class.getClassLoader());
            }
            try {
                Object objNewInstance2 = Class.forName(parcel.readString()).newInstance();
                p.g(objNewInstance2, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                List listC = z.c(objNewInstance2);
                parcel.readList(listC, DeepBinderInternal.class.getClassLoader());
                return listC;
            } catch (Exception unused2) {
                return parcel.readArrayList(DeepBinderInternal.class.getClassLoader());
            }
        }
        if (i10 == 12) {
            return parcel.readSparseArray(DeepBinderInternal.class.getClassLoader());
        }
        if (i10 == 13) {
            return parcel.createByteArray();
        }
        if (i10 == 14) {
            return parcel.createStringArray();
        }
        if (i10 == 15) {
            return parcel.readStrongBinder();
        }
        if (i10 == 16) {
            String string = parcel.readString();
            int i12 = parcel.readInt();
            try {
                TypeCache companion = TypeCache.INSTANCE.getInstance();
                p.f(string);
                Class<?> classType = companion.getClassType(string);
                if (classType == null) {
                    throw new RuntimeException("Cannot find class: " + string);
                }
                synchronized (SerializeUtilsKt.creatorMap) {
                    try {
                        HashMap map = SerializeUtilsKt.creatorMap;
                        String name = classType.getName();
                        Object obj = map.get(name);
                        if (obj == null) {
                            Field declaredField = classType.getDeclaredField("CREATOR");
                            declaredField.setAccessible(true);
                            Object obj2 = declaredField.get(null);
                            p.g(obj2, "null cannot be cast to non-null type android.os.Parcelable.Creator<*>");
                            obj = (Parcelable.Creator) obj2;
                            map.put(name, obj);
                        }
                        creator = (Parcelable.Creator) obj;
                    } finally {
                    }
                }
                Object[] objArrNewArray = creator.newArray(i12);
                while (i11 < i12) {
                    objArrNewArray[i11] = creator.createFromParcel(parcel);
                    i11++;
                }
                return objArrNewArray;
            } catch (IPCException e10) {
                throw new RuntimeException(e10);
            }
        }
        if (i10 == 17) {
            return readArray(parcel, version);
        }
        if (i10 == 18) {
            return parcel.createIntArray();
        }
        if (i10 == 19) {
            return parcel.createLongArray();
        }
        if (i10 == 20) {
            return Byte.valueOf(parcel.readByte());
        }
        if (i10 == 21) {
            try {
                return new ObjectInputStream(new ByteArrayInputStream(parcel.createByteArray())) { // from class: com.stepos.deepbinder.core.utils.SerializeUtils.internalReadFromParcel.1
                    @Override // java.io.ObjectInputStream
                    public Class<?> resolveClass(ObjectStreamClass desc) throws ClassNotFoundException {
                        p.f(desc);
                        Class<?> cls = Class.forName(desc.getName(), false, DeepBinderInternal.class.getClassLoader());
                        p.h(cls, "forName(...)");
                        return cls;
                    }
                }.readObject();
            } catch (IOException unused3) {
                throw new RuntimeException("Parcelable encountered IOException reading a Serializable object");
            } catch (ClassNotFoundException unused4) {
                throw new RuntimeException("Parcelable encountered ClassNotFoundException reading a Serializable object");
            }
        }
        if (i10 == 22) {
            return parcel.readSparseBooleanArray();
        }
        if (i10 == 23) {
            return parcel.createBooleanArray();
        }
        if (i10 != 24) {
            if (i10 == 25) {
                return parcel.readPersistableBundle(DeepBinderInternal.class.getClassLoader());
            }
            if (i10 == 26) {
                return parcel.readSize();
            }
            if (i10 == 27) {
                return parcel.readSizeF();
            }
            if (i10 == 28) {
                return parcel.createDoubleArray();
            }
            throw new RuntimeException("Parcel " + parcel + ": Unmarshalling unknown type code " + i10 + " at offset " + (parcel.dataPosition() - 4));
        }
        String string2 = parcel.readString();
        int i13 = parcel.readInt();
        if (i13 < 0) {
            return null;
        }
        try {
            TypeCache companion2 = TypeCache.INSTANCE.getInstance();
            p.f(string2);
            Class<?> classType2 = companion2.getClassType(string2);
            if (classType2 == null) {
                classType2 = CharSequence.class;
            }
            Object objNewInstance3 = Array.newInstance(classType2, i13);
            p.g(objNewInstance3, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence?>");
            CharSequence[] charSequenceArr = (CharSequence[]) objNewInstance3;
            for (int i14 = 0; i14 < i13; i14++) {
                charSequenceArr[i14] = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            }
            return charSequenceArr;
        } catch (Exception unused5) {
            CharSequence[] charSequenceArr2 = new CharSequence[i13];
            while (i11 < i13) {
                charSequenceArr2[i11] = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                i11++;
            }
            return charSequenceArr2;
        }
    }

    private final void internalWriteToParcel(Parcel parcel, Object obj, int version) throws IOException {
        if (obj == null) {
            parcel.writeInt(Constants.INSTANCE.getVAL_NULL());
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
            byte[] bytes = ((String) obj).getBytes(C0953c.UTF_8);
            p.h(bytes, "getBytes(...)");
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
            if (version >= 1) {
                parcel.writeString(obj.getClass().getName());
            }
            parcel.writeMap(z.d(obj));
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
            if (version >= 1) {
                parcel.writeString(obj.getClass().getName());
            }
            parcel.writeList(z.c(obj));
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
        boolean z10 = obj instanceof Object[];
        if (z10 && (((Object[]) obj) instanceof String[])) {
            parcel.writeInt(14);
            parcel.writeStringArray((String[]) obj);
            return;
        }
        if (z10) {
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
        if (z10) {
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
            writeArray(parcel, (Object[]) obj, version);
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
                t tVar = t.f7040a;
                b.a(objectOutputStream, null);
                parcel.writeByteArray(byteArrayOutputStream.toByteArray());
                b.a(byteArrayOutputStream, null);
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    private final Object[] readArray(Parcel parcel, int version) throws ClassNotFoundException, NegativeArraySizeException {
        int i10 = parcel.readInt();
        if (i10 < 0) {
            return null;
        }
        String string = parcel.readString();
        int i11 = 0;
        if (string == null || string.length() == 0) {
            Object[] objArr = new Object[i10];
            while (i11 < i10) {
                objArr[i11] = INSTANCE.internalReadFromParcel(parcel, version);
                i11++;
            }
            return objArr;
        }
        try {
            Class<?> classType = TypeCache.INSTANCE.getInstance().getClassType(string);
            if (classType == null) {
                throw new ClassNotFoundException("Cannot find class: " + string);
            }
            Object objNewInstance = Array.newInstance(classType, i10);
            p.g(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object[] objArr2 = (Object[]) objNewInstance;
            for (int i12 = 0; i12 < i10; i12++) {
                objArr2[i12] = internalReadFromParcel(parcel, version);
            }
            return objArr2;
        } catch (Exception e10) {
            IPCLog.INSTANCE.w("SerializeUtils", "Failed to restore array type: " + string + ", fallback to Object array", e10);
            Object[] objArr3 = new Object[i10];
            while (i11 < i10) {
                objArr3[i11] = INSTANCE.internalReadFromParcel(parcel, version);
                i11++;
            }
            return objArr3;
        }
    }

    private final void writeArray(Parcel parcel, Object[] array, int version) {
        if (array == null) {
            parcel.writeInt(Constants.INSTANCE.getVAL_NULL());
            return;
        }
        parcel.writeInt(array.length);
        Class<?> componentType = array.getClass().getComponentType();
        parcel.writeString(componentType != null ? componentType.getName() : "");
        for (Object obj : array) {
            INSTANCE.internalWriteToParcel(parcel, obj, version);
        }
    }

    public final Object readFromParcel(ClassLoader classLoader, Parcel parcel, int version) {
        p.i(parcel, "parcel");
        if (parcel.readInt() != 1) {
            return internalReadFromParcel(parcel, version);
        }
        Parcelable parcelable = parcel.readParcelable(classLoader);
        if (parcelable == null) {
            parcelable = null;
        }
        return decode(parcelable != null ? SharedMemory.getDataFromFileDescriptor(parcelable) : null, version);
    }

    public final ParameterWrapper[] readParameterWrapperArray(Parcel parcel, int version) {
        p.i(parcel, "parcel");
        int i10 = parcel.readInt();
        if (i10 < 0) {
            return null;
        }
        ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            parameterWrapperArr[i11] = ParameterWrapperParser.INSTANCE.parserParameterWrapperFromParcel(parcel, version);
        }
        return parameterWrapperArr;
    }

    public final void writeParameterWrapperArray(Parcel parcel, ParameterWrapper[] parameterWrappers, int version, int flags) {
        p.i(parcel, "parcel");
        if (parameterWrappers == null) {
            IPCLog.INSTANCE.w("SerializeUtils", "writeParameterWrapperArray parameterWrappers null", new Object[0]);
            return;
        }
        parcel.writeInt(parameterWrappers.length);
        for (ParameterWrapper parameterWrapper : parameterWrappers) {
            ParameterWrapperParser.INSTANCE.writeParameterWrapperIntoParcel(parameterWrapper, parcel, version, flags);
        }
    }

    public final void writeToParcel(Parcel parcel, Object obj, int version, int flags, boolean useSharedMemory) {
        p.i(parcel, "parcel");
        if (useSharedMemory && (obj instanceof byte[]) && ((byte[]) obj).length > Constants.MAX_SIZE) {
            parcel.writeInt(1);
            parcel.writeParcelable(SharedMemory.getFileDescriptorFromData(encode(obj, version)), flags);
            return;
        }
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        internalWriteToParcel(parcel, obj, version);
        int iDataSize = parcel.dataSize();
        if (!useSharedMemory || iDataSize <= Constants.MAX_SIZE) {
            return;
        }
        parcel.setDataSize(iDataPosition);
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(1);
        parcel.writeParcelable(SharedMemory.getFileDescriptorFromData(encode(obj, version)), flags);
    }
}
