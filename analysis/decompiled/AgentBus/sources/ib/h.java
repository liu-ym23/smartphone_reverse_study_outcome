package ib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class h implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5038a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5039b;

    /* renamed from: c, reason: collision with root package name */
    public String f5040c;

    public h(ArrayList arrayList) {
        this.f5038a = arrayList;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        q7.k.e(obj, "proxy");
        q7.k.e(method, "method");
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (q7.k.a(name, "supports") && q7.k.a(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (q7.k.a(name, "unsupported") && q7.k.a(Void.TYPE, returnType)) {
            this.f5039b = true;
            return null;
        }
        boolean zA = q7.k.a(name, "protocols");
        ArrayList arrayList = this.f5038a;
        if (zA && objArr.length == 0) {
            return arrayList;
        }
        if ((q7.k.a(name, "selectProtocol") || q7.k.a(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                List list = (List) obj2;
                int size = list.size();
                if (size >= 0) {
                    int i2 = 0;
                    while (true) {
                        Object obj3 = list.get(i2);
                        q7.k.c(obj3, "null cannot be cast to non-null type kotlin.String");
                        String str = (String) obj3;
                        if (!arrayList.contains(str)) {
                            if (i2 == size) {
                                break;
                            }
                            i2++;
                        } else {
                            this.f5040c = str;
                            return str;
                        }
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.f5040c = str2;
                return str2;
            }
        }
        if ((!q7.k.a(name, "protocolSelected") && !q7.k.a(name, "selected")) || objArr.length != 1) {
            return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
        }
        Object obj4 = objArr[0];
        q7.k.c(obj4, "null cannot be cast to non-null type kotlin.String");
        this.f5040c = (String) obj4;
        return null;
    }
}
