package androidx.datastore.preferences.core;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PreferencesKt$edit$2 extends SuspendLambda implements p<g1.a, b<? super g1.a>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f1714a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1715b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f1716c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PreferencesKt$edit$2(p<? super MutablePreferences, ? super b<? super n>, ? extends Object> pVar, b<? super PreferencesKt$edit$2> bVar) {
        super(2, bVar);
        this.f1716c = (SuspendLambda) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(this.f1716c, bVar);
        preferencesKt$edit$2.f1715b = obj;
        return preferencesKt$edit$2;
    }

    @Override // zb.p
    public final Object invoke(g1.a aVar, b<? super g1.a> bVar) {
        return ((PreferencesKt$edit$2) create(aVar, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f1714a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutablePreferences mutablePreferences = (MutablePreferences) this.f1715b;
            kotlin.c.b(obj);
            return mutablePreferences;
        }
        kotlin.c.b(obj);
        MutablePreferences mutablePreferences2 = new MutablePreferences(kotlin.collections.b.o0(((g1.a) this.f1715b).a()), false);
        this.f1715b = mutablePreferences2;
        this.f1714a = 1;
        return this.f1716c.invoke(mutablePreferences2, this) == coroutineSingletons ? coroutineSingletons : mutablePreferences2;
    }
}
