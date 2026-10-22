package com.android.server.media;

import android.content.Context;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import com.android.server.job.controllers.JobStatus;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class MediaSessionDeviceConfig {
    private static final long DEFAULT_MEDIA_BUTTON_RECEIVER_FGS_ALLOWLIST_DURATION_MS = 10000;
    private static final long DEFAULT_MEDIA_SESSION_CALLBACK_FGS_ALLOWLIST_DURATION_MS = 10000;
    private static final long DEFAULT_MEDIA_SESSION_CALLBACK_FGS_WHILE_IN_USE_TEMP_ALLOW_DURATION_MS = 10000;
    private static final long DEFAULT_MEDIA_SESSION_TEMP_USER_ENGAGED_DURATION_MS = 600000;
    private static final String KEY_MEDIA_BUTTON_RECEIVER_FGS_ALLOWLIST_DURATION_MS = "media_button_receiver_fgs_allowlist_duration_ms";
    private static final String KEY_MEDIA_SESSION_CALLBACK_FGS_ALLOWLIST_DURATION_MS = "media_session_calback_fgs_allowlist_duration_ms";
    private static final String KEY_MEDIA_SESSION_CALLBACK_FGS_WHILE_IN_USE_TEMP_ALLOW_DURATION_MS = "media_session_callback_fgs_while_in_use_temp_allow_duration_ms";
    private static final String KEY_MEDIA_SESSION_TEMP_USER_ENGAGED_DURATION_MS = "media_session_temp_user_engaged_duration_ms";
    private static volatile long sMediaButtonReceiverFgsAllowlistDurationMs;
    private static volatile long sMediaSessionCallbackFgsAllowlistDurationMs;
    private static volatile long sMediaSessionCallbackFgsWhileInUseTempAllowDurationMs;
    private static volatile long sMediaSessionTempUserEngagedDurationMs;

    /* JADX INFO: renamed from: $r8$lambda$MNJwt-oLqFqNCBNiXIWjsovBf6M, reason: not valid java name */
    public static /* synthetic */ void m5617$r8$lambda$MNJwtoLqFqNCBNiXIWjsovBf6M(DeviceConfig.Properties r0, String r1) {
        lambda$refresh$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$k_hFW2LrttADCrEeih-AxETDeEg, reason: not valid java name */
    public static /* synthetic */ void m5618$r8$lambda$k_hFW2LrttADCrEeihAxETDeEg(DeviceConfig.Properties r0) {
        lambda$initialize$1(r0);
    }

    MediaSessionDeviceConfig() {
    }

    static {
        sMediaButtonReceiverFgsAllowlistDurationMs = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        sMediaSessionCallbackFgsAllowlistDurationMs = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        sMediaSessionCallbackFgsWhileInUseTempAllowDurationMs = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        sMediaSessionTempUserEngagedDurationMs = 600000;
    }

    private static void refresh(final DeviceConfig.Properties properties) {
        properties.getKeyset();
        properties.getKeyset().forEach(new MediaSessionDeviceConfig$$ExternalSyntheticLambda1(properties));
    }

    private static /* synthetic */ void lambda$refresh$0(DeviceConfig.Properties properties, String key) {
        switch(key.hashCode()) {
            case -1976080914: goto L15;
            case -1842784600: goto L12;
            case -1060130895: goto L9;
            case 1803361950: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L19:
        switch(r0) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            default: goto L29;
        };
    L21:
        sMediaSessionTempUserEngagedDurationMs = properties.getLong(key, 600000);
        return;
    L22:
        sMediaSessionCallbackFgsWhileInUseTempAllowDurationMs = properties.getLong(key, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    L23:
        sMediaSessionCallbackFgsAllowlistDurationMs = properties.getLong(key, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    L24:
        sMediaButtonReceiverFgsAllowlistDurationMs = properties.getLong(key, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    L29:
        return;
    L6:
        if (key.equals(KEY_MEDIA_SESSION_CALLBACK_FGS_ALLOWLIST_DURATION_MS) == false) goto L17;
        r0 = 1;
        goto L19
    L9:
        if (key.equals(KEY_MEDIA_SESSION_CALLBACK_FGS_WHILE_IN_USE_TEMP_ALLOW_DURATION_MS) == false) goto L17;
        r0 = 2;
        goto L19
    L12:
        if (key.equals(KEY_MEDIA_SESSION_TEMP_USER_ENGAGED_DURATION_MS) == false) goto L17;
        r0 = 3;
        goto L19
    L15:
        if (key.equals(KEY_MEDIA_BUTTON_RECEIVER_FGS_ALLOWLIST_DURATION_MS) == false) goto L17;
        r0 = 0;
        goto L19
    }

    public static void initialize(Context context) {
        DeviceConfig.addOnPropertiesChangedListener("media", context.getMainExecutor(), new MediaSessionDeviceConfig$$ExternalSyntheticLambda0());
        refresh(DeviceConfig.getProperties("media", new String[0]));
    }

    private static /* synthetic */ void lambda$initialize$1(DeviceConfig.Properties properties) {
        refresh(properties);
    }

    public static long getMediaButtonReceiverFgsAllowlistDurationMs() {
        return sMediaButtonReceiverFgsAllowlistDurationMs;
    }

    public static long getMediaSessionCallbackFgsAllowlistDurationMs() {
        return sMediaSessionCallbackFgsAllowlistDurationMs;
    }

    public static long getMediaSessionCallbackFgsWhileInUseTempAllowDurationMs() {
        return sMediaSessionCallbackFgsWhileInUseTempAllowDurationMs;
    }

    public static long getMediaSessionTempUserEngagedDurationMs() {
        return sMediaSessionTempUserEngagedDurationMs;
    }

    public static void dump(PrintWriter pw, String prefix) {
        pw.println("Media session config:");
        String dumpFormat = prefix + "  %s: [cur: %s, def: %s]";
        Long r1 = Long.valueOf(sMediaButtonReceiverFgsAllowlistDurationMs);
        Long r2 = Long.valueOf(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        pw.println(TextUtils.formatSimple(dumpFormat, new Object[]{KEY_MEDIA_BUTTON_RECEIVER_FGS_ALLOWLIST_DURATION_MS, r1, r2}));
        pw.println(TextUtils.formatSimple(dumpFormat, new Object[]{KEY_MEDIA_SESSION_CALLBACK_FGS_ALLOWLIST_DURATION_MS, Long.valueOf(sMediaSessionCallbackFgsAllowlistDurationMs), r2}));
        pw.println(TextUtils.formatSimple(dumpFormat, new Object[]{KEY_MEDIA_SESSION_CALLBACK_FGS_WHILE_IN_USE_TEMP_ALLOW_DURATION_MS, Long.valueOf(sMediaSessionCallbackFgsWhileInUseTempAllowDurationMs), r2}));
        pw.println(TextUtils.formatSimple(dumpFormat, new Object[]{KEY_MEDIA_SESSION_TEMP_USER_ENGAGED_DURATION_MS, Long.valueOf(sMediaSessionTempUserEngagedDurationMs), 600000L}));
    }
}
