package com.bytedance.android.live.revlink.aio;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import k11.n;
import k11.o;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/aio/StateTransitionSerializableObjectImpl;", "Lk11/o;", "Lk11/n;", "from", "Lk11/n;", "getFrom", "()Lk11/n;", "M6", "(Lk11/n;)V", RemoteMessageConst.TO, "getTo", "q2", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StateTransitionSerializableObjectImpl implements o {

    @SerializedName("from_state")
    private n from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    @SerializedName("to_state")
    private n f92001to;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/aio/StateTransitionSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(StateTransitionSerializableObjectImpl.class);
        }
    }

    public StateTransitionSerializableObjectImpl() {
    }

    @Override // k11.o
    public final void M6(n r100) {
        this.from = r100;
    }

    @Override // k11.o
    public final void q2(n r100) {
        this.f92001to = r100;
    }
}
