package com.stepos.datacenter.fts.sqlite;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Wa.g;
import Wa.j;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u0002\u0014\u0016B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0012\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010)R\u0014\u00100\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010)¨\u00062"}, d2 = {"Lcom/stepos/datacenter/fts/sqlite/AsyncIndexQueue;", "", "Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine;", C3081a.KEY_ENGINE, "", "batchSize", "", "batchDelayMs", "<init>", "(Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine;IJ)V", "LY8/t;", "e", "()V", Const.INTENT_KEY_UMID, "(Le9/c;)Ljava/lang/Object;", "", "Lcom/stepos/datacenter/fts/sqlite/AsyncIndexQueue$b;", "batch", "c", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine;", Const.INTENT_KEY_PKGNAME, "I", "J", "LWa/g;", "LWa/g;", "taskChannel", "LUa/M;", "LUa/M;", "scope", "Lkotlinx/coroutines/g;", "f", "Lkotlinx/coroutines/g;", "processingJob", "Ljava/util/concurrent/atomic/AtomicBoolean;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunning", "Ljava/util/concurrent/atomic/AtomicLong;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/concurrent/atomic/AtomicLong;", "submittedCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "processedCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "failedCount", "k", "pendingCount", "Companion", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncIndexQueue {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SQLiteFtsEngine engine;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int batchSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long batchDelayMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final g<IndexTask> taskChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public M scope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g processingJob;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean isRunning;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong submittedCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong processedCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong failedCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong pendingCount;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\r\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/stepos/datacenter/fts/sqlite/AsyncIndexQueue$b;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "docId", "Ljava/lang/String;", "c", "tableName", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.fts.sqlite.AsyncIndexQueue$b, reason: from toString */
    public static final /* data */ class IndexTask {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final long docId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String tableName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String content;

        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: b, reason: from getter */
        public final long getDocId() {
            return this.docId;
        }

        /* renamed from: c, reason: from getter */
        public final String getTableName() {
            return this.tableName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IndexTask)) {
                return false;
            }
            IndexTask indexTask = (IndexTask) other;
            return this.docId == indexTask.docId && p.d(this.tableName, indexTask.tableName) && p.d(this.content, indexTask.content);
        }

        public int hashCode() {
            return (((Long.hashCode(this.docId) * 31) + this.tableName.hashCode()) * 31) + this.content.hashCode();
        }

        public String toString() {
            return "IndexTask(docId=" + this.docId + ", tableName=" + this.tableName + ", content=" + this.content + ")";
        }
    }

    public AsyncIndexQueue(SQLiteFtsEngine engine, int i10, long j10) {
        p.i(engine, "engine");
        this.engine = engine;
        this.batchSize = i10;
        this.batchDelayMs = j10;
        this.taskChannel = j.b(Integer.MAX_VALUE, null, null, 6, null);
        this.isRunning = new AtomicBoolean(false);
        this.submittedCount = new AtomicLong(0L);
        this.processedCount = new AtomicLong(0L);
        this.failedCount = new AtomicLong(0L);
        this.pendingCount = new AtomicLong(0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.util.List<com.stepos.datacenter.fts.sqlite.AsyncIndexQueue.IndexTask> r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.fts.sqlite.AsyncIndexQueue.c(java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d0, code lost:
    
        if (r9.c(r2, r0) == r1) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:13:0x002b, B:18:0x0044, B:41:0x00b6, B:25:0x006d, B:29:0x0080, B:31:0x0088, B:33:0x0099, B:37:0x00a5, B:42:0x00ba, B:44:0x00c3, B:21:0x0058, B:24:0x0067), top: B:51:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:13:0x002b, B:18:0x0044, B:41:0x00b6, B:25:0x006d, B:29:0x0080, B:31:0x0088, B:33:0x0099, B:37:0x00a5, B:42:0x00ba, B:44:0x00c3, B:21:0x0058, B:24:0x0067), top: B:51:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00a2 -> B:25:0x006d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b4 -> B:41:0x00b6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.fts.sqlite.AsyncIndexQueue.d(e9.c):java.lang.Object");
    }

    public final void e() {
        if (this.isRunning.getAndSet(true)) {
            Log.w("AsyncIndexQueue", "AsyncIndexQueue already running");
            return;
        }
        M mA = d.a(Y.b().plus(L0.b(null, 1, null)));
        this.scope = mA;
        this.processingJob = mA != null ? C1060i.d(mA, null, null, new AsyncIndexQueue$start$1(this, null), 3, null) : null;
        Log.d("AsyncIndexQueue", "AsyncIndexQueue started");
    }

    public /* synthetic */ AsyncIndexQueue(SQLiteFtsEngine sQLiteFtsEngine, int i10, long j10, int i11, i iVar) {
        this(sQLiteFtsEngine, (i11 & 2) != 0 ? 50 : i10, (i11 & 4) != 0 ? 100L : j10);
    }
}
