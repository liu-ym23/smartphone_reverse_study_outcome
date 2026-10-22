package c8;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin;
import n8.AbstractC1744c;

/* renamed from: c8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0886a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2097a;
    public final ArrayList b;
    public final AnnotationConstructorCaller$CallMode c;
    public final List d;
    public final ArrayList e;
    public final ArrayList f;
    public final ArrayList g;

    public C0886a(Class jClass, ArrayList arrayList, AnnotationConstructorCaller$CallMode annotationConstructorCaller$CallMode, AnnotationConstructorCaller$Origin annotationConstructorCaller$Origin, List methods) {
        kotlin.jvm.internal.k.f(jClass, "jClass");
        kotlin.jvm.internal.k.f(methods, "methods");
        this.f2097a = jClass;
        this.b = arrayList;
        this.c = annotationConstructorCaller$CallMode;
        this.d = methods;
        List list = methods;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Method) it.next()).getGenericReturnType());
        }
        this.e = arrayList2;
        List list2 = this.d;
        ArrayList arrayList3 = new ArrayList(D7.w.c0(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            kotlin.jvm.internal.k.c(returnType);
            List list3 = AbstractC1744c.f5355a;
            Class<?> cls = (Class) AbstractC1744c.c.get(returnType);
            if (cls != null) {
                returnType = cls;
            }
            arrayList3.add(returnType);
        }
        this.f = arrayList3;
        List list4 = this.d;
        ArrayList arrayList4 = new ArrayList(D7.w.c0(list4, 10));
        Iterator it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((Method) it3.next()).getDefaultValue());
        }
        this.g = arrayList4;
        if (this.c == AnnotationConstructorCaller$CallMode.b && annotationConstructorCaller$Origin == AnnotationConstructorCaller$Origin.f4941a && !D7.v.N0(this.b, "value").isEmpty()) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // c8.e
    public final List a() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    @Override // c8.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object call(java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c8.C0886a.call(java.lang.Object[]):java.lang.Object");
    }

    @Override // c8.e
    public final /* bridge */ /* synthetic */ Member getMember() {
        return null;
    }

    @Override // c8.e
    public final Type getReturnType() {
        return this.f2097a;
    }

    public /* synthetic */ C0886a(Class cls, ArrayList arrayList, AnnotationConstructorCaller$CallMode annotationConstructorCaller$CallMode) {
        AnnotationConstructorCaller$Origin annotationConstructorCaller$Origin = AnnotationConstructorCaller$Origin.b;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(cls.getDeclaredMethod((String) it.next(), null));
        }
        this(cls, arrayList, annotationConstructorCaller$CallMode, annotationConstructorCaller$Origin, arrayList2);
    }
}
