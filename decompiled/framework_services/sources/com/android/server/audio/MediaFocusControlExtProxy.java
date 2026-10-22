package com.android.server.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.FocusOwnerInfo;
import android.media.IAudioFocusDispatcher;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.prometheus.ext.core.ExtLoader;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class MediaFocusControlExtProxy extends MediaFocusControlExt {
    private final List<MediaFocusControlExt> mMediaFocusControlExts;

    public static MediaFocusControlExtProxy get(MediaFocusControl base) {
        return new MediaFocusControlExtProxy(base);
    }

    public MediaFocusControlExtProxy(MediaFocusControl base) {
        this.mMediaFocusControlExts = ExtLoader.getAll(MediaFocusControlExt.class, base);
    }

    @Override // com.android.server.audio.MediaFocusControlExt
    protected void init_onEnd(Context cntxt, Stack<FocusRequester> focusStack, Object audioFocusLock, Handler focusHandler) {
        if (this.mMediaFocusControlExts != null) goto L5;
        return;
    L5:
        Iterator<MediaFocusControlExt> r0 = this.mMediaFocusControlExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        MediaFocusControlExt ext = r0.next();
        ext.init_onEnd(cntxt, focusStack, audioFocusLock, focusHandler);
        goto L7
    }

    @Override // com.android.server.audio.MediaFocusControlExt
    protected void requestAudioFocus_onBegin(AudioAttributes aa, int focusChangeHint, IBinder cb, IAudioFocusDispatcher fd, String clientId, String callingPackageName, int flags, int sdk, boolean forceDuck, int testUid, boolean permissionOverridesCheck) {
        if (this.mMediaFocusControlExts != null) goto L5;
        return;
    L5:
        Iterator<MediaFocusControlExt> r0 = this.mMediaFocusControlExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        MediaFocusControlExt ext = r0.next();
        ext.requestAudioFocus_onBegin(aa, focusChangeHint, cb, fd, clientId, callingPackageName, flags, sdk, forceDuck, testUid, permissionOverridesCheck);
        goto L7
    }

    @Override // com.android.server.audio.MediaFocusControlExt
    protected boolean abandonAudioFocus_onBegin(IAudioFocusDispatcher fl, String clientId, AudioAttributes aa, String callingPackageName) {
        if (this.mMediaFocusControlExts != null) goto L5;
        return false;
    L5:
        Iterator<MediaFocusControlExt> r0 = this.mMediaFocusControlExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        MediaFocusControlExt ext = r0.next();
        if (ext.abandonAudioFocus_onBegin(fl, clientId, aa, callingPackageName) == false) goto L7;
        return true;
    L13:
        return false;
    }

    @Override // com.android.server.audio.MediaFocusControlExt
    protected void handleMessage_onEnd(Message msg) {
        if (this.mMediaFocusControlExts != null) goto L5;
        return;
    L5:
        Iterator<MediaFocusControlExt> r0 = this.mMediaFocusControlExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        MediaFocusControlExt ext = r0.next();
        ext.handleMessage_onEnd(msg);
        goto L7
    }

    @Override // com.android.server.audio.MediaFocusControlExt
    public FocusOwnerInfo getTopFocusOwnerInfo() {
        if (this.mMediaFocusControlExts != null) goto L5;
        return null;
    L5:
        Iterator<MediaFocusControlExt> r0 = this.mMediaFocusControlExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        MediaFocusControlExt ext = r0.next();
        FocusOwnerInfo info = ext.getTopFocusOwnerInfo();
        if (info == null) goto L7;
        return info;
    L12:
        return null;
    }
}
