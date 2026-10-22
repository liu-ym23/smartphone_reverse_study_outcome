package com.bytedance.android.annie.scheme.vo.refactor;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0017\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR$\u0010/\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R$\u00102\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R$\u00105\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\"\u0010H\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010:\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\"\u0010N\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR$\u0010Q\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0015\u001a\u0004\bR\u0010\u0017\"\u0004\bS\u0010\u0019R$\u0010T\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0015\u001a\u0004\bU\u0010\u0017\"\u0004\bV\u0010\u0019R\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR\"\u0010Z\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010:\u001a\u0004\b[\u0010<\"\u0004\b\\\u0010>R\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR\"\u0010`\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\"\u0010c\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0015\u001a\u0004\bd\u0010\u0017\"\u0004\be\u0010\u0019R\"\u0010f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010\u0004\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\"\u0010j\u001a\u00020i8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010\u0015\u001a\u0004\bq\u0010\u0017\"\u0004\br\u0010\u0019R\"\u0010s\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010\u0015\u001a\u0004\bt\u0010\u0017\"\u0004\bu\u0010\u0019R\"\u0010v\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bv\u0010\u0015\u001a\u0004\bw\u0010\u0017\"\u0004\bx\u0010\u0019R\"\u0010y\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\by\u0010\u0004\u001a\u0004\bz\u0010\u0006\"\u0004\b{\u0010\b¨\u0006|"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/FragmentParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/CardParamVoNew;", "", "useReceivedTitle", "Z", "e2", "()Z", "M2", "(Z)V", "Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;", "hybridType", "Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;", "M1", "()Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;", "u2", "(Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;)V", "pullDownIndicatorNotShow", OuterPayLoginWrapper.LOGIN_STYLE_V1, "C2", "", "indicatorColor", "Ljava/lang/String;", "O1", "()Ljava/lang/String;", "w2", "(Ljava/lang/String;)V", "showClose", "X1", "G2", "showBack", "W1", "F2", "enableShare", "I1", "q2", "forbidRightBack", "J1", "r2", "hideNavBar", "L1", "t2", "isPopUp", "f2", "B2", "isRealFullScreen", "h2", "E2", "statusBarColor", "a2", "J2", "statusBarBgColor", "Z1", "I2", "title", "c2", "L2", "", "bundleWebBgColor", "I", "z1", "()I", "k2", "(I)V", "hideLoading", "K1", "s2", "supportExchangeTheme", "b2", "K2", "closePositionRight", "A1", "l2", "iconTheme", "N1", "v2", "autoShowNavBar", "w1", "j2", "showFloatLive", "Y1", "H2", "titleColor", "d2", "setTitleColor", "navBarColor", "R1", "setNavBarColor", "disableInputScroll", "F1", "n2", "androidSoftInputMode", "u1", "i2", "lazyLoad", "Q1", "y2", "enableCardCache", "G1", DevicePlans.DEVICE_PLAN_OPPO2, "prerenderCacheKey", "U1", "setPrerenderCacheKey", "enablePadAdapter", "H1", "p2", "", "padRatio", FaceService.girlLabel, "S1", "()F", "z2", "(F)V", "containerBgColor", "C1", Keys.API_PARAM_KEY_M2, "pageTag", "T1", "A2", "launchMode", DiagnoseResult.DIAGNOSE_LEVEL_P1, "x2", "isPullUpPopup", DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2, "D2", "annie_release"}, k = 1, mv = {1, 4, 3})
public class FragmentParamVoNew extends CardParamVoNew {
    public static final Parcelable.Creator<FragmentParamVoNew> CREATOR = null;

    @SerializedName("android_soft_input_mode")
    private int androidSoftInputMode;

    @SerializedName(AppConstants.BUNDLE_AUTO_SHOW_NAV_BAR)
    private boolean autoShowNavBar;

    @SerializedName("bundle_web_bg_color")
    private int bundleWebBgColor;

