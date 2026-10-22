package com.bytedance.android.livesdkapi.ai.callback;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/ai/callback/IAiCallback;", "", LynxVideoManagerLite.EVENT_ON_PLAY_COMPLETED, "", "result", "Lorg/json/JSONObject;", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAiCallback {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void onCompleted$default(IAiCallback r100, JSONObject r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.onCompleted(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCompleted");
        }
    }

    void onCompleted(JSONObject r100);
}
