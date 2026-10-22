package com.bef.effectsdk.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MessageCenter {
    public static final int BEF_MSG_TYPE_RECORD_VIDEO = 72;
    public static final int MSG_CLIENT_TO_SDK_CHALLENGE_GAME = 4103;
    public static final int MSG_CLIENT_TO_SDK_PUASE_GAME = 4100;
    public static final int MSG_CLIENT_TO_SDK_RESTART_GAME = 4102;
    public static final int MSG_CLIENT_TO_SDK_RESUME_GAME = 4101;
    public static final int MSG_CLIENT_TO_SDK_START_GAME = 4097;
    public static final int MSG_CLINET_TO_SDK_FINISH_GAME = 4098;
    public static final int MSG_ERROR_TYPE_CONFIG = 4097;
    public static final int MSG_EVENT_2D_ANIMATION_CYCLE_FINISH = 5;
    public static final int MSG_EVENT_ALGORITHM_CHANGE_FACE_COUNT = 1;
    public static final int MSG_EVENT_AUDIO_FILE_WRITTEN = 2;
    public static final int MSG_EVENT_AUDIO_INIT = 1;
    public static final int MSG_EVENT_AUDIO_RECORD_FILEPATH = 2;
    public static final int MSG_EVENT_AUDIO_RECORD_START = 0;
    public static final int MSG_EVENT_AUDIO_RECORD_STOP = 1;
    public static final int MSG_EVENT_BODY_DANCE_CATEGORY_ADJUST = 1;
    public static final int MSG_EVENT_BODY_DANCE_CATEGORY_SCORE = 2;
    public static final int MSG_EVENT_CAMERA_SWITCH = 3;
    public static final int MSG_EVENT_CAMERA_TO_BACK = 2;
    public static final int MSG_EVENT_CAMERA_TO_FRONT = 1;
    public static final int MSG_EVENT_ENIGMA_COMPLETE = 1;
    public static final int MSG_EVENT_EXIT_GAME = 0;
    public static final int MSG_EVENT_GAME_END = 3;
    public static final int MSG_EVENT_GAME_READY = 2;
    public static final int MSG_EVENT_LOAD_FAIL = 4;
    public static final int MSG_EVENT_LOAD_INIT = 1;
    public static final int MSG_EVENT_LOAD_LOADING = 2;
    public static final int MSG_EVENT_LOAD_SUCCESS = 3;
    public static final int MSG_EVENT_PLAY_GAME_BGM = 1;
    public static final int MSG_EVENT_RECORD_CLIP_KEY = 2;
    public static final int MSG_EVENT_REPLAY_GAME = 1;
    public static final int MSG_EVENT_STOP_GAME_BGM = 0;
    public static final int MSG_ID_BEGIN = 16;
    public static final int MSG_SDK_TO_CLIENT_END_GAME_REQ = 4099;
    public static final int MSG_SDK_TO_CLIENT_GAME_RESOURCE_LOADED = 4104;
    public static final int MSG_TYPE_2D_ANIMATION_CYCLE = 18;
    public static final int MSG_TYPE_ALGORITHM_CHANGE = 23;
    public static final int MSG_TYPE_APP_STATUS = 22;
    public static final int MSG_TYPE_ARSCAN_STICKER = 53;
    public static final int MSG_TYPE_AUDIO_PLAYER = 21;
    public static final int MSG_TYPE_AUDIO_RECORD = 43;
    public static final int MSG_TYPE_BODY_DANCE = 19;
    public static final int MSG_TYPE_CLIENT_INTERACTION = 41;
    public static final int MSG_TYPE_EFFECT = 20;
    public static final int MSG_TYPE_FACE_ATTRIBUTIONS = 34;
    public static final int MSG_TYPE_FACE_VERIFY = 35;
    public static final int MSG_TYPE_GAME_DATA = 42;
    public static final int MSG_TYPE_GAME_MUSIC_END = 44;
    public static final int MSG_TYPE_GAME_MUSIC_REQ = 47;
    public static final int MSG_TYPE_GAME_NTF = 46;
    public static final int MSG_TYPE_GAME_REQ = 45;
    public static final int MSG_TYPE_GENERAL_AUDIO = 58;
    public static final int MSG_TYPE_HIDEINPUTMETHOD = 33;
    public static final int MSG_TYPE_LIVE_ACTIVITY_INFO = 56;
    public static final int MSG_TYPE_LIVE_GIFT_NOTIFY = 57;
    public static final int MSG_TYPE_LIVE_INTERACTION = 40;
    public static final int MSG_TYPE_LIVE_MAGIC_GESTURE_INFO = 55;
    public static final int MSG_TYPE_LIVE_OGC_INFO = 64;
    public static final int MSG_TYPE_M10N_INFO = 66;
    public static final int MSG_TYPE_RESOURCE = 17;
    public static final int MSG_TYPE_SHOWINPUTMETHOD = 32;
    public static final int MSG_TYPE_START_RECORD = 48;
    public static final int MSG_TYPE_STICKER_ASK_LOAD_CNT = 51;
    public static final int MSG_TYPE_STICKER_LOAD_CNT = 50;
    public static final int MSG_TYPE_STOP_RECORD = 49;
    public static final int MSG_TYPE_SWITCH_CAMERA_POSITION = 71;
    public static final int MSG_TYPE_SWITCH_TO_AR_MODE = 80;
    public static final int MSG_TYPE_TYPE_ENIGMA = 24;
    public static final int MSG_TYPE_VE_AUDIO = 59;
    public static final int MSG_TYPE_VRBRUSH_STICKER = 54;
    private static final String TAG = "MessageCenter";
    private static final List<Listener> sListeners = null;
    private static HandlerThread sMessageCenterThread;
    private static final Object sMessageCenterThreadLock = null;
    private static Handler sMessageHandler;

    /* JADX INFO: loaded from: classes39.dex */
    public interface Listener {
        void onMessageReceived(int r100, int r101, int r102, String r103);
    }

    /* JADX INFO: loaded from: classes39.dex */
    public static class MessageHandler extends Handler {
        public MessageHandler(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            MessageCenter.access$000(r100);
        }
    }

    public MessageCenter() {
    }

    static {
        sMessageCenterThreadLock = new Object();
        sListeners = new ArrayList();
    }

    public static void destroy() {
        List<Listener> r100 = sListeners;
        monitor-enter(r100);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (r100.isEmpty() == true) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L23
        return;
    L8:
        Object r101 = sMessageCenterThreadLock;     // Catch: Throwable -> L23
        monitor-enter(r101);     // Catch: Throwable -> L23
        Handler r102 = sMessageHandler;     // Catch: Throwable -> L20
        if (r102 == null) goto L13;
        r102.removeCallbacksAndMessages(null);     // Catch: Throwable -> L20
        sMessageHandler = null;     // Catch: Throwable -> L20
    L13:
        HandlerThread r103 = sMessageCenterThread;     // Catch: Throwable -> L20
        if (r103 == null) goto L16;
        r103.quit();     // Catch: Throwable -> L20
        sMessageCenterThread = null;     // Catch: Throwable -> L20
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L20
        r100.clear();     // Catch: Throwable -> L23
        monitor-exit(r100);     // Catch: Throwable -> L23
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    }

    public static void init() {
        Object r100 = sMessageCenterThreadLock;
        monitor-enter(r100);
        HandlerThread r101 = sMessageCenterThread;     // Catch: Throwable -> L13
        if (r101 != null) goto L7;
    L10:
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2(TAG);     // Catch: Throwable -> L13
        sMessageCenterThread = r102;     // Catch: Throwable -> L13
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L13
        sMessageHandler = new MessageHandler(sMessageCenterThread.getLooper());     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L7:
        if (ThreadMethodProxy.isAlive(r101) == false) goto L10;
        if (sMessageCenterThread.getLooper() != null) goto L11;
    L13:
        th = move-exception;
        throw th;
    }

    public static void removeAllListener() {
        List<Listener> r100 = sListeners;
        monitor-enter(r100);
        r100.clear();     // Catch: Throwable -> L7
        destroy();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$000(Message r100) {
        handleMessage(r100);
    }

    public static void addListener(Listener r100) {
        List<Listener> r101 = sListeners;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101.isEmpty() == false) goto L7;
        init();     // Catch: Throwable -> L10
    L7:
        r101.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    private static void handleMessage(Message r100) {
        List<Listener> r101 = sListeners;
        monitor-enter(r101);
        int r102 = r101.size();     // Catch: Throwable -> L12
        Listener[] r103 = new Listener[r102];     // Catch: Throwable -> L12
        r101.toArray(r103);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        if (r102 > 0) goto L8;
        return;
    L8:
        int r104 = 0;
    L9:
        if (r104 >= r102) goto L11;
        r103[r104].onMessageReceived(r100.what, r100.arg1, r100.arg2, (String) r100.obj);
        r104 = r104 + 1;
        goto L9
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void removeListener(Listener r100) {
        List<Listener> r101 = sListeners;
        monitor-enter(r101);
        r101.remove(r100);     // Catch: Throwable -> L9
        if (r101.isEmpty() == false) goto L7;
        destroy();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void setListener(Listener r100) {
        List<Listener> r101 = sListeners;
        monitor-enter(r101);
        addListener(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void postMessage(int r100, int r101, int r102, String r103) {
        Object r104 = sMessageCenterThreadLock;
        monitor-enter(r104);
        Handler r105 = sMessageHandler;     // Catch: Throwable -> L11
        if (r105 != null) goto L8;
        monitor-exit(r104);     // Catch: Throwable -> L11
        return;
    L8:
        Message.obtain(r105, r100, r101, r102, r103).sendToTarget();     // Catch: Throwable -> L11
        monitor-exit(r104);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
