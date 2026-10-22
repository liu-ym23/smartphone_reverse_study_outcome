package com.bytedance.android.live.schema.vo;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.x.d;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b1\b\u0007\u0018\u00002\u00020\u0001:\u0001FR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u000e\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR$\u00101\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001bR$\u00104\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001bR$\u00107\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0018\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001bR$\u0010:\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001bR\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR$\u0010C\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0018\u001a\u0004\bD\u0010\u001a\"\u0004\bE\u0010\u001b¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/schema/vo/BaseHybridParamVo;", "Landroid/os/Parcelable;", "", "hideStatusBar", "Z", "e", "()Z", FaceService.girlLabel, "(Z)V", "pullDownClose", "h", "J", "", "pullDownHeight", "I", "getPullDownHeight", "()I", "K", "(I)V", "pullDownIndicatorNotShow", RXScreenCaptureService.KEY_INDEX, "L", "", "indicatorColor", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "(Ljava/lang/String;)V", "hidePoster", "getHidePoster", ExifInterface.LONGITUDE_EAST, "showClose", ce.f26396k, "N", "showBack", ce.f26395j, "M", "enableShare", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableShare", "forbidRightBack", "b", "setForbidRightBack", "hideNavBar", "d", "setHideNavBar", "transStatusBar", "t", "setTransStatusBar", "statusBarColor", "q", "R", "statusBarBgColor", "o", "O", "title", "s", d.f25925o, "webBgColor", "D", "setWebBgColor", "hideLoading", "c", "setHideLoading", "supportExchangeTheme", "r", "setSupportExchangeTheme", "url", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, ExifInterface.LATITUDE_SOUTH, "HybridType", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseHybridParamVo implements Parcelable {
    public static final Parcelable.Creator<BaseHybridParamVo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridType f100519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f100520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f100521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f100522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f100523e;

    @SerializedName(AppConstants.BUNDLE_ENABLE_SHARE)
    private boolean enableShare;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f100524f;

    @SerializedName("forbid_right_back")
    private boolean forbidRightBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f100525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f100526h;

    @SerializedName("hide_loading")
    private boolean hideLoading;

    @SerializedName("hide_nav_bar")
    private boolean hideNavBar;

    @SerializedName("hide_poster")
    private boolean hidePoster;

    @SerializedName("hide_status_bar")
    private boolean hideStatusBar;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f100527i;

    @SerializedName(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_COLOR)
    private String indicatorColor;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f100528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f100529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f100530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f100531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f100532n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f100533o;

    @SerializedName(AppConstants.BUNDLE_PULL_DOWN_CLOSE)
    private boolean pullDownClose;

    @SerializedName(AppConstants.BUNDLE_PULL_DOWN_HEIGHT)
    private int pullDownHeight;

    @SerializedName(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_NOT_SHOW)
    private boolean pullDownIndicatorNotShow;

    @SerializedName(AppConstants.BUNDLE_SHOW_BACK)
    private boolean showBack;

    @SerializedName(AppConstants.BUNDLE_SHOW_CLOSE)
    private boolean showClose;

    @SerializedName(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR)
    private String statusBarBgColor;

    @SerializedName(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR)
    private String statusBarColor;

    @SerializedName(AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME)
    private boolean supportExchangeTheme;

    @SerializedName("title")
    private String title;

    @SerializedName(AppConstants.TRANS_STATUS_BAR)
    private boolean transStatusBar;

    @SerializedName("url")
    private String url;

    @SerializedName("web_bg_color")
    private String webBgColor;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/schema/vo/BaseHybridParamVo$HybridType;", "", "H5", "LYNX", "HOST_H5", "NATIVE", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        public static final HybridType H5 = null;
        public static final HybridType HOST_H5 = null;
        public static final HybridType LYNX = null;
        public static final HybridType NATIVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HybridType[] f100534a = null;

        static {
            HybridType r100 = new HybridType("H5", 0);
            H5 = r100;
            HybridType r101 = new HybridType("LYNX", 1);
            LYNX = r101;
            HybridType r102 = new HybridType("HOST_H5", 2);
            HOST_H5 = r102;
            HybridType r103 = new HybridType("NATIVE", 3);
            NATIVE = r103;
            f100534a = new HybridType[]{r100, r101, r102, r103};
        }

        public static HybridType valueOf(String r100) {
            return (HybridType) r27.a.a(HybridType.class, r100);
        }

        public static HybridType[] values() {
            return (HybridType[]) f100534a.clone();
        }

        public HybridType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a implements Parcelable.Creator<BaseHybridParamVo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseHybridParamVo createFromParcel(Parcel r410) {
            Intrinsics.checkNotNullParameter(r410, "in");
            if (r410.readInt() == 0) goto L5;
            boolean r100 = true;
        L6:
            HybridType r101 = (HybridType) r27.a.a(HybridType.class, r410.readString());
            String r102 = r410.readString();
            String r103 = r410.readString();
            if (r410.readInt() == 0) goto L9;
            boolean r104 = true;
        L10:
            int r110 = r410.readInt();
            if (r410.readInt() == 0) goto L13;
            boolean r111 = true;
        L14:
            String r112 = r410.readString();
            if (r410.readInt() == 0) goto L17;
            boolean r113 = true;
        L19:
            if (r410.readInt() == 0) goto L21;
            boolean r114 = true;
        L23:
            if (r410.readInt() == 0) goto L25;
            boolean r115 = true;
        L27:
            if (r410.readInt() == 0) goto L29;
            boolean r116 = true;
        L31:
            if (r410.readInt() == 0) goto L33;
            boolean r117 = true;
        L35:
            if (r410.readInt() == 0) goto L37;
            Integer r118 = Integer.valueOf(r410.readInt());
        L39:
            if (r410.readInt() == 0) goto L41;
            boolean r210 = true;
        L43:
            if (r410.readInt() == 0) goto L45;
            boolean r211 = true;
        L46:
            String r212 = r410.readString();
            if (r410.readInt() == 0) goto L49;
            boolean r213 = true;
        L51:
            if (r410.readInt() == 0) goto L53;
            boolean r214 = true;
        L55:
            if (r410.readInt() == 0) goto L57;
            boolean r215 = true;
        L59:
            if (r410.readInt() == 0) goto L61;
            boolean r216 = true;
        L62:
            String r217 = r410.readString();
            String r218 = r410.readString();
            if (r410.readInt() != 0) goto L65;
            Boolean r219 = null;
        L70:
            String r310 = r410.readString();
            String r311 = r410.readString();
            int r312 = r410.readInt();
            String r313 = r410.readString();
            if (r410.readInt() == 0) goto L73;
            boolean r314 = true;
        L74:
            int r315 = r410.readInt();
            if (r410.readInt() == 0) goto L77;
            boolean r316 = true;
        L79:
            return new BaseHybridParamVo(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r410.readString(), r410.readString(), r410.readString());
        L77:
            r316 = false;
            goto L79
        L73:
            r314 = false;
            goto L74
        L65:
            if (r410.readInt() == 0) goto L67;
            boolean r105 = true;
        L68:
            r219 = Boolean.valueOf(r105);
            goto L70
        L67:
            r105 = false;
            goto L68
        L61:
            r216 = false;
            goto L62
        L57:
            r215 = false;
            goto L59
        L53:
            r214 = false;
            goto L55
        L49:
            r213 = false;
            goto L51
        L45:
            r211 = false;
            goto L46
        L41:
            r210 = false;
            goto L43
        L37:
            r118 = null;
            goto L39
        L33:
            r117 = false;
            goto L35
        L29:
            r116 = false;
            goto L31
        L25:
            r115 = false;
            goto L27
        L21:
            r114 = false;
            goto L23
        L17:
            r113 = false;
            goto L19
        L13:
            r111 = false;
            goto L14
        L9:
            r104 = false;
            goto L10
        L5:
            r100 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BaseHybridParamVo[] newArray(int r100) {
            return new BaseHybridParamVo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BaseHybridParamVo() {
        this(false, false, 0, false, null, false, false, false, false, false, false, false, false, null, null, null, null, null, 0, null, false, 0, false, null, null, null, -1, 3);
    }

    public final void E() {
        this.hidePoster = false;
    }

    public final void F() {
        this.hideStatusBar = false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.hideStatusBar ? 1 : 0);
        r100.writeString(this.f100519a.name());
        r100.writeString(this.f100520b);
        r100.writeString(this.f100521c);
        r100.writeInt(this.pullDownClose ? 1 : 0);
        r100.writeInt(this.pullDownHeight);
        r100.writeInt(this.pullDownIndicatorNotShow ? 1 : 0);
        r100.writeString(this.indicatorColor);
        r100.writeInt(this.hidePoster ? 1 : 0);
        r100.writeInt(this.showClose ? 1 : 0);
        r100.writeInt(this.showBack ? 1 : 0);
        r100.writeInt(this.enableShare ? 1 : 0);
        r100.writeInt(this.forbidRightBack ? 1 : 0);
        Integer r102 = this.f100522d;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
    L6:
        r100.writeInt(this.f100523e ? 1 : 0);
        r100.writeInt(this.hideNavBar ? 1 : 0);
        r100.writeString(this.f100524f);
        r100.writeInt(this.f100525g ? 1 : 0);
        r100.writeInt(this.f100526h ? 1 : 0);
        r100.writeInt(this.f100527i ? 1 : 0);
        r100.writeInt(this.transStatusBar ? 1 : 0);
        r100.writeString(this.statusBarColor);
        r100.writeString(this.statusBarBgColor);
        Boolean r103 = this.f100528j;
        if (r103 == null) goto L9;
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
    L10:
        r100.writeString(this.f100529k);
        r100.writeString(this.title);
        r100.writeInt(this.f100530l);
        r100.writeString(this.webBgColor);
        r100.writeInt(this.hideLoading ? 1 : 0);
        r100.writeInt(this.f100531m);
        r100.writeInt(this.supportExchangeTheme ? 1 : 0);
        r100.writeString(this.f100532n);
        r100.writeString(this.url);
        r100.writeString(this.f100533o);
        return;
    L9:
        r100.writeInt(0);
        goto L10
    L5:
        r100.writeInt(0);
        goto L6
    }

    public final String toString() {
        return "BaseHybridParamVo(hideStatusBar=" + this.hideStatusBar + ", hybridType=" + this.f100519a + ", monitorPageService=" + this.f100520b + ", fromLabel=" + this.f100521c + ", pullDownClose=" + this.pullDownClose + ", pullDownHeight=" + this.pullDownHeight + ", pullDownIndicatorNotShow=" + this.pullDownIndicatorNotShow + ", indicatorColor=" + this.indicatorColor + ", hidePoster=" + this.hidePoster + ", showClose=" + this.showClose + ",showBack=" + this.showBack + ", enableShare=" + this.enableShare + ", forbidRightBack=" + this.forbidRightBack + ", backgroundRes=" + this.f100522d + ", userWebViewTitle=" + this.f100523e + ", hideNavBar=" + this.hideNavBar + ", fromContainer=" + this.f100524f + ", isPopUp=" + this.f100525g + ", hideMore=" + this.f100526h + ", isFullScreen=" + this.f100527i + ", transStatusBar=" + this.transStatusBar + ", statusBarColor=" + this.statusBarColor + ", statusBarBgColor=" + this.statusBarBgColor + ", isOutUrl=" + this.f100528j + ", scene=" + this.f100529k + ", title=" + this.title + ", bundleWebBgColor=" + this.f100530l + ", webBgColor=" + this.webBgColor + ", hideLoading=" + this.hideLoading + ", requestCode=" + this.f100531m + ", supportExchangeTheme=" + this.supportExchangeTheme + ", injectJsonUrl=" + this.f100532n + ", url=" + this.url + ", originSchema=" + this.f100533o + ')';
    }

    public final String D() {
        return this.webBgColor;
    }

    public final boolean a() {
        return this.enableShare;
    }

    public final boolean b() {
        return this.forbidRightBack;
    }

    public final boolean c() {
        return this.hideLoading;
    }

    public final boolean d() {
        return this.hideNavBar;
    }

    public final boolean e() {
        return this.hideStatusBar;
    }

    public final String g() {
        return this.indicatorColor;
    }

    public final boolean h() {
        return this.pullDownClose;
    }

    public final boolean i() {
        return this.pullDownIndicatorNotShow;
    }

    public final boolean j() {
        return this.showBack;
    }

    public final boolean k() {
        return this.showClose;
    }

    public final String o() {
        return this.statusBarBgColor;
    }

    public final String q() {
        return this.statusBarColor;
    }

    public final boolean r() {
        return this.supportExchangeTheme;
    }

    public final String s() {
        return this.title;
    }

    public final boolean t() {
        return this.transStatusBar;
    }

    public final String z() {
        return this.url;
    }

    public final void I(String r100) {
        this.indicatorColor = r100;
    }

    public final void J(boolean r100) {
        this.pullDownClose = r100;
    }

    public final void K(int r100) {
        this.pullDownHeight = r100;
    }

    public final void L(boolean r100) {
        this.pullDownIndicatorNotShow = r100;
    }

    public final void M(boolean r100) {
        this.showBack = r100;
    }

    public final void N(boolean r100) {
        this.showClose = r100;
    }

    public final void O(String r100) {
        this.statusBarBgColor = r100;
    }

    public final void R(String r100) {
        this.statusBarColor = r100;
    }

    public final void S(String r100) {
        this.url = r100;
    }

    public /* synthetic */ BaseHybridParamVo(boolean r310, boolean r410, int r411, boolean r412, String r413, boolean r414, boolean r415, boolean r416, boolean r417, boolean r418, boolean r419, boolean r510, boolean r511, String r512, String r513, Boolean r514, String r515, String r516, int r517, String r518, boolean r519, int r610, boolean r611, String r612, String r613, String r614, int r615, int r616) {
        if ((r615 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r615 & 2) == 0) goto L9;
        HybridType r101 = HybridType.H5;
    L11:
        if ((r615 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r615 & 16) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r615 & 32) == 0) goto L21;
        int r110 = 0;
    L23:
        if ((r615 & 64) == 0) goto L25;
        boolean r111 = true;
    L27:
        if ((r615 & 128) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r615 & 256) == 0) goto L33;
        boolean r113 = false;
    L35:
        if ((r615 & 512) == 0) goto L37;
        boolean r114 = false;
    L39:
        if ((r615 & 1024) == 0) goto L41;
        boolean r115 = false;
    L43:
        if ((r615 & 2048) == 0) goto L45;
        boolean r104 = false;
    L47:
        if ((r615 & 4096) == 0) goto L49;
        boolean r116 = false;
    L51:
        if ((32768 & r615) == 0) goto L53;
        boolean r210 = false;
    L55:
        if ((65536 & r615) == 0) goto L57;
        String r211 = "";
    L59:
        if ((524288 & r615) == 0) goto L61;
        boolean r212 = false;
    L63:
        if ((1048576 & r615) == 0) goto L65;
        boolean r213 = false;
    L67:
        if ((2097152 & r615) == 0) goto L69;
        String r214 = "";
    L71:
        if ((4194304 & r615) == 0) goto L73;
        String r215 = "";
    L75:
        if ((8388608 & r615) == 0) goto L77;
        Boolean r216 = Boolean.FALSE;
    L79:
        if ((16777216 & r615) == 0) goto L81;
        String r217 = "";
    L83:
        if ((33554432 & r615) == 0) goto L85;
        String r311 = "";
    L87:
        if ((67108864 & r615) == 0) goto L89;
        int r312 = -1;
    L91:
        if ((134217728 & r615) == 0) goto L93;
        String r313 = "";
    L95:
        if ((268435456 & r615) == 0) goto L97;
        boolean r314 = true;
    L99:
        if ((536870912 & r615) == 0) goto L101;
        int r315 = 0;
    L103:
        if ((1073741824 & r615) == 0) goto L105;
        boolean r316 = false;
    L107:
        if ((r615 & Integer.MIN_VALUE) == 0) goto L109;
        String r105 = "";
    L111:
        if ((r616 & 1) == 0) goto L113;
        String r317 = "";
    L115:
        if ((r616 & 2) == 0) goto L117;
        String r318 = "";
    L118:
        this(r100, r101, null, r102, r103, r110, r111, r112, r113, r114, r115, r104, r116, null, false, r210, r211, false, false, r212, r213, r214, r215, r216, r217, r311, r312, r313, r314, r315, r316, r105, r317, r318);
        return;
    L117:
        r318 = r614;
        goto L118
    L113:
        r317 = r613;
        goto L115
    L109:
        r105 = r612;
        goto L111
    L105:
        r316 = r611;
        goto L107
    L101:
        r315 = r610;
        goto L103
    L97:
        r314 = r519;
        goto L99
    L93:
        r313 = r518;
        goto L95
    L89:
        r312 = r517;
        goto L91
    L85:
        r311 = r516;
        goto L87
    L81:
        r217 = r515;
        goto L83
    L77:
        r216 = r514;
        goto L79
    L73:
        r215 = r513;
        goto L75
    L69:
        r214 = r512;
        goto L71
    L65:
        r213 = r511;
        goto L67
    L61:
        r212 = r510;
        goto L63
    L57:
        r211 = null;
        goto L59
    L53:
        r210 = r419;
        goto L55
    L49:
        r116 = r418;
        goto L51
    L45:
        r104 = r417;
        goto L47
    L41:
        r115 = r416;
        goto L43
    L37:
        r114 = r415;
        goto L39
    L33:
        r113 = r414;
        goto L35
    L29:
        r112 = r413;
        goto L31
    L25:
        r111 = r412;
        goto L27
    L21:
        r110 = r411;
        goto L23
    L17:
        r103 = r410;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }

    public BaseHybridParamVo(boolean r100, HybridType r101, String r102, String r103, boolean r104, int r110, boolean r111, String r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, Integer r118, boolean r119, boolean r210, String r211, boolean r212, boolean r213, boolean r214, boolean r215, String r216, String r217, Boolean r218, String r219, String r310, int r311, String r312, boolean r313, int r314, boolean r315, String r316, String r317, String r318) {
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        Intrinsics.checkNotNullParameter(r316, "injectJsonUrl");
        this.hideStatusBar = r100;
        this.f100519a = r101;
        this.f100520b = r102;
        this.f100521c = r103;
        this.pullDownClose = r104;
        this.pullDownHeight = r110;
        this.pullDownIndicatorNotShow = r111;
        this.indicatorColor = r112;
        this.hidePoster = r113;
        this.showClose = r114;
        this.showBack = r115;
        this.enableShare = r116;
        this.forbidRightBack = r117;
        this.f100522d = r118;
        this.f100523e = r119;
        this.hideNavBar = r210;
        this.f100524f = r211;
        this.f100525g = r212;
        this.f100526h = r213;
        this.f100527i = r214;
        this.transStatusBar = r215;
        this.statusBarColor = r216;
        this.statusBarBgColor = r217;
        this.f100528j = r218;
        this.f100529k = r219;
        this.title = r310;
        this.f100530l = r311;
        this.webBgColor = r312;
        this.hideLoading = r313;
        this.f100531m = r314;
        this.supportExchangeTheme = r315;
        this.f100532n = r316;
        this.url = r317;
        this.f100533o = r318;
    }
}
