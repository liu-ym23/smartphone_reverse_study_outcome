package androidx.compose.ui.platform;

import C7.r;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.SessionMutex;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Stable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ<\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R+\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "", "Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "initialInterceptor", "parent", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;)V", "interceptor", "LC7/r;", "updateInterceptor", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;)V", "Landroidx/compose/ui/node/Owner;", "owner", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "LH7/c;", "", "session", "textInputSession", "(Landroidx/compose/ui/node/Owner;LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "<set-?>", "interceptor$delegate", "Landroidx/compose/runtime/MutableState;", "getInterceptor", "()Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "setInterceptor", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class ChainedPlatformTextInputInterceptor {

    /* renamed from: interceptor$delegate, reason: from kotlin metadata */
    private final MutableState interceptor;
    private final ChainedPlatformTextInputInterceptor parent;

    @J7.c(c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor", f = "PlatformTextInputModifierNode.kt", l = {219}, m = "textInputSession")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChainedPlatformTextInputInterceptor.this.textInputSession(null, null, this);
        }
    }

    @J7.c(c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2", f = "PlatformTextInputModifierNode.kt", l = {248}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements S7.n {
        final /* synthetic */ S7.n $session;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChainedPlatformTextInputInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(S7.n nVar, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$session = nVar;
            this.this$0 = chainedPlatformTextInputInterceptor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$session, this.this$0, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, H7.c<?> cVar) {
            return ((AnonymousClass2) create(platformTextInputSessionScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1 chainedPlatformTextInputInterceptor$textInputSession$2$scope$1 = new ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1((PlatformTextInputSessionScope) this.L$0, SessionMutex.m3626constructorimpl(), this.this$0);
                S7.n nVar = this.$session;
                this.label = 1;
                if (nVar.invoke(chainedPlatformTextInputInterceptor$textInputSession$2$scope$1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public ChainedPlatformTextInputInterceptor(PlatformTextInputInterceptor platformTextInputInterceptor, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor) {
        this.parent = chainedPlatformTextInputInterceptor;
        this.interceptor = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(platformTextInputInterceptor, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlatformTextInputInterceptor getInterceptor() {
        return (PlatformTextInputInterceptor) this.interceptor.getValue();
    }

    private final void setInterceptor(PlatformTextInputInterceptor platformTextInputInterceptor) {
        this.interceptor.setValue(platformTextInputInterceptor);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object textInputSession(androidx.compose.ui.node.Owner r6, S7.n r7, H7.c<?> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1 r0 = (androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1 r0 = new androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            kotlin.b.b(r8)
            goto L43
        L2f:
            kotlin.b.b(r8)
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor r8 = r5.parent
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2 r2 = new androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2
            r4 = 0
            r2.<init>(r7, r5, r4)
            r0.label = r3
            java.lang.Object r5 = androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.access$interceptedTextInputSession(r6, r8, r2, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor.textInputSession(androidx.compose.ui.node.Owner, S7.n, H7.c):java.lang.Object");
    }

    public final void updateInterceptor(PlatformTextInputInterceptor interceptor) {
        setInterceptor(interceptor);
    }
}
