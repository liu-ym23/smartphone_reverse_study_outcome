package com.bytedance.android.live.revenue.model.extension.main;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/main/IMainRoomLinkExt;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "", "", "getAnchorAbMap", "()Ljava/util/Map;", "getAnchorAbMap$annotations", "()V", "anchorAbMap", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IMainRoomLinkExt extends e<IRoom>, IRoom {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "AnchorABMap")
    Map<String, String> getAnchorAbMap();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();
}
