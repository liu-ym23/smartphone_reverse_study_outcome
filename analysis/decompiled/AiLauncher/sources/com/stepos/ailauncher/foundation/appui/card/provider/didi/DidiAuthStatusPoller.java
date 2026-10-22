package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import Ua.C1060i;
import Ua.L0;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.NetworkPhase;
import com.stepos.ailauncher.common.utils.NetworkStateMonitor;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001=B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0082@¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u0003J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0019068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusPoller;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "view", "", "thirdUid", "deviceId", "reason", "LY8/t;", "p", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "m", "(Ljava/lang/String;)V", "r", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;)V", "cardId", "s", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "k", "(Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusPoller$a;", "entry", "l", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusPoller$a;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusPoller$a;Ljava/lang/String;)V", "n", "o", "", "consecutiveUnavailable", "", "q", "(I)J", "", "ENABLED", "Z", "INTERVAL_MS", "J", "REQUEST_TIMEOUT_MS", "MAX_UNAVAILABLE_RETRY_MS", "REASON_AUTHORIZED", "Ljava/lang/String;", "REASON_BUDGET", "", "REVALIDATION_RESUME_REASONS", "Ljava/util/Set;", "LUa/M;", "scope", "LUa/M;", "", "entries", "Ljava/util/Map;", "concluded", "Lkotlinx/coroutines/g;", "pollJob", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiAuthStatusPoller {
    private static final boolean ENABLED = true;
    private static final long INTERVAL_MS = 2000;
    private static final long MAX_UNAVAILABLE_RETRY_MS = 60000;
    private static final String REASON_AUTHORIZED = "authorized";
    private static final String REASON_BUDGET = "budget_exhausted";
    private static final long REQUEST_TIMEOUT_MS = 5000;
    private static final Map<String, String> concluded;
    private static final Map<String, a> entries;
    private static kotlinx.coroutines.g pollJob;
    private static final Ua.M scope;
    public static final DidiAuthStatusPoller INSTANCE = new DidiAuthStatusPoller();
    private static final Set<String> REVALIDATION_RESUME_REASONS = Z8.Y.j("attached", "window_visible");

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller$1", f = "DidiAuthStatusPoller.kt", l = {107}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller$1$a */
        public static final class a<T> implements Xa.c {
            public static final a<T> INSTANCE = new a<>();

            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(NetworkPhase networkPhase, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                if (networkPhase == NetworkPhase.AVAILABLE) {
                    DidiAuthStatusPoller.INSTANCE.o();
                }
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.t<NetworkPhase> tVarE = NetworkStateMonitor.e();
                Xa.c<? super NetworkPhase> cVar = a.INSTANCE;
                this.label = 1;
                if (tVarE.collect(cVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    static {
        Ua.M mA = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
        scope = mA;
        entries = new LinkedHashMap();
        concluded = new LinkedHashMap();
        C1060i.d(mA, null, null, new AnonymousClass1(null), 3, null);
    }

    public final void h(a entry, String reason) {
        concluded.put(entry.getThirdUid(), reason);
        entries.remove(entry.getThirdUid());
        R5.b.INSTANCE.c("didi.authPoll.stop", Y8.j.a("accountScope", C3324v.INSTANCE.c(entry.getThirdUid())), Y8.j.a("reason", reason));
    }

    public final void i() {
        kotlinx.coroutines.g gVar = pollJob;
        if (gVar == null || !gVar.b()) {
            Collection<a> collectionValues = entries.values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                return;
            }
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((a) it.next()).k()) {
                    pollJob = C1060i.d(scope, null, null, new DidiAuthStatusPoller$ensureRunning$2(null), 3, null);
                    return;
                }
            }
        }
    }

    public final void j(String thirdUid, String reason) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (thirdUid.length() == 0) {
            return;
        }
        concluded.remove(thirdUid);
        a aVar = entries.get(thirdUid);
        if (aVar != null) {
            INSTANCE.n(aVar, reason);
        }
        R5.b.INSTANCE.c("didi.authPoll.invalidate", Y8.j.a("accountScope", C3324v.INSTANCE.c(thirdUid)), Y8.j.a("reason", reason));
        i();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0103 A[EDGE_INSN: B:73:0x0103->B:41:0x0103 BREAK  A[LOOP:2: B:36:0x00ca->B:76:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x018c -> B:60:0x018f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(e9.InterfaceC4014c<? super Y8.t> r17) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller.k(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller.a r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller.l(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller$a, e9.c):java.lang.Object");
    }

    public final void m(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        C1060i.d(scope, null, null, new DidiAuthStatusPoller$reset$1(reason, null), 3, null);
    }

    public final void n(a entry, String reason) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        entry.r(jElapsedRealtime);
        entry.p(jElapsedRealtime);
        entry.q(false);
        entry.o(0);
        R5.b.INSTANCE.c("didi.authPoll.entry.restarted", Y8.j.a("accountScope", C3324v.INSTANCE.c(entry.getThirdUid())), Y8.j.a("reason", reason));
    }

    public final void o() {
        Collection<a> collectionValues = entries.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            a aVar = (a) obj;
            if (aVar.getValidatingPersistedSnapshot() && aVar.getPausedForRevalidationBudget() && !aVar.l().isEmpty()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            INSTANCE.n((a) it.next(), SpriteEventAction.NETWORK_AVAILABLE);
            z10 = true;
        }
        if (z10) {
            i();
        }
    }

    public final void p(DidiCardView view, String thirdUid, String deviceId, String reason) {
        String str;
        Object obj;
        Object obj2;
        boolean z10;
        String str2;
        Object obj3;
        String str3;
        Object obj4;
        DidiAuthStatusPoller didiAuthStatusPoller;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (thirdUid.length() == 0) {
            return;
        }
        String strC = C3324v.INSTANCE.c(thirdUid);
        DidiAuthStatusRepository didiAuthStatusRepository = DidiAuthStatusRepository.INSTANCE;
        DidiAuthStatusDto didiAuthStatusDtoY = didiAuthStatusRepository.y(thirdUid);
        boolean zT = didiAuthStatusRepository.t(thirdUid);
        boolean z11 = (didiAuthStatusDtoY == null || zT) ? false : true;
        if (didiAuthStatusDtoY != null) {
            if (zT) {
                concluded.put(thirdUid, "authorized");
            }
            R5.b.INSTANCE.c("didi.authPoll.replay.cached", Y8.j.a("accountScope", strC), Y8.j.a("source", zT ? "network" : "persisted"));
            view.h0(didiAuthStatusDtoY, thirdUid, "cached_subscribe");
        }
        Map<String, String> map = concluded;
        String str4 = map.get(thirdUid);
        if (str4 != null) {
            if (!kotlin.jvm.internal.p.d(str4, "authorized")) {
                if (!z11 || !REVALIDATION_RESUME_REASONS.contains(reason)) {
                    R5.b.INSTANCE.c("didi.authPoll.skip.concluded", Y8.j.a("accountScope", strC), Y8.j.a("reason", str4));
                    return;
                }
                map.remove(thirdUid);
            }
            if (zT) {
                R5.b.INSTANCE.c("didi.authPoll.skip.concluded", Y8.j.a("accountScope", strC), Y8.j.a("reason", str4));
                return;
            }
            map.remove(thirdUid);
        }
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            R5.b.INSTANCE.c("didi.authPoll.skip.privacy", Y8.j.a("accountScope", strC));
            return;
        }
        if (!didiAuthStatusRepository.x()) {
            R5.b.INSTANCE.h("didi.authPoll.skip.api", Y8.j.a("accountScope", strC), Y8.j.a("reason", "didiOauth baseUrl 未配置"));
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, a> map2 = entries;
        a aVar = map2.get(thirdUid);
        if (aVar == null) {
            str = strC;
            obj2 = "reason";
            obj = "accountScope";
            z10 = true;
            a aVar2 = new a(thirdUid, deviceId, jElapsedRealtime, jElapsedRealtime, z11, false, 0, null, 224, null);
            map2.put(thirdUid, aVar2);
            aVar = aVar2;
        } else {
            str = strC;
            obj = "accountScope";
            obj2 = "reason";
            z10 = true;
        }
        a aVar3 = aVar;
        if (z11) {
            aVar3.s(z10);
        }
        if (aVar3.j(view)) {
            str2 = reason;
            obj3 = obj2;
            str3 = str;
            obj4 = obj;
        } else {
            aVar3.g().add(new WeakReference<>(view));
            str3 = str;
            obj4 = obj;
            str2 = reason;
            obj3 = obj2;
            R5.b.INSTANCE.c("didi.authPoll.subscribe", Y8.j.a(obj4, str3), Y8.j.a("subscribers", Integer.valueOf(aVar3.l().size())), Y8.j.a(obj3, str2));
        }
        if (!aVar3.getPausedForRevalidationBudget()) {
            didiAuthStatusPoller = this;
        } else if (!aVar3.getValidatingPersistedSnapshot() || !REVALIDATION_RESUME_REASONS.contains(str2)) {
            R5.b.INSTANCE.c("didi.authPoll.skip.revalidationPaused", Y8.j.a(obj4, str3), Y8.j.a(obj3, str2));
            return;
        } else {
            didiAuthStatusPoller = this;
            didiAuthStatusPoller.n(aVar3, str2);
        }
        didiAuthStatusPoller.i();
    }

    public final long q(int consecutiveUnavailable) {
        if (consecutiveUnavailable <= 0) {
            return 2000L;
        }
        return C5685n.k(2000 << C5685n.j(consecutiveUnavailable - 1, 10), 60000L);
    }

    public final void r(DidiCardView view, String thirdUid, String reason) {
        Map<String, a> map;
        a aVar;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (thirdUid != null) {
            if (thirdUid.length() <= 0) {
                thirdUid = null;
            }
            if (thirdUid == null || (aVar = (map = entries).get(thirdUid)) == null) {
                return;
            }
            aVar.m(view);
            int size = aVar.l().size();
            if (size == 0) {
                map.remove(thirdUid);
            }
            R5.b.INSTANCE.c("didi.authPoll.unsubscribe", Y8.j.a("accountScope", C3324v.INSTANCE.c(thirdUid)), Y8.j.a("left", Integer.valueOf(size)), Y8.j.a("reason", reason));
        }
    }

    public final void s(DidiCardView view, String thirdUid, String deviceId, String cardId, String reason) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (thirdUid.length() == 0 || cardId.length() == 0) {
            return;
        }
        C1060i.d(scope, null, null, new DidiAuthStatusPoller$validateOnce$1(thirdUid, cardId, C3324v.INSTANCE.c(thirdUid), reason, view, deviceId, null), 3, null);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b!\b\u0002\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010*R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010'\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010*R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u0010\u00102\u001a\u0004\b3\u0010\u0015¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusPoller$a;", "", "", "thirdUid", "deviceId", "", "startedAtElapsed", "nextDueAtElapsed", "", "validatingPersistedSnapshot", "pausedForRevalidationBudget", "", "consecutiveUnavailable", "", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "subscribers", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJZZILjava/util/List;)V", "", "l", "()Ljava/util/List;", "view", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;)Z", "m", "k", "()Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "c", "J", "f", "()J", "r", "(J)V", Const.INTENT_KEY_UMID, "p", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "s", "(Z)V", "e", "q", "I", Const.INTENT_KEY_PKGNAME, "()I", "o", "(I)V", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private int consecutiveUnavailable;
        private final String deviceId;
        private long nextDueAtElapsed;
        private boolean pausedForRevalidationBudget;
        private long startedAtElapsed;
        private final List<WeakReference<DidiCardView>> subscribers;
        private final String thirdUid;
        private boolean validatingPersistedSnapshot;

        public a(String thirdUid, String deviceId, long j10, long j11, boolean z10, boolean z11, int i10, List<WeakReference<DidiCardView>> subscribers) {
            kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
            kotlin.jvm.internal.p.i(deviceId, "deviceId");
            kotlin.jvm.internal.p.i(subscribers, "subscribers");
            this.thirdUid = thirdUid;
            this.deviceId = deviceId;
            this.startedAtElapsed = j10;
            this.nextDueAtElapsed = j11;
            this.validatingPersistedSnapshot = z10;
            this.pausedForRevalidationBudget = z11;
            this.consecutiveUnavailable = i10;
            this.subscribers = subscribers;
        }

        public static final boolean n(DidiCardView didiCardView, WeakReference it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.get() == null || it.get() == didiCardView;
        }

        /* renamed from: b, reason: from getter */
        public final int getConsecutiveUnavailable() {
            return this.consecutiveUnavailable;
        }

        /* renamed from: c, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* renamed from: d, reason: from getter */
        public final long getNextDueAtElapsed() {
            return this.nextDueAtElapsed;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getPausedForRevalidationBudget() {
            return this.pausedForRevalidationBudget;
        }

        /* renamed from: f, reason: from getter */
        public final long getStartedAtElapsed() {
            return this.startedAtElapsed;
        }

        public final List<WeakReference<DidiCardView>> g() {
            return this.subscribers;
        }

        /* renamed from: h, reason: from getter */
        public final String getThirdUid() {
            return this.thirdUid;
        }

        /* renamed from: i, reason: from getter */
        public final boolean getValidatingPersistedSnapshot() {
            return this.validatingPersistedSnapshot;
        }

        public final boolean j(DidiCardView view) {
            kotlin.jvm.internal.p.i(view, "view");
            List<WeakReference<DidiCardView>> list = this.subscribers;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == view) {
                    return true;
                }
            }
            return false;
        }

        public final boolean k() {
            return (this.pausedForRevalidationBudget || l().isEmpty()) ? false : true;
        }

        public final List<DidiCardView> l() {
            ArrayList arrayList = new ArrayList();
            Iterator<WeakReference<DidiCardView>> it = this.subscribers.iterator();
            while (it.hasNext()) {
                DidiCardView didiCardView = it.next().get();
                if (didiCardView == null) {
                    it.remove();
                } else {
                    arrayList.add(didiCardView);
                }
            }
            return arrayList;
        }

        public final boolean m(final DidiCardView view) {
            kotlin.jvm.internal.p.i(view, "view");
            return Z8.A.L(this.subscribers, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.n
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(DidiAuthStatusPoller.a.n(view, (WeakReference) obj));
                }
            });
        }

        public final void o(int i10) {
            this.consecutiveUnavailable = i10;
        }

        public final void p(long j10) {
            this.nextDueAtElapsed = j10;
        }

        public final void q(boolean z10) {
            this.pausedForRevalidationBudget = z10;
        }

        public final void r(long j10) {
            this.startedAtElapsed = j10;
        }

        public final void s(boolean z10) {
            this.validatingPersistedSnapshot = z10;
        }

        public /* synthetic */ a(String str, String str2, long j10, long j11, boolean z10, boolean z11, int i10, List list, int i11, kotlin.jvm.internal.i iVar) {
            this(str, str2, j10, j11, z10, (i11 & 32) != 0 ? false : z11, (i11 & 64) != 0 ? 0 : i10, (i11 & 128) != 0 ? new ArrayList() : list);
        }
    }
}