    @SerializedName("close_position_right")
    private boolean closePositionRight;

    @SerializedName("container_bg_color")
    private String containerBgColor;

    @SerializedName("disable_input_scroll")
    private boolean disableInputScroll;

    @SerializedName("enable_card_cache")
    private boolean enableCardCache;

    @SerializedName("enable_pad_adapter")
    private boolean enablePadAdapter;

    @SerializedName(AppConstants.BUNDLE_ENABLE_SHARE)
    private boolean enableShare;

    @SerializedName("forbid_right_back")
    private boolean forbidRightBack;

    @SerializedName("hide_loading")
    private boolean hideLoading;

    @SerializedName("hide_nav_bar")
    private boolean hideNavBar;

    @SerializedName("hybrid_type")
    private BaseHybridParamVoNew.HybridType hybridType;

    @SerializedName("icon_theme")
    private int iconTheme;

    @SerializedName(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_COLOR)
    private String indicatorColor;

    @SerializedName("is_pop_up")
    private boolean isPopUp;

    @SerializedName("is_pull_popup")
    private boolean isPullUpPopup;

    @SerializedName("is_real_fullscreen")
    private boolean isRealFullScreen;

    @SerializedName(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD)
    private String launchMode;

    @SerializedName("lazy_load")
    private boolean lazyLoad;

    @SerializedName("nav_bar_color")
    private String navBarColor;

    @SerializedName("pad_ratio")
    private float padRatio;

    @SerializedName(FrescoMonitorConst.PAGE_TAG)
    private String pageTag;

    @SerializedName("prerender_cache_key")
    private String prerenderCacheKey;

    @SerializedName(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_NOT_SHOW)
    private boolean pullDownIndicatorNotShow;

    @SerializedName(AppConstants.BUNDLE_SHOW_BACK)
    private boolean showBack;

    @SerializedName(AppConstants.BUNDLE_SHOW_CLOSE)
    private boolean showClose;

    @SerializedName("show_float_live")
    private boolean showFloatLive;

    @SerializedName(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR)
    private String statusBarBgColor;

    @SerializedName(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR)
    private String statusBarColor;

    @SerializedName(AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME)
    private boolean supportExchangeTheme;

    @SerializedName("title")
    private String title;

    @SerializedName("title_color")
    private String titleColor;

    @SerializedName("use_received_title")
    private boolean useReceivedTitle;

