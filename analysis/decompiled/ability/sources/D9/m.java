package D9;

import C9.AbstractC0200b;

/* loaded from: classes4.dex */
public final class m extends a {
    public final C9.l f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(AbstractC0200b json, C9.l value, String str) {
        super(json, str);
        kotlin.jvm.internal.k.f(json, "json");
        kotlin.jvm.internal.k.f(value, "value");
        this.f = value;
        this.f435a.add("primitive");
    }

    @Override // D9.a
    public final C9.l b(String tag) {
        kotlin.jvm.internal.k.f(tag, "tag");
        if (tag == "primitive") {
            return this.f;
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag");
    }

    @Override // A9.c
    public final int decodeElementIndex(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return 0;
    }

    @Override // D9.a
    public final C9.l q() {
        return this.f;
    }
}
