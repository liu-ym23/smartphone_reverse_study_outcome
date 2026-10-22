package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1172u;
import Z8.C1174w;
import Z8.Y;
import Z8.Z;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.NetworkPhase;
import com.stepos.ailauncher.contract.api.livenotification.RiskLiveButton;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementButton;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementParams;
import com.stepos.ailauncher.taskstore.R$color;
import com.stepos.ailauncher.taskstore.R$drawable;
import com.stepos.ailauncher.taskstore.R$string;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJM\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJE\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b(\u0010'J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b-\u0010,J\u001f\u00101\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u001dH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u00104J\u0017\u00106\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b6\u0010,J\u001f\u00107\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b9\u0010'J'\u0010;\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0010H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\"H\u0002¢\u0006\u0004\b=\u0010>J\u001f\u0010?\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b?\u0010@J'\u0010B\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010CJ/\u0010E\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u0010:\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u001dH\u0002¢\u0006\u0004\bE\u0010FJ'\u0010G\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u001dH\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bI\u0010JJ7\u0010N\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u001fH\u0002¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\bP\u0010QJ'\u0010R\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\bR\u0010QJ\u0015\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00100SH\u0000¢\u0006\u0004\bT\u0010UJ\u0019\u0010V\u001a\u0004\u0018\u00010\u00102\u0006\u0010:\u001a\u00020\u0010H\u0000¢\u0006\u0004\bV\u0010*J\u0015\u0010W\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bW\u0010XJ\u001d\u0010Y\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bY\u0010ZJ\u001d\u0010[\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b[\u0010ZJ\u001d\u0010\\\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\\\u0010ZJ\u001d\u0010]\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b]\u0010ZJ\u001f\u0010^\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0010H\u0000¢\u0006\u0004\b^\u0010_J-\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001d\u0018\u00010b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010a\u001a\u00020`H\u0000¢\u0006\u0004\bc\u0010dJ\u001d\u0010e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0010¢\u0006\u0004\be\u0010fJ3\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00100S2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00100g2\b\b\u0002\u0010i\u001a\u00020\u001f¢\u0006\u0004\bj\u0010kJ\u0015\u0010l\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bl\u0010XR\u0014\u0010m\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082T¢\u0006\u0006\n\u0004\bp\u00105R\u0014\u0010q\u001a\u00020o8\u0002X\u0082T¢\u0006\u0006\n\u0004\bq\u00105R\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010u\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\bu\u0010nR\u0014\u0010v\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\bv\u0010nR\u0014\u0010w\u001a\u00020o8\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u00105R&\u0010z\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0y0x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R \u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010{RU\u0010\u007f\u001aB\u0012\f\u0012\n ~*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n ~*\u0004\u0018\u00010\u001f0\u001f ~* \u0012\f\u0012\n ~*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n ~*\u0004\u0018\u00010\u001f0\u001f\u0018\u00010}0}8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001RW\u0010\u0081\u0001\u001aB\u0012\f\u0012\n ~*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n ~*\u0004\u0018\u00010\u001f0\u001f ~* \u0012\f\u0012\n ~*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n ~*\u0004\u0018\u00010\u001f0\u001f\u0018\u00010}0}8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\"\u0010\u0082\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001d0x8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010{R\u0019\u0010\u0083\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001¨\u0006\u0085\u0001"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/T;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/taskstore/livenotification/f;", "params", "Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;", "level", "LY8/t;", "O", "(Landroid/content/Context;Lcom/stepos/ailauncher/taskstore/livenotification/f;Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;)V", "appContext", "Landroid/app/Notification$Builder;", "builder", "", "riskRequestId", "", "Lcom/stepos/ailauncher/contract/api/livenotification/RiskLiveButton;", "riskButtons", "Landroid/graphics/drawable/Icon;", "transparentIcon", "f", "(Landroid/content/Context;Landroid/app/Notification$Builder;Lcom/stepos/ailauncher/taskstore/livenotification/f;Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;Ljava/lang/String;Ljava/util/List;Landroid/graphics/drawable/Icon;)V", "style", "Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;", "F", "(Ljava/lang/String;)Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;", "", "operation", "", "remind", "isExecuting", "Landroid/os/Bundle;", "m", "(Landroid/content/Context;Lcom/stepos/ailauncher/taskstore/livenotification/f;Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;IZZ)Landroid/os/Bundle;", "status", "z", "(Ljava/lang/String;)Z", "D", "K", "(Ljava/lang/String;)Ljava/lang/String;", "H", "(Ljava/lang/String;)I", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/app/NotificationManager;", "manager", "notificationId", "B", "(Landroid/app/NotificationManager;I)Z", "I", "(Lcom/stepos/ailauncher/taskstore/livenotification/f;)I", "J", "N", "L", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "sessionId", "u", "(Landroid/content/Context;Landroid/app/NotificationManager;Ljava/lang/String;)V", "l", "()Landroid/os/Bundle;", "x", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;)I", "baseId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;ILcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;)I", "keepId", "t", "(Landroid/content/Context;Landroid/app/NotificationManager;Ljava/lang/String;I)V", "v", "(Landroid/content/Context;Landroid/app/NotificationManager;I)V", "w", "(Landroid/content/Context;)Z", "requestCode", TaskLiveNotificationDismissReceiver.EXTRA_FROM_CLICK, "Landroid/app/PendingIntent;", "k", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Z)Landroid/app/PendingIntent;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Lcom/stepos/ailauncher/taskstore/livenotification/f;Lcom/stepos/ailauncher/taskstore/livenotification/LiveCardLevel;)Landroid/app/PendingIntent;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "G", "()Ljava/util/Set;", ExifInterface.LONGITUDE_EAST, "y", "(Landroid/content/Context;)V", ExifInterface.LATITUDE_SOUTH, "(Landroid/content/Context;Lcom/stepos/ailauncher/taskstore/livenotification/f;)V", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "U", "C", "(Landroid/content/Context;Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "phase", "Lkotlin/Pair;", "M", "(Landroid/content/Context;Lcom/stepos/ailauncher/common/utils/NetworkPhase;)Lkotlin/Pair;", "n", "(Landroid/content/Context;Ljava/lang/String;)V", "", "sessionIds", "forceIfSingleLive", "q", "(Landroid/content/Context;Ljava/util/Collection;Z)Ljava/util/Set;", "p", "TAG", "Ljava/lang/String;", "", "END_CANCEL_DELAY_MS", "EXECUTING_CAPSULE_AFTER_COLLAPSE_MS", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "CHANNEL_ID_ALERT", "CHANNEL_ID_SILENT", "TIMEOUT_AFTER_MS", "Ljava/util/concurrent/ConcurrentHashMap;", "", "notificationIdMap", "Ljava/util/concurrent/ConcurrentHashMap;", "lastNotifiedStatus", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "createdSessions", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "permissionCapsuleSessions", "pendingExecutingCapsuleToken", "channelCreated", "Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class T {
    private static final String CHANNEL_ID_ALERT = "taskstore_live_notification_channel";
    private static final String CHANNEL_ID_SILENT = "taskstore_live_notification_silent_channel";
    private static final long END_CANCEL_DELAY_MS = 300;
    private static final long EXECUTING_CAPSULE_AFTER_COLLAPSE_MS = 950;
    private static final String TAG = "TaskLiveNotification";
    private static final long TIMEOUT_AFTER_MS = 14400000;
    private static volatile boolean channelCreated;
    public static final T INSTANCE = new T();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ConcurrentHashMap<String, Set<Integer>> notificationIdMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> lastNotifiedStatus = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> createdSessions = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> permissionCapsuleSessions = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap<String, Integer> pendingExecutingCapsuleToken = new ConcurrentHashMap<>();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LiveCardLevel.values().length];
            try {
                iArr[LiveCardLevel.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LiveCardLevel.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveCardLevel.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LiveCardLevel.PERMISSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NetworkPhase.values().length];
            try {
                iArr2[NetworkPhase.AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[NetworkPhase.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[NetworkPhase.LOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            T t12 = T.INSTANCE;
            return b9.b.d(Integer.valueOf(com.stepos.ailauncher.mcpservice.risk.notification.b.d(t12.F(((RiskLiveButton) t10).getStyle()))), Integer.valueOf(com.stepos.ailauncher.mcpservice.risk.notification.b.d(t12.F(((RiskLiveButton) t11).getStyle()))));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public c(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(Integer.valueOf(com.stepos.ailauncher.mcpservice.risk.notification.b.c(((RiskLiveButton) t10).getId())), Integer.valueOf(com.stepos.ailauncher.mcpservice.risk.notification.b.c(((RiskLiveButton) t11).getId())));
        }
    }

    public static final void P(String str, int i10, NotificationManager notificationManager, int i11, Notification notification, String str2, Context context) {
        Object objB;
        Set<Integer> setPutIfAbsent;
        if (pendingExecutingCapsuleToken.remove(str, Integer.valueOf(i10)) && createdSessions.contains(str)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                notificationManager.notify(i11, notification);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.h(objB)) {
                ConcurrentHashMap<String, Set<Integer>> concurrentHashMap = notificationIdMap;
                Set<Integer> setNewSetFromMap = concurrentHashMap.get(str);
                if (setNewSetFromMap == null && (setPutIfAbsent = concurrentHashMap.putIfAbsent(str, (setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap())))) != null) {
                    setNewSetFromMap = setPutIfAbsent;
                }
                setNewSetFromMap.add(Integer.valueOf(i11));
                lastNotifiedStatus.put(str, str2);
                createdSessions.add(str);
                T t10 = INSTANCE;
                kotlin.jvm.internal.p.f(context);
                t10.t(context, notificationManager, str, i11);
                Log.d(TAG, "executing capsule posted after card collapse sessionId=" + str + " notifId=" + i11);
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "executing capsule failed sessionId=" + str, thE);
            }
        }
    }

    public static final void Q(LiveNotificationParams liveNotificationParams, int i10, NotificationManager notificationManager, Notification notification, long j10) {
        Set<Integer> set;
        Object objB;
        if (kotlin.jvm.internal.p.d(lastNotifiedStatus.get(liveNotificationParams.getSessionId()), liveNotificationParams.getStatus()) && (set = notificationIdMap.get(liveNotificationParams.getSessionId())) != null && set.contains(Integer.valueOf(i10))) {
            try {
                Result.Companion companion = Result.INSTANCE;
                notificationManager.notify(i10, notification);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.h(objB)) {
                Log.d(TAG, "capsule icons refreshed sessionId=" + liveNotificationParams.getSessionId() + " notifId=" + i10 + " status=" + liveNotificationParams.getStatus() + " delay=" + j10);
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "capsule icon refresh failed notifId=" + i10, thE);
            }
        }
    }

    public static final void R(LiveNotificationParams liveNotificationParams, String str, Context context, NotificationManager notificationManager, int i10, String str2) {
        Log.d(TAG, "recreate sessionId=" + liveNotificationParams.getSessionId() + " prev=" + str + " reason=" + str2);
        T t10 = INSTANCE;
        kotlin.jvm.internal.p.f(context);
        t10.v(context, notificationManager, i10);
        try {
            Result.Companion companion = Result.INSTANCE;
            notificationManager.cancel(i10);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        Set<Integer> set = notificationIdMap.get(liveNotificationParams.getSessionId());
        if (set != null) {
            set.remove(Integer.valueOf(i10));
        }
    }

    public static final void o(String str, Set set, NotificationManager notificationManager) {
        Object objB;
        if (lastNotifiedStatus.containsKey(str)) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            try {
                Result.Companion companion = Result.INSTANCE;
                notificationManager.cancel(iIntValue);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "cancel failed sessionId=" + str + " id=" + iIntValue, thE);
            }
        }
    }

    public static final void r(List list, NotificationManager notificationManager) {
        Object objB;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            StatusBarNotification statusBarNotification = (StatusBarNotification) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                notificationManager.cancel(statusBarNotification.getTag(), statusBarNotification.getId());
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "cancelMatching failed tag=" + statusBarNotification.getTag() + " id=" + statusBarNotification.getId(), thE);
            }
        }
    }

    public static final boolean s(Set<String> set, String str) {
        if (La.H.x0(str)) {
            return false;
        }
        Set<String> set2 = set;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            if (C3723k.INSTANCE.f((String) it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean A(String status) {
        String upperCase = status.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case 35394935:
                return !upperCase.equals("PENDING");
            case 1383663147:
                return !upperCase.equals("COMPLETED");
            case 1834295853:
                return !upperCase.equals("WAITING");
            case 2066319421:
                return !upperCase.equals("FAILED");
            default:
                return true;
        }
    }

    public final boolean B(NotificationManager manager, int notificationId) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            StatusBarNotification[] activeNotifications = manager.getActiveNotifications();
            kotlin.jvm.internal.p.h(activeNotifications, "getActiveNotifications(...)");
            int length = activeNotifications.length;
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (activeNotifications[i10].getId() == notificationId) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean C(Context context, String sessionId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService(NotificationManager.class);
        if (notificationManager == null) {
            return false;
        }
        Set<Integer> set = notificationIdMap.get(sessionId);
        Set setR1 = set != null ? Z8.F.r1(set) : null;
        if (setR1 == null) {
            setR1 = Y.e();
        }
        Set set2 = setR1;
        if (set2.isEmpty()) {
            InterfaceC4149a<LiveCardLevel> entries = LiveCardLevel.getEntries();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<LiveCardLevel> it = entries.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(Integer.valueOf(INSTANCE.x(sessionId, it.next())));
            }
            set2 = linkedHashSet;
        }
        Set set3 = set2;
        if ((set3 instanceof Collection) && set3.isEmpty()) {
            return false;
        }
        Iterator it2 = set3.iterator();
        while (it2.hasNext()) {
            if (INSTANCE.B(notificationManager, ((Number) it2.next()).intValue())) {
                return true;
            }
        }
        return false;
    }

    public final boolean D(String status) {
        String upperCase = status.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        return kotlin.jvm.internal.p.d(upperCase, "WAITING") || kotlin.jvm.internal.p.d(upperCase, "PENDING");
    }

    public final String E(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return lastNotifiedStatus.get(sessionId);
    }

    public final RiskStatementButton.Style F(String style) {
        String upperCase = style.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        return kotlin.jvm.internal.p.d(upperCase, "REJECT") ? RiskStatementButton.Style.REJECT : kotlin.jvm.internal.p.d(upperCase, "EMPHASIS") ? RiskStatementButton.Style.EMPHASIS : RiskStatementButton.Style.NORMAL;
    }

    public final Set<String> G() {
        Set<String> setKeySet = notificationIdMap.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        Set<String> setKeySet2 = lastNotifiedStatus.keySet();
        kotlin.jvm.internal.p.h(setKeySet2, "<get-keys>(...)");
        return Z8.F.r1(Z.o(setKeySet, setKeySet2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r0.equals("WAITING") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (r0.equals("PENDING") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        return com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_pending;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int H(java.lang.String r1) {
        /*
            r0 = this;
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r1.toUpperCase(r0)
            java.lang.String r1 = "toUpperCase(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case 35394935: goto L35;
                case 1383663147: goto L29;
                case 1834295853: goto L20;
                case 2066319421: goto L14;
                default: goto L13;
            }
        L13:
            goto L3d
        L14:
            java.lang.String r1 = "FAILED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1d
            goto L3d
        L1d:
            int r0 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_failed
            return r0
        L20:
            java.lang.String r1 = "WAITING"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L40
            goto L3d
        L29:
            java.lang.String r1 = "COMPLETED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L32
            goto L3d
        L32:
            int r0 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_done
            return r0
        L35:
            java.lang.String r1 = "PENDING"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L40
        L3d:
            int r0 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_processing
            return r0
        L40:
            int r0 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_pending
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.H(java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if (r2.equals("WAITING") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        if (r2.equals("PENDING") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        return com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_pending_right;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int I(com.stepos.ailauncher.taskstore.livenotification.LiveNotificationParams r3) {
        /*
            r2 = this;
            java.lang.String r2 = r3.getStatus()
            java.lang.String r0 = "FAILED"
            r1 = 1
            boolean r2 = La.D.L(r2, r0, r1)
            if (r2 == 0) goto L10
            int r2 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_failed_right
            return r2
        L10:
            boolean r2 = r3.getContentOnly()
            if (r2 == 0) goto L18
            r2 = 0
            return r2
        L18:
            java.lang.String r2 = r3.getStatus()
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toUpperCase(r3)
            java.lang.String r3 = "toUpperCase(...)"
            kotlin.jvm.internal.p.h(r2, r3)
            int r3 = r2.hashCode()
            r0 = 35394935(0x21c1577, float:1.146723E-37)
            if (r3 == r0) goto L51
            r0 = 1383663147(0x5279062b, float:2.6738758E11)
            if (r3 == r0) goto L45
            r0 = 1834295853(0x6d55222d, float:4.1226014E27)
            if (r3 == r0) goto L3c
            goto L5c
        L3c:
            java.lang.String r3 = "WAITING"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L59
            goto L5c
        L45:
            java.lang.String r3 = "COMPLETED"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L4e
            goto L5c
        L4e:
            int r2 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_done_right
            return r2
        L51:
            java.lang.String r3 = "PENDING"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L5c
        L59:
            int r2 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_pending_right
            return r2
        L5c:
            int r2 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_processing_right
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.I(com.stepos.ailauncher.taskstore.livenotification.f):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        if (r9.equals("WAITING") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r9.equals("PENDING") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        return com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_pending_card;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        if (r9.equals("WAITING") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:
    
        if (r9.equals("PENDING") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
    
        return com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_pending_card;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int J(com.stepos.ailauncher.taskstore.livenotification.LiveNotificationParams r10) {
        /*
            r9 = this;
            boolean r9 = r10.getContentOnly()
            java.lang.String r0 = "PENDING"
            java.lang.String r1 = "COMPLETED"
            java.lang.String r2 = "WAITING"
            r3 = 1834295853(0x6d55222d, float:4.1226014E27)
            r4 = 1383663147(0x5279062b, float:2.6738758E11)
            r5 = 35394935(0x21c1577, float:1.146723E-37)
            java.lang.String r6 = "toUpperCase(...)"
            if (r9 == 0) goto L4d
            java.lang.String r9 = r10.getStatus()
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r9 = r9.toUpperCase(r10)
            kotlin.jvm.internal.p.h(r9, r6)
            int r10 = r9.hashCode()
            if (r10 == r5) goto L41
            if (r10 == r4) goto L37
            if (r10 == r3) goto L30
            goto L4a
        L30:
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L47
            goto L4a
        L37:
            boolean r9 = r9.equals(r1)
            if (r9 != 0) goto L3e
            goto L4a
        L3e:
            int r9 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_done_card
            return r9
        L41:
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L4a
        L47:
            int r9 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_pending_card
            return r9
        L4a:
            int r9 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_processing_card
            return r9
        L4d:
            java.lang.String r9 = r10.getStatus()
            java.lang.String r7 = "FAILED"
            r8 = 1
            boolean r9 = La.D.L(r9, r7, r8)
            if (r9 == 0) goto L5d
            int r9 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_failed_card
            return r9
        L5d:
            java.lang.String r9 = r10.getStatus()
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r9 = r9.toUpperCase(r10)
            kotlin.jvm.internal.p.h(r9, r6)
            int r10 = r9.hashCode()
            if (r10 == r5) goto L86
            if (r10 == r4) goto L7c
            if (r10 == r3) goto L75
            goto L8f
        L75:
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L8c
            goto L8f
        L7c:
            boolean r9 = r9.equals(r1)
            if (r9 != 0) goto L83
            goto L8f
        L83:
            int r9 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_done_card
            return r9
        L86:
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L8f
        L8c:
            int r9 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_pending_card
            return r9
        L8f:
            int r9 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_capsule_icon_processing_card
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.J(com.stepos.ailauncher.taskstore.livenotification.f):int");
    }

    public final String K(String status) {
        String upperCase = status.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case 35394935:
                return upperCase.equals("PENDING") ? CHANNEL_ID_ALERT : CHANNEL_ID_SILENT;
            case 1383663147:
                return !upperCase.equals("COMPLETED") ? CHANNEL_ID_SILENT : CHANNEL_ID_ALERT;
            case 1834295853:
                return !upperCase.equals("WAITING") ? CHANNEL_ID_SILENT : CHANNEL_ID_ALERT;
            case 2066319421:
                return !upperCase.equals("FAILED") ? CHANNEL_ID_SILENT : CHANNEL_ID_ALERT;
            default:
                return CHANNEL_ID_SILENT;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String L(android.content.Context r1, java.lang.String r2) {
        /*
            r0 = this;
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r2.toUpperCase(r0)
            java.lang.String r2 = "toUpperCase(...)"
            kotlin.jvm.internal.p.h(r0, r2)
            int r2 = r0.hashCode()
            switch(r2) {
                case 35394935: goto L35;
                case 1383663147: goto L29;
                case 1834295853: goto L20;
                case 2066319421: goto L14;
                default: goto L13;
            }
        L13:
            goto L40
        L14:
            java.lang.String r2 = "FAILED"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L1d
            goto L40
        L1d:
            int r0 = com.stepos.ailauncher.taskstore.R$string.taskstore_live_session_task_failed
            goto L42
        L20:
            java.lang.String r2 = "WAITING"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L3d
            goto L40
        L29:
            java.lang.String r2 = "COMPLETED"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L32
            goto L40
        L32:
            int r0 = com.stepos.ailauncher.taskstore.R$string.taskstore_live_session_task_completed
            goto L42
        L35:
            java.lang.String r2 = "PENDING"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L40
        L3d:
            int r0 = com.stepos.ailauncher.taskstore.R$string.taskstore_live_session_task_waiting
            goto L42
        L40:
            int r0 = com.stepos.ailauncher.taskstore.R$string.taskstore_live_session_task_running
        L42:
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.L(android.content.Context, java.lang.String):java.lang.String");
    }

    public final Pair<String, Integer> M(Context context, NetworkPhase phase) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(phase, "phase");
        int i10 = a.$EnumSwitchMapping$1[phase.ordinal()];
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            return new Pair<>(context.getString(R$string.taskstore_live_status_network_connecting), Integer.valueOf(androidx.core.content.a.c(context, R$color.taskstore_live_status_desc_network_connecting)));
        }
        if (i10 == 3) {
            return new Pair<>(context.getString(R$string.taskstore_live_status_network_lost), Integer.valueOf(androidx.core.content.a.c(context, R$color.taskstore_live_capsule_failed_content)));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (r0.equals("PENDING") != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        return com.stepos.ailauncher.taskstore.R$color.taskstore_live_status_desc_pending;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if (r0.equals("CANCELLED") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
    
        return com.stepos.ailauncher.taskstore.R$color.taskstore_live_status_desc_failed;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r0.equals("FAILED") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (r0.equals("WAITING") == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int N(java.lang.String r1) {
        /*
            r0 = this;
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r1.toUpperCase(r0)
            java.lang.String r1 = "toUpperCase(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case -1031784143: goto L3d;
                case 35394935: goto L32;
                case 1383663147: goto L26;
                case 1834295853: goto L1d;
                case 2066319421: goto L14;
                default: goto L13;
            }
        L13:
            goto L45
        L14:
            java.lang.String r1 = "FAILED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
            goto L45
        L1d:
            java.lang.String r1 = "WAITING"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3a
            goto L45
        L26:
            java.lang.String r1 = "COMPLETED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2f
            goto L45
        L2f:
            int r0 = com.stepos.ailauncher.taskstore.R$color.taskstore_live_status_desc_done
            return r0
        L32:
            java.lang.String r1 = "PENDING"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L45
        L3a:
            int r0 = com.stepos.ailauncher.taskstore.R$color.taskstore_live_status_desc_pending
            return r0
        L3d:
            java.lang.String r1 = "CANCELLED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
        L45:
            int r0 = com.stepos.ailauncher.taskstore.R$color.taskstore_live_status_desc_processing
            return r0
        L48:
            int r0 = com.stepos.ailauncher.taskstore.R$color.taskstore_live_status_desc_failed
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.N(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0432 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0460 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x074a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x08a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(android.content.Context r40, final com.stepos.ailauncher.taskstore.livenotification.LiveNotificationParams r41, com.stepos.ailauncher.taskstore.livenotification.LiveCardLevel r42) {
        /*
            Method dump skipped, instructions count: 2472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.O(android.content.Context, com.stepos.ailauncher.taskstore.livenotification.f, com.stepos.ailauncher.taskstore.livenotification.LiveCardLevel):void");
    }

    public final void S(Context context, LiveNotificationParams params) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(params, "params");
        O(context, params, LiveCardLevel.LARGE);
    }

    public final void T(Context context, LiveNotificationParams params) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(params, "params");
        O(context, params, LiveCardLevel.MEDIUM);
    }

    public final void U(Context context, LiveNotificationParams params) {
        Set<Integer> setPutIfAbsent;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(params, "params");
        Context applicationContext = context.getApplicationContext();
        if (La.D.L(params.getStatus(), "CANCELLED", true)) {
            Log.d(TAG, "showPERMISSION skipped: cancelled sessionId=" + params.getSessionId());
            kotlin.jvm.internal.p.f(applicationContext);
            n(applicationContext, params.getSessionId());
            return;
        }
        String riskRequestId = params.getRiskRequestId();
        List<RiskLiveButton> listO = params.o();
        if (riskRequestId == null || La.H.x0(riskRequestId) || listO.size() < 3) {
            Log.w(TAG, "showPERMISSION skipped: need 3 risk buttons sessionId=" + params.getSessionId() + " requestId=" + riskRequestId + " count=" + listO.size());
            return;
        }
        kotlin.jvm.internal.p.f(applicationContext);
        if (w(applicationContext)) {
            if (!channelCreated) {
                y(applicationContext);
            }
            NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService(NotificationManager.class);
            if (notificationManager == null) {
                Log.w(TAG, "showPERMISSION skipped: NotificationManager unavailable");
                return;
            }
            String sessionId = params.getSessionId();
            String sessionId2 = params.getSessionId();
            LiveCardLevel liveCardLevel = LiveCardLevel.PERMISSION;
            int iH = h(sessionId, x(sessionId2, liveCardLevel), liveCardLevel);
            PendingIntent pendingIntentK = k(applicationContext, (params.getSessionId() + "@PERMISSION@click").hashCode(), params.getSessionId(), params.getStatus(), true);
            String riskLevel = params.getRiskLevel();
            if (La.H.x0(riskLevel)) {
                riskLevel = "medium";
            }
            String title = params.getTitle();
            if (La.H.x0(title)) {
                title = params.getContent();
            }
            String riskBody = params.getRiskBody();
            List<RiskLiveButton> list = listO;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (RiskLiveButton riskLiveButton : list) {
                arrayList.add(new RiskStatementButton(riskLiveButton.getId(), riskLiveButton.getText(), null, INSTANCE.F(riskLiveButton.getStyle()), 4, null));
            }
            RiskStatementParams riskStatementParams = new RiskStatementParams(riskRequestId, riskLevel, title, riskBody, arrayList, null, params.getSessionId(), null, com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME, null);
            Set<Integer> set = notificationIdMap.get(params.getSessionId());
            Set setR1 = set != null ? Z8.F.r1(set) : null;
            if (setR1 == null) {
                setR1 = Y.e();
            }
            Integer num = (Integer) Z8.F.r0(setR1);
            boolean z10 = false;
            boolean z11 = num != null;
            x xVar = x.INSTANCE;
            boolean zE = xVar.e(riskRequestId);
            com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
            if (vVar.k() && !vVar.j()) {
                z10 = true;
            }
            C3719g c3719g = C3719g.INSTANCE;
            boolean zG = c3719g.g(zE, z10);
            if (zG) {
                xVar.h(riskRequestId);
            }
            if (num != null) {
                iH = num.intValue();
            }
            int i10 = iH;
            int iF = c3719g.f(zE, z11);
            LiveCardLevel liveCardLevel2 = LiveCardLevel.PERMISSION;
            String sessionId3 = params.getSessionId();
            String str = iF == 0 ? "CREATE" : "UPDATE";
            ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((RiskLiveButton) it.next()).getId());
            }
            Log.d(TAG, "notify level=" + liveCardLevel2 + " notifId=" + i10 + " sessionId=" + sessionId3 + " requestId=" + riskRequestId + " pinned=" + zG + " alreadySeen=" + zE + " sessionCenterForeground=" + z10 + " hasLiveWindow=" + z11 + " op=" + str + " buttons=" + arrayList2 + " title='" + riskStatementParams.getTitle() + "'");
            com.stepos.ailauncher.mcpservice.risk.notification.a.m(com.stepos.ailauncher.mcpservice.risk.notification.a.INSTANCE, applicationContext, riskStatementParams, i10, pendingIntentK, false, zG, iF, null, 128, null);
            t(applicationContext, notificationManager, params.getSessionId(), i10);
            ConcurrentHashMap<String, Set<Integer>> concurrentHashMap = notificationIdMap;
            String sessionId4 = params.getSessionId();
            Set<Integer> setNewSetFromMap = concurrentHashMap.get(sessionId4);
            if (setNewSetFromMap == null && (setPutIfAbsent = concurrentHashMap.putIfAbsent(sessionId4, (setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap())))) != null) {
                setNewSetFromMap = setPutIfAbsent;
            }
            setNewSetFromMap.add(Integer.valueOf(i10));
            lastNotifiedStatus.put(params.getSessionId(), params.getStatus());
            createdSessions.add(params.getSessionId());
            permissionCapsuleSessions.add(params.getSessionId());
        }
    }

    public final void V(Context context, LiveNotificationParams params) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(params, "params");
        O(context, params, LiveCardLevel.SMALL);
    }

    public final void f(Context appContext, Notification.Builder builder, LiveNotificationParams params, LiveCardLevel level, String riskRequestId, List<RiskLiveButton> riskButtons, Icon transparentIcon) {
        List<RiskLiveButton> list = riskButtons;
        for (RiskLiveButton riskLiveButton : Z8.B.U(Z8.F.c1(list, new c(new b())))) {
            com.stepos.ailauncher.mcpservice.risk.notification.a aVar = com.stepos.ailauncher.mcpservice.risk.notification.a.INSTANCE;
            builder.addAction(aVar.f(appContext, transparentIcon, riskLiveButton.getText(), INSTANCE.F(riskLiveButton.getStyle()), riskLiveButton.getId(), com.stepos.ailauncher.mcpservice.risk.notification.a.c(aVar, appContext, riskRequestId, riskLiveButton.getId(), (params.getSessionId() + "@" + level.name() + "@risk@" + riskRequestId + "@" + riskLiveButton.getId()).hashCode(), 0, 16, null)));
        }
        String sessionId = params.getSessionId();
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RiskLiveButton) it.next()).getId());
        }
        Log.d(TAG, "risk actions attached sessionId=" + sessionId + " level=" + level + " requestId=" + riskRequestId + " buttons=" + arrayList);
    }

    public final int g(String status) {
        String upperCase = status.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        int iHashCode = upperCase.hashCode();
        if (iHashCode != 35394935) {
            if (iHashCode == 1383663147) {
                if (upperCase.equals("COMPLETED")) {
                    return R$drawable.taskstore_live_capsule_icon_done_right;
                }
                return 0;
            }
            if (iHashCode != 1834295853 || !upperCase.equals("WAITING")) {
                return 0;
            }
        } else if (!upperCase.equals("PENDING")) {
            return 0;
        }
        return R$drawable.taskstore_live_capsule_icon_pending_right;
    }

    public final int h(String sessionId, int baseId, LiveCardLevel level) {
        Set<Map.Entry<String, Set<Integer>>> setEntrySet = notificationIdMap.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            Map.Entry entry = (Map.Entry) obj;
            kotlin.jvm.internal.p.f(entry);
            Object key = entry.getKey();
            kotlin.jvm.internal.p.h(key, "component1(...)");
            if (!kotlin.jvm.internal.p.d((String) key, sessionId)) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            kotlin.jvm.internal.p.h(value, "<get-value>(...)");
            Z8.A.E(hashSet, (Iterable) value);
        }
        if (!hashSet.contains(Integer.valueOf(baseId))) {
            return baseId;
        }
        int i10 = baseId;
        do {
            i10 = i10 == Integer.MAX_VALUE ? Integer.MIN_VALUE : i10 + 1;
        } while (hashSet.contains(Integer.valueOf(i10)));
        Set<Map.Entry<String, Set<Integer>>> setEntrySet2 = notificationIdMap.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet2, "<get-entries>(...)");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setEntrySet2) {
            Map.Entry entry2 = (Map.Entry) obj2;
            kotlin.jvm.internal.p.f(entry2);
            Object value2 = entry2.getValue();
            kotlin.jvm.internal.p.h(value2, "component2(...)");
            if (((Set) value2).contains(Integer.valueOf(i10))) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add((String) ((Map.Entry) it2.next()).getKey());
        }
        Log.w(TAG, "notificationId collision resolved baseId=" + baseId + " allocatedId=" + i10 + " sessionId=" + sessionId + " level=" + level + " occupiedOwners=" + arrayList3);
        return i10;
    }

    public final PendingIntent i(Context context, LiveNotificationParams params, LiveCardLevel level) {
        Intent intent = new Intent(AlipayXuiLiveClickReceiver.ACTION);
        intent.setClass(context, AlipayXuiLiveClickReceiver.class);
        intent.putExtra("taskId", params.getSessionId());
        String clickAppLink = params.getClickAppLink();
        if (clickAppLink == null) {
            clickAppLink = "";
        }
        intent.putExtra(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, clickAppLink);
        String clickSessionId = params.getClickSessionId();
        intent.putExtra("sessionId", clickSessionId != null ? clickSessionId : "");
        intent.putExtra("status", params.getStatus());
        intent.putExtra("dismissnotificationpannel", true);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (params.getSessionId() + "@" + level.name() + "@alipayClick").hashCode(), intent, 201326592);
        kotlin.jvm.internal.p.h(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    public final PendingIntent j(Context context, LiveNotificationParams params, LiveCardLevel level) {
        Intent intent = new Intent(AlipayXuiLiveClickReceiver.ACTION);
        intent.setClass(context, AlipayXuiLiveClickReceiver.class);
        intent.putExtra("taskId", params.getSessionId());
        intent.putExtra("status", params.getStatus());
        intent.putExtra(AlipayXuiLiveClickReceiver.EXTRA_SWIPE, true);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (params.getSessionId() + "@" + level.name() + "@alipaySwipe").hashCode(), intent, 201326592);
        kotlin.jvm.internal.p.h(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    public final PendingIntent k(Context context, int requestCode, String sessionId, String status, boolean fromClick) {
        Intent intent = new Intent(TaskLiveNotificationDismissReceiver.ACTION_DISMISS);
        intent.setClass(context, TaskLiveNotificationDismissReceiver.class);
        intent.putExtra("sessionId", sessionId);
        intent.putExtra("status", status);
        intent.putExtra(TaskLiveNotificationDismissReceiver.EXTRA_FROM_CLICK, fromClick);
        intent.putExtra("dismissnotificationpannel", true);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, requestCode, intent, 201326592);
        kotlin.jvm.internal.p.h(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    public final Bundle l() {
        Bundle bundle = new Bundle();
        bundle.putInt("notification.live.operation", 2);
        bundle.putInt("notification.live.type", 6);
        bundle.putBoolean("notification.live.pinned", false);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("notification.live.capsuleStatus", -1);
        bundle.putBundle("notification.live.capsule", bundle2);
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x027f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle m(android.content.Context r27, com.stepos.ailauncher.taskstore.livenotification.LiveNotificationParams r28, com.stepos.ailauncher.taskstore.livenotification.LiveCardLevel r29, int r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 938
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.m(android.content.Context, com.stepos.ailauncher.taskstore.livenotification.f, com.stepos.ailauncher.taskstore.livenotification.LiveCardLevel, int, boolean, boolean):android.os.Bundle");
    }

    public final void n(Context context, final String sessionId) {
        final Set setR1;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        Context applicationContext = context.getApplicationContext();
        final NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService(NotificationManager.class);
        if (notificationManager == null) {
            return;
        }
        kotlin.jvm.internal.p.f(applicationContext);
        u(applicationContext, notificationManager, sessionId);
        lastNotifiedStatus.remove(sessionId);
        createdSessions.remove(sessionId);
        permissionCapsuleSessions.remove(sessionId);
        pendingExecutingCapsuleToken.remove(sessionId);
        Set<Integer> setRemove = notificationIdMap.remove(sessionId);
        if (setRemove == null || (setR1 = Z8.F.r1(setRemove)) == null) {
            InterfaceC4149a<LiveCardLevel> entries = LiveCardLevel.getEntries();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<LiveCardLevel> it = entries.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(Integer.valueOf(x(sessionId, it.next())));
            }
            setR1 = linkedHashSet;
        }
        mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.taskstore.livenotification.O
            @Override // java.lang.Runnable
            public final void run() {
                T.o(sessionId, setR1, notificationManager);
            }
        }, 300L);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053 A[Catch: all -> 0x00d4, TryCatch #2 {all -> 0x00d4, blocks: (B:5:0x0014, B:9:0x002b, B:11:0x0034, B:13:0x003a, B:15:0x0043, B:17:0x0049, B:18:0x004d, B:21:0x0056, B:20:0x0053, B:22:0x0059, B:23:0x005d, B:25:0x0063, B:29:0x0095, B:30:0x009f, B:31:0x00a3, B:33:0x00a9, B:37:0x00c3, B:38:0x00cd, B:34:0x00af, B:26:0x0085), top: B:51:0x0014, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.p.i(r11, r0)
            android.content.Context r11 = r11.getApplicationContext()
            java.lang.Class<android.app.NotificationManager> r0 = android.app.NotificationManager.class
            java.lang.Object r0 = r11.getSystemService(r0)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            if (r0 != 0) goto L14
            return
        L14:
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Ld4
            android.service.notification.StatusBarNotification[] r1 = r0.getActiveNotifications()     // Catch: java.lang.Throwable -> Ld4
            java.lang.String r2 = "getActiveNotifications(...)"
            kotlin.jvm.internal.p.h(r1, r2)     // Catch: java.lang.Throwable -> Ld4
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ld4
            r2.<init>()     // Catch: java.lang.Throwable -> Ld4
            int r3 = r1.length     // Catch: java.lang.Throwable -> Ld4
            r4 = 0
        L26:
            java.lang.String r5 = "taskstore_live_notification_silent_channel"
            if (r4 >= r3) goto L59
            r6 = r1[r4]     // Catch: java.lang.Throwable -> Ld4
            android.app.Notification r7 = r6.getNotification()     // Catch: java.lang.Throwable -> Ld4
            r8 = 0
            if (r7 == 0) goto L39
            java.lang.String r7 = r7.getChannelId()     // Catch: java.lang.Throwable -> Ld4
            goto L3a
        L39:
            r7 = r8
        L3a:
            java.lang.String r9 = "taskstore_live_notification_channel"
            boolean r7 = kotlin.jvm.internal.p.d(r7, r9)     // Catch: java.lang.Throwable -> Ld4
            if (r7 != 0) goto L53
            android.app.Notification r7 = r6.getNotification()     // Catch: java.lang.Throwable -> Ld4
            if (r7 == 0) goto L4d
            java.lang.String r8 = r7.getChannelId()     // Catch: java.lang.Throwable -> Ld4
        L4d:
            boolean r5 = kotlin.jvm.internal.p.d(r8, r5)     // Catch: java.lang.Throwable -> Ld4
            if (r5 == 0) goto L56
        L53:
            r2.add(r6)     // Catch: java.lang.Throwable -> Ld4
        L56:
            int r4 = r4 + 1
            goto L26
        L59:
            java.util.Iterator r1 = r2.iterator()     // Catch: java.lang.Throwable -> Ld4
        L5d:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> Ld4
            if (r3 == 0) goto L9f
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> Ld4
            android.service.notification.StatusBarNotification r3 = (android.service.notification.StatusBarNotification) r3     // Catch: java.lang.Throwable -> Ld4
            android.app.Notification$Builder r4 = new android.app.Notification$Builder     // Catch: java.lang.Throwable -> Ld4
            r4.<init>(r11, r5)     // Catch: java.lang.Throwable -> Ld4
            int r6 = com.stepos.ailauncher.taskstore.R$drawable.taskstore_live_small_icon     // Catch: java.lang.Throwable -> Ld4
            android.app.Notification$Builder r4 = r4.setSmallIcon(r6)     // Catch: java.lang.Throwable -> Ld4
            android.os.Bundle r6 = r10.l()     // Catch: java.lang.Throwable -> Ld4
            android.app.Notification$Builder r4 = r4.addExtras(r6)     // Catch: java.lang.Throwable -> Ld4
            android.app.Notification r4 = r4.build()     // Catch: java.lang.Throwable -> Ld4
            java.lang.String r6 = "build(...)"
            kotlin.jvm.internal.p.h(r4, r6)     // Catch: java.lang.Throwable -> Ld4
            kotlin.Result$a r6 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L94
            int r3 = r3.getId()     // Catch: java.lang.Throwable -> L94
            r0.notify(r3, r4)     // Catch: java.lang.Throwable -> L94
            Y8.t r3 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L94
            kotlin.Result.b(r3)     // Catch: java.lang.Throwable -> L94
            goto L5d
        L94:
            r3 = move-exception
            kotlin.Result$a r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Ld4
            java.lang.Object r3 = kotlin.C4849c.a(r3)     // Catch: java.lang.Throwable -> Ld4
            kotlin.Result.b(r3)     // Catch: java.lang.Throwable -> Ld4
            goto L5d
        L9f:
            java.util.Iterator r10 = r2.iterator()     // Catch: java.lang.Throwable -> Ld4
        La3:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Throwable -> Ld4
            if (r11 == 0) goto Lcd
            java.lang.Object r11 = r10.next()     // Catch: java.lang.Throwable -> Ld4
            android.service.notification.StatusBarNotification r11 = (android.service.notification.StatusBarNotification) r11     // Catch: java.lang.Throwable -> Ld4
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r1 = r11.getTag()     // Catch: java.lang.Throwable -> Lc2
            int r11 = r11.getId()     // Catch: java.lang.Throwable -> Lc2
            r0.cancel(r1, r11)     // Catch: java.lang.Throwable -> Lc2
            Y8.t r11 = Y8.t.f7040a     // Catch: java.lang.Throwable -> Lc2
            kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> Lc2
            goto La3
        Lc2:
            r11 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Ld4
            java.lang.Object r11 = kotlin.C4849c.a(r11)     // Catch: java.lang.Throwable -> Ld4
            kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> Ld4
            goto La3
        Lcd:
            Y8.t r10 = Y8.t.f7040a     // Catch: java.lang.Throwable -> Ld4
            java.lang.Object r10 = kotlin.Result.b(r10)     // Catch: java.lang.Throwable -> Ld4
            goto Ldf
        Ld4:
            r10 = move-exception
            kotlin.Result$a r11 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.C4849c.a(r10)
            java.lang.Object r10 = kotlin.Result.b(r10)
        Ldf:
            java.lang.Throwable r10 = kotlin.Result.e(r10)
            if (r10 == 0) goto Lec
            java.lang.String r11 = "TaskLiveNotification"
            java.lang.String r0 = "cancelAllOnChannel failed"
            android.util.Log.w(r11, r0, r10)
        Lec:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Set<java.lang.Integer>> r10 = com.stepos.ailauncher.taskstore.livenotification.T.notificationIdMap
            r10.clear()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r10 = com.stepos.ailauncher.taskstore.livenotification.T.lastNotifiedStatus
            r10.clear()
            java.util.concurrent.ConcurrentHashMap$KeySetView<java.lang.String, java.lang.Boolean> r10 = com.stepos.ailauncher.taskstore.livenotification.T.createdSessions
            r10.clear()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r10 = com.stepos.ailauncher.taskstore.livenotification.T.pendingExecutingCapsuleToken
            r10.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.p(android.content.Context):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x036b A[LOOP:12: B:141:0x0365->B:143:0x036b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0210  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Set<java.lang.String> q(android.content.Context r20, java.util.Collection<java.lang.String> r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.T.q(android.content.Context, java.util.Collection, boolean):java.util.Set");
    }

    public final void t(Context appContext, NotificationManager manager, String sessionId, int keepId) {
        Object objB;
        Set<Integer> set = notificationIdMap.get(sessionId);
        if (set == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (((Number) obj).intValue() != keepId) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Log.d(TAG, "cancel other levels sessionId=" + sessionId + " keepId=" + keepId + " stale=" + arrayList);
        int iX = x(sessionId, LiveCardLevel.PERMISSION);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (iIntValue != iX) {
                v(appContext, manager, iIntValue);
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                manager.cancel(iIntValue);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "cancel other level failed sessionId=" + sessionId + " id=" + iIntValue, thE);
            }
            set.remove(Integer.valueOf(iIntValue));
        }
        if (set.isEmpty()) {
            notificationIdMap.remove(sessionId);
        }
    }

    public final void u(Context appContext, NotificationManager manager, String sessionId) {
        List listE;
        if (!channelCreated) {
            y(appContext);
        }
        Set<Integer> set = notificationIdMap.get(sessionId);
        int iX = x(sessionId, LiveCardLevel.PERMISSION);
        if (set == null || set.isEmpty()) {
            listE = C1172u.e(Integer.valueOf(x(sessionId, LiveCardLevel.SMALL)));
        } else {
            listE = new ArrayList();
            for (Object obj : set) {
                if (((Number) obj).intValue() != iX) {
                    listE.add(obj);
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (hashSet.add(Integer.valueOf(iIntValue))) {
                v(appContext, manager, iIntValue);
                Log.d(TAG, "endLiveNotification sessionId=" + sessionId + " notifId=" + iIntValue);
            }
        }
    }

    public final void v(Context appContext, NotificationManager manager, int notificationId) {
        Object objB;
        Notification notificationBuild = new Notification.Builder(appContext, CHANNEL_ID_SILENT).setSmallIcon(R$drawable.taskstore_live_small_icon).addExtras(l()).build();
        kotlin.jvm.internal.p.h(notificationBuild, "build(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            manager.notify(notificationId, notificationBuild);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "endLiveNotificationId failed notifId=" + notificationId, thE);
        }
    }

    public final boolean w(Context context) {
        boolean zA = androidx.core.app.m.b(context).a();
        if (!zA) {
            Log.w(TAG, "notification disabled at app/channel level, skip live notification");
        }
        return zA;
    }

    public final int x(String sessionId, LiveCardLevel level) {
        return U.i(sessionId, level);
    }

    public final void y(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (channelCreated) {
            return;
        }
        synchronized (this) {
            if (channelCreated) {
                return;
            }
            NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService(NotificationManager.class);
            if (notificationManager == null) {
                Log.w(TAG, "init failed: NotificationManager unavailable");
                return;
            }
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID_ALERT, context.getString(R$string.taskstore_live_notification_channel_name), 4);
            notificationChannel.setDescription(context.getString(R$string.taskstore_live_notification_channel_desc));
            notificationChannel.setShowBadge(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{0, 180, 80, 180});
            NotificationChannel notificationChannel2 = new NotificationChannel(CHANNEL_ID_SILENT, context.getString(R$string.taskstore_live_notification_silent_channel_name), 2);
            notificationChannel2.setDescription(context.getString(R$string.taskstore_live_notification_silent_channel_desc));
            notificationChannel2.setShowBadge(true);
            notificationChannel2.setSound(null, null);
            notificationChannel2.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.createNotificationChannel(notificationChannel2);
            channelCreated = true;
            Log.d(TAG, "live notification channels created: alert=taskstore_live_notification_channel silent=taskstore_live_notification_silent_channel");
        }
    }

    public final boolean z(String status) {
        String upperCase = status.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case 35394935:
                return upperCase.equals("PENDING");
            case 1383663147:
                return upperCase.equals("COMPLETED");
            case 1834295853:
                return upperCase.equals("WAITING");
            case 2066319421:
                return upperCase.equals("FAILED");
            default:
                return false;
        }
    }
}
