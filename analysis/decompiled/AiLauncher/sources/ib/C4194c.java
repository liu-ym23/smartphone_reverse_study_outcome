package ib;

import La.D;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u001b\u0010\u0005\u001a\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u001a\u0010\u0011\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012*\n\u0010\u0014\"\u00020\u00132\u00020\u0013¨\u0006\u0015"}, d2 = {"Lib/d;", Const.INTENT_KEY_APIKEY, "LY8/h;", "getMover", "()Lib/d;", "mover", "Lib/a;", Const.INTENT_KEY_PKGNAME, "Lib/a;", "SystemFileSystem", "Lib/f;", "c", "Lib/f;", "SystemTemporaryDirectory", "", Const.INTENT_KEY_UMID, "Z", "isWindows", "()Z", "Ljava/io/FileNotFoundException;", "FileNotFoundException", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: ib.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4194c {

    /* renamed from: a, reason: collision with root package name */
    public static final Y8.h f33131a = C4848b.b(new InterfaceC5063a() { // from class: ib.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return C4194c.b();
        }
    });

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC4192a f33132b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final f f33133c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f33134d;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"ib/c$a", "Lib/h;", "Lib/f;", "path", "", Const.INTENT_KEY_APIKEY, "(Lib/f;)Z", "mustExist", "LY8/t;", Const.INTENT_KEY_UMID, "(Lib/f;Z)V", "c", "(Lib/f;)Lib/f;", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: ib.c$a */
    public static final class a extends h {
        @Override // ib.InterfaceC4192a
        public boolean a(f path) {
            p.i(path, "path");
            return path.getFile().exists();
        }

        @Override // ib.InterfaceC4192a
        public f c(f path) throws IOException {
            p.i(path, "path");
            if (!path.getFile().exists()) {
                throw new FileNotFoundException(path.getFile().getAbsolutePath());
            }
            File canonicalFile = path.getFile().getCanonicalFile();
            p.h(canonicalFile, "getCanonicalFile(...)");
            return new f(canonicalFile);
        }

        @Override // ib.InterfaceC4192a
        public void d(f path, boolean mustExist) throws IOException {
            p.i(path, "path");
            if (a(path)) {
                if (!path.getFile().delete()) {
                    throw new IOException("Deletion failed");
                }
            } else if (mustExist) {
                throw new FileNotFoundException("File does not exist: " + path.getFile());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"ib/c$b", "Lib/d;", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: ib.c$b */
    public static final class b implements InterfaceC4195d {
    }

    static {
        String property = System.getProperty("java.io.tmpdir");
        p.h(property, "getProperty(...)");
        f33133c = g.a(property);
        String property2 = System.getProperty("os.name");
        f33134d = property2 != null ? D.X(property2, "Windows", false, 2, null) : false;
    }

    public static final InterfaceC4195d b() throws ClassNotFoundException {
        try {
            Class.forName("java.nio.file.Files");
            return new C4196e();
        } catch (ClassNotFoundException unused) {
            return new b();
        }
    }
}
