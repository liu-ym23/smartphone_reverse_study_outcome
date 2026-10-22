package com.bytedance.android.livesdk.multilink.base.model.guestlink;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.linkmic_audience.GuestLinkLeaveChannelResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/guestlink/IGuestLinkLeaveChannelResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/guestlink/d;", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGuestLinkLeaveChannelResponseFlexImpl extends FlexModelBase<d> implements d, h {
    public IGuestLinkLeaveChannelResponseFlexImpl() {
        super(d.class);
    }

    public IGuestLinkLeaveChannelResponseFlexImpl(g r100) {
        super(d.class);
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
