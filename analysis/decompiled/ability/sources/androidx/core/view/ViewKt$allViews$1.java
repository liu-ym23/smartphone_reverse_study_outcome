package androidx.core.view;

import C7.r;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@J7.c(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {410, 412}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Li9/k;", "Landroid/view/View;", "LC7/r;", "<anonymous>", "(Li9/k;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes2.dex */
public final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements S7.n {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, H7.c<? super ViewKt$allViews$1> cVar) {
        super(2, cVar);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, cVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // S7.n
    public final Object invoke(i9.k kVar, H7.c<? super r> cVar) {
        return ((ViewKt$allViews$1) create(kVar, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3 = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            i9.k kVar = (i9.k) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = kVar;
            this.label = 1;
            kVar.a(this, view);
            return obj3;
        }
        Object obj4 = r.f317a;
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj4;
        }
        i9.k kVar2 = (i9.k) this.L$0;
        kotlin.b.b(obj);
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            i9.i descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            kVar2.getClass();
            Iterator it = descendants.iterator();
            i9.j jVar = (i9.j) kVar2;
            if (it.hasNext()) {
                jVar.c = it;
                jVar.f4623a = 2;
                jVar.d = this;
                obj2 = obj3;
            } else {
                obj2 = obj4;
            }
            if (obj2 != obj3) {
                obj2 = obj4;
            }
            if (obj2 == obj3) {
                return obj3;
            }
        }
        return obj4;
    }
}
