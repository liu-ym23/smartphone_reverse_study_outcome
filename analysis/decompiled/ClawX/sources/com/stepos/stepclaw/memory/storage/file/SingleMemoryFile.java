package com.stepos.stepclaw.memory.storage.file;

import a8.b;
import b5.g;
import c5.m;
import c5.o;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionIds;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import m0.f;
import m5.l;
import x5.a;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001d2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\tJ\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010$R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\tR\u001a\u0010'\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/file/SingleMemoryFile;", "Lcom/stepos/stepclaw/memory/storage/file/MemoryFile;", "Ljava/io/File;", "baseDir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "<init>", "(Ljava/io/File;Ljava/lang/String;)V", "contentHash", "()Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "readEntries", "()Ljava/util/List;", "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "item", "appendEntry", "(Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;)Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "entryId", "newState", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "updateEntryState", "(Ljava/lang/String;Ljava/lang/String;)Z", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memoryIndex", "updateEntryStateByMemoryIndex", "(JLjava/lang/String;)Z", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "similarityThreshold", "Lb5/g;", "appendEntryWithMmr", "(Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;D)Lb5/g;", "readRawContent", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "backfillMemoryIndex", "()I", "Ljava/io/File;", "Ljava/lang/String;", "getCategory", "file", "getFile", "()Ljava/io/File;", "getExists", "()Z", "exists", "getLastModified", "()J", "lastModified", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SingleMemoryFile extends MemoryFile {
    private final File baseDir;
    private final String category;
    private final File file;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleMemoryFile(File baseDir, String category) {
        super(null);
        p.e(baseDir, "baseDir");
        p.e(category, "category");
        this.baseDir = baseDir;
        this.category = category;
        this.file = new File(baseDir, f.d("stepmem/", getCategory(), MemoryFile.EXTENSION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence contentHash$lambda$0(byte b9) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public MemoryRecord appendEntry(CatchMemoryItem item) {
        p.e(item, "item");
        ensureDirectoryExists();
        MemoryRecord memoryRecordCopy$default = MemoryRecord.copy$default(item.toMemoryRecord(getCategory(), SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), null, null, 0L, null, MemoryFile.PERMANENT_DATE, 0.0d, null, null, 0L, null, 1007, null);
        l.w0(getFile(), b.n(item.toJsonString(), "\n"), a.f6276a);
        return memoryRecordCopy$default;
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public g appendEntryWithMmr(CatchMemoryItem item, double similarityThreshold) {
        p.e(item, "item");
        return checkDuplicate(item.getContent(), readEntries(), similarityThreshold) ? new g(Boolean.FALSE, null) : new g(Boolean.TRUE, appendEntry(item));
    }

    public final int backfillMemoryIndex() {
        if (!getFile().exists()) {
            return 0;
        }
        ArrayList arrayListD0 = l.D0(getFile());
        ArrayList arrayList = new ArrayList();
        int size = arrayListD0.size();
        int i8 = 0;
        int i9 = 0;
        while (i8 < size) {
            Object obj = arrayListD0.get(i8);
            i8++;
            String str = (String) obj;
            String string = n.T1(str).toString();
            if (string.length() != 0 && u.c1(string, "{", false)) {
                try {
                    Json json = MemoryFile.INSTANCE.getJSON();
                    json.getSerializersModule();
                    CatchMemoryItem catchMemoryItem = (CatchMemoryItem) json.decodeFromString(CatchMemoryItem.INSTANCE.serializer(), string);
                    if (catchMemoryItem.getMemoryIndex() == null) {
                        arrayList.add(CatchMemoryItem.copy$default(catchMemoryItem, null, 0.0d, null, null, null, Long.valueOf(OfflineEvolutionIds.INSTANCE.newMemoryIndexId()), null, 95, null).toJsonString());
                        i9++;
                    } else {
                        arrayList.add(str);
                    }
                } catch (Exception unused) {
                    arrayList.add(str);
                }
            } else {
                arrayList.add(str);
            }
        }
        if (i9 > 0) {
            l.G0(getFile(), m.A0(arrayList, "\n", null, null, null, 62) + "\n", a.f6276a);
        }
        return i9;
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public String contentHash() {
        if (!getFile().exists()) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(l.C0(getFile()));
        p.b(bArrDigest);
        return c5.l.h0(bArrDigest, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, new o3.a(11), 30);
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public String getCategory() {
        return this.category;
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public boolean getExists() {
        return getFile().exists();
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public File getFile() {
        return this.file;
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public long getLastModified() {
        if (getFile().exists()) {
            return getFile().lastModified();
        }
        return 0L;
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public List<MemoryRecord> readEntries() {
        if (!getFile().exists()) {
            return s.f1092a;
        }
        ArrayList arrayListD0 = l.D0(getFile());
        ArrayList arrayList = new ArrayList();
        int size = arrayListD0.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayListD0.get(i9);
            i9++;
            MemoryRecord jsonEntry = parseJsonEntry((String) obj, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            if (jsonEntry != null) {
                arrayList.add(jsonEntry);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.n0(arrayList, 10));
        int size2 = arrayList.size();
        while (i8 < size2) {
            Object obj2 = arrayList.get(i8);
            i8++;
            arrayList2.add(MemoryRecord.copy$default((MemoryRecord) obj2, null, null, 0L, null, MemoryFile.PERMANENT_DATE, 0.0d, null, null, 0L, null, 1007, null));
        }
        return arrayList2;
    }

    @Override // com.stepos.stepclaw.memory.storage.file.MemoryFile
    public String readRawContent() {
        return getFile().exists() ? l.E0(getFile(), a.f6276a) : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    }

    public final boolean updateEntryState(String entryId, String newState) throws IOException {
        String str;
        p.e(entryId, "entryId");
        String newState2 = newState;
        p.e(newState2, "newState");
        boolean z = false;
        if (!getFile().exists()) {
            return false;
        }
        ArrayList arrayListD0 = l.D0(getFile());
        ArrayList arrayList = new ArrayList();
        int size = arrayListD0.size();
        int i8 = 0;
        boolean z2 = false;
        while (i8 < size) {
            int i9 = i8 + 1;
            String str2 = (String) arrayListD0.get(i8);
            String string = n.T1(str2).toString();
            if (string.length() != 0 && u.c1(string, "{", z)) {
                try {
                    MemoryFile.Companion companion = MemoryFile.INSTANCE;
                    Json json = companion.getJSON();
                    json.getSerializersModule();
                    CatchMemoryItem catchMemoryItem = (CatchMemoryItem) json.decodeFromString(CatchMemoryItem.INSTANCE.serializer(), string);
                    String strGenerateEntryId = companion.generateEntryId(catchMemoryItem.getContent(), getCategory(), SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                    if (z2 || !p.a(strGenerateEntryId, entryId)) {
                        arrayList.add(str2);
                    } else {
                        str = str2;
                        try {
                            arrayList.add(CatchMemoryItem.copy$default(catchMemoryItem, null, 0.0d, null, null, newState2, null, null, 111, null).toJsonString());
                            z2 = true;
                        } catch (Exception unused) {
                            arrayList.add(str);
                            newState2 = newState;
                            i8 = i9;
                            z = false;
                        }
                    }
                } catch (Exception unused2) {
                    str = str2;
                }
            } else {
                arrayList.add(str2);
            }
            newState2 = newState;
            i8 = i9;
            z = false;
        }
        if (z2) {
            l.G0(getFile(), m.A0(arrayList, "\n", null, null, null, 62) + "\n", a.f6276a);
        }
        return z2;
    }

    public final boolean updateEntryStateByMemoryIndex(long memoryIndex, String newState) throws IOException {
        String str;
        Long memoryIndex2;
        String newState2 = newState;
        p.e(newState2, "newState");
        boolean z = false;
        if (!getFile().exists()) {
            return false;
        }
        ArrayList arrayListD0 = l.D0(getFile());
        ArrayList arrayList = new ArrayList();
        int size = arrayListD0.size();
        int i8 = 0;
        boolean z2 = false;
        while (i8 < size) {
            int i9 = i8 + 1;
            String str2 = (String) arrayListD0.get(i8);
            String string = n.T1(str2).toString();
            if (string.length() != 0 && u.c1(string, "{", z)) {
                try {
                    Json json = MemoryFile.INSTANCE.getJSON();
                    json.getSerializersModule();
                    CatchMemoryItem catchMemoryItem = (CatchMemoryItem) json.decodeFromString(CatchMemoryItem.INSTANCE.serializer(), string);
                    if (z2 || (memoryIndex2 = catchMemoryItem.getMemoryIndex()) == null || memoryIndex2.longValue() != memoryIndex) {
                        arrayList.add(str2);
                    } else {
                        str = str2;
                        try {
                            arrayList.add(CatchMemoryItem.copy$default(catchMemoryItem, null, 0.0d, null, null, newState2, null, null, 111, null).toJsonString());
                            z2 = true;
                        } catch (Exception unused) {
                            arrayList.add(str);
                            newState2 = newState;
                            i8 = i9;
                            z = false;
                        }
                    }
                } catch (Exception unused2) {
                    str = str2;
                }
            } else {
                arrayList.add(str2);
            }
            newState2 = newState;
            i8 = i9;
            z = false;
        }
        if (z2) {
            l.G0(getFile(), m.A0(arrayList, "\n", null, null, null, 62) + "\n", a.f6276a);
        }
        return z2;
    }
}
