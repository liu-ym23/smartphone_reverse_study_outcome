package com.bytedance.android.annie.scheme.vo.refactor;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.annie.scheme.convert.HybridTypeNew;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00107\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\"\u0010@\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u00108\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\"\u0010C\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\"\u0010F\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\"\u0010I\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u00108\u001a\u0004\bJ\u0010:\"\u0004\bK\u0010<R\"\u0010L\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u00108\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\"\u0010R\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0004\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\"\u0010X\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u00108\u001a\u0004\bY\u0010:\"\u0004\bZ\u0010<R\"\u0010[\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u00108\u001a\u0004\b\\\u0010:\"\u0004\b]\u0010<R\"\u0010^\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u00108\u001a\u0004\b_\u0010:\"\u0004\b`\u0010<R\"\u0010a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0004\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\"\u0010d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0004\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\bR\"\u0010g\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010\u0004\u001a\u0004\bh\u0010\u0006\"\u0004\bi\u0010\bR$\u0010k\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010q\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0004\u001a\u0004\br\u0010\u0006\"\u0004\bs\u0010\bR$\u0010t\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010l\u001a\u0004\bu\u0010n\"\u0004\bv\u0010pR\"\u0010w\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bw\u00108\u001a\u0004\bx\u0010:\"\u0004\by\u0010<R\"\u0010z\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bz\u00108\u001a\u0004\b{\u0010:\"\u0004\b|\u0010<R\"\u0010}\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b}\u00108\u001a\u0004\b~\u0010:\"\u0004\b\u007f\u0010<R*\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R(\u0010\u0087\u0001\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010l\u001a\u0005\b\u0088\u0001\u0010n\"\u0005\b\u0089\u0001\u0010pR&\u0010\u008a\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR&\u0010\u008d\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u0004\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR&\u0010\u0090\u0001\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u00108\u001a\u0005\b\u0091\u0001\u0010:\"\u0005\b\u0092\u0001\u0010<R&\u0010\u0093\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010\u0004\u001a\u0005\b\u0094\u0001\u0010\u0006\"\u0005\b\u0095\u0001\u0010\bR&\u0010\u0096\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0004\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR&\u0010\u0099\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010\u0004\u001a\u0005\b\u009a\u0001\u0010\u0006\"\u0005\b\u009b\u0001\u0010\bR&\u0010\u009c\u0001\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u00108\u001a\u0005\b\u009d\u0001\u0010:\"\u0005\b\u009e\u0001\u0010<R&\u0010\u009f\u0001\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u00108\u001a\u0005\b \u0001\u0010:\"\u0005\b¡\u0001\u0010<R&\u0010¢\u0001\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u00108\u001a\u0005\b£\u0001\u0010:\"\u0005\b¤\u0001\u0010<¨\u0006¥\u0001"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/PopupHybridParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/FragmentParamVoNew;", "", "width", "I", "getWidth", "()I", DevicePlans.DEVICE_PLAN_VIVO4, "(I)V", "height", "getHeight", "N3", "horizontalWidth", "Y2", "S3", "horizontalHeight", "V2", "P3", "horizontalHeightPercent", "W2", "Q3", "horizontalWidthPercent", "Z2", "T3", "horizontalRadius", "X2", "R3", GXTemplateKey.FLEXBOX_MARGIN, "d3", "X3", "marginBottom", "getMarginBottom", "Y3", "marginRight", "getMarginRight", "Z3", "radius", "l3", "f4", "radiusTopLeft", DevicePlans.DEVICE_PLAN_OPPO3, "i4", "radiusTopRight", "p3", "j4", "radiusBottomRight", "n3", "h4", "radiusBottomLeft", "m3", "g4", GXTemplateKey.GAIAX_LAYER_GRAVITY, "T2", "M3", "", "useBottomClose", "Z", "y3", "()Z", "s4", "(Z)V", "landScapeCustomHeight", "b3", "V3", "landScapeCustomWidth", "c3", "W3", "landScapeCustomGravity", "a3", "U3", "showDim", "r3", "l4", "showDimForce", "s3", "m4", "canceledOnTouchOutside", DiagnoseResult.DIAGNOSE_LEVEL_P2, "J3", "heightPercent", "U2", "O3", "widthPercent", "B3", "w4", "rateHeight", "q3", "k4", "useRealScreenHeight", "A3", "u4", "enablePullUp", "S2", "L3", "disableNestedChildScroll", "R2", "K3", "upOffsetHeight", "v3", "p4", "usePlayerBottomHeight", "z3", "t4", "padUsePlayerBottomHeight", "i3", "c4", "", "upStatusBarBgColor", "Ljava/lang/String;", "w3", "()Ljava/lang/String;", "q4", "(Ljava/lang/String;)V", "isAlreadyAdaptationUi", "F3", "I3", "popUpType", "j3", "d4", "needAnimation", "g3", "b4", "windowFloating", "C3", "x4", "abandonCoordinate", "N2", "G3", "", "maskAlpha", FaceService.girlLabel, "e3", "()F", "a4", "(F)V", "maskBgColor", "f3", "setMaskBgColor", "upCloseIconPosition", "t3", "n4", "upHeightPercent", "u3", "o4", "upTransStatusBar", "x3", "r4", "xOffset", "D3", "y4", "yOffset", "E3", "z4", "pullDownHeight", "k3", "e4", "allowingStateLoss", "O2", "H3", "delayOpen", "Q2", "setDelayOpen", "padUsePhoneSize", "h3", "setPadUsePhoneSize", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class PopupHybridParamVoNew extends FragmentParamVoNew {
    public static final Parcelable.Creator<PopupHybridParamVoNew> CREATOR = null;

    @SerializedName(AppConstants.ARG_ABANDON_COORDINATE)
    private boolean abandonCoordinate;

    @SerializedName("allowing_state_loss")
    private boolean allowingStateLoss;

    @SerializedName("mask_click_disable")
    private boolean canceledOnTouchOutside;

    @SerializedName("delay_open")
    private boolean delayOpen;

    @SerializedName("disable_nested_child_scroll")
    private boolean disableNestedChildScroll;

    @SerializedName("up_full_screen")
    private boolean enablePullUp;

    @SerializedName(GXTemplateKey.GAIAX_LAYER_GRAVITY)
    private int gravity;

    @SerializedName("height")
    private int height;

    @SerializedName(ECFindSimilarConfig.HEIGHT_PERCENT)
    private int heightPercent;

    @SerializedName("horizontal_height")
    private int horizontalHeight;

    @SerializedName("horizontal_height_percent")
    private int horizontalHeightPercent;

    @SerializedName("horizontal_radius")
    private int horizontalRadius;

    @SerializedName("horizontal_width")
    private int horizontalWidth;

    @SerializedName("horizontal_width_percent")
    private int horizontalWidthPercent;

    @SerializedName("is_already_adaptation_ui")
    private int isAlreadyAdaptationUi;

    @SerializedName("landScape_custom_gravity")
    private boolean landScapeCustomGravity;

    @SerializedName("landscape_custom_height")
    private boolean landScapeCustomHeight;

    @SerializedName("landScape_custom_width")
    private boolean landScapeCustomWidth;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private int margin;

    @SerializedName("margin_bottom")
    private int marginBottom;

    @SerializedName("margin_right")
    private int marginRight;

    @SerializedName("mask_alpha")
    private float maskAlpha;

    @SerializedName("mask_bg_color")
    private String maskBgColor;

    @SerializedName("open_animate")
    private boolean needAnimation;

    @SerializedName("pad_use_phone_size")
    private boolean padUsePhoneSize;

    @SerializedName("pad_use_player_bottom_height")
    private int padUsePlayerBottomHeight;

    @SerializedName("popup_type")
    private String popUpType;

    @SerializedName(AppConstants.BUNDLE_PULL_DOWN_HEIGHT)
    private int pullDownHeight;

    @SerializedName("radius")
    private int radius;

    @SerializedName("radius_bottom_left")
    private int radiusBottomLeft;

    @SerializedName("radius_bottom_right")
    private int radiusBottomRight;

    @SerializedName("radius_top_left")
    private int radiusTopLeft;

    @SerializedName("radius_top_right")
    private int radiusTopRight;

    @SerializedName("rate_height")
    private int rateHeight;

    @SerializedName("show_dim")
    private boolean showDim;

    @SerializedName("show_dim_force")
    private boolean showDimForce;

    @SerializedName("close_icon_position")
    private int upCloseIconPosition;

    @SerializedName("up_height_percent")
    private int upHeightPercent;

    @SerializedName("up_offset_height")
    private int upOffsetHeight;

    @SerializedName("up_status_bar_bg_color")
    private String upStatusBarBgColor;

    @SerializedName("up_trans_status_bar")
    private boolean upTransStatusBar;

    @SerializedName("use_bottom_close")
    private boolean useBottomClose;

    @SerializedName("use_player_bottom_height")
    private int usePlayerBottomHeight;

    @SerializedName("use_real_screen_height")
    private boolean useRealScreenHeight;

    @SerializedName("width")
    private int width;

    @SerializedName("width_percent")
    private int widthPercent;

    @SerializedName("window_floating")
    private boolean windowFloating;

    @SerializedName("x_offset")
    private int xOffset;

    @SerializedName("y_offset")
    private int yOffset;

    public static final class a implements Parcelable.Creator<PopupHybridParamVoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopupHybridParamVoNew createFromParcel(Parcel r510) {
            Intrinsics.checkNotNullParameter(r510, "parcel");
            int r100 = r510.readInt();
            int r101 = r510.readInt();
            int r102 = r510.readInt();
            int r103 = r510.readInt();
            int r104 = r510.readInt();
            int r105 = r510.readInt();
            int r106 = r510.readInt();
            int r107 = r510.readInt();
            int r110 = r510.readInt();
            int r111 = r510.readInt();
            int r112 = r510.readInt();
            int r113 = r510.readInt();
            int r114 = r510.readInt();
            int r115 = r510.readInt();
            int r116 = r510.readInt();
            int r117 = r510.readInt();
            if (r510.readInt() == 0) goto L5;
            boolean r118 = true;
        L7:
            if (r510.readInt() == 0) goto L9;
            boolean r210 = true;
        L11:
            if (r510.readInt() == 0) goto L13;
            boolean r211 = true;
        L15:
            if (r510.readInt() == 0) goto L17;
            boolean r212 = true;
        L19:
            if (r510.readInt() == 0) goto L21;
            boolean r213 = true;
        L23:
            if (r510.readInt() == 0) goto L25;
            boolean r214 = true;
        L27:
            if (r510.readInt() == 0) goto L29;
            boolean r215 = true;
        L30:
            int r216 = r510.readInt();
            int r217 = r510.readInt();
            int r218 = r510.readInt();
            if (r510.readInt() == 0) goto L33;
            boolean r310 = true;
        L35:
            if (r510.readInt() == 0) goto L37;
            boolean r311 = true;
        L39:
            if (r510.readInt() == 0) goto L41;
            boolean r312 = true;
        L42:
            int r313 = r510.readInt();
            int r314 = r510.readInt();
            int r315 = r510.readInt();
            String r316 = r510.readString();
            int r317 = r510.readInt();
            String r318 = r510.readString();
            if (r510.readInt() == 0) goto L45;
            boolean r319 = true;
        L47:
            if (r510.readInt() == 0) goto L49;
            boolean r410 = true;
        L51:
            if (r510.readInt() == 0) goto L53;
            boolean r411 = true;
        L54:
            float r412 = r510.readFloat();
            String r413 = r510.readString();
            int r414 = r510.readInt();
            int r415 = r510.readInt();
            if (r510.readInt() == 0) goto L57;
            boolean r416 = true;
        L58:
            int r417 = r510.readInt();
            int r418 = r510.readInt();
            int r419 = r510.readInt();
            if (r510.readInt() == 0) goto L61;
            boolean r511 = true;
        L63:
            if (r510.readInt() == 0) goto L65;
            boolean r512 = true;
        L67:
            if (r510.readInt() == 0) goto L69;
            boolean r513 = true;
        L71:
            return new PopupHybridParamVoNew(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r511, r512, r513);
        L69:
            r513 = false;
            goto L71
        L65:
            r512 = false;
            goto L67
        L61:
            r511 = false;
            goto L63
        L57:
            r416 = false;
            goto L58
        L53:
            r411 = false;
            goto L54
        L49:
            r410 = false;
            goto L51
        L45:
            r319 = false;
            goto L47
        L41:
            r312 = false;
            goto L42
        L37:
            r311 = false;
            goto L39
        L33:
            r310 = false;
            goto L35
        L29:
            r215 = false;
            goto L30
        L25:
            r214 = false;
            goto L27
        L21:
            r213 = false;
            goto L23
        L17:
            r212 = false;
            goto L19
        L13:
            r211 = false;
            goto L15
        L9:
            r210 = false;
            goto L11
        L5:
            r118 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopupHybridParamVoNew[] newArray(int r100) {
            return new PopupHybridParamVoNew[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopupHybridParamVoNew() {
        this(0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeInt(this.horizontalWidth);
        r100.writeInt(this.horizontalHeight);
        r100.writeInt(this.horizontalHeightPercent);
        r100.writeInt(this.horizontalWidthPercent);
        r100.writeInt(this.horizontalRadius);
        r100.writeInt(this.margin);
        r100.writeInt(this.marginBottom);
        r100.writeInt(this.marginRight);
        r100.writeInt(this.radius);
        r100.writeInt(this.radiusTopLeft);
        r100.writeInt(this.radiusTopRight);
        r100.writeInt(this.radiusBottomRight);
        r100.writeInt(this.radiusBottomLeft);
        r100.writeInt(this.gravity);
        r100.writeInt(this.useBottomClose ? 1 : 0);
        r100.writeInt(this.landScapeCustomHeight ? 1 : 0);
        r100.writeInt(this.landScapeCustomWidth ? 1 : 0);
        r100.writeInt(this.landScapeCustomGravity ? 1 : 0);
        r100.writeInt(this.showDim ? 1 : 0);
        r100.writeInt(this.showDimForce ? 1 : 0);
        r100.writeInt(this.canceledOnTouchOutside ? 1 : 0);
        r100.writeInt(this.heightPercent);
        r100.writeInt(this.widthPercent);
        r100.writeInt(this.rateHeight);
        r100.writeInt(this.useRealScreenHeight ? 1 : 0);
        r100.writeInt(this.enablePullUp ? 1 : 0);
        r100.writeInt(this.disableNestedChildScroll ? 1 : 0);
        r100.writeInt(this.upOffsetHeight);
        r100.writeInt(this.usePlayerBottomHeight);
        r100.writeInt(this.padUsePlayerBottomHeight);
        r100.writeString(this.upStatusBarBgColor);
        r100.writeInt(this.isAlreadyAdaptationUi);
        r100.writeString(this.popUpType);
        r100.writeInt(this.needAnimation ? 1 : 0);
        r100.writeInt(this.windowFloating ? 1 : 0);
        r100.writeInt(this.abandonCoordinate ? 1 : 0);
        r100.writeFloat(this.maskAlpha);
        r100.writeString(this.maskBgColor);
        r100.writeInt(this.upCloseIconPosition);
        r100.writeInt(this.upHeightPercent);
        r100.writeInt(this.upTransStatusBar ? 1 : 0);
        r100.writeInt(this.xOffset);
        r100.writeInt(this.yOffset);
        r100.writeInt(this.pullDownHeight);
        r100.writeInt(this.allowingStateLoss ? 1 : 0);
        r100.writeInt(this.delayOpen ? 1 : 0);
        r100.writeInt(this.padUsePhoneSize ? 1 : 0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public final String toString() {
        return super.toString() + "\nPopupHybridParamVo(width=" + this.width + ", height=" + this.height + ", horizontalWidth=" + this.horizontalWidth + ", horizontalHeight=" + this.horizontalHeight + ", horizontalHeightPercent=" + this.horizontalHeightPercent + ", horizontalWidthPercent=" + this.horizontalWidthPercent + ", horizontalRadius=" + this.horizontalRadius + ", margin=" + this.margin + ", marginBottom=" + this.marginBottom + ", marginRight=" + this.marginRight + ", radius=" + this.radius + ", radiusTopLeft=" + this.radiusTopLeft + ", radiusTopRight=" + this.radiusTopRight + ", radiusBottomRight=" + this.radiusBottomRight + ", radiusBottomLeft=" + this.radiusBottomLeft + ", gravity=" + this.gravity + ", useBottomClose=" + this.useBottomClose + ", landScapeCustomHeight=" + this.landScapeCustomHeight + ", landScapeCustomWidth=" + this.landScapeCustomWidth + ", landScapeCustomGravity=" + this.landScapeCustomGravity + ", showDim=" + this.showDim + ", showDimForce=" + this.showDimForce + ", canceledOnTouchOutside=" + this.canceledOnTouchOutside + ", heightPercent=" + this.heightPercent + ", widthPercent=" + this.widthPercent + ", rateHeight=" + this.rateHeight + ", useRealScreenHeight=" + this.useRealScreenHeight + ", enablePullUp=" + this.enablePullUp + ", disableNestedChildScroll=" + this.disableNestedChildScroll + ", upOffsetHeight=" + this.upOffsetHeight + ", usePlayerBottomHeight=" + this.usePlayerBottomHeight + ", padUsePlayerBottomHeight=" + this.padUsePlayerBottomHeight + ", upStatusBarBgColor=" + this.upStatusBarBgColor + ", isAlreadyAdaptationUi=" + this.isAlreadyAdaptationUi + ", popUpType=" + this.popUpType + ", needAnimation=" + this.needAnimation + ", windowFloating=" + this.windowFloating + ", abandonCoordinate=" + this.abandonCoordinate + ", maskAlpha=" + this.maskAlpha + ", upCloseIconPosition=" + this.upCloseIconPosition + ", upHeightPercent=" + this.upHeightPercent + ", upTransStatusBar=" + this.upTransStatusBar + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", pullDownHeight=" + this.pullDownHeight + ", delayOpen=" + this.delayOpen + ", padUsePhoneSize=" + this.padUsePhoneSize + "})";
    }

    public final boolean A3() {
        return this.useRealScreenHeight;
    }

    public final int B3() {
        return this.widthPercent;
    }

    public final boolean C3() {
        return this.windowFloating;
    }

    public final int D3() {
        return this.xOffset;
    }

    public final int E3() {
        return this.yOffset;
    }

    public final int F3() {
        return this.isAlreadyAdaptationUi;
    }

    public final boolean N2() {
        return this.abandonCoordinate;
    }

    public final boolean O2() {
        return this.allowingStateLoss;
    }

    public final boolean P2() {
        return this.canceledOnTouchOutside;
    }

    public final boolean Q2() {
        return this.delayOpen;
    }

    public final boolean R2() {
        return this.disableNestedChildScroll;
    }

    public final boolean S2() {
        return this.enablePullUp;
    }

    public final int T2() {
        return this.gravity;
    }

    public final int U2() {
        return this.heightPercent;
    }

    public final int V2() {
        return this.horizontalHeight;
    }

    public final int W2() {
        return this.horizontalHeightPercent;
    }

    public final int X2() {
        return this.horizontalRadius;
    }

    public final int Y2() {
        return this.horizontalWidth;
    }

    public final int Z2() {
        return this.horizontalWidthPercent;
    }

    public final boolean a3() {
        return this.landScapeCustomGravity;
    }

    public final boolean b3() {
        return this.landScapeCustomHeight;
    }

    public final boolean c3() {
        return this.landScapeCustomWidth;
    }

    public final int d3() {
        return this.margin;
    }

    public final float e3() {
        return this.maskAlpha;
    }

    public final String f3() {
        return this.maskBgColor;
    }

    public final boolean g3() {
        return this.needAnimation;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean h3() {
        return this.padUsePhoneSize;
    }

    public final int i3() {
        return this.padUsePlayerBottomHeight;
    }

    public final String j3() {
        return this.popUpType;
    }

    public final int k3() {
        return this.pullDownHeight;
    }

    public final int l3() {
        return this.radius;
    }

    public final int m3() {
        return this.radiusBottomLeft;
    }

    public final int n3() {
        return this.radiusBottomRight;
    }

    public final int o3() {
        return this.radiusTopLeft;
    }

    public final int p3() {
        return this.radiusTopRight;
    }

    public final int q3() {
        return this.rateHeight;
    }

    public final boolean r3() {
        return this.showDim;
    }

    public final boolean s3() {
        return this.showDimForce;
    }

    public final int t3() {
        return this.upCloseIconPosition;
    }

    public final int u3() {
        return this.upHeightPercent;
    }

    public final int v3() {
        return this.upOffsetHeight;
    }

    public final String w3() {
        return this.upStatusBarBgColor;
    }

    public final boolean x3() {
        return this.upTransStatusBar;
    }

    public final boolean y3() {
        return this.useBottomClose;
    }

    public final int z3() {
        return this.usePlayerBottomHeight;
    }

    public /* synthetic */ PopupHybridParamVoNew(int r510) {
        this(300, 400, 0, 0, 0, 0, -1, 0, 0, 0, 8, 0, 0, 0, 0, 17, false, false, false, false, false, false, true, 0, 0, -1, false, false, false, -1, 0, 0, "", 0, "", true, true, false, 0.0f, "", 0, 0, false, 0, 0, 0, false, false, false);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public final void F(u8.a r510) {
        super.F(r510);
        v8.a r100 = this.T;
        if (r100 != null) goto L5;
        return;
    L5:
        if (((Number) r100.b("use_host", 0)).intValue() != 1) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        BaseHybridParamVoNew.HybridType r102 = BaseHybridParamVoNew.HybridType.HOST_H5;
    L11:
        HybridTypeNew r103 = r510.f549147d;
        if (r103 != null) goto L14;
    L16:
        int r104 = ((Number) r100.b("radius", 8)).intValue();
        int r105 = ((Number) r100.b("radius_top_right", 0)).intValue();
        int r106 = ((Number) r100.b("radius_top_left", 0)).intValue();
        int r107 = ((Number) r100.b("radius_bottom_right", 0)).intValue();
        int r108 = ((Number) r100.b("radius_bottom_left", 0)).intValue();
        int r110 = ((Number) r100.b("radius_enable_each", 0)).intValue();
        int r111 = ((Number) r100.b("height", 400)).intValue();
        int r112 = ((Number) r100.b("width", 300)).intValue();
        int r113 = ((Number) r100.b(GXTemplateKey.FLEXBOX_MARGIN, 0)).intValue();
        int r114 = ((Number) r100.b("margin_bottom", 0)).intValue();
        int r109 = ((Number) r100.b("margin_right", 0)).intValue();
        int r115 = ((Number) r100.b(ECFindSimilarConfig.HEIGHT_PERCENT, 0)).intValue();
        int r116 = ((Number) r100.b("width_percent", 0)).intValue();
        int r117 = ((Number) r100.b("horizontal_height", 0)).intValue();
        int r118 = ((Number) r100.b("horizontal_width", 0)).intValue();
        int r119 = ((Number) r100.b("horizontal_height_percent", 0)).intValue();
        int r120 = ((Number) r100.b("horizontal_width_percent", 0)).intValue();
        int r121 = ((Number) r100.b("horizontal_radius", -1)).intValue();
        float r122 = ((Number) r100.b("mask_alpha", Float.valueOf(0.0f))).floatValue();
        String r123 = (String) r100.b("mask_bg_color", "");
        if (((Number) r100.b("show_dim", 0)).intValue() != 1) goto L19;
        boolean r124 = true;
    L20:
        boolean r210 = r124;
        if (((Number) r100.b("show_mask", 0)).intValue() != 1) goto L23;
        boolean r125 = true;
    L24:
        boolean r211 = r125;
        if (((Number) r100.b("mask_click_disable", 0)).intValue() != 0) goto L27;
        boolean r126 = true;
    L28:
        boolean r212 = r126;
        if (((Number) r100.b("disable_outside_click_close", 0)).intValue() != 0) goto L31;
        boolean r127 = true;
    L32:
        boolean r310 = r127;
        if (((Number) r100.b("open_animate", 1)).intValue() != 1) goto L35;
        boolean r128 = true;
    L36:
        String r129 = (String) r100.b("show_from", "");
        boolean r311 = r128;
        String r130 = (String) r100.b("transition_animation", "auto");
        if (((Number) r100.b("landscape_custom_gravity", 0)).intValue() != 1) goto L39;
        boolean r131 = true;
    L40:
        boolean r312 = r131;
        if (((Number) r100.b("landscape_custom_height", 0)).intValue() != 1) goto L43;
        boolean r132 = true;
    L44:
        boolean r313 = r132;
        int r133 = ((Number) r100.b("rate_height", -1)).intValue();
        String r134 = (String) r100.b("up_status_bar_bg_color", "");
        if (((Number) r100.b("landscape_custom_width", 0)).intValue() != 1) goto L47;
        boolean r135 = true;
    L48:
        boolean r314 = r135;
        if (((Number) r100.b("up_full_screen", 0)).intValue() != 1) goto L51;
        boolean r136 = true;
    L52:
        boolean r315 = r136;
        int r137 = ((Number) r100.b("up_offset_height", -1)).intValue();
        if (((Number) r100.b("disable_nested_child_scroll", 0)).intValue() != 1) goto L55;
        boolean r138 = true;
    L56:
        boolean r316 = r138;
        int r139 = ((Number) r100.b("close_icon_position", 0)).intValue();
        if (((Number) r100.b("window_floating", 1)).intValue() != 1) goto L59;
        boolean r140 = true;
    L60:
        boolean r410 = r140;
        if (((Number) r100.b("use_real_screen_height", 0)).intValue() != 1) goto L63;
        boolean r141 = true;
    L64:
        boolean r411 = r141;
        int r142 = ((Number) r100.b("up_height_percent", 0)).intValue();
        if (((Number) r100.b("up_trans_status_bar", 0)).intValue() != 1) goto L67;
        boolean r143 = true;
    L68:
        boolean r412 = r143;
        int r144 = ((Number) r100.b("is_already_adaptation_ui", 0)).intValue();
        if (((Number) r100.b("allowing_state_loss", 0)).intValue() != 1) goto L71;
        boolean r145 = true;
    L72:
        boolean r413 = r145;
        if (((Number) r100.b("delay_open", 0)).intValue() != 1) goto L75;
        boolean r146 = true;
    L76:
        boolean r414 = r146;
        if (((Number) r100.b(AppConstants.ARG_ABANDON_COORDINATE, 0)).intValue() != 1) goto L79;
        boolean r147 = true;
    L80:
        boolean r415 = r147;
        int r148 = ((Number) r100.b(AppConstants.BUNDLE_PULL_DOWN_HEIGHT, 0)).intValue();
        if (((Number) r100.b("pad_use_phone_size", 0)).intValue() != 1) goto L83;
        boolean r149 = true;
    L84:
        u2(r102);
        B2(true);
        this.width = r112;
        this.height = r111;
        this.margin = r113;
        this.horizontalWidth = r118;
        this.horizontalHeight = r117;
        this.horizontalHeightPercent = r119;
        this.horizontalWidthPercent = r120;
        this.horizontalRadius = r121;
        this.radius = r104;
        if (r110 != 1) goto L87;
        this.radiusTopLeft = r106;
        this.radiusTopRight = r105;
        this.radiusBottomRight = r107;
        this.radiusBottomLeft = r108;
    L87:
        this.gravity = 17;
        this.rateHeight = r133;
        this.useRealScreenHeight = r411;
        this.upStatusBarBgColor = r134;
        this.enablePullUp = r315;
        this.upOffsetHeight = r137;
        this.disableNestedChildScroll = r316;
        this.upCloseIconPosition = r139;
        this.landScapeCustomWidth = r314;
        this.heightPercent = r115;
        this.widthPercent = r116;
        if (StringsKt.isBlank(r129) == false) goto L90;
        String r150 = r130;
    L91:
        this.popUpType = r150;
        if (r311 == true) goto L94;
    L98:
        boolean r151 = false;
    L99:
        this.needAnimation = r151;
        this.landScapeCustomGravity = r312;
        this.landScapeCustomHeight = r313;
        this.maskAlpha = r122;
        this.maskBgColor = v8.a.a(r123);
        if (r210 == true) goto L104;
        if (r211 == true) goto L104;
        boolean r152 = false;
    L105:
        this.showDim = r152;
        if (r210 == true) goto L110;
        if (r211 == true) goto L110;
        boolean r153 = false;
    L111:
        this.showDimForce = r153;
        this.windowFloating = r410;
        if (r212 == false) goto L115;
        if (r310 == false) goto L115;
        boolean r154 = true;
    L116:
        this.canceledOnTouchOutside = r154;
        this.upHeightPercent = r142;
        this.upTransStatusBar = r412;
        this.isAlreadyAdaptationUi = r144;
        this.marginBottom = r114;
        this.marginRight = r109;
        this.abandonCoordinate = r415;
        this.pullDownHeight = r148;
        this.allowingStateLoss = r413;
        this.delayOpen = r414;
        this.padUsePhoneSize = r149;
        return;
    L115:
        r154 = false;
    L110:
        r153 = true;
    L104:
        r152 = true;
        goto L105
    L94:
        if (Intrinsics.areEqual(r130, "none") == true) goto L98;
        if (StringsKt.isBlank(r123) == false) goto L98;
        r151 = true;
        goto L99
    L90:
        r150 = r129;
        goto L91
    L83:
        r149 = false;
        goto L84
    L79:
        r147 = false;
        goto L80
    L75:
        r146 = false;
        goto L76
    L71:
        r145 = false;
        goto L72
    L67:
        r143 = false;
        goto L68
    L63:
        r141 = false;
        goto L64
    L59:
        r140 = false;
        goto L60
    L55:
        r138 = false;
        goto L56
    L51:
        r136 = false;
        goto L52
    L47:
        r135 = false;
        goto L48
    L43:
        r132 = false;
        goto L44
    L39:
        r131 = false;
        goto L40
    L35:
        r128 = false;
        goto L36
    L31:
        r127 = false;
        goto L32
    L27:
        r126 = false;
        goto L28
    L23:
        r125 = false;
        goto L24
    L19:
        r124 = false;
        goto L20
    L14:
        if (r103 != HybridTypeNew.Lynx) goto L16;
        r102 = BaseHybridParamVoNew.HybridType.LYNX;
        goto L16
    L10:
        r102 = BaseHybridParamVoNew.HybridType.H5;
        goto L11
    L7:
        r101 = false;
        goto L8
    }

    public final void G3(boolean r100) {
        this.abandonCoordinate = r100;
    }

    public final void H3(boolean r100) {
        this.allowingStateLoss = r100;
    }

    public final void I3(int r100) {
        this.isAlreadyAdaptationUi = r100;
    }

    public final void J3(boolean r100) {
        this.canceledOnTouchOutside = r100;
    }

    public final void K3(boolean r100) {
        this.disableNestedChildScroll = r100;
    }

    public final void L3(boolean r100) {
        this.enablePullUp = r100;
    }

    public final void M3(int r100) {
        this.gravity = r100;
    }

    public final void N3(int r100) {
        this.height = r100;
    }

    public final void O3(int r100) {
        this.heightPercent = r100;
    }

    public final void P3(int r100) {
        this.horizontalHeight = r100;
    }

    public final void Q3(int r100) {
        this.horizontalHeightPercent = r100;
    }

    public final void R3(int r100) {
        this.horizontalRadius = r100;
    }

    public final void S3(int r100) {
        this.horizontalWidth = r100;
    }

    public final void T3(int r100) {
        this.horizontalWidthPercent = r100;
    }

    public final void U3(boolean r100) {
        this.landScapeCustomGravity = r100;
    }

    public final void V3(boolean r100) {
        this.landScapeCustomHeight = r100;
    }

    public final void W3(boolean r100) {
        this.landScapeCustomWidth = r100;
    }

    public final void X3(int r100) {
        this.margin = r100;
    }

    public final void Y3(int r100) {
        this.marginBottom = r100;
    }

    public final void Z3(int r100) {
        this.marginRight = r100;
    }

    public final void a4(float r100) {
        this.maskAlpha = r100;
    }

    public final void b4(boolean r100) {
        this.needAnimation = r100;
    }

    public final void c4(int r100) {
        this.padUsePlayerBottomHeight = r100;
    }

    public final void d4(String r100) {
        this.popUpType = r100;
    }

    public final void e4(int r100) {
        this.pullDownHeight = r100;
    }

    public final void f4(int r100) {
        this.radius = r100;
    }

    public final void g4(int r100) {
        this.radiusBottomLeft = r100;
    }

    public final void h4(int r100) {
        this.radiusBottomRight = r100;
    }

    public final void i4(int r100) {
        this.radiusTopLeft = r100;
    }

    public final void j4(int r100) {
        this.radiusTopRight = r100;
    }

    public final void k4(int r100) {
        this.rateHeight = r100;
    }

    public final void l4(boolean r100) {
        this.showDim = r100;
    }

    public final void m4(boolean r100) {
        this.showDimForce = r100;
    }

    public final void n4(int r100) {
        this.upCloseIconPosition = r100;
    }

    public final void o4(int r100) {
        this.upHeightPercent = r100;
    }

    public final void p4(int r100) {
        this.upOffsetHeight = r100;
    }

    public final void q4(String r100) {
        this.upStatusBarBgColor = r100;
    }

    public final void r4(boolean r100) {
        this.upTransStatusBar = r100;
    }

    public final void s4(boolean r100) {
        this.useBottomClose = r100;
    }

    public final void t4(int r100) {
        this.usePlayerBottomHeight = r100;
    }

    public final void u4(boolean r100) {
        this.useRealScreenHeight = r100;
    }

    public final void v4(int r100) {
        this.width = r100;
    }

    public final void w4(int r100) {
        this.widthPercent = r100;
    }

    public final void x4(boolean r100) {
        this.windowFloating = r100;
    }

    public final void y4(int r100) {
        this.xOffset = r100;
    }

    public final void z4(int r100) {
        this.yOffset = r100;
    }

    public PopupHybridParamVoNew(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, boolean r119, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, int r216, int r217, int r218, boolean r219, boolean r310, boolean r311, int r312, int r313, int r314, String r315, int r316, String r317, boolean r318, boolean r319, boolean r410, float r411, String r412, int r413, int r414, boolean r415, int r416, int r417, int r418, boolean r419, boolean r510, boolean r511) {
        super(0);
        this.width = r100;
        this.height = r101;
        this.horizontalWidth = r102;
        this.horizontalHeight = r103;
        this.horizontalHeightPercent = r104;
        this.horizontalWidthPercent = r105;
        this.horizontalRadius = r106;
        this.margin = r110;
        this.marginBottom = r111;
        this.marginRight = r112;
        this.radius = r113;
        this.radiusTopLeft = r114;
        this.radiusTopRight = r115;
        this.radiusBottomRight = r116;
        this.radiusBottomLeft = r117;
        this.gravity = r118;
        this.useBottomClose = r119;
        this.landScapeCustomHeight = r210;
        this.landScapeCustomWidth = r211;
        this.landScapeCustomGravity = r212;
        this.showDim = r213;
        this.showDimForce = r214;
        this.canceledOnTouchOutside = r215;
        this.heightPercent = r216;
        this.widthPercent = r217;
        this.rateHeight = r218;
        this.useRealScreenHeight = r219;
        this.enablePullUp = r310;
        this.disableNestedChildScroll = r311;
        this.upOffsetHeight = r312;
        this.usePlayerBottomHeight = r313;
        this.padUsePlayerBottomHeight = r314;
        this.upStatusBarBgColor = r315;
        this.isAlreadyAdaptationUi = r316;
        this.popUpType = r317;
        this.needAnimation = r318;
        this.windowFloating = r319;
        this.abandonCoordinate = r410;
        this.maskAlpha = r411;
        this.maskBgColor = r412;
        this.upCloseIconPosition = r413;
        this.upHeightPercent = r414;
        this.upTransStatusBar = r415;
        this.xOffset = r416;
        this.yOffset = r417;
        this.pullDownHeight = r418;
        this.allowingStateLoss = r419;
        this.delayOpen = r510;
        this.padUsePhoneSize = r511;
    }
}
