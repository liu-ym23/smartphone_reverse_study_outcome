package com.stepos.ailauncher.chat.panelui;

import Z8.A;
import Z8.B;
import android.app.Activity;
import android.os.Looper;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010#\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J'\u0010&\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002¢\u0006\u0004\b&\u0010'J#\u0010*\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003R\u0014\u0010-\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00040/j\b\u0012\u0004\u0012\u00020\u0004`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R$\u00104\u001a\u0012\u0012\u0004\u0012\u0002030/j\b\u0012\u0004\u0012\u000203`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00102¨\u00065"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/s;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/panelui/e;", "layer", "LY8/t;", "m", "(Lcom/stepos/ailauncher/chat/panelui/e;)V", "", "layerId", "s", "(Ljava/lang/String;)V", "", "ownerKeys", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;", "reason", "", "f", "(Ljava/util/Collection;Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;)I", "ownerKey", "", "transitionId", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "phase", "q", "(Ljava/lang/Object;JLcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)I", "expectedPhase", "n", "o", "(Ljava/lang/Object;)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/chat/panelui/e;Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "l", "(Lcom/stepos/ailauncher/chat/panelui/e;)Z", "layerOwner", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Object;Ljava/util/Collection;)Z", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "p", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "e", "TAG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "stack", "Ljava/util/ArrayList;", "Lcom/stepos/ailauncher/chat/panelui/g;", "ownerRecentsStates", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class s {
    private static final String TAG = "PanelLayerRegistry";
    public static final s INSTANCE = new s();
    private static final ArrayList<e> stack = new ArrayList<>();
    private static final ArrayList<OwnerRecentsState> ownerRecentsStates = new ArrayList<>();

    public static final boolean g(Collection collection, OwnerRecentsState state) {
        kotlin.jvm.internal.p.i(state, "state");
        Object obj = state.a().get();
        if (obj == null) {
            return true;
        }
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return false;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (INSTANCE.p(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean k(e it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !INSTANCE.l(it);
    }

    public static final boolean r(OwnerRecentsState it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.a().get() == null;
    }

    public static final boolean t(String str, e it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getLayerId(), str);
    }

    public final void e() {
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PanelLayerRegistry must run on main thread");
        }
    }

    public final int f(final Collection<? extends Object> ownerKeys, PanelLayerDismissReason reason) {
        kotlin.jvm.internal.p.i(ownerKeys, "ownerKeys");
        kotlin.jvm.internal.p.i(reason, "reason");
        e();
        j();
        ArrayList<e> arrayList = stack;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            e eVar = (e) obj;
            if (eVar.isShowing() && INSTANCE.i(eVar.a(), ownerKeys)) {
                arrayList2.add(obj);
            }
        }
        Iterator it = B.U(arrayList2).iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (INSTANCE.h((e) it.next(), reason)) {
                i10++;
            }
        }
        if (reason != PanelLayerDismissReason.OVERVIEW && reason != PanelLayerDismissReason.OWNER_DESTROY) {
            return i10;
        }
        A.L(ownerRecentsStates, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.panelui.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(s.g(ownerKeys, (OwnerRecentsState) obj2));
            }
        });
        return i10;
    }

    public final boolean h(e layer, PanelLayerDismissReason reason) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(layer.e(reason)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        boolean zBooleanValue = ((Boolean) objB).booleanValue();
        s(layer.getLayerId());
        C4148a.k(TAG, "dismiss id=" + layer.getLayerId() + " reason=" + reason + " ok=" + zBooleanValue, false, 4, null);
        return zBooleanValue;
    }

    public final boolean i(Object layerOwner, Collection<? extends Object> ownerKeys) {
        if (layerOwner == null || ownerKeys.isEmpty()) {
            return false;
        }
        Collection<? extends Object> collection = ownerKeys;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (INSTANCE.p(it.next(), layerOwner)) {
                return true;
            }
        }
        return false;
    }

    public final void j() {
        ArrayList<e> arrayList = stack;
        int size = arrayList.size();
        A.L(arrayList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.panelui.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(s.k((e) obj));
            }
        });
        int size2 = size - arrayList.size();
        if (size2 > 0) {
            C4148a.d(TAG, "pruneDead removed=" + size2 + " size=" + arrayList.size(), false, 4, null);
        }
    }

    public final boolean l(e layer) {
        return layer.isShowing() || layer.f();
    }

    public final void m(e layer) {
        OwnerRecentsState ownerRecentsStatePrevious;
        kotlin.jvm.internal.p.i(layer, "layer");
        e();
        Object objA = layer.a();
        if (objA == null) {
            C4148a.h(TAG, "reject ownerless layer id=" + layer.getLayerId(), false, 4, null);
            return;
        }
        s(layer.getLayerId());
        stack.add(layer);
        ArrayList<OwnerRecentsState> arrayList = ownerRecentsStates;
        ListIterator<OwnerRecentsState> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                ownerRecentsStatePrevious = null;
                break;
            } else {
                ownerRecentsStatePrevious = listIterator.previous();
                if (INSTANCE.p(ownerRecentsStatePrevious.a().get(), objA)) {
                    break;
                }
            }
        }
        OwnerRecentsState ownerRecentsState = ownerRecentsStatePrevious;
        if (ownerRecentsState != null) {
            layer.c(ownerRecentsState.getTransitionId(), ownerRecentsState.getPhase());
        }
        d.INSTANCE.c(layer);
        C4148a.d(TAG, "register id=" + layer.getLayerId() + " policy=" + layer.getHomePolicy() + " size=" + stack.size(), false, 4, null);
    }

    public final int n(Object ownerKey, long transitionId, PanelLayerRecentsPhase expectedPhase) {
        OwnerRecentsState ownerRecentsStatePrevious;
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(expectedPhase, "expectedPhase");
        e();
        j();
        ArrayList<OwnerRecentsState> arrayList = ownerRecentsStates;
        ListIterator<OwnerRecentsState> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                ownerRecentsStatePrevious = null;
                break;
            }
            ownerRecentsStatePrevious = listIterator.previous();
            if (INSTANCE.p(ownerRecentsStatePrevious.a().get(), ownerKey)) {
                break;
            }
        }
        OwnerRecentsState ownerRecentsState = ownerRecentsStatePrevious;
        if (ownerRecentsState == null) {
            return 0;
        }
        if (ownerRecentsState.getTransitionId() != transitionId || ownerRecentsState.getPhase() != expectedPhase) {
            C4148a.u(TAG, "skip stale resume expected=" + expectedPhase + "/" + transitionId + " actual=" + ownerRecentsState.getPhase() + "/" + ownerRecentsState.getTransitionId(), false, 4, null);
            return 0;
        }
        ArrayList<e> arrayList2 = stack;
        ArrayList<e> arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            e eVar = (e) obj;
            s sVar = INSTANCE;
            if (sVar.p(eVar.a(), ownerKey) && sVar.l(eVar)) {
                arrayList3.add(obj);
            }
        }
        int i10 = 0;
        int i11 = 0;
        for (e eVar2 : arrayList3) {
            if (eVar2.f()) {
                if (eVar2.d(transitionId, expectedPhase)) {
                    i11++;
                } else {
                    i10++;
                }
            }
        }
        if (i10 == 0) {
            ownerRecentsStates.remove(ownerRecentsState);
        }
        C4148a.k(TAG, "resume owner phase=" + expectedPhase + " transition=" + transitionId + " count=" + i11 + " failed=" + i10, false, 4, null);
        return i11;
    }

    public final int o(Object ownerKey) {
        OwnerRecentsState ownerRecentsStatePrevious;
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        e();
        ArrayList<OwnerRecentsState> arrayList = ownerRecentsStates;
        ListIterator<OwnerRecentsState> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                ownerRecentsStatePrevious = null;
                break;
            }
            ownerRecentsStatePrevious = listIterator.previous();
            if (INSTANCE.p(ownerRecentsStatePrevious.a().get(), ownerKey)) {
                break;
            }
        }
        OwnerRecentsState ownerRecentsState = ownerRecentsStatePrevious;
        if (ownerRecentsState == null) {
            return 0;
        }
        return n(ownerKey, ownerRecentsState.getTransitionId(), ownerRecentsState.getPhase());
    }

    public final boolean p(Object a10, Object b10) {
        if (a10 != null && b10 != null) {
            if (a10 == b10) {
                return true;
            }
            boolean z10 = a10 instanceof View;
            View view = z10 ? (View) a10 : null;
            View rootView = view != null ? view.getRootView() : null;
            boolean z11 = b10 instanceof View;
            View view2 = z11 ? (View) b10 : null;
            View rootView2 = view2 != null ? view2.getRootView() : null;
            if (rootView != null && rootView2 != null && rootView == rootView2) {
                return true;
            }
            Activity activity = a10 instanceof Activity ? (Activity) a10 : null;
            Activity activity2 = b10 instanceof Activity ? (Activity) b10 : null;
            if (activity != null && activity2 != null && activity == activity2) {
                return true;
            }
            if (activity != null && z11 && ((View) b10).getContext() == activity) {
                return true;
            }
            if (activity2 != null && z10 && ((View) a10).getContext() == activity2) {
                return true;
            }
        }
        return false;
    }

    public final int q(Object ownerKey, long transitionId, PanelLayerRecentsPhase phase) {
        OwnerRecentsState ownerRecentsStatePrevious;
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(phase, "phase");
        e();
        j();
        ArrayList<OwnerRecentsState> arrayList = ownerRecentsStates;
        A.L(arrayList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.panelui.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(s.r((OwnerRecentsState) obj));
            }
        });
        ListIterator<OwnerRecentsState> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                ownerRecentsStatePrevious = null;
                break;
            }
            ownerRecentsStatePrevious = listIterator.previous();
            if (INSTANCE.p(ownerRecentsStatePrevious.a().get(), ownerKey)) {
                break;
            }
        }
        OwnerRecentsState ownerRecentsState = ownerRecentsStatePrevious;
        if (ownerRecentsState == null) {
            ownerRecentsStates.add(new OwnerRecentsState(new WeakReference(ownerKey), transitionId, phase));
        } else {
            ownerRecentsState.e(transitionId);
            ownerRecentsState.d(phase);
        }
        ArrayList<e> arrayList2 = stack;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            e eVar = (e) obj;
            s sVar = INSTANCE;
            if (sVar.p(eVar.a(), ownerKey) && sVar.l(eVar)) {
                arrayList3.add(obj);
            }
        }
        Iterator it = B.U(arrayList3).iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (((e) it.next()).c(transitionId, phase)) {
                i10++;
            }
        }
        C4148a.k(TAG, "suspend owner phase=" + phase + " transition=" + transitionId + " count=" + i10, false, 4, null);
        return i10;
    }

    public final void s(final String layerId) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        e();
        ArrayList<e> arrayList = stack;
        if (A.L(arrayList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.panelui.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(s.t(layerId, (e) obj));
            }
        })) {
            d.INSTANCE.e(layerId);
            C4148a.d(TAG, "unregister id=" + layerId + " size=" + arrayList.size(), false, 4, null);
        }
    }
}
