package B9;

import java.util.Arrays;
import kotlinx.serialization.SerializationException;

/* renamed from: B9.w, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0195w implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public final Enum[] f262a;
    public final C7.f b;

    public C0195w(String str, Enum[] values) {
        kotlin.jvm.internal.k.f(values, "values");
        this.f262a = values;
        this.b = kotlin.a.a(new A6.i(1, this, str));
    }

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        int iDecodeEnum = decoder.decodeEnum(getDescriptor());
        Enum[] enumArr = this.f262a;
        if (iDecodeEnum >= 0 && iDecodeEnum < enumArr.length) {
            return enumArr[iDecodeEnum];
        }
        throw new SerializationException(iDecodeEnum + " is not among valid " + getDescriptor().h() + " enum values, values size is " + enumArr.length);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return (z9.g) this.b.getF4884a();
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        Enum value = (Enum) obj;
        kotlin.jvm.internal.k.f(value, "value");
        Enum[] enumArr = this.f262a;
        int iU0 = D7.q.u0(enumArr, value);
        if (iU0 != -1) {
            fVar.encodeEnum(getDescriptor(), iU0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().h());
        sb.append(", must be one of ");
        String string = Arrays.toString(enumArr);
        kotlin.jvm.internal.k.e(string, "toString(...)");
        sb.append(string);
        throw new SerializationException(sb.toString());
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().h() + '>';
    }
}
