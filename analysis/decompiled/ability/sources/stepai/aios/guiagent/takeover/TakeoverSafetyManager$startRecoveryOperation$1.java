package stepai.aios.guiagent.takeover;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v7.o;
import w9.InterfaceC2108a;

@c(c = "stepai.aios.guiagent.takeover.TakeoverSafetyManager", f = "TakeoverSafetyManager.kt", l = {322, o.META_DATA_FIELD_NUMBER}, m = "startRecoveryOperation", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TakeoverSafetyManager$startRecoveryOperation$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6164a;
    public InterfaceC2108a b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ b e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverSafetyManager$startRecoveryOperation$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.d(null, this);
    }
}
