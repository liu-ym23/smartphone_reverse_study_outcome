package l9;

import android.content.ComponentName;
import com.stepos.deepbinder.annotation.method.MethodName;
import com.stepos.deepbinder.annotation.method.Oneway;
import com.stepos.deepbinder.annotation.method.Synchronize;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.handler.BaseInvocationHandler;
import com.stepos.deepbinder.core.log.IPCLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import x9.c;
import x9.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends BaseInvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final Call f10370a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10371b;

    /* renamed from: c, reason: collision with root package name */
    public final com.stepos.deepbinder.client.channel.remote.a f10372c;

    /* renamed from: d, reason: collision with root package name */
    public final ComponentName f10373d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10374e;

    /* renamed from: f, reason: collision with root package name */
    public final ServiceWrapper f10375f;

    /* renamed from: g, reason: collision with root package name */
    public C0107a f10376g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: l9.a$a, reason: collision with other inner class name */
    public static final class C0107a implements ProviderStateListener {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<a> f10377a;

        public C0107a(a aVar) {
            this.f10377a = new WeakReference<>(aVar);
        }

        @Override // com.stepos.deepbinder.client.api.ProviderStateListener
        public final void onProviderStart(ComponentName componentName) {
            g.f(componentName, "componentName");
        }

        @Override // com.stepos.deepbinder.client.api.ProviderStateListener
        public final void onProviderStop(ComponentName componentName) {
            AtomicBoolean atomicBooleanIsCleaned;
            g.f(componentName, "componentName");
            a aVar = this.f10377a.get();
            if (aVar == null || (atomicBooleanIsCleaned = aVar.isCleaned()) == null) {
                return;
            }
            atomicBooleanIsCleaned.set(true);
        }
    }

    public a(Call call) {
        this.f10370a = call;
        ComponentName remoteComponentName = call.getRemoteComponentName();
        this.f10373d = remoteComponentName;
        ServiceWrapper serviceWrapperWithType = ServiceWrapper.Companion.create().withTimeStamp(call.getServiceWrapper().getTimeStamp()).withServiceInterfaceClass(call.getServiceWrapper().getServiceInterfaceClass()).withServiceName(call.getServiceWrapper().getName()).withCallerPackageName(call.getServiceWrapper().getCallerPackageName()).withCallerProcessName(call.getServiceWrapper().getCallerProcessName()).withType(call.getServiceWrapper().getType() == 1 ? 4 : 3);
        this.f10375f = serviceWrapperWithType;
        this.f10372c = j9.a.f9742a.a(remoteComponentName);
        this.f10371b = ((AutoRecover) serviceWrapperWithType.getServiceInterfaceClass().getAnnotation(AutoRecover.class)) != null;
        String str = c.c(remoteComponentName).f13759a;
        g.c(str);
        this.f10374e = str;
        C0107a c0107a = new C0107a(this);
        i9.a.f9578a.add(c0107a);
        this.f10376g = c0107a;
    }

    @Override // com.stepos.deepbinder.core.handler.BaseInvocationHandler
    public final Reply internalInvoke(Method method, Object[] args) {
        String name;
        String name2;
        g.f(method, "method");
        g.f(args, "args");
        MethodName methodName = (MethodName) method.getAnnotation(MethodName.class);
        Synchronize synchronize = (Synchronize) method.getAnnotation(Synchronize.class);
        Oneway oneway = (Oneway) method.getAnnotation(Oneway.class);
        Class<?> returnType = method.getReturnType();
        g.e(returnType, "getReturnType(...)");
        boolean zB = g.b(Void.TYPE, returnType);
        ParameterWrapper[] parameterWrapperArrD = e.d(this.f10374e, method, args);
        MethodWrapper methodWrapperObtain = MethodWrapper.Companion.obtain();
        if (methodName == null || (name = methodName.value()) == null) {
            name = method.getName();
        }
        g.c(name);
        MethodWrapper methodWrapperWithVoid = methodWrapperObtain.withMethodName(name).withSync(synchronize != null).withOneway(oneway != null).withVoid(zB);
        if (zB) {
            name2 = null;
        } else {
            Class<?> returnType2 = method.getReturnType();
            g.e(returnType2, "getReturnType(...)");
            name2 = returnType2.getName();
        }
        Call callWithAutoRecover = Call.CREATOR.obtain().withProtocolVersion(this.f10370a.getProtocolVersion()).withServiceWrapper(this.f10375f).withParameterWrappers(parameterWrapperArrD).withMethodWrapper(methodWrapperWithVoid.withReturnType(name2)).withRemoteComponentName(this.f10373d).withAutoRecover(this.f10371b);
        try {
            return this.f10372c.sendCall(callWithAutoRecover);
        } catch (IPCException e10) {
            if (!callWithAutoRecover.getAutoRecover() || e10.getErrorCode() != 22) {
                throw e10;
            }
            synchronized (this) {
                try {
                    if (callWithAutoRecover.getServiceWrapper().getType() == 4 || g.b(String.valueOf(this.f10375f.getTimeStamp()), e10.getExtraErrorData())) {
                        long jA = w9.g.f13619a.a();
                        this.f10370a.getServiceWrapper().withTimeStamp(jA);
                        this.f10372c.sendCall(this.f10370a);
                        this.f10375f.withTimeStamp(jA);
                        callWithAutoRecover.setAutoRecover(false);
                    }
                    return this.f10372c.sendCall(callWithAutoRecover);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.stepos.deepbinder.core.handler.BaseInvocationHandler
    public final void recycleOriginObjects() {
        Call call = this.f10370a;
        try {
            IPCLog.INSTANCE.d("MethodInvocationHandler", "[recycleOriginObjects]", "timeStamp", Long.valueOf(call.getServiceWrapper().getTimeStamp()), "isCleaned", Boolean.valueOf(isCleaned().get()));
            C0107a c0107a = this.f10376g;
            if (c0107a != null) {
                CopyOnWriteArrayList<ProviderStateListener> copyOnWriteArrayList = i9.a.f9578a;
                CopyOnWriteArrayList<ProviderStateListener> copyOnWriteArrayList2 = i9.a.f9578a;
                copyOnWriteArrayList2.remove(c0107a);
                if (copyOnWriteArrayList2.isEmpty()) {
                    i9.a.f9579b.clear();
                }
                this.f10376g = null;
            }
            if (isCleaned().get()) {
                return;
            }
            this.f10372c.recycleRemote(new Long[]{Long.valueOf(call.getServiceWrapper().getTimeStamp())});
        } catch (IPCException e10) {
            IPCLog.INSTANCE.w("MethodInvocationHandler", "[recycleOriginObjects][error]", "exception", e10);
        }
    }
}
