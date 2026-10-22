package wb;

import fc.i;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements i<File> {

    /* renamed from: a, reason: collision with root package name */
    public final File f13655a;

    /* renamed from: b, reason: collision with root package name */
    public final FileWalkDirection f13656b;

    /* renamed from: c, reason: collision with root package name */
    public final l<File, Boolean> f13657c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a extends AbstractC0165c {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class b extends mb.b<File> {

        /* renamed from: c, reason: collision with root package name */
        public final ArrayDeque<AbstractC0165c> f13658c;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public final class a extends a {

            /* renamed from: b, reason: collision with root package name */
            public boolean f13660b;

            /* renamed from: c, reason: collision with root package name */
            public File[] f13661c;

            /* renamed from: d, reason: collision with root package name */
            public int f13662d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f13663e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f13664f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, File rootDir) {
                super(rootDir);
                g.f(rootDir, "rootDir");
                this.f13664f = bVar;
            }

            @Override // wb.c.AbstractC0165c
            public final File a() {
                boolean z = this.f13663e;
                File file = this.f13670a;
                if (!z && this.f13661c == null) {
                    l<File, Boolean> lVar = c.this.f13657c;
                    if (lVar != null && !lVar.invoke(file).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = file.listFiles();
                    this.f13661c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        this.f13663e = true;
                    }
                }
                File[] fileArr = this.f13661c;
                if (fileArr == null || this.f13662d >= fileArr.length) {
                    if (this.f13660b) {
                        return null;
                    }
                    this.f13660b = true;
                    return file;
                }
                g.c(fileArr);
                int i10 = this.f13662d;
                this.f13662d = i10 + 1;
                return fileArr[i10];
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: wb.c$b$b, reason: collision with other inner class name */
        public final class C0163b extends AbstractC0165c {

            /* renamed from: b, reason: collision with root package name */
            public boolean f13665b;

            @Override // wb.c.AbstractC0165c
            public final File a() {
                if (this.f13665b) {
                    return null;
                }
                this.f13665b = true;
                return this.f13670a;
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: wb.c$b$c, reason: collision with other inner class name */
        public final class C0164c extends a {

            /* renamed from: b, reason: collision with root package name */
            public boolean f13666b;

            /* renamed from: c, reason: collision with root package name */
            public File[] f13667c;

            /* renamed from: d, reason: collision with root package name */
            public int f13668d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b f13669e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0164c(b bVar, File rootDir) {
                super(rootDir);
                g.f(rootDir, "rootDir");
                this.f13669e = bVar;
            }

            @Override // wb.c.AbstractC0165c
            public final File a() {
                boolean z = this.f13666b;
                File file = this.f13670a;
                if (!z) {
                    l<File, Boolean> lVar = c.this.f13657c;
                    if (lVar != null && !lVar.invoke(file).booleanValue()) {
                        return null;
                    }
                    this.f13666b = true;
                    return file;
                }
                File[] fileArr = this.f13667c;
                if (fileArr != null && this.f13668d >= fileArr.length) {
                    return null;
                }
                if (fileArr == null) {
                    File[] fileArrListFiles = file.listFiles();
                    this.f13667c = fileArrListFiles;
                    if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                        return null;
                    }
                }
                File[] fileArr2 = this.f13667c;
                g.c(fileArr2);
                int i10 = this.f13668d;
                this.f13668d = i10 + 1;
                return fileArr2[i10];
            }
        }

        public b() {
            ArrayDeque<AbstractC0165c> arrayDeque = new ArrayDeque<>();
            this.f13658c = arrayDeque;
            File rootFile = c.this.f13655a;
            if (rootFile.isDirectory()) {
                arrayDeque.push(b(rootFile));
            } else if (!rootFile.isFile()) {
                this.f10545a = 2;
            } else {
                g.f(rootFile, "rootFile");
                arrayDeque.push(new C0163b(rootFile));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // mb.b
        public final void a() {
            T t8;
            File fileA;
            while (true) {
                ArrayDeque<AbstractC0165c> arrayDeque = this.f13658c;
                AbstractC0165c abstractC0165cPeek = arrayDeque.peek();
                if (abstractC0165cPeek == null) {
                    t8 = 0;
                    break;
                }
                fileA = abstractC0165cPeek.a();
                if (fileA == null) {
                    arrayDeque.pop();
                } else if (fileA.equals(abstractC0165cPeek.f13670a) || !fileA.isDirectory() || arrayDeque.size() >= Integer.MAX_VALUE) {
                    break;
                } else {
                    arrayDeque.push(b(fileA));
                }
            }
            t8 = fileA;
            if (t8 == 0) {
                this.f10545a = 2;
            } else {
                this.f10546b = t8;
                this.f10545a = 1;
            }
        }

        public final a b(File file) {
            int iOrdinal = c.this.f13656b.ordinal();
            if (iOrdinal == 0) {
                return new C0164c(this, file);
            }
            if (iOrdinal == 1) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: wb.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0165c {

        /* renamed from: a, reason: collision with root package name */
        public final File f13670a;

        public AbstractC0165c(File root) {
            g.f(root, "root");
            this.f13670a = root;
        }

        public abstract File a();
    }

    public c(File file, FileWalkDirection fileWalkDirection, l lVar) {
        this.f13655a = file;
        this.f13656b = fileWalkDirection;
        this.f13657c = lVar;
    }

    @Override // fc.i
    public final Iterator<File> iterator() {
        return new b();
    }
}
