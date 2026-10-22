package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.LinkmicEnlargeGuestTurnOnContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R/\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/base/model/message/LinkmicEnlargeGuestTurnOnContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/f6;", "", "source$delegate", "Ljava/lang/Object;", "getSource", "()I", "source", "Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "<set-?>", "enlargeGuestInfo$delegate", "getEnlargeGuestInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "setEnlargeGuestInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;)V", "enlargeGuestInfo", "", "_enlargedUserId$delegate", "get_enlargedUserId", "()J", "_enlargedUserId", "", "_enlargedOpenId$delegate", "get_enlargedOpenId", "()Ljava/lang/String;", "_enlargedOpenId", "trackingData$delegate", "getTrackingData", "trackingData", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicEnlargeGuestTurnOnContentFlexImpl extends FlexModelBase<f6> implements f6, vh7.h {

    @SerializedName("enlarged_openid")
    protected String _$$_enlargedOpenId;

    @SerializedName("enlarged_user_id")
    protected long _$$_enlargedUserId;

    @SerializedName("info")
    protected EnlargeGuestInfo _$$enlargeGuestInfo;

    @SerializedName("source")
    protected int _$$source;

    @SerializedName("tracking_data")
    protected String _$$trackingData;

    public LinkmicEnlargeGuestTurnOnContentFlexImpl() {
        super(f6.class);
        this._$$_enlargedOpenId = "";
    }

    @Override // com.bytedance.android.live.base.model.message.f6
    public final EnlargeGuestInfo getEnlargeGuestInfo() {
        return this._$$enlargeGuestInfo;
    }

    @Override // com.bytedance.android.live.base.model.message.f6
    public final int getSource() {
        return this._$$source;
    }

    @Override // com.bytedance.android.live.base.model.message.f6
    public final String getTrackingData() {
        return this._$$trackingData;
    }

    @Override // com.bytedance.android.live.base.model.message.f6
    public final String get_enlargedOpenId() {
        return this._$$_enlargedOpenId;
    }

    @Override // com.bytedance.android.live.base.model.message.f6
    public final long get_enlargedUserId() {
        return this._$$_enlargedUserId;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo, java.lang.Object] */
    public LinkmicEnlargeGuestTurnOnContentFlexImpl(am3.g r100) {
        super(f6.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$_enlargedUserId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$source = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$enlargeGuestInfo = vh7.f.a(r100, EnlargeGuestInfo.class);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$trackingData = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this._$$_enlargedOpenId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$_enlargedOpenId != null) goto L43;
        this._$$_enlargedOpenId = "";
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.f6
    public final void setEnlargeGuestInfo(EnlargeGuestInfo r100) {
        this._$$enlargeGuestInfo = r100;
    }
}
