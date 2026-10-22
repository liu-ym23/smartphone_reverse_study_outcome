package com.bytedance.android.livesdkapi;

import com.bytedance.android.live.broadcast.api.monitor.LiveStreamCodeMonitor$OnErrorType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/LiveCommonConstantsKt;", "", "()V", "LINK_CONSTANT_SEI_VERSION_PK", "", LiveStreamCodeMonitor$OnErrorType.MSG_ERROR_AUDIO_CAPTURE, LiveStreamCodeMonitor$OnErrorType.MSG_ERROR_VIDEO_CAPTURE, "REASON_ADVENTURE_LEAVE_ROOM", "", "REASON_AUDIO_SILENCE_OPT", "REASON_FORCE_OPEN_ANCHOR_MIC", "REASON_LINK_SECURITY", "REASON_LIVE_END", "REASON_MATCH_APPLY", "REASON_NOT_USE_BACKUP_STREAM", "REASON_ON_PAUSE", "REASON_ON_RESUME", "REASON_SWITCH_BACKUP_STREAM", "REASON_USE_BACKUP_STREAM", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveCommonConstantsKt {
    public static final LiveCommonConstantsKt INSTANCE = null;
    public static final int LINK_CONSTANT_SEI_VERSION_PK = 2;
    public static final int MSG_ERROR_AUDIO_CAPTURE = 3;
    public static final int MSG_ERROR_VIDEO_CAPTURE = 2;
    public static final String REASON_ADVENTURE_LEAVE_ROOM = "adventure leave rtc room";
    public static final String REASON_AUDIO_SILENCE_OPT = "audio silence opt";
    public static final String REASON_FORCE_OPEN_ANCHOR_MIC = "force open video talk anchor mic";
    public static final String REASON_LINK_SECURITY = "link security";
    public static final String REASON_LIVE_END = "live end";
    public static final String REASON_MATCH_APPLY = "match apply";
    public static final String REASON_NOT_USE_BACKUP_STREAM = "not use backup stream";
    public static final String REASON_ON_PAUSE = "onPause";
    public static final String REASON_ON_RESUME = "onResume";
    public static final String REASON_SWITCH_BACKUP_STREAM = "swtich backup stream";
    public static final String REASON_USE_BACKUP_STREAM = "use backup stream";

    private LiveCommonConstantsKt() {
    }

    static {
        INSTANCE = new LiveCommonConstantsKt();
    }
}
