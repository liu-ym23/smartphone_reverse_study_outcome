package com.bytedance.android.livesdkapi.feed;

import com.bytedance.android.livesdkapi.depend.model.open.OpenRoom;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH'J6\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IOpenFeedLogger;", "", "logShow", "", "openRoom", "Lcom/bytedance/android/livesdkapi/depend/model/open/OpenRoom;", "enterParams", "Lcom/bytedance/android/livesdkapi/feed/EnterParams;", "extra", "", "", "logWindowDuration", "duration", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOpenFeedLogger {
    @Deprecated(message = "建议使用logShow(openRoom: OpenRoom, enterParams: EnterParams, extra: Map<String, String>?)")
    void logShow(OpenRoom r100);

    void logShow(OpenRoom r100, EnterParams r101, Map<String, String> r102);

    @Deprecated(message = "建议使用logWindowDuration(openRoom: OpenRoom, duration: Long, enterParams: EnterParams, extra:Map<String, String>?)")
    void logWindowDuration(OpenRoom r100, long r101);

    void logWindowDuration(OpenRoom r100, long r101, EnterParams r102, Map<String, String> r103);
}
