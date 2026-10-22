package androidx.compose.foundation;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006Ju\u0010\t\u001a\u00020\u00142f\u0010\t\u001ab\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\n¢\u0006\u0002\b\u0016H\u0016¢\u0006\u0002\u0010\u001eJO\u0010\u001f\u001a\u00020\u0014*\u00020\f2A\u0010\u001f\u001a=\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u0016H\u0016J%\u0010 \u001a\u00020\u0014*\u00020\f2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u0016H\u0016J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u001e\u0010\"\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRr\u0010\t\u001ad\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\n¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017RK\u0010\u0018\u001a?\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0019¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Landroidx/compose/foundation/SurfaceScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "onSurface", "Lkotlin/Function5;", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroid/view/Surface;", "Lkotlin/ParameterName;", "name", "surface", "", "width", "height", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function5;", "onSurfaceChanged", "Lkotlin/Function3;", "onSurfaceDestroyed", "Lkotlin/Function1;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function5;)V", "onChanged", "onDestroyed", "dispatchSurfaceCreated", "dispatchSurfaceChanged", "dispatchSurfaceDestroyed", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
abstract class BaseAndroidExternalSurfaceState implements AndroidExternalSurfaceScope, SurfaceScope {

    /* JADX INFO: renamed from: job, reason: collision with root package name */
    private Job f5720job;
    private Function5<? super SurfaceCoroutineScope, ? super Surface, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> onSurface;
    private Function3<? super Surface, ? super Integer, ? super Integer, Unit> onSurfaceChanged;
    private Function1<? super Surface, Unit> onSurfaceDestroyed;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1", f = "AndroidExternalSurface.android.kt", i = {0}, l = {130, 136}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $height;
        final /* synthetic */ Surface $surface;
        final /* synthetic */ int $width;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseAndroidExternalSurfaceState this$0;

        public AnonymousClass1(BaseAndroidExternalSurfaceState r100, Surface r101, int r102, int r103, Continuation<? super AnonymousClass1> r104) {
            this.this$0 = r100;
            this.$surface = r101;
            this.$width = r102;
            this.$height = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, this.$surface, this.$width, this.$height, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CoroutineScope r102 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r110);
        L15:
            BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1 r103 = new BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1(this.this$0, r102);
            Function5 r104 = BaseAndroidExternalSurfaceState.access$getOnSurface$p(this.this$0);
            if (r104 == null) goto L21;
            Surface r105 = this.$surface;
            Integer r106 = Boxing.boxInt(this.$width);
            Integer r107 = Boxing.boxInt(this.$height);
            this.L$0 = null;
            this.label = 2;
            if (r104.invoke(r103, r105, r106, r107, this) != r100) goto L21;
            return r100;
        L10:
            ResultKt.throwOnFailure(r110);
            r102 = (CoroutineScope) this.L$0;
            Job r111 = BaseAndroidExternalSurfaceState.access$getJob$p(this.this$0);
            if (r111 == null) goto L15;
            this.L$0 = r102;
            this.label = 1;
            if (JobKt.cancelAndJoin(r111, this) != r100) goto L15;
            return r100;
        }
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public BaseAndroidExternalSurfaceState(CoroutineScope r100) {
        this.scope = r100;
    }

    public static final /* synthetic */ Job access$getJob$p(BaseAndroidExternalSurfaceState r100) {
        return r100.f5720job;
    }

    public static final /* synthetic */ Function5 access$getOnSurface$p(BaseAndroidExternalSurfaceState r100) {
        return r100.onSurface;
    }

    public final void dispatchSurfaceDestroyed(Surface r100) {
        Function1<? super Surface, Unit> r101 = this.onSurfaceDestroyed;
        if (r101 == null) goto L5;
        r101.invoke(r100);
    L5:
        Job r102 = this.f5720job;
        if (r102 == null) goto L9;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
        return;
    }

    @Override // androidx.compose.foundation.AndroidExternalSurfaceScope
    public void onSurface(Function5<? super SurfaceCoroutineScope, ? super Surface, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> r100) {
        this.onSurface = r100;
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onChanged(Surface r100, Function3<? super Surface, ? super Integer, ? super Integer, Unit> r101) {
        this.onSurfaceChanged = r101;
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onDestroyed(Surface r100, Function1<? super Surface, Unit> r101) {
        this.onSurfaceDestroyed = r101;
    }

    public final void dispatchSurfaceChanged(Surface r100, int r101, int r102) {
        Function3<? super Surface, ? super Integer, ? super Integer, Unit> r103 = this.onSurfaceChanged;
        if (r103 == null) goto L6;
        r103.invoke(r100, Integer.valueOf(r101), Integer.valueOf(r102));
        return;
    }

    public final void dispatchSurfaceCreated(Surface r110, int r111, int r112) {
        if (this.onSurface == null) goto L6;
        this.f5720job = BuildersKt.launch$default(this.scope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, r110, r111, r112, null), 1, null);
        return;
    }
}
