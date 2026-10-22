package com.obric.aiagent.performance;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.f.c;
import d.n;
import d.o;
import d.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: MemoryUploadFileHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18747a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.performance.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MemoryUploadFileHelper.kt */
    @f(b = "MemoryUploadFileHelper.kt", c = {39}, d = "collectRecentAlogFiles", e = "com.obric.aiagent.performance.MemoryUploadFileHelper")
    static final class C0393a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f18748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f18749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f18751d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18752e;

        C0393a(a r3, d.c.d<? super C0393a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18751d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f18750c = r4;
            this.f18752e |= Integer.MIN_VALUE;
            return this.f18751d.a(0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).getName(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin")).getName(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f18747a = new a();
    }

    private a() {
    }

    public final Object a(long r10, ThresholdItemConfig r12, d.c.d<? super List<? extends File>> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, C0393a.class) == false) goto L7;
        C0393a r0 = (C0393a) ZeusTransformUtils.preCheckCast(r14, C0393a.class, "com.obric.aiagent.plugin");
        if ((r0.f18752e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18752e -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f18750c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f18752e;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        long r9 = r0.f18749b;
        long r11 = r0.f18748a;
        o.a(r15);     // Catch: Throwable -> L14
    L27:
        long r4 = 1000;
        List<String> r16 = com.ss.android.agilelogger.a.a(r9 / r4, r11 / r4);     // Catch: Throwable -> L14
        d.h.b.o.c(r16, "getALogFiles(...)");     // Catch: Throwable -> L14
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r17, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Iterator r19 = r17.iterator();     // Catch: Throwable -> L14
    L30:
        if (r19.hasNext() == false) goto L32;
        r18.add(new File((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L14
        goto L30
    L32:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        HashSet r110 = new HashSet();     // Catch: Throwable -> L14
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r21 = r20.iterator();     // Catch: Throwable -> L14
    L34:
        if (r21.hasNext() == false) goto L38;
        Object r1 = r21.next();     // Catch: Throwable -> L14
        if (r110.add(((File) ZeusTransformUtils.preCheckCast(r1, File.class, "com.obric.aiagent.plugin")).getAbsolutePath()) == false) goto L34;
        r111.add(r1);     // Catch: Throwable -> L14
        goto L34
    L38:
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L14
    L40:
        if (r23.hasNext() == false) goto L49;
        Object r113 = r23.next();     // Catch: Throwable -> L14
        File r5 = (File) ZeusTransformUtils.preCheckCast(r113, File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r5.exists() == true) goto L44;
    L46:
        boolean r6 = false;
    L47:
        if (r6 == false) goto L40;
        r112.add(r113);     // Catch: Throwable -> L14
        goto L40
    L44:
        if (r5.isFile() == false) goto L46;
        r6 = true;
        goto L47
    L49:
        Object r24 = n.f(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L14
    L53:
        Throwable r114 = n.c(r24);
        if (r114 == null) goto L56;
        ILogDepend.Companion.e(MemoryReportServiceImpl.TAG, "collectRecentAlogFiles failed, endTimeMs=" + r11, r114);
    L56:
        List r115 = p.b();
        if (n.b(r24) == true) goto L59;
        return r24;
    L59:
        return r115;
    L14:
        th = th;
        r10 = r11;
    L52:
        n.a r116 = n.f38560a;
        r24 = n.f(o.a(th));
        r11 = r10;
        goto L53
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        o.a(r15);
        if (r12.getEnableAlog() == false) goto L21;
        long r117 = d.l.n.a(r10 - d.l.n.a(r12.getRecentAlogMs(), 0), 0);
        n.a r7 = n.f38560a;     // Catch: Throwable -> L51
        a r25 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        com.ss.android.agilelogger.a.c();     // Catch: Throwable -> L51
        r0.f18748a = r10;     // Catch: Throwable -> L51
        r0.f18749b = r117;     // Catch: Throwable -> L51
        r0.f18752e = 1;     // Catch: Throwable -> L51
        if (ax.a(1000, r0) != r2) goto L26;
        return r2;
    L26:
        r9 = r117;
        r11 = r10;
    L51:
        th = th;
        goto L52
    L21:
        return p.b();
    L7:
        r0 = new C0393a(this, r14);
        goto L8
    }

    public final int a(ZipOutputStream r11, List<? extends File> r12, ThresholdItemConfig r13) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "output");
        d.h.b.o.e(r10, "alogFiles");
        d.h.b.o.e(r13, "config");
        if (r13.getEnableAlog() == true) goto L6;
        return 0;
    L6:
        if (r10.isEmpty() == false) goto L9;
        ILogDepend.Companion.i(MemoryReportServiceImpl.TAG, "appendAlog skipped, no recent alog files");
        return 0;
    L9:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r2 = 0;
    L11:
        if (r14.hasNext() == false) goto L40;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r14.next(), File.class, "com.obric.aiagent.plugin");
        String r4 = "alog/" + r3.getName();
        n.a r5 = n.f38560a;     // Catch: Throwable -> L30
        r11.putNextEntry(new ZipEntry(r4));     // Catch: Throwable -> L30
        InputStream r6 = (InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r6, BufferedInputStream.class) == false) goto L16;
        BufferedInputStream r7 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r6, BufferedInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
    L17:
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        d.f.b.a((InputStream) ZeusTransformUtils.preCheckCast((BufferedInputStream) ZeusTransformUtils.preCheckCast(r8, BufferedInputStream.class, "com.obric.aiagent.plugin"), InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r11, OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L25
        c.a(r8, null);     // Catch: Throwable -> L30
        r11.closeEntry();     // Catch: Throwable -> L30
        int r9 = r2 + 1;
        Object r15 = n.f(Integer.valueOf(r2));     // Catch: Throwable -> L23
    L32:
        Throwable r16 = n.c(r15);
        if (r16 == null) goto L39;
        n.a r17 = n.f38560a;     // Catch: Throwable -> L36
        r11.closeEntry();     // Catch: Throwable -> L36
        n.f(x.f38692a);     // Catch: Throwable -> L36
    L38:
        ILogDepend.Companion.e(MemoryReportServiceImpl.TAG, "appendAlog failed, path=" + r3.getAbsolutePath(), r16);
    L36:
        th = move-exception;
        n.a r18 = n.f38560a;
        n.f(o.a(th));
    L39:
        r2 = r9;
    L23:
        th = move-exception;
        th = th;
        r2 = r9;
    L31:
        n.a r19 = n.f38560a;
        Object r20 = n.f(o.a(th));
        r9 = r2;
        r15 = r20;
        goto L32
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        c.a(r8, th);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L16:
        r7 = new BufferedInputStream(r6, 8192);     // Catch: Throwable -> L30
    L30:
        th = th;
        goto L31
    L40:
        ILogDepend.Companion.i(MemoryReportServiceImpl.TAG, "appendAlog finished, count=" + r2 + ", total=" + r10.size());
        return r2;
    }

    public final String a(long r10) {
        Debug.MemoryInfo r9 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r9);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Map<String, String> r0 = r9.getMemoryStats();
        d.h.b.o.c(r0, "getMemoryStats(...)");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(ao.b(r0), Map.class, "com.obric.aiagent.plugin");
    L6:
        Runtime r2 = Runtime.getRuntime();
        StringBuilder r3 = new StringBuilder();
        StringBuilder r11 = r3.append("Uptime=" + f18747a.b(r10));
        d.h.b.o.c(r11, "append(...)");
        d.h.b.o.c(r11.append('\n'), "append(...)");
        StringBuilder r12 = r3.append("** MEMINFO in pid " + Process.myPid() + " [" + IRuntimeContext.Companion.getProcessName() + "] **");
        d.h.b.o.c(r12, "append(...)");
        d.h.b.o.c(r12.append('\n'), "append(...)");
        StringBuilder r13 = r3.append("total_pss=" + r9.getTotalPss());
        d.h.b.o.c(r13, "append(...)");
        d.h.b.o.c(r13.append('\n'), "append(...)");
        StringBuilder r14 = r3.append("dalvik_pss=" + r9.dalvikPss);
        d.h.b.o.c(r14, "append(...)");
        d.h.b.o.c(r14.append('\n'), "append(...)");
        StringBuilder r15 = r3.append("native_pss=" + r9.nativePss);
        d.h.b.o.c(r15, "append(...)");
        d.h.b.o.c(r15.append('\n'), "append(...)");
        StringBuilder r16 = r3.append("other_pss=" + r9.otherPss);
        d.h.b.o.c(r16, "append(...)");
        d.h.b.o.c(r16.append('\n'), "append(...)");
        StringBuilder r17 = r3.append("total_private_dirty=" + r9.getTotalPrivateDirty());
        d.h.b.o.c(r17, "append(...)");
        d.h.b.o.c(r17.append('\n'), "append(...)");
        StringBuilder r18 = r3.append("total_shared_dirty=" + r9.getTotalSharedDirty());
        d.h.b.o.c(r18, "append(...)");
        d.h.b.o.c(r18.append('\n'), "append(...)");
        StringBuilder r19 = r3.append("total_swappable_pss=" + r9.getTotalSwappablePss());
        d.h.b.o.c(r19, "append(...)");
        d.h.b.o.c(r19.append('\n'), "append(...)");
        StringBuilder r20 = r3.append("native_heap_allocated=" + Debug.getNativeHeapAllocatedSize());
        d.h.b.o.c(r20, "append(...)");
        d.h.b.o.c(r20.append('\n'), "append(...)");
        StringBuilder r21 = r3.append("java_heap_used=" + (r2.totalMemory() - r2.freeMemory()));
        d.h.b.o.c(r21, "append(...)");
        d.h.b.o.c(r21.append('\n'), "append(...)");
        StringBuilder r22 = r3.append("java_heap_total=" + r2.totalMemory());
        d.h.b.o.c(r22, "append(...)");
        d.h.b.o.c(r22.append('\n'), "append(...)");
        StringBuilder r23 = r3.append("java_heap_max=" + r2.maxMemory());
        d.h.b.o.c(r23, "append(...)");
        d.h.b.o.c(r23.append('\n'), "append(...)");
        if ((!r1.isEmpty()) == false) goto L12;
        StringBuilder r24 = r3.append("memory_stats=");
        d.h.b.o.c(r24, "append(...)");
        d.h.b.o.c(r24.append('\n'), "append(...)");
        Iterator r25 = r1.entrySet().iterator();
    L10:
        if (r25.hasNext() == false) goto L12;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r25.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        StringBuilder r111 = r3.append("    " + ((String) ZeusTransformUtils.preCheckCast(r110.getKey(), String.class, "com.obric.aiagent.plugin")) + '=' + ((String) ZeusTransformUtils.preCheckCast(r110.getValue(), String.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r111, "append(...)");
        d.h.b.o.c(r111.append('\n'), "append(...)");
    L12:
        String r26 = r3.toString();
        d.h.b.o.c(r26, "toString(...)");
        return r26;
    L5:
        r1 = ao.b();
        goto L6
    }

    public final String b(long r5) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = n.f(new SimpleDateFormat("yyyyMMdd.HHmmss", Locale.getDefault()).format(new Date(r5)));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r6);
        if (r2 == null) goto L12;
        ILogDepend.Companion.e(MemoryReportServiceImpl.TAG, "formatFileTime error, timestamp=" + r5, r2);
        r6 = String.valueOf(r5);
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L7
    }

    public final String a() {
        IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        String r3 = r2.getFlowDid();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r4) == false) goto L12;
        r4 = ITraceDepend.Companion.getDeviceId();
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L5:
        r3 = null;
        goto L6
    }
}
