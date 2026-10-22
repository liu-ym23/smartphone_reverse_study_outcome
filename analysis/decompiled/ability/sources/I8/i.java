package I8;

import Z7.t;

/* loaded from: classes4.dex */
public final class i implements V7.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f814a;
    public final /* synthetic */ j b;

    public i(Object obj, j jVar) {
        this.b = jVar;
        this.f814a = obj;
    }

    public final void a(Object obj, t property, Object obj2) {
        kotlin.jvm.internal.k.f(property, "property");
        if (this.b.f839a) {
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
        this.f814a = obj2;
    }

    @Override // V7.b
    public final Object getValue(Object obj, t property) {
        kotlin.jvm.internal.k.f(property, "property");
        return this.f814a;
    }

    public final String toString() {
        return androidx.compose.foundation.b.t(new StringBuilder("ObservableProperty(value="), this.f814a, ')');
    }
}
