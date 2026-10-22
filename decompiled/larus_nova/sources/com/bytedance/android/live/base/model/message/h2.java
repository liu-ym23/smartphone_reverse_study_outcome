package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface h2 extends vh7.c<h2> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "current_verify_position")
    int getCurrentVerifyPosition();

    @FieldName(name = "final_position_items")
    List<LinkmicPositionItem> getFinalPositionItems();

    @FieldName(name = "verify_position_items")
    List<i2> getVerifyPositionItems();
}
