package j8;

import G8.f;
import V8.s;
import h8.InterfaceC1522e;
import java.util.Collection;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

/* renamed from: j8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1602a implements InterfaceC1603b, InterfaceC1605d {
    public static final C1602a b = new C1602a(0);
    public static final C1602a c = new C1602a(1);
    public static final C1602a d = new C1602a(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4776a;

    public /* synthetic */ C1602a(int i) {
        this.f4776a = i;
    }

    @Override // j8.InterfaceC1603b
    public Collection a(f name, InterfaceC1522e classDescriptor) {
        k.f(name, "name");
        k.f(classDescriptor, "classDescriptor");
        return EmptyList.f4893a;
    }

    @Override // j8.InterfaceC1603b
    public Collection b(InterfaceC1522e classDescriptor) {
        k.f(classDescriptor, "classDescriptor");
        return EmptyList.f4893a;
    }

    @Override // j8.InterfaceC1603b
    public Collection c(InterfaceC1522e interfaceC1522e) {
        return EmptyList.f4893a;
    }

    @Override // j8.InterfaceC1603b
    public Collection d(InterfaceC1522e interfaceC1522e) {
        return EmptyList.f4893a;
    }

    @Override // j8.InterfaceC1605d
    public boolean e(InterfaceC1522e classDescriptor, s sVar) {
        switch (this.f4776a) {
            case 1:
                k.f(classDescriptor, "classDescriptor");
                return true;
            default:
                k.f(classDescriptor, "classDescriptor");
                return !sVar.getAnnotations().k(AbstractC1606e.f4777a);
        }
    }
}
