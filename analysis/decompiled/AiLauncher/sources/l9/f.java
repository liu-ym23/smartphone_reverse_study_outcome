package l9;

import Y8.t;
import Z8.AbstractC1155c;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.AccessDeniedException;
import kotlin.io.FileWalkDirection;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u0016\u0018Bm\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR(\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ll9/f;", "LKa/j;", "Ljava/io/File;", "start", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/Function1;", "", "onEnter", "LY8/t;", "onLeave", "Lkotlin/Function2;", "Ljava/io/IOException;", "onFail", "", "maxDepth", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lp9/l;Lp9/l;Lp9/p;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "", "iterator", "()Ljava/util/Iterator;", Const.INTENT_KEY_APIKEY, "Ljava/io/File;", Const.INTENT_KEY_PKGNAME, "Lkotlin/io/FileWalkDirection;", "c", "Lp9/l;", Const.INTENT_KEY_UMID, "e", "Lp9/p;", "f", "I", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class f implements Ka.j<File> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final File start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final FileWalkDirection direction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<File, Boolean> onEnter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<File, t> onLeave;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final p<File, IOException, t> onFail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int maxDepth;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ll9/f$a;", "Ll9/f$c;", "Ljava/io/File;", "rootDir", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File rootDir) {
            super(rootDir);
            kotlin.jvm.internal.p.i(rootDir, "rootDir");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0006\u0010\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Ll9/f$b;", "LZ8/c;", "Ljava/io/File;", "<init>", "(Ll9/f;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Parameters.ROOT, "Ll9/f$a;", "f", "(Ljava/io/File;)Ll9/f$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/io/File;", "Ljava/util/ArrayDeque;", "Ll9/f$c;", "c", "Ljava/util/ArrayDeque;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_PKGNAME, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends AbstractC1155c<File> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final ArrayDeque<c> state;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"Ll9/f$b$a;", "Ll9/f$a;", "Ljava/io/File;", "rootDir", "<init>", "(Ll9/f$b;Ljava/io/File;)V", Const.INTENT_KEY_PKGNAME, "()Ljava/io/File;", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", Const.INTENT_KEY_UMID, "I", "fileIndex", "e", "failed", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class a extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public boolean rootVisited;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public File[] fileList;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            public int fileIndex;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            public boolean failed;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f36983f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, File rootDir) {
                super(rootDir);
                kotlin.jvm.internal.p.i(rootDir, "rootDir");
                this.f36983f = bVar;
            }

            @Override // l9.f.c
            public File b() {
                if (!this.failed && this.fileList == null) {
                    InterfaceC5074l interfaceC5074l = f.this.onEnter;
                    if (interfaceC5074l != null && !((Boolean) interfaceC5074l.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.fileList = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        p pVar = f.this.onFail;
                        if (pVar != null) {
                            pVar.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.failed = true;
                    }
                }
                File[] fileArr = this.fileList;
                if (fileArr != null) {
                    int i10 = this.fileIndex;
                    kotlin.jvm.internal.p.f(fileArr);
                    if (i10 < fileArr.length) {
                        File[] fileArr2 = this.fileList;
                        kotlin.jvm.internal.p.f(fileArr2);
                        int i11 = this.fileIndex;
                        this.fileIndex = i11 + 1;
                        return fileArr2[i11];
                    }
                }
                if (!this.rootVisited) {
                    this.rootVisited = true;
                    return getRoot();
                }
                InterfaceC5074l interfaceC5074l2 = f.this.onLeave;
                if (interfaceC5074l2 != null) {
                    interfaceC5074l2.invoke(getRoot());
                }
                return null;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"Ll9/f$b$b;", "Ll9/f$c;", "Ljava/io/File;", "rootFile", "<init>", "(Ll9/f$b;Ljava/io/File;)V", Const.INTENT_KEY_PKGNAME, "()Ljava/io/File;", "", "Z", "visited", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: l9.f$b$b, reason: collision with other inner class name */
        public final class C0469b extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public boolean visited;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f36985c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0469b(b bVar, File rootFile) {
                super(rootFile);
                kotlin.jvm.internal.p.i(rootFile, "rootFile");
                this.f36985c = bVar;
            }

            @Override // l9.f.c
            public File b() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return getRoot();
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Ll9/f$b$c;", "Ll9/f$a;", "Ljava/io/File;", "rootDir", "<init>", "(Ll9/f$b;Ljava/io/File;)V", Const.INTENT_KEY_PKGNAME, "()Ljava/io/File;", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", Const.INTENT_KEY_UMID, "I", "fileIndex", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class c extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public boolean rootVisited;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public File[] fileList;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            public int fileIndex;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b f36989e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, File rootDir) {
                super(rootDir);
                kotlin.jvm.internal.p.i(rootDir, "rootDir");
                this.f36989e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // l9.f.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File b() {
                /*
                    r9 = this;
                    boolean r0 = r9.rootVisited
                    r1 = 0
                    if (r0 != 0) goto L28
                    l9.f$b r0 = r9.f36989e
                    l9.f r0 = l9.f.this
                    p9.l r0 = l9.f.e(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r9.getRoot()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r9.rootVisited = r0
                    java.io.File r9 = r9.getRoot()
                    return r9
                L28:
                    java.io.File[] r0 = r9.fileList
                    if (r0 == 0) goto L47
                    int r2 = r9.fileIndex
                    kotlin.jvm.internal.p.f(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L47
                L35:
                    l9.f$b r0 = r9.f36989e
                    l9.f r0 = l9.f.this
                    p9.l r0 = l9.f.g(r0)
                    if (r0 == 0) goto L46
                    java.io.File r9 = r9.getRoot()
                    r0.invoke(r9)
                L46:
                    return r1
                L47:
                    java.io.File[] r0 = r9.fileList
                    if (r0 != 0) goto L92
                    java.io.File r0 = r9.getRoot()
                    java.io.File[] r0 = r0.listFiles()
                    r9.fileList = r0
                    if (r0 != 0) goto L76
                    l9.f$b r0 = r9.f36989e
                    l9.f r0 = l9.f.this
                    p9.p r0 = l9.f.f(r0)
                    if (r0 == 0) goto L76
                    java.io.File r2 = r9.getRoot()
                    kotlin.io.AccessDeniedException r3 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r9.getRoot()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r3)
                L76:
                    java.io.File[] r0 = r9.fileList
                    if (r0 == 0) goto L80
                    kotlin.jvm.internal.p.f(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L92
                L80:
                    l9.f$b r0 = r9.f36989e
                    l9.f r0 = l9.f.this
                    p9.l r0 = l9.f.g(r0)
                    if (r0 == 0) goto L91
                    java.io.File r9 = r9.getRoot()
                    r0.invoke(r9)
                L91:
                    return r1
                L92:
                    java.io.File[] r0 = r9.fileList
                    kotlin.jvm.internal.p.f(r0)
                    int r1 = r9.fileIndex
                    int r2 = r1 + 1
                    r9.fileIndex = r2
                    r9 = r0[r1]
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: l9.f.b.c.b():java.io.File");
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class d {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f36990a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f36990a = iArr;
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.state = arrayDeque;
            if (f.this.start.isDirectory()) {
                arrayDeque.push(f(f.this.start));
            } else if (f.this.start.isFile()) {
                arrayDeque.push(new C0469b(this, f.this.start));
            } else {
                b();
            }
        }

        @Override // Z8.AbstractC1155c
        public void a() {
            File fileG = g();
            if (fileG != null) {
                c(fileG);
            } else {
                b();
            }
        }

        public final a f(File root) {
            int i10 = d.f36990a[f.this.direction.ordinal()];
            if (i10 == 1) {
                return new c(this, root);
            }
            if (i10 == 2) {
                return new a(this, root);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final File g() {
            File fileB;
            while (true) {
                c cVarPeek = this.state.peek();
                if (cVarPeek == null) {
                    return null;
                }
                fileB = cVarPeek.b();
                if (fileB == null) {
                    this.state.pop();
                } else {
                    if (kotlin.jvm.internal.p.d(fileB, cVarPeek.getRoot()) || !fileB.isDirectory() || this.state.size() >= f.this.maxDepth) {
                        break;
                    }
                    this.state.push(f(fileB));
                }
            }
            return fileB;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Ll9/f$c;", "", "Ljava/io/File;", Parameters.ROOT, "<init>", "(Ljava/io/File;)V", Const.INTENT_KEY_PKGNAME, "()Ljava/io/File;", Const.INTENT_KEY_APIKEY, "Ljava/io/File;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final File root;

        public c(File root) {
            kotlin.jvm.internal.p.i(root, "root");
            this.root = root;
        }

        /* renamed from: a, reason: from getter */
        public final File getRoot() {
            return this.root;
        }

        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(File file, FileWalkDirection fileWalkDirection, InterfaceC5074l<? super File, Boolean> interfaceC5074l, InterfaceC5074l<? super File, t> interfaceC5074l2, p<? super File, ? super IOException, t> pVar, int i10) {
        this.start = file;
        this.direction = fileWalkDirection;
        this.onEnter = interfaceC5074l;
        this.onLeave = interfaceC5074l2;
        this.onFail = pVar;
        this.maxDepth = i10;
    }

    @Override // Ka.j
    public Iterator<File> iterator() {
        return new b();
    }

    public /* synthetic */ f(File file, FileWalkDirection fileWalkDirection, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, p pVar, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(file, (i11 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, interfaceC5074l, interfaceC5074l2, pVar, (i11 & 32) != 0 ? Integer.MAX_VALUE : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        kotlin.jvm.internal.p.i(start, "start");
        kotlin.jvm.internal.p.i(direction, "direction");
    }
}
