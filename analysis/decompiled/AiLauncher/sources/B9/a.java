package B9;

import E9.W;
import S9.E;
import S9.F;
import Z8.C1173v;
import ga.b;
import ga.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.f;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1474a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Set<b> f1475b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f1476c;

    /* renamed from: B9.a$a, reason: collision with other inner class name */
    public static final class C0011a implements f.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f1477a;

        public C0011a(Ref$BooleanRef ref$BooleanRef) {
            this.f1477a = ref$BooleanRef;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.c
        public void a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.c
        public f.a b(b classId, W source) {
            p.i(classId, "classId");
            p.i(source, "source");
            if (!p.d(classId, E.f5678a.a())) {
                return null;
            }
            this.f1477a.f34815a = true;
            return null;
        }
    }

    static {
        List listP = C1173v.p(F.f5683a, F.f5694l, F.f5695m, F.f5686d, F.f5688f, F.f5691i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b.a aVar = b.f32721d;
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(aVar.c((c) it.next()));
        }
        f1475b = linkedHashSet;
        b.a aVar2 = b.f32721d;
        c REPEATABLE_ANNOTATION = F.f5692j;
        p.h(REPEATABLE_ANNOTATION, "REPEATABLE_ANNOTATION");
        f1476c = aVar2.c(REPEATABLE_ANNOTATION);
    }

    public final b a() {
        return f1476c;
    }

    public final Set<b> b() {
        return f1475b;
    }

    public final boolean c(f klass) {
        p.i(klass, "klass");
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        klass.c(new C0011a(ref$BooleanRef), null);
        return ref$BooleanRef.f34815a;
    }
}
