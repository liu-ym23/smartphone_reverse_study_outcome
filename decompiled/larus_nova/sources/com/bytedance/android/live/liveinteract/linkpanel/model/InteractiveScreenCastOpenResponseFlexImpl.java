package com.bytedance.android.live.liveinteract.linkpanel.model;

import am3.g;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.linkmic_profit.InteractiveScreenCastOpenResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR+\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/model/InteractiveScreenCastOpenResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/linkpanel/model/b;", "", "<set-?>", "rtcExtInfo$delegate", "Ljava/lang/Object;", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "rtcExtInfo", "liveCoreExtInfo$delegate", "getLiveCoreExtInfo", "setLiveCoreExtInfo", "liveCoreExtInfo", "", "targetUiLayout$delegate", "getTargetUiLayout", "()J", "setTargetUiLayout", "(J)V", "targetUiLayout", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "castInfo$delegate", "getCastInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "setCastInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;)V", "castInfo", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractiveScreenCastOpenResponseFlexImpl extends FlexModelBase<b> implements b, h {

    @SerializedName("screen_cast_info")
    protected s0 _$$castInfo;

    @SerializedName("live_core_ext_info")
    protected String _$$liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String _$$rtcExtInfo;

    @SerializedName("target_ui_layout")
    protected long _$$targetUiLayout;

    public InteractiveScreenCastOpenResponseFlexImpl() {
        super(b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.model.b
    public final s0 getCastInfo() {
        return this._$$castInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.model.b
    public final String getLiveCoreExtInfo() {
        return this._$$liveCoreExtInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.model.b
    public final String getRtcExtInfo() {
        return this._$$rtcExtInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.model.b
    public final long getTargetUiLayout() {
        return this._$$targetUiLayout;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdk.chatroom.model.interact.s0, java.lang.Object] */
    public InteractiveScreenCastOpenResponseFlexImpl(g r100) {
        super(b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$castInfo = f.a(r100, s0.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$rtcExtInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$liveCoreExtInfo = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$targetUiLayout = r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.model.b
    public final void setCastInfo(s0 r100) {
        this._$$castInfo = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.model.b
    public final void setLiveCoreExtInfo(String r100) {
        this._$$liveCoreExtInfo = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.model.b
    public final void setRtcExtInfo(String r100) {
        this._$$rtcExtInfo = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.model.b
    public final void setTargetUiLayout(long r100) {
        this._$$targetUiLayout = r100;
    }
}
