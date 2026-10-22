package ai.onnxruntime;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OrtUtil {
    private static final Logger logger = Logger.getLogger(OrtUtil.class.getName());

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: ai.onnxruntime.OrtUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ai$onnxruntime$OnnxJavaType;

        static {
            int[] iArr = new int[OnnxJavaType.values().length];
            $SwitchMap$ai$onnxruntime$OnnxJavaType = iArr;
            try {
                iArr[OnnxJavaType.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UINT8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UNKNOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.FLOAT16.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BFLOAT16.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class BufferTuple {
        final long byteSize;
        final Buffer data;
        final boolean isCopy;
        final int pos;
        final long size;

        public BufferTuple(Buffer buffer, int i10, long j10, long j11, boolean z) {
            this.data = buffer;
            this.pos = i10;
            this.byteSize = j10;
            this.size = j11;
            this.isCopy = z;
        }
    }

    private OrtUtil() {
    }

    public static int capacityFromSize(int i10) {
        return (int) ((i10 / 0.75d) + 1.0d);
    }

    public static Object convertBoxedPrimitiveToArray(OnnxJavaType onnxJavaType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[onnxJavaType.ordinal()]) {
            case 1:
                return new float[]{((Float) obj).floatValue()};
            case 2:
                return new double[]{((Double) obj).doubleValue()};
            case 3:
            case 4:
                return new byte[]{((Byte) obj).byteValue()};
            case 5:
                return new short[]{((Short) obj).shortValue()};
            case 6:
                return new int[]{((Integer) obj).intValue()};
            case 7:
                return new long[]{((Long) obj).longValue()};
            case 8:
                return new boolean[]{((Boolean) obj).booleanValue()};
            default:
                return null;
        }
    }

    public static long elementCount(long[] jArr) {
        long j10 = 1;
        for (long j11 : jArr) {
            if (j11 < 0) {
                throw new IllegalArgumentException("Received negative value in shape " + Arrays.toString(jArr) + " .");
            }
            j10 *= j11;
        }
        return j10;
    }

    public static String[] flattenString(Object obj) {
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        ArrayList arrayList = new ArrayList();
        flattenString((Object[]) obj, arrayList);
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static Object newBooleanArray(long[] jArr) {
        return Array.newInstance((Class<?>) Boolean.TYPE, transformShape(jArr));
    }

    public static Object newByteArray(long[] jArr) {
        return Array.newInstance((Class<?>) Byte.TYPE, transformShape(jArr));
    }

    public static Object newDoubleArray(long[] jArr) {
        return Array.newInstance((Class<?>) Double.TYPE, transformShape(jArr));
    }

    public static Object newFloatArray(long[] jArr) {
        return Array.newInstance((Class<?>) Float.TYPE, transformShape(jArr));
    }

    public static Object newIntArray(long[] jArr) {
        return Array.newInstance((Class<?>) Integer.TYPE, transformShape(jArr));
    }

    public static Object newLongArray(long[] jArr) {
        return Array.newInstance((Class<?>) Long.TYPE, transformShape(jArr));
    }

    public static Object newShortArray(long[] jArr) {
        return Array.newInstance((Class<?>) Short.TYPE, transformShape(jArr));
    }

    public static Object newStringArray(long[] jArr) {
        return Array.newInstance((Class<?>) String.class, transformShape(jArr));
    }

    public static BufferTuple prepareBuffer(Buffer buffer, OnnxJavaType onnxJavaType) {
        Buffer bufferPut;
        Buffer buffer2;
        int iPosition;
        if (onnxJavaType == OnnxJavaType.STRING || onnxJavaType == OnnxJavaType.UNKNOWN) {
            throw new IllegalStateException("Cannot create a " + onnxJavaType + " tensor from a buffer");
        }
        if (buffer.remaining() * onnxJavaType.size > Integer.MAX_VALUE - (r2 * 8)) {
            throw new IllegalStateException("Cannot allocate a direct buffer of the requested size and type, size " + buffer.remaining() + ", type = " + onnxJavaType);
        }
        int iRemaining = buffer.remaining() * onnxJavaType.size;
        if (buffer.isDirect()) {
            buffer2 = buffer;
            iPosition = buffer.position() * onnxJavaType.size;
        } else {
            int iPosition2 = buffer.position();
            ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iRemaining).order(ByteOrder.nativeOrder());
            switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[onnxJavaType.ordinal()]) {
                case 1:
                    bufferPut = byteBufferOrder.asFloatBuffer().put((FloatBuffer) buffer);
                    break;
                case 2:
                    bufferPut = byteBufferOrder.asDoubleBuffer().put((DoubleBuffer) buffer);
                    break;
                case 3:
                case 4:
                case 8:
                    bufferPut = byteBufferOrder.put((ByteBuffer) buffer);
                    break;
                case 5:
                case 11:
                case 12:
                    bufferPut = byteBufferOrder.asShortBuffer().put((ShortBuffer) buffer);
                    break;
                case 6:
                    bufferPut = byteBufferOrder.asIntBuffer().put((IntBuffer) buffer);
                    break;
                case 7:
                    bufferPut = byteBufferOrder.asLongBuffer().put((LongBuffer) buffer);
                    break;
                case 9:
                case 10:
                default:
                    throw new IllegalStateException("Impossible to reach here, managed to cast a buffer as an incorrect type, found " + onnxJavaType);
            }
            buffer.position(iPosition2);
            bufferPut.rewind();
            buffer2 = bufferPut;
            iPosition = 0;
        }
        return new BufferTuple(buffer2, iPosition, iRemaining, buffer.remaining(), buffer2 != buffer);
    }

    public static Object reshape(boolean[] zArr, long[] jArr) {
        Object objNewBooleanArray = newBooleanArray(jArr);
        reshape(zArr, objNewBooleanArray, 0);
        return objNewBooleanArray;
    }

    public static int[] transformShape(long[] jArr) {
        if (jArr.length == 0 || jArr.length > 8) {
            throw new IllegalArgumentException("Arrays with less than 1 and greater than 8 dimensions are not supported.");
        }
        int[] iArr = new int[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            long j10 = jArr[i10];
            if (j10 < 0 || j10 > 2147483647L) {
                throw new IllegalArgumentException("Invalid shape for a Java array, expected non-negative entries smaller than Integer.MAX_VALUE. Found " + Arrays.toString(jArr));
            }
            iArr[i10] = (int) j10;
        }
        return iArr;
    }

    public static boolean validateShape(long[] jArr) {
        boolean z = true;
        for (int i10 = 0; i10 < jArr.length; i10++) {
            long j10 = jArr[i10];
            z = z & (j10 > 0) & (((long) ((int) j10)) == j10);
        }
        return z && jArr.length <= 8;
    }

    public static Object reshape(byte[] bArr, long[] jArr) {
        Object objNewByteArray = newByteArray(jArr);
        reshape(bArr, objNewByteArray, 0);
        return objNewByteArray;
    }

    public static Object reshape(short[] sArr, long[] jArr) {
        Object objNewShortArray = newShortArray(jArr);
        reshape(sArr, objNewShortArray, 0);
        return objNewShortArray;
    }

    private static void flattenString(Object[] objArr, ArrayList<String> arrayList) {
        for (Object obj : objArr) {
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                if (cls.getComponentType().isArray()) {
                    flattenString((Object[]) obj, arrayList);
                } else if (cls.getComponentType().equals(String.class)) {
                    arrayList.addAll(Arrays.asList((String[]) obj));
                } else {
                    throw new IllegalStateException("Found a non-String, non-array element type, " + cls);
                }
            } else {
                throw new IllegalStateException("Found an element type where there should have been an array. Class = " + cls);
            }
        }
    }

    public static Object reshape(int[] iArr, long[] jArr) {
        Object objNewIntArray = newIntArray(jArr);
        reshape(iArr, objNewIntArray, 0);
        return objNewIntArray;
    }

    public static Object reshape(long[] jArr, long[] jArr2) {
        Object objNewLongArray = newLongArray(jArr2);
        reshape(jArr, objNewLongArray, 0);
        return objNewLongArray;
    }

    public static long[] transformShape(int[] iArr) {
        if (iArr.length != 0 && iArr.length <= 8) {
            long[] jArr = new long[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                long j10 = iArr[i10];
                if (j10 >= 1) {
                    jArr[i10] = j10;
                } else {
                    throw new IllegalArgumentException("Invalid shape for a Java array, expected positive entries smaller than Integer.MAX_VALUE. Found " + Arrays.toString(iArr));
                }
            }
            return jArr;
        }
        throw new IllegalArgumentException("Arrays with less than 1 and greater than 8 dimensions are not supported.");
    }

    public static Object reshape(float[] fArr, long[] jArr) {
        Object objNewFloatArray = newFloatArray(jArr);
        reshape(fArr, objNewFloatArray, 0);
        return objNewFloatArray;
    }

    public static Object reshape(double[] dArr, long[] jArr) {
        Object objNewDoubleArray = newDoubleArray(jArr);
        reshape(dArr, objNewDoubleArray, 0);
        return objNewDoubleArray;
    }

    public static Object reshape(String[] strArr, long[] jArr) {
        Object objNewStringArray = newStringArray(jArr);
        reshape(strArr, objNewStringArray, 0);
        return objNewStringArray;
    }

    private static int reshape(Object obj, Object obj2, int i10) {
        if (obj2.getClass().isArray()) {
            for (Object obj3 : (Object[]) obj2) {
                Class<?> cls = obj3.getClass();
                if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    if (!componentType.isPrimitive() && componentType != String.class) {
                        i10 = reshape(obj, obj3, i10);
                    } else {
                        int length = Array.getLength(obj3);
                        System.arraycopy(obj, i10, obj3, 0, length);
                        i10 = length + i10;
                    }
                } else {
                    throw new IllegalStateException("Found element type when expecting an array. Class " + cls);
                }
            }
            return i10;
        }
        throw new IllegalStateException("Found element type when expecting an array. Class " + obj2.getClass());
    }
}
