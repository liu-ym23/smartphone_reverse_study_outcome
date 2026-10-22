package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/WantListenInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/jc;", "", "other", "", "equals", "", "hashCode", "", "wantListenCount", "J", "getWantListenCount", "()Ljava/lang/Long;", "setWantListenCount", "(J)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WantListenInfo extends FlexModelBase<jc> implements jc, vh7.h {

    @SerializedName("want_listen_count")
    protected long wantListenCount;

    public WantListenInfo() {
        super(jc.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.jc
    public Long getWantListenCount() {
        return Long.valueOf(this.wantListenCount);
    }

    public int hashCode() {
        long r100 = getWantListenCount().longValue();
        return (int) (r100 ^ (r100 >>> 32));
    }

    public WantListenInfo(am3.g r100) {
        super(jc.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.wantListenCount = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(WantListenInfo.class, r100.getClass())) == false) goto L12;
        return false;
    L12:
        if (getWantListenCount().longValue() == ((WantListenInfo) r100).getWantListenCount().longValue()) goto L14;
        return false;
    L14:
        return true;
    }

    public void setWantListenCount(long r100) {
        this.wantListenCount = r100;
    }
}
