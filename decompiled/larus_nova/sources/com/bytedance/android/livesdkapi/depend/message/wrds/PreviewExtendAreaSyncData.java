package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.depend.model.live.PreviewAreaActionConfig;
import com.bytedance.android.livesdkapi.depend.model.live.PreviewAreaPart;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewExtendAreaSyncData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\"\b\u0007\u0018\u0000 _2\u00020\u0001:\u0001_B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\\\u001a\u00020>2\b\u0010]\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010^\u001a\u00020&H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R&\u0010!\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R \u0010.\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R,\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R&\u0010:\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR$\u0010=\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u0002\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010D\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0014\"\u0004\bF\u0010\u0016R&\u0010G\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR\u001e\u0010J\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010(\"\u0004\bL\u0010*R\"\u0010M\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001e\u0010S\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010(\"\u0004\bU\u0010*R\"\u0010V\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z¨\u0006`"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewExtendAreaSyncData;", "", "()V", "actionCfg", "Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewAreaActionConfig;", "getActionCfg", "()Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewAreaActionConfig;", "setActionCfg", "(Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewAreaActionConfig;)V", "bottomPart", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewAreaPart;", "getBottomPart", "()Ljava/util/List;", "setBottomPart", "(Ljava/util/List;)V", "buttonPart", "", "getButtonPart$annotations", "getButtonPart", "()Ljava/lang/String;", "setButtonPart", "(Ljava/lang/String;)V", "extendIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getExtendIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setExtendIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "extendPreText", "getExtendPreText$annotations", "getExtendPreText", "setExtendPreText", "extendText", "getExtendText$annotations", "getExtendText", "setExtendText", "extendType", "", "getExtendType", "()I", "setExtendType", "(I)V", "extra", "getExtra", "setExtra", "extraBusiness", "getExtraBusiness", "setExtraBusiness", "extraEnterRoom", "", "getExtraEnterRoom", "()Ljava/util/Map;", "setExtraEnterRoom", "(Ljava/util/Map;)V", "icontype", "getIcontype", "setIcontype", "midPart", "getMidPart", "setMidPart", "needDelimiter", "", "getNeedDelimiter$annotations", "getNeedDelimiter", "()Z", "setNeedDelimiter", "(Z)V", "passThroughJson", "getPassThroughJson", "setPassThroughJson", "rightPart", "getRightPart", "setRightPart", "uiType", "getUiType", "setUiType", "useJson", "getUseJson", "()Ljava/lang/Boolean;", "setUseJson", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useMarquee", "getUseMarquee", "setUseMarquee", "version", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equals", "other", "hashCode", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewExtendAreaSyncData implements h {
    public static final Companion Companion = null;
    public static final int PK_SCENE = 9;
    public static final String SYNC_KEY = "PreviewExtendAreaSyncData";

    @SerializedName("action_cfg")
    protected PreviewAreaActionConfig actionCfg;

    @SerializedName("bottom_part")
    protected List<PreviewAreaPart> bottomPart;

    @SerializedName("button_part")
    protected String buttonPart;

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

    @SerializedName("icon_type")
    protected int icontype;

    @SerializedName("mid_part")
    protected List<PreviewAreaPart> midPart;

    @SerializedName("need_delimiter")
    protected boolean needDelimiter;

    @SerializedName("pass_through_extra_json")
    protected String passThroughJson;

    @SerializedName("right_part")
    protected List<PreviewAreaPart> rightPart;

    @SerializedName("ui_type")
    protected int uiType;

    @SerializedName("use_pass_through_extra_json")
    protected Boolean useJson;

    @SerializedName("use_marquee")
    protected int useMarquee;

    @SerializedName("version")
    protected Integer version;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewExtendAreaSyncData$Companion;", "", "()V", "PK_SCENE", "", "SYNC_KEY", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
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

    public int hashCode() {
        int r100 = this.extendType * 31;
        String r101 = this.extendText;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.extendPreText;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ImageModel r108 = this.extendIcon;
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

    public PreviewExtendAreaSyncData() {
        this.version = 0;
        this.useJson = Boolean.FALSE;
    }

    public final PreviewAreaActionConfig getActionCfg() {
        return this.actionCfg;
    }

    public final List<PreviewAreaPart> getBottomPart() {
        return this.bottomPart;
    }

    public final String getButtonPart() {
        return this.buttonPart;
    }

    public final ImageModel getExtendIcon() {
        return this.extendIcon;
    }

    public final String getExtendPreText() {
        return this.extendPreText;
    }

    public final String getExtendText() {
        return this.extendText;
    }

    public final int getExtendType() {
        return this.extendType;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getExtraBusiness() {
        return this.extraBusiness;
    }

    public final Map<String, String> getExtraEnterRoom() {
        return this.extraEnterRoom;
    }

    public final int getIcontype() {
        return this.icontype;
    }

    public final List<PreviewAreaPart> getMidPart() {
        return this.midPart;
    }

    public final boolean getNeedDelimiter() {
        return this.needDelimiter;
    }

    public final String getPassThroughJson() {
        return this.passThroughJson;
    }

    public final List<PreviewAreaPart> getRightPart() {
        return this.rightPart;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final Boolean getUseJson() {
        return this.useJson;
    }

    public final int getUseMarquee() {
        return this.useMarquee;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public PreviewExtendAreaSyncData(g r110) {
        this.rightPart = new ArrayList();
        this.midPart = new ArrayList();
        this.bottomPart = new ArrayList();
        this.extraEnterRoom = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L44;
        switch(r101) {
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            case 14: goto L29;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L28;
            case 18: goto L27;
            case 19: goto L26;
            case 20: goto L8;
            case 21: goto L7;
            default: goto L6;
        };
    L7:
        this.extraBusiness = am3.h.c(r110);
        goto L3
    L8:
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L9:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L9
    L14:
        if (r105 != 2) goto L15;
        r104 = am3.h.c(r110);
        goto L9
    L15:
        am3.h.e(r110);
        goto L9
    L18:
        r110.d(r102);
        Map<String, String> r106 = this.extraEnterRoom;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L26:
        this.passThroughJson = am3.h.c(r110);
        goto L3
    L27:
        this.useJson = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L28:
        this.actionCfg = new PreviewAreaActionConfig(r110);
        goto L3
    L29:
        this.version = Integer.valueOf(r110.i());
        goto L3
    L30:
        this.uiType = r110.i();
        goto L3
    L31:
        List<PreviewAreaPart> r107 = this.bottomPart;
        PreviewAreaPart r108 = new PreviewAreaPart(r110);
    L36:
        r107.add(r108);
        goto L3
    L32:
        this.needDelimiter = am3.h.a(r110);
        goto L3
    L33:
        r107 = this.midPart;
        r108 = new PreviewAreaPart(r110);
        goto L36
    L34:
        this.buttonPart = am3.h.c(r110);
        goto L3
    L35:
        r107 = this.rightPart;
        r108 = new PreviewAreaPart(r110);
        goto L36
    L37:
        this.icontype = r110.i();
        goto L3
    L38:
        this.useMarquee = r110.i();
        goto L3
    L39:
        this.extra = am3.h.c(r110);
        goto L3
    L40:
        this.extendType = r110.i();
        goto L3
    L41:
        this.extendText = am3.h.c(r110);
        goto L3
    L42:
        this.extendPreText = am3.h.c(r110);
        goto L3
    L43:
        this.extendIcon = x.a(r110);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L44:
        r110.d(r100);
        if (this.version != null) goto L48;
        this.version = 0;
    L48:
        if (this.useJson != null) goto L102;
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
        if ((!Intrinsics.areEqual(PreviewExtendAreaSyncData.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        PreviewExtendAreaSyncData r102 = (PreviewExtendAreaSyncData) r100;
        if (this.extendType == r102.extendType) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.extendText, r102.extendText)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.extendPreText, r102.extendPreText)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.message.wrds.PreviewExtendAreaSyncData");
    L8:
        r101 = null;
        goto L10
    }

    public final void setActionCfg(PreviewAreaActionConfig r100) {
        this.actionCfg = r100;
    }

    public final void setBottomPart(List<PreviewAreaPart> r100) {
        this.bottomPart = r100;
    }

    public final void setButtonPart(String r100) {
        this.buttonPart = r100;
    }

    public final void setExtendIcon(ImageModel r100) {
        this.extendIcon = r100;
    }

    public final void setExtendPreText(String r100) {
        this.extendPreText = r100;
    }

    public final void setExtendText(String r100) {
        this.extendText = r100;
    }

    public final void setExtendType(int r100) {
        this.extendType = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setExtraBusiness(String r100) {
        this.extraBusiness = r100;
    }

    public final void setExtraEnterRoom(Map<String, String> r100) {
        this.extraEnterRoom = r100;
    }

    public final void setIcontype(int r100) {
        this.icontype = r100;
    }

    public final void setMidPart(List<PreviewAreaPart> r100) {
        this.midPart = r100;
    }

    public final void setNeedDelimiter(boolean r100) {
        this.needDelimiter = r100;
    }

    public final void setPassThroughJson(String r100) {
        this.passThroughJson = r100;
    }

    public final void setRightPart(List<PreviewAreaPart> r100) {
        this.rightPart = r100;
    }

    public final void setUiType(int r100) {
        this.uiType = r100;
    }

    public final void setUseJson(Boolean r100) {
        this.useJson = r100;
    }

    public final void setUseMarquee(int r100) {
        this.useMarquee = r100;
    }

    public final void setVersion(Integer r100) {
        this.version = r100;
    }
}
