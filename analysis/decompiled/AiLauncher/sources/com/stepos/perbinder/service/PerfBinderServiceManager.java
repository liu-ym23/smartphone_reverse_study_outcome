package com.stepos.perbinder.service;

import La.H;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.deepbinder.annotation.extension.Action;
import com.stepos.deepbinder.annotation.extension.PackageLimit;
import com.stepos.deepbinder.annotation.type.ServiceName;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u00020\u001a2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010$R8\u0010*\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060(j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/stepos/perbinder/service/PerfBinderServiceManager;", "", "<init>", "()V", "", "routerName", "Ljava/lang/Class;", "clazz", "LY8/t;", "addRouter", "(Ljava/lang/String;Ljava/lang/Class;)V", "caller", "arg", "Landroid/os/Bundle;", "extras", "ipcActionCall", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "serviceName", "methodName", "params", "executeCall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "serviceClass", "Ljava/lang/reflect/Method;", "getMethodByAnnotation", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;", "", "checkCallerPermission", "(Ljava/lang/Class;Ljava/lang/String;)Z", "method", "checkMethodPermission", "(Ljava/lang/reflect/Method;Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "", "ERROR_SERVICE_REFUSE", "I", "ERROR_SERVICE_NO", "ERROR_ILLEGAL_ACCESS", "ERROR_UNKNOWN", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "routerMap", "Ljava/util/HashMap;", "perfbinder-service_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PerfBinderServiceManager {
    private static final int ERROR_ILLEGAL_ACCESS = -999;
    private static final int ERROR_SERVICE_NO = -3;
    private static final int ERROR_SERVICE_REFUSE = -2;
    private static final int ERROR_UNKNOWN = -1000;
    private static final String TAG = "SkyRouterExtension";
    public static final PerfBinderServiceManager INSTANCE = new PerfBinderServiceManager();
    private static final HashMap<String, Class<?>> routerMap = new HashMap<>();

    private PerfBinderServiceManager() {
    }

    public static final void addRouter(String routerName, Class<?> clazz) {
        p.i(routerName, "routerName");
        p.i(clazz, "clazz");
        routerMap.put(routerName, clazz);
    }

    private final boolean checkCallerPermission(Class<?> serviceClass, String caller) {
        ServiceName serviceName = (ServiceName) serviceClass.getAnnotation(ServiceName.class);
        if (serviceName != null && !serviceName.export()) {
            return false;
        }
        PackageLimit packageLimit = (PackageLimit) serviceClass.getAnnotation(PackageLimit.class);
        return packageLimit == null || H.b1(packageLimit.packageList(), new String[]{Const.STR_MART_COMMA}, false, 0, 6, null).contains(caller);
    }

    private final boolean checkMethodPermission(Method method, String caller) {
        PackageLimit packageLimit = (PackageLimit) method.getAnnotation(PackageLimit.class);
        return packageLimit == null || H.b1(packageLimit.packageList(), new String[]{Const.STR_MART_COMMA}, false, 0, 6, null).contains(caller);
    }

    private final Bundle executeCall(String caller, String serviceName, String methodName, Bundle params) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = routerMap.get(serviceName);
        if (cls == null) {
            try {
                cls = Class.forName(serviceName);
            } catch (ClassNotFoundException unused) {
                Bundle bundle = new Bundle();
                bundle.putInt("errorCode", -3);
                return bundle;
            }
        }
        try {
            p.f(cls);
            if (checkCallerPermission(cls, caller)) {
                Method methodByAnnotation = getMethodByAnnotation(caller, cls, methodName);
                if (methodByAnnotation == null) {
                    return null;
                }
                Object objInvoke = methodByAnnotation.invoke(null, params);
                if (objInvoke instanceof Bundle) {
                    return (Bundle) objInvoke;
                }
                return null;
            }
            Log.i(TAG, "executeCall checkCallerPermission failed for " + cls);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("errorCode", -2);
            return bundle2;
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("errorCode", -999);
            return bundle3;
        } catch (Exception e11) {
            e11.printStackTrace();
            new Bundle().putInt("errorCode", -1000);
            return null;
        }
    }

    private final Method getMethodByAnnotation(String caller, Class<?> serviceClass, String methodName) throws SecurityException {
        try {
            return serviceClass.getMethod(methodName, Bundle.class);
        } catch (NoSuchMethodException unused) {
            Method[] methods = serviceClass.getMethods();
            p.h(methods, "getMethods(...)");
            int length = methods.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    return null;
                }
                Method method = methods[i10];
                if (method.isAnnotationPresent(Action.class)) {
                    Action action = (Action) method.getAnnotation(Action.class);
                    if (p.d(action != null ? action.name() : null, methodName)) {
                        PerfBinderServiceManager perfBinderServiceManager = INSTANCE;
                        p.f(method);
                        if (perfBinderServiceManager.checkMethodPermission(method, caller)) {
                            return method;
                        }
                    } else {
                        continue;
                    }
                }
                i10++;
            }
        }
    }

    public static final Bundle ipcActionCall(String caller, String arg, Bundle extras) {
        p.i(caller, "caller");
        p.i(extras, "extras");
        String string = extras.getString("serviceName");
        String string2 = extras.getString("methodName");
        return (string == null || string2 == null) ? new Bundle() : INSTANCE.executeCall(caller, string, string2, extras.getBundle("params"));
    }
}
