package com.bytedance.android.annie.scheme.vo.refactor;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.doc.structure.StructurePlugin;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\"\u0010)\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\"\u00102\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00105\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0012\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0012\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R\"\u0010>\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0012\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0012\u001a\u0004\bI\u0010\u0014\"\u0004\bJ\u0010\u0016R\"\u0010K\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u000b\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010\u000f¨\u0006N"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/CardParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;", "pageType", "Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;", "I0", "()Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;", "l1", "(Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;)V", "", "enableAppCache", "Z", "i0", "()Z", "T0", "(Z)V", "", "headStr", "Ljava/lang/String;", "C0", "()Ljava/lang/String;", "e1", "(Ljava/lang/String;)V", "loadNoCache", "G0", DoraObricDeviceHomeViewModel.PRODUCT_CODE_G1, "disableHostJsbMethod", "c0", "R0", "disableThreadSpread", "f0", "S0", "createViewAsync", "b0", "O0", StructurePlugin.ENABLE_FONT_SCALE, "o0", "Z0", "enableViewZoom", "v0", "c1", "hidePoster", "F0", "f1", "scene", "K0", "r1", "enableCodeCache", "j0", "X0", "enableResourceLock", "p0", "b1", "forestSessionID", "y0", "d1", "isSetScreenSize", "N0", "s1", "monitorReportPerf", "H0", "h1", "forestDownloadEngine", "w0", "setForestDownloadEngine", "", "webForestMode", "I", "M0", "()I", "setWebForestMode", "(I)V", AppConstants.BUNDLE_REFERER, "J0", DevicePlans.DEVICE_PLAN_OPPO1, "useScreenHeight", "L0", "setUseScreenHeight", "annie_release"}, k = 1, mv = {1, 4, 3})
public class CardParamVoNew extends BaseHybridParamVoNew {
    public static final Parcelable.Creator<CardParamVoNew> CREATOR = null;

    @SerializedName("create_view_async")
    private boolean createViewAsync;

    @SerializedName("disable_host_jsb_method")
    private boolean disableHostJsbMethod;

    @SerializedName("disable_thread_spread")
    private boolean disableThreadSpread;

    @SerializedName("enable_app_cache")
    private boolean enableAppCache;

    @SerializedName("enable_code_cache")
    private boolean enableCodeCache;

    @SerializedName("enable_font_scale")
    private String enableFontScale;

    @SerializedName("lock_resource")
    private boolean enableResourceLock;

    @SerializedName("enable_view_zoom")
    private boolean enableViewZoom;

    @SerializedName("forest_download_engine")
    private String forestDownloadEngine;

    @SerializedName("forest_session_id")
    private String forestSessionID;

    @SerializedName("head_str")
    private String headStr;

    @SerializedName("hide_poster")
    private boolean hidePoster;

    @SerializedName("screen_size_adaptation")
    private boolean isSetScreenSize;

    @SerializedName("load_no_cache")
    private boolean loadNoCache;

    @SerializedName("monitor_report_perf")
    private String monitorReportPerf;

    @SerializedName("page_type")
    private PageType pageType;

    @SerializedName(AppConstants.BUNDLE_REFERER)
    private String referer;

    @SerializedName("scene")
    private String scene;

    @SerializedName("use_screen_height")
    private boolean useScreenHeight;

    @SerializedName("web_forest_mode")
    private int webForestMode;

