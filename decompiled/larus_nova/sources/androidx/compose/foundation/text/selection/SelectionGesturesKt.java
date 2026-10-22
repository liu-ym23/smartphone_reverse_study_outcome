package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\"\u0010\r\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u0007*\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0080@¢\u0006\u0002\u0010\u0019\u001a\"\u0010\u001a\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a\"\u0010\u001c\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a*\u0010\u001d\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u001e\u001a\u00020\u0011*\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u001f\u001a \u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010&\u001a\u00020\u0006*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"STATIC_KEY", "", "updateSelectionTouchMode", "Landroidx/compose/ui/Modifier;", "updateTouchMode", "Lkotlin/Function1;", "", "", "selectionGestureInput", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "touchSelection", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "observer", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "mouseSelectionBtf2", "awaitDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "isPrecisePointer", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0}, l = {432}, m = "awaitDown", n = {"$this$awaitDown"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.access$awaitDown(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 1, 1, 1}, l = {159, 184}, m = "mouseSelection", n = {"$this$mouseSelection", "observer", "$this$mouseSelection", "observer", "dragConsumed"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class C86591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C86591(Continuation<? super C86591> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.access$mouseSelection(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 1, 1, 1}, l = {358, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500}, m = "mouseSelectionBtf2", n = {"$this$mouseSelectionBtf2", "observer", "$this$mouseSelectionBtf2", "observer", "dragConsumed"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class C86601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C86601(Continuation<? super C86601> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.access$mouseSelectionBtf2(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2", f = "SelectionGestures.kt", i = {0}, l = {210, 218, 221, 222}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
    public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ClicksCounter $clicksCounter;
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(ClicksCounter r100, MouseSelectionObserver r101, TextDragObserver r102, Continuation<? super AnonymousClass2> r103) {
            this.$clicksCounter = r100;
            this.$mouseSelectionObserver = r101;
            this.$textDragObserver = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.$clicksCounter, this.$mouseSelectionObserver, this.$textDragObserver, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(AwaitPointerEventScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L13;
            if (r101 == 1) goto L12;
            if (r101 == 2) goto L11;
            if (r101 == 3) goto L11;
            if (r101 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r110);
        L41:
            return Unit.INSTANCE;
        L12:
            AwaitPointerEventScope r102 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r110);
        L16:
            PointerEvent r111 = (PointerEvent) r110;
            this.$clicksCounter.update(r111);
            boolean r103 = SelectionGesturesKt.isPrecisePointer(r111);
            if (r103 == true) goto L19;
        L31:
            if (r103 == true) goto L41;
            if (this.$clicksCounter.getClicks() != 1) goto L37;
            TextDragObserver r104 = this.$textDragObserver;
            this.L$0 = null;
            this.label = 3;
            if (SelectionGesturesKt.access$touchSelectionFirstPress(r102, r104, r111, this) != r100) goto L41;
            return r100;
        L37:
            TextDragObserver r105 = this.$textDragObserver;
            this.L$0 = null;
            this.label = 4;
            if (SelectionGesturesKt.access$touchSelectionSubsequentPress(r102, r105, r111, this) != r100) goto L41;
            return r100;
        L19:
            if (PointerEvent_androidKt.m6099isPrimaryPressedaHzCxE(r111.m6066getButtonsry648PA()) == false) goto L31;
            List<PointerInputChange> r106 = r111.getChanges();
            int r107 = r106.size();
            boolean r112 = false;
            int r113 = 0;
        L21:
            if (r113 >= r107) goto L26;
            if ((!((PointerInputChange) ListProtector.get(r106, r113)).isConsumed()) == false) goto L27;
            r113 = r113 + 1;
        L27:
            if (r112 == false) goto L31;
            MouseSelectionObserver r108 = this.$mouseSelectionObserver;
            ClicksCounter r109 = this.$clicksCounter;
            this.L$0 = null;
            this.label = 2;
            if (SelectionGesturesKt.access$mouseSelectionBtf2(r102, r108, r109, r111, this) != r100) goto L41;
            return r100;
        L26:
            r112 = true;
            goto L27
        L13:
            ResultKt.throwOnFailure(r110);
            r102 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = r102;
            this.label = 1;
            r110 = SelectionGesturesKt.access$awaitDown(r102, this);
            if (r110 != r100) goto L16;
            return r100;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 1, 1}, l = {126, 130}, m = "touchSelection", n = {"$this$touchSelection", "observer", "firstDown", "$this$touchSelection", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class C86621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C86621(Continuation<? super C86621> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.access$touchSelection(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 1, 1}, l = {VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 243}, m = "touchSelectionFirstPress", n = {"$this$touchSelectionFirstPress", "observer", "firstDown", "$this$touchSelectionFirstPress", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class C86631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C86631(Continuation<? super C86631> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.access$touchSelectionFirstPress(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 323}, m = "touchSelectionSubsequentPress", n = {"$this$touchSelectionSubsequentPress", "observer", "firstDown", "overSlop", "pointerId", "$this$touchSelectionSubsequentPress", "observer"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1"})
    public static final class C86641 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C86641(Continuation<? super C86641> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.access$touchSelectionSubsequentPress(null, null, null, this);
        }
    }

    public static /* synthetic */ Unit a(TextDragObserver r100, PointerInputChange r101) {
        return touchSelectionSubsequentPress$lambda$8(r100, r101);
    }

    public static /* synthetic */ Unit b(MouseSelectionObserver r100, PointerInputChange r101) {
        return mouseSelection$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit c(MouseSelectionObserver r100, SelectionAdjustment r101, Ref.BooleanRef r102, PointerInputChange r103) {
        return mouseSelection$lambda$4(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit d(TextDragObserver r100, PointerInputChange r101) {
        return touchSelection$lambda$0(r100, r101);
    }

    public static /* synthetic */ Unit e(TextDragObserver r100, PointerInputChange r101) {
        return touchSelectionFirstPress$lambda$6(r100, r101);
    }

    public static /* synthetic */ Unit f(MouseSelectionObserver r100, SelectionAdjustment r101, Ref.BooleanRef r102, PointerInputChange r103) {
        return mouseSelectionBtf2$lambda$12(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit g(MouseSelectionObserver r100, PointerInputChange r101) {
        return mouseSelectionBtf2$lambda$10(r100, r101);
    }

    public static final boolean isPrecisePointer(PointerEvent r100) {
        List<PointerInputChange> r101 = r100.getChanges();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (PointerType.m6198equalsimpl0(((PointerInputChange) ListProtector.get(r101, r103)).m6129getTypeT8wyACA(), PointerType.Companion.m6203getMouseT8wyACA()) == false) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    public static final /* synthetic */ Object access$awaitDown(AwaitPointerEventScope r100, Continuation r101) {
        return awaitDown(r100, r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    private static final Object awaitDown(AwaitPointerEventScope r100, Continuation<? super PointerEvent> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
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
        if (r111 >= r109) goto L24;
        if (PointerEventKt.changedToDownIgnoreConsumed((PointerInputChange) ListProtector.get(r108, r111)) == false) goto L25;
        r111 = r111 + 1;
    L25:
        if (r110 == true) goto L26;
    L15:
        PointerEventPass r112 = PointerEventPass.Main;
        r102.L$0 = r100;
        r102.label = 1;
        r104 = r100.awaitPointerEvent(r112, r102);
        if (r104 != r105) goto L18;
        return r105;
    L26:
        return r107;
    L24:
        r110 = true;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
    L7:
        r102 = new AnonymousClass1(r101);
        goto L8
    }

    private static final Unit mouseSelection$lambda$2(MouseSelectionObserver r100, PointerInputChange r101) {
        if (r100.mo1373onExtendDragk4lQ0M(r101.m6126getPositionF1C5BW0()) == false) goto L6;
        r101.consume();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit mouseSelectionBtf2$lambda$10(MouseSelectionObserver r100, PointerInputChange r101) {
        if (r100.mo1373onExtendDragk4lQ0M(r101.m6126getPositionF1C5BW0()) == false) goto L6;
        r101.consume();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit touchSelection$lambda$0(TextDragObserver r100, PointerInputChange r101) {
        r100.mo1130onDragk4lQ0M(PointerEventKt.positionChange(r101));
        r101.consume();
        return Unit.INSTANCE;
    }

    private static final Unit touchSelectionFirstPress$lambda$6(TextDragObserver r100, PointerInputChange r101) {
        r100.mo1130onDragk4lQ0M(PointerEventKt.positionChange(r101));
        r101.consume();
        return Unit.INSTANCE;
    }

    private static final Unit touchSelectionSubsequentPress$lambda$8(TextDragObserver r100, PointerInputChange r101) {
        r100.mo1130onDragk4lQ0M(PointerEventKt.positionChange(r101));
        r101.consume();
        return Unit.INSTANCE;
    }

    public static final Modifier updateSelectionTouchMode(Modifier r100, final Function1<? super Boolean, Unit> r101) {
        return SuspendingPointerInputFilterKt.pointerInput(r100, Integer.valueOf(STATIC_KEY), new C86651(r101));
    }

    public static final /* synthetic */ boolean access$distanceIsTolerable(ViewConfiguration r100, PointerInputChange r101, PointerInputChange r102) {
        return distanceIsTolerable(r100, r101, r102);
    }

    private static final boolean distanceIsTolerable(ViewConfiguration r100, PointerInputChange r101, PointerInputChange r102) {
        float r103 = DragGestureDetectorKt.m432pointerSlopE8SPZFQ(r100, r101.m6129getTypeT8wyACA());
        if (Offset.m4580getDistanceimpl(Offset.m4586minusMKHz9U(r101.m6126getPositionF1C5BW0(), r102.m6126getPositionF1C5BW0())) >= r103) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Modifier selectionGestureInput(Modifier r100, final MouseSelectionObserver r101, final TextDragObserver r102) {
        return SuspendingPointerInputFilterKt.pointerInput(r100, r101, r102, new C86611(r101, r102));
    }

    public static final /* synthetic */ Object access$touchSelection(AwaitPointerEventScope r100, TextDragObserver r101, PointerEvent r102, Continuation r103) {
        return touchSelection(r100, r101, r102, r103);
    }

    public static final /* synthetic */ Object access$touchSelectionFirstPress(AwaitPointerEventScope r100, TextDragObserver r101, PointerEvent r102, Continuation r103) {
        return touchSelectionFirstPress(r100, r101, r102, r103);
    }

    public static final /* synthetic */ Object access$touchSelectionSubsequentPress(AwaitPointerEventScope r100, TextDragObserver r101, PointerEvent r102, Continuation r103) {
        return touchSelectionSubsequentPress(r100, r101, r102, r103);
    }

    private static final Unit mouseSelection$lambda$4(MouseSelectionObserver r100, SelectionAdjustment r101, Ref.BooleanRef r102, PointerInputChange r103) {
        if (r100.mo1371onDrag3MmeM6k(r103.m6126getPositionF1C5BW0(), r101) == false) goto L6;
        r103.consume();
        r102.element = true;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit mouseSelectionBtf2$lambda$12(MouseSelectionObserver r100, SelectionAdjustment r101, Ref.BooleanRef r102, PointerInputChange r103) {
        if (r100.mo1371onDrag3MmeM6k(r103.m6126getPositionF1C5BW0(), r101) == false) goto L6;
        r103.consume();
        r102.element = true;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object selectionGesturePointerInputBtf2(PointerInputScope r100, MouseSelectionObserver r101, TextDragObserver r102, Continuation<? super Unit> r103) {
        Object r104 = ForEachGestureKt.awaitEachGesture(r100, new AnonymousClass2(new ClicksCounter(r100.getViewConfiguration()), r101, r102, null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }

    private static final Object touchSelection(AwaitPointerEventScope r100, final TextDragObserver r101, PointerEvent r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof C86621) == false) goto L7;
        C86621 r102 = (C86621) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L17;
        if (r105 != 2) goto L16;
        r101 = (TextDragObserver) r102.L$1;
        r100 = (AwaitPointerEventScope) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: CancellationException -> L43
    L32:
        if (((Boolean) r112).booleanValue() == false) goto L40;
        List<PointerInputChange> r106 = r100.getCurrentEvent().getChanges();     // Catch: CancellationException -> L43
        int r113 = r106.size();     // Catch: CancellationException -> L43
        int r114 = 0;
    L34:
        if (r114 >= r113) goto L39;
        PointerInputChange r107 = (PointerInputChange) ListProtector.get(r106, r114);     // Catch: CancellationException -> L43
        if (PointerEventKt.changedToUp(r107) == false) goto L38;
        r107.consume();     // Catch: CancellationException -> L43
    L38:
        r114 = r114 + 1;     // Catch: CancellationException -> L43
        goto L34
    L39:
        r101.onStop();     // Catch: CancellationException -> L43
    L42:
        return Unit.INSTANCE;
    L40:
        r101.onCancel();     // Catch: CancellationException -> L43
        goto L42
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        PointerInputChange r108 = (PointerInputChange) r102.L$2;
        r101 = (TextDragObserver) r102.L$1;
        AwaitPointerEventScope r115 = (AwaitPointerEventScope) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: CancellationException -> L43
        PointerInputChange r116 = r108;
        r100 = r115;
    L24:
        PointerInputChange r117 = (PointerInputChange) r112;     // Catch: CancellationException -> L43
        if (r117 == null) goto L42;
        if (distanceIsTolerable(r100.getViewConfiguration(), r116, r117) == false) goto L42;
        r101.mo1131onStartk4lQ0M(r117.m6126getPositionF1C5BW0());     // Catch: CancellationException -> L43
        long r118 = r117.m6124getIdJ3iCeTQ();     // Catch: CancellationException -> L43
        Function1 r109 = new d0(r101);     // Catch: CancellationException -> L43
        r102.L$0 = r100;     // Catch: CancellationException -> L43
        r102.L$1 = r101;     // Catch: CancellationException -> L43
        r102.L$2 = null;     // Catch: CancellationException -> L43
        r102.label = 2;     // Catch: CancellationException -> L43
        r112 = DragGestureDetectorKt.m429dragjO51t88(r100, r118, r109, r102);     // Catch: CancellationException -> L43
        if (r112 != r104) goto L32;
        return r104;
    L20:
        ResultKt.throwOnFailure(r112);
        r116 = (PointerInputChange) CollectionsKt.first(r110.getChanges());     // Catch: CancellationException -> L43
        long r119 = r116.m6124getIdJ3iCeTQ();     // Catch: CancellationException -> L43
        r102.L$0 = r100;     // Catch: CancellationException -> L43
        r102.L$1 = r101;     // Catch: CancellationException -> L43
        r102.L$2 = r116;     // Catch: CancellationException -> L43
        r102.label = 1;     // Catch: CancellationException -> L43
        r112 = DragGestureDetectorKt.m419awaitLongPressOrCancellationrnUCldI(r100, r119, r102);     // Catch: CancellationException -> L43
        if (r112 != r104) goto L24;
        return r104;
    L43:
        e = move-exception;
        r101.onCancel();
        throw e;
    L7:
        r102 = new C86621(r111);
        goto L8
    }

    private static final Object touchSelectionFirstPress(AwaitPointerEventScope r100, final TextDragObserver r101, PointerEvent r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof C86631) == false) goto L7;
        C86631 r102 = (C86631) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L17;
        if (r105 != 2) goto L16;
        r101 = (TextDragObserver) r102.L$1;
        r100 = (AwaitPointerEventScope) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: CancellationException -> L43
    L32:
        if (((Boolean) r112).booleanValue() == false) goto L40;
        List<PointerInputChange> r106 = r100.getCurrentEvent().getChanges();     // Catch: CancellationException -> L43
        int r113 = r106.size();     // Catch: CancellationException -> L43
        int r114 = 0;
    L34:
        if (r114 >= r113) goto L39;
        PointerInputChange r107 = (PointerInputChange) ListProtector.get(r106, r114);     // Catch: CancellationException -> L43
        if (PointerEventKt.changedToUp(r107) == false) goto L38;
        r107.consume();     // Catch: CancellationException -> L43
    L38:
        r114 = r114 + 1;     // Catch: CancellationException -> L43
        goto L34
    L39:
        r101.onStop();     // Catch: CancellationException -> L43
    L42:
        return Unit.INSTANCE;
    L40:
        r101.onCancel();     // Catch: CancellationException -> L43
        goto L42
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        PointerInputChange r108 = (PointerInputChange) r102.L$2;
        r101 = (TextDragObserver) r102.L$1;
        AwaitPointerEventScope r115 = (AwaitPointerEventScope) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: CancellationException -> L43
        PointerInputChange r116 = r108;
        r100 = r115;
    L24:
        PointerInputChange r117 = (PointerInputChange) r112;     // Catch: CancellationException -> L43
        if (r117 == null) goto L42;
        if (distanceIsTolerable(r100.getViewConfiguration(), r116, r117) == false) goto L42;
        r101.mo1131onStartk4lQ0M(r117.m6126getPositionF1C5BW0());     // Catch: CancellationException -> L43
        long r118 = r117.m6124getIdJ3iCeTQ();     // Catch: CancellationException -> L43
        Function1 r109 = new h0(r101);     // Catch: CancellationException -> L43
        r102.L$0 = r100;     // Catch: CancellationException -> L43
        r102.L$1 = r101;     // Catch: CancellationException -> L43
        r102.L$2 = null;     // Catch: CancellationException -> L43
        r102.label = 2;     // Catch: CancellationException -> L43
        r112 = DragGestureDetectorKt.m429dragjO51t88(r100, r118, r109, r102);     // Catch: CancellationException -> L43
        if (r112 != r104) goto L32;
        return r104;
    L20:
        ResultKt.throwOnFailure(r112);
        r116 = (PointerInputChange) CollectionsKt.first(r110.getChanges());     // Catch: CancellationException -> L43
        long r119 = r116.m6124getIdJ3iCeTQ();     // Catch: CancellationException -> L43
        r102.L$0 = r100;     // Catch: CancellationException -> L43
        r102.L$1 = r101;     // Catch: CancellationException -> L43
        r102.L$2 = r116;     // Catch: CancellationException -> L43
        r102.label = 1;     // Catch: CancellationException -> L43
        r112 = DragGestureDetectorKt.m419awaitLongPressOrCancellationrnUCldI(r100, r119, r102);     // Catch: CancellationException -> L43
        if (r112 != r104) goto L24;
        return r104;
    L43:
        e = move-exception;
        r101.onCancel();
        throw e;
    L7:
        r102 = new C86631(r111);
        goto L8
    }

    private static final Object touchSelectionSubsequentPress(AwaitPointerEventScope r110, final TextDragObserver r111, PointerEvent r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof C86641) == false) goto L7;
        C86641 r100 = (C86641) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L16;
        r111 = (TextDragObserver) r100.L$1;
        r110 = (AwaitPointerEventScope) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: CancellationException -> L55
    L44:
        if (((Boolean) r114).booleanValue() == false) goto L52;
        List<PointerInputChange> r115 = r110.getCurrentEvent().getChanges();     // Catch: CancellationException -> L55
        int r116 = r115.size();     // Catch: CancellationException -> L55
        int r117 = 0;
    L46:
        if (r117 >= r116) goto L51;
        PointerInputChange r104 = (PointerInputChange) ListProtector.get(r115, r117);     // Catch: CancellationException -> L55
        if (PointerEventKt.changedToUp(r104) == false) goto L50;
        r104.consume();     // Catch: CancellationException -> L55
    L50:
        r117 = r117 + 1;     // Catch: CancellationException -> L55
        goto L46
    L51:
        r111.onStop();     // Catch: CancellationException -> L55
    L54:
        return Unit.INSTANCE;
    L52:
        r111.onCancel();     // Catch: CancellationException -> L55
        goto L54
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r118 = r100.J$0;
        Ref.LongRef r119 = (Ref.LongRef) r100.L$3;
        PointerInputChange r105 = (PointerInputChange) r100.L$2;
        TextDragObserver r106 = (TextDragObserver) r100.L$1;
        AwaitPointerEventScope r107 = (AwaitPointerEventScope) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: CancellationException -> L20
        Ref.LongRef r108 = r119;
        Object r109 = r114;
        long r120 = r118;
        r111 = r106;
        r110 = r107;
    L26:
        DownResolution r121 = (DownResolution) r109;     // Catch: CancellationException -> L55
        if (r121 != null) goto L30;
        r121 = DownResolution.Timeout;     // Catch: CancellationException -> L55
    L30:
        if (r121 == DownResolution.Cancel) goto L32;
        r111.mo1131onStartk4lQ0M(r105.m6126getPositionF1C5BW0());     // Catch: CancellationException -> L55
        if (r121 != DownResolution.Up) goto L38;
        r111.onStop();     // Catch: CancellationException -> L55
        return Unit.INSTANCE;
    L38:
        if (r121 != DownResolution.Drag) goto L40;
        r111.mo1130onDragk4lQ0M(r108.element);     // Catch: CancellationException -> L55
    L40:
        Function1 r122 = new g0(r111);     // Catch: CancellationException -> L55
        r100.L$0 = r110;     // Catch: CancellationException -> L55
        r100.L$1 = r111;     // Catch: CancellationException -> L55
        r100.L$2 = null;     // Catch: CancellationException -> L55
        r100.L$3 = null;     // Catch: CancellationException -> L55
        r100.label = 2;     // Catch: CancellationException -> L55
        r114 = DragGestureDetectorKt.m429dragjO51t88(r110, r120, r122, r100);     // Catch: CancellationException -> L55
        if (r114 != r102) goto L44;
        return r102;
    L32:
        return Unit.INSTANCE;
    L20:
        e = e;
        r111 = r106;
    L56:
        r111.onCancel();
        throw e;
    L22:
        ResultKt.throwOnFailure(r114);
        r105 = (PointerInputChange) CollectionsKt.first(r112.getChanges());     // Catch: CancellationException -> L55
        r120 = r105.m6124getIdJ3iCeTQ();     // Catch: CancellationException -> L55
        r108 = new Ref.LongRef();     // Catch: CancellationException -> L55
        r108.element = Offset.Companion.m4597getUnspecifiedF1C5BW0();     // Catch: CancellationException -> L55
        long r123 = r110.getViewConfiguration().getLongPressTimeoutMillis();     // Catch: CancellationException -> L55
        SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 r124 = new SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(r120, r108, null);     // Catch: CancellationException -> L55
        r100.L$0 = r110;     // Catch: CancellationException -> L55
        r100.L$1 = r111;     // Catch: CancellationException -> L55
        r100.L$2 = r105;     // Catch: CancellationException -> L55
        r100.L$3 = r108;     // Catch: CancellationException -> L55
        r100.J$0 = r120;     // Catch: CancellationException -> L55
        r100.label = 1;     // Catch: CancellationException -> L55
        r109 = r110.withTimeoutOrNull(r123, r124, r100);     // Catch: CancellationException -> L55
        if (r109 != r102) goto L26;
        return r102;
    L55:
        e = e;
    L7:
        r100 = new C86641(r113);
        goto L8
    }

    public static final /* synthetic */ Object access$mouseSelection(AwaitPointerEventScope r100, MouseSelectionObserver r101, ClicksCounter r102, PointerEvent r103, Continuation r104) {
        return mouseSelection(r100, r101, r102, r103, r104);
    }

    public static final /* synthetic */ Object access$mouseSelectionBtf2(AwaitPointerEventScope r100, MouseSelectionObserver r101, ClicksCounter r102, PointerEvent r103, Continuation r104) {
        return mouseSelectionBtf2(r100, r101, r102, r103, r104);
    }

    private static final Object mouseSelection(AwaitPointerEventScope r100, final MouseSelectionObserver r110, ClicksCounter r111, PointerEvent r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof C86591) == false) goto L7;
        C86591 r101 = (C86591) r113;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r114 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        int r105 = 0;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        Ref.BooleanRef r106 = (Ref.BooleanRef) r101.L$2;
        r110 = (MouseSelectionObserver) r101.L$1;
        AwaitPointerEventScope r115 = (AwaitPointerEventScope) r101.L$0;
        ResultKt.throwOnFailure(r114);
    L45:
        if (((Boolean) r114).booleanValue() == true) goto L47;
    L54:
        r110.onDragDone();
    L56:
        return Unit.INSTANCE;
    L47:
        if (r106.element == false) goto L54;
        List<PointerInputChange> r107 = r115.getCurrentEvent().getChanges();
        int r116 = r107.size();
    L49:
        if (r105 >= r116) goto L54;
        PointerInputChange r117 = (PointerInputChange) ListProtector.get(r107, r105);
        if (PointerEventKt.changedToUp(r117) == false) goto L53;
        r117.consume();
    L53:
        r105 = r105 + 1;
        goto L49
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (MouseSelectionObserver) r101.L$1;
        r100 = (AwaitPointerEventScope) r101.L$0;
        ResultKt.throwOnFailure(r114);
    L24:
        if (((Boolean) r114).booleanValue() == false) goto L31;
        List<PointerInputChange> r108 = r100.getCurrentEvent().getChanges();
        int r118 = r108.size();
    L26:
        if (r105 >= r118) goto L31;
        PointerInputChange r119 = (PointerInputChange) ListProtector.get(r108, r105);
        if (PointerEventKt.changedToUp(r119) == false) goto L30;
        r119.consume();
    L30:
        r105 = r105 + 1;
    L31:
        r110.onDragDone();
        goto L56
    L16:
        ResultKt.throwOnFailure(r114);
        r111.update(r112);
        PointerInputChange r120 = (PointerInputChange) ListProtector.get(r112.getChanges(), 0);
        if (TextFieldSelectionManager_androidKt.isShiftPressed(r112) == true) goto L19;
        int r121 = r111.getClicks();
        if (r121 == 1) goto L37;
        if (r121 == 2) goto L36;
        final SelectionAdjustment r122 = SelectionAdjustment.Companion.getParagraph();
    L39:
        if (r110.mo1374onStart9KIMszo(r120.m6126getPositionF1C5BW0(), r122, r111.getClicks()) == false) goto L56;
        final Ref.BooleanRef r123 = new Ref.BooleanRef();
        r123.element = !Intrinsics.areEqual(r122, SelectionAdjustment.Companion.getNone());
        long r109 = r120.m6124getIdJ3iCeTQ();
        Function1 r124 = new c0(r110, r122, r123);
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.L$2 = r123;
        r101.label = 2;
        r114 = DragGestureDetectorKt.m429dragjO51t88(r100, r109, r124, r101);
        if (r114 != r103) goto L43;
        return r103;
    L43:
        r115 = r100;
        r106 = r123;
        goto L45
    L36:
        r122 = SelectionAdjustment.Companion.getWord();
        goto L39
    L37:
        r122 = SelectionAdjustment.Companion.getNone();
        goto L39
    L19:
        if (r110.mo1372onExtendk4lQ0M(r120.m6126getPositionF1C5BW0()) == false) goto L56;
        long r125 = r120.m6124getIdJ3iCeTQ();
        Function1 r126 = new b0(r110);
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.label = 1;
        r114 = DragGestureDetectorKt.m429dragjO51t88(r100, r125, r126, r101);
        if (r114 != r103) goto L24;
        return r103;
    L7:
        r101 = new C86591(r113);
        goto L8
    }

    private static final Object mouseSelectionBtf2(AwaitPointerEventScope r100, final MouseSelectionObserver r110, ClicksCounter r111, PointerEvent r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof C86601) == false) goto L7;
        C86601 r101 = (C86601) r113;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r114 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        int r105 = 0;
        boolean r106 = true;
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L18;
        Ref.BooleanRef r107 = (Ref.BooleanRef) r101.L$2;
        r110 = (MouseSelectionObserver) r101.L$1;
        AwaitPointerEventScope r115 = (AwaitPointerEventScope) r101.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L15
    L59:
        if (((Boolean) r114).booleanValue() == true) goto L61;
    L68:
        r110.onDragDone();
    L72:
        return Unit.INSTANCE;
    L61:
        if (r107.element == false) goto L68;
        List<PointerInputChange> r108 = r115.getCurrentEvent().getChanges();     // Catch: Throwable -> L15
        int r116 = r108.size();     // Catch: Throwable -> L15
    L63:
        if (r105 >= r116) goto L68;
        PointerInputChange r117 = r108.get(r105);     // Catch: Throwable -> L15
        if (PointerEventKt.changedToUp(r117) == false) goto L67;
        r117.consume();     // Catch: Throwable -> L15
    L67:
        r105 = r105 + 1;
        goto L63
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r110 = (MouseSelectionObserver) r101.L$1;
        r100 = (AwaitPointerEventScope) r101.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L22
    L32:
        if (((Boolean) r114).booleanValue() == false) goto L39;
        List<PointerInputChange> r109 = r100.getCurrentEvent().getChanges();     // Catch: Throwable -> L22
        int r118 = r109.size();     // Catch: Throwable -> L22
    L34:
        if (r105 >= r118) goto L39;
        PointerInputChange r119 = r109.get(r105);     // Catch: Throwable -> L22
        if (PointerEventKt.changedToUp(r119) == false) goto L38;
        r119.consume();     // Catch: Throwable -> L22
    L38:
        r105 = r105 + 1;
    L39:
        r110.onDragDone();
        goto L72
    L24:
        ResultKt.throwOnFailure(r114);
        PointerInputChange r120 = (PointerInputChange) ListProtector.get(r112.getChanges(), 0);
        if (TextFieldSelectionManager_androidKt.isShiftPressed(r112) == true) goto L27;
        int r121 = r111.getClicks();
        if (r121 == 1) goto L47;
        if (r121 == 2) goto L46;
        final SelectionAdjustment r122 = SelectionAdjustment.Companion.getParagraph();
    L49:
        if (r110.mo1374onStart9KIMszo(r120.m6126getPositionF1C5BW0(), r122, r111.getClicks()) == false) goto L72;
        r120.consume();     // Catch: Throwable -> L15
        final Ref.BooleanRef r123 = new Ref.BooleanRef();     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r122, SelectionAdjustment.Companion.getNone()) == false) goto L54;
        r106 = false;
    L54:
        r123.element = r106;     // Catch: Throwable -> L15
        long r124 = r120.m6124getIdJ3iCeTQ();     // Catch: Throwable -> L15
        Function1 r125 = new f0(r110, r122, r123);     // Catch: Throwable -> L15
        r101.L$0 = r100;     // Catch: Throwable -> L15
        r101.L$1 = r110;     // Catch: Throwable -> L15
        r101.L$2 = r123;     // Catch: Throwable -> L15
        r101.label = 2;     // Catch: Throwable -> L15
        r114 = DragGestureDetectorKt.m429dragjO51t88(r100, r124, r125, r101);     // Catch: Throwable -> L15
        if (r114 != r103) goto L57;
        return r103;
    L57:
        r115 = r100;
        r107 = r123;
        goto L59
    L46:
        r122 = SelectionAdjustment.Companion.getWord();
        goto L49
    L47:
        r122 = SelectionAdjustment.Companion.getNone();
        goto L49
    L27:
        if (r110.mo1372onExtendk4lQ0M(r120.m6126getPositionF1C5BW0()) == false) goto L72;
        r120.consume();     // Catch: Throwable -> L22
        long r126 = r120.m6124getIdJ3iCeTQ();     // Catch: Throwable -> L22
        Function1 r127 = new e0(r110);     // Catch: Throwable -> L22
        r101.L$0 = r100;     // Catch: Throwable -> L22
        r101.L$1 = r110;     // Catch: Throwable -> L22
        r101.label = 1;     // Catch: Throwable -> L22
        r114 = DragGestureDetectorKt.m429dragjO51t88(r100, r126, r127, r101);     // Catch: Throwable -> L22
        if (r114 != r103) goto L32;
        return r103;
    L22:
        th = move-exception;
        r110.onDragDone();
        throw th;
    L15:
        th = move-exception;
        r110.onDragDone();
        throw th;
    L7:
        r101 = new C86601(r113);
        goto L8
    }
}
