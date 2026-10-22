package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.chatroom.ui.i8;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/IResolutionInfoService;", "Lcom/bytedance/android/live/base/IService;", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IResolutionInfoService extends IService {
    LiveMode K1();

    i8 L3();

    List<RoomCreateInfo.p.a> f5();

    String w0();
}
