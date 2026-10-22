package stepai.aios.guiagent.pipeline;

import Aa.d;
import Aa.e;
import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.config.Action;
import za.g;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {1315, 1409, 1410, 1329, 1332, 1333, 1337, 1344, 1409, 1410, 1360, 1409, 1410, 1370, 1374, 1409, 1410, 1385, 1409, 1410, 1394, 1409, 1410, 1405, 1409, 1410, 1409, 1410}, m = "executeActionWithTakeoverCheck", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$executeActionWithTakeoverCheck$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public e f6058a;
    public za.e b;
    public Action c;
    public g d;
    public d e;
    public Object f;
    public Object g;
    public za.a h;
    public za.a i;

    /* renamed from: j, reason: collision with root package name */
    public za.a f6059j;
    public za.a k;
    public /* synthetic */ Object l;
    public final /* synthetic */ b m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$executeActionWithTakeoverCheck$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.m = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= Integer.MIN_VALUE;
        return this.m.o(null, null, null, null, this);
    }
}
