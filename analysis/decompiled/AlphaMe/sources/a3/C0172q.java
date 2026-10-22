package a3;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;

/* renamed from: a3.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0172q extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Function0 f2319a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2320b;

    /* renamed from: c, reason: collision with root package name */
    public int f2321c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2320b = obj;
        this.f2321c |= Integer.MIN_VALUE;
        return r.a(null, null, this);
    }
}
