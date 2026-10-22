package com.stepos.ailauncher.common.utils;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/common/utils/y;", "", "<init>", "()V", "Lcom/stepos/ailauncher/common/utils/y$a;", "listener", "LY8/t;", "c", "(Lcom/stepos/ailauncher/common/utils/y$a;)V", "", "pageTag", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "e", "(Ljava/lang/String;)Z", "Lkotlin/Function0;", "action", "f", "(Lp9/a;)V", "TAG", "Ljava/lang/String;", "", "foregroundPages", "Ljava/util/Set;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", Const.INTENT_KEY_UMID, "()Z", "hasForegroundPage", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class y {
    public static final y INSTANCE = new y();
    private static final String TAG = "ForegroundPageTracker";
    private static final Set<String> foregroundPages;
    private static final CopyOnWriteArraySet<a> listeners;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/common/utils/y$a;", "", "", "hasForegroundPage", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Z)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(boolean hasForegroundPage);
    }

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        kotlin.jvm.internal.p.h(keySetViewNewKeySet, "newKeySet(...)");
        foregroundPages = keySetViewNewKeySet;
        listeners = new CopyOnWriteArraySet<>();
    }

    public static final Y8.t h(String str) {
        foregroundPages.remove(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t j(String str) {
        foregroundPages.add(str);
        return Y8.t.f7040a;
    }

    public final void c(a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        listeners.add(listener);
    }

    public final boolean d() {
        return !foregroundPages.isEmpty();
    }

    public final boolean e(String pageTag) {
        kotlin.jvm.internal.p.i(pageTag, "pageTag");
        return foregroundPages.contains(pageTag);
    }

    public final void f(InterfaceC5063a<Y8.t> action) {
        Object objB;
        Set<String> set = foregroundPages;
        synchronized (set) {
            boolean z10 = !set.isEmpty();
            action.invoke();
            boolean z11 = !set.isEmpty();
            if (z10 == z11) {
                return;
            }
            Y8.t tVar = Y8.t.f7040a;
            for (a aVar : listeners) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    aVar.a(z11);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(TAG, "listener callback failed", thE);
                }
            }
        }
    }

    public final void g(final String pageTag) {
        kotlin.jvm.internal.p.i(pageTag, "pageTag");
        f(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return y.h(pageTag);
            }
        });
    }

    public final void i(final String pageTag) {
        kotlin.jvm.internal.p.i(pageTag, "pageTag");
        f(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return y.j(pageTag);
            }
        });
    }
}
