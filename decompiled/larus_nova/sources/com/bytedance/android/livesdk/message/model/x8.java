package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface x8 extends vh7.c<x8> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    List<String> getUserIdString();
}
