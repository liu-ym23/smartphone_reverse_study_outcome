package com.stepos.stepclaw.memory.lightmem.evolution;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionLog;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step", "total", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, "Lb5/a0;", "(IILjava/lang/String;)V", "Lcom/stepos/stepclaw/memory/utils/AndroidMemoryLogger;", "logger", "Lcom/stepos/stepclaw/memory/utils/AndroidMemoryLogger;", "TAG", "Ljava/lang/String;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OfflineEvolutionLog {
    private static final String TAG = "OfflineEvo";
    public static final OfflineEvolutionLog INSTANCE = new OfflineEvolutionLog();
    private static final AndroidMemoryLogger logger = new AndroidMemoryLogger();

    private OfflineEvolutionLog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String step$lambda$0(int i8, int i9, String str) {
        StringBuilder sbT = a8.b.t("[", i8, "/", i9, "] ");
        sbT.append(str);
        return sbT.toString();
    }

    public final void step(int step, int total, String message) {
        p.e(message, "message");
        logger.logI(TAG, null, new com.stepos.stepclaw.memory.lightmem.e(message, step, total, 1));
    }
}
