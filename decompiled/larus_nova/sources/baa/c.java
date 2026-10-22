package baa;

import android.content.Context;
import com.obric.aiagent.product.platform.api.app.ObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.aiagent.product.platform.api.view.ObricWindowManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import z9a.d;

/* JADX INFO: loaded from: classes.dex */
public final class c implements w9a.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f18440c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<c> f18441d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f18442b;

    public static final class a {
        public a() {
        }
    }

    static {
        f18440c = new a();
        f18441d = LazyKt.lazy(new baa.a());
    }

    private final Context getContext() {
        return (Context) this.f18442b.getValue();
    }

    public c() {
        this.f18442b = LazyKt.lazy(new b());
    }

    @Override // w9a.a
    public final void a() {
        d r100 = d.f571072a;
    }

    @Override // w9a.a
    public final RomInfo b() {
        return RomInfo.f385011a;
    }

    @Override // w9a.a
    public final ObricActivityManager.Companion c() {
        return ObricActivityManager.f385005a;
    }

    @Override // w9a.a
    public final void d() {
        aaa.c r100 = aaa.c.f2372a;
    }

    @Override // w9a.a
    public final ObricActivityTaskManager.Companion e() {
        return ObricActivityTaskManager.f385007a;
    }

    @Override // w9a.a
    public final ObricWindowManager.Companion windowManager() {
        return ObricWindowManager.f385015a;
    }
}
