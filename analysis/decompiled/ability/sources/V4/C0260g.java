package V4;

import com.stepos.common.ChatContentType;

/* renamed from: V4.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0260g extends AbstractC0262i {
    public final String b;
    public final ChatContentType c;

    public C0260g(String text) {
        kotlin.jvm.internal.k.f(text, "text");
        this.b = text;
        this.c = ChatContentType.f3540a;
    }

    @Override // V4.AbstractC0262i
    public final ChatContentType a() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0260g) && kotlin.jvm.internal.k.b(this.b, ((C0260g) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return B7.a.m("Text(text=", this.b, ")");
    }
}
