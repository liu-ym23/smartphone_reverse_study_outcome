package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import com.stepos.stepclaw.memory.storage.persist.IndexPersistence;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/stepos/stepclaw/memory/MemoryFormatMigrator;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/persist/IndexPersistence;", "persistence", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "embeddingStorage", "Lkotlin/Function0;", "Lb5/a0;", "clearOfflineCaches", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Lcom/stepos/stepclaw/memory/storage/persist/IndexPersistence;Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;Lp5/a;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "Lcom/stepos/stepclaw/memory/MemoryFormatMigrator$MigrationResult;", "migrateIfNeeded", "()Lcom/stepos/stepclaw/memory/MemoryFormatMigrator$MigrationResult;", "Lcom/stepos/stepclaw/memory/storage/persist/IndexPersistence;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "Lp5/a;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Companion", "MigrationResult", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryFormatMigrator {
    private static final String TAG = "MemoryFormatMigrator";
    private final p5.a clearOfflineCaches;
    private final EmbeddingStorage embeddingStorage;
    private final MemoryLogger logger;
    private final IndexPersistence persistence;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010JD\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/stepos/stepclaw/memory/MemoryFormatMigrator$MigrationResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "indexWiped", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embeddingWiped", "offlineCachesCleared", "previousIndexVersion", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "previousEmbeddingVersion", "<init>", "(ZZZLjava/lang/Integer;Ljava/lang/Integer;)V", "getIndexWiped", "()Z", "getEmbeddingWiped", "getOfflineCachesCleared", "getPreviousIndexVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreviousEmbeddingVersion", "anyWiped", "getAnyWiped", "component1", "component2", "component3", "component4", "component5", "copy", "(ZZZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/stepos/stepclaw/memory/MemoryFormatMigrator$MigrationResult;", "equals", "other", "hashCode", "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MigrationResult {
        private final boolean embeddingWiped;
        private final boolean indexWiped;
        private final boolean offlineCachesCleared;
        private final Integer previousEmbeddingVersion;
        private final Integer previousIndexVersion;

        public MigrationResult(boolean z, boolean z2, boolean z8, Integer num, Integer num2) {
            this.indexWiped = z;
            this.embeddingWiped = z2;
            this.offlineCachesCleared = z8;
            this.previousIndexVersion = num;
            this.previousEmbeddingVersion = num2;
        }

        public static /* synthetic */ MigrationResult copy$default(MigrationResult migrationResult, boolean z, boolean z2, boolean z8, Integer num, Integer num2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                z = migrationResult.indexWiped;
            }
            if ((i8 & 2) != 0) {
                z2 = migrationResult.embeddingWiped;
            }
            if ((i8 & 4) != 0) {
                z8 = migrationResult.offlineCachesCleared;
            }
            if ((i8 & 8) != 0) {
                num = migrationResult.previousIndexVersion;
            }
            if ((i8 & 16) != 0) {
                num2 = migrationResult.previousEmbeddingVersion;
            }
            Integer num3 = num2;
            boolean z9 = z8;
            return migrationResult.copy(z, z2, z9, num, num3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIndexWiped() {
            return this.indexWiped;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getEmbeddingWiped() {
            return this.embeddingWiped;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getOfflineCachesCleared() {
            return this.offlineCachesCleared;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getPreviousIndexVersion() {
            return this.previousIndexVersion;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getPreviousEmbeddingVersion() {
            return this.previousEmbeddingVersion;
        }

        public final MigrationResult copy(boolean indexWiped, boolean embeddingWiped, boolean offlineCachesCleared, Integer previousIndexVersion, Integer previousEmbeddingVersion) {
            return new MigrationResult(indexWiped, embeddingWiped, offlineCachesCleared, previousIndexVersion, previousEmbeddingVersion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MigrationResult)) {
                return false;
            }
            MigrationResult migrationResult = (MigrationResult) other;
            return this.indexWiped == migrationResult.indexWiped && this.embeddingWiped == migrationResult.embeddingWiped && this.offlineCachesCleared == migrationResult.offlineCachesCleared && kotlin.jvm.internal.p.a(this.previousIndexVersion, migrationResult.previousIndexVersion) && kotlin.jvm.internal.p.a(this.previousEmbeddingVersion, migrationResult.previousEmbeddingVersion);
        }

        public final boolean getAnyWiped() {
            return this.indexWiped || this.embeddingWiped;
        }

        public final boolean getEmbeddingWiped() {
            return this.embeddingWiped;
        }

        public final boolean getIndexWiped() {
            return this.indexWiped;
        }

        public final boolean getOfflineCachesCleared() {
            return this.offlineCachesCleared;
        }

        public final Integer getPreviousEmbeddingVersion() {
            return this.previousEmbeddingVersion;
        }

        public final Integer getPreviousIndexVersion() {
            return this.previousIndexVersion;
        }

        public int hashCode() {
            int iG = a8.b.g(a8.b.g(Boolean.hashCode(this.indexWiped) * 31, 31, this.embeddingWiped), 31, this.offlineCachesCleared);
            Integer num = this.previousIndexVersion;
            int iHashCode = (iG + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.previousEmbeddingVersion;
            return iHashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "MigrationResult(indexWiped=" + this.indexWiped + ", embeddingWiped=" + this.embeddingWiped + ", offlineCachesCleared=" + this.offlineCachesCleared + ", previousIndexVersion=" + this.previousIndexVersion + ", previousEmbeddingVersion=" + this.previousEmbeddingVersion + ")";
        }
    }

    public MemoryFormatMigrator(IndexPersistence persistence, EmbeddingStorage embeddingStorage, p5.a aVar, MemoryLogger logger) {
        kotlin.jvm.internal.p.e(persistence, "persistence");
        kotlin.jvm.internal.p.e(logger, "logger");
        this.persistence = persistence;
        this.embeddingStorage = embeddingStorage;
        this.clearOfflineCaches = aVar;
        this.logger = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateIfNeeded$lambda$0(Integer num, Integer num2) {
        return "migrateIfNeeded: starting migration (index=" + num + "→3, embedding=" + num2 + "→2)";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateIfNeeded$lambda$1(Integer num, Integer num2) {
        return "migrateIfNeeded: no wipe required (index=" + num + "/3, embedding=" + num2 + "/2)";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateIfNeeded$lambda$2(int i8) {
        return a8.b.k(i8, "migrateIfNeeded: wiped BM25 index (", " files)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateIfNeeded$lambda$3(int i8) {
        return a8.b.k(i8, "migrateIfNeeded: wiped embedding storage (", " files)");
    }

    public final MigrationResult migrateIfNeeded() {
        boolean z;
        final Integer numPeekPersistedVersion = this.persistence.peekPersistedVersion();
        EmbeddingStorage embeddingStorage = this.embeddingStorage;
        final Integer numPeekFormatVersion = embeddingStorage != null ? embeddingStorage.peekFormatVersion() : null;
        boolean z2 = (numPeekPersistedVersion == null || numPeekPersistedVersion.intValue() == 3) ? false : true;
        boolean z8 = (this.embeddingStorage == null || numPeekFormatVersion == null || numPeekFormatVersion.intValue() == 2) ? false : true;
        if (z2 || z8) {
            final int i8 = 0;
            MemoryLogger.logI$default(this.logger, TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.u
                @Override // p5.a
                public final Object invoke() {
                    switch (i8) {
                        case 0:
                            return MemoryFormatMigrator.migrateIfNeeded$lambda$0(numPeekPersistedVersion, numPeekFormatVersion);
                        default:
                            return MemoryFormatMigrator.migrateIfNeeded$lambda$1(numPeekPersistedVersion, numPeekFormatVersion);
                    }
                }
            }, 2, null);
        } else {
            final int i9 = 1;
            MemoryLogger.logD$default(this.logger, TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.u
                @Override // p5.a
                public final Object invoke() {
                    switch (i9) {
                        case 0:
                            return MemoryFormatMigrator.migrateIfNeeded$lambda$0(numPeekPersistedVersion, numPeekFormatVersion);
                        default:
                            return MemoryFormatMigrator.migrateIfNeeded$lambda$1(numPeekPersistedVersion, numPeekFormatVersion);
                    }
                }
            }, 2, null);
        }
        if (z2) {
            MemoryLogger.logI$default(this.logger, TAG, null, new j(this.persistence.invalidatePersistedIndexes(), 3), 2, null);
        }
        if (z8) {
            EmbeddingStorage embeddingStorage2 = this.embeddingStorage;
            kotlin.jvm.internal.p.b(embeddingStorage2);
            MemoryLogger.logI$default(this.logger, TAG, null, new j(embeddingStorage2.wipeAll(), 4), 2, null);
        }
        p5.a aVar = this.clearOfflineCaches;
        if ((z2 || z8) && aVar != null) {
            aVar.invoke();
            z = true;
        } else {
            z = false;
        }
        EmbeddingStorage embeddingStorage3 = this.embeddingStorage;
        if (embeddingStorage3 != null) {
            embeddingStorage3.writeFormatVersion();
        }
        return new MigrationResult(z2, z8, z, numPeekPersistedVersion, numPeekFormatVersion);
    }

    public /* synthetic */ MemoryFormatMigrator(IndexPersistence indexPersistence, EmbeddingStorage embeddingStorage, p5.a aVar, MemoryLogger memoryLogger, int i8, kotlin.jvm.internal.i iVar) {
        this(indexPersistence, embeddingStorage, (i8 & 4) != 0 ? null : aVar, memoryLogger);
    }
}
