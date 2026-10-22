package b5;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b0 implements e, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public p5.a f884a;

    /* renamed from: b, reason: collision with root package name */
    public Object f885b;

    @Override // b5.e
    public final boolean a() {
        return this.f885b != w.f917a;
    }

    @Override // b5.e
    public final Object getValue() {
        if (this.f885b == w.f917a) {
            p5.a aVar = this.f884a;
            kotlin.jvm.internal.p.b(aVar);
            this.f885b = aVar.invoke();
            this.f884a = null;
        }
        return this.f885b;
    }

    public final String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
