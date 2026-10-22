package com.stepos.ailauncher.foundation.appui.card.state;

import La.H;
import La.K;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import Z8.Y;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import o6.C5009a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0004\b \u0010\u0003J\u0019\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00172\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010\u0003J\u0017\u0010.\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u001fJ\u0017\u0010/\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00100JG\u00107\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00062.\u00106\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010504\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000105H\u0002¢\u0006\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010=\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010:R\u0014\u0010?\u001a\u00020>8\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010:R\u0014\u0010B\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010:R\u0014\u0010C\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010:R\u0014\u0010D\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010J¨\u0006L"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/state/k;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/state/c;", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "", "stateType", "phase", "", "metadata", "", "nowWallMs", "Lcom/stepos/ailauncher/foundation/appui/card/state/j;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;J)Lcom/stepos/ailauncher/foundation/appui/card/state/j;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;)Lcom/stepos/ailauncher/foundation/appui/card/state/j;", "reason", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "", "c", "()Z", "record", "f", "(Lcom/stepos/ailauncher/foundation/appui/card/state/j;)V", "recordId", "e", "(Ljava/lang/String;)V", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/state/j;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/Set;", "index", "q", "(Ljava/util/Set;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/state/k$a;", AuthSessionDto.STATUS_PENDING, "r", "(Lcom/stepos/ailauncher/foundation/appui/card/state/k$a;)Z", "m", "n", "k", "(Ljava/lang/String;)Ljava/lang/String;", UxipConstants.f30680s, "o", "event", "", "Lkotlin/Pair;", "fields", "p", "(Ljava/lang/String;[Lkotlin/Pair;)V", "MMKV_ID", "Ljava/lang/String;", "RECORD_INDEX_KEY", "PENDING_WRITE_KEY", "RECORD_PREFIX", "", "SCHEMA_VERSION", "I", "OP_UPSERT", "OP_DELETE", "OP_CLEAR_ALL", "lock", "Ljava/lang/Object;", "Ljava/util/LinkedHashMap;", "memory", "Ljava/util/LinkedHashMap;", "loaded", "Z", "storageAvailable", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class k {
    private static final String MMKV_ID = "card_ui_state_v1";
    private static final String OP_CLEAR_ALL = "CLEAR_ALL";
    private static final String OP_DELETE = "DELETE";
    private static final String OP_UPSERT = "UPSERT";
    private static final String PENDING_WRITE_KEY = "pending_write_v1";
    private static final String RECORD_INDEX_KEY = "record_index_v1";
    private static final String RECORD_PREFIX = "record_v1_";
    private static final int SCHEMA_VERSION = 1;
    private static boolean loaded;
    private static boolean storageAvailable;
    public static final k INSTANCE = new k();
    private static final Object lock = new Object();
    private static final LinkedHashMap<String, CardUiStateRecord> memory = new LinkedHashMap<>();

    public static /* synthetic */ CardUiStateRecord h(k kVar, CardStateIdentity cardStateIdentity, String str, String str2, Map map, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i10 & 8) != 0) {
            map = kotlin.collections.a.i();
        }
        Map map2 = map;
        if ((i10 & 16) != 0) {
            j10 = System.currentTimeMillis();
        }
        return kVar.g(cardStateIdentity, str, str3, map2, j10);
    }

    public final void a(CardStateIdentity identity, String reason) {
        p.i(identity, "identity");
        p.i(reason, "reason");
        if (H.x0(identity.getAccountScope()) || H.x0(identity.getTaskId())) {
            return;
        }
        synchronized (lock) {
            try {
                INSTANCE.b();
                Collection<CardUiStateRecord> collectionValues = memory.values();
                p.h(collectionValues, "<get-values>(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    CardUiStateRecord cardUiStateRecord = (CardUiStateRecord) obj;
                    if (p.d(cardUiStateRecord.getIdentity().getAccountScope(), identity.getAccountScope()) && p.d(cardUiStateRecord.getIdentity().getTemplateType(), identity.getTemplateType()) && p.d(cardUiStateRecord.getIdentity().getBizChannel(), identity.getBizChannel()) && p.d(cardUiStateRecord.getIdentity().getTaskId(), identity.getTaskId()) && !p.d(cardUiStateRecord.getIdentity().getRevisionFingerprint(), identity.getRevisionFingerprint())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<String> arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((CardUiStateRecord) it.next()).getRecordId());
                }
                for (String str : arrayList2) {
                    memory.remove(str);
                    INSTANCE.e(str);
                }
                if (!arrayList2.isEmpty()) {
                    INSTANCE.p("card.ui_state.clear", Y8.j.a("templateType", identity.getTemplateType()), Y8.j.a("bizChannel", identity.getBizChannel()), Y8.j.a("taskId", identity.getTaskId()), Y8.j.a("count", Integer.valueOf(arrayList2.size())), Y8.j.a("reason", reason));
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        if (loaded) {
            return;
        }
        loaded = true;
        boolean zC = c();
        storageAvailable = zC;
        if (zC) {
            l();
            Set<String> setI = i();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : setI) {
                k kVar = INSTANCE;
                CardUiStateRecord cardUiStateRecordJ = kVar.j(str);
                if (cardUiStateRecordJ == null || cardUiStateRecordJ.getSchemaVersion() != 1) {
                    kVar.n(str);
                } else {
                    memory.put(str, cardUiStateRecordJ);
                    linkedHashSet.add(str);
                }
            }
            if (p.d(linkedHashSet, setI)) {
                return;
            }
            q(linkedHashSet);
        }
    }

    public final boolean c() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            C5009a.INSTANCE.d(C3197a.INSTANCE.a());
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("card.ui_state.load.fail", Y8.j.a("reason", "storage_init"), Y8.j.a("exception", thE.getClass().getSimpleName()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final CardUiStateRecord d(CardStateIdentity identity) {
        p.i(identity, "identity");
        CardUiStateRecord cardUiStateRecord = null;
        if (H.x0(identity.getTaskId()) || H.x0(identity.getAccountScope())) {
            return null;
        }
        synchronized (lock) {
            INSTANCE.b();
            CardUiStateRecord cardUiStateRecord2 = memory.get(identity.c());
            if (cardUiStateRecord2 != null) {
                if (cardUiStateRecord2.getSchemaVersion() == 1) {
                    cardUiStateRecord = cardUiStateRecord2;
                }
            }
        }
        return cardUiStateRecord;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = com.stepos.ailauncher.foundation.appui.card.state.k.storageAvailable
            if (r0 != 0) goto L6
            goto L7b
        L6:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L41
            com.stepos.ailauncher.foundation.appui.card.state.k$a r1 = new com.stepos.ailauncher.foundation.appui.card.state.k$a     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = "DELETE"
            r5 = 4
            r6 = 0
            r4 = 0
            r3 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L36
            r7.r(r1)     // Catch: java.lang.Throwable -> L36
            r7.n(r3)     // Catch: java.lang.Throwable -> L36
            java.util.Set r8 = r7.i()     // Catch: java.lang.Throwable -> L36
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L36
            java.util.Set r8 = Z8.F.q1(r8)     // Catch: java.lang.Throwable -> L36
            r8.remove(r3)     // Catch: java.lang.Throwable -> L36
            boolean r8 = r7.q(r8)     // Catch: java.lang.Throwable -> L36
            if (r8 == 0) goto L39
            r7.m()     // Catch: java.lang.Throwable -> L36
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L36
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L36
            goto L4e
        L36:
            r0 = move-exception
        L37:
            r7 = r0
            goto L44
        L39:
            java.lang.String r7 = "index_write_failed"
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L36
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L36
            throw r8     // Catch: java.lang.Throwable -> L36
        L41:
            r0 = move-exception
            r3 = r8
            goto L37
        L44:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L4e:
            java.lang.Throwable r7 = kotlin.Result.e(r7)
            if (r7 == 0) goto L7b
            R5.b r8 = R5.b.INSTANCE
            com.stepos.ailauncher.foundation.appui.card.state.k r0 = com.stepos.ailauncher.foundation.appui.card.state.k.INSTANCE
            java.lang.String r0 = r0.o(r3)
            java.lang.String r1 = "recordId"
            kotlin.Pair r0 = Y8.j.a(r1, r0)
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.String r1 = "reason"
            kotlin.Pair r7 = Y8.j.a(r1, r7)
            kotlin.Pair[] r7 = new kotlin.Pair[]{r0, r7}
            java.lang.String r0 = "card.ui_state.persist.fail"
            r8.h(r0, r7)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.state.k.e(java.lang.String):void");
    }

    public final void f(CardUiStateRecord record) {
        Object objB;
        Object objB2;
        Set<String> setQ1;
        if (storageAvailable) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(N5.k.INSTANCE.b().toJson(record));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            String str = (String) objB;
            if (str == null || str.length() == 0) {
                R5.b.INSTANCE.h("card.ui_state.persist.fail", Y8.j.a("recordId", o(record.getRecordId())), Y8.j.a("reason", "serialize"));
                return;
            }
            try {
                r(new PendingWrite(OP_UPSERT, record.getRecordId(), str));
                C5009a.INSTANCE.H(MMKV_ID, k(record.getRecordId()), str);
                setQ1 = F.q1(i());
                setQ1.add(record.getRecordId());
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (!q(setQ1)) {
                throw new IllegalStateException("index_write_failed");
            }
            m();
            objB2 = Result.b(t.f7040a);
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                R5.b.INSTANCE.h("card.ui_state.persist.fail", Y8.j.a("recordId", INSTANCE.o(record.getRecordId())), Y8.j.a("reason", thE.getClass().getSimpleName()));
            }
        }
    }

    public final CardUiStateRecord g(CardStateIdentity identity, String stateType, String phase, Map<String, String> metadata, long nowWallMs) {
        CardUiStateRecord cardUiStateRecord;
        p.i(identity, "identity");
        p.i(stateType, "stateType");
        p.i(metadata, "metadata");
        if (H.x0(identity.getTaskId()) || H.x0(identity.getAccountScope())) {
            return null;
        }
        synchronized (lock) {
            try {
                k kVar = INSTANCE;
                kVar.b();
                String strC = identity.c();
                LinkedHashMap<String, CardUiStateRecord> linkedHashMap = memory;
                CardUiStateRecord cardUiStateRecord2 = linkedHashMap.get(strC);
                cardUiStateRecord = new CardUiStateRecord(1, strC, identity, stateType, phase, cardUiStateRecord2 != null ? cardUiStateRecord2.getCreatedAtWallMs() : nowWallMs, nowWallMs, metadata);
                linkedHashMap.put(strC, cardUiStateRecord);
                kVar.f(cardUiStateRecord);
                kVar.p("card.ui_state.put", Y8.j.a("templateType", identity.getTemplateType()), Y8.j.a("bizChannel", identity.getBizChannel()), Y8.j.a("taskId", identity.getTaskId()), Y8.j.a("stateType", stateType), Y8.j.a("phase", phase));
            } catch (Throwable th) {
                throw th;
            }
        }
        return cardUiStateRecord;
    }

    public final Set<String> i() {
        Object objB;
        Object objB2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C5009a.v(C5009a.INSTANCE, MMKV_ID, RECORD_INDEX_KEY, null, 4, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "";
        }
        String str = (String) objB;
        if (H.x0(str)) {
            return Y.e();
        }
        try {
            String[] strArr = (String[]) N5.k.INSTANCE.b().fromJson(str, String[].class);
            Set setI1 = strArr != null ? r.i1(strArr) : null;
            if (setI1 == null) {
                setI1 = Y.e();
            }
            objB2 = Result.b(setI1);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Set setE = Y.e();
        if (Result.g(objB2)) {
            objB2 = setE;
        }
        return (Set) objB2;
    }

    public final CardUiStateRecord j(String recordId) {
        Object objB;
        Object objB2;
        try {
            Result.Companion companion = Result.INSTANCE;
            String strV = C5009a.v(C5009a.INSTANCE, MMKV_ID, k(recordId), null, 4, null);
            if (H.x0(strV)) {
                strV = null;
            }
            objB = Result.b(strV);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            return null;
        }
        try {
            objB2 = Result.b((CardUiStateRecord) N5.k.INSTANCE.b().fromJson(str, CardUiStateRecord.class));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB2);
        if (thE != null) {
            R5.b.INSTANCE.h("card.ui_state.load.fail", Y8.j.a("recordId", INSTANCE.o(recordId)), Y8.j.a("reason", "record_json"), Y8.j.a("exception", thE.getClass().getSimpleName()));
        }
        return (CardUiStateRecord) (Result.g(objB2) ? null : objB2);
    }

    public final String k(String recordId) {
        return RECORD_PREFIX + recordId;
    }

    public final void l() {
        Object objB;
        Object objB2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C5009a.v(C5009a.INSTANCE, MMKV_ID, PENDING_WRITE_KEY, null, 4, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str = "";
        if (Result.g(objB)) {
            objB = "";
        }
        String str2 = (String) objB;
        if (H.x0(str2)) {
            return;
        }
        try {
            PendingWrite pendingWrite = (PendingWrite) N5.k.INSTANCE.b().fromJson(str2, PendingWrite.class);
            String operation = pendingWrite.getOperation();
            int iHashCode = operation.hashCode();
            if (iHashCode != -1785066193) {
                if (iHashCode != 1516964975) {
                    if (iHashCode == 2012838315 && operation.equals(OP_DELETE)) {
                        n(pendingWrite.getRecordId());
                        Set<String> setQ1 = F.q1(i());
                        setQ1.remove(pendingWrite.getRecordId());
                        q(setQ1);
                    }
                } else if (operation.equals(OP_CLEAR_ALL)) {
                    Iterator<T> it = i().iterator();
                    while (it.hasNext()) {
                        n((String) it.next());
                    }
                    q(Y.e());
                }
            } else if (operation.equals(OP_UPSERT)) {
                String recordJson = pendingWrite.getRecordJson();
                if (recordJson != null) {
                    str = recordJson;
                }
                if (!H.x0(pendingWrite.getRecordId()) && !H.x0(str)) {
                    C5009a.INSTANCE.H(MMKV_ID, k(pendingWrite.getRecordId()), str);
                    Set<String> setQ12 = F.q1(i());
                    setQ12.add(pendingWrite.getRecordId());
                    q(setQ12);
                }
            }
            objB2 = Result.b(t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB2);
        if (thE != null) {
            R5.b.INSTANCE.h("card.ui_state.journal.replay.fail", Y8.j.a("exception", thE.getClass().getSimpleName()));
        }
        m();
    }

    public final void m() {
        try {
            Result.Companion companion = Result.INSTANCE;
            C5009a.INSTANCE.J(MMKV_ID, PENDING_WRITE_KEY);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void n(String recordId) {
        if (H.x0(recordId)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            C5009a.INSTANCE.J(MMKV_ID, k(recordId));
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final String o(String value) {
        return K.R1(value, 12);
    }

    public final void p(String event, Pair<String, ? extends Object>... fields) {
        R5.b.INSTANCE.c(event, (Pair[]) Arrays.copyOf(fields, fields.length));
    }

    public final boolean q(Set<String> index) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            C5009a c5009a = C5009a.INSTANCE;
            String json = N5.k.INSTANCE.b().toJson(F.m1(index));
            p.h(json, "toJson(...)");
            objB = Result.b(Boolean.valueOf(c5009a.H(MMKV_ID, RECORD_INDEX_KEY, json)));
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

    public final boolean r(PendingWrite pending) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            C5009a c5009a = C5009a.INSTANCE;
            String json = N5.k.INSTANCE.b().toJson(pending);
            p.h(json, "toJson(...)");
            objB = Result.b(Boolean.valueOf(c5009a.H(MMKV_ID, PENDING_WRITE_KEY, json)));
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/state/k$a;", "", "", "operation", "recordId", "recordJson", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.state.k$a, reason: from toString */
    public static final /* data */ class PendingWrite {

        @SerializedName("operation")
        private final String operation;

        @SerializedName("record_id")
        private final String recordId;

        @SerializedName("record_json")
        private final String recordJson;

        public PendingWrite(String operation, String recordId, String str) {
            p.i(operation, "operation");
            p.i(recordId, "recordId");
            this.operation = operation;
            this.recordId = recordId;
            this.recordJson = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getOperation() {
            return this.operation;
        }

        /* renamed from: b, reason: from getter */
        public final String getRecordId() {
            return this.recordId;
        }

        /* renamed from: c, reason: from getter */
        public final String getRecordJson() {
            return this.recordJson;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingWrite)) {
                return false;
            }
            PendingWrite pendingWrite = (PendingWrite) other;
            return p.d(this.operation, pendingWrite.operation) && p.d(this.recordId, pendingWrite.recordId) && p.d(this.recordJson, pendingWrite.recordJson);
        }

        public int hashCode() {
            int iHashCode = ((this.operation.hashCode() * 31) + this.recordId.hashCode()) * 31;
            String str = this.recordJson;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "PendingWrite(operation=" + this.operation + ", recordId=" + this.recordId + ", recordJson=" + this.recordJson + ")";
        }

        public /* synthetic */ PendingWrite(String str, String str2, String str3, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : str3);
        }
    }
}
