package com.bytedance.android.shopping.anchorv4.dto.business;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.BaseSlice;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.style.SlcStyle;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B·\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017¢\u0006\u0002\u0010\u001aJ½\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017¢\u0006\u0002\u0010*R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\r\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "Lcom/bytedance/android/ecom/arch/slice/BaseSlice;", "Ljava/io/Serializable;", "componentId", "", "vo", "Lcom/bytedance/android/shopping/anchorv4/dto/business/VO;", "version", "", "ui", "Lcom/bytedance/android/shopping/anchorv4/dto/business/UI;", GXTemplateKey.GAIAX_TRACK, "Lcom/google/gson/JsonObject;", "isHide", "", "sliceType", "sliceId", "viewType", "style", "Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;", "showAction", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "trackMeta", "", "config", "", "(Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/business/VO;ILcom/bytedance/android/shopping/anchorv4/dto/business/UI;Lcom/google/gson/JsonObject;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;Ljava/util/Map;)V", "getComponentId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "setHide", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTrack", "()Lcom/google/gson/JsonObject;", "getUi", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/UI;", "getVersion", "()I", "getVo", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/VO;", "copy", "(Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/business/VO;ILcom/bytedance/android/shopping/anchorv4/dto/business/UI;Lcom/google/gson/JsonObject;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;Ljava/util/Map;)Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentDTO extends BaseSlice implements Serializable {

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("is_hide")
    private Boolean isHide;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final JsonObject track;

    /* JADX INFO: renamed from: ui, reason: collision with root package name */
    @SerializedName("ui")
    private final UI f166517ui;

    @SerializedName("version")
    private final int version;

    /* JADX INFO: renamed from: vo, reason: collision with root package name */
    @SerializedName("vo")
    private final VO f166518vo;

    public ComponentDTO() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final JsonObject getTrack() {
        return this.track;
    }

    public final UI getUi() {
        return this.f166517ui;
    }

    public final int getVersion() {
        return this.version;
    }

    public final VO getVo() {
        return this.f166518vo;
    }

    public final Boolean isHide() {
        return this.isHide;
    }

    public final void setHide(Boolean r100) {
        this.isHide = r100;
    }

    public ComponentDTO(String r110, VO r111, int r112, UI r113, JsonObject r114, Boolean r210, String r211, String r212, String r213, SlcStyle r214, IAction r215, Map<String, String> r216, Map<String, ? extends Object> r217) {
        super(r211, r212, r213, r214, null, r215, r216, r217, null, null, 784, null);
        this.componentId = r110;
        this.f166518vo = r111;
        this.version = r112;
        this.f166517ui = r113;
        this.track = r114;
        this.isHide = r210;
    }

    public final ComponentDTO copy(String r110, VO r111, int r112, UI r113, JsonObject r210, Boolean r211, String r212, String r213, String r214, SlcStyle r215, IAction r216, Map<String, String> r217, Map<String, ? extends Object> r218) {
        return new ComponentDTO(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public /* synthetic */ ComponentDTO(String r110, VO r111, int r112, UI r113, JsonObject r114, Boolean r210, String r211, String r212, String r213, SlcStyle r214, IAction r215, Map r216, Map r217, int r218, DefaultConstructorMarker r219) {
        Map r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        VO r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r218 & 8) == 0) goto L17;
        UI r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        JsonObject r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Boolean r106 = Boolean.FALSE;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r218 & 512) == 0) goto L41;
        SlcStyle r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        IAction r117 = null;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Map r118 = null;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r100 = r217;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ComponentDTO copy$default(ComponentDTO r110, String r111, VO r112, int r113, UI r114, JsonObject r115, Boolean r210, String r211, String r212, String r213, SlcStyle r214, IAction r215, Map r216, Map r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.componentId;
    L7:
        if ((r218 & 2) == 0) goto L9;
        VO r101 = r110.f166518vo;
    L11:
        if ((r218 & 4) == 0) goto L13;
        int r102 = r110.version;
    L15:
        if ((r218 & 8) == 0) goto L17;
        UI r103 = r110.f166517ui;
    L19:
        if ((r218 & 16) == 0) goto L21;
        JsonObject r104 = r110.track;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Boolean r105 = r110.isHide;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r106 = r110.getSliceType();
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.getSliceId();
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.getViewType();
    L39:
        if ((r218 & 512) == 0) goto L41;
        SlcStyle r117 = r110.getStyle();
    L43:
        if ((r218 & 1024) == 0) goto L45;
        IAction r118 = r110.getShowAction();
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Map r119 = r110.getTrackMeta();
    L51:
        if ((r218 & 4096) == 0) goto L53;
        Map r108 = r110.getConfig();
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
