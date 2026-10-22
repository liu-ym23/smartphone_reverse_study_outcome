package com.bytedance.android.live.wallet.model.queryorder;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.wallet.model.n;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/wallet/model/queryorder/b;", "Lvh7/e;", "Lcom/bytedance/android/live/wallet/model/queryorder/c;", "", "getSuccessToastMsg", "()Ljava/lang/String;", "getSuccessToastMsg$annotations", "()V", "successToastMsg", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface b extends e<c>, c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ b asMain();

    @Override // com.bytedance.android.live.wallet.model.queryorder.c, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.live.wallet.model.queryorder.c, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    /* synthetic */ String getCoupon();

    /* synthetic */ String getCouponDescription();

    /* synthetic */ List<n> getCouponDetail();

    /* synthetic */ long getDeductAmount();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    /* synthetic */ long getRebateAmount();

    /* synthetic */ String getRebateMessage();

    /* synthetic */ int getStatus();

    @FieldName(name = "success_toast")
    String getSuccessToastMsg();

    /* synthetic */ void setCoupon(String r100);

    /* synthetic */ void setCouponDescription(String r100);

    /* synthetic */ void setCouponDetail(List<n> r100);

    /* synthetic */ void setDeductAmount(long r100);

    /* synthetic */ void setRebateAmount(long r100);

    /* synthetic */ void setRebateMessage(String r100);

    /* synthetic */ void setStatus(int r100);
}
