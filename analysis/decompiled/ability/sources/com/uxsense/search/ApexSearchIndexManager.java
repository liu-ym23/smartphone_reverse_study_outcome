package com.uxsense.search;

import C7.r;
import C9.AbstractC0200b;
import C9.g;
import D7.v;
import J7.c;
import O7.i;
import S7.n;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.uxsense.base.metadata.Comment;
import com.uxsense.base.metadata.Creation;
import com.uxsense.base.metadata.User;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.file.FileException;
import com.uxsense.file.FileResult;
import com.uxsense.parse.b;
import j9.AbstractC1607a;
import j9.m;
import java.io.File;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.sync.a;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.d;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001kB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJB\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"H\u0086@¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b\u0012\u0010*J \u0010+\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0086@¢\u0006\u0004\b+\u0010,J&\u0010.\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020(0\u0017H\u0086@¢\u0006\u0004\b.\u0010\u001aJ\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b/\u0010'J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u00101\u001a\u000200¢\u0006\u0004\b\u0012\u00102J \u00103\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0086@¢\u0006\u0004\b3\u00104J.\u00106\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u0002000\u0017H\u0086@¢\u0006\u0004\b6\u00107J&\u00108\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b8\u0010\u001dJ\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b9\u0010'J\u001e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140:2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b;\u0010'J\u001e\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140:2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b<\u0010'J&\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140:2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b=\u0010\u001dJ\u0018\u0010>\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b>\u0010'J,\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110@\u0018\u00010?2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bA\u0010'J\u0010\u0010B\u001a\u00020\u0014H\u0086@¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bD\u0010'J\u0018\u0010E\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bE\u0010'J\u0010\u0010F\u001a\u00020\u0014H\u0086@¢\u0006\u0004\bF\u0010CJ\"\u0010H\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020\u001bH\u0086@¢\u0006\u0004\bH\u0010IJ\u0018\u0010J\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bJ\u0010'J\u0018\u0010K\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bK\u0010'J\u0018\u0010M\u001a\u00020L2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bM\u0010'J\u0018\u0010N\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bN\u0010'J\u001e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\bO\u0010'J\u001e\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\bP\u0010'J&\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\bQ\u0010\u001dJ\u0018\u0010R\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\bR\u0010'R\u0014\u0010S\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082T¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R&\u0010]\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110@0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R&\u0010_\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110@0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010^R2\u0010`\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110@0?0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010^R \u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020U0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010^R \u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010^R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00040c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00040c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010eR&\u0010g\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0c0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010^R\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006l"}, d2 = {"Lcom/uxsense/search/ApexSearchIndexManager;", "", AppAgent.CONSTRUCT, "()V", "", "appName", "Ljava/nio/file/Path;", "getSearchIndexDir", "(Ljava/lang/String;)Ljava/nio/file/Path;", "getCreationIndexFile", "getUserIndexFile", "", "creationId", "getCommentIndexFile", "(Ljava/lang/String;J)Ljava/nio/file/Path;", "Lcom/uxsense/base/metadata/Creation;", "creation", "Lcom/uxsense/search/SearchableEntity;", "createSearchableEntity", "(Lcom/uxsense/base/metadata/Creation;)Lcom/uxsense/search/SearchableEntity;", "LC7/r;", "indexCreation", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;LH7/c;)Ljava/lang/Object;", "", "creations", "indexCreations", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "", "removeCreationIndex", "(Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "title", "authorNickname", "Lcom/uxsense/search/MatchMode;", "matchMode", "", "threshold", "findExistingCreation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/search/MatchMode;FLH7/c;)Ljava/lang/Object;", "getCreationIndex", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/base/metadata/User;", BffConstant.Role.User, "(Lcom/uxsense/base/metadata/User;)Lcom/uxsense/search/SearchableEntity;", "indexUser", "(Ljava/lang/String;Lcom/uxsense/base/metadata/User;LH7/c;)Ljava/lang/Object;", "users", "indexUsers", "getUserIndex", "Lcom/uxsense/base/metadata/Comment;", "comment", "(Lcom/uxsense/base/metadata/Comment;)Lcom/uxsense/search/SearchableEntity;", "indexComment", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Comment;LH7/c;)Ljava/lang/Object;", "comments", "indexComments", "(Ljava/lang/String;JLjava/util/List;LH7/c;)Ljava/lang/Object;", "getCommentIndex", "getAllCommentIndex", "Lcom/uxsense/file/FileResult;", "saveCreationIndex", "saveUserIndex", "saveCommentIndex", "saveAllIndex", "", "", "clearCache", "clearAllCache", "(LH7/c;)Ljava/lang/Object;", "saveDirtyIndexes", "flushDirtyIndexes", "flushAllDirtyIndexes", "includeCreations", "rebuildIndex", "(Ljava/lang/String;ZLH7/c;)Ljava/lang/Object;", "needsRebuild", "initializeIfNeeded", "Lcom/uxsense/search/ApexSearchIndexManager$IndexStats;", "getIndexStats", "hasDirtyIndexes", "loadCreationIndex", "loadUserIndex", "loadCommentIndex", "checkAndAutoSave", "TAG", "Ljava/lang/String;", "", "AUTO_SAVE_THRESHOLD", "I", "AUTO_SAVE_INTERVAL_MS", "J", "LC9/b;", "json", "LC9/b;", "creationIndexCache", "Ljava/util/Map;", "userIndexCache", "commentIndexCache", "updateCounters", "lastSaveTime", "", "dirtyCreationIndex", "Ljava/util/Set;", "dirtyUserIndex", "dirtyCommentIndex", "Lw9/a;", "mutex", "Lw9/a;", "IndexStats", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexSearchIndexManager {
    private static final long AUTO_SAVE_INTERVAL_MS = 60000;
    private static final int AUTO_SAVE_THRESHOLD = 10;
    private static final String TAG = "ApexSearchIndexManager";
    public static final ApexSearchIndexManager INSTANCE = new ApexSearchIndexManager();
    private static final AbstractC0200b json = e.b(new b(5));
    private static final Map<String, List<SearchableEntity>> creationIndexCache = new LinkedHashMap();
    private static final Map<String, List<SearchableEntity>> userIndexCache = new LinkedHashMap();
    private static final Map<String, Map<Long, List<SearchableEntity>>> commentIndexCache = new LinkedHashMap();
    private static final Map<String, Integer> updateCounters = new LinkedHashMap();
    private static final Map<String, Long> lastSaveTime = new LinkedHashMap();
    private static final Set<String> dirtyCreationIndex = new LinkedHashSet();
    private static final Set<String> dirtyUserIndex = new LinkedHashSet();
    private static final Map<String, Set<Long>> dirtyCommentIndex = new LinkedHashMap();
    private static final InterfaceC2108a mutex = new a();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/uxsense/search/ApexSearchIndexManager$IndexStats;", "", "creationCount", "", "userCount", "commentCount", "lastUpdated", "", AppAgent.CONSTRUCT, "(IIIJ)V", "getCreationCount", "()I", "getUserCount", "getCommentCount", "getLastUpdated", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class IndexStats {
        private final int commentCount;
        private final int creationCount;
        private final long lastUpdated;
        private final int userCount;

        public IndexStats(int i, int i6, int i10, long j5) {
            this.creationCount = i;
            this.userCount = i6;
            this.commentCount = i10;
            this.lastUpdated = j5;
        }

        public static /* synthetic */ IndexStats copy$default(IndexStats indexStats, int i, int i6, int i10, long j5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i = indexStats.creationCount;
            }
            if ((i11 & 2) != 0) {
                i6 = indexStats.userCount;
            }
            if ((i11 & 4) != 0) {
                i10 = indexStats.commentCount;
            }
            if ((i11 & 8) != 0) {
                j5 = indexStats.lastUpdated;
            }
            int i12 = i10;
            return indexStats.copy(i, i6, i12, j5);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCreationCount() {
            return this.creationCount;
        }

        /* renamed from: component2, reason: from getter */
        public final int getUserCount() {
            return this.userCount;
        }

        /* renamed from: component3, reason: from getter */
        public final int getCommentCount() {
            return this.commentCount;
        }

        /* renamed from: component4, reason: from getter */
        public final long getLastUpdated() {
            return this.lastUpdated;
        }

        public final IndexStats copy(int creationCount, int userCount, int commentCount, long lastUpdated) {
            return new IndexStats(creationCount, userCount, commentCount, lastUpdated);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IndexStats)) {
                return false;
            }
            IndexStats indexStats = (IndexStats) other;
            return this.creationCount == indexStats.creationCount && this.userCount == indexStats.userCount && this.commentCount == indexStats.commentCount && this.lastUpdated == indexStats.lastUpdated;
        }

        public final int getCommentCount() {
            return this.commentCount;
        }

        public final int getCreationCount() {
            return this.creationCount;
        }

        public final long getLastUpdated() {
            return this.lastUpdated;
        }

        public final int getUserCount() {
            return this.userCount;
        }

        public int hashCode() {
            return Long.hashCode(this.lastUpdated) + androidx.constraintlayout.core.dsl.a.a(this.commentCount, androidx.constraintlayout.core.dsl.a.a(this.userCount, Integer.hashCode(this.creationCount) * 31, 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("IndexStats(creationCount=");
            sb.append(this.creationCount);
            sb.append(", userCount=");
            sb.append(this.userCount);
            sb.append(", commentCount=");
            sb.append(this.commentCount);
            sb.append(", lastUpdated=");
            return B7.a.p(sb, this.lastUpdated, ')');
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 572}, m = "checkAndAutoSave")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$checkAndAutoSave$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.checkAndAutoSave(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752}, m = "clearAllCache")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$clearAllCache$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13071(H7.c<? super C13071> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.clearAllCache(this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752}, m = "clearCache")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$clearCache$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13081(H7.c<? super C13081> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.clearCache(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {193}, m = "findExistingCreation")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$findExistingCreation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13091 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13091(H7.c<? super C13091> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.findExistingCreation(null, null, null, null, 0.0f, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 630}, m = "flushAllDirtyIndexes")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$flushAllDirtyIndexes$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13101(H7.c<? super C13101> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.flushAllDirtyIndexes(this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752}, m = "getAllCommentIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$getAllCommentIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13111(H7.c<? super C13111> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.getAllCommentIndex(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 381}, m = "getCommentIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$getCommentIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13121 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13121(H7.c<? super C13121> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.getCommentIndex(null, 0L, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 219}, m = "getCreationIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$getCreationIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13131(H7.c<? super C13131> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.getCreationIndex(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752}, m = "getIndexStats")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$getIndexStats$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13141(H7.c<? super C13141> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.getIndexStats(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 300}, m = "getUserIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$getUserIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13151(H7.c<? super C13151> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.getUserIndex(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752}, m = "hasDirtyIndexes")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$hasDirtyIndexes$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13161(H7.c<? super C13161> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.hasDirtyIndexes(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 349}, m = "indexComment")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$indexComment$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13171(H7.c<? super C13171> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.indexComment(null, null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 373}, m = "indexComments")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$indexComments$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13181 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13181(H7.c<? super C13181> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.indexComments(null, 0L, null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 141}, m = "indexCreation")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$indexCreation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13191(H7.c<? super C13191> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.indexCreation(null, null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 164}, m = "indexCreations")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$indexCreations$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13201(H7.c<? super C13201> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.indexCreations(null, null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 269}, m = "indexUser")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$indexUser$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13211(H7.c<? super C13211> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.indexUser(null, null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 292}, m = "indexUsers")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$indexUsers$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13221(H7.c<? super C13221> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.indexUsers(null, null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {709, 710, 713, 714}, m = "initializeIfNeeded")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$initializeIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13231 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13231(H7.c<? super C13231> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.initializeIfNeeded(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager$loadCommentIndex$2", f = "ApexSearchIndexManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/SearchableEntity;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$loadCommentIndex$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $creationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, long j5, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$creationId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$appName, this.$creationId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            try {
                File file = ApexSearchIndexManager.INSTANCE.getCommentIndexFile(this.$appName, this.$creationId).toFile();
                if (!file.exists()) {
                    return EmptyList.f4893a;
                }
                AbstractC0200b abstractC0200b = ApexSearchIndexManager.json;
                String strX = i.X(file, AbstractC1607a.f4778a);
                abstractC0200b.getClass();
                return ((SearchIndex) abstractC0200b.a(SearchIndex.INSTANCE.serializer(), strX)).getEntities();
            } catch (Exception unused) {
                return EmptyList.f4893a;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<SearchableEntity>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager$loadCreationIndex$2", f = "ApexSearchIndexManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/SearchableEntity;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$loadCreationIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13242 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13242(String str, H7.c<? super C13242> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13242(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            try {
                File file = ApexSearchIndexManager.INSTANCE.getCreationIndexFile(this.$appName).toFile();
                if (!file.exists()) {
                    return EmptyList.f4893a;
                }
                AbstractC0200b abstractC0200b = ApexSearchIndexManager.json;
                String strX = i.X(file, AbstractC1607a.f4778a);
                abstractC0200b.getClass();
                return ((SearchIndex) abstractC0200b.a(SearchIndex.INSTANCE.serializer(), strX)).getEntities();
            } catch (Exception unused) {
                return EmptyList.f4893a;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<SearchableEntity>> cVar) {
            return ((C13242) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager$loadUserIndex$2", f = "ApexSearchIndexManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/SearchableEntity;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$loadUserIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13252 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13252(String str, H7.c<? super C13252> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13252(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            try {
                File file = ApexSearchIndexManager.INSTANCE.getUserIndexFile(this.$appName).toFile();
                if (!file.exists()) {
                    return EmptyList.f4893a;
                }
                AbstractC0200b abstractC0200b = ApexSearchIndexManager.json;
                String strX = i.X(file, AbstractC1607a.f4778a);
                abstractC0200b.getClass();
                return ((SearchIndex) abstractC0200b.a(SearchIndex.INSTANCE.serializer(), strX)).getEntities();
            } catch (Exception unused) {
                return EmptyList.f4893a;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<SearchableEntity>> cVar) {
            return ((C13252) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager$needsRebuild$2", f = "ApexSearchIndexManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$needsRebuild$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13262 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13262(String str, H7.c<? super C13262> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13262(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            ApexSearchIndexManager apexSearchIndexManager = ApexSearchIndexManager.INSTANCE;
            return Boolean.valueOf((apexSearchIndexManager.getUserIndexFile(this.$appName).toFile().exists() || apexSearchIndexManager.getCreationIndexFile(this.$appName).toFile().exists()) ? false : true);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((C13262) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 657, 762, 684}, m = "rebuildIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$rebuildIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13271(H7.c<? super C13271> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.rebuildIndex(null, false, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager$rebuildIndex$3", f = "ApexSearchIndexManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$rebuildIndex$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, H7.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass3(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            File file = ApexSearchIndexManager.INSTANCE.getSearchIndexDir(this.$appName).toFile();
            if (file.exists()) {
                i.T(file);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752}, m = "removeCreationIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$removeCreationIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13281 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13281(H7.c<? super C13281> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.removeCreationIndex(null, 0L, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {521, 522, 752, 526}, m = "saveAllIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$saveAllIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13291(H7.c<? super C13291> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.saveAllIndex(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager$saveCommentIndex$2", f = "ApexSearchIndexManager.kt", l = {752}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$saveCommentIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13302 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $creationId;
        long J$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13302(String str, long j5, H7.c<? super C13302> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$creationId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13302(this.$appName, this.$creationId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterfaceC2108a interfaceC2108a;
            String str;
            long j5;
            List list;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    interfaceC2108a = ApexSearchIndexManager.mutex;
                    String str2 = this.$appName;
                    long j6 = this.$creationId;
                    this.L$0 = interfaceC2108a;
                    this.L$1 = str2;
                    this.J$0 = j6;
                    this.label = 1;
                    if (interfaceC2108a.lock(null, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    str = str2;
                    j5 = j6;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j5 = this.J$0;
                    str = (String) this.L$1;
                    interfaceC2108a = (InterfaceC2108a) this.L$0;
                    kotlin.b.b(obj);
                }
                try {
                    Map map = (Map) ApexSearchIndexManager.commentIndexCache.get(str);
                    List listF1 = (map == null || (list = (List) map.get(new Long(j5))) == null) ? null : v.f1(list);
                    if (listF1 == null) {
                        listF1 = EmptyList.f4893a;
                    }
                    SearchIndex searchIndex = new SearchIndex(0, this.$appName, EntityType.COMMENT, listF1, 0L, 17, (kotlin.jvm.internal.e) null);
                    File file = ApexSearchIndexManager.INSTANCE.getCommentIndexFile(this.$appName, this.$creationId).toFile();
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    AbstractC0200b abstractC0200b = ApexSearchIndexManager.json;
                    abstractC0200b.getClass();
                    i.Y(file, abstractC0200b.b(SearchIndex.INSTANCE.serializer(), searchIndex));
                    return new FileResult.Success(r.f317a);
                } finally {
                    interfaceC2108a.unlock(null);
                }
            } catch (Exception e) {
                return new FileResult.Error(new FileException.WriteError(ApexSearchIndexManager.INSTANCE.getCommentIndexFile(this.$appName, this.$creationId), e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C13302) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager$saveCreationIndex$2", f = "ApexSearchIndexManager.kt", l = {752}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$saveCreationIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13312 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13312(String str, H7.c<? super C13312> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13312(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterfaceC2108a interfaceC2108a;
            String str;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    interfaceC2108a = ApexSearchIndexManager.mutex;
                    String str2 = this.$appName;
                    this.L$0 = interfaceC2108a;
                    this.L$1 = str2;
                    this.label = 1;
                    if (interfaceC2108a.lock(null, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    str = str2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$1;
                    interfaceC2108a = (InterfaceC2108a) this.L$0;
                    kotlin.b.b(obj);
                }
                try {
                    List list = (List) ApexSearchIndexManager.creationIndexCache.get(str);
                    List listF1 = list != null ? v.f1(list) : null;
                    if (listF1 == null) {
                        listF1 = EmptyList.f4893a;
                    }
                    SearchIndex searchIndex = new SearchIndex(0, this.$appName, EntityType.CREATION, listF1, 0L, 17, (kotlin.jvm.internal.e) null);
                    File file = ApexSearchIndexManager.INSTANCE.getCreationIndexFile(this.$appName).toFile();
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    AbstractC0200b abstractC0200b = ApexSearchIndexManager.json;
                    abstractC0200b.getClass();
                    i.Y(file, abstractC0200b.b(SearchIndex.INSTANCE.serializer(), searchIndex));
                    return new FileResult.Success(r.f317a);
                } finally {
                    interfaceC2108a.unlock(null);
                }
            } catch (Exception e) {
                return new FileResult.Error(new FileException.WriteError(ApexSearchIndexManager.INSTANCE.getCreationIndexFile(this.$appName), e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C13312) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager", f = "ApexSearchIndexManager.kt", l = {752, 599, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO}, m = "saveDirtyIndexes")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$saveDirtyIndexes$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13321 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13321(H7.c<? super C13321> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexSearchIndexManager.this.saveDirtyIndexes(null, this);
        }
    }

    @c(c = "com.uxsense.search.ApexSearchIndexManager$saveUserIndex$2", f = "ApexSearchIndexManager.kt", l = {752}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.ApexSearchIndexManager$saveUserIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13332 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13332(String str, H7.c<? super C13332> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13332(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterfaceC2108a interfaceC2108a;
            String str;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    interfaceC2108a = ApexSearchIndexManager.mutex;
                    String str2 = this.$appName;
                    this.L$0 = interfaceC2108a;
                    this.L$1 = str2;
                    this.label = 1;
                    if (interfaceC2108a.lock(null, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    str = str2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$1;
                    interfaceC2108a = (InterfaceC2108a) this.L$0;
                    kotlin.b.b(obj);
                }
                try {
                    List list = (List) ApexSearchIndexManager.userIndexCache.get(str);
                    List listF1 = list != null ? v.f1(list) : null;
                    if (listF1 == null) {
                        listF1 = EmptyList.f4893a;
                    }
                    SearchIndex searchIndex = new SearchIndex(0, this.$appName, EntityType.USER, listF1, 0L, 17, (kotlin.jvm.internal.e) null);
                    File file = ApexSearchIndexManager.INSTANCE.getUserIndexFile(this.$appName).toFile();
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    AbstractC0200b abstractC0200b = ApexSearchIndexManager.json;
                    abstractC0200b.getClass();
                    i.Y(file, abstractC0200b.b(SearchIndex.INSTANCE.serializer(), searchIndex));
                    return new FileResult.Success(r.f317a);
                } finally {
                    interfaceC2108a.unlock(null);
                }
            } catch (Exception e) {
                return new FileResult.Error(new FileException.WriteError(ApexSearchIndexManager.INSTANCE.getUserIndexFile(this.$appName), e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C13332) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private ApexSearchIndexManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkAndAutoSave(java.lang.String r13, H7.c<? super C7.r> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.uxsense.search.ApexSearchIndexManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.uxsense.search.ApexSearchIndexManager$checkAndAutoSave$1 r0 = (com.uxsense.search.ApexSearchIndexManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$checkAndAutoSave$1 r0 = new com.uxsense.search.ApexSearchIndexManager$checkAndAutoSave$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            C7.r r3 = C7.r.f317a
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L44
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            kotlin.b.b(r14)
            goto La2
        L2e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L36:
            java.lang.Object r13 = r0.L$1
            w9.a r13 = (w9.InterfaceC2108a) r13
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.b.b(r14)
            r14 = r13
            r13 = r2
            goto L56
        L44:
            kotlin.b.b(r14)
            w9.a r14 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r5
            java.lang.Object r2 = r14.lock(r6, r0)
            if (r2 != r1) goto L56
            goto La1
        L56:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.uxsense.search.ApexSearchIndexManager.updateCounters     // Catch: java.lang.Throwable -> L65
            java.lang.Object r7 = r2.get(r13)     // Catch: java.lang.Throwable -> L65
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: java.lang.Throwable -> L65
            if (r7 == 0) goto L67
            int r7 = r7.intValue()     // Catch: java.lang.Throwable -> L65
            goto L68
        L65:
            r12 = move-exception
            goto La3
        L67:
            r7 = 0
        L68:
            int r7 = r7 + r5
            java.lang.Integer r5 = new java.lang.Integer     // Catch: java.lang.Throwable -> L65
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L65
            r2.put(r13, r5)     // Catch: java.lang.Throwable -> L65
            r14.unlock(r6)
            long r8 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.String, java.lang.Long> r14 = com.uxsense.search.ApexSearchIndexManager.lastSaveTime
            java.lang.Object r14 = r14.get(r13)
            java.lang.Long r14 = (java.lang.Long) r14
            if (r14 == 0) goto L87
            long r10 = r14.longValue()
            goto L89
        L87:
            r10 = 0
        L89:
            r14 = 10
            if (r7 < r14) goto La2
            long r8 = r8 - r10
            r10 = 60000(0xea60, double:2.9644E-319)
            int r14 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r14 < 0) goto La2
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r12 = r12.saveDirtyIndexes(r13, r0)
            if (r12 != r1) goto La2
        La1:
            return r1
        La2:
            return r3
        La3:
            r14.unlock(r6)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.checkAndAutoSave(java.lang.String, H7.c):java.lang.Object");
    }

    public static /* synthetic */ Object findExistingCreation$default(ApexSearchIndexManager apexSearchIndexManager, String str, String str2, String str3, MatchMode matchMode, float f, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        String str4 = str3;
        if ((i & 8) != 0) {
            matchMode = MatchMode.FUZZY;
        }
        MatchMode matchMode2 = matchMode;
        if ((i & 16) != 0) {
            f = 0.9f;
        }
        return apexSearchIndexManager.findExistingCreation(str, str2, str4, matchMode2, f, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r json$lambda$0(g Json) {
        k.f(Json, "$this$Json");
        Json.c = true;
        Json.e = false;
        Json.f325a = true;
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadCommentIndex(String str, long j5, H7.c<? super List<SearchableEntity>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(str, j5, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadCreationIndex(String str, H7.c<? super List<SearchableEntity>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13242(str, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadUserIndex(String str, H7.c<? super List<SearchableEntity>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13252(str, null), cVar);
    }

    public static /* synthetic */ Object rebuildIndex$default(ApexSearchIndexManager apexSearchIndexManager, String str, boolean z10, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        return apexSearchIndexManager.rebuildIndex(str, z10, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCreationIndex$lambda$10$lambda$8(long j5, SearchableEntity it) {
        k.f(it, "it");
        return it.getEntityId() == j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCreationIndex$lambda$10$lambda$9(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearAllCache(H7.c<? super C7.r> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.uxsense.search.ApexSearchIndexManager.C13071
            if (r0 == 0) goto L13
            r0 = r5
            com.uxsense.search.ApexSearchIndexManager$clearAllCache$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13071) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$clearAllCache$1 r0 = new com.uxsense.search.ApexSearchIndexManager$clearAllCache$1
            r0.<init>(r5)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            java.lang.Object r5 = r0.L$0
            w9.a r5 = (w9.InterfaceC2108a) r5
            kotlin.b.b(r4)
            goto L45
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.b.b(r4)
            w9.a r4 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r0 = r4.lock(r3, r0)
            if (r0 != r5) goto L44
            return r5
        L44:
            r5 = r4
        L45:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r4 = com.uxsense.search.ApexSearchIndexManager.creationIndexCache     // Catch: java.lang.Throwable -> L5a
            r4.clear()     // Catch: java.lang.Throwable -> L5a
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r4 = com.uxsense.search.ApexSearchIndexManager.userIndexCache     // Catch: java.lang.Throwable -> L5a
            r4.clear()     // Catch: java.lang.Throwable -> L5a
            java.util.Map<java.lang.String, java.util.Map<java.lang.Long, java.util.List<com.uxsense.search.SearchableEntity>>> r4 = com.uxsense.search.ApexSearchIndexManager.commentIndexCache     // Catch: java.lang.Throwable -> L5a
            r4.clear()     // Catch: java.lang.Throwable -> L5a
            C7.r r4 = C7.r.f317a     // Catch: java.lang.Throwable -> L5a
            r5.unlock(r3)
            return r4
        L5a:
            r4 = move-exception
            r5.unlock(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.clearAllCache(H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearCache(java.lang.String r5, H7.c<? super java.util.Map<java.lang.Long, java.util.List<com.uxsense.search.SearchableEntity>>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.search.ApexSearchIndexManager.C13081
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.search.ApexSearchIndexManager$clearCache$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$clearCache$1 r0 = new com.uxsense.search.ApexSearchIndexManager$clearCache$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r5 = r0.L$1
            w9.a r5 = (w9.InterfaceC2108a) r5
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r4)
            r4 = r5
            r5 = r6
            goto L4c
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.b.b(r4)
            w9.a r4 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r2
            java.lang.Object r0 = r4.lock(r3, r0)
            if (r0 != r6) goto L4c
            return r6
        L4c:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r6 = com.uxsense.search.ApexSearchIndexManager.creationIndexCache     // Catch: java.lang.Throwable -> L62
            r6.remove(r5)     // Catch: java.lang.Throwable -> L62
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r6 = com.uxsense.search.ApexSearchIndexManager.userIndexCache     // Catch: java.lang.Throwable -> L62
            r6.remove(r5)     // Catch: java.lang.Throwable -> L62
            java.util.Map<java.lang.String, java.util.Map<java.lang.Long, java.util.List<com.uxsense.search.SearchableEntity>>> r6 = com.uxsense.search.ApexSearchIndexManager.commentIndexCache     // Catch: java.lang.Throwable -> L62
            java.lang.Object r5 = r6.remove(r5)     // Catch: java.lang.Throwable -> L62
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Throwable -> L62
            r4.unlock(r3)
            return r5
        L62:
            r5 = move-exception
            r4.unlock(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.clearCache(java.lang.String, H7.c):java.lang.Object");
    }

    public final SearchableEntity createSearchableEntity(Creation creation) {
        k.f(creation, "creation");
        String str = creation.getTitle() + " " + creation.getAuthorNickname() + " " + m.N0(100, creation.getContent());
        FuzzyMatcher fuzzyMatcher = FuzzyMatcher.INSTANCE;
        return new SearchableEntity(EntityType.CREATION, creation.getCreationId(), creation.getUserId(), str, v.a1(v.v0(v.Q0(fuzzyMatcher.extractKeywords(creation.getContent()), fuzzyMatcher.extractKeywords(str))), 100), System.currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findExistingCreation(java.lang.String r6, java.lang.String r7, java.lang.String r8, com.uxsense.search.MatchMode r9, float r10, H7.c<? super java.lang.Long> r11) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r11 instanceof com.uxsense.search.ApexSearchIndexManager.C13091
            if (r0 == 0) goto L13
            r0 = r11
            com.uxsense.search.ApexSearchIndexManager$findExistingCreation$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$findExistingCreation$1 r0 = new com.uxsense.search.ApexSearchIndexManager$findExistingCreation$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            float r10 = r0.F$0
            java.lang.Object r5 = r0.L$2
            r9 = r5
            com.uxsense.search.MatchMode r9 = (com.uxsense.search.MatchMode) r9
            java.lang.Object r5 = r0.L$1
            r8 = r5
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r5 = r0.L$0
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7
            kotlin.b.b(r11)
            goto L5c
        L39:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L41:
            kotlin.b.b(r11)
            boolean r11 = j9.m.s0(r7)
            if (r11 == 0) goto L4b
            return r4
        L4b:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.F$0 = r10
            r0.label = r3
            java.lang.Object r11 = r5.getCreationIndex(r6, r0)
            if (r11 != r1) goto L5c
            return r1
        L5c:
            java.util.List r11 = (java.util.List) r11
            boolean r5 = r11.isEmpty()
            if (r5 == 0) goto L65
            return r4
        L65:
            if (r8 == 0) goto L82
            boolean r5 = j9.m.s0(r8)
            if (r5 == 0) goto L6e
            goto L82
        L6e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            r6 = 32
            r5.append(r6)
            r5.append(r8)
            java.lang.String r7 = r5.toString()
        L82:
            java.util.Iterator r5 = r11.iterator()
            r6 = 0
            r8 = r4
        L88:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto La9
            java.lang.Object r11 = r5.next()
            com.uxsense.search.SearchableEntity r11 = (com.uxsense.search.SearchableEntity) r11
            com.uxsense.search.FuzzyMatcher r0 = com.uxsense.search.FuzzyMatcher.INSTANCE
            java.lang.String r1 = r11.getSearchableText()
            float r0 = r0.calculateScore(r7, r1, r9)
            int r1 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r1 < 0) goto L88
            int r1 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r1 <= 0) goto L88
            r8 = r11
            r6 = r0
            goto L88
        La9:
            if (r8 == 0) goto Lb5
            long r5 = r8.getEntityId()
            java.lang.Long r7 = new java.lang.Long
            r7.<init>(r5)
            return r7
        Lb5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.findExistingCreation(java.lang.String, java.lang.String, java.lang.String, com.uxsense.search.MatchMode, float, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (r2.lock(null, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object flushAllDirtyIndexes(H7.c<? super C7.r> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uxsense.search.ApexSearchIndexManager.C13101
            if (r0 == 0) goto L13
            r0 = r7
            com.uxsense.search.ApexSearchIndexManager$flushAllDirtyIndexes$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$flushAllDirtyIndexes$1 r0 = new com.uxsense.search.ApexSearchIndexManager$flushAllDirtyIndexes$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r2 = r0.L$0
            java.util.Iterator r2 = (java.util.Iterator) r2
            kotlin.b.b(r7)
            goto L71
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            java.lang.Object r2 = r0.L$0
            w9.a r2 = (w9.InterfaceC2108a) r2
            kotlin.b.b(r7)
            goto L4f
        L3f:
            kotlin.b.b(r7)
            w9.a r2 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r2.lock(r5, r0)
            if (r7 != r1) goto L4f
            goto L87
        L4f:
            java.util.Set<java.lang.String> r7 = com.uxsense.search.ApexSearchIndexManager.dirtyCreationIndex     // Catch: java.lang.Throwable -> L8b
            java.util.Set<java.lang.String> r4 = com.uxsense.search.ApexSearchIndexManager.dirtyUserIndex     // Catch: java.lang.Throwable -> L8b
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L8b
            java.util.LinkedHashSet r7 = D7.N.L(r7, r4)     // Catch: java.lang.Throwable -> L8b
            java.util.Map<java.lang.String, java.util.Set<java.lang.Long>> r4 = com.uxsense.search.ApexSearchIndexManager.dirtyCommentIndex     // Catch: java.lang.Throwable -> L8b
            java.util.Set r4 = r4.keySet()     // Catch: java.lang.Throwable -> L8b
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L8b
            java.util.LinkedHashSet r7 = D7.N.L(r7, r4)     // Catch: java.lang.Throwable -> L8b
            java.util.Set r7 = D7.v.j1(r7)     // Catch: java.lang.Throwable -> L8b
            r2.unlock(r5)
            java.util.Iterator r7 = r7.iterator()
            r2 = r7
        L71:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L88
            java.lang.Object r7 = r2.next()
            java.lang.String r7 = (java.lang.String) r7
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r6.saveDirtyIndexes(r7, r0)
            if (r7 != r1) goto L71
        L87:
            return r1
        L88:
            C7.r r6 = C7.r.f317a
            return r6
        L8b:
            r6 = move-exception
            r2.unlock(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.flushAllDirtyIndexes(H7.c):java.lang.Object");
    }

    public final Object flushDirtyIndexes(String str, H7.c<? super r> cVar) {
        Object objSaveDirtyIndexes = saveDirtyIndexes(str, cVar);
        return objSaveDirtyIndexes == CoroutineSingletons.f4909a ? objSaveDirtyIndexes : r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAllCommentIndex(java.lang.String r5, H7.c<? super java.util.List<com.uxsense.search.SearchableEntity>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.search.ApexSearchIndexManager.C13111
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.search.ApexSearchIndexManager$getAllCommentIndex$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$getAllCommentIndex$1 r0 = new com.uxsense.search.ApexSearchIndexManager$getAllCommentIndex$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r5 = r0.L$1
            w9.a r5 = (w9.InterfaceC2108a) r5
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r4)
            r4 = r5
            r5 = r6
            goto L4c
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.b.b(r4)
            w9.a r4 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r2
            java.lang.Object r0 = r4.lock(r3, r0)
            if (r0 != r6) goto L4c
            return r6
        L4c:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L79
            r6.<init>()     // Catch: java.lang.Throwable -> L79
            java.util.Map<java.lang.String, java.util.Map<java.lang.Long, java.util.List<com.uxsense.search.SearchableEntity>>> r0 = com.uxsense.search.ApexSearchIndexManager.commentIndexCache     // Catch: java.lang.Throwable -> L79
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Throwable -> L79
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L7b
            java.util.Collection r5 = r5.values()     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L7b
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L79
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L79
        L67:
            boolean r0 = r5.hasNext()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r5.next()     // Catch: java.lang.Throwable -> L79
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L79
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L79
            r6.addAll(r0)     // Catch: java.lang.Throwable -> L79
            goto L67
        L79:
            r5 = move-exception
            goto L7f
        L7b:
            r4.unlock(r3)
            return r6
        L7f:
            r4.unlock(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.getAllCommentIndex(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a9 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0031, B:36:0x009e, B:38:0x00a9, B:39:0x00b1), top: B:47:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getCommentIndex(java.lang.String r6, long r7, H7.c<? super java.util.List<com.uxsense.search.SearchableEntity>> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.getCommentIndex(java.lang.String, long, H7.c):java.lang.Object");
    }

    public final Path getCommentIndexFile(String appName, long creationId) {
        k.f(appName, "appName");
        Path pathResolve = getSearchIndexDir(appName).resolve("comments_" + creationId + ".json");
        k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getCreationIndex(java.lang.String r7, H7.c<? super java.util.List<com.uxsense.search.SearchableEntity>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.uxsense.search.ApexSearchIndexManager.C13131
            if (r0 == 0) goto L13
            r0 = r8
            com.uxsense.search.ApexSearchIndexManager$getCreationIndex$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$getCreationIndex$1 r0 = new com.uxsense.search.ApexSearchIndexManager$getCreationIndex$1
            r0.<init>(r8)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L4c
            if (r1 == r3) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r7 = r0.L$1
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.b.b(r6)     // Catch: java.lang.Throwable -> L33
            goto L88
        L33:
            r6 = move-exception
            goto L9e
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            java.lang.Object r7 = r0.L$1
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r1 = r0.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.b.b(r6)
            r6 = r7
            r7 = r1
            goto L5e
        L4c:
            kotlin.b.b(r6)
            w9.a r6 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r1 = r6.lock(r4, r0)
            if (r1 != r8) goto L5e
            goto L84
        L5e:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r1 = com.uxsense.search.ApexSearchIndexManager.creationIndexCache     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r1.get(r7)     // Catch: java.lang.Throwable -> L71
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L71
            if (r1 == 0) goto L76
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L71
            java.util.List r1 = D7.v.f1(r1)     // Catch: java.lang.Throwable -> L71
            if (r1 != 0) goto L9a
            goto L76
        L71:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L9e
        L76:
            com.uxsense.search.ApexSearchIndexManager r1 = com.uxsense.search.ApexSearchIndexManager.INSTANCE     // Catch: java.lang.Throwable -> L71
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L71
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L71
            r0.label = r2     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r1.loadCreationIndex(r7, r0)     // Catch: java.lang.Throwable -> L71
            if (r0 != r8) goto L85
        L84:
            return r8
        L85:
            r8 = r7
            r7 = r6
            r6 = r0
        L88:
            r0 = r6
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L33
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r1 = com.uxsense.search.ApexSearchIndexManager.creationIndexCache     // Catch: java.lang.Throwable -> L33
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L33
            java.util.ArrayList r0 = D7.v.g1(r0)     // Catch: java.lang.Throwable -> L33
            r1.put(r8, r0)     // Catch: java.lang.Throwable -> L33
            r1 = r6
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L33
            r6 = r7
        L9a:
            r6.unlock(r4)
            return r1
        L9e:
            r7.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.getCreationIndex(java.lang.String, H7.c):java.lang.Object");
    }

    public final Path getCreationIndexFile(String appName) {
        k.f(appName, "appName");
        Path pathResolve = getSearchIndexDir(appName).resolve("creations.json");
        k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getIndexStats(java.lang.String r11, H7.c<? super com.uxsense.search.ApexSearchIndexManager.IndexStats> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.uxsense.search.ApexSearchIndexManager.C13141
            if (r0 == 0) goto L13
            r0 = r12
            com.uxsense.search.ApexSearchIndexManager$getIndexStats$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13141) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$getIndexStats$1 r0 = new com.uxsense.search.ApexSearchIndexManager$getIndexStats$1
            r0.<init>(r12)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r12 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r11 = r0.L$1
            w9.a r11 = (w9.InterfaceC2108a) r11
            java.lang.Object r12 = r0.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.b.b(r10)
            r10 = r11
            r11 = r12
            goto L4c
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            kotlin.b.b(r10)
            w9.a r10 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r11
            r0.L$1 = r10
            r0.label = r2
            java.lang.Object r0 = r10.lock(r3, r0)
            if (r0 != r12) goto L4c
            return r12
        L4c:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r12 = com.uxsense.search.ApexSearchIndexManager.creationIndexCache     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r12 = r12.get(r11)     // Catch: java.lang.Throwable -> L5d
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L5d
            r0 = 0
            if (r12 == 0) goto L60
            int r12 = r12.size()     // Catch: java.lang.Throwable -> L5d
            r5 = r12
            goto L61
        L5d:
            r0 = move-exception
            r11 = r0
            goto La8
        L60:
            r5 = r0
        L61:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r12 = com.uxsense.search.ApexSearchIndexManager.userIndexCache     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r12 = r12.get(r11)     // Catch: java.lang.Throwable -> L5d
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L5d
            if (r12 == 0) goto L71
            int r12 = r12.size()     // Catch: java.lang.Throwable -> L5d
            r6 = r12
            goto L72
        L71:
            r6 = r0
        L72:
            java.util.Map<java.lang.String, java.util.Map<java.lang.Long, java.util.List<com.uxsense.search.SearchableEntity>>> r12 = com.uxsense.search.ApexSearchIndexManager.commentIndexCache     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r11 = r12.get(r11)     // Catch: java.lang.Throwable -> L5d
            java.util.Map r11 = (java.util.Map) r11     // Catch: java.lang.Throwable -> L5d
            if (r11 == 0) goto L9a
            java.util.Collection r11 = r11.values()     // Catch: java.lang.Throwable -> L5d
            if (r11 == 0) goto L9a
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch: java.lang.Throwable -> L5d
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> L5d
        L88:
            boolean r12 = r11.hasNext()     // Catch: java.lang.Throwable -> L5d
            if (r12 == 0) goto L9a
            java.lang.Object r12 = r11.next()     // Catch: java.lang.Throwable -> L5d
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L5d
            int r12 = r12.size()     // Catch: java.lang.Throwable -> L5d
            int r0 = r0 + r12
            goto L88
        L9a:
            r7 = r0
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5d
            com.uxsense.search.ApexSearchIndexManager$IndexStats r4 = new com.uxsense.search.ApexSearchIndexManager$IndexStats     // Catch: java.lang.Throwable -> L5d
            r4.<init>(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5d
            r10.unlock(r3)
            return r4
        La8:
            r10.unlock(r3)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.getIndexStats(java.lang.String, H7.c):java.lang.Object");
    }

    public final Path getSearchIndexDir(String appName) {
        k.f(appName, "appName");
        Path pathResolve = ApexMetadataFileManager.INSTANCE.getAppRootDir(appName).resolve("search_index");
        k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getUserIndex(java.lang.String r7, H7.c<? super java.util.List<com.uxsense.search.SearchableEntity>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.uxsense.search.ApexSearchIndexManager.C13151
            if (r0 == 0) goto L13
            r0 = r8
            com.uxsense.search.ApexSearchIndexManager$getUserIndex$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$getUserIndex$1 r0 = new com.uxsense.search.ApexSearchIndexManager$getUserIndex$1
            r0.<init>(r8)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L4c
            if (r1 == r3) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r7 = r0.L$1
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.b.b(r6)     // Catch: java.lang.Throwable -> L33
            goto L88
        L33:
            r6 = move-exception
            goto L9e
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            java.lang.Object r7 = r0.L$1
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r1 = r0.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.b.b(r6)
            r6 = r7
            r7 = r1
            goto L5e
        L4c:
            kotlin.b.b(r6)
            w9.a r6 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r1 = r6.lock(r4, r0)
            if (r1 != r8) goto L5e
            goto L84
        L5e:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r1 = com.uxsense.search.ApexSearchIndexManager.userIndexCache     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r1.get(r7)     // Catch: java.lang.Throwable -> L71
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L71
            if (r1 == 0) goto L76
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L71
            java.util.List r1 = D7.v.f1(r1)     // Catch: java.lang.Throwable -> L71
            if (r1 != 0) goto L9a
            goto L76
        L71:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L9e
        L76:
            com.uxsense.search.ApexSearchIndexManager r1 = com.uxsense.search.ApexSearchIndexManager.INSTANCE     // Catch: java.lang.Throwable -> L71
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L71
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L71
            r0.label = r2     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r1.loadUserIndex(r7, r0)     // Catch: java.lang.Throwable -> L71
            if (r0 != r8) goto L85
        L84:
            return r8
        L85:
            r8 = r7
            r7 = r6
            r6 = r0
        L88:
            r0 = r6
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L33
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r1 = com.uxsense.search.ApexSearchIndexManager.userIndexCache     // Catch: java.lang.Throwable -> L33
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L33
            java.util.ArrayList r0 = D7.v.g1(r0)     // Catch: java.lang.Throwable -> L33
            r1.put(r8, r0)     // Catch: java.lang.Throwable -> L33
            r1 = r6
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L33
            r6 = r7
        L9a:
            r6.unlock(r4)
            return r1
        L9e:
            r7.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.getUserIndex(java.lang.String, H7.c):java.lang.Object");
    }

    public final Path getUserIndexFile(String appName) {
        k.f(appName, "appName");
        Path pathResolve = getSearchIndexDir(appName).resolve("users.json");
        k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object hasDirtyIndexes(java.lang.String r5, H7.c<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.search.ApexSearchIndexManager.C13161
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.search.ApexSearchIndexManager$hasDirtyIndexes$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$hasDirtyIndexes$1 r0 = new com.uxsense.search.ApexSearchIndexManager$hasDirtyIndexes$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r5 = r0.L$1
            w9.a r5 = (w9.InterfaceC2108a) r5
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r4)
            r4 = r5
            r5 = r6
            goto L4c
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.b.b(r4)
            w9.a r4 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r2
            java.lang.Object r0 = r4.lock(r3, r0)
            if (r0 != r6) goto L4c
            return r6
        L4c:
            java.util.Set<java.lang.String> r6 = com.uxsense.search.ApexSearchIndexManager.dirtyCreationIndex     // Catch: java.lang.Throwable -> L70
            boolean r6 = r6.contains(r5)     // Catch: java.lang.Throwable -> L70
            if (r6 != 0) goto L73
            java.util.Set<java.lang.String> r6 = com.uxsense.search.ApexSearchIndexManager.dirtyUserIndex     // Catch: java.lang.Throwable -> L70
            boolean r6 = r6.contains(r5)     // Catch: java.lang.Throwable -> L70
            if (r6 != 0) goto L73
            java.util.Map<java.lang.String, java.util.Set<java.lang.Long>> r6 = com.uxsense.search.ApexSearchIndexManager.dirtyCommentIndex     // Catch: java.lang.Throwable -> L70
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> L70
            java.util.Set r5 = (java.util.Set) r5     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto L72
            java.util.Collection r5 = (java.util.Collection) r5     // Catch: java.lang.Throwable -> L70
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> L70
            r5 = r5 ^ r2
            if (r5 != r2) goto L72
            goto L73
        L70:
            r5 = move-exception
            goto L7b
        L72:
            r2 = 0
        L73:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L70
            r4.unlock(r3)
            return r5
        L7b:
            r4.unlock(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.hasDirtyIndexes(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e8, code lost:
    
        if (checkAndAutoSave(r12, r0) == r1) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object indexComment(java.lang.String r12, com.uxsense.base.metadata.Comment r13, H7.c<? super C7.r> r14) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.indexComment(java.lang.String, com.uxsense.base.metadata.Comment, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0126, code lost:
    
        if (checkAndAutoSave(r10, r2) == r3) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object indexComments(java.lang.String r17, long r18, java.util.List<com.uxsense.base.metadata.Comment> r20, H7.c<? super C7.r> r21) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.indexComments(java.lang.String, long, java.util.List, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
    
        if (checkAndAutoSave(r12, r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object indexCreation(java.lang.String r12, com.uxsense.base.metadata.Creation r13, H7.c<? super C7.r> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.uxsense.search.ApexSearchIndexManager.C13191
            if (r0 == 0) goto L13
            r0 = r14
            com.uxsense.search.ApexSearchIndexManager$indexCreation$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13191) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$indexCreation$1 r0 = new com.uxsense.search.ApexSearchIndexManager$indexCreation$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L46
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.b.b(r14)
            goto Lb7
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L34:
            java.lang.Object r12 = r0.L$2
            w9.a r12 = (w9.InterfaceC2108a) r12
            java.lang.Object r13 = r0.L$1
            com.uxsense.base.metadata.Creation r13 = (com.uxsense.base.metadata.Creation) r13
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.b.b(r14)
            r14 = r12
            r12 = r2
            goto L5a
        L46:
            kotlin.b.b(r14)
            w9.a r14 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.label = r4
            java.lang.Object r2 = r14.lock(r5, r0)
            if (r2 != r1) goto L5a
            goto Lb6
        L5a:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r2 = com.uxsense.search.ApexSearchIndexManager.creationIndexCache     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r4 = r2.get(r12)     // Catch: java.lang.Throwable -> L6b
            if (r4 != 0) goto L6d
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L6b
            r4.<init>()     // Catch: java.lang.Throwable -> L6b
            r2.put(r12, r4)     // Catch: java.lang.Throwable -> L6b
            goto L6d
        L6b:
            r11 = move-exception
            goto Lba
        L6d:
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L6b
            java.util.Iterator r2 = r4.iterator()     // Catch: java.lang.Throwable -> L6b
            r6 = 0
        L74:
            boolean r7 = r2.hasNext()     // Catch: java.lang.Throwable -> L6b
            if (r7 == 0) goto L90
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L6b
            com.uxsense.search.SearchableEntity r7 = (com.uxsense.search.SearchableEntity) r7     // Catch: java.lang.Throwable -> L6b
            long r7 = r7.getEntityId()     // Catch: java.lang.Throwable -> L6b
            long r9 = r13.getCreationId()     // Catch: java.lang.Throwable -> L6b
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L8d
            goto L91
        L8d:
            int r6 = r6 + 1
            goto L74
        L90:
            r6 = -1
        L91:
            com.uxsense.search.ApexSearchIndexManager r2 = com.uxsense.search.ApexSearchIndexManager.INSTANCE     // Catch: java.lang.Throwable -> L6b
            com.uxsense.search.SearchableEntity r13 = r2.createSearchableEntity(r13)     // Catch: java.lang.Throwable -> L6b
            if (r6 < 0) goto L9d
            r4.set(r6, r13)     // Catch: java.lang.Throwable -> L6b
            goto La0
        L9d:
            r4.add(r13)     // Catch: java.lang.Throwable -> L6b
        La0:
            java.util.Set<java.lang.String> r13 = com.uxsense.search.ApexSearchIndexManager.dirtyCreationIndex     // Catch: java.lang.Throwable -> L6b
            r13.add(r12)     // Catch: java.lang.Throwable -> L6b
            r14.unlock(r5)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r11 = r11.checkAndAutoSave(r12, r0)
            if (r11 != r1) goto Lb7
        Lb6:
            return r1
        Lb7:
            C7.r r11 = C7.r.f317a
            return r11
        Lba:
            r14.unlock(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.indexCreation(java.lang.String, com.uxsense.base.metadata.Creation, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00eb, code lost:
    
        if (checkAndAutoSave(r12, r0) == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object indexCreations(java.lang.String r12, java.util.List<com.uxsense.base.metadata.Creation> r13, H7.c<? super C7.r> r14) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.indexCreations(java.lang.String, java.util.List, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
    
        if (checkAndAutoSave(r12, r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object indexUser(java.lang.String r12, com.uxsense.base.metadata.User r13, H7.c<? super C7.r> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.uxsense.search.ApexSearchIndexManager.C13211
            if (r0 == 0) goto L13
            r0 = r14
            com.uxsense.search.ApexSearchIndexManager$indexUser$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$indexUser$1 r0 = new com.uxsense.search.ApexSearchIndexManager$indexUser$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L46
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.b.b(r14)
            goto Lb7
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L34:
            java.lang.Object r12 = r0.L$2
            w9.a r12 = (w9.InterfaceC2108a) r12
            java.lang.Object r13 = r0.L$1
            com.uxsense.base.metadata.User r13 = (com.uxsense.base.metadata.User) r13
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.b.b(r14)
            r14 = r12
            r12 = r2
            goto L5a
        L46:
            kotlin.b.b(r14)
            w9.a r14 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.label = r4
            java.lang.Object r2 = r14.lock(r5, r0)
            if (r2 != r1) goto L5a
            goto Lb6
        L5a:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r2 = com.uxsense.search.ApexSearchIndexManager.userIndexCache     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r4 = r2.get(r12)     // Catch: java.lang.Throwable -> L6b
            if (r4 != 0) goto L6d
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L6b
            r4.<init>()     // Catch: java.lang.Throwable -> L6b
            r2.put(r12, r4)     // Catch: java.lang.Throwable -> L6b
            goto L6d
        L6b:
            r11 = move-exception
            goto Lba
        L6d:
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L6b
            java.util.Iterator r2 = r4.iterator()     // Catch: java.lang.Throwable -> L6b
            r6 = 0
        L74:
            boolean r7 = r2.hasNext()     // Catch: java.lang.Throwable -> L6b
            if (r7 == 0) goto L90
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L6b
            com.uxsense.search.SearchableEntity r7 = (com.uxsense.search.SearchableEntity) r7     // Catch: java.lang.Throwable -> L6b
            long r7 = r7.getEntityId()     // Catch: java.lang.Throwable -> L6b
            long r9 = r13.getUserId()     // Catch: java.lang.Throwable -> L6b
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L8d
            goto L91
        L8d:
            int r6 = r6 + 1
            goto L74
        L90:
            r6 = -1
        L91:
            com.uxsense.search.ApexSearchIndexManager r2 = com.uxsense.search.ApexSearchIndexManager.INSTANCE     // Catch: java.lang.Throwable -> L6b
            com.uxsense.search.SearchableEntity r13 = r2.createSearchableEntity(r13)     // Catch: java.lang.Throwable -> L6b
            if (r6 < 0) goto L9d
            r4.set(r6, r13)     // Catch: java.lang.Throwable -> L6b
            goto La0
        L9d:
            r4.add(r13)     // Catch: java.lang.Throwable -> L6b
        La0:
            java.util.Set<java.lang.String> r13 = com.uxsense.search.ApexSearchIndexManager.dirtyUserIndex     // Catch: java.lang.Throwable -> L6b
            r13.add(r12)     // Catch: java.lang.Throwable -> L6b
            r14.unlock(r5)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r11 = r11.checkAndAutoSave(r12, r0)
            if (r11 != r1) goto Lb7
        Lb6:
            return r1
        Lb7:
            C7.r r11 = C7.r.f317a
            return r11
        Lba:
            r14.unlock(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.indexUser(java.lang.String, com.uxsense.base.metadata.User, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00eb, code lost:
    
        if (checkAndAutoSave(r12, r0) == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object indexUsers(java.lang.String r12, java.util.List<com.uxsense.base.metadata.User> r13, H7.c<? super C7.r> r14) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.indexUsers(java.lang.String, java.util.List, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initializeIfNeeded(java.lang.String r10, H7.c<? super C7.r> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.uxsense.search.ApexSearchIndexManager.C13231
            if (r0 == 0) goto L14
            r0 = r11
            com.uxsense.search.ApexSearchIndexManager$initializeIfNeeded$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.uxsense.search.ApexSearchIndexManager$initializeIfNeeded$1 r0 = new com.uxsense.search.ApexSearchIndexManager$initializeIfNeeded$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r4.label
            C7.r r7 = C7.r.f317a
            r2 = 0
            r3 = 4
            r5 = 3
            r6 = 2
            r8 = 1
            if (r1 == 0) goto L52
            if (r1 == r8) goto L4a
            if (r1 == r6) goto L46
            if (r1 == r5) goto L3d
            if (r1 != r3) goto L35
            kotlin.b.b(r11)
            goto L90
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            java.lang.Object r10 = r4.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.b.b(r11)
            r1 = r9
            goto L85
        L46:
            kotlin.b.b(r11)
            goto L78
        L4a:
            java.lang.Object r10 = r4.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.b.b(r11)
            goto L60
        L52:
            kotlin.b.b(r11)
            r4.L$0 = r10
            r4.label = r8
            java.lang.Object r11 = r9.needsRebuild(r10, r4)
            if (r11 != r0) goto L60
            goto L8f
        L60:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L79
            r4.L$0 = r2
            r4.label = r6
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            r2 = r10
            java.lang.Object r9 = rebuildIndex$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L78
            goto L8f
        L78:
            return r7
        L79:
            r1 = r9
            r4.L$0 = r10
            r4.label = r5
            java.lang.Object r9 = r1.getCreationIndex(r10, r4)
            if (r9 != r0) goto L85
            goto L8f
        L85:
            r4.L$0 = r2
            r4.label = r3
            java.lang.Object r9 = r1.getUserIndex(r10, r4)
            if (r9 != r0) goto L90
        L8f:
            return r0
        L90:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.initializeIfNeeded(java.lang.String, H7.c):java.lang.Object");
    }

    public final Object needsRebuild(String str, H7.c<? super Boolean> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13262(str, null), cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x011c, code lost:
    
        if (saveAllIndex(r8, r9) == r0) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d4 A[Catch: all -> 0x00dd, TryCatch #1 {all -> 0x00dd, blocks: (B:33:0x00cc, B:35:0x00d4, B:38:0x00df, B:39:0x00ed, B:41:0x00f3), top: B:60:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f3 A[Catch: all -> 0x00dd, LOOP:0: B:39:0x00ed->B:41:0x00f3, LOOP_END, TRY_LEAVE, TryCatch #1 {all -> 0x00dd, blocks: (B:33:0x00cc, B:35:0x00d4, B:38:0x00df, B:39:0x00ed, B:41:0x00f3), top: B:60:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object rebuildIndex(java.lang.String r8, boolean r9, H7.c<? super C7.r> r10) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.rebuildIndex(java.lang.String, boolean, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object removeCreationIndex(java.lang.String r5, long r6, H7.c<? super java.lang.Boolean> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.uxsense.search.ApexSearchIndexManager.C13281
            if (r0 == 0) goto L13
            r0 = r8
            com.uxsense.search.ApexSearchIndexManager$removeCreationIndex$1 r0 = (com.uxsense.search.ApexSearchIndexManager.C13281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.search.ApexSearchIndexManager$removeCreationIndex$1 r0 = new com.uxsense.search.ApexSearchIndexManager$removeCreationIndex$1
            r0.<init>(r8)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3c
            if (r1 != r2) goto L34
            long r6 = r0.J$0
            java.lang.Object r5 = r0.L$1
            w9.a r5 = (w9.InterfaceC2108a) r5
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.b.b(r4)
            r4 = r5
            r5 = r8
            goto L50
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.b.b(r4)
            w9.a r4 = com.uxsense.search.ApexSearchIndexManager.mutex
            r0.L$0 = r5
            r0.L$1 = r4
            r0.J$0 = r6
            r0.label = r2
            java.lang.Object r0 = r4.lock(r3, r0)
            if (r0 != r8) goto L50
            return r8
        L50:
            java.util.Map<java.lang.String, java.util.List<com.uxsense.search.SearchableEntity>> r8 = com.uxsense.search.ApexSearchIndexManager.creationIndexCache     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r5 = r8.get(r5)     // Catch: java.lang.Throwable -> L6f
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Throwable -> L6f
            if (r5 == 0) goto L71
            R3.f r8 = new R3.f     // Catch: java.lang.Throwable -> L6f
            r0 = 3
            r8.<init>(r6, r0)     // Catch: java.lang.Throwable -> L6f
            androidx.window.embedding.b r6 = new androidx.window.embedding.b     // Catch: java.lang.Throwable -> L6f
            r7 = 3
            r6.<init>(r8, r7)     // Catch: java.lang.Throwable -> L6f
            boolean r5 = r5.removeIf(r6)     // Catch: java.lang.Throwable -> L6f
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L6f
            goto L72
        L6f:
            r5 = move-exception
            goto L76
        L71:
            r5 = r3
        L72:
            r4.unlock(r3)
            return r5
        L76:
            r4.unlock(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.removeCreationIndex(java.lang.String, long, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        if (r8.lock(null, r0) != r1) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object saveAllIndex(java.lang.String r9, H7.c<? super C7.r> r10) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.saveAllIndex(java.lang.String, H7.c):java.lang.Object");
    }

    public final Object saveCommentIndex(String str, long j5, H7.c<? super FileResult<r>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13302(str, j5, null), cVar);
    }

    public final Object saveCreationIndex(String str, H7.c<? super FileResult<r>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13312(str, null), cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0106, code lost:
    
        if (saveUserIndex(r6, r2) == r3) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object saveDirtyIndexes(java.lang.String r16, H7.c<? super C7.r> r17) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.ApexSearchIndexManager.saveDirtyIndexes(java.lang.String, H7.c):java.lang.Object");
    }

    public final Object saveUserIndex(String str, H7.c<? super FileResult<r>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13332(str, null), cVar);
    }

    public final SearchableEntity createSearchableEntity(User user) {
        k.f(user, "user");
        String str = user.getNickname() + " " + user.getUuid() + " " + user.getBio();
        return new SearchableEntity(EntityType.USER, user.getUserId(), 0L, str, FuzzyMatcher.INSTANCE.extractKeywords(str), System.currentTimeMillis());
    }

    public final SearchableEntity createSearchableEntity(Comment comment) {
        k.f(comment, "comment");
        String str = comment.getNickname() + " " + comment.getContent();
        return new SearchableEntity(EntityType.COMMENT, comment.getCommentId(), comment.getCreationId(), str, FuzzyMatcher.INSTANCE.extractKeywords(str), System.currentTimeMillis());
    }
}
