package u9;

import android.content.Context;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    public static /* synthetic */ class a {
    }

    public static final class b implements Comparator {
        public b() {
        }

        public int a(File r10, File r11) {
            return b(r10.lastModified(), r11.lastModified());
        }

        public final int b(long r10, long r11) {
            if (r10 >= r11) goto L5;
            return -1;
        L5:
            if (r10 != r11) goto L7;
            return 0;
        L7:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((File) r10, (File) r11);
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public static long a(File r10) {
        if (r10.isDirectory() == false) goto L9;
        File[] r11 = r10.listFiles();
        int r12 = r11.length;
        long r13 = 0;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L7;
        r13 = r13 + r11[r14].length();
        r14 = r14 + 1;
        goto L5
    L7:
        return r13;
    L9:
        return r10.length();
    }

    public static long b(List r10) {
        Iterator r11 = r10.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + a((File) r11.next());
        goto L4
    L6:
        return r12;
    }

    public static boolean c(File r10) {
        if (r10.isDirectory() == false) goto L13;
        File[] r11 = r10.listFiles();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        if (r11[r13].delete() == false) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        return false;
    L11:
        return r10.delete();
    L13:
        return r10.delete();
    }

    public static List d(File r10) {
        LinkedList r11 = new LinkedList();
        File[] r12 = r10.listFiles();
        if (r12 == null) goto L6;
        List r13 = Arrays.asList(r12);
        Collections.sort(r13, new b(null));
        return r13;
    L6:
        return r11;
    }

    public static File e(Context r10) {
        return new File(r10.getExternalCacheDir(), ".local");
    }
}
