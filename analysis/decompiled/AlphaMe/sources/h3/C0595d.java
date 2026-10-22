package h3;

import f1.AbstractC0557a;
import java.util.regex.Pattern;
import k3.InterfaceC0696k;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;

/* renamed from: h3.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0595d extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final DiskLruCache.Snapshot f12883a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12884b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12885c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.v f12886d;

    public C0595d(DiskLruCache.Snapshot snapshot, String str, String str2) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.f12883a = snapshot;
        this.f12884b = str;
        this.f12885c = str2;
        this.f12886d = AbstractC0557a.h(new C0594c(snapshot.getSource(1), this));
    }

    @Override // h3.f0
    public final long contentLength() {
        String str = this.f12885c;
        if (str == null) {
            return -1L;
        }
        return Util.toLongOrDefault(str, -1L);
    }

    @Override // h3.f0
    public final M contentType() {
        String str = this.f12884b;
        if (str == null) {
            return null;
        }
        Pattern pattern = M.f12732d;
        return C0611u.t(str);
    }

    @Override // h3.f0
    public final InterfaceC0696k source() {
        return this.f12886d;
    }
}
