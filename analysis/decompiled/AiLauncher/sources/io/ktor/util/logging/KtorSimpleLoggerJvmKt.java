package io.ktor.util.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.p;
import vc.c;
import vc.e;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "name", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "KtorSimpleLogger", "(Ljava/lang/String;)Lvc/c;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KtorSimpleLoggerJvmKt {
    public static final c KtorSimpleLogger(String name) {
        p.i(name, "name");
        c cVarM = e.m(name);
        p.h(cVarM, "getLogger(...)");
        return cVarM;
    }
}
