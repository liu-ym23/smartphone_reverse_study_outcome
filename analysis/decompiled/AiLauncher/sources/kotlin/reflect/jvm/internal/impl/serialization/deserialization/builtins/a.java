package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import C9.c;
import E9.InterfaceC0819y;
import da.C3963a;
import da.C3965c;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ua.AbstractC5634t;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class a extends AbstractC5634t implements c {

    /* renamed from: o, reason: collision with root package name */
    public static final C0456a f36015o = new C0456a(null);

    /* renamed from: n, reason: collision with root package name */
    public final boolean f36016n;

    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a$a, reason: collision with other inner class name */
    public static final class C0456a {
        public /* synthetic */ C0456a(i iVar) {
            this();
        }

        public final a a(ga.c fqName, InterfaceC5869l storageManager, InterfaceC0819y module, InputStream inputStream, boolean z10) throws IOException {
            p.i(fqName, "fqName");
            p.i(storageManager, "storageManager");
            p.i(module, "module");
            p.i(inputStream, "inputStream");
            Pair<ProtoBuf$PackageFragment, C3963a> pairA = C3965c.a(inputStream);
            ProtoBuf$PackageFragment protoBuf$PackageFragmentA = pairA.a();
            C3963a c3963aB = pairA.b();
            if (protoBuf$PackageFragmentA != null) {
                return new a(fqName, storageManager, module, protoBuf$PackageFragmentA, c3963aB, z10, null);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + C3963a.f32147h + ", actual " + c3963aB + ". Please update Kotlin");
        }

        public C0456a() {
        }
    }

    public /* synthetic */ a(ga.c cVar, InterfaceC5869l interfaceC5869l, InterfaceC0819y interfaceC0819y, ProtoBuf$PackageFragment protoBuf$PackageFragment, C3963a c3963a, boolean z10, i iVar) {
        this(cVar, interfaceC5869l, interfaceC0819y, protoBuf$PackageFragment, c3963a, z10);
    }

    @Override // H9.H, H9.AbstractC0834m
    public String toString() {
        return "builtins package fragment for " + f() + " from " + DescriptorUtilsKt.s(this);
    }

    public a(ga.c cVar, InterfaceC5869l interfaceC5869l, InterfaceC0819y interfaceC0819y, ProtoBuf$PackageFragment protoBuf$PackageFragment, C3963a c3963a, boolean z10) {
        super(cVar, interfaceC5869l, interfaceC0819y, protoBuf$PackageFragment, c3963a, null);
        this.f36016n = z10;
    }
}
