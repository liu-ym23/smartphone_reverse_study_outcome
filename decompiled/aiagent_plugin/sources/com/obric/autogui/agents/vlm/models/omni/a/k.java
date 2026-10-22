package com.obric.autogui.agents.vlm.models.omni.a;

import com.obric.autogui.agents.vlm.models.omni.a.h;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DataFeedbackUploadStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public class k<R extends h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<R> f28183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<File> f28185c;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin")).d()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f28186a;

        public b(Comparator r3) {
            this.f28186a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r2 = this.f28186a.compare(r3, r4);
            if (r2 != 0) goto L15;
            int r5 = ((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin")).c();
            if (r5 != null) goto L9;
            r5 = Integer.MAX_VALUE;
        L9:
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.aiagent.plugin");
            Integer r7 = ((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin")).c();
            if (r7 == null) goto L12;
            Object r8 = ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.aiagent.plugin");
        L14:
            return d.b.a.a(r6, (Comparable) r8);
        L12:
            r8 = ZeusTransformUtils.preCheckCast(Integer.MAX_VALUE, Comparable.class, "com.obric.aiagent.plugin");
            goto L14
        L15:
            return r2;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f28187a;

        public c(Comparator r3) {
            this.f28187a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f28187a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin")).a().getName(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin")).a().getName(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ h lambda$FcRDDYLYW2B8oCBV1hYKm9Vffgs(k r0, File r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$M-rSwIZ5F-W-QXO7Xlw5q7mK3RU, reason: not valid java name */
    public static /* synthetic */ boolean m772lambda$MrSwIZ5FWQXO7Xlw5q7mK3RU(File r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$imMzw2aHXIKW8n9YzBDuc51Vrj4(k r0, File r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.n.j lambda$sezUVWXnkJCc2NExy8AHrzXq_QE(File r0) {
        return a(r0);
    }

    public k(g<R> r3, String r4, d.h.a.a<? extends File> r5) {
        d.h.a.a<File> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "fileName");
        o.e(r4, "tag");
        o.e(r6, "journalRootProvider");
        this.f28183a = r3;
        this.f28184b = r4;
        this.f28185c = r6;
    }

    public final List<R> a() {
        File r0 = (File) ZeusTransformUtils.preCheckCast(this.f28185c.invoke(), File.class, "com.obric.aiagent.plugin");
        if (r0.exists() == false) goto L18;
        if (r0.isDirectory() == false) goto L18;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L9
        final k r2 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Object r3 = d.n.f(d.n.m.g(d.n.m.a(d.n.m.e(d.n.m.a(d.n.m.c(d.n.m.a((d.n.j) ZeusTransformUtils.preCheckCast(d.f.k.d(r0), d.n.j.class, "com.obric.aiagent.plugin"), new $$Lambda$k$imMzw2aHXIKW8n9YzBDuc51Vrj4(r2)), $$Lambda$k$sezUVWXnkJCc2NExy8AHrzXq_QE.INSTANCE), $$Lambda$k$MrSwIZ5FWQXO7Xlw5q7mK3RU.INSTANCE), new $$Lambda$k$FcRDDYLYW2B8oCBV1hYKm9Vffgs(r2)), (Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new b((Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L9
    L11:
        Throwable r4 = d.n.c(r3);
        if (r4 == null) goto L16;
        OmniDataFeedbackLog.INSTANCE.e(this.f28184b, "list upload data failed, dirType=" + this.f28183a.a(), r4);
        r3 = p.b();
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L9:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
    L18:
        return p.b();
    }

    private static final boolean a(k r1, File r2) {
        o.e(r2, "it");
        if (r2.isDirectory() == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r2.getName(), r1.f28183a.a()) == false) goto L7;
        return true;
    }

    private static final d.n.j a(File r1) {
        o.e(r1, "dir");
        File[] r2 = r1.listFiles();
        if (r2 == null) goto L5;
        d.n.j r3 = d.a.i.k(r2);
    L6:
        if (r3 == null) goto L8;
        return r3;
    L8:
        return d.n.m.a();
    L5:
        r3 = null;
        goto L6
    }

    private static final boolean b(File r0) {
        return r0.isFile();
    }

    private static final h b(k r0, File r1) {
        g<R> r2 = r0.f28183a;
        o.a(r1);
        return r2.b(r1);
    }

    public final List<R> a(String r5) {
        o.e(r5, DBDefinition.TASK_ID);
        String r6 = this.f28183a.a(r5);
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r2 = r7.next();
        if (o.a(((h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin")).b(), r6) == false) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public final void a(R r10) {
        h r11 = (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.aiagent.plugin");
        o.e(r11, "record");
        File r12 = r11.a().getParentFile();
        if (r12 == null) goto L64;
        d.n.j r3 = null;
        if (o.a(r12.getName(), this.f28183a.a()) == true) goto L8;
        r12 = null;
    L8:
        if (r12 != null) goto L55;
        return;
    L55:
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L30
        k r6 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        File[] r7 = r12.listFiles();     // Catch: Throwable -> L30
        if (r7 == null) goto L14;
        r3 = d.a.i.k(r7);     // Catch: Throwable -> L30
    L14:
        if (r3 != null) goto L16;
        r3 = d.n.m.a();     // Catch: Throwable -> L30
    L16:
        Iterator r4 = r3.a();     // Catch: Throwable -> L30
    L18:
        if (r4.hasNext() == false) goto L27;
        File r8 = (File) ZeusTransformUtils.preCheckCast(r4.next(), File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (r8.isFile() == false) goto L24;
        g<R> r9 = r6.f28183a;     // Catch: Throwable -> L30
        o.a(r8);     // Catch: Throwable -> L30
        if (r9.b(r8) == null) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L18;
        boolean r14 = true;
    L28:
        Object r15 = d.n.f(Boolean.valueOf(r14));     // Catch: Throwable -> L30
    L32:
        Throwable r16 = d.n.c(r15);
        if (r16 == null) goto L37;
        OmniDataFeedbackLog.INSTANCE.e(this.f28184b, "scan drained upload dir failed, dirType=" + this.f28183a.a(), r16);
        r15 = true;
    L37:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L57;
        return;
    L57:
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L41
        k r0 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        Object r18 = d.n.f(Boolean.valueOf(d.f.k.h(r12)));     // Catch: Throwable -> L41
    L44:
        if (d.n.b(r18) == false) goto L47;
        r18 = false;
    L47:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r18, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L51;
        OmniDataFeedbackLog r19 = OmniDataFeedbackLog.INSTANCE;
        String r1 = this.f28184b;
        if (r19.isVerboseLogEnabled() == false) goto L65;
        Loog.INSTANCE.i(r1, "delete drained upload dir, dirType=" + this.f28183a.a());
        return;
    L65:
        return;
    L51:
        OmniDataFeedbackLog r110 = OmniDataFeedbackLog.INSTANCE;
        String r2 = this.f28184b;
        if (r110.isVerboseLogEnabled() == false) goto L67;
        Loog.INSTANCE.w(r2, "delete drained upload dir failed, dirType=" + this.f28183a.a());
        return;
    L67:
        return;
    L41:
        th = move-exception;
        d.n.a r20 = d.n.f38560a;
        r18 = d.n.f(d.o.a(th));
    L24:
        r13 = false;
        goto L25
    L27:
        r14 = false;
    L30:
        th = move-exception;
        d.n.a r21 = d.n.f38560a;
        r15 = d.n.f(d.o.a(th));
        goto L32
    }
}
