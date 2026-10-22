package com.android.server.media;

import android.app.PendingIntent;
import android.content.Context;
import android.media.session.MediaSession;
import android.view.KeyEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediaKeyDispatcher {
    static final int KEY_EVENT_DOUBLE_TAP = 2;
    static final int KEY_EVENT_LONG_PRESS = 8;
    static final int KEY_EVENT_SINGLE_TAP = 1;
    static final int KEY_EVENT_TRIPLE_TAP = 4;
    private Map<Integer, Integer> mOverriddenKeyEvents;

    @Retention(RetentionPolicy.SOURCE)
    @interface KeyEventType {
    }

    public MediaKeyDispatcher(Context context) {
        this.mOverriddenKeyEvents = new HashMap();
        this.mOverriddenKeyEvents.put(126, 0);
        this.mOverriddenKeyEvents.put(127, 0);
        this.mOverriddenKeyEvents.put(85, 0);
        this.mOverriddenKeyEvents.put(91, 0);
        this.mOverriddenKeyEvents.put(79, 0);
        this.mOverriddenKeyEvents.put(86, 0);
        this.mOverriddenKeyEvents.put(87, 0);
        this.mOverriddenKeyEvents.put(88, 0);
        this.mOverriddenKeyEvents.put(25, 0);
        this.mOverriddenKeyEvents.put(24, 0);
        this.mOverriddenKeyEvents.put(164, 0);
    }

    MediaSession.Token getMediaSession(KeyEvent keyEvent, int uid, boolean asSystemService) {
        return null;
    }

    PendingIntent getMediaButtonReceiver(KeyEvent keyEvent, int uid, boolean asSystemService) {
        return null;
    }

    Map<Integer, Integer> getOverriddenKeyEvents() {
        return this.mOverriddenKeyEvents;
    }

    static boolean isSingleTapOverridden(int overriddenKeyEvents) {
        if ((overriddenKeyEvents & 1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isDoubleTapOverridden(int overriddenKeyEvents) {
        if ((overriddenKeyEvents & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isTripleTapOverridden(int overriddenKeyEvents) {
        if ((overriddenKeyEvents & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isLongPressOverridden(int overriddenKeyEvents) {
        if ((overriddenKeyEvents & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void setOverriddenKeyEvents(int keyCode, int keyEventType) {
        this.mOverriddenKeyEvents.put(Integer.valueOf(keyCode), Integer.valueOf(keyEventType));
    }

    void onSingleTap(KeyEvent keyEvent) {
    }

    void onDoubleTap(KeyEvent keyEvent) {
    }

    void onTripleTap(KeyEvent keyEvent) {
    }

    void onLongPress(KeyEvent keyEvent) {
    }
}
