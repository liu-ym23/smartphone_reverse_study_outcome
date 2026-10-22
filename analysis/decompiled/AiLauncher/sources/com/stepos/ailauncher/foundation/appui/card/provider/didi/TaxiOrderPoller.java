package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import N5.CardEnvelope;
import Ua.C1060i;
import Ua.L0;
import Z8.C1173v;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.f0;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.n0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001NB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u001f\u0010 J+\u0010!\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0010H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b&\u0010'J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(H\u0082@¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00152\u0006\u0010)\u001a\u00020(2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b2\u00103J1\u00106\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\b2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000104H\u0002¢\u0006\u0004\b6\u00107R\u0014\u00108\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00158\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020(0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010DR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\b0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010H¨\u0006O"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderPoller;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "view", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "vendor", "", "orderNo", "platformOrderId", "cardTaskId", "", D6.a.KEY_TASK_STATUS, "LN5/i;", "terminalEnvelope", "LY8/t;", "u", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;LN5/i;)V", "p", "(Ljava/lang/String;)V", "", "n", "(Ljava/lang/String;)Z", "reason", "v", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;Ljava/lang/String;Ljava/lang/String;)V", "f", "(Ljava/lang/String;)LN5/i;", "k", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;Ljava/lang/Integer;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/Integer;LN5/i;)V", "l", "m", "()Z", "o", "(Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderPoller$a;", "entry", "q", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderPoller$a;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$a;", "ok", "e", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderPoller$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$a;)V", "s", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderPoller$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$a;)Z", "t", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderPoller$a;Ljava/lang/String;)V", "Lkotlin/Function0;", "extraTrace", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderPoller$a;Ljava/lang/String;Lp9/a;)V", "TAG", "Ljava/lang/String;", "ENABLED", "Z", "", "REQUEST_TIMEOUT_MS", "J", "LUa/M;", "scope", "LUa/M;", "", "entries", "Ljava/util/Map;", "concluded", "", "caocaoCancelledOrders", "Ljava/util/Set;", "Lkotlinx/coroutines/g;", "pollJob", "Lkotlinx/coroutines/g;", "", "CANCEL_TERMINAL_TASK_STATUSES", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaxiOrderPoller {
    public static final boolean ENABLED = true;
    private static final long REQUEST_TIMEOUT_MS = 10000;
    private static final String TAG = "TaxiOrderPoller";
    private static kotlinx.coroutines.g pollJob;
    public static final TaxiOrderPoller INSTANCE = new TaxiOrderPoller();
    private static final Ua.M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
    private static final Map<String, a> entries = new LinkedHashMap();
    private static final Map<String, String> concluded = new LinkedHashMap();
    private static final Set<String> caocaoCancelledOrders = new LinkedHashSet();
    private static final Set<Integer> CANCEL_TERMINAL_TASK_STATUSES = Z8.Y.j(7, 27);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(TaxiOrderPoller taxiOrderPoller, a aVar, String str, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5063a = null;
        }
        taxiOrderPoller.h(aVar, str, interfaceC5063a);
    }

    public static final Y8.t r(a aVar, long j10) {
        R5.b.INSTANCE.h("poller.budget.exhausted", Y8.j.a("orderNo", aVar.getOrderNo()), Y8.j.a("lastTaskStatus", aVar.getLastTaskStatus()), Y8.j.a("totalMs", Long.valueOf(j10)));
        return Y8.t.f7040a;
    }

    public final void e(a entry, f0.Ok ok) {
        a aVar;
        entry.q(0);
        Integer lastTaskStatus = entry.getLastTaskStatus();
        if (kotlin.jvm.internal.p.d(ok.getTrackStatus(), o0.TRACK_STATUS_PAUSED)) {
            entry.t(true);
            R5.b.INSTANCE.c("poller.stop", Y8.j.a("orderNo", entry.getOrderNo()), Y8.j.a("reason", o0.TRACK_STATUS_PAUSED));
            return;
        }
        boolean zS = s(entry, ok);
        Integer lastTaskStatus2 = entry.getLastTaskStatus();
        if (lastTaskStatus2 == null) {
            lastTaskStatus2 = ok.getTaskStatus();
        }
        entry.r(lastTaskStatus2);
        boolean zD = kotlin.jvm.internal.p.d(ok.getTrackStatus(), o0.TRACK_STATUS_TERMINAL);
        o0 o0Var = o0.INSTANCE;
        boolean zI = o0Var.i(entry.getLastTaskStatus());
        R5.b.INSTANCE.c("poller.result", Y8.j.a("orderNo", entry.getOrderNo()), Y8.j.a("fromStatus", lastTaskStatus), Y8.j.a("toStatus", entry.getLastTaskStatus()), Y8.j.a("trackStatus", ok.getTrackStatus()), Y8.j.a(M5.e.RESULT_RENDERED, Boolean.valueOf(zS)));
        if (!zD && !zI) {
            aVar = entry;
        } else {
            if (!o0Var.a(entry.getLastTaskStatus(), ok.getTrackStatus())) {
                i(this, entry, zD ? "platform_terminal" : "task_terminal", null, 4, null);
                return;
            }
            aVar = entry;
            aVar.u(aVar.getTerminalTicks() + 1);
            if (aVar.getTerminalTicks() > 2) {
                i(this, aVar, "finished_grace_done", null, 4, null);
                return;
            }
        }
        aVar.s(SystemClock.elapsedRealtime() + o0Var.d(aVar.getVendor(), ok.getNextPollAt(), aVar.getLastTaskStatus(), System.currentTimeMillis()));
    }

    public final CardEnvelope f(String orderNo) {
        n0.Snapshot snapshotK;
        if (orderNo == null) {
            return null;
        }
        if (orderNo.length() <= 0) {
            orderNo = null;
        }
        if (orderNo == null || (snapshotK = n0.INSTANCE.k(orderNo)) == null) {
            return null;
        }
        return snapshotK.getEnvelope();
    }

    public final boolean g(TaxiVendorSpec vendor, String reason, Integer taskStatus) {
        return vendor.getPollSource() == TaxiPollSource.DIDI_ADAPTER && kotlin.jvm.internal.p.d(reason, "http_400") && o0.INSTANCE.f(taskStatus);
    }

    public final void h(a entry, String reason, InterfaceC5063a<Y8.t> extraTrace) {
        entries.remove(entry.getOrderNo());
        concluded.put(entry.getOrderNo(), reason);
        if (extraTrace != null) {
            extraTrace.invoke();
        } else {
            R5.b.INSTANCE.c("poller.stop", Y8.j.a("orderNo", entry.getOrderNo()), Y8.j.a("reason", reason));
        }
    }

    public final void j(String orderNo, Integer taskStatus, CardEnvelope terminalEnvelope) {
        int terminalTicks;
        CardEnvelope envelope;
        CardEnvelope boundEnvelope;
        a aVar = entries.get(orderNo);
        if (!Z8.F.f0(CANCEL_TERMINAL_TASK_STATUSES, taskStatus) || terminalEnvelope == null || aVar == null) {
            if (aVar == null || 1 > (terminalTicks = aVar.getTerminalTicks()) || terminalTicks >= 3) {
                if (aVar != null) {
                    i(this, aVar, "terminal_on_bind", null, 4, null);
                    return;
                }
                Map<String, String> map = concluded;
                if (map.containsKey(orderNo)) {
                    return;
                }
                map.put(orderNo, "terminal_on_bind");
                R5.b.INSTANCE.c("poller.stop", Y8.j.a("orderNo", orderNo), Y8.j.a(D6.a.KEY_TASK_STATUS, taskStatus), Y8.j.a("reason", "terminal_on_bind"));
                return;
            }
            return;
        }
        List<DidiCardView> listN = aVar.n();
        List<DidiCardView> list = listN;
        Iterator<T> it = list.iterator();
        while (true) {
            envelope = null;
            if (!it.hasNext()) {
                boundEnvelope = null;
                break;
            } else {
                boundEnvelope = ((DidiCardView) it.next()).getBoundEnvelope();
                if (boundEnvelope != null) {
                    break;
                }
            }
        }
        if (boundEnvelope == null) {
            n0.Snapshot snapshotK = n0.INSTANCE.k(orderNo);
            if (snapshotK != null) {
                envelope = snapshotK.getEnvelope();
            }
        } else {
            envelope = boundEnvelope;
        }
        n0 n0Var = n0.INSTANCE;
        CardEnvelope cardEnvelopeJ = n0Var.j(envelope, terminalEnvelope);
        n0Var.l(orderNo, cardEnvelopeJ);
        entries.remove(orderNo);
        concluded.put(orderNo, "cancel_terminal_on_bind");
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            ((DidiCardView) it2.next()).m0(cardEnvelopeJ, orderNo, "cancel_terminal_on_bind", true);
        }
        R5.b.INSTANCE.c("poller.cancel.broadcast", Y8.j.a("orderNo", orderNo), Y8.j.a(D6.a.KEY_TASK_STATUS, taskStatus), Y8.j.a("terminalTaskId", terminalEnvelope.getTaskId()), Y8.j.a("subscribers", Integer.valueOf(listN.size())));
    }

    public final String k() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(com.stepos.ailauncher.foundation.account.f.INSTANCE.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        return str == null ? "" : str;
    }

    public final void l() {
        kotlinx.coroutines.g gVar = pollJob;
        if ((gVar == null || !gVar.b()) && m()) {
            pollJob = C1060i.d(scope, null, null, new TaxiOrderPoller$ensureRunning$1(null), 3, null);
        }
    }

    public final boolean m() {
        Collection<a> collectionValues = entries.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            return false;
        }
        for (a aVar : collectionValues) {
            if (!aVar.getPaused() && !aVar.n().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean n(String orderNo) {
        if (orderNo == null) {
            return false;
        }
        if (orderNo.length() <= 0) {
            orderNo = null;
        }
        if (orderNo == null) {
            return false;
        }
        return caocaoCancelledOrders.contains(orderNo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
    
        r1 = com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller.entries.values();
        r4 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00de, code lost:
    
        if (r1.hasNext() == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e0, code lost:
    
        r11 = r1.next();
        r12 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller.a) r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
    
        if (r12.getPaused() != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f7, code lost:
    
        if (r12.n().isEmpty() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        r4.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fd, code lost:
    
        r1 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0105, code lost:
    
        if (r1.hasNext() != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0107, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0109, code lost:
    
        r4 = g9.C4109a.g(((com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller.a) r1.next()).getNextDueAtElapsed());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011b, code lost:
    
        if (r1.hasNext() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011d, code lost:
    
        r11 = g9.C4109a.g(((com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller.a) r1.next()).getNextDueAtElapsed());
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012f, code lost:
    
        if (r4.compareTo(r11) <= 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0131, code lost:
    
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0133, code lost:
    
        if (r4 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0135, code lost:
    
        r11 = r4.longValue();
        r4 = v9.C5685n.g(r11 - android.os.SystemClock.elapsedRealtime(), 50);
        r2.L$0 = g9.h.a(r10);
        r2.L$1 = null;
        r2.L$2 = null;
        r2.J$0 = r8;
        r2.J$1 = r11;
        r6 = 2;
        r2.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015a, code lost:
    
        if (Ua.U.a(r4, r2) != r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015c, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9 A[EDGE_INSN: B:69:0x00c9->B:35:0x00c9 BREAK  A[LOOP:1: B:30:0x00a3->B:71:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x015a -> B:56:0x015d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(e9.InterfaceC4014c<? super Y8.t> r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller.o(e9.c):java.lang.Object");
    }

    public final void p(String orderNo) {
        if (orderNo != null) {
            if (orderNo.length() <= 0) {
                orderNo = null;
            }
            if (orderNo != null && caocaoCancelledOrders.add(orderNo)) {
                a aVar = entries.get(orderNo);
                List<DidiCardView> listN = aVar != null ? aVar.n() : null;
                if (listN == null) {
                    listN = C1173v.m();
                }
                R5.b.INSTANCE.c("poller.caocao.cancelled", Y8.j.a("orderNo", orderNo), Y8.j.a("subscribers", Integer.valueOf(listN.size())));
                Iterator<T> it = listN.iterator();
                while (it.hasNext()) {
                    ((DidiCardView) it.next()).U0(orderNo, "cancel_notified");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(final com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller.a r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$pollOnce$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$pollOnce$1 r0 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$pollOnce$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$pollOnce$1 r0 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$pollOnce$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r11 = r0.L$0
            com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$a r11 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller.a) r11
            kotlin.C4849c.b(r12)
        L2c:
            r3 = r11
            goto La7
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            kotlin.C4849c.b(r12)
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r11.getStartedAtElapsed()
            long r4 = r4 - r6
            com.stepos.ailauncher.foundation.appui.card.provider.didi.o0 r12 = com.stepos.ailauncher.foundation.appui.card.provider.didi.o0.INSTANCE
            boolean r12 = r12.e(r4)
            if (r12 == 0) goto L57
            com.stepos.ailauncher.foundation.appui.card.provider.didi.g0 r12 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.g0
            r12.<init>()
            java.lang.String r0 = "budget_exhausted"
            r10.h(r11, r0, r12)
            Y8.t r10 = Y8.t.f7040a
            return r10
        L57:
            R5.b r12 = R5.b.INSTANCE
            java.lang.String r2 = "orderNo"
            java.lang.String r6 = r11.getOrderNo()
            kotlin.Pair r2 = Y8.j.a(r2, r6)
            com.stepos.ailauncher.foundation.appui.card.provider.didi.p0 r6 = r11.getVendor()
            com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiPollSource r6 = r6.getPollSource()
            java.lang.String r7 = "source"
            kotlin.Pair r6 = Y8.j.a(r7, r6)
            java.lang.String r7 = "taskStatus"
            java.lang.Integer r8 = r11.getLastTaskStatus()
            kotlin.Pair r7 = Y8.j.a(r7, r8)
            java.lang.String r8 = "elapsedMs"
            java.lang.Long r9 = g9.C4109a.g(r4)
            kotlin.Pair r8 = Y8.j.a(r8, r9)
            kotlin.Pair[] r2 = new kotlin.Pair[]{r2, r6, r7, r8}
            java.lang.String r6 = "poller.tick"
            r12.c(r6, r2)
            com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$pollOnce$outcome$1 r12 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$pollOnce$outcome$1
            r2 = 0
            r12.<init>(r11, r2)
            r0.L$0 = r11
            r0.J$0 = r4
            r0.label = r3
            r2 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r12 = kotlinx.coroutines.TimeoutKt.e(r2, r12, r0)
            if (r12 != r1) goto L2c
            return r1
        La7:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0 r12 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.f0) r12
            if (r12 != 0) goto Lb2
            java.lang.String r11 = "timeout"
            r10.t(r3, r11)
            goto Ldc
        Lb2:
            boolean r11 = r12 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.f0.Retry
            if (r11 == 0) goto Lc0
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b r12 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.f0.Retry) r12
            java.lang.String r11 = r12.getReason()
            r10.t(r3, r11)
            goto Ldc
        Lc0:
            boolean r11 = r12 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.f0.Stop
            if (r11 == 0) goto Ld2
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c r12 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.f0.Stop) r12
            java.lang.String r4 = r12.getReason()
            r6 = 4
            r7 = 0
            r5 = 0
            r2 = r10
            i(r2, r3, r4, r5, r6, r7)
            goto Ldc
        Ld2:
            r2 = r10
            boolean r10 = r12 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.f0.Ok
            if (r10 == 0) goto Ldf
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$a r12 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.f0.Ok) r12
            r2.e(r3, r12)
        Ldc:
            Y8.t r10 = Y8.t.f7040a
            return r10
        Ldf:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller.q(com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderPoller$a, e9.c):java.lang.Object");
    }

    public final boolean s(a entry, f0.Ok ok) {
        CardEnvelope envelope;
        CardEnvelope boundEnvelope;
        n0 n0Var = n0.INSTANCE;
        CardEnvelope cardEnvelopeC = n0Var.c(ok.getSnapshot(), ok.getTaskStatus());
        if (cardEnvelopeC == null) {
            return false;
        }
        Integer taskStatus = cardEnvelopeC.getTaskStatus();
        if (taskStatus != null) {
            int iIntValue = taskStatus.intValue();
            if (!o0.INSTANCE.h(entry.getLastTaskStatus(), Integer.valueOf(iIntValue))) {
                R5.b.INSTANCE.c("poller.skip.stale", Y8.j.a("orderNo", entry.getOrderNo()), Y8.j.a("fromStatus", entry.getLastTaskStatus()), Y8.j.a("status", Integer.valueOf(iIntValue)));
                return false;
            }
            entry.r(Integer.valueOf(iIntValue));
        }
        if (n0Var.h(cardEnvelopeC)) {
            R5.b.INSTANCE.h("poller.snapshot.thin", Y8.j.a("orderNo", entry.getOrderNo()), Y8.j.a("snapshotKeys", ok.getSnapshot().keySet()));
            return false;
        }
        if (n0Var.d(cardEnvelopeC)) {
            i(this, entry, "empty_items", null, 4, null);
            return false;
        }
        List<DidiCardView> listN = entry.n();
        if (listN.isEmpty()) {
            return false;
        }
        List<DidiCardView> list = listN;
        Iterator<T> it = list.iterator();
        while (true) {
            envelope = null;
            if (!it.hasNext()) {
                boundEnvelope = null;
                break;
            }
            boundEnvelope = ((DidiCardView) it.next()).getBoundEnvelope();
            if (boundEnvelope != null) {
                break;
            }
        }
        if (boundEnvelope == null) {
            n0.Snapshot snapshotK = n0.INSTANCE.k(entry.getOrderNo());
            if (snapshotK != null) {
                envelope = snapshotK.getEnvelope();
            }
        } else {
            envelope = boundEnvelope;
        }
        CardEnvelope cardEnvelopeJ = n0Var.j(envelope, cardEnvelopeC);
        n0.INSTANCE.l(entry.getOrderNo(), cardEnvelopeJ);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            DidiCardView.n0((DidiCardView) it2.next(), cardEnvelopeJ, entry.getOrderNo(), null, false, 12, null);
        }
        return true;
    }

    public final void t(a entry, String reason) {
        entry.q(entry.getConsecutiveFailures() + 1);
        long jB = o0.INSTANCE.b(entry.getVendor(), entry.getConsecutiveFailures(), entry.getLastTaskStatus());
        entry.s(SystemClock.elapsedRealtime() + jB);
        R5.b.INSTANCE.h("poller.fail", Y8.j.a("orderNo", entry.getOrderNo()), Y8.j.a("source", entry.getVendor().getPollSource()), Y8.j.a("reason", reason), Y8.j.a("consecutiveFailures", Integer.valueOf(entry.getConsecutiveFailures())), Y8.j.a("nextDelayMs", Long.valueOf(jB)));
    }

    public final void u(DidiCardView view, TaxiVendorSpec vendor, String orderNo, String platformOrderId, String cardTaskId, Integer taskStatus, CardEnvelope terminalEnvelope) {
        Object obj;
        o0 o0Var;
        Object obj2;
        Object obj3;
        Integer num;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(vendor, "vendor");
        kotlin.jvm.internal.p.i(orderNo, "orderNo");
        if (orderNo.length() == 0) {
            return;
        }
        o0 o0Var2 = o0.INSTANCE;
        if (o0Var2.i(taskStatus)) {
            j(orderNo, taskStatus, terminalEnvelope);
            return;
        }
        if (o0Var2.f(taskStatus)) {
            Map<String, String> map = concluded;
            String str = map.get(orderNo);
            if (str != null) {
                if (!INSTANCE.g(vendor, str, taskStatus)) {
                    R5.b.INSTANCE.c("poller.skip.concluded", Y8.j.a("orderNo", orderNo), Y8.j.a("reason", str));
                    return;
                } else {
                    map.remove(orderNo);
                    R5.b.INSTANCE.c("poller.resume.concluded", Y8.j.a("orderNo", orderNo), Y8.j.a("priorReason", str), Y8.j.a(D6.a.KEY_TASK_STATUS, taskStatus));
                }
            }
            if (!TaxiOrderRepository.INSTANCE.j(vendor)) {
                R5.b.INSTANCE.h("poller.stop", Y8.j.a("orderNo", orderNo), Y8.j.a("source", vendor.getPollSource()), Y8.j.a("reason", "api_unavailable"));
                return;
            }
            if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
                R5.b.INSTANCE.c("poller.skip.privacy", Y8.j.a("orderNo", orderNo));
                return;
            }
            if (vendor.getPollSource() == TaxiPollSource.DIDI_ADAPTER && k().length() == 0) {
                R5.b.INSTANCE.h("poller.skip.noUserId", Y8.j.a("orderNo", orderNo));
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Map<String, a> map2 = entries;
            a aVar = map2.get(orderNo);
            if (aVar == null) {
                obj = "orderNo";
                o0Var = o0Var2;
                obj3 = D6.a.KEY_TASK_STATUS;
                obj2 = "source";
                a aVar2 = new a(orderNo, vendor, platformOrderId, cardTaskId, jElapsedRealtime, jElapsedRealtime, null, 0, 0, false, null, 1984, null);
                map2.put(orderNo, aVar2);
                aVar = aVar2;
            } else {
                obj = "orderNo";
                o0Var = o0Var2;
                obj2 = "source";
                obj3 = D6.a.KEY_TASK_STATUS;
            }
            a aVar3 = aVar;
            if (taskStatus != null) {
                num = taskStatus;
                if (o0Var.h(aVar3.getLastTaskStatus(), num)) {
                    aVar3.r(num);
                }
            } else {
                num = taskStatus;
            }
            if (!aVar3.m(view)) {
                aVar3.j().add(new WeakReference<>(view));
            }
            aVar3.t(false);
            R5.b.INSTANCE.c("poller.subscribe", Y8.j.a(obj, orderNo), Y8.j.a(obj2, vendor.getPollSource()), Y8.j.a(obj3, num), Y8.j.a("hasPlatformId", Boolean.valueOf(platformOrderId != null)), Y8.j.a("subscribers", Integer.valueOf(aVar3.n().size())));
            l();
        }
    }

    public final void v(DidiCardView view, String orderNo, String reason) {
        a aVar;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (orderNo != null) {
            if (orderNo.length() <= 0) {
                orderNo = null;
            }
            if (orderNo == null || (aVar = entries.get(orderNo)) == null || !aVar.o(view)) {
                return;
            }
            R5.b.INSTANCE.c("poller.unsubscribe", Y8.j.a("orderNo", orderNo), Y8.j.a("reason", reason), Y8.j.a("subscribers", Integer.valueOf(aVar.n().size())));
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b(\b\u0002\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b$\u0010 R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b%\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010&\u001a\u0004\b)\u0010(\"\u0004\b*\u0010+R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00101\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0014\u0010=\u001a\u0004\b>\u0010\u0019¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderPoller$a;", "", "", "orderNo", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "vendor", "platformOrderId", "cardTaskId", "", "startedAtElapsed", "nextDueAtElapsed", "", "lastTaskStatus", "consecutiveFailures", "terminalTicks", "", o0.TRACK_STATUS_PAUSED, "", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "subscribers", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/Integer;IIZLjava/util/List;)V", "", "n", "()Ljava/util/List;", "view", "m", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;)Z", "o", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "l", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_PKGNAME, "J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "e", "s", "(J)V", "Ljava/lang/Integer;", Const.INTENT_KEY_UMID, "()Ljava/lang/Integer;", "r", "(Ljava/lang/Integer;)V", "I", "c", "()I", "q", "(I)V", "k", "u", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "t", "(Z)V", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final String cardTaskId;
        private int consecutiveFailures;
        private Integer lastTaskStatus;
        private long nextDueAtElapsed;
        private final String orderNo;
        private boolean paused;
        private final String platformOrderId;
        private final long startedAtElapsed;
        private final List<WeakReference<DidiCardView>> subscribers;
        private int terminalTicks;
        private final TaxiVendorSpec vendor;

        public a(String orderNo, TaxiVendorSpec vendor, String str, String str2, long j10, long j11, Integer num, int i10, int i11, boolean z10, List<WeakReference<DidiCardView>> subscribers) {
            kotlin.jvm.internal.p.i(orderNo, "orderNo");
            kotlin.jvm.internal.p.i(vendor, "vendor");
            kotlin.jvm.internal.p.i(subscribers, "subscribers");
            this.orderNo = orderNo;
            this.vendor = vendor;
            this.platformOrderId = str;
            this.cardTaskId = str2;
            this.startedAtElapsed = j10;
            this.nextDueAtElapsed = j11;
            this.lastTaskStatus = num;
            this.consecutiveFailures = i10;
            this.terminalTicks = i11;
            this.paused = z10;
            this.subscribers = subscribers;
        }

        public static final boolean p(DidiCardView didiCardView, WeakReference it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.get() == didiCardView || it.get() == null;
        }

        /* renamed from: b, reason: from getter */
        public final String getCardTaskId() {
            return this.cardTaskId;
        }

        /* renamed from: c, reason: from getter */
        public final int getConsecutiveFailures() {
            return this.consecutiveFailures;
        }

        /* renamed from: d, reason: from getter */
        public final Integer getLastTaskStatus() {
            return this.lastTaskStatus;
        }

        /* renamed from: e, reason: from getter */
        public final long getNextDueAtElapsed() {
            return this.nextDueAtElapsed;
        }

        /* renamed from: f, reason: from getter */
        public final String getOrderNo() {
            return this.orderNo;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getPaused() {
            return this.paused;
        }

        /* renamed from: h, reason: from getter */
        public final String getPlatformOrderId() {
            return this.platformOrderId;
        }

        /* renamed from: i, reason: from getter */
        public final long getStartedAtElapsed() {
            return this.startedAtElapsed;
        }

        public final List<WeakReference<DidiCardView>> j() {
            return this.subscribers;
        }

        /* renamed from: k, reason: from getter */
        public final int getTerminalTicks() {
            return this.terminalTicks;
        }

        /* renamed from: l, reason: from getter */
        public final TaxiVendorSpec getVendor() {
            return this.vendor;
        }

        public final boolean m(DidiCardView view) {
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

        public final List<DidiCardView> n() {
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

        public final boolean o(final DidiCardView view) {
            kotlin.jvm.internal.p.i(view, "view");
            return Z8.A.L(this.subscribers, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.h0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(TaxiOrderPoller.a.p(view, (WeakReference) obj));
                }
            });
        }

        public final void q(int i10) {
            this.consecutiveFailures = i10;
        }

        public final void r(Integer num) {
            this.lastTaskStatus = num;
        }

        public final void s(long j10) {
            this.nextDueAtElapsed = j10;
        }

        public final void t(boolean z10) {
            this.paused = z10;
        }

        public final void u(int i10) {
            this.terminalTicks = i10;
        }

        public /* synthetic */ a(String str, TaxiVendorSpec taxiVendorSpec, String str2, String str3, long j10, long j11, Integer num, int i10, int i11, boolean z10, List list, int i12, kotlin.jvm.internal.i iVar) {
            this(str, taxiVendorSpec, str2, str3, j10, j11, (i12 & 64) != 0 ? null : num, (i12 & 128) != 0 ? 0 : i10, (i12 & 256) != 0 ? 0 : i11, (i12 & 512) != 0 ? false : z10, (i12 & 1024) != 0 ? new ArrayList() : list);
        }
    }
}
