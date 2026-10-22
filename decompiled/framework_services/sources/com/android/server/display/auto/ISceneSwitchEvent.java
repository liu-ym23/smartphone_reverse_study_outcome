package com.android.server.display.auto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public interface ISceneSwitchEvent {
    public static final int REASON_APP_FOCUS = 1;
    public static final int REASON_BOOTSTRAP = 4;
    public static final int REASON_DISPLAY_SCENE_SOURCE = 16;
    public static final int REASON_DISPLAY_TRANSACTION = 2;
    public static final int REASON_FEATURE_DISABLED = 8;
    public static final int REASON_NONE = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChangeReason {
    }

    int getFromScene();

    int getGeneration();

    int getReason();

    long getTimestamp();

    int getToScene();

    static String reasonToString(int reason) {
        if (reason != 0) goto L5;
        return "NONE";
    L5:
        StringBuilder sb = new StringBuilder();
        appendReason(sb, reason, 1, "APP_FOCUS");
        appendReason(sb, reason, 2, "DISPLAY_TRANSACTION");
        appendReason(sb, reason, 4, "BOOTSTRAP");
        appendReason(sb, reason, 8, "FEATURE_DISABLED");
        appendReason(sb, reason, 16, "DISPLAY_SCENE_SOURCE");
        return sb.toString();
    }

    static void appendReason(StringBuilder sb, int reason, int flag, String label) {
        if ((reason & flag) != 0) goto L6;
        return;
    L6:
        if (sb.length() <= 0) goto L8;
        sb.append('|');
    L8:
        sb.append(label);
    }
}
