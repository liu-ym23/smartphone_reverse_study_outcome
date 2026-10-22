package com.bytedance.android.livesdkapi.service.dummy;

import com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService;
import com.bytedance.android.livesdkapi.service.vs.IVSVideoService;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/dummy/VSVideoServiceDummy;", "Lcom/bytedance/android/livesdkapi/service/vs/IVSVideoService;", "()V", "deleteCache", "", "videoId", "", "enablePreviewPortraitFullScreen", "", "()Ljava/lang/Boolean;", "getCachedVideoId", "episodeId", "", "getLocalVideoPath", "", "Lkotlin/Pair;", "isLocalVideoVertical", "(Ljava/lang/String;)Ljava/lang/Boolean;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSVideoServiceDummy implements IVSVideoService {
    @Override // com.bytedance.android.livesdkapi.service.vs.IVSVideoService
    public void deleteCache(String r100) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSVideoService
    public Boolean enablePreviewPortraitFullScreen() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSVideoService
    public String getCachedVideoId(long r100) {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSVideoService
    public Map<String, Pair<String, String>> getLocalVideoPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSVideoService
    public Boolean isLocalVideoVertical(String r100) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        return null;
    }

    public VSVideoServiceDummy() {
        k.l(IVSVideoService.class, this);
        k.l(IVSHistoryProgressService.class, new VSHistoryProgressServiceDummy());
    }
}
