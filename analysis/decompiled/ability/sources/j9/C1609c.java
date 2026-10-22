package j9;

import java.util.Iterator;

/* renamed from: j9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1609c implements i9.i {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f4780a;
    public final int b;
    public final S7.n c;

    public C1609c(CharSequence input, int i, S7.n nVar) {
        kotlin.jvm.internal.k.f(input, "input");
        this.f4780a = input;
        this.b = i;
        this.c = nVar;
    }

    @Override // i9.i
    public final Iterator iterator() {
        return new C1608b(this);
    }
}
