package com.bytedance.android.ec.store.repository.vo;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.shopping.store.utils.ListMapNumberHandlerGsonHolder;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b=\u0010>R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R0\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0000\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/h;", "Lcom/bytedance/android/shopping/store/hybridproduct/extension/d;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "iconInfo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "h", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIconInfo", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "textInfo", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "l", "()Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "setTextInfo", "(Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;)V", "Lcom/bytedance/android/ec/store/repository/vo/f;", "countdownInfo", "Lcom/bytedance/android/ec/store/repository/vo/f;", "f", "()Lcom/bytedance/android/ec/store/repository/vo/f;", "setCountdownInfo", "(Lcom/bytedance/android/ec/store/repository/vo/f;)V", "", "<set-?>", "status", "Ljava/lang/String;", ce.f26396k, "()Ljava/lang/String;", "", "notShowCouponStateButton", "Ljava/lang/Boolean;", "getNotShowCouponStateButton", "()Ljava/lang/Boolean;", "p", "(Ljava/lang/Boolean;)V", "selectParams", ce.f26395j, "setSelectParams", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/store/repository/vo/e;", "applyCouponInfo", "Lcom/bytedance/android/ec/store/repository/vo/e;", "e", "()Lcom/bytedance/android/ec/store/repository/vo/e;", "setApplyCouponInfo", "(Lcom/bytedance/android/ec/store/repository/vo/e;)V", "Lcom/bytedance/android/ec/store/repository/vo/g;", "panelInfo", "Lcom/bytedance/android/ec/store/repository/vo/g;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/ec/store/repository/vo/g;", "q", "(Lcom/bytedance/android/ec/store/repository/vo/g;)V", "", "couponMapData", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", "o", "(Ljava/util/Map;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements com.bytedance.android.shopping.store.hybridproduct.extension.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f48458a = null;

    @SerializedName("apply_coupon_info")
    private e applyCouponInfo;

    @SerializedName("countdown_info")
    private f countdownInfo;

    @SerializedName("coupon_map_data")
    private Map<String, h> couponMapData;

    @SerializedName("icon_info")
    private ECUrlModel iconInfo;

    @SerializedName("not_show_coupon_state_btn")
    private Boolean notShowCouponStateButton;

    @SerializedName("panel_info")
    private g panelInfo;

    @SerializedName("select_params")
    private String selectParams;

    @SerializedName("status")
    private String status;

    @SerializedName("text_info")
    private ECTagListDTO textInfo;

    public static final class a {
        public a() {
        }

        public static h a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            int r102 = t0.f45720a;     // Catch: Throwable -> L5
            h r103 = (h) t0.a.f45721a.fromJson(r101, h.class);     // Catch: Throwable -> L5
        L6:
            List<? extends Map<String, ? extends Object>> r104 = null;
            if (r101 != null) goto L10;
            r101 = SliceInitService.DEFAULT_SWITCH;
        L10:
            JSONObject r105 = new JSONObject(r101).optJSONObject("apply_coupon_info");     // Catch: Throwable -> L25
            if (r105 == null) goto L15;
            JSONArray r106 = r105.optJSONArray("apply_resource_params");     // Catch: Throwable -> L25
            if (r106 == null) goto L15;
            String r107 = r106.toString();     // Catch: Throwable -> L25
        L16:
            if (r107 != null) goto L18;
        L21:
            boolean r108 = true;
        L22:
            if (r108 == true) goto L26;
            r104 = (List) ((Gson) ListMapNumberHandlerGsonHolder.f186914b.getValue()).fromJson(r107, ListMapNumberHandlerGsonHolder.f186913a);     // Catch: Throwable -> L25
            goto L26
        L18:
            if (r107.length() == 0) goto L21;
            r108 = false;
        L15:
            r107 = null;
        L26:
            if (r104 == null) goto L30;
            e r109 = r103.e();
            if (r109 == null) goto L30;
            r109.f(r104);
        L30:
            return r103;
        L5:
            r103 = new h();
            goto L6
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 21;
    }

    static {
        f48458a = new a();
    }

    public final void b() {
        this.status = "4";
    }

    public final void c() {
        this.status = "2";
    }

    public final void d() {
        this.status = "3";
    }

    public final boolean m() {
        f r100 = this.countdownInfo;
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100.b() * 1000) > System.currentTimeMillis()) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean n() {
        return Intrinsics.areEqual(this.notShowCouponStateButton, Boolean.TRUE);
    }

    public final boolean r() {
        return Intrinsics.areEqual(this.status, "1");
    }

    public final boolean s() {
        return Intrinsics.areEqual(this.status, "3");
    }

    public h() {
        this.notShowCouponStateButton = Boolean.FALSE;
    }

    public final e e() {
        return this.applyCouponInfo;
    }

    public final f f() {
        return this.countdownInfo;
    }

    public final Map<String, h> g() {
        return this.couponMapData;
    }

    public final ECUrlModel h() {
        return this.iconInfo;
    }

    public final g i() {
        return this.panelInfo;
    }

    public final String j() {
        return this.selectParams;
    }

    public final String k() {
        return this.status;
    }

    public final ECTagListDTO l() {
        return this.textInfo;
    }

    public final void o(Map<String, h> r100) {
        this.couponMapData = r100;
    }

    public final void p(Boolean r100) {
        this.notShowCouponStateButton = r100;
    }

    public final void q(g r100) {
        this.panelInfo = r100;
    }

    public final void t(h r100) {
        Intrinsics.checkNotNullParameter(r100, "couponVO");
        this.iconInfo = r100.iconInfo;
        this.textInfo = r100.textInfo;
        this.countdownInfo = r100.countdownInfo;
        this.status = r100.status;
        this.selectParams = r100.selectParams;
        this.notShowCouponStateButton = r100.notShowCouponStateButton;
        this.applyCouponInfo = r100.applyCouponInfo;
    }
}
