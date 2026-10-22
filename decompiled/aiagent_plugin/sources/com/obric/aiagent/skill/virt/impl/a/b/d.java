package com.obric.aiagent.skill.virt.impl.a.b;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.skill.virt.api.f;
import com.obric.aiagent.skill.virt.api.g;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f.k;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: VirtFileBridgeSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21908a = null;
    private static final char[] g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<File> f21909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<String> f21910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<File> f21911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.b<com.obric.aiagent.skill.virt.impl.a.b.a, x> f21912e;
    private final d.h.a.b<File, x> f;

    /* JADX INFO: compiled from: VirtFileBridgeSupport.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(String r10, String r11, boolean r12) {
            o.e(r10, DownloadConstants.PATH_KEY);
            o.e(r11, "field");
            boolean r1 = true;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L51;
            if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, false, 6, null) >= 0) goto L7;
            boolean r9 = true;
        L8:
            if (r9 == false) goto L49;
            if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), '\n', 0, false, 6, null) >= 0) goto L12;
            boolean r13 = true;
        L13:
            if (r13 == false) goto L47;
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L17;
        L19:
            Iterator r4 = r3.iterator();
        L21:
            if (r4.hasNext() == false) goto L18;
            if (o.a((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin"), DownloadConstants.VULNERABILITY_PATH) == false) goto L21;
            boolean r5 = true;
        L26:
            if ((!r5) == false) goto L45;
            if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L36;
            if (r12 == true) goto L31;
        L35:
            r1 = false;
            goto L36
        L31:
            if (o.a(r10, "~") == true) goto L36;
            if (d.o.o.b(r10, "~/", false, 2, null) == false) goto L35;
        L36:
            if (r1 == true) goto L43;
            StringBuilder r14 = new StringBuilder().append(r11).append(" must be an absolute Virt path");
            if (r12 == false) goto L40;
            String r15 = " or start with '~/";
        L42:
            throw new IllegalArgumentException(r14.append(r15).toString().toString());
        L40:
            r15 = "";
            goto L42
        L43:
            return;
        L45:
            throw new IllegalArgumentException((r11 + " must not contain parent traversal").toString());
        L18:
            r5 = false;
            goto L26
        L17:
            if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L19;
        L47:
            throw new IllegalArgumentException((r11 + " must not contain newline").toString());
        L12:
            r13 = false;
            goto L13
        L49:
            throw new IllegalArgumentException((r11 + " must not contain NUL").toString());
        L7:
            r9 = false;
            goto L8
        L51:
            throw new IllegalArgumentException((r11 + " must not be blank").toString());
        }

        public final String a(String r13) {
            CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
            int r1 = 0;
            if (r12 != null) goto L5;
        L8:
            boolean r14 = true;
        L9:
            CharSequence r2 = "staging.bin";
            if (r14 == false) goto L12;
            return "staging.bin";
        L12:
            CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.c(d.o.o.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString(), '/', null, 2, null), '\\', null, 2, null), CharSequence.class, "com.obric.aiagent.plugin");
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length()), Collection.class, "com.obric.aiagent.plugin");
        L14:
            if (r1 >= r15.length()) goto L25;
            char r3 = r15.charAt(r1);
            if (Character.isLetterOrDigit(r3) == true) goto L24;
            if (r3 == '.') goto L24;
            if (r3 == '-') goto L24;
            if (r3 == '_') goto L24;
            r3 = '_';
        L24:
            r16.add(Character.valueOf(r3));
            r1 = r1 + 1;
            goto L14
        L25:
            CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null), CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r17) == true) goto L30;
            r2 = r17;
        L30:
            return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        L5:
            if (d.o.o.d(r12) == true) goto L8;
            r14 = false;
            goto L9
        }

        public final String b(String r3) {
            o.e(r3, "targetPath");
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.c(d.o.o.c(r3, new char[]{'/'}), '/', null, 2, null), CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r2) == false) goto L6;
            r2 = "staging.bin";
        L6:
            return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        }

        public final String a() {
            byte[] r0 = new byte[8];
            new SecureRandom().nextBytes(r0);
            StringBuilder r1 = new StringBuilder(16);
            int r2 = 0;
        L3:
            if (r2 >= 8) goto L5;
            byte r3 = r0[r2];
            r1.append(d.a()[(r3 >> 4) & 15]);
            r1.append(d.a()[r3 & 15]);
            r2 = r2 + 1;
            goto L3
        L5:
            String r6 = r1.toString();
            o.c(r6, "toString(...)");
            return r6;
        }

        public final String c(String r8) {
            o.e(r8, "text");
            return '\'' + d.o.o.a(r8, "'", "'\\''", false, 4, null) + '\'';
        }

        public final String a(String r4, String r5) {
            o.e(r4, "base");
            o.e(r5, "child");
            String r6 = d.o.o.c(r4, new char[]{'/'});
            String r3 = d.o.o.a(r5, new char[]{'/'});
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
            return "/";
        L8:
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L11;
            return '/' + r3;
        L11:
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
            return r6;
        L14:
            return r6 + '/' + r3;
        }

        public final String a(String r7, String r8, boolean r9, boolean r10, boolean r11, boolean r12) {
            o.e(r7, "containerStagingEntry");
            o.e(r8, "targetPath");
            String r13 = c(r7);
            String r6 = c(r8);
            if (r11 == false) goto L5;
            String r0 = "-d";
        L7:
            if (r12 == false) goto L11;
            if (r11 == false) goto L11;
            boolean r2 = false;
        L12:
            if (r2 == false) goto L29;
            StringBuilder r3 = new StringBuilder();
            r3.append("set -e; if [ ! ").append(r0).append(' ').append(r13).append(" ]; then echo 'staging entry missing' >&2; exit 71; fi; ");
            if (r10 == false) goto L18;
            String r14 = d.o.o.c(r8, '/', "");
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
            r3.append("mkdir -p ").append(d.f21908a.c(r14)).append("; ");
        L18:
            if (r9 == true) goto L20;
            r3.append("if [ -e ").append(r6).append(" ]; then echo 'target exists' >&2; exit 72; fi; ");
        L22:
            r3.append("mv -f -- ").append(r13).append(' ').append(r6).append("; ");
            r3.append("if [ ! ").append(r0).append(' ').append(r6).append(" ]; then echo 'target verification failed' >&2; exit 73; fi; ");
            if (r12 == false) goto L25;
            r3.append("chmod 755 -- ").append(r6).append("; ");
            r3.append("if [ ! -x ").append(r6).append(" ]; then echo 'target is not executable' >&2; exit 74; fi");
        L26:
            String r15 = r3.toString();
            o.c(r15, "toString(...)");
            return r15;
        L25:
            r3.append(':');
            goto L26
        L20:
            if (r11 == false) goto L22;
            r3.append("rm -rf -- ").append(r6).append("; ");
            goto L22
        L29:
            throw new IllegalArgumentException("ensureExecutable is only supported for file imports.".toString());
        L11:
            r2 = true;
            goto L12
        L5:
            r0 = "-f";
            goto L7
        }

        public final String a(String r5, String r6, String r7, boolean r8) {
            o.e(r5, "sourcePath");
            o.e(r6, "containerStagingDir");
            o.e(r7, "containerStagingFile");
            String r9 = c(r5);
            String r10 = c(r6);
            String r4 = c(r7);
            if (r8 == false) goto L5;
            String r11 = "mv -f --";
        L6:
            StringBuilder r12 = new StringBuilder();
            r12.append("set -e; ");
            r12.append("if [ -L ").append(r9).append(" ]; then echo 'source is a symlink' >&2; exit 81; fi; ");
            r12.append("if [ ! -f ").append(r9).append(" ]; then echo 'source is not a regular file' >&2; exit 82; fi; ");
            r12.append("if [ ! -r ").append(r9).append(" ]; then echo 'source is not readable' >&2; exit 83; fi; ");
            r12.append("mkdir -p ").append(r10).append("; ");
            r12.append(r11).append(' ').append(r9).append(' ').append(r4).append("; ");
            r12.append("if [ -L ").append(r4).append(" ]; then echo 'staging is a symlink' >&2; exit 84; fi; ");
            r12.append("if [ ! -f ").append(r4).append(" ]; then echo 'staging is not a regular file' >&2; exit 85; fi");
            String r13 = r12.toString();
            o.c(r13, "toString(...)");
            return r13;
        L5:
            r11 = "cp -f --";
            goto L6
        }

        public final String d(String r2) {
            o.e(r2, "sourcePath");
            String r1 = c(r2);
            return "set -e; rm -f -- " + r1 + "; if [ -e " + r1 + " ] || [ -L " + r1 + " ]; then echo 'source deletion failed' >&2; exit 86; fi";
        }
    }

    /* JADX INFO: compiled from: VirtFileBridgeSupport.kt */
    public static final class b extends SimpleFileVisitor<Path> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Path f21913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Path f21914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.e f21915c;

        b(Path r3, Path r4, z.e r5) {
            Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.aiagent.plugin");
            Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.aiagent.plugin");
            this.f21913a = r6;
            this.f21914b = r7;
            this.f21915c = r5;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public /* synthetic */ FileVisitResult preVisitDirectory(Object r3, BasicFileAttributes r4) {
            BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.aiagent.plugin");
            return a((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public /* synthetic */ FileVisitResult visitFile(Object r3, BasicFileAttributes r4) {
            BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.aiagent.plugin");
            return b((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.aiagent.plugin"), r5);
        }

        public FileVisitResult a(Path r3, BasicFileAttributes r4) {
            Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.aiagent.plugin");
            BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.aiagent.plugin");
            o.e(r5, "dir");
            o.e(r6, "attrs");
            Path r7 = this.f21913a.relativize(r5);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r7.toString(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
            boolean r8 = true;
        L6:
            Path r2 = this.f21914b;
            if (r8 == true) goto L11;
            r2 = r2.resolve(r7);
        L11:
            if (Files.exists(r2, new LinkOption[0]) == true) goto L14;
            Files.createDirectories(r2, new FileAttribute[0]);
        L14:
            return FileVisitResult.CONTINUE;
        L5:
            r8 = false;
            goto L6
        }

        public FileVisitResult b(Path r6, BasicFileAttributes r7) {
            Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r6, Path.class, "com.obric.aiagent.plugin");
            BasicFileAttributes r9 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r7, BasicFileAttributes.class, "com.obric.aiagent.plugin");
            o.e(r8, "file");
            o.e(r9, "attrs");
            if ((!r9.isSymbolicLink()) == false) goto L11;
            if (r9.isRegularFile() == false) goto L9;
            Files.copy(r8, this.f21914b.resolve(this.f21913a.relativize(r8)), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES});
            this.f21915c.f38503a += r9.size();
            return FileVisitResult.CONTINUE;
        L9:
            throw new IllegalArgumentException(("HostDirectory contains non-regular file: " + r8).toString());
        L11:
            throw new IllegalArgumentException(("HostDirectory contains symlink; not supported: " + r8).toString());
        }
    }

    /* JADX INFO: compiled from: VirtFileBridgeSupport.kt */
    public static final class c extends SimpleFileVisitor<Path> {
        c() {
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public /* synthetic */ FileVisitResult postVisitDirectory(Object r3, IOException r4) {
            return a((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public /* synthetic */ FileVisitResult visitFile(Object r3, BasicFileAttributes r4) {
            BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.aiagent.plugin");
            return a((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.aiagent.plugin"), r5);
        }

        public FileVisitResult a(Path r2, BasicFileAttributes r3) {
            Path r1 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.aiagent.plugin");
            BasicFileAttributes r4 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r3, BasicFileAttributes.class, "com.obric.aiagent.plugin");
            o.e(r1, "file");
            o.e(r4, "attrs");
            Files.deleteIfExists(r1);
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult a(Path r2, IOException r3) {
            Path r1 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.aiagent.plugin");
            o.e(r1, "dir");
            if (r3 != null) goto L6;
            Files.deleteIfExists(r1);
            return FileVisitResult.CONTINUE;
        L6:
            throw r3;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.b.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VirtFileBridgeSupport.kt */
    public static final class C0467d extends SimpleFileVisitor<Path> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.e f21916a;

        C0467d(z.e r1) {
            this.f21916a = r1;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public /* synthetic */ FileVisitResult visitFile(Object r3, BasicFileAttributes r4) {
            BasicFileAttributes r5 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.aiagent.plugin");
            return a((Path) ZeusTransformUtils.preCheckCast(r3, Path.class, "com.obric.aiagent.plugin"), r5);
        }

        public FileVisitResult a(Path r3, BasicFileAttributes r4) {
            Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.aiagent.plugin");
            BasicFileAttributes r6 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r4, BasicFileAttributes.class, "com.obric.aiagent.plugin");
            o.e(r5, "file");
            o.e(r6, "attrs");
            if (r6.isSymbolicLink() == false) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == false) goto L12;
            this.f21916a.f38503a += r6.size();
            return FileVisitResult.CONTINUE;
        L12:
            throw new IllegalArgumentException(("HostDirectory contains unsupported entry: " + r5).toString());
        L5:
            if (r6.isRegularFile() == false) goto L7;
            r0 = true;
            goto L8
        }
    }

    public static /* synthetic */ x lambda$TEKoj4lY8x4RYfqjFTr2jmtSjjc(File r0) {
        return c(r0);
    }

    public static /* synthetic */ x lambda$YwXpoM5oYIqSsWnP4Z6hUbxSkuo(com.obric.aiagent.skill.virt.impl.a.b.a r0) {
        return a(r0);
    }

    public d(d.h.a.a<? extends File> r3, d.h.a.a<String> r4, d.h.a.a<? extends File> r5, d.h.a.b<? super com.obric.aiagent.skill.virt.impl.a.b.a, x> r6, d.h.a.b<? super File, x> r7) {
        d.h.a.a<File> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<String> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<File> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<com.obric.aiagent.skill.virt.impl.a.b.a, x> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<File, x> r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r8, "hostShareRootProvider");
        o.e(r9, "containerShareRootProvider");
        o.e(r10, "defaultExportDirProvider");
        o.e(r11, "onMove");
        o.e(r12, "onCleanupFailure");
        this.f21909b = r8;
        this.f21910c = r9;
        this.f21911d = r10;
        this.f21912e = r11;
        this.f = r12;
    }

    public static final /* synthetic */ char[] a() {
        return g;
    }

    public /* synthetic */ d(d.h.a.a r4, d.h.a.a r5, d.h.a.a r6, d.h.a.b r7, d.h.a.b r8, int r9, h r10) {
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r9 & 8) == 0) goto L5;
        r13 = $$Lambda$d$YwXpoM5oYIqSsWnP4Z6hUbxSkuo.INSTANCE;
    L5:
        d.h.a.b r0 = r13;
        if ((r9 & 16) == 0) goto L8;
        d.h.a.b r2 = $$Lambda$d$TEKoj4lY8x4RYfqjFTr2jmtSjjc.INSTANCE;
    L9:
        this(r11, r12, r1, r0, r2);
        return;
    L8:
        r2 = r14;
        goto L9
    }

    private static final x a(com.obric.aiagent.skill.virt.impl.a.b.a r1) {
        o.e(r1, "it");
        return x.f38692a;
    }

    private static final x c(File r1) {
        o.e(r1, "it");
        return x.f38692a;
    }

    public final boolean a(String r4) {
        o.e(r4, "containerPath");
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.f21910c.invoke(), String.class, "com.obric.aiagent.plugin");
        if (o.a(r4, r3) == false) goto L5;
    L6:
        return true;
    L5:
        if (d.o.o.b(r4, r3 + '/', false, 2, null) == true) goto L6;
        return false;
    }

    public final com.obric.aiagent.skill.virt.impl.a.b.b a(com.obric.aiagent.skill.virt.impl.a.b.c r6, String r7) {
        o.e(r6, "kind");
        o.e(r7, DbHelper.COL_ID);
        File r0 = new File(new File((File) ZeusTransformUtils.preCheckCast(this.f21909b.invoke(), File.class, "com.obric.aiagent.plugin"), r6.a()), r7);
        if (r0.mkdirs() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        a r2 = f21908a;
        return new com.obric.aiagent.skill.virt.impl.a.b.b(r0, r2.a(r2.a((String) ZeusTransformUtils.preCheckCast(this.f21910c.invoke(), String.class, "com.obric.aiagent.plugin"), r6.a()), r7));
    L13:
        throw new IllegalStateException(("Unable to create file bridge staging directory: " + r0.getAbsolutePath()).toString());
    L5:
        if (r0.isDirectory() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void a(File r5) {
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.exists() == false) goto L20;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L9
        d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Object r3 = n.f(Boolean.valueOf(k.h(r5)));     // Catch: Throwable -> L9
    L12:
        if (n.b(r3) == false) goto L15;
        r3 = false;
    L15:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L21;
        this.f.invoke(r5);
        return;
    L21:
        return;
    L9:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L12
    }

    public final String a(g r5, String r6) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.aiagent.plugin");
        o.e(r4, DBHelper.BATTERY_COL_SOURCE);
        o.e(r6, "targetPath");
        if (ZeusTransformUtils.instanceOf(r4, g.b.class) == false) goto L6;
        String r7 = ((g.b) ZeusTransformUtils.preCheckCast(r4, g.b.class, "com.obric.aiagent.plugin")).a().getName();
    L17:
        return f21908a.a(r7);
    L6:
        if (ZeusTransformUtils.instanceOf(r4, g.c.class) == false) goto L11;
        r7 = ((g.c) ZeusTransformUtils.preCheckCast(r4, g.c.class, "com.obric.aiagent.plugin")).b();
        if (r7 != null) goto L17;
        r7 = d.o.o.c(r6, '/', null, 2, null);
        goto L17
    L11:
        if (ZeusTransformUtils.instanceOf(r4, g.a.class) == false) goto L19;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(((g.a) ZeusTransformUtils.preCheckCast(r4, g.a.class, "com.obric.aiagent.plugin")).a().getName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r8) == false) goto L15;
        r8 = d.o.o.c(r6, '/', null, 2, null);
    L15:
        r7 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        goto L17
    L19:
        throw new d.k();
    }

    public final long a(g r8, File r9, boolean r10) {
        g r11 = (g) ZeusTransformUtils.wrapperContextForParams(r8, g.class, "com.obric.aiagent.plugin");
        o.e(r11, DBHelper.BATTERY_COL_SOURCE);
        o.e(r9, "hostStagingEntry");
        if (ZeusTransformUtils.instanceOf(r11, g.b.class) == false) goto L24;
        if (((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).a().isFile() == false) goto L22;
        if (((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).a().canRead() == false) goto L20;
        long r5 = ((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).a().length();
        if (r10 == false) goto L11;
        Path r12 = ((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).a().toPath();
        o.c(r12, "toPath(...)");
        Path r13 = r9.toPath();
        o.c(r13, "toPath(...)");
        a(r12, r13, true, "HostFile(stage)");
        return r5;
    L11:
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).a()), Closeable.class, "com.obric.aiagent.plugin");
        long r6 = a((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r14, FileInputStream.class, "com.obric.aiagent.plugin"), InputStream.class, "com.obric.aiagent.plugin"), r9);     // Catch: Throwable -> L14
        d.f.c.a(r14, null);
        return r6;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        d.f.c.a(r14, th);
        throw th;
    L20:
        throw new IllegalArgumentException(("HostFile source is not readable: " + ((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).a().getAbsolutePath()).toString());
    L22:
        throw new IllegalArgumentException(("HostFile source is not a regular file: " + ((g.b) ZeusTransformUtils.preCheckCast(r11, g.b.class, "com.obric.aiagent.plugin")).a().getAbsolutePath()).toString());
    L24:
        if (ZeusTransformUtils.instanceOf(r11, g.a.class) == false) goto L30;
        File r15 = ((g.a) ZeusTransformUtils.preCheckCast(r11, g.a.class, "com.obric.aiagent.plugin")).a();
        b(r15);
        if (r10 == false) goto L28;
        Path r16 = r15.toPath();
        o.c(r16, "toPath(...)");
        long r7 = b(r16);
        Path r17 = r15.toPath();
        o.c(r17, "toPath(...)");
        Path r18 = r9.toPath();
        o.c(r18, "toPath(...)");
        a(r17, r18, true, "HostDirectory(stage)");
        return r7;
    L28:
        Path r19 = r15.toPath();
        o.c(r19, "toPath(...)");
        Path r20 = r9.toPath();
        o.c(r20, "toPath(...)");
        return a(r19, r20);
    L30:
        if (ZeusTransformUtils.instanceOf(r11, g.c.class) == false) goto L41;
        Closeable r21 = (Closeable) ZeusTransformUtils.preCheckCast(((g.c) ZeusTransformUtils.preCheckCast(r11, g.c.class, "com.obric.aiagent.plugin")).a(), Closeable.class, "com.obric.aiagent.plugin");
        long r22 = a((InputStream) ZeusTransformUtils.preCheckCast(r21, InputStream.class, "com.obric.aiagent.plugin"), r9);     // Catch: Throwable -> L35
        d.f.c.a(r21, null);
        return r22;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        d.f.c.a(r21, th);
        throw th;
    L41:
        throw new d.k();
    }

    public final com.obric.aiagent.skill.virt.api.h a(g.b r7, String r8, f r9) {
        o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        o.e(r8, "targetPath");
        o.e(r9, "config");
        if (r7.a().isFile() == false) goto L11;
        if (r7.a().canRead() == false) goto L9;
        File r0 = b(r8);
        a(r0, r9.b(), r9.a(), false);
        long r1 = r7.a().length();
        Path r10 = r7.a().toPath();
        o.c(r10, "toPath(...)");
        Path r4 = r0.toPath();
        o.c(r4, "toPath(...)");
        a(r10, r4, r9.a(), "HostFile");
        a(r0, r9.d());
        return new com.obric.aiagent.skill.virt.api.h(f21908a.b(r8), r1);
    L9:
        throw new IllegalArgumentException(("HostFile source is not readable: " + r7.a().getAbsolutePath()).toString());
    L11:
        throw new IllegalArgumentException(("HostFile source is not a regular file: " + r7.a().getAbsolutePath()).toString());
    }

    public final com.obric.aiagent.skill.virt.api.h a(g.a r7, String r8, f r9) {
        o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        o.e(r8, "targetPath");
        o.e(r9, "config");
        File r10 = r7.a();
        b(r10);
        File r0 = b(r8);
        a(r0, r9.b(), r9.a(), true);
        if (r9.c() == false) goto L5;
        Path r1 = r10.toPath();
        o.c(r1, "toPath(...)");
        long r3 = b(r1);
        Path r11 = r10.toPath();
        o.c(r11, "toPath(...)");
        Path r2 = r0.toPath();
        o.c(r2, "toPath(...)");
        a(r11, r2, r9.a(), "HostDirectory");
    L6:
        a(r0, r9.d());
        return new com.obric.aiagent.skill.virt.api.h(f21908a.b(r8), r3);
    L5:
        Path r12 = r10.toPath();
        o.c(r12, "toPath(...)");
        Path r4 = r0.toPath();
        o.c(r4, "toPath(...)");
        r3 = a(r12, r4);
        goto L6
    }

    public final File a(com.obric.aiagent.skill.virt.api.c r5, String r6, com.obric.aiagent.skill.virt.api.b r7) {
        com.obric.aiagent.skill.virt.api.c r8 = (com.obric.aiagent.skill.virt.api.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.virt.api.c.class, "com.obric.aiagent.plugin");
        o.e(r8, "destination");
        o.e(r6, "stagingFileName");
        o.e(r7, "config");
        boolean r2 = false;
        if (o.a(r8, com.obric.aiagent.skill.virt.api.c.a.f21558a) == false) goto L16;
        File r4 = (File) ZeusTransformUtils.preCheckCast(this.f21911d.invoke(), File.class, "com.obric.aiagent.plugin");
        if (r4.mkdirs() == false) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == false) goto L14;
        File r10 = new File(r4, r6);
    L20:
        File r11 = r10.getParentFile();
        if (r7.c() == false) goto L35;
        if (r11 == null) goto L35;
        if (r11.exists() == true) goto L35;
        if (r11.mkdirs() == false) goto L28;
    L29:
        r2 = true;
    L30:
        if (r2 == true) goto L35;
        throw new IllegalStateException(("Unable to create export parent: " + r11.getAbsolutePath()).toString());
    L28:
        if (r11.isDirectory() == false) goto L30;
    L35:
        if (r10.exists() == true) goto L37;
    L45:
        return r10;
    L37:
        if (r7.b() == false) goto L44;
        if ((!r10.isDirectory()) == true) goto L45;
        throw new IllegalArgumentException(("Destination is a directory: " + r10.getAbsolutePath()).toString());
    L44:
        throw new IllegalArgumentException(("Destination exists and overwrite=false: " + r10.getAbsolutePath()).toString());
    L14:
        throw new IllegalStateException(("Unable to create default export directory: " + r4.getAbsolutePath()).toString());
    L7:
        if (r4.isDirectory() == true) goto L10;
        r9 = false;
        goto L11
    L16:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.virt.api.c.b.class) == false) goto L49;
        if ((!((com.obric.aiagent.skill.virt.api.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.virt.api.c.b.class, "com.obric.aiagent.plugin")).a().isDirectory()) == false) goto L47;
        r10 = ((com.obric.aiagent.skill.virt.api.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.virt.api.c.b.class, "com.obric.aiagent.plugin")).a();
        goto L20
    L47:
        throw new IllegalArgumentException(("HostFile destination must not be a directory: " + ((com.obric.aiagent.skill.virt.api.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.virt.api.c.b.class, "com.obric.aiagent.plugin")).a().getAbsolutePath()).toString());
    L49:
        throw new d.k();
    }

    public final void a(File r8, File r9) {
        o.e(r8, "stagingFile");
        o.e(r9, "destinationFile");
        if (r9.exists() == false) goto L10;
        if (r9.delete() == true) goto L10;
        throw new IllegalStateException("Failed to remove existing destination: " + r9.getAbsolutePath());
    L10:
        if (r8.renameTo(r9) == false) goto L12;
        return;
    L12:
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r8), Closeable.class, "com.obric.aiagent.plugin");
        FileInputStream r1 = (FileInputStream) ZeusTransformUtils.preCheckCast(r0, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r9), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        d.f.b.a((InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r3, FileOutputStream.class, "com.obric.aiagent.plugin"), OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L24
        d.f.c.a(r3, null);     // Catch: Throwable -> L29
        d.f.c.a(r0, null);
        if (r8.delete() == true) goto L20;
        this.f.invoke(r8);
    L20:
        if (r9.isFile() == false) goto L23;
        return;
    L23:
        throw new FileNotFoundException("Destination file missing after copy: " + r9.getAbsolutePath());
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        d.f.c.a(r3, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        d.f.c.a(r0, th);
        throw th;
    }

    private final File b(String r9) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.f21910c.invoke(), String.class, "com.obric.aiagent.plugin");
        boolean r4 = true;
        if (o.a(r9, r0) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L19;
        String r10 = d.o.o.b(d.o.o.a(r9, (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")), new char[]{'/'});
        File r8 = (File) ZeusTransformUtils.preCheckCast(this.f21909b.invoke(), File.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L14;
        r4 = false;
    L14:
        if (r4 == false) goto L17;
        return r8;
    L17:
        return new File(r8, r10);
    L19:
        throw new IllegalArgumentException(("container path must be under share root (" + r0 + "): " + r9).toString());
    L5:
        if (d.o.o.b(r9, r0 + '/', false, 2, null) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void a(File r1, boolean r2, boolean r3, boolean r4) {
        File r0 = r1.getParentFile();
        if (r2 == false) goto L19;
        if (r0 == null) goto L19;
        if (r0.exists() == true) goto L19;
        if (r0.mkdirs() == false) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L19;
        throw new IllegalArgumentException(("createParents failed for host path: " + r0.getAbsolutePath()).toString());
    L10:
        if (r0.exists() == true) goto L13;
        r5 = false;
    L19:
        if (r1.exists() == true) goto L21;
        return;
    L21:
        if (r3 == false) goto L34;
        if (r1.isDirectory() == false) goto L29;
        if (r4 == true) goto L29;
        throw new IllegalStateException(("target is a directory but source is a file: " + r1.getAbsolutePath()).toString());
    L29:
        if (r1.isDirectory() == false) goto L31;
        k.h(r1);
        return;
    L31:
        r1.delete();
        return;
    L34:
        throw new IllegalArgumentException(("target exists and overwrite=false: " + r1.getAbsolutePath()).toString());
    }

    private final void a(File r2, boolean r3) {
        if (r3 == true) goto L5;
        return;
    L5:
        if (r2.isFile() == false) goto L17;
        boolean r1 = true;
        if (r2.setExecutable(true, false) == true) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException(("ensureExecutable failed: " + r2.getAbsolutePath()).toString());
    L9:
        if (r2.canExecute() == false) goto L11;
    L17:
        throw new IllegalArgumentException(("ensureExecutable requires a regular file: " + r2.getAbsolutePath()).toString());
    }

    private final void a(Path r9, Path r10, boolean r11, String r12) {
        Path r13 = (Path) ZeusTransformUtils.wrapperContextForParams(r9, Path.class, "com.obric.aiagent.plugin");
        Path r14 = (Path) ZeusTransformUtils.wrapperContextForParams(r10, Path.class, "com.obric.aiagent.plugin");
        if (r11 == false) goto L5;
        StandardCopyOption[] r4 = {StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE};
    L18:
        Files.move(r13, r14, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), CopyOption[].class, "com.obric.aiagent.plugin"));     // Catch: FileAlreadyExistsException -> L8 AtomicMoveNotSupportedException -> L10
        this.f21912e.invoke(new com.obric.aiagent.skill.virt.impl.a.b.a(r12, r13.toString(), r14.toString(), false));     // Catch: FileAlreadyExistsException -> L8 AtomicMoveNotSupportedException -> L10
        return;
    L10:
        this.f21912e.invoke(new com.obric.aiagent.skill.virt.impl.a.b.a(r12, r13.toString(), r14.toString(), true));
        if (Files.isDirectory(r13, new LinkOption[0]) == false) goto L13;
        a(r13, r14);
        a(r13);
        return;
    L13:
        if (r11 == false) goto L15;
        StandardCopyOption[] r8 = {StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES};
    L16:
        Files.copy(r13, r14, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), CopyOption[].class, "com.obric.aiagent.plugin"));
        Files.deleteIfExists(r13);
        return;
    L15:
        r8 = new StandardCopyOption[]{StandardCopyOption.COPY_ATTRIBUTES};
    L8:
        e = move-exception;
        throw e;
    L5:
        r4 = new StandardCopyOption[]{StandardCopyOption.ATOMIC_MOVE};
        goto L18
    }

    private final long a(Path r3, Path r4) {
        Path r2 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.aiagent.plugin");
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.aiagent.plugin");
        z.e r6 = new z.e();
        Files.walkFileTree(r2, (FileVisitor) ZeusTransformUtils.preCheckCast(new b(r2, r5, r6), FileVisitor.class, "com.obric.aiagent.plugin"));
        return r6.f38503a;
    }

    private final void a(Path r3) {
        Files.walkFileTree((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.aiagent.plugin"), (FileVisitor) ZeusTransformUtils.preCheckCast(new c(), FileVisitor.class, "com.obric.aiagent.plugin"));
    }

    private final long b(Path r4) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.aiagent.plugin");
        z.e r5 = new z.e();
        Files.walkFileTree(r3, (FileVisitor) ZeusTransformUtils.preCheckCast(new C0467d(r5), FileVisitor.class, "com.obric.aiagent.plugin"));
        return r5.f38503a;
    }

    private final void b(File r3) {
        if (r3.isDirectory() == false) goto L22;
        if (r3.canRead() == false) goto L20;
        String[] r2 = r3.list();
        boolean r0 = false;
        if (r2 != null) goto L9;
    L13:
        r0 = true;
    L15:
        if ((!r0) == false) goto L18;
        return;
    L18:
        throw new IllegalArgumentException(("HostDirectory source is empty: " + r3.getAbsolutePath()).toString());
    L9:
        if (r2.length != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L15;
    L11:
        r4 = false;
        goto L12
    L20:
        throw new IllegalArgumentException(("HostDirectory source is not readable: " + r3.getAbsolutePath()).toString());
    L22:
        throw new IllegalArgumentException(("HostDirectory source is not a directory: " + r3.getAbsolutePath()).toString());
    }

    private final long a(InputStream r4, File r5) {
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r5), Closeable.class, "com.obric.aiagent.plugin");
        long r6 = d.f.b.a(r4, (OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r3, FileOutputStream.class, "com.obric.aiagent.plugin"), OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L6
        d.f.c.a(r3, null);
        return r6;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        d.f.c.a(r3, th);
        throw th;
    }

    static {
        f21908a = new a(null);
        char[] r0 = "0123456789abcdef".toCharArray();
        o.c(r0, "toCharArray(...)");
        g = r0;
    }
}
