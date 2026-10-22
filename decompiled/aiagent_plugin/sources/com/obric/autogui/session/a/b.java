package com.obric.autogui.session.a;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.f.k;
import d.h.b.h;
import d.h.b.o;
import d.n.j;
import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AOLocalJournalCleansingTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "LocJorCleanse/Task";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f30718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f30719c;

    /* JADX INFO: compiled from: AOLocalJournalCleansingTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class C0832b<T> implements Comparator {
        public C0832b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).lastModified()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin")).lastModified()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f30717a = new a(null);
    }

    public static /* synthetic */ boolean lambda$8lIUVb_Os8S6U3pTSvN8vVY9cnI(File r0) {
        return b(r0);
    }

    public b(long r2, File r4) {
        o.e(r4, "rootDir");
        this.f30718b = r2;
        this.f30719c = r4;
    }

    public final void a() {
        if (this.f30719c.exists() == true) goto L5;
    L42:
        Loog.INSTANCE.e(TAG, "[Dir] `" + this.f30719c + "` does not exist or is not a directory.");
        return;
    L5:
        if (this.f30719c.isDirectory() == false) goto L42;
        File[] r0 = this.f30719c.listFiles($$Lambda$b$8lIUVb_Os8S6U3pTSvN8vVY9cnI.INSTANCE);
        Integer r3 = null;
        if (r0 == null) goto L10;
        List r1 = i.c(r0, (Comparator) ZeusTransformUtils.preCheckCast(new C0832b(), Comparator.class, "com.obric.aiagent.plugin"));
    L11:
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L19:
        if (r6 == false) goto L21;
    L37:
        Loog r4 = Loog.INSTANCE;
        StringBuilder r13 = new StringBuilder().append("[Dir] `").append(this.f30719c).append("` not cleansed as journalDirs=");
        if (r1 == null) goto L40;
        r3 = Integer.valueOf(r1.size());
    L40:
        r4.d(TAG, r13.append(r3).append('.').toString());
        return;
    L21:
        if (r1.size() <= 1) goto L37;
        long r9 = a(this.f30719c);
        if (r9 > this.f30718b) goto L27;
        Loog.INSTANCE.d(TAG, "[Dir] `" + this.f30719c + "` contains less than " + this.f30718b + " bytes (" + r9 + ").");
        return;
    L27:
        Iterator r2 = r1.subList(0, r1.size() - 1).iterator();
    L29:
        if (r2.hasNext() == false) goto L50;
        File r7 = (File) ZeusTransformUtils.preCheckCast(r2.next(), File.class, "com.obric.aiagent.plugin");
        if (r9 <= this.f30718b) goto L32;
        o.a(r7);
        long r8 = a(r7);
        if (k.h(r7) == false) goto L29;
        r9 = r9 - r8;
        Loog.INSTANCE.d(TAG, " - [Del] deleted `" + r7 + "`; spared " + r8 + "/B; remaining " + r9 + '.');
        goto L29
    L32:
        Loog.INSTANCE.d(TAG, " - [Del] already meets the need with remaining=" + r9 + '.');
        return;
    L50:
        return;
    L14:
        if (r5.isEmpty() == true) goto L17;
        r6 = false;
        goto L19
    L10:
        r1 = null;
        goto L11
    }

    private static final boolean b(File r0) {
        return r0.isDirectory();
    }

    private final long a(File r6) {
        long r0 = 0;
        if (r6.exists() == true) goto L5;
    L11:
        return r0;
    L5:
        if (r6.isDirectory() == false) goto L11;
        Iterator r5 = ((j) ZeusTransformUtils.preCheckCast(k.d(r6), j.class, "com.obric.aiagent.plugin")).a();
    L9:
        if (r5.hasNext() == false) goto L11;
        r0 = r0 + ((File) ZeusTransformUtils.preCheckCast(r5.next(), File.class, "com.obric.aiagent.plugin")).length();
        goto L9
    }
}
