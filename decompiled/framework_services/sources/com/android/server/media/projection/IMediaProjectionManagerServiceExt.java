package com.android.server.media.projection;

import android.prometheus.ext.core.ExtLoader;
import android.view.ContentRecordingSession;

/* JADX INFO: loaded from: classes2.dex */
public class IMediaProjectionManagerServiceExt {
    public static final String NODE_CREATE_PROJECTION = "create_projection";
    public static final String NODE_GET_PROJECTION = "get_projection";
    public static final String NODE_SET_CONTENT_RECORDING_SESSION = "set_content_recording_session";
    public static final String NODE_SET_REVIEWED_CONSENT_SESSION = "set_reviewed_consent_session";
    public static final String NODE_START = "start";
    public static final String NODE_START_PROJECTION_LOCKED = "start_projection_locked";
    public static final String NODE_STOP = "stop";
    public static final String NODE_USER_REVIEW_CONSENT_RESULT = "user_review_consent_result";
    public static final int STATE_CONTENT_SESSION_SET = 4;
    public static final int STATE_CREATED = 1;
    public static final int STATE_INITIAL = 0;
    public static final int STATE_STARTED = 3;
    public static final int STATE_STARTING = 2;
    public static final int STATE_STOPPED = 5;

    public static IMediaProjectionManagerServiceExt get(Object base) {
        return (IMediaProjectionManagerServiceExt) ExtLoader.get(IMediaProjectionManagerServiceExt.class, base);
    }

    public IMediaProjectionManagerServiceExt() {
    }

    public IMediaProjectionManagerServiceExt(Object base) {
    }

    public void createProjectionInternal_onInit(int sid, int hostUid, String hostPkg) {
    }

    public void createProjectionInternal_onResult(boolean success, String errorType, Throwable ex) {
    }

    public void startProjectionLocked_onEnd() {
    }

    public void setContentRecordingSession_onEnd(ContentRecordingSession incomingSession, boolean success) {
    }

    public void setUserReviewGrantedConsentResult_onEnd(int consentResult, boolean success, String errorType) {
    }

    public void setReviewedConsentSessionLocked_onEnd(ContentRecordingSession session, boolean success) {
    }

    public void getProjectionInternal_onEnd(boolean success, String errorType) {
    }

    public void MediaProjection_start_onStart() {
    }

    public void MediaProjection_start_onFailure(String errorType, Throwable ex) {
    }

    public void MediaProjection_stop_onEnd(int stopReason) {
    }

    public boolean skipSwitchMediarouter() {
        return false;
    }
}
