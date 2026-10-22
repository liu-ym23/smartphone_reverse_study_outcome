package com.bytedance.android.annie.scheme.vo.refactor;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.annie.scheme.convert.HybridTypeNew;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\n\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001FR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u0005\u0010\tR\"\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010(\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\"\u0010+\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\"\u0010.\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\"\u00101\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\"\u00104\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u001d\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R$\u00107\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001d\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R$\u0010:\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u00103\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\t¨\u0006G"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/HybridSchemaParam;", "Lcom/bytedance/android/annie/scheme/vo/refactor/RealBaseParamVo;", "", "hideStatusBar", "Z", RXScreenCaptureService.KEY_INDEX, "()Z", "O", "(Z)V", "isFullScreen", "D", "L", "transStatusBar", "r", "pullDownClose", "q", "Y", "enableEngineViewScroll", "c", "setEnableEngineViewScroll", "isOutUrl", "Ljava/lang/Boolean;", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/Boolean;", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/Boolean;)V", "", "originSchema", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "U", "(Ljava/lang/String;)V", "enableViewRemove", "d", "J", "loaderName", ce.f26395j, "R", "errorPageTheme", "e", "K", "openContainerID", ce.f26396k, ExifInterface.LATITUDE_SOUTH, "webNestedScroll", "t", "setWebNestedScroll", "closeAfterSuccess", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "xBridgeRegisterStrategy", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "setXBridgeRegisterStrategy", "webBgColor", "s", "a0", "gradientBgColor", ce.f26391f, "M", "", "gradientColorPercent", "h", "()I", "N", "(I)V", "disableWebviewSelectMenus", "b", "setDisableWebviewSelectMenus", "HybridType", "annie_release"}, k = 1, mv = {1, 4, 3})
public class BaseHybridParamVoNew extends HybridSchemaParam {
    public static final Parcelable.Creator<BaseHybridParamVoNew> CREATOR = null;
    public final Lazy R;
    public final Lazy S;
    public v8.a T;

    @SerializedName("_close_after_open_success")
    private boolean closeAfterSuccess;

    @SerializedName("disable_webview_select_menus")
    private boolean disableWebviewSelectMenus;

    @SerializedName("enable_engine_view_scroll")
    private boolean enableEngineViewScroll;

    @SerializedName("live_enable_view_remove")
    private boolean enableViewRemove;

    @SerializedName("error_page_theme")
    private String errorPageTheme;

    @SerializedName("gradient_bg_color")
    private String gradientBgColor;

    @SerializedName("gradient_color_percent")
    private int gradientColorPercent;

    @SerializedName("hide_status_bar")
    private boolean hideStatusBar;

    @SerializedName("is_full_screen")
    private boolean isFullScreen;

    @SerializedName("is_out_url")
    private Boolean isOutUrl;

    @SerializedName("loader_name")
    private String loaderName;

    @SerializedName("_open_container_id")
    private String openContainerID;

    @SerializedName("origin_schema")
    private String originSchema;

    @SerializedName(AppConstants.BUNDLE_PULL_DOWN_CLOSE)
    private boolean pullDownClose;

    @SerializedName(AppConstants.TRANS_STATUS_BAR)
    private boolean transStatusBar;

    @SerializedName("web_bg_color")
    private String webBgColor;

    @SerializedName("web_nested_scroll")
    private boolean webNestedScroll;

    @SerializedName("xbridge_register_strategy")
    private String xBridgeRegisterStrategy;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;", "", "", "toMonitorString", "H5", "LYNX", "HOST_H5", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        public static final HybridType H5 = null;
        public static final HybridType HOST_H5 = null;
        public static final HybridType LYNX = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HybridType[] f39810a = null;

        public static HybridType valueOf(String r100) {
            return (HybridType) r27.a.a(HybridType.class, r100);
        }

        public static HybridType[] values() {
            return (HybridType[]) f39810a.clone();
        }

        static {
            HybridType r100 = new HybridType("H5", 0);
            H5 = r100;
            HybridType r101 = new HybridType("LYNX", 1);
            LYNX = r101;
            HybridType r102 = new HybridType("HOST_H5", 2);
            HOST_H5 = r102;
            f39810a = new HybridType[]{r100, r101, r102};
        }

        public final String toMonitorString() {
            if (this != LYNX) goto L5;
            return "lynx";
        L5:
            return "web";
        }

