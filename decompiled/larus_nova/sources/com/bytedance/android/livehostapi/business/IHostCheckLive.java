package com.bytedance.android.livehostapi.business;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.model.CheckLiveParams;
import com.ss.ugc.live.sdk.platform.bytelink.data.idl.TenantPublishers;
import com.ss.ugc.live.sdk.platform.bytelink.e;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\b\u0010\r\u001a\u00020\bH&J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0013H&J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0016H&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostCheckLive;", "Lcom/bytedance/android/live/base/IService;", "", "scene", "Lcom/ss/ugc/live/sdk/platform/bytelink/data/idl/TenantPublishers;", "publishers", "Lcom/ss/ugc/live/sdk/platform/bytelink/e;", "callback", "", "registerPublisher", "triggerReason", "", "Lcom/bytedance/android/livesdkapi/model/CheckLiveParams;", "unregisterPublisher", "Lcom/bytedance/android/livehostapi/business/ICheckLiveListener;", "listener", "addMessageListener", "removeMessageListener", "anchorId", "Lcom/bytedance/android/livehostapi/business/IRoomFeatureListener;", "addRoomFeatureMessageListener", "removeRoomFeatureMessageListener", "Lcom/bytedance/android/livehostapi/business/IHighValueListener;", "addHighValueMessageListener", "removeHighValueMessageListener", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostCheckLive extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostCheckLive$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void registerPublisher$default(IHostCheckLive r100, String r101, TenantPublishers r102, e r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.registerPublisher(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerPublisher");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void registerPublisher$default(IHostCheckLive r100, String r101, TenantPublishers r102, e r103, int r104, Object r105) {
            CC.registerPublisher$default(r100, r101, r102, r103, r104, r105);
        }
    }

    void addHighValueMessageListener(String r100, IHighValueListener r101);

    void addMessageListener(String r100, ICheckLiveListener r101);

    void addRoomFeatureMessageListener(String r100, String r101, IRoomFeatureListener r102);

    void registerPublisher(String r100, TenantPublishers r101, e r102);

    void registerPublisher(String r100, String r101, List<CheckLiveParams> r102);

    void removeHighValueMessageListener(String r100);

    void removeMessageListener(String r100);

    void removeRoomFeatureMessageListener(String r100);

    void unregisterPublisher();
}
