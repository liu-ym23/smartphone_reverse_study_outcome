package com.bytedance.android.livesdkapi.depend.event;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/event/PosterPreviewShowEvent;", "", "()V", "extraLog", "", "", "getExtraLog", "()Ljava/util/Map;", "setExtraLog", "(Ljava/util/Map;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PosterPreviewShowEvent {
    private Map<String, String> extraLog;

    public PosterPreviewShowEvent() {
    }

    public final Map<String, String> getExtraLog() {
        return this.extraLog;
    }

    public final void setExtraLog(Map<String, String> r100) {
        this.extraLog = r100;
    }
}
