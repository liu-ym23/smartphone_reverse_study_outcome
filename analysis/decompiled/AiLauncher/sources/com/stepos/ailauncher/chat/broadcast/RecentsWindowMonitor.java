package com.stepos.ailauncher.chat.broadcast;

import Y8.t;
import Z8.F;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.DialogC3116e0;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import io.ktor.http.ContentType;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010#\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001A\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002DEB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0017\u0010\u000bJ\u0015\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0015J!\u0010\u001b\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\u0004\b\u001d\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\u0004\b\u001f\u0010\u001cJ!\u0010 \u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\u0004\b \u0010\u001cJ#\u0010#\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010&J\u001f\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0012H\u0002¢\u0006\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010-R&\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0019018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R&\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u0019018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00103R$\u00106\u001a\u00020\t2\u0006\u00105\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u000bR\u0016\u00109\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00107R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor;", "", "<init>", "()V", "Landroid/app/Application;", ContentType.Application.TYPE, "LY8/t;", "k", "(Landroid/app/Application;)V", "", "l", "()Z", "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", "", "o", "()J", "", "reason", "e", "(Ljava/lang/String;)Z", "n", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "Lkotlin/Function1;", "listener", "c", "(Lp9/l;)V", "q", "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$LauncherGesture;", Const.INTENT_KEY_PKGNAME, "p", "action", "enterRecents", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)V", "from", Const.INTENT_KEY_UMID, "newState", "r", "(Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "ACTION_SHOW_GESTURE_VIEW", "ACTION_CANCEL_GESTURE_VIEW", "ACTION_ENTER_RECENTS", "", "listeners", "Ljava/util/Set;", "launcherGestureListeners", UxipConstants.f30680s, "isQuickSwitchInProgress", "Z", "m", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", "peekEnteredElapsed", "J", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "suppressMinusOneRestoreOnNextIdle", "Ljava/util/concurrent/atomic/AtomicBoolean;", "com/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$a", "receiver", "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$a;", "LauncherGesture", "RecentsState", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecentsWindowMonitor {
    private static final String ACTION_CANCEL_GESTURE_VIEW = "com.android.systemui.recents.action.CANCEL_GESTURE_VIEW";
    private static final String ACTION_ENTER_RECENTS = "com.stepos.ACTION_ENTER_RECENTS";
    private static final String ACTION_SHOW_GESTURE_VIEW = "com.android.systemui.recents.action.SHOW_GESTURE_VIEW";
    private static final String TAG = "RecentsWindowMonitor";
    private static volatile boolean initialized;
    private static volatile boolean isQuickSwitchInProgress;
    private static volatile long peekEnteredElapsed;
    public static final RecentsWindowMonitor INSTANCE = new RecentsWindowMonitor();
    private static final Set<InterfaceC5074l<RecentsState, t>> listeners = new LinkedHashSet();
    private static final Set<InterfaceC5074l<LauncherGesture, t>> launcherGestureListeners = new LinkedHashSet();
    private static volatile RecentsState state = RecentsState.IDLE;
    private static final AtomicBoolean suppressMinusOneRestoreOnNextIdle = new AtomicBoolean(false);
    private static final a receiver = new a();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$LauncherGesture;", "", "action", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "QUICK_SWITCH_START", "BACK_TO_HOME", "QUICK_SWITCH", "CANCEL_GESTURE_VIEW", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LauncherGesture {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ LauncherGesture[] $VALUES;
        private final String action;
        public static final LauncherGesture QUICK_SWITCH_START = new LauncherGesture("QUICK_SWITCH_START", 0, "com.stepos.ACTION_QUICK_SWITCH_START");
        public static final LauncherGesture BACK_TO_HOME = new LauncherGesture("BACK_TO_HOME", 1, DialogC3116e0.ACTION_BACK_TO_HOME);
        public static final LauncherGesture QUICK_SWITCH = new LauncherGesture("QUICK_SWITCH", 2, "com.stepos.ACTION_QUICK_SWITCH");
        public static final LauncherGesture CANCEL_GESTURE_VIEW = new LauncherGesture("CANCEL_GESTURE_VIEW", 3, "com.stepos.ACTION_CANCEL_GESTURE_VIEW");

        private static final /* synthetic */ LauncherGesture[] $values() {
            return new LauncherGesture[]{QUICK_SWITCH_START, BACK_TO_HOME, QUICK_SWITCH, CANCEL_GESTURE_VIEW};
        }

        static {
            LauncherGesture[] launcherGestureArr$values = $values();
            $VALUES = launcherGestureArr$values;
            $ENTRIES = kotlin.enums.a.a(launcherGestureArr$values);
        }

        private LauncherGesture(String str, int i10, String str2) {
            this.action = str2;
        }

        public static InterfaceC4149a<LauncherGesture> getEntries() {
            return $ENTRIES;
        }

        public static LauncherGesture valueOf(String str) {
            return (LauncherGesture) Enum.valueOf(LauncherGesture.class, str);
        }

        public static LauncherGesture[] values() {
            return (LauncherGesture[]) $VALUES.clone();
        }

        public final String getAction() {
            return this.action;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PEEK", "OVERVIEW", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class RecentsState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ RecentsState[] $VALUES;
        public static final RecentsState IDLE = new RecentsState("IDLE", 0);
        public static final RecentsState PEEK = new RecentsState("PEEK", 1);
        public static final RecentsState OVERVIEW = new RecentsState("OVERVIEW", 2);

        private static final /* synthetic */ RecentsState[] $values() {
            return new RecentsState[]{IDLE, PEEK, OVERVIEW};
        }

        static {
            RecentsState[] recentsStateArr$values = $values();
            $VALUES = recentsStateArr$values;
            $ENTRIES = kotlin.enums.a.a(recentsStateArr$values);
        }

        private RecentsState(String str, int i10) {
        }

        public static InterfaceC4149a<RecentsState> getEntries() {
            return $ENTRIES;
        }

        public static RecentsState valueOf(String str) {
            return (RecentsState) Enum.valueOf(RecentsState.class, str);
        }

        public static RecentsState[] values() {
            return (RecentsState[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$a", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            p.i(context, "context");
            p.i(intent, "intent");
            RecentsWindowMonitor recentsWindowMonitor = RecentsWindowMonitor.INSTANCE;
            String action = intent.getAction();
            boolean z10 = false;
            if (p.d(intent.getAction(), "com.stepos.ACTION_ENTER_RECENTS") && intent.getBooleanExtra("enter", false)) {
                z10 = true;
            }
            recentsWindowMonitor.j(action, z10);
        }
    }

    public final void b(InterfaceC5074l<? super LauncherGesture, t> listener) {
        p.i(listener, "listener");
        launcherGestureListeners.add(listener);
    }

    public final void c(InterfaceC5074l<? super RecentsState, t> listener) {
        Object objB;
        p.i(listener, "listener");
        Set<InterfaceC5074l<RecentsState, t>> set = listeners;
        synchronized (set) {
            set.add(listener);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            listener.invoke(state);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "addStateChangeListener: initial callback failed", thE);
        }
    }

    public final void d(String from) {
        if (state == RecentsState.IDLE) {
            peekEnteredElapsed = SystemClock.elapsedRealtime();
            r(RecentsState.PEEK, from);
            return;
        }
        Log.w(TAG, "SHOW_GESTURE ignored already=" + state + " elapsed=" + o() + "ms from=" + from);
    }

    public final boolean e(String reason) {
        p.i(reason, "reason");
        if (state != RecentsState.PEEK) {
            return false;
        }
        suppressMinusOneRestoreOnNextIdle.set(true);
        r(RecentsState.IDLE, "explicit-wake:" + reason);
        return true;
    }

    public final boolean f(String reason) {
        p.i(reason, "reason");
        if (state != RecentsState.PEEK) {
            return false;
        }
        RecentsState recentsState = state;
        state = RecentsState.IDLE;
        peekEnteredElapsed = 0L;
        Log.d(TAG, "state: " + recentsState + " -> IDLE (from=stuck-peek:" + reason + " silent)");
        return true;
    }

    public final boolean g() {
        return suppressMinusOneRestoreOnNextIdle.getAndSet(false);
    }

    public final RecentsState h() {
        return state;
    }

    public final void i(String action) {
        LauncherGesture next;
        LauncherGesture launcherGesture;
        Object objB;
        if (p.d(action, "com.android.systemui.recents.action.CANCEL_GESTURE_VIEW")) {
            launcherGesture = LauncherGesture.CANCEL_GESTURE_VIEW;
        } else {
            Iterator<LauncherGesture> it = LauncherGesture.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (p.d(next.getAction(), action)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            launcherGesture = next;
        }
        if (launcherGesture == null) {
            return;
        }
        isQuickSwitchInProgress = launcherGesture == LauncherGesture.QUICK_SWITCH_START;
        for (InterfaceC5074l interfaceC5074l : F.m1(launcherGestureListeners)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5074l.invoke(launcherGesture);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "launcher gesture callback failed: " + action, thE);
            }
        }
    }

    public final void j(String action, boolean enterRecents) {
        i(action);
        if (p.d(action, "com.android.systemui.recents.action.SHOW_GESTURE_VIEW")) {
            d(action);
            return;
        }
        if (p.d(action, "com.android.systemui.recents.action.CANCEL_GESTURE_VIEW")) {
            if (state == RecentsState.PEEK) {
                r(RecentsState.IDLE, action);
                return;
            }
            return;
        }
        if (p.d(action, LauncherGesture.BACK_TO_HOME.getAction())) {
            if (state == RecentsState.PEEK) {
                suppressMinusOneRestoreOnNextIdle.set(true);
                r(RecentsState.IDLE, action);
                return;
            }
            return;
        }
        if (p.d(action, "com.stepos.ACTION_ENTER_RECENTS")) {
            if (enterRecents) {
                r(RecentsState.OVERVIEW, action + "(enter=true)");
                return;
            }
            r(RecentsState.IDLE, action + "(enter=false)");
        }
    }

    public final void k(Application application) {
        p.i(application, "application");
        if (initialized) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        Iterator<LauncherGesture> it = LauncherGesture.getEntries().iterator();
        while (it.hasNext()) {
            intentFilter.addAction(it.next().getAction());
        }
        intentFilter.addAction("com.android.systemui.recents.action.SHOW_GESTURE_VIEW");
        intentFilter.addAction("com.android.systemui.recents.action.CANCEL_GESTURE_VIEW");
        intentFilter.addAction("com.stepos.ACTION_ENTER_RECENTS");
        application.registerReceiver(receiver, intentFilter, 2);
        initialized = true;
        Log.d(TAG, "init: registered receiver");
    }

    public final boolean l() {
        return state == RecentsState.OVERVIEW;
    }

    public final boolean m() {
        return isQuickSwitchInProgress;
    }

    public final boolean n() {
        return suppressMinusOneRestoreOnNextIdle.get();
    }

    public final long o() {
        if (state != RecentsState.PEEK || peekEnteredElapsed <= 0) {
            return -1L;
        }
        return SystemClock.elapsedRealtime() - peekEnteredElapsed;
    }

    public final void p(InterfaceC5074l<? super LauncherGesture, t> listener) {
        p.i(listener, "listener");
        launcherGestureListeners.remove(listener);
    }

    public final void q(InterfaceC5074l<? super RecentsState, t> listener) {
        p.i(listener, "listener");
        Set<InterfaceC5074l<RecentsState, t>> set = listeners;
        synchronized (set) {
            set.remove(listener);
        }
    }

    public final void r(RecentsState newState, String from) {
        List<InterfaceC5074l> listM1;
        Object objB;
        RecentsState recentsState = state;
        if (recentsState == newState) {
            return;
        }
        RecentsState recentsState2 = RecentsState.PEEK;
        if (newState == recentsState2) {
            suppressMinusOneRestoreOnNextIdle.set(false);
        }
        if (newState != recentsState2) {
            peekEnteredElapsed = 0L;
        } else if (peekEnteredElapsed <= 0) {
            peekEnteredElapsed = SystemClock.elapsedRealtime();
        }
        state = newState;
        Log.d(TAG, "state: " + recentsState + " -> " + newState + " (from=" + from + ")");
        Set<InterfaceC5074l<RecentsState, t>> set = listeners;
        synchronized (set) {
            listM1 = F.m1(set);
        }
        for (InterfaceC5074l interfaceC5074l : listM1) {
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5074l.invoke(newState);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "listener callback failed", thE);
            }
        }
    }
}
