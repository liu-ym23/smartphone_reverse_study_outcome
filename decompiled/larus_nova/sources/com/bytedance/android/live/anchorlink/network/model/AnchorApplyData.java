package com.bytedance.android.live.anchorlink.network.model;

import am3.g;
import com.bytedance.android.livesdk.link.model.bridge.e;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.linkmic.ApplyResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/anchorlink/network/model/AnchorApplyData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/e;", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorApplyData extends FlexModelBase<e> implements e, h {
    public AnchorApplyData() {
        super(e.class);
    }

    public AnchorApplyData(g r100) {
        super(e.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L6;
        am3.h.d(decodeExtensionFields(r102, r100), r100);
        goto L3
    L6:
        r100.d(r101);
        setThreadSafe(true);
    }
}
