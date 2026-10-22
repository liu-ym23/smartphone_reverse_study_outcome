package com.stepos.deepbinder.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.cpuset.c;
import com.stepos.deepbinder.core.entity.parser.Parser;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import f.a;
import java.util.HashMap;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class Reply implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private static final ObjectPool<Reply> pool = new ObjectPool<>(0, new c(10), new o6.a(4), 1, null);
    private HashMap<Object, Object> extraInfoMap;
    private ParameterWrapper[] flowParameterWrappers;
    private long invokeTime;
    private IPCException ipcException;
    private int protocolVersion;
    private Object result;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CREATOR implements Parcelable.Creator<Reply> {
        public /* synthetic */ CREATOR(e eVar) {
            this();
        }

        public final Reply obtain() {
            return (Reply) Reply.pool.borrowObject();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reply createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return Parser.INSTANCE.parserReply(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reply[] newArray(int i10) {
            return new Reply[i10];
        }
    }

    private Reply() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Reply pool$lambda$6() {
        return new Reply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n pool$lambda$8(Reply reply) {
        g.f(reply, "reply");
        reply.extraInfoMap = null;
        ParameterWrapper[] parameterWrapperArr = reply.flowParameterWrappers;
        if (parameterWrapperArr != null) {
            for (ParameterWrapper parameterWrapper : parameterWrapperArr) {
                parameterWrapper.recycle();
            }
        }
        reply.flowParameterWrappers = null;
        reply.ipcException = null;
        reply.invokeTime = 0L;
        reply.protocolVersion = 0;
        reply.result = null;
        return n.f10413a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final HashMap<Object, Object> getExtraInfoMap() {
        return this.extraInfoMap;
    }

    public final ParameterWrapper[] getFlowParameterWrappers() {
        return this.flowParameterWrappers;
    }

    public final long getInvokeTime() {
        return this.invokeTime;
    }

    public final IPCException getIpcException() {
        return this.ipcException;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final Object getResult() {
        return this.result;
    }

    public final void recycle() {
        pool.returnObject(this);
    }

    public final void setExtraInfoMap(HashMap<Object, Object> map) {
        this.extraInfoMap = map;
    }

    public final void setFlowParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.flowParameterWrappers = parameterWrapperArr;
    }

    public final void setInvokeTime(long j10) {
        this.invokeTime = j10;
    }

    public final void setIpcException(IPCException iPCException) {
        this.ipcException = iPCException;
    }

    public final void setProtocolVersion(int i10) {
        this.protocolVersion = i10;
    }

    public final void setResult(Object obj) {
        this.result = obj;
    }

    public final Reply withExtraInfoMap(HashMap<Object, Object> map) {
        g.f(map, "map");
        this.extraInfoMap = map;
        return this;
    }

    public final Reply withFlowParameterWrappers(ParameterWrapper[] wrappers) {
        g.f(wrappers, "wrappers");
        this.flowParameterWrappers = wrappers;
        return this;
    }

    public final Reply withIPCException(IPCException exception) {
        g.f(exception, "exception");
        this.ipcException = exception;
        return this;
    }

    public final Reply withInvokeTime(long j10) {
        this.invokeTime = j10;
        return this;
    }

    public final Reply withProtocolVersion(int i10) {
        this.protocolVersion = i10;
        return this;
    }

    public final Reply withResult(Object obj) {
        this.result = obj;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        Parser.INSTANCE.writeReply(this, dest, i10);
        recycle();
    }
}
