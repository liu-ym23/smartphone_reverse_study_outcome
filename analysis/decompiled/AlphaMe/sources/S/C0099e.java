package S;

import java.io.Serializable;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: S.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0099e extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Serializable f1741a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f1742b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1743c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y1.f f1744d;

    /* renamed from: e, reason: collision with root package name */
    public int f1745e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0099e(y1.f fVar, Continuation continuation) {
        super(continuation);
        this.f1744d = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1743c = obj;
        this.f1745e |= Integer.MIN_VALUE;
        return y1.f.d(this.f1744d, null, null, this);
    }
}
