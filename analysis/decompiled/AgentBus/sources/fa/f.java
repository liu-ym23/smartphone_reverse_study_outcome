package fa;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class f implements j {

    /* renamed from: a, reason: collision with root package name */
    public final j f3623a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3624b;

    /* renamed from: c, reason: collision with root package name */
    public final p7.k f3625c;

    public f(j jVar, boolean z4, p7.k kVar) {
        this.f3623a = jVar;
        this.f3624b = z4;
        this.f3625c = kVar;
    }

    @Override // fa.j
    public final Iterator iterator() {
        return new e(this);
    }
}
