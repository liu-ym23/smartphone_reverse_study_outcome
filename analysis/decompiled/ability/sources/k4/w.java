package k4;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import com.stepos.ability.mcpserver.security.RateLimiter$buckets$1;

/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final McpServerConfig f4817a;
    public final RateLimiter$buckets$1 b;

    public w(McpServerConfig config) {
        kotlin.jvm.internal.k.f(config, "config");
        this.f4817a = config;
        this.b = new RateLimiter$buckets$1(this);
    }

    public final boolean a(long j5, String callerKey) {
        v vVar;
        kotlin.jvm.internal.k.f(callerKey, "callerKey");
        double rateLimitBurst = this.f4817a.getRateLimitBurst();
        synchronized (this.b) {
            try {
                RateLimiter$buckets$1 rateLimiter$buckets$1 = this.b;
                Object vVar2 = rateLimiter$buckets$1.get(callerKey);
                if (vVar2 == null) {
                    vVar2 = new v(rateLimitBurst, j5);
                    rateLimiter$buckets$1.put(callerKey, vVar2);
                }
                vVar = (v) vVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (vVar) {
            long j6 = j5 - vVar.b;
            if (j6 < 0) {
                j6 = 0;
            }
            double dMin = Math.min(rateLimitBurst, ((this.f4817a.getRateLimitPerMinute() / 60000.0d) * j6) + vVar.f4816a);
            vVar.f4816a = dMin;
            vVar.b = j5;
            if (dMin < 1.0d) {
                return false;
            }
            vVar.f4816a = dMin - 1.0d;
            return true;
        }
    }
}
