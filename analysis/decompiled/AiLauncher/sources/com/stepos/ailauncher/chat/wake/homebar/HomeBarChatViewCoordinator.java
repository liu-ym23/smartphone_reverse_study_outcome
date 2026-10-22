package com.stepos.ailauncher.chat.wake.homebar;

import android.app.Application;
import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.U0;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.sheet.DesktopChatResidentController;
import com.stepos.ailauncher.chat.wake.C3172w;
import com.stepos.ailauncher.chat.wake.N;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarDisableManager;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import com.stepos.ailauncher.container.l0;
import com.stepos.ailauncher.container.m0;
import com.stepos.core.download.ModelFlowMeta;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.lang.ref.WeakReference;
import java.util.Set;
import k5.C4814a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0003J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarChatViewCoordinator;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "n", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "activity", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)V", "", "o", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "showMinorModeNotice", "f", "(Z)Z", "c", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "TAG", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarChatViewCoordinator$Mode;", "mode", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarChatViewCoordinator$Mode;", "Lcom/stepos/ailauncher/chat/wake/homebar/x;", "showRequest", "Lcom/stepos/ailauncher/chat/wake/homebar/x;", "Ljava/lang/ref/WeakReference;", "prewarmRef", "Ljava/lang/ref/WeakReference;", "revealWhenReady", "Z", "cancelled", "Mode", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeBarChatViewCoordinator {
    private static final String TAG = "HomeBarChatView";
    private static volatile boolean cancelled;
    private static WeakReference<ChatActivity> prewarmRef;
    private static volatile boolean revealWhenReady;
    public static final HomeBarChatViewCoordinator INSTANCE = new HomeBarChatViewCoordinator();
    private static Mode mode = Mode.NONE;
    private static final x showRequest = new x();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarChatViewCoordinator$Mode;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "EMBEDDED", "REUSE", "DEFERRED_STACK_LAUNCH", "PREWARM_NEW", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode NONE = new Mode(ModelFlowMeta.PLAN_NONE, 0);
        public static final Mode EMBEDDED = new Mode("EMBEDDED", 1);
        public static final Mode REUSE = new Mode("REUSE", 2);
        public static final Mode DEFERRED_STACK_LAUNCH = new Mode("DEFERRED_STACK_LAUNCH", 3);
        public static final Mode PREWARM_NEW = new Mode("PREWARM_NEW", 4);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{NONE, EMBEDDED, REUSE, DEFERRED_STACK_LAUNCH, PREWARM_NEW};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = kotlin.enums.a.a(modeArr$values);
        }

        private Mode(String str, int i10) {
        }

        public static InterfaceC4149a<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.EMBEDDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.REUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Mode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Mode.DEFERRED_STACK_LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Mode.PREWARM_NEW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Y8.t l(long j10, Mode mode2) {
        if (!showRequest.b(j10)) {
            return Y8.t.f7040a;
        }
        HomeBarChatViewCoordinator homeBarChatViewCoordinator = INSTANCE;
        if (!homeBarChatViewCoordinator.f(true) && !homeBarChatViewCoordinator.e()) {
            C4148a.k(TAG, "onShow → restore mode=" + mode2 + " request=" + j10, false, 4, null);
            A.d();
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t m(long j10) throws Resources.NotFoundException {
        if (!showRequest.b(j10)) {
            return Y8.t.f7040a;
        }
        HomeBarChatViewCoordinator homeBarChatViewCoordinator = INSTANCE;
        if (!homeBarChatViewCoordinator.f(true) && !homeBarChatViewCoordinator.e() && !cancelled) {
            l0.INSTANCE.f();
            WeakReference<ChatActivity> weakReference = prewarmRef;
            ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
            if (chatActivity == null || chatActivity.isFinishing() || chatActivity.isDestroyed()) {
                revealWhenReady = true;
                C4148a.k(TAG, "onShow: prewarm Activity not ready, reveal when attached", false, 4, null);
            } else {
                chatActivity.D9();
                homeBarChatViewCoordinator.g();
            }
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    public final void c() throws Resources.NotFoundException {
        Mode mode2 = mode;
        Mode mode3 = Mode.PREWARM_NEW;
        boolean z10 = mode2 == mode3;
        WeakReference<ChatActivity> weakReference = prewarmRef;
        ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
        if (mode == mode3 && chatActivity != null && !chatActivity.isFinishing() && !chatActivity.isDestroyed()) {
            chatActivity.h7();
        }
        prewarmRef = null;
        revealWhenReady = false;
        mode = Mode.NONE;
        if (z10) {
            C3172w.INSTANCE.f();
        }
    }

    public final void d(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (f(revealWhenReady)) {
            activity.h7();
            return;
        }
        if (cancelled) {
            C4148a.k(TAG, "attachPrewarm: already cancelled, finish", false, 4, null);
            activity.h7();
            return;
        }
        prewarmRef = new WeakReference<>(activity);
        if (revealWhenReady) {
            revealWhenReady = false;
            activity.D9();
            g();
        }
    }

    public final boolean e() throws Resources.NotFoundException {
        if (!MicOccupancyMonitor.INSTANCE.r()) {
            return false;
        }
        C4148a.k(TAG, "onShow blocked: system call", false, 4, null);
        WakeService.INSTANCE.N(C3197a.INSTANCE.a(), C4814a.BOTTOM_BAR_KEY_LONG_CLICK);
        i();
        A.i(0L, 0L, 0L, 3, null);
        return true;
    }

    public final boolean f(boolean showMinorModeNotice) throws Resources.NotFoundException {
        boolean zA = N.INSTANCE.a(C3197a.INSTANCE.a(), showMinorModeNotice ? C4814a.BOTTOM_BAR_KEY_LONG_CLICK : null);
        if (zA && !HomeBarDisableManager.INSTANCE.e()) {
            return false;
        }
        Set<HomeBarDisableManager.Scene> setC = HomeBarDisableManager.INSTANCE.c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ignored: minorMode=");
        sb2.append(!zA);
        sb2.append(", scenes=");
        sb2.append(setC);
        C4148a.k(TAG, sb2.toString(), false, 4, null);
        i();
        A.i(0L, 0L, 0L, 3, null);
        return true;
    }

    public final void g() {
        mode = Mode.NONE;
        prewarmRef = null;
    }

    public final void h(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        WeakReference<ChatActivity> weakReference = prewarmRef;
        if ((weakReference != null ? weakReference.get() : null) == activity) {
            prewarmRef = null;
        }
    }

    public final void i() throws Resources.NotFoundException {
        showRequest.c();
        cancelled = true;
        revealWhenReady = false;
        WeakReference<ChatActivity> weakReference = prewarmRef;
        ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
        boolean z10 = mode == Mode.PREWARM_NEW;
        g();
        if (z10 && chatActivity != null && !chatActivity.isFinishing() && !chatActivity.isDestroyed()) {
            C4148a.k(TAG, "onCancel → finish prewarm ChatActivity", false, 4, null);
            chatActivity.h7();
        }
        if (z10) {
            C3172w.INSTANCE.f();
        }
    }

    public final void j() throws Resources.NotFoundException {
        showRequest.d();
        if (com.stepos.ailauncher.chat.minor.a.INSTANCE.c() || HomeBarDisableManager.INSTANCE.e()) {
            i();
            return;
        }
        if (MicOccupancyMonitor.INSTANCE.r()) {
            c();
            cancelled = true;
            revealWhenReady = false;
            C4148a.k(TAG, "onPressed skipped prewarm: system call", false, 4, null);
            return;
        }
        g.e(g.INSTANCE, null, 1, null);
        c();
        cancelled = false;
        revealWhenReady = false;
        Application applicationA = C3197a.INSTANCE.a();
        RecentsWindowMonitor.INSTANCE.e("homebar-pressed");
        m0.INSTANCE.k();
        if (!AuthManager.INSTANCE.K()) {
            mode = Mode.NONE;
            C4148a.k(TAG, "onPressed ignored: amoo is disabled", false, 4, null);
            return;
        }
        if (!U0.INSTANCE.r()) {
            mode = Mode.NONE;
            C4148a.k(TAG, "onPressed ignored: navigation wake disabled", false, 4, null);
            return;
        }
        if (DesktopChatResidentController.H3()) {
            mode = Mode.NONE;
            C4148a.k(TAG, "onPressed ignored: HOME just consumed", false, 4, null);
            return;
        }
        if (DesktopChatResidentController.P1()) {
            mode = Mode.NONE;
            C4148a.k(TAG, "onPressed ignored: chat page already foreground", false, 4, null);
            return;
        }
        if (l0.INSTANCE.e()) {
            mode = Mode.EMBEDDED;
            C4148a.k(TAG, "onPressed → wait embedded restore (no Activity)", false, 4, null);
            return;
        }
        if (DesktopChatResidentController.t0()) {
            mode = Mode.REUSE;
            C4148a.k(TAG, "onPressed → wait reuse existing ChatActivity", false, 4, null);
        } else if (C2739j.INSTANCE.G(applicationA)) {
            mode = Mode.DEFERRED_STACK_LAUNCH;
            C4148a.k(TAG, "onPressed → wait stacked restore (no prewarm Activity)", false, 4, null);
        } else {
            mode = Mode.PREWARM_NEW;
            C4148a.k(TAG, "onPressed → prewarm transparent ChatActivity", false, 4, null);
            String sessionId = C3172w.INSTANCE.j().getSessionId();
            C2739j.t(applicationA, sessionId, sessionId != null, false, true, 8, null);
        }
    }

    public final void k() {
        Long lA;
        if (f(true) || e() || (lA = showRequest.a()) == null) {
            return;
        }
        final long jLongValue = lA.longValue();
        int i10 = a.$EnumSwitchMapping$0[mode.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            final Mode mode2 = mode;
            mode = Mode.NONE;
            g.INSTANCE.d(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.homebar.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return HomeBarChatViewCoordinator.l(jLongValue, mode2);
                }
            });
        } else {
            if (i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            g.INSTANCE.d(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.homebar.b
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return HomeBarChatViewCoordinator.m(jLongValue);
                }
            });
        }
    }

    public final void n() {
        showRequest.d();
        cancelled = false;
        k();
    }

    public final boolean o() {
        return cancelled || com.stepos.ailauncher.chat.minor.a.INSTANCE.c() || HomeBarDisableManager.INSTANCE.e() || MicOccupancyMonitor.INSTANCE.r();
    }
}
