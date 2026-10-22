package io.ktor.util.debug;

import La.H;
import Y8.h;
import java.lang.management.ManagementFactory;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0007\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/debug/IntellijIdeaDebugDetector;", "", "<init>", "()V", "", "isDebuggerConnected$delegate", "LY8/h;", "isDebuggerConnected", "()Z", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IntellijIdeaDebugDetector {
    public static final IntellijIdeaDebugDetector INSTANCE = new IntellijIdeaDebugDetector();

    /* renamed from: isDebuggerConnected$delegate, reason: from kotlin metadata */
    private static final h isDebuggerConnected = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.util.debug.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Boolean.valueOf(IntellijIdeaDebugDetector.isDebuggerConnected_delegate$lambda$0());
        }
    });

    private IntellijIdeaDebugDetector() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDebuggerConnected_delegate$lambda$0() {
        try {
            return H.g0(ManagementFactory.getRuntimeMXBean().getInputArguments().toString(), "jdwp", false, 2, null);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean isDebuggerConnected() {
        return ((Boolean) isDebuggerConnected.getValue()).booleanValue();
    }
}
