package com.stepos.deepbinder.client;

import android.app.Application;
import android.content.ComponentName;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.handler.BaseInvocationHandler;
import com.stepos.deepbinder.core.log.IPCLog;
import f.a;
import h0.e;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jd.b;
import w9.g;
import x9.c;
import x9.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class DeepBinderClient {
    public static final int CONNECT_ALWAYS = -1;
    public static final int CONNECT_MAX_TIME = 43200000;
    public static final DeepBinderClient INSTANCE = new DeepBinderClient();
    private static final String IPC_REQUEST_DEEPBINDER = "deepbinder";
    private static final String TAG = "DeepBinder";

    private DeepBinderClient() {
    }

    @SafeVarargs
    private final <T> T createProxy(ComponentName componentName, Class<T> cls, String str, String str2, Pair<Class<?>, Object>... pairArr) throws NumberFormatException {
        ParameterWrapper[] parameterWrapperArr;
        String strA = c.a();
        String str3 = c.c(componentName).f13759a;
        if (strA.equals(str3)) {
            try {
                return (T) createService(cls, str, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException(e11);
            }
        }
        ServiceWrapper.Companion companion = ServiceWrapper.Companion;
        ServiceWrapper serviceWrapperObtain = companion.obtain();
        serviceWrapperObtain.setTimeStamp(g.f13619a.a());
        serviceWrapperObtain.setServiceInterfaceClass(cls);
        serviceWrapperObtain.setName(str);
        serviceWrapperObtain.setCallerPackageName(INSTANCE.getContext().getPackageName());
        serviceWrapperObtain.setCallerProcessName(strA);
        int i10 = 0;
        serviceWrapperObtain.setType((str2.length() == 0 ? 1 : 0) ^ 1);
        serviceWrapperObtain.withProxyStateBinder(companion.getBinder());
        Call callCreate = Call.CREATOR.create();
        callCreate.setServiceWrapper(serviceWrapperObtain);
        MethodWrapper methodWrapperObtain = MethodWrapper.Companion.obtain();
        methodWrapperObtain.setName(str2);
        methodWrapperObtain.setVoid(true);
        callCreate.setMethodWrapper(methodWrapperObtain);
        kotlin.jvm.internal.g.c(str3);
        Pair[] pairArr2 = (Pair[]) Arrays.copyOf(pairArr, pairArr.length);
        if (pairArr2 == null) {
            parameterWrapperArr = new ParameterWrapper[0];
        } else {
            ArrayList arrayList = new ArrayList(pairArr2.length);
            for (Pair pair : pairArr2) {
                Class cls2 = (Class) pair.first;
                if (cls2 == null) {
                    throw new IPCException(32, "The pair and parameter class can't be null!");
                }
                Object obj = pair.second;
                if (obj != null && !cls2.isAssignableFrom(obj.getClass())) {
                    throw new IPCException(37, e.c("The parameter object ", obj.getClass().getName(), " is not an instance of ", cls2.getName(), ". Please check the pair's values!"));
                }
                arrayList.add(ParameterWrapper.Companion.obtain().withParameterName(((Class) pair.first).getName()).withData(obj));
            }
            parameterWrapperArr = (ParameterWrapper[]) arrayList.toArray(new ParameterWrapper[0]);
        }
        callCreate.setParameterWrappers(parameterWrapperArr);
        callCreate.setRemoteComponentName(componentName);
        try {
            j9.a.f9742a.a(componentName).sendCall(callCreate);
        } catch (IPCException e12) {
            if (e12.getErrorCode() != 52) {
                throw e12;
            }
            IPCLog.INSTANCE.w(TAG, "Caller protocol version higher than server, degrading version", new Object[0]);
            try {
                String extraErrorData = e12.getExtraErrorData();
                if (extraErrorData != null) {
                    i10 = Integer.parseInt(extraErrorData);
                }
            } catch (NumberFormatException unused) {
                IPCLog.INSTANCE.w(TAG, "Failed to parse protocol version, using default", new Object[0]);
            }
            callCreate.setProtocolVersion(i10);
            j9.a.f9742a.a(componentName).sendCall(callCreate);
        }
        return (T) getProxy(callCreate);
    }

    @SafeVarargs
    private final <T> T createProxyByMethodName(ComponentName componentName, String str, Class<T> cls, String str2, Pair<Class<?>, Object>... pairArr) {
        b.Q(componentName);
        return (T) createProxy(componentName, cls, b.P(cls, str), str2, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    private final <T> T getProxy(Call call) {
        T t8 = (T) Proxy.newProxyInstance(call.getServiceWrapper().getServiceInterfaceClass().getClassLoader(), new Class[]{call.getServiceWrapper().getServiceInterfaceClass()}, new l9.a(call));
        if (t8 != null) {
            w9.c.f13608a.a();
            w9.c.a(t8);
        }
        return t8;
    }

    private final <T> void recycle(T t8) throws IllegalArgumentException {
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(t8);
        kotlin.jvm.internal.g.d(invocationHandler, "null cannot be cast to non-null type com.stepos.deepbinder.core.handler.BaseInvocationHandler");
        ((BaseInvocationHandler) invocationHandler).clean();
    }

    @a
    public final void addComponentAuthority(ComponentName componentName, String authority) {
        x9.a aVarPutIfAbsent;
        kotlin.jvm.internal.g.f(componentName, "componentName");
        kotlin.jvm.internal.g.f(authority, "authority");
        if (authority.length() == 0) {
            return;
        }
        ConcurrentHashMap<ComponentName, x9.a> concurrentHashMap = d.f13766b;
        x9.a aVar = concurrentHashMap.get(componentName);
        if (aVar == null && (aVarPutIfAbsent = concurrentHashMap.putIfAbsent(componentName, (aVar = new x9.a(null, null, null)))) != null) {
            aVar = aVarPutIfAbsent;
        }
        aVar.f13761c = Uri.parse(authority);
    }

    @a
    public final void connect(ComponentName componentName) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        if (TextUtils.isEmpty(componentName.getClassName()) || TextUtils.isEmpty(componentName.getPackageName())) {
            throw new IPCException(27, "The component name or its contained info is null, please check!");
        }
        j9.a.f9742a.a(componentName).connect();
    }

    @SafeVarargs
    @a
    public final <T> T create(String targetPkg, Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        kotlin.jvm.internal.g.f(targetPkg, "targetPkg");
        kotlin.jvm.internal.g.f(serviceInterface, "serviceInterface");
        kotlin.jvm.internal.g.f(params, "params");
        return (T) create(new ComponentName(targetPkg, "com.stepos.deepbinder.service.DeepBinderProvider"), "", serviceInterface, (Pair[]) Arrays.copyOf(params, params.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T createService(Class<T> serviceInterface, String str, Pair<Class<?>, Object>... params) throws ClassNotFoundException {
        kotlin.jvm.internal.g.f(serviceInterface, "serviceInterface");
        kotlin.jvm.internal.g.f(params, "params");
        if (str == null || str.length() == 0) {
            str = null;
        }
        if (str == null) {
            ServiceName serviceName = (ServiceName) serviceInterface.getAnnotation(ServiceName.class);
            String strValue = serviceName != null ? serviceName.value() : null;
            if (strValue == null) {
                throw new IllegalArgumentException("Service name not provided and no @ServiceName annotation found");
            }
            str = strValue;
        }
        try {
            Class<?> cls = Class.forName(str);
            ArrayList arrayList = new ArrayList(params.length);
            for (Pair<Class<?>, Object> pair : params) {
                arrayList.add((Class) pair.first);
            }
            Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
            ArrayList arrayList2 = new ArrayList(params.length);
            for (Pair<Class<?>, Object> pair2 : params) {
                arrayList2.add(pair2.second);
            }
            Object[] array = arrayList2.toArray(new Object[0]);
            return (T) cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)).newInstance(Arrays.copyOf(array, array.length));
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    @SafeVarargs
    @a
    public final <T> T createSingleton(ComponentName componentName, Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        kotlin.jvm.internal.g.f(serviceInterface, "serviceInterface");
        kotlin.jvm.internal.g.f(params, "params");
        return (T) createProxyByMethodName(componentName, "", serviceInterface, "getInstance", (Pair[]) Arrays.copyOf(params, params.length));
    }

    public final void disconnect(ComponentName componentName) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        if (TextUtils.isEmpty(componentName.getClassName()) || TextUtils.isEmpty(componentName.getPackageName())) {
            throw new IPCException(27, "The component name or its contained info is null, please check!");
        }
        j9.a.f9742a.c(componentName);
    }

    @a
    public final Application getContext() {
        return DeepBinderInternal.getContext();
    }

    @a
    public final boolean isConnect(ComponentName componentName) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        try {
            if (TextUtils.isEmpty(componentName.getClassName()) || TextUtils.isEmpty(componentName.getPackageName())) {
                throw new IPCException(27, "The component name or its contained info is null, please check!");
            }
            return c.b(componentName);
        } catch (IPCException unused) {
            return false;
        }
    }

    public final <T> void recycleCallback(T t8) {
        try {
            recycle(t8);
        } catch (ClassCastException unused) {
            if (t8 != null) {
                n9.b bVar = n9.b.f10675a;
                n9.b.b(t8);
            }
        } catch (IllegalArgumentException unused2) {
            if (t8 != null) {
                n9.b bVar2 = n9.b.f10675a;
                n9.b.b(t8);
            }
        }
    }

    @a
    public final <T> void recycleService(T t8) {
        try {
            recycle(t8);
        } catch (ClassCastException | IllegalArgumentException unused) {
        }
    }

    @a
    public final void registerProviderStateListener(ProviderStateListener listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        i9.a.f9578a.add(listener);
    }

    @a
    public final void removeComponentAuthority(ComponentName componentName) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        d.f13766b.remove(componentName);
    }

    public final void setAutoDisconnectTime(int i10) {
        j9.a aVar = j9.a.f9742a;
        j9.a.f9744c = i10;
    }

    @a
    public final void unRegisterProviderStateListener(ProviderStateListener listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        CopyOnWriteArrayList<ProviderStateListener> copyOnWriteArrayList = i9.a.f9578a;
        CopyOnWriteArrayList<ProviderStateListener> copyOnWriteArrayList2 = i9.a.f9578a;
        copyOnWriteArrayList2.remove(listener);
        if (copyOnWriteArrayList2.isEmpty()) {
            i9.a.f9579b.clear();
        }
    }

    @SafeVarargs
    @a
    public final <T> T createSingleton(ComponentName componentName, String serviceName, Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        kotlin.jvm.internal.g.f(serviceName, "serviceName");
        kotlin.jvm.internal.g.f(serviceInterface, "serviceInterface");
        kotlin.jvm.internal.g.f(params, "params");
        return (T) createProxyByMethodName(componentName, serviceName, serviceInterface, "getInstance", (Pair[]) Arrays.copyOf(params, params.length));
    }

    public final void setAutoDisconnectTime(ComponentName componentName, int i10) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        j9.a aVar = j9.a.f9742a;
        j9.a.f9745d.put(Integer.valueOf(componentName.hashCode()), Integer.valueOf(i10));
    }

    @SafeVarargs
    @a
    public final <T> T create(ComponentName componentName, String serviceName, Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        kotlin.jvm.internal.g.f(serviceName, "serviceName");
        kotlin.jvm.internal.g.f(serviceInterface, "serviceInterface");
        kotlin.jvm.internal.g.f(params, "params");
        b.Q(componentName);
        return (T) createProxy(componentName, serviceInterface, b.P(serviceInterface, serviceName), "", (Pair[]) Arrays.copyOf(params, params.length));
    }

    @SafeVarargs
    @a
    public final <T> T createSingleton(ComponentName componentName, Class<T> serviceInterface, String methodName, Pair<Class<?>, Object>... params) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        kotlin.jvm.internal.g.f(serviceInterface, "serviceInterface");
        kotlin.jvm.internal.g.f(methodName, "methodName");
        kotlin.jvm.internal.g.f(params, "params");
        return (T) createProxyByMethodName(componentName, "", serviceInterface, methodName, (Pair[]) Arrays.copyOf(params, params.length));
    }

    @SafeVarargs
    @a
    public final <T> T createSingleton(ComponentName componentName, String serviceName, Class<T> serviceInterface, String methodName, Pair<Class<?>, Object>... params) {
        kotlin.jvm.internal.g.f(componentName, "componentName");
        kotlin.jvm.internal.g.f(serviceName, "serviceName");
        kotlin.jvm.internal.g.f(serviceInterface, "serviceInterface");
        kotlin.jvm.internal.g.f(methodName, "methodName");
        kotlin.jvm.internal.g.f(params, "params");
        return (T) createProxyByMethodName(componentName, serviceName, serviceInterface, methodName, (Pair[]) Arrays.copyOf(params, params.length));
    }

    public final <T> T createService(Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        kotlin.jvm.internal.g.f(serviceInterface, "serviceInterface");
        kotlin.jvm.internal.g.f(params, "params");
        return (T) createService(serviceInterface, null, (Pair[]) Arrays.copyOf(params, params.length));
    }
}
