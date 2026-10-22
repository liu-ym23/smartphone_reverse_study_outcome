package com.bytedance.android.live.wallet.model.queryorder;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.live.wallet.model.n;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001c\u0010%\u001a\u00020 8&@&X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/wallet/model/queryorder/c;", "Lvh7/c;", "Lcom/bytedance/android/live/wallet/model/queryorder/b;", "asMain", "", "getCoupon", "()Ljava/lang/String;", "setCoupon", "(Ljava/lang/String;)V", AnchorBenefitToast.TYPE_COUPON, "getCouponDescription", "setCouponDescription", "couponDescription", "", "Lcom/bytedance/android/live/wallet/model/n;", "getCouponDetail", "()Ljava/util/List;", "setCouponDetail", "(Ljava/util/List;)V", "couponDetail", "", "getRebateAmount", "()J", "setRebateAmount", "(J)V", "rebateAmount", "getDeductAmount", "setDeductAmount", "deductAmount", "getRebateMessage", "setRebateMessage", "rebateMessage", "", "getStatus", "()I", "setStatus", "(I)V", "status", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.c<c> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    b asMain();

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    String getCoupon();

    String getCouponDescription();

    List<n> getCouponDetail();

    long getDeductAmount();

    long getRebateAmount();

    String getRebateMessage();

    int getStatus();

    void setCoupon(String r100);

    void setCouponDescription(String r100);

    void setCouponDetail(List<n> r100);

    void setDeductAmount(long r100);

    void setRebateAmount(long r100);

    void setRebateMessage(String r100);

    void setStatus(int r100);
}
