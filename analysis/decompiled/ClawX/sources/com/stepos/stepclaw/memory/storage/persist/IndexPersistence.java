package com.stepos.stepclaw.memory.storage.persist;

import a8.b;
import b7.c;
import c5.m;
import c5.o;
import c5.s;
import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.memory.lightmem.f;
import com.stepos.stepclaw.memory.storage.cache.TieredCacheConfig;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.index.AccessStatsEntry;
import com.stepos.stepclaw.memory.storage.index.BM25Index;
import com.stepos.stepclaw.memory.storage.index.DocMeta;
import com.stepos.stepclaw.memory.storage.index.IndexSnapshot;
import com.stepos.stepclaw.memory.storage.index.Posting;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.w;
import m5.h;
import m5.j;
import m5.k;
import m5.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x5.a;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 [2\u00020\u0001:\u0001[B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\r¢\u0006\u0004\b%\u0010&J-\u0010+\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001f¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010$\u001a\u00020\r¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u001f¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\r2\u0006\u00104\u001a\u00020\rH\u0002¢\u0006\u0004\b5\u00106JA\u0010>\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\r2\u0018\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020:09082\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?JI\u0010A\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010@\u001a\u00020\r2\u0018\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020:09082\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\bA\u0010BJQ\u0010E\u001a\u00020D2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010\r2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0018\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020:09082\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u000fH\u0002¢\u0006\u0004\bG\u0010#J+\u0010J\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\bJ\u0010KJ'\u0010M\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\bM\u0010NJ/\u0010Q\u001a\u00020\r2\u0006\u0010O\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010@\u001a\u00020\r2\u0006\u0010P\u001a\u00020\rH\u0002¢\u0006\u0004\bQ\u0010RR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010SR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010TR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010UR#\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-0V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z¨\u0006\\"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/persist/IndexPersistence;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/io/File;", "baseDir", "Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "cacheConfig", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Ljava/io/File;Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "Lcom/stepos/stepclaw/memory/storage/index/BM25Index;", "index", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "partitionKeys", "Lb5/a0;", "persistAccessStats", "(Lcom/stepos/stepclaw/memory/storage/index/BM25Index;Ljava/util/Set;)V", "partitionDir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/index/AccessStatsEntry;", "loadAccessStats", "(Ljava/io/File;)Ljava/util/Map;", "persistIndex", "(Lcom/stepos/stepclaw/memory/storage/index/BM25Index;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "loadPersistedMeta", "()Z", "category", "dateFrom", "dateTo", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "loadPersistedCategoryIndex", "(Ljava/lang/String;Lcom/stepos/stepclaw/memory/storage/index/BM25Index;Ljava/lang/String;Ljava/lang/String;)I", "clearFileStates", "()V", "path", "clearFileState", "(Ljava/lang/String;)V", "hash", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lastModified", "entryCount", "updateFileState", "(Ljava/lang/String;Ljava/lang/String;JI)V", "Lcom/stepos/stepclaw/memory/storage/persist/FileIndexState;", "getFileState", "(Ljava/lang/String;)Lcom/stepos/stepclaw/memory/storage/persist/FileIndexState;", "peekPersistedVersion", "()Ljava/lang/Integer;", "invalidatePersistedIndexes", "()I", "partitionKey", "resolveAccessStatsDir", "(Ljava/lang/String;)Ljava/lang/String;", "indexDir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/index/DocMeta;", "docs", "Lcom/stepos/stepclaw/memory/storage/index/IndexSnapshot;", "snapshot", "persistCategoryIndex", "(Ljava/io/File;Ljava/lang/String;Ljava/util/List;Lcom/stepos/stepclaw/memory/storage/index/IndexSnapshot;)V", "date", "persistCategoryDateIndex", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/stepclaw/memory/storage/index/IndexSnapshot;)V", "docIds", "Lorg/json/JSONObject;", "buildIndexJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/List;Lcom/stepos/stepclaw/memory/storage/index/IndexSnapshot;)Lorg/json/JSONObject;", "migratePermanentAccessStats", "file", "stats", "writeAccessStatsFile", "(Ljava/io/File;Ljava/util/Map;)V", "indexFile", "loadIndexFromFile", "(Ljava/io/File;Ljava/lang/String;Lcom/stepos/stepclaw/memory/storage/index/BM25Index;)I", "docId", "metaCategory", "migrateDocId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/io/File;", "Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "fileStates", "Ljava/util/Map;", "getFileStates", "()Ljava/util/Map;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndexPersistence {
    public static final String ACCESS_STATS_FILE = "access_stats.json";
    public static final int ACCESS_STATS_VERSION = 1;
    private static final int BUFFER_SIZE = 65536;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INDEX_DATA_FILE = "index.json";
    public static final String INDEX_DIR = "stepmem/index";
    public static final String INDEX_META_FILE = "_meta.json";
    public static final int INDEX_VERSION = 3;
    private static final String TAG = "Mem-IndexPersistence";
    private final File baseDir;
    private final TieredCacheConfig cacheConfig;
    private final Map<String, FileIndexState> fileStates;
    private final MemoryLogger logger;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/persist/IndexPersistence$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Ljava/io/File;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "Lb5/a0;", "bufferedWrite", "(Ljava/io/File;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "INDEX_DIR", "INDEX_META_FILE", "INDEX_DATA_FILE", "ACCESS_STATS_FILE", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ACCESS_STATS_VERSION", "I", "INDEX_VERSION", "BUFFER_SIZE", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void bufferedWrite(File file, String content) throws IOException {
            p.e(file, "<this>");
            p.e(content, "content");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file), IndexPersistence.BUFFER_SIZE);
            try {
                bufferedWriter.write(content);
                bufferedWriter.close();
            } finally {
            }
        }

        private Companion() {
        }
    }

    public IndexPersistence(File baseDir, TieredCacheConfig cacheConfig, MemoryLogger logger) {
        p.e(baseDir, "baseDir");
        p.e(cacheConfig, "cacheConfig");
        p.e(logger, "logger");
        this.baseDir = baseDir;
        this.cacheConfig = cacheConfig;
        this.logger = logger;
        this.fileStates = new LinkedHashMap();
    }

    public static final void bufferedWrite(File file, String str) throws IOException {
        INSTANCE.bufferedWrite(file, str);
    }

    private final JSONObject buildIndexJson(String category, String date, Set<String> docIds, List<? extends Map.Entry<String, DocMeta>> docs, IndexSnapshot snapshot) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<Posting>> entry : snapshot.getInvertedIndex().entrySet()) {
            String key = entry.getKey();
            List<Posting> value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (docIds.contains(((Posting) obj).getDocId())) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                linkedHashMap.put(key, arrayList);
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 3);
        jSONObject.put("category", category);
        if (date != null) {
            jSONObject.put("date", date);
        }
        jSONObject.put("documentCount", docIds.size());
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            List<Posting> list = (List) entry2.getValue();
            JSONArray jSONArray = new JSONArray();
            for (Posting posting : list) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("docId", posting.getDocId());
                jSONObject3.put("frequency", posting.getFrequency());
                jSONArray.put(jSONObject3);
            }
            jSONObject2.put(str, jSONArray);
        }
        jSONObject.put("invertedIndex", jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        for (Map.Entry<String, DocMeta> entry3 : docs) {
            String key2 = entry3.getKey();
            DocMeta value2 = entry3.getValue();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("length", value2.getLength());
            jSONObject5.put("date", value2.getDate());
            jSONObject5.put("category", value2.getCategory());
            jSONObject5.put("createdAt", value2.getCreatedAt());
            jSONObject4.put(key2, jSONObject5);
        }
        jSONObject.put("docMetas", jSONObject4);
        JSONObject jSONObject6 = new JSONObject();
        for (String str2 : docIds) {
            String str3 = snapshot.getDocContents().get(str2);
            if (str3 != null) {
                jSONObject6.put(str2, str3);
            }
        }
        jSONObject.put("docContents", jSONObject6);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invalidatePersistedIndexes$lambda$1(w wVar, File file) {
        return "invalidatePersistedIndexes: removed " + wVar.f3684a + " entries under " + file.getPath();
    }

    private final int loadIndexFromFile(File indexFile, String category, BM25Index index) throws JSONException {
        File file;
        int i8;
        JSONObject jSONObject;
        String str;
        String str2;
        String str3;
        String next;
        String strOptString;
        String string;
        Iterator<String> it;
        String strNormalizeCategory;
        long epochMilli;
        long j4;
        int i9;
        int iOptInt;
        String str4;
        long jOptLong;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject2;
        LinkedHashMap linkedHashMap;
        JSONObject jSONObject3;
        File file2 = indexFile;
        BM25Index bM25Index = index;
        String str8 = "createdAt";
        int i10 = 0;
        if (file2.exists()) {
            try {
                jSONObject = new JSONObject(l.E0(file2, a.f6276a));
            } catch (Exception e9) {
                e = e9;
                file = file2;
                i8 = i10;
            }
            if (jSONObject.optInt("version", 0) == 3) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("docMetas");
                JSONObject jSONObject5 = jSONObject.getJSONObject("docContents");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator<String> itKeys = jSONObject4.keys();
                p.d(itKeys, "keys(...)");
                while (true) {
                    boolean zHasNext = itKeys.hasNext();
                    str = "category";
                    str2 = "date";
                    str3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                    if (!zHasNext) {
                        break;
                    }
                    try {
                        String next2 = itKeys.next();
                        JSONObject jSONObject6 = jSONObject4.getJSONObject(next2);
                        String strOptString2 = jSONObject6.optString("date", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                        String strOptString3 = jSONObject6.optString("category", category);
                        p.b(next2);
                        p.b(strOptString2);
                        p.b(strOptString3);
                        linkedHashMap2.put(next2, migrateDocId(next2, category, strOptString2, strOptString3));
                        i10 = 0;
                    } catch (Exception e10) {
                        e = e10;
                        file = file2;
                    }
                    e = e10;
                    file = file2;
                    i8 = 0;
                    ALog.e(TAG, "Failed to load index from " + file.getPath(), e);
                    return i8;
                }
                JSONObject jSONObject7 = jSONObject.getJSONObject("invertedIndex");
                Iterator<String> itKeys2 = jSONObject7.keys();
                p.d(itKeys2, "keys(...)");
                while (itKeys2.hasNext()) {
                    try {
                        String next3 = itKeys2.next();
                        JSONArray jSONArray = jSONObject7.getJSONArray(next3);
                        JSONObject jSONObject8 = jSONObject7;
                        ArrayList arrayList = new ArrayList();
                        Iterator<String> it2 = itKeys2;
                        int length = jSONArray.length();
                        int i11 = 0;
                        while (i11 < length) {
                            int i12 = length;
                            JSONObject jSONObject9 = jSONArray.getJSONObject(i11);
                            int i13 = i11;
                            String string2 = jSONObject9.getString("docId");
                            String strMigrateDocId = (String) linkedHashMap2.get(string2);
                            if (strMigrateDocId == null) {
                                p.b(string2);
                                strMigrateDocId = migrateDocId(string2, category, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, category);
                            }
                            arrayList.add(new Posting(strMigrateDocId, jSONObject9.getInt("frequency"), null, 4, null));
                            i11 = i13 + 1;
                            length = i12;
                        }
                        p.b(next3);
                        bM25Index.importPostings(next3, arrayList);
                        file2 = indexFile;
                        jSONObject7 = jSONObject8;
                        itKeys2 = it2;
                    } catch (Exception e11) {
                        e = e11;
                        file = indexFile;
                    }
                }
                w wVar = new w();
                Iterator<String> itKeys3 = jSONObject4.keys();
                p.d(itKeys3, "keys(...)");
                while (itKeys3.hasNext()) {
                    try {
                        next = itKeys3.next();
                        JSONObject jSONObject10 = jSONObject4.getJSONObject(next);
                        strOptString = jSONObject5.optString(next, str3);
                        string = jSONObject10.getString(str2);
                        MemoryFile.Companion companion = MemoryFile.INSTANCE;
                        it = itKeys3;
                        String string3 = jSONObject10.getString(str);
                        p.d(string3, "getString(...)");
                        strNormalizeCategory = companion.normalizeCategory(string3);
                        p.b(string);
                        if (n.t1(string) && this.cacheConfig.getPermanentCategories().contains(strNormalizeCategory)) {
                            string = MemoryFile.PERMANENT_DATE;
                        }
                        if (jSONObject10.has(str8)) {
                            epochMilli = jSONObject10.getLong(str8);
                        } else {
                            try {
                                epochMilli = LocalDate.parse(string).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
                            } catch (Exception unused) {
                                epochMilli = 0;
                            }
                        }
                        String str9 = (String) linkedHashMap2.get(next);
                        if (str9 != null) {
                            next = str9;
                        }
                        p.b(next);
                        j4 = epochMilli;
                        i9 = jSONObject10.getInt("length");
                        p.b(strOptString);
                        try {
                            iOptInt = jSONObject10.optInt("hitCount", 0);
                            str4 = str8;
                            jOptLong = jSONObject10.optLong("lastAccessedAt", 0L);
                            str5 = str2;
                            str6 = str3;
                            str7 = str;
                            jSONObject2 = jSONObject5;
                            i8 = 0;
                            linkedHashMap = linkedHashMap2;
                            jSONObject3 = jSONObject4;
                        } catch (Exception e12) {
                            e = e12;
                            i8 = 0;
                            file = indexFile;
                            ALog.e(TAG, "Failed to load index from " + file.getPath(), e);
                            return i8;
                        }
                    } catch (Exception e13) {
                        e = e13;
                        i8 = 0;
                    }
                    try {
                        BM25Index.importDocMeta$default(index, next, i9, string, strNormalizeCategory, strOptString, j4, iOptInt, jOptLong, null, 256, null);
                        wVar.f3684a++;
                        bM25Index = index;
                        str3 = str6;
                        jSONObject4 = jSONObject3;
                        jSONObject5 = jSONObject2;
                        linkedHashMap2 = linkedHashMap;
                        itKeys3 = it;
                        str = str7;
                        str8 = str4;
                        str2 = str5;
                    } catch (Exception e14) {
                        e = e14;
                        file = indexFile;
                        ALog.e(TAG, "Failed to load index from " + file.getPath(), e);
                        return i8;
                    }
                }
                BM25Index bM25Index2 = bM25Index;
                String str10 = str3;
                i8 = 0;
                File parentFile = indexFile.getParentFile();
                p.d(parentFile, "getParentFile(...)");
                for (Map.Entry<String, AccessStatsEntry> entry : loadAccessStats(parentFile).entrySet()) {
                    String key = entry.getKey();
                    AccessStatsEntry value = entry.getValue();
                    DocMeta docMeta = bM25Index2.getDocMeta(key);
                    if (docMeta != null) {
                        int length2 = docMeta.getLength();
                        String date = docMeta.getDate();
                        String category2 = docMeta.getCategory();
                        String document = bM25Index2.getDocument(key);
                        if (document == null) {
                            document = str10;
                        }
                        BM25Index.importDocMeta$default(bM25Index2, key, length2, date, category2, document, docMeta.getCreatedAt(), value.getHitCount(), value.getLastAccessedAt(), null, 256, null);
                        bM25Index2 = index;
                    }
                }
                file = indexFile;
                try {
                    MemoryLogger.logD$default(this.logger, TAG, null, new s3.a(file, wVar), 2, null);
                    return wVar.f3684a;
                } catch (Exception e15) {
                    e = e15;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadIndexFromFile$lambda$0(File file, w wVar) {
        return "Loaded index from " + file.getPath() + ": " + wVar.f3684a + " docs";
    }

    public static /* synthetic */ int loadPersistedCategoryIndex$default(IndexPersistence indexPersistence, String str, BM25Index bM25Index, String str2, String str3, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = null;
        }
        if ((i8 & 8) != 0) {
            str3 = null;
        }
        return indexPersistence.loadPersistedCategoryIndex(str, bM25Index, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPersistedMeta$lambda$0(int i8) {
        return b.k(i8, "Index version mismatch (", " != 3), will rebuild");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPersistedMeta$lambda$1(IndexPersistence indexPersistence) {
        return b.k(indexPersistence.fileStates.size(), "Loaded persisted file states: ", " files");
    }

    private final String migrateDocId(String docId, String category, String date, String metaCategory) {
        int iQ1 = n.q1(docId, '/', 0, 6);
        int iQ12 = n.q1(docId, '#', 0, 6);
        if (1 <= iQ1 && iQ1 < iQ12) {
            return docId;
        }
        if (!n.t1(metaCategory)) {
            category = metaCategory;
        }
        if (this.cacheConfig.getPermanentCategories().contains(category)) {
            date = MemoryFile.PERMANENT_DATE;
        }
        if (iQ12 >= 0) {
            docId = docId.substring(iQ12 + 1);
            p.d(docId, "substring(...)");
        }
        return category + "/" + date + "#" + docId;
    }

    private final void migratePermanentAccessStats() {
        File file = new File(this.baseDir, INDEX_DIR);
        for (String str : this.cacheConfig.getPermanentCategories()) {
            File file2 = new File(file, b.n(str, "/permanent"));
            File file3 = new File(file2, ACCESS_STATS_FILE);
            if (file3.exists()) {
                File file4 = new File(file, str);
                File file5 = new File(file4, ACCESS_STATS_FILE);
                try {
                    Map<String, AccessStatsEntry> mapLoadAccessStats = loadAccessStats(file2);
                    if (mapLoadAccessStats.isEmpty()) {
                        file3.delete();
                        file2.delete();
                    } else {
                        if (file5.exists()) {
                            Map<String, AccessStatsEntry> mapLoadAccessStats2 = loadAccessStats(file4);
                            p.e(mapLoadAccessStats2, "<this>");
                            LinkedHashMap linkedHashMap = new LinkedHashMap(mapLoadAccessStats2);
                            for (Map.Entry<String, AccessStatsEntry> entry : mapLoadAccessStats.entrySet()) {
                                String key = entry.getKey();
                                AccessStatsEntry value = entry.getValue();
                                AccessStatsEntry accessStatsEntry = (AccessStatsEntry) linkedHashMap.get(key);
                                if (accessStatsEntry == null || value.getLastAccessedAt() > accessStatsEntry.getLastAccessedAt()) {
                                    linkedHashMap.put(key, value);
                                }
                            }
                            writeAccessStatsFile(file5, linkedHashMap);
                        } else {
                            file4.mkdirs();
                            writeAccessStatsFile(file5, mapLoadAccessStats);
                        }
                        file3.delete();
                        file2.delete();
                        MemoryLogger.logI$default(this.logger, TAG, null, new f((Object) str, 9, (Object) mapLoadAccessStats), 2, null);
                    }
                } catch (Exception e9) {
                    ALog.e(TAG, "Failed to migrate access_stats for " + str, e9);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migratePermanentAccessStats$lambda$0(String str, Map map) {
        return m0.f.e(b.v("Migrated access_stats from ", str, "/permanent/ to ", str, "/ ("), map.size(), " entries)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String peekPersistedVersion$lambda$0(Exception exc) {
        return m0.f.c("peekPersistedVersion failed: ", exc.getMessage());
    }

    private final void persistCategoryDateIndex(File indexDir, String category, String date, List<? extends Map.Entry<String, DocMeta>> docs, IndexSnapshot snapshot) throws JSONException, IOException {
        File file = new File(indexDir, b.o(category, "/", date));
        file.mkdirs();
        ArrayList arrayList = new ArrayList(o.n0(docs, 10));
        Iterator<T> it = docs.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        JSONObject jSONObjectBuildIndexJson = buildIndexJson(category, date, m.R0(arrayList), docs, snapshot);
        Companion companion = INSTANCE;
        File file2 = new File(file, INDEX_DATA_FILE);
        String string = jSONObjectBuildIndexJson.toString(2);
        p.d(string, "toString(...)");
        companion.bufferedWrite(file2, string);
    }

    private final void persistCategoryIndex(File indexDir, String category, List<? extends Map.Entry<String, DocMeta>> docs, IndexSnapshot snapshot) throws JSONException, IOException {
        File file = new File(indexDir, category);
        file.mkdirs();
        ArrayList arrayList = new ArrayList(o.n0(docs, 10));
        Iterator<T> it = docs.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        JSONObject jSONObjectBuildIndexJson = buildIndexJson(category, null, m.R0(arrayList), docs, snapshot);
        Companion companion = INSTANCE;
        File file2 = new File(file, INDEX_DATA_FILE);
        String string = jSONObjectBuildIndexJson.toString(2);
        p.d(string, "toString(...)");
        companion.bufferedWrite(file2, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String persistIndex$lambda$3(File file, Map map) {
        return "Index persisted to " + file + " (" + map.keySet().size() + " categories)";
    }

    private final String resolveAccessStatsDir(String partitionKey) {
        int iQ1 = n.q1(partitionKey, '/', 0, 6);
        if (iQ1 >= 0) {
            String strSubstring = partitionKey.substring(0, iQ1);
            p.d(strSubstring, "substring(...)");
            if (this.cacheConfig.getPermanentCategories().contains(strSubstring)) {
                return strSubstring;
            }
        }
        return partitionKey;
    }

    private final void writeAccessStatsFile(File file, Map<String, AccessStatsEntry> stats) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, AccessStatsEntry> entry : stats.entrySet()) {
            String key = entry.getKey();
            AccessStatsEntry value = entry.getValue();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("h", value.getHitCount());
            jSONObject3.put("t", value.getLastAccessedAt());
            jSONObject2.put(key, jSONObject3);
        }
        jSONObject.put("stats", jSONObject2);
        Companion companion = INSTANCE;
        String string = jSONObject.toString();
        p.d(string, "toString(...)");
        companion.bufferedWrite(file, string);
    }

    public final void clearFileState(String path) {
        p.e(path, "path");
        this.fileStates.remove(path);
    }

    public final void clearFileStates() {
        this.fileStates.clear();
    }

    public final FileIndexState getFileState(String path) {
        p.e(path, "path");
        return this.fileStates.get(path);
    }

    public final Map<String, FileIndexState> getFileStates() {
        return this.fileStates;
    }

    public final int invalidatePersistedIndexes() {
        File file = new File(this.baseDir, INDEX_DIR);
        if (!file.exists()) {
            this.fileStates.clear();
            return 0;
        }
        w wVar = new w();
        try {
            h hVar = new h(new j(file, k.f3924b, null));
            while (hVar.hasNext()) {
                File file2 = (File) hVar.next();
                if (!p.a(file2, file) && file2.exists() && file2.delete()) {
                    wVar.f3684a++;
                }
            }
            this.fileStates.clear();
            MemoryLogger.logI$default(this.logger, TAG, null, new s3.a(wVar, file), 2, null);
        } catch (Exception e9) {
            ALog.e(TAG, "invalidatePersistedIndexes failed", e9);
        }
        return wVar.f3684a;
    }

    public final Map<String, AccessStatsEntry> loadAccessStats(File partitionDir) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        p.e(partitionDir, "partitionDir");
        File file = new File(partitionDir, ACCESS_STATS_FILE);
        boolean zExists = file.exists();
        t tVar = t.f1093a;
        if (zExists) {
            try {
                JSONObject jSONObject = new JSONObject(l.E0(file, a.f6276a));
                if (jSONObject.optInt("version", 0) == 1 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("stats")) != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    p.d(itKeys, "keys(...)");
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONObject jSONObject2 = jSONObjectOptJSONObject.getJSONObject(next);
                        linkedHashMap.put(next, new AccessStatsEntry(jSONObject2.optInt("h", 0), jSONObject2.optLong("t", 0L)));
                    }
                    return linkedHashMap;
                }
            } catch (Exception e9) {
                ALog.e(TAG, "Failed to load access stats from " + file.getPath(), e9);
                return tVar;
            }
        }
        return tVar;
    }

    public final int loadPersistedCategoryIndex(String category, BM25Index index, String dateFrom, String dateTo) {
        List<File> arrayList;
        p.e(category, "category");
        p.e(index, "index");
        File file = new File(this.baseDir, "stepmem/index/".concat(category));
        int iLoadIndexFromFile = 0;
        if (!file.exists()) {
            return 0;
        }
        if (this.cacheConfig.getPermanentCategories().contains(category)) {
            return loadIndexFromFile(new File(file, INDEX_DATA_FILE), category, index);
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    arrayList.add(file2);
                }
            }
        } else {
            arrayList = s.f1092a;
        }
        for (File file3 : arrayList) {
            String name = file3.getName();
            if (dateFrom == null || name.compareTo(dateFrom) >= 0) {
                if (dateTo == null || name.compareTo(dateTo) <= 0) {
                    iLoadIndexFromFile += loadIndexFromFile(new File(file3, INDEX_DATA_FILE), category, index);
                }
            }
        }
        return iLoadIndexFromFile;
    }

    public final boolean loadPersistedMeta() throws JSONException {
        try {
            File file = new File(this.baseDir, INDEX_DIR);
            if (file.exists()) {
                File file2 = new File(file, INDEX_META_FILE);
                if (file2.exists()) {
                    JSONObject jSONObject = new JSONObject(l.E0(file2, a.f6276a));
                    int iOptInt = jSONObject.optInt("version", 0);
                    if (iOptInt != 3) {
                        MemoryLogger.logW$default(this.logger, TAG, null, new com.stepos.stepclaw.memory.lightmem.evolution.b(iOptInt, 1), 2, null);
                        return false;
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("fileStates");
                    Iterator<String> itKeys = jSONObject2.keys();
                    p.d(itKeys, "keys(...)");
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        Map<String, FileIndexState> map = this.fileStates;
                        String string = jSONObject3.getString("hash");
                        p.d(string, "getString(...)");
                        map.put(next, new FileIndexState(string, jSONObject3.getLong("lastModified"), jSONObject3.getInt("entryCount")));
                    }
                    MemoryLogger.logD$default(this.logger, TAG, null, new c(20, this), 2, null);
                    migratePermanentAccessStats();
                    return true;
                }
            }
            return false;
        } catch (Exception e9) {
            ALog.e(TAG, "Failed to load persisted meta", e9);
            return false;
        }
    }

    public final Integer peekPersistedVersion() {
        int iOptInt;
        try {
            File file = new File(this.baseDir, "stepmem/index/_meta.json");
            if (file.exists() && (iOptInt = new JSONObject(l.E0(file, a.f6276a)).optInt("version", -1)) >= 0) {
                return Integer.valueOf(iOptInt);
            }
            return null;
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new com.stepos.stepclaw.memory.search.b(e9, 3), 2, null);
            return null;
        }
    }

    public final void persistAccessStats(BM25Index index, Set<String> partitionKeys) throws JSONException {
        p.e(index, "index");
        p.e(partitionKeys, "partitionKeys");
        if (partitionKeys.isEmpty()) {
            return;
        }
        try {
            File file = new File(this.baseDir, INDEX_DIR);
            Set<Map.Entry<String, AccessStatsEntry>> setEntrySet = index.exportAccessStats(partitionKeys).entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : setEntrySet) {
                String strN1 = n.N1((String) ((Map.Entry) obj).getKey(), '#');
                Object arrayList = linkedHashMap.get(strN1);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(strN1, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (String str : partitionKeys) {
                String strResolveAccessStatsDir = resolveAccessStatsDir(str);
                Collection collection = (List) linkedHashMap.get(str);
                if (collection == null) {
                    collection = s.f1092a;
                }
                Object arrayList2 = linkedHashMap2.get(strResolveAccessStatsDir);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(strResolveAccessStatsDir, arrayList2);
                }
                ((List) arrayList2).addAll(collection);
            }
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                String str2 = (String) entry.getKey();
                List<Map.Entry> list = (List) entry.getValue();
                File file2 = new File(file, str2);
                file2.mkdirs();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 1);
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry entry2 : list) {
                    String str3 = (String) entry2.getKey();
                    AccessStatsEntry accessStatsEntry = (AccessStatsEntry) entry2.getValue();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("h", accessStatsEntry.getHitCount());
                    jSONObject3.put("t", accessStatsEntry.getLastAccessedAt());
                    jSONObject2.put(str3, jSONObject3);
                }
                jSONObject.put("stats", jSONObject2);
                Companion companion = INSTANCE;
                File file3 = new File(file2, ACCESS_STATS_FILE);
                String string = jSONObject.toString();
                p.d(string, "toString(...)");
                companion.bufferedWrite(file3, string);
            }
        } catch (Exception e9) {
            ALog.e(TAG, "Failed to persist access stats", e9);
        }
    }

    public final void persistIndex(BM25Index index) throws JSONException {
        p.e(index, "index");
        try {
            File file = new File(this.baseDir, INDEX_DIR);
            file.mkdirs();
            IndexSnapshot indexSnapshotExportIndex = index.exportIndex();
            Set<Map.Entry<String, DocMeta>> setEntrySet = indexSnapshotExportIndex.getDocMetas().entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : setEntrySet) {
                String category = ((DocMeta) ((Map.Entry) obj).getValue()).getCategory();
                Object arrayList = linkedHashMap.get(category);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(category, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List<? extends Map.Entry<String, DocMeta>> list = (List) entry.getValue();
                if (this.cacheConfig.getPermanentCategories().contains(str)) {
                    this.persistCategoryIndex(file, str, list, indexSnapshotExportIndex);
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Object obj2 : list) {
                        String date = ((DocMeta) ((Map.Entry) obj2).getValue()).getDate();
                        Object arrayList2 = linkedHashMap2.get(date);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            linkedHashMap2.put(date, arrayList2);
                        }
                        ((List) arrayList2).add(obj2);
                    }
                    for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                        String str2 = (String) entry2.getKey();
                        List<? extends Map.Entry<String, DocMeta>> list2 = (List) entry2.getValue();
                        IndexPersistence indexPersistence = this;
                        indexPersistence.persistCategoryDateIndex(file, str, str2, list2, indexSnapshotExportIndex);
                        this = indexPersistence;
                    }
                }
            }
            IndexPersistence indexPersistence2 = this;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", 3);
            jSONObject.put("totalDocuments", index.getDocumentCount());
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, FileIndexState> entry3 : indexPersistence2.fileStates.entrySet()) {
                String key = entry3.getKey();
                FileIndexState value = entry3.getValue();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("hash", value.getHash());
                jSONObject3.put("lastModified", value.getLastModified());
                jSONObject3.put("entryCount", value.getEntryCount());
                jSONObject2.put(key, jSONObject3);
            }
            jSONObject.put("fileStates", jSONObject2);
            Companion companion = INSTANCE;
            File file2 = new File(file, INDEX_META_FILE);
            String string = jSONObject.toString(2);
            p.d(string, "toString(...)");
            companion.bufferedWrite(file2, string);
            MemoryLogger.logD$default(indexPersistence2.logger, TAG, null, new f(file, 10, linkedHashMap), 2, null);
        } catch (Exception e9) {
            ALog.e(TAG, "Failed to persist index", e9);
        }
    }

    public final void updateFileState(String path, String hash, long lastModified, int entryCount) {
        p.e(path, "path");
        p.e(hash, "hash");
        this.fileStates.put(path, new FileIndexState(hash, lastModified, entryCount));
    }

    public /* synthetic */ IndexPersistence(File file, TieredCacheConfig tieredCacheConfig, MemoryLogger memoryLogger, int i8, i iVar) {
        this(file, tieredCacheConfig, (i8 & 4) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
