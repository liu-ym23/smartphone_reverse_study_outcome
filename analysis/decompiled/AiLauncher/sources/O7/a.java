package O7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.usearch.USearchNative;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00060\u0001j\u0002`\u0002B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u000fJ\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0004¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b \u0010\"\u001a\u0004\b%\u0010$R\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b*\u0010$R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010.¨\u00060"}, d2 = {"LO7/a;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "", "dimension", "metric", "connectivity", "expansionAdd", "expansionSearch", "<init>", "(IIIII)V", "", "capacity", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)Z", "addThreads", "searchThreads", "l", "(JII)Z", "key", Const.INTENT_KEY_BACKGROUND_COMMAND, ContentDisposition.Parameters.Size, "()J", "", "path", "e", "(Ljava/lang/String;)Z", "LY8/t;", "close", "()V", "finalize", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "I", "getDimension", "()I", "getMetric", "c", "getConnectivity", Const.INTENT_KEY_UMID, "getExpansionAdd", "getExpansionSearch", "f", "J", "handle", "Z", AlipayXuiIsland.REASON_CLOSED, "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int dimension;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int metric;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int connectivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int expansionAdd;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int expansionSearch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long handle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    public a(int i10, int i11, int i12, int i13, int i14) {
        this.dimension = i10;
        this.metric = i11;
        this.connectivity = i12;
        this.expansionAdd = i13;
        this.expansionSearch = i14;
        USearchNative uSearchNative = USearchNative.f31118a;
        if (!uSearchNative.a()) {
            uSearchNative.b();
        }
        long jNativeCreate = USearchNative.nativeCreate(i10, i11, i12, i13, i14);
        this.handle = jNativeCreate;
        if (jNativeCreate == 0) {
            throw new RuntimeException("Failed to create USearch index");
        }
    }

    public final void b() {
        if (this.closed) {
            throw new IllegalStateException("Index has been closed");
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        long j10 = this.handle;
        if (j10 != 0) {
            USearchNative.nativeDestroy(j10);
            this.handle = 0L;
            this.closed = true;
        }
    }

    public final boolean e(String path) {
        p.i(path, "path");
        b();
        return USearchNative.nativeLoad(this.handle, path);
    }

    public final void finalize() {
        close();
    }

    public final boolean g(long key) {
        b();
        return USearchNative.nativeRemove(this.handle, key);
    }

    public final boolean i(long capacity) {
        b();
        return USearchNative.nativeReserve(this.handle, capacity);
    }

    public final boolean l(long capacity, int addThreads, int searchThreads) {
        b();
        return USearchNative.nativeReserveWithThreads(this.handle, capacity, addThreads, searchThreads);
    }

    public final long size() {
        b();
        return USearchNative.nativeSize(this.handle);
    }
}
