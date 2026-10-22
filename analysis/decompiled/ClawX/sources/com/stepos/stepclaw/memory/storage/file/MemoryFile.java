package com.stepos.stepclaw.memory.storage.file;

import b5.a0;
import b5.g;
import c5.k;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.evolution.EpisodicMemoryEvolutionState;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import o3.a;
import x5.h;
import x5.j;
import x5.l;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 12\u00020\u0001:\u00011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\u0016H\u0004¢\u0006\u0004\b\u0017\u0010\u0003J!\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J-\u0010#\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0004¢\u0006\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0006R\u0014\u0010-\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/\u0082\u0001\u000223¨\u00064"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/file/MemoryFile;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "contentHash", "()Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "readEntries", "()Ljava/util/List;", "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "item", "appendEntry", "(Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;)Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "similarityThreshold", "Lb5/g;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "appendEntryWithMmr", "(Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;D)Lb5/g;", "readRawContent", "Lb5/a0;", "ensureDirectoryExists", "line", "entryDate", "parseEntry", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "parseJsonEntry", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memoryIndex", "containsMemoryIndex", "(J)Z", "content", "existingEntries", "checkDuplicate", "(Ljava/lang/String;Ljava/util/List;D)Z", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "file", "getCategory", "category", "getExists", "()Z", "exists", "getLastModified", "()J", "lastModified", "Companion", "Lcom/stepos/stepclaw/memory/storage/file/DailyMemoryFile;", "Lcom/stepos/stepclaw/memory/storage/file/SingleMemoryFile;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MemoryFile {
    public static final String ENTRY_PREFIX = "- ";
    public static final String EXTENSION = ".jsonl";
    private static final Map<String, String> LEGACY_CATEGORY_MAP;
    public static final String PERMANENT_DATE = "permanent";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private static final l TIMESTAMP_PATTERN = new l("\\s*\\(timestamp:\\s*(\\d+)\\)\\s*$");
    private static final Json JSON = JsonKt.Json$default(null, new a(9), 1, null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010%R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/file/MemoryFile$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "normalizeCategory", "(Ljava/lang/String;)Ljava/lang/String;", "todayDate", "()Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "millis", "formatAsIso8601", "(J)Ljava/lang/String;", "iso8601", "parseIso8601ToMillis", "(Ljava/lang/String;)J", "content", "date", "generateEntryId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/text/SimpleDateFormat;", "DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "getDATE_FORMAT", "()Ljava/text/SimpleDateFormat;", "Lx5/l;", "TIMESTAMP_PATTERN", "Lx5/l;", "getTIMESTAMP_PATTERN", "()Lx5/l;", "Lkotlinx/serialization/json/Json;", "JSON", "Lkotlinx/serialization/json/Json;", "getJSON", "()Lkotlinx/serialization/json/Json;", "ENTRY_PREFIX", "Ljava/lang/String;", "EXTENSION", "PERMANENT_DATE", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "LEGACY_CATEGORY_MAP", "Ljava/util/Map;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ String generateEntryId$default(Companion companion, String str, String str2, String str3, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                str3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            return companion.generateEntryId(str, str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence generateEntryId$lambda$0(byte b9) {
            return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
        }

        public final String formatAsIso8601(long millis) {
            try {
                String string = Instant.ofEpochMilli(millis).toString();
                p.b(string);
                return string;
            } catch (Exception unused) {
                return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
        }

        public final String generateEntryId(String content, String category, String date) {
            p.e(content, "content");
            p.e(category, "category");
            p.e(date, "date");
            String str = category + ":" + date + ":" + content;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(x5.a.f6276a);
            p.d(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            p.b(bArrDigest);
            return n.Q1(16, c5.l.h0(bArrDigest, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, new a(10), 30));
        }

        public final SimpleDateFormat getDATE_FORMAT() {
            return MemoryFile.DATE_FORMAT;
        }

        public final Json getJSON() {
            return MemoryFile.JSON;
        }

        public final l getTIMESTAMP_PATTERN() {
            return MemoryFile.TIMESTAMP_PATTERN;
        }

        public final String normalizeCategory(String category) {
            p.e(category, "category");
            String str = (String) MemoryFile.LEGACY_CATEGORY_MAP.get(category);
            return str == null ? category : str;
        }

        public final long parseIso8601ToMillis(String iso8601) {
            p.e(iso8601, "iso8601");
            if (n.t1(iso8601)) {
                return System.currentTimeMillis();
            }
            try {
                return Instant.parse(iso8601).toEpochMilli();
            } catch (Exception unused) {
                return System.currentTimeMillis();
            }
        }

        public final String todayDate() {
            String str = getDATE_FORMAT().format(new Date());
            p.d(str, "format(...)");
            return str;
        }

        private Companion() {
        }
    }

    static {
        Map<String, String> mapSingletonMap = Collections.singletonMap("agent", "agent_identity");
        p.d(mapSingletonMap, "singletonMap(...)");
        LEGACY_CATEGORY_MAP = mapSingletonMap;
    }

    public /* synthetic */ MemoryFile(i iVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 JSON$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    public static /* synthetic */ g appendEntryWithMmr$default(MemoryFile memoryFile, CatchMemoryItem catchMemoryItem, double d, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendEntryWithMmr");
        }
        if ((i8 & 2) != 0) {
            d = 0.8d;
        }
        return memoryFile.appendEntryWithMmr(catchMemoryItem, d);
    }

    public abstract MemoryRecord appendEntry(CatchMemoryItem item);

    public abstract g appendEntryWithMmr(CatchMemoryItem item, double similarityThreshold);

    public final boolean checkDuplicate(String content, List<MemoryRecord> existingEntries, double similarityThreshold) {
        List listS;
        List listS2;
        p.e(content, "content");
        p.e(existingEntries, "existingEntries");
        String lowerCase = content.toLowerCase(Locale.ROOT);
        p.d(lowerCase, "toLowerCase(...)");
        Pattern patternCompile = Pattern.compile("\\s+");
        p.d(patternCompile, "compile(...)");
        n.E1(0);
        Matcher matcher = patternCompile.matcher(lowerCase);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(lowerCase.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(lowerCase.subSequence(iEnd, lowerCase.length()).toString());
            listS = arrayList;
        } else {
            listS = a.a.S(lowerCase.toString());
        }
        Set setR0 = m.R0(listS);
        Iterator<MemoryRecord> it = existingEntries.iterator();
        while (it.hasNext()) {
            String lowerCase2 = it.next().getContent().toLowerCase(Locale.ROOT);
            p.d(lowerCase2, "toLowerCase(...)");
            Pattern patternCompile2 = Pattern.compile("\\s+");
            p.d(patternCompile2, "compile(...)");
            n.E1(0);
            Matcher matcher2 = patternCompile2.matcher(lowerCase2);
            if (matcher2.find()) {
                ArrayList arrayList2 = new ArrayList(10);
                int iEnd2 = 0;
                do {
                    arrayList2.add(lowerCase2.subSequence(iEnd2, matcher2.start()).toString());
                    iEnd2 = matcher2.end();
                } while (matcher2.find());
                arrayList2.add(lowerCase2.subSequence(iEnd2, lowerCase2.length()).toString());
                listS2 = arrayList2;
            } else {
                listS2 = a.a.S(lowerCase2.toString());
            }
            Set setR02 = m.R0(listS2);
            LinkedHashSet linkedHashSetX0 = m.x0(setR0, setR02);
            Set setQ0 = m.Q0(setR0);
            m.p0(setQ0, setR02);
            if (!setQ0.isEmpty() && linkedHashSetX0.size() / setQ0.size() >= similarityThreshold) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsMemoryIndex(long memoryIndex) throws IOException {
        boolean z = false;
        if (!getFile().exists()) {
            return false;
        }
        File file = getFile();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), x5.a.f6276a), 8192);
        try {
            Iterator it = new w5.a(new k(2, bufferedReader)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String string = n.T1((String) it.next()).toString();
                if (string.length() != 0 && u.c1(string, "{", false)) {
                    try {
                        Json json = JSON;
                        json.getSerializersModule();
                        Long memoryIndex2 = ((CatchMemoryItem) json.decodeFromString(CatchMemoryItem.INSTANCE.serializer(), string)).getMemoryIndex();
                        if (memoryIndex2 != null && memoryIndex2.longValue() == memoryIndex) {
                            z = true;
                            break;
                        }
                    } catch (Exception unused) {
                        continue;
                    }
                }
            }
            bufferedReader.close();
            return z;
        } finally {
        }
    }

    public abstract String contentHash();

    public final void ensureDirectoryExists() {
        File parentFile = getFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
    }

    public abstract String getCategory();

    public abstract boolean getExists();

    public abstract File getFile();

    public abstract long getLastModified();

    public final MemoryRecord parseEntry(String line, String entryDate) {
        String str;
        Long lF1;
        p.e(line, "line");
        p.e(entryDate, "entryDate");
        String string = n.T1(n.B1(line, ENTRY_PREFIX)).toString();
        if (string.length() == 0) {
            return null;
        }
        l lVar = TIMESTAMP_PATTERN;
        j jVarB = l.b(lVar, string);
        long jCurrentTimeMillis = (jVarB == null || (str = (String) ((h) jVarB.a()).get(1)) == null || (lF1 = u.f1(str)) == null) ? System.currentTimeMillis() : lF1.longValue();
        String string2 = n.T1(lVar.f(string)).toString();
        if (string2.length() == 0) {
            return null;
        }
        return new MemoryRecord(INSTANCE.generateEntryId(string2, getCategory(), entryDate), string2, jCurrentTimeMillis, getCategory(), entryDate, 0.0d, null, null, 0L, null, 992, null);
    }

    public final MemoryRecord parseJsonEntry(String line, String entryDate) {
        p.e(line, "line");
        p.e(entryDate, "entryDate");
        String string = n.T1(line).toString();
        if (string.length() == 0 || !u.c1(string, "{", false)) {
            return null;
        }
        try {
            Json json = JSON;
            json.getSerializersModule();
            CatchMemoryItem catchMemoryItem = (CatchMemoryItem) json.decodeFromString(CatchMemoryItem.INSTANCE.serializer(), string);
            if (catchMemoryItem.getContent().length() == 0) {
                return null;
            }
            String strNormalizeState = EpisodicMemoryEvolutionState.INSTANCE.normalizeState(catchMemoryItem.getState());
            if (p.a(strNormalizeState, EpisodicMemoryEvolutionState.DEPRECATED)) {
                return null;
            }
            Companion companion = INSTANCE;
            long iso8601ToMillis = companion.parseIso8601ToMillis(catchMemoryItem.getCreateAt());
            Long memoryIndex = catchMemoryItem.getMemoryIndex();
            long jLongValue = memoryIndex != null ? memoryIndex.longValue() : 0L;
            return new MemoryRecord(jLongValue != 0 ? String.valueOf(jLongValue) : companion.generateEntryId(catchMemoryItem.getContent(), getCategory(), entryDate), catchMemoryItem.getContent(), iso8601ToMillis, getCategory(), entryDate, catchMemoryItem.getConfidence(), catchMemoryItem.getProfileType(), strNormalizeState, jLongValue, catchMemoryItem.getKeywords());
        } catch (Exception unused) {
            return null;
        }
    }

    public abstract List<MemoryRecord> readEntries();

    public abstract String readRawContent();

    private MemoryFile() {
    }
}
