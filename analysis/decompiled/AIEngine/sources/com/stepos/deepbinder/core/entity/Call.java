package com.stepos.deepbinder.core.entity;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.cpuset.c;
import com.stepos.deepbinder.core.entity.ext.CallerData;
import com.stepos.deepbinder.core.entity.parser.Parser;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import f.a;
import java.util.HashMap;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class Call implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private static final ObjectPool<Call> pool = new ObjectPool<>(0, new c(8), new o6.a(2), 1, null);
    private boolean autoRecover;
    public CallerData callerData;
    private int dataSize;
    private HashMap<Object, Object> extraInfoMap;
    public MethodWrapper methodWrapper;
    private ParameterWrapper[] parameterWrappers;
    private boolean protocolInvalidFlag;
    private int protocolVersion;
    private final boolean recyclable;
    public ComponentName remoteComponentName;
    public ServiceWrapper serviceWrapper;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CREATOR implements Parcelable.Creator<Call> {
        public /* synthetic */ CREATOR(e eVar) {
            this();
        }

        public final Call create() {
            return new Call(false, null);
        }

        public final Call obtain() {
            return (Call) Call.pool.borrowObject();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Call createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return Parser.INSTANCE.parserCall(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Call[] newArray(int i10) {
            return new Call[i10];
        }
    }

    public /* synthetic */ Call(boolean z, e eVar) {
        this(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n pool$lambda$10(Call call) {
        g.f(call, "call");
        call.protocolVersion = -2;
        call.autoRecover = false;
        call.protocolInvalidFlag = false;
        call.parameterWrappers = null;
        call.extraInfoMap = new HashMap<>();
        call.dataSize = -2;
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Call pool$lambda$9() {
        return new Call(true);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getAutoRecover() {
        return this.autoRecover;
    }

    public final CallerData getCallerData() {
        CallerData callerData = this.callerData;
        if (callerData != null) {
            return callerData;
        }
        g.l("callerData");
        throw null;
    }

    public final int getDataSize() {
        return this.dataSize;
    }

    public final HashMap<Object, Object> getExtraInfoMap() {
        return this.extraInfoMap;
    }

    public final MethodWrapper getMethodWrapper() {
        MethodWrapper methodWrapper = this.methodWrapper;
        if (methodWrapper != null) {
            return methodWrapper;
        }
        g.l("methodWrapper");
        throw null;
    }

    public final ParameterWrapper[] getParameterWrappers() {
        return this.parameterWrappers;
    }

    public final boolean getProtocolInvalidFlag() {
        return this.protocolInvalidFlag;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final ComponentName getRemoteComponentName() {
        ComponentName componentName = this.remoteComponentName;
        if (componentName != null) {
            return componentName;
        }
        g.l("remoteComponentName");
        throw null;
    }

    public final ServiceWrapper getServiceWrapper() {
        ServiceWrapper serviceWrapper = this.serviceWrapper;
        if (serviceWrapper != null) {
            return serviceWrapper;
        }
        g.l("serviceWrapper");
        throw null;
    }

    public final void recycle() {
        if (this.recyclable) {
            pool.returnObject(this);
        }
    }

    public final void setAutoRecover(boolean z) {
        this.autoRecover = z;
    }

    public final void setCallerData(CallerData callerData) {
        g.f(callerData, "<set-?>");
        this.callerData = callerData;
    }

    public final void setDataSize(int i10) {
        this.dataSize = i10;
    }

    public final void setExtraInfoMap(HashMap<Object, Object> map) {
        g.f(map, "<set-?>");
        this.extraInfoMap = map;
    }

    public final void setMethodWrapper(MethodWrapper methodWrapper) {
        g.f(methodWrapper, "<set-?>");
        this.methodWrapper = methodWrapper;
    }

    public final void setParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.parameterWrappers = parameterWrapperArr;
    }

    public final void setProtocolInvalidFlag(boolean z) {
        this.protocolInvalidFlag = z;
    }

    public final void setProtocolVersion(int i10) {
        this.protocolVersion = i10;
    }

    public final void setRemoteComponentName(ComponentName componentName) {
        g.f(componentName, "<set-?>");
        this.remoteComponentName = componentName;
    }

    public final void setServiceWrapper(ServiceWrapper serviceWrapper) {
        g.f(serviceWrapper, "<set-?>");
        this.serviceWrapper = serviceWrapper;
    }

    public final void updateDataSize(int i10) {
        this.dataSize = i10;
    }

    public final Call withAutoRecover(boolean z) {
        this.autoRecover = z;
        return this;
    }

    public final Call withCallerData(CallerData data) {
        g.f(data, "data");
        setCallerData(data);
        return this;
    }

    public final Call withExtraInfoMap(HashMap<Object, Object> map) {
        g.f(map, "map");
        this.extraInfoMap = map;
        return this;
    }

    public final Call withMethodWrapper(MethodWrapper wrapper) {
        g.f(wrapper, "wrapper");
        setMethodWrapper(wrapper);
        return this;
    }

    public final Call withParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.parameterWrappers = parameterWrapperArr;
        return this;
    }

    public final Call withProtocolInvalidFlag(boolean z) {
        this.protocolInvalidFlag = z;
        return this;
    }

    public final Call withProtocolVersion(int i10) {
        this.protocolVersion = i10;
        return this;
    }

    public final Call withRemoteComponentName(ComponentName component) {
        g.f(component, "component");
        setRemoteComponentName(component);
        return this;
    }

    public final Call withServiceWrapper(ServiceWrapper wrapper) {
        g.f(wrapper, "wrapper");
        setServiceWrapper(wrapper);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        Parser.INSTANCE.writeCall(this, parcel, i10);
        recycle();
    }

    private Call(boolean z) {
        this.recyclable = z;
        this.extraInfoMap = new HashMap<>();
    }

    public /* synthetic */ Call(boolean z, int i10, e eVar) {
        this((i10 & 1) != 0 ? true : z);
    }
}
