package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicProfitInteractiveScreenCastCloseContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkScreenCastCloseContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/b9;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "screenCastInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "getScreenCastInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "setScreenCastInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;)V", "", "rtcExtInfo$delegate", "Ljava/lang/Object;", "getRtcExtInfo", "()Ljava/lang/String;", "rtcExtInfo", "liveCoreExtInfo$delegate", "getLiveCoreExtInfo", "liveCoreExtInfo", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkScreenCastCloseContentFlexImpl extends FlexModelBase<b9> implements b9, vh7.h {

    @SerializedName("live_core_ext_info")
    protected String _$$liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String _$$rtcExtInfo;

    @SerializedName("screen_cast_info")
    protected com.bytedance.android.livesdk.chatroom.model.interact.s0 screenCastInfo;

    public ILinkScreenCastCloseContentFlexImpl() {
        super(b9.class);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.chatroom.model.interact.s0, java.lang.Object] */
    public ILinkScreenCastCloseContentFlexImpl(am3.g r100) {
        super(b9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.screenCastInfo = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.interact.s0.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$rtcExtInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$liveCoreExtInfo = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.message.model.b9
    public final String getLiveCoreExtInfo() {
        return this._$$liveCoreExtInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.b9
    public final String getRtcExtInfo() {
        return this._$$rtcExtInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.b9
    public com.bytedance.android.livesdk.chatroom.model.interact.s0 getScreenCastInfo() {
        return this.screenCastInfo;
    }

    public void setScreenCastInfo(com.bytedance.android.livesdk.chatroom.model.interact.s0 r100) {
        this.screenCastInfo = r100;
    }
}
