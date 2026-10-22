package com.bytedance.android.livesdkapi.feed.manager;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.Metadata;
import md0.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001fJ8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0015\u001a\u00020\u000eH&J\b\u0010\u0016\u001a\u00020\u000eH&J\b\u0010\u0018\u001a\u00020\u0017H&R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/manager/IInteractFeedViewManager;", "Lmd0/a$a;", "Lmd0/a$c;", "Lmd0/a$b;", "Lcom/bytedance/android/livesdkapi/feed/manager/ISingleBroadcastPreviewKtvComponent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "", "isLiveAlive", "", "enterFromMerge", "enterMethod", "Ljava/lang/Runnable;", "bindCallback", "", "bind", "Lcom/bytedance/android/livesdkapi/model/SeiAppData;", "seiAppData", "updateSceneByVer", "sei", "parseSeiData", "onOnlineListChangeBySei", LiveCommonConstants.REASON_ON_DEDTROY, "", "getSeiVersion", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "getMLivePlayerView", "()Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "setMLivePlayerView", "(Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;)V", "mLivePlayerView", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractFeedViewManager extends a.InterfaceC6802a, a.c, a.b, ISingleBroadcastPreviewKtvComponent {
    public static final Companion Companion = null;
    public static final int FEED_FULL_SCREEN = 3;

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.feed.manager.IInteractFeedViewManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ void $default$onBusinessAppSeiUpdate(IInteractFeedViewManager r100, JSONObject r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onSpeechRhythm(IInteractFeedViewManager r100, String r101) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/manager/IInteractFeedViewManager$Companion;", "", "()V", "FEED_FULL_SCREEN", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int FEED_FULL_SCREEN = 3;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void bind$default(IInteractFeedViewManager r100, IRoom r101, boolean r102, String r103, String r110, Runnable r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 16) == 0) goto L6;
            r111 = null;
        L6:
            r100.bind(r101, r102, r103, r110, r111);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void bind(IRoom r100, boolean r101, String r102, String r103, Runnable r104);

    LivePlayerView getMLivePlayerView();

    int getSeiVersion();

    @Override // md0.a.InterfaceC6802a
    /* synthetic */ boolean isVersionSupported(int r100, int r101);

    /* synthetic */ void onAudioMvControllerUpdate(String r100);

    /* synthetic */ void onAudioSubtitleUpdate(String r100);

    @Override // md0.a.InterfaceC6802a
    /* bridge */ /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r100);

    void onDestroy();

    /* synthetic */ void onKtvSeiUpdate(String r100);

    void onOnlineListChangeBySei();

    /* synthetic */ void onRadioSeiUpdate(JSONObject r100);

    /* synthetic */ void onRadioTextSeiUpdate(JSONObject r100);

    @Override // md0.a.InterfaceC6802a
    /* synthetic */ void onSeiUpdated(SeiAppData r100);

    /* synthetic */ void onSpeechRecognitionSeiUpdate(String r100);

    /* bridge */ /* synthetic */ void onSpeechRhythm(String r100);

    /* synthetic */ void onTalkStateUpdated(String[] r100, boolean[] r101);

    /* synthetic */ void onVideoStateSeiUpdate(ld0.a r100);

    void parseSeiData(String r100);

    void setMLivePlayerView(LivePlayerView r100);

    void updateSceneByVer(SeiAppData r100);
}
