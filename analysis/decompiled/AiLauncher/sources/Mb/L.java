package Mb;

import Mb.z;
import com.autonavi.aps.amapapi.config.Const;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 52\u00020\u0001:\u00016B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010\"J\u001f\u0010&\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\rH\u0016¢\u0006\u0004\b,\u0010'J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010/R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u00102R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00067"}, d2 = {"LMb/L;", "LMb/i;", "LMb/z;", "zipPath", "fileSystem", "", "LNb/n;", "entries", "", "comment", "<init>", "(LMb/z;LMb/i;Ljava/util/Map;Ljava/lang/String;)V", Const.JSON_KEY_DIR, "", "throwOnFailure", "", "I0", "(LMb/z;Z)Ljava/util/List;", "path", "LMb/h;", "Y", "(LMb/z;)LMb/h;", Const.STR_FILE, "LMb/g;", "e0", "(LMb/z;)LMb/g;", "U", "(LMb/z;)Ljava/util/List;", "LMb/I;", "v0", "(LMb/z;)LMb/I;", "mustCreate", "LMb/G;", "k0", "(LMb/z;Z)LMb/G;", "mustExist", "e", "LY8/t;", "m", "(LMb/z;Z)V", "source", "target", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/z;LMb/z;)V", "G", "D0", "(LMb/z;)LMb/z;", "LMb/z;", "f", "LMb/i;", "Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class L extends AbstractC0971i {

    /* renamed from: j, reason: collision with root package name */
    public static final z f4700j = z.Companion.e(z.INSTANCE, "/", false, 1, null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final z zipPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final AbstractC0971i fileSystem;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<z, Nb.n> entries;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final String comment;

    public L(z zipPath, AbstractC0971i fileSystem, Map<z, Nb.n> entries, String str) {
        kotlin.jvm.internal.p.i(zipPath, "zipPath");
        kotlin.jvm.internal.p.i(fileSystem, "fileSystem");
        kotlin.jvm.internal.p.i(entries, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = str;
    }

    private final List<z> I0(z dir, boolean throwOnFailure) throws IOException {
        Nb.n nVar = this.entries.get(D0(dir));
        if (nVar != null) {
            return Z8.F.m1(nVar.c());
        }
        if (!throwOnFailure) {
            return null;
        }
        throw new IOException("not a directory: " + dir);
    }

    public final z D0(z path) {
        return f4700j.m(path, true);
    }

    @Override // Mb.AbstractC0971i
    public void G(z path, boolean mustExist) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // Mb.AbstractC0971i
    public List<z> U(z dir) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        List<z> listI0 = I0(dir, true);
        kotlin.jvm.internal.p.f(listI0);
        return listI0;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060 A[Catch: all -> 0x004e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x004e, blocks: (B:8:0x0027, B:34:0x0060, B:22:0x004a, B:9:0x0033, B:19:0x0045), top: B:60:0x0027, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071  */
    @Override // Mb.AbstractC0971i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Mb.C0970h Y(Mb.z r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.String r0 = "path"
            kotlin.jvm.internal.p.i(r14, r0)
            Mb.z r14 = r13.D0(r14)
            java.util.Map<Mb.z, Nb.n> r0 = r13.entries
            java.lang.Object r14 = r0.get(r14)
            Nb.n r14 = (Nb.n) r14
            r1 = 0
            if (r14 != 0) goto L15
            return r1
        L15:
            long r2 = r14.getOffset()
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L72
            Mb.i r0 = r13.fileSystem
            Mb.z r13 = r13.zipPath
            Mb.g r13 = r0.e0(r13)
            long r2 = r14.getOffset()     // Catch: java.lang.Throwable -> L4e
            Mb.I r0 = r13.J(r2)     // Catch: java.lang.Throwable -> L4e
            Mb.f r2 = Mb.u.c(r0)     // Catch: java.lang.Throwable -> L4e
            Nb.n r14 = Nb.r.n(r2, r14)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.lang.Throwable -> L3d
            goto L3f
        L3d:
            r0 = move-exception
            goto L53
        L3f:
            r0 = r1
            goto L53
        L41:
            r0 = move-exception
            r14 = r0
            if (r2 == 0) goto L51
            r2.close()     // Catch: java.lang.Throwable -> L49
            goto L51
        L49:
            r0 = move-exception
            Y8.d.a(r14, r0)     // Catch: java.lang.Throwable -> L4e
            goto L51
        L4e:
            r0 = move-exception
            r14 = r0
            goto L61
        L51:
            r0 = r14
            r14 = r1
        L53:
            if (r0 != 0) goto L60
            if (r13 == 0) goto L5e
            r13.close()     // Catch: java.lang.Throwable -> L5b
            goto L5e
        L5b:
            r0 = move-exception
            r13 = r0
            goto L6e
        L5e:
            r13 = r1
            goto L6e
        L60:
            throw r0     // Catch: java.lang.Throwable -> L4e
        L61:
            if (r13 == 0) goto L6c
            r13.close()     // Catch: java.lang.Throwable -> L67
            goto L6c
        L67:
            r0 = move-exception
            r13 = r0
            Y8.d.a(r14, r13)
        L6c:
            r13 = r14
            r14 = r1
        L6e:
            if (r13 != 0) goto L71
            goto L72
        L71:
            throw r13
        L72:
            Mb.h r2 = new Mb.h
            boolean r13 = r14.getIsDirectory()
            r3 = r13 ^ 1
            boolean r4 = r14.getIsDirectory()
            boolean r13 = r14.getIsDirectory()
            if (r13 == 0) goto L86
        L84:
            r6 = r1
            goto L8f
        L86:
            long r0 = r14.getIo.ktor.http.ContentDisposition.Parameters.Size java.lang.String()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L84
        L8f:
            java.lang.Long r7 = r14.f()
            java.lang.Long r8 = r14.h()
            java.lang.Long r9 = r14.g()
            r11 = 128(0x80, float:1.8E-43)
            r12 = 0
            r5 = 0
            r10 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: Mb.L.Y(Mb.z):Mb.h");
    }

    @Override // Mb.AbstractC0971i
    public G e(z file, boolean mustExist) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // Mb.AbstractC0971i
    public AbstractC0969g e0(z file) {
        kotlin.jvm.internal.p.i(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // Mb.AbstractC0971i
    public void g(z source, z target) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // Mb.AbstractC0971i
    public G k0(z file, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // Mb.AbstractC0971i
    public void m(z dir, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // Mb.AbstractC0971i
    public I v0(z file) throws Throwable {
        InterfaceC0968f interfaceC0968f;
        kotlin.jvm.internal.p.i(file, "file");
        Nb.n nVar = this.entries.get(D0(file));
        if (nVar == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        AbstractC0969g abstractC0969gE0 = this.fileSystem.e0(this.zipPath);
        Throwable th = null;
        try {
            InterfaceC0968f interfaceC0968fC = u.c(abstractC0969gE0.J(nVar.getOffset()));
            if (abstractC0969gE0 != null) {
                try {
                    abstractC0969gE0.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            interfaceC0968f = interfaceC0968fC;
        } catch (Throwable th3) {
            if (abstractC0969gE0 != null) {
                try {
                    abstractC0969gE0.close();
                } catch (Throwable th4) {
                    Y8.d.a(th3, th4);
                }
            }
            interfaceC0968f = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        Nb.r.r(interfaceC0968f);
        return nVar.getCompressionMethod() == 0 ? w.e(interfaceC0968f, nVar.getIo.ktor.http.ContentDisposition.Parameters.Size java.lang.String(), false, 2, null) : u.d(new o(w.e(interfaceC0968f, nVar.getCompressedSize(), false, 2, null), new Inflater(true)), nVar.getIo.ktor.http.ContentDisposition.Parameters.Size java.lang.String(), true);
    }
}
