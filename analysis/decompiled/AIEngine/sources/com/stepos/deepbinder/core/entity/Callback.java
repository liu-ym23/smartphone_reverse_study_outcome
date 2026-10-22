package com.stepos.deepbinder.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.cpuset.c;
import com.stepos.deepbinder.core.entity.parser.Parser;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import f.a;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class Callback implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private static final ObjectPool<Callback> pool = new ObjectPool<>(100, new c(9), new o6.a(3));
    private String callerProcessName;
    private int dataSize;
    private HashMap<String, Object> extraInfoMap;
    private boolean isOneway;
    private MethodWrapper methodWrapper;
    private ParameterWrapper[] parameterWrappers;
    private int protocolVersion;
    private long timeStamp;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CREATOR implements Parcelable.Creator<Callback> {
        public /* synthetic */ CREATOR(e eVar) {
            this();
        }

        public final Callback obtain() {
            return (Callback) Callback.pool.borrowObject();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Callback createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return Parser.INSTANCE.parserCallback(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Callback[] newArray(int i10) {
            return new Callback[i10];
        }
    }

    private Callback() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Callback pool$lambda$7() {
        return new Callback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n pool$lambda$9(Callback callback) {
        g.f(callback, "callback");
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
        return n.f10413a;
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

    public final boolean isOneway() {
        return this.isOneway;
    }

    public final void recycle() {
        pool.returnObject(this);
    }

    public final void setCallerProcessName(String str) {
        this.callerProcessName = str;
    }

    public final void setDataSize(int i10) {
        this.dataSize = i10;
    }

    public final void setExtraInfoMap(HashMap<String, Object> map) {
        this.extraInfoMap = map;
    }

    public final void setMethodWrapper(MethodWrapper methodWrapper) {
        this.methodWrapper = methodWrapper;
    }

    public final void setOneway(boolean z) {
        this.isOneway = z;
    }

    public final void setParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.parameterWrappers = parameterWrapperArr;
    }

    public final void setProtocolVersion(int i10) {
        this.protocolVersion = i10;
    }

    public final void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public String toString() {
        String string;
        long j10 = this.timeStamp;
        MethodWrapper methodWrapper = this.methodWrapper;
        ParameterWrapper[] parameterWrapperArr = this.parameterWrappers;
        if (parameterWrapperArr != null) {
            string = Arrays.toString(parameterWrapperArr);
            g.e(string, "toString(...)");
        } else {
            string = null;
        }
        String str = this.callerProcessName;
        int i10 = this.dataSize;
        boolean z = this.isOneway;
        HashMap<String, Object> map = this.extraInfoMap;
        int i11 = this.protocolVersion;
        StringBuilder sb2 = new StringBuilder("Callback(timeStamp=");
        sb2.append(j10);
        sb2.append(", methodWrapper=");
        sb2.append(methodWrapper);
        ai.onnxruntime.a.z(sb2, ", parameterWrappers=", string, ", callerProcessName='", str);
        sb2.append("', dataSize=");
        sb2.append(i10);
        sb2.append(", isOneway=");
        sb2.append(z);
        sb2.append(", extraInfoMap=");
        sb2.append(map);
        sb2.append(", protocolVersion=");
        sb2.append(i11);
        sb2.append(")");
        return sb2.toString();
    }

    public final void updateDataSize(int i10) {
        this.dataSize = i10;
    }

    public final Callback withCallerProcessName(String name) {
        g.f(name, "name");
        this.callerProcessName = name;
        return this;
    }

    public final Callback withExtraInfoMap(HashMap<String, Object> map) {
        g.f(map, "map");
        this.extraInfoMap = map;
        return this;
    }

    public final Callback withMethodWrapper(MethodWrapper wrapper) {
        g.f(wrapper, "wrapper");
        this.methodWrapper = wrapper;
        return this;
    }

    public final Callback withOneway(boolean z) {
        this.isOneway = z;
        return this;
    }

    public final Callback withParameterWrappers(ParameterWrapper[] wrappers) {
        g.f(wrappers, "wrappers");
        this.parameterWrappers = wrappers;
        return this;
    }

    public final Callback withProtocolVersion(int i10) {
        this.protocolVersion = i10;
        return this;
    }

    public final Callback withTimeStamp(long j10) {
        this.timeStamp = j10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        Parser.INSTANCE.writeCallback(this, dest, i10);
        recycle();
    }
}
