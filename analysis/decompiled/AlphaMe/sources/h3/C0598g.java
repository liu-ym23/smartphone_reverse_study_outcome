package h3;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;

/* renamed from: h3.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0598g implements CacheRequest {

    /* renamed from: a, reason: collision with root package name */
    public final DiskLruCache.Editor f12904a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.z f12905b;

    /* renamed from: c, reason: collision with root package name */
    public final C0597f f12906c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12907d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0599h f12908e;

    public C0598g(C0599h this$0, DiskLruCache.Editor editor) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.f12908e = this$0;
        this.f12904a = editor;
        k3.z zVarNewSink = editor.newSink(1);
        this.f12905b = zVarNewSink;
        this.f12906c = new C0597f(this$0, this, zVarNewSink);
    }

    @Override // okhttp3.internal.cache.CacheRequest
    public final void abort() throws IOException {
        synchronized (this.f12908e) {
            if (this.f12907d) {
                return;
            }
            this.f12907d = true;
            Util.closeQuietly(this.f12905b);
            try {
                this.f12904a.abort();
            } catch (IOException unused) {
            }
        }
    }

    @Override // okhttp3.internal.cache.CacheRequest
    public final k3.z body() {
        return this.f12906c;
    }
}
