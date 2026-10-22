package com.bytedance.android.live.revlink.impl.lynxcontainer;

import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u001a\u0010\u0019\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001a\u0010\u001b\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u001a\u0010!\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR\u001a\u0010#\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR\u001a\u0010%\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014R\u001a\u0010)\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014R\u001a\u0010+\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014R*\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00020-j\b\u0012\u0004\u0012\u00020\u0002`.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R*\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00020-j\b\u0012\u0004\u0012\u00020\u0002`.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R\u001a\u00105\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r¨\u00069"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/lynxcontainer/b;", "", "", "lynxUrl", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "tag", "o", "", "width", "I", "q", "()I", "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "widthRadio", FaceService.girlLabel, "r", "()F", "heightRadio", "b", "horizontalGravity", "c", "verticalGravity", "p", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "s", "marginLeft", "h", "marginRight", ce.f26395j, "marginTop", "l", "marginBottom", "f", "marginLeftRadio", RXScreenCaptureService.KEY_INDEX, "marginRightRadio", ce.f26396k, "marginTopRadio", "m", "marginBottomRadio", ce.f26391f, "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableList;", "observerDataset", "Ljava/util/List;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/util/List;", "initData", "d", "superView", "getSuperView", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("height")
    private final int height;

    @SerializedName("height_radio")
    private final float heightRadio;

    @SerializedName("horizontal_align")
    private final int horizontalGravity;

    @SerializedName("init_data")
    private final List<String> initData;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName("margin_bottom")
    private final int marginBottom;

    @SerializedName("margin_bottom_radio")
    private final float marginBottomRadio;

    @SerializedName("margin_left")
    private final int marginLeft;

    @SerializedName("margin_left_radio")
    private final float marginLeftRadio;

    @SerializedName("margin_right")
    private final int marginRight;

    @SerializedName("margin_right_radio")
    private final float marginRightRadio;

    @SerializedName("margin_top")
    private final int marginTop;

    @SerializedName("margin_top_radio")
    private final float marginTopRadio;

    @SerializedName("observer")
    private final List<String> observerDataset;

    @SerializedName("super_view")
    private final int superView;

    @SerializedName("tag")
    private final String tag;

    @SerializedName("vertical_align")
    private final int verticalGravity;

    @SerializedName("width")
    private final int width;

    @SerializedName("width_radio")
    private final float widthRadio;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
    private final int f92671z;

    public b() {
        this.lynxUrl = "";
        this.tag = "";
        this.observerDataset = new ArrayList();
        this.initData = new ArrayList();
    }

    public final int a() {
        return this.height;
    }

    public final float b() {
        return this.heightRadio;
    }

    public final int c() {
        return this.horizontalGravity;
    }

    public final List<String> d() {
        return this.initData;
    }

    public final String e() {
        return this.lynxUrl;
    }

    public final int f() {
        return this.marginBottom;
    }

    public final float g() {
        return this.marginBottomRadio;
    }

    public final int h() {
        return this.marginLeft;
    }

    public final float i() {
        return this.marginLeftRadio;
    }

    public final int j() {
        return this.marginRight;
    }

    public final float k() {
        return this.marginRightRadio;
    }

    public final int l() {
        return this.marginTop;
    }

    public final float m() {
        return this.marginTopRadio;
    }

    public final List<String> n() {
        return this.observerDataset;
    }

    public final String o() {
        return this.tag;
    }

    public final int p() {
        return this.verticalGravity;
    }

    public final int q() {
        return this.width;
    }

    public final float r() {
        return this.widthRadio;
    }

    public final int s() {
        return this.f92671z;
    }
}
