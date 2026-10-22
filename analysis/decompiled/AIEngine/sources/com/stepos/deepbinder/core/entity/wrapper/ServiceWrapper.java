package com.stepos.deepbinder.core.entity.wrapper;

import android.os.Binder;
import android.os.IBinder;
import com.stepos.core.ota.d;
import com.stepos.cpuset.c;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import f.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class ServiceWrapper extends BaseWrapper {
    public static final Companion Companion = new Companion(null);
    private static final IBinder binder = new Binder();
    private static final ObjectPool<ServiceWrapper> pool = new ObjectPool<>(0, new c(13), new o6.a(7));
    private String callerPackageName;
    private String callerProcessName;
    private IBinder proxyStateBinder;
    private final boolean recyclable;
    private int recycleCount;
    public Class<?> serviceInterfaceClass;
    private long timeStamp;
    private int type;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ServiceWrapper create() {
            return new ServiceWrapper(false, null);
        }

        public final IBinder getBinder() {
            return ServiceWrapper.binder;
        }

        public final ServiceWrapper obtain() {
            return (ServiceWrapper) ServiceWrapper.pool.borrowObject();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ServiceWrapper(boolean z, e eVar) {
        this(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ServiceWrapper pool$lambda$6() {
        return new ServiceWrapper(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n pool$lambda$7(ServiceWrapper wrapper) {
        g.f(wrapper, "wrapper");
        wrapper.setName("");
        wrapper.timeStamp = -2L;
        wrapper.type = -2;
        wrapper.callerPackageName = "";
        wrapper.callerProcessName = "";
        wrapper.proxyStateBinder = binder;
        return n.f10413a;
    }

    public final String getCallerPackageName() {
        return this.callerPackageName;
    }

    public final String getCallerProcessName() {
        return this.callerProcessName;
    }

    public final IBinder getProxyStateBinder() {
        IBinder iBinder = this.proxyStateBinder;
        if (iBinder != null) {
            return iBinder;
        }
        g.l("proxyStateBinder");
        throw null;
    }

    public final Class<?> getServiceInterfaceClass() {
        Class<?> cls = this.serviceInterfaceClass;
        if (cls != null) {
            return cls;
        }
        g.l("serviceInterfaceClass");
        throw null;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.stepos.deepbinder.core.entity.wrapper.BaseWrapper
    public void recycle() {
        if (this.recyclable) {
            this.recycleCount++;
            pool.returnObject(this);
        }
    }

    public final void setCallerPackageName(String str) {
        g.f(str, "<set-?>");
        this.callerPackageName = str;
    }

    public final void setCallerProcessName(String str) {
        g.f(str, "<set-?>");
        this.callerProcessName = str;
    }

    public final void setServiceInterfaceClass(Class<?> cls) {
        g.f(cls, "<set-?>");
        this.serviceInterfaceClass = cls;
    }

    public final void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public String toString() {
        String name = this.serviceInterfaceClass != null ? getServiceInterfaceClass().getName() : "未初始化";
        String string = this.proxyStateBinder != null ? getProxyStateBinder().toString() : "未初始化";
        String name2 = getName();
        long j10 = this.timeStamp;
        int i10 = this.type;
        String str = this.callerPackageName;
        String str2 = this.callerProcessName;
        int i11 = this.recycleCount;
        boolean z = this.recyclable;
        StringBuilder sbL = d.l("ServiceWrapper(name='", j10, name2, "', timeStamp=");
        sbL.append(", type=");
        sbL.append(i10);
        sbL.append(", callerPackageName='");
        sbL.append(str);
        ai.onnxruntime.a.z(sbL, "', callerProcessName='", str2, "', serviceInterfaceClass=", name);
        sbL.append(", proxyStateBinder=");
        sbL.append(string);
        sbL.append(", recycleCount=");
        sbL.append(i11);
        sbL.append(", recyclable=");
        sbL.append(z);
        sbL.append(")");
        return sbL.toString();
    }

    public final ServiceWrapper withCallerPackageName(String value) {
        g.f(value, "value");
        this.callerPackageName = value;
        return this;
    }

    public final ServiceWrapper withCallerProcessName(String value) {
        g.f(value, "value");
        this.callerProcessName = value;
        return this;
    }

    public final void withProxyStateBinder(IBinder binder2) {
        g.f(binder2, "binder");
        this.proxyStateBinder = binder2;
    }

    public final ServiceWrapper withServiceInterfaceClass(Class<?> clazz) {
        g.f(clazz, "clazz");
        setServiceInterfaceClass(clazz);
        return this;
    }

    public final ServiceWrapper withServiceName(String name) {
        g.f(name, "name");
        setName(name);
        return this;
    }

    public final ServiceWrapper withTimeStamp(long j10) {
        this.timeStamp = j10;
        return this;
    }

    public final ServiceWrapper withType(int i10) {
        this.type = i10;
        return this;
    }

    private ServiceWrapper(boolean z) {
        this.recyclable = z;
        this.timeStamp = -2L;
        this.callerPackageName = "";
        this.callerProcessName = "";
    }

    public /* synthetic */ ServiceWrapper(boolean z, int i10, e eVar) {
        this((i10 & 1) != 0 ? true : z);
    }
}
