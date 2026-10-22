package com.stepos.ailauncher.common.utils;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0006J\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0003J\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0003J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/common/utils/E;", "", "<init>", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "", "tag", "Lcom/stepos/ailauncher/common/utils/E$a;", "host", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Lcom/stepos/ailauncher/common/utils/E$a;)V", "l", "(Ljava/lang/String;)V", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "c", "f", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "k", Const.INTENT_KEY_BACKGROUND_COMMAND, "LOCK_SCREEN_CHAT_ACTIVITY", "Ljava/lang/String;", "CHAT_ACTIVITY_PREFIX", "Ljava/util/concurrent/atomic/AtomicInteger;", "suppressKeyguardGoneAutoFinishCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/ConcurrentHashMap;", "conversationHostWindows", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "pendingHostRestores", "Ljava/util/concurrent/CopyOnWriteArrayList;", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E {
    private static final String CHAT_ACTIVITY_PREFIX = "com.stepos.ailauncher.chat.";
    public static final String LOCK_SCREEN_CHAT_ACTIVITY = "com.stepos.ailauncher.chat.lockscreen.LockScreenChatActivity";
    public static final E INSTANCE = new E();
    private static final AtomicInteger suppressKeyguardGoneAutoFinishCount = new AtomicInteger(0);
    private static final ConcurrentHashMap<String, a> conversationHostWindows = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<InterfaceC5063a<Y8.t>> pendingHostRestores = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/common/utils/E$a;", "", "Lkotlin/Function0;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()Lp9/a;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        InterfaceC5063a<Y8.t> a();
    }

    public static final int e(int i10) {
        return C5685n.f(i10 - 1, 0);
    }

    public final void b() {
        suppressKeyguardGoneAutoFinishCount.incrementAndGet();
    }

    public final void c() {
        pendingHostRestores.clear();
    }

    public final void d() {
        suppressKeyguardGoneAutoFinishCount.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.ailauncher.common.utils.D
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                return E.e(i10);
            }
        });
    }

    public final boolean f() {
        return !conversationHostWindows.isEmpty() || g();
    }

    public final boolean g() {
        C3202f c3202f = C3202f.INSTANCE;
        String strD = c3202f.d();
        return strD != null && c3202f.e() && La.D.X(strD, CHAT_ACTIVITY_PREFIX, false, 2, null);
    }

    public final boolean h() {
        return kotlin.jvm.internal.p.d(C3202f.INSTANCE.d(), LOCK_SCREEN_CHAT_ACTIVITY);
    }

    public final void i(String tag, a host) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(host, "host");
        conversationHostWindows.put(tag, host);
    }

    public final void j() {
        CopyOnWriteArrayList<InterfaceC5063a<Y8.t>> copyOnWriteArrayList = pendingHostRestores;
        List<InterfaceC5063a> listM1 = Z8.F.m1(copyOnWriteArrayList);
        copyOnWriteArrayList.clear();
        for (InterfaceC5063a interfaceC5063a : listM1) {
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5063a.invoke();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final boolean k() {
        return suppressKeyguardGoneAutoFinishCount.get() > 0;
    }

    public final void l(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        conversationHostWindows.remove(tag);
    }

    public final void m() {
        Object objB;
        InterfaceC5063a<Y8.t> interfaceC5063a;
        pendingHostRestores.clear();
        Collection<a> collectionValues = conversationHostWindows.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        for (a aVar : Z8.F.m1(collectionValues)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(aVar.a());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.h(objB) && (interfaceC5063a = (InterfaceC5063a) objB) != null) {
                pendingHostRestores.add(interfaceC5063a);
            }
        }
    }
}
