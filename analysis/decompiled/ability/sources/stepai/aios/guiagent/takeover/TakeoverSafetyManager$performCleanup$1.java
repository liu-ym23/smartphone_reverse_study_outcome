package stepai.aios.guiagent.takeover;

import J7.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.takeover.TakeoverSafetyManager", f = "TakeoverSafetyManager.kt", l = {322}, m = "performCleanup", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TakeoverSafetyManager$performCleanup$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f6162a;
    public ArrayList b;
    public kotlinx.coroutines.sync.a c;
    public /* synthetic */ Object d;
    public final /* synthetic */ b e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverSafetyManager$performCleanup$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return b.b(this.e, this);
    }
}
