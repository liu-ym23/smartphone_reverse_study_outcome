package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.PreRTCLinkUserInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/IPreRTCLinkUserInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/z1;", "", "rtcPushStream$delegate", "Ljava/lang/Object;", "getRtcPushStream", "()Z", "rtcPushStream", "", "linkmicIdStr$delegate", "getLinkmicIdStr", "()Ljava/lang/String;", "linkmicIdStr", "", "linkStatus$delegate", "getLinkStatus", "()I", "linkStatus", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPreRTCLinkUserInfoFlexImpl extends FlexModelBase<z1> implements z1, vh7.h {

    @SerializedName("link_status")
    protected int _$$linkStatus;

    @SerializedName("linkmic_id_str")
    protected String _$$linkmicIdStr;

    @SerializedName("rtc_push_stream")
    protected boolean _$$rtcPushStream;

    public IPreRTCLinkUserInfoFlexImpl() {
        super(z1.class);
        this._$$rtcPushStream = false;
        this._$$linkmicIdStr = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z1
    public final int getLinkStatus() {
        return this._$$linkStatus;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z1
    public final String getLinkmicIdStr() {
        return this._$$linkmicIdStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z1
    public final boolean getRtcPushStream() {
        return this._$$rtcPushStream;
    }

    public IPreRTCLinkUserInfoFlexImpl(am3.g r100) {
        super(z1.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$rtcPushStream = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$linkmicIdStr = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this._$$linkStatus = r100.i();
        r102 = r102 | 2;
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L19;
        this._$$rtcPushStream = false;
    L19:
        if (this._$$linkmicIdStr != null) goto L34;
        this._$$linkmicIdStr = "";
        return;
    }
}
