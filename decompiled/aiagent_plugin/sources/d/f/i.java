package d.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.aa;
import d.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements d.n.j<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f38441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f38442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<File, Boolean> f38443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<File, x> f38444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.m<File, IOException, x> f38445e;
    private final int f;

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    private static abstract class a extends c {
        public a(File r2) {
            d.h.b.o.e(r2, "rootDir");
            super(r2);
            if (aa.f38393b == false) goto L10;
            boolean r1 = r2.isDirectory();
            if (aa.f38393b == false) goto L11;
            if (r1 == false) goto L9;
            return;
        L9:
            throw new AssertionError("rootDir must be verified to be directory beforehand.");
        L11:
            return;
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    private final class b extends d.a.b<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f38446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayDeque<c> f38447b;

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f38448a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f38449b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private File[] f38450c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f38451d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f38452e;

            public a(b r2, File r3) {
                d.h.b.o.e(r3, "rootDir");
                this.f38448a = r2;
                super(r3);
            }

            @Override // d.f.i.c
            public File a() {
                if (this.f38452e == false) goto L5;
            L19:
                File[] r0 = this.f38450c;
                if (r0 == null) goto L26;
                int r3 = this.f38451d;
                d.h.b.o.a(r0);
                if (r3 >= r0.length) goto L26;
                File[] r1 = this.f38450c;
                d.h.b.o.a(r1);
                int r2 = this.f38451d;
                this.f38451d = r2 + 1;
                return r1[r2];
            L26:
                if (this.f38449b == true) goto L29;
                this.f38449b = true;
                return b();
            L29:
                d.h.a.b r4 = i.f(this.f38448a.f38446a);
                if (r4 == null) goto L32;
                r4.invoke(b());
            L32:
                return null;
            L5:
                if (this.f38450c != null) goto L19;
                d.h.a.b r5 = i.d(this.f38448a.f38446a);
                boolean r6 = false;
                if (r5 != null) goto L9;
            L11:
                if (r6 == false) goto L13;
                return null;
            L13:
                File[] r7 = b().listFiles();
                this.f38450c = r7;
                if (r7 != null) goto L19;
                d.h.a.m r8 = i.e(this.f38448a.f38446a);
                if (r8 == null) goto L18;
                r8.invoke(b(), new d.f.a(b(), null, "Cannot list files in a directory", 2, null));
            L18:
                this.f38452e = true;
                goto L19
            L9:
                if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(b()), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L11;
                r6 = true;
                goto L11
            }
        }

        /* JADX INFO: renamed from: d.f.i$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class C1040b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f38453a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f38454b;

            public C1040b(b r2, File r3) {
                d.h.b.o.e(r3, "rootFile");
                this.f38453a = r2;
                super(r3);
                if (aa.f38393b == false) goto L10;
                boolean r1 = r3.isFile();
                if (aa.f38393b == false) goto L11;
                if (r1 == false) goto L9;
                return;
            L9:
                throw new AssertionError("rootFile must be verified to be file beforehand.");
            L11:
                return;
            }

            @Override // d.f.i.c
            public File a() {
                if (this.f38454b == false) goto L6;
                return null;
            L6:
                this.f38454b = true;
                return b();
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f38455a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f38456b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private File[] f38457c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f38458d;

            public c(b r2, File r3) {
                d.h.b.o.e(r3, "rootDir");
                this.f38455a = r2;
                super(r3);
            }

            @Override // d.f.i.c
            public File a() {
                if (this.f38456b == true) goto L13;
                d.h.a.b r0 = i.d(this.f38455a.f38446a);
                boolean r2 = false;
                if (r0 != null) goto L7;
            L9:
                if (r2 == false) goto L11;
                return null;
            L11:
                this.f38456b = true;
                return b();
            L7:
                if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(b()), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L9;
                r2 = true;
                goto L9
            L13:
                File[] r1 = this.f38457c;
                if (r1 == null) goto L23;
                int r3 = this.f38458d;
                d.h.b.o.a(r1);
                if (r3 < r1.length) goto L23;
                d.h.a.b r4 = i.f(this.f38455a.f38446a);
                if (r4 == null) goto L21;
                r4.invoke(b());
            L21:
                return null;
            L23:
                if (this.f38457c != null) goto L37;
                File[] r5 = b().listFiles();
                this.f38457c = r5;
                if (r5 != null) goto L29;
                d.h.a.m r6 = i.e(this.f38455a.f38446a);
                if (r6 == null) goto L29;
                r6.invoke(b(), new d.f.a(b(), null, "Cannot list files in a directory", 2, null));
            L29:
                File[] r7 = this.f38457c;
                if (r7 == null) goto L33;
                d.h.b.o.a(r7);
                if (r7.length != 0) goto L37;
            L33:
                d.h.a.b r8 = i.f(this.f38455a.f38446a);
                if (r8 == null) goto L36;
                r8.invoke(b());
            L36:
                return null;
            L37:
                File[] r9 = this.f38457c;
                d.h.b.o.a(r9);
                int r10 = this.f38458d;
                this.f38458d = r10 + 1;
                return r9[r10];
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public /* synthetic */ class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f38459a = null;

            static {
                int[] r0 = new int[j.values().length];
                r0[j.f38461a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[j.f38462b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f38459a = r0;
            }
        }

        public b(i r3) {
            this.f38446a = r3;
            ArrayDeque<c> r0 = new ArrayDeque();
            this.f38447b = r0;
            if (i.a(r3).isDirectory() == false) goto L6;
            r0.push(a(i.a(r3)));
            return;
        L6:
            if (i.a(r3).isFile() == false) goto L8;
            r0.push(new C1040b(this, i.a(r3)));
            return;
        L8:
            b();
        }

        @Override // d.a.b
        public void a() {
            File r0 = c();
            if (r0 == null) goto L5;
            a(r0);
            return;
        L5:
            b();
        }

        private final a a(File r4) {
            j r0 = i.b(this.f38446a);
            int r1 = d.f38459a[r0.ordinal()];
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L8;
            return (a) ZeusTransformUtils.preCheckCast(new a(this, r4), a.class, "com.obric.aiagent.plugin");
        L8:
            throw new d.k();
        L10:
            return (a) ZeusTransformUtils.preCheckCast(new c(this, r4), a.class, "com.obric.aiagent.plugin");
        }

        private final File c() {
        L2:
            c r0 = (c) ZeusTransformUtils.preCheckCast(this.f38447b.peek(), c.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L4;
            File r1 = r0.a();
            if (r1 == null) goto L8;
            if (d.h.b.o.a(r1, r0.b()) == true) goto L17;
            if (r1.isDirectory() == false) goto L17;
            if (this.f38447b.size() >= i.c(this.f38446a)) goto L17;
            this.f38447b.push(a(r1));
        L17:
            return r1;
        L8:
            this.f38447b.pop();
            goto L2
        L4:
            return null;
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    private static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f38460a;

        public abstract File a();

        public c(File r2) {
            d.h.b.o.e(r2, "root");
            this.f38460a = r2;
        }

        public final File b() {
            return this.f38460a;
        }
    }

    private i(File r3, j r4, d.h.a.b<? super File, Boolean> r5, d.h.a.b<? super File, x> r6, d.h.a.m<? super File, ? super IOException, x> r7, int r8) {
        d.h.a.b<File, Boolean> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<File, x> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m<File, IOException, x> r11 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.m.class, "com.obric.aiagent.plugin");
        this.f38441a = r3;
        this.f38442b = r4;
        this.f38443c = r9;
        this.f38444d = r10;
        this.f38445e = r11;
        this.f = r8;
    }

    public static final /* synthetic */ File a(i r0) {
        return r0.f38441a;
    }

    public static final /* synthetic */ j b(i r0) {
        return r0.f38442b;
    }

    public static final /* synthetic */ int c(i r0) {
        return r0.f;
    }

    public static final /* synthetic */ d.h.a.b d(i r0) {
        return r0.f38443c;
    }

    public static final /* synthetic */ d.h.a.m e(i r0) {
        return r0.f38445e;
    }

    public static final /* synthetic */ d.h.a.b f(i r0) {
        return r0.f38444d;
    }

    /* synthetic */ i(File r6, j r7, d.h.a.b r8, d.h.a.b r9, d.h.a.m r10, int r11, int r12, d.h.b.h r13) {
        d.h.a.b r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r1 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r12 & 2) == 0) goto L5;
        j r3 = j.f38461a;
    L7:
        if ((r12 & 32) == 0) goto L9;
        int r4 = Integer.MAX_VALUE;
    L10:
        this(r6, r3, r0, r2, r1, r4);
        return;
    L9:
        r4 = r11;
        goto L10
    L5:
        r3 = r7;
        goto L7
    }

    public i(File r11, j r12) {
        d.h.b.o.e(r11, "start");
        d.h.b.o.e(r12, "direction");
        this(r11, r12, null, null, null, 0, 32, null);
    }

    @Override // d.n.j
    public Iterator<File> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new b(this), Iterator.class, "com.obric.aiagent.plugin");
    }

    public final i a(d.h.a.m<? super File, ? super IOException, x> r8) {
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "function");
        return new i(this.f38441a, this.f38442b, this.f38443c, this.f38444d, r5, this.f);
    }
}
