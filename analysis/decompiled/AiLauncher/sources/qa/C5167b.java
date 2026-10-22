package qa;

import E9.InterfaceC0797b;
import kotlin.jvm.internal.p;
import xa.InterfaceC5859b;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;

/* renamed from: qa.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5167b implements InterfaceC5166a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable<Object> f38618a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5859b<InterfaceC0797b, AbstractC5990d0> f38619b;

    public C5167b(InterfaceC5869l storageManager, Iterable<? extends Object> samWithReceiverResolvers) {
        p.i(storageManager, "storageManager");
        p.i(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.f38618a = samWithReceiverResolvers;
        this.f38619b = storageManager.g();
    }
}
