package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Z", "f", "", "now", "c", "(J)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "RETENTION_MS", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "", "pendingAt", "Ljava/util/concurrent/ConcurrentHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3309f {
    private static final long RETENTION_MS = 2700000;
    public static final C3309f INSTANCE = new C3309f();
    private static final ConcurrentHashMap<String, Long> pendingAt = new ConcurrentHashMap<>();

    public static final boolean d(long j10, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object value = it.getValue();
        kotlin.jvm.internal.p.h(value, "<get-value>(...)");
        return j10 - ((Number) value).longValue() >= 2700000;
    }

    public static final boolean e(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public final void c(final long now) {
        Set<Map.Entry<String, Long>> setEntrySet = pendingAt.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C3309f.d(now, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C3309f.e(interfaceC5074l, obj);
            }
        });
    }

    public final synchronized void f(DidiCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        if (La.D.L(model.getBizChannel(), q0.CAOCAO, true)) {
            if (model.getStatus() == 91) {
                return;
            }
            pendingAt.remove(model.getCardId());
        }
    }

    public final boolean g(DidiCardModel model) {
        return model.getStatus() == 91 && La.D.L(model.getBizChannel(), q0.CAOCAO, true);
    }

    public final synchronized boolean h(DidiCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        if (!g(model)) {
            return false;
        }
        String cardId = model.getCardId();
        if (cardId.length() <= 0) {
            cardId = null;
        }
        if (cardId == null) {
            return false;
        }
        c(SystemClock.elapsedRealtime());
        return pendingAt.containsKey(cardId);
    }

    public final synchronized void i(DidiCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        if (g(model)) {
            String cardId = model.getCardId();
            if (cardId.length() <= 0) {
                cardId = null;
            }
            if (cardId == null) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c(jElapsedRealtime);
            pendingAt.put(cardId, Long.valueOf(jElapsedRealtime));
        }
    }
}
