package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel;
import com.stepos.ailauncher.foundation.appui.card.state.CardStateIdentity;
import com.stepos.ailauncher.foundation.appui.card.state.CardUiStateRecord;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010!J!\u0010$\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/e0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "view", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)V", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)V", DidiCardProvider.KEY_ORDER, "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/e0$a;", "candidates", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Ljava/util/List;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/e0$a;", "k", "", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "", "nowElapsed", Const.INTENT_KEY_PKGNAME, "(J)V", "entry", "", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/e0$a;J)Z", "orderModel", "estimateSessionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/state/c;", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;)V", "ESTIMATE_CANDIDATE_TTL_MS", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "estimateViews", "Ljava/util/concurrent/ConcurrentHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e0 {
    private static final long ESTIMATE_CANDIDATE_TTL_MS = 600000;
    public static final e0 INSTANCE = new e0();
    private static final ConcurrentHashMap<String, EstimateEntry> estimateViews = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\b\u0082\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0012R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010%R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/e0$a;", "", "Lcom/stepos/ailauncher/foundation/appui/card/state/c;", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "", "sessionId", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "view", "", "carTypeNames", "", "lastSeenElapsed", "", "submittedInProcess", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;Ljava/lang/String;Ljava/lang/ref/WeakReference;Ljava/util/Set;JZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/state/c;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/state/c;", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "Ljava/lang/ref/WeakReference;", "f", "()Ljava/lang/ref/WeakReference;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/ref/WeakReference;)V", "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "J", "c", "()J", Const.INTENT_KEY_BACKGROUND_COMMAND, "(J)V", "Z", "e", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.e0$a, reason: from toString */
    public static final /* data */ class EstimateEntry {
        private final Set<String> carTypeNames;
        private final CardStateIdentity identity;
        private long lastSeenElapsed;
        private final String sessionId;
        private boolean submittedInProcess;
        private WeakReference<DidiCardView> view;

        public EstimateEntry(CardStateIdentity identity, String str, WeakReference<DidiCardView> weakReference, Set<String> carTypeNames, long j10, boolean z10) {
            kotlin.jvm.internal.p.i(identity, "identity");
            kotlin.jvm.internal.p.i(carTypeNames, "carTypeNames");
            this.identity = identity;
            this.sessionId = str;
            this.view = weakReference;
            this.carTypeNames = carTypeNames;
            this.lastSeenElapsed = j10;
            this.submittedInProcess = z10;
        }

        public final Set<String> a() {
            return this.carTypeNames;
        }

        /* renamed from: b, reason: from getter */
        public final CardStateIdentity getIdentity() {
            return this.identity;
        }

        /* renamed from: c, reason: from getter */
        public final long getLastSeenElapsed() {
            return this.lastSeenElapsed;
        }

        /* renamed from: d, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getSubmittedInProcess() {
            return this.submittedInProcess;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EstimateEntry)) {
                return false;
            }
            EstimateEntry estimateEntry = (EstimateEntry) other;
            return kotlin.jvm.internal.p.d(this.identity, estimateEntry.identity) && kotlin.jvm.internal.p.d(this.sessionId, estimateEntry.sessionId) && kotlin.jvm.internal.p.d(this.view, estimateEntry.view) && kotlin.jvm.internal.p.d(this.carTypeNames, estimateEntry.carTypeNames) && this.lastSeenElapsed == estimateEntry.lastSeenElapsed && this.submittedInProcess == estimateEntry.submittedInProcess;
        }

        public final WeakReference<DidiCardView> f() {
            return this.view;
        }

        public final void g(long j10) {
            this.lastSeenElapsed = j10;
        }

        public final void h(boolean z10) {
            this.submittedInProcess = z10;
        }

        public int hashCode() {
            int iHashCode = this.identity.hashCode() * 31;
            String str = this.sessionId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            WeakReference<DidiCardView> weakReference = this.view;
            return ((((((iHashCode2 + (weakReference != null ? weakReference.hashCode() : 0)) * 31) + this.carTypeNames.hashCode()) * 31) + Long.hashCode(this.lastSeenElapsed)) * 31) + Boolean.hashCode(this.submittedInProcess);
        }

        public final void i(WeakReference<DidiCardView> weakReference) {
            this.view = weakReference;
        }

        public String toString() {
            return "EstimateEntry(identity=" + this.identity + ", sessionId=" + this.sessionId + ", view=" + this.view + ", carTypeNames=" + this.carTypeNames + ", lastSeenElapsed=" + this.lastSeenElapsed + ", submittedInProcess=" + this.submittedInProcess + ")";
        }
    }

    public final EstimateEntry a(DidiCardModel order, List<EstimateEntry> candidates) {
        if (candidates.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : candidates) {
            CardUiStateRecord cardUiStateRecordD = com.stepos.ailauncher.foundation.appui.card.state.k.INSTANCE.d(((EstimateEntry) obj).getIdentity());
            if (!kotlin.jvm.internal.p.d(cardUiStateRecordD != null ? cardUiStateRecordD.getStateType() : null, "DIMMED")) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((EstimateEntry) obj2).getSubmittedInProcess()) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.size() == 1) {
            return (EstimateEntry) Z8.F.X0(arrayList2);
        }
        if (arrayList2.size() > 1) {
            return k(order, arrayList2);
        }
        EstimateEntry estimateEntryK = k(order, arrayList);
        return estimateEntryK != null ? estimateEntryK : (EstimateEntry) Z8.F.Z0(arrayList);
    }

    public final void b(long nowElapsed) {
        Set<Map.Entry<String, EstimateEntry>> setEntrySet = estimateViews.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
        for (Map.Entry entry : Z8.F.m1(setEntrySet)) {
            kotlin.jvm.internal.p.f(entry);
            Object key = entry.getKey();
            kotlin.jvm.internal.p.h(key, "component1(...)");
            String str = (String) key;
            Object value = entry.getValue();
            kotlin.jvm.internal.p.h(value, "component2(...)");
            EstimateEntry estimateEntry = (EstimateEntry) value;
            if (!INSTANCE.c(estimateEntry, nowElapsed)) {
                estimateViews.remove(str, estimateEntry);
            }
        }
    }

    public final boolean c(EstimateEntry entry, long nowElapsed) {
        WeakReference<DidiCardView> weakReferenceF = entry.f();
        DidiCardView didiCardView = weakReferenceF != null ? weakReferenceF.get() : null;
        return (didiCardView != null && didiCardView.isAttachedToWindow()) || nowElapsed - entry.getLastSeenElapsed() <= 600000;
    }

    public final String d(String value) {
        String lowerCase = new Regex("\\s+").l(value, "").toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final synchronized void e(DidiCardView view, DidiCardModel model) {
        String string;
        try {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(model, "model");
            boolean z10 = true;
            if (model.getStatus() == 1) {
                d0 d0Var = d0.INSTANCE;
                if (d0Var.d(model)) {
                    b(SystemClock.elapsedRealtime());
                    CardStateIdentity cardStateIdentityB = d0Var.b(model);
                    if (cardStateIdentityB == null) {
                        return;
                    }
                    d0Var.c(cardStateIdentityB);
                    i(cardStateIdentityB);
                    CardUiStateRecord cardUiStateRecordD = com.stepos.ailauncher.foundation.appui.card.state.k.INSTANCE.d(cardStateIdentityB);
                    ConcurrentHashMap<String, EstimateEntry> concurrentHashMap = estimateViews;
                    EstimateEntry estimateEntry = concurrentHashMap.get(cardStateIdentityB.c());
                    String strC = cardStateIdentityB.c();
                    String sessionId = model.getSessionId();
                    WeakReference weakReference = new WeakReference(view);
                    List<DidiCardModel.CarTypeItem> listK = model.k();
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = listK.iterator();
                    while (it.hasNext()) {
                        String name = ((DidiCardModel.CarTypeItem) it.next()).getName();
                        if (name == null || (string = La.H.D1(name).toString()) == null || string.length() <= 0) {
                            string = null;
                        }
                        if (string != null) {
                            arrayList.add(string);
                        }
                    }
                    Set setR1 = Z8.F.r1(arrayList);
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (estimateEntry == null || !estimateEntry.getSubmittedInProcess()) {
                        if (!kotlin.jvm.internal.p.d(cardUiStateRecordD != null ? cardUiStateRecordD.getStateType() : null, "DIMMED")) {
                            z10 = false;
                        }
                    }
                    concurrentHashMap.put(strC, new EstimateEntry(cardStateIdentityB, sessionId, weakReference, setR1, jElapsedRealtime, z10));
                    R5.b.INSTANCE.c("taxi.estimate.candidate.bound", Y8.j.a("taskId", model.getCardId()), Y8.j.a("bizChannel", model.getBizChannel()), Y8.j.a("storedDimmed", Boolean.valueOf(kotlin.jvm.internal.p.d(cardUiStateRecordD != null ? cardUiStateRecordD.getStateType() : null, "DIMMED"))));
                    com.stepos.ailauncher.foundation.appui.card.state.i iVar = com.stepos.ailauncher.foundation.appui.card.state.i.INSTANCE;
                    if (cardUiStateRecordD == null || !d0.INSTANCE.h(model, cardUiStateRecordD)) {
                        cardUiStateRecordD = null;
                    }
                    iVar.j(cardStateIdentityB, view, cardUiStateRecordD);
                }
            }
        } finally {
        }
    }

    public final synchronized void f(DidiCardModel model) {
        try {
            kotlin.jvm.internal.p.i(model, "model");
            if (C3328z.a(model)) {
                d0 d0Var = d0.INSTANCE;
                if (d0Var.d(model)) {
                    CardStateIdentity cardStateIdentityB = d0Var.b(model);
                    if (cardStateIdentityB == null) {
                        return;
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    b(jElapsedRealtime);
                    Collection<EstimateEntry> collectionValues = estimateViews.values();
                    kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : collectionValues) {
                        EstimateEntry estimateEntry = (EstimateEntry) obj;
                        e0 e0Var = INSTANCE;
                        kotlin.jvm.internal.p.f(estimateEntry);
                        if (e0Var.c(estimateEntry, jElapsedRealtime) && kotlin.jvm.internal.p.d(estimateEntry.getIdentity().getAccountScope(), cardStateIdentityB.getAccountScope()) && kotlin.jvm.internal.p.d(estimateEntry.getIdentity().getBizChannel(), cardStateIdentityB.getBizChannel()) && e0Var.j(model, estimateEntry.getSessionId())) {
                            arrayList.add(obj);
                        }
                    }
                    List<EstimateEntry> listM1 = Z8.F.m1(arrayList);
                    EstimateEntry estimateEntryA = a(model, listM1);
                    if (estimateEntryA == null) {
                        R5.b bVar = R5.b.INSTANCE;
                        Pair pairA = Y8.j.a("orderTaskId", model.getCardId());
                        String orderNo = model.getOrderNo();
                        if (orderNo == null) {
                            orderNo = "null";
                        }
                        bVar.h("taxi.estimate.order_success.no_match", pairA, Y8.j.a("orderNo", orderNo), Y8.j.a("bizChannel", model.getBizChannel()), Y8.j.a("candidateCount", Integer.valueOf(listM1.size())));
                        return;
                    }
                    estimateEntryA.h(true);
                    CardUiStateRecord cardUiStateRecordD = com.stepos.ailauncher.foundation.appui.card.state.k.INSTANCE.d(estimateEntryA.getIdentity());
                    if (!kotlin.jvm.internal.p.d(cardUiStateRecordD != null ? cardUiStateRecordD.getStateType() : null, "DIMMED")) {
                        com.stepos.ailauncher.foundation.appui.card.state.i iVar = com.stepos.ailauncher.foundation.appui.card.state.i.INSTANCE;
                        CardStateIdentity identity = estimateEntryA.getIdentity();
                        Pair pairA2 = Y8.j.a("trigger", "order_created");
                        String bizChannel = model.getBizChannel();
                        if (bizChannel == null) {
                            bizChannel = "";
                        }
                        com.stepos.ailauncher.foundation.appui.card.state.i.i(iVar, identity, null, "DIMMED", "ORDER_STARTED", kotlin.collections.a.m(pairA2, Y8.j.a("vendor", bizChannel)), 2, null);
                    }
                    R5.b bVar2 = R5.b.INSTANCE;
                    Pair pairA3 = Y8.j.a("estimateTaskId", estimateEntryA.getIdentity().getTaskId());
                    Pair pairA4 = Y8.j.a("orderTaskId", model.getCardId());
                    String orderNo2 = model.getOrderNo();
                    if (orderNo2 == null) {
                        orderNo2 = "null";
                    }
                    bVar2.c("taxi.estimate.order_success.matched", pairA3, pairA4, Y8.j.a("orderNo", orderNo2), Y8.j.a("bizChannel", model.getBizChannel()), Y8.j.a("candidateCount", Integer.valueOf(listM1.size())));
                }
            }
        } finally {
        }
    }

    public final synchronized void g(DidiCardView view, DidiCardModel model) {
        DidiCardView didiCardView;
        String string;
        try {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(model, "model");
            if (model.getStatus() == 1) {
                d0 d0Var = d0.INSTANCE;
                if (d0Var.d(model)) {
                    CardStateIdentity cardStateIdentityB = d0Var.b(model);
                    if (cardStateIdentityB != null) {
                        d0Var.c(cardStateIdentityB);
                        i(cardStateIdentityB);
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        ConcurrentHashMap<String, EstimateEntry> concurrentHashMap = estimateViews;
                        String strC = cardStateIdentityB.c();
                        String sessionId = model.getSessionId();
                        WeakReference weakReference = new WeakReference(view);
                        List<DidiCardModel.CarTypeItem> listK = model.k();
                        ArrayList arrayList = new ArrayList();
                        Iterator<T> it = listK.iterator();
                        while (it.hasNext()) {
                            String name = ((DidiCardModel.CarTypeItem) it.next()).getName();
                            String str = null;
                            if (name != null && (string = La.H.D1(name).toString()) != null && string.length() > 0) {
                                str = string;
                            }
                            if (str != null) {
                                arrayList.add(str);
                            }
                        }
                        concurrentHashMap.put(strC, new EstimateEntry(cardStateIdentityB, sessionId, weakReference, Z8.F.r1(arrayList), jElapsedRealtime, true));
                        didiCardView = view;
                        com.stepos.ailauncher.foundation.appui.card.state.i.i(com.stepos.ailauncher.foundation.appui.card.state.i.INSTANCE, cardStateIdentityB, didiCardView, "DIMMED", "SUBMITTED", null, 16, null);
                    } else {
                        didiCardView = view;
                    }
                    didiCardView.V0("submitted");
                }
            }
        } finally {
        }
    }

    public final synchronized void h(DidiCardView view, DidiCardModel model) {
        try {
            kotlin.jvm.internal.p.i(view, "view");
            if (model != null && model.getStatus() == 1) {
                d0 d0Var = d0.INSTANCE;
                if (d0Var.d(model)) {
                    CardStateIdentity cardStateIdentityB = d0Var.b(model);
                    if (cardStateIdentityB == null) {
                        return;
                    }
                    EstimateEntry estimateEntry = estimateViews.get(cardStateIdentityB.c());
                    if (estimateEntry != null) {
                        WeakReference<DidiCardView> weakReferenceF = estimateEntry.f();
                        if ((weakReferenceF != null ? weakReferenceF.get() : null) == view) {
                            estimateEntry.i(null);
                            estimateEntry.g(SystemClock.elapsedRealtime());
                            R5.b.INSTANCE.c("taxi.estimate.candidate.retained", Y8.j.a("taskId", model.getCardId()), Y8.j.a("bizChannel", model.getBizChannel()), Y8.j.a("reason", "view_unbound"));
                        }
                    }
                    com.stepos.ailauncher.foundation.appui.card.state.i iVar = com.stepos.ailauncher.foundation.appui.card.state.i.INSTANCE;
                    iVar.k(cardStateIdentityB, view);
                    iVar.e();
                    b(SystemClock.elapsedRealtime());
                }
            }
        } finally {
        }
    }

    public final void i(CardStateIdentity identity) {
        Set<Map.Entry<String, EstimateEntry>> setEntrySet = estimateViews.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
        for (Map.Entry entry : Z8.F.m1(setEntrySet)) {
            kotlin.jvm.internal.p.f(entry);
            Object key = entry.getKey();
            kotlin.jvm.internal.p.h(key, "component1(...)");
            String str = (String) key;
            Object value = entry.getValue();
            kotlin.jvm.internal.p.h(value, "component2(...)");
            EstimateEntry estimateEntry = (EstimateEntry) value;
            if (kotlin.jvm.internal.p.d(estimateEntry.getIdentity().getAccountScope(), identity.getAccountScope()) && kotlin.jvm.internal.p.d(estimateEntry.getIdentity().getTemplateType(), identity.getTemplateType()) && kotlin.jvm.internal.p.d(estimateEntry.getIdentity().getBizChannel(), identity.getBizChannel()) && kotlin.jvm.internal.p.d(estimateEntry.getIdentity().getTaskId(), identity.getTaskId()) && !kotlin.jvm.internal.p.d(estimateEntry.getIdentity().getRevisionFingerprint(), identity.getRevisionFingerprint())) {
                estimateViews.remove(str, estimateEntry);
            }
        }
    }

    public final boolean j(DidiCardModel orderModel, String estimateSessionId) {
        String sessionId = orderModel.getSessionId();
        if (sessionId != null) {
            if (La.H.x0(sessionId)) {
                sessionId = null;
            }
            if (sessionId != null && estimateSessionId != null) {
                if (La.H.x0(estimateSessionId)) {
                    estimateSessionId = null;
                }
                if (estimateSessionId != null) {
                    return kotlin.jvm.internal.p.d(sessionId, estimateSessionId);
                }
            }
        }
        return true;
    }

    public final EstimateEntry k(DidiCardModel order, List<EstimateEntry> candidates) {
        String string;
        String plateTitle = order.getPlateTitle();
        if (plateTitle != null && (string = La.H.D1(plateTitle).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : candidates) {
                    Set<String> setA = ((EstimateEntry) obj).a();
                    if (!(setA instanceof Collection) || !setA.isEmpty()) {
                        Iterator<T> it = setA.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                String str = (String) it.next();
                                e0 e0Var = INSTANCE;
                                if (kotlin.jvm.internal.p.d(e0Var.d(str), e0Var.d(string))) {
                                    arrayList.add(obj);
                                    break;
                                }
                            }
                        }
                    }
                }
                return (EstimateEntry) Z8.F.Z0(arrayList);
            }
        }
        return null;
    }
}
