package com.bytedance.android.livesdkapi.roomplayer;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Deprecated(message = "不要使用！ 获取播放器能力请使用[LivePlayer]")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H'J6\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u0010H'J\u0014\u0010\u0017\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClientPool;", "Lcom/bytedance/android/live/base/IService;", "createClient", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "roomId", "", "type", "Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientType;", "scene", "Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientScene;", "createPlayerView", "Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "useScene", "destroyClient", "", "client", "getClient", "anchorId", "pseudoLiving", "firstShow", "preview", "isPlaying", "live-ttliveplayer-api_release"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerClientPool extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean isPlaying$default(ILivePlayerClientPool r100, PlayerClientScene r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.isPlaying(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isPlaying");
        }

        public static /* synthetic */ ILivePlayerClient createClient$default(ILivePlayerClientPool r100, long r101, PlayerClientType r102, PlayerClientScene r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = PlayerClientType.NORMAL;
        L7:
            if ((r104 & 4) == 0) goto L10;
            r103 = PlayerClientScene.PREVIEW;
        L10:
            return r100.createClient(r101, r102, r103);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createClient");
        }

        public static /* synthetic */ AbsLivePlayerView createPlayerView$default(ILivePlayerClientPool r100, Context r101, long r102, PlayerClientType r110, PlayerClientScene r111, int r112, Object r113) {
            if (r113 != null) goto L12;
            if ((r112 & 4) == 0) goto L6;
            r110 = PlayerClientType.NORMAL;
        L6:
            PlayerClientType r103 = r110;
            if ((r112 & 8) == 0) goto L10;
            r111 = PlayerClientScene.PREVIEW;
        L10:
            return r100.createPlayerView(r101, r102, r103, r111);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPlayerView");
        }

        public static /* synthetic */ ILivePlayerClient getClient$default(ILivePlayerClientPool r110, long r111, long r112, boolean r113, boolean r114, boolean r115, int r116, Object r117) {
            if (r117 != null) goto L18;
            if ((r116 & 4) == 0) goto L6;
            boolean r100 = false;
        L8:
            if ((r116 & 8) == 0) goto L10;
            boolean r101 = false;
        L12:
            if ((r116 & 16) == 0) goto L14;
            boolean r102 = true;
        L16:
            return r110.getClient(r111, r112, r100, r101, r102);
        L14:
            r102 = r115;
            goto L16
        L10:
            r101 = r114;
            goto L12
        L6:
            r100 = r113;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClient");
        }
    }

    ILivePlayerClient createClient(long r100, PlayerClientType r101, PlayerClientScene r102);

    AbsLivePlayerView createPlayerView(Context r100, long r101, PlayerClientType r102, PlayerClientScene r103);

    boolean destroyClient(ILivePlayerClient r100);

    @Deprecated(message = "")
    ILivePlayerClient getClient(long r100);

    @Deprecated(message = "")
    ILivePlayerClient getClient(long r100, long r101);

    @Deprecated(message = "")
    ILivePlayerClient getClient(long r100, long r101, boolean r102, boolean r103, boolean r104);

    ILivePlayerClient getClient(long r100, PlayerClientScene r101);

    boolean isPlaying(PlayerClientScene r100);
}
