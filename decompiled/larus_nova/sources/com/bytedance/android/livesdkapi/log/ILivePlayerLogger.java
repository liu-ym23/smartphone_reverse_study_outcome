package com.bytedance.android.livesdkapi.log;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSpmLogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVqosLogger;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/ILivePlayerLogger;", "", "appLogger", "Lcom/bytedance/android/livesdkapi/log/ILivePlayerAppLogger;", "exceptionLogger", "Lcom/bytedance/android/livesdkapi/log/ILivePlayerExceptionLogger;", EventVerify.TYPE_LAUNCH, "", "spmLogger", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerSpmLogger;", "traceLogger", "Lcom/bytedance/android/livesdkapi/log/ILivePlayerTraceMonitor;", "vqosLogger", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerVqosLogger;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerLogger {
    ILivePlayerAppLogger appLogger();

    ILivePlayerExceptionLogger exceptionLogger();

    void launch();

    ILivePlayerSpmLogger spmLogger();

    ILivePlayerTraceMonitor traceLogger();

    ILivePlayerVqosLogger vqosLogger();
}
