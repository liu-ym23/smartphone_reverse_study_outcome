package com.bytedance.android.livesdkapi.business;

import com.bytedance.android.live.base.IService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/business/IHsLiveAdMocService;", "Lcom/bytedance/android/live/base/IService;", "logEvent", "", "isV1", "", "event", "", "label", "extra", "", "DEFAULT", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHsLiveAdMocService extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/business/IHsLiveAdMocService$DEFAULT;", "Lcom/bytedance/android/livesdkapi/business/IHsLiveAdMocService;", "()V", "logEvent", "", "isV1", "", "event", "", "label", "extra", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DEFAULT implements IHsLiveAdMocService {
        public DEFAULT() {
        }

        @Override // com.bytedance.android.livesdkapi.business.IHsLiveAdMocService
        public void logEvent(boolean r100, String r101, String r102, Map<String, String> r103) {
            Intrinsics.checkNotNullParameter(r101, "event");
            Intrinsics.checkNotNullParameter(r102, "label");
            Intrinsics.checkNotNullParameter(r103, "extra");
        }
    }

    void logEvent(boolean r100, String r101, String r102, Map<String, String> r103);
}
