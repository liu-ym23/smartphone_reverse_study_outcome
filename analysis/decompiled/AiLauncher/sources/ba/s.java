package ba;

import E9.X;
import ea.C4019c;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import ua.C5638x;
import wa.C5776S;
import wa.InterfaceC5793q;

/* loaded from: classes5.dex */
public final class s implements InterfaceC5793q {

    /* renamed from: b, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.load.kotlin.f f15362b;

    /* renamed from: c, reason: collision with root package name */
    public final C5638x<C4019c> f15363c;

    /* renamed from: d, reason: collision with root package name */
    public final C5776S f15364d;

    /* renamed from: e, reason: collision with root package name */
    public final DeserializedContainerAbiStability f15365e;

    public s(kotlin.reflect.jvm.internal.impl.load.kotlin.f binaryClass, C5638x<C4019c> c5638x, C5776S preReleaseInfo, DeserializedContainerAbiStability abiStability) {
        kotlin.jvm.internal.p.i(binaryClass, "binaryClass");
        kotlin.jvm.internal.p.i(preReleaseInfo, "preReleaseInfo");
        kotlin.jvm.internal.p.i(abiStability, "abiStability");
        this.f15362b = binaryClass;
        this.f15363c = c5638x;
        this.f15364d = preReleaseInfo;
        this.f15365e = abiStability;
    }

    @Override // wa.InterfaceC5793q
    public String a() {
        return "Class '" + this.f15362b.j().a().a() + '\'';
    }

    @Override // E9.W
    public X b() {
        X NO_SOURCE_FILE = X.f2445a;
        kotlin.jvm.internal.p.h(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.f d() {
        return this.f15362b;
    }

    public String toString() {
        return s.class.getSimpleName() + ": " + this.f15362b;
    }
}
