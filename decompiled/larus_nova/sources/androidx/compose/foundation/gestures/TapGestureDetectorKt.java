package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008b\u0001\u0010\t\u001a\u00020\u0005*\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0012\u0010\u0011\u001a\u00020\u0005*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017\u001a[\u0010\u0018\u001a\u00020\u0005*\u00020\n2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u0010\u001d\u001a&\u0010\u001a\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 \u001a&\u0010!\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0080@¢\u0006\u0002\u0010 \u001a\u001e\u0010\"\u001a\u00020\u001c*\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010$\u001a\u00020\u001cH\u0000\u001a\u0014\u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u0012H\u0087@¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(*\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0080@¢\u0006\u0002\u0010&\u001aL\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u0002072\b\b\u0002\u0010:\u001a\u0002022'\u0010;\u001a#\b\u0001\u0012\u0004\u0012\u000208\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060<¢\u0006\u0002\b\u0007H\u0002¢\u0006\u0002\u0010=\"7\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"*\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\"\u001a\u00101\u001a\u0002028BX\u0082\u0004¢\u0006\f\u0012\u0004\b3\u0010,\u001a\u0004\b4\u00105¨\u0006>"}, d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "detectTapGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDoubleTap", "Lkotlin/Function1;", "onLongPress", "onPress", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDown", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrimaryFirstDown", "isChangedToDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onlyPrimaryMouseButton", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForLongPress", "Landroidx/compose/foundation/gestures/LongPressResult;", "value", "DetectTapGesturesEnableNewDispatchingBehavior", "getDetectTapGesturesEnableNewDispatchingBehavior$annotations", "()V", "getDetectTapGesturesEnableNewDispatchingBehavior", "()Z", "setDetectTapGesturesEnableNewDispatchingBehavior", "(Z)V", "coroutineStartForCurrentDispatchBehavior", "Lkotlinx/coroutines/CoroutineStart;", "getCoroutineStartForCurrentDispatchBehavior$annotations", "getCoroutineStartForCurrentDispatchBehavior", "()Lkotlinx/coroutines/CoroutineStart;", "launchAwaitingReset", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "resetJob", "start", "block", "Lkotlin/Function2;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TapGestureDetectorKt {
    private static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = null;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT}, m = "awaitFirstDown", n = {"$this$awaitFirstDown", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"})
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {304}, m = "awaitPrimaryFirstDown", n = {"$this$awaitPrimaryFirstDown", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitPrimaryFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", i = {0, 0}, l = {VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "minUptime"}, s = {"L$0", "J$0"})
    public static final class C85862 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public C85862(PointerInputChange r100, Continuation<? super C85862> r101) {
            this.$firstUp = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C85862 r102 = new C85862(this.$firstUp, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AwaitPointerEventScope r100, Continuation<? super PointerInputChange> r101) {
            return ((C85862) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(AwaitPointerEventScope r100, Continuation<? super PointerInputChange> r101) {
            return invoke2(r100, r101);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004d -> B:13:0x0052). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            long r102 = this.J$0;
            AwaitPointerEventScope r103 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            long r104 = r102;
            AwaitPointerEventScope r105 = r103;
            Object r106 = r100;
            C85862 r107 = this;
        L13:
            PointerInputChange r111 = (PointerInputChange) r110;
            if (r111.getUptimeMillis() < r104) goto L16;
            return r111;
        L16:
            C85862 r112 = r107;
            r100 = r106;
            AwaitPointerEventScope r108 = r105;
        L9:
            r112.L$0 = r108;
            r112.J$0 = r104;
            r112.label = 1;
            Object r109 = TapGestureDetectorKt.awaitFirstDown$default(r108, false, null, r112, 3, null);
            if (r109 != r100) goto L12;
            return r100;
        L12:
            Object r113 = r100;
            r107 = r112;
            r110 = r109;
            r105 = r108;
            r106 = r113;
            goto L13
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            AwaitPointerEventScope r114 = (AwaitPointerEventScope) this.L$0;
            long r115 = this.$firstUp.getUptimeMillis() + r114.getViewConfiguration().getDoubleTapMinTimeMillis();
            r108 = r114;
            r104 = r115;
            r112 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {209}, m = "consumeUntilUp", n = {"$this$consumeUntilUp"}, s = {"L$0"})
    public static final class C85871 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C85871(Continuation<? super C85871> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.access$consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputScope $this_detectTapAndPress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", i = {0, 0, 1}, l = {251, 257}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "resetJob", "resetJob"}, s = {"L$0", "L$1", "L$0"})
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C01131(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r100, PressGestureScopeImpl r101, PointerInputChange r102, Continuation<? super C01131> r103) {
                    this.$onPress = r100;
                    this.$pressScope = r101;
                    this.$down = r102;
                    super(2, r103);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C01131(this.$onPress, this.$pressScope, this.$down, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C01131) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L8;
                    if (r102 != 1) goto L7;
                    ResultKt.throwOnFailure(r100);
                L12:
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r100);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> r103 = this.$onPress;
                    PressGestureScopeImpl r104 = this.$pressScope;
                    Offset r105 = Offset.m4571boximpl(this.$down.m6126getPositionF1C5BW0());
                    this.label = 1;
                    if (r103.invoke(r104, r105, this) != r101) goto L12;
                    return r101;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01142 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public C01142(PressGestureScopeImpl r100, Continuation<? super C01142> r101) {
                    this.$pressScope = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C01142(this.$pressScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C01142) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r100);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass3(PressGestureScopeImpl r100, Continuation<? super AnonymousClass3> r101) {
                    this.$pressScope = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new AnonymousClass3(this.$pressScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r100);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineScope r100, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r101, Function1<? super Offset, Unit> r102, PressGestureScopeImpl r103, Continuation<? super AnonymousClass1> r104) {
                this.$$this$coroutineScope = r100;
                this.$onPress = r101;
                this.$onTap = r102;
                this.$pressScope = r103;
                super(2, r104);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                AnonymousClass1 r102 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onTap, this.$pressScope, r101);
                r102.L$0 = r100;
                return r102;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L10;
                if (r101 == 1) goto L9;
                if (r101 != 2) goto L8;
                Job r102 = (Job) this.L$0;
                ResultKt.throwOnFailure(r110);
                Job r103 = r102;
            L21:
                PointerInputChange r111 = (PointerInputChange) r110;
                if (r111 != null) goto L24;
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r103, null, new C01142(this.$pressScope, null), 2, null);
            L28:
                return Unit.INSTANCE;
            L24:
                r111.consume();
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r103, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                Function1<Offset, Unit> r104 = this.$onTap;
                if (r104 == null) goto L28;
                r104.invoke(Offset.m4571boximpl(r111.m6126getPositionF1C5BW0()));
                goto L28
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                Job r105 = (Job) this.L$1;
                AwaitPointerEventScope r106 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r110);
                AwaitPointerEventScope r112 = r106;
            L14:
                PointerInputChange r113 = (PointerInputChange) r110;
                r113.consume();
                if (this.$onPress == TapGestureDetectorKt.access$getNoPressGesture$p()) goto L17;
                CoroutineScope r107 = this.$$this$coroutineScope;
                C01131 r108 = new C01131(this.$onPress, this.$pressScope, r113, null);
                TapGestureDetectorKt.launchAwaitingReset$default(r107, r105, null, r108, 2, null);
            L17:
                this.L$0 = r105;
                this.L$1 = null;
                this.label = 2;
                r110 = TapGestureDetectorKt.waitForUpOrCancellation$default(r112, null, this, 1, null);
                if (r110 != r100) goto L20;
                return r100;
            L20:
                r103 = r105;
                goto L21
            L10:
                ResultKt.throwOnFailure(r110);
                AwaitPointerEventScope r114 = (AwaitPointerEventScope) this.L$0;
                r105 = BuildersKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.access$getCoroutineStartForCurrentDispatchBehavior(), new TapGestureDetectorKt$detectTapAndPress$2$1$resetJob$1(this.$pressScope, null), 1, null);
                this.L$0 = r114;
                this.L$1 = r105;
                this.label = 1;
                Object r109 = TapGestureDetectorKt.awaitFirstDown$default(r114, false, null, this, 3, null);
                if (r109 != r100) goto L13;
                return r100;
            L13:
                r112 = r114;
                r110 = r109;
                goto L14
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C85882(PointerInputScope r100, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r101, Function1<? super Offset, Unit> r102, PressGestureScopeImpl r103, Continuation<? super C85882> r104) {
            this.$this_detectTapAndPress = r100;
            this.$onPress = r101;
            this.$onTap = r102;
            this.$pressScope = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C85882 r102 = new C85882(this.$this_detectTapAndPress, this.$onPress, this.$onTap, this.$pressScope, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C85882) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            CoroutineScope r102 = (CoroutineScope) this.L$0;
            PointerInputScope r111 = this.$this_detectTapAndPress;
            AnonymousClass1 r103 = new AnonymousClass1(r102, this.$onPress, this.$onTap, this.$pressScope, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(r111, r103, this) != r100) goto L12;
            return r100;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {0, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7}, l = {105, 116, 119, 122, 149, 167, 169, 180}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "resetJob", "$this$awaitEachGesture", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "resetJob", "resetJob", "$this$awaitEachGesture", "upOrCancel", "cancelOrReleaseJob", "resetJob", "upOrCancel", "$this$awaitEachGesture", "resetJob", "upOrCancel", "secondDown", "resetJob"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0"})
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onLongPress;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C01151(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r100, PressGestureScopeImpl r101, PointerInputChange r102, Continuation<? super C01151> r103) {
                    this.$onPress = r100;
                    this.$pressScope = r101;
                    this.$down = r102;
                    super(2, r103);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C01151(this.$onPress, this.$pressScope, this.$down, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C01151) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L8;
                    if (r102 != 1) goto L7;
                    ResultKt.throwOnFailure(r100);
                L12:
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r100);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> r103 = this.$onPress;
                    PressGestureScopeImpl r104 = this.$pressScope;
                    Offset r105 = Offset.m4571boximpl(this.$down.m6126getPositionF1C5BW0());
                    this.label = 1;
                    if (r103.invoke(r104, r105, this) != r101) goto L12;
                    return r101;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public C01162(PressGestureScopeImpl r100, Continuation<? super C01162> r101) {
                    this.$pressScope = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C01162(this.$pressScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C01162) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r100);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass3(PressGestureScopeImpl r100, Continuation<? super AnonymousClass3> r101) {
                    this.$pressScope = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new AnonymousClass3(this.$pressScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r100);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass4(PressGestureScopeImpl r100, Continuation<? super AnonymousClass4> r101) {
                    this.$pressScope = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new AnonymousClass4(this.$pressScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((AnonymousClass4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r100);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", i = {}, l = {157, 158}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Job $cancelOrReleaseJob;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass5(Job r100, PressGestureScopeImpl r101, Continuation<? super AnonymousClass5> r102) {
                    this.$cancelOrReleaseJob = r100;
                    this.$pressScope = r101;
                    super(2, r102);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new AnonymousClass5(this.$cancelOrReleaseJob, this.$pressScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((AnonymousClass5) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L10;
                    if (r102 == 1) goto L9;
                    if (r102 != 2) goto L8;
                    ResultKt.throwOnFailure(r100);
                L17:
                    return Unit.INSTANCE;
                L8:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L9:
                    ResultKt.throwOnFailure(r100);
                L13:
                    PressGestureScopeImpl r103 = this.$pressScope;
                    this.label = 2;
                    if (r103.reset(this) != r101) goto L17;
                    return r101;
                L10:
                    ResultKt.throwOnFailure(r100);
                    Job r104 = this.$cancelOrReleaseJob;
                    this.label = 1;
                    if (r104.join(this) != r101) goto L13;
                    return r101;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ PointerInputChange $secondDown;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass6(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r100, PressGestureScopeImpl r101, PointerInputChange r102, Continuation<? super AnonymousClass6> r103) {
                    this.$onPress = r100;
                    this.$pressScope = r101;
                    this.$secondDown = r102;
                    super(2, r103);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new AnonymousClass6(this.$onPress, this.$pressScope, this.$secondDown, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((AnonymousClass6) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L8;
                    if (r102 != 1) goto L7;
                    ResultKt.throwOnFailure(r100);
                L12:
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r100);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> r103 = this.$onPress;
                    PressGestureScopeImpl r104 = this.$pressScope;
                    Offset r105 = Offset.m4571boximpl(this.$secondDown.m6126getPositionF1C5BW0());
                    this.label = 1;
                    if (r103.invoke(r104, r105, this) != r101) goto L12;
                    return r101;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass7(PressGestureScopeImpl r100, Continuation<? super AnonymousClass7> r101) {
                    this.$pressScope = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new AnonymousClass7(this.$pressScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((AnonymousClass7) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r100);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass8(PressGestureScopeImpl r100, Continuation<? super AnonymousClass8> r101) {
                    this.$pressScope = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new AnonymousClass8(this.$pressScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((AnonymousClass8) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r100);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineScope r100, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r101, Function1<? super Offset, Unit> r102, Function1<? super Offset, Unit> r103, Function1<? super Offset, Unit> r104, PressGestureScopeImpl r105, Continuation<? super AnonymousClass1> r106) {
                this.$$this$coroutineScope = r100;
                this.$onPress = r101;
                this.$onLongPress = r102;
                this.$onDoubleTap = r103;
                this.$onTap = r104;
                this.$pressScope = r105;
                super(2, r106);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
                AnonymousClass1 r100 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, r111);
                r100.L$0 = r110;
                return r100;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r210) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: goto L15;
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    case 8: goto L6;
                    default: goto L5;
                };
            L6:
                Job r101 = (Job) this.L$0;
                ResultKt.throwOnFailure(r210);
                Job r110 = r101;
            L82:
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r110, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                return Unit.INSTANCE;
            L7:
                PointerInputChange r102 = (PointerInputChange) this.L$3;
                PointerInputChange r103 = (PointerInputChange) this.L$2;
                Job r104 = (Job) this.L$1;
                AwaitPointerEventScope r105 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r210);
                Object r106 = r210;
            L76:
                LongPressResult r107 = (LongPressResult) r106;
                if (Intrinsics.areEqual(r107, LongPressResult.Success.INSTANCE) == false) goto L85;
                this.$onLongPress.invoke(Offset.m4571boximpl(r102.m6126getPositionF1C5BW0()));
                this.L$0 = r104;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 8;
                if (TapGestureDetectorKt.access$consumeUntilUp(r105, this) != r100) goto L81;
                return r100;
            L81:
                r110 = r104;
                goto L82
            L85:
                if ((r107 instanceof LongPressResult.Released) == false) goto L88;
                Job r111 = r104;
                PointerInputChange r108 = ((LongPressResult.Released) r107).getFinalUpChange();
                PointerInputChange r109 = r103;
            L90:
                if (r108 == null) goto L92;
                r108.consume();
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r111, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                this.$onDoubleTap.invoke(Offset.m4571boximpl(r108.m6126getPositionF1C5BW0()));
            L98:
                return Unit.INSTANCE;
            L92:
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r111, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                Function1<Offset, Unit> r112 = this.$onTap;
                if (r112 == null) goto L98;
                r112.invoke(Offset.m4571boximpl(r109.m6126getPositionF1C5BW0()));
                goto L98
            L88:
                if ((r107 instanceof LongPressResult.Canceled) == false) goto L96;
                r109 = r103;
                r111 = r104;
                r108 = null;
                goto L90
            L96:
                throw new NoWhenBranchMatchedException();
            L8:
                r109 = (PointerInputChange) this.L$1;
                Job r113 = (Job) this.L$0;
                ResultKt.throwOnFailure(r210);
                Object r114 = r210;
            L71:
                r108 = (PointerInputChange) r114;
                r111 = r113;
                goto L90
            L9:
                Job r115 = (Job) this.L$2;
                r103 = (PointerInputChange) this.L$1;
                AwaitPointerEventScope r116 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r210);
                Object r117 = r210;
            L57:
                PointerInputChange r118 = (PointerInputChange) r117;
                if (r118 != null) goto L62;
                Function1<Offset, Unit> r119 = this.$onTap;
                if (r119 == null) goto L98;
                r119.invoke(Offset.m4571boximpl(r103.m6126getPositionF1C5BW0()));
                goto L98
            L62:
                Job r120 = BuildersKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.access$getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(r115, this.$pressScope, null), 1, null);
                if (this.$onPress == TapGestureDetectorKt.access$getNoPressGesture$p()) goto L66;
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r120, null, new AnonymousClass6(this.$onPress, this.$pressScope, r118, null), 2, null);
            L66:
                if (this.$onLongPress != null) goto L72;
                this.L$0 = r120;
                this.L$1 = r103;
                this.L$2 = null;
                this.label = 6;
                r114 = TapGestureDetectorKt.waitForUpOrCancellation$default(r116, null, this, 1, null);
                if (r114 != r100) goto L70;
                return r100;
            L70:
                PointerInputChange r211 = r103;
                r113 = r120;
                r109 = r211;
                goto L71
            L72:
                this.L$0 = r116;
                this.L$1 = r120;
                this.L$2 = r103;
                this.L$3 = r118;
                this.label = 7;
                r106 = TapGestureDetectorKt.waitForLongPress$default(r116, null, this, 1, null);
                if (r106 != r100) goto L75;
                return r100;
            L75:
                AwaitPointerEventScope r212 = r116;
                r104 = r120;
                r102 = r118;
                r105 = r212;
                goto L76
            L10:
                Job r121 = (Job) this.L$0;
                ResultKt.throwOnFailure(r210);
            L37:
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r121, null, new C01162(this.$pressScope, null), 2, null);
                return Unit.INSTANCE;
            L12:
                r121 = (Job) this.L$2;
                PointerInputChange r122 = (PointerInputChange) this.L$1;
                r116 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r210);
                Object r123 = r210;
            L32:
                LongPressResult r124 = (LongPressResult) r123;
                if (Intrinsics.areEqual(r124, LongPressResult.Success.INSTANCE) == false) goto L40;
                this.$onLongPress.invoke(Offset.m4571boximpl(r122.m6126getPositionF1C5BW0()));
                this.L$0 = r121;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 4;
                if (TapGestureDetectorKt.access$consumeUntilUp(r116, this) != r100) goto L37;
                return r100;
            L40:
                if ((r124 instanceof LongPressResult.Released) == false) goto L43;
                r103 = ((LongPressResult.Released) r124).getFinalUpChange();
            L28:
                Job r125 = r121;
                if (r103 != null) goto L47;
                r115 = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r125, null, new AnonymousClass3(this.$pressScope, null), 2, null);
            L48:
                if (r103 == null) goto L98;
                if (this.$onDoubleTap != null) goto L54;
                Function1<Offset, Unit> r126 = this.$onTap;
                if (r126 == null) goto L98;
                r126.invoke(Offset.m4571boximpl(r103.m6126getPositionF1C5BW0()));
                goto L98
            L54:
                this.L$0 = r116;
                this.L$1 = r103;
                this.L$2 = r115;
                this.label = 5;
                r117 = TapGestureDetectorKt.access$awaitSecondDown(r116, r103, this);
                if (r117 != r100) goto L57;
                return r100;
            L47:
                r103.consume();
                r115 = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r125, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                goto L48
            L43:
                if ((r124 instanceof LongPressResult.Canceled) == false) goto L100;
                r103 = null;
                goto L28
            L100:
                throw new NoWhenBranchMatchedException();
            L13:
                r121 = (Job) this.L$1;
                AwaitPointerEventScope r127 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r210);
                r116 = r127;
                Object r128 = r210;
            L27:
                r103 = (PointerInputChange) r128;
                goto L28
            L14:
                AwaitPointerEventScope r129 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r210);
                r116 = r129;
                Object r130 = r210;
            L19:
                r122 = (PointerInputChange) r130;
                r122.consume();
                r121 = BuildersKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.access$getCoroutineStartForCurrentDispatchBehavior(), new TapGestureDetectorKt$detectTapGestures$2$1$resetJob$1(this.$pressScope, null), 1, null);
                if (this.$onPress == TapGestureDetectorKt.access$getNoPressGesture$p()) goto L23;
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r121, null, new C01151(this.$onPress, this.$pressScope, r122, null), 2, null);
            L23:
                if (this.$onLongPress != null) goto L29;
                this.L$0 = r116;
                this.L$1 = r121;
                this.label = 2;
                r128 = TapGestureDetectorKt.waitForUpOrCancellation$default(r116, null, this, 1, null);
                if (r128 != r100) goto L27;
                return r100;
            L29:
                this.L$0 = r116;
                this.L$1 = r122;
                this.L$2 = r121;
                this.label = 3;
                r123 = TapGestureDetectorKt.waitForLongPress$default(r116, null, this, 1, null);
                if (r123 != r100) goto L32;
                return r100;
            L15:
                ResultKt.throwOnFailure(r210);
                AwaitPointerEventScope r131 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = r131;
                this.label = 1;
                r130 = TapGestureDetectorKt.awaitFirstDown$default(r131, false, null, this, 3, null);
                if (r130 != r100) goto L18;
                return r100;
            L18:
                r116 = r131;
                goto L19
            L5:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C85892(PointerInputScope r100, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r101, Function1<? super Offset, Unit> r102, Function1<? super Offset, Unit> r103, Function1<? super Offset, Unit> r104, Continuation<? super C85892> r105) {
            this.$this_detectTapGestures = r100;
            this.$onPress = r101;
            this.$onLongPress = r102;
            this.$onDoubleTap = r103;
            this.$onTap = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
            C85892 r101 = new C85892(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, r110);
            r101.L$0 = r100;
            return r101;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C85892) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            CoroutineScope r102 = (CoroutineScope) this.L$0;
            PressGestureScopeImpl r103 = new PressGestureScopeImpl(this.$this_detectTapGestures);
            PointerInputScope r111 = this.$this_detectTapGestures;
            AnonymousClass1 r104 = new AnonymousClass1(r102, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, r103, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(r111, r104, this) != r100) goto L12;
            return r100;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1", f = "TapGestureDetector.kt", i = {0}, l = {TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK, 500}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C85901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Job $resetJob;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C85901(Job r100, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super C85901> r102) {
            this.$resetJob = r100;
            this.$block = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C85901 r102 = new C85901(this.$resetJob, this.$block, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C85901) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CoroutineScope r103 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r100);
        L15:
            Function2<CoroutineScope, Continuation<? super Unit>, Object> r104 = this.$block;
            this.L$0 = null;
            this.label = 2;
            if (r104.invoke(r103, this) != r101) goto L19;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            r103 = (CoroutineScope) this.L$0;
            if (ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled == false) goto L15;
            Job r105 = this.$resetJob;
            this.L$0 = r103;
            this.label = 1;
            if (r105.join(this) != r101) goto L15;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {384}, m = "waitForLongPress", n = {"result"}, s = {"L$0"})
    public static final class C85911 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C85911(Continuation<? super C85911> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForLongPress(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2", f = "TapGestureDetector.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500, 409}, m = "invokeSuspend", n = {"$this$withTimeout", "$this$withTimeout"}, s = {"L$0", "L$0"})
    public static final class C85922 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerEventPass $pass;
        final /* synthetic */ Ref.ObjectRef<LongPressResult> $result;
        private /* synthetic */ Object L$0;
        int label;

        public C85922(PointerEventPass r100, Ref.ObjectRef<LongPressResult> r101, Continuation<? super C85922> r102) {
            this.$pass = r100;
            this.$result = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C85922 r102 = new C85922(this.$pass, this.$result, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
            return ((C85922) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, androidx.compose.foundation.gestures.LongPressResult$Success] */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
        /* JADX WARN: Type inference failed for: r1v4, types: [T, androidx.compose.foundation.gestures.LongPressResult$Released] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d4 -> B:46:0x00d7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            AwaitPointerEventScope r102 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            C85922 r103 = this;
        L46:
            List<PointerInputChange> r111 = ((PointerEvent) r110).getChanges();
            int r104 = r111.size();
            int r105 = 0;
        L47:
            if (r105 >= r104) goto L52;
            if (((PointerInputChange) ListProtector.get(r111, r105)).isConsumed() == true) goto L50;
            r105 = r105 + 1;
            goto L47
        L50:
            boolean r112 = true;
        L53:
            if (r112 == false) goto L57;
            Ref.ObjectRef<LongPressResult> r113 = r103.$result;
            r113.element = LongPressResult.Canceled.INSTANCE;
        L56:
            return Unit.INSTANCE;
        L57:
            AwaitPointerEventScope r114 = r102;
            C85922 r106 = r103;
        L11:
            PointerEventPass r107 = r106.$pass;
            r106.L$0 = r114;
            r106.label = 1;
            Object r108 = r114.awaitPointerEvent(r107, r106);
            if (r108 != r100) goto L14;
            return r100;
        L14:
            AwaitPointerEventScope r109 = r114;
            r110 = r108;
        L15:
            PointerEvent r115 = (PointerEvent) r110;
            List<PointerInputChange> r116 = r115.getChanges();
            int r117 = r116.size();
            int r118 = 0;
        L16:
            if (r118 >= r117) goto L21;
            if (PointerEventKt.changedToUp((PointerInputChange) ListProtector.get(r116, r118)) == false) goto L19;
            r118 = r118 + 1;
            goto L16
        L19:
            boolean r119 = false;
        L22:
            if (r119 == false) goto L25;
            Ref.ObjectRef<LongPressResult> r120 = r106.$result;
            r120.element = new LongPressResult.Released((PointerInputChange) ListProtector.get(r115.getChanges(), 0));
            goto L56
        L25:
            if (TapGestureDetector_androidKt.isDeepPress(r115) == false) goto L27;
            Ref.ObjectRef<LongPressResult> r121 = r106.$result;
            r121.element = LongPressResult.Success.INSTANCE;
            goto L56
        L27:
            List<PointerInputChange> r122 = r115.getChanges();
            int r123 = r122.size();
            int r124 = 0;
        L28:
            if (r124 >= r123) goto L39;
            PointerInputChange r125 = (PointerInputChange) ListProtector.get(r122, r124);
            if (r125.isConsumed() == false) goto L32;
        L35:
            boolean r126 = true;
        L36:
            if (r126 == true) goto L37;
            r124 = r124 + 1;
            goto L28
        L37:
            boolean r127 = true;
        L40:
            if (r127 == false) goto L42;
            Ref.ObjectRef<LongPressResult> r128 = r106.$result;
            r128.element = LongPressResult.Canceled.INSTANCE;
            goto L56
        L42:
            PointerEventPass r129 = PointerEventPass.Final;
            r106.L$0 = r109;
            r106.label = 2;
            r110 = r109.awaitPointerEvent(r129, r106);
            if (r110 != r100) goto L45;
            return r100;
        L45:
            AwaitPointerEventScope r130 = r109;
            r103 = r106;
            r102 = r130;
            goto L46
        L32:
            if (PointerEventKt.m6071isOutOfBoundsjwHxaWs(r125, r109.mo6021getSizeYbymL2g(), r109.mo6020getExtendedTouchPaddingNHjbRc()) == true) goto L35;
            r126 = false;
            goto L36
        L39:
            r127 = false;
            goto L40
        L21:
            r119 = true;
            goto L22
        L52:
            r112 = false;
            goto L53
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            AwaitPointerEventScope r131 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            r109 = r131;
            r106 = this;
            goto L15
        L10:
            ResultKt.throwOnFailure(r110);
            r114 = (AwaitPointerEventScope) this.L$0;
            r106 = this;
            goto L11
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 1, 1}, l = {352, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME}, m = "waitForUpOrCancellation", n = {"$this$waitForUpOrCancellation", "pass", "$this$waitForUpOrCancellation", "pass"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C85932 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C85932(Continuation<? super C85932> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    private static /* synthetic */ void getCoroutineStartForCurrentDispatchBehavior$annotations() {
    }

    @Deprecated(message = "This flag has been moved to ComposeFoundationFlags and renamed to isDetectTapGesturesImmediateCoroutineDispatchEnabled. For compatibility,  DetectTapGesturesEnableNewDispatchingBehavior controls the new flag (isDetectTapGesturesImmediateCoroutineDispatchEnabled). Please use  isDetectTapGesturesImmediateCoroutineDispatchEnabled instead.", replaceWith = @ReplaceWith(expression = "isDetectTapGesturesImmediateCoroutineDispatchEnabled", imports = {"androidx.compose.foundation.ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled"}))
    public static /* synthetic */ void getDetectTapGesturesEnableNewDispatchingBehavior$annotations() {
    }

    static {
        NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);
    }

    private static final CoroutineStart getCoroutineStartForCurrentDispatchBehavior() {
        if (ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled == false) goto L6;
        return CoroutineStart.UNDISPATCHED;
    L6:
        return CoroutineStart.DEFAULT;
    }

    public static final /* synthetic */ CoroutineStart access$getCoroutineStartForCurrentDispatchBehavior() {
        return getCoroutineStartForCurrentDispatchBehavior();
    }

    public static final /* synthetic */ Function3 access$getNoPressGesture$p() {
        return NoPressGesture;
    }

    public static final boolean getDetectTapGesturesEnableNewDispatchingBehavior() {
        return ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled;
    }

    public static final void setDetectTapGesturesEnableNewDispatchingBehavior(boolean r100) {
        ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled = r100;
    }

    public static final /* synthetic */ Object access$consumeUntilUp(AwaitPointerEventScope r100, Continuation r101) {
        return consumeUntilUp(r100, r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    private static final Object consumeUntilUp(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof C85871) == false) goto L7;
        C85871 r102 = (C85871) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (AwaitPointerEventScope) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        PointerEvent r107 = (PointerEvent) r104;
        List<PointerInputChange> r108 = r107.getChanges();
        int r109 = r108.size();
        boolean r110 = false;
        int r111 = 0;
    L19:
        if (r111 >= r109) goto L21;
        ((PointerInputChange) ListProtector.get(r108, r111)).consume();
        r111 = r111 + 1;
        goto L19
    L21:
        List<PointerInputChange> r112 = r107.getChanges();
        int r113 = r112.size();
        int r114 = 0;
    L22:
        if (r114 >= r113) goto L27;
        if (((PointerInputChange) ListProtector.get(r112, r114)).getPressed() == true) goto L25;
        r114 = r114 + 1;
        goto L22
    L25:
        r110 = true;
    L27:
        if (r110 == false) goto L29;
    L15:
        r102.L$0 = r100;
        r102.label = 1;
        r104 = AwaitPointerEventScope.CC.awaitPointerEvent$default(r100, null, r102, 1, null);
        if (r104 != r105) goto L18;
        return r105;
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
    L7:
        r102 = new C85871(r101);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object waitForUpOrCancellation(AwaitPointerEventScope r100, Continuation r101) {
        return waitForUpOrCancellation(r100, PointerEventPass.Main, r101);
    }

    public static final /* synthetic */ Object access$awaitSecondDown(AwaitPointerEventScope r100, PointerInputChange r101, Continuation r102) {
        return awaitSecondDown(r100, r101, r102);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object awaitFirstDown(AwaitPointerEventScope r100, boolean r101, Continuation r102) {
        return awaitFirstDown(r100, r101, PointerEventPass.Main, r102);
    }

    private static final Object awaitSecondDown(AwaitPointerEventScope r100, PointerInputChange r101, Continuation<? super PointerInputChange> r102) {
        return r100.withTimeoutOrNull(r100.getViewConfiguration().getDoubleTapTimeoutMillis(), new C85862(r101, null), r102);
    }

    public static final boolean isChangedToDown(PointerEvent r100, boolean r101, boolean r102) {
        if (r102 == false) goto L13;
        List<PointerInputChange> r103 = r100.getChanges();
        int r104 = r103.size();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        if (PointerType.m6198equalsimpl0(((PointerInputChange) ListProtector.get(r103, r105)).m6129getTypeT8wyACA(), PointerType.Companion.m6203getMouseT8wyACA()) == false) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L16;
    L18:
        List<PointerInputChange> r108 = r100.getChanges();
        int r109 = r108.size();
        int r110 = 0;
    L19:
        if (r110 >= r109) goto L32;
        PointerInputChange r111 = (PointerInputChange) ListProtector.get(r108, r110);
        if (r101 == false) goto L23;
        boolean r112 = PointerEventKt.changedToDown(r111);
    L24:
        if (r112 == false) goto L25;
        r110 = r110 + 1;
        goto L19
    L25:
        return false;
    L23:
        r112 = PointerEventKt.changedToDownIgnoreConsumed(r111);
        goto L24
    L32:
        return true;
    L16:
        if (PointerEvent_androidKt.m6099isPrimaryPressedaHzCxE(r100.m6066getButtonsry648PA()) == true) goto L18;
        return false;
    L10:
        r106 = true;
    L13:
        r107 = false;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
    public static final Object waitForLongPress(AwaitPointerEventScope r100, PointerEventPass r101, Continuation<? super LongPressResult> r102) {
        if ((r102 instanceof C85911) == false) goto L7;
        C85911 r103 = (C85911) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        Ref.ObjectRef r108 = (Ref.ObjectRef) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: PointerEventTimeoutCancellationException -> L23
    L21:
        return r108.element;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        Ref.ObjectRef r109 = new Ref.ObjectRef();
        r109.element = LongPressResult.Canceled.INSTANCE;
        long r110 = r100.getViewConfiguration().getLongPressTimeoutMillis();     // Catch: PointerEventTimeoutCancellationException -> L23
        C85922 r111 = new C85922(r101, r109, null);     // Catch: PointerEventTimeoutCancellationException -> L23
        r103.L$0 = r109;     // Catch: PointerEventTimeoutCancellationException -> L23
        r103.label = 1;     // Catch: PointerEventTimeoutCancellationException -> L23
        if (r100.withTimeout(r110, r111, r103) != r106) goto L20;
        return r106;
    L20:
        r108 = r109;
    L24:
        return LongPressResult.Success.INSTANCE;
    L7:
        r103 = new C85911(r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00e4 -> B:13:0x0037). Please report as a decompilation issue!!! */
    public static final Object waitForUpOrCancellation(AwaitPointerEventScope r110, PointerEventPass r111, Continuation<? super PointerInputChange> r210) {
        if ((r210 instanceof C85932) == false) goto L7;
        C85932 r100 = (C85932) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L17;
        if (r104 == 1) goto L16;
        if (r104 != 2) goto L15;
        PointerEventPass r105 = (PointerEventPass) r100.L$1;
        AwaitPointerEventScope r106 = (AwaitPointerEventScope) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L13:
        Object r112 = r103;
        C85932 r107 = r100;
        PointerEventPass r108 = r105;
        Object r109 = r112;
        List<PointerInputChange> r113 = ((PointerEvent) r102).getChanges();
        int r114 = r113.size();
        int r115 = 0;
    L51:
        if (r115 >= r114) goto L56;
        if (((PointerInputChange) ListProtector.get(r113, r115)).isConsumed() == true) goto L54;
        r115 = r115 + 1;
        goto L51
    L54:
        boolean r116 = true;
    L57:
        if (r116 == false) goto L59;
        return null;
    L59:
        AwaitPointerEventScope r117 = r106;
    L18:
        r107.L$0 = r117;
        r107.L$1 = r108;
        r107.label = 1;
        Object r118 = r117.awaitPointerEvent(r108, r107);
        if (r118 != r109) goto L21;
        return r109;
    L21:
        r106 = r117;
        r102 = r118;
        Object r119 = r109;
        r105 = r108;
        r100 = r107;
        r103 = r119;
    L22:
        PointerEvent r120 = (PointerEvent) r102;
        List<PointerInputChange> r121 = r120.getChanges();
        int r122 = r121.size();
        int r123 = 0;
    L23:
        if (r123 >= r122) goto L28;
        if (PointerEventKt.changedToUp((PointerInputChange) ListProtector.get(r121, r123)) == false) goto L26;
        r123 = r123 + 1;
        goto L23
    L26:
        boolean r124 = false;
    L29:
        if (r124 == true) goto L31;
        List<PointerInputChange> r125 = r120.getChanges();
        int r126 = r125.size();
        int r127 = 0;
    L33:
        if (r127 >= r126) goto L44;
        PointerInputChange r128 = (PointerInputChange) ListProtector.get(r125, r127);
        if (r128.isConsumed() == false) goto L37;
    L40:
        boolean r129 = true;
    L41:
        if (r129 == true) goto L42;
        r127 = r127 + 1;
        goto L33
    L42:
        boolean r130 = true;
    L45:
        if (r130 == false) goto L47;
        return null;
    L47:
        PointerEventPass r131 = PointerEventPass.Final;
        r100.L$0 = r106;
        r100.L$1 = r105;
        r100.label = 2;
        r102 = r106.awaitPointerEvent(r131, r100);
        if (r102 != r103) goto L13;
        return r103;
    L37:
        if (PointerEventKt.m6071isOutOfBoundsjwHxaWs(r128, r106.mo6021getSizeYbymL2g(), r106.mo6020getExtendedTouchPaddingNHjbRc()) == true) goto L40;
        r129 = false;
        goto L41
    L44:
        r130 = false;
        goto L45
    L31:
        return ListProtector.get(r120.getChanges(), 0);
    L28:
        r124 = true;
        goto L29
    L56:
        r116 = false;
        goto L57
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r105 = (PointerEventPass) r100.L$1;
        r106 = (AwaitPointerEventScope) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L22
    L17:
        ResultKt.throwOnFailure(r102);
        r117 = r110;
        r109 = r103;
        r107 = r100;
        r108 = r111;
    L7:
        r100 = new C85932(r210);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    public static final Object awaitFirstDown(AwaitPointerEventScope r100, boolean r101, PointerEventPass r102, Continuation<? super PointerInputChange> r110) {
        if ((r110 instanceof AnonymousClass2) == false) goto L7;
        AnonymousClass2 r103 = (AnonymousClass2) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        boolean r107 = r103.Z$0;
        PointerEventPass r108 = (PointerEventPass) r103.L$1;
        AwaitPointerEventScope r109 = (AwaitPointerEventScope) r103.L$0;
        ResultKt.throwOnFailure(r111);
        r101 = r107;
        r100 = r109;
        r102 = r108;
    L18:
        PointerEvent r112 = (PointerEvent) r111;
        if (isChangedToDown$default(r112, r101, false, 2, null) == true) goto L21;
    L15:
        r103.L$0 = r100;
        r103.L$1 = r102;
        r103.Z$0 = r101;
        r103.label = 1;
        r111 = r100.awaitPointerEvent(r102, r103);
        if (r111 != r105) goto L18;
        return r105;
    L21:
        return ListProtector.get(r112.getChanges(), 0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
    L7:
        r103 = new AnonymousClass2(r110);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    public static final Object awaitPrimaryFirstDown(AwaitPointerEventScope r100, boolean r101, PointerEventPass r102, Continuation<? super PointerInputChange> r103) {
        if ((r103 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r104 = (AnonymousClass1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        boolean r109 = r104.Z$0;
        PointerEventPass r110 = (PointerEventPass) r104.L$1;
        AwaitPointerEventScope r111 = (AwaitPointerEventScope) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r101 = r109;
        r100 = r111;
        r102 = r110;
    L18:
        PointerEvent r112 = (PointerEvent) r106;
        if (isChangedToDown(r112, r101, true) == true) goto L21;
    L15:
        r104.L$0 = r100;
        r104.L$1 = r102;
        r104.Z$0 = r101;
        r104.label = 1;
        r106 = r100.awaitPointerEvent(r102, r104);
        if (r106 != r107) goto L18;
        return r107;
    L21:
        return ListProtector.get(r112.getChanges(), 0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
    L7:
        r104 = new AnonymousClass1(r103);
        goto L8
    }

    public static final Object detectTapAndPress(PointerInputScope r100, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r101, Function1<? super Offset, Unit> r102, Continuation<? super Unit> r110) {
        Object r103 = CoroutineScopeKt.coroutineScope(new C85882(r100, r101, r102, new PressGestureScopeImpl(r100), null), r110);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    private static final Job launchAwaitingReset(CoroutineScope r100, Job r101, CoroutineStart r102, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r103) {
        return BuildersKt.launch$default(r100, null, r102, new C85901(r101, r103, null), 1, null);
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope r100, boolean r101, Continuation r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = true;
    L6:
        return awaitFirstDown(r100, r101, r102);
    }

    public static /* synthetic */ boolean isChangedToDown$default(PointerEvent r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = TapGestureDetector_androidKt.firstDownRefersToPrimaryMouseButtonOnly();
    L6:
        return isChangedToDown(r100, r101, r102);
    }

    public static /* synthetic */ Object waitForLongPress$default(AwaitPointerEventScope r100, PointerEventPass r101, Continuation r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = PointerEventPass.Main;
    L6:
        return waitForLongPress(r100, r101, r102);
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope r100, PointerEventPass r101, Continuation r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = PointerEventPass.Main;
    L6:
        return waitForUpOrCancellation(r100, r101, r102);
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope r100, boolean r101, PointerEventPass r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = PointerEventPass.Main;
    L9:
        return awaitFirstDown(r100, r101, r102, r103);
    }

    public static /* synthetic */ Object awaitPrimaryFirstDown$default(AwaitPointerEventScope r100, boolean r101, PointerEventPass r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = PointerEventPass.Main;
    L9:
        return awaitPrimaryFirstDown(r100, r101, r102, r103);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope r100, Function3 r101, Function1 r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = NoPressGesture;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = null;
    L9:
        return detectTapAndPress(r100, r101, r102, r103);
    }

    public static final Object detectTapGestures(PointerInputScope r100, Function1<? super Offset, Unit> r101, Function1<? super Offset, Unit> r110, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r111, Function1<? super Offset, Unit> r112, Continuation<? super Unit> r113) {
        Object r102 = CoroutineScopeKt.coroutineScope(new C85892(r100, r111, r110, r101, r112, null), r113);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Job launchAwaitingReset$default(CoroutineScope r100, Job r101, CoroutineStart r102, Function2 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = getCoroutineStartForCurrentDispatchBehavior();
    L6:
        return launchAwaitingReset(r100, r101, r102, r103);
    }

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope r100, Function1 r101, Function1 r102, Function3 r110, Function1 r111, Continuation r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        Function1 r103 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        Function1 r104 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r110 = NoPressGesture;
    L13:
        Function3 r105 = r110;
        if ((r113 & 8) == 0) goto L16;
        Function1 r106 = null;
    L18:
        return detectTapGestures(r100, r103, r104, r105, r106, r112);
    L16:
        r106 = r111;
        goto L18
    L9:
        r104 = r102;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }
}
