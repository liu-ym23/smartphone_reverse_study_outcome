package com.bytedance.android.livesdkapi.log;

import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/IPlayerBlackScreenMonitor;", "", "blackScreenDetect", "", "trigger", "", "forceCheck", EventVerify.TYPE_LAUNCH, "", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlayerBlackScreenMonitor {
    public static final Companion Companion = null;
    public static final String TRIGGER_KEEP_ALIVE = "keep_alive";
    public static final String TRIGGER_TYPE_PAUSE = "pause";
    public static final String TRIGGER_TYPE_RELEASE = "release";
    public static final String TRIGGER_TYPE_SCENE_CHANGE = "scene_change";
    public static final String TRIGGER_TYPE_STOP = "stop";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/IPlayerBlackScreenMonitor$Companion;", "", "()V", "TRIGGER_KEEP_ALIVE", "", "TRIGGER_TYPE_PAUSE", "TRIGGER_TYPE_RELEASE", "TRIGGER_TYPE_SCENE_CHANGE", "TRIGGER_TYPE_STOP", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String TRIGGER_KEEP_ALIVE = "keep_alive";
        public static final String TRIGGER_TYPE_PAUSE = "pause";
        public static final String TRIGGER_TYPE_RELEASE = "release";
        public static final String TRIGGER_TYPE_SCENE_CHANGE = "scene_change";
        public static final String TRIGGER_TYPE_STOP = "stop";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean blackScreenDetect$default(IPlayerBlackScreenMonitor r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = false;
        L7:
            return r100.blackScreenDetect(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blackScreenDetect");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean blackScreenDetect(String r100, boolean r101);

    void launch();
}
