package Za;

import Ua.InterfaceC1045a0;
import Ua.InterfaceC1066l;
import Ua.T;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0017¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"LZa/u;", "LUa/I;", "LUa/T;", "dispatcher", "", "name", "<init>", "(LUa/I;Ljava/lang/String;)V", "Lkotlin/coroutines/d;", "context", "", "l1", "(Lkotlin/coroutines/d;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LY8/t;", "h1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "k1", "toString", "()Ljava/lang/String;", "", "timeMillis", "LUa/l;", "continuation", "v0", "(JLUa/l;)V", "LUa/a0;", "U", "(JLjava/lang/Runnable;Lkotlin/coroutines/d;)LUa/a0;", "c", "LUa/I;", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class u extends Ua.I implements T {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ T f7759b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Ua.I dispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public u(Ua.I i10, String str) {
        T t10 = i10 instanceof T ? (T) i10 : null;
        this.f7759b = t10 == null ? Ua.P.a() : t10;
        this.dispatcher = i10;
        this.name = str;
    }

    @Override // Ua.T
    public InterfaceC1045a0 U(long timeMillis, Runnable block, kotlin.coroutines.d context) {
        return this.f7759b.U(timeMillis, block, context);
    }

    @Override // Ua.I
    public void h1(kotlin.coroutines.d context, Runnable block) {
        this.dispatcher.h1(context, block);
    }

    @Override // Ua.I
    public void k1(kotlin.coroutines.d context, Runnable block) {
        this.dispatcher.k1(context, block);
    }

    @Override // Ua.I
    public boolean l1(kotlin.coroutines.d context) {
        return this.dispatcher.l1(context);
    }

    @Override // Ua.I
    /* renamed from: toString, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // Ua.T
    public void v0(long timeMillis, InterfaceC1066l<? super Y8.t> continuation) {
        this.f7759b.v0(timeMillis, continuation);
    }
}
