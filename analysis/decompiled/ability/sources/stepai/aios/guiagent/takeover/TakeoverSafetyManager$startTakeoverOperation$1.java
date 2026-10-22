package stepai.aios.guiagent.takeover;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import w9.InterfaceC2108a;

@c(c = "stepai.aios.guiagent.takeover.TakeoverSafetyManager", f = "TakeoverSafetyManager.kt", l = {322, 62}, m = "startTakeoverOperation", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TakeoverSafetyManager$startTakeoverOperation$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6165a;
    public String b;
    public InterfaceC2108a c;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ b f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverSafetyManager$startTakeoverOperation$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.e(null, null, this);
    }
}
