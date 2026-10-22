package kotlinx.coroutines;

import Y8.t;
import cb.j;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.q;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class JobSupport$onAwaitInternal$1 extends FunctionReferenceImpl implements q<JobSupport, j<?>, Object, t> {

    /* renamed from: a, reason: collision with root package name */
    public static final JobSupport$onAwaitInternal$1 f36258a = new JobSupport$onAwaitInternal$1();

    public JobSupport$onAwaitInternal$1() {
        super(3, JobSupport.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // p9.q
    public /* bridge */ /* synthetic */ t invoke(JobSupport jobSupport, j<?> jVar, Object obj) {
        l(jobSupport, jVar, obj);
        return t.f7040a;
    }

    public final void l(JobSupport jobSupport, j<?> jVar, Object obj) {
        jobSupport.w0(jVar, obj);
    }
}
