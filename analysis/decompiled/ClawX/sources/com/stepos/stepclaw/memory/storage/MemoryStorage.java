package com.stepos.stepclaw.memory.storage;

import a6.f0;
import a6.i0;
import a6.r0;
import b5.a0;
import c5.l;
import c5.m;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.memory.lightmem.evolution.EpisodicMemoryEvolutionState;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionIds;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.memory.storage.MemoryStorage;
import com.stepos.stepclaw.memory.storage.file.DailyMemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryFileManager;
import com.stepos.stepclaw.memory.storage.file.MemoryRecord;
import com.stepos.stepclaw.memory.storage.file.SingleMemoryFile;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import com.stepos.stepclaw.memory.utils.PerfTrace;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.w;
import p5.p;
import w5.k;
import x5.h;
import x5.j;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001<B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J6\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ4\u0010\"\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0004\b\"\u0010#J\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0$¢\u0006\u0004\b%\u0010&J>\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0086@¢\u0006\u0004\b*\u0010+J\r\u0010-\u001a\u00020,¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020,¢\u0006\u0004\b/\u0010.J\u0015\u00101\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\f¢\u0006\u0004\b1\u00102R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b5\u00106R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/stepos/stepclaw/memory/storage/MemoryStorage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/io/File;", "baseDir", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Ljava/io/File;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "item", "normalizeCatchMemoryItemForWrite", "(Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;)Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "line", "date", "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "parseLegacyEntry", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "category", "sessionId", "writeMemory", "(Ljava/lang/String;Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "markDocumentAsDeprecated", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memoryIndex", "containsMemoryIndex", "(Ljava/lang/String;JLjava/lang/String;)Z", "fromState", "toState", "singleDate", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "bulkUpdateState", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getCategories", "()Ljava/util/List;", "dateFrom", "dateTo", "categories", "readEntries", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "Lb5/a0;", "migrateAgentToAgentIdentity", "()V", "migrateMdToJsonl", "iso8601", "parseIso8601ToMillis", "(Ljava/lang/String;)J", "Ljava/io/File;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "getLogger", "()Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", "fileManager", "Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", "getFileManager", "()Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryStorage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> PERMANENT_CATEGORIES = l.k0(new String[]{"user_profile", "agent_identity"});
    private static final String TAG = "MemoryStorage";
    private final File baseDir;
    private final MemoryFileManager fileManager;
    private final MemoryLogger logger;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/MemoryStorage$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "PERMANENT_CATEGORIES", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getPERMANENT_CATEGORIES", "()Ljava/util/Set;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Set<String> getPERMANENT_CATEGORIES() {
            return MemoryStorage.PERMANENT_CATEGORIES;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.MemoryStorage$bulkUpdateState$2", f = "MemoryStorage.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.MemoryStorage$bulkUpdateState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p {
        final /* synthetic */ String $category;
        final /* synthetic */ String $fromState;
        final /* synthetic */ String $singleDate;
        final /* synthetic */ String $toState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, String str3, String str4, f5.c cVar) {
            super(2, cVar);
            this.$category = str;
            this.$singleDate = str2;
            this.$fromState = str3;
            this.$toState = str4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(String str) {
            return m0.f.c("bulkUpdateState: single-file category not supported: ", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(String str, String str2, int i8, String str3, String str4) {
            StringBuilder sbV = a8.b.v("bulkUpdateState: ", str, "/", str2, ": ");
            sbV.append(i8);
            sbV.append(" entries ");
            sbV.append(str3);
            sbV.append(" → ");
            sbV.append(str4);
            return sbV.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2(String str, String str2) {
            return a8.b.p("bulkUpdateState failed for ", str, "/", str2);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryStorage.this.new AnonymousClass2(this.$category, this.$singleDate, this.$fromState, this.$toState, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            int i8 = 0;
            if (MemoryStorage.this.getFileManager().isSingleFileCategory(this.$category)) {
                MemoryLogger.logW$default(MemoryStorage.this.getLogger(), MemoryStorage.TAG, null, new c(i8, this.$category), 2, null);
                return new Integer(0);
            }
            String str = this.$singleDate;
            int i9 = 0;
            for (final String str2 : str != null ? a.a.S(str) : MemoryStorage.this.getFileManager().listDates(this.$category)) {
                DailyMemoryFile dailyFile = MemoryStorage.this.getFileManager().getDailyFile(this.$category, str2);
                if (dailyFile.getExists()) {
                    try {
                        final int iBulkUpdateState = dailyFile.bulkUpdateState(this.$fromState, this.$toState);
                        if (iBulkUpdateState > 0) {
                            MemoryLogger logger = MemoryStorage.this.getLogger();
                            final String str3 = this.$category;
                            final String str4 = this.$fromState;
                            final String str5 = this.$toState;
                            MemoryLogger.logD$default(logger, MemoryStorage.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.storage.d
                                @Override // p5.a
                                public final Object invoke() {
                                    String str6 = str4;
                                    String str7 = str5;
                                    return MemoryStorage.AnonymousClass2.invokeSuspend$lambda$1(str3, str2, iBulkUpdateState, str6, str7);
                                }
                            }, 2, null);
                            i9 += iBulkUpdateState;
                        }
                    } catch (Exception e9) {
                        MemoryStorage.this.getLogger().logE(MemoryStorage.TAG, null, e9, new e(this.$category, i8, str2));
                    }
                }
            }
            return new Integer(i9);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Z"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.MemoryStorage$markDocumentAsDeprecated$2", f = "MemoryStorage.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.MemoryStorage$markDocumentAsDeprecated$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00542 extends h5.i implements p {
        final /* synthetic */ String $docId;
        int label;
        final /* synthetic */ MemoryStorage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00542(String str, MemoryStorage memoryStorage, f5.c cVar) {
            super(2, cVar);
            this.$docId = str;
            this.this$0 = memoryStorage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(String str) {
            return m0.f.c("markDocumentAsDeprecated: invalid docId format: ", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(String str) {
            return m0.f.c("markDocumentAsDeprecated: invalid docId format (no #): ", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2(String str) {
            return m0.f.c("markDocumentAsDeprecated: legacy hash-style docId no longer supported: ", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$3(String str) {
            return m0.f.c("markDocumentAsDeprecated: entry not found in file: ", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$4(String str) {
            return m0.f.c("markDocumentAsDeprecated: success, docId=", str);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00542(this.$docId, this.this$0, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00542) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            int i8 = 2;
            List listG1 = n.G1(this.$docId, new String[]{"/"}, 2, 2);
            int i9 = 1;
            if (listG1.size() != 2) {
                MemoryLogger.logW$default(this.this$0.getLogger(), MemoryStorage.TAG, null, new c(i9, this.$docId), 2, null);
                return Boolean.FALSE;
            }
            String str = (String) listG1.get(0);
            List listG12 = n.G1((CharSequence) listG1.get(1), new String[]{"#"}, 2, 2);
            if (listG12.size() != 2) {
                MemoryLogger.logW$default(this.this$0.getLogger(), MemoryStorage.TAG, null, new c(i8, this.$docId), 2, null);
                return Boolean.FALSE;
            }
            String str2 = (String) listG12.get(0);
            Long lF1 = u.f1((String) listG12.get(1));
            if (lF1 == null) {
                MemoryLogger.logW$default(this.this$0.getLogger(), MemoryStorage.TAG, null, new c(3, this.$docId), 2, null);
                return Boolean.FALSE;
            }
            if (kotlin.jvm.internal.p.a(str2, MemoryFile.PERMANENT_DATE) ? this.this$0.getFileManager().getSingleFile(str).updateEntryStateByMemoryIndex(lF1.longValue(), EpisodicMemoryEvolutionState.DEPRECATED) : this.this$0.getFileManager().getDailyFile(str, str2).updateEntryStateByMemoryIndex(lF1.longValue(), EpisodicMemoryEvolutionState.DEPRECATED)) {
                MemoryLogger.logD$default(this.this$0.getLogger(), MemoryStorage.TAG, null, new c(5, this.$docId), 2, null);
                return Boolean.TRUE;
            }
            MemoryLogger.logW$default(this.this$0.getLogger(), MemoryStorage.TAG, null, new c(4, this.$docId), 2, null);
            return Boolean.FALSE;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "<anonymous>", "(La6/f0;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.MemoryStorage$readEntries$2", f = "MemoryStorage.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.MemoryStorage$readEntries$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00552 extends h5.i implements p {
        final /* synthetic */ List<String> $categories;
        final /* synthetic */ String $dateFrom;
        final /* synthetic */ String $dateTo;
        int label;
        final /* synthetic */ MemoryStorage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00552(List<String> list, MemoryStorage memoryStorage, String str, String str2, f5.c cVar) {
            super(2, cVar);
            this.$categories = list;
            this.this$0 = memoryStorage;
            this.$dateFrom = str;
            this.$dateTo = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(DailyMemoryFile dailyMemoryFile, Exception exc) {
            return a8.b.p("readEntries: failed to read ", dailyMemoryFile.getFile().getName(), ": ", exc.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$4(SingleMemoryFile singleMemoryFile, Exception exc) {
            return a8.b.p("readEntries: failed to read single file ", singleMemoryFile.getCategory(), ": ", exc.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$5(Exception exc) {
            return m0.f.c("readEntries: unexpected error: ", exc.getMessage());
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00552(this.$categories, this.this$0, this.$dateFrom, this.$dateTo, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00552) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00bd A[Catch: Exception -> 0x0019, TryCatch #1 {Exception -> 0x0019, blocks: (B:5:0x000e, B:7:0x0016, B:17:0x0048, B:18:0x005a, B:20:0x0060, B:24:0x0070, B:25:0x0085, B:27:0x008d, B:29:0x0093, B:32:0x009b, B:33:0x009f, B:35:0x00a5, B:37:0x00b5, B:39:0x00bd, B:47:0x00f9, B:48:0x00fd, B:50:0x0103, B:54:0x0113, B:40:0x00c8, B:41:0x00dd, B:43:0x00e3, B:45:0x00f4, B:10:0x001c, B:11:0x0029, B:13:0x002f, B:15:0x0040, B:16:0x0044, B:21:0x0067, B:51:0x010a), top: B:62:0x000e, inners: #0, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c8 A[Catch: Exception -> 0x0019, TryCatch #1 {Exception -> 0x0019, blocks: (B:5:0x000e, B:7:0x0016, B:17:0x0048, B:18:0x005a, B:20:0x0060, B:24:0x0070, B:25:0x0085, B:27:0x008d, B:29:0x0093, B:32:0x009b, B:33:0x009f, B:35:0x00a5, B:37:0x00b5, B:39:0x00bd, B:47:0x00f9, B:48:0x00fd, B:50:0x0103, B:54:0x0113, B:40:0x00c8, B:41:0x00dd, B:43:0x00e3, B:45:0x00f4, B:10:0x001c, B:11:0x0029, B:13:0x002f, B:15:0x0040, B:16:0x0044, B:21:0x0067, B:51:0x010a), top: B:62:0x000e, inners: #0, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0103 A[Catch: Exception -> 0x0019, TRY_LEAVE, TryCatch #1 {Exception -> 0x0019, blocks: (B:5:0x000e, B:7:0x0016, B:17:0x0048, B:18:0x005a, B:20:0x0060, B:24:0x0070, B:25:0x0085, B:27:0x008d, B:29:0x0093, B:32:0x009b, B:33:0x009f, B:35:0x00a5, B:37:0x00b5, B:39:0x00bd, B:47:0x00f9, B:48:0x00fd, B:50:0x0103, B:54:0x0113, B:40:0x00c8, B:41:0x00dd, B:43:0x00e3, B:45:0x00f4, B:10:0x001c, B:11:0x0029, B:13:0x002f, B:15:0x0040, B:16:0x0044, B:21:0x0067, B:51:0x010a), top: B:62:0x000e, inners: #0, #2 }] */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 325
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.storage.MemoryStorage.C00552.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.MemoryStorage$writeMemory$2", f = "MemoryStorage.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.MemoryStorage$writeMemory$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00562 extends h5.i implements p {
        final /* synthetic */ String $category;
        final /* synthetic */ String $date;
        final /* synthetic */ CatchMemoryItem $item;
        final /* synthetic */ String $sessionId;
        int label;
        final /* synthetic */ MemoryStorage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00562(String str, String str2, CatchMemoryItem catchMemoryItem, MemoryStorage memoryStorage, String str3, f5.c cVar) {
            super(2, cVar);
            this.$category = str;
            this.$date = str2;
            this.$item = catchMemoryItem;
            this.this$0 = memoryStorage;
            this.$sessionId = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(long j4, String str) {
            return "[PERF] writeMemory total: cost=" + j4 + "ms" + str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2() {
            return "Failed to write memory";
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00562(this.$category, this.$date, this.$item, this.this$0, this.$sessionId, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00562) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws Exception {
            MemoryRecord memoryRecordAppendEntry;
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            String strNormalizeCategory = MemoryFile.INSTANCE.normalizeCategory(this.$category);
            PerfTrace perfTrace = PerfTrace.INSTANCE;
            long jCurrentTimeMillis = perfTrace.getEnabled() ? System.currentTimeMillis() : 0L;
            try {
                ALog.d$default(MemoryStorage.TAG, "[writeMemory] start: category=" + strNormalizeCategory + ", date=" + this.$date + ", content=" + n.Q1(50, this.$item.getContent()) + "..., memoryIndex=" + this.$item.getMemoryIndex() + ", state=" + this.$item.getState(), null, 4, null);
                boolean zIsSingleFileCategory = this.this$0.getFileManager().isSingleFileCategory(strNormalizeCategory);
                MemoryFile singleFile = zIsSingleFileCategory ? this.this$0.getFileManager().getSingleFile(strNormalizeCategory) : this.this$0.getFileManager().getDailyFile(strNormalizeCategory, this.$date);
                ALog.d$default(MemoryStorage.TAG, "[writeMemory] file resolved: path=" + singleFile.getFile().getAbsolutePath() + ", exists=" + singleFile.getExists() + ", isSingleFile=" + zIsSingleFileCategory, null, 4, null);
                CatchMemoryItem catchMemoryItemNormalizeCatchMemoryItemForWrite = this.this$0.normalizeCatchMemoryItemForWrite(this.$item);
                ALog.d$default(MemoryStorage.TAG, "[writeMemory] normalized item: memoryIndex=" + catchMemoryItemNormalizeCatchMemoryItemForWrite.getMemoryIndex() + ", state=" + catchMemoryItemNormalizeCatchMemoryItemForWrite.getState(), null, 4, null);
                try {
                    String str = this.$sessionId;
                    boolean enabled = perfTrace.getEnabled();
                    final String strConcat = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                    if (enabled) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        MemoryRecord memoryRecordAppendEntry2 = singleFile.appendEntry(catchMemoryItemNormalizeCatchMemoryItemForWrite);
                        String strConcat2 = str != null ? " | traceId=".concat(str) : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        MemoryLogger logger = perfTrace.getLogger();
                        if (logger != null) {
                            logger.logD(MemoryStorage.TAG, str, new PerfTrace.AnonymousClass1("writeMemory.appendEntry", jCurrentTimeMillis2, strConcat2));
                        }
                        memoryRecordAppendEntry = memoryRecordAppendEntry2;
                    } else {
                        memoryRecordAppendEntry = singleFile.appendEntry(catchMemoryItemNormalizeCatchMemoryItemForWrite);
                    }
                    ALog.d$default(MemoryStorage.TAG, "[writeMemory] appendEntry result: entry=" + memoryRecordAppendEntry, null, 4, null);
                    final long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                    String str2 = this.$sessionId;
                    if (str2 != null) {
                        strConcat = " | traceId=".concat(str2);
                    }
                    this.this$0.getLogger().logD(MemoryStorage.TAG, this.$sessionId, new p5.a() { // from class: com.stepos.stepclaw.memory.storage.f
                        @Override // p5.a
                        public final Object invoke() {
                            return MemoryStorage.C00562.invokeSuspend$lambda$1(jCurrentTimeMillis3, strConcat);
                        }
                    });
                    return memoryRecordAppendEntry;
                } catch (Exception e9) {
                    ALog.e(MemoryStorage.TAG, "[writeMemory] appendEntry EXCEPTION: " + e9.getClass().getSimpleName() + " - " + e9.getMessage(), e9);
                    throw e9;
                }
            } catch (Exception e10) {
                this.this$0.getLogger().logE(MemoryStorage.TAG, this.$sessionId, e10, new g());
                return null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MemoryStorage(File baseDir, MemoryLogger logger) {
        kotlin.jvm.internal.p.e(baseDir, "baseDir");
        kotlin.jvm.internal.p.e(logger, "logger");
        this.baseDir = baseDir;
        this.logger = logger;
        this.fileManager = new MemoryFileManager(baseDir, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Object bulkUpdateState$default(MemoryStorage memoryStorage, String str, String str2, String str3, String str4, f5.c cVar, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            str4 = null;
        }
        return memoryStorage.bulkUpdateState(str, str2, str3, str4, cVar);
    }

    public static /* synthetic */ boolean containsMemoryIndex$default(MemoryStorage memoryStorage, String str, long j4, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = MemoryFile.INSTANCE.todayDate();
        }
        return memoryStorage.containsMemoryIndex(str, j4, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateAgentToAgentIdentity$lambda$3(w wVar, List list) {
        return "migrateAgentToAgentIdentity: migrated " + wVar.f3684a + " lines from " + list.size() + " daily files";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean migrateMdToJsonl$lambda$0(File it) {
        kotlin.jvm.internal.p.e(it, "it");
        if (it.isFile()) {
            String name = it.getName();
            kotlin.jvm.internal.p.d(name, "getName(...)");
            if (u.V0(name, ".md", false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateMdToJsonl$lambda$3(File file, File file2, List list) {
        String name = file.getName();
        String name2 = file2.getName();
        return m0.f.e(a8.b.v("Migrated: ", name, " -> ", name2, " ("), list.size(), " entries)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateMdToJsonl$lambda$4(File file, Exception exc) {
        return a8.b.p("Migration failed for ", file.getPath(), ": ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateMdToJsonl$lambda$5(w wVar, w wVar2) {
        return "MD->JSONL migration: " + wVar.f3684a + " migrated, " + wVar2.f3684a + " failed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CatchMemoryItem normalizeCatchMemoryItemForWrite(CatchMemoryItem item) {
        Long memoryIndex = item.getMemoryIndex();
        long jLongValue = memoryIndex != null ? memoryIndex.longValue() : OfflineEvolutionIds.INSTANCE.newMemoryIndexId();
        String strNormalizeState = EpisodicMemoryEvolutionState.INSTANCE.normalizeState(item.getState());
        Long memoryIndex2 = item.getMemoryIndex();
        return (memoryIndex2 != null && jLongValue == memoryIndex2.longValue() && kotlin.jvm.internal.p.a(strNormalizeState, item.getState())) ? item : CatchMemoryItem.copy$default(item, null, 0.0d, null, null, strNormalizeState, Long.valueOf(jLongValue), null, 79, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parseIso8601ToMillis$lambda$0(String str) {
        return m0.f.d("Failed to parse ISO 8601 time: ", str, ", using current time");
    }

    private final MemoryRecord parseLegacyEntry(String line, String date) {
        String str;
        Long lF1;
        String string = n.T1(line).toString();
        if (!u.c1(string, MemoryFile.ENTRY_PREFIX, false)) {
            return null;
        }
        String string2 = n.T1(n.B1(string, MemoryFile.ENTRY_PREFIX)).toString();
        if (string2.length() == 0) {
            return null;
        }
        MemoryFile.Companion companion = MemoryFile.INSTANCE;
        j jVarB = x5.l.b(companion.getTIMESTAMP_PATTERN(), string2);
        long jCurrentTimeMillis = (jVarB == null || (str = (String) ((h) jVarB.a()).get(1)) == null || (lF1 = u.f1(str)) == null) ? System.currentTimeMillis() : lF1.longValue();
        String string3 = n.T1(companion.getTIMESTAMP_PATTERN().f(string2)).toString();
        if (string3.length() == 0) {
            return null;
        }
        return new MemoryRecord(companion.generateEntryId(string3, MemoryIndexManager.LEGACY_CATEGORY, date), string3, jCurrentTimeMillis, MemoryIndexManager.LEGACY_CATEGORY, date, 0.0d, null, null, 0L, null, 992, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object readEntries$default(MemoryStorage memoryStorage, String str, String str2, List list, f5.c cVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = null;
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        if ((i8 & 4) != 0) {
            list = s.f1092a;
        }
        return memoryStorage.readEntries(str, str2, list, cVar);
    }

    public static /* synthetic */ Object writeMemory$default(MemoryStorage memoryStorage, String str, CatchMemoryItem catchMemoryItem, String str2, String str3, f5.c cVar, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            str3 = MemoryFile.INSTANCE.todayDate();
        }
        return memoryStorage.writeMemory(str, catchMemoryItem, str2, str3, cVar);
    }

    public final Object bulkUpdateState(String str, String str2, String str3, String str4, f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new AnonymousClass2(str, str4, str2, str3, null), cVar);
    }

    public final boolean containsMemoryIndex(String category, long memoryIndex, String date) {
        kotlin.jvm.internal.p.e(category, "category");
        kotlin.jvm.internal.p.e(date, "date");
        String strNormalizeCategory = MemoryFile.INSTANCE.normalizeCategory(category);
        return (this.fileManager.isSingleFileCategory(strNormalizeCategory) ? this.fileManager.getSingleFile(strNormalizeCategory) : this.fileManager.getDailyFile(strNormalizeCategory, date)).containsMemoryIndex(memoryIndex);
    }

    public final List<String> getCategories() {
        return this.fileManager.listCategories();
    }

    public final MemoryFileManager getFileManager() {
        return this.fileManager;
    }

    public final MemoryLogger getLogger() {
        return this.logger;
    }

    public final Object markDocumentAsDeprecated(String str, f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new C00542(str, this, null), cVar);
    }

    public final void migrateAgentToAgentIdentity() throws IOException {
        File file = new File(this.baseDir, "stepmem/agent");
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(this.baseDir, "stepmem/agent_identity.jsonl");
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file3 : fileArrListFiles) {
                    if (file3.isFile()) {
                        String name = file3.getName();
                        kotlin.jvm.internal.p.d(name, "getName(...)");
                        if (u.V0(name, MemoryFile.EXTENSION, false)) {
                            arrayList.add(file3);
                        }
                    }
                }
                List<File> listJ0 = m.J0(arrayList, new Comparator() { // from class: com.stepos.stepclaw.memory.storage.MemoryStorage$migrateAgentToAgentIdentity$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t8, T t9) {
                        return a.a.l(((File) t8).getName(), ((File) t9).getName());
                    }
                });
                if (listJ0.isEmpty()) {
                    m5.l.z0(file);
                    return;
                }
                w wVar = new w();
                for (File file4 : listJ0) {
                    kotlin.jvm.internal.p.b(file4);
                    ArrayList arrayListD0 = m5.l.D0(file4);
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayListD0.size();
                    int i8 = 0;
                    while (i8 < size) {
                        Object obj = arrayListD0.get(i8);
                        i8++;
                        if (n.T1((String) obj).toString().length() > 0) {
                            arrayList2.add(obj);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        m5.l.w0(file2, a8.b.n(m.A0(arrayList2, "\n", null, null, null, 62), "\n"), x5.a.f6276a);
                        wVar.f3684a = arrayList2.size() + wVar.f3684a;
                    }
                }
                m5.l.z0(file);
                File file5 = new File(this.baseDir, "stepmem/index/agent");
                if (file5.exists() && file5.isDirectory()) {
                    File file6 = new File(this.baseDir, "stepmem/index/agent_identity");
                    if (file6.exists()) {
                        m5.l.z0(file5);
                    } else {
                        file5.renameTo(file6);
                    }
                }
                MemoryLogger.logI$default(this.logger, TAG, null, new e(wVar, 5, listJ0), 2, null);
            }
        }
    }

    public final void migrateMdToJsonl() {
        File file = new File(this.baseDir, "stepmem");
        if (file.exists() && file.isDirectory()) {
            w wVar = new w();
            w wVar2 = new w();
            List<File> listX0 = k.x0(new w5.g(new m5.j(file, m5.k.f3923a, null), new a(), 0));
            if (listX0.isEmpty()) {
                return;
            }
            for (File file2 : listX0) {
                File file3 = new File(file2.getParentFile(), m5.l.A0(file2).concat(MemoryFile.EXTENSION));
                try {
                    if (file3.exists()) {
                        file2.delete();
                        wVar.f3684a++;
                    } else {
                        ArrayList arrayListD0 = m5.l.D0(file2);
                        ArrayList arrayList = new ArrayList();
                        int size = arrayListD0.size();
                        int i8 = 0;
                        int i9 = 0;
                        while (i9 < size) {
                            Object obj = arrayListD0.get(i9);
                            i9++;
                            if (u.c1((String) obj, MemoryFile.ENTRY_PREFIX, false)) {
                                arrayList.add(obj);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        int size2 = arrayList.size();
                        int i10 = 0;
                        while (i10 < size2) {
                            Object obj2 = arrayList.get(i10);
                            i10++;
                            MemoryRecord legacyEntry = parseLegacyEntry((String) obj2, m5.l.A0(file2));
                            if (legacyEntry != null) {
                                arrayList2.add(legacyEntry);
                            }
                        }
                        if (arrayList2.isEmpty()) {
                            file2.delete();
                            wVar.f3684a++;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            int size3 = arrayList2.size();
                            while (i8 < size3) {
                                Object obj3 = arrayList2.get(i8);
                                i8++;
                                MemoryRecord memoryRecord = (MemoryRecord) obj3;
                                double d = 0.0d;
                                String str = null;
                                sb.append(new CatchMemoryItem(memoryRecord.getContent(), d, str, MemoryFile.INSTANCE.formatAsIso8601(memoryRecord.getCreatedAt()), EpisodicMemoryEvolutionState.PENDING, Long.valueOf(OfflineEvolutionIds.INSTANCE.newMemoryIndexId()), null, 68, (i) null).toJsonString());
                                sb.append('\n');
                            }
                            String string = sb.toString();
                            kotlin.jvm.internal.p.d(string, "toString(...)");
                            m5.l.G0(file3, string, x5.a.f6276a);
                            file2.delete();
                            wVar.f3684a++;
                            MemoryLogger.logD$default(this.logger, TAG, null, new com.stepos.stepclaw.memory.embedding.g(file2, file3, arrayList2, 2), 2, null);
                        }
                    }
                } catch (Exception e9) {
                    wVar2.f3684a++;
                    MemoryLogger.logW$default(this.logger, TAG, null, new e(file2, 3, e9), 2, null);
                }
            }
            if (wVar.f3684a > 0 || wVar2.f3684a > 0) {
                MemoryLogger.logI$default(this.logger, TAG, null, new e(wVar, 4, wVar2), 2, null);
            }
        }
    }

    public final long parseIso8601ToMillis(String iso8601) {
        kotlin.jvm.internal.p.e(iso8601, "iso8601");
        if (n.t1(iso8601)) {
            return System.currentTimeMillis();
        }
        try {
            try {
                return Instant.parse(iso8601).toEpochMilli();
            } catch (Exception unused) {
                MemoryLogger.logW$default(this.logger, TAG, null, new c(6, iso8601), 2, null);
                return System.currentTimeMillis();
            }
        } catch (Exception unused2) {
            return ((Instant) DateTimeFormatter.ISO_DATE_TIME.parse(iso8601, new b())).toEpochMilli();
        }
    }

    public final Object readEntries(String str, String str2, List<String> list, f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new C00552(list, this, str, str2, null), cVar);
    }

    public final Object writeMemory(String str, CatchMemoryItem catchMemoryItem, String str2, String str3, f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new C00562(str, str3, catchMemoryItem, this, str2, null), cVar);
    }

    public /* synthetic */ MemoryStorage(File file, MemoryLogger memoryLogger, int i8, i iVar) {
        this(file, (i8 & 2) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