        public HybridType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements Parcelable.Creator<BaseHybridParamVoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseHybridParamVoNew createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            if (r210.readInt() == 0) goto L5;
            boolean r100 = true;
        L7:
            if (r210.readInt() == 0) goto L9;
            boolean r101 = true;
        L11:
            if (r210.readInt() == 0) goto L13;
            boolean r102 = true;
        L15:
            if (r210.readInt() == 0) goto L17;
            boolean r103 = true;
        L19:
            if (r210.readInt() == 0) goto L21;
            boolean r104 = true;
        L23:
            if (r210.readInt() != 0) goto L26;
            Boolean r105 = null;
        L30:
            String r110 = r210.readString();
            if (r210.readInt() == 0) goto L33;
            boolean r111 = true;
        L34:
            String r112 = r210.readString();
            String r113 = r210.readString();
            String r114 = r210.readString();
            if (r210.readInt() == 0) goto L37;
            boolean r115 = true;
        L39:
            if (r210.readInt() == 0) goto L41;
            boolean r116 = true;
        L42:
            String r117 = r210.readString();
            String r118 = r210.readString();
            String r119 = r210.readString();
            int r211 = r210.readInt();
            if (r210.readInt() == 0) goto L45;
            boolean r212 = true;
        L47:
            return new BaseHybridParamVoNew(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212);
        L45:
            r212 = false;
            goto L47
        L41:
            r116 = false;
            goto L42
        L37:
            r115 = false;
            goto L39
        L33:
            r111 = false;
            goto L34
        L26:
            if (r210.readInt() == 0) goto L28;
            boolean r106 = true;
        L29:
            r105 = Boolean.valueOf(r106);
            goto L30
        L28:
            r106 = false;
            goto L29
        L21:
            r104 = false;
            goto L23
        L17:
            r103 = false;
            goto L19
        L13:
            r102 = false;
            goto L15
        L9:
            r101 = false;
            goto L11
        L5:
            r100 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BaseHybridParamVoNew[] newArray(int r100) {
            return new BaseHybridParamVoNew[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BaseHybridParamVoNew() {
        this(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    @Override // com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(this.hideStatusBar ? 1 : 0);
        r100.writeInt(this.isFullScreen ? 1 : 0);
        r100.writeInt(this.transStatusBar ? 1 : 0);
        r100.writeInt(this.pullDownClose ? 1 : 0);
        r100.writeInt(this.enableEngineViewScroll ? 1 : 0);
        Boolean r102 = this.isOutUrl;
        if (r102 != null) goto L6;
        ?? r103 = 0;
    L5:
        r100.writeInt(r103);
        r100.writeString(this.originSchema);
        r100.writeInt(this.enableViewRemove ? 1 : 0);
        r100.writeString(this.loaderName);
        r100.writeString(this.errorPageTheme);
        r100.writeString(this.openContainerID);
        r100.writeInt(this.webNestedScroll ? 1 : 0);
        r100.writeInt(this.closeAfterSuccess ? 1 : 0);
        r100.writeString(this.xBridgeRegisterStrategy);
        r100.writeString(this.webBgColor);
        r100.writeString(this.gradientBgColor);
        r100.writeInt(this.gradientColorPercent);
        r100.writeInt(this.disableWebviewSelectMenus ? 1 : 0);
        return;
    L6:
        r100.writeInt(1);
        r103 = r102.booleanValue();
        goto L5
    }

    public String toString() {
        return super.toString() + "BaseHybridParamVo(hideStatusBar=" + this.hideStatusBar + ", hybridType=" + this.f39813a + ", pullDownClose=" + this.pullDownClose + ", enableEngineViewScroll=" + this.enableEngineViewScroll + ", isOutUrl=" + this.isOutUrl + ", url=" + this.f39814b + ", originSchema=" + this.originSchema + ", loaderName='" + this.loaderName + "', fallbackSchema=" + this.f39815c + ", webBgColor=" + this.webBgColor + ", gradientBgColor=" + this.gradientBgColor + ", gradientColorPercent=" + this.gradientColorPercent + ')';
    }

    public final boolean D() {
        return this.isFullScreen;
    }

    public final Boolean E() {
        return this.isOutUrl;
    }

    public final boolean a() {
        return this.closeAfterSuccess;
    }

    public final boolean b() {
        return this.disableWebviewSelectMenus;
    }

    public final boolean c() {
        return this.enableEngineViewScroll;
    }

    public final boolean d() {
        return this.enableViewRemove;
    }

    public final String e() {
        return this.errorPageTheme;
    }

    public final String g() {
        return this.gradientBgColor;
    }

    public final int h() {
        return this.gradientColorPercent;
    }

    public final boolean i() {
        return this.hideStatusBar;
    }

    public final String j() {
        return this.loaderName;
    }

    public final String k() {
        return this.openContainerID;
    }

    public final String o() {
        return this.originSchema;
    }

    public final boolean q() {
        return this.pullDownClose;
    }

    public final boolean r() {
        return this.transStatusBar;
    }

    public final String s() {
        return this.webBgColor;
    }

    public final boolean t() {
        return this.webNestedScroll;
    }

    public final String z() {
        return this.xBridgeRegisterStrategy;
    }

    public /* synthetic */ BaseHybridParamVoNew(int r210) {
        this(false, false, false, false, false, Boolean.FALSE, "", false, "", "default", "", false, false, "all", "", "", 0, false);
    }

    public void F(u8.a r310) {
        v8.a r100 = r310.f549148e;
        if (r100 != null) goto L5;
        r100 = new v8.a(r310.f549145b, r310.f549144a, r310.f549146c);
    L5:
        this.T = r100;
        String r101 = r310.f549144a;
        if (r101 != null) goto L8;
        r101 = (String) r100.b("url", "");
    L8:
        String r102 = (String) r100.b("enter_from", "");
        String r103 = (String) r100.b("is_out_url", "");
        if (((Number) r100.b("hide_status_bar", 0)).intValue() != 1) goto L11;
        boolean r104 = true;
    L13:
        if (((Number) r100.b(AppConstants.BUNDLE_PULL_DOWN_CLOSE, 0)).intValue() != 1) goto L15;
        boolean r110 = true;
    L17:
        if (((Number) r100.b("enable_pull_down_close", 0)).intValue() != 1) goto L19;
        boolean r111 = true;
    L21:
        if (((Number) r100.b("enable_engine_view_scroll", 0)).intValue() != 1) goto L23;
        boolean r112 = true;
    L25:
        if (((Number) r100.b("live_enable_view_remove", 0)).intValue() != 1) goto L27;
        boolean r113 = true;
    L28:
        ((Number) r100.b("enable_prefetch", 0)).intValue();
        String r114 = (String) r100.b("loader_name", "");
        String r105 = (String) r100.b("error_page_theme", "default");
        boolean r106 = ((Boolean) r100.b(AppConstants.BUNDLE_LIVE_WEBVIEW_OFFLINEENABLE, Boolean.TRUE)).booleanValue();
        String r115 = (String) r100.b("_open_container_id", "");
        String r116 = r101;
        if (((Number) r100.b("_close_after_open_success", 0)).intValue() != 1) goto L31;
        boolean r107 = true;
    L32:
        String r108 = (String) r100.b("fallback_url", "");
        String r109 = (String) r100.b(AppConstants.BUNDLE_FALLBACK_URL, "");
        boolean r210 = r107;
        String r117 = (String) r100.b("xbridge_register_strategy", "all");
        Uri r118 = r310.f549145b;
        if (r118 == null) goto L38;
        String r119 = r118.toString();
        if (r119 == null) goto L38;
    L39:
        boolean r120 = ((Boolean) r100.b("is_fullScreen", Boolean.FALSE)).booleanValue();
        if (((Number) r100.b(AppConstants.TRANS_STATUS_BAR, 0)).intValue() != 1) goto L42;
        boolean r121 = true;
    L43:
        boolean r211 = r121;
        int r122 = ((Number) r100.b("preset_width_px", -1)).intValue();
        int r123 = ((Number) r100.b("lynx_thread", 0)).intValue();
        String r124 = (String) r100.b("web_bg_color", "");
        String r125 = (String) r100.b("gradient_bg_color", "");
        int r126 = ((Number) r100.b("gradient_color_percent", 0)).intValue();
        if (((Number) r100.b("disable_webview_select_menus", 0)).intValue() != 1) goto L46;
        boolean r127 = true;
    L48:
        if (r310.f549147d != HybridTypeNew.Lynx) goto L50;
        HybridKitType r128 = HybridKitType.LYNX;
    L51:
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        this.f39813a = r128;
        this.hideStatusBar = r104;
        if (r110 == true) goto L56;
        if (r111 == true) goto L56;
        boolean r129 = false;
    L57:
        this.pullDownClose = r129;
        this.enableEngineViewScroll = r112;
        if (Intrinsics.areEqual("is_from_out_scene", r103) == false) goto L60;
    L63:
        boolean r130 = true;
    L64:
        this.isOutUrl = Boolean.valueOf(r130);
        this.originSchema = r119;
        this.enableViewRemove = r113;
        this.loaderName = r114;
        this.errorPageTheme = r105;
        this.openContainerID = r115;
        this.closeAfterSuccess = r210;
        this.xBridgeRegisterStrategy = r117;
        if (r108.length() != 0) goto L67;
        boolean r131 = true;
    L68:
        if (r131 == false) goto L70;
        String r132 = r109;
    L71:
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        this.f39815c = r132;
        this.isFullScreen = r120;
        this.transStatusBar = r211;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f39814b = r116;
        this.f39818f = !r106;
        this.f39837y = r122;
        this.D = r123;
        this.webBgColor = r124;
        if (((Number) r100.b("web_nested_scroll", 0)).intValue() != 1) goto L74;
        boolean r133 = true;
    L75:
        this.webNestedScroll = r133;
        this.gradientBgColor = r125;
        this.gradientColorPercent = r126;
        this.disableWebviewSelectMenus = r127;
        return;
    L74:
        r133 = false;
        goto L75
    L70:
        r132 = r108;
        goto L71
    L67:
        r131 = false;
        goto L68
    L60:
        if (Intrinsics.areEqual(MemorySourceLinkType.DEEPLINK, r102) == true) goto L63;
        r130 = false;
    L56:
        r129 = true;
        goto L57
    L50:
        r128 = HybridKitType.WEB;
        goto L51
    L46:
        r127 = false;
        goto L48
    L42:
        r121 = false;
    L38:
        r119 = "";
        goto L39
    L31:
        r107 = false;
        goto L32
    L27:
        r113 = false;
        goto L28
    L23:
        r112 = false;
        goto L25
    L19:
        r111 = false;
        goto L21
    L15:
        r110 = false;
        goto L17
    L11:
        r104 = false;
        goto L13
    }

    public final void I(boolean r100) {
        this.closeAfterSuccess = r100;
    }

    public final void J(boolean r100) {
        this.enableViewRemove = r100;
    }

    public final void K(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorPageTheme = r100;
    }

    public final void L(boolean r100) {
        this.isFullScreen = r100;
    }

    public final void M(String r100) {
        this.gradientBgColor = r100;
    }

    public final void N(int r100) {
        this.gradientColorPercent = r100;
    }

    public final void O(boolean r100) {
        this.hideStatusBar = r100;
    }

    public final void R(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loaderName = r100;
    }

    public final void S(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openContainerID = r100;
    }

    public final void U(String r100) {
        this.originSchema = r100;
    }

    public final void W(Boolean r100) {
        this.isOutUrl = r100;
    }

    public final void Y(boolean r100) {
        this.pullDownClose = r100;
    }

    public final void Z(boolean r100) {
        this.transStatusBar = r100;
    }

    public final void a0(String r100) {
        this.webBgColor = r100;
    }

    public BaseHybridParamVoNew(boolean r100, boolean r101, boolean r102, boolean r110, boolean r111, Boolean r112, String r113, boolean r114, String r115, String r116, String r117, boolean r118, boolean r119, String r210, String r211, String r212, int r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r115, "loaderName");
        Intrinsics.checkNotNullParameter(r116, "errorPageTheme");
        Intrinsics.checkNotNullParameter(r117, "openContainerID");
        Intrinsics.checkNotNullParameter(r210, "xBridgeRegisterStrategy");
        super(0);
        this.hideStatusBar = r100;
        this.isFullScreen = r101;
        this.transStatusBar = r102;
        this.pullDownClose = r110;
        this.enableEngineViewScroll = r111;
        this.isOutUrl = r112;
        this.originSchema = r113;
        this.enableViewRemove = r114;
        this.loaderName = r115;
        this.errorPageTheme = r116;
        this.openContainerID = r117;
        this.webNestedScroll = r118;
        this.closeAfterSuccess = r119;
        this.xBridgeRegisterStrategy = r210;
        this.webBgColor = r211;
        this.gradientBgColor = r212;
        this.gradientColorPercent = r213;
        this.disableWebviewSelectMenus = r214;
        this.R = LazyKt.lazy(new BaseHybridParamVoNew$noQueryUrl$2(this));
        this.S = LazyKt.lazy(new BaseHybridParamVoNew$noQueryUrlWithID$2(this));
    }
}
