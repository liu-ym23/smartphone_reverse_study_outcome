package g4;

import A6.i;
import com.stepos.ability.mcpserver.model.McpServerState;
import i4.C1554b;
import java.io.IOException;
import java.net.BindException;
import kotlin.jvm.internal.k;

/* renamed from: g4.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1459f {

    /* renamed from: a, reason: collision with root package name */
    public final i f4482a;
    public final C1554b b;
    public volatile boolean c;
    public volatile C1458e d;
    public G7.a e;

    public C1459f(i iVar, C1554b monitor) {
        k.f(monitor, "monitor");
        this.f4482a = iVar;
        this.b = monitor;
    }

    public final boolean a() {
        C1458e c1458e = (C1458e) this.f4482a.invoke();
        try {
            c1458e.f();
            synchronized (this) {
                if (this.c) {
                    c1458e.g();
                    return false;
                }
                this.d = c1458e;
                this.b.c(new McpServerState.Running(c1458e.c == null ? -1 : c1458e.c.getLocalPort()));
                return true;
            }
        } catch (BindException e) {
            C1554b c1554b = this.b;
            String message = e.getMessage();
            if (message == null) {
                message = "bind refused";
            }
            c1554b.c(new McpServerState.Failed("port in use, retrying: ".concat(message), true));
            return false;
        } catch (IOException e6) {
            this.b.c(new McpServerState.Failed(B7.a.B(e6.getClass().getSimpleName(), ": ", e6.getMessage()), false));
            return false;
        }
    }
}
