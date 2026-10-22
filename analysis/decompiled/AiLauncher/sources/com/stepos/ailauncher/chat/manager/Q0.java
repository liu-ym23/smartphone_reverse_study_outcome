package com.stepos.ailauncher.chat.manager;

import Z8.C1172u;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001:B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0013\u0010\rJ\u001d\u0010\u0014\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\b\u0014\u0010\u0011J\u001b\u0010\u0017\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R$\u0010+\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00168\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00100\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010(R\u0014\u00103\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010(R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0004048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/Q0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/manager/Q0$a;", "listener", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/manager/Q0$a;)V", "r", "", "sessionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "", "sessionIds", "k", "(Ljava/util/Collection;)V", "l", "m", "n", "keys", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/Collection;)Z", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Collection;)Ljava/lang/Long;", "", "o", "(Ljava/util/Collection;)Ljava/util/Set;", "ids", "e", "(Ljava/util/Set;)V", "TAG", "Ljava/lang/String;", "editedSessionIds", "Ljava/util/Set;", "Ljava/util/concurrent/atomic/AtomicInteger;", HomeGestureEligibilityContract.EXTRA_GENERATION, "Ljava/util/concurrent/atomic/AtomicInteger;", "consumedGeneration", UxipConstants.f30680s, "awaitingSettlement", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "detailAutoTtsSessionIds", "detailAutoTtsSentAtMs", "J", "detailAutoTtsGeneration", "consumedDetailAutoTtsGeneration", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onMarkedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Q0 {
    private static final String TAG = "SessionExternalEditSignal";
    private static volatile boolean awaitingSettlement;
    private static volatile long detailAutoTtsSentAtMs;
    public static final Q0 INSTANCE = new Q0();
    private static volatile Set<String> editedSessionIds = Z8.Y.e();
    private static final AtomicInteger generation = new AtomicInteger(0);
    private static final AtomicInteger consumedGeneration = new AtomicInteger(0);
    private static volatile Set<String> detailAutoTtsSessionIds = Z8.Y.e();
    private static final AtomicInteger detailAutoTtsGeneration = new AtomicInteger(0);
    private static final AtomicInteger consumedDetailAutoTtsGeneration = new AtomicInteger(0);
    private static final CopyOnWriteArrayList<a> onMarkedListeners = new CopyOnWriteArrayList<>();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/Q0$a;", "", "", "", "sessionIds", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Set;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(Set<String> sessionIds);
    }

    public static final void d(a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        onMarkedListeners.addIfAbsent(listener);
    }

    public static final void f(Set set) {
        Object objB;
        Iterator<a> it = onMarkedListeners.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            a next = it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                next.a(set);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "onMarked listener failed", thE, false, 8, null);
            }
        }
    }

    public static final void j(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        k(C1172u.e(sessionId));
    }

    public static final void k(Collection<String> sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        Q0 q02 = INSTANCE;
        Set<String> setO = q02.o(sessionIds);
        if (setO.isEmpty()) {
            return;
        }
        awaitingSettlement = false;
        q02.e(setO);
    }

    public static final void l(Collection<String> sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        Q0 q02 = INSTANCE;
        Set<String> setO = q02.o(sessionIds);
        if (setO.isEmpty()) {
            return;
        }
        awaitingSettlement = true;
        detailAutoTtsSessionIds = setO;
        detailAutoTtsSentAtMs = System.currentTimeMillis();
        detailAutoTtsGeneration.incrementAndGet();
        q02.e(setO);
    }

    public static final void m(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        n(C1172u.e(sessionId));
    }

    public static final void n(Collection<String> sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        Q0 q02 = INSTANCE;
        Set<String> setO = q02.o(sessionIds);
        if (setO.isEmpty() || !awaitingSettlement) {
            return;
        }
        awaitingSettlement = false;
        q02.e(Z8.Z.o(editedSessionIds, setO));
    }

    public static final String p(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return La.H.D1(it).toString();
    }

    public static final boolean q(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.length() > 0;
    }

    public static final void r(a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        onMarkedListeners.remove(listener);
    }

    public final void e(final Set<String> ids) {
        editedSessionIds = ids;
        AtomicInteger atomicInteger = generation;
        atomicInteger.incrementAndGet();
        C4148a.k(TAG, "mark ids=" + ids + " awaitingSettlement=" + awaitingSettlement + " gen=" + atomicInteger.get() + " listeners=" + onMarkedListeners.size(), false, 4, null);
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.manager.P0
            @Override // java.lang.Runnable
            public final void run() {
                Q0.f(ids);
            }
        };
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            mainHandler.post(runnable);
        }
    }

    public final Long g(Collection<String> keys) {
        AtomicInteger atomicInteger;
        int i10;
        kotlin.jvm.internal.p.i(keys, "keys");
        Set<String> setO = o(keys);
        if (!setO.isEmpty()) {
            Set<String> set = detailAutoTtsSessionIds;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (setO.contains((String) it.next())) {
                        int i11 = detailAutoTtsGeneration.get();
                        if (i11 == 0) {
                            return null;
                        }
                        do {
                            atomicInteger = consumedDetailAutoTtsGeneration;
                            i10 = atomicInteger.get();
                            if (i10 == i11) {
                                return null;
                            }
                        } while (!atomicInteger.compareAndSet(i10, i11));
                        Long lValueOf = Long.valueOf(detailAutoTtsSentAtMs);
                        if (lValueOf.longValue() > 0) {
                            return lValueOf;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final boolean h(Collection<String> keys) {
        kotlin.jvm.internal.p.i(keys, "keys");
        if (editedSessionIds.isEmpty()) {
            return false;
        }
        Set<String> set = editedSessionIds;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (keys.contains((String) it.next())) {
                    int i10 = generation.get();
                    AtomicInteger atomicInteger = consumedGeneration;
                    if (atomicInteger.get() == i10) {
                        return false;
                    }
                    atomicInteger.set(i10);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean i() {
        return awaitingSettlement;
    }

    public final Set<String> o(Collection<String> sessionIds) {
        return SequencesKt___SequencesKt.f0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(Z8.F.d0(sessionIds), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.N0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Q0.p((String) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.O0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(Q0.q((String) obj));
            }
        }));
    }
}
