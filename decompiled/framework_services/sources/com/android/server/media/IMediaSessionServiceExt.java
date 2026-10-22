package com.android.server.media;

import android.media.session.PlaybackState;
import android.prometheus.ext.core.ExtLoader;
import android.view.KeyEvent;
import com.android.server.pm.Settings;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IMediaSessionServiceExt {
    public static final String ERROR_ALREADY_CLOSED = "ALREADY_CLOSED";
    public static final String ERROR_EXCEPTION = "EXCEPTION";
    public static final String ERROR_INVALID_ARGUMENT = "INVALID_ARGUMENT";
    public static final String ERROR_INVALID_RECORD = "INVALID_RECORD";
    public static final String ERROR_OWNER_DIED = "OWNER_DIED";
    public static final String ERROR_PACKAGE_MISMATCH = "PACKAGE_MISMATCH";
    public static final String ERROR_SESSION_NOT_FOUND = "SESSION_NOT_FOUND";
    public static final String ERROR_TOO_MANY_SESSIONS = "TOO_MANY_SESSIONS";
    public static final String NODE_CREATE_SESSION = "create_session";
    public static final String NODE_DESTROY_SESSION = "destroy_session";
    public static final String NODE_DISPATCH_MEDIA_KEY_EVENT = "dispatch_media_key_event";
    public static final String NODE_DISPATCH_MEDIA_KEY_EVENT_TO_SESSION = "dispatch_media_key_event_to_session";
    public static final String NODE_SESSION_ACTIVE_STATE_CHANGED = "session_active_state_changed";
    public static final String NODE_SET_GLOBAL_PRIORITY_SESSION = "set_global_priority_session";
    public static final int STATE_ACTIVE = 2;
    public static final int STATE_CREATED = 1;
    public static final int STATE_DESTROYED = 4;
    public static final int STATE_INACTIVE = 3;
    public static final int STATE_NONE = 0;

    public static IMediaSessionServiceExt get(MediaSessionService base) {
        return (IMediaSessionServiceExt) ExtLoader.get(IMediaSessionServiceExt.class, base);
    }

    public IMediaSessionServiceExt() {
    }

    public IMediaSessionServiceExt(Object base) {
    }

    public MediaSessionRecordImpl getTopPriorityVolumeSession(List<MediaSessionRecord> records) {
        return null;
    }

    public void init(int uid, int userId, String pkg, String tag) {
    }

    public int getSid() {
        return 0;
    }

    public void onSessionActiveStateChanged_onEnd(MediaSessionRecordImpl record, boolean userEngaged, PlaybackState playbackState) {
    }

    public void setGlobalPrioritySession_onEnd(MediaSessionRecordImpl record) {
    }

    public void destroySessionLocked_onStart(MediaSessionRecordImpl record) {
    }

    public void createSession_onSuccess(MediaSessionRecord record) {
    }

    public void createSession_onException(int uid, String pkg, String tag, Exception ex) {
    }

    public void dispatchMediaKeyEvent_onBeforeHandle(int uid, String pkg, KeyEvent keyEvent, String errorType) {
    }

    public void dispatchMediaKeyEventToSessionAsSystemService_onBeforeDispatch(int uid, String pkg, KeyEvent keyEvent, MediaSessionRecord record, String errorType) {
    }

    public static String getCreateSessionErrorType(Exception e) {
        if ((e instanceof SecurityException) == false) goto L11;
        if (e.getMessage() == null) goto L11;
        if (e.getMessage().contains(Settings.ATTR_PACKAGE) == false) goto L11;
        return ERROR_PACKAGE_MISMATCH;
    L11:
        if ((e instanceof IllegalArgumentException) == false) goto L15;
        return ERROR_INVALID_ARGUMENT;
    L15:
        if ((e instanceof RuntimeException) == false) goto L27;
        String msg = e.getMessage();
        if (msg == null) goto L27;
        if (msg.contains("too many sessions") == false) goto L23;
        return ERROR_TOO_MANY_SESSIONS;
    L23:
        if (msg.contains("owner died prematurely") == false) goto L27;
        return ERROR_OWNER_DIED;
    L27:
        if ((e instanceof IllegalStateException) == true) goto L29;
        return ERROR_EXCEPTION;
    L29:
        if (e.getMessage() != null) goto L31;
        return ERROR_EXCEPTION;
    L31:
        if (e.getMessage().contains("Invalid session record") == false) goto L37;
        return ERROR_INVALID_RECORD;
    L37:
        return ERROR_EXCEPTION;
    }
}
