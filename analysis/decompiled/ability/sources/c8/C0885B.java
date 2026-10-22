package c8;

import b8.v0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* renamed from: c8.B, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0885B implements e {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2096a;
    public final e b;
    public final Member c;
    public final A5.c d;
    public final Y7.f[] e;
    public final boolean f;

    /* JADX WARN: Removed duplicated region for block: B:145:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b A[LOOP:1: B:25:0x0075->B:27:0x007b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0885B(c8.e r11, h8.InterfaceC1520c r12, boolean r13) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 907
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c8.C0885B.<init>(c8.e, h8.c, boolean):void");
    }

    @Override // c8.e
    public final List a() {
        return this.b.a();
    }

    public final Y7.f b(int i) {
        Y7.f[] fVarArr = this.e;
        if (i >= 0 && i < fVarArr.length) {
            return fVarArr[i];
        }
        if (fVarArr.length == 0) {
            return new Y7.f(i, i, 1);
        }
        int length = ((Y7.f) D7.q.y0(fVarArr)).b + 1 + (i - fVarArr.length);
        return new Y7.f(length, length, 1);
    }

    @Override // c8.e
    public final Object call(Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        Object objE;
        Object objE2;
        kotlin.jvm.internal.k.f(args, "args");
        A5.c cVar = this.d;
        Y7.f fVar = (Y7.f) cVar.b;
        List[] listArr = (List[]) cVar.c;
        Method method = (Method) cVar.d;
        boolean zIsEmpty = fVar.isEmpty();
        int i = fVar.b;
        int i6 = fVar.f1569a;
        if (!zIsEmpty) {
            if (this.f) {
                ListBuilder listBuilder = new ListBuilder(args.length);
                for (int i10 = 0; i10 < i6; i10++) {
                    listBuilder.add(args[i10]);
                }
                if (i6 <= i) {
                    while (true) {
                        List<Method> list = listArr[i6];
                        Object obj = args[i6];
                        if (list != null) {
                            for (Method method2 : list) {
                                if (obj != null) {
                                    objE2 = method2.invoke(obj, null);
                                } else {
                                    Class<?> returnType = method2.getReturnType();
                                    kotlin.jvm.internal.k.e(returnType, "getReturnType(...)");
                                    objE2 = v0.e(returnType);
                                }
                                listBuilder.add(objE2);
                            }
                        } else {
                            listBuilder.add(obj);
                        }
                        if (i6 == i) {
                            break;
                        }
                        i6++;
                    }
                }
                int i11 = i + 1;
                int length = args.length - 1;
                if (i11 <= length) {
                    while (true) {
                        listBuilder.add(args[i11]);
                        if (i11 == length) {
                            break;
                        }
                        i11++;
                    }
                }
                args = H4.o.q(listBuilder).toArray(new Object[0]);
            } else {
                int length2 = args.length;
                Object[] objArr = new Object[length2];
                for (int i12 = 0; i12 < length2; i12++) {
                    if (i12 > i || i6 > i12) {
                        objE = args[i12];
                    } else {
                        List list2 = listArr[i12];
                        Method method3 = list2 != null ? (Method) D7.v.U0(list2) : null;
                        objE = args[i12];
                        if (method3 != null) {
                            if (objE != null) {
                                objE = method3.invoke(objE, null);
                            } else {
                                Class<?> returnType2 = method3.getReturnType();
                                kotlin.jvm.internal.k.e(returnType2, "getReturnType(...)");
                                objE = v0.e(returnType2);
                            }
                        }
                    }
                    objArr[i12] = objE;
                }
                args = objArr;
            }
        }
        Object objCall = this.b.call(args);
        return (objCall == CoroutineSingletons.f4909a || method == null || (objInvoke = method.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // c8.e
    public final Member getMember() {
        return this.c;
    }

    @Override // c8.e
    public final Type getReturnType() {
        return this.b.getReturnType();
    }
}
