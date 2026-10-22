package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0018\u0010\u000bR.\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0007\u001a\u0004\b\u001e\u0010\u001fR.\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b\"\u0010\u001fR.\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0007\u001a\u0004\b%\u0010\u001fR\u001c\u0010+\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0007\u001a\u0004\b(\u0010)R\u001c\u0010.\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0007\u001a\u0004\b,\u0010)R\u001c\u00103\u001a\u0004\u0018\u00010/8&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0007\u001a\u0004\b0\u00101R\u001c\u00108\u001a\u0004\u0018\u0001048&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0007\u001a\u0004\b5\u00106R\u001c\u0010;\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b9\u0010\u0013R\u001c\u0010>\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0007\u001a\u0004\b<\u0010\u0013R\u001c\u0010A\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0007\u001a\u0004\b?\u0010\u0013R\u001c\u0010D\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0007\u001a\u0004\bB\u0010\u0013R\u001a\u0010H\u001a\u0002048&X§\u0004¢\u0006\f\u0012\u0004\bG\u0010\u0007\u001a\u0004\bE\u0010FR\u001c\u0010K\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0007\u001a\u0004\bI\u0010\u0013R:\u0010Q\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010Lj\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`M8&X§\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0007\u001a\u0004\bN\u0010OR:\u0010T\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010Lj\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`M8&X§\u0004¢\u0006\f\u0012\u0004\bS\u0010\u0007\u001a\u0004\bR\u0010OR\u001c\u0010W\u001a\u0004\u0018\u0001048&X§\u0004¢\u0006\f\u0012\u0004\bV\u0010\u0007\u001a\u0004\bU\u00106R\u001c\u0010Z\u001a\u0004\u0018\u0001048&X§\u0004¢\u0006\f\u0012\u0004\bY\u0010\u0007\u001a\u0004\bX\u00106R\u001c\u0010]\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\\\u0010\u0007\u001a\u0004\b[\u0010\u0013R\u001c\u0010`\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b_\u0010\u0007\u001a\u0004\b^\u0010)¨\u0006a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExtendArea;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExtendAreaEx;", "Lpy/k;", "getExtendIcon", "()Lpy/k;", "getExtendIcon$annotations", "()V", "extendIcon", "", "getUseMarquee", "()I", "getUseMarquee$annotations", "useMarquee", "getExtendType", "getExtendType$annotations", "extendType", "", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getExtra$annotations", "extra", "getIcontype", "getIcontype$annotations", "icontype", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPart;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getRightPart", "()Ljava/util/List;", "getRightPart$annotations", "rightPart", "getMidPart", "getMidPart$annotations", "midPart", "getBottomPart", "getBottomPart$annotations", "bottomPart", "getVersion", "()Ljava/lang/Integer;", "getVersion$annotations", "version", "getEnableClickableArea", "getEnableClickableArea$annotations", "enableClickableArea", "Lcom/bytedance/android/livesdkapi/depend/model/live/IActionConfig;", "getActionCfg", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IActionConfig;", "getActionCfg$annotations", "actionCfg", "", "getUseJson", "()Ljava/lang/Boolean;", "getUseJson$annotations", "useJson", "getPassThroughJson", "getPassThroughJson$annotations", "passThroughJson", "getButtonPart", "getButtonPart$annotations", "buttonPart", "getExtendPreText", "getExtendPreText$annotations", "extendPreText", "getExtendText", "getExtendText$annotations", "extendText", "getNeedDelimiter", "()Z", "getNeedDelimiter$annotations", "needDelimiter", "getExtraBusiness", "getExtraBusiness$annotations", "extraBusiness", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getExtraEnterRoom", "()Ljava/util/Map;", "getExtraEnterRoom$annotations", "extraEnterRoom", "getEtExtra", "getEtExtra$annotations", "etExtra", "getNoNeedPoll", "getNoNeedPoll$annotations", "noNeedPoll", "getUseTitleFusion", "getUseTitleFusion$annotations", "useTitleFusion", "getSingleLogResult", "getSingleLogResult$annotations", "singleLogResult", "getComponentType", "getComponentType$annotations", "componentType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPreviewExtendArea extends c<IPreviewExtendArea>, IPreviewExtendAreaEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "action_cfg")
        public static /* synthetic */ void getActionCfg$annotations() {
        }

        @FieldName(name = "bottom_part")
        public static /* synthetic */ void getBottomPart$annotations() {
        }

        @FieldName(name = "button_part")
        public static /* synthetic */ void getButtonPart$annotations() {
        }

        @FieldName(name = "component_type")
        public static /* synthetic */ void getComponentType$annotations() {
        }

        @FieldName(name = "clickable_area")
        public static /* synthetic */ void getEnableClickableArea$annotations() {
        }

        @FieldName(name = "et_extra")
        public static /* synthetic */ void getEtExtra$annotations() {
        }

        @FieldName(name = "extend_icon")
        public static /* synthetic */ void getExtendIcon$annotations() {
        }

        @FieldName(name = "extend_pre_text")
        public static /* synthetic */ void getExtendPreText$annotations() {
        }

        @FieldName(name = "extend_text")
        public static /* synthetic */ void getExtendText$annotations() {
        }

        @FieldName(name = "extend_type")
        public static /* synthetic */ void getExtendType$annotations() {
        }

        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "extra_business")
        public static /* synthetic */ void getExtraBusiness$annotations() {
        }

        @FieldName(name = "extra_enter_room")
        public static /* synthetic */ void getExtraEnterRoom$annotations() {
        }

        @FieldName(name = "icon_type")
        public static /* synthetic */ void getIcontype$annotations() {
        }

        @FieldName(name = "mid_part")
        public static /* synthetic */ void getMidPart$annotations() {
        }

        @FieldName(name = "need_delimiter")
        public static /* synthetic */ void getNeedDelimiter$annotations() {
        }

        @FieldName(name = "no_need_poll")
        public static /* synthetic */ void getNoNeedPoll$annotations() {
        }

        @FieldName(name = "pass_through_extra_json")
        public static /* synthetic */ void getPassThroughJson$annotations() {
        }

        @FieldName(name = "right_part")
        public static /* synthetic */ void getRightPart$annotations() {
        }

        @FieldName(name = "single_log_result")
        public static /* synthetic */ void getSingleLogResult$annotations() {
        }

        @FieldName(name = "use_pass_through_extra_json")
        public static /* synthetic */ void getUseJson$annotations() {
        }

        @FieldName(name = "use_marquee")
        public static /* synthetic */ void getUseMarquee$annotations() {
        }

        @FieldName(name = "use_title_fusion")
        public static /* synthetic */ void getUseTitleFusion$annotations() {
        }

        @FieldName(name = "version")
        public static /* synthetic */ void getVersion$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "action_cfg")
    IActionConfig getActionCfg();

    @FieldName(name = "bottom_part")
    List<IPart> getBottomPart();

    @FieldName(name = "button_part")
    String getButtonPart();

    @FieldName(name = "component_type")
    Integer getComponentType();

    @FieldName(name = "clickable_area")
    Integer getEnableClickableArea();

    @FieldName(name = "et_extra")
    Map<String, String> getEtExtra();

    @FieldName(name = "extend_icon")
    k getExtendIcon();

    @FieldName(name = "extend_pre_text")
    String getExtendPreText();

    @FieldName(name = "extend_text")
    String getExtendText();

    @FieldName(name = "extend_type")
    int getExtendType();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "extra_business")
    String getExtraBusiness();

    @FieldName(name = "extra_enter_room")
    Map<String, String> getExtraEnterRoom();

    @FieldName(name = "icon_type")
    int getIcontype();

    @FieldName(name = "mid_part")
    List<IPart> getMidPart();

    @FieldName(name = "need_delimiter")
    boolean getNeedDelimiter();

    @FieldName(name = "no_need_poll")
    Boolean getNoNeedPoll();

    @FieldName(name = "pass_through_extra_json")
    String getPassThroughJson();

    @FieldName(name = "right_part")
    List<IPart> getRightPart();

    @FieldName(name = "single_log_result")
    String getSingleLogResult();

    @FieldName(name = "use_pass_through_extra_json")
    Boolean getUseJson();

    @FieldName(name = "use_marquee")
    int getUseMarquee();

    @FieldName(name = "use_title_fusion")
    Boolean getUseTitleFusion();

    @FieldName(name = "version")
    Integer getVersion();

    @FieldName(name = "extra#setter")
    void setExtra(String r100);
}
