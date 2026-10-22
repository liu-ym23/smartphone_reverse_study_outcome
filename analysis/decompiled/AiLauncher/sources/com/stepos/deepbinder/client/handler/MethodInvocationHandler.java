package com.stepos.deepbinder.client.handler;

import android.content.ComponentName;
import com.stepos.deepbinder.annotation.method.MethodName;
import com.stepos.deepbinder.annotation.method.Oneway;
import com.stepos.deepbinder.annotation.method.Synchronize;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.deepbinder.client.cache.ListenerCache;
import com.stepos.deepbinder.client.channel.ClientChannelManager;
import com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.handler.BaseInvocationHandler;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.TimeStampGenerator;
import com.stepos.deepbinder.core.utils.IPCUtils;
import com.stepos.deepbinder.core.utils.ParameterTransformerUtils;
import com.stepos.deepbinder.core.utils.TypeUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0002)*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/stepos/deepbinder/client/handler/MethodInvocationHandler;", "Lcom/stepos/deepbinder/core/handler/BaseInvocationHandler;", "Lcom/stepos/deepbinder/core/entity/Call;", "mInstanceCreateCall", "<init>", "(Lcom/stepos/deepbinder/core/entity/Call;)V", "call", "Lcom/stepos/deepbinder/core/exception/IPCException;", "exception", "Lcom/stepos/deepbinder/core/entity/Reply;", "handlerException", "(Lcom/stepos/deepbinder/core/entity/Call;Lcom/stepos/deepbinder/core/exception/IPCException;)Lcom/stepos/deepbinder/core/entity/Reply;", "Ljava/lang/reflect/Method;", "method", "", "", "args", "internalInvoke", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Lcom/stepos/deepbinder/core/entity/Reply;", "LY8/t;", "recycleOriginObjects", "()V", "Lcom/stepos/deepbinder/core/entity/Call;", "", "isServiceAutoRecover", "Z", "Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "mBaseRemoteChannel", "Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "Landroid/content/ComponentName;", "mRemoteComponentName", "Landroid/content/ComponentName;", "", "mRemoteProcessName", "Ljava/lang/String;", "Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "mServiceWrapper", "Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "providerStateListener", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "Companion", "RemoteStateListener", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MethodInvocationHandler extends BaseInvocationHandler {
    private static final int MAX_RECOVER_COUNT = 100;
    private static final String TAG = "MethodInvocationHandler";
    private final boolean isServiceAutoRecover;
    private final BaseRemoteChannel mBaseRemoteChannel;
    private final Call mInstanceCreateCall;
    private final ComponentName mRemoteComponentName;
    private final String mRemoteProcessName;
    private final ServiceWrapper mServiceWrapper;
    private ProviderStateListener providerStateListener;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\"\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00020\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/client/handler/MethodInvocationHandler$RemoteStateListener;", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "Lcom/stepos/deepbinder/client/handler/MethodInvocationHandler;", "handler", "<init>", "(Lcom/stepos/deepbinder/client/handler/MethodInvocationHandler;)V", "Landroid/content/ComponentName;", "componentName", "LY8/t;", "onProviderStop", "(Landroid/content/ComponentName;)V", "onProviderStart", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "weakHandler", "Ljava/lang/ref/WeakReference;", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RemoteStateListener implements ProviderStateListener {
        private final WeakReference<MethodInvocationHandler> weakHandler;

        public RemoteStateListener(MethodInvocationHandler handler) {
            p.i(handler, "handler");
            this.weakHandler = new WeakReference<>(handler);
        }

        @Override // com.stepos.deepbinder.client.api.ProviderStateListener
        public void onProviderStart(ComponentName componentName) {
            p.i(componentName, "componentName");
        }

        @Override // com.stepos.deepbinder.client.api.ProviderStateListener
        public void onProviderStop(ComponentName componentName) {
            AtomicBoolean atomicBooleanIsCleaned;
            p.i(componentName, "componentName");
            MethodInvocationHandler methodInvocationHandler = this.weakHandler.get();
            if (methodInvocationHandler == null || (atomicBooleanIsCleaned = methodInvocationHandler.getIsCleaned()) == null) {
                return;
            }
            atomicBooleanIsCleaned.set(true);
        }
    }

    public MethodInvocationHandler(Call mInstanceCreateCall) {
        p.i(mInstanceCreateCall, "mInstanceCreateCall");
        this.mInstanceCreateCall = mInstanceCreateCall;
        ComponentName remoteComponentName = mInstanceCreateCall.getRemoteComponentName();
        this.mRemoteComponentName = remoteComponentName;
        ServiceWrapper serviceWrapperWithType = ServiceWrapper.INSTANCE.create().withTimeStamp(mInstanceCreateCall.getServiceWrapper().getTimeStamp()).withServiceInterfaceClass(mInstanceCreateCall.getServiceWrapper().getServiceInterfaceClass()).withServiceName(mInstanceCreateCall.getServiceWrapper().getName()).withCallerPackageName(mInstanceCreateCall.getServiceWrapper().getCallerPackageName()).withCallerProcessName(mInstanceCreateCall.getServiceWrapper().getCallerProcessName()).withType(mInstanceCreateCall.getServiceWrapper().getType() == 1 ? 4 : 3);
        this.mServiceWrapper = serviceWrapperWithType;
        this.mBaseRemoteChannel = ClientChannelManager.INSTANCE.getRemoteChannel(remoteComponentName);
        this.isServiceAutoRecover = ((AutoRecover) serviceWrapperWithType.getServiceInterfaceClass().getAnnotation(AutoRecover.class)) != null;
        String processName = IPCUtils.INSTANCE.queryComponentInternalInfoFromProvider(remoteComponentName).getProcessName();
        p.f(processName);
        this.mRemoteProcessName = processName;
        RemoteStateListener remoteStateListener = new RemoteStateListener(this);
        ListenerCache.INSTANCE.getInstance().registerProcessStateListener(remoteStateListener);
        this.providerStateListener = remoteStateListener;
    }

    private final Reply handlerException(Call call, IPCException exception) {
        Reply replySendCall;
        if (!call.getAutoRecover() || exception.getErrorCode() != 22) {
            throw exception;
        }
        synchronized (this) {
            try {
                if (call.getServiceWrapper().getType() == 4 || p.d(String.valueOf(this.mServiceWrapper.getTimeStamp()), exception.getExtraErrorData())) {
                    long timeStamp = TimeStampGenerator.INSTANCE.getTimeStamp();
                    this.mInstanceCreateCall.getServiceWrapper().withTimeStamp(timeStamp);
                    this.mBaseRemoteChannel.sendCall(this.mInstanceCreateCall);
                    this.mServiceWrapper.withTimeStamp(timeStamp);
                    call.setAutoRecover(false);
                }
                replySendCall = this.mBaseRemoteChannel.sendCall(call);
            } catch (Throwable th) {
                throw th;
            }
        }
        return replySendCall;
    }

    @Override // com.stepos.deepbinder.core.handler.BaseInvocationHandler
    public Reply internalInvoke(Method method, Object[] args) {
        String name;
        String classId;
        p.i(method, "method");
        p.i(args, "args");
        MethodName methodName = (MethodName) method.getAnnotation(MethodName.class);
        Synchronize synchronize = (Synchronize) method.getAnnotation(Synchronize.class);
        Oneway oneway = (Oneway) method.getAnnotation(Oneway.class);
        TypeUtils typeUtils = TypeUtils.INSTANCE;
        Class<?> returnType = method.getReturnType();
        p.h(returnType, "getReturnType(...)");
        boolean zIsVoid = typeUtils.isVoid(returnType);
        ParameterWrapper[] parameterWrapperArrWrapParameters = ParameterTransformerUtils.INSTANCE.wrapParameters(this.mRemoteProcessName, method, args);
        MethodWrapper methodWrapperObtain = MethodWrapper.INSTANCE.obtain();
        if (methodName == null || (name = methodName.value()) == null) {
            name = method.getName();
        }
        p.f(name);
        MethodWrapper methodWrapperWithVoid = methodWrapperObtain.withMethodName(name).withSync(synchronize != null).withOneway(oneway != null).withVoid(zIsVoid);
        if (zIsVoid) {
            classId = null;
        } else {
            Class<?> returnType2 = method.getReturnType();
            p.h(returnType2, "getReturnType(...)");
            classId = typeUtils.getClassId(returnType2);
        }
        Call callWithAutoRecover = Call.INSTANCE.obtain().withProtocolVersion(this.mInstanceCreateCall.getProtocolVersion()).withServiceWrapper(this.mServiceWrapper).withParameterWrappers(parameterWrapperArrWrapParameters).withMethodWrapper(methodWrapperWithVoid.withReturnType(classId)).withRemoteComponentName(this.mRemoteComponentName).withAutoRecover(this.isServiceAutoRecover);
        try {
            return this.mBaseRemoteChannel.sendCall(callWithAutoRecover);
        } catch (IPCException e10) {
            return this.handlerException(callWithAutoRecover, e10);
        }
    }

    @Override // com.stepos.deepbinder.core.handler.BaseInvocationHandler
    public void recycleOriginObjects() {
        try {
            IPCLog.INSTANCE.d(TAG, "[recycleOriginObjects]", "timeStamp", Long.valueOf(this.mInstanceCreateCall.getServiceWrapper().getTimeStamp()), "isCleaned", Boolean.valueOf(getIsCleaned().get()));
            ProviderStateListener providerStateListener = this.providerStateListener;
            if (providerStateListener != null) {
                ListenerCache.INSTANCE.getInstance().unRegisterProcessStateListener(providerStateListener);
                this.providerStateListener = null;
            }
            if (getIsCleaned().get()) {
                return;
            }
            this.mBaseRemoteChannel.recycleRemote(new Long[]{Long.valueOf(this.mInstanceCreateCall.getServiceWrapper().getTimeStamp())});
        } catch (IPCException e10) {
            IPCLog.INSTANCE.w(TAG, "[recycleOriginObjects][error]", "exception", e10);
        }
    }
}
