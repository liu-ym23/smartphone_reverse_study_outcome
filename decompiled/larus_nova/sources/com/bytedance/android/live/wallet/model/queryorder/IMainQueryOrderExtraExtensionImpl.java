package com.bytedance.android.live.wallet.model.queryorder;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.live.wallet.model.n;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J.\u0010\t\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0012R$\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010&\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001e\u0010)\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0012R\u001c\u0010/\u001a\u00020*8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/android/live/wallet/model/queryorder/IMainQueryOrderExtraExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/wallet/model/queryorder/c;", "Lcom/bytedance/android/live/wallet/model/queryorder/b;", "Lvh7/e;", "asMain", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getSuccessToastMsg", "()Ljava/lang/String;", "successToastMsg", "getCoupon", "setCoupon", "(Ljava/lang/String;)V", AnchorBenefitToast.TYPE_COUPON, "getCouponDescription", "setCouponDescription", "couponDescription", "", "Lcom/bytedance/android/live/wallet/model/n;", "getCouponDetail", "()Ljava/util/List;", "setCouponDetail", "(Ljava/util/List;)V", "couponDetail", "", "getDeductAmount", "()J", "setDeductAmount", "(J)V", "deductAmount", "getRebateAmount", "setRebateAmount", "rebateAmount", "getRebateMessage", "setRebateMessage", "rebateMessage", "", "getStatus", "()I", "setStatus", "(I)V", "status", "base", "<init>", "(Lcom/bytedance/android/live/wallet/model/queryorder/c;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainQueryOrderExtraExtensionImpl extends ModelExtensionBase<c, b> implements b, c {
    private final /* synthetic */ c $$delegate_0;

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public b asMain() {
        return this.$$delegate_0.asMain();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<c>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<c>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public String getCoupon() {
        return this.$$delegate_0.getCoupon();
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public String getCouponDescription() {
        return this.$$delegate_0.getCouponDescription();
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public List<n> getCouponDetail() {
        return this.$$delegate_0.getCouponDetail();
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public long getDeductAmount() {
        return this.$$delegate_0.getDeductAmount();
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public long getRebateAmount() {
        return this.$$delegate_0.getRebateAmount();
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public String getRebateMessage() {
        return this.$$delegate_0.getRebateMessage();
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public int getStatus() {
        return this.$$delegate_0.getStatus();
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public void setCoupon(String r100) {
        this.$$delegate_0.setCoupon(r100);
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public void setCouponDescription(String r100) {
        this.$$delegate_0.setCouponDescription(r100);
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public void setCouponDetail(List<n> r100) {
        this.$$delegate_0.setCouponDetail(r100);
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public void setDeductAmount(long r100) {
        this.$$delegate_0.setDeductAmount(r100);
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public void setRebateAmount(long r100) {
        this.$$delegate_0.setRebateAmount(r100);
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public void setRebateMessage(String r100) {
        this.$$delegate_0.setRebateMessage(r100);
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b, com.bytedance.android.live.wallet.model.queryorder.c
    public void setStatus(int r100) {
        this.$$delegate_0.setStatus(r100);
    }

    @Override // com.bytedance.android.live.wallet.model.queryorder.b
    public String getSuccessToastMsg() {
        return (String) get(10, b.class);
    }

    public IMainQueryOrderExtraExtensionImpl(c r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