    public static final class a implements Parcelable.Creator<CardParamVoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CardParamVoNew createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            PageType r100 = PageType.valueOf(r210.readString());
            if (r210.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            String r102 = r210.readString();
            if (r210.readInt() == 0) goto L9;
            boolean r103 = true;
        L11:
            if (r210.readInt() == 0) goto L13;
            boolean r104 = true;
        L15:
            if (r210.readInt() == 0) goto L17;
            boolean r105 = true;
        L19:
            if (r210.readInt() == 0) goto L21;
            boolean r110 = true;
        L22:
            String r111 = r210.readString();
            if (r210.readInt() == 0) goto L25;
            boolean r112 = true;
        L27:
            if (r210.readInt() == 0) goto L29;
            boolean r113 = true;
        L30:
            String r114 = r210.readString();
            if (r210.readInt() == 0) goto L33;
            boolean r115 = true;
        L35:
            if (r210.readInt() == 0) goto L37;
            boolean r116 = true;
        L38:
            String r117 = r210.readString();
            if (r210.readInt() == 0) goto L41;
            boolean r118 = true;
        L42:
            String r119 = r210.readString();
            String r211 = r210.readString();
            int r212 = r210.readInt();
            String r213 = r210.readString();
            if (r210.readInt() == 0) goto L45;
            boolean r214 = true;
        L47:
            return new CardParamVoNew(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214);
        L45:
            r214 = false;
            goto L47
        L41:
            r118 = false;
            goto L42
        L37:
            r116 = false;
            goto L38
        L33:
            r115 = false;
            goto L35
        L29:
            r113 = false;
            goto L30
        L25:
            r112 = false;
            goto L27
        L21:
            r110 = false;
            goto L22
        L17:
            r105 = false;
            goto L19
        L13:
            r104 = false;
            goto L15
        L9:
            r103 = false;
            goto L11
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CardParamVoNew[] newArray(int r100) {
            return new CardParamVoNew[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CardParamVoNew() {
        this(0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.pageType.name());
        r100.writeInt(this.enableAppCache ? 1 : 0);
        r100.writeString(this.headStr);
        r100.writeInt(this.loadNoCache ? 1 : 0);
        r100.writeInt(this.disableHostJsbMethod ? 1 : 0);
        r100.writeInt(this.disableThreadSpread ? 1 : 0);
        r100.writeInt(this.createViewAsync ? 1 : 0);
        r100.writeString(this.enableFontScale);
        r100.writeInt(this.enableViewZoom ? 1 : 0);
        r100.writeInt(this.hidePoster ? 1 : 0);
        r100.writeString(this.scene);
        r100.writeInt(this.enableCodeCache ? 1 : 0);
        r100.writeInt(this.enableResourceLock ? 1 : 0);
        r100.writeString(this.forestSessionID);
        r100.writeInt(this.isSetScreenSize ? 1 : 0);
        r100.writeString(this.monitorReportPerf);
        r100.writeString(this.forestDownloadEngine);
        r100.writeInt(this.webForestMode);
        r100.writeString(this.referer);
        r100.writeInt(this.useScreenHeight ? 1 : 0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(super.toString());
        r100.append("\nCardParamVo(enableAppCache=");
        r100.append(this.enableAppCache);
        r100.append(", headStr=");
        r100.append(this.headStr);
        r100.append(", loadNoCache=");
        r100.append(this.loadNoCache);
        r100.append(", offlineEnable=");
        r100.append(!this.f39818f);
        r100.append(", disableHostJsbMethod=");
        r100.append(this.disableHostJsbMethod);
        r100.append(", referer=");
        r100.append(this.referer);
        r100.append(", disableThreadSpread=");
        r100.append(this.disableThreadSpread);
        r100.append(", presetWidth=");
        r100.append(this.f39837y);
        r100.append(", createViewAsync=");
        r100.append(this.createViewAsync);
        r100.append(", isSetScreenSize=");
        r100.append(this.isSetScreenSize);
        r100.append(", monitorReportPerf=");
        r100.append(this.monitorReportPerf);
        r100.append(", enableFontScale=");
        r100.append(this.enableFontScale);
        r100.append(", enableViewZoom=");
        r100.append(this.enableViewZoom);
        r100.append(", hidePoster=");
        r100.append(this.hidePoster);
        r100.append(", enableCodeCache=");
        r100.append(this.enableCodeCache);
        r100.append(", forestSessionID=");
        r100.append(this.forestSessionID);
        r100.append(", enableResourceLock=");
        r100.append(this.enableResourceLock);
        r100.append(", useScreenHeight=");
        r100.append(this.useScreenHeight);
        r100.append(')');
        return r100.toString();
    }

    public final String C0() {
        return this.headStr;
    }

    public final boolean F0() {
        return this.hidePoster;
    }

    public final boolean G0() {
        return this.loadNoCache;
    }

    public final String H0() {
        return this.monitorReportPerf;
    }

    public final PageType I0() {
        return this.pageType;
    }

    public final String J0() {
        return this.referer;
    }

    public final String K0() {
        return this.scene;
    }

    public final boolean L0() {
        return this.useScreenHeight;
    }

    public final int M0() {
        return this.webForestMode;
    }

    public final boolean N0() {
        return this.isSetScreenSize;
    }

    public final boolean b0() {
        return this.createViewAsync;
    }

    public final boolean c0() {
        return this.disableHostJsbMethod;
    }

    public final boolean f0() {
        return this.disableThreadSpread;
    }

    public final boolean i0() {
        return this.enableAppCache;
    }

    public final boolean j0() {
        return this.enableCodeCache;
    }

    public final String o0() {
        return this.enableFontScale;
    }

    public final boolean p0() {
        return this.enableResourceLock;
    }

    public final boolean v0() {
        return this.enableViewZoom;
    }

    public final String w0() {
        return this.forestDownloadEngine;
    }

    public final String y0() {
        return this.forestSessionID;
    }

    public /* synthetic */ CardParamVoNew(int r210) {
        this(PageType.CARD, false, "", false, false, false, false, null, false, false, "", false, false, "", false, "", "", 0, "", false);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public void F(u8.a r210) {
        super.F(r210);
        v8.a r100 = this.T;
        if (r100 == null) goto L46;
        String r101 = (String) r100.b(AppConstants.BUNDLE_REFERER, "");
        Boolean r102 = Boolean.FALSE;
        boolean r103 = ((Boolean) r100.b(AppConstants.BUNDLE_ENABLE_APP_CACHE, r102)).booleanValue();
        String r104 = (String) r100.b(AppConstants.BUNDLE_WAP_HEADERS, "");
        boolean r105 = ((Boolean) r100.b(AppConstants.BUNDLE_LOAD_NO_CACHE, r102)).booleanValue();
        if (((Number) r100.b("disable_host_jsb_method", 0)).intValue() != 1) goto L7;
        boolean r106 = true;
    L9:
        if (((Number) r100.b("disable_thread_spread", 0)).intValue() != 1) goto L11;
        boolean r110 = true;
    L13:
        if (((Number) r100.b("create_view_sync", 0)).intValue() != 1) goto L15;
        boolean r111 = true;
    L16:
        String r112 = (String) r100.b("enable_font_scale", "");
        if (((Number) r100.b("enable_view_zoom", 0)).intValue() != 1) goto L19;
        boolean r113 = true;
    L21:
        if (((Number) r100.b(AppConstants.BUNDLE_HIDE_POSTER, 0)).intValue() != 1) goto L23;
        boolean r114 = true;
    L24:
        String r115 = (String) r100.b("is_out_scene", "");
        if (((Number) r100.b("enable_code_cache", 0)).intValue() != 1) goto L27;
        boolean r107 = true;
    L28:
        boolean r116 = r107;
        if (((Number) r100.b("lock_resource", 0)).intValue() != 1) goto L31;
        boolean r108 = true;
    L32:
        String r109 = (String) r100.b("forest_session_id", "");
        boolean r117 = r108;
        if (((Number) r100.b("screen_size_adaptation", 0)).intValue() != 1) goto L35;
        boolean r118 = true;
    L36:
        String r119 = (String) r100.b("monitor_report_perf", "");
        String r120 = (String) r100.b("forest_download_engine", TrafficMetrics.FRPM_TTNET);
        int r121 = ((Number) r100.b("web_forest_mode", 0)).intValue();
        if (((Number) r100.b("use_screen_height", 0)).intValue() != 1) goto L39;
        boolean r122 = true;
    L40:
        this.enableAppCache = r103;
        this.headStr = r104;
        this.loadNoCache = r105;
        this.disableHostJsbMethod = r106;
        this.disableThreadSpread = r110;
        this.createViewAsync = r111;
        this.enableFontScale = r112;
        this.enableViewZoom = r113;
        this.hidePoster = r114;
        this.scene = r115;
        this.enableCodeCache = r116;
        this.enableResourceLock = r117;
        this.forestSessionID = r109;
        this.isSetScreenSize = r118;
        this.monitorReportPerf = r119;
        this.referer = r101;
        if (n.f(this.f39814b) == false) goto L43;
        String r123 = DBDefinition.DOWNLOAD_TABLE_NAME;
    L44:
        this.forestDownloadEngine = r123;
        this.webForestMode = r121;
        this.useScreenHeight = r122;
        return;
    L43:
        r123 = r120;
        goto L44
    L39:
        r122 = false;
        goto L40
    L35:
        r118 = false;
        goto L36
    L31:
        r108 = false;
        goto L32
    L27:
        r107 = false;
        goto L28
    L23:
        r114 = false;
        goto L24
    L19:
        r113 = false;
        goto L21
    L15:
        r111 = false;
        goto L16
    L11:
        r110 = false;
        goto L13
    L7:
        r106 = false;
        goto L9
    }

    public final void O0(boolean r100) {
        this.createViewAsync = r100;
    }

    public final void R0(boolean r100) {
        this.disableHostJsbMethod = r100;
    }

    public final void S0(boolean r100) {
        this.disableThreadSpread = r100;
    }

    public final void T0(boolean r100) {
        this.enableAppCache = r100;
    }

    public final void X0(boolean r100) {
        this.enableCodeCache = r100;
    }

    public final void Z0(String r100) {
        this.enableFontScale = r100;
    }

    public final void b1(boolean r100) {
        this.enableResourceLock = r100;
    }

    public final void c1(boolean r100) {
        this.enableViewZoom = r100;
    }

    public final void d1(String r100) {
        this.forestSessionID = r100;
    }

    public final void e1(String r100) {
        this.headStr = r100;
    }

    public final void f1(boolean r100) {
        this.hidePoster = r100;
    }

    public final void g1(boolean r100) {
        this.loadNoCache = r100;
    }

    public final void h1(String r100) {
        this.monitorReportPerf = r100;
    }

    public final void l1(PageType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageType = r100;
    }

    public final void o1(String r100) {
        this.referer = r100;
    }

    public final void r1(String r100) {
        this.scene = r100;
    }

    public final void s1(boolean r100) {
        this.isSetScreenSize = r100;
    }

    public CardParamVoNew(PageType r100, boolean r101, String r102, boolean r103, boolean r104, boolean r110, boolean r111, String r112, boolean r113, boolean r114, String r115, boolean r116, boolean r117, String r118, boolean r119, String r210, String r211, int r212, String r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        Intrinsics.checkNotNullParameter(r211, "forestDownloadEngine");
        super(0);
        this.pageType = r100;
        this.enableAppCache = r101;
        this.headStr = r102;
        this.loadNoCache = r103;
        this.disableHostJsbMethod = r104;
        this.disableThreadSpread = r110;
        this.createViewAsync = r111;
        this.enableFontScale = r112;
        this.enableViewZoom = r113;
        this.hidePoster = r114;
        this.scene = r115;
        this.enableCodeCache = r116;
        this.enableResourceLock = r117;
        this.forestSessionID = r118;
        this.isSetScreenSize = r119;
        this.monitorReportPerf = r210;
        this.forestDownloadEngine = r211;
        this.webForestMode = r212;
        this.referer = r213;
        this.useScreenHeight = r214;
    }
}
