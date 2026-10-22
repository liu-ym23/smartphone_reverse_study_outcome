package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DebugProbesImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
final class DebugProbesImpl$Installations$kotlinx$VolatileWrapper {
    private static final AtomicIntegerFieldUpdater installations$FU = null;

    @Volatile
    private volatile int installations;

    static {
        installations$FU = AtomicIntegerFieldUpdater.newUpdater(DebugProbesImpl$Installations$kotlinx$VolatileWrapper.class, "installations");
    }

    private DebugProbesImpl$Installations$kotlinx$VolatileWrapper() {
    }

    public /* synthetic */ DebugProbesImpl$Installations$kotlinx$VolatileWrapper(DefaultConstructorMarker r1) {
        this();
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater access$getInstallations$FU$p() {
        return installations$FU;
    }
}
