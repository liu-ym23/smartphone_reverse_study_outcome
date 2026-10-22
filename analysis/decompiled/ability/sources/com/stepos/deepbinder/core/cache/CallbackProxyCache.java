package com.stepos.deepbinder.core.cache;

import android.os.IBinder;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.handler.CallbackInvocationHandler;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.IPCRecycle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stepos/deepbinder/core/cache/CallbackProxyCache;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "TIME_STAMP", "callbackProxyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/ref/WeakReference;", "getCallbackProxy", "callbackClass", "Ljava/lang/Class;", "parameterWrapper", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", Constants.PARAM_PROTOCOL_VERSION, "", "processName", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallbackProxyCache {
    private static final String TAG = "CallbackProxyCache";
    private static final String TIME_STAMP = "timeStamp";
    public static final CallbackProxyCache INSTANCE = new CallbackProxyCache();
    private static final ConcurrentHashMap<Long, WeakReference<Object>> callbackProxyMap = new ConcurrentHashMap<>();

    private CallbackProxyCache() {
    }

    public final synchronized Object getCallbackProxy(Class<?> callbackClass, ParameterWrapper parameterWrapper, int protocolVersion, String processName) {
        try {
            k.f(callbackClass, "callbackClass");
            k.f(parameterWrapper, "parameterWrapper");
            k.f(processName, "processName");
            long timeStamp = parameterWrapper.getTimeStamp();
            ConcurrentHashMap<Long, WeakReference<Object>> concurrentHashMap = callbackProxyMap;
            WeakReference<Object> weakReference = concurrentHashMap.get(Long.valueOf(timeStamp));
            Object obj = weakReference != null ? weakReference.get() : null;
            if (obj != null) {
                IPCLog.INSTANCE.d(TAG, "[getCallbackProxy][Exists]", TIME_STAMP, Long.valueOf(timeStamp));
                return obj;
            }
            IPCLog.INSTANCE.d(TAG, "[getCallbackProxy][Create]", TIME_STAMP, Long.valueOf(timeStamp));
            concurrentHashMap.remove(Long.valueOf(timeStamp));
            IBinder clientServiceBinder = parameterWrapper.getClientServiceBinder();
            if (clientServiceBinder == null) {
                return null;
            }
            Object objNewProxyInstance = Proxy.newProxyInstance(callbackClass.getClassLoader(), new Class[]{callbackClass}, new CallbackInvocationHandler(clientServiceBinder, timeStamp, parameterWrapper.hashCode(), protocolVersion, processName));
            concurrentHashMap.put(Long.valueOf(timeStamp), new WeakReference<>(objNewProxyInstance));
            IPCRecycle companion = IPCRecycle.INSTANCE.getInstance();
            k.c(objNewProxyInstance);
            companion.register(objNewProxyInstance);
            return objNewProxyInstance;
        } catch (Throwable th) {
            throw th;
        }
    }
}
