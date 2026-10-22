package S;

import java.io.FileInputStream;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class H extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public M f1698a;

    /* renamed from: b, reason: collision with root package name */
    public FileInputStream f1699b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1700c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ M f1701d;

    /* renamed from: e, reason: collision with root package name */
    public int f1702e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(M m4, Continuation continuation) {
        super(continuation);
        this.f1701d = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1700c = obj;
        this.f1702e |= Integer.MIN_VALUE;
        return this.f1701d.h(this);
    }
}
