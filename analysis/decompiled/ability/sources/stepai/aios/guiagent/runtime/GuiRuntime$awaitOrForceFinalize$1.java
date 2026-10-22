package stepai.aios.guiagent.runtime;

import Ca.C0205d;
import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.runtime.GuiRuntime", f = "GuiRuntime.kt", l = {455, 464}, m = "awaitOrForceFinalize", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class GuiRuntime$awaitOrForceFinalize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6119a;
    public C0205d b;
    public String c;
    public long d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiRuntime$awaitOrForceFinalize$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return a.a(this.f, null, null, null, 0L, this);
    }
}
