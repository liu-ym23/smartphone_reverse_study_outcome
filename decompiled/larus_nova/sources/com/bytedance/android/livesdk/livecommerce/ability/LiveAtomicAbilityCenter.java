package com.bytedance.android.livesdk.livecommerce.ability;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveAtomicAbilityCenter implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, d<?>> f147634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f147635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveDynamicContext f147636c;

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final void c() {
        Intrinsics.checkNotNullParameter("show_promotion_card_guide", "abilityName");
        this.f147634a.remove("show_promotion_card_guide");     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final h e() {
        Intrinsics.checkNotNullParameter("add_cart", "abilityName");
        return this.f147634a.get("add_cart");
    }

    public LiveAtomicAbilityCenter(LiveDynamicContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f147636c = r100;
        this.f147634a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <R extends d<?>> R get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "abilityName");
        if (this.f147635b == true) goto L21;
        c r101 = this.f147636c.f147715a;
        monitor-enter(this);
        if (r101 != null) goto L29;
        monitor-exit(this);
        goto L21
    L29:
    L18:
        th = move-exception;
        throw th;
    L10:
        if (this.f147635b == true) goto L16;
        Iterator<Map.Entry<String, d<?>>> r102 = r101.getAbilities().entrySet().iterator();     // Catch: Throwable -> L18
    L13:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<String, d<?>> r103 = r102.next();     // Catch: Throwable -> L18
        b(r103.getKey(), r103.getValue());     // Catch: Throwable -> L18
        goto L13
    L15:
        this.f147635b = true;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
    L21:
        Object r104 = null;
        if (this.f147635b == false) goto L32;
        d<?> r105 = this.f147634a.get(r100);
        if ((r105 instanceof d) == false) goto L28;
        r104 = r105;
    L28:
        return (R) r104;
    L32:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final void b(String r100, d<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "abilityName");
        Intrinsics.checkNotNullParameter(r101, "ability");
        this.f147634a.put(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T> void a(final Context r100, final f<T> r110, com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "action");
        if (r111 == null) goto L5;
        r111.schedule(new LiveAtomicAbilityCenter$schedule$1(this, r100, r110));
        return;
    L5:
        b.a.a(this, r100, r110, null, null, null, 20);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T> void d(Context r100, f<T> r101, Object r110, il2.a r111, e r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "action");
        d r102 = get(r101.f147637a);
        if ((r102 instanceof d) == true) goto L5;
        r102 = null;
    L5:
        d r103 = r102;
        if (r103 == null) goto L9;
        r103.a(r100, r101.f147638b, r110, r111, r112);
        return;
    }
}
