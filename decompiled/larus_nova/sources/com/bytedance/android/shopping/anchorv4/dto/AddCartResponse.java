package com.bytedance.android.shopping.anchorv4.dto;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR,\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/AddCartResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "cartNumWithBusinessLine", "", "Lcom/bytedance/android/ec/model/sku/CartNumWithBusinessLine;", "getCartNumWithBusinessLine", "()Ljava/util/List;", "setCartNumWithBusinessLine", "(Ljava/util/List;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "schema", "getSchema", "setSchema", "toastBar", "", "", "getToastBar", "()Ljava/util/Map;", "setToastBar", "(Ljava/util/Map;)V", "toastMsg", "getToastMsg", "setToastMsg", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddCartResponse extends CommerceBaseResponse {

    @SerializedName("cart_id")
    private String cartId;

    @SerializedName("cart_num_with_business_line")
    private List<CartNumWithBusinessLine> cartNumWithBusinessLine;

    @SerializedName("count")
    private int count;

    @SerializedName("after_add_jump_url")
    private String schema;

    @SerializedName("toast_bar")
    private Map<String, ? extends Object> toastBar;

    @SerializedName(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
    private String toastMsg;

    public AddCartResponse() {
        this.cartId = "";
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final List<CartNumWithBusinessLine> getCartNumWithBusinessLine() {
        return this.cartNumWithBusinessLine;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Map<String, Object> getToastBar() {
        return this.toastBar;
    }

    public final String getToastMsg() {
        return this.toastMsg;
    }

    public final void setCartId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cartId = r100;
    }

    public final void setCartNumWithBusinessLine(List<CartNumWithBusinessLine> r100) {
        this.cartNumWithBusinessLine = r100;
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setToastBar(Map<String, ? extends Object> r100) {
        this.toastBar = r100;
    }

    public final void setToastMsg(String r100) {
        this.toastMsg = r100;
    }
}
