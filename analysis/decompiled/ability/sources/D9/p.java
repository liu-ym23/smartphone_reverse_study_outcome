package D9;

import C9.AbstractC0200b;

/* loaded from: classes4.dex */
public final class p extends a {
    public final C9.d f;
    public final int g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(AbstractC0200b json, C9.d value) {
        super(json, null);
        kotlin.jvm.internal.k.f(json, "json");
        kotlin.jvm.internal.k.f(value, "value");
        this.f = value;
        this.g = value.f322a.size();
        this.h = -1;
    }

    @Override // D9.a
    public final C9.l b(String tag) throws NumberFormatException {
        kotlin.jvm.internal.k.f(tag, "tag");
        return (C9.l) this.f.f322a.get(Integer.parseInt(tag));
    }

    @Override // A9.c
    public final int decodeElementIndex(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        int i = this.h;
        if (i >= this.g - 1) {
            return -1;
        }
        int i6 = i + 1;
        this.h = i6;
        return i6;
    }

    @Override // D9.a
    public final String o(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return String.valueOf(i);
    }

    @Override // D9.a
    public final C9.l q() {
        return this.f;
    }
}
