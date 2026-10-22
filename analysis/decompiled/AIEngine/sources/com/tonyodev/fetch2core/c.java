package com.tonyodev.fetch2core;

import com.tonyodev.fetch2core.server.FileRequest;
import java.net.InetSocketAddress;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c extends Downloader<ib.a, a> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public InetSocketAddress f8232a = new InetSocketAddress(0);

        /* renamed from: b, reason: collision with root package name */
        public FileRequest f8233b = new FileRequest(0, null, 0, 0, null, null, null, 0, 0, false, 1023, null);

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!a.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.FileServerDownloader.TransporterRequest");
            a aVar = (a) obj;
            return g.b(this.f8232a, aVar.f8232a) && g.b(this.f8233b, aVar.f8233b);
        }

        public final int hashCode() {
            return this.f8233b.hashCode() + (this.f8232a.hashCode() * 31);
        }

        public final String toString() {
            return "TransporterRequest(inetSocketAddress=" + this.f8232a + ", fileRequest=" + this.f8233b + ")";
        }
    }
}
