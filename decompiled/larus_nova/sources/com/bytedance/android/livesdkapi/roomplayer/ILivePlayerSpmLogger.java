package com.bytedance.android.livesdkapi.roomplayer;

import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JD\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JN\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0005H&J:\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000bH&J:\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000bH&J:\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000bH&J:\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000bH&JD\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&J:\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000bH&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerSpmLogger;", "", "logAudio", "", "msg", "", "logCallStack", "logExtraRender", "logLifeCycle", "extras", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "simple", "", "logLivePlayer", "logPlayerClient", "subTag", "logPlayerClientEventHub", "logPlayerException", "logPlayerMonitor", "logPlayerMute", "logPlayerView", "logPlayerWidget", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerSpmLogger {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void logCallStack$default(ILivePlayerSpmLogger r100, String r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = "";
        L6:
            r100.logCallStack(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logCallStack");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logPlayerClientEventHub$default(ILivePlayerSpmLogger r100, String r101, HashMap r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.logPlayerClientEventHub(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPlayerClientEventHub");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logPlayerException$default(ILivePlayerSpmLogger r100, String r101, HashMap r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.logPlayerException(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPlayerException");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logPlayerMonitor$default(ILivePlayerSpmLogger r100, String r101, HashMap r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.logPlayerMonitor(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPlayerMonitor");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logPlayerMute$default(ILivePlayerSpmLogger r100, String r101, HashMap r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.logPlayerMute(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPlayerMute");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logPlayerWidget$default(ILivePlayerSpmLogger r100, String r101, HashMap r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.logPlayerWidget(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPlayerWidget");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logLifeCycle$default(ILivePlayerSpmLogger r100, String r101, HashMap r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = true;
        L9:
            r100.logLifeCycle(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logLifeCycle");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logPlayerView$default(ILivePlayerSpmLogger r100, String r101, HashMap r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = true;
        L9:
            r100.logPlayerView(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPlayerView");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logPlayerClient$default(ILivePlayerSpmLogger r100, String r101, HashMap r102, boolean r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r105 & 4) == 0) goto L10;
            r103 = true;
        L10:
            if ((r105 & 8) == 0) goto L12;
            r104 = "";
        L12:
            r100.logPlayerClient(r101, r102, r103, r104);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPlayerClient");
        }
    }

    void logAudio(String r100);

    void logCallStack(String r100);

    void logExtraRender(String r100);

    void logLifeCycle(String r100, HashMap<String, Object> r101, boolean r102);

    void logLivePlayer(String r100);

    void logPlayerClient(String r100, HashMap<String, Object> r101, boolean r102, String r103);

    void logPlayerClientEventHub(String r100, HashMap<String, Object> r101);

    void logPlayerException(String r100, HashMap<String, Object> r101);

    void logPlayerMonitor(String r100, HashMap<String, Object> r101);

    void logPlayerMute(String r100, HashMap<String, Object> r101);

    void logPlayerView(String r100, HashMap<String, Object> r101, boolean r102);

    void logPlayerWidget(String r100, HashMap<String, Object> r101);
}
