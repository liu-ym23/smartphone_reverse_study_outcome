package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRB\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/p;", "Lvh7/c;", "Lcom/bytedance/android/live/profit/privilege/model/touch/r;", "getMeta", "()Lcom/bytedance/android/live/profit/privilege/model/touch/r;", "setMeta", "(Lcom/bytedance/android/live/profit/privilege/model/touch/r;)V", "getMeta$annotations", "()V", "meta", "Lcom/bytedance/android/live/profit/privilege/model/touch/q;", "getDetail", "()Lcom/bytedance/android/live/profit/privilege/model/touch/q;", "setDetail", "(Lcom/bytedance/android/live/profit/privilege/model/touch/q;)V", "getDetail$annotations", "detail", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getBizExtra", "()Ljava/util/Map;", "setBizExtra", "(Ljava/util/Map;)V", "getBizExtra$annotations", "bizExtra", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p extends vh7.c<p> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "biz_extra")
    Map<String, String> getBizExtra();

    @FieldName(name = "detail")
    q getDetail();

    @FieldName(name = "meta")
    r getMeta();

    @FieldName(name = "biz_extra#setter")
    void setBizExtra(Map<String, String> r100);

    @FieldName(name = "detail#setter")
    void setDetail(q r100);

    @FieldName(name = "meta#setter")
    void setMeta(r r100);
}
