package R1;

import B0.f;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class b {
    public static final ConcurrentHashMap d = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1141a = new HashMap();
    public volatile File b;
    public f c;

    public static long a(File file) {
        File[] fileArrListFiles = file.listFiles();
        long jA = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            jA = (file2.isDirectory() ? a(file2) : file2.length()) + jA;
        }
        return jA;
    }

    public static b b(String str) {
        ConcurrentHashMap concurrentHashMap = d;
        b bVar = (b) concurrentHashMap.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        concurrentHashMap.put(str, bVar2);
        return bVar2;
    }
}
