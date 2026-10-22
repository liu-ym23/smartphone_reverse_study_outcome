package org.chromium.support_lib_boundary.a;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Collection;

/* JADX INFO: compiled from: BoundaryInterfaceReflectionUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f40543a = true;

    static {
    }

    public a() {
    }

    public static <T> T a(Class<T> r3, InvocationHandler r4) {
        InvocationHandler r5 = (InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r4, InvocationHandler.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
        return null;
    L7:
        return r3.cast(Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{r3}, r5));
    }

    private static boolean a() {
        if ("eng".equals(Build.TYPE) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(Build.TYPE) == true) goto L8;
        return false;
    }

    public static boolean a(Collection<String> r2, String r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        if (f40543a == true) goto L10;
        if (r3.endsWith(":dev") == false) goto L10;
        throw new AssertionError();
    L10:
        if (r4.contains(r3) == false) goto L12;
    L17:
        return true;
    L12:
        if (a() == true) goto L14;
    L16:
        return false;
    L14:
        if (r4.contains(r3 + ":dev") == false) goto L16;
        goto L16
    }
}
