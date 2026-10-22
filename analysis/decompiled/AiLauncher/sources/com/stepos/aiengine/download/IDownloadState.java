package com.stepos.aiengine.download;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/download/IDownloadState;", "", "<init>", "()V", "STATUS_NONE", "", "STATUS_WAITING", "STATUS_STARTED", "STATUS_ERROR", "STATUS_PAUSED", "STATUS_CHECKING", "STATUS_FINISHED", "STATUS_REMOVED", "STATUS_WAITING_USER_ACTION", "STATUS_USER_CONFIRMED", "STATUS_CTA_REJECTED", "STATUS_USER_CANCELLED", "STATUS_SERVICE_DISABLED", "STATUS_NO_NETWORK", "STATUS_INSUFFICIENT_SPACE", "STATUS_LOW_BATTERY", "isUserInteractionState", "", VoiceWakeupReceiver.EXTRA_STATE, "isUserCancelled", "isTerminal", "isActive", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IDownloadState {
    public static final IDownloadState INSTANCE = new IDownloadState();
    public static final int STATUS_CHECKING = 5;
    public static final int STATUS_CTA_REJECTED = 14;
    public static final int STATUS_ERROR = 3;
    public static final int STATUS_FINISHED = 6;
    public static final int STATUS_INSUFFICIENT_SPACE = 18;
    public static final int STATUS_LOW_BATTERY = 19;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_NO_NETWORK = 17;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_REMOVED = 7;
    public static final int STATUS_SERVICE_DISABLED = 16;
    public static final int STATUS_STARTED = 2;
    public static final int STATUS_USER_CANCELLED = 15;
    public static final int STATUS_USER_CONFIRMED = 13;
    public static final int STATUS_WAITING = 1;
    public static final int STATUS_WAITING_USER_ACTION = 10;

    public final boolean isActive(int state) {
        return state == 1 || state == 2 || state == 5;
    }

    public final boolean isTerminal(int state) {
        return state == 6 || state == 3 || state == 7;
    }

    public final boolean isUserCancelled(int state) {
        return state == 15;
    }

    public final boolean isUserInteractionState(int state) {
        return state == 10 || state == 13;
    }
}
