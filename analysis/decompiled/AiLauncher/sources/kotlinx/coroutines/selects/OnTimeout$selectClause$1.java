package kotlinx.coroutines.selects;

import Y8.t;
import cb.j;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.q;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements q<OnTimeout, j<?>, Object, t> {

    /* renamed from: a, reason: collision with root package name */
    public static final OnTimeout$selectClause$1 f36799a = new OnTimeout$selectClause$1();

    public OnTimeout$selectClause$1() {
        super(3, OnTimeout.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // p9.q
    public /* bridge */ /* synthetic */ t invoke(OnTimeout onTimeout, j<?> jVar, Object obj) {
        l(onTimeout, jVar, obj);
        return t.f7040a;
    }

    public final void l(OnTimeout onTimeout, j<?> jVar, Object obj) {
        onTimeout.d(jVar, obj);
    }
}
