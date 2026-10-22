package stepai.aios.guiagent.session;

import J7.c;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import za.f;

@c(c = "stepai.aios.guiagent.session.SessionManager", f = "SessionManager.kt", l = {537}, m = "createSession", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SessionManager$createSession$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public f f6137a;
    public LinkedHashMap b;
    public kotlinx.coroutines.sync.a c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionManager$createSession$2(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.h(null, null, this);
    }
}
