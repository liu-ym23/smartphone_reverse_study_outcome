package S;

import java.io.Serializable;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class C extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public M f1669a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1670b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f1671c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1672d;

    /* renamed from: e, reason: collision with root package name */
    public E f1673e;

    /* renamed from: f, reason: collision with root package name */
    public Iterator f1674f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1675g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ M f1676h;

    /* renamed from: i, reason: collision with root package name */
    public int f1677i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(M m4, Continuation continuation) {
        super(continuation);
        this.f1676h = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1675g = obj;
        this.f1677i |= Integer.MIN_VALUE;
        return this.f1676h.e(this);
    }
}
