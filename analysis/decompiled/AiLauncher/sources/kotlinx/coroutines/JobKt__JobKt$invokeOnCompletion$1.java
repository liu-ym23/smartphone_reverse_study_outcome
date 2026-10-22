package kotlinx.coroutines;

import Ua.AbstractC1088w0;
import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class JobKt__JobKt$invokeOnCompletion$1 extends FunctionReferenceImpl implements InterfaceC5074l<Throwable, t> {
    public JobKt__JobKt$invokeOnCompletion$1(Object obj) {
        super(1, obj, AbstractC1088w0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ t invoke(Throwable th) {
        l(th);
        return t.f7040a;
    }

    public final void l(Throwable th) {
        ((AbstractC1088w0) this.receiver).v(th);
    }
}
