package coil.disk;

import Mb.AbstractC0971i;
import Mb.z;
import Ua.I;
import coil.disk.DiskLruCache;
import coil.disk.a;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0003\u001a\u000f\u0012B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\f*\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010 ¨\u0006\""}, d2 = {"Lcoil/disk/b;", "Lcoil/disk/a;", "", "maxSize", "LMb/z;", "directory", "LMb/i;", "fileSystem", "LUa/I;", "cleanupDispatcher", "<init>", "(JLMb/z;LMb/i;LUa/I;)V", "", "key", "Lcoil/disk/a$c;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcoil/disk/a$c;", "Lcoil/disk/a$b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcoil/disk/a$b;", "e", "(Ljava/lang/String;)Ljava/lang/String;", "J", Const.INTENT_KEY_UMID, "()J", "LMb/z;", "c", "()LMb/z;", "LMb/i;", "getFileSystem", "()LMb/i;", "Lcoil/disk/DiskLruCache;", "Lcoil/disk/DiskLruCache;", "cache", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long maxSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final z directory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AbstractC0971i fileSystem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final DiskLruCache cache;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcoil/disk/b$b;", "Lcoil/disk/a$b;", "Lcoil/disk/DiskLruCache$b;", "Lcoil/disk/DiskLruCache;", "editor", "<init>", "(Lcoil/disk/DiskLruCache$b;)V", "Lcoil/disk/b$c;", "c", "()Lcoil/disk/b$c;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "Lcoil/disk/DiskLruCache$b;", "LMb/z;", "getMetadata", "()LMb/z;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: coil.disk.b$b, reason: collision with other inner class name */
    public static final class C0197b implements a.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final DiskLruCache.b editor;

        public C0197b(DiskLruCache.b bVar) {
            this.editor = bVar;
        }

        @Override // coil.disk.a.b
        public void b() {
            this.editor.a();
        }

        @Override // coil.disk.a.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public c a() {
            DiskLruCache.d dVarC = this.editor.c();
            if (dVarC != null) {
                return new c(dVarC);
            }
            return null;
        }

        @Override // coil.disk.a.b
        public z getData() {
            return this.editor.f(1);
        }

        @Override // coil.disk.a.b
        public z getMetadata() {
            return this.editor.f(0);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcoil/disk/b$c;", "Lcoil/disk/a$c;", "Lcoil/disk/DiskLruCache$d;", "Lcoil/disk/DiskLruCache;", "snapshot", "<init>", "(Lcoil/disk/DiskLruCache$d;)V", "LY8/t;", "close", "()V", "Lcoil/disk/b$b;", Const.INTENT_KEY_PKGNAME, "()Lcoil/disk/b$b;", Const.INTENT_KEY_APIKEY, "Lcoil/disk/DiskLruCache$d;", "LMb/z;", "getMetadata", "()LMb/z;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements a.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final DiskLruCache.d snapshot;

        public c(DiskLruCache.d dVar) {
            this.snapshot = dVar;
        }

        @Override // coil.disk.a.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0197b P0() {
            DiskLruCache.b bVarB = this.snapshot.b();
            if (bVarB != null) {
                return new C0197b(bVarB);
            }
            return null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.snapshot.close();
        }

        @Override // coil.disk.a.c
        public z getData() {
            return this.snapshot.e(1);
        }

        @Override // coil.disk.a.c
        public z getMetadata() {
            return this.snapshot.e(0);
        }
    }

    public b(long j10, z zVar, AbstractC0971i abstractC0971i, I i10) {
        this.maxSize = j10;
        this.directory = zVar;
        this.fileSystem = abstractC0971i;
        this.cache = new DiskLruCache(getFileSystem(), getDirectory(), i10, getMaxSize(), 1, 2);
    }

    @Override // coil.disk.a
    public a.b a(String key) {
        DiskLruCache.b bVarD0 = this.cache.D0(e(key));
        if (bVarD0 != null) {
            return new C0197b(bVarD0);
        }
        return null;
    }

    @Override // coil.disk.a
    public a.c b(String key) {
        DiskLruCache.d dVarI0 = this.cache.I0(e(key));
        if (dVarI0 != null) {
            return new c(dVarI0);
        }
        return null;
    }

    /* renamed from: c, reason: from getter */
    public z getDirectory() {
        return this.directory;
    }

    /* renamed from: d, reason: from getter */
    public long getMaxSize() {
        return this.maxSize;
    }

    public final String e(String str) {
        return ByteString.INSTANCE.d(str).J().t();
    }

    @Override // coil.disk.a
    public AbstractC0971i getFileSystem() {
        return this.fileSystem;
    }
}
