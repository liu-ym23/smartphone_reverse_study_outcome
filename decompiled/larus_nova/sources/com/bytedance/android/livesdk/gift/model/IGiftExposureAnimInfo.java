package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010 \u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftExposureAnimInfo;", "Lvh7/c;", "", "getFrequencyKey", "()Ljava/lang/String;", "setFrequencyKey", "(Ljava/lang/String;)V", "getFrequencyKey$annotations", "()V", "frequencyKey", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAssetUrl", "()Lpy/k;", "setAssetUrl", "(Lpy/k;)V", "getAssetUrl$annotations", "assetUrl", "", "getInterval", "()I", "setInterval", "(I)V", "getInterval$annotations", VideoThumbInfo.KEY_INTERVAL, "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getShowTime", "()Ljava/lang/Long;", "setShowTime", "(Ljava/lang/Long;)V", "getShowTime$annotations", "showTime", "FreqCtlIntervalEnum", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IGiftExposureAnimInfo extends vh7.c<IGiftExposureAnimInfo> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftExposureAnimInfo$FreqCtlIntervalEnum;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "FreqCtlIntervalEnumUnknown", "FreqCtlIntervalEnumDay", "FreqCtlIntervalEnumWeek", "FreqCtlIntervalEnumMonth", "FreqCtlIntervalEnumYear", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum FreqCtlIntervalEnum extends Enum<FreqCtlIntervalEnum> {
        public static final FreqCtlIntervalEnum FreqCtlIntervalEnumDay = null;
        public static final FreqCtlIntervalEnum FreqCtlIntervalEnumMonth = null;
        public static final FreqCtlIntervalEnum FreqCtlIntervalEnumUnknown = null;
        public static final FreqCtlIntervalEnum FreqCtlIntervalEnumWeek = null;
        public static final FreqCtlIntervalEnum FreqCtlIntervalEnumYear = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FreqCtlIntervalEnum[] f126369a = null;
        private int value;

        static {
            FreqCtlIntervalEnum r100 = new FreqCtlIntervalEnum("FreqCtlIntervalEnumUnknown", 0, 0);
            FreqCtlIntervalEnumUnknown = r100;
            FreqCtlIntervalEnum r101 = new FreqCtlIntervalEnum("FreqCtlIntervalEnumDay", 1, 1);
            FreqCtlIntervalEnumDay = r101;
            FreqCtlIntervalEnum r102 = new FreqCtlIntervalEnum("FreqCtlIntervalEnumWeek", 2, 2);
            FreqCtlIntervalEnumWeek = r102;
            FreqCtlIntervalEnum r103 = new FreqCtlIntervalEnum("FreqCtlIntervalEnumMonth", 3, 3);
            FreqCtlIntervalEnumMonth = r103;
            FreqCtlIntervalEnum r104 = new FreqCtlIntervalEnum("FreqCtlIntervalEnumYear", 4, 4);
            FreqCtlIntervalEnumYear = r104;
            f126369a = new FreqCtlIntervalEnum[]{r100, r101, r102, r103, r104};
        }

        public static FreqCtlIntervalEnum valueOf(String r100) {
            return (FreqCtlIntervalEnum) r27.a.a(FreqCtlIntervalEnum.class, r100);
        }

        public static FreqCtlIntervalEnum[] values() {
            return (FreqCtlIntervalEnum[]) f126369a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public FreqCtlIntervalEnum(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "asset_img")
    py.k getAssetUrl();

    @FieldName(name = "frequency_key")
    String getFrequencyKey();

    @FieldName(name = VideoThumbInfo.KEY_INTERVAL)
    int getInterval();

    @FieldName(name = "show_count")
    Long getShowTime();

    @FieldName(name = "asset_img#setter")
    void setAssetUrl(py.k r100);

    @FieldName(name = "frequency_key#setter")
    void setFrequencyKey(String r100);

    @FieldName(name = "interval#setter")
    void setInterval(int r100);

    @FieldName(name = "show_count#setter")
    void setShowTime(Long r100);
}
