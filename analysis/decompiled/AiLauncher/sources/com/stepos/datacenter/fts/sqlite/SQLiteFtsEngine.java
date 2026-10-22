package com.stepos.datacenter.fts.sqlite;

import La.D;
import La.H;
import Ua.C1056g;
import Ua.Y;
import Z8.F;
import android.content.Context;
import android.util.LruCache;
import b7.C1454b;
import b7.d;
import c7.FtsDocument;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine;
import e9.InterfaceC4014c;
import g9.C4109a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u000250B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\nJ%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0086@¢\u0006\u0004\b#\u0010$J\u001e\u0010(\u001a\u00020'2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000fH\u0086@¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\bH\u0086@¢\u0006\u0004\b*\u0010+J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b,\u0010\u0012J\u0018\u0010-\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\bH\u0086@¢\u0006\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010=\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010:¨\u0006?"}, d2 = {"Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lb7/b;", "request", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lb7/b;)Ljava/lang/String;", "tableName", "LY8/t;", "t", "(Ljava/lang/String;)V", "", "Lb7/d;", "w", "(Lb7/b;Le9/c;)Ljava/lang/Object;", "query", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/String;", "p", "m", "n", "ftsQuery", "", "l", "(Ljava/lang/String;Lb7/b;)[Ljava/lang/String;", "q", "(Ljava/lang/String;)Ljava/util/List;", "", "docId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "r", "(JLjava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lc7/a;", "documents", "", "s", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "u", "(JLjava/lang/String;Le9/c;)Ljava/lang/Object;", "v", "o", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/datacenter/fts/sqlite/a;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/datacenter/fts/sqlite/a;", "dbHelper", "Landroid/util/LruCache;", "Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine$a;", Const.INTENT_KEY_PKGNAME, "Landroid/util/LruCache;", "searchCache", "Ljava/util/concurrent/atomic/AtomicLong;", "c", "Ljava/util/concurrent/atomic/AtomicLong;", "cacheHits", Const.INTENT_KEY_UMID, "cacheMisses", "Companion", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SQLiteFtsEngine {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final a dbHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final LruCache<String, CacheEntry> searchCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong cacheHits;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final AtomicLong cacheMisses;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine$a;", "", "", "Lb7/d;", "results", "", "timestamp", "<init>", "(Ljava/util/List;J)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "J", "()J", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$a, reason: from toString */
    public static final /* data */ class CacheEntry {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<d> results;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final long timestamp;

        /* JADX WARN: Multi-variable type inference failed */
        public CacheEntry(List<? extends d> results, long j10) {
            p.i(results, "results");
            this.results = results;
            this.timestamp = j10;
        }

        public final List<d> a() {
            return this.results;
        }

        /* renamed from: b, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CacheEntry)) {
                return false;
            }
            CacheEntry cacheEntry = (CacheEntry) other;
            return p.d(this.results, cacheEntry.results) && this.timestamp == cacheEntry.timestamp;
        }

        public int hashCode() {
            return (this.results.hashCode() * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "CacheEntry(results=" + this.results + ", timestamp=" + this.timestamp + ")";
        }
    }

    public SQLiteFtsEngine(Context context) {
        p.i(context, "context");
        this.dbHelper = a.INSTANCE.c(context);
        this.searchCache = new LruCache<>(100);
        this.cacheHits = new AtomicLong(0L);
        this.cacheMisses = new AtomicLong(0L);
    }

    public static final CharSequence k(SQLiteFtsEngine sQLiteFtsEngine, String it) {
        p.i(it, "it");
        return "\"" + sQLiteFtsEngine.p(it) + "\"*";
    }

    public final String i(C1454b request) {
        return request.f() + "_" + request.g() + "_" + request.c() + "_" + request.e() + "_" + request.h();
    }

    public final String j(String query) {
        List<String> listN = new Regex("\\s+").n(query, 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != 1) {
            return F.A0(arrayList, " OR ", null, null, 0, null, new InterfaceC5074l() { // from class: c7.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SQLiteFtsEngine.k(this.f15476a, (String) obj2);
                }
            }, 30, null);
        }
        return "\"" + p((String) arrayList.get(0)) + "\"*";
    }

    public final String[] l(String ftsQuery, C1454b request) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ftsQuery);
        String strG = request.g();
        if (strG != null) {
            if (H.x0(strG)) {
                strG = null;
            }
            if (strG != null) {
                arrayList.add(strG);
            }
        }
        if (request.d() > 0.0d) {
            arrayList.add(String.valueOf(-request.d()));
        }
        arrayList.add(String.valueOf(request.c()));
        arrayList.add(String.valueOf(request.e()));
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String m(C1454b request) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT d.id, d.doc_id, d.table_name, d.content, ");
        sb2.append("bm25(fts_content) as score ");
        sb2.append("FROM fts_content f ");
        sb2.append("JOIN fts_data d ON f.rowid = d.id ");
        sb2.append("WHERE fts_content MATCH ? ");
        String strG = request.g();
        if (strG != null && !H.x0(strG)) {
            sb2.append("AND d.table_name = ? ");
        }
        if (request.d() > 0.0d) {
            sb2.append("AND bm25(fts_content) <= ? ");
        }
        sb2.append("ORDER BY score ");
        sb2.append("LIMIT ? OFFSET ?");
        return sb2.toString();
    }

    public final String n(C1454b request) {
        String strA = request.a();
        p.h(strA, "getHighlightPrefix(...)");
        String strB = request.b();
        p.h(strB, "getHighlightSuffix(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT d.id, d.doc_id, d.table_name, d.content, ");
        sb2.append("bm25(fts_content) as score, ");
        sb2.append("highlight(fts_content, 0, '" + strA + "', '" + strB + "') as highlighted, ");
        sb2.append("d.updated_at ");
        sb2.append("FROM fts_content f ");
        sb2.append("JOIN fts_data d ON f.rowid = d.id ");
        sb2.append("WHERE fts_content MATCH ? ");
        String strG = request.g();
        if (strG != null && !H.x0(strG)) {
            sb2.append("AND d.table_name = ? ");
        }
        if (request.d() > 0.0d) {
            sb2.append("AND bm25(fts_content) <= ? ");
        }
        sb2.append("ORDER BY score ");
        sb2.append("LIMIT ? OFFSET ?");
        return sb2.toString();
    }

    public final Object o(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new SQLiteFtsEngine$clearTable$2(this, str, null), interfaceC4014c);
    }

    public final String p(String query) {
        return D.T(query, "\"", "\"\"", false, 4, null);
    }

    public final List<String> q(String query) {
        List<String> listN = new Regex("\\s+").n(query, 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Object r(long j10, String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return H.x0(str2) ? C4109a.a(false) : C1056g.j(Y.b(), new SQLiteFtsEngine$indexDocument$2(this, str, j10, str2, null), interfaceC4014c);
    }

    public final Object s(List<FtsDocument> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return list.isEmpty() ? C4109a.f(0) : C1056g.j(Y.b(), new SQLiteFtsEngine$indexDocumentsBatch$2(this, list, null), interfaceC4014c);
    }

    public final void t(String tableName) {
        for (String str : this.searchCache.snapshot().keySet()) {
            p.f(str);
            if (H.g0(str, "_" + tableName + "_", false, 2, null) || H.g0(str, "_null_", false, 2, null)) {
                this.searchCache.remove(str);
            }
        }
    }

    public final Object u(long j10, String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new SQLiteFtsEngine$removeFromIndex$2(this, str, j10, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(b7.C1454b r10, e9.InterfaceC4014c<? super java.util.List<? extends b7.d>> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$search$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$search$1 r0 = (com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$search$1) r0
            int r1 = r0.f30085e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f30085e = r1
            goto L18
        L13:
            com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$search$1 r0 = new com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$search$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f30083c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f30085e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r9 = r0.f30082b
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.f30081a
            com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine r10 = (com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine) r10
            kotlin.C4849c.b(r11)
            r8 = r11
            r11 = r9
            r9 = r10
            r10 = r8
            goto L96
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            kotlin.C4849c.b(r11)
            java.lang.String r11 = r10.f()
            java.lang.String r2 = "getQuery(...)"
            kotlin.jvm.internal.p.h(r11, r2)
            java.lang.CharSequence r11 = La.H.D1(r11)
            java.lang.String r11 = r11.toString()
            boolean r11 = La.H.x0(r11)
            if (r11 == 0) goto L5c
            java.util.List r9 = Z8.C1173v.m()
            return r9
        L5c:
            java.lang.String r11 = r9.i(r10)
            android.util.LruCache<java.lang.String, com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$a> r2 = r9.searchCache
            java.lang.Object r2 = r2.get(r11)
            com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$a r2 = (com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine.CacheEntry) r2
            if (r2 == 0) goto L84
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r2.getTimestamp()
            long r4 = r4 - r6
            r6 = 60000(0xea60, double:2.9644E-319)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L84
            java.util.concurrent.atomic.AtomicLong r9 = r9.cacheHits
            r9.incrementAndGet()
            java.util.List r9 = r2.a()
            return r9
        L84:
            java.util.concurrent.atomic.AtomicLong r2 = r9.cacheMisses
            r2.incrementAndGet()
            r0.f30081a = r9
            r0.f30082b = r11
            r0.f30085e = r3
            java.lang.Object r10 = r9.w(r10, r0)
            if (r10 != r1) goto L96
            return r1
        L96:
            java.util.List r10 = (java.util.List) r10
            android.util.LruCache<java.lang.String, com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$a> r9 = r9.searchCache
            com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$a r0 = new com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$a
            long r1 = java.lang.System.currentTimeMillis()
            r0.<init>(r10, r1)
            r9.put(r11, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine.v(b7.b, e9.c):java.lang.Object");
    }

    public final Object w(C1454b c1454b, InterfaceC4014c<? super List<? extends d>> interfaceC4014c) {
        return C1056g.j(Y.b(), new SQLiteFtsEngine$searchInternal$2(c1454b, this, null), interfaceC4014c);
    }
}
