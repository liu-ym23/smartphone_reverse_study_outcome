package Mb;

import Mb.z;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 /2\u00060\u0001j\u0002`\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u000bH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u000bH&¢\u0006\u0004\b \u0010\u001cJ\u0015\u0010!\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\u001eJ!\u0010#\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u000bH&¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b%\u0010$J\u0015\u0010&\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H&¢\u0006\u0004\b*\u0010+J!\u0010,\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u000bH&¢\u0006\u0004\b,\u0010$J\u0015\u0010-\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b-\u0010'J\u000f\u0010.\u001a\u00020\"H\u0016¢\u0006\u0004\b.\u0010\u0004¨\u00060"}, d2 = {"LMb/i;", "Ljava/io/Closeable;", "Lokio/Closeable;", "<init>", "()V", "LMb/z;", "path", "LMb/h;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(LMb/z;)LMb/h;", "Y", "", "J", "(LMb/z;)Z", Const.JSON_KEY_DIR, "", "U", "(LMb/z;)Ljava/util/List;", Const.STR_FILE, "LMb/g;", "e0", "(LMb/z;)LMb/g;", "LMb/I;", "v0", "(LMb/z;)LMb/I;", "mustCreate", "LMb/G;", "k0", "(LMb/z;Z)LMb/G;", "g0", "(LMb/z;)LMb/G;", "mustExist", "e", Const.INTENT_KEY_PKGNAME, "LY8/t;", "m", "(LMb/z;Z)V", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LMb/z;)V", "source", "target", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/z;LMb/z;)V", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "close", Const.INTENT_KEY_APIKEY, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0971i implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC0971i f4735b;

    /* renamed from: c, reason: collision with root package name */
    public static final z f4736c;

    /* renamed from: d, reason: collision with root package name */
    public static final AbstractC0971i f4737d;

    static {
        AbstractC0971i rVar;
        try {
            Class.forName("java.nio.file.Files");
            rVar = new t();
        } catch (ClassNotFoundException unused) {
            rVar = new r();
        }
        f4735b = rVar;
        z.Companion companion = z.INSTANCE;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.p.h(property, "getProperty(...)");
        f4736c = z.Companion.e(companion, property, false, 1, null);
        ClassLoader classLoader = Nb.l.class.getClassLoader();
        kotlin.jvm.internal.p.h(classLoader, "getClassLoader(...)");
        f4737d = new Nb.l(classLoader, false, null, 4, null);
    }

    public static /* synthetic */ void n(AbstractC0971i abstractC0971i, z zVar, boolean z10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        abstractC0971i.m(zVar, z10);
    }

    public final void A(z path) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        G(path, false);
    }

    public abstract void G(z path, boolean mustExist) throws IOException;

    public final boolean J(z path) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        return Nb.d.b(this, path);
    }

    public abstract List<z> U(z dir) throws IOException;

    public final C0970h V(z path) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        return Nb.d.c(this, path);
    }

    public abstract C0970h Y(z path) throws IOException;

    public final G b(z file) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        return e(file, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract G e(z file, boolean mustExist) throws IOException;

    public abstract AbstractC0969g e0(z file) throws IOException;

    public abstract void g(z source, z target) throws IOException;

    public final G g0(z file) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        return k0(file, false);
    }

    public final void i(z dir) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        l(dir, false);
    }

    public abstract G k0(z file, boolean mustCreate) throws IOException;

    public final void l(z dir, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        Nb.d.a(this, dir, mustCreate);
    }

    public abstract void m(z dir, boolean mustCreate) throws IOException;

    public abstract I v0(z file) throws IOException;
}
