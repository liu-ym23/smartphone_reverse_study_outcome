package com.bytedance.android.live.profit.privilege.model.touch;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001c\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR*\u0010 \u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/d;", "Lvh7/c;", "", "getStrategy", "()I", "setStrategy", "(I)V", "getStrategy$annotations", "()V", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getLimit", "()Ljava/lang/Long;", "setLimit", "(Ljava/lang/Long;)V", "getLimit$annotations", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getKey$annotations", "key", "getCur", "setCur", "getCur$annotations", "cur", "getDuration", "setDuration", "getDuration$annotations", "duration", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "cur")
    Long getCur();

    @FieldName(name = "duration")
    Long getDuration();

    @FieldName(name = "key")
    String getKey();

    @FieldName(name = VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    Long getLimit();

    @FieldName(name = BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    int getStrategy();

    @FieldName(name = "cur#setter")
    void setCur(Long r100);

    @FieldName(name = "duration#setter")
    void setDuration(Long r100);

    @FieldName(name = "key#setter")
    void setKey(String r100);

    @FieldName(name = "limit#setter")
    void setLimit(Long r100);

    @FieldName(name = "strategy#setter")
    void setStrategy(int r100);
}
