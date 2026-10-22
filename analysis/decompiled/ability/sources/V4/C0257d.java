package V4;

import com.stepos.common.ChatContentType;
import java.util.Arrays;

/* renamed from: V4.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0257d extends AbstractC0262i {
    public final byte[] b;
    public final ChatContentType c = ChatContentType.f;

    public C0257d(byte[] bArr) {
        this.b = bArr;
    }

    @Override // V4.AbstractC0262i
    public final ChatContentType a() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0257d) && kotlin.jvm.internal.k.b(this.b, ((C0257d) obj).b);
    }

    public final int hashCode() {
        byte[] bArr = this.b;
        if (bArr == null) {
            return 0;
        }
        return Arrays.hashCode(bArr);
    }

    public final String toString() {
        return B7.a.m("Bytes(content=", Arrays.toString(this.b), ")");
    }
}
