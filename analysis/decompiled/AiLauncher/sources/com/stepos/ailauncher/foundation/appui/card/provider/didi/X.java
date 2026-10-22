package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\tJ\u001d\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\tJ\u001d\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/X;", "", "<init>", "()V", "", "thirdUid", "cardId", "LY8/t;", "o", "(Ljava/lang/String;Ljava/lang/String;)V", "", "k", "(Ljava/lang/String;Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "n", "l", "e", "m", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "PENDING_TTL_MS", "J", "AUTHORIZED_TTL_MS", "Ljava/util/concurrent/ConcurrentHashMap;", AuthSessionDto.STATUS_PENDING, "Ljava/util/concurrent/ConcurrentHashMap;", "authorized", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class X {
    private static final long AUTHORIZED_TTL_MS = 2700000;
    private static final long PENDING_TTL_MS = 600000;
    public static final X INSTANCE = new X();
    private static final ConcurrentHashMap<String, Long> pending = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> authorized = new ConcurrentHashMap<>();

    public static final boolean f(long j10, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object value = it.getValue();
        kotlin.jvm.internal.p.h(value, "<get-value>(...)");
        return j10 - ((Number) value).longValue() > 600000;
    }

    public static final boolean g(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final boolean h(long j10, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object value = it.getValue();
        kotlin.jvm.internal.p.h(value, "<get-value>(...)");
        return j10 - ((Number) value).longValue() > 2700000;
    }

    public static final boolean i(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public final void e() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Set<Map.Entry<String, Long>> setEntrySet = pending.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(X.f(jElapsedRealtime, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.U
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return X.g(interfaceC5074l, obj);
            }
        });
        Set<Map.Entry<String, Long>> setEntrySet2 = authorized.entrySet();
        final InterfaceC5074l interfaceC5074l2 = new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(X.h(jElapsedRealtime, (Map.Entry) obj));
            }
        };
        setEntrySet2.removeIf(new Predicate() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.W
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return X.i(interfaceC5074l2, obj);
            }
        });
    }

    public final synchronized void j(String thirdUid, String cardId) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(cardId, "cardId");
        if (!La.H.x0(thirdUid) && !La.H.x0(cardId)) {
            String strM = m(thirdUid, cardId);
            pending.remove(strM);
            authorized.remove(strM);
        }
    }

    public final synchronized boolean k(String thirdUid, String cardId) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(cardId, "cardId");
        if (!La.H.x0(thirdUid) && !La.H.x0(cardId)) {
            e();
            return pending.remove(m(thirdUid, cardId)) != null;
        }
        return false;
    }

    public final synchronized boolean l(String thirdUid, String cardId) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(cardId, "cardId");
        if (!La.H.x0(thirdUid) && !La.H.x0(cardId)) {
            e();
            return authorized.containsKey(m(thirdUid, cardId));
        }
        return false;
    }

    public final String m(String thirdUid, String cardId) {
        return thirdUid + "|" + cardId;
    }

    public final synchronized void n(String thirdUid, String cardId) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(cardId, "cardId");
        if (!La.H.x0(thirdUid) && !La.H.x0(cardId)) {
            e();
            String strM = m(thirdUid, cardId);
            pending.remove(strM);
            authorized.put(strM, Long.valueOf(SystemClock.elapsedRealtime()));
        }
    }

    public final synchronized void o(String thirdUid, String cardId) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(cardId, "cardId");
        if (!La.H.x0(thirdUid) && !La.H.x0(cardId)) {
            e();
            String strM = m(thirdUid, cardId);
            authorized.remove(strM);
            pending.put(strM, Long.valueOf(SystemClock.elapsedRealtime()));
        }
    }
}
