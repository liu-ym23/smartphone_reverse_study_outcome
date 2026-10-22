package stepai.android.mindx.client.inner;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "stepai.android.mindx.client.inner.StepInnerClient", f = "StepInnerClient.kt", l = {172}, m = "chat")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class StepInnerClient$chat$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public e f6200a;
    public String b;
    public /* synthetic */ Object c;
    public final /* synthetic */ e d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepInnerClient$chat$1(e eVar, H7.c cVar) {
        super(cVar);
        this.d = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.chat(null, null, this);
    }
}
