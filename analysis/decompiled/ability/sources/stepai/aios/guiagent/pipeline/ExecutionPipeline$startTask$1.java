package stepai.aios.guiagent.pipeline;

import J7.c;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m9.c0;
import za.d;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {436, 338, 436, 436, 353, 363, 436, 371, 378, 381, 391, 396, TypedValues.CycleType.TYPE_VISIBILITY, 436, 414, 436, TypedValues.CycleType.TYPE_EASING, 436, TypedValues.CycleType.TYPE_WAVE_OFFSET, 436, 436}, m = "startTask$suspendImpl", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$startTask$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public b f6096a;
    public String b;
    public c0 c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public d i;

    /* renamed from: j, reason: collision with root package name */
    public Object f6097j;
    public Iterator k;
    public d l;
    public String m;
    public Object n;
    public Aa.d o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f6098q;

    /* renamed from: r, reason: collision with root package name */
    public /* synthetic */ Object f6099r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ b f6100s;

    /* renamed from: t, reason: collision with root package name */
    public int f6101t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$startTask$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f6100s = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6099r = obj;
        this.f6101t |= Integer.MIN_VALUE;
        return b.J(this.f6100s, null, this);
    }
}
