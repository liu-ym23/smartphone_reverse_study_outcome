package com.bytedance.android.livesdkapi.livestate;

import com.bytedance.android.live.base.IService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\n\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/livestate/ILiveStateChecker;", "Lcom/bytedance/android/live/base/IService;", "checkAlive", "", "roomId", "", "callback", "Lcom/bytedance/android/livesdkapi/livestate/ILiveStateChecker$Callback;", "", "Lcom/bytedance/android/livesdkapi/livestate/ILiveStateChecker$MultiResultCallback;", "Callback", "MultiResultCallback", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveStateChecker extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/livestate/ILiveStateChecker$Callback;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "onSuccess", "alive", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {
        void onError();

        void onSuccess(boolean r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/livestate/ILiveStateChecker$MultiResultCallback;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "onSuccess", "alive", "", "", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface MultiResultCallback {
        void onError();

        void onSuccess(Map<Long, Boolean> r100);
    }

    void checkAlive(long r100, Callback r101);

    void checkAlive(List<Long> r100, MultiResultCallback r101);
}
