package com.stepos.stepclaw.memory.storage.file;

import c5.m;
import c5.o;
import c5.s;
import c5.u;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.storage.MemoryStorage;
import e5.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0006J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u000b\u001a\u00020\u0006J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0015J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "baseDir", "Ljava/io/File;", "singleFileCategories", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/io/File;Ljava/util/Set;)V", "isSingleFileCategory", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "getSingleFile", "Lcom/stepos/stepclaw/memory/storage/file/SingleMemoryFile;", "getDailyFile", "Lcom/stepos/stepclaw/memory/storage/file/DailyMemoryFile;", "date", "getTodayFile", "getFile", "Lcom/stepos/stepclaw/memory/storage/file/MemoryFile;", "listCategories", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "listDates", "listSingleFiles", "listDailyFilesByDateRange", "dateFrom", "dateTo", "categories", "listAllFiles", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryFileManager {
    private final File baseDir;
    private final Set<String> singleFileCategories;

    public MemoryFileManager(File baseDir, Set<String> singleFileCategories) {
        p.e(baseDir, "baseDir");
        p.e(singleFileCategories, "singleFileCategories");
        this.baseDir = baseDir;
        this.singleFileCategories = singleFileCategories;
    }

    public static /* synthetic */ MemoryFile getFile$default(MemoryFileManager memoryFileManager, String str, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        return memoryFileManager.getFile(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List listDailyFilesByDateRange$default(MemoryFileManager memoryFileManager, String str, String str2, Set set, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = null;
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        if ((i8 & 4) != 0) {
            set = u.f1094a;
        }
        return memoryFileManager.listDailyFilesByDateRange(str, str2, set);
    }

    public final DailyMemoryFile getDailyFile(String category, String date) {
        p.e(category, "category");
        p.e(date, "date");
        return new DailyMemoryFile(this.baseDir, category, date);
    }

    public final MemoryFile getFile(String category, String date) {
        p.e(category, "category");
        if (isSingleFileCategory(category)) {
            return getSingleFile(category);
        }
        if (date == null) {
            date = MemoryFile.INSTANCE.todayDate();
        }
        return getDailyFile(category, date);
    }

    public final SingleMemoryFile getSingleFile(String category) {
        p.e(category, "category");
        return new SingleMemoryFile(this.baseDir, category);
    }

    public final DailyMemoryFile getTodayFile(String category) {
        p.e(category, "category");
        return getDailyFile(category, MemoryFile.INSTANCE.todayDate());
    }

    public final boolean isSingleFileCategory(String category) {
        p.e(category, "category");
        return this.singleFileCategories.contains(category);
    }

    public final List<MemoryFile> listAllFiles() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listSingleFiles());
        arrayList.addAll(listDailyFilesByDateRange$default(this, null, null, null, 7, null));
        return arrayList;
    }

    public final List<String> listCategories() {
        File file = new File(this.baseDir, "stepmem");
        if (!file.exists()) {
            return s.f1092a;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        File[] fileArrListFiles = file.listFiles();
        int i8 = 0;
        if (fileArrListFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory() && !p.a(file2.getName(), "index")) {
                    arrayList.add(file2);
                }
            }
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                String name = ((File) obj).getName();
                p.d(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        File[] fileArrListFiles2 = file.listFiles();
        if (fileArrListFiles2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (File file3 : fileArrListFiles2) {
                if (file3.isFile()) {
                    String name2 = file3.getName();
                    p.d(name2, "getName(...)");
                    if (x5.u.V0(name2, MemoryFile.EXTENSION, false)) {
                        arrayList2.add(file3);
                    }
                }
            }
            int size2 = arrayList2.size();
            while (i8 < size2) {
                Object obj2 = arrayList2.get(i8);
                i8++;
                File file4 = (File) obj2;
                p.b(file4);
                linkedHashSet.add(l.A0(file4));
            }
        }
        return m.N0(linkedHashSet);
    }

    public final List<DailyMemoryFile> listDailyFilesByDateRange(String dateFrom, String dateTo, Set<String> categories) {
        p.e(categories, "categories");
        List<String> listListCategories = categories.isEmpty() ? listCategories() : m.N0(categories);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListCategories) {
            if (!isSingleFileCategory((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj2 = arrayList.get(i8);
            i8++;
            String str = (String) obj2;
            List<String> listListDates = listDates(str);
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : listListDates) {
                String str2 = (String) obj3;
                if (dateFrom == null || str2.compareTo(dateFrom) >= 0) {
                    if (dateTo == null || str2.compareTo(dateTo) <= 0) {
                        arrayList3.add(obj3);
                    }
                }
            }
            int size2 = arrayList3.size();
            int i9 = 0;
            while (i9 < size2) {
                Object obj4 = arrayList3.get(i9);
                i9++;
                arrayList2.add(getDailyFile(str, (String) obj4));
            }
        }
        return arrayList2;
    }

    public final List<String> listDates(String category) {
        File[] fileArrListFiles;
        p.e(category, "category");
        if (!isSingleFileCategory(category)) {
            File file = new File(this.baseDir, "stepmem/".concat(category));
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                ArrayList arrayList = new ArrayList();
                int i8 = 0;
                for (File file2 : fileArrListFiles) {
                    if (file2.isFile()) {
                        String name = file2.getName();
                        p.d(name, "getName(...)");
                        if (x5.u.V0(name, MemoryFile.EXTENSION, false)) {
                            arrayList.add(file2);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList(o.n0(arrayList, 10));
                int size = arrayList.size();
                while (i8 < size) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    File file3 = (File) obj;
                    p.b(file3);
                    arrayList2.add(l.A0(file3));
                }
                return m.J0(arrayList2, a.f2367c);
            }
        }
        return s.f1092a;
    }

    public final List<SingleMemoryFile> listSingleFiles() {
        Set<String> set = this.singleFileCategories;
        ArrayList arrayList = new ArrayList(o.n0(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(getSingleFile((String) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            if (((SingleMemoryFile) obj).getExists()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public /* synthetic */ MemoryFileManager(File file, Set set, int i8, i iVar) {
        this(file, (i8 & 2) != 0 ? MemoryStorage.INSTANCE.getPERMANENT_CATEGORIES() : set);
    }
}
