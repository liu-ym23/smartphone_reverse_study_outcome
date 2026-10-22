package com.bytedance.android.ec.model.order;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/model/order/ProductPurchaseInfo;", "Ljava/io/Serializable;", "isUserJoinActivity", "", "promotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "newSourceType", "", "appointCb", "Lkotlin/Function1;", "", "clickDepositPresaleAppointCb", "Lkotlin/Function0;", "depositPresaleAppointSuccessCb", "skuRestoreState", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "saveSkuRestoreState", "passThroughEventData", "(ZLcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/bytedance/android/ec/model/sku/SkuRestoreState;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getAppointCb", "()Lkotlin/jvm/functions/Function1;", "getClickDepositPresaleAppointCb", "()Lkotlin/jvm/functions/Function0;", "getDepositPresaleAppointSuccessCb", "()Z", "getNewSourceType", "()Ljava/lang/String;", "getPassThroughEventData", "getPromotion", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getSaveSkuRestoreState", "getSkuRestoreState", "()Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductPurchaseInfo implements Serializable {
    private final Function1<Boolean, Unit> appointCb;
    private final Function0<Unit> clickDepositPresaleAppointCb;
    private final Function0<Unit> depositPresaleAppointSuccessCb;
    private final boolean isUserJoinActivity;
    private final String newSourceType;
    private final String passThroughEventData;
    private final PromotionProductStruct promotion;
    private final Function1<SkuRestoreState, Unit> saveSkuRestoreState;
    private final SkuRestoreState skuRestoreState;

    public final Function1<Boolean, Unit> getAppointCb() {
        return this.appointCb;
    }

    public final Function0<Unit> getClickDepositPresaleAppointCb() {
        return this.clickDepositPresaleAppointCb;
    }

    public final Function0<Unit> getDepositPresaleAppointSuccessCb() {
        return this.depositPresaleAppointSuccessCb;
    }

    public final String getNewSourceType() {
        return this.newSourceType;
    }

    public final String getPassThroughEventData() {
        return this.passThroughEventData;
    }

    public final PromotionProductStruct getPromotion() {
        return this.promotion;
    }

    public final Function1<SkuRestoreState, Unit> getSaveSkuRestoreState() {
        return this.saveSkuRestoreState;
    }

    public final SkuRestoreState getSkuRestoreState() {
        return this.skuRestoreState;
    }

    public final boolean isUserJoinActivity() {
        return this.isUserJoinActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProductPurchaseInfo(boolean r100, PromotionProductStruct r101, String r102, Function1<? super Boolean, Unit> r103, Function0<Unit> r104, Function0<Unit> r105, SkuRestoreState r106, Function1<? super SkuRestoreState, Unit> r107, String r108) {
        this.isUserJoinActivity = r100;
        this.promotion = r101;
        this.newSourceType = r102;
        this.appointCb = r103;
        this.clickDepositPresaleAppointCb = r104;
        this.depositPresaleAppointSuccessCb = r105;
        this.skuRestoreState = r106;
        this.saveSkuRestoreState = r107;
        this.passThroughEventData = r108;
    }

    public /* synthetic */ ProductPurchaseInfo(boolean r110, PromotionProductStruct r111, String r112, Function1 r113, Function0 r114, Function0 r115, SkuRestoreState r116, Function1 r210, String r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r212 & 4) == 0) goto L9;
        String r101 = a.VALUE_PRODUCT_DETAIL;
    L11:
        if ((r212 & 8) == 0) goto L13;
        Function1 r102 = null;
    L15:
        if ((r212 & 16) == 0) goto L17;
        Function0 r103 = null;
    L19:
        if ((r212 & 32) == 0) goto L21;
        Function0 r104 = null;
    L23:
        if ((r212 & 64) == 0) goto L25;
        SkuRestoreState r105 = null;
    L27:
        if ((r212 & 128) == 0) goto L29;
        Function1 r117 = null;
    L31:
        if ((r212 & 256) == 0) goto L33;
        String r118 = null;
    L34:
        this(r100, r111, r101, r102, r103, r104, r105, r117, r118);
        return;
    L33:
        r118 = r211;
        goto L34
    L29:
        r117 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
