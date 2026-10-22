package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w2;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/a0;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w2 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.a0>, com.bytedance.android.livesdk.link.model.bridge.a0 {
    @Override // com.bytedance.android.livesdk.link.model.bridge.a0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.a0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "name")
    /* synthetic */ String getName();

    @FieldName(name = "shell_type")
    /* synthetic */ long getType();
}
