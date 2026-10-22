package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import fc.k;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import lb.n;
import qb.b;
import rb.c;
import v0.x;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {410, 412}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements p<k<? super View>, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f1529a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1530b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1531c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, b<? super ViewKt$allViews$1> bVar) {
        super(2, bVar);
        this.f1531c = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.f1531c, bVar);
        viewKt$allViews$1.f1530b = obj;
        return viewKt$allViews$1;
    }

    @Override // zb.p
    public final Object invoke(k<? super View> kVar, b<? super n> bVar) {
        return ((ViewKt$allViews$1) create(kVar, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f1529a;
        View view = this.f1531c;
        if (i10 == 0) {
            kotlin.c.b(obj);
            k kVar = (k) this.f1530b;
            this.f1530b = kVar;
            this.f1529a = 1;
            kVar.a(view, this);
            return coroutineSingletons;
        }
        if (i10 == 1) {
            k kVar2 = (k) this.f1530b;
            kotlin.c.b(obj);
            if (view instanceof ViewGroup) {
                this.f1530b = null;
                this.f1529a = 2;
                kVar2.getClass();
                Object objB = kVar2.b(new x(new kotlin.jvm.internal.a((ViewGroup) view)), this);
                if (objB != coroutineSingletons) {
                    objB = n.f10413a;
                }
                if (objB == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return n.f10413a;
    }
}
