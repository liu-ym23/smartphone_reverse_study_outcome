package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import py.k;
import r27.a;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.PreviewExtendArea")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u0082\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003:\u0004\u0082\u0001\u0083\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010w\u001a\u00020FJ\u0013\u0010x\u001a\u00020F2\b\u0010y\u001a\u0004\u0018\u00010zH\u0096\u0002J\u0010\u0010{\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010\fH\u0016J\u0010\u0010}\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010\fH\u0016J\u0010\u0010~\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010\fH\u0016J\b\u0010\u007f\u001a\u00020\u001aH\u0016J\t\u0010\u0080\u0001\u001a\u00020FH\u0002J\t\u0010\u0081\u0001\u001a\u00020FH\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR,\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010$8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u0010/\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R&\u00103\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001e\u00107\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010<\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0016\"\u0004\b>\u0010\u0018R \u0010?\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0016\"\u0004\bA\u0010\u0018R,\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010$8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010&\"\u0004\bD\u0010(R\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00109\"\u0004\bM\u0010;R\u0012\u0010N\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0004\n\u0002\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR&\u0010V\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000f\"\u0004\bX\u0010\u0011R$\u0010Y\u001a\u00020F8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bZ\u0010\u0004\u001a\u0004\b[\u0010H\"\u0004\b\\\u0010JR\"\u0010]\u001a\u0004\u0018\u00010F8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010O\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010b\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0016\"\u0004\bd\u0010\u0018R&\u0010e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000f\"\u0004\bg\u0010\u0011R \u0010h\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0016\"\u0004\bj\u0010\u0018R\"\u0010k\u001a\u0004\u0018\u00010F8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010O\u001a\u0004\bl\u0010_\"\u0004\bm\u0010aR\u001e\u0010n\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00109\"\u0004\bp\u0010;R\"\u0010q\u001a\u0004\u0018\u00010F8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010O\u001a\u0004\br\u0010_\"\u0004\bs\u0010aR\"\u0010t\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\bu\u0010\u001c\"\u0004\bv\u0010\u001e¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewExtendArea;", "Ljava/io/Serializable;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExtendArea;", "()V", "actionCfg", "Lcom/bytedance/android/livesdkapi/depend/model/live/ActionConfig;", "getActionCfg", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ActionConfig;", "setActionCfg", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ActionConfig;)V", "bottomPart", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/Part;", "getBottomPart", "()Ljava/util/List;", "setBottomPart", "(Ljava/util/List;)V", "buttonPart", "", "getButtonPart$annotations", "getButtonPart", "()Ljava/lang/String;", "setButtonPart", "(Ljava/lang/String;)V", "componentType", "", "getComponentType", "()Ljava/lang/Integer;", "setComponentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enableClickableArea", "getEnableClickableArea", "setEnableClickableArea", "etExtra", "", "getEtExtra", "()Ljava/util/Map;", "setEtExtra", "(Ljava/util/Map;)V", "extendIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getExtendIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setExtendIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "extendPreText", "getExtendPreText$annotations", "getExtendPreText", "setExtendPreText", "extendText", "getExtendText$annotations", "getExtendText", "setExtendText", "extendType", "getExtendType", "()I", "setExtendType", "(I)V", "extra", "getExtra", "setExtra", "extraBusiness", "getExtraBusiness", "setExtraBusiness", "extraEnterRoom", "getExtraEnterRoom", "setExtraEnterRoom", "hasExtendAreaShown", "", "getHasExtendAreaShown", "()Z", "setHasExtendAreaShown", "(Z)V", "icontype", "getIcontype", "setIcontype", "isVSComponent", "Ljava/lang/Boolean;", "liveLifeModel", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveLifeModel;", "getLiveLifeModel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveLifeModel;", "setLiveLifeModel", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveLifeModel;)V", "midPart", "getMidPart", "setMidPart", "needDelimiter", "getNeedDelimiter$annotations", "getNeedDelimiter", "setNeedDelimiter", "noNeedPoll", "getNoNeedPoll", "()Ljava/lang/Boolean;", "setNoNeedPoll", "(Ljava/lang/Boolean;)V", "passThroughJson", "getPassThroughJson", "setPassThroughJson", "rightPart", "getRightPart", "setRightPart", "singleLogResult", "getSingleLogResult", "setSingleLogResult", "useJson", "getUseJson", "setUseJson", "useMarquee", "getUseMarquee", "setUseMarquee", "useTitleFusion", "getUseTitleFusion", "setUseTitleFusion", "version", "getVersion", "setVersion", "canShowGoldTaskArea", "equals", "other", "", "getBottomPartKmp", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPart;", "getMidPartKmp", "getRightPartKmp", "hashCode", "isVSComponentType", "useWithTitleConfig", "Companion", "IconType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewExtendArea extends FlexModelBase<IPreviewExtendArea> implements IPreviewExtendArea, h {
    public static final Companion Companion = null;
    public static final int LIVE_EXTEND_TYPE_AD = 15;
    public static final int LIVE_EXTEND_TYPE_AICONTENT = 35;
    public static final int LIVE_EXTEND_TYPE_ANNOUNCEMENT = 3;
    public static final int LIVE_EXTEND_TYPE_ECOMMERCE = 1;
    public static final int LIVE_EXTEND_TYPE_EXPLAINCARD = 101;
    public static final int LIVE_EXTEND_TYPE_GAME_PROMOTION = 4;
    public static final int LIVE_EXTEND_TYPE_GAME_PROMOTION_V2 = 102;
    public static final int LIVE_EXTEND_TYPE_GOLD_TASK = 16;
    public static final int LIVE_EXTEND_TYPE_LIVE_LIFE = 5;
    public static final int LIVE_EXTEND_TYPE_PROGRAM_LIST_CD = 13;
    public static final int LIVE_EXTEND_TYPE_PROGRAM_LIST_ICON = 12;
    public static final int LIVE_EXTEND_TYPE_UNKNOW = 0;
    public static final int LIVE_EXTEND_TYPE_UVORPV = 2;
    public static final int LIVE_EXTEND_TYPE_WINDMILL = 103;

    @SerializedName("action_cfg")
    protected ActionConfig actionCfg;

    @SerializedName("bottom_part")
    protected List<Part> bottomPart;

    @SerializedName("button_part")
    protected String buttonPart;

    @SerializedName("component_type")
    protected Integer componentType;

    @SerializedName("clickable_area")
    protected Integer enableClickableArea;

    @SerializedName("et_extra")
    protected Map<String, String> etExtra;

    @SerializedName("extend_icon")
    protected ImageModel extendIcon;

    @SerializedName("extend_pre_text")
    protected String extendPreText;

    @SerializedName("extend_text")
    protected String extendText;

    @SerializedName("extend_type")
    protected int extendType;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("extra_business")
    protected String extraBusiness;

    @SerializedName("extra_enter_room")
    protected Map<String, String> extraEnterRoom;
    private boolean hasExtendAreaShown;

    @SerializedName("icon_type")
    protected int icontype;
    private Boolean isVSComponent;
    private LiveLifeModel liveLifeModel;

    @SerializedName("mid_part")
    protected List<Part> midPart;

    @SerializedName("need_delimiter")
    protected boolean needDelimiter;

    @SerializedName("no_need_poll")
    protected Boolean noNeedPoll;

    @SerializedName("pass_through_extra_json")
    protected String passThroughJson;

    @SerializedName("right_part")
    protected List<Part> rightPart;

    @SerializedName("single_log_result")
    protected String singleLogResult;

    @SerializedName("use_pass_through_extra_json")
    protected Boolean useJson;

    @SerializedName("use_marquee")
    protected int useMarquee;

    @SerializedName("use_title_fusion")
    protected Boolean useTitleFusion;

    @SerializedName("version")
    protected Integer version;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewExtendArea$Companion;", "", "()V", "LIVE_EXTEND_TYPE_AD", "", "LIVE_EXTEND_TYPE_AICONTENT", "LIVE_EXTEND_TYPE_ANNOUNCEMENT", "LIVE_EXTEND_TYPE_ECOMMERCE", "LIVE_EXTEND_TYPE_EXPLAINCARD", "LIVE_EXTEND_TYPE_GAME_PROMOTION", "LIVE_EXTEND_TYPE_GAME_PROMOTION_V2", "LIVE_EXTEND_TYPE_GOLD_TASK", "LIVE_EXTEND_TYPE_LIVE_LIFE", "LIVE_EXTEND_TYPE_PROGRAM_LIST_CD", "LIVE_EXTEND_TYPE_PROGRAM_LIST_ICON", "LIVE_EXTEND_TYPE_UNKNOW", "LIVE_EXTEND_TYPE_UVORPV", "LIVE_EXTEND_TYPE_WINDMILL", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewExtendArea$IconType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UnKnownType", "Icon", "ProductCover", "BigIcon", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum IconType extends Enum<IconType> {
        private static final /* synthetic */ IconType[] $VALUES = null;
        public static final IconType BigIcon = null;
        public static final IconType Icon = null;

        @Deprecated(message = "")
        public static final IconType ProductCover = null;
        public static final IconType UnKnownType = null;
        private final int value;

        static {
            IconType r100 = new IconType("UnKnownType", 0, 0);
            UnKnownType = r100;
            IconType r101 = new IconType("Icon", 1, 1);
            Icon = r101;
            IconType r102 = new IconType("ProductCover", 2, 2);
            ProductCover = r102;
            IconType r103 = new IconType("BigIcon", 3, 3);
            BigIcon = r103;
            $VALUES = new IconType[]{r100, r101, r102, r103};
        }

        public static IconType valueOf(String r100) {
            return (IconType) a.a(IconType.class, r100);
        }

        public static IconType[] values() {
            return (IconType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        private IconType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Deprecated(message = "新版本统一使用bottom_part")
    public static /* synthetic */ void getButtonPart$annotations() {
    }

    @Deprecated(message = "新版本统一使用mid_part代替")
    public static /* synthetic */ void getExtendPreText$annotations() {
    }

    @Deprecated(message = "新版本统一使用mid_part代替")
    public static /* synthetic */ void getExtendText$annotations() {
    }

    @Deprecated(message = "新版本统一使用使用part来做分割线")
    public static /* synthetic */ void getNeedDelimiter$annotations() {
    }

    public PreviewExtendArea() {
        super(IPreviewExtendArea.class);
        this.version = 0;
        this.enableClickableArea = 0;
        this.useJson = Boolean.FALSE;
    }

    private final boolean isVSComponentType() {
        Boolean r100 = this.isVSComponent;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return r100.booleanValue();
    L7:
        if (TextUtils.isEmpty(getExtraBusiness()) == true) goto L17;
        String r101 = getExtraBusiness();     // Catch: JSONException -> L14
        Intrinsics.checkNotNull(r101);     // Catch: JSONException -> L14
        int r102 = JSONObjectProtectorUtils.getInt(new JSONObject(r101), "vs_component_type");     // Catch: JSONException -> L14
        boolean r103 = true;
        if (r102 == 1) goto L12;
        r103 = false;
    L12:
        this.isVSComponent = Boolean.valueOf(r103);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.toString();
    L17:
        if (this.isVSComponent != null) goto L19;
        this.isVSComponent = Boolean.FALSE;
    L19:
        Boolean r104 = this.isVSComponent;
        Intrinsics.checkNotNull(r104);
        return r104.booleanValue();
    }

    public final boolean canShowGoldTaskArea() {
        boolean r100 = true;
        if (Intrinsics.areEqual(getUseJson(), Boolean.TRUE) == true) goto L14;
        return true;
    L14:
        if (new JSONObject(getPassThroughJson()).optLong("timestamp") > (System.currentTimeMillis() / ((long) 1000))) goto L11;
        r100 = false;
    L11:
        return r100;
    L16:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public /* bridge */ /* synthetic */ IActionConfig getActionCfg() {
        return getActionCfg();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendAreaEx
    public List<IPart> getBottomPartKmp() {
        return getBottomPart();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public /* bridge */ /* synthetic */ k getExtendIcon() {
        return getExtendIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendAreaEx
    public List<IPart> getMidPartKmp() {
        return getMidPart();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendAreaEx
    public List<IPart> getRightPartKmp() {
        return getRightPart();
    }

    public int hashCode() {
        int r100 = getExtendType() * 31;
        String r101 = getExtendText();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = getExtendPreText();
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ImageModel r108 = getExtendIcon();
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendAreaEx
    public boolean useWithTitleConfig() {
        if (isVSComponentType() == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(getUseTitleFusion(), Boolean.TRUE) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public List<Part> getBottomPart() {
        return this.bottomPart;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public String getButtonPart() {
        return this.buttonPart;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public Integer getComponentType() {
        return this.componentType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public Integer getEnableClickableArea() {
        return this.enableClickableArea;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public Map<String, String> getEtExtra() {
        return this.etExtra;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public String getExtendPreText() {
        return this.extendPreText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public String getExtendText() {
        return this.extendText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public int getExtendType() {
        return this.extendType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public String getExtraBusiness() {
        return this.extraBusiness;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public Map<String, String> getExtraEnterRoom() {
        return this.extraEnterRoom;
    }

    public final boolean getHasExtendAreaShown() {
        return this.hasExtendAreaShown;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public int getIcontype() {
        return this.icontype;
    }

    public final LiveLifeModel getLiveLifeModel() {
        return this.liveLifeModel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public List<Part> getMidPart() {
        return this.midPart;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public boolean getNeedDelimiter() {
        return this.needDelimiter;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public Boolean getNoNeedPoll() {
        return this.noNeedPoll;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public String getPassThroughJson() {
        return this.passThroughJson;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public List<Part> getRightPart() {
        return this.rightPart;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public String getSingleLogResult() {
        return this.singleLogResult;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public Boolean getUseJson() {
        return this.useJson;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public int getUseMarquee() {
        return this.useMarquee;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public Boolean getUseTitleFusion() {
        return this.useTitleFusion;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public Integer getVersion() {
        return this.version;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public ActionConfig getActionCfg() {
        return this.actionCfg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public ImageModel getExtendIcon() {
        return this.extendIcon;
    }

    public PreviewExtendArea(g r110) {
        super(IPreviewExtendArea.class);
        this.rightPart = new ArrayList();
        this.midPart = new ArrayList();
        this.bottomPart = new ArrayList();
        this.extraEnterRoom = new HashMap();
        this.etExtra = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L63;
        g.a r102 = decodeExtensionFields(r101, r110);
        String r111 = null;
        switch(r101) {
            case 1: goto L62;
            case 2: goto L61;
            case 3: goto L60;
            case 4: goto L59;
            case 5: goto L58;
            case 6: goto L57;
            case 7: goto L56;
            case 8: goto L54;
            case 9: goto L53;
            case 10: goto L52;
            case 11: goto L51;
            case 12: goto L50;
            case 13: goto L7;
            case 14: goto L49;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L48;
            case 18: goto L47;
            case 19: goto L46;
            case 20: goto L30;
            case 21: goto L29;
            case 22: goto L28;
            case 23: goto L12;
            case 24: goto L11;
            case 25: goto L10;
            case 26: goto L9;
            case 27: goto L8;
            default: goto L7;
        };
    L8:
        this.componentType = Integer.valueOf(r110.i());
        goto L3
    L9:
        this.singleLogResult = am3.h.c(r110);
        goto L3
    L10:
        this.useTitleFusion = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L11:
        this.enableClickableArea = Integer.valueOf(r110.i());
        goto L3
    L12:
        long r112 = r110.c();
        String r103 = null;
    L13:
        int r104 = r110.f();
        if (r104 == (-1)) goto L20;
        if (r104 != 1) goto L16;
        r111 = am3.h.c(r110);
        goto L13
    L16:
        if (r104 != 2) goto L17;
        r103 = am3.h.c(r110);
        goto L13
    L17:
        am3.h.e(r110);
        goto L13
    L20:
        r110.d(r112);
        Map<String, String> r105 = this.etExtra;
        if (r111 == null) goto L27;
        if (r103 == null) goto L25;
    L41:
        r105.put(r111, r103);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L28:
        this.noNeedPoll = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L29:
        this.extraBusiness = am3.h.c(r110);
        goto L3
    L30:
        long r113 = r110.c();
        r103 = null;
    L31:
        int r106 = r110.f();
        if (r106 == (-1)) goto L38;
        if (r106 != 1) goto L34;
        r111 = am3.h.c(r110);
        goto L31
    L34:
        if (r106 != 2) goto L35;
        r103 = am3.h.c(r110);
        goto L31
    L35:
        am3.h.e(r110);
        goto L31
    L38:
        r110.d(r113);
        r105 = this.extraEnterRoom;
        if (r111 == null) goto L45;
        if (r103 != null) goto L41;
        throw new IllegalStateException("Value must not be null");
    L45:
        throw new IllegalStateException("Key must not be null");
    L46:
        this.passThroughJson = am3.h.c(r110);
        goto L3
    L47:
        this.useJson = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L48:
        this.actionCfg = new ActionConfig(r110);
        goto L3
    L49:
        this.version = Integer.valueOf(r110.i());
        goto L3
    L50:
        List<Part> r107 = this.bottomPart;
        Part r108 = new Part(r110);
    L55:
        r107.add(r108);
        goto L3
    L51:
        this.needDelimiter = am3.h.a(r110);
        goto L3
    L52:
        r107 = this.midPart;
        r108 = new Part(r110);
        goto L55
    L53:
        this.buttonPart = am3.h.c(r110);
        goto L3
    L54:
        r107 = this.rightPart;
        r108 = new Part(r110);
        goto L55
    L56:
        this.icontype = r110.i();
        goto L3
    L57:
        this.useMarquee = r110.i();
        goto L3
    L58:
        this.extra = am3.h.c(r110);
        goto L3
    L59:
        this.extendType = r110.i();
        goto L3
    L60:
        this.extendText = am3.h.c(r110);
        goto L3
    L61:
        this.extendPreText = am3.h.c(r110);
        goto L3
    L62:
        this.extendIcon = x.a(r110);
        goto L3
    L7:
        am3.h.d(r102, r110);
        goto L3
    L63:
        r110.d(r100);
        setThreadSafe(true);
        if (this.version != null) goto L67;
        this.version = 0;
    L67:
        if (this.enableClickableArea != null) goto L70;
        this.enableClickableArea = 0;
    L70:
        if (this.useJson != null) goto L144;
        this.useJson = Boolean.FALSE;
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(PreviewExtendArea.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        PreviewExtendArea r102 = (PreviewExtendArea) r100;
        if (getExtendType() == r102.getExtendType()) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(getExtendText(), r102.getExtendText())) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(getExtendPreText(), r102.getExtendPreText())) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.PreviewExtendArea");
    L8:
        r101 = null;
        goto L10
    }

    public void setActionCfg(ActionConfig r100) {
        this.actionCfg = r100;
    }

    public void setBottomPart(List<Part> r100) {
        this.bottomPart = r100;
    }

    public void setButtonPart(String r100) {
        this.buttonPart = r100;
    }

    public void setComponentType(Integer r100) {
        this.componentType = r100;
    }

    public void setEnableClickableArea(Integer r100) {
        this.enableClickableArea = r100;
    }

    public void setEtExtra(Map<String, String> r100) {
        this.etExtra = r100;
    }

    public void setExtendIcon(ImageModel r100) {
        this.extendIcon = r100;
    }

    public void setExtendPreText(String r100) {
        this.extendPreText = r100;
    }

    public void setExtendText(String r100) {
        this.extendText = r100;
    }

    public void setExtendType(int r100) {
        this.extendType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExtendArea
    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setExtraBusiness(String r100) {
        this.extraBusiness = r100;
    }

    public void setExtraEnterRoom(Map<String, String> r100) {
        this.extraEnterRoom = r100;
    }

    public final void setHasExtendAreaShown(boolean r100) {
        this.hasExtendAreaShown = r100;
    }

    public void setIcontype(int r100) {
        this.icontype = r100;
    }

    public final void setLiveLifeModel(LiveLifeModel r100) {
        this.liveLifeModel = r100;
    }

    public void setMidPart(List<Part> r100) {
        this.midPart = r100;
    }

    public void setNeedDelimiter(boolean r100) {
        this.needDelimiter = r100;
    }

    public void setNoNeedPoll(Boolean r100) {
        this.noNeedPoll = r100;
    }

    public void setPassThroughJson(String r100) {
        this.passThroughJson = r100;
    }

    public void setRightPart(List<Part> r100) {
        this.rightPart = r100;
    }

    public void setSingleLogResult(String r100) {
        this.singleLogResult = r100;
    }

    public void setUseJson(Boolean r100) {
        this.useJson = r100;
    }

    public void setUseMarquee(int r100) {
        this.useMarquee = r100;
    }

    public void setUseTitleFusion(Boolean r100) {
        this.useTitleFusion = r100;
    }

    public void setVersion(Integer r100) {
        this.version = r100;
    }
}
