package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: ConstantValueFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ConstantValueFactory {
    public static final ConstantValueFactory INSTANCE = null;

    static {
        INSTANCE = new ConstantValueFactory();
    }

    private ConstantValueFactory() {
    }

    public final ArrayValue createArrayValue(List<? extends ConstantValue<?>> r2, final KotlinType r3) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "type");
        return new ArrayValue(r2, new AnonymousClass1(r3));
    }

    public final ConstantValue<?> createConstantValue(Object r3) {
        if ((r3 instanceof Byte) == false) goto L6;
        return new ByteValue(((Number) r3).byteValue());
    L6:
        if ((r3 instanceof Short) == false) goto L9;
        return new ShortValue(((Number) r3).shortValue());
    L9:
        if ((r3 instanceof Integer) == false) goto L12;
        return new IntValue(((Number) r3).intValue());
    L12:
        if ((r3 instanceof Long) == false) goto L15;
        return new LongValue(((Number) r3).longValue());
    L15:
        if ((r3 instanceof Character) == false) goto L18;
        return new CharValue(((Character) r3).charValue());
    L18:
        if ((r3 instanceof Float) == false) goto L21;
        return new FloatValue(((Number) r3).floatValue());
    L21:
        if ((r3 instanceof Double) == false) goto L24;
        return new DoubleValue(((Number) r3).doubleValue());
    L24:
        if ((r3 instanceof Boolean) == false) goto L27;
        return new BooleanValue(((Boolean) r3).booleanValue());
    L27:
        if ((r3 instanceof String) == false) goto L30;
        return new StringValue((String) r3);
    L30:
        if ((r3 instanceof byte[]) == false) goto L33;
        return createArrayValue(ArraysKt.toList((byte[]) r3), PrimitiveType.BYTE);
    L33:
        if ((r3 instanceof short[]) == false) goto L36;
        return createArrayValue(ArraysKt.toList((short[]) r3), PrimitiveType.SHORT);
    L36:
        if ((r3 instanceof int[]) == false) goto L39;
        return createArrayValue(ArraysKt.toList((int[]) r3), PrimitiveType.INT);
    L39:
        if ((r3 instanceof long[]) == false) goto L42;
        return createArrayValue(ArraysKt.toList((long[]) r3), PrimitiveType.LONG);
    L42:
        if ((r3 instanceof char[]) == false) goto L45;
        return createArrayValue(ArraysKt.toList((char[]) r3), PrimitiveType.CHAR);
    L45:
        if ((r3 instanceof float[]) == false) goto L48;
        return createArrayValue(ArraysKt.toList((float[]) r3), PrimitiveType.FLOAT);
    L48:
        if ((r3 instanceof double[]) == false) goto L51;
        return createArrayValue(ArraysKt.toList((double[]) r3), PrimitiveType.DOUBLE);
    L51:
        if ((r3 instanceof boolean[]) == true) goto L73;
        if (r3 == null) goto L74;
        return null;
    L74:
        return new NullValue();
    L73:
        return createArrayValue(ArraysKt.toList((boolean[]) r3), PrimitiveType.BOOLEAN);
    }

    private final ArrayValue createArrayValue(List<?> r3, final PrimitiveType r4) {
        List r5 = CollectionsKt.toList(r3);
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        ConstantValue<?> r1 = createConstantValue(r6.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return new ArrayValue(r0, new AnonymousClass3(r4));
    }
}
