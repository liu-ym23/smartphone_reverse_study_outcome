package coil.decode;

import F1.j;
import Mb.AbstractC0971i;
import Mb.InterfaceC0968f;
import Mb.u;
import Mb.z;
import coil.decode.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b\u0019\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010)¨\u0006+"}, d2 = {"Lcoil/decode/d;", "Lcoil/decode/e;", "LMb/z;", Const.STR_FILE, "LMb/i;", "fileSystem", "", "diskCacheKey", "Ljava/io/Closeable;", "closeable", "Lcoil/decode/e$a;", "metadata", "<init>", "(LMb/z;LMb/i;Ljava/lang/String;Ljava/io/Closeable;Lcoil/decode/e$a;)V", "LMb/f;", "e", "()LMb/f;", "LY8/t;", "close", "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "LMb/z;", "getFile$coil_base_release", "()LMb/z;", Const.INTENT_KEY_PKGNAME, "LMb/i;", "l", "()LMb/i;", "c", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "Ljava/io/Closeable;", "Lcoil/decode/e$a;", "()Lcoil/decode/e$a;", "", "f", "Z", "isClosed", "LMb/f;", "source", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final z file;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbstractC0971i fileSystem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String diskCacheKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Closeable closeable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final e.a metadata;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isClosed;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public InterfaceC0968f source;

    public d(z zVar, AbstractC0971i abstractC0971i, String str, Closeable closeable, e.a aVar) {
        super(null);
        this.file = zVar;
        this.fileSystem = abstractC0971i;
        this.diskCacheKey = str;
        this.closeable = closeable;
        this.metadata = aVar;
    }

    @Override // coil.decode.e
    /* renamed from: b, reason: from getter */
    public e.a getMetadata() {
        return this.metadata;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.isClosed = true;
            InterfaceC0968f interfaceC0968f = this.source;
            if (interfaceC0968f != null) {
                j.d(interfaceC0968f);
            }
            Closeable closeable = this.closeable;
            if (closeable != null) {
                j.d(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil.decode.e
    public synchronized InterfaceC0968f e() {
        g();
        InterfaceC0968f interfaceC0968f = this.source;
        if (interfaceC0968f != null) {
            return interfaceC0968f;
        }
        InterfaceC0968f interfaceC0968fC = u.c(getFileSystem().v0(this.file));
        this.source = interfaceC0968fC;
        return interfaceC0968fC;
    }

    public final void g() {
        if (this.isClosed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
    }

    /* renamed from: i, reason: from getter */
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    /* renamed from: l, reason: from getter */
    public AbstractC0971i getFileSystem() {
        return this.fileSystem;
    }
}
