package com.stepos.deepbinder.core.entity;

import C7.r;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.parser.Parser;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.uxsense.parse.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b/\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0011\u001a\u00020\u00002\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\n¢\u0006\u0004\b&\u0010\u0003RB\u0010'\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010CR$\u0010D\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006K"}, d2 = {"Lcom/stepos/deepbinder/core/entity/Reply;", "Landroid/os/Parcelable;", AppAgent.CONSTRUCT, "()V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "withExtraInfoMap", "(Ljava/util/HashMap;)Lcom/stepos/deepbinder/core/entity/Reply;", "", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "wrappers", "withFlowParameterWrappers", "([Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)Lcom/stepos/deepbinder/core/entity/Reply;", "Lcom/stepos/deepbinder/core/exception/IPCException;", "exception", "withIPCException", "(Lcom/stepos/deepbinder/core/exception/IPCException;)Lcom/stepos/deepbinder/core/entity/Reply;", "", "time", "withInvokeTime", "(J)Lcom/stepos/deepbinder/core/entity/Reply;", "version", "withProtocolVersion", "(I)Lcom/stepos/deepbinder/core/entity/Reply;", "value", "withResult", "(Ljava/lang/Object;)Lcom/stepos/deepbinder/core/entity/Reply;", "recycle", "extraInfoMap", "Ljava/util/HashMap;", "getExtraInfoMap", "()Ljava/util/HashMap;", "setExtraInfoMap", "(Ljava/util/HashMap;)V", "flowParameterWrappers", "[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "getFlowParameterWrappers", "()[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "setFlowParameterWrappers", "([Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)V", "ipcException", "Lcom/stepos/deepbinder/core/exception/IPCException;", "getIpcException", "()Lcom/stepos/deepbinder/core/exception/IPCException;", "setIpcException", "(Lcom/stepos/deepbinder/core/exception/IPCException;)V", "invokeTime", "J", "getInvokeTime", "()J", "setInvokeTime", "(J)V", Constants.PARAM_PROTOCOL_VERSION, "I", "getProtocolVersion", "setProtocolVersion", "(I)V", "result", "Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "CREATOR", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Reply implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObjectPool<Reply> pool = new ObjectPool<>(0, new a(26), new m5.a(0), 1, null);
    private HashMap<Object, Object> extraInfoMap;
    private ParameterWrapper[] flowParameterWrappers;
    private long invokeTime;
    private IPCException ipcException;
    private int protocolVersion;
    private Object result;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/core/entity/Reply$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/deepbinder/core/entity/Reply;", AppAgent.CONSTRUCT, "()V", "pool", "Lcom/stepos/deepbinder/core/entity/pool/ObjectPool;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/stepos/deepbinder/core/entity/Reply;", "obtain", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.deepbinder.core.entity.Reply$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<Reply> {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Reply obtain() {
            return (Reply) Reply.pool.borrowObject();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reply createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return Parser.INSTANCE.parserReply(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reply[] newArray(int size) {
            return new Reply[size];
        }
    }

    private Reply() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Reply pool$lambda$6() {
        return new Reply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r pool$lambda$8(Reply reply) {
        k.f(reply, "reply");
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
        return r.f317a;
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

    public final void setInvokeTime(long j5) {
        this.invokeTime = j5;
    }

    public final void setIpcException(IPCException iPCException) {
        this.ipcException = iPCException;
    }

    public final void setProtocolVersion(int i) {
        this.protocolVersion = i;
    }

    public final void setResult(Object obj) {
        this.result = obj;
    }

    public final Reply withExtraInfoMap(HashMap<Object, Object> map) {
        k.f(map, "map");
        this.extraInfoMap = map;
        return this;
    }

    public final Reply withFlowParameterWrappers(ParameterWrapper[] wrappers) {
        k.f(wrappers, "wrappers");
        this.flowParameterWrappers = wrappers;
        return this;
    }

    public final Reply withIPCException(IPCException exception) {
        k.f(exception, "exception");
        this.ipcException = exception;
        return this;
    }

    public final Reply withInvokeTime(long time) {
        this.invokeTime = time;
        return this;
    }

    public final Reply withProtocolVersion(int version) {
        this.protocolVersion = version;
        return this;
    }

    public final Reply withResult(Object value) {
        this.result = value;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        Parser.INSTANCE.writeReply(this, dest, flags);
        recycle();
    }
}
