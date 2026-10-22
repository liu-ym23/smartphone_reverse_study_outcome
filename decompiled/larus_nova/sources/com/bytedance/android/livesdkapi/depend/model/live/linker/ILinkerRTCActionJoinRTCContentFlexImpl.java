package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerRTCActionJoinRTCContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R/\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContent;", "", "<set-?>", "canJoinRtcAdvance$delegate", "Ljava/lang/Object;", "getCanJoinRtcAdvance", "()Z", "setCanJoinRtcAdvance", "(Z)V", "canJoinRtcAdvance", "", "rtcExtInfo$delegate", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "rtcExtInfo", "liveCoreExtInfo$delegate", "getLiveCoreExtInfo", "setLiveCoreExtInfo", "liveCoreExtInfo", "linkMicIdString$delegate", "getLinkMicIdString", "setLinkMicIdString", "linkMicIdString", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerRTCActionJoinRTCContentFlexImpl extends FlexModelBase<ILinkerRTCActionJoinRTCContent> implements ILinkerRTCActionJoinRTCContent, h {

    @SerializedName("join_rtc")
    protected boolean _$$canJoinRtcAdvance;

    @SerializedName("linkmic_id_str")
    protected String _$$linkMicIdString;

    @SerializedName("live_core_ext_info")
    protected String _$$liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String _$$rtcExtInfo;

    public ILinkerRTCActionJoinRTCContentFlexImpl() {
        super(ILinkerRTCActionJoinRTCContent.class);
        this._$$canJoinRtcAdvance = false;
    }

    public ILinkerRTCActionJoinRTCContentFlexImpl(g r100) {
        super(ILinkerRTCActionJoinRTCContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$canJoinRtcAdvance = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$rtcExtInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this._$$liveCoreExtInfo = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        this._$$linkMicIdString = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r104, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & true) == true) goto L37;
        this._$$canJoinRtcAdvance = false;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent
    public final boolean getCanJoinRtcAdvance() {
        return this._$$canJoinRtcAdvance;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent
    public final String getLinkMicIdString() {
        return this._$$linkMicIdString;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent
    public final String getLiveCoreExtInfo() {
        return this._$$liveCoreExtInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent
    public final String getRtcExtInfo() {
        return this._$$rtcExtInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent
    public final void setCanJoinRtcAdvance(boolean r100) {
        this._$$canJoinRtcAdvance = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent
    public final void setLinkMicIdString(String r100) {
        this._$$linkMicIdString = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent
    public final void setLiveCoreExtInfo(String r100) {
        this._$$liveCoreExtInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent
    public final void setRtcExtInfo(String r100) {
        this._$$rtcExtInfo = r100;
    }
}
