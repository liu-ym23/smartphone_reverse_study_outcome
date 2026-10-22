package com.android.server.media.metrics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.DataSpace;
import android.hardware.tv.mediaquality.ParameterName;
import android.media.MediaMetrics;
import android.media.metrics.EditingEndedEvent;
import android.media.metrics.IMediaMetricsManager;
import android.media.metrics.MediaItemInfo;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.Binder;
import android.os.PersistableBundle;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Size;
import android.util.Slog;
import android.util.StatsEvent;
import android.util.StatsLog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.SystemService;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaMetricsManagerService extends SystemService {
    private static final String AUDIO_MIME_TYPE_PREFIX = "audio/";
    private static final int DURATION_BUCKETS_BELOW_ONE_MINUTE = 8;
    private static final int DURATION_BUCKETS_COUNT = 13;
    private static final MediaItemInfo EMPTY_MEDIA_ITEM_INFO = null;
    private static final String FAILED_TO_GET = "failed_to_get";
    private static final int LOGGING_LEVEL_BLOCKED = 99999;
    private static final int LOGGING_LEVEL_EVERYTHING = 0;
    private static final int LOGGING_LEVEL_NO_UID = 1000;
    private static final String MEDIA_METRICS_MODE = "media_metrics_mode";
    private static final int MEDIA_METRICS_MODE_ALLOWLIST = 3;
    private static final int MEDIA_METRICS_MODE_BLOCKLIST = 2;
    private static final int MEDIA_METRICS_MODE_OFF = 0;
    private static final int MEDIA_METRICS_MODE_ON = 1;
    private static final Pattern PATTERN_KNOWN_EDITING_LIBRARY_NAMES = null;
    private static final String PLAYER_METRICS_APP_ALLOWLIST = "player_metrics_app_allowlist";
    private static final String PLAYER_METRICS_APP_BLOCKLIST = "player_metrics_app_blocklist";
    private static final String PLAYER_METRICS_PER_APP_ATTRIBUTION_ALLOWLIST = "player_metrics_per_app_attribution_allowlist";
    private static final String PLAYER_METRICS_PER_APP_ATTRIBUTION_BLOCKLIST = "player_metrics_per_app_attribution_blocklist";
    private static final String TAG = "MediaMetricsManagerService";
    private static final String VIDEO_MIME_TYPE_PREFIX = "video/";
    private static final String mMetricsId = "metrics.manager";
    private List<String> mAllowlist;
    private List<String> mBlockList;
    private final Context mContext;
    private final Object mLock;
    private Integer mMode;
    private List<String> mNoUidAllowlist;
    private List<String> mNoUidBlocklist;
    private final SecureRandom mSecureRandom;

    private final class BinderService extends IMediaMetricsManager.Stub {
        final /* synthetic */ MediaMetricsManagerService this$0;

        /* synthetic */ BinderService(MediaMetricsManagerService r1, MediaMetricsManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(MediaMetricsManagerService r1) {
            this.this$0 = r1;
        }

        public void reportPlaybackMetrics(String sessionId, PlaybackMetrics metrics, int userId) {
            int level = loggingLevel();
            if (level != MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED) goto L5;
            return;
        L5:
            StatsEvent.Builder r1 = StatsEvent.newBuilder().setAtomId(320);
            if (level != 0) goto L8;
            int r3 = Binder.getCallingUid();
        L9:
            StatsEvent statsEvent = r1.writeInt(r3).writeString(sessionId).writeLong(metrics.getMediaDurationMillis()).writeInt(metrics.getStreamSource()).writeInt(metrics.getStreamType()).writeInt(metrics.getPlaybackType()).writeInt(metrics.getDrmType()).writeInt(metrics.getContentType()).writeString(metrics.getPlayerName()).writeString(metrics.getPlayerVersion()).writeByteArray(new byte[0]).writeInt(metrics.getVideoFramesPlayed()).writeInt(metrics.getVideoFramesDropped()).writeInt(metrics.getAudioUnderrunCount()).writeLong(metrics.getNetworkBytesRead()).writeLong(metrics.getLocalBytesRead()).writeLong(metrics.getNetworkTransferDurationMillis()).writeString(Base64.encodeToString(metrics.getDrmSessionId(), 0)).usePooledBuffer().build();
            StatsLog.write(statsEvent);
            return;
        L8:
            r3 = 0;
            goto L9
        }

        public void reportBundleMetrics(String sessionId, PersistableBundle metrics, int userId) {
            int level = loggingLevel();
            if (level != MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED) goto L5;
            return;
        L5:
            int atomid = metrics.getInt("bundlesession-statsd-atom");
            switch(atomid) {
                case 322: goto L8;
                default: goto L7;
            };
        L7:
            return;
        L8:
            String _sessionId = metrics.getString("playbackstateevent-sessionid");
            int _state = metrics.getInt("playbackstateevent-state", -1);
            long _lifetime = metrics.getLong("playbackstateevent-lifetime", -1);
            if (_sessionId == null) goto L16;
            if (_state < 0) goto L16;
            if (_lifetime < 0) goto L16;
            StatsEvent statsEvent = StatsEvent.newBuilder().setAtomId(322).writeString(_sessionId).writeInt(_state).writeLong(_lifetime).usePooledBuffer().build();
            StatsLog.write(statsEvent);
            return;
        L16:
            Slog.d(MediaMetricsManagerService.TAG, "dropping incomplete data for atom 322: _sessionId: " + _sessionId + " _state: " + _state + " _lifetime: " + _lifetime);
        }

        public void reportPlaybackStateEvent(String sessionId, PlaybackStateEvent event, int userId) {
            int level = loggingLevel();
            if (level != MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED) goto L5;
            return;
        L5:
            StatsEvent statsEvent = StatsEvent.newBuilder().setAtomId(322).writeString(sessionId).writeInt(event.getState()).writeLong(event.getTimeSinceCreatedMillis()).usePooledBuffer().build();
            StatsLog.write(statsEvent);
        }

        private String getSessionIdInternal(int userId) {
            byte[] byteId = new byte[12];
            MediaMetricsManagerService.m5798$$Nest$fgetmSecureRandom(this.this$0).nextBytes(byteId);
            String id = Base64.encodeToString(byteId, 11);
            new MediaMetrics.Item(MediaMetricsManagerService.mMetricsId).set(MediaMetrics.Property.EVENT, "create").set(MediaMetrics.Property.LOG_SESSION_ID, id).record();
            return id;
        }

        public void releaseSessionId(String sessionId, int userId) {
            Slog.v(MediaMetricsManagerService.TAG, "Releasing sessionId " + sessionId + " for userId " + userId + " [NOP]");
        }

        public String getPlaybackSessionId(int userId) {
            return getSessionIdInternal(userId);
        }

        public String getRecordingSessionId(int userId) {
            return getSessionIdInternal(userId);
        }

        public String getTranscodingSessionId(int userId) {
            return getSessionIdInternal(userId);
        }

        public String getEditingSessionId(int userId) {
            return getSessionIdInternal(userId);
        }

        public String getBundleSessionId(int userId) {
            return getSessionIdInternal(userId);
        }

        public void reportPlaybackErrorEvent(String sessionId, PlaybackErrorEvent event, int userId) {
            int level = loggingLevel();
            if (level != MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED) goto L5;
            return;
        L5:
            StatsEvent statsEvent = StatsEvent.newBuilder().setAtomId(323).writeString(sessionId).writeString(event.getExceptionStack()).writeInt(event.getErrorCode()).writeInt(event.getSubErrorCode()).writeLong(event.getTimeSinceCreatedMillis()).usePooledBuffer().build();
            StatsLog.write(statsEvent);
        }

        public void reportNetworkEvent(String sessionId, NetworkEvent event, int userId) {
            int level = loggingLevel();
            if (level != MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED) goto L5;
            return;
        L5:
            StatsEvent statsEvent = StatsEvent.newBuilder().setAtomId(321).writeString(sessionId).writeInt(event.getNetworkType()).writeLong(event.getTimeSinceCreatedMillis()).usePooledBuffer().build();
            StatsLog.write(statsEvent);
        }

        public void reportTrackChangeEvent(String sessionId, TrackChangeEvent event, int userId) {
            int level = loggingLevel();
            if (level != MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED) goto L5;
            return;
        L5:
            StatsEvent statsEvent = StatsEvent.newBuilder().setAtomId(FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ACTIVE_DEVICE_ADMIN).writeString(sessionId).writeInt(event.getTrackState()).writeInt(event.getTrackChangeReason()).writeString(event.getContainerMimeType()).writeString(event.getSampleMimeType()).writeString(event.getCodecName()).writeInt(event.getBitrate()).writeLong(event.getTimeSinceCreatedMillis()).writeInt(event.getTrackType()).writeString(event.getLanguage()).writeString(event.getLanguageRegion()).writeInt(event.getChannelCount()).writeInt(event.getAudioSampleRate()).writeInt(event.getWidth()).writeInt(event.getHeight()).writeFloat(event.getVideoFrameRate()).usePooledBuffer().build();
            StatsLog.write(statsEvent);
        }

        /* JADX WARN: Failed to apply debug info
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:79)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 8 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v0 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 6 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v0 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v38 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v38 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v42 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v42 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v46 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v46 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v50 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v50 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v54 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v54 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v58 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v58 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v62 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v62 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r3v66 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v66 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r45v0 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r45v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r47v0 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r47v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /* JADX WARN: Failed to calculate best type for var: r49v0 ??
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r49v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 7 more
         */
        /*  JADX ERROR: Types fix failed
            jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v0 ??, new type: long
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
            	... 5 more
            */
        public void reportEditingEndedEvent(java.lang.String r52, android.media.metrics.EditingEndedEvent r53, int r54) {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE (r3v0 ?? I:long) = 
                  (r1v6 'inputMediaItemInfo' android.media.metrics.MediaItemInfo A[D('inputMediaItemInfo' android.media.metrics.MediaItemInfo)])
                 VIRTUAL call: android.media.metrics.MediaItemInfo.getDataTypes():long A[DECLARE_VAR] (LINE:377) in method: com.android.server.media.metrics.MediaMetricsManagerService.BinderService.reportEditingEndedEvent(java.lang.String, android.media.metrics.EditingEndedEvent, int):void, file: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
                	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
                	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
                	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
                	... 48 more
                */
            /*
                Method dump skipped, instruction units count: 1139
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.media.metrics.MediaMetricsManagerService.BinderService.reportEditingEndedEvent(java.lang.String, android.media.metrics.EditingEndedEvent, int):void");
        }

        private int loggingLevel() {
            Object r0 = MediaMetricsManagerService.m5794$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int uid = Binder.getCallingUid();     // Catch: Throwable -> L9
            if (MediaMetricsManagerService.m5795$$Nest$fgetmMode(this.this$0) != null) goto L15;
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            MediaMetricsManagerService.m5801$$Nest$fputmMode(this.this$0, Integer.valueOf(DeviceConfig.getInt("media", MediaMetricsManagerService.MEDIA_METRICS_MODE, 2)));     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L9
            goto L15
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L15:
            if (MediaMetricsManagerService.m5795$$Nest$fgetmMode(this.this$0).intValue() != 1) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return 0;
        L18:
            int r2 = MediaMetricsManagerService.m5795$$Nest$fgetmMode(this.this$0).intValue();     // Catch: Throwable -> L9
            int r4 = MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
            if (r2 != 0) goto L23;
            Slog.v(MediaMetricsManagerService.TAG, "Logging level blocked: MEDIA_METRICS_MODE_OFF");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L23:
            PackageManager pm = this.this$0.getContext().getPackageManager();     // Catch: Throwable -> L9
            String[] packages = pm.getPackagesForUid(uid);     // Catch: Throwable -> L9
            if (packages == null) goto L89;
            if (packages.length == 0) goto L89;
            if (MediaMetricsManagerService.m5795$$Nest$fgetmMode(this.this$0).intValue() != 2) goto L57;
            if (MediaMetricsManagerService.m5793$$Nest$fgetmBlockList(this.this$0) != null) goto L37;
            MediaMetricsManagerService.m5800$$Nest$fputmBlockList(this.this$0, MediaMetricsManagerService.m5804$$Nest$mgetListLocked(this.this$0, MediaMetricsManagerService.PLAYER_METRICS_APP_BLOCKLIST));     // Catch: Throwable -> L9
            if (MediaMetricsManagerService.m5793$$Nest$fgetmBlockList(this.this$0) != null) goto L37;
            Slog.v(MediaMetricsManagerService.TAG, "Logging level blocked: Failed to get PLAYER_METRICS_APP_BLOCKLIST.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L37:
            Integer level = loggingLevelInternal(packages, MediaMetricsManagerService.m5793$$Nest$fgetmBlockList(this.this$0), MediaMetricsManagerService.PLAYER_METRICS_APP_BLOCKLIST);     // Catch: Throwable -> L9
            if (level == null) goto L43;
            int r5 = level.intValue();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r5;
        L43:
            if (MediaMetricsManagerService.m5797$$Nest$fgetmNoUidBlocklist(this.this$0) != null) goto L49;
            MediaMetricsManagerService.m5803$$Nest$fputmNoUidBlocklist(this.this$0, MediaMetricsManagerService.m5804$$Nest$mgetListLocked(this.this$0, MediaMetricsManagerService.PLAYER_METRICS_PER_APP_ATTRIBUTION_BLOCKLIST));     // Catch: Throwable -> L9
            if (MediaMetricsManagerService.m5797$$Nest$fgetmNoUidBlocklist(this.this$0) != null) goto L49;
            Slog.v(MediaMetricsManagerService.TAG, "Logging level blocked: Failed to get PLAYER_METRICS_PER_APP_ATTRIBUTION_BLOCKLIST.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L49:
            Integer level2 = loggingLevelInternal(packages, MediaMetricsManagerService.m5797$$Nest$fgetmNoUidBlocklist(this.this$0), MediaMetricsManagerService.PLAYER_METRICS_PER_APP_ATTRIBUTION_BLOCKLIST);     // Catch: Throwable -> L9
            if (level2 == null) goto L54;
            int r3 = level2.intValue();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L54:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return 0;
        L57:
            if (MediaMetricsManagerService.m5795$$Nest$fgetmMode(this.this$0).intValue() == 3) goto L59;
            monitor-exit(r0);     // Catch: Throwable -> L9
            Slog.v(MediaMetricsManagerService.TAG, "Logging level blocked: Blocked by default.");
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L59:
            if (MediaMetricsManagerService.m5796$$Nest$fgetmNoUidAllowlist(this.this$0) != null) goto L65;
            MediaMetricsManagerService.m5802$$Nest$fputmNoUidAllowlist(this.this$0, MediaMetricsManagerService.m5804$$Nest$mgetListLocked(this.this$0, MediaMetricsManagerService.PLAYER_METRICS_PER_APP_ATTRIBUTION_ALLOWLIST));     // Catch: Throwable -> L9
            if (MediaMetricsManagerService.m5796$$Nest$fgetmNoUidAllowlist(this.this$0) != null) goto L65;
            Slog.v(MediaMetricsManagerService.TAG, "Logging level blocked: Failed to get PLAYER_METRICS_PER_APP_ATTRIBUTION_ALLOWLIST.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L65:
            Integer level3 = loggingLevelInternal(packages, MediaMetricsManagerService.m5796$$Nest$fgetmNoUidAllowlist(this.this$0), MediaMetricsManagerService.PLAYER_METRICS_PER_APP_ATTRIBUTION_ALLOWLIST);     // Catch: Throwable -> L9
            if (level3 == null) goto L71;
            int r6 = level3.intValue();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r6;
        L71:
            if (MediaMetricsManagerService.m5792$$Nest$fgetmAllowlist(this.this$0) != null) goto L77;
            MediaMetricsManagerService.m5799$$Nest$fputmAllowlist(this.this$0, MediaMetricsManagerService.m5804$$Nest$mgetListLocked(this.this$0, MediaMetricsManagerService.PLAYER_METRICS_APP_ALLOWLIST));     // Catch: Throwable -> L9
            if (MediaMetricsManagerService.m5792$$Nest$fgetmAllowlist(this.this$0) != null) goto L77;
            Slog.v(MediaMetricsManagerService.TAG, "Logging level blocked: Failed to get PLAYER_METRICS_APP_ALLOWLIST.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L77:
            Integer level4 = loggingLevelInternal(packages, MediaMetricsManagerService.m5792$$Nest$fgetmAllowlist(this.this$0), MediaMetricsManagerService.PLAYER_METRICS_APP_ALLOWLIST);     // Catch: Throwable -> L9
            if (level4 == null) goto L82;
            int r7 = level4.intValue();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r7;
        L82:
            Slog.v(MediaMetricsManagerService.TAG, "Logging level blocked: Not detected in any allowlist.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L89:
            Slog.d(MediaMetricsManagerService.TAG, "empty package from uid " + uid);     // Catch: Throwable -> L9
            if (MediaMetricsManagerService.m5795$$Nest$fgetmMode(this.this$0).intValue() != 2) goto L93;
            r4 = 1000;
        L93:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r4;
        L9:
            th = move-exception;
            throw th;
        }

        private Integer loggingLevelInternal(String[] packages, List<String> cached, String listName) {
            if (inList(packages, cached) == true) goto L5;
            return null;
        L5:
            return Integer.valueOf(listNameToLoggingLevel(listName));
        }

        private boolean inList(String[] packages, List<String> arr) {
            int r0 = packages.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            String p = packages[r2];
            Iterator<String> r4 = arr.iterator();
        L6:
            if (r4.hasNext() == false) goto L12;
            String element = r4.next();
            if (p.equals(element) == false) goto L6;
            return true;
        L12:
            r2 = r2 + 1;
            goto L3
        L13:
            return false;
        }

        private int listNameToLoggingLevel(String listName) {
            switch(listName.hashCode()) {
                case -1894232751: goto L15;
                case -1289480849: goto L12;
                case -789056333: goto L9;
                case 1900310029: goto L6;
                default: goto L17;
            };
        L17:
            byte r0 = -1;
        L19:
            switch(r0) {
                case 0: goto L24;
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L21;
                default: goto L20;
            };
        L20:
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L21:
            return 1000;
        L23:
            return 0;
        L24:
            return MediaMetricsManagerService.LOGGING_LEVEL_BLOCKED;
        L6:
            if (listName.equals(MediaMetricsManagerService.PLAYER_METRICS_PER_APP_ATTRIBUTION_ALLOWLIST) == false) goto L17;
            r0 = 2;
            goto L19
        L9:
            if (listName.equals(MediaMetricsManagerService.PLAYER_METRICS_APP_BLOCKLIST) == false) goto L17;
            r0 = 0;
            goto L19
        L12:
            if (listName.equals(MediaMetricsManagerService.PLAYER_METRICS_APP_ALLOWLIST) == false) goto L17;
            r0 = 1;
            goto L19
        L15:
            if (listName.equals(MediaMetricsManagerService.PLAYER_METRICS_PER_APP_ATTRIBUTION_BLOCKLIST) == false) goto L17;
            r0 = 3;
            goto L19
        }
    }

    public static /* synthetic */ void $r8$lambda$3zfSFqjd2XGt_8BvNvc_mTaVjig(MediaMetricsManagerService r0, DeviceConfig.Properties r1) {
        r0.updateConfigs(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllowlist, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5792$$Nest$fgetmAllowlist(MediaMetricsManagerService r0) {
        return r0.mAllowlist;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBlockList, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5793$$Nest$fgetmBlockList(MediaMetricsManagerService r0) {
        return r0.mBlockList;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5794$$Nest$fgetmLock(MediaMetricsManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ Integer m5795$$Nest$fgetmMode(MediaMetricsManagerService r0) {
        return r0.mMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNoUidAllowlist, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5796$$Nest$fgetmNoUidAllowlist(MediaMetricsManagerService r0) {
        return r0.mNoUidAllowlist;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNoUidBlocklist, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5797$$Nest$fgetmNoUidBlocklist(MediaMetricsManagerService r0) {
        return r0.mNoUidBlocklist;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecureRandom, reason: not valid java name */
    static /* bridge */ /* synthetic */ SecureRandom m5798$$Nest$fgetmSecureRandom(MediaMetricsManagerService r0) {
        return r0.mSecureRandom;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAllowlist, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5799$$Nest$fputmAllowlist(MediaMetricsManagerService r0, List r1) {
        r0.mAllowlist = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBlockList, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5800$$Nest$fputmBlockList(MediaMetricsManagerService r0, List r1) {
        r0.mBlockList = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5801$$Nest$fputmMode(MediaMetricsManagerService r0, Integer r1) {
        r0.mMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNoUidAllowlist, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5802$$Nest$fputmNoUidAllowlist(MediaMetricsManagerService r0, List r1) {
        r0.mNoUidAllowlist = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNoUidBlocklist, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5803$$Nest$fputmNoUidBlocklist(MediaMetricsManagerService r0, List r1) {
        r0.mNoUidBlocklist = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5804$$Nest$mgetListLocked(MediaMetricsManagerService r0, String r1) {
        return r0.getListLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetEMPTY_MEDIA_ITEM_INFO, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaItemInfo m5805$$Nest$sfgetEMPTY_MEDIA_ITEM_INFO() {
        return EMPTY_MEDIA_ITEM_INFO;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetBucketedDurationMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5806$$Nest$smgetBucketedDurationMillis(long r0) {
        return getBucketedDurationMillis(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetCodecEnum, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5807$$Nest$smgetCodecEnum(String r0) {
        return getCodecEnum(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetFilteredAudioSampleRateHz, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5808$$Nest$smgetFilteredAudioSampleRateHz(int r0) {
        return getFilteredAudioSampleRateHz(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetFilteredFirstMimeType, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5809$$Nest$smgetFilteredFirstMimeType(List r0, String r1) {
        return getFilteredFirstMimeType(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetFilteredLibraryName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5810$$Nest$smgetFilteredLibraryName(String r0) {
        return getFilteredLibraryName(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetFilteredMimeType, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5811$$Nest$smgetFilteredMimeType(String r0) {
        return getFilteredMimeType(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetThroughputFps, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5812$$Nest$smgetThroughputFps(EditingEndedEvent r0) {
        return getThroughputFps(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetVideoFrameRateEnum, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5813$$Nest$smgetVideoFrameRateEnum(float r0) {
        return getVideoFrameRateEnum(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetVideoHdrFormatEnum, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5814$$Nest$smgetVideoHdrFormatEnum(int r0, String r1) {
        return getVideoHdrFormatEnum(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetVideoResolutionAspectRatioEnum, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5815$$Nest$smgetVideoResolutionAspectRatioEnum(Size r0) {
        return getVideoResolutionAspectRatioEnum(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetVideoResolutionEnum, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5816$$Nest$smgetVideoResolutionEnum(Size r0) {
        return getVideoResolutionEnum(r0);
    }

    static {
        EMPTY_MEDIA_ITEM_INFO = new MediaItemInfo.Builder().build();
        PATTERN_KNOWN_EDITING_LIBRARY_NAMES = Pattern.compile("androidx\\.media3:media3-(transformer|muxer):[\\d.]+(-(alpha|beta|rc)\\d\\d)?");
    }

    public MediaMetricsManagerService(Context context) {
        super(context);
        this.mMode = null;
        this.mAllowlist = null;
        this.mNoUidAllowlist = null;
        this.mBlockList = null;
        this.mNoUidBlocklist = null;
        this.mLock = new Object();
        this.mContext = context;
        this.mSecureRandom = new SecureRandom();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("media_metrics", new BinderService(this, null));
        DeviceConfig.addOnPropertiesChangedListener("media", this.mContext.getMainExecutor(), new MediaMetricsManagerService$$ExternalSyntheticLambda0(this));
    }

    private void updateConfigs(DeviceConfig.Properties properties) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMode = Integer.valueOf(properties.getInt(MEDIA_METRICS_MODE, 2));     // Catch: Throwable -> L9
        List<String> newList = getListLocked(PLAYER_METRICS_APP_ALLOWLIST);     // Catch: Throwable -> L9
        if (newList != null) goto L11;
        if (this.mMode.intValue() != 3) goto L11;
    L12:
        List<String> newList2 = getListLocked(PLAYER_METRICS_PER_APP_ATTRIBUTION_ALLOWLIST);     // Catch: Throwable -> L9
        if (newList2 == null) goto L15;
    L16:
        this.mNoUidAllowlist = newList2;     // Catch: Throwable -> L9
    L17:
        List<String> newList3 = getListLocked(PLAYER_METRICS_APP_BLOCKLIST);     // Catch: Throwable -> L9
        if (newList3 == null) goto L20;
    L21:
        this.mBlockList = newList3;     // Catch: Throwable -> L9
    L22:
        List<String> newList4 = getListLocked(PLAYER_METRICS_PER_APP_ATTRIBUTION_BLOCKLIST);     // Catch: Throwable -> L9
        if (newList4 == null) goto L25;
    L26:
        this.mNoUidBlocklist = newList4;     // Catch: Throwable -> L9
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L25:
        if (this.mMode.intValue() == 2) goto L27;
    L20:
        if (this.mMode.intValue() == 2) goto L22;
    L15:
        if (this.mMode.intValue() == 3) goto L17;
    L11:
        this.mAllowlist = newList;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private List<String> getListLocked(String listName) {
        long identity = Binder.clearCallingIdentity();
        String listString = DeviceConfig.getString("media", listName, FAILED_TO_GET);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        if (listString.equals(FAILED_TO_GET) == false) goto L8;
        Slog.d(TAG, "failed to get " + listName + " from DeviceConfig");
        return null;
    L8:
        String[] pkgArr = listString.split(",");
        return Arrays.asList(pkgArr);
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static String getFilteredLibraryName(String libraryName) {
        if (TextUtils.isEmpty(libraryName) == false) goto L6;
        return "";
    L6:
        if (PATTERN_KNOWN_EDITING_LIBRARY_NAMES.matcher(libraryName).matches() == true) goto L8;
        return "";
    L8:
        return libraryName;
    }

    private static int getThroughputFps(EditingEndedEvent event) {
        MediaItemInfo outputMediaItemInfo = event.getOutputMediaItemInfo();
        if (outputMediaItemInfo != null) goto L5;
        return -1;
    L5:
        long videoSampleCount = outputMediaItemInfo.getVideoSampleCount();
        if (videoSampleCount != (-1)) goto L8;
        return -1;
    L8:
        long elapsedTimeMs = event.getTimeSinceCreatedMillis();
        if (elapsedTimeMs != (-1)) goto L12;
        return -1;
    L12:
        return (int) Math.min(2147483647L, Math.round((videoSampleCount * 1000.0d) / elapsedTimeMs));
    }

    private static long getBucketedDurationMillis(long durationMillis) {
        if (durationMillis != (-1)) goto L5;
    L9:
        return -1;
    L5:
        if (durationMillis <= 0) goto L9;
        int bucketIndex = (int) Math.floor((Math.log((1 + durationMillis) / 60000.0d) / Math.log(2.0d)) + 8.0d);
        return (long) Math.ceil(Math.pow(2.0d, Math.min(13, Math.max(0, bucketIndex)) - 8) * 60000.0d);
    }

    private static String getFilteredFirstMimeType(List<String> mimeTypes, String prefix) {
        int size = mimeTypes.size();
        int i = 0;
    L3:
        if (i >= size) goto L9;
        String mimeType = mimeTypes.get(i);
        if (mimeType.startsWith(prefix) == true) goto L7;
        i = i + 1;
        goto L3
    L7:
        return getFilteredMimeType(mimeType);
    L9:
        return "";
    }

    private static String getFilteredMimeType(String mimeType) {
        if (TextUtils.isEmpty(mimeType) == false) goto L6;
        return "";
    L6:
        switch(mimeType.hashCode()) {
            case -2123537834: goto L132;
            case -1851077871: goto L129;
            case -1664118616: goto L126;
            case -1662735862: goto L123;
            case -1662541442: goto L120;
            case -1662384007: goto L117;
            case -1662382439: goto L114;
            case -1662095187: goto L111;
            case -1248337486: goto L108;
            case -1095064472: goto L105;
            case -1003765268: goto L102;
            case -979127466: goto L99;
            case -432837260: goto L96;
            case -432837259: goto L93;
            case -387023398: goto L90;
            case -275430368: goto L87;
            case -156749520: goto L84;
            case -53558318: goto L81;
            case -43467528: goto L78;
            case 13915911: goto L75;
            case 64194685: goto L72;
            case 187078296: goto L69;
            case 187078886: goto L66;
            case 187090232: goto L63;
            case 187091926: goto L60;
            case 187094639: goto L57;
            case 187099443: goto L54;
            case 1187890754: goto L51;
            case 1331836730: goto L48;
            case 1331848029: goto L45;
            case 1331852436: goto L42;
            case 1504578661: goto L39;
            case 1504619009: goto L36;
            case 1504824762: goto L33;
            case 1504831518: goto L30;
            case 1504891608: goto L27;
            case 1505118770: goto L24;
            case 1505942594: goto L21;
            case 1556697186: goto L18;
            case 1599127256: goto L15;
            case 1599127257: goto L12;
            case 2039520277: goto L9;
            default: goto L134;
        };
    L134:
        byte r0 = -1;
    L135:
        switch(r0) {
            case 0: goto L138;
            case 1: goto L138;
            case 2: goto L138;
            case 3: goto L138;
            case 4: goto L138;
            case 5: goto L138;
            case 6: goto L138;
            case 7: goto L138;
            case 8: goto L138;
            case 9: goto L138;
            case 10: goto L138;
            case 11: goto L138;
            case 12: goto L138;
            case 13: goto L138;
            case 14: goto L138;
            case 15: goto L138;
            case 16: goto L138;
            case 17: goto L138;
            case 18: goto L138;
            case 19: goto L138;
            case 20: goto L138;
            case 21: goto L138;
            case 22: goto L138;
            case 23: goto L138;
            case 24: goto L138;
            case 25: goto L138;
            case 26: goto L138;
            case 27: goto L138;
            case 28: goto L138;
            case 29: goto L138;
            case 30: goto L138;
            case 31: goto L138;
            case 32: goto L138;
            case 33: goto L138;
            case 34: goto L138;
            case 35: goto L138;
            case 36: goto L138;
            case 37: goto L138;
            case 38: goto L138;
            case 39: goto L138;
            case 40: goto L138;
            case 41: goto L138;
            default: goto L139;
        };
    L139:
        return "";
    L138:
        return mimeType;
    L9:
        if (mimeType.equals("video/x-matroska") == false) goto L134;
        r0 = 1;
        goto L135
    L12:
        if (mimeType.equals("video/x-vnd.on2.vp9") == false) goto L134;
        r0 = 7;
        goto L135
    L15:
        if (mimeType.equals("video/x-vnd.on2.vp8") == false) goto L134;
        r0 = 6;
        goto L135
    L18:
        if (mimeType.equals("audio/true-hd") == false) goto L134;
        r0 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L135
    L21:
        if (mimeType.equals("audio/vnd.dts.hd") == false) goto L134;
        r0 = ParameterName.GAMUT_MAPPING;
        goto L135
    L24:
        if (mimeType.equals("audio/webm") == false) goto L134;
        r0 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L135
    L27:
        if (mimeType.equals("audio/opus") == false) goto L134;
        r0 = ParameterName.LOW_LATENCY;
        goto L135
    L30:
        if (mimeType.equals("audio/mpeg") == false) goto L134;
        r0 = ParameterName.FILM_MODE;
        goto L135
    L33:
        if (mimeType.equals("audio/midi") == false) goto L134;
        r0 = 34;
        goto L135
    L36:
        if (mimeType.equals("audio/flac") == false) goto L134;
        r0 = ParameterName.VRR;
        goto L135
    L39:
        if (mimeType.equals("audio/eac3") == false) goto L134;
        r0 = ParameterName.COLOR_TEMPERATURE;
        goto L135
    L42:
        if (mimeType.equals("video/raw") == false) goto L134;
        r0 = 14;
        goto L135
    L45:
        if (mimeType.equals("video/mp4") == false) goto L134;
        r0 = 0;
        goto L135
    L48:
        if (mimeType.equals("video/avc") == false) goto L134;
        r0 = 4;
        goto L135
    L51:
        if (mimeType.equals("video/mp4v-es") == false) goto L134;
        r0 = 10;
        goto L135
    L54:
        if (mimeType.equals("audio/wav") == false) goto L134;
        r0 = 33;
        goto L135
    L57:
        if (mimeType.equals("audio/raw") == false) goto L134;
        r0 = 35;
        goto L135
    L60:
        if (mimeType.equals("audio/ogg") == false) goto L134;
        r0 = ParameterName.CVRR;
        goto L135
    L63:
        if (mimeType.equals("audio/mp4") == false) goto L134;
        r0 = 15;
        goto L135
    L66:
        if (mimeType.equals("audio/av4") == false) goto L134;
        r0 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L135
    L69:
        if (mimeType.equals("audio/ac3") == false) goto L134;
        r0 = ParameterName.COLOR_TUNE;
        goto L135
    L72:
        if (mimeType.equals("application/dash+xml") == false) goto L134;
        r0 = ParameterName.COLOR_TEMPERATURE_BLUE_GAIN;
        goto L135
    L75:
        if (mimeType.equals("video/x-flv") == false) goto L134;
        r0 = 12;
        goto L135
    L78:
        if (mimeType.equals("application/webm") == false) goto L134;
        r0 = 37;
        goto L135
    L81:
        if (mimeType.equals("audio/mp4a-latm") == false) goto L134;
        r0 = 16;
        goto L135
    L84:
        if (mimeType.equals("application/vnd.ms-sstr+xml") == false) goto L134;
        r0 = 41;
        goto L135
    L87:
        if (mimeType.equals("application/x-matroska") == false) goto L134;
        r0 = ParameterName.COLOR_TEMPERATURE_GREEN_GAIN;
        goto L135
    L90:
        if (mimeType.equals("audio/x-matroska") == false) goto L134;
        r0 = ParameterName.DE_CONTOUR;
        goto L135
    L93:
        if (mimeType.equals("audio/mpeg-L2") == false) goto L134;
        r0 = ParameterName.BLUE_STRETCH;
        goto L135
    L96:
        if (mimeType.equals("audio/mpeg-L1") == false) goto L134;
        r0 = ParameterName.BLACK_STRETCH;
        goto L135
    L99:
        if (mimeType.equals("application/x-mpegURL") == false) goto L134;
        r0 = ParameterName.COLOR_TEMPERATURE_RED_OFFSET;
        goto L135
    L102:
        if (mimeType.equals("audio/vorbis") == false) goto L134;
        r0 = ParameterName.PC_MODE;
        goto L135
    L105:
        if (mimeType.equals("audio/vnd.dts") == false) goto L134;
        r0 = ParameterName.LEVEL_RANGE;
        goto L135
    L108:
        if (mimeType.equals("application/mp4") == false) goto L134;
        r0 = 36;
        goto L135
    L111:
        if (mimeType.equals("video/webm") == false) goto L134;
        r0 = 2;
        goto L135
    L114:
        if (mimeType.equals("video/mpeg") == false) goto L134;
        r0 = 11;
        goto L135
    L117:
        if (mimeType.equals("video/mp2t") == false) goto L134;
        r0 = 9;
        goto L135
    L120:
        if (mimeType.equals("video/hevc") == false) goto L134;
        r0 = 5;
        goto L135
    L123:
        if (mimeType.equals("video/av01") == false) goto L134;
        r0 = 8;
        goto L135
    L126:
        if (mimeType.equals("video/3gpp") == false) goto L134;
        r0 = 3;
        goto L135
    L129:
        if (mimeType.equals("video/dolby-vision") == false) goto L134;
        r0 = 13;
        goto L135
    L132:
        if (mimeType.equals("audio/eac3-joc") == false) goto L134;
        r0 = ParameterName.GLOBE_DIMMING;
        goto L135
    }

    private static int getCodecEnum(String mimeType) {
        if (TextUtils.isEmpty(mimeType) == false) goto L6;
        return 0;
    L6:
        switch(mimeType.hashCode()) {
            case -1662735862: goto L21;
            case -1662541442: goto L18;
            case 1331836730: goto L15;
            case 1599127256: goto L12;
            case 1599127257: goto L9;
            default: goto L23;
        };
    L23:
        byte r0 = -1;
    L24:
        switch(r0) {
            case 0: goto L31;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L26;
            default: goto L36;
        };
    L26:
        return 5;
    L36:
        return 0;
    L33:
        return 4;
    L34:
        return 3;
    L35:
        return 2;
    L31:
        return 1;
    L9:
        if (mimeType.equals("video/x-vnd.on2.vp9") == false) goto L23;
        r0 = 3;
        goto L24
    L12:
        if (mimeType.equals("video/x-vnd.on2.vp8") == false) goto L23;
        r0 = 2;
        goto L24
    L15:
        if (mimeType.equals("video/avc") == false) goto L23;
        r0 = 0;
        goto L24
    L18:
        if (mimeType.equals("video/hevc") == false) goto L23;
        r0 = 1;
        goto L24
    L21:
        if (mimeType.equals("video/av01") == false) goto L23;
        r0 = 4;
        goto L24
    }

    private static int getFilteredAudioSampleRateHz(int sampleRateHz) {
        switch(sampleRateHz) {
            case 8000: goto L5;
            case 11025: goto L5;
            case 16000: goto L5;
            case 22050: goto L5;
            case 44100: goto L5;
            case 48000: goto L5;
            case 96000: goto L5;
            case 192000: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return sampleRateHz;
    }

    private static int getVideoResolutionEnum(Size size) {
        int width = size.getWidth();
        int height = size.getHeight();
        if (width != 352) goto L8;
        if (height != 640) goto L8;
        return 228;
    L8:
        if (width != 360) goto L13;
        if (height != 640) goto L13;
        return 233;
    L13:
        if (width != 480) goto L17;
        if (height != 640) goto L17;
        return 311;
    L17:
        if (width != 480) goto L23;
        if (height != 854) goto L23;
        return 414;
    L23:
        if (width != 540) goto L29;
        if (height != 960) goto L29;
        return 524;
    L29:
        if (width != 576) goto L35;
        if (height != 1024) goto L35;
        return FrameworkStatsLog.MEDIA_CODEC_RENDERED__RESOLUTION__RESOLUTION_576X1024;
    L35:
        if (width != 1280) goto L41;
        if (height != 720) goto L41;
        return 931;
    L41:
        if (width != 1920) goto L47;
        if (height != 1080) goto L47;
        return FrameworkStatsLog.MEDIA_CODEC_RENDERED__RESOLUTION__RESOLUTION_1080P_FHD;
    L47:
        if (width != 1440) goto L53;
        if (height != 2560) goto L53;
        return FrameworkStatsLog.MEDIA_CODEC_RENDERED__RESOLUTION__RESOLUTION_1440X2560;
    L53:
        if (width != 3840) goto L59;
        if (height != 2160) goto L59;
        return FrameworkStatsLog.MEDIA_CODEC_RENDERED__RESOLUTION__RESOLUTION_4K_UHD;
    L59:
        if (width == 7680) goto L61;
        return 0;
    L61:
        if (height != 4320) goto L66;
        return FrameworkStatsLog.MEDIA_CODEC_RENDERED__RESOLUTION__RESOLUTION_8K_UHD;
    L66:
        return 0;
    }

    private static int getVideoResolutionAspectRatioEnum(Size size) {
        int width = size.getWidth();
        int height = size.getHeight();
        if (width <= 0) goto L14;
        if (height <= 0) goto L16;
        if (width >= height) goto L9;
        return 3;
    L9:
        if (height >= width) goto L12;
        return 2;
    L12:
        return 1;
    L16:
        return 0;
    L14:
        return 0;
    }

    private static int getVideoHdrFormatEnum(int dataSpace, String mimeType) {
        if (dataSpace != 0) goto L6;
        return 0;
    L6:
        if (mimeType.equals("video/dolby-vision") == false) goto L9;
        return 5;
    L9:
        int standard = DataSpace.getStandard(dataSpace);
        int transfer = DataSpace.getTransfer(dataSpace);
        if (standard == 393216) goto L12;
    L15:
        if (standard == 393216) goto L17;
        return 1;
    L17:
        if (transfer != 29360128) goto L22;
        return 3;
    L22:
        return 1;
    L12:
        if (transfer != 33554432) goto L15;
        return 2;
    }

    private static int getVideoFrameRateEnum(float frameRate) {
        int frameRateInt = Math.round(frameRate);
        switch(frameRateInt) {
            case 24: goto L13;
            case 25: goto L12;
            case 30: goto L11;
            case 50: goto L10;
            case 60: goto L9;
            case 120: goto L8;
            case 240: goto L7;
            case 480: goto L6;
            case 960: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 96000;
    L6:
        return 48000;
    L7:
        return 24000;
    L8:
        return 12000;
    L9:
        return 6000;
    L10:
        return 5000;
    L11:
        return 3000;
    L12:
        return 2500;
    L13:
        return 2400;
    }
}
