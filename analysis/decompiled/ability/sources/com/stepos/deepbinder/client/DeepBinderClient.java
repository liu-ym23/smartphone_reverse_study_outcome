package com.stepos.deepbinder.client;

import android.app.Application;
import android.content.ComponentName;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.deepbinder.client.cache.ListenerCache;
import com.stepos.deepbinder.client.channel.ClientChannelManager;
import com.stepos.deepbinder.client.handler.MethodInvocationHandler;
import com.stepos.deepbinder.client.util.ValidateUtils;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.handler.BaseInvocationHandler;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.IPCRecycle;
import com.stepos.deepbinder.core.tools.TimeStampGenerator;
import com.stepos.deepbinder.core.utils.IPCUtils;
import com.stepos.deepbinder.core.utils.ParameterWrapperUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jo\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t22\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jo\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u000b\u001a\u00020\t22\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ_\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010 \u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000722\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0004\b!\u0010\"J_\u0010#\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t22\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0004\b#\u0010$J_\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000722\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u001fJ\u000f\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b,\u0010-J\u001b\u0010/\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u00042\u0006\u0010.\u001a\u00028\u0000¢\u0006\u0004\b/\u0010\u001aJ\u001d\u00101\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u00042\u0006\u00100\u001a\u00028\u0000H\u0007¢\u0006\u0004\b1\u0010\u001aJ\u0017\u00104\u001a\u00020\u00182\u0006\u00103\u001a\u000202H\u0007¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b6\u0010\u001fJ\u0015\u00109\u001a\u00020\u00182\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00182\u0006\u00103\u001a\u000202H\u0007¢\u0006\u0004\b;\u00105Jg\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000722\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0004\b!\u0010<Jg\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000722\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0004\b%\u0010<J\u001d\u00109\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010=Jg\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u000b\u001a\u00020\t22\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0004\b%\u0010>Jo\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u000b\u001a\u00020\t22\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0004\b%\u0010\u0012JU\u0010#\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000722\u0010\u000e\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r0\f\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0004\b#\u0010?R\u0014\u0010@\u001a\u0002078\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u0002078\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010AR\u0014\u0010C\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010D¨\u0006F"}, d2 = {"Lcom/stepos/deepbinder/client/DeepBinderClient;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/ComponentName;", "componentName", "Ljava/lang/Class;", "serviceInterface", "", "serviceName", "methodName", "", "Landroid/util/Pair;", "params", "createProxy", "(Landroid/content/ComponentName;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;[Landroid/util/Pair;)Ljava/lang/Object;", "createProxyByMethodName", "(Landroid/content/ComponentName;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;[Landroid/util/Pair;)Ljava/lang/Object;", "Lcom/stepos/deepbinder/core/entity/Call;", "call", "getProxy", "(Lcom/stepos/deepbinder/core/entity/Call;)Ljava/lang/Object;", "proxy", "LC7/r;", "recycle", "(Ljava/lang/Object;)V", "authority", "addComponentAuthority", "(Landroid/content/ComponentName;Ljava/lang/String;)V", Constants.METHOD_CONNECT, "(Landroid/content/ComponentName;)V", "targetPkg", "create", "(Ljava/lang/String;Ljava/lang/Class;[Landroid/util/Pair;)Ljava/lang/Object;", "createService", "(Ljava/lang/Class;Ljava/lang/String;[Landroid/util/Pair;)Ljava/lang/Object;", "createSingleton", "(Landroid/content/ComponentName;Ljava/lang/Class;[Landroid/util/Pair;)Ljava/lang/Object;", "disconnect", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "", "isConnect", "(Landroid/content/ComponentName;)Z", "callback", "recycleCallback", NotificationCompat.CATEGORY_SERVICE, "recycleService", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "listener", "registerProviderStateListener", "(Lcom/stepos/deepbinder/client/api/ProviderStateListener;)V", "removeComponentAuthority", "", "time", "setAutoDisconnectTime", "(I)V", "unRegisterProviderStateListener", "(Landroid/content/ComponentName;Ljava/lang/String;Ljava/lang/Class;[Landroid/util/Pair;)Ljava/lang/Object;", "(Landroid/content/ComponentName;I)V", "(Landroid/content/ComponentName;Ljava/lang/Class;Ljava/lang/String;[Landroid/util/Pair;)Ljava/lang/Object;", "(Ljava/lang/Class;[Landroid/util/Pair;)Ljava/lang/Object;", "CONNECT_ALWAYS", "I", "CONNECT_MAX_TIME", "IPC_REQUEST_DEEPBINDER", "Ljava/lang/String;", "TAG", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeepBinderClient {
    public static final int CONNECT_ALWAYS = -1;
    public static final int CONNECT_MAX_TIME = 43200000;
    public static final DeepBinderClient INSTANCE = new DeepBinderClient();
    private static final String IPC_REQUEST_DEEPBINDER = "deepbinder";
    private static final String TAG = "DeepBinder";

    private DeepBinderClient() {
    }

    @SafeVarargs
    private final <T> T createProxy(ComponentName componentName, Class<T> serviceInterface, String serviceName, String methodName, Pair<Class<?>, Object>... params) throws NumberFormatException {
        IPCUtils iPCUtils = IPCUtils.INSTANCE;
        String currentProcessName = iPCUtils.getCurrentProcessName();
        String processName = iPCUtils.queryComponentInternalInfoFromProvider(componentName).getProcessName();
        if (k.b(currentProcessName, processName)) {
            try {
                return (T) createService(serviceInterface, serviceName, (Pair[]) Arrays.copyOf(params, params.length));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e6) {
                throw new RuntimeException(e6);
            }
        }
        ServiceWrapper.Companion companion = ServiceWrapper.INSTANCE;
        ServiceWrapper serviceWrapperObtain = companion.obtain();
        serviceWrapperObtain.setTimeStamp(TimeStampGenerator.INSTANCE.getTimeStamp());
        serviceWrapperObtain.setServiceInterfaceClass(serviceInterface);
        serviceWrapperObtain.setName(serviceName);
        serviceWrapperObtain.setCallerPackageName(INSTANCE.getContext().getPackageName());
        serviceWrapperObtain.setCallerProcessName(currentProcessName);
        int i = 0;
        serviceWrapperObtain.setType((methodName.length() == 0 ? 1 : 0) ^ 1);
        serviceWrapperObtain.withProxyStateBinder(companion.getBinder());
        Call callCreate = Call.INSTANCE.create();
        callCreate.setServiceWrapper(serviceWrapperObtain);
        MethodWrapper methodWrapperObtain = MethodWrapper.INSTANCE.obtain();
        methodWrapperObtain.setName(methodName);
        methodWrapperObtain.setVoid(true);
        callCreate.setMethodWrapper(methodWrapperObtain);
        ParameterWrapperUtil parameterWrapperUtil = ParameterWrapperUtil.INSTANCE;
        k.c(processName);
        callCreate.setParameterWrappers(parameterWrapperUtil.wrapperParameters(processName, (Pair[]) Arrays.copyOf(params, params.length)));
        callCreate.setRemoteComponentName(componentName);
        try {
            ClientChannelManager.INSTANCE.getRemoteChannel(componentName).sendCall(callCreate);
        } catch (IPCException e9) {
            if (e9.getErrorCode() != 52) {
                throw e9;
            }
            IPCLog.INSTANCE.w(TAG, "Caller protocol version higher than server, degrading version", new Object[0]);
            try {
                String extraErrorData = e9.getExtraErrorData();
                if (extraErrorData != null) {
                    i = Integer.parseInt(extraErrorData);
                }
            } catch (NumberFormatException unused) {
                IPCLog.INSTANCE.w(TAG, "Failed to parse protocol version, using default", new Object[0]);
            }
            callCreate.setProtocolVersion(i);
            ClientChannelManager.INSTANCE.getRemoteChannel(componentName).sendCall(callCreate);
        }
        return (T) getProxy(callCreate);
    }

    @SafeVarargs
    private final <T> T createProxyByMethodName(ComponentName componentName, String serviceName, Class<T> serviceInterface, String methodName, Pair<Class<?>, Object>... params) {
        ValidateUtils validateUtils = ValidateUtils.INSTANCE;
        validateUtils.validateComponentName(componentName);
        return (T) createProxy(componentName, serviceInterface, validateUtils.validateAndGetServiceName(serviceName, serviceInterface), methodName, (Pair[]) Arrays.copyOf(params, params.length));
    }

    private final <T> T getProxy(Call call) throws IllegalArgumentException {
        T t9 = (T) Proxy.newProxyInstance(call.getServiceWrapper().getServiceInterfaceClass().getClassLoader(), new Class[]{call.getServiceWrapper().getServiceInterfaceClass()}, new MethodInvocationHandler(call));
        if (t9 != null) {
            IPCRecycle.INSTANCE.getInstance().register(t9);
        }
        return t9;
    }

    private final <T> void recycle(T proxy) throws IllegalArgumentException {
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxy);
        k.d(invocationHandler, "null cannot be cast to non-null type com.stepos.deepbinder.core.handler.BaseInvocationHandler");
        ((BaseInvocationHandler) invocationHandler).clean();
    }

    @Keep
    public final void addComponentAuthority(ComponentName componentName, String authority) {
        k.f(componentName, "componentName");
        k.f(authority, "authority");
        IPCUtils.INSTANCE.addProviderAuthority(componentName, authority);
    }

    @Keep
    public final void connect(ComponentName componentName) {
        k.f(componentName, "componentName");
        ValidateUtils.INSTANCE.validateComponentName(componentName);
        ClientChannelManager.INSTANCE.getRemoteChannel(componentName).connect();
    }

    @SafeVarargs
    @Keep
    public final <T> T create(String targetPkg, Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        k.f(targetPkg, "targetPkg");
        k.f(serviceInterface, "serviceInterface");
        k.f(params, "params");
        return (T) create(new ComponentName(targetPkg, "com.stepos.deepbinder.service.DeepBinderProvider"), "", serviceInterface, (Pair[]) Arrays.copyOf(params, params.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T createService(Class<T> serviceInterface, String serviceName, Pair<Class<?>, Object>... params) throws ClassNotFoundException {
        k.f(serviceInterface, "serviceInterface");
        k.f(params, "params");
        if (serviceName == null || serviceName.length() == 0) {
            serviceName = null;
        }
        if (serviceName == null) {
            ServiceName serviceName2 = (ServiceName) serviceInterface.getAnnotation(ServiceName.class);
            String strValue = serviceName2 != null ? serviceName2.value() : null;
            if (strValue == null) {
                throw new IllegalArgumentException("Service name not provided and no @ServiceName annotation found");
            }
            serviceName = strValue;
        }
        try {
            Class<?> cls = Class.forName(serviceName);
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(e6);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException(e9);
        }
    }

    @SafeVarargs
    @Keep
    public final <T> T createSingleton(ComponentName componentName, Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        k.f(componentName, "componentName");
        k.f(serviceInterface, "serviceInterface");
        k.f(params, "params");
        return (T) createProxyByMethodName(componentName, "", serviceInterface, "getInstance", (Pair[]) Arrays.copyOf(params, params.length));
    }

    public final void disconnect(ComponentName componentName) {
        k.f(componentName, "componentName");
        ValidateUtils.INSTANCE.validateComponentName(componentName);
        ClientChannelManager.INSTANCE.releaseRemoteChannel(componentName);
    }

    @Keep
    public final Application getContext() {
        return DeepBinderInternal.getContext();
    }

    @Keep
    public final boolean isConnect(ComponentName componentName) {
        k.f(componentName, "componentName");
        try {
            ValidateUtils.INSTANCE.validateComponentName(componentName);
            return IPCUtils.INSTANCE.isProcessAlive(componentName);
        } catch (IPCException unused) {
            return false;
        }
    }

    public final <T> void recycleCallback(T callback) {
        try {
            recycle(callback);
        } catch (ClassCastException unused) {
            if (callback != null) {
                CallbackCache.INSTANCE.removeCallback(callback);
            }
        } catch (IllegalArgumentException unused2) {
            if (callback != null) {
                CallbackCache.INSTANCE.removeCallback(callback);
            }
        }
    }

    @Keep
    public final <T> void recycleService(T service) {
        try {
            recycle(service);
        } catch (ClassCastException | IllegalArgumentException unused) {
        }
    }

    @Keep
    public final void registerProviderStateListener(ProviderStateListener listener) {
        k.f(listener, "listener");
        ListenerCache.INSTANCE.registerProcessStateListener(listener);
    }

    @Keep
    public final void removeComponentAuthority(ComponentName componentName) {
        k.f(componentName, "componentName");
        IPCUtils.INSTANCE.removeProviderAuthority(componentName);
    }

    public final void setAutoDisconnectTime(int time) {
        ClientChannelManager.INSTANCE.setDisconnectTime(time);
    }

    @Keep
    public final void unRegisterProviderStateListener(ProviderStateListener listener) {
        k.f(listener, "listener");
        ListenerCache.INSTANCE.unRegisterProcessStateListener(listener);
    }

    @SafeVarargs
    @Keep
    public final <T> T createSingleton(ComponentName componentName, String serviceName, Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        k.f(componentName, "componentName");
        k.f(serviceName, "serviceName");
        k.f(serviceInterface, "serviceInterface");
        k.f(params, "params");
        return (T) createProxyByMethodName(componentName, serviceName, serviceInterface, "getInstance", (Pair[]) Arrays.copyOf(params, params.length));
    }

    public final void setAutoDisconnectTime(ComponentName componentName, int time) {
        k.f(componentName, "componentName");
        ClientChannelManager.INSTANCE.setDisconnectTime(componentName, time);
    }

    @SafeVarargs
    @Keep
    public final <T> T create(ComponentName componentName, String serviceName, Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        k.f(componentName, "componentName");
        k.f(serviceName, "serviceName");
        k.f(serviceInterface, "serviceInterface");
        k.f(params, "params");
        ValidateUtils validateUtils = ValidateUtils.INSTANCE;
        validateUtils.validateComponentName(componentName);
        return (T) createProxy(componentName, serviceInterface, validateUtils.validateAndGetServiceName(serviceName, serviceInterface), "", (Pair[]) Arrays.copyOf(params, params.length));
    }

    @SafeVarargs
    @Keep
    public final <T> T createSingleton(ComponentName componentName, Class<T> serviceInterface, String methodName, Pair<Class<?>, Object>... params) {
        k.f(componentName, "componentName");
        k.f(serviceInterface, "serviceInterface");
        k.f(methodName, "methodName");
        k.f(params, "params");
        return (T) createProxyByMethodName(componentName, "", serviceInterface, methodName, (Pair[]) Arrays.copyOf(params, params.length));
    }

    @SafeVarargs
    @Keep
    public final <T> T createSingleton(ComponentName componentName, String serviceName, Class<T> serviceInterface, String methodName, Pair<Class<?>, Object>... params) {
        k.f(componentName, "componentName");
        k.f(serviceName, "serviceName");
        k.f(serviceInterface, "serviceInterface");
        k.f(methodName, "methodName");
        k.f(params, "params");
        return (T) createProxyByMethodName(componentName, serviceName, serviceInterface, methodName, (Pair[]) Arrays.copyOf(params, params.length));
    }

    public final <T> T createService(Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        k.f(serviceInterface, "serviceInterface");
        k.f(params, "params");
        return (T) createService(serviceInterface, null, (Pair[]) Arrays.copyOf(params, params.length));
    }
}
