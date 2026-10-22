package com.obric.aiagent.skill.manager.impl;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: SkillCoverStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Long> f19524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<File, String> f19525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.f f19526e;

    /* JADX INFO: compiled from: SkillCoverStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public static /* synthetic */ String lambda$uKRVVoaVsttukHC8UcM4WhghRQE(Context r0, File r1) {
            return a(r0, r1);
        }

        private a() {
        }

        public final au a(Context r7) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "context");
            final Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            dv r0 = dv.f19775a;
            d.h.b.o.a(r8);
            d.h.a.a r2 = null;
            return new au(r0.b(r8), r2, new $$Lambda$au$a$uKRVVoaVsttukHC8UcM4WhghRQE(r8), 2, null);
        }

        private static final String a(Context r2, File r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "coverFile");
            String r5 = ZeusTransformUtils.getUriForFile(r4, "com.obric.agent.fileprovider", r3, "com.obric.aiagent.plugin").toString();
            d.h.b.o.c(r5, "toString(...)");
            return r5;
        }
    }

    /* JADX INFO: compiled from: SkillCoverStore.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f19529c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19527a, r6.f19527a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f19528b, r6.f19528b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f19529c, r6.f19529c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f19527a.hashCode() * 31) + this.f19528b.hashCode()) * 31) + this.f19529c.hashCode();
        }

        public String toString() {
            return "ManagedUriShape(scheme=" + this.f19527a + ", authority=" + this.f19528b + ", pathPrefix=" + this.f19529c + ')';
        }

        public b(String r3, String r4, List<String> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "scheme");
            d.h.b.o.e(r4, "authority");
            d.h.b.o.e(r6, "pathPrefix");
            this.f19527a = r3;
            this.f19528b = r4;
            this.f19529c = r6;
        }

        public final String a() {
            return this.f19527a;
        }

        public final String b() {
            return this.f19528b;
        }

        public final List<String> c() {
            return this.f19529c;
        }
    }

    static {
        f19522a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$RF5O8ei_EWFR0Qhm6m6Jm-JBsJM, reason: not valid java name */
    public static /* synthetic */ b m278lambda$RF5O8ei_EWFR0Qhm6m6JmJBsJM(au r0) {
        return a(r0);
    }

    public static /* synthetic */ long lambda$l15PpzJjq9u0Ej4CBlBIxHj8lwM() {
        return c();
    }

    public au(File r3, d.h.a.a<Long> r4, d.h.a.b<? super File, String> r5) {
        d.h.a.a<Long> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<File, String> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "coversDir");
        d.h.b.o.e(r6, "maxCoverBytesProvider");
        d.h.b.o.e(r7, "uriFactory");
        this.f19523b = r3;
        this.f19524c = r6;
        this.f19525d = r7;
        this.f19526e = d.g.a(d.j.f38507c, new $$Lambda$au$RF5O8ei_EWFR0Qhm6m6JmJBsJM(this));
    }

    public /* synthetic */ au(File r2, d.h.a.a r3, d.h.a.b r4, int r5, d.h.b.h r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L5;
        r7 = $$Lambda$au$l15PpzJjq9u0Ej4CBlBIxHj8lwM.INSTANCE;
    L5:
        this(r2, r7, r8);
    }

    private static final long c() {
        return com.obric.aiagent.skill.manager.api.al.f19195a.a().p();
    }

    public final y a(InputStream r17, String r18, long r19) {
        d.h.b.o.e(r17, "input");
        String r5 = b(r18);
        a();
        File r6 = new File(this.f19523b, UUID.randomUUID() + c(r5));
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        FileOutputStream r8 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r7, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(r17, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        InputStream r9 = (InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        byte[] r10 = new byte[8192];     // Catch: Throwable -> L29
        long r11 = 0;
        long r12 = 0;
    L6:
        int r14 = r9.read(r10);     // Catch: Throwable -> L29
        boolean r15 = false;
        if (r14 < 0) goto L8;
        if (r14 == 0) goto L6;
        r12 = r12 + ((long) r14);
        if (r12 > r19) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L28;
        r8.write(r10, 0, r14);     // Catch: Throwable -> L29
        r11 = 0;
        goto L6
    L28:
        throw new IllegalArgumentException(("Managed cover exceeds " + r19 + " bytes").toString());     // Catch: Throwable -> L29
    L24:
        r13 = false;
        goto L25
    L8:
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L29
        d.f.c.a(r1, null);     // Catch: Throwable -> L36
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L36
        d.f.c.a(r7, null);     // Catch: Throwable -> L43
        if (r12 <= r11) goto L14;
        r15 = true;
    L14:
        if (r15 == false) goto L18;
        return new y((String) ZeusTransformUtils.preCheckCast(this.f19525d.invoke(r6), String.class, "com.obric.aiagent.plugin"), r6);
    L18:
        throw new IllegalArgumentException("Managed cover must not be empty".toString());     // Catch: Throwable -> L43
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        d.f.c.a(r1, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        d.f.c.a(r7, th);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        r6.delete();
        throw th;
    }

    public final boolean a(String r2) {
        d.h.b.o.e(r2, "coverUrl");
        File r1 = d(r2);
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.exists() == true) goto L8;
        return false;
    L8:
        if (r1.delete() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static /* synthetic */ at a(au r6, Set r7, long r8, long r10, int r12, Object r13) {
        Set<String> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L6;
        r10 = System.currentTimeMillis();
    L6:
        return r6.a(r1, r8, r10);
    }

    public final at a(Set<String> r9, long r10, long r12) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "referencedUrls");
        Set r13 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin"));
        if (this.f19523b.exists() == true) goto L6;
        File[] r0 = new File[0];
    L9:
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r4 = r0.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L15;
        File r6 = r0[r5];
        if (r6.isFile() == false) goto L14;
        r3.add(r6);
    L14:
        r5 = r5 + 1;
        goto L10
    L15:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r7 = 0;
        int r8 = 0;
    L17:
        if (r1.hasNext() == false) goto L31;
        File r14 = (File) ZeusTransformUtils.preCheckCast(r1.next(), File.class, "com.obric.aiagent.plugin");
        d.h.a.b<File, String> r15 = this.f19525d;
        d.h.b.o.a(r14);
        if (r13.contains(r15.invoke(r14)) == true) goto L17;
        if ((r12 - r14.lastModified()) < r10) goto L17;
        boolean r16 = r14.delete();     // Catch: Exception -> L26
    L27:
        if (r16 == true) goto L28;
        r8 = r8 + 1;
        goto L17
    L28:
        r7 = r7 + 1;
    L26:
        r16 = false;
        goto L27
    L31:
        return new at(r7, r8);
    L6:
        if (this.f19523b.isDirectory() == false) goto L35;
        r0 = this.f19523b.listFiles();
        if (r0 != null) goto L9;
        throw new IOException("Failed to list managed cover directory.");
    L35:
        throw new IOException("Managed cover path is not a directory.");
    }

    private final String b(String r4) {
        if (r4 == null) goto L9;
        String r5 = d.o.o.a(r4, ';', null, 2, null);
        if (r5 == null) goto L9;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r6 == null) goto L9;
        Locale r1 = Locale.US;
        d.h.b.o.c(r1, "US");
        String r7 = r6.toLowerCase(r1);
        d.h.b.o.c(r7, "toLowerCase(...)");
    L10:
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        if (d.o.o.b(r7, "image/", false, 2, null) == false) goto L16;
        return r7;
    L16:
        throw new IllegalArgumentException("Managed cover must use an image mime type".toString());
    L9:
        r7 = null;
        goto L10
    }

    private final String c(String r1) {
        switch(r1.hashCode()) {
            case -1487394660: goto L17;
            case -1487018032: goto L13;
            case -879264467: goto L10;
            case -879258763: goto L6;
            default: goto L20;
        };
    L20:
        return ".img";
    L6:
        if (r1.equals("image/png") == false) goto L20;
        return ".png";
    L10:
        if (r1.equals("image/jpg") == false) goto L20;
    L19:
        return ".jpg";
    L13:
        if (r1.equals("image/webp") == false) goto L20;
        return ".webp";
    L17:
        if (r1.equals("image/jpeg") == true) goto L19;
        goto L19
    }

    private final void a() {
        if (this.f19523b.mkdirs() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Failed to create managed cover directory".toString());
    L5:
        if (this.f19523b.isDirectory() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final File d(String r6) {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        au r3 = (au) ZeusTransformUtils.preCheckCast(this, au.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r7 = d.n.f(new URI(r6));     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r7) == false) goto L10;
        r7 = null;
    L10:
        URI r8 = (URI) ZeusTransformUtils.preCheckCast(r7, URI.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L47;
        return null;
    L47:
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
        Object r0 = d.n.f(((au) ZeusTransformUtils.preCheckCast(this, au.class, "com.obric.aiagent.plugin")).b());     // Catch: Throwable -> L15
    L18:
        if (d.n.b(r0) == false) goto L20;
        r0 = null;
    L20:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L24;
        return null;
    L24:
        if (d.h.b.o.a(r8.getScheme(), r1.a()) == true) goto L26;
        return null;
    L26:
        if (d.h.b.o.a(r8.getAuthority(), r1.b()) == false) goto L53;
        List<String> r9 = e(r8.getRawPath());
        if (r9 != null) goto L32;
        return null;
    L32:
        if (r9.size() == (r1.c().size() + 1)) goto L35;
        return null;
    L35:
        if (d.h.b.o.a(d.a.p.c((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"), r1.c().size()), r1.c()) == true) goto L37;
        return null;
    L37:
        String r10 = (String) ZeusTransformUtils.preCheckCast(d.a.p.n(r9), String.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L41;
        r10 = "";
    L41:
        if (g(r10) == true) goto L43;
        return null;
    L43:
        File r5 = new File(this.f19523b, r10);
        if (a(r5) == true) goto L46;
        return null;
    L46:
        return r5;
    L53:
        return null;
    L15:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r0 = d.n.f(d.o.a(th));
    L5:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L8
    }

    private final boolean a(File r1) {
        Path r0 = this.f19523b.getCanonicalFile().toPath();
        return d.h.b.o.a(r1.getCanonicalFile().toPath().getParent(), r0);
    }

    private final List<String> e(String r12) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        ArrayList r2 = new ArrayList();
        Iterator r13 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null).iterator();
    L14:
        if (r13.hasNext() == false) goto L32;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L14;
        String r7 = f(r5);
        if (r7 == null) goto L23;
        if (d.h.b.o.a(r7, ".") == true) goto L30;
        if (d.h.b.o.a(r7, DownloadConstants.VULNERABILITY_PATH) == true) goto L30;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add(r7);
    L30:
        return null;
    L23:
        return null;
    L18:
        r6 = false;
        goto L19
    L32:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final String f(String r5) {
        ByteArrayOutputStream r4 = new ByteArrayOutputStream(r5.length());
        int r0 = 0;
    L4:
        if (r0 >= r5.length()) goto L16;
        char r1 = r5.charAt(r0);
        if (r1 == '%') goto L8;
        r4.write(r1);
        r0 = r0 + 1;
        goto L4
    L8:
        if ((r0 + 2) >= r5.length()) goto L9;
        int r2 = r0 + 1;
        r0 = r0 + 3;
        String r3 = r5.substring(r2, r0);
        d.h.b.o.c(r3, "substring(...)");
        Integer r6 = d.o.o.a(r3, 16);
        if (r6 == null) goto L13;
        r4.write(r6.intValue());
        goto L4
    L13:
        return null;
    L9:
        return null;
    L16:
        return r4.toString(StandardCharsets.UTF_8.name());
    }

    private final boolean g(String r6) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return false;
    L6:
        if (d.h.b.o.a(r6, ".") == false) goto L8;
        return false;
    L8:
        if (d.h.b.o.a(r6, DownloadConstants.VULNERABILITY_PATH) == false) goto L11;
        return false;
    L11:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == false) goto L13;
        return false;
    L13:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '\\', false, 2, null) == true) goto L18;
        return true;
    L18:
        return false;
    }

    private final b b() {
        return (b) ZeusTransformUtils.preCheckCast(this.f19526e.b(), b.class, "com.obric.aiagent.plugin");
    }

    private static final b a(au r7) {
        URI r1 = new URI((String) ZeusTransformUtils.preCheckCast(r7.f19525d.invoke(new File(r7.f19523b, ".managed-skill-cover-path-probe")), String.class, "com.obric.aiagent.plugin"));
        boolean r3 = false;
        if (d.h.b.o.a(r1.getScheme(), "content") == false) goto L14;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.getAuthority(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r3 = true;
        goto L14
    L7:
        if (d.o.o.d(r0) == true) goto L10;
        r2 = false;
    L14:
        if (r3 == false) goto L26;
        List<String> r8 = r7.e(r1.getRawPath());
        if (r8 == null) goto L24;
        if (d.h.b.o.a(d.a.p.n(r8), ".managed-skill-cover-path-probe") == false) goto L22;
        String r4 = r1.getScheme();
        d.h.b.o.c(r4, "getScheme(...)");
        String r5 = r1.getAuthority();
        d.h.b.o.c(r5, "getAuthority(...)");
        return new b(r4, r5, d.a.p.e(r8, 1));
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L24:
        throw new IllegalArgumentException("Required value was null.".toString());
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