    public static final class a implements Parcelable.Creator<FragmentParamVoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentParamVoNew createFromParcel(Parcel r310) {
            Intrinsics.checkNotNullParameter(r310, "parcel");
            if (r310.readInt() == 0) goto L5;
            boolean r100 = true;
        L6:
            BaseHybridParamVoNew.HybridType r101 = BaseHybridParamVoNew.HybridType.valueOf(r310.readString());
            if (r310.readInt() == 0) goto L9;
            boolean r102 = true;
        L10:
            String r103 = r310.readString();
            if (r310.readInt() == 0) goto L13;
            boolean r104 = true;
        L15:
            if (r310.readInt() == 0) goto L17;
            boolean r105 = true;
        L19:
            if (r310.readInt() == 0) goto L21;
            boolean r110 = true;
        L23:
            if (r310.readInt() == 0) goto L25;
            boolean r111 = true;
        L27:
            if (r310.readInt() == 0) goto L29;
            boolean r112 = true;
        L31:
            if (r310.readInt() == 0) goto L33;
            boolean r113 = true;
        L35:
            if (r310.readInt() == 0) goto L37;
            boolean r114 = true;
        L38:
            String r115 = r310.readString();
            String r116 = r310.readString();
            String r117 = r310.readString();
            int r118 = r310.readInt();
            if (r310.readInt() == 0) goto L41;
            boolean r119 = true;
        L43:
            if (r310.readInt() == 0) goto L45;
            boolean r210 = true;
        L47:
            if (r310.readInt() == 0) goto L49;
            boolean r211 = true;
        L50:
            int r212 = r310.readInt();
            if (r310.readInt() == 0) goto L53;
            boolean r213 = true;
        L55:
            if (r310.readInt() == 0) goto L57;
            boolean r214 = true;
        L58:
            String r215 = r310.readString();
            String r216 = r310.readString();
            if (r310.readInt() == 0) goto L61;
            boolean r217 = true;
        L62:
            int r218 = r310.readInt();
            if (r310.readInt() == 0) goto L65;
            boolean r219 = true;
        L67:
            if (r310.readInt() == 0) goto L69;
            boolean r311 = true;
        L70:
            String r312 = r310.readString();
            if (r310.readInt() == 0) goto L73;
            boolean r313 = true;
        L74:
            float r314 = r310.readFloat();
            String r315 = r310.readString();
            String r316 = r310.readString();
            String r317 = r310.readString();
            if (r310.readInt() == 0) goto L77;
            boolean r318 = true;
        L79:
            return new FragmentParamVoNew(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r311, r312, r313, r314, r315, r316, r317, r318);
        L77:
            r318 = false;
            goto L79
        L73:
            r313 = false;
            goto L74
        L69:
            r311 = false;
            goto L70
        L65:
            r219 = false;
            goto L67
        L61:
            r217 = false;
            goto L62
        L57:
            r214 = false;
            goto L58
        L53:
            r213 = false;
            goto L55
        L49:
            r211 = false;
            goto L50
        L45:
            r210 = false;
            goto L47
        L41:
            r119 = false;
            goto L43
        L37:
            r114 = false;
            goto L38
        L33:
            r113 = false;
            goto L35
        L29:
            r112 = false;
            goto L31
        L25:
            r111 = false;
            goto L27
        L21:
            r110 = false;
            goto L23
        L17:
            r105 = false;
            goto L19
        L13:
            r104 = false;
            goto L15
        L9:
            r102 = false;
            goto L10
        L5:
            r100 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentParamVoNew[] newArray(int r100) {
            return new FragmentParamVoNew[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FragmentParamVoNew() {
        this(0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(this.useReceivedTitle ? 1 : 0);
        r100.writeString(this.hybridType.name());
        r100.writeInt(this.pullDownIndicatorNotShow ? 1 : 0);
        r100.writeString(this.indicatorColor);
        r100.writeInt(this.showClose ? 1 : 0);
        r100.writeInt(this.showBack ? 1 : 0);
        r100.writeInt(this.enableShare ? 1 : 0);
        r100.writeInt(this.forbidRightBack ? 1 : 0);
        r100.writeInt(this.hideNavBar ? 1 : 0);
        r100.writeInt(this.isPopUp ? 1 : 0);
        r100.writeInt(this.isRealFullScreen ? 1 : 0);
        r100.writeString(this.statusBarColor);
        r100.writeString(this.statusBarBgColor);
        r100.writeString(this.title);
        r100.writeInt(this.bundleWebBgColor);
        r100.writeInt(this.hideLoading ? 1 : 0);
        r100.writeInt(this.supportExchangeTheme ? 1 : 0);
        r100.writeInt(this.closePositionRight ? 1 : 0);
        r100.writeInt(this.iconTheme);
        r100.writeInt(this.autoShowNavBar ? 1 : 0);
        r100.writeInt(this.showFloatLive ? 1 : 0);
        r100.writeString(this.titleColor);
        r100.writeString(this.navBarColor);
        r100.writeInt(this.disableInputScroll ? 1 : 0);
        r100.writeInt(this.androidSoftInputMode);
        r100.writeInt(this.lazyLoad ? 1 : 0);
        r100.writeInt(this.enableCardCache ? 1 : 0);
        r100.writeString(this.prerenderCacheKey);
        r100.writeInt(this.enablePadAdapter ? 1 : 0);
        r100.writeFloat(this.padRatio);
        r100.writeString(this.containerBgColor);
        r100.writeString(this.pageTag);
        r100.writeString(this.launchMode);
        r100.writeInt(this.isPullUpPopup ? 1 : 0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public String toString() {
        return super.toString() + "FragmentParamVo(useReceivedTitle=" + this.useReceivedTitle + ", hybridType=" + this.hybridType + ", pullDownIndicatorNotShow=" + this.pullDownIndicatorNotShow + ", indicatorColor=" + this.indicatorColor + ", showClose=" + this.showClose + ", showBack=" + this.showBack + ", enableShare=" + this.enableShare + ", forbidRightBack=" + this.forbidRightBack + ", hideNavBar=" + this.hideNavBar + ", isPopUp=" + this.isPopUp + ", isFullScreen=" + D() + ", transStatusBar=" + r() + ", statusBarColor=" + this.statusBarColor + ", statusBarBgColor=" + this.statusBarBgColor + ", title=" + this.title + ", bundleWebBgColor=" + this.bundleWebBgColor + ", hideLoading=" + this.hideLoading + ", supportExchangeTheme=" + this.supportExchangeTheme + ", closePositionRight=" + this.closePositionRight + ", iconTheme=" + this.iconTheme + ", autoShowNavBar=" + this.autoShowNavBar + ", showFloatLive=" + this.showFloatLive + ", disableInputScroll=" + this.disableInputScroll + ", androidSoftInputMode=" + this.androidSoftInputMode + ", enablePadAdapter=" + this.enablePadAdapter + ", padRatio=" + this.padRatio + ", containerBgColor='" + this.containerBgColor + "', isPullUpPopup=" + this.isPullUpPopup + ')';
    }

    public final boolean A1() {
        return this.closePositionRight;
    }

    public final String C1() {
        return this.containerBgColor;
    }

    public final boolean F1() {
        return this.disableInputScroll;
    }

    public final boolean G1() {
        return this.enableCardCache;
    }

    public final boolean H1() {
        return this.enablePadAdapter;
    }

    public final boolean I1() {
        return this.enableShare;
    }

    public final boolean J1() {
        return this.forbidRightBack;
    }

    public final boolean K1() {
        return this.hideLoading;
    }

    public final boolean L1() {
        return this.hideNavBar;
    }

    public final BaseHybridParamVoNew.HybridType M1() {
        return this.hybridType;
    }

    public final int N1() {
        return this.iconTheme;
    }

    public final String O1() {
        return this.indicatorColor;
    }

    public final String P1() {
        return this.launchMode;
    }

    public final boolean Q1() {
        return this.lazyLoad;
    }

    public final String R1() {
        return this.navBarColor;
    }

    public final float S1() {
        return this.padRatio;
    }

    public final String T1() {
        return this.pageTag;
    }

    public final String U1() {
        return this.prerenderCacheKey;
    }

    public final boolean V1() {
        return this.pullDownIndicatorNotShow;
    }

    public final boolean W1() {
        return this.showBack;
    }

    public final boolean X1() {
        return this.showClose;
    }

    public final boolean Y1() {
        return this.showFloatLive;
    }

    public final String Z1() {
        return this.statusBarBgColor;
    }

    public final String a2() {
        return this.statusBarColor;
    }

    public final boolean b2() {
        return this.supportExchangeTheme;
    }

    public final String c2() {
        return this.title;
    }

    public final String d2() {
        return this.titleColor;
    }

    public final boolean e2() {
        return this.useReceivedTitle;
    }

    public final boolean f2() {
        return this.isPopUp;
    }

    public final boolean g2() {
        return this.isPullUpPopup;
    }

    public final boolean h2() {
        return this.isRealFullScreen;
    }

    public final int u1() {
        return this.androidSoftInputMode;
    }

    public final boolean w1() {
        return this.autoShowNavBar;
    }

    public final int z1() {
        return this.bundleWebBgColor;
    }

    public /* synthetic */ FragmentParamVoNew(int r310) {
        this(false, BaseHybridParamVoNew.HybridType.H5, true, "", false, false, false, false, false, false, false, "", "", "", -1, true, false, true, 0, false, false, "", "", false, -1, false, false, "", false, 0.0f, "", "", "", false);
    }

    public final void A2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageTag = r100;
    }

    public final void B2(boolean r100) {
        this.isPopUp = r100;
    }

    public final void C2(boolean r100) {
        this.pullDownIndicatorNotShow = r100;
    }

    public final void D2(boolean r100) {
        this.isPullUpPopup = r100;
    }

    public final void E2(boolean r100) {
        this.isRealFullScreen = r100;
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public void F(u8.a r310) {
        super.F(r310);
        v8.a r100 = this.T;
        if (r100 == null) goto L87;
        boolean r101 = ((Boolean) r100.b(AppConstants.BUNDLE_USE_WEBVIEW_TITLE, Boolean.FALSE)).booleanValue();
        String r102 = (String) r100.b(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR, "");
        String r103 = (String) r100.b("status_font_mode", "");
        String r104 = (String) r100.b(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR, "");
        int r105 = ((Number) r100.b(AppConstants.BUNDLE_WEB_VIEW_BACKGROUND_COLOR, -1)).intValue();
        String r106 = (String) r100.b(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_COLOR, "");
        String r110 = (String) r100.b("title", "");
        if (((Number) r100.b(AppConstants.BUNDLE_PULL_DOWN_INDICATOR_NOT_SHOW, 0)).intValue() != 1) goto L7;
        boolean r111 = true;
    L9:
        if (((Number) r100.b("hide_loading", 1)).intValue() != 1) goto L11;
        boolean r112 = true;
    L13:
        if (((Number) r100.b(AppConstants.BUNDLE_SHOW_CLOSE, 0)).intValue() != 1) goto L15;
        boolean r107 = true;
    L17:
        if (((Number) r100.b("hide_nav_bar", 0)).intValue() != 1) goto L19;
        boolean r113 = true;
    L21:
        if (((Number) r100.b(AppConstants.BUNDLE_ENABLE_SHARE, 0)).intValue() != 1) goto L23;
        boolean r108 = true;
    L24:
        boolean r114 = r112;
        if (((Number) r100.b(AppConstants.BUNDLE_SHOW_BACK, 0)).intValue() != 1) goto L27;
        boolean r115 = true;
    L29:
        if (((Number) r100.b("forbid_right_back", 0)).intValue() != 1) goto L31;
        boolean r109 = true;
    L33:
        if (((Number) r100.b("disable_back_press", 0)).intValue() != 1) goto L35;
        boolean r116 = true;
    L37:
        if (((Number) r100.b(AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME, 0)).intValue() != 1) goto L39;
        boolean r117 = true;
    L40:
        boolean r210 = r117;
        int r118 = ((Number) r100.b("icon_theme", 0)).intValue();
        String r119 = (String) r100.b("title_color", "");
        String r120 = (String) r100.b("nav_bar_color", "");
        if (((Number) r100.b("show_float_live", 0)).intValue() != 1) goto L43;
        boolean r121 = true;
    L44:
        boolean r211 = r121;
        if (((Number) r100.b(AppConstants.BUNDLE_AUTO_SHOW_NAV_BAR, 0)).intValue() != 1) goto L47;
        boolean r122 = true;
    L48:
        boolean r212 = r122;
        if (((Number) r100.b("disable_input_scroll", 0)).intValue() != 1) goto L51;
        boolean r123 = true;
    L52:
        boolean r311 = r123;
        int r124 = ((Number) r100.b("android_soft_input_mode", -1)).intValue();
        if (((Number) r100.b("lazy_load", 0)).intValue() != 1) goto L55;
        boolean r125 = true;
    L56:
        boolean r213 = r125;
        if (((Number) r100.b("enable_card_cache", 0)).intValue() != 1) goto L59;
        boolean r126 = true;
    L60:
        String r127 = (String) r100.b("prerender_cache_key", "");
        boolean r312 = r126;
        if (((Number) r100.b("enable_pad_adapter", 0)).intValue() != 1) goto L63;
        boolean r128 = true;
    L64:
        boolean r313 = r128;
        float r129 = ((Number) r100.b("pad_ratio", Float.valueOf(0.47368422f))).floatValue();
        String r130 = (String) r100.b("container_bg_color", "");
        CharSequence r131 = (CharSequence) r100.b(FrescoMonitorConst.PAGE_TAG, "");
        if (StringsKt.isBlank(r131) == false) goto L68;
        String r132 = this.f39814b;
        HashMap<String, List<WeakReference<Activity>>> r314 = r7.a.f536391a;
        Intrinsics.checkNotNullParameter(r132, "url");
        int r133 = x8.a.f562881a;
        x8.a.d("FullScreenPageRecord", "begin generator url " + r132, true);
        StringsKt.isBlank(r132);
        Uri r134 = UriProtector.parse(r132);
        r131 = r134.getHost() + r134.getPath();
    L68:
        String r135 = (String) r131;
        String r136 = (String) r100.b(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD, "");
        if (Intrinsics.areEqual(r103, "dark") == false) goto L72;
        String r137 = "black";
    L79:
        this.useReceivedTitle = r101;
        this.pullDownIndicatorNotShow = r111;
        this.indicatorColor = r106;
        this.showClose = r107;
        this.showBack = r115;
        this.enableShare = r108;
        if (r109 == true) goto L84;
        if (r116 == true) goto L84;
        boolean r138 = false;
    L85:
        this.forbidRightBack = r138;
        this.hideNavBar = r113;
        this.statusBarColor = r137;
        this.statusBarBgColor = r104;
        this.title = r110;
        this.bundleWebBgColor = r105;
        this.hideLoading = r114;
        this.supportExchangeTheme = r210;
        this.iconTheme = r118;
        this.titleColor = v8.a.a(r119);
        this.navBarColor = v8.a.a(r120);
        this.autoShowNavBar = r212;
        this.showFloatLive = r211;
        this.disableInputScroll = r311;
        this.androidSoftInputMode = r124;
        this.lazyLoad = r213;
        this.enableCardCache = r312;
        this.prerenderCacheKey = r127;
        this.enablePadAdapter = r313;
        this.padRatio = r129;
        this.containerBgColor = v8.a.a(r130);
        this.pageTag = r135;
        this.launchMode = r136;
        return;
    L84:
        r138 = true;
        goto L85
    L72:
        if (Intrinsics.areEqual(r103, "light") == false) goto L76;
        r137 = "white";
        goto L79
    L76:
        if ((!StringsKt.isBlank(r103)) == false) goto L78;
        r137 = r103;
        goto L79
    L78:
        r137 = r102;
        goto L79
    L63:
        r128 = false;
        goto L64
    L59:
        r126 = false;
        goto L60
    L55:
        r125 = false;
        goto L56
    L51:
        r123 = false;
        goto L52
    L47:
        r122 = false;
        goto L48
    L43:
        r121 = false;
        goto L44
    L39:
        r117 = false;
        goto L40
    L35:
        r116 = false;
        goto L37
    L31:
        r109 = false;
        goto L33
    L27:
        r115 = false;
        goto L29
    L23:
        r108 = false;
        goto L24
    L19:
        r113 = false;
        goto L21
    L15:
        r107 = false;
        goto L17
    L11:
        r112 = false;
        goto L13
    L7:
        r111 = false;
        goto L9
    }

    public final void F2(boolean r100) {
        this.showBack = r100;
    }

    public final void G2(boolean r100) {
        this.showClose = r100;
    }

    public final void H2(boolean r100) {
        this.showFloatLive = r100;
    }

    public final void I2(String r100) {
        this.statusBarBgColor = r100;
    }

    public final void J2(String r100) {
        this.statusBarColor = r100;
    }

    public final void K2(boolean r100) {
        this.supportExchangeTheme = r100;
    }

    public final void L2(String r100) {
        this.title = r100;
    }

    public final void M2(boolean r100) {
        this.useReceivedTitle = r100;
    }

    public final void i2(int r100) {
        this.androidSoftInputMode = r100;
    }

    public final void j2(boolean r100) {
        this.autoShowNavBar = r100;
    }

    public final void k2(int r100) {
        this.bundleWebBgColor = r100;
    }

    public final void l2(boolean r100) {
        this.closePositionRight = r100;
    }

    public final void m2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.containerBgColor = r100;
    }

    public final void n2(boolean r100) {
        this.disableInputScroll = r100;
    }

    public final void o2(boolean r100) {
        this.enableCardCache = r100;
    }

    public final void p2(boolean r100) {
        this.enablePadAdapter = r100;
    }

    public final void q2(boolean r100) {
        this.enableShare = r100;
    }

    public final void r2(boolean r100) {
        this.forbidRightBack = r100;
    }

    public final void s2(boolean r100) {
        this.hideLoading = r100;
    }

    public final void t2(boolean r100) {
        this.hideNavBar = r100;
    }

    public final void u2(BaseHybridParamVoNew.HybridType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hybridType = r100;
    }

    public final void v2(int r100) {
        this.iconTheme = r100;
    }

    public final void w2(String r100) {
        this.indicatorColor = r100;
    }

    public final void x2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.launchMode = r100;
    }

    public final void y2(boolean r100) {
        this.lazyLoad = r100;
    }

    public final void z2(float r100) {
        this.padRatio = r100;
    }

    public FragmentParamVoNew(boolean r100, BaseHybridParamVoNew.HybridType r101, boolean r110, String r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, String r119, String r210, String r211, int r212, boolean r213, boolean r214, boolean r215, int r216, boolean r217, boolean r218, String r219, String r310, boolean r311, int r312, boolean r313, boolean r314, String r315, boolean r316, float r317, String r318, String r319, String r410, boolean r411) {
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        Intrinsics.checkNotNullParameter(r315, "prerenderCacheKey");
        Intrinsics.checkNotNullParameter(r318, "containerBgColor");
        Intrinsics.checkNotNullParameter(r319, "pageTag");
        Intrinsics.checkNotNullParameter(r410, "launchMode");
        super(0);
        this.useReceivedTitle = r100;
        this.hybridType = r101;
        this.pullDownIndicatorNotShow = r110;
        this.indicatorColor = r111;
        this.showClose = r112;
        this.showBack = r113;
        this.enableShare = r114;
        this.forbidRightBack = r115;
        this.hideNavBar = r116;
        this.isPopUp = r117;
        this.isRealFullScreen = r118;
        this.statusBarColor = r119;
        this.statusBarBgColor = r210;
        this.title = r211;
        this.bundleWebBgColor = r212;
        this.hideLoading = r213;
        this.supportExchangeTheme = r214;
        this.closePositionRight = r215;
        this.iconTheme = r216;
        this.autoShowNavBar = r217;
        this.showFloatLive = r218;
        this.titleColor = r219;
        this.navBarColor = r310;
        this.disableInputScroll = r311;
        this.androidSoftInputMode = r312;
        this.lazyLoad = r313;
        this.enableCardCache = r314;
        this.prerenderCacheKey = r315;
        this.enablePadAdapter = r316;
        this.padRatio = r317;
        this.containerBgColor = r318;
        this.pageTag = r319;
        this.launchMode = r410;
        this.isPullUpPopup = r411;
    }
}
