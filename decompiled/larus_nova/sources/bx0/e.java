package bx0;

import com.bytedance.android.live.recharge.platform.core.config.RechargeConfigKey;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import zv0.h;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<RechargeConfigKey, Object> f21275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, h> f21276b;

    public e() {
        this.f21275a = new HashMap();
        this.f21276b = new ConcurrentHashMap();
    }

    public final void a(RechargeConfigKey r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f21275a.put(r100, r101);
    }
}
