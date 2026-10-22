package com.bytedance.android.ec.model.response;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR*\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/bytedance/android/ec/model/response/r;", "Lcom/bytedance/android/ec/model/g;", "Lcom/bytedance/android/ec/model/response/e;", "cartCustomConfig", "Lcom/bytedance/android/ec/model/response/e;", "b", "()Lcom/bytedance/android/ec/model/response/e;", "f", "(Lcom/bytedance/android/ec/model/response/e;)V", "Lcom/bytedance/android/ec/model/response/a;", "autoApplyCoupon", "Lcom/bytedance/android/ec/model/response/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/a;", "setAutoApplyCoupon", "(Lcom/bytedance/android/ec/model/response/a;)V", "Lcom/bytedance/android/ec/model/response/n1;", "roomInfo", "Lcom/bytedance/android/ec/model/response/n1;", "d", "()Lcom/bytedance/android/ec/model/response/n1;", "setRoomInfo", "(Lcom/bytedance/android/ec/model/response/n1;)V", "", "replaceRelatedInfo", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setReplaceRelatedInfo", "(Ljava/lang/String;)V", "Lsl/p;", "redirectData", "Lsl/p;", "getRedirectData", "()Lsl/p;", "setRedirectData", "(Lsl/p;)V", "routeRule", "e", "setRouteRule", "", "Lcom/bytedance/android/ec/model/response/j0;", SlcCommonAction.KEY_ACTIONS, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class r extends com.bytedance.android.ec.model.g {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private List<? extends j0> actions;

    @SerializedName("auto_apply_coupon")
    private a autoApplyCoupon;

    @SerializedName("cart_custom_config_v2")
    private e cartCustomConfig;

    @SerializedName("redirect_data")
    private sl.p redirectData;

    @SerializedName("replace_related_info")
    private String replaceRelatedInfo;

    @SerializedName("room_info")
    private n1 roomInfo;

    @SerializedName("route_rule")
    private String routeRule;

    public r() {
    }

    public final a a() {
        return this.autoApplyCoupon;
    }

    public final e b() {
        return this.cartCustomConfig;
    }

    public final String c() {
        return this.replaceRelatedInfo;
    }

    public final n1 d() {
        return this.roomInfo;
    }

    public final String e() {
        return this.routeRule;
    }

    public final List<j0> getActions() {
        return this.actions;
    }

    public final void f(e r100) {
        this.cartCustomConfig = r100;
    }
}
