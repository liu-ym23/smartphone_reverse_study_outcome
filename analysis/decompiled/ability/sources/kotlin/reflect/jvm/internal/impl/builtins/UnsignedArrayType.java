package kotlin.reflect.jvm.internal.impl.builtins;

import G8.b;
import G8.f;
import ca.AbstractC0897f;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class UnsignedArrayType {
    public static final UnsignedArrayType b;
    public static final UnsignedArrayType c;
    public static final UnsignedArrayType d;
    public static final UnsignedArrayType e;
    public static final /* synthetic */ UnsignedArrayType[] f;

    /* renamed from: a, reason: collision with root package name */
    public final f f4944a;

    static {
        UnsignedArrayType unsignedArrayType = new UnsignedArrayType("UBYTEARRAY", 0, AbstractC0897f.A("kotlin/UByteArray", false));
        b = unsignedArrayType;
        UnsignedArrayType unsignedArrayType2 = new UnsignedArrayType("USHORTARRAY", 1, AbstractC0897f.A("kotlin/UShortArray", false));
        c = unsignedArrayType2;
        UnsignedArrayType unsignedArrayType3 = new UnsignedArrayType("UINTARRAY", 2, AbstractC0897f.A("kotlin/UIntArray", false));
        d = unsignedArrayType3;
        UnsignedArrayType unsignedArrayType4 = new UnsignedArrayType("ULONGARRAY", 3, AbstractC0897f.A("kotlin/ULongArray", false));
        e = unsignedArrayType4;
        UnsignedArrayType[] unsignedArrayTypeArr = {unsignedArrayType, unsignedArrayType2, unsignedArrayType3, unsignedArrayType4};
        f = unsignedArrayTypeArr;
        a.a(unsignedArrayTypeArr);
    }

    public UnsignedArrayType(String str, int i, b bVar) {
        this.f4944a = bVar.f();
    }

    public static UnsignedArrayType valueOf(String str) {
        return (UnsignedArrayType) Enum.valueOf(UnsignedArrayType.class, str);
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[]) f.clone();
    }
}
