package com.stepos.ailauncher.migu.play;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0003J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/migu/play/MiguInstallState;", "", "<init>", "()V", "Lkotlin/Function0;", "LY8/t;", "observer", Const.INTENT_KEY_APIKEY, "(Lp9/a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "", "percent", "f", "(I)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Integer;", "c", "e", Const.INTENT_KEY_PKGNAME, "", "installed", "Lcom/stepos/ailauncher/migu/play/MiguInstallState$Phase;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Boolean;)Lcom/stepos/ailauncher/migu/play/MiguInstallState$Phase;", "progress", "Ljava/lang/Integer;", "pendingFromClick", "Z", "awaitingOpen", "Ljava/util/concurrent/CopyOnWriteArrayList;", "observers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Phase", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MiguInstallState {
    private static volatile boolean awaitingOpen;
    private static volatile boolean pendingFromClick;
    private static volatile Integer progress;
    public static final MiguInstallState INSTANCE = new MiguInstallState();
    private static final CopyOnWriteArrayList<InterfaceC5063a<Y8.t>> observers = new CopyOnWriteArrayList<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/migu/play/MiguInstallState$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "INSTALLING", "AWAITING_OPEN", "INSTALLED", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Phase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase IDLE = new Phase("IDLE", 0);
        public static final Phase INSTALLING = new Phase("INSTALLING", 1);
        public static final Phase AWAITING_OPEN = new Phase("AWAITING_OPEN", 2);
        public static final Phase INSTALLED = new Phase("INSTALLED", 3);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{IDLE, INSTALLING, AWAITING_OPEN, INSTALLED};
        }

        static {
            Phase[] phaseArr$values = $values();
            $VALUES = phaseArr$values;
            $ENTRIES = kotlin.enums.a.a(phaseArr$values);
        }

        private Phase(String str, int i10) {
        }

        public static InterfaceC4149a<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }
    }

    public final void a(InterfaceC5063a<Y8.t> observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        observers.addIfAbsent(observer);
    }

    public final void b() {
        awaitingOpen = false;
        progress = null;
        pendingFromClick = false;
    }

    public final void c() {
        pendingFromClick = true;
        awaitingOpen = false;
        d();
    }

    public final void d() {
        Iterator<T> it = observers.iterator();
        while (it.hasNext()) {
            InterfaceC5063a interfaceC5063a = (InterfaceC5063a) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5063a.invoke();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void e() {
        progress = null;
        pendingFromClick = false;
        awaitingOpen = true;
    }

    public final void f(int percent) {
        if (1 > percent || percent >= 101) {
            return;
        }
        progress = Integer.valueOf(percent);
        awaitingOpen = false;
    }

    public final Integer g() {
        return progress;
    }

    public final void h(InterfaceC5063a<Y8.t> observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        observers.remove(observer);
    }

    public final Phase i(Boolean installed) {
        return awaitingOpen ? Phase.AWAITING_OPEN : (progress != null || pendingFromClick) ? Phase.INSTALLING : kotlin.jvm.internal.p.d(installed, Boolean.TRUE) ? Phase.INSTALLED : Phase.IDLE;
    }
}
