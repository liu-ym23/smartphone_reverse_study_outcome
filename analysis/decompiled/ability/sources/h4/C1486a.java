package h4;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import java.util.concurrent.atomic.AtomicLong;
import k4.w;
import kotlin.jvm.internal.k;

/* renamed from: h4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1486a {

    /* renamed from: a, reason: collision with root package name */
    public final w f4561a;
    public final AtomicLong b;

    public C1486a(McpServerConfig config) {
        k.f(config, "config");
        this.f4561a = new w(new McpServerConfig(null, 0, 0, 0, 0, 0, config.getHandshakeRatePerMinute(), config.getHandshakeBurst(), 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L, 0, 0, 0, 0, 0, 8388415, null));
        this.b = new AtomicLong(0L);
    }
}
