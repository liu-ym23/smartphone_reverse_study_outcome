package c8;

import X8.AbstractC0272c;
import androidx.exifinterface.media.ExifInterface;
import b8.AbstractC0830C;
import b8.v0;
import h8.InterfaceC1499G;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1536s;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import n8.AbstractC1744c;

/* renamed from: c8.A, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0884A implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Method f2095a;
    public final Method b;
    public final ArrayList c;
    public final ArrayList d;
    public final ArrayList e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.ArrayList] */
    public C0884A(InterfaceC1536s interfaceC1536s, AbstractC0830C container, String constructorDesc, List list) {
        ?? M5;
        Method methodG;
        kotlin.jvm.internal.k.f(container, "container");
        kotlin.jvm.internal.k.f(constructorDesc, "constructorDesc");
        Method methodF = container.f("constructor-impl", constructorDesc);
        kotlin.jvm.internal.k.c(methodF);
        this.f2095a = methodF;
        Method methodF2 = container.f("box-impl", j9.m.z0(constructorDesc, ExifInterface.GPS_MEASUREMENT_INTERRUPTED) + AbstractC1744c.b(container.b()));
        kotlin.jvm.internal.k.c(methodF2);
        this.b = methodF2;
        List list2 = list;
        ArrayList arrayList = new ArrayList(D7.w.c0(list2, 10));
        Iterator it = list2.iterator();
        while (true) {
            List listM = null;
            if (!it.hasNext()) {
                break;
            }
            X8.w type = ((InterfaceC1499G) it.next()).getType();
            kotlin.jvm.internal.k.e(type, "getType(...)");
            X8.A aB = AbstractC0272c.b(type);
            ArrayList arrayListI = H4.o.I(aB);
            if (arrayListI == null) {
                Class clsY = H4.o.Y(aB);
                if (clsY != null && (methodG = H4.o.G(clsY, interfaceC1536s)) != null) {
                    listM = H4.o.M(methodG);
                }
            } else {
                listM = arrayListI;
            }
            arrayList.add(listM);
        }
        this.c = arrayList;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i6 = i + 1;
            if (i < 0) {
                H4.o.X();
                throw null;
            }
            InterfaceC1524g interfaceC1524gD = ((InterfaceC1499G) obj).getType().Q().d();
            kotlin.jvm.internal.k.d(interfaceC1524gD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            InterfaceC1522e interfaceC1522e = (InterfaceC1522e) interfaceC1524gD;
            List list3 = (List) this.c.get(i);
            if (list3 != null) {
                List list4 = list3;
                M5 = new ArrayList(D7.w.c0(list4, 10));
                Iterator it2 = list4.iterator();
                while (it2.hasNext()) {
                    M5.add(((Method) it2.next()).getReturnType());
                }
            } else {
                Class clsK = v0.k(interfaceC1522e);
                kotlin.jvm.internal.k.c(clsK);
                M5 = H4.o.M(clsK);
            }
            arrayList2.add(M5);
            i = i6;
        }
        this.d = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            D7.A.e0((Iterable) it3.next(), arrayList3);
        }
        this.e = arrayList3;
    }

    @Override // c8.e
    public final List a() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ArrayList] */
    @Override // c8.e
    public final Object call(Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ?? M5;
        kotlin.jvm.internal.k.f(args, "args");
        ArrayList other = this.c;
        kotlin.jvm.internal.k.f(other, "other");
        int length = args.length;
        ArrayList arrayList = new ArrayList(Math.min(D7.w.c0(other, 10), length));
        Iterator it = other.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (i >= length) {
                break;
            }
            arrayList.add(new Pair(args[i], next));
            i++;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            Object obj = pair.f4886a;
            List list = (List) pair.b;
            if (list != null) {
                List list2 = list;
                M5 = new ArrayList(D7.w.c0(list2, 10));
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    M5.add(((Method) it3.next()).invoke(obj, null));
                }
            } else {
                M5 = H4.o.M(obj);
            }
            D7.A.e0((Iterable) M5, arrayList2);
        }
        Object[] array = arrayList2.toArray(new Object[0]);
        this.f2095a.invoke(null, Arrays.copyOf(array, array.length));
        return this.b.invoke(null, Arrays.copyOf(array, array.length));
    }

    @Override // c8.e
    public final /* bridge */ /* synthetic */ Member getMember() {
        return null;
    }

    @Override // c8.e
    public final Type getReturnType() {
        Class<?> returnType = this.b.getReturnType();
        kotlin.jvm.internal.k.e(returnType, "getReturnType(...)");
        return returnType;
    }
}
