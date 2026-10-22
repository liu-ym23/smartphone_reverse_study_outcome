package com.bytedance.android.livesdkapi.player;

import android.hardware.HardwareBuffer;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000  2\u00020\u0001:\u0001 J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\u001c\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001eH&J\b\u0010\u001f\u001a\u00020\u0003H\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/ILivePlayerEventListener;", "", "onBindRenderView", "", "renderView", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", LynxVideoManagerLite.EVENT_ON_FIRST_FRAME, "onHWBDrawFrame", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "roi", "", "colorSpace", "", "onMute", "onMuteIssueWarning", "", "onPlaying", "onPrepare", "onRelease", "onSei", "sei", "onStallEvent", "event", "onStartPul", "onStop", "onSurfaceReady", "onUnMute", "onVideoSizeChange", "size", "Lkotlin/Pair;", "openHardwareBufferOutput", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerEventListener {
    public static final int AUDIO_RENDER_STALL_EVENT_END = 3001;
    public static final int AUDIO_RENDER_STALL_EVENT_END2 = 3002;
    public static final Companion Companion = null;
    public static final int PULL_STALL_EVENT_END = 1002;
    public static final int PULL_STALL_EVENT_START = 1001;
    public static final int VIDEO_RENDER_STALL_EVENT_END = 2001;
    public static final int VIDEO_RENDER_STALL_EVENT_END2 = 2002;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/ILivePlayerEventListener$Companion;", "", "()V", "AUDIO_RENDER_STALL_EVENT_END", "", "AUDIO_RENDER_STALL_EVENT_END2", "PULL_STALL_EVENT_END", "PULL_STALL_EVENT_START", "VIDEO_RENDER_STALL_EVENT_END", "VIDEO_RENDER_STALL_EVENT_END2", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int AUDIO_RENDER_STALL_EVENT_END = 3001;
        public static final int AUDIO_RENDER_STALL_EVENT_END2 = 3002;
        public static final int PULL_STALL_EVENT_END = 1002;
        public static final int PULL_STALL_EVENT_START = 1001;
        public static final int VIDEO_RENDER_STALL_EVENT_END = 2001;
        public static final int VIDEO_RENDER_STALL_EVENT_END2 = 2002;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onHWBDrawFrame(ILivePlayerEventListener r100, HardwareBuffer r101, int[] r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "hardwareBuffer");
            Intrinsics.checkNotNullParameter(r102, "roi");
        }

        public static String onMuteIssueWarning(ILivePlayerEventListener r100) {
            return null;
        }

        public static void onStallEvent(ILivePlayerEventListener r100, int r101) {
        }

        public static void openHardwareBufferOutput(ILivePlayerEventListener r100) {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onBindRenderView(IRenderView r100);

    void onFirstFrame();

    void onHWBDrawFrame(HardwareBuffer r100, int[] r101, int r102);

    void onMute();

    String onMuteIssueWarning();

    void onPlaying();

    void onPrepare();

    void onRelease();

    void onSei(String r100);

    void onStallEvent(int r100);

    void onStartPul();

    void onStop();

    void onSurfaceReady();

    void onUnMute();

    void onVideoSizeChange(Pair<Integer, Integer> r100);

    void openHardwareBufferOutput();
}
