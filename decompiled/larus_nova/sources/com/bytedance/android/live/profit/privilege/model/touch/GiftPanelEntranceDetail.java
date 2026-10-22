package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001=R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R6\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR*\u0010\u001e\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\n\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\n\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R6\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\n\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010-\u001a\u0004\u0018\u00010'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\n\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010.8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\n\u001a\u0004\b/\u00100\"\u0004\b1\u00102RB\u0010<\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u000105j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`68&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\n\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail;", "Lvh7/c;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPanelDetail", "()Ljava/util/List;", "setPanelDetail", "(Ljava/util/List;)V", "getPanelDetail$annotations", "()V", "panelDetail", "", "getPanelUrl", "()Ljava/lang/String;", "setPanelUrl", "(Ljava/lang/String;)V", "getPanelUrl$annotations", "panelUrl", "getBubbleText", "setBubbleText", "getBubbleText$annotations", "bubbleText", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBubbleBackgroundImg", "()Lpy/k;", "setBubbleBackgroundImg", "(Lpy/k;)V", "getBubbleBackgroundImg$annotations", "bubbleBackgroundImg", "getBubbleUrl", "setBubbleUrl", "getBubbleUrl$annotations", "bubbleUrl", "getAwardTips", "setAwardTips", "getAwardTips$annotations", "awardTips", "Lcom/bytedance/android/live/profit/privilege/model/touch/h;", "getLightInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/h;", "setLightInfo", "(Lcom/bytedance/android/live/profit/privilege/model/touch/h;)V", "getLightInfo$annotations", "lightInfo", "Lcom/bytedance/android/live/profit/privilege/model/touch/b;", "getDynamicInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/b;", "setDynamicInfo", "(Lcom/bytedance/android/live/profit/privilege/model/touch/b;)V", "getDynamicInfo$annotations", "dynamicInfo", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getExtra$annotations", "extra", "RichTextType", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface GiftPanelEntranceDetail extends vh7.c<GiftPanelEntranceDetail> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail$RichTextType;", "", "", "value", "I", "getValue", "()I", "RichTextTypeUnknown", "RichTextTypeText", "RichTextTypeImg", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RichTextType extends Enum<RichTextType> {
        public static final RichTextType RichTextTypeImg = null;
        public static final RichTextType RichTextTypeText = null;
        public static final RichTextType RichTextTypeUnknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RichTextType[] f88417a = null;
        private final int value;

        static {
            RichTextType r100 = new RichTextType("RichTextTypeUnknown", 0, 0);
            RichTextTypeUnknown = r100;
            RichTextType r101 = new RichTextType("RichTextTypeText", 1, 1);
            RichTextTypeText = r101;
            RichTextType r102 = new RichTextType("RichTextTypeImg", 2, 2);
            RichTextTypeImg = r102;
            f88417a = new RichTextType[]{r100, r101, r102};
        }

        public static RichTextType valueOf(String r100) {
            return (RichTextType) r27.a.a(RichTextType.class, r100);
        }

        public static RichTextType[] values() {
            return (RichTextType[]) f88417a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public RichTextType(String r100, int r101, int r102) {
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

    @FieldName(name = "award_tips")
    List<n> getAwardTips();

    @FieldName(name = "bubble_background_img")
    py.k getBubbleBackgroundImg();

    @FieldName(name = "bubble_text")
    List<n> getBubbleText();

    @FieldName(name = "bubble_url")
    String getBubbleUrl();

    @FieldName(name = "dynamic_info")
    b getDynamicInfo();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = "light_info")
    h getLightInfo();

    @FieldName(name = "panel_detail")
    List<n> getPanelDetail();

    @FieldName(name = "panel_url")
    String getPanelUrl();

    @FieldName(name = "award_tips#setter")
    void setAwardTips(List<? extends n> r100);

    @FieldName(name = "bubble_background_img#setter")
    void setBubbleBackgroundImg(py.k r100);

    @FieldName(name = "bubble_text#setter")
    void setBubbleText(List<? extends n> r100);

    @FieldName(name = "bubble_url#setter")
    void setBubbleUrl(String r100);

    @FieldName(name = "dynamic_info#setter")
    void setDynamicInfo(b r100);

    @FieldName(name = "extra#setter")
    void setExtra(Map<String, String> r100);

    @FieldName(name = "light_info#setter")
    void setLightInfo(h r100);

    @FieldName(name = "panel_detail#setter")
    void setPanelDetail(List<? extends n> r100);

    @FieldName(name = "panel_url#setter")
    void setPanelUrl(String r100);
}
