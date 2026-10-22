package kotlin.reflect.jvm.internal.impl.builtins;

import D7.q;
import G8.f;
import e8.j;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class PrimitiveType {
    public static final Set e;
    public static final PrimitiveType f;
    public static final PrimitiveType g;
    public static final PrimitiveType h;
    public static final PrimitiveType i;

    /* renamed from: j, reason: collision with root package name */
    public static final PrimitiveType f4942j;
    public static final PrimitiveType k;
    public static final PrimitiveType l;
    public static final PrimitiveType m;
    public static final /* synthetic */ PrimitiveType[] n;

    /* renamed from: a, reason: collision with root package name */
    public final f f4943a;
    public final f b;
    public final Object c;
    public final Object d;

    static {
        PrimitiveType primitiveType = new PrimitiveType("BOOLEAN", 0, "Boolean");
        f = primitiveType;
        PrimitiveType primitiveType2 = new PrimitiveType("CHAR", 1, "Char");
        g = primitiveType2;
        PrimitiveType primitiveType3 = new PrimitiveType("BYTE", 2, "Byte");
        h = primitiveType3;
        PrimitiveType primitiveType4 = new PrimitiveType("SHORT", 3, "Short");
        i = primitiveType4;
        PrimitiveType primitiveType5 = new PrimitiveType("INT", 4, "Int");
        f4942j = primitiveType5;
        PrimitiveType primitiveType6 = new PrimitiveType("FLOAT", 5, "Float");
        k = primitiveType6;
        PrimitiveType primitiveType7 = new PrimitiveType("LONG", 6, "Long");
        l = primitiveType7;
        PrimitiveType primitiveType8 = new PrimitiveType("DOUBLE", 7, "Double");
        m = primitiveType8;
        PrimitiveType[] primitiveTypeArr = {primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7, primitiveType8};
        n = primitiveTypeArr;
        a.a(primitiveTypeArr);
        e = q.K0(new PrimitiveType[]{primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7, primitiveType8});
    }

    public PrimitiveType(String str, int i6, String str2) {
        this.f4943a = f.e(str2);
        this.b = f.e(str2.concat("Array"));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        this.c = kotlin.a.b(lazyThreadSafetyMode, new j(this, 0));
        this.d = kotlin.a.b(lazyThreadSafetyMode, new j(this, 1));
    }

    public static PrimitiveType valueOf(String str) {
        return (PrimitiveType) Enum.valueOf(PrimitiveType.class, str);
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) n.clone();
    }
}
