package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DebugProbesImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
final class DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper {
    private static final AtomicLongFieldUpdater sequenceNumber$FU = null;

    @Volatile
    private volatile long sequenceNumber;

    static {
        sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper.class, "sequenceNumber");
    }

    private DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper() {
    }

    public /* synthetic */ DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper(DefaultConstructorMarker r1) {
        this();
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getSequenceNumber$FU$p() {
        return sequenceNumber$FU;
    }
}
