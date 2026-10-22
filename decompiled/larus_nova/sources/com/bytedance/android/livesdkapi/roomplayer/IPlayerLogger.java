package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger;
import com.bytedance.android.livesdkapi.log.ILivePlayerLoggerAssembler;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J.\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerLogger;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerSpmLogger;", "appLog", "Lcom/bytedance/android/livesdkapi/log/ILivePlayerAppLogger;", "feedbackException", "", a.KEY_EXCEPTION, "", "exceptionReason", "exceptionExtraParams", "", "logAssembler", "Lcom/bytedance/android/livesdkapi/log/ILivePlayerLoggerAssembler;", "logException", "exceptionName", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlayerLogger extends ILivePlayerSpmLogger {
    ILivePlayerAppLogger appLog();

    void feedbackException(String r100, String r101, Map<String, String> r102);

    ILivePlayerLoggerAssembler logAssembler();

    void logException(String r100, String r101, Map<String, String> r102);
}
