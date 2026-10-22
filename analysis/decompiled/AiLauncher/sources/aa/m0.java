package aa;

import Z8.C1174w;
import Z8.IndexedValue;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import p9.InterfaceC5074l;
import v9.C5685n;

/* loaded from: classes5.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, f0> f8157a = new LinkedHashMap();

    public final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f8158a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0 f8159b;

        /* renamed from: aa.m0$a$a, reason: collision with other inner class name */
        public final class C0125a {

            /* renamed from: a, reason: collision with root package name */
            public final String f8160a;

            /* renamed from: b, reason: collision with root package name */
            public final String f8161b;

            /* renamed from: c, reason: collision with root package name */
            public final List<Pair<String, p0>> f8162c;

            /* renamed from: d, reason: collision with root package name */
            public Pair<String, p0> f8163d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ a f8164e;

            public C0125a(a aVar, String functionName, String str) {
                kotlin.jvm.internal.p.i(functionName, "functionName");
                this.f8164e = aVar;
                this.f8160a = functionName;
                this.f8161b = str;
                this.f8162c = new ArrayList();
                this.f8163d = Y8.j.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            public final Pair<String, f0> a() {
                ba.x xVar = ba.x.f15368a;
                String strC = this.f8164e.c();
                String str = this.f8160a;
                List<Pair<String, p0>> list = this.f8162c;
                ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).e());
                }
                String strM = xVar.m(strC, xVar.k(str, arrayList, this.f8163d.e()));
                p0 p0VarF = this.f8163d.f();
                List<Pair<String, p0>> list2 = this.f8162c;
                ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((p0) ((Pair) it2.next()).f());
                }
                return Y8.j.a(strM, new f0(p0VarF, arrayList2, this.f8161b));
            }

            public final void b(String type, C1261i... qualifiers) {
                p0 p0Var;
                kotlin.jvm.internal.p.i(type, "type");
                kotlin.jvm.internal.p.i(qualifiers, "qualifiers");
                List<Pair<String, p0>> list = this.f8162c;
                if (qualifiers.length == 0) {
                    p0Var = null;
                } else {
                    Iterable<IndexedValue> iterableJ1 = Z8.r.j1(qualifiers);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(iterableJ1, 10)), 16));
                    for (IndexedValue indexedValue : iterableJ1) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.c()), (C1261i) indexedValue.d());
                    }
                    p0Var = new p0(linkedHashMap);
                }
                list.add(Y8.j.a(type, p0Var));
            }

            public final void c(String type, C1261i... qualifiers) {
                kotlin.jvm.internal.p.i(type, "type");
                kotlin.jvm.internal.p.i(qualifiers, "qualifiers");
                Iterable<IndexedValue> iterableJ1 = Z8.r.j1(qualifiers);
                LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(iterableJ1, 10)), 16));
                for (IndexedValue indexedValue : iterableJ1) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.c()), (C1261i) indexedValue.d());
                }
                this.f8163d = Y8.j.a(type, new p0(linkedHashMap));
            }

            public final void d(JvmPrimitiveType type) {
                kotlin.jvm.internal.p.i(type, "type");
                String desc = type.getDesc();
                kotlin.jvm.internal.p.h(desc, "getDesc(...)");
                this.f8163d = Y8.j.a(desc, null);
            }
        }

        public a(m0 m0Var, String className) {
            kotlin.jvm.internal.p.i(className, "className");
            this.f8159b = m0Var;
            this.f8158a = className;
        }

        public static /* synthetic */ void b(a aVar, String str, String str2, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            aVar.a(str, str2, interfaceC5074l);
        }

        public final void a(String name, String str, InterfaceC5074l<? super C0125a, Y8.t> block) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(block, "block");
            Map map = this.f8159b.f8157a;
            C0125a c0125a = new C0125a(this, name, str);
            block.invoke(c0125a);
            Pair<String, f0> pairA = c0125a.a();
            map.put(pairA.e(), pairA.f());
        }

        public final String c() {
            return this.f8158a;
        }
    }

    public final Map<String, f0> b() {
        return this.f8157a;
    }
}
