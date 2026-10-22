package sa;

import E9.InterfaceC0797b;
import kotlin.jvm.internal.p;
import ya.AbstractC5990d0;

/* renamed from: sa.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5458e implements InterfaceC5460g, InterfaceC5462i {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0797b f40178a;

    /* renamed from: b, reason: collision with root package name */
    public final C5458e f40179b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0797b f40180c;

    public C5458e(InterfaceC0797b classDescriptor, C5458e c5458e) {
        p.i(classDescriptor, "classDescriptor");
        this.f40178a = classDescriptor;
        this.f40179b = c5458e == null ? this : c5458e;
        this.f40180c = classDescriptor;
    }

    @Override // sa.InterfaceC5460g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 getType() {
        AbstractC5990d0 abstractC5990d0N = this.f40178a.n();
        p.h(abstractC5990d0N, "getDefaultType(...)");
        return abstractC5990d0N;
    }

    public boolean equals(Object obj) {
        InterfaceC0797b interfaceC0797b = this.f40178a;
        C5458e c5458e = obj instanceof C5458e ? (C5458e) obj : null;
        return p.d(interfaceC0797b, c5458e != null ? c5458e.f40178a : null);
    }

    public int hashCode() {
        return this.f40178a.hashCode();
    }

    @Override // sa.InterfaceC5462i
    public final InterfaceC0797b r() {
        return this.f40178a;
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
