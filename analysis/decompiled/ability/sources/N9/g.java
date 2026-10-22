package N9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class g implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1020a;
    public boolean b;
    public String c;

    public g(ArrayList arrayList) {
        this.f1020a = arrayList;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object proxy, Method method, Object[] objArr) {
        kotlin.jvm.internal.k.f(proxy, "proxy");
        kotlin.jvm.internal.k.f(method, "method");
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (kotlin.jvm.internal.k.b(name, "supports") && kotlin.jvm.internal.k.b(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (kotlin.jvm.internal.k.b(name, "unsupported") && kotlin.jvm.internal.k.b(Void.TYPE, returnType)) {
            this.b = true;
            return null;
        }
        boolean zB = kotlin.jvm.internal.k.b(name, "protocols");
        ArrayList arrayList = this.f1020a;
        if (zB && objArr.length == 0) {
            return arrayList;
        }
        if ((kotlin.jvm.internal.k.b(name, "selectProtocol") || kotlin.jvm.internal.k.b(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof List) {
                kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List list = (List) obj;
                int size = list.size();
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        Object obj2 = list.get(i);
                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.String");
                        String str = (String) obj2;
                        if (!arrayList.contains(str)) {
                            if (i == size) {
                                break;
                            }
                            i++;
                        } else {
                            this.c = str;
                            return str;
                        }
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.c = str2;
                return str2;
            }
        }
        if ((!kotlin.jvm.internal.k.b(name, "protocolSelected") && !kotlin.jvm.internal.k.b(name, "selected")) || objArr.length != 1) {
            return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
        }
        Object obj3 = objArr[0];
        kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type kotlin.String");
        this.c = (String) obj3;
        return null;
    }
}
