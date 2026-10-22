package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/j;", "Lvh7/c;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getMPlayerInfo", "()Ljava/util/List;", "mPlayerInfo", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j extends vh7.c<j> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "user")
    List<ILinkPlayerInfoBridge> getMPlayerInfo();
}
