package com.stepos.deepbinder.core.entity;

import C7.r;
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.ext.CallerData;
import com.stepos.deepbinder.core.entity.parser.Parser;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.uxsense.parse.a;
import com.uxsense.parse.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b9\b\u0007\u0018\u0000 i2\u00020\u0001:\u0001iB\u0013\b\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001d\u001a\u00020\u00002\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001d\u0010&\u001a\u00020\u00002\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010\u0011J\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u00002\u0006\u0010 \u001a\u000201¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\f¢\u0006\u0004\b4\u00105R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00106R\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\u0018R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00106\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u0005R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u00106\u001a\u0004\b@\u0010=\"\u0004\bA\u0010\u0005R\"\u0010B\u001a\u0002018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u001f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR*\u0010N\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R>\u0010`\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u00108\u001a\u0004\bg\u0010\b\"\u0004\bh\u0010\u0018¨\u0006j"}, d2 = {"Lcom/stepos/deepbinder/core/entity/Call;", "Landroid/os/Parcelable;", "", "recyclable", AppAgent.CONSTRUCT, "(Z)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "enabled", "withAutoRecover", "(Z)Lcom/stepos/deepbinder/core/entity/Call;", "Lcom/stepos/deepbinder/core/entity/ext/CallerData;", SettingsConfig.KEY_DATA, "withCallerData", "(Lcom/stepos/deepbinder/core/entity/ext/CallerData;)Lcom/stepos/deepbinder/core/entity/Call;", "size", "updateDataSize", "(I)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "withExtraInfoMap", "(Ljava/util/HashMap;)Lcom/stepos/deepbinder/core/entity/Call;", "Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "wrapper", "withMethodWrapper", "(Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;)Lcom/stepos/deepbinder/core/entity/Call;", "", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "wrappers", "withParameterWrappers", "([Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)Lcom/stepos/deepbinder/core/entity/Call;", "flag", "withProtocolInvalidFlag", "version", "withProtocolVersion", "(I)Lcom/stepos/deepbinder/core/entity/Call;", "Landroid/content/ComponentName;", "component", "withRemoteComponentName", "(Landroid/content/ComponentName;)Lcom/stepos/deepbinder/core/entity/Call;", "Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "withServiceWrapper", "(Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;)Lcom/stepos/deepbinder/core/entity/Call;", "recycle", "()V", "Z", Constants.PARAM_PROTOCOL_VERSION, "I", "getProtocolVersion", "setProtocolVersion", "autoRecover", "getAutoRecover", "()Z", "setAutoRecover", "protocolInvalidFlag", "getProtocolInvalidFlag", "setProtocolInvalidFlag", "serviceWrapper", "Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "getServiceWrapper", "()Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "setServiceWrapper", "(Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;)V", "methodWrapper", "Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "getMethodWrapper", "()Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "setMethodWrapper", "(Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;)V", "parameterWrappers", "[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "getParameterWrappers", "()[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "setParameterWrappers", "([Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)V", "callerData", "Lcom/stepos/deepbinder/core/entity/ext/CallerData;", "getCallerData", "()Lcom/stepos/deepbinder/core/entity/ext/CallerData;", "setCallerData", "(Lcom/stepos/deepbinder/core/entity/ext/CallerData;)V", "remoteComponentName", "Landroid/content/ComponentName;", "getRemoteComponentName", "()Landroid/content/ComponentName;", "setRemoteComponentName", "(Landroid/content/ComponentName;)V", "extraInfoMap", "Ljava/util/HashMap;", "getExtraInfoMap", "()Ljava/util/HashMap;", "setExtraInfoMap", "(Ljava/util/HashMap;)V", "dataSize", "getDataSize", "setDataSize", "CREATOR", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Call implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObjectPool<Call> pool = new ObjectPool<>(0, new a(24), new b(28), 1, null);
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

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/deepbinder/core/entity/Call$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/deepbinder/core/entity/Call;", AppAgent.CONSTRUCT, "()V", "pool", "Lcom/stepos/deepbinder/core/entity/pool/ObjectPool;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/stepos/deepbinder/core/entity/Call;", "create", "obtain", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.deepbinder.core.entity.Call$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<Call> {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Call create() {
            return new Call(false, null);
        }

        public final Call obtain() {
            return (Call) Call.pool.borrowObject();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Call createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return Parser.INSTANCE.parserCall(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Call[] newArray(int size) {
            return new Call[size];
        }
    }

    public /* synthetic */ Call(boolean z10, e eVar) {
        this(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r pool$lambda$10(Call call) {
        k.f(call, "call");
        call.protocolVersion = -2;
        call.autoRecover = false;
        call.protocolInvalidFlag = false;
        call.parameterWrappers = null;
        call.extraInfoMap = new HashMap<>();
        call.dataSize = -2;
        return r.f317a;
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
        k.n("callerData");
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
        k.n("methodWrapper");
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
        k.n("remoteComponentName");
        throw null;
    }

    public final ServiceWrapper getServiceWrapper() {
        ServiceWrapper serviceWrapper = this.serviceWrapper;
        if (serviceWrapper != null) {
            return serviceWrapper;
        }
        k.n("serviceWrapper");
        throw null;
    }

    public final void recycle() {
        if (this.recyclable) {
            pool.returnObject(this);
        }
    }

    public final void setAutoRecover(boolean z10) {
        this.autoRecover = z10;
    }

    public final void setCallerData(CallerData callerData) {
        k.f(callerData, "<set-?>");
        this.callerData = callerData;
    }

    public final void setDataSize(int i) {
        this.dataSize = i;
    }

    public final void setExtraInfoMap(HashMap<Object, Object> map) {
        k.f(map, "<set-?>");
        this.extraInfoMap = map;
    }

    public final void setMethodWrapper(MethodWrapper methodWrapper) {
        k.f(methodWrapper, "<set-?>");
        this.methodWrapper = methodWrapper;
    }

    public final void setParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.parameterWrappers = parameterWrapperArr;
    }

    public final void setProtocolInvalidFlag(boolean z10) {
        this.protocolInvalidFlag = z10;
    }

    public final void setProtocolVersion(int i) {
        this.protocolVersion = i;
    }

    public final void setRemoteComponentName(ComponentName componentName) {
        k.f(componentName, "<set-?>");
        this.remoteComponentName = componentName;
    }

    public final void setServiceWrapper(ServiceWrapper serviceWrapper) {
        k.f(serviceWrapper, "<set-?>");
        this.serviceWrapper = serviceWrapper;
    }

    public final void updateDataSize(int size) {
        this.dataSize = size;
    }

    public final Call withAutoRecover(boolean enabled) {
        this.autoRecover = enabled;
        return this;
    }

    public final Call withCallerData(CallerData data) {
        k.f(data, "data");
        setCallerData(data);
        return this;
    }

    public final Call withExtraInfoMap(HashMap<Object, Object> map) {
        k.f(map, "map");
        this.extraInfoMap = map;
        return this;
    }

    public final Call withMethodWrapper(MethodWrapper wrapper) {
        k.f(wrapper, "wrapper");
        setMethodWrapper(wrapper);
        return this;
    }

    public final Call withParameterWrappers(ParameterWrapper[] wrappers) {
        this.parameterWrappers = wrappers;
        return this;
    }

    public final Call withProtocolInvalidFlag(boolean flag) {
        this.protocolInvalidFlag = flag;
        return this;
    }

    public final Call withProtocolVersion(int version) {
        this.protocolVersion = version;
        return this;
    }

    public final Call withRemoteComponentName(ComponentName component) {
        k.f(component, "component");
        setRemoteComponentName(component);
        return this;
    }

    public final Call withServiceWrapper(ServiceWrapper wrapper) {
        k.f(wrapper, "wrapper");
        setServiceWrapper(wrapper);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        Parser.INSTANCE.writeCall(this, parcel, flags);
        recycle();
    }

    private Call(boolean z10) {
        this.recyclable = z10;
        this.extraInfoMap = new HashMap<>();
    }

    public /* synthetic */ Call(boolean z10, int i, e eVar) {
        this((i & 1) != 0 ? true : z10);
    }
}
