package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.floatview.FloatWindowConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IMiddlewareInnerLiveFloatWindowService;", "Lcom/bytedance/android/live/base/IService;", "floatWindowIsShowing", "", "showLiveSteamFloatWindow", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "floatWindowConfig", "Lcom/bytedance/android/livesdkapi/floatview/FloatWindowConfig;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareInnerLiveFloatWindowService extends IService {
    boolean floatWindowIsShowing();

    void showLiveSteamFloatWindow(IRoom r100, FloatWindowConfig r101);
}
