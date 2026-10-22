package h3;

import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;

/* renamed from: h3.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0599h implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    public final DiskLruCache f12912a;

    public C0599h(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        FileSystem fileSystem = FileSystem.SYSTEM;
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.f12912a = new DiskLruCache(fileSystem, directory, 201105, 2, SizeBasedTriggeringPolicy.DEFAULT_MAX_FILE_SIZE, TaskRunner.INSTANCE);
    }

    public final b0 a(V newRequest) throws IOException {
        Intrinsics.checkNotNullParameter(newRequest, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.f12912a.get(y0.e.c(newRequest.f12826a));
            if (snapshot == null) {
                return null;
            }
            try {
                C0596e c0596e = new C0596e(snapshot.getSource(0));
                H cachedRequest = c0596e.f12893b;
                String str = c0596e.f12894c;
                J url = c0596e.f12892a;
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                H h4 = c0596e.f12898g;
                String strA = h4.a("Content-Type");
                String strA2 = h4.a("Content-Length");
                U u4 = new U();
                Intrinsics.checkNotNullParameter(url, "url");
                u4.f12821a = url;
                u4.d(str, null);
                Intrinsics.checkNotNullParameter(cachedRequest, "headers");
                G gD = cachedRequest.d();
                Intrinsics.checkNotNullParameter(gD, "<set-?>");
                u4.f12823c = gD;
                V request = u4.b();
                a0 a0Var = new a0();
                Intrinsics.checkNotNullParameter(request, "request");
                a0Var.f12850a = request;
                T protocol = c0596e.f12895d;
                Intrinsics.checkNotNullParameter(protocol, "protocol");
                a0Var.f12851b = protocol;
                a0Var.f12852c = c0596e.f12896e;
                String message = c0596e.f12897f;
                Intrinsics.checkNotNullParameter(message, "message");
                a0Var.f12853d = message;
                a0Var.c(h4);
                a0Var.f12856g = new C0595d(snapshot, strA, strA2);
                a0Var.f12854e = c0596e.f12899h;
                a0Var.f12860k = c0596e.f12900i;
                a0Var.f12861l = c0596e.f12901j;
                b0 cachedResponse = a0Var.a();
                Intrinsics.checkNotNullParameter(newRequest, "request");
                Intrinsics.checkNotNullParameter(cachedResponse, "response");
                if (Intrinsics.areEqual(url, newRequest.f12826a) && Intrinsics.areEqual(str, newRequest.f12827b)) {
                    Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
                    Intrinsics.checkNotNullParameter(cachedRequest, "cachedRequest");
                    Intrinsics.checkNotNullParameter(newRequest, "newRequest");
                    Set<String> setJ = y0.e.j(cachedResponse.f12869f);
                    if (!(setJ instanceof Collection) || !setJ.isEmpty()) {
                        for (String name : setJ) {
                            List listG = cachedRequest.g(name);
                            Intrinsics.checkNotNullParameter(name, "name");
                            if (!Intrinsics.areEqual(listG, newRequest.f12828c.g(name))) {
                            }
                        }
                    }
                    return cachedResponse;
                }
                f0 f0Var = cachedResponse.f12870g;
                if (f0Var != null) {
                    Util.closeQuietly(f0Var);
                }
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f12912a.close();
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        this.f12912a.flush();
    }
}
