package com.stepos.deepbinder.core.provider;

import I4.l;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.view.i;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.deepbinder.annotation.method.UIThread;
import com.stepos.deepbinder.core.api.IClientService;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.deepbinder.core.cache.TypeCache;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.internal.InternalMethod;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.IPCThreadCaller;
import com.stepos.deepbinder.core.utils.ParameterTransformerUtils;
import com.stepos.deepbinder.core.utils.TypeUtils;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJM\u0010\u0017\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u001aJ\u0017\u0010#\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u001aJ3\u0010(\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00142\b\b\u0001\u0010&\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0014H\u0015¢\u0006\u0004\b(\u0010)J\u001f\u0010-\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00142\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\u001aJ\u000f\u00101\u001a\u000200H\u0017¢\u0006\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/stepos/deepbinder/core/provider/ClientServiceProvider;", "Landroid/os/Binder;", "Lcom/stepos/deepbinder/core/api/IClientService;", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/deepbinder/core/entity/Callback;", "callback", "", "callbackObj", "", "determineUIThreadStatus", "(Lcom/stepos/deepbinder/core/entity/Callback;Ljava/lang/Object;)Z", "Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "", "parameters", "isUiThread", "Lcom/stepos/deepbinder/core/entity/Reply;", Constants.PARAM_REPLY, "", "", "flowIndices", "LC7/r;", "handleSyncCallback", "(Ljava/lang/Object;Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;[Ljava/lang/Object;ZLcom/stepos/deepbinder/core/entity/Reply;Ljava/util/List;)V", "prepareAndSendSyncCallback", "(Lcom/stepos/deepbinder/core/entity/Callback;)Lcom/stepos/deepbinder/core/entity/Reply;", "retrieveCallbackObject", "(Lcom/stepos/deepbinder/core/entity/Callback;)Ljava/lang/Object;", "retrieveInternalMethod", "(Lcom/stepos/deepbinder/core/entity/Callback;Ljava/lang/Object;)Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;", "", "retrieveParameters", "(Lcom/stepos/deepbinder/core/entity/Callback;Ljava/util/List;)[Ljava/lang/Object;", "sendAsyncCallback", "sendSyncCallback", "code", "Landroid/os/Parcel;", SettingsConfig.KEY_DATA, "flags", "onTransact", "(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", Constants.PARAM_PID, "", "timestamps", "recycle", "(I[J)V", "sendCallback", "Landroid/os/IBinder;", "asBinder", "()Landroid/os/IBinder;", "Companion", "CallbackRunnable", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClientServiceProvider extends Binder implements IClientService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ClientServiceProvider";
    private static volatile ClientServiceProvider instance;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/stepos/deepbinder/core/provider/ClientServiceProvider$CallbackRunnable;", "Ljava/util/concurrent/Callable;", "", "Ljava/lang/Runnable;", "Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "callback", "", "parameters", "", "isUiThread", AppAgent.CONSTRUCT, "(Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;Ljava/lang/Object;[Ljava/lang/Object;Z)V", "call", "()Ljava/lang/Object;", "", "getException", "()Ljava/lang/Throwable;", "LC7/r;", "run", "()V", "Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;", "Ljava/lang/Object;", "[Ljava/lang/Object;", "Z", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "exception", "Ljava/lang/Throwable;", "result", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CallbackRunnable implements Callable<Object>, Runnable {
        private final Object callback;
        private final CountDownLatch countDownLatch;
        private Throwable exception;
        private final boolean isUiThread;
        private final InternalMethod method;
        private final Object[] parameters;
        private Object result;

        public CallbackRunnable(InternalMethod method, Object callback, Object[] parameters, boolean z10) {
            k.f(method, "method");
            k.f(callback, "callback");
            k.f(parameters, "parameters");
            this.method = method;
            this.callback = callback;
            this.parameters = parameters;
            this.isUiThread = z10;
            this.countDownLatch = new CountDownLatch(1);
        }

        @Override // java.util.concurrent.Callable
        @Keep
        public Object call() throws InterruptedException {
            if (this.isUiThread) {
                IPCThreadCaller.INSTANCE.post(true, false, this);
                this.countDownLatch.await();
            } else {
                run();
            }
            return this.result;
        }

        public final Throwable getException() {
            return this.exception;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InternalMethod internalMethod = this.method;
                Object obj = this.callback;
                Object[] objArr = this.parameters;
                this.result = internalMethod.invoke(obj, Arrays.copyOf(objArr, objArr.length));
            } catch (Throwable th) {
                try {
                    this.exception = th;
                    if (this.isUiThread) {
                        this.countDownLatch.countDown();
                    }
                } finally {
                    if (this.isUiThread) {
                        this.countDownLatch.countDown();
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/deepbinder/core/provider/ClientServiceProvider$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "instance", "Lcom/stepos/deepbinder/core/provider/ClientServiceProvider;", "getClientService", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ClientServiceProvider getClientService() {
            ClientServiceProvider clientServiceProvider;
            ClientServiceProvider clientServiceProvider2 = ClientServiceProvider.instance;
            if (clientServiceProvider2 != null) {
                return clientServiceProvider2;
            }
            synchronized (ClientServiceProvider.class) {
                clientServiceProvider = ClientServiceProvider.instance;
                if (clientServiceProvider == null) {
                    clientServiceProvider = new ClientServiceProvider();
                    ClientServiceProvider.instance = clientServiceProvider;
                }
            }
            return clientServiceProvider;
        }

        private Companion() {
        }
    }

    public ClientServiceProvider() {
        attachInterface(this, Constants.INSTANCE.getCLIENT_SERVICE_DESCRIPTOR());
    }

    private final boolean determineUIThreadStatus(Callback callback, Object callbackObj) {
        Class<?>[] interfaces = callbackObj.getClass().getInterfaces();
        k.e(interfaces, "getInterfaces(...)");
        for (Class<?> cls : interfaces) {
            Annotation[] annotations = cls.getAnnotations();
            k.d(annotations, "null cannot be cast to non-null type kotlin.Array<java.lang.annotation.Annotation>");
            TypeUtils typeUtils = TypeUtils.INSTANCE;
            if (typeUtils.arrayContainsAnnotation(annotations, Callback.class)) {
                TypeCache companion = TypeCache.INSTANCE.getInstance();
                MethodWrapper methodWrapper = callback.getMethodWrapper();
                k.c(methodWrapper);
                String name = methodWrapper.getName();
                if (name == null) {
                    name = "";
                }
                ParameterWrapper[] parameterWrappers = callback.getParameterWrappers();
                if (parameterWrappers == null) {
                    parameterWrappers = new ParameterWrapper[0];
                }
                String methodId = typeUtils.getMethodId(name, parameterWrappers);
                MethodWrapper methodWrapper2 = callback.getMethodWrapper();
                k.c(methodWrapper2);
                ParameterWrapper[] parameterWrappers2 = callback.getParameterWrappers();
                if (parameterWrappers2 == null) {
                    parameterWrappers2 = new ParameterWrapper[0];
                }
                Method method = companion.getMethod(cls, methodId, methodWrapper2, parameterWrappers2).getMethod();
                k.c(method);
                Annotation[] annotations2 = method.getAnnotations();
                k.d(annotations2, "null cannot be cast to non-null type kotlin.Array<java.lang.annotation.Annotation>");
                if (typeUtils.arrayContainsAnnotation(annotations2, UIThread.class)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleSyncCallback(java.lang.Object r4, com.stepos.deepbinder.core.entity.internal.InternalMethod r5, java.lang.Object[] r6, boolean r7, com.stepos.deepbinder.core.entity.Reply r8, java.util.List<java.lang.Integer> r9) {
        /*
            r3 = this;
            r3 = 0
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L3e
            android.os.Looper r1 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L3e
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L3e
            if (r0 != 0) goto L49
            if (r7 == 0) goto L49
            com.stepos.deepbinder.core.provider.ClientServiceProvider$CallbackRunnable r0 = new com.stepos.deepbinder.core.provider.ClientServiceProvider$CallbackRunnable     // Catch: java.lang.Throwable -> L3e
            r0.<init>(r5, r4, r6, r7)     // Catch: java.lang.Throwable -> L3e
            com.stepos.deepbinder.core.tools.IPCThreadCaller$Companion r4 = com.stepos.deepbinder.core.tools.IPCThreadCaller.INSTANCE     // Catch: java.lang.Throwable -> L3e
            java.util.concurrent.Future r4 = r4.submit(r0)     // Catch: java.lang.Throwable -> L3e
            com.stepos.deepbinder.core.utils.TypeUtils r6 = com.stepos.deepbinder.core.utils.TypeUtils.INSTANCE     // Catch: java.lang.Throwable -> L3e
            java.lang.reflect.Method r5 = r5.getMethod()     // Catch: java.lang.Throwable -> L3e
            kotlin.jvm.internal.k.c(r5)     // Catch: java.lang.Throwable -> L3e
            java.lang.Class r5 = r5.getReturnType()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r7 = "getReturnType(...)"
            kotlin.jvm.internal.k.e(r5, r7)     // Catch: java.lang.Throwable -> L3e
            boolean r5 = r6.isVoid(r5)     // Catch: java.lang.Throwable -> L3e
            if (r5 == 0) goto L40
            boolean r5 = r9.isEmpty()     // Catch: java.lang.Throwable -> L3e
            if (r5 == 0) goto L40
            r8.setResult(r3)     // Catch: java.lang.Throwable -> L3e
            goto L44
        L3e:
            r4 = move-exception
            goto L53
        L40:
            java.lang.Object r3 = r4.get()     // Catch: java.lang.Throwable -> L3e
        L44:
            java.lang.Throwable r4 = r0.getException()     // Catch: java.lang.Throwable -> L3e
            goto L5d
        L49:
            int r7 = r6.length     // Catch: java.lang.Throwable -> L3e
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r4 = r5.invoke(r4, r6)     // Catch: java.lang.Throwable -> L3e
            goto L60
        L53:
            boolean r5 = r4 instanceof java.lang.reflect.InvocationTargetException
            if (r5 == 0) goto L5d
            java.lang.reflect.InvocationTargetException r4 = (java.lang.reflect.InvocationTargetException) r4
            java.lang.Throwable r4 = r4.getTargetException()
        L5d:
            r2 = r4
            r4 = r3
            r3 = r2
        L60:
            if (r3 != 0) goto L66
            r8.setResult(r4)
            return
        L66:
            com.stepos.deepbinder.core.exception.IPCException r4 = new com.stepos.deepbinder.core.exception.IPCException
            r5 = 4
            r4.<init>(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.core.provider.ClientServiceProvider.handleSyncCallback(java.lang.Object, com.stepos.deepbinder.core.entity.internal.InternalMethod, java.lang.Object[], boolean, com.stepos.deepbinder.core.entity.Reply, java.util.List):void");
    }

    private final Reply prepareAndSendSyncCallback(Callback callback) {
        ArrayList arrayList = new ArrayList();
        Object objRetrieveCallbackObject = retrieveCallbackObject(callback);
        InternalMethod internalMethodRetrieveInternalMethod = retrieveInternalMethod(callback, objRetrieveCallbackObject);
        Object[] objArrRetrieveParameters = retrieveParameters(callback, arrayList);
        boolean zDetermineUIThreadStatus = determineUIThreadStatus(callback, objRetrieveCallbackObject);
        Reply replyObtain = Reply.INSTANCE.obtain();
        handleSyncCallback(objRetrieveCallbackObject, internalMethodRetrieveInternalMethod, objArrRetrieveParameters, zDetermineUIThreadStatus, replyObtain, arrayList);
        if (!arrayList.isEmpty()) {
            replyObtain.setFlowParameterWrappers(ParameterTransformerUtils.INSTANCE.getFlowParameterWrappers(arrayList, objArrRetrieveParameters));
        }
        return replyObtain;
    }

    private final Object retrieveCallbackObject(Callback callback) {
        Object callback2 = CallbackCache.INSTANCE.getCallback(callback.getTimeStamp());
        if (callback2 != null) {
            return callback2;
        }
        throw new IPCException(6, "The callback could not be found on the calling side, perhaps it was recycled or the calling process was restarted");
    }

    private final InternalMethod retrieveInternalMethod(Callback callback, Object callbackObj) {
        TypeCache companion = TypeCache.INSTANCE.getInstance();
        Class<?> cls = callbackObj.getClass();
        TypeUtils typeUtils = TypeUtils.INSTANCE;
        MethodWrapper methodWrapper = callback.getMethodWrapper();
        k.c(methodWrapper);
        String name = methodWrapper.getName();
        if (name == null) {
            name = "";
        }
        ParameterWrapper[] parameterWrappers = callback.getParameterWrappers();
        if (parameterWrappers == null) {
            parameterWrappers = new ParameterWrapper[0];
        }
        String methodId = typeUtils.getMethodId(name, parameterWrappers);
        MethodWrapper methodWrapper2 = callback.getMethodWrapper();
        k.c(methodWrapper2);
        ParameterWrapper[] parameterWrappers2 = callback.getParameterWrappers();
        if (parameterWrappers2 == null) {
            parameterWrappers2 = new ParameterWrapper[0];
        }
        return companion.getMethod(cls, methodId, methodWrapper2, parameterWrappers2);
    }

    private final Object[] retrieveParameters(Callback callback, List<Integer> flowIndices) {
        ParameterTransformerUtils parameterTransformerUtils = ParameterTransformerUtils.INSTANCE;
        String callerProcessName = callback.getCallerProcessName();
        if (callerProcessName == null) {
            callerProcessName = "";
        }
        return parameterTransformerUtils.unwrapParameters(callerProcessName, callback.getParameterWrappers(), flowIndices, callback.getProtocolVersion());
    }

    private final Reply sendAsyncCallback(Callback callback) {
        IPCThreadCaller.INSTANCE.post(false, false, new l(28, this, callback));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Reply sendSyncCallback(Callback callback) {
        try {
            return prepareAndSendSyncCallback(callback);
        } catch (IPCException e) {
            IPCLog.INSTANCE.w(TAG, "[sendCallbackSync]" + callback, e);
            return Reply.INSTANCE.obtain().withIPCException(e);
        } finally {
            callback.recycle();
        }
    }

    @Override // android.os.IInterface
    @Keep
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    @Keep
    public boolean onTransact(int code, @NonNull Parcel data, Parcel reply, int flags) {
        k.f(data, "data");
        if (code == 3) {
            Callback callbackCreateFromParcel = Callback.INSTANCE.createFromParcel(data);
            boolean zIsOneway = callbackCreateFromParcel.getIsOneway();
            MethodWrapper methodWrapper = callbackCreateFromParcel.getMethodWrapper();
            boolean zIsVoid = methodWrapper != null ? methodWrapper.getIsVoid() : true;
            int protocolVersion = callbackCreateFromParcel.getProtocolVersion();
            Reply replySendCallback = sendCallback(callbackCreateFromParcel);
            if (!zIsOneway && (!zIsVoid || replySendCallback.getIpcException() != null || replySendCallback.getFlowParameterWrappers() != null)) {
                replySendCallback.setProtocolVersion(protocolVersion);
                k.c(reply);
                replySendCallback.writeToParcel(reply, 0);
            }
        } else if (code == 4) {
            int i = data.readInt();
            long[] jArrCreateLongArray = data.createLongArray();
            if (jArrCreateLongArray == null) {
                jArrCreateLongArray = new long[0];
            }
            IPCThreadCaller.INSTANCE.post(false, false, new i(i, 6, this, jArrCreateLongArray));
            return true;
        }
        return true;
    }

    @Override // com.stepos.deepbinder.core.api.IService
    public void recycle(int pid, long[] timestamps) {
        k.f(timestamps, "timestamps");
        for (long j5 : timestamps) {
            IPCLog.INSTANCE.d(TAG, b.p(j5, "[recycle] timeStamp="), new Object[0]);
            CallbackCache.INSTANCE.removeCallback(j5);
        }
    }

    @Override // com.stepos.deepbinder.core.api.IClientService
    public Reply sendCallback(Callback callback) {
        k.f(callback, "callback");
        if (!callback.getIsOneway()) {
            return sendSyncCallback(callback);
        }
        Reply replySendAsyncCallback = sendAsyncCallback(callback);
        return replySendAsyncCallback == null ? Reply.INSTANCE.obtain() : replySendAsyncCallback;
    }
}
