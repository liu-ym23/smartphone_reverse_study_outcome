package com.android.server.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.FocusOwnerInfo;
import android.media.IAudioFocusDispatcher;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class MediaFocusControlExt {
    public static final String TAG = null;

    static {
        TAG = MediaFocusControlExt.class.getSimpleName();
    }

    public MediaFocusControlExt() {
    }

    public static MediaFocusControlExt get(MediaFocusControl base) {
        return MediaFocusControlExtProxy.get(base);
    }

    protected void init_onEnd(Context cntxt, Stack<FocusRequester> focusStack, Object audioFocusLock, Handler focusHandler) {
    }

    protected void requestAudioFocus_onBegin(AudioAttributes aa, int focusChangeHint, IBinder cb, IAudioFocusDispatcher fd, String clientId, String callingPackageName, int flags, int sdk, boolean forceDuck, int testUid, boolean permissionOverridesCheck) {
    }

    protected boolean abandonAudioFocus_onBegin(IAudioFocusDispatcher fl, String clientId, AudioAttributes aa, String callingPackageName) {
        return false;
    }

    protected void handleMessage_onEnd(Message msg) {
    }

    public FocusOwnerInfo getTopFocusOwnerInfo() {
        return null;
    }
}
