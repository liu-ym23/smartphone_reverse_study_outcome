package Xa;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlinx.coroutines.flow.SharedFlowImpl;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"LXa/q;", "LYa/c;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "<init>", "()V", "flow", "", "c", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)Z", "", "Le9/c;", "LY8/t;", Const.INTENT_KEY_UMID, "(Lkotlinx/coroutines/flow/SharedFlowImpl;)[Le9/c;", "", Const.INTENT_KEY_APIKEY, "J", "index", Const.INTENT_KEY_PKGNAME, "Le9/c;", "cont", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class q extends Ya.c<SharedFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long index = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public InterfaceC4014c<? super Y8.t> cont;

    @Override // Ya.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(SharedFlowImpl<?> flow) {
        if (this.index >= 0) {
            return false;
        }
        this.index = flow.Y();
        return true;
    }

    @Override // Ya.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC4014c<Y8.t>[] b(SharedFlowImpl<?> flow) {
        long j10 = this.index;
        this.index = -1L;
        this.cont = null;
        return flow.X(j10);
    }
}
