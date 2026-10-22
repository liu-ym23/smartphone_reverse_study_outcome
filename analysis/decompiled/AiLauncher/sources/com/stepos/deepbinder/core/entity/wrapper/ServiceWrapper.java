package com.stepos.deepbinder.core.entity.wrapper;

import Y8.t;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00002\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u000fJ\u000f\u0010\u001c\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u00101R\"\u00102\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010.\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u00101R&\u00105\u001a\u0006\u0012\u0002\b\u00030\u00118\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00158\u0006@BX\u0086.¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010(¨\u0006A"}, d2 = {"Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "Lcom/stepos/deepbinder/core/entity/wrapper/BaseWrapper;", "", "recyclable", "<init>", "(Z)V", "", UxipConstants.f30680s, "withTimeStamp", "(J)Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "", "withType", "(I)Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "", "withCallerPackageName", "(Ljava/lang/String;)Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "withCallerProcessName", "Ljava/lang/Class;", "clazz", "withServiceInterfaceClass", "(Ljava/lang/Class;)Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "Landroid/os/IBinder;", "binder", "LY8/t;", "withProxyStateBinder", "(Landroid/os/IBinder;)V", "name", "withServiceName", "toString", "()Ljava/lang/String;", "recycle", "()V", "Z", "timeStamp", "J", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "type", "I", "getType", "()I", "setType", "(I)V", "callerPackageName", "Ljava/lang/String;", "getCallerPackageName", "setCallerPackageName", "(Ljava/lang/String;)V", "callerProcessName", "getCallerProcessName", "setCallerProcessName", "serviceInterfaceClass", "Ljava/lang/Class;", "getServiceInterfaceClass", "()Ljava/lang/Class;", "setServiceInterfaceClass", "(Ljava/lang/Class;)V", "proxyStateBinder", "Landroid/os/IBinder;", "getProxyStateBinder", "()Landroid/os/IBinder;", "recycleCount", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ServiceWrapper extends BaseWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final IBinder binder = new Binder();
    private static final ObjectPool<ServiceWrapper> pool = new ObjectPool<>(0, new InterfaceC5063a() { // from class: j7.e
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ServiceWrapper.pool$lambda$6();
        }
    }, new InterfaceC5074l() { // from class: j7.f
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return ServiceWrapper.pool$lambda$7((ServiceWrapper) obj);
        }
    });
    private String callerPackageName;
    private String callerProcessName;
    private IBinder proxyStateBinder;
    private final boolean recyclable;
    private int recycleCount;
    public Class<?> serviceInterfaceClass;
    private long timeStamp;
    private int type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper$Companion;", "", "<init>", "()V", "binder", "Landroid/os/IBinder;", "getBinder", "()Landroid/os/IBinder;", "pool", "Lcom/stepos/deepbinder/core/entity/pool/ObjectPool;", "Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "create", "obtain", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
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

    public /* synthetic */ ServiceWrapper(boolean z10, i iVar) {
        this(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ServiceWrapper pool$lambda$6() {
        return new ServiceWrapper(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t pool$lambda$7(ServiceWrapper wrapper) {
        p.i(wrapper, "wrapper");
        wrapper.setName("");
        wrapper.timeStamp = -2L;
        wrapper.type = -2;
        wrapper.callerPackageName = "";
        wrapper.callerProcessName = "";
        wrapper.proxyStateBinder = binder;
        return t.f7040a;
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
        p.A("proxyStateBinder");
        return null;
    }

    public final Class<?> getServiceInterfaceClass() {
        Class<?> cls = this.serviceInterfaceClass;
        if (cls != null) {
            return cls;
        }
        p.A("serviceInterfaceClass");
        return null;
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
        p.i(str, "<set-?>");
        this.callerPackageName = str;
    }

    public final void setCallerProcessName(String str) {
        p.i(str, "<set-?>");
        this.callerProcessName = str;
    }

    public final void setServiceInterfaceClass(Class<?> cls) {
        p.i(cls, "<set-?>");
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
        return "ServiceWrapper(name='" + getName() + "', timeStamp=" + this.timeStamp + ", type=" + this.type + ", callerPackageName='" + this.callerPackageName + "', callerProcessName='" + this.callerProcessName + "', serviceInterfaceClass=" + name + ", proxyStateBinder=" + string + ", recycleCount=" + this.recycleCount + ", recyclable=" + this.recyclable + ")";
    }

    public final ServiceWrapper withCallerPackageName(String value) {
        p.i(value, "value");
        this.callerPackageName = value;
        return this;
    }

    public final ServiceWrapper withCallerProcessName(String value) {
        p.i(value, "value");
        this.callerProcessName = value;
        return this;
    }

    public final void withProxyStateBinder(IBinder binder2) {
        p.i(binder2, "binder");
        this.proxyStateBinder = binder2;
    }

    public final ServiceWrapper withServiceInterfaceClass(Class<?> clazz) {
        p.i(clazz, "clazz");
        setServiceInterfaceClass(clazz);
        return this;
    }

    public final ServiceWrapper withServiceName(String name) {
        p.i(name, "name");
        setName(name);
        return this;
    }

    public final ServiceWrapper withTimeStamp(long value) {
        this.timeStamp = value;
        return this;
    }

    public final ServiceWrapper withType(int value) {
        this.type = value;
        return this;
    }

    private ServiceWrapper(boolean z10) {
        this.recyclable = z10;
        this.timeStamp = -2L;
        this.callerPackageName = "";
        this.callerProcessName = "";
    }

    public /* synthetic */ ServiceWrapper(boolean z10, int i10, i iVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
