package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.SubscribeGiftPackInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR+\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001c¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/SubscribeGiftPackInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/q3;", "", "<set-?>", "relatedGiftId$delegate", "Ljava/lang/Object;", "getRelatedGiftId", "()J", "setRelatedGiftId", "(J)V", "relatedGiftId", "offlineTimeSecond$delegate", "getOfflineTimeSecond", "setOfflineTimeSecond", "offlineTimeSecond", "", "leftScores$delegate", "getLeftScores", "()I", "setLeftScores", "(I)V", "leftScores", "", "entranceSchemeUrl$delegate", "getEntranceSchemeUrl", "()Ljava/lang/String;", "setEntranceSchemeUrl", "(Ljava/lang/String;)V", "entranceSchemeUrl", "entranceSchemeUrlQueryParams$delegate", "getEntranceSchemeUrlQueryParams", "setEntranceSchemeUrlQueryParams", "entranceSchemeUrlQueryParams", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SubscribeGiftPackInfoFlexImpl extends FlexModelBase<q3> implements q3, vh7.h {

    @SerializedName("entrance_scheme_url")
    protected String _$$entranceSchemeUrl;

    @SerializedName("entrance_scheme_url_query_params")
    protected String _$$entranceSchemeUrlQueryParams;

    @SerializedName("left_scores")
    protected int _$$leftScores;

    @SerializedName("offline_time_second")
    protected long _$$offlineTimeSecond;

    @SerializedName("related_gift_id")
    protected long _$$relatedGiftId;

    public SubscribeGiftPackInfoFlexImpl() {
        super(q3.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final String getEntranceSchemeUrl() {
        return this._$$entranceSchemeUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final String getEntranceSchemeUrlQueryParams() {
        return this._$$entranceSchemeUrlQueryParams;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final int getLeftScores() {
        return this._$$leftScores;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final long getOfflineTimeSecond() {
        return this._$$offlineTimeSecond;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final long getRelatedGiftId() {
        return this._$$relatedGiftId;
    }

    public SubscribeGiftPackInfoFlexImpl(am3.g r100) {
        super(q3.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$relatedGiftId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$offlineTimeSecond = r100.j();
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this._$$leftScores = r100.i();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this._$$entranceSchemeUrl = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 6) goto L15;
        this._$$entranceSchemeUrlQueryParams = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final void setEntranceSchemeUrl(String r100) {
        this._$$entranceSchemeUrl = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final void setEntranceSchemeUrlQueryParams(String r100) {
        this._$$entranceSchemeUrlQueryParams = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final void setLeftScores(int r100) {
        this._$$leftScores = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final void setOfflineTimeSecond(long r100) {
        this._$$offlineTimeSecond = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q3
    public final void setRelatedGiftId(long r100) {
        this._$$relatedGiftId = r100;
    }
}
