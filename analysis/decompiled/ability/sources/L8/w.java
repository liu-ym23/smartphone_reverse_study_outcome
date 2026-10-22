package L8;

import com.fasterxml.jackson.core.JsonFactory;
import h8.InterfaceC1540w;

/* loaded from: classes4.dex */
public final class w extends g {
    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        kotlin.jvm.internal.k.f(module, "module");
        return module.c().u();
    }

    @Override // L8.g
    public final String toString() {
        return B7.a.g(JsonFactory.DEFAULT_QUOTE_CHAR, (String) this.f939a, new StringBuilder("\""));
    }
}
