package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface s5 extends vh7.c<s5> {
    public static final int SWITCH_TYPE_SEEK = 1;
    public static final int SWITCH_TYPE_UNKNOWN = 0;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    String getSwitchDisplayText();

    String getSwitchExtra();

    boolean getSwitchOn();

    int getSwitchType();
}
