package id;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f5954a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5955b;

    /* renamed from: c, reason: collision with root package name */
    public String f5956c;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        ArrayList arrayList = this.f5954a;
        obj.getClass();
        method.getClass();
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (yb.k.a(name, "supports") && yb.k.a(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (yb.k.a(name, "unsupported") && yb.k.a(Void.TYPE, returnType)) {
            this.f5955b = true;
            return null;
        }
        if (yb.k.a(name, "protocols") && objArr.length == 0) {
            return arrayList;
        }
        if ((yb.k.a(name, "selectProtocol") || yb.k.a(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                List list = (List) obj2;
                int size = list.size();
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        Object obj3 = list.get(i);
                        obj3.getClass();
                        String str = (String) obj3;
                        if (!arrayList.contains(str)) {
                            if (i == size) {
                                break;
                            }
                            i++;
                        } else {
                            this.f5956c = str;
                            return str;
                        }
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.f5956c = str2;
                return str2;
            }
        }
        if ((!yb.k.a(name, "protocolSelected") && !yb.k.a(name, "selected")) || objArr.length != 1) {
            return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        this.f5956c = (String) obj4;
        return null;
    }
}
