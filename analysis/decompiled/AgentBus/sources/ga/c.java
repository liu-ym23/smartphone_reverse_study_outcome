package ga;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements fa.j {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f4014a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4015b;

    /* renamed from: c, reason: collision with root package name */
    public final p7.n f4016c;

    public c(CharSequence charSequence, int i2, p7.n nVar) {
        q7.k.e(charSequence, "input");
        this.f4014a = charSequence;
        this.f4015b = i2;
        this.f4016c = nVar;
    }

    @Override // fa.j
    public final Iterator iterator() {
        return new b(this);
    }
}
