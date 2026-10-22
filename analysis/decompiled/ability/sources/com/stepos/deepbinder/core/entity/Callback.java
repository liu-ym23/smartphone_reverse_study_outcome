package com.stepos.deepbinder.core.entity;

import C7.r;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.parser.Parser;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.uxsense.parse.a;
import com.uxsense.parse.b;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b1\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0001ZB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0018\u001a\u00020\u00002\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015`\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001b\u0010%\u001a\u00020\u00002\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\n¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\rH\u0016¢\u0006\u0004\b/\u00100R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R*\u0010=\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010C\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u00100\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\u0013R\"\u0010L\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bL\u0010N\"\u0004\bO\u0010PRB\u0010Q\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010I\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\u0013¨\u0006["}, d2 = {"Lcom/stepos/deepbinder/core/entity/Callback;", "Landroid/os/Parcelable;", AppAgent.CONSTRUCT, "()V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", HintConstants.AUTOFILL_HINT_NAME, "withCallerProcessName", "(Ljava/lang/String;)Lcom/stepos/deepbinder/core/entity/Callback;", "size", "updateDataSize", "(I)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "withExtraInfoMap", "(Ljava/util/HashMap;)Lcom/stepos/deepbinder/core/entity/Callback;", "Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "wrapper", "withMethodWrapper", "(Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;)Lcom/stepos/deepbinder/core/entity/Callback;", "", "oneway", "withOneway", "(Z)Lcom/stepos/deepbinder/core/entity/Callback;", "", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "wrappers", "withParameterWrappers", "([Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)Lcom/stepos/deepbinder/core/entity/Callback;", "version", "withProtocolVersion", "(I)Lcom/stepos/deepbinder/core/entity/Callback;", "", "stamp", "withTimeStamp", "(J)Lcom/stepos/deepbinder/core/entity/Callback;", "recycle", "toString", "()Ljava/lang/String;", "timeStamp", "J", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "methodWrapper", "Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "getMethodWrapper", "()Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "setMethodWrapper", "(Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;)V", "parameterWrappers", "[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "getParameterWrappers", "()[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "setParameterWrappers", "([Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)V", "callerProcessName", "Ljava/lang/String;", "getCallerProcessName", "setCallerProcessName", "(Ljava/lang/String;)V", "dataSize", "I", "getDataSize", "setDataSize", "isOneway", "Z", "()Z", "setOneway", "(Z)V", "extraInfoMap", "Ljava/util/HashMap;", "getExtraInfoMap", "()Ljava/util/HashMap;", "setExtraInfoMap", "(Ljava/util/HashMap;)V", Constants.PARAM_PROTOCOL_VERSION, "getProtocolVersion", "setProtocolVersion", "CREATOR", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Callback implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObjectPool<Callback> pool = new ObjectPool<>(100, new a(25), new b(29));
    private String callerProcessName;
    private int dataSize;
    private HashMap<String, Object> extraInfoMap;
    private boolean isOneway;
    private MethodWrapper methodWrapper;
    private ParameterWrapper[] parameterWrappers;
    private int protocolVersion;
    private long timeStamp;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/core/entity/Callback$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/deepbinder/core/entity/Callback;", AppAgent.CONSTRUCT, "()V", "pool", "Lcom/stepos/deepbinder/core/entity/pool/ObjectPool;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/stepos/deepbinder/core/entity/Callback;", "obtain", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.deepbinder.core.entity.Callback$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<Callback> {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Callback obtain() {
            return (Callback) Callback.pool.borrowObject();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Callback createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return Parser.INSTANCE.parserCallback(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Callback[] newArray(int size) {
            return new Callback[size];
        }
    }

    private Callback() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Callback pool$lambda$7() {
        return new Callback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r pool$lambda$9(Callback callback) {
        k.f(callback, "callback");
        callback.timeStamp = -2L;
        MethodWrapper methodWrapper = callback.methodWrapper;
        if (methodWrapper != null) {
            methodWrapper.recycle();
        }
        callback.methodWrapper = null;
        ParameterWrapper[] parameterWrapperArr = callback.parameterWrappers;
        if (parameterWrapperArr != null) {
            for (ParameterWrapper parameterWrapper : parameterWrapperArr) {
                parameterWrapper.recycle();
            }
        }
        callback.parameterWrappers = null;
        callback.callerProcessName = null;
        callback.dataSize = -2;
        callback.isOneway = false;
        callback.extraInfoMap = null;
        callback.protocolVersion = -2;
        return r.f317a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getCallerProcessName() {
        return this.callerProcessName;
    }

    public final int getDataSize() {
        return this.dataSize;
    }

    public final HashMap<String, Object> getExtraInfoMap() {
        return this.extraInfoMap;
    }

    public final MethodWrapper getMethodWrapper() {
        return this.methodWrapper;
    }

    public final ParameterWrapper[] getParameterWrappers() {
        return this.parameterWrappers;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: isOneway, reason: from getter */
    public final boolean getIsOneway() {
        return this.isOneway;
    }

    public final void recycle() {
        pool.returnObject(this);
    }

    public final void setCallerProcessName(String str) {
        this.callerProcessName = str;
    }

    public final void setDataSize(int i) {
        this.dataSize = i;
    }

    public final void setExtraInfoMap(HashMap<String, Object> map) {
        this.extraInfoMap = map;
    }

    public final void setMethodWrapper(MethodWrapper methodWrapper) {
        this.methodWrapper = methodWrapper;
    }

    public final void setOneway(boolean z10) {
        this.isOneway = z10;
    }

    public final void setParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.parameterWrappers = parameterWrapperArr;
    }

    public final void setProtocolVersion(int i) {
        this.protocolVersion = i;
    }

    public final void setTimeStamp(long j5) {
        this.timeStamp = j5;
    }

    public String toString() {
        String string;
        long j5 = this.timeStamp;
        MethodWrapper methodWrapper = this.methodWrapper;
        ParameterWrapper[] parameterWrapperArr = this.parameterWrappers;
        if (parameterWrapperArr != null) {
            string = Arrays.toString(parameterWrapperArr);
            k.e(string, "toString(...)");
        } else {
            string = null;
        }
        String str = this.callerProcessName;
        int i = this.dataSize;
        boolean z10 = this.isOneway;
        HashMap<String, Object> map = this.extraInfoMap;
        int i6 = this.protocolVersion;
        StringBuilder sb = new StringBuilder("Callback(timeStamp=");
        sb.append(j5);
        sb.append(", methodWrapper=");
        sb.append(methodWrapper);
        androidx.constraintlayout.core.dsl.a.A(sb, ", parameterWrappers=", string, ", callerProcessName='", str);
        sb.append("', dataSize=");
        sb.append(i);
        sb.append(", isOneway=");
        sb.append(z10);
        sb.append(", extraInfoMap=");
        sb.append(map);
        sb.append(", protocolVersion=");
        sb.append(i6);
        sb.append(")");
        return sb.toString();
    }

    public final void updateDataSize(int size) {
        this.dataSize = size;
    }

    public final Callback withCallerProcessName(String name) {
        k.f(name, "name");
        this.callerProcessName = name;
        return this;
    }

    public final Callback withExtraInfoMap(HashMap<String, Object> map) {
        k.f(map, "map");
        this.extraInfoMap = map;
        return this;
    }

    public final Callback withMethodWrapper(MethodWrapper wrapper) {
        k.f(wrapper, "wrapper");
        this.methodWrapper = wrapper;
        return this;
    }

    public final Callback withOneway(boolean oneway) {
        this.isOneway = oneway;
        return this;
    }

    public final Callback withParameterWrappers(ParameterWrapper[] wrappers) {
        k.f(wrappers, "wrappers");
        this.parameterWrappers = wrappers;
        return this;
    }

    public final Callback withProtocolVersion(int version) {
        this.protocolVersion = version;
        return this;
    }

    public final Callback withTimeStamp(long stamp) {
        this.timeStamp = stamp;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        Parser.INSTANCE.writeCallback(this, dest, flags);
        recycle();
    }
}
