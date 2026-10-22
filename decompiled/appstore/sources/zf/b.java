package zf;

import kotlin.jvm.internal.q;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements ReadWriteProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f26388a;

    public b(Object r10) {
        this.f26388a = r10;
    }

    public abstract void a(KProperty r10, Object r11, Object r12);

    public boolean b(KProperty r10, Object r11, Object r12) {
        q.g(r10, "property");
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public Object getValue(Object r10, KProperty r11) {
        q.g(r11, "property");
        return this.f26388a;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object r10, KProperty r11, Object r12) {
        q.g(r11, "property");
        Object r13 = this.f26388a;
        if (b(r11, r13, r12) == true) goto L5;
        return;
    L5:
        this.f26388a = r12;
        a(r11, r13, r12);
    }

    public String toString() {
        return "ObservableProperty(value=" + this.f26388a + ')';
    }
}
