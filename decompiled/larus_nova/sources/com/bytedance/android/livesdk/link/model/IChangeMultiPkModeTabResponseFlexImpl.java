package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.linkmic.ChangeMultiPKModeTabResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IChangeMultiPkModeTabResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/q3;", "Lcom/bytedance/android/livesdk/link/model/e7;", "multiPKModeInfo", "Lcom/bytedance/android/livesdk/link/model/e7;", "getMultiPKModeInfo", "()Lcom/bytedance/android/livesdk/link/model/e7;", "setMultiPKModeInfo", "(Lcom/bytedance/android/livesdk/link/model/e7;)V", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IChangeMultiPkModeTabResponseFlexImpl extends FlexModelBase<q3> implements q3, vh7.h {

    @SerializedName("multi_pk_mode_info")
    protected e7 multiPKModeInfo;

    public IChangeMultiPkModeTabResponseFlexImpl() {
        super(q3.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.link.model.e7, java.lang.Object] */
    public IChangeMultiPkModeTabResponseFlexImpl(am3.g r100) {
        super(q3.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.multiPKModeInfo = vh7.f.a(r100, e7.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.q3
    public e7 getMultiPKModeInfo() {
        return this.multiPKModeInfo;
    }

    public void setMultiPKModeInfo(e7 r100) {
        this.multiPKModeInfo = r100;
    }
}
