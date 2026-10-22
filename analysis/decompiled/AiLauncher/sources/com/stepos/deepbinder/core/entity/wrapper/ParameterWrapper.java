package com.stepos.deepbinder.core.entity.wrapper;

import Y8.t;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.utils.TypeUtils;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00101\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "Lcom/stepos/deepbinder/core/entity/wrapper/BaseWrapper;", "<init>", "()V", "Landroid/os/IBinder;", "binder", "withClientServiceBinder", "(Landroid/os/IBinder;)Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "", UxipConstants.f30680s, "withData", "(Ljava/lang/Object;)Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "", "flag", "withFlowFlag", "(I)Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "withHashCodeValue", "", "name", "withParameterName", "(Ljava/lang/String;)Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "", "withTimeStamp", "(J)Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "LY8/t;", "recycle", "toString", "()Ljava/lang/String;", "clientServiceBinder", "Landroid/os/IBinder;", "getClientServiceBinder", "()Landroid/os/IBinder;", "setClientServiceBinder", "(Landroid/os/IBinder;)V", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "flowFlag", "I", "getFlowFlag", "()I", "setFlowFlag", "(I)V", "hashCodeValue", "getHashCodeValue", "setHashCodeValue", "timeStamp", "J", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ParameterWrapper extends BaseWrapper {
    private static final String TAG = "ParameterWrapper";
    private IBinder clientServiceBinder;
    private Object data;
    private int flowFlag;
    private int hashCodeValue;
    private long timeStamp;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObjectPool<ParameterWrapper> pool = new ObjectPool<>(F.GESTURE_HEIGHT_DP, new InterfaceC5063a() { // from class: j7.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ParameterWrapper.pool$lambda$6();
        }
    }, new InterfaceC5074l() { // from class: j7.d
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return ParameterWrapper.pool$lambda$7((ParameterWrapper) obj);
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper$Companion;", "", "<init>", "()V", "TAG", "", "pool", "Lcom/stepos/deepbinder/core/entity/pool/ObjectPool;", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "obtain", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final ParameterWrapper obtain() {
            return (ParameterWrapper) ParameterWrapper.pool.borrowObject();
        }

        private Companion() {
        }
    }

    private ParameterWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterWrapper pool$lambda$6() {
        return new ParameterWrapper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t pool$lambda$7(ParameterWrapper wrapper) {
        p.i(wrapper, "wrapper");
        wrapper.setName("");
        wrapper.clientServiceBinder = null;
        wrapper.data = null;
        wrapper.flowFlag = -1;
        wrapper.hashCodeValue = -1;
        wrapper.timeStamp = -1L;
        return t.f7040a;
    }

    public final IBinder getClientServiceBinder() {
        return this.clientServiceBinder;
    }

    public final Object getData() {
        return this.data;
    }

    public final int getFlowFlag() {
        return this.flowFlag;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    @Override // com.stepos.deepbinder.core.entity.wrapper.BaseWrapper
    public void recycle() {
        pool.returnObject(this);
    }

    public final void setClientServiceBinder(IBinder iBinder) {
        this.clientServiceBinder = iBinder;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final void setFlowFlag(int i10) {
        this.flowFlag = i10;
    }

    public final void setHashCodeValue(int i10) {
        this.hashCodeValue = i10;
    }

    public final void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public String toString() {
        return "ParameterWrapper(name='" + getName() + "', flowFlag=" + this.flowFlag + ", hashCodeValue=" + this.hashCodeValue + ", timeStamp=" + this.timeStamp + ", hasData=" + (this.data != null) + ")";
    }

    public final ParameterWrapper withClientServiceBinder(IBinder binder) {
        this.clientServiceBinder = binder;
        return this;
    }

    public final ParameterWrapper withData(Object value) {
        this.data = value;
        if (value != null) {
            Class<?> cls = value.getClass();
            if (this.flowFlag == 1) {
                if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType == null) {
                        componentType = Object.class;
                    }
                    TypeUtils typeUtils = TypeUtils.INSTANCE;
                    String name = cls.getName();
                    p.h(name, "getName(...)");
                    this.data = Array.newInstance(componentType, typeUtils.getObjectArraySize(name, value));
                } else if (List.class.isAssignableFrom(cls)) {
                    this.data = new ArrayList();
                } else if (Map.class.isAssignableFrom(cls)) {
                    this.data = new HashMap();
                } else {
                    try {
                        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(null);
                        declaredConstructor.setAccessible(true);
                        this.data = declaredConstructor.newInstance(null);
                    } catch (Throwable th) {
                        IPCLog.INSTANCE.w(TAG, "[setData][newInstance]", th);
                    }
                }
            }
        }
        return this;
    }

    public final ParameterWrapper withFlowFlag(int flag) {
        this.flowFlag = flag;
        return this;
    }

    public final ParameterWrapper withHashCodeValue(int value) {
        this.hashCodeValue = value;
        return this;
    }

    public final ParameterWrapper withParameterName(String name) {
        p.i(name, "name");
        setName(name);
        return this;
    }

    public final ParameterWrapper withTimeStamp(long value) {
        this.timeStamp = value;
        return this;
    }
}
