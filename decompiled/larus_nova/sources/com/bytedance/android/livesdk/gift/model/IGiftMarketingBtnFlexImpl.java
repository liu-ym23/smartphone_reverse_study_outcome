package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.GiftMarketingBtn")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingBtnFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/v1;", "", "buttonType$delegate", "Ljava/lang/Object;", "getButtonType", "()I", "buttonType", "sendGiftCount$delegate", "getSendGiftCount", "sendGiftCount", "", "textBeforeMission$delegate", "getTextBeforeMission", "()Ljava/lang/String;", "textBeforeMission", "textAfterMission$delegate", "getTextAfterMission", "textAfterMission", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftMarketingBtnFlexImpl extends FlexModelBase<v1> implements v1, vh7.h {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE)
    protected int _$$buttonType;

    @SerializedName("send_gift_count")
    protected int _$$sendGiftCount;

    @SerializedName("text_after_mission")
    protected String _$$textAfterMission;

    @SerializedName("text_before_mission")
    protected String _$$textBeforeMission;

    public IGiftMarketingBtnFlexImpl() {
        super(v1.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.v1
    public final int getButtonType() {
        return this._$$buttonType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v1
    public final int getSendGiftCount() {
        return this._$$sendGiftCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v1
    public final String getTextAfterMission() {
        return this._$$textAfterMission;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v1
    public final String getTextBeforeMission() {
        return this._$$textBeforeMission;
    }

    public IGiftMarketingBtnFlexImpl(am3.g r100) {
        super(v1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$buttonType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$sendGiftCount = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$textBeforeMission = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$textAfterMission = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
