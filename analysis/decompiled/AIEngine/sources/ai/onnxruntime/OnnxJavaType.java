package ai.onnxruntime;

import ai.onnxruntime.TensorInfo;
import com.stepos.core.common.telemetry.FailStage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT8' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OnnxJavaType {
    private static final /* synthetic */ OnnxJavaType[] $VALUES;
    public static final OnnxJavaType BFLOAT16;
    public static final OnnxJavaType BOOL;
    public static final OnnxJavaType DOUBLE;
    public static final OnnxJavaType FLOAT;
    public static final OnnxJavaType FLOAT16;
    public static final OnnxJavaType INT16;
    public static final OnnxJavaType INT32;
    public static final OnnxJavaType INT64;
    public static final OnnxJavaType INT8;
    public static final OnnxJavaType STRING;
    public static final OnnxJavaType UINT8;
    public static final OnnxJavaType UNKNOWN;
    private static final OnnxJavaType[] values;
    public final Class<?> clazz;
    public final int size;
    public final int value;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: ai.onnxruntime.OnnxJavaType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType;

        static {
            int[] iArr = new int[TensorInfo.OnnxTensorType.values().length];
            $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType = iArr;
            try {
                iArr[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    static {
        OnnxJavaType onnxJavaType = new OnnxJavaType("FLOAT", 0, 1, Float.TYPE, 4);
        FLOAT = onnxJavaType;
        OnnxJavaType onnxJavaType2 = new OnnxJavaType("DOUBLE", 1, 2, Double.TYPE, 8);
        DOUBLE = onnxJavaType2;
        Class cls = Byte.TYPE;
        OnnxJavaType onnxJavaType3 = new OnnxJavaType("INT8", 2, 3, cls, 1);
        INT8 = onnxJavaType3;
        Class cls2 = Short.TYPE;
        OnnxJavaType onnxJavaType4 = new OnnxJavaType("INT16", 3, 4, cls2, 2);
        INT16 = onnxJavaType4;
        OnnxJavaType onnxJavaType5 = new OnnxJavaType("INT32", 4, 5, Integer.TYPE, 4);
        INT32 = onnxJavaType5;
        OnnxJavaType onnxJavaType6 = new OnnxJavaType("INT64", 5, 6, Long.TYPE, 8);
        INT64 = onnxJavaType6;
        OnnxJavaType onnxJavaType7 = new OnnxJavaType("BOOL", 6, 7, Boolean.TYPE, 1);
        BOOL = onnxJavaType7;
        OnnxJavaType onnxJavaType8 = new OnnxJavaType("STRING", 7, 8, String.class, 4);
        STRING = onnxJavaType8;
        OnnxJavaType onnxJavaType9 = new OnnxJavaType("UINT8", 8, 9, cls, 1);
        UINT8 = onnxJavaType9;
        OnnxJavaType onnxJavaType10 = new OnnxJavaType("FLOAT16", 9, 10, cls2, 2);
        FLOAT16 = onnxJavaType10;
        OnnxJavaType onnxJavaType11 = new OnnxJavaType("BFLOAT16", 10, 11, cls2, 2);
        BFLOAT16 = onnxJavaType11;
        OnnxJavaType onnxJavaType12 = new OnnxJavaType(FailStage.UNKNOWN, 11, 0, Object.class, 0);
        UNKNOWN = onnxJavaType12;
        $VALUES = new OnnxJavaType[]{onnxJavaType, onnxJavaType2, onnxJavaType3, onnxJavaType4, onnxJavaType5, onnxJavaType6, onnxJavaType7, onnxJavaType8, onnxJavaType9, onnxJavaType10, onnxJavaType11, onnxJavaType12};
        OnnxJavaType[] onnxJavaTypeArrValues = values();
        values = new OnnxJavaType[onnxJavaTypeArrValues.length];
        for (OnnxJavaType onnxJavaType13 : onnxJavaTypeArrValues) {
            values[onnxJavaType13.value] = onnxJavaType13;
        }
    }

    private OnnxJavaType(String str, int i10, int i11, Class cls, int i12) {
        this.value = i11;
        this.clazz = cls;
        this.size = i12;
    }

    public static OnnxJavaType mapFromClass(Class<?> cls) {
        return (cls.equals(Byte.TYPE) || cls.equals(Byte.class)) ? INT8 : (cls.equals(Short.TYPE) || cls.equals(Short.class)) ? INT16 : (cls.equals(Integer.TYPE) || cls.equals(Integer.class)) ? INT32 : (cls.equals(Long.TYPE) || cls.equals(Long.class)) ? INT64 : (cls.equals(Float.TYPE) || cls.equals(Float.class)) ? FLOAT : (cls.equals(Double.TYPE) || cls.equals(Double.class)) ? DOUBLE : (cls.equals(Boolean.TYPE) || cls.equals(Boolean.class)) ? BOOL : cls.equals(String.class) ? STRING : UNKNOWN;
    }

    public static OnnxJavaType mapFromInt(int i10) {
        if (i10 > 0) {
            OnnxJavaType[] onnxJavaTypeArr = values;
            if (i10 < onnxJavaTypeArr.length) {
                return onnxJavaTypeArr[i10];
            }
        }
        return UNKNOWN;
    }

    public static OnnxJavaType mapFromOnnxTensorType(TensorInfo.OnnxTensorType onnxTensorType) {
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$TensorInfo$OnnxTensorType[onnxTensorType.ordinal()]) {
            case 1:
                return UINT8;
            case 2:
                return INT8;
            case 3:
            case 4:
                return INT16;
            case 5:
            case 6:
                return INT32;
            case 7:
            case 8:
                return INT64;
            case 9:
                return FLOAT16;
            case 10:
                return BFLOAT16;
            case 11:
                return FLOAT;
            case 12:
                return DOUBLE;
            case 13:
                return STRING;
            case 14:
                return BOOL;
            default:
                return UNKNOWN;
        }
    }

    public static OnnxJavaType valueOf(String str) {
        return (OnnxJavaType) Enum.valueOf(OnnxJavaType.class, str);
    }

    public static OnnxJavaType[] values() {
        return (OnnxJavaType[]) $VALUES.clone();
    }
}
