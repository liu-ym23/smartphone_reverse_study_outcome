package kotlin.reflect.jvm.internal.impl.builtins;

import G8.b;
import G8.f;
import ca.AbstractC0897f;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class UnsignedType {
    public static final /* synthetic */ UnsignedType[] d;

    /* renamed from: a, reason: collision with root package name */
    public final b f4945a;
    public final f b;
    public final b c;

    static {
        UnsignedType[] unsignedTypeArr = {new UnsignedType("UBYTE", 0, AbstractC0897f.A("kotlin/UByte", false)), new UnsignedType("USHORT", 1, AbstractC0897f.A("kotlin/UShort", false)), new UnsignedType("UINT", 2, AbstractC0897f.A("kotlin/UInt", false)), new UnsignedType("ULONG", 3, AbstractC0897f.A("kotlin/ULong", false))};
        d = unsignedTypeArr;
        a.a(unsignedTypeArr);
    }

    public UnsignedType(String str, int i, b bVar) {
        this.f4945a = bVar;
        f fVarF = bVar.f();
        this.b = fVarF;
        this.c = new b(bVar.f687a, f.e(fVarF.b() + "Array"));
    }

    public static UnsignedType valueOf(String str) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) d.clone();
    }
}
