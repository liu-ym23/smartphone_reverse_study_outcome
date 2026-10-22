package androidx.compose.ui.platform;

import C7.r;
import android.view.LifecycleOwner;
import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", l = {388}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends SuspendLambda implements S7.n {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt.AnonymousClass2 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ Ref$ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(Ref$ObjectRef<MotionDurationScaleImpl> ref$ObjectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt.AnonymousClass2 anonymousClass2, View view, H7.c<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1> cVar) {
        super(2, cVar);
        this.$systemDurationScaleSettingConsumer = ref$ObjectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = anonymousClass2;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, cVar);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r7.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1c
            if (r1 != r2) goto L14
            java.lang.Object r0 = r7.L$0
            m9.c0 r0 = (m9.c0) r0
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L12
            goto L63
        L12:
            r8 = move-exception
            goto L7a
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1c:
            kotlin.b.b(r8)
            java.lang.Object r8 = r7.L$0
            m9.z r8 = (m9.InterfaceC1733z) r8
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.platform.MotionDurationScaleImpl> r1 = r7.$systemDurationScaleSettingConsumer     // Catch: java.lang.Throwable -> L51
            java.lang.Object r1 = r1.f4920a     // Catch: java.lang.Throwable -> L51
            androidx.compose.ui.platform.MotionDurationScaleImpl r1 = (androidx.compose.ui.platform.MotionDurationScaleImpl) r1     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L54
            android.view.View r4 = r7.$this_createLifecycleAwareWindowRecomposer     // Catch: java.lang.Throwable -> L51
            android.content.Context r4 = r4.getContext()     // Catch: java.lang.Throwable -> L51
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L51
            p9.t r4 = androidx.compose.ui.platform.WindowRecomposer_androidKt.access$getAnimationScaleFlowFor(r4)     // Catch: java.lang.Throwable -> L51
            java.lang.Object r5 = r4.getValue()     // Catch: java.lang.Throwable -> L51
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L51
            float r5 = r5.floatValue()     // Catch: java.lang.Throwable -> L51
            r1.setScaleFactor(r5)     // Catch: java.lang.Throwable -> L51
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r5 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch: java.lang.Throwable -> L51
            r5.<init>(r4, r1, r3)     // Catch: java.lang.Throwable -> L51
            r1 = 3
            m9.q0 r8 = m9.AbstractC1683A.n(r8, r3, r5, r1)     // Catch: java.lang.Throwable -> L51
            goto L55
        L51:
            r8 = move-exception
            r0 = r3
            goto L7a
        L54:
            r8 = r3
        L55:
            androidx.compose.runtime.Recomposer r1 = r7.$recomposer     // Catch: java.lang.Throwable -> L76
            r7.L$0 = r8     // Catch: java.lang.Throwable -> L76
            r7.label = r2     // Catch: java.lang.Throwable -> L76
            java.lang.Object r1 = r1.runRecomposeAndApplyChanges(r7)     // Catch: java.lang.Throwable -> L76
            if (r1 != r0) goto L62
            return r0
        L62:
            r0 = r8
        L63:
            if (r0 == 0) goto L68
            r0.cancel(r3)
        L68:
            androidx.lifecycle.LifecycleOwner r8 = r7.$source
            androidx.lifecycle.Lifecycle r8 = r8.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r7 = r7.$self
            r8.removeObserver(r7)
            C7.r r7 = C7.r.f317a
            return r7
        L76:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L7a:
            if (r0 == 0) goto L7f
            r0.cancel(r3)
        L7f:
            androidx.lifecycle.LifecycleOwner r0 = r7.$source
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r7 = r7.$self
            r0.removeObserver(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
