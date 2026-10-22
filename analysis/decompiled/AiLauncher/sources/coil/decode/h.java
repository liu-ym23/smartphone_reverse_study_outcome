package coil.decode;

import F1.j;
import Mb.AbstractC0971i;
import Mb.InterfaceC0968f;
import Mb.u;
import Mb.z;
import coil.decode.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcoil/decode/h;", "Lcoil/decode/e;", "LMb/f;", "source", "Lkotlin/Function0;", "Ljava/io/File;", "cacheDirectoryFactory", "Lcoil/decode/e$a;", "metadata", "<init>", "(LMb/f;Lp9/a;Lcoil/decode/e$a;)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "e", "()LMb/f;", "close", Const.INTENT_KEY_APIKEY, "Lcoil/decode/e$a;", Const.INTENT_KEY_PKGNAME, "()Lcoil/decode/e$a;", "", "Z", "isClosed", "c", "LMb/f;", Const.INTENT_KEY_UMID, "Lp9/a;", "LMb/z;", "LMb/z;", Const.STR_FILE, "LMb/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LMb/i;", "fileSystem", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final e.a metadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean isClosed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public InterfaceC0968f source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<? extends File> cacheDirectoryFactory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public z file;

    public h(InterfaceC0968f interfaceC0968f, InterfaceC5063a<? extends File> interfaceC5063a, e.a aVar) {
        super(null);
        this.metadata = aVar;
        this.source = interfaceC0968f;
        this.cacheDirectoryFactory = interfaceC5063a;
    }

    private final void g() {
        if (this.isClosed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
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
            z zVar = this.file;
            if (zVar != null) {
                i().A(zVar);
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
        AbstractC0971i abstractC0971iI = i();
        z zVar = this.file;
        p.f(zVar);
        InterfaceC0968f interfaceC0968fC = u.c(abstractC0971iI.v0(zVar));
        this.source = interfaceC0968fC;
        return interfaceC0968fC;
    }

    public AbstractC0971i i() {
        return AbstractC0971i.f4735b;
    }
}
