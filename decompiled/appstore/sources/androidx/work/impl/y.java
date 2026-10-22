package androidx.work.impl;

import android.content.Context;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.j0;
import kotlin.collections.k0;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f5900a = null;

    static {
        f5900a = new y();
    }

    public y() {
    }

    public static final void d(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        y r11 = f5900a;
        if (r11.b(r10).exists() == false) goto L17;
        androidx.work.i.e().a(z.b(), "Migrating WorkDatabase to the no-backup directory");
        Iterator r12 = r11.e(r10).entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L23;
        Map.Entry r13 = (Map.Entry) r12.next();
        File r14 = (File) r13.getKey();
        File r15 = (File) r13.getValue();
        if (r14.exists() == false) goto L6;
        if (r15.exists() == false) goto L13;
        androidx.work.i.e().k(z.b(), "Over-writing contents of " + r15);
    L13:
        if (r14.renameTo(r15) == false) goto L15;
        String r16 = "Migrated " + r14 + "to " + r15;
    L16:
        androidx.work.i.e().a(z.b(), r16);
        goto L6
    L15:
        r16 = "Renaming " + r14 + " to " + r15 + " failed";
        goto L16
    L23:
        return;
    }

    public final File a(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        return c(r10);
    }

    public final File b(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        File r11 = r10.getDatabasePath("androidx.work.workdb");
        kotlin.jvm.internal.q.f(r11, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return r11;
    }

    public final File c(Context r10) {
        return new File(a.f5434a.a(r10), "androidx.work.workdb");
    }

    public final Map e(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        File r11 = b(r10);
        File r12 = a(r10);
        String[] r13 = z.a();
        LinkedHashMap r14 = new LinkedHashMap(bg.h.d(j0.e(r13.length), 16));
        int r15 = r13.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L6;
        String r17 = r13[r16];
        Pair r18 = kotlin.d.a(new File(r11.getPath() + r17), new File(r12.getPath() + r17));
        r14.put(r18.getFirst(), r18.getSecond());
        r16 = r16 + 1;
        goto L3
    L6:
        return k0.n(r14, kotlin.d.a(r11, r12));
    }
}
