package stepai.aios.guiagent.pipeline;

import Aa.d;
import Aa.e;
import J7.c;
import androidx.core.view.PointerIconCompat;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import za.g;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {PointerIconCompat.TYPE_GRAB, 1026, 2381}, m = "awaitNextAction", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitNextAction$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public e f6038a;
    public za.e b;
    public g c;
    public AtomicReference d;
    public AtomicReference e;
    public String f;
    public d g;
    public String h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public String f6039j;
    public boolean k;
    public /* synthetic */ Object l;
    public final /* synthetic */ b m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$awaitNextAction$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.m = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= Integer.MIN_VALUE;
        return this.m.e(null, null, null, null, this);
    }
}
