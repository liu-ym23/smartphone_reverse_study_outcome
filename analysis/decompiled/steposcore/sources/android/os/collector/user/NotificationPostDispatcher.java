package android.os.collector.user;

import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class NotificationPostDispatcher {
    public static final int MAX_SUBTEXT_LEN = 128;
    public static final int MAX_TEXT_LEN = 512;
    public static final int MAX_TITLE_LEN = 128;
    private static final long ONE_MINUTE_MS = 60000;
    private static final long PER_KEY_DEDUP_WINDOW_MS = 1000;
    private static final int RATE_LIMIT_PER_MIN = 60;
    public static final int RECENT_BUFFER_CAPACITY = 100;
    private static final String TAG = "NotificationPostDispatcher";
    private static final String TAG_DIAG = "CollectCompanionDiag";
    private static final Object S_RATE_LOCK = new Object();
    private static final Map<String, Long> S_LAST_SEEN_BY_KEY = new HashMap();
    private static final Deque<Long> S_FIRE_TIMES = new ArrayDeque(61);
    private static final Deque<StepOSNotificationPostData> S_RECENT_BUFFER = new ArrayDeque(100);
    private static final Object S_RECENT_LOCK = new Object();

    private NotificationPostDispatcher() {
    }

    public static List<StepOSNotificationPostData> snapshotRecent() {
        ArrayList arrayList;
        synchronized (S_RECENT_LOCK) {
            arrayList = new ArrayList(S_RECENT_BUFFER);
        }
        return arrayList;
    }

    public static int recentSize() {
        int size;
        synchronized (S_RECENT_LOCK) {
            size = S_RECENT_BUFFER.size();
        }
        return size;
    }

    public static void clearRecent() {
        synchronized (S_RECENT_LOCK) {
            S_RECENT_BUFFER.clear();
        }
    }

    private static void appendRecent(StepOSNotificationPostData data) {
        synchronized (S_RECENT_LOCK) {
            if (S_RECENT_BUFFER.size() >= 100) {
                S_RECENT_BUFFER.pollFirst();
            }
            S_RECENT_BUFFER.addLast(data);
        }
    }

    public static void onPosted(StatusBarNotification sbn) {
    }

    private static String clamp(String s, int max) {
        return s == null ? "" : s.length() <= max ? s : s.substring(0, max);
    }

    private static String extractString(Bundle extras, String key) {
        if (extras == null) {
            return "";
        }
        CharSequence cs = extras.getCharSequence(key);
        if (cs == null) {
            cs = extras.getString(key);
        }
        return cs == null ? "" : cs.toString();
    }

    private static String nullToEmpty(String s) {
        return s == null ? "" : s;
    }
}
