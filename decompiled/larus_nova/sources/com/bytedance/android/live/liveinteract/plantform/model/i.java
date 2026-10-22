package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface i extends vh7.c<i> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "fuzzy_fan_ticket")
    String getFuzzyFanTicket();

    @FieldName(name = "last_7_days_gift_count_text")
    String getLast7DaysGiftCountTxt();

    @FieldName(name = "is_active")
    boolean isIsActive();
}
