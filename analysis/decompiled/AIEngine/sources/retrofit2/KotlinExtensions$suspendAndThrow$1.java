package retrofit2;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
/* loaded from: classes.dex */
public final class KotlinExtensions$suspendAndThrow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f11809a;

    /* renamed from: b, reason: collision with root package name */
    public int f11810b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11809a = obj;
        this.f11810b |= Integer.MIN_VALUE;
        return KotlinExtensions.a(null, this);
    }
}
