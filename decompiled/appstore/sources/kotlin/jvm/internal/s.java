package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.jvm.KotlinReflectionNotSupportedError;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f21184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21185b;

    public s(Class r10, String r11) {
        q.g(r10, "jClass");
        q.g(r11, "moduleName");
        this.f21184a = r10;
        this.f21185b = r11;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof s) == true) goto L5;
    L7:
        return false;
    L5:
        if (q.b(getJClass(), ((s) r10).getJClass()) == false) goto L7;
        return true;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class getJClass() {
        return this.f21184a;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection getMembers() {
        throw new KotlinReflectionNotSupportedError();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
