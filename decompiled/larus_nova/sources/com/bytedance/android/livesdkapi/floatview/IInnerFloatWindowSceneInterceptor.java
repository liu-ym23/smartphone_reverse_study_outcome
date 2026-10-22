package com.bytedance.android.livesdkapi.floatview;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowSceneInterceptor;", "", "canShow", "", "showFloat", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "floatWindowConfig", "Lcom/bytedance/android/livesdkapi/floatview/FloatWindowConfig;", "tag", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInnerFloatWindowSceneInterceptor {
    boolean canShow();

    void showFloat(IRoom r100, FloatWindowConfig r101);

    String tag();
}
