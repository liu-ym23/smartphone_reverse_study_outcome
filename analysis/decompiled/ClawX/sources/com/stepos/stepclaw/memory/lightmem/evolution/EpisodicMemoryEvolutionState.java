package com.stepos.stepclaw.memory.lightmem.evolution;

import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/evolution/EpisodicMemoryEvolutionState;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "PENDING", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "EVOLVED", "IN_PROGRESS", "DEPRECATED", "LEGACY_ZH_TO_EN", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "normalizeState", "raw", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EpisodicMemoryEvolutionState {
    public static final EpisodicMemoryEvolutionState INSTANCE = new EpisodicMemoryEvolutionState();
    public static final String PENDING = "pending";
    public static final String EVOLVED = "evolved";
    public static final String IN_PROGRESS = "evolving";
    public static final String DEPRECATED = "deprecated";
    private static final Map<String, String> LEGACY_ZH_TO_EN = z.U(new b5.g("未演化", PENDING), new b5.g("已演化", EVOLVED), new b5.g("演化中", IN_PROGRESS), new b5.g("已废弃", DEPRECATED));

    private EpisodicMemoryEvolutionState() {
    }

    public final String normalizeState(String raw) {
        p.e(raw, "raw");
        String string = n.T1(raw).toString();
        if (string.length() == 0) {
            return PENDING;
        }
        String str = LEGACY_ZH_TO_EN.get(string);
        return str != null ? str : string;
    }
}
