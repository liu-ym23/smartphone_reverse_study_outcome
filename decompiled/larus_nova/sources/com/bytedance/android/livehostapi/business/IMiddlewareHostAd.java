package com.bytedance.android.livehostapi.business;

import com.bytedance.android.live.base.IService;
import is2.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostAd;", "Lcom/bytedance/android/live/base/IService;", "", "Lis2/b;", "getRoomBackendHandlers", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareHostAd extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IMiddlewareHostAd$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$getRoomBackendHandlers(IMiddlewareHostAd r100) {
            return CollectionsKt.emptyList();
        }

        public static /* synthetic */ List access$getRoomBackendHandlers$jd(IMiddlewareHostAd r100) {
            return $default$getRoomBackendHandlers(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static List<b> getRoomBackendHandlers(IMiddlewareHostAd r100) {
            return CC.access$getRoomBackendHandlers$jd(r100);
        }
    }

    List<b> getRoomBackendHandlers();
}
