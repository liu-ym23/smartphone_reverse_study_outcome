package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.IconAutoplayAssetInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010 \u001a\u0004\u0018\u00010\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftExposureAnimInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/IGiftExposureAnimInfo;", "", "<set-?>", "frequencyKey$delegate", "Ljava/lang/Object;", "getFrequencyKey", "()Ljava/lang/String;", "setFrequencyKey", "(Ljava/lang/String;)V", "frequencyKey", "Lpy/k;", "assetUrl$delegate", "getAssetUrl", "()Lpy/k;", "setAssetUrl", "(Lpy/k;)V", "assetUrl", "", "interval$delegate", "getInterval", "()I", "setInterval", "(I)V", VideoThumbInfo.KEY_INTERVAL, "", "showTime$delegate", "getShowTime", "()Ljava/lang/Long;", "setShowTime", "(Ljava/lang/Long;)V", "showTime", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftExposureAnimInfoFlexImpl extends FlexModelBase<IGiftExposureAnimInfo> implements IGiftExposureAnimInfo, vh7.h {

    @SerializedName("asset_img")
    protected py.k _$$assetUrl;

    @SerializedName("frequency_key")
    protected String _$$frequencyKey;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    protected int _$$interval;

    @SerializedName("show_count")
    protected Long _$$showTime;

    public IGiftExposureAnimInfoFlexImpl() {
        super(IGiftExposureAnimInfo.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo
    public final py.k getAssetUrl() {
        return this._$$assetUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo
    public final String getFrequencyKey() {
        return this._$$frequencyKey;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo
    public final int getInterval() {
        return this._$$interval;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo
    public final Long getShowTime() {
        return this._$$showTime;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public IGiftExposureAnimInfoFlexImpl(am3.g r100) {
        super(IGiftExposureAnimInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$frequencyKey = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$assetUrl = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$interval = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$showTime = Long.valueOf(r100.j());
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo
    public final void setAssetUrl(py.k r100) {
        this._$$assetUrl = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo
    public final void setFrequencyKey(String r100) {
        this._$$frequencyKey = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo
    public final void setInterval(int r100) {
        this._$$interval = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo
    public final void setShowTime(Long r100) {
        this._$$showTime = r100;
    }
}
