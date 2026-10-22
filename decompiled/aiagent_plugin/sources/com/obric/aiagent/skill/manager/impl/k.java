package com.obric.aiagent.skill.manager.impl;

import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.UUID;

/* JADX INFO: compiled from: CliPackageStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20127a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d.o.k f20128e = null;
    private static final d.o.k f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f20129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<String> f20130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Gson f20131d;

    /* JADX INFO: compiled from: CliPackageStore.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: lambda$r1E4l6L5UpQ0lDeh-mMF5ImgdVk, reason: not valid java name */
    public static /* synthetic */ String m285lambda$r1E4l6L5UpQ0lDehmMF5ImgdVk() {
        return a();
    }

    public k(File r3, d.h.a.a<String> r4, Gson r5) {
        d.h.a.a<String> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "cliRoot");
        d.h.b.o.e(r6, "uniqueId");
        d.h.b.o.e(r5, "gson");
        this.f20129b = r3;
        this.f20130c = r6;
        this.f20131d = r5;
    }

    public /* synthetic */ k(File r2, d.h.a.a r3, Gson r4, int r5, d.h.b.h r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = $$Lambda$k$r1E4l6L5UpQ0lDehmMF5ImgdVk.INSTANCE;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = new Gson();
    L8:
        this(r2, r7, r4);
    }

    private static final String a() {
        return UUID.randomUUID().toString();
    }

    public final File a(String r5) {
        d.h.b.o.e(r5, "name");
        d(r5);
        File r0 = new File(this.f20129b, ".staging");
        c(r0);
        File r1 = new File(r0, r5 + '_' + ((String) ZeusTransformUtils.preCheckCast(this.f20130c.invoke(), String.class, "com.obric.aiagent.plugin")) + ".part");
        if (r1.exists() == true) goto L5;
    L9:
        return r1;
    L5:
        if (r1.delete() == true) goto L9;
        throw new IllegalStateException("Cannot reset CLI staging file.");
    }

    public final j b(String r9) {
        d.h.b.o.e(r9, "name");
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L17
        k r8 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        r8.d(r9);     // Catch: Throwable -> L17
        File r10 = r8.e(r9);     // Catch: Throwable -> L17
        if (r10.isFile() == true) goto L6;
        return null;
    L6:
        boolean r3 = true;
        j r11 = (j) ZeusTransformUtils.preCheckCast(r8.f20131d.fromJson(d.f.k.a(r10, null, 1, null), j.class), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r11 != null) goto L9;
        return null;
    L9:
        r8.g(r11.a());     // Catch: Throwable -> L17
        r8.h(r11.b());     // Catch: Throwable -> L17
        if (r11.c() >= 0) goto L13;
        r3 = false;
    L13:
        if (r3 == false) goto L16;
        Object r12 = d.n.f(r11);     // Catch: Throwable -> L17
    L20:
        if (d.n.b(r12) == true) goto L24;
        r1 = r12;
    L24:
        return (j) ZeusTransformUtils.preCheckCast(r1, j.class, "com.obric.aiagent.plugin");
    L16:
        throw new IllegalArgumentException("Invalid CLI current file size.".toString());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r12 = d.n.f(d.o.a(th));
        goto L20
    }

    public final File c(String r2) {
        d.h.b.o.e(r2, "name");
        j r0 = b(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r2, r0);
    }

    public final File a(String r3, j r4) {
        d.h.b.o.e(r3, "name");
        d.h.b.o.e(r4, "state");
        File r2 = a(r3, r4.a(), r4.b());
        if (r2.isFile() == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == true) goto L12;
        return null;
    L12:
        return r2;
    L5:
        if (r2.length() != r4.c()) goto L7;
        r5 = true;
        goto L8
    }

    public final File a(String r25, g r26, File r27, long r28) {
        d.h.b.o.e(r25, "name");
        d.h.b.o.e(r26, "descriptor");
        d.h.b.o.e(r27, "stagingFile");
        d(r25);
        a(r26);
        if (r27.isFile() == false) goto L85;
        boolean r5 = false;
        boolean r6 = true;
        if (r27.length() != r26.c()) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L83;
        File r7 = a(r25, r26.a(), r26.b());
        File r8 = r7.getParentFile();
        if (r8 == null) goto L81;
        c(r8);
        File r9 = b(r7);
        File r10 = e(r25);
        File r11 = r10.getParentFile();
        if (r11 == null) goto L79;
        c(r11);
        File r12 = b(r10);
        File r13 = new File(r10.getParentFile(), '.' + r10.getName() + '.' + ((String) ZeusTransformUtils.preCheckCast(this.f20130c.invoke(), String.class, "com.obric.aiagent.plugin")) + ".part");
        if (r13.exists() == true) goto L16;
    L90:
        a(r7, r9);     // Catch: Throwable -> L52
        if (r27.renameTo(r7) == false) goto L51;
    L48:
        th = move-exception;
        Throwable r2 = th;
    L88:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L59
        if (r5 == false) goto L57;
        r10.delete();     // Catch: Throwable -> L59
    L57:
        a(r12, r10, r2);     // Catch: Throwable -> L59
        Object r1 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L59
    L61:
        Throwable r3 = d.n.c(r1);     // Catch: Throwable -> L75
        if (r3 == null) goto L86;
        r2.addSuppressed(r3);     // Catch: Throwable -> L75
    L86:
        d.n.a r14 = d.n.f38560a;     // Catch: Throwable -> L69
        if (r6 == false) goto L67;
        r7.delete();     // Catch: Throwable -> L69
    L67:
        a(r9, r7, r2);     // Catch: Throwable -> L69
        Object r15 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L69
    L71:
        Throwable r16 = d.n.c(r15);     // Catch: Throwable -> L75
        if (r16 == null) goto L95;
        r2.addSuppressed(r16);     // Catch: Throwable -> L75
        throw r2;     // Catch: Throwable -> L75
    L95:
        throw r2;     // Catch: Throwable -> L75
    L69:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L75
        r15 = d.n.f(d.o.a(th));     // Catch: Throwable -> L75
        goto L71
    L75:
        th = move-exception;
        r13.delete();
        throw th;
    L59:
        th = move-exception;
        d.n.a r18 = d.n.f38560a;     // Catch: Throwable -> L75
        r1 = d.n.f(d.o.a(th));     // Catch: Throwable -> L75
        goto L61
    L23:
        if (r7.isFile() == false) goto L47;
        if (r7.length() != r26.c()) goto L47;
        j r19 = new j(r26.a(), r26.b(), r26.c(), r26.e(), r28);     // Catch: Throwable -> L48
        String r20 = this.f20131d.toJson(r19);     // Catch: Throwable -> L48
        d.h.b.o.c(r20, "toJson(...)");     // Catch: Throwable -> L48
        d.f.k.a(r13, r20, null, 2, null);     // Catch: Throwable -> L48
        if (d.h.b.o.a((j) ZeusTransformUtils.preCheckCast(this.f20131d.fromJson(d.f.k.a(r13, null, 1, null), j.class), j.class, "com.obric.aiagent.plugin"), r19) == false) goto L45;
        a(r10, r12);     // Catch: Throwable -> L48
        if (r13.renameTo(r10) == false) goto L43;
    L40:
        th = move-exception;
        r2 = th;
        r5 = true;
        goto L88
    L31:
        if (d.h.b.o.a(b(r25), r19) == false) goto L39;
        if (r9 == null) goto L34;
        r9.delete();     // Catch: Throwable -> L40
    L34:
        if (r12 == null) goto L36;
        r12.delete();     // Catch: Throwable -> L40
    L36:
        r13.delete();
        return r7;
    L39:
        throw new IllegalArgumentException("Committed CLI current state is invalid.".toString());     // Catch: Throwable -> L40
    L43:
        throw new IllegalStateException("Cannot atomically commit CLI current state.");     // Catch: Throwable -> L48
    L45:
        throw new IllegalArgumentException("CLI staged state is invalid.".toString());     // Catch: Throwable -> L48
    L47:
        throw new IllegalStateException("Committed CLI package is invalid.");     // Catch: Throwable -> L48
    L51:
        throw new IllegalStateException("Cannot atomically commit CLI package.");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        r2 = th;
        r6 = false;
        goto L88
    L16:
        if (r13.delete() == true) goto L90;
        throw new IllegalStateException("Cannot reset CLI state staging file.");
    L79:
        throw new IllegalStateException("CLI state directory is missing.".toString());
    L81:
        throw new IllegalStateException("CLI version directory is missing.".toString());
    L83:
        throw new IllegalArgumentException("CLI staging file size mismatch.".toString());
    L7:
        r4 = false;
        goto L8
    L85:
        throw new IllegalArgumentException("CLI staging file is missing.".toString());
    }

    public final void a(String r4, String r5) {
        d.h.b.o.e(r4, "name");
        d.h.b.o.e(r5, "currentVersion");
        d(r4);
        g(r5);
        File[] r3 = f(r4).listFiles();
        int r6 = 0;
        if (r3 != null) goto L5;
        r3 = new File[0];
    L5:
        int r0 = r3.length;
    L6:
        if (r6 >= r0) goto L15;
        File r1 = r3[r6];
        if (d.h.b.o.a(r1.getName(), r5) == true) goto L14;
        d.h.b.o.a(r1);
        if (d.f.k.h(r1) == true) goto L14;
        throw new IllegalStateException("Cannot remove old CLI version.");
    L14:
        r6 = r6 + 1;
        goto L6
    }

    public final void a(File r1) {
        d.h.b.o.e(r1, "stagingFile");
        if (r1.exists() == false) goto L6;
        r1.delete();
        return;
    }

    public final void d(String r1) {
        d.h.b.o.e(r1, "name");
        i.f20120a.a(r1);
    }

    public final void a(g r5) {
        d.h.b.o.e(r5, "descriptor");
        g(r5.a());
        h(r5.b());
        if (r5.c() < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L13;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5.d(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("CLI download URL is empty.".toString());
    L13:
        throw new IllegalArgumentException("Invalid CLI file size.".toString());
    L5:
        r4 = false;
        goto L6
    }

    private final File e(String r4) {
        d(r4);
        return a(this.f20129b, new String[]{r4, "current.json"});
    }

    private final File a(String r3, String r4, String r5) {
        d(r3);
        g(r4);
        h(r5);
        return a(f(r3), new String[]{r4, r5});
    }

    private final File f(String r4) {
        d(r4);
        return a(this.f20129b, new String[]{r4, "versions"});
    }

    private final File b(File r5) {
        if (r5.exists() == true) goto L7;
        return null;
    L7:
        return new File(r5.getParentFile(), '.' + r5.getName() + '.' + ((String) ZeusTransformUtils.preCheckCast(this.f20130c.invoke(), String.class, "com.obric.aiagent.plugin")) + ".backup");
    }

    private final void a(File r1, File r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.exists() == false) goto L12;
        if (r2.delete() == true) goto L12;
        throw new IllegalStateException("Cannot reset CLI backup.");
    L12:
        if (r1.renameTo(r2) == false) goto L15;
        return;
    L15:
        throw new IllegalStateException("Cannot stage existing CLI backup.");
    }

    private final void a(File r3, File r4, Throwable r5) {
        boolean r2 = true;
        if (r3 != null) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == true) goto L11;
        return;
    L11:
        if (r4.exists() == false) goto L14;
        r4.delete();
    L14:
        if (r3.renameTo(r4) == false) goto L17;
        return;
    L17:
        throw new IllegalStateException("Cannot restore previous CLI state.", r5);
    L5:
        if (r3.exists() != true) goto L7;
        goto L7
    }

    private final void g(String r3) {
        if (f20128e.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("Invalid CLI version.".toString());
    L5:
        if (d.h.b.o.a(r3, ".") == true) goto L9;
        if (d.h.b.o.a(r3, DownloadConstants.VULNERABILITY_PATH) == true) goto L9;
        r2 = true;
        goto L10
    }

    private final void h(String r3) {
        if (f.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L19;
        if (d.h.b.o.a(r3, ".") == false) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L17;
        if (d.h.b.o.a(new File(r3).getName(), r3) == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException("Invalid CLI filename.".toString());
    L17:
        throw new IllegalArgumentException("Invalid CLI filename.".toString());
    L7:
        if (d.h.b.o.a(r3, DownloadConstants.VULNERABILITY_PATH) == true) goto L9;
        r2 = true;
        goto L10
    L19:
        throw new IllegalArgumentException("Invalid CLI filename.".toString());
    }

    private final void c(File r1) {
        if (r1.mkdirs() == false) goto L5;
        return;
    L5:
        if (r1.isDirectory() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot prepare CLI package directory.");
    }

    static {
        f20127a = new a(null);
        f20128e = new d.o.k("[A-Za-z0-9][A-Za-z0-9._+-]{0,127}");
        f = new d.o.k("[A-Za-z0-9][A-Za-z0-9._+-]{0,127}");
    }

    private final File a(File r6, String... r7) {
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        File r4 = new File(r6, r7[r2]);
        r2 = r2 + 1;
        r6 = r4;
        goto L3
    L5:
        StringBuilder r8 = new StringBuilder();
        String r5 = this.f20129b.getCanonicalFile().getPath();
        d.h.b.o.c(r5, "getPath(...)");
        String r9 = r8.append(d.o.o.c(r5, new char[]{File.separatorChar})).append(File.separator).toString();
        String r10 = r6.getCanonicalFile().getPath();
        d.h.b.o.a(r10);
        if (d.o.o.b(r10, r9, false, 2, null) == false) goto L9;
        return r6;
    L9:
        throw new IllegalArgumentException("CLI package path escapes private storage.".toString());
    }
}
