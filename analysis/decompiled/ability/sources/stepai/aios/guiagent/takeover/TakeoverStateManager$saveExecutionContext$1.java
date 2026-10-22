package stepai.aios.guiagent.takeover;

import J7.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.takeover.TakeoverStateManager", f = "TakeoverStateManager.kt", l = {221}, m = "saveExecutionContext", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TakeoverStateManager$saveExecutionContext$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6169a;
    public String b;
    public List c;
    public String d;
    public String e;
    public kotlinx.coroutines.sync.a f;
    public int g;
    public /* synthetic */ Object h;
    public final /* synthetic */ a i;

    /* renamed from: j, reason: collision with root package name */
    public int f6170j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverStateManager$saveExecutionContext$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.i = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.f6170j |= Integer.MIN_VALUE;
        return this.i.i(null, 0, null, null, null, null, this);
    }
}
