package com.bytedance.android.livesdkapi.ai;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.ai.callback.IAiCallback;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/ai/IAiOuterService;", "Lcom/bytedance/android/live/base/IService;", "predict", "", "businessName", "", "params", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/android/livesdkapi/ai/callback/IAiCallback;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAiOuterService extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean predict$default(IAiOuterService r100, String r101, JSONObject r102, IAiCallback r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.predict(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: predict");
        }
    }

    boolean predict(String r100, JSONObject r101, IAiCallback r102);
}
