package androidx.compose.foundation;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import S7.o;
import S7.q;
import android.view.Surface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineStart;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006JE\u0010\u000e\u001a\u00020\f24\u0010\u000e\u001a0\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0011\u001a\u00020\f*\u00020\t2\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\f*\u00020\t2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 RF\u0010\u000e\u001a2\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010!R0\u0010\"\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Landroidx/compose/foundation/SurfaceScope;", "Lm9/z;", "scope", AppAgent.CONSTRUCT, "(Lm9/z;)V", "Lkotlin/Function5;", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroid/view/Surface;", "", "LH7/c;", "LC7/r;", "", "onSurface", "(LS7/q;)V", "Lkotlin/Function3;", "onChanged", "(Landroid/view/Surface;LS7/o;)V", "Lkotlin/Function1;", "onDestroyed", "(Landroid/view/Surface;LS7/k;)V", "surface", "width", "height", "dispatchSurfaceCreated", "(Landroid/view/Surface;II)V", "dispatchSurfaceChanged", "dispatchSurfaceDestroyed", "(Landroid/view/Surface;)V", "Lm9/z;", "getScope", "()Lm9/z;", "LS7/q;", "onSurfaceChanged", "LS7/o;", "onSurfaceDestroyed", "LS7/k;", "Lm9/c0;", "job", "Lm9/c0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
abstract class BaseAndroidExternalSurfaceState implements AndroidExternalSurfaceScope, SurfaceScope {
    private c0 job;
    private q onSurface;
    private o onSurfaceChanged;
    private k onSurfaceDestroyed;
    private final InterfaceC1733z scope;

    @c(c = "androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1", f = "AndroidExternalSurface.android.kt", l = {132, 137}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ int $height;
        final /* synthetic */ Surface $surface;
        final /* synthetic */ int $width;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Surface surface, int i, int i6, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$surface = surface;
            this.$width = i;
            this.$height = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = BaseAndroidExternalSurfaceState.this.new AnonymousClass1(this.$surface, this.$width, this.$height, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
        
            if (r3.invoke(r4, r5, r6, r7, r9) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r9.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.b.b(r10)
                goto L67
            L10:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L18:
                java.lang.Object r1 = r9.L$0
                m9.z r1 = (m9.InterfaceC1733z) r1
                kotlin.b.b(r10)
                goto L3b
            L20:
                kotlin.b.b(r10)
                java.lang.Object r10 = r9.L$0
                r1 = r10
                m9.z r1 = (m9.InterfaceC1733z) r1
                androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = androidx.compose.foundation.BaseAndroidExternalSurfaceState.this
                m9.c0 r10 = androidx.compose.foundation.BaseAndroidExternalSurfaceState.access$getJob$p(r10)
                if (r10 == 0) goto L3b
                r9.L$0 = r1
                r9.label = r3
                java.lang.Object r10 = kotlinx.coroutines.a.e(r10, r9)
                if (r10 != r0) goto L3b
                goto L66
            L3b:
                androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1 r4 = new androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1
                androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = androidx.compose.foundation.BaseAndroidExternalSurfaceState.this
                r4.<init>(r10, r1)
                androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = androidx.compose.foundation.BaseAndroidExternalSurfaceState.this
                S7.q r3 = androidx.compose.foundation.BaseAndroidExternalSurfaceState.access$getOnSurface$p(r10)
                if (r3 == 0) goto L67
                android.view.Surface r5 = r9.$surface
                int r10 = r9.$width
                java.lang.Integer r6 = new java.lang.Integer
                r6.<init>(r10)
                int r10 = r9.$height
                java.lang.Integer r7 = new java.lang.Integer
                r7.<init>(r10)
                r10 = 0
                r9.L$0 = r10
                r9.label = r2
                r8 = r9
                java.lang.Object r9 = r3.invoke(r4, r5, r6, r7, r8)
                if (r9 != r0) goto L67
            L66:
                return r0
            L67:
                C7.r r9 = C7.r.f317a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BaseAndroidExternalSurfaceState.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public BaseAndroidExternalSurfaceState(InterfaceC1733z interfaceC1733z) {
        this.scope = interfaceC1733z;
    }

    public final void dispatchSurfaceChanged(Surface surface, int width, int height) {
        o oVar = this.onSurfaceChanged;
        if (oVar != null) {
            oVar.invoke(surface, Integer.valueOf(width), Integer.valueOf(height));
        }
    }

    public final void dispatchSurfaceCreated(Surface surface, int width, int height) {
        if (this.onSurface != null) {
            InterfaceC1733z interfaceC1733z = this.scope;
            CoroutineStart coroutineStart = CoroutineStart.f5175a;
            this.job = AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(surface, width, height, null), 1);
        }
    }

    public final void dispatchSurfaceDestroyed(Surface surface) {
        k kVar = this.onSurfaceDestroyed;
        if (kVar != null) {
            kVar.invoke(surface);
        }
        c0 c0Var = this.job;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.job = null;
    }

    public final InterfaceC1733z getScope() {
        return this.scope;
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onChanged(Surface surface, o oVar) {
        this.onSurfaceChanged = oVar;
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onDestroyed(Surface surface, k kVar) {
        this.onSurfaceDestroyed = kVar;
    }

    @Override // androidx.compose.foundation.AndroidExternalSurfaceScope
    public void onSurface(q onSurface) {
        this.onSurface = onSurface;
    }
}
