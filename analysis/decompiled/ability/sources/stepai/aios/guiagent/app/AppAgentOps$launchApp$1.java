package stepai.aios.guiagent.app;

import J7.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.app.AppAgentOps", f = "AppAgentOps.kt", l = {27, 28}, m = "launchApp-bMdYcbs", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppAgentOps$launchApp$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppAgentOps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAgentOps$launchApp$1(AppAgentOps appAgentOps, H7.c<? super AppAgentOps$launchApp$1> cVar) {
        super(cVar);
        this.this$0 = appAgentOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7360launchAppbMdYcbs = this.this$0.m7360launchAppbMdYcbs(null, 0L, null, null, null, null, this);
        return objM7360launchAppbMdYcbs == CoroutineSingletons.f4909a ? objM7360launchAppbMdYcbs : new Result(objM7360launchAppbMdYcbs);
    }
}
