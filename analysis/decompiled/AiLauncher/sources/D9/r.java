package D9;

import E9.D;
import E9.InterfaceC0819y;
import M9.c;
import Z8.C1173v;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.InputStream;
import qa.InterfaceC5166a;
import ua.AbstractC5617c;
import ua.AbstractC5631q;
import ua.C5619e;
import ua.C5627m;
import ua.C5630p;
import ua.C5639y;
import ua.InterfaceC5591A;
import ua.InterfaceC5626l;
import ua.InterfaceC5628n;
import ua.InterfaceC5636v;
import ua.InterfaceC5637w;
import va.C5686a;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class r extends AbstractC5617c {

    /* renamed from: f, reason: collision with root package name */
    public static final a f2312f = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(InterfaceC5869l storageManager, ba.p finder, InterfaceC0819y moduleDescriptor, D notFoundClasses, G9.a additionalClassPartsProvider, G9.c platformDependentDeclarationFilter, InterfaceC5628n deserializationConfiguration, kotlin.reflect.jvm.internal.impl.types.checker.e kotlinTypeChecker, InterfaceC5166a samConversionResolver) {
        super(storageManager, finder, moduleDescriptor);
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(finder, "finder");
        kotlin.jvm.internal.p.i(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.p.i(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.p.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.p.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.p.i(deserializationConfiguration, "deserializationConfiguration");
        kotlin.jvm.internal.p.i(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.p.i(samConversionResolver, "samConversionResolver");
        C5630p c5630p = new C5630p(this);
        C5686a c5686a = C5686a.f42871r;
        C5619e c5619e = new C5619e(moduleDescriptor, notFoundClasses, c5686a);
        InterfaceC5591A.a aVar = InterfaceC5591A.a.f42514a;
        InterfaceC5636v DO_NOTHING = InterfaceC5636v.f42653a;
        kotlin.jvm.internal.p.h(DO_NOTHING, "DO_NOTHING");
        l(new C5627m(storageManager, moduleDescriptor, deserializationConfiguration, c5630p, c5619e, this, aVar, DO_NOTHING, c.a.f4661a, InterfaceC5637w.a.f42654a, C1173v.p(new kotlin.reflect.jvm.internal.impl.builtins.functions.a(storageManager, moduleDescriptor), new kotlin.reflect.jvm.internal.impl.builtins.jvm.c(storageManager, moduleDescriptor, null, 4, null)), notFoundClasses, InterfaceC5626l.f42608a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, c5686a.e(), kotlinTypeChecker, samConversionResolver, null, C5639y.f42660a, SQLiteDatabase.OPEN_PRIVATECACHE, null));
    }

    @Override // ua.AbstractC5617c
    public AbstractC5631q e(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        InputStream inputStreamB = h().b(fqName);
        if (inputStreamB != null) {
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f36015o.a(fqName, j(), i(), inputStreamB, false);
        }
        return null;
    }
}
