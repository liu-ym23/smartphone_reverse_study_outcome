package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/k;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.e<IAnchorGameRoleBridge>, IAnchorGameRoleBridge {
    @Override // com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "content")
    /* synthetic */ String getContent();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "role")
    /* synthetic */ Integer getRole();

    @FieldName(name = "content#setter")
    /* synthetic */ void setContent(String r100);

    @FieldName(name = "role#setter")
    /* synthetic */ void setRole(Integer r100);
}
