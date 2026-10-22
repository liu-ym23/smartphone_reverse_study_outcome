package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.GroupLiveService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000bH&J\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000bH&J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IAnswerQuestionService;", "Lcom/bytedance/android/live/base/IService;", "answerWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getAnswerWidget", "()Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "setAnswerWidget", "(Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;)V", "dismissAnswerQuestionContainer", "", "getAnswerQuestionServiceWidget", "Ljava/lang/Class;", "getPreviewAnswerQuestionServiceWidget", "showAnswerQuestionContainer", "schema", "", "initData", "Lcom/google/gson/JsonObject;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAnswerQuestionService extends IService {
    boolean dismissAnswerQuestionContainer();

    Class<? extends LiveRecyclableWidget> getAnswerQuestionServiceWidget();

    LiveRecyclableWidget getAnswerWidget();

    Class<? extends LiveRecyclableWidget> getPreviewAnswerQuestionServiceWidget();

    void setAnswerWidget(LiveRecyclableWidget r100);

    boolean showAnswerQuestionContainer(String r100, JsonObject r101);
}
