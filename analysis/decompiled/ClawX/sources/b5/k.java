package b5;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements e, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public p5.a f899a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f900b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f901c;

    public k(p5.a initializer) {
        kotlin.jvm.internal.p.e(initializer, "initializer");
        this.f899a = initializer;
        this.f900b = w.f917a;
        this.f901c = this;
    }

    @Override // b5.e
    public final boolean a() {
        return this.f900b != w.f917a;
    }

    @Override // b5.e
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f900b;
        w wVar = w.f917a;
        if (obj != wVar) {
            return obj;
        }
        synchronized (this.f901c) {
            objInvoke = this.f900b;
            if (objInvoke == wVar) {
                p5.a aVar = this.f899a;
                kotlin.jvm.internal.p.b(aVar);
                objInvoke = aVar.invoke();
                this.f900b = objInvoke;
                this.f899a = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
