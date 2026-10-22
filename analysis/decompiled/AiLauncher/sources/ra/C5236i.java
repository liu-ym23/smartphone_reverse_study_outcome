package ra;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import p9.InterfaceC5063a;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;

/* renamed from: ra.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5236i extends AbstractC5228a {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5865h<InterfaceC5238k> f38893b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C5236i(InterfaceC5063a<? extends InterfaceC5238k> getScope) {
        this(null, getScope, 1, 0 == true ? 1 : 0);
        kotlin.jvm.internal.p.i(getScope, "getScope");
    }

    public static final InterfaceC5238k j(InterfaceC5063a interfaceC5063a) {
        InterfaceC5238k interfaceC5238k = (InterfaceC5238k) interfaceC5063a.invoke();
        return interfaceC5238k instanceof AbstractC5228a ? ((AbstractC5228a) interfaceC5238k).g() : interfaceC5238k;
    }

    @Override // ra.AbstractC5228a
    public InterfaceC5238k h() {
        return this.f38893b.invoke();
    }

    public C5236i(InterfaceC5869l storageManager, InterfaceC5063a<? extends InterfaceC5238k> getScope) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(getScope, "getScope");
        this.f38893b = storageManager.i(new C5235h(getScope));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C5236i(InterfaceC5869l NO_LOCKS, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        if ((i10 & 1) != 0) {
            NO_LOCKS = LockBasedStorageManager.f36050e;
            kotlin.jvm.internal.p.h(NO_LOCKS, "NO_LOCKS");
        }
        this(NO_LOCKS, interfaceC5063a);
    }
}
