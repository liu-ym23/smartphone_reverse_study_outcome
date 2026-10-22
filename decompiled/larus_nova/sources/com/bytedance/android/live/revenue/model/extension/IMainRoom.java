package com.bytedance.android.live.revenue.model.extension;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.revenue.model.extension.main.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import iy0.a;
import iy0.b;
import java.util.Map;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes47.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/IMainRoom;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMainRoom extends e<IRoom>, IRoom {
    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    /* synthetic */ Map<String, String> getAnchorAbMap();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomEx
    /* synthetic */ b getGameData();

    /* synthetic */ c getMainOthers();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomEx
    /* synthetic */ a getOfficialChannelInfo();

    /* synthetic */ long getWebcastSdkVersion();
}
