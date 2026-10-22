package com.stepos.deepbinder.core.handler;

import android.os.IBinder;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.deepbinder.annotation.method.Oneway;
import com.stepos.deepbinder.core.channel.ChannelManager;
import com.stepos.deepbinder.core.channel.client.BaseClientChannel;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.utils.IPCUtils;
import com.stepos.deepbinder.core.utils.ParameterTransformerUtils;
import com.stepos.deepbinder.core.utils.TypeUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0097\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b&\u0010\u0013R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/deepbinder/core/handler/CallbackInvocationHandler;", "Lcom/stepos/deepbinder/core/handler/BaseInvocationHandler;", "Landroid/os/IBinder;", "clientServiceBinder", "", "timeStamp", "", "hashCodeValue", Constants.PARAM_PROTOCOL_VERSION, "", "processName", AppAgent.CONSTRUCT, "(Landroid/os/IBinder;JIILjava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/reflect/Method;", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "", "args", "Lcom/stepos/deepbinder/core/entity/Reply;", "internalInvoke", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Lcom/stepos/deepbinder/core/entity/Reply;", "LC7/r;", "recycleOriginObjects", "()V", "Landroid/os/IBinder;", "getClientServiceBinder", "()Landroid/os/IBinder;", "J", "getTimeStamp", "()J", "I", "getHashCodeValue", "getProtocolVersion", "Ljava/lang/String;", "getProcessName", "()Ljava/lang/String;", "Lcom/stepos/deepbinder/core/channel/client/BaseClientChannel;", "baseClientChannel", "Lcom/stepos/deepbinder/core/channel/client/BaseClientChannel;", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallbackInvocationHandler extends BaseInvocationHandler {
    private static final String TAG = "CallbackInvocationHandler";
    private final BaseClientChannel baseClientChannel;
    private final IBinder clientServiceBinder;
    private final int hashCodeValue;
    private final String processName;
    private final int protocolVersion;
    private final long timeStamp;

    public CallbackInvocationHandler(IBinder clientServiceBinder, long j5, int i, int i6, String processName) {
        k.f(clientServiceBinder, "clientServiceBinder");
        k.f(processName, "processName");
        this.clientServiceBinder = clientServiceBinder;
        this.timeStamp = j5;
        this.hashCodeValue = i;
        this.protocolVersion = i6;
        this.processName = processName;
        this.baseClientChannel = ChannelManager.INSTANCE.getClientChannel(clientServiceBinder);
    }

    @Keep
    public boolean equals(Object other) throws IllegalArgumentException {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(other);
            if (hashCode() == other.hashCode()) {
                long j5 = this.timeStamp;
                k.d(invocationHandler, "null cannot be cast to non-null type com.stepos.deepbinder.core.handler.CallbackInvocationHandler");
                if (j5 == ((CallbackInvocationHandler) invocationHandler).timeStamp) {
                    return true;
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        return false;
    }

    public final IBinder getClientServiceBinder() {
        return this.clientServiceBinder;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    @Keep
    public int hashCode() {
        return this.hashCodeValue;
    }

    @Override // com.stepos.deepbinder.core.handler.BaseInvocationHandler
    public Reply internalInvoke(Method method, Object[] args) {
        String classId;
        k.f(method, "method");
        k.f(args, "args");
        TypeUtils typeUtils = TypeUtils.INSTANCE;
        Class<?> returnType = method.getReturnType();
        k.e(returnType, "getReturnType(...)");
        boolean zIsVoid = typeUtils.isVoid(returnType);
        ParameterWrapper[] parameterWrapperArrWrapParameters = ParameterTransformerUtils.INSTANCE.wrapParameters(this.processName, method, args);
        MethodWrapper methodWrapperObtain = MethodWrapper.INSTANCE.obtain();
        String name = method.getName();
        k.e(name, "getName(...)");
        MethodWrapper methodWrapperWithVoid = methodWrapperObtain.withMethodName(name).withVoid(zIsVoid);
        if (zIsVoid) {
            classId = null;
        } else {
            Class<?> returnType2 = method.getReturnType();
            k.e(returnType2, "getReturnType(...)");
            classId = typeUtils.getClassId(returnType2);
        }
        if (classId == null) {
            classId = "";
        }
        methodWrapperWithVoid.withReturnType(classId);
        Callback callbackWithTimeStamp = Callback.INSTANCE.obtain().withProtocolVersion(this.protocolVersion).withParameterWrappers(parameterWrapperArrWrapParameters).withMethodWrapper(methodWrapperWithVoid).withTimeStamp(this.timeStamp);
        String currentProcessName = IPCUtils.INSTANCE.getCurrentProcessName();
        Reply replySendCallback = this.baseClientChannel.sendCallback(callbackWithTimeStamp.withCallerProcessName(currentProcessName != null ? currentProcessName : "").withOneway(method.getAnnotation(Oneway.class) != null));
        return replySendCallback == null ? Reply.INSTANCE.obtain() : replySendCallback;
    }

    @Override // com.stepos.deepbinder.core.handler.BaseInvocationHandler
    public void recycleOriginObjects() {
        try {
            IPCLog.INSTANCE.d(TAG, "[recycleOriginObjects] timeStamp=" + this.timeStamp, new Object[0]);
            this.baseClientChannel.recycleClient(new Long[]{Long.valueOf(this.timeStamp)});
        } catch (IPCException e) {
            IPCLog.INSTANCE.w(TAG, "[recycleOriginObjects][error]", e);
        }
    }
}
