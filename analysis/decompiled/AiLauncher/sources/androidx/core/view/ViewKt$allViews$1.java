package androidx.core.view;

import android.view.View;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LKa/l;", "Landroid/view/View;", "LY8/t;", "<anonymous>", "(LKa/l;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {410, 412}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements p9.p<Ka.l<? super View>, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f13143a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13144b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f13145c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, InterfaceC4014c<? super ViewKt$allViews$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f13145c = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.f13145c, interfaceC4014c);
        viewKt$allViews$1.f13144b = obj;
        return viewKt$allViews$1;
    }

    @Override // p9.p
    public final Object invoke(Ka.l<? super View> lVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ViewKt$allViews$1) create(lVar, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r1.c(r5, r4) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.f13143a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r5)
            goto L4f
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1a:
            java.lang.Object r1 = r4.f13144b
            Ka.l r1 = (Ka.l) r1
            kotlin.C4849c.b(r5)
            goto L37
        L22:
            kotlin.C4849c.b(r5)
            java.lang.Object r5 = r4.f13144b
            r1 = r5
            Ka.l r1 = (Ka.l) r1
            android.view.View r5 = r4.f13145c
            r4.f13144b = r1
            r4.f13143a = r3
            java.lang.Object r5 = r1.a(r5, r4)
            if (r5 != r0) goto L37
            goto L4e
        L37:
            android.view.View r5 = r4.f13145c
            boolean r3 = r5 instanceof android.view.ViewGroup
            if (r3 == 0) goto L4f
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            Ka.j r5 = androidx.core.view.Q.b(r5)
            r3 = 0
            r4.f13144b = r3
            r4.f13143a = r2
            java.lang.Object r4 = r1.c(r5, r4)
            if (r4 != r0) goto L4f
        L4e:
            return r0
        L4f:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewKt$allViews$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
