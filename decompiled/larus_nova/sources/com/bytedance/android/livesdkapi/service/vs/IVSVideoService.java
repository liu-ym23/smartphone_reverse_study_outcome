package com.bytedance.android.livesdkapi.service.vs;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.vs.cache.VSVideoServiceImp")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH&J*\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/vs/IVSVideoService;", "Lcom/bytedance/android/live/base/IService;", "deleteCache", "", "videoId", "", "enablePreviewPortraitFullScreen", "", "()Ljava/lang/Boolean;", "getCachedVideoId", "episodeId", "", "getLocalVideoPath", "", "Lkotlin/Pair;", "isLocalVideoVertical", "(Ljava/lang/String;)Ljava/lang/Boolean;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSVideoService extends IService {
    void deleteCache(String r100);

    Boolean enablePreviewPortraitFullScreen();

    String getCachedVideoId(long r100);

    Map<String, Pair<String, String>> getLocalVideoPath(String r100);

    Boolean isLocalVideoVertical(String r100);
}
