package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import h9.InterfaceC4149a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002,-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump;", "", "<init>", "()V", "", "taskId", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "", "k", "(Ljava/lang/String;Ljava/lang/String;)Z", "e", "(Ljava/lang/String;)Z", "f", "reason", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "cleaned", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "delayMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;J)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$a;", "session", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$a;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "jumped", Const.INTENT_KEY_UMID, "(Ljava/lang/String;ZLjava/lang/String;)V", "DELAY_MS", "J", "RETRY_MS", "", "MAX_RETRIES", "I", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/ConcurrentHashMap;", "sessions", "Ljava/util/concurrent/ConcurrentHashMap;", "State", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlipayExecutingAutoJump {
    public static final long DELAY_MS = 1000;
    private static final int MAX_RETRIES = 7;
    private static final long RETRY_MS = 150;
    public static final AlipayExecutingAutoJump INSTANCE = new AlipayExecutingAutoJump();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ConcurrentHashMap<String, a> sessions = new ConcurrentHashMap<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$State;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING_DRAW", "PENDING", "DONE", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State WAITING_DRAW = new State("WAITING_DRAW", 0);
        public static final State PENDING = new State("PENDING", 1);
        public static final State DONE = new State("DONE", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{WAITING_DRAW, PENDING, DONE};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10) {
        }

        public static InterfaceC4149a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.WAITING_DRAW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void j(String str) {
        INSTANCE.g(str);
    }

    public final void b(String taskId, String reason) {
        a aVar;
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (taskId.length() == 0 || (aVar = sessions.get(taskId)) == null) {
            return;
        }
        State state = aVar.getState();
        State state2 = State.DONE;
        if (state == state2) {
            return;
        }
        c(aVar);
        aVar.h(state2);
        R5.b.INSTANCE.c("alipay.autoJump.skip", Y8.j.a("taskId", taskId), Y8.j.a("reason", reason));
    }

    public final void c(a session) {
        Runnable runnable = session.getRunnable();
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        session.g(null);
    }

    public final void d(String taskId, boolean jumped, String appLink) {
        a aVar = sessions.get(taskId);
        if (aVar == null) {
            return;
        }
        c(aVar);
        aVar.h(State.DONE);
        R5.b.INSTANCE.c("alipay.autoJump.fire", Y8.j.a("taskId", taskId), Y8.j.a("jumped", Boolean.valueOf(jumped)), Y8.j.a(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, appLink));
    }

    public final boolean e(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (taskId.length() <= 0) {
            return false;
        }
        a aVar = sessions.get(taskId);
        return (aVar != null ? aVar.getState() : null) == State.WAITING_DRAW;
    }

    public final boolean f(String taskId, String appLink) {
        a aVar;
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (taskId.length() == 0 || (aVar = sessions.get(taskId)) == null) {
            return false;
        }
        h(taskId, N5.j.INSTANCE.d(appLink));
        if (aVar.getState() != State.WAITING_DRAW) {
            return false;
        }
        aVar.h(State.PENDING);
        aVar.f(0);
        R5.b.INSTANCE.c("alipay.autoJump.visible", Y8.j.a("taskId", taskId));
        i(taskId, 1000L);
        return true;
    }

    public final void g(String taskId) {
        a aVar = sessions.get(taskId);
        if (aVar != null && aVar.getState() == State.PENDING) {
            String appLink = aVar.getAppLink();
            if (appLink == null || appLink.length() == 0) {
                b(taskId, "noLink");
                return;
            }
            N5.d dVarA = N5.z.INSTANCE.a(taskId);
            AlipayXuiCardView alipayXuiCardView = dVarA instanceof AlipayXuiCardView ? (AlipayXuiCardView) dVarA : null;
            if (alipayXuiCardView != null && alipayXuiCardView.E0(taskId)) {
                d(taskId, alipayXuiCardView.L0(appLink), appLink);
            } else {
                if (aVar.getRetries() >= 7) {
                    b(taskId, "left");
                    return;
                }
                aVar.f(aVar.getRetries() + 1);
                R5.b.INSTANCE.c("alipay.autoJump.retry", Y8.j.a("taskId", taskId), Y8.j.a("retry", Integer.valueOf(aVar.getRetries())));
                i(taskId, 150L);
            }
        }
    }

    public final void h(String taskId, String cleaned) {
        a aVar;
        if (cleaned == null || (aVar = sessions.get(taskId)) == null || aVar.getState() == State.DONE || kotlin.jvm.internal.p.d(aVar.getAppLink(), cleaned)) {
            return;
        }
        aVar.e(cleaned);
        R5.b.INSTANCE.c("alipay.autoJump.linkUpdate", Y8.j.a("taskId", taskId), Y8.j.a(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, cleaned));
    }

    public final void i(final String taskId, long delayMs) {
        a aVar = sessions.get(taskId);
        if (aVar == null) {
            return;
        }
        c(aVar);
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.c
            @Override // java.lang.Runnable
            public final void run() {
                AlipayExecutingAutoJump.j(taskId);
            }
        };
        aVar.g(runnable);
        mainHandler.postDelayed(runnable, delayMs);
    }

    public final boolean k(String taskId, String appLink) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (taskId.length() == 0) {
            return false;
        }
        if (O.INSTANCE.b(taskId)) {
            R5.b.INSTANCE.c("alipay.autoJump.skip", Y8.j.a("taskId", taskId), Y8.j.a("reason", o0.TRACK_STATUS_TERMINAL));
            return false;
        }
        String strD = N5.j.INSTANCE.d(appLink);
        ConcurrentHashMap<String, a> concurrentHashMap = sessions;
        a aVar = concurrentHashMap.get(taskId);
        if (aVar == null) {
            if (strD != null) {
                concurrentHashMap.put(taskId, new a(State.WAITING_DRAW, strD, 0, null, 12, null));
                R5.b.INSTANCE.c("alipay.autoJump.arm", Y8.j.a("taskId", taskId), Y8.j.a("hasLink", Boolean.TRUE));
                return true;
            }
            concurrentHashMap.put(taskId, new a(State.DONE, null, 0, null, 14, null));
            R5.b.INSTANCE.c("alipay.autoJump.skip", Y8.j.a("taskId", taskId), Y8.j.a("reason", "noLink"));
            return false;
        }
        int i10 = b.$EnumSwitchMapping$0[aVar.getState().ordinal()];
        if (i10 == 1) {
            R5.b.INSTANCE.c("alipay.autoJump.skip", Y8.j.a("taskId", taskId), Y8.j.a("reason", "already"));
            return false;
        }
        if (i10 == 2) {
            h(taskId, strD);
            return true;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        h(taskId, strD);
        return false;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$a;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$State;", VoiceWakeupReceiver.EXTRA_STATE, "", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "", "retries", "Ljava/lang/Runnable;", "runnable", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$State;Ljava/lang/String;ILjava/lang/Runnable;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$State;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$State;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayExecutingAutoJump$State;)V", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "I", Const.INTENT_KEY_PKGNAME, "()I", "f", "(I)V", "Ljava/lang/Runnable;", "c", "()Ljava/lang/Runnable;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Runnable;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private String appLink;
        private int retries;
        private Runnable runnable;
        private State state;

        public a(State state, String str, int i10, Runnable runnable) {
            kotlin.jvm.internal.p.i(state, "state");
            this.state = state;
            this.appLink = str;
            this.retries = i10;
            this.runnable = runnable;
        }

        /* renamed from: a, reason: from getter */
        public final String getAppLink() {
            return this.appLink;
        }

        /* renamed from: b, reason: from getter */
        public final int getRetries() {
            return this.retries;
        }

        /* renamed from: c, reason: from getter */
        public final Runnable getRunnable() {
            return this.runnable;
        }

        /* renamed from: d, reason: from getter */
        public final State getState() {
            return this.state;
        }

        public final void e(String str) {
            this.appLink = str;
        }

        public final void f(int i10) {
            this.retries = i10;
        }

        public final void g(Runnable runnable) {
            this.runnable = runnable;
        }

        public final void h(State state) {
            kotlin.jvm.internal.p.i(state, "<set-?>");
            this.state = state;
        }

        public /* synthetic */ a(State state, String str, int i10, Runnable runnable, int i11, kotlin.jvm.internal.i iVar) {
            this(state, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : runnable);
        }
    }
}
