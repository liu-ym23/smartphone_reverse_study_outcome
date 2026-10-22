package com.bytedance.android.live.recharge;

import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R&\u0010\n\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R&\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/recharge/l;", "Lvh7/c;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getDiamond", "()J", "setDiamond", "(J)V", "getDiamond$annotations", "()V", DyVerifyReqConstants.Value.DIAMOND, "getMoney", "setMoney", "getMoney$annotations", "money", "liverecharge-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l extends vh7.c<l> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = DyVerifyReqConstants.Value.DIAMOND)
    long getDiamond();

    @FieldName(name = "money")
    long getMoney();

    @FieldName(name = "diamond#setter")
    void setDiamond(long r100);

    @FieldName(name = "money#setter")
    void setMoney(long r100);
}
