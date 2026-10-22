package com.bytedance.android.livesdkapi.service.gamecp;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J&\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/gamecp/ILiveMiniGamePlayService;", "", "closeMiniGamePlayGame", "", "schema", "", "isMiniGamePlayRunning", "", "appId", "openMiniGamePlayGame", "startParmaMap", "", "preloadMiniGamePlayGame", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMiniGamePlayService {
    void closeMiniGamePlayGame(String r100);

    boolean isMiniGamePlayRunning(String r100);

    void openMiniGamePlayGame(String r100, Map<String, ? extends Object> r101);

    void preloadMiniGamePlayGame(String r100);
}
