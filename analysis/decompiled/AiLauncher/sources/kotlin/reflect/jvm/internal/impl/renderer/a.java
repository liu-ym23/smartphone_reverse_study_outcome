package kotlin.reflect.jvm.internal.impl.renderer;

import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.b0;
import Z8.B;
import ga.e;
import ja.y;
import java.util.ArrayList;
import ka.C4828h;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public interface a {

    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.a$a, reason: collision with other inner class name */
    public static final class C0453a implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0453a f35907a = new C0453a();

        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        public String a(InterfaceC0799d classifier, kotlin.reflect.jvm.internal.impl.renderer.b renderer) {
            p.i(classifier, "classifier");
            p.i(renderer, "renderer");
            if (classifier instanceof b0) {
                e name = ((b0) classifier).getName();
                p.h(name, "getName(...)");
                return renderer.R(name, false);
            }
            ga.d dVarM = C4828h.m(classifier);
            p.h(dVarM, "getFqName(...)");
            return renderer.Q(dVarM);
        }
    }

    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f35908a = new b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [E9.d, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v1, types: [E9.A, E9.h] */
        /* JADX WARN: Type inference failed for: r1v2, types: [E9.h] */
        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        public String a(InterfaceC0799d classifier, kotlin.reflect.jvm.internal.impl.renderer.b renderer) {
            p.i(classifier, "classifier");
            p.i(renderer, "renderer");
            if (classifier instanceof b0) {
                e name = ((b0) classifier).getName();
                p.h(name, "getName(...)");
                return renderer.R(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(classifier.getName());
                classifier = classifier.b();
            } while (classifier instanceof InterfaceC0797b);
            return y.g(B.V(arrayList));
        }
    }

    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f35909a = new c();

        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        public String a(InterfaceC0799d classifier, kotlin.reflect.jvm.internal.impl.renderer.b renderer) {
            p.i(classifier, "classifier");
            p.i(renderer, "renderer");
            return b(classifier);
        }

        public final String b(InterfaceC0799d interfaceC0799d) {
            e name = interfaceC0799d.getName();
            p.h(name, "getName(...)");
            String strC = y.c(name);
            if (interfaceC0799d instanceof b0) {
                return strC;
            }
            InterfaceC0803h interfaceC0803hB = interfaceC0799d.b();
            p.h(interfaceC0803hB, "getContainingDeclaration(...)");
            String strC2 = c(interfaceC0803hB);
            if (strC2 == null || p.d(strC2, "")) {
                return strC;
            }
            return strC2 + '.' + strC;
        }

        public final String c(InterfaceC0803h interfaceC0803h) {
            if (interfaceC0803h instanceof InterfaceC0797b) {
                return b((InterfaceC0799d) interfaceC0803h);
            }
            if (interfaceC0803h instanceof E) {
                return y.b(((E) interfaceC0803h).f().i());
            }
            return null;
        }
    }

    String a(InterfaceC0799d interfaceC0799d, kotlin.reflect.jvm.internal.impl.renderer.b bVar);
}
