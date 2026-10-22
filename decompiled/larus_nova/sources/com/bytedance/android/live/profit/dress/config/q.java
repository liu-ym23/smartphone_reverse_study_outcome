package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/q;", "Lvh7/c;", "", "getLeadingDecoration", "()Ljava/lang/String;", "getLeadingDecoration$annotations", "()V", "leadingDecoration", "getLaggingDecoration", "getLaggingDecoration$annotations", "laggingDecoration", "getLeadingLastDecoration", "getLeadingLastDecoration$annotations", "leadingLastDecoration", "getLaggingLastDecoration", "getLaggingLastDecoration$annotations", "laggingLastDecoration", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q extends vh7.c<q> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "lagging_decoration_id")
    String getLaggingDecoration();

    @FieldName(name = "lagging_last_decoration_id")
    String getLaggingLastDecoration();

    @FieldName(name = "leading_decoration_id")
    String getLeadingDecoration();

    @FieldName(name = "leading_last_decoration_id")
    String getLeadingLastDecoration();
}
