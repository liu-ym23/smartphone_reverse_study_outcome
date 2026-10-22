package com.stepos.ailauncher.foundation.appui.card.state;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJM\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0003R&\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/state/i;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/state/c;", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "Lcom/stepos/ailauncher/foundation/appui/card/state/d;", "consumer", "Lcom/stepos/ailauncher/foundation/appui/card/state/j;", "restoredState", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;Lcom/stepos/ailauncher/foundation/appui/card/state/d;Lcom/stepos/ailauncher/foundation/appui/card/state/j;)V", "k", "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;Lcom/stepos/ailauncher/foundation/appui/card/state/d;)V", "", "stateType", "phase", "", "metadata", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;Lcom/stepos/ailauncher/foundation/appui/card/state/d;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/stepos/ailauncher/foundation/appui/card/state/j;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "consumers", "Ljava/util/concurrent/ConcurrentHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i {
    public static final i INSTANCE = new i();
    private static final ConcurrentHashMap<String, WeakReference<d>> consumers = new ConcurrentHashMap<>();

    public static final boolean f(Map.Entry it) {
        p.i(it, "it");
        return ((WeakReference) it.getValue()).get() == null;
    }

    public static final boolean g(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardUiStateRecord i(i iVar, CardStateIdentity cardStateIdentity, d dVar, String str, String str2, Map map, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            dVar = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            map = kotlin.collections.a.i();
        }
        return iVar.h(cardStateIdentity, dVar, str, str2, map);
    }

    public static final WeakReference l(d dVar, String str, WeakReference reference) {
        p.i(str, "<unused var>");
        p.i(reference, "reference");
        if (reference.get() == dVar) {
            return null;
        }
        return reference;
    }

    public static final WeakReference m(p9.p pVar, Object obj, Object obj2) {
        return (WeakReference) pVar.invoke(obj, obj2);
    }

    public final void e() {
        Set<Map.Entry<String, WeakReference<d>>> setEntrySet = consumers.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.state.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(i.f((Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.foundation.appui.card.state.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return i.g(interfaceC5074l, obj);
            }
        });
    }

    public final synchronized CardUiStateRecord h(CardStateIdentity identity, d consumer, String stateType, String phase, Map<String, String> metadata) {
        CardUiStateRecord cardUiStateRecordH;
        try {
            p.i(identity, "identity");
            p.i(stateType, "stateType");
            p.i(metadata, "metadata");
            cardUiStateRecordH = k.h(k.INSTANCE, identity, stateType, phase, metadata, 0L, 16, null);
            if (consumer == null) {
                WeakReference<d> weakReference = consumers.get(identity.c());
                consumer = weakReference != null ? weakReference.get() : null;
            }
            if (consumer != null) {
                consumer.a(cardUiStateRecordH);
            }
        } catch (Throwable th) {
            throw th;
        }
        return cardUiStateRecordH;
    }

    public final synchronized void j(CardStateIdentity identity, d consumer, CardUiStateRecord restoredState) {
        p.i(identity, "identity");
        p.i(consumer, "consumer");
        consumers.put(identity.c(), new WeakReference<>(consumer));
        consumer.a(restoredState);
    }

    public final synchronized void k(CardStateIdentity identity, final d consumer) {
        p.i(identity, "identity");
        p.i(consumer, "consumer");
        ConcurrentHashMap<String, WeakReference<d>> concurrentHashMap = consumers;
        String strC = identity.c();
        final p9.p pVar = new p9.p() { // from class: com.stepos.ailauncher.foundation.appui.card.state.e
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return i.l(consumer, (String) obj, (WeakReference) obj2);
            }
        };
        concurrentHashMap.computeIfPresent(strC, new BiFunction() { // from class: com.stepos.ailauncher.foundation.appui.card.state.f
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return i.m(pVar, obj, obj2);
            }
        });
    }
}
