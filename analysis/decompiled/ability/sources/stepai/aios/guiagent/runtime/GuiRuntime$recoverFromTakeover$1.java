package stepai.aios.guiagent.runtime;

import Ca.C0205d;
import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.runtime.GuiRuntime", f = "GuiRuntime.kt", l = {352, 361}, m = "recoverFromTakeover", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class GuiRuntime$recoverFromTakeover$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6123a;
    public C0205d b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiRuntime$recoverFromTakeover$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.m(null, this);
    }
}
