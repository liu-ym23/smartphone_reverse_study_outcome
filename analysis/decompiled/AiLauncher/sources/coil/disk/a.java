package coil.disk;

import Mb.AbstractC0971i;
import Mb.z;
import Ua.I;
import Ua.Y;
import android.os.StatFs;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\u0010\u0005\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lcoil/disk/a;", "", "", "key", "Lcoil/disk/a$c;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcoil/disk/a$c;", "Lcoil/disk/a$b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcoil/disk/a$b;", "LMb/i;", "getFileSystem", "()LMb/i;", "getFileSystem$annotations", "()V", "fileSystem", "c", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface a {

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcoil/disk/a$a;", "", "<init>", "()V", "Ljava/io/File;", "directory", "c", "(Ljava/io/File;)Lcoil/disk/a$a;", "LMb/z;", Const.INTENT_KEY_PKGNAME, "(LMb/z;)Lcoil/disk/a$a;", "Lcoil/disk/a;", Const.INTENT_KEY_APIKEY, "()Lcoil/disk/a;", "LMb/z;", "LMb/i;", "LMb/i;", "fileSystem", "", "D", "maxSizePercent", "", Const.INTENT_KEY_UMID, "J", "minimumMaxSizeBytes", "e", "maximumMaxSizeBytes", "f", "maxSizeBytes", "LUa/I;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LUa/I;", "cleanupDispatcher", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: coil.disk.a$a, reason: collision with other inner class name */
    public static final class C0196a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public z directory;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public long maxSizeBytes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public AbstractC0971i fileSystem = AbstractC0971i.f4735b;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public double maxSizePercent = 0.02d;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public long minimumMaxSizeBytes = 10485760;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public long maximumMaxSizeBytes = 262144000;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public I cleanupDispatcher = Y.b();

        public final a a() {
            long jO;
            z zVar = this.directory;
            if (zVar == null) {
                throw new IllegalStateException("directory == null");
            }
            if (this.maxSizePercent > 0.0d) {
                try {
                    File file = zVar.toFile();
                    file.mkdir();
                    StatFs statFs = new StatFs(file.getAbsolutePath());
                    jO = C5685n.o((long) (this.maxSizePercent * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), this.minimumMaxSizeBytes, this.maximumMaxSizeBytes);
                } catch (Exception unused) {
                    jO = this.minimumMaxSizeBytes;
                }
            } else {
                jO = this.maxSizeBytes;
            }
            return new coil.disk.b(jO, zVar, this.fileSystem, this.cleanupDispatcher);
        }

        public final C0196a b(z directory) {
            this.directory = directory;
            return this;
        }

        public final C0196a c(File directory) {
            return b(z.Companion.d(z.INSTANCE, directory, false, 1, null));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcoil/disk/a$b;", "", "Lcoil/disk/a$c;", Const.INTENT_KEY_APIKEY, "()Lcoil/disk/a$c;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "LMb/z;", "getMetadata", "()LMb/z;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        c a();

        void b();

        z getData();

        z getMetadata();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcoil/disk/a$c;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Lcoil/disk/a$b;", "P0", "()Lcoil/disk/a$b;", "LMb/z;", "getMetadata", "()LMb/z;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface c extends Closeable {
        b P0();

        z getData();

        z getMetadata();
    }

    b a(String key);

    c b(String key);

    AbstractC0971i getFileSystem();
}
