package com.bytedance.android.live.schema.vo;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00101\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010:\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\"\u0010=\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u00102\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\"\u0010@\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u00102\u001a\u0004\bA\u00104\"\u0004\bB\u00106R\"\u0010C\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u00102\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\"\u0010F\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\"\u0010L\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\"\u0010O\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u00102\u001a\u0004\bP\u00104\"\u0004\bQ\u00106R\"\u0010R\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0004\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006\"\u0004\b2\u0010\bR$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010a\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u00102\u001a\u0004\bb\u00104\"\u0004\bc\u00106R\"\u0010e\u001a\u00020d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010A\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010j\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010\u0004\u001a\u0004\b\u0004\u0010\u0006\"\u0004\bk\u0010\b¨\u0006l"}, d2 = {"Lcom/bytedance/android/live/schema/vo/PopupHybridParamVo;", "Landroid/os/Parcelable;", "", "width", "I", "getWidth", "()I", "a0", "(I)V", "height", "getHeight", "setHeight", "horizontalWidth", "e", "setHorizontalWidth", "horizontalHeight", "c", "setHorizontalHeight", "horizontalHeightPercent", "d", "setHorizontalHeightPercent", "horizontalWidthPercent", ce.f26391f, "setHorizontalWidthPercent", GXTemplateKey.FLEXBOX_MARGIN, ce.f26396k, "setMargin", "radius", "r", "R", "horizontalRadius", "getHorizontalRadius", "setHorizontalRadius", "radiusTopLeft", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, ExifInterface.LONGITUDE_WEST, "radiusTopRight", "D", "Y", "radiusBottomRight", "t", "U", "radiusBottomLeft", "s", ExifInterface.LATITUDE_SOUTH, GXTemplateKey.GAIAX_LAYER_GRAVITY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "N", "", "useBottomClose", "Z", "L", "()Z", "setUseBottomClose", "(Z)V", "landScapeCustomHeight", RXScreenCaptureService.KEY_INDEX, "setLandScapeCustomHeight", "landScapeCustomWidth", ce.f26395j, "setLandScapeCustomWidth", "landScapeCustomGravity", "h", "setLandScapeCustomGravity", "showDim", FaceService.girlLabel, "setShowDim", "canceledOnTouchOutside", "getCanceledOnTouchOutside", "setCanceledOnTouchOutside", "heightPercent", "b", "setHeightPercent", "widthPercent", "M", "setWidthPercent", "rateHeight", ExifInterface.LONGITUDE_EAST, "setRateHeight", "enablePullUp", "getEnablePullUp", "setEnablePullUp", "upOffsetHeight", "J", "setUpOffsetHeight", "upHeightPercent", "getUpHeightPercent", "setUpHeightPercent", "usePlayerBottomHeight", "getUsePlayerBottomHeight", "", "upStatusBarBgColor", "Ljava/lang/String;", "K", "()Ljava/lang/String;", "setUpStatusBarBgColor", "(Ljava/lang/String;)V", "needAnimation", "q", "O", "", "maskAlpha", "o", "()F", "setMaskAlpha", "(F)V", "upCloseIconPosition", "setUpCloseIconPosition", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopupHybridParamVo implements Parcelable {
    public static final Parcelable.Creator<PopupHybridParamVo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f100537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f100538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f100539c;

    @SerializedName("mask_click_disable")
    private boolean canceledOnTouchOutside;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f100540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f100541e;

    @SerializedName("up_full_screen")
    private boolean enablePullUp;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f100542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f100543g;

    @SerializedName(GXTemplateKey.GAIAX_LAYER_GRAVITY)
    private int gravity;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f100544h;

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

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f100545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LynxHybridParamVo f100546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BaseHybridParamVo f100547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f100548l;

    @SerializedName("landScape_custom_gravity")
    private boolean landScapeCustomGravity;

    @SerializedName("landscape_custom_height")
    private boolean landScapeCustomHeight;

    @SerializedName("landScape_custom_width")
    private boolean landScapeCustomWidth;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f100549m;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private int margin;

    @SerializedName("mask_alpha")
    private float maskAlpha;

    @SerializedName("open_animate")
    private boolean needAnimation;

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

    @SerializedName("close_icon_position")
    private int upCloseIconPosition;

    @SerializedName("up_height_percent")
    private int upHeightPercent;

    @SerializedName("up_offset_height")
    private int upOffsetHeight;

    @SerializedName("up_status_bar_bg_color")
    private String upStatusBarBgColor;

    @SerializedName("use_bottom_close")
    private boolean useBottomClose;

    @SerializedName("use_player_bottom_height")
    private int usePlayerBottomHeight;

    @SerializedName("width")
    private int width;

    @SerializedName("width_percent")
    private int widthPercent;

    public static class a implements Parcelable.Creator<PopupHybridParamVo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopupHybridParamVo createFromParcel(Parcel r510) {
            Intrinsics.checkNotNullParameter(r510, "in");
            int r100 = r510.readInt();
            int r101 = r510.readInt();
            int r102 = r510.readInt();
            int r103 = r510.readInt();
            int r104 = r510.readInt();
            int r105 = r510.readInt();
            int r106 = r510.readInt();
            int r110 = r510.readInt();
            int r111 = r510.readInt();
            int r112 = r510.readInt();
            int r113 = r510.readInt();
            int r114 = r510.readInt();
            int r115 = r510.readInt();
            int r116 = r510.readInt();
            if (r510.readInt() == 0) goto L5;
            boolean r117 = true;
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
        L22:
            int r214 = r510.readInt();
            if (r510.readInt() == 0) goto L25;
            boolean r215 = true;
        L27:
            if (r510.readInt() == 0) goto L29;
            boolean r216 = true;
        L30:
            int r217 = r510.readInt();
            int r218 = r510.readInt();
            int r219 = r510.readInt();
            if (r510.readInt() == 0) goto L33;
            boolean r310 = true;
        L34:
            int r311 = r510.readInt();
            int r312 = r510.readInt();
            int r313 = r510.readInt();
            String r314 = r510.readString();
            String r315 = r510.readString();
            String r316 = r510.readString();
            String r317 = r510.readString();
            if (r510.readInt() == 0) goto L37;
            boolean r318 = true;
        L39:
            if (r510.readInt() == 0) goto L41;
            boolean r319 = true;
        L43:
            if (r510.readInt() == 0) goto L45;
            boolean r410 = true;
        L46:
            float r411 = r510.readFloat();
            int r412 = r510.readInt();
            if (r510.readInt() == 0) goto L49;
            boolean r413 = true;
        L50:
            int r414 = r510.readInt();
            BaseHybridParamVo r415 = null;
            if (r510.readInt() == 0) goto L53;
            LynxHybridParamVo r416 = LynxHybridParamVo.CREATOR.createFromParcel(r510);
        L55:
            if (r510.readInt() == 0) goto L58;
            r415 = BaseHybridParamVo.CREATOR.createFromParcel(r510);
        L58:
            if (r510.readInt() == 0) goto L60;
            boolean r417 = true;
        L62:
            return new PopupHybridParamVo(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r416, r415, r417, r510.readString());
        L60:
            r417 = false;
            goto L62
        L53:
            r416 = null;
            goto L55
        L49:
            r413 = false;
            goto L50
        L45:
            r410 = false;
            goto L46
        L41:
            r319 = false;
            goto L43
        L37:
            r318 = false;
            goto L39
        L33:
            r310 = false;
            goto L34
        L29:
            r216 = false;
            goto L30
        L25:
            r215 = false;
            goto L27
        L21:
            r213 = false;
            goto L22
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
            r117 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopupHybridParamVo[] newArray(int r100) {
            return new PopupHybridParamVo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public final void R() {
        this.radius = 0;
    }

    public final void S() {
        this.radiusBottomLeft = 0;
    }

    public final void U() {
        this.radiusBottomRight = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeInt(this.horizontalWidth);
        r100.writeInt(this.horizontalHeight);
        r100.writeInt(this.horizontalHeightPercent);
        r100.writeInt(this.horizontalWidthPercent);
        r100.writeInt(this.margin);
        r100.writeInt(this.radius);
        r100.writeInt(this.horizontalRadius);
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
        r100.writeInt(this.f100537a);
        r100.writeInt(this.f100538b ? 1 : 0);
        r100.writeInt(this.canceledOnTouchOutside ? 1 : 0);
        r100.writeInt(this.heightPercent);
        r100.writeInt(this.widthPercent);
        r100.writeInt(this.rateHeight);
        r100.writeInt(this.enablePullUp ? 1 : 0);
        r100.writeInt(this.upOffsetHeight);
        r100.writeInt(this.upHeightPercent);
        r100.writeInt(this.usePlayerBottomHeight);
        r100.writeString(this.f100539c);
        r100.writeString(this.upStatusBarBgColor);
        r100.writeString(this.f100540d);
        r100.writeString(this.f100541e);
        r100.writeInt(this.needAnimation ? 1 : 0);
        r100.writeInt(this.f100542f ? 1 : 0);
        r100.writeInt(this.f100543g ? 1 : 0);
        r100.writeFloat(this.maskAlpha);
        r100.writeInt(this.f100544h);
        r100.writeInt(this.f100545i ? 1 : 0);
        r100.writeInt(this.upCloseIconPosition);
        LynxHybridParamVo r102 = this.f100546j;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r102.writeToParcel(r100, 0);
    L6:
        BaseHybridParamVo r103 = this.f100547k;
        if (r103 == null) goto L9;
        r100.writeInt(1);
        r103.writeToParcel(r100, 0);
    L10:
        r100.writeInt(this.f100548l ? 1 : 0);
        r100.writeString(this.f100549m);
        return;
    L9:
        r100.writeInt(0);
        goto L10
    L5:
        r100.writeInt(0);
        goto L6
    }

    public final void N() {
        this.gravity = 80;
    }

    public final String toString() {
        return "PopupHybridParamVo(width=" + this.width + ", height=" + this.height + ", horizontalWidth=" + this.horizontalWidth + ", horizontalHeight=" + this.horizontalHeight + ",horizontalHeightPercent=" + this.horizontalHeightPercent + ", horizontalWidthPercent=" + this.horizontalWidthPercent + ", margin=" + this.margin + ", radius=" + this.radius + ", radiusTopLeft=" + this.radiusTopLeft + ", radiusTopRight=" + this.radiusTopRight + ", radiusBottomRight=" + this.radiusBottomRight + ", radiusBottomLeft=" + this.radiusBottomLeft + ", gravity=" + this.gravity + ", useBottomClose=" + this.useBottomClose + ", landScapeCustomHeight=" + this.landScapeCustomHeight + ", landScapeCustomWidth=" + this.landScapeCustomWidth + ", landScapeCustomGravity=" + this.landScapeCustomGravity + ", showDim=" + this.showDim + ", showDimForce=" + this.f100538b + ", drawableBackgroundWidth=" + this.f100537a + ", canceledOnTouchOutside=" + this.canceledOnTouchOutside + ", heightPercent=" + this.heightPercent + ", widthPercent=" + this.widthPercent + ", rateHeight=" + this.rateHeight + ", enablePullUp=" + this.enablePullUp + ", upOffsetHeight=" + this.upOffsetHeight + ", upStatusBarColor=" + this.f100539c + ", upStatusBarBgColor=" + this.upStatusBarBgColor + ", extraData=" + this.f100540d + ", popUpType=" + this.f100541e + ", needAnimation=" + this.needAnimation + ", windowFloating=" + this.f100542f + ", abandonCoordinate=" + this.f100543g + ", maskAlpha=" + this.maskAlpha + ", closeType=" + this.f100544h + ", closeIconPositionRight=" + this.f100545i + ", upCloseIconPosition=" + this.upCloseIconPosition + ", autoShowNavBar=" + this.f100548l + ", upHeightPercent=" + this.upHeightPercent + ", lynxHybridParamVo=" + this.f100546j + ", commonHybridParam=" + this.f100547k + "),showAnimationType=" + this.f100549m;
    }

    public final int D() {
        return this.radiusTopRight;
    }

    public final int E() {
        return this.rateHeight;
    }

    public final boolean F() {
        return this.showDim;
    }

    public final int I() {
        return this.upCloseIconPosition;
    }

    public final int J() {
        return this.upOffsetHeight;
    }

    public final String K() {
        return this.upStatusBarBgColor;
    }

    public final boolean L() {
        return this.useBottomClose;
    }

    public final int M() {
        return this.widthPercent;
    }

    public final int a() {
        return this.gravity;
    }

    public final int b() {
        return this.heightPercent;
    }

    public final int c() {
        return this.horizontalHeight;
    }

    public final int d() {
        return this.horizontalHeightPercent;
    }

    public final int e() {
        return this.horizontalWidth;
    }

    public final int g() {
        return this.horizontalWidthPercent;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean h() {
        return this.landScapeCustomGravity;
    }

    public final boolean i() {
        return this.landScapeCustomHeight;
    }

    public final boolean j() {
        return this.landScapeCustomWidth;
    }

    public final int k() {
        return this.margin;
    }

    public final float o() {
        return this.maskAlpha;
    }

    public final boolean q() {
        return this.needAnimation;
    }

    public final int r() {
        return this.radius;
    }

    public final int s() {
        return this.radiusBottomLeft;
    }

    public final int t() {
        return this.radiusBottomRight;
    }

    public final int z() {
        return this.radiusTopLeft;
    }

    public final void O(boolean r100) {
        this.needAnimation = r100;
    }

    public final void W(int r100) {
        this.radiusTopLeft = r100;
    }

    public final void Y(int r100) {
        this.radiusTopRight = r100;
    }

    public final void Z(int r100) {
        this.usePlayerBottomHeight = r100;
    }

    public final void a0(int r100) {
        this.width = r100;
    }

    public /* synthetic */ PopupHybridParamVo(int r510, int r511, int r512, int r513, int r514, int r515, int r516, int r517, int r518, int r519, int r610, int r611, int r612, int r613, boolean r614, boolean r615, boolean r616, boolean r617, boolean r618, boolean r619, boolean r710, int r711, int r712, int r713, boolean r714, int r715, int r716, String r717, String r718, String r719, boolean r810, boolean r811, boolean r812, float r813, int r814, boolean r815, int r816, LynxHybridParamVo r817, BaseHybridParamVo r818, boolean r819, String r910, int r911, int r912) {
        if ((r911 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r911 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r911 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r911 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r911 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r911 & 32) == 0) goto L25;
        int r110 = 0;
    L27:
        if ((r911 & 64) == 0) goto L29;
        int r111 = 0;
    L31:
        if ((r911 & 128) == 0) goto L33;
        int r112 = 0;
    L35:
        if ((r911 & 256) == 0) goto L37;
        int r113 = -1;
    L39:
        if ((r911 & 512) == 0) goto L41;
        int r114 = 0;
    L43:
        if ((r911 & 1024) == 0) goto L45;
        int r115 = 0;
    L47:
        if ((r911 & 2048) == 0) goto L49;
        int r116 = 0;
    L51:
        if ((r911 & 4096) == 0) goto L53;
        int r117 = 0;
    L55:
        if ((r911 & 8192) == 0) goto L57;
        int r118 = 0;
    L59:
        if ((r911 & 16384) == 0) goto L61;
        boolean r119 = false;
    L63:
        if ((32768 & r911) == 0) goto L65;
        boolean r210 = false;
    L67:
        if ((65536 & r911) == 0) goto L69;
        boolean r211 = false;
    L71:
        if ((131072 & r911) == 0) goto L73;
        boolean r212 = false;
    L75:
        if ((262144 & r911) == 0) goto L77;
        boolean r105 = true;
    L79:
        if ((r911 & 1048576) == 0) goto L81;
        boolean r213 = true;
    L83:
        if ((r911 & 2097152) == 0) goto L85;
        boolean r214 = true;
    L87:
        if ((r911 & 4194304) == 0) goto L89;
        int r215 = 0;
    L91:
        if ((r911 & 8388608) == 0) goto L93;
        int r216 = 0;
    L95:
        if ((r911 & 16777216) == 0) goto L97;
        int r217 = -1;
    L99:
        if ((r911 & 33554432) == 0) goto L101;
        boolean r310 = false;
    L103:
        if ((r911 & 67108864) == 0) goto L105;
        int r311 = -1;
    L107:
        if ((134217728 & r911) == 0) goto L109;
        int r312 = 70;
    L111:
        if ((1073741824 & r911) == 0) goto L113;
        String r313 = null;
    L115:
        if ((r911 & Integer.MIN_VALUE) == 0) goto L117;
        String r106 = null;
    L119:
        if ((r912 & 1) == 0) goto L121;
        String r314 = "";
    L123:
        if ((r912 & 2) == 0) goto L125;
        boolean r315 = true;
    L127:
        if ((r912 & 4) == 0) goto L129;
        boolean r316 = true;
    L131:
        if ((r912 & 8) == 0) goto L133;
        boolean r410 = false;
    L135:
        if ((r912 & 16) == 0) goto L137;
        float r411 = 0.0f;
    L139:
        if ((r912 & 32) == 0) goto L141;
        int r412 = 0;
    L143:
        if ((r912 & 64) == 0) goto L145;
        boolean r413 = false;
    L147:
        if ((r912 & 128) == 0) goto L149;
        int r414 = 0;
    L151:
        if ((r912 & 256) == 0) goto L153;
        LynxHybridParamVo r415 = null;
    L155:
        if ((r912 & 1024) == 0) goto L157;
        boolean r416 = false;
    L159:
        if ((r912 & 2048) == 0) goto L161;
        String r417 = "bottom";
    L162:
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r105, 0, r213, r214, r215, r216, r217, r310, r311, r312, 0, null, r313, r106, r314, r315, r316, r410, r411, r412, r413, r414, r415, r818, r416, r417);
        return;
    L161:
        r417 = r910;
        goto L162
    L157:
        r416 = r819;
        goto L159
    L153:
        r415 = r817;
        goto L155
    L149:
        r414 = r816;
        goto L151
    L145:
        r413 = r815;
        goto L147
    L141:
        r412 = r814;
        goto L143
    L137:
        r411 = r813;
        goto L139
    L133:
        r410 = r812;
        goto L135
    L129:
        r316 = r811;
        goto L131
    L125:
        r315 = r810;
        goto L127
    L121:
        r314 = r719;
        goto L123
    L117:
        r106 = r718;
        goto L119
    L113:
        r313 = r717;
        goto L115
    L109:
        r312 = r716;
        goto L111
    L105:
        r311 = r715;
        goto L107
    L101:
        r310 = r714;
        goto L103
    L97:
        r217 = r713;
        goto L99
    L93:
        r216 = r712;
        goto L95
    L89:
        r215 = r711;
        goto L91
    L85:
        r214 = r710;
        goto L87
    L81:
        r213 = r619;
        goto L83
    L77:
        r105 = r618;
        goto L79
    L73:
        r212 = r617;
        goto L75
    L69:
        r211 = r616;
        goto L71
    L65:
        r210 = r615;
        goto L67
    L61:
        r119 = r614;
        goto L63
    L57:
        r118 = r613;
        goto L59
    L53:
        r117 = r612;
        goto L55
    L49:
        r116 = r611;
        goto L51
    L45:
        r115 = r610;
        goto L47
    L41:
        r114 = r519;
        goto L43
    L37:
        r113 = r518;
        goto L39
    L33:
        r112 = r517;
        goto L35
    L29:
        r111 = r516;
        goto L31
    L25:
        r110 = r515;
        goto L27
    L21:
        r104 = r514;
        goto L23
    L17:
        r103 = r513;
        goto L19
    L13:
        r102 = r512;
        goto L15
    L9:
        r101 = r511;
        goto L11
    L5:
        r100 = r510;
        goto L7
    }

    public PopupHybridParamVo(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r110, int r111, int r112, int r113, int r114, int r115, int r116, boolean r117, boolean r118, boolean r119, boolean r210, boolean r211, int r212, boolean r213, boolean r214, int r215, int r216, int r217, boolean r218, int r219, int r310, int r311, String r312, String r313, String r314, String r315, boolean r316, boolean r317, boolean r318, float r319, int r410, boolean r411, int r412, LynxHybridParamVo r413, BaseHybridParamVo r414, boolean r415, String r416) {
        this.width = r100;
        this.height = r101;
        this.horizontalWidth = r102;
        this.horizontalHeight = r103;
        this.horizontalHeightPercent = r104;
        this.horizontalWidthPercent = r105;
        this.margin = r106;
        this.radius = r110;
        this.horizontalRadius = r111;
        this.radiusTopLeft = r112;
        this.radiusTopRight = r113;
        this.radiusBottomRight = r114;
        this.radiusBottomLeft = r115;
        this.gravity = r116;
        this.useBottomClose = r117;
        this.landScapeCustomHeight = r118;
        this.landScapeCustomWidth = r119;
        this.landScapeCustomGravity = r210;
        this.showDim = r211;
        this.f100537a = r212;
        this.f100538b = r213;
        this.canceledOnTouchOutside = r214;
        this.heightPercent = r215;
        this.widthPercent = r216;
        this.rateHeight = r217;
        this.enablePullUp = r218;
        this.upOffsetHeight = r219;
        this.upHeightPercent = r310;
        this.usePlayerBottomHeight = r311;
        this.f100539c = r312;
        this.upStatusBarBgColor = r313;
        this.f100540d = r314;
        this.f100541e = r315;
        this.needAnimation = r316;
        this.f100542f = r317;
        this.f100543g = r318;
        this.maskAlpha = r319;
        this.f100544h = r410;
        this.f100545i = r411;
        this.upCloseIconPosition = r412;
        this.f100546j = r413;
        this.f100547k = r414;
        this.f100548l = r415;
        this.f100549m = r416;
    }
}
