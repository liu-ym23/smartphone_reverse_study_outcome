package com.bytedance.android.livesdk.livecommerce.dynamiccontext;

import com.bytedance.android.livesdk.livecommerce.ability.b;
import com.bytedance.android.livesdk.livecommerce.ability.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveDynamicContext {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f147714c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f147715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f147716b;

    public static final class a {
        public static LiveDynamicContext a() {
            return (LiveDynamicContext) LiveDynamicContext.f147714c.getValue();
        }
    }

    public final b a() {
        return (b) this.f147716b.getValue();
    }

    static {
        f147714c = LazyKt.lazy(LiveDynamicContext$Companion$INSTANCE$2.INSTANCE);
    }

    public LiveDynamicContext() {
        this.f147716b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new LiveDynamicContext$abilityCenter$2(this));
    }
}
