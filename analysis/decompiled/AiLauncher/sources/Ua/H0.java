package Ua;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LUa/H0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "LUa/I;", "dispatcher", "LUa/l;", "LY8/t;", "continuation", "<init>", "(LUa/I;LUa/l;)V", "run", "()V", Const.INTENT_KEY_APIKEY, "LUa/I;", Const.INTENT_KEY_PKGNAME, "LUa/l;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class H0 implements Runnable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final I dispatcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1066l<Y8.t> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public H0(I i10, InterfaceC1066l<? super Y8.t> interfaceC1066l) {
        this.dispatcher = i10;
        this.continuation = interfaceC1066l;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.continuation.t(this.dispatcher, Y8.t.f7040a);
    }
}
