package android.os.collector.user;

import android.app.ActivityThread;
import android.app.AppGlobals;
import android.app.Notification;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageManager;
import android.graphics.drawable.Icon;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.os.collector.config.StepOSAppClassifyConfig;
import android.os.collector.user.StepOSMediaFileData;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.android.internal.os.BackgroundThread;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class UserDataCollectors {
    private static final int CONTENT_HASH_CAP_BYTES = 4096;
    private static final int CONTENT_MAX_BYTES = 3072;
    public static final int HINT_LIKE_CARD = 1;
    public static final int HINT_LIKE_ID = 4;
    public static final int HINT_LIKE_PASSWORD = 8;
    public static final int HINT_LIKE_PHONE = 2;
    private static final float MEDIA_RATING_UNRATED = -1.0f;
    private static final int MEDIA_TEXT_MAX = 128;
    private static final int MEDIA_VALUE_UNKNOWN = -1;
    private static final int MF_BATCH_BYTE_BUDGET = 3000;
    private static final int MF_BATCH_MAX_ITEMS = 10;
    private static final long MF_FLUSH_DELAY_MS = 2000;
    private static final int MF_MIME_MAX = 64;
    private static final int MF_NAME_MAX = 128;
    private static final int MF_PATH_MAX = 256;
    private static final int MF_PKG_MAX = 128;
    private static final int MF_URI_MAX = 192;
    private static final long NOTIF_PER_KEY_DEDUP_MS = 1000;
    private static final int NOTIF_RATE_LIMIT_PER_MIN = 60;
    private static final long NOTIF_RATE_WINDOW_MS = 60000;
    public static final int NOTIF_RECENT_BUFFER_CAPACITY = 100;
    private static final int NOTIF_SUBTEXT_MAX = 128;
    private static final int NOTIF_TEXT_MAX = 512;
    private static final int NOTIF_TITLE_MAX = 128;
    private static final String PKG_DATA_MIGRATION = "com.stepos.datamigration";
    private static final int RECENT_BUFFER_SIZE = 10;
    private static final int SHARE_EXTRA_TEXT_MAX = 512;
    private static final int SOURCE_TYPE_DRAG_DROP = 1;
    private static final int SOURCE_TYPE_SHARE = 0;
    private static final String TAG = "UserDataCollectors";
    private static final int ZEN_REASON_MAX = 48;
    private static final Object FG_LOCK = new Object();
    private static String sLastFgPkg = "";
    private static long sLastEnterMs = 0;
    private static final Object SCREEN_LOCK = new Object();
    private static long sLastTransitionMs = 0;
    private static boolean sLastInteractive = false;
    private static boolean sScreenInitialized = false;
    private static final Object KEYGUARD_LOCK = new Object();
    private static long sKeyguardLastTransitionMs = 0;
    private static boolean sKeyguardLastShown = false;
    private static boolean sKeyguardInitialized = false;
    private static final Object ALARM_LOCK = new Object();
    private static String sAlarmLastPkg = "";
    private static long sAlarmLastTriggerMs = 0;
    private static final Object ZEN_LOCK = new Object();
    private static long sZenLastTransitionMs = 0;
    private static final Pattern PATTERN_LIKE_CARD = Pattern.compile("\\d{16}");
    private static final Pattern PATTERN_LIKE_PHONE = Pattern.compile("(?<!\\d)1[3-9]\\d{9}(?!\\d)");
    private static final Pattern PATTERN_LIKE_ID = Pattern.compile("(?<!\\d)\\d{17}[\\dXx](?!\\d)");
    private static final Object CLIP_LOCK = new Object();
    private static final Deque<Long> sRecentHashes = new ArrayDeque(11);
    private static final Object WM_LOCK = new Object();
    private static String sWmLastPkg = "";
    private static int sWmLastActivityType = -1;
    private static boolean sWmLastFocusable = false;
    private static boolean sWmInitialized = false;
    private static final Object NOTIF_LOCK = new Object();
    private static final Map<String, Long> sNotifLastPostMs = new HashMap();
    private static final Deque<Long> sNotifRateWindow = new ArrayDeque(61);
    private static final Object NOTIF_RECENT_LOCK = new Object();
    private static final Deque<StepOSNotificationPostData> sNotifRecentBuffer = new ArrayDeque(100);
    private static final Object MEDIA_METADATA_LOCK = new Object();
    private static StepOSMediaMetadataData sLastMediaMetadata = null;
    private static String[] sShareDataSubscriberPkgs = null;
    private static final Object MF_LOCK = new Object();
    private static final List<StepOSMediaFileData.MediaFileItem> sMediaFileBatch = new ArrayList();
    private static int sMediaFileBatchBytes = 0;
    private static boolean sMediaFileFlushScheduled = false;

    private UserDataCollectors() {
    }

    public static void onActivityResumed(String packageName, int userId, long enterTimeMs) throws Throwable {
        if (packageName != null && !packageName.isEmpty()) {
            synchronized (FG_LOCK) {
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (packageName.equals(sLastFgPkg)) {
                        return;
                    }
                    String prevPkg = sLastFgPkg;
                    long prevDurationMs = sLastEnterMs > 0 ? Math.max(0L, enterTimeMs - sLastEnterMs) : 0L;
                    sLastFgPkg = packageName;
                    sLastEnterMs = enterTimeMs;
                    int uid = resolveUid(packageName, userId);
                    new StepOSForegroundChangeData(packageName, uid, prevPkg, enterTimeMs, prevDurationMs).write();
                } catch (Throwable th2) {
                    th = th2;
                    while (true) {
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                }
            }
        }
    }

    private static int resolveUid(String pkg, int userId) {
        try {
            IPackageManager pm = AppGlobals.getPackageManager();
            if (pm == null) {
                return 0;
            }
            return pm.getPackageUid(pkg, 0L, userId);
        } catch (Throwable th) {
            return 0;
        }
    }

    public static void onScreenChanged(boolean interactive, long timestampMs) throws Throwable {
        synchronized (SCREEN_LOCK) {
            try {
                if (sScreenInitialized) {
                    try {
                        if (interactive == sLastInteractive) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                }
                long jMax = 0;
                if (sScreenInitialized && sLastTransitionMs > 0) {
                    jMax = Math.max(0L, timestampMs - sLastTransitionMs);
                }
                long prevDur = jMax;
                sLastInteractive = interactive;
                sLastTransitionMs = timestampMs;
                sScreenInitialized = true;
                new StepOSScreenUsageData(interactive, prevDur, timestampMs).write();
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static void onKeyguardChanged(boolean shown, long timestampMs) throws Throwable {
        synchronized (KEYGUARD_LOCK) {
            try {
                if (sKeyguardInitialized) {
                    try {
                        if (shown == sKeyguardLastShown) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                }
                long jMax = 0;
                if (sKeyguardInitialized && sKeyguardLastTransitionMs > 0) {
                    jMax = Math.max(0L, timestampMs - sKeyguardLastTransitionMs);
                }
                long prevDur = jMax;
                sKeyguardLastShown = shown;
                sKeyguardLastTransitionMs = timestampMs;
                sKeyguardInitialized = true;
                new StepOSKeyguardChangeData(shown, prevDur, timestampMs).write();
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static void onAlarmClockSet(String packageName, long triggerAtMs, long timestampMs) throws Throwable {
        if (packageName == null) {
            packageName = "";
        }
        String packageName2 = packageName;
        synchronized (ALARM_LOCK) {
            try {
                if (sAlarmLastTriggerMs != 0) {
                    try {
                        if (triggerAtMs == sAlarmLastTriggerMs && packageName2.equals(sAlarmLastPkg)) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                }
                sAlarmLastPkg = packageName2;
                sAlarmLastTriggerMs = triggerAtMs;
                new StepOSAlarmClockChangeData(packageName2, triggerAtMs, timestampMs).write();
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static void onZenModeChanged(int zenMode, int prevZenMode, String reason, long timestampMs) {
        long prevDur;
        if (zenMode == prevZenMode) {
            return;
        }
        synchronized (ZEN_LOCK) {
            prevDur = sZenLastTransitionMs > 0 ? Math.max(0L, timestampMs - sZenLastTransitionMs) : 0L;
            sZenLastTransitionMs = timestampMs;
        }
        new StepOSZenModeChangeData(zenMode, prevZenMode, prevDur, timestampMs, truncate(reason, 48)).write();
    }

    public static void writeIfChanged(String sourcePkg, ClipData clip) {
        ClipDescription desc;
        int textLengthChars;
        boolean containsUri;
        int sensitiveHints;
        CharSequence firstText;
        if (clip == null || (desc = clip.getDescription()) == null) {
            return;
        }
        StringBuilder mimeSb = new StringBuilder();
        boolean containsUri2 = false;
        boolean containsHtml = false;
        for (int i = 0; i < desc.getMimeTypeCount(); i++) {
            if (i > 0) {
                mimeSb.append(',');
            }
            String m = desc.getMimeType(i);
            mimeSb.append(m != null ? m : "");
            if (m != null) {
                if (m.equals("text/html")) {
                    containsHtml = true;
                }
                if (m.equals("text/uri-list") || m.equals("text/vnd.android.intent")) {
                    containsUri2 = true;
                }
            }
        }
        int itemCount = clip.getItemCount();
        int textLengthChars2 = 0;
        int sensitiveHints2 = 0;
        if (itemCount > 0) {
            ClipData.Item first = clip.getItemAt(0);
            CharSequence firstText2 = first != null ? first.getText() : null;
            if (firstText2 != null) {
                textLengthChars2 = firstText2.length();
                sensitiveHints2 = computeSensitiveHints(firstText2);
            }
            if (first != null && first.getUri() != null) {
                textLengthChars = textLengthChars2;
                containsUri = true;
                sensitiveHints = sensitiveHints2;
                firstText = firstText2;
            } else {
                textLengthChars = textLengthChars2;
                containsUri = containsUri2;
                sensitiveHints = sensitiveHints2;
                firstText = firstText2;
            }
        } else {
            textLengthChars = 0;
            containsUri = containsUri2;
            sensitiveHints = 0;
            firstText = null;
        }
        long hash = computeContentHash(firstText, mimeSb.toString(), itemCount, containsHtml, containsUri);
        synchronized (CLIP_LOCK) {
            if (sRecentHashes.contains(Long.valueOf(hash))) {
                return;
            }
            sRecentHashes.addLast(Long.valueOf(hash));
            while (sRecentHashes.size() > 10) {
                sRecentHashes.pollFirst();
            }
            String fullContent = firstText != null ? firstText.toString() : "";
            String content = truncateUtf8(fullContent, CONTENT_MAX_BYTES);
            StepOSClipboardChangeData data = new StepOSClipboardChangeData(sourcePkg != null ? sourcePkg : "", mimeSb.toString(), itemCount, textLengthChars, containsHtml, containsUri, sensitiveHints, System.currentTimeMillis(), content);
            data.write();
        }
    }

    private static String truncateUtf8(String s, int maxBytes) {
        if (s.isEmpty() || s.getBytes(StandardCharsets.UTF_8).length <= maxBytes) {
            return s;
        }
        int bytes = 0;
        int i = 0;
        while (i < s.length()) {
            int cp = s.codePointAt(i);
            int cpBytes = cp < 128 ? 1 : cp < 2048 ? 2 : cp < 65536 ? 3 : 4;
            if (bytes + cpBytes > maxBytes) {
                break;
            }
            bytes += cpBytes;
            i += Character.charCount(cp);
        }
        return s.substring(0, i);
    }

    private static int computeSensitiveHints(CharSequence text) {
        int hints = 0;
        String s = text.toString();
        if (s.length() > 4096) {
            s = s.substring(0, 4096);
        }
        if (PATTERN_LIKE_CARD.matcher(s).find()) {
            hints = 0 | 1;
        }
        if (PATTERN_LIKE_PHONE.matcher(s).find()) {
            hints |= 2;
        }
        if (PATTERN_LIKE_ID.matcher(s).find()) {
            hints |= 4;
        }
        String lower = s.toLowerCase();
        if (lower.contains("password") || lower.contains("passwd") || lower.contains("密码")) {
            return hints | 8;
        }
        return hints;
    }

    private static long computeContentHash(CharSequence charSequence, String str, int i, boolean z, boolean z2) {
        long jMixInt = mixInt(mixInt(mixInt(mixInt(-3750763034362895579L, str.hashCode()), i), z ? 1 : 0), z2 ? 1 : 0);
        if (charSequence != null && !charSequence.isEmpty()) {
            byte[] bytes = charSequence.toString().getBytes(StandardCharsets.UTF_8);
            for (int i2 = 0; i2 < Math.min(bytes.length, 4096); i2++) {
                jMixInt = (jMixInt ^ (bytes[i2] & 255)) * 1099511628211L;
            }
            return mixInt(jMixInt, bytes.length);
        }
        return jMixInt;
    }

    private static long mixInt(long h, int v) {
        return (h ^ (v & 4294967295L)) * 1099511628211L;
    }

    public static void onWindowModeChanged(String packageName, int uid, int activityType, boolean focusable, long timestampMs) throws Throwable {
        int appType;
        if (packageName == null) {
            packageName = "";
        }
        String packageName2 = packageName;
        synchronized (WM_LOCK) {
            try {
                if (sWmInitialized) {
                    try {
                        if (packageName2.equals(sWmLastPkg) && activityType == sWmLastActivityType && focusable == sWmLastFocusable) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                }
                sWmLastPkg = packageName2;
                sWmLastActivityType = activityType;
                sWmLastFocusable = focusable;
                sWmInitialized = true;
                try {
                    int appType2 = StepOSAppClassifyConfig.getInstance().getAppType(packageName2);
                    appType = appType2;
                } catch (Throwable th3) {
                    appType = 0;
                }
                new StepOSForegroundWindowModeData(packageName2, uid, appType, activityType, focusable, timestampMs).write();
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public static void onNotificationPosted(StatusBarNotification sbn) {
        Notification n;
        String title;
        String text;
        String subText;
        if (sbn == null || (n = sbn.getNotification()) == null || n.visibility == -1) {
            return;
        }
        long now = sbn.getPostTime();
        if (now <= 0) {
            now = System.currentTimeMillis();
        }
        long now2 = now;
        String key = sbn.getKey();
        if (key == null) {
            key = "";
        }
        String key2 = key;
        synchronized (NOTIF_LOCK) {
            Long last = sNotifLastPostMs.get(key2);
            if (last == null || now2 - last.longValue() >= NOTIF_PER_KEY_DEDUP_MS) {
                while (!sNotifRateWindow.isEmpty() && now2 - sNotifRateWindow.peekFirst().longValue() > NOTIF_RATE_WINDOW_MS) {
                    sNotifRateWindow.pollFirst();
                }
                if (sNotifRateWindow.size() >= 60) {
                    return;
                }
                sNotifLastPostMs.put(key2, Long.valueOf(now2));
                sNotifRateWindow.addLast(Long.valueOf(now2));
                if (n.isMediaNotification()) {
                    writeMediaMetadata(sbn, n);
                    return;
                }
                Bundle extras = n.extras;
                if (extras == null) {
                    title = "";
                    text = "";
                    subText = "";
                } else {
                    String title2 = truncate(charSeqToString(extras.getCharSequence("android.title")), 128);
                    String text2 = truncate(charSeqToString(extras.getCharSequence("android.text")), 512);
                    String subText2 = truncate(charSeqToString(extras.getCharSequence("android.subText")), 128);
                    title = title2;
                    text = text2;
                    subText = subText2;
                }
                String title3 = sbn.getPackageName();
                String pkg = title3 != null ? sbn.getPackageName() : "";
                StepOSNotificationPostData data = new StepOSNotificationPostData(pkg, n.getChannelId() != null ? n.getChannelId() : "", n.category != null ? n.category : "", now2, sbn.isOngoing(), sbn.getGroupKey() != null ? sbn.getGroupKey() : "", title, text, subText, n.flags);
                data.write();
                synchronized (NOTIF_RECENT_LOCK) {
                    if (sNotifRecentBuffer.size() >= 100) {
                        sNotifRecentBuffer.pollFirst();
                    }
                    sNotifRecentBuffer.addLast(data);
                }
            }
        }
    }

    public static List<StepOSNotificationPostData> snapshotRecentNotifications() {
        ArrayList arrayList;
        synchronized (NOTIF_RECENT_LOCK) {
            arrayList = new ArrayList(sNotifRecentBuffer);
        }
        return arrayList;
    }

    private static String charSeqToString(CharSequence cs) {
        return cs != null ? cs.toString() : "";
    }

    private static void writeMediaMetadata(StatusBarNotification sbn, Notification n) {
        int positionMs;
        int state;
        String pkg = sbn.getPackageName() != null ? sbn.getPackageName() : "";
        Bundle extras = n.extras;
        if (extras == null) {
            return;
        }
        MediaSession.Token token = (MediaSession.Token) extras.getParcelable("android.mediaSession", MediaSession.Token.class);
        Context context = ActivityThread.currentApplication();
        if (token == null || context == null) {
            return;
        }
        try {
            MediaController controller = new MediaController(context, token);
            MediaMetadata metadata = controller.getMetadata();
            PlaybackState playbackState = controller.getPlaybackState();
            if (metadata == null && playbackState == null) {
                return;
            }
            int durationMs = mediaDurationMs(metadata);
            if (playbackState == null) {
                positionMs = -1;
            } else {
                positionMs = clampMediaMs(playbackState.getPosition());
            }
            if (playbackState == null) {
                state = 0;
            } else {
                state = playbackState.getState();
            }
            if (durationMs == -1 && positionMs == -1 && state == 0) {
                return;
            }
            Rating rating = metadata != null ? metadata.getRating("android.media.metadata.USER_RATING") : null;
            StepOSMediaMetadataData data = new StepOSMediaMetadataData(pkg, pickMediaText(metadata, "android.media.metadata.TITLE", extras, "android.title"), pickMediaText(metadata, "android.media.metadata.ARTIST", extras, "android.text"), pickMediaText(metadata, "android.media.metadata.ALBUM", extras, "android.subText"), durationMs, positionMs, state, rating != null ? rating.getRatingStyle() : 0, mediaRatingValue(rating), firstActionIconResId(n));
            writeMediaMetadataIfChanged(data);
        } catch (Throwable th) {
        }
    }

    private static void writeMediaMetadataIfChanged(StepOSMediaMetadataData data) {
        synchronized (MEDIA_METADATA_LOCK) {
            if (sLastMediaMetadata == null || !sameExceptPosition(sLastMediaMetadata, data)) {
                sLastMediaMetadata = data;
                data.write();
            }
        }
    }

    private static boolean sameExceptPosition(StepOSMediaMetadataData a, StepOSMediaMetadataData b) {
        return a.mPackageName.equals(b.mPackageName) && a.mTitle.equals(b.mTitle) && a.mArtist.equals(b.mArtist) && a.mAlbum.equals(b.mAlbum) && a.mDurationMs == b.mDurationMs && a.mState == b.mState && a.mRatingStyle == b.mRatingStyle && a.mRatingValue == b.mRatingValue && a.mFirstActionIconResId == b.mFirstActionIconResId;
    }

    private static int firstActionIconResId(Notification notification) {
        Notification.Action[] actions = notification.actions;
        if (actions == null || actions.length == 0) {
            return 0;
        }
        return actionIconResId(actions[0]);
    }

    private static int actionIconResId(Notification.Action action) {
        if (action == null) {
            return 0;
        }
        try {
            Icon icon = action.getIcon();
            if (icon != null && icon.getType() == 2) {
                return icon.getResId();
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    private static String pickMediaText(MediaMetadata metadata, String metaKey, Bundle extras, String extraKey) {
        String value = metadata != null ? metadata.getString(metaKey) : null;
        if (value == null || value.isEmpty()) {
            value = charSeqToString(extras.getCharSequence(extraKey));
        }
        return truncate(value, 128);
    }

    private static int mediaDurationMs(MediaMetadata metadata) {
        if (metadata == null || !metadata.containsKey("android.media.metadata.DURATION")) {
            return -1;
        }
        return clampMediaMs(metadata.getLong("android.media.metadata.DURATION"));
    }

    private static int clampMediaMs(long valueMs) {
        if (valueMs < 0) {
            return -1;
        }
        if (valueMs > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) valueMs;
    }

    private static float mediaRatingValue(Rating rating) {
        if (rating == null || !rating.isRated()) {
            return -1.0f;
        }
        switch (rating.getRatingStyle()) {
            case 1:
                return rating.hasHeart() ? 1.0f : 0.0f;
            case 2:
                return rating.isThumbUp() ? 1.0f : 0.0f;
            case 3:
            case 4:
            case 5:
                return rating.getStarRating();
            case 6:
                return rating.getPercentRating();
            default:
                return -1.0f;
        }
    }

    private static String truncate(String s, int max) {
        return s == null ? "" : s.length() <= max ? s : s.substring(0, max);
    }

    public static void onShareData(Intent intent, ClipData clipData, String callerPkg, String targetPkg) {
        String mimeType;
        ClipData sourceClip;
        String action;
        String extraText;
        String extraSubject;
        int sourceType;
        CharSequence text;
        String mimeType2 = "";
        String extraText2 = "";
        String extraSubject2 = "";
        String[] streamUris = null;
        if (intent != null) {
            String action2 = intent.getAction() != null ? intent.getAction() : "";
            String mimeType3 = intent.getType() != null ? intent.getType() : "";
            sourceClip = intent.getClipData();
            CharSequence text2 = intent.getCharSequenceExtra("android.intent.extra.TEXT");
            if (text2 != null) {
                extraText2 = truncate(text2.toString(), 512);
            }
            CharSequence subj = intent.getCharSequenceExtra("android.intent.extra.SUBJECT");
            if (subj != null) {
                extraSubject2 = truncate(subj.toString(), 512);
            }
            if ("android.intent.action.SEND_MULTIPLE".equals(action2)) {
                ArrayList<Uri> uris = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                if (uris != null && !uris.isEmpty()) {
                    streamUris = new String[uris.size()];
                    for (int i = 0; i < uris.size(); i++) {
                        streamUris[i] = uris.get(i).toString();
                    }
                }
            } else {
                Uri streamUri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                if (streamUri != null) {
                    streamUris = new String[]{streamUri.toString()};
                }
            }
            mimeType = mimeType3;
            action = action2;
            extraText = extraText2;
            extraSubject = extraSubject2;
            sourceType = 0;
        } else if (clipData != null) {
            ClipDescription desc = clipData.getDescription();
            if (desc != null && desc.getMimeTypeCount() > 0) {
                mimeType2 = desc.getMimeType(0) != null ? desc.getMimeType(0) : "";
            }
            if (clipData.getItemCount() > 0) {
                ClipData.Item item = clipData.getItemAt(0);
                if (item != null && (text = item.getText()) != null) {
                    extraText2 = truncate(text.toString(), 512);
                }
                ArrayList<String> uriList = new ArrayList<>();
                for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
                    ClipData.Item ci = clipData.getItemAt(i2);
                    if (ci != null && ci.getUri() != null) {
                        uriList.add(ci.getUri().toString());
                    }
                }
                if (!uriList.isEmpty()) {
                    streamUris = (String[]) uriList.toArray(new String[0]);
                }
            }
            mimeType = mimeType2;
            sourceClip = clipData;
            action = "";
            extraText = extraText2;
            extraSubject = "";
            sourceType = 1;
        } else {
            return;
        }
        String[] finalUris = streamUris != null ? streamUris : new String[0];
        String[] clipItems = expandClipData(sourceClip);
        grantUrisToSubscribers(finalUris);
        new StepOSShareData(sourceType, callerPkg != null ? callerPkg : "", targetPkg != null ? targetPkg : "", action, mimeType, extraText, finalUris, extraSubject, clipItems).write();
    }

    private static String[] expandClipData(ClipData clip) {
        if (clip == null) {
            return new String[0];
        }
        try {
            int count = clip.getItemCount();
            ClipDescription desc = clip.getDescription();
            int mimeCount = desc != null ? desc.getMimeTypeCount() : 0;
            StringBuilder mimeSb = new StringBuilder();
            for (int i = 0; i < mimeCount; i++) {
                if (i > 0) {
                    mimeSb.append(',');
                }
                mimeSb.append(desc.getMimeType(i));
            }
            String mimeCsv = mimeSb.toString();
            String[] out = new String[count];
            int i2 = 0;
            while (i2 < count) {
                ClipData.Item item = clip.getItemAt(i2);
                CharSequence text = item != null ? item.getText() : null;
                CharSequence html = item != null ? item.getHtmlText() : null;
                Uri uri = item != null ? item.getUri() : null;
                String textStr = text != null ? truncate(text.toString(), 512) : "";
                String htmlStr = html != null ? truncate(html.toString(), 512) : "";
                int count2 = count;
                out[i2] = "mime=" + mimeCsv + "; uri=" + (uri != null ? uri.toString() : "") + "; text=" + textStr + "; htmlText=" + htmlStr;
                i2++;
                count = count2;
            }
            return out;
        } catch (Throwable th) {
            return new String[0];
        }
    }

    private static String[] getShareDataSubscriberPkgs(Context context) {
        if (sShareDataSubscriberPkgs == null) {
            synchronized (UserDataCollectors.class) {
                if (sShareDataSubscriberPkgs == null) {
                    sShareDataSubscriberPkgs = context.getResources().getStringArray(17236315);
                }
            }
        }
        return sShareDataSubscriberPkgs;
    }

    private static void grantUrisToSubscribers(String[] uris) {
        Context context;
        String[] subscribers;
        if (uris == null || uris.length == 0 || (context = ActivityThread.currentApplication()) == null || (subscribers = getShareDataSubscriberPkgs(context)) == null || subscribers.length == 0) {
            return;
        }
        for (String pkg : subscribers) {
            if (context.getPackageManager().checkPermission("android.permission.FORCE_PERSISTABLE_URI_PERMISSIONS", pkg) == 0) {
                for (String uriStr : uris) {
                    try {
                        context.grantUriPermission(pkg, Uri.parse(uriStr), 65);
                    } catch (Exception e) {
                        Log.w(TAG, "grantUriPermission failed: pkg=" + pkg + " uri=" + uriStr, e);
                    }
                }
            }
        }
    }

    public static void onMediaFileInsert(int fileType, String uri, String fileName, String filePath, long fileSize, String mimeType, String ownerPackage, long createdTimeMs, boolean isFromMediaScan, String scanCallerPackage) {
        if (!isCollectedMediaType(fileType)) {
            return;
        }
        if (isFromMediaScan && !PKG_DATA_MIGRATION.equals(scanCallerPackage)) {
            return;
        }
        StepOSMediaFileData.MediaFileItem item = new StepOSMediaFileData.MediaFileItem(fileType, truncate(uri, MF_URI_MAX), truncate(fileName, 128), truncate(filePath, 256), fileSize, truncate(mimeType, 64), truncate(ownerPackage, 128), createdTimeMs);
        int itemBytes = utf8Length(item.mSourcePackage) + utf8Length(item.mUri) + utf8Length(item.mFileName) + utf8Length(item.mFilePath) + utf8Length(item.mMimeType);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "onMediaFileInsert: type=" + fileType + " name=" + item.mFileName + " pkg=" + item.mSourcePackage + " scan=" + isFromMediaScan);
        }
        List<StepOSMediaFileData.MediaFileItem> ready = null;
        synchronized (MF_LOCK) {
            boolean wouldOverflow = true;
            if (sMediaFileBatchBytes + itemBytes <= MF_BATCH_BYTE_BUDGET && sMediaFileBatch.size() + 1 <= 10) {
                wouldOverflow = false;
            }
            if (wouldOverflow && !sMediaFileBatch.isEmpty()) {
                ready = detachMediaFileBatchLocked();
            }
            sMediaFileBatch.add(item);
            sMediaFileBatchBytes += itemBytes;
            scheduleMediaFileFlushLocked();
        }
        if (ready != null) {
            writeMediaFileBatch(ready);
        }
    }

    private static boolean isCollectedMediaType(int fileType) {
        return fileType == 1 || fileType == 2 || fileType == 3 || fileType == 6;
    }

    private static int utf8Length(String s) {
        return s.getBytes(StandardCharsets.UTF_8).length;
    }

    private static void scheduleMediaFileFlushLocked() {
        if (sMediaFileFlushScheduled) {
            return;
        }
        sMediaFileFlushScheduled = true;
        BackgroundThread.getHandler().postDelayed(new Runnable() { // from class: android.os.collector.user.UserDataCollectors$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UserDataCollectors.flushMediaFileBatch();
            }
        }, MF_FLUSH_DELAY_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void flushMediaFileBatch() {
        synchronized (MF_LOCK) {
            sMediaFileFlushScheduled = false;
            if (sMediaFileBatch.isEmpty()) {
                return;
            }
            List<StepOSMediaFileData.MediaFileItem> batch = detachMediaFileBatchLocked();
            writeMediaFileBatch(batch);
        }
    }

    private static List<StepOSMediaFileData.MediaFileItem> detachMediaFileBatchLocked() {
        List<StepOSMediaFileData.MediaFileItem> batch = new ArrayList<>(sMediaFileBatch);
        sMediaFileBatch.clear();
        sMediaFileBatchBytes = 0;
        return batch;
    }

    private static void writeMediaFileBatch(final List<StepOSMediaFileData.MediaFileItem> batch) {
        BackgroundThread.getExecutor().execute(new Runnable() { // from class: android.os.collector.user.UserDataCollectors$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                UserDataCollectors.lambda$writeMediaFileBatch$0(batch);
            }
        });
    }

    static /* synthetic */ void lambda$writeMediaFileBatch$0(List batch) {
        try {
            new StepOSMediaFileData(batch.size(), batch).write();
        } catch (Throwable t) {
            Log.e(TAG, "media file batch write failed, size=" + batch.size(), t);
        }
    }
}
