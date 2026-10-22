package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ListenLiveEventHandler;", "", "handleListenLiveSwitch", "", "listenStatus", "Lcom/bytedance/android/livesdkapi/model/ListenLiveStatus;", "logDuration", "reason", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ListenLiveEventHandler {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void logDuration$default(ListenLiveEventHandler r100, String r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = "";
        L6:
            r100.logDuration(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logDuration");
        }
    }

    void handleListenLiveSwitch(ListenLiveStatus r100);

    void logDuration(String r100);
}
