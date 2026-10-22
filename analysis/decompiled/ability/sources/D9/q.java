package D9;

import C9.AbstractC0200b;
import C9.x;
import D7.v;
import java.util.List;

/* loaded from: classes4.dex */
public final class q extends o {

    /* renamed from: j, reason: collision with root package name */
    public final x f444j;
    public final List k;
    public final int l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(AbstractC0200b json, x value) {
        super(json, value, (String) null, 12);
        kotlin.jvm.internal.k.f(json, "json");
        kotlin.jvm.internal.k.f(value, "value");
        this.f444j = value;
        List listF1 = v.f1(value.f335a.keySet());
        this.k = listF1;
        this.l = listF1.size() * 2;
        this.m = -1;
    }

    @Override // D9.o, D9.a
    public final C9.l b(String tag) {
        kotlin.jvm.internal.k.f(tag, "tag");
        return this.m % 2 == 0 ? C9.m.b(tag) : (C9.l) kotlin.collections.a.N(tag, this.f444j);
    }

    @Override // D9.o, A9.c
    public final int decodeElementIndex(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        int i = this.m;
        if (i >= this.l - 1) {
            return -1;
        }
        int i6 = i + 1;
        this.m = i6;
        return i6;
    }

    @Override // D9.o, D9.a, A9.c
    public final void endStructure(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
    }

    @Override // D9.o, D9.a
    public final String o(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return (String) this.k.get(i / 2);
    }

    @Override // D9.o, D9.a
    public final C9.l q() {
        return this.f444j;
    }

    @Override // D9.o
    /* renamed from: v */
    public final x q() {
        return this.f444j;
    }
}
