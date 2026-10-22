package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import Ua.C1060i;
import Ua.L0;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoAuthStatusPoller;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "view", "", "accountKey", "vendorId", "integrationId", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "key", "reason", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;Ljava/lang/String;Ljava/lang/String;)V", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoAuthStatusPoller$a;", "entry", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoAuthStatusPoller$a;Le9/c;)Ljava/lang/Object;", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "INTERVAL_MS", "J", "REQUEST_TIMEOUT_MS", "LUa/M;", "scope", "LUa/M;", "", "entries", "Ljava/util/Map;", "", "concluded", "Ljava/util/Set;", "Lkotlinx/coroutines/g;", "pollJob", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CaocaoAuthStatusPoller {
    private static final long INTERVAL_MS = 2000;
    private static final long REQUEST_TIMEOUT_MS = 5000;
    private static kotlinx.coroutines.g pollJob;
    public static final CaocaoAuthStatusPoller INSTANCE = new CaocaoAuthStatusPoller();
    private static final Ua.M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
    private static final Map<String, a> entries = new LinkedHashMap();
    private static final Set<String> concluded = new LinkedHashSet();

    public static final boolean k(DidiCardView didiCardView, WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null || it.get() == didiCardView;
    }

    public final void d() {
        kotlinx.coroutines.g gVar = pollJob;
        if ((gVar == null || !gVar.b()) && !entries.isEmpty()) {
            pollJob = C1060i.d(scope, null, null, new CaocaoAuthStatusPoller$ensureRunning$1(null), 3, null);
        }
    }

    public final void e(String accountKey, String vendorId, String integrationId, String reason) {
        kotlin.jvm.internal.p.i(accountKey, "accountKey");
        kotlin.jvm.internal.p.i(vendorId, "vendorId");
        kotlin.jvm.internal.p.i(integrationId, "integrationId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (accountKey.length() == 0) {
            return;
        }
        String strF = f(accountKey, vendorId, integrationId);
        concluded.remove(strF);
        a aVar = entries.get(strF);
        if (aVar != null) {
            aVar.i(SystemClock.elapsedRealtime());
        }
        R5.b.INSTANCE.c("caocao.authPoll.invalidate", Y8.j.a("key", strF), Y8.j.a("reason", reason));
        d();
    }

    public final String f(String accountKey, String vendorId, String integrationId) {
        return accountKey + "|" + vendorId + "|" + integrationId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f8, code lost:
    
        r14 = com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.entries.values();
        r1 = new java.util.ArrayList();
        r14 = r14.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010d, code lost:
    
        if (r14.hasNext() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010f, code lost:
    
        r8 = r14.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0120, code lost:
    
        if (((com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.a) r8).h().isEmpty() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0122, code lost:
    
        r1.add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0126, code lost:
    
        r14 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012e, code lost:
    
        if (r14.hasNext() != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0130, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0132, code lost:
    
        r1 = g9.C4109a.g(((com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.a) r14.next()).getNextDueAtElapsed());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0144, code lost:
    
        if (r14.hasNext() == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0146, code lost:
    
        r8 = g9.C4109a.g(((com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.a) r14.next()).getNextDueAtElapsed());
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0158, code lost:
    
        if (r1.compareTo(r8) <= 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015a, code lost:
    
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x015c, code lost:
    
        if (r1 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015e, code lost:
    
        r8 = r1.longValue();
        r10 = v9.C5685n.g(r8 - android.os.SystemClock.elapsedRealtime(), 0);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.J$0 = r6;
        r0.J$1 = r8;
        r0.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0180, code lost:
    
        if (Ua.U.a(r10, r0) != r15) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f8 A[EDGE_INSN: B:62:0x00f8->B:41:0x00f8 BREAK  A[LOOP:0: B:36:0x00c5->B:65:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0180 -> B:17:0x004b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.g(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.a r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$pollOnce$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$pollOnce$1 r0 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$pollOnce$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$pollOnce$1 r0 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$pollOnce$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r9 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r8 = r0.L$0
            com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$a r8 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.a) r8
            kotlin.C4849c.b(r7)
            goto L55
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.C4849c.b(r7)
            long r3 = android.os.SystemClock.elapsedRealtime()
            r5 = 2000(0x7d0, double:9.88E-321)
            long r3 = r3 + r5
            r8.i(r3)
            com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$pollOnce$result$1 r7 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$pollOnce$result$1
            r1 = 0
            r7.<init>(r8, r1)
            r0.L$0 = r8
            r0.label = r2
            r1 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.e(r1, r7, r0)
            if (r7 != r9) goto L55
            return r9
        L55:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b r7 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b) r7
            if (r7 != 0) goto L5b
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b$c r7 = com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b.c.INSTANCE
        L5b:
            boolean r9 = r7 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b.Authorized
            java.lang.String r0 = "poll"
            if (r9 == 0) goto L92
            java.util.Set<java.lang.String> r7 = com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.concluded
            java.lang.String r9 = r8.getKey()
            r7.add(r9)
            java.util.Map<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$a> r7 = com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.entries
            java.lang.String r9 = r8.getKey()
            r7.remove(r9)
            java.util.List r7 = r8.h()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L7e:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto Lbc
            java.lang.Object r9 = r7.next()
            com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView r9 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView) r9
            java.lang.String r1 = r8.getAccountKey()
            r9.i0(r1, r0)
            goto L7e
        L92:
            boolean r9 = r7 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b.NotAuthorized
            if (r9 == 0) goto Lb4
            java.util.List r7 = r8.h()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        La0:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto Lbc
            java.lang.Object r9 = r7.next()
            com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView r9 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView) r9
            java.lang.String r1 = r8.getAccountKey()
            r9.j0(r1, r0)
            goto La0
        Lb4:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b$c r8 = com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b.c.INSTANCE
            boolean r7 = kotlin.jvm.internal.p.d(r7, r8)
            if (r7 == 0) goto Lbf
        Lbc:
            Y8.t r7 = Y8.t.f7040a
            return r7
        Lbf:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.h(com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$a, e9.c):java.lang.Object");
    }

    public final void i(DidiCardView view, String accountKey, String vendorId, String integrationId) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(accountKey, "accountKey");
        kotlin.jvm.internal.p.i(vendorId, "vendorId");
        kotlin.jvm.internal.p.i(integrationId, "integrationId");
        if (accountKey.length() == 0 || vendorId.length() == 0 || integrationId.length() == 0 || !com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return;
        }
        String strF = f(accountKey, vendorId, integrationId);
        Set<String> set = concluded;
        if (set.contains(strF)) {
            if (CaocaoCredentialStatusRepository.INSTANCE.k(accountKey, vendorId, integrationId) != null) {
                return;
            } else {
                set.remove(strF);
            }
        }
        if (CaocaoCredentialStatusRepository.INSTANCE.j()) {
            Map<String, a> map = entries;
            a aVar = map.get(strF);
            if (aVar == null) {
                aVar = new a(strF, accountKey, vendorId, integrationId, null, 0L, 48, null);
                map.put(strF, aVar);
            }
            a aVar2 = aVar;
            if (!aVar2.g(view)) {
                aVar2.e().add(new WeakReference<>(view));
            }
            d();
        }
    }

    public final void j(final DidiCardView view, String key, String reason) {
        Map<String, a> map;
        a aVar;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (key != null) {
            if (key.length() <= 0) {
                key = null;
            }
            if (key == null || (aVar = (map = entries).get(key)) == null) {
                return;
            }
            Z8.A.L(aVar.e(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(CaocaoAuthStatusPoller.k(view, (WeakReference) obj));
                }
            });
            if (aVar.h().isEmpty()) {
                map.remove(key);
            }
            R5.b.INSTANCE.c("caocao.authPoll.unsubscribe", Y8.j.a("key", key), Y8.j.a("reason", reason));
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoAuthStatusPoller$a;", "", "", "key", "accountKey", "vendorId", "integrationId", "", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "subscribers", "", "nextDueAtElapsed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;J)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/util/List;", "view", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;)Z", "Ljava/lang/String;", "c", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "f", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "e", "J", Const.INTENT_KEY_UMID, "()J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final String accountKey;
        private final String integrationId;
        private final String key;
        private long nextDueAtElapsed;
        private final List<WeakReference<DidiCardView>> subscribers;
        private final String vendorId;

        public a(String key, String accountKey, String vendorId, String integrationId, List<WeakReference<DidiCardView>> subscribers, long j10) {
            kotlin.jvm.internal.p.i(key, "key");
            kotlin.jvm.internal.p.i(accountKey, "accountKey");
            kotlin.jvm.internal.p.i(vendorId, "vendorId");
            kotlin.jvm.internal.p.i(integrationId, "integrationId");
            kotlin.jvm.internal.p.i(subscribers, "subscribers");
            this.key = key;
            this.accountKey = accountKey;
            this.vendorId = vendorId;
            this.integrationId = integrationId;
            this.subscribers = subscribers;
            this.nextDueAtElapsed = j10;
        }

        /* renamed from: a, reason: from getter */
        public final String getAccountKey() {
            return this.accountKey;
        }

        /* renamed from: b, reason: from getter */
        public final String getIntegrationId() {
            return this.integrationId;
        }

        /* renamed from: c, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* renamed from: d, reason: from getter */
        public final long getNextDueAtElapsed() {
            return this.nextDueAtElapsed;
        }

        public final List<WeakReference<DidiCardView>> e() {
            return this.subscribers;
        }

        /* renamed from: f, reason: from getter */
        public final String getVendorId() {
            return this.vendorId;
        }

        public final boolean g(DidiCardView view) {
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

        public final List<DidiCardView> h() {
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

        public final void i(long j10) {
            this.nextDueAtElapsed = j10;
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ a(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.List r13, long r14, int r16, kotlin.jvm.internal.i r17) {
            /*
                r8 = this;
                r0 = r16 & 16
                if (r0 == 0) goto L9
                java.util.ArrayList r13 = new java.util.ArrayList
                r13.<init>()
            L9:
                r5 = r13
                r13 = r16 & 32
                if (r13 == 0) goto L19
                long r0 = android.os.SystemClock.elapsedRealtime()
                r6 = r0
                r2 = r10
                r3 = r11
                r4 = r12
                r0 = r8
                r1 = r9
                goto L1f
            L19:
                r6 = r14
                r0 = r8
                r1 = r9
                r2 = r10
                r3 = r11
                r4 = r12
            L1f:
                r0.<init>(r1, r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, long, int, kotlin.jvm.internal.i):void");
        }
    }
}
