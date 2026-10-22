package com.stepos.stepclaw.memory.lightmem.evolution;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.SnowflakeIdGenerator;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionIds;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "snowflake", "Lcom/stepos/stepclaw/memory/lightmem/SnowflakeIdGenerator;", "newMemoryIndexId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OfflineEvolutionIds {
    public static final OfflineEvolutionIds INSTANCE = new OfflineEvolutionIds();
    private static final SnowflakeIdGenerator snowflake = new SnowflakeIdGenerator(0, 0, 3, null);

    private OfflineEvolutionIds() {
    }

    public final long newMemoryIndexId() {
        return snowflake.nextId();
    }
}
