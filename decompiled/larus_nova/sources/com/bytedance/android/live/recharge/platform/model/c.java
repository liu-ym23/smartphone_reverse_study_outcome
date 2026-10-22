package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0012\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/c;", "Lvh7/c;", "", "Lcom/bytedance/android/live/recharge/platform/model/h;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getSignInfos", "()Ljava/util/List;", "setSignInfos", "(Ljava/util/List;)V", "getSignInfos$annotations", "()V", "signInfos", "", "getRenderDataInfo", "()Ljava/lang/String;", "setRenderDataInfo", "(Ljava/lang/String;)V", "getRenderDataInfo$annotations", "renderDataInfo", "", "getType", "()I", "setType", "(I)V", "getType$annotations", "type", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface c extends vh7.c<c> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "render_data_info")
    String getRenderDataInfo();

    @FieldName(name = "sign_info")
    List<h> getSignInfos();

    @FieldName(name = "type")
    int getType();

    @FieldName(name = "render_data_info#setter")
    void setRenderDataInfo(String r100);

    @FieldName(name = "sign_info#setter")
    void setSignInfos(List<? extends h> r100);

    @FieldName(name = "type#setter")
    void setType(int r100);
}
