package com.bytedance.android.livesdkapi.test;

import com.bytedance.android.live.base.IService;
import java.util.Set;
import kotlin.Metadata;
import vlc.b;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H&J\u001b\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/test/ILiveTestService;", "Lcom/bytedance/android/live/base/IService;", "", "id", "Lcom/bytedance/android/livesdkapi/test/TestActionHandler;", "getTestActionHandler", "", "getTestActionIds", "Lvlc/b;", "getMsgInterceptor", "getLiveRoomId", "", "port", "", "setTestPort", "(Ljava/lang/Integer;)V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveTestService extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void setTestPort$default(ILiveTestService r100, Integer r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            r100.setTestPort(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTestPort");
        }
    }

    String getLiveRoomId();

    b getMsgInterceptor();

    TestActionHandler getTestActionHandler(String r100);

    Set<String> getTestActionIds();

    void setTestPort(Integer r100);
}
