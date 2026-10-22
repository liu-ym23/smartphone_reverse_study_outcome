package com.obric.aiagent.skill.ovirt.impl.a;

import com.obric.aiagent.skill.manager.api.af;
import com.obric.aiagent.skill.manager.api.ag;
import com.obric.aiagent.skill.manager.api.ah;
import com.obric.aiagent.skill.manager.api.ai;
import com.obric.aiagent.skill.virt.api.j;
import com.obric.aiagent.skill.virt.api.x;
import com.obric.aiagent.skill.virt.api.y;
import com.obric.aiagent.skill.virt.api.z;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.h.a.s;
import d.h.b.h;
import d.h.b.o;
import d.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FilesystemCleaner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0442a f21094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ai f21095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s<x, String, Long, String, d.c.d<? super z>, Object> f21096c;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FilesystemCleaner.kt */
    private static final class C0442a {
        public /* synthetic */ C0442a(h r1) {
            this();
        }

        private C0442a() {
        }
    }

    /* JADX INFO: compiled from: FilesystemCleaner.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x f21097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x f21098b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f21097a, r6.f21097a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f21098b, r6.f21098b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f21097a.hashCode() * 31) + this.f21098b.hashCode();
        }

        public String toString() {
            return "ResolvedTarget(absolutePath=" + this.f21097a + ", workDir=" + this.f21098b + ')';
        }

        public b(x r3, x r4) {
            x r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.aiagent.plugin");
            x r6 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.aiagent.plugin");
            o.e(r5, "absolutePath");
            o.e(r6, "workDir");
            this.f21097a = r5;
            this.f21098b = r6;
        }

        public final x a() {
            return this.f21097a;
        }

        public final x b() {
            return this.f21098b;
        }
    }

    /* JADX INFO: compiled from: FilesystemCleaner.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21099a = null;

        static {
            int[] r0 = new int[ag.values().length];
            r0[ag.f19170a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ag.f19171b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f21099a = r0;
        }
    }

    /* JADX INFO: compiled from: FilesystemCleaner.kt */
    @f(b = "FilesystemCleaner.kt", c = {30, 34, 38}, d = "clean", e = "com.obric.aiagent.skill.ovirt.impl.cleanup.FilesystemCleaner")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21103d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21104e;
        Object f;
        Object g;
        long h;
        /* synthetic */ Object i;
        final /* synthetic */ a j;
        int k;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.i = r3;
            this.k |= Integer.MIN_VALUE;
            return this.j.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FilesystemCleaner.kt */
    @f(b = "FilesystemCleaner.kt", c = {148}, d = "runResolvedTarget", e = "com.obric.aiagent.skill.ovirt.impl.cleanup.FilesystemCleaner")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f21108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21109e;
        final /* synthetic */ a f;
        int g;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f21109e = r7;
            this.g |= Integer.MIN_VALUE;
            return a.a(this.f, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f21094a = new C0442a(null);
    }

    public static /* synthetic */ CharSequence lambda$3hI5G0rBlvUM1eMGv8W6mZbr02k(String r0) {
        return a(r0);
    }

    public a(ai r3, s<? super x, ? super String, ? super Long, ? super String, ? super d.c.d<? super z>, ? extends Object> r4) {
        s<x, String, Long, String, d.c.d<? super z>, Object> r5 = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.aiagent.plugin");
        o.e(r3, "settings");
        o.e(r5, "executeSyncShell");
        this.f21095b = r3;
        this.f21096c = r5;
    }

    public static final /* synthetic */ Object a(a r6, String r7, String r8, b r9, String r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0176 -> B:25:0x017b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0228 -> B:42:0x022b). Please report as a decompilation issue!!! */
    public final Object a(String r26, y r27, d.c.d<? super Boolean> r28) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if ((r3.k & Integer.MIN_VALUE) == 0) goto L7;
        r3.k -= Integer.MIN_VALUE;
        a r4 = this;
    L8:
        Object r2 = r3.i;
        Object r5 = d.c.a.b.a();
        int r6 = r3.k;
        boolean r10 = true;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        long r11 = r3.h;
        ah r7 = (ah) ZeusTransformUtils.preCheckCast(r3.g, ah.class, "com.obric.aiagent.plugin");
        Iterator<ah> r8 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f, Iterator.class, "com.obric.aiagent.plugin");
        List<ah> r9 = (List) ZeusTransformUtils.preCheckCast(r3.f21104e, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.preCheckCast(r3.f21103d, List.class, "com.obric.aiagent.plugin");
        y r14 = (y) ZeusTransformUtils.preCheckCast(r3.f21102c, y.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.f21101b, String.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.f21100a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        Object r15 = r2;
    L43:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L38;
        ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).add(r0.a(r7) + "=cleanup failed");
    L38:
        if (r8.hasNext() == false) goto L45;
        r7 = (ah) ZeusTransformUtils.preCheckCast(r8.next(), ah.class, "com.obric.aiagent.plugin");
        r3.f21100a = r0;
        r3.f21101b = r12;
        r3.f21102c = r14;
        r3.f21103d = r13;
        r3.f21104e = r9;
        r3.f = r8;
        r3.g = r7;
        r3.h = r11;
        r3.k = 3;
        r15 = r0.a(r12, r14, r7, r3);
        if (r15 != r5) goto L43;
        return r5;
    L45:
        long r16 = System.currentTimeMillis() - r11;
        int r17 = (r9.size() + 1) + r0.f21095b.a().size();
        if (r13.isEmpty() == false) goto L48;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge/ConfigFs", "run: ok rules=" + r17 + " durationMs=" + r16, "run: ok uniqueId=" + r12 + " rules=" + r17 + " durationMs=" + r16);
    L50:
        return d.c.b.a.b.a(r10);
    L48:
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("SkRt/Purge/ConfigFs", "run: fail durationMs=" + r16 + " failureCount=" + r13.size(), "run: fail uniqueId=" + r12 + " durationMs=" + r16 + " failures=" + p.a((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("; ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        r10 = false;
        goto L50
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r18 = r3.h;
        List<ah> r19 = (List) ZeusTransformUtils.preCheckCast(r3.f21104e, List.class, "com.obric.aiagent.plugin");
        List r20 = (List) ZeusTransformUtils.preCheckCast(r3.f21103d, List.class, "com.obric.aiagent.plugin");
        y r110 = (y) ZeusTransformUtils.preCheckCast(r3.f21102c, y.class, "com.obric.aiagent.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(r3.f21101b, String.class, "com.obric.aiagent.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r3.f21100a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L34:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L36;
        ((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin")).add("mandatory-tmp-root=cleanup failed");
    L36:
        r13 = r20;
        r14 = r110;
        r8 = r0.f21095b.a().iterator();
        long r23 = r18;
        r9 = r19;
        r12 = r111;
        r11 = r23;
        goto L38
    L17:
        long r112 = r3.h;
        ah r21 = (ah) ZeusTransformUtils.preCheckCast(r3.g, ah.class, "com.obric.aiagent.plugin");
        Iterator<ah> r22 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f, Iterator.class, "com.obric.aiagent.plugin");
        List<ah> r24 = (List) ZeusTransformUtils.preCheckCast(r3.f21104e, List.class, "com.obric.aiagent.plugin");
        List r113 = (List) ZeusTransformUtils.preCheckCast(r3.f21103d, List.class, "com.obric.aiagent.plugin");
        y r114 = (y) ZeusTransformUtils.preCheckCast(r3.f21102c, y.class, "com.obric.aiagent.plugin");
        String r25 = (String) ZeusTransformUtils.preCheckCast(r3.f21101b, String.class, "com.obric.aiagent.plugin");
        a r29 = (a) ZeusTransformUtils.preCheckCast(r3.f21100a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        r4 = r29;
        String r30 = r25;
        List r31 = r113;
        ah r115 = r21;
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L28;
        ((Collection) ZeusTransformUtils.preCheckCast(r31, Collection.class, "com.obric.aiagent.plugin")).add(r4.a(r115) + "=cleanup failed");
    L28:
        y r32 = r114;
    L20:
        if (r22.hasNext() == false) goto L29;
        r115 = (ah) ZeusTransformUtils.preCheckCast(r22.next(), ah.class, "com.obric.aiagent.plugin");
        r3.f21100a = r4;
        r3.f21101b = r30;
        r3.f21102c = r32;
        r3.f21103d = r31;
        r3.f21104e = r24;
        r3.f = r22;
        r3.g = r115;
        r3.h = r112;
        r3.k = 1;
        Object r116 = r4.a(r30, r32, r115, r3);
        if (r116 != r5) goto L24;
        return r5;
    L24:
        r114 = r32;
        r2 = r116;
        goto L26
    L29:
        r3.f21100a = r4;
        r3.f21101b = r30;
        r3.f21102c = r32;
        r3.f21103d = r31;
        r3.f21104e = r24;
        r3.f = null;
        r3.g = null;
        r3.h = r112;
        r3.k = 2;
        Object r33 = r4.c(r30, r32, r3);
        if (r33 != r5) goto L32;
        return r5;
    L32:
        long r210 = r112;
        r111 = r30;
        r110 = r32;
        r0 = r4;
        r2 = r33;
        r19 = r24;
        r20 = r31;
        r18 = r210;
        goto L34
    L18:
        d.o.a(r2);
        long r34 = System.currentTimeMillis();
        List r35 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r24 = a();
        r112 = r34;
        r30 = r26;
        r32 = r27;
        r31 = r35;
        r22 = r24.iterator();
    L7:
        r4 = this;
        r3 = new d(r4, r1);
        goto L8
    }

    public final Object b(String r9, y r10, d.c.d<? super Boolean> r11) {
        d.c.d<? super Boolean> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.api.e r12 = r10.a(".obric/shell-outputs");
        return a(r9, "purge-shell-output", new b((x) ZeusTransformUtils.preCheckCast(r12, x.class, "com.obric.aiagent.plugin"), (x) ZeusTransformUtils.preCheckCast(r10.a(), x.class, "com.obric.aiagent.plugin")), "rm -rf -- " + com.obric.aiagent.skill.ovirt.impl.a.a(r12.a()), r7);
    }

    private final Object c(String r9, y r10, d.c.d<? super Boolean> r11) {
        d.c.d<? super Boolean> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r9, "mandatory-tmp-root", new b((x) ZeusTransformUtils.preCheckCast(r10.c("/tmp"), x.class, "com.obric.aiagent.plugin"), (x) ZeusTransformUtils.preCheckCast(r10.a(), x.class, "com.obric.aiagent.plugin")), a("/tmp", p.b()), r7);
    }

    private final Object a(String r9, y r10, ah r11, d.c.d<? super Boolean> r12) {
        d.c.d<? super Boolean> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        b r5 = a(r10, r11);     // Catch: Throwable -> L13
        if (r5 != null) goto L18;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge/ConfigFs", "runRule: skipped reason=no-share-root", "runRule: skipped uniqueId=" + r9 + " rule=" + a(r11) + " reason=no-share-root");
        return d.c.b.a.b.a(true);
    L18:
        return a(r9, a(r11), r5, a(r11, r5.a().a(), a(r11.e())), r7);
    L10:
        th = move-exception;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge/ConfigFs", "runRule: invalid excludes", "runRule: invalid excludes uniqueId=" + r9 + " rule=" + a(r11), th);
        return d.c.b.a.b.a(false);
    L13:
        th = move-exception;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge/ConfigFs", "runRule: target resolution failed", "runRule: target resolution failed uniqueId=" + r9 + " rule=" + a(r11), th);
        return d.c.b.a.b.a(false);
    }

    private final Object a(String r19, String r20, b r21, String r22, d.c.d<? super Boolean> r23) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L7;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        e r9 = r3;
        Object r2 = r9.f21109e;
        Object r4 = d.c.a.b.a();
        int r5 = r9.g;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        long r6 = r9.f21108d;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r9.f21107c, b.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r9.f21106b, String.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.f21105a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L14
        b r14 = r7;
        String r11 = r8;
    L59:
        z r0 = (z) ZeusTransformUtils.preCheckCast(r2, z.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        long r12 = System.currentTimeMillis() - r6;
        Integer r13 = null;
        if (ZeusTransformUtils.instanceOf(r0, z.a.class) == false) goto L33;
        z.a r15 = (z.a) ZeusTransformUtils.preCheckCast(r0, z.a.class, "com.obric.aiagent.plugin");
    L34:
        if (r15 == null) goto L36;
        r13 = d.c.b.a.b.a(r15.b());
    L36:
        if (r13 != null) goto L39;
    L42:
        String r16 = d.o.o.e(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0.a(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), 512);
        boolean r17 = ZeusTransformUtils.instanceOf(r0, z.b.class);
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("SkRt/Purge/ConfigFs", "runRule: fail exitCode=" + r13 + " timedOut=" + r17 + " durationMs=" + r12, "runRule: fail uniqueId=" + r10 + " rule=" + r11 + " target=" + r14.a().a() + " durationMs=" + r12 + ' ' + ("purge failed exitCode=" + r13 + " timedOut=" + r17 + " stderr='" + r16 + '\''));
        return d.c.b.a.b.a(false);
    L39:
        if (r13.intValue() != 0) goto L42;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge/ConfigFs", "runRule: ok durationMs=" + r12, "runRule: ok uniqueId=" + r10 + " rule=" + r11 + " target=" + r14.a().a() + " durationMs=" + r12);
        return d.c.b.a.b.a(true);
    L33:
        r15 = null;
    L44:
        th = th;
    L57:
        long r18 = System.currentTimeMillis() - r6;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge/ConfigFs", "runRule: launch threw durationMs=" + r18, "runRule: launch threw uniqueId=" + r10 + " rule=" + r11 + " target=" + r14.a().a() + " durationMs=" + r18, th);
        return d.c.b.a.b.a(false);
    L14:
        th = th;
        r14 = r7;
        r11 = r8;
        goto L57
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r2);
        long r24 = System.currentTimeMillis();
        s<x, String, Long, String, d.c.d<? super z>, Object> r25 = this.f21096c;     // Catch: Throwable -> L52
        x r26 = r21.b();     // Catch: Throwable -> L52
        Long r27 = d.c.b.a.b.a(60000);     // Catch: Throwable -> L52
        r9.f21105a = r19;     // Catch: Throwable -> L52
        r11 = r20;
        r9.f21106b = r11;     // Catch: Throwable -> L50
        r14 = r21;
        r9.f21107c = r14;     // Catch: Throwable -> L48
        r9.f21108d = r24;     // Catch: Throwable -> L48
        r9.g = 1;     // Catch: Throwable -> L48
        long r110 = r24;
        r2 = r25.a(r26, r22, r27, "purge_rule", r9);     // Catch: Throwable -> L46
        if (r2 != r4) goto L28;
        return r4;
    L28:
        r10 = r19;
        r6 = r110;
    L46:
        th = th;
    L56:
        r10 = r19;
        r6 = r110;
    L48:
        th = th;
    L55:
        r110 = r24;
    L50:
        th = th;
    L54:
        r14 = r21;
    L52:
        th = th;
        r11 = r20;
    L7:
        r3 = new e(this, r1);
        goto L8
    }

    private final b a(y r3, ah r4) {
        ag r2 = r4.b();
        int r5 = c.f21099a[r2.ordinal()];
        if (r5 == 1) goto L14;
        if (r5 != 2) goto L12;
        j r6 = r3.b();
        if (r6 != null) goto L15;
        return null;
    L15:
        return new b((x) ZeusTransformUtils.preCheckCast(r3.b(r4.c()), x.class, "com.obric.aiagent.plugin"), (x) ZeusTransformUtils.preCheckCast(r6, x.class, "com.obric.aiagent.plugin"));
    L12:
        throw new k();
    L14:
        return new b((x) ZeusTransformUtils.preCheckCast(r3.a(r4.c()), x.class, "com.obric.aiagent.plugin"), (x) ZeusTransformUtils.preCheckCast(r3.a(), x.class, "com.obric.aiagent.plugin"));
    }

    private final String a(ah r5, String r6, List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (r5.d() == af.f19167b) goto L5;
    L9:
        r3 = false;
    L10:
        if (r3 == false) goto L13;
        return "rm -rf -- " + com.obric.aiagent.skill.ovirt.impl.a.a(r6);
    L13:
        return a(r6, r8);
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        if (r8.isEmpty() == false) goto L9;
        goto L9
    }

    private final String a(String r11, List<String> r12) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        String r13 = com.obric.aiagent.skill.ovirt.impl.a.a(r11);
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(p.b(new String[]{"find", r13, "-mindepth 1", "-maxdepth 1", p.a((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$a$3hI5G0rBlvUM1eMGv8W6mZbr02k.INSTANCE, 30, null), "-exec rm -rf -- {} +"}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r3 = r15.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r1.add(r3);
        goto L4
    L9:
        return "if [ -e " + r13 + " ] && [ ! -d " + r13 + " ]; then echo 'purge target is not a directory' >&2; exit 64; fi; if [ -d " + r13 + " ]; then " + p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + "; fi";
    }

    private static final CharSequence a(String r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("! -name " + com.obric.aiagent.skill.ovirt.impl.a.a(r2), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final List<String> a(List<String> r9) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        boolean r3 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L26;
        if ((!d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null)) == false) goto L24;
        if ((!d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null)) == false) goto L22;
        if (o.a(r1, ".") == false) goto L14;
    L16:
        r3 = false;
    L17:
        if (r3 == false) goto L20;
        r10.add(r1);
        goto L4
    L20:
        throw new IllegalArgumentException("exclude must not be . or ..".toString());
    L14:
        if (o.a(r1, DownloadConstants.VULNERABILITY_PATH) == true) goto L16;
    L22:
        throw new IllegalArgumentException("exclude must not contain NUL".toString());
    L24:
        throw new IllegalArgumentException(("exclude must be a direct child name: " + r1).toString());
    L26:
        throw new IllegalArgumentException("exclude must not be blank".toString());
    L28:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
    }

    private final List<ah> a() {
        return p.a(new ah("mandatory-share-root", ag.f19171b, "", af.f19166a, null, 16, null));
    }

    private final String a(ah r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r1) == false) goto L6;
        r1 = "unnamed-rule";
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    }
}
