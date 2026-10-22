package a8;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements h {

    /* renamed from: a, reason: collision with root package name */
    public final Class f425a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f426b;

    /* renamed from: c, reason: collision with root package name */
    public final int f427c;

    /* renamed from: d, reason: collision with root package name */
    public final List f428d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f429e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f430f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f431g;

    public a(Class cls, ArrayList arrayList, int i2, int i10, List list) {
        q7.k.e(cls, "jClass");
        m.x.t(i2, "callMode");
        m.x.t(i10, "origin");
        q7.k.e(list, "methods");
        this.f425a = cls;
        this.f426b = arrayList;
        this.f427c = i2;
        this.f428d = list;
        ArrayList arrayList2 = new ArrayList(d7.t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Method) it.next()).getGenericReturnType());
        }
        this.f429e = arrayList2;
        List list2 = this.f428d;
        ArrayList arrayList3 = new ArrayList(d7.t.A0(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            q7.k.d(returnType, "it");
            List list3 = l8.d.f5857a;
            Class<?> cls2 = (Class) l8.d.f5859c.get(returnType);
            if (cls2 != null) {
                returnType = cls2;
            }
            arrayList3.add(returnType);
        }
        this.f430f = arrayList3;
        List list4 = this.f428d;
        ArrayList arrayList4 = new ArrayList(d7.t.A0(list4, 10));
        Iterator it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((Method) it3.next()).getDefaultValue());
        }
        this.f431g = arrayList4;
        if (this.f427c == 2 && i10 == 1 && !d7.r.Z0(this.f426b, "value").isEmpty()) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // a8.h
    public final Type f() {
        return this.f425a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    @Override // a8.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a8.a.h(java.lang.Object[]):java.lang.Object");
    }

    @Override // a8.h
    public final List i() {
        return this.f429e;
    }

    @Override // a8.h
    public final /* bridge */ /* synthetic */ Member j() {
        return null;
    }

    public /* synthetic */ a(Class cls, ArrayList arrayList, int i2) {
        ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(cls.getDeclaredMethod((String) it.next(), null));
        }
        this(cls, arrayList, i2, 2, arrayList2);
    }
}
