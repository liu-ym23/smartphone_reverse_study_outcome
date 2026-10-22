package com.stepos.ailauncher.container.wallpaper;

import La.D;
import Y8.t;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.provider.c;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bQ\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0016\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ=\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019¢\u0006\u0004\b#\u0010!J%\u0010'\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0019¢\u0006\u0004\b'\u0010(J-\u0010-\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\b¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0019¢\u0006\u0004\b0\u0010!J%\u00102\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0019¢\u0006\u0004\b2\u00103J\u001d\u00105\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019¢\u0006\u0004\b5\u00106J5\u00109\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0019¢\u0006\u0004\b9\u0010:J%\u0010;\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0019¢\u0006\u0004\b=\u0010>J\u001d\u0010A\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0004¢\u0006\u0004\bA\u0010BJ\u0015\u0010C\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0019¢\u0006\u0004\bC\u0010!J\u001d\u0010F\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0004\bF\u0010GJ\u001d\u0010I\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u0019¢\u0006\u0004\bI\u00106J\u0015\u0010J\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0004\bJ\u0010KJ\u001d\u0010N\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u00152\u0006\u0010M\u001a\u00020\u0019¢\u0006\u0004\bN\u0010OJ'\u0010Q\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u00192\b\b\u0002\u0010P\u001a\u00020\u0019¢\u0006\u0004\bQ\u0010(J\u0017\u0010S\u001a\u00020\u00192\b\u0010R\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bS\u0010TJ\u001d\u0010V\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u0019¢\u0006\u0004\bV\u00106J\u001d\u0010X\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u0019¢\u0006\u0004\bX\u00106J/\u0010Z\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\b\b\u0002\u0010Y\u001a\u00020\u0019¢\u0006\u0004\bZ\u0010[J\u001d\u0010]\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020\u0015¢\u0006\u0004\b]\u0010^J'\u0010a\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u00192\u0006\u0010_\u001a\u00020\b2\b\b\u0002\u0010`\u001a\u00020\u0019¢\u0006\u0004\ba\u0010bJ!\u0010e\u001a\u0004\u0018\u00010\u00192\b\u0010c\u001a\u0004\u0018\u00010\u00192\u0006\u0010d\u001a\u00020\u0019¢\u0006\u0004\be\u0010fJ\u0015\u0010h\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u0019¢\u0006\u0004\bh\u0010iJ\u0015\u0010j\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u0019¢\u0006\u0004\bj\u0010iJ'\u0010p\u001a\u00020o2\u0006\u0010l\u001a\u00020k2\b\u0010n\u001a\u0004\u0018\u00010m2\u0006\u0010g\u001a\u00020\u0019¢\u0006\u0004\bp\u0010qJ/\u0010r\u001a\u00020o2\u0006\u0010l\u001a\u00020k2\b\u0010n\u001a\u0004\u0018\u00010m2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\br\u0010sJ7\u0010t\u001a\u00020o2\u0006\u0010l\u001a\u00020k2\b\u0010n\u001a\u0004\u0018\u00010m2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010x\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bx\u0010wR\u0014\u0010y\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\by\u0010wR\u0014\u0010z\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bz\u0010wR\u0014\u0010{\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b{\u0010wR\u0014\u0010|\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b|\u0010wR\u0014\u0010}\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b}\u0010wR\u0014\u0010~\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b~\u0010wR\u0014\u0010\u007f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u007f\u0010wR\u0016\u0010\u0080\u0001\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010wR\u0016\u0010\u0081\u0001\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010wR\u0016\u0010\u0082\u0001\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010wR\u0016\u0010\u0083\u0001\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010wR\u0016\u0010\u0084\u0001\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010wR\u0016\u0010\u0085\u0001\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010wR\u0016\u0010\u0086\u0001\u001a\u00020\u00158\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010\fR\u0016\u0010\u0087\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010 R\u0016\u0010\u0088\u0001\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010wR\u0016\u0010\u0089\u0001\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010NR\u0016\u0010\u008a\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010 R\u0016\u0010\u008b\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010 R\u0016\u0010\u008c\u0001\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010NR\u0016\u0010\u008d\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010 R\u0016\u0010\u008e\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010 R\u0016\u0010\u008f\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010 R\u0016\u0010\u0090\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010 R\u0016\u0010\u0091\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010 R\u001d\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0006¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0016\u0010\u0097\u0001\u001a\u00020\u00158\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010\fR\u0016\u0010\u0098\u0001\u001a\u00020\u00158\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010\fR\u0016\u0010\u0099\u0001\u001a\u00020\u00158\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010\fR\u0016\u0010\u009a\u0001\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010wR\u0016\u0010\u009b\u0001\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010wR\u0018\u0010\u009c\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010\fR\u0018\u0010\u009d\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010 R\u0018\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001a\u00020\u00158\u0006X\u0086T¢\u0006\u0007\n\u0005\b¡\u0001\u0010\f¨\u0006¢\u0001"}, d2 = {"Lcom/stepos/ailauncher/container/wallpaper/a;", "", "<init>", "()V", "", "progress", Const.INTENT_KEY_APIKEY, "(F)F", "", "K", "(F)I", "", "J", "(F)Ljava/lang/String;", "phase", c.a.COL_SEQ, "Landroid/os/Bundle;", Const.INTENT_KEY_PKGNAME, "(FLjava/lang/String;I)Landroid/os/Bundle;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()I", "", "nowMs", "lastMs", "last", "", ExifInterface.LONGITUDE_EAST, "(JJLjava/lang/String;FF)Z", "forceBroadcast", "p", "(ZJJLjava/lang/String;FF)Z", "commandSucceeded", "F", "(Z)Z", "followingPanelProgress", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "fingerDragging", "settling", "pageMoving", "f", "(ZZZ)Z", "pendingOpen", "ratio", "resting", "restTicks", "u", "(ZFZI)Z", "alreadyLatched", "y", "pendingClose", "w", "(ZFZ)Z", "closingStarted", "c", "(ZZ)Z", "previousRatio", "elapsedMs", "x", "(ZFFJZ)Z", "B", "(ZFF)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)F", "panelOpen", "storedProgress", "l", "(ZF)F", "G", "animated", "panelRatio", "s", "(ZF)Z", "destroyed", "D", "H", "(F)Z", "delayMs", "aiDesktopBound", "I", "(JZ)Z", "alreadyGaveUp", "r", "className", "e", "(Ljava/lang/String;)Z", "deferredPending", "q", "settleAlreadyPending", "C", "pendingEnd", "t", "(ZZZZ)Z", "millisSinceOnScroll", "z", "(ZJ)Z", "keyboardHeightPx", "nineSplitCovering", "v", "(ZIZ)Z", "lastPaused", "shouldPause", "k", "(Ljava/lang/Boolean;Z)Ljava/lang/Boolean;", "pause", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Z)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/content/Context;", "context", "Landroid/os/IBinder;", "windowToken", "LY8/t;", "o", "(Landroid/content/Context;Landroid/os/IBinder;Z)V", "m", "(Landroid/content/Context;Landroid/os/IBinder;FLjava/lang/String;)V", "n", "(Landroid/content/Context;Landroid/os/IBinder;FLjava/lang/String;Z)V", "ACTION", "Ljava/lang/String;", "ACTION_PAUSE", "ACTION_RESUME", "BROADCAST", "BROADCAST_PAUSE", "BROADCAST_RESUME", "KEY_PROGRESS", "KEY_PHASE", "KEY_STATE", "PHASE_START", "PHASE_MOVE", "PHASE_END", "STATE_LAUNCHER", "STATE_AILAUNCHER", "WALLPAPER_PACKAGE", "MOVE_MIN_INTERVAL_MS", "PROGRESS_EPSILON", "KEY_SEQ", "SEQ_NONE", "LATCH_OPEN", "LATCH_CLOSE", "LATCH_REST_TICKS", "LATCH_NEAR_EDGE", "PRIME_CLOSE", "FAST_CLOSE_RATIO_PER_SEC", "FAST_CLOSE_MAX_RATIO", "RELEASE_CLOSE_PRIME", "", "OPEN_PROGRESS_RESYNC_DELAYS_MS", "[J", Const.INTENT_KEY_UMID, "()[J", "WALLPAPER_CHANGED_RESYNC_DEBOUNCE_MS", "DEFER_BOOT_OPEN_TIMEOUT_MS", "DEFER_BOOT_OPEN_SETTLE_MS", "AI_DESKTOP_WALLPAPER_CLASS", "TAG", "lastSendElapsed", "lastProgress", "Ljava/util/concurrent/atomic/AtomicInteger;", "seqCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "LATE_OPEN_RESYNC_MIN_DELAY_MS", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final String ACTION = "action_alive_ai_desktop";
    public static final String ACTION_PAUSE = "action_alive_ai_desktop_pause";
    public static final String ACTION_RESUME = "action_alive_ai_desktop_resume";
    public static final String AI_DESKTOP_WALLPAPER_CLASS = "com.stepos.sdkstage.wallpaper.ai.desktop.AiDesktopWallpaper";
    public static final String BROADCAST = "com.stepos.alivewallpaper.AI_DESKTOP";
    public static final String BROADCAST_PAUSE = "com.stepos.alivewallpaper.AI_DESKTOP_PAUSE";
    public static final String BROADCAST_RESUME = "com.stepos.alivewallpaper.AI_DESKTOP_RESUME";
    public static final long DEFER_BOOT_OPEN_SETTLE_MS = 2000;
    public static final long DEFER_BOOT_OPEN_TIMEOUT_MS = 15000;
    public static final float FAST_CLOSE_MAX_RATIO = 0.2f;
    public static final float FAST_CLOSE_RATIO_PER_SEC = 4.0f;
    public static final String KEY_PHASE = "ai_desktop_phase";
    public static final String KEY_PROGRESS = "ai_desktop_progress";
    public static final String KEY_SEQ = "ai_desktop_seq";
    public static final String KEY_STATE = "ai_desktop_state";
    public static final float LATCH_CLOSE = 0.01f;
    public static final float LATCH_NEAR_EDGE = 0.05f;
    public static final float LATCH_OPEN = 0.99f;
    public static final int LATCH_REST_TICKS = 2;
    public static final long LATE_OPEN_RESYNC_MIN_DELAY_MS = 10000;
    public static final long MOVE_MIN_INTERVAL_MS = 16;
    public static final String PHASE_END = "end";
    public static final String PHASE_MOVE = "move";
    public static final String PHASE_START = "start";
    public static final float PRIME_CLOSE = 0.2f;
    public static final float PROGRESS_EPSILON = 0.001f;
    public static final float RELEASE_CLOSE_PRIME = 0.05f;
    public static final int SEQ_NONE = 0;
    public static final String STATE_AILAUNCHER = "ailauncher";
    public static final String STATE_LAUNCHER = "launcher";
    private static final String TAG = "AiDesktopWpBridge";
    public static final long WALLPAPER_CHANGED_RESYNC_DEBOUNCE_MS = 500;
    public static final String WALLPAPER_PACKAGE = "com.stepos.alivewallpaper";
    private static long lastSendElapsed;
    public static final a INSTANCE = new a();
    private static final long[] OPEN_PROGRESS_RESYNC_DELAYS_MS = {0, 2000, 5000, 10000, 20000};
    private static float lastProgress = Float.NaN;
    private static final AtomicInteger seqCounter = new AtomicInteger(0);

    public final boolean A(boolean followingPanelProgress) {
        return !followingPanelProgress;
    }

    public final boolean B(boolean alreadyLatched, float ratio, float previousRatio) {
        return alreadyLatched && !Float.isNaN(previousRatio) && a(ratio) > a(previousRatio) + 0.05f;
    }

    public final boolean C(boolean aiDesktopBound, boolean settleAlreadyPending) {
        return aiDesktopBound && !settleAlreadyPending;
    }

    public final boolean D(boolean panelOpen, boolean destroyed) {
        return panelOpen && !destroyed;
    }

    public final boolean E(long nowMs, long lastMs, String phase, float progress, float last) {
        p.i(phase, "phase");
        if (p.d(phase, "start")) {
            return true;
        }
        boolean z10 = Math.abs(a(progress) - last) < 0.001f;
        return p.d(phase, PHASE_END) ? !z10 : !z10 && nowMs - lastMs >= 16;
    }

    public final boolean F(boolean commandSucceeded) {
        return true;
    }

    public final boolean G(boolean panelOpen) {
        return panelOpen;
    }

    public final boolean H(float panelRatio) {
        return a(panelRatio) >= 0.99f;
    }

    public final boolean I(long delayMs, boolean aiDesktopBound) {
        return aiDesktopBound && delayMs >= 10000;
    }

    public final String J(float progress) {
        return a(progress) >= 0.5f ? STATE_AILAUNCHER : "launcher";
    }

    public final int K(float progress) {
        return (int) (a(progress) * 1000.0f);
    }

    public final float a(float progress) {
        if (Float.isNaN(progress) || Float.isInfinite(progress) || progress < 0.0f) {
            return 0.0f;
        }
        if (progress > 1.0f) {
            return 1.0f;
        }
        return progress;
    }

    public final Bundle b(float progress, String phase, int seq) {
        p.i(phase, "phase");
        float fA = a(progress);
        Bundle bundle = new Bundle();
        bundle.putFloat(KEY_PROGRESS, fA);
        bundle.putString(KEY_PHASE, phase);
        bundle.putString(KEY_STATE, INSTANCE.J(fA));
        if (seq != 0) {
            bundle.putInt(KEY_SEQ, seq);
        }
        return bundle;
    }

    public final boolean c(boolean closingStarted, boolean fingerDragging) {
        return !closingStarted && fingerDragging;
    }

    public final long[] d() {
        return OPEN_PROGRESS_RESYNC_DELAYS_MS;
    }

    public final boolean e(String className) {
        if (className == null || className.length() == 0) {
            return false;
        }
        return D.K(className, ".AiDesktopWallpaper", false, 2, null) || p.d(className, AI_DESKTOP_WALLPAPER_CLASS);
    }

    public final boolean f(boolean fingerDragging, boolean settling, boolean pageMoving) {
        return (fingerDragging || settling || pageMoving) ? false : true;
    }

    public final int g() {
        AtomicInteger atomicInteger = seqCounter;
        int iIncrementAndGet = atomicInteger.incrementAndGet();
        return iIncrementAndGet != 0 ? iIncrementAndGet : atomicInteger.incrementAndGet();
    }

    public final float h(boolean pendingOpen) {
        return pendingOpen ? 1.0f : 0.0f;
    }

    public final String i(boolean pause) {
        return pause ? ACTION_PAUSE : ACTION_RESUME;
    }

    public final String j(boolean pause) {
        return pause ? BROADCAST_PAUSE : BROADCAST_RESUME;
    }

    public final Boolean k(Boolean lastPaused, boolean shouldPause) {
        if (p.d(lastPaused, Boolean.valueOf(shouldPause))) {
            return null;
        }
        if (lastPaused != null || shouldPause) {
            return Boolean.valueOf(shouldPause);
        }
        return null;
    }

    public final float l(boolean panelOpen, float storedProgress) {
        if (panelOpen) {
            return a(storedProgress);
        }
        return 0.0f;
    }

    public final void m(Context context, IBinder windowToken, float progress, String phase) {
        p.i(context, "context");
        p.i(phase, "phase");
        n(context, windowToken, progress, phase, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(android.content.Context r19, android.os.IBinder r20, float r21, java.lang.String r22, boolean r23) {
        /*
            r18 = this;
            r1 = r18
            r10 = r19
            r7 = r22
            java.lang.String r0 = "context"
            kotlin.jvm.internal.p.i(r10, r0)
            java.lang.String r0 = "phase"
            kotlin.jvm.internal.p.i(r7, r0)
            long r3 = android.os.SystemClock.elapsedRealtime()
            r0 = r21
            float r8 = r1.a(r0)
            long r5 = com.stepos.ailauncher.container.wallpaper.a.lastSendElapsed
            float r9 = com.stepos.ailauncher.container.wallpaper.a.lastProgress
            r2 = r23
            boolean r0 = r1.p(r2, r3, r5, r7, r8, r9)
            if (r0 != 0) goto L29
            goto Ld6
        L29:
            com.stepos.ailauncher.container.wallpaper.a.lastSendElapsed = r3
            com.stepos.ailauncher.container.wallpaper.a.lastProgress = r8
            int r0 = r1.g()
            android.os.Bundle r17 = r1.b(r8, r7, r0)
            java.lang.String r2 = "AiDesktopWpBridge"
            if (r20 == 0) goto L88
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L57
            android.app.WallpaperManager r11 = android.app.WallpaperManager.getInstance(r10)     // Catch: java.lang.Throwable -> L57
            java.lang.String r13 = "action_alive_ai_desktop"
            int r16 = r1.K(r8)     // Catch: java.lang.Throwable -> L57
            r14 = 0
            r15 = 0
            r12 = r20
            r11.sendWallpaperCommand(r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L57
            r3 = r17
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L55
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L55
            goto L64
        L55:
            r0 = move-exception
            goto L5a
        L57:
            r0 = move-exception
            r3 = r17
        L5a:
            kotlin.Result$a r4 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L64:
            java.lang.Throwable r4 = kotlin.Result.e(r0)
            if (r4 == 0) goto L83
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "sendWallpaperCommand failed: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.w(r2, r4)
        L83:
            boolean r0 = kotlin.Result.h(r0)
            goto L8b
        L88:
            r3 = r17
            r0 = 0
        L8b:
            boolean r0 = r1.F(r0)
            if (r0 == 0) goto Ld6
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lac
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "com.stepos.alivewallpaper.AI_DESKTOP"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "com.stepos.alivewallpaper"
            r0.setPackage(r1)     // Catch: java.lang.Throwable -> Lac
            r0.putExtras(r3)     // Catch: java.lang.Throwable -> Lac
            r10.sendBroadcast(r0)     // Catch: java.lang.Throwable -> Lac
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> Lac
            goto Lb7
        Lac:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        Lb7:
            java.lang.Throwable r0 = kotlin.Result.e(r0)
            if (r0 == 0) goto Ld6
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "sendBroadcast failed: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.w(r2, r0)
        Ld6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.container.wallpaper.a.n(android.content.Context, android.os.IBinder, float, java.lang.String, boolean):void");
    }

    public final void o(Context context, IBinder windowToken, boolean pause) {
        Object objB;
        Object objB2;
        p.i(context, "context");
        if (windowToken == null) {
            return;
        }
        String strI = i(pause);
        try {
            Result.Companion companion = Result.INSTANCE;
            WallpaperManager.getInstance(context).sendWallpaperCommand(windowToken, strI, 0, 0, 0, new Bundle());
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "sendPlayback " + strI + " failed: " + thE.getMessage());
        }
        boolean zH = Result.h(objB);
        if (F(zH)) {
            try {
                Intent intent = new Intent(j(pause));
                intent.setPackage(WALLPAPER_PACKAGE);
                context.sendBroadcast(intent);
                objB2 = Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                Log.w(TAG, "sendPlayback broadcast failed: " + thE2.getMessage());
            }
        }
        Log.i(TAG, "playback pause=" + pause + " commanded=" + zH);
    }

    public final boolean p(boolean forceBroadcast, long nowMs, long lastMs, String phase, float progress, float last) {
        p.i(phase, "phase");
        if (forceBroadcast) {
            return true;
        }
        return E(nowMs, lastMs, phase, progress, last);
    }

    public final boolean q(boolean deferredPending, boolean aiDesktopBound) {
        return deferredPending && aiDesktopBound;
    }

    public final boolean r(boolean animated, boolean aiDesktopBound, boolean alreadyGaveUp) {
        return (animated || aiDesktopBound || alreadyGaveUp) ? false : true;
    }

    public final boolean s(boolean animated, float panelRatio) {
        return animated && a(panelRatio) < 0.99f;
    }

    public final boolean t(boolean fingerDragging, boolean settling, boolean pageMoving, boolean pendingEnd) {
        return fingerDragging || settling || pageMoving || pendingEnd;
    }

    public final boolean u(boolean pendingOpen, float ratio, boolean resting, int restTicks) {
        if (!resting) {
            return false;
        }
        float fA = a(ratio);
        if (!pendingOpen ? fA > 0.01f : fA < 0.99f) {
            return true;
        }
        if (!pendingOpen ? fA <= 0.060000002f : fA >= 0.94f) {
            if (restTicks >= 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean v(boolean panelOpen, int keyboardHeightPx, boolean nineSplitCovering) {
        if (panelOpen) {
            return keyboardHeightPx > 0 || nineSplitCovering;
        }
        return false;
    }

    public final boolean w(boolean pendingClose, float ratio, boolean alreadyLatched) {
        return pendingClose && !alreadyLatched && a(ratio) <= 0.2f;
    }

    public final boolean x(boolean fingerDragging, float ratio, float previousRatio, long elapsedMs, boolean alreadyLatched) {
        if (fingerDragging && !alreadyLatched && !Float.isNaN(previousRatio) && elapsedMs > 0) {
            float fA = a(ratio);
            if (fA > 0.2f) {
                return false;
            }
            float fA2 = a(previousRatio) - fA;
            if (fA2 > 0.0f && (fA2 * 1000.0f) / elapsedMs >= 4.0f) {
                return true;
            }
        }
        return false;
    }

    public final boolean y(boolean alreadyLatched) {
        return !alreadyLatched;
    }

    public final boolean z(boolean fingerDragging, long millisSinceOnScroll) {
        return !fingerDragging || millisSinceOnScroll >= 32;
    }
}
