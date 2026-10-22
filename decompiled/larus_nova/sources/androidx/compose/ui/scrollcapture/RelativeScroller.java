package androidx.compose.ui.scrollcapture;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/scrollcapture/RelativeScroller;", "", "viewportSize", "", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "<init>", "(ILkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "value", "scrollAmount", "getScrollAmount", "()F", BasicTestActionHandler.TEST_ACTION_RESET, "", "scrollRangeIntoView", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapOffsetToViewport", "offset", "scrollTo", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delta", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RelativeScroller {
    private float scrollAmount;
    private final Function2<Float, Continuation<? super Float>, Object> scrollBy;
    private final int viewportSize;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.scrollcapture.RelativeScroller", f = "ComposeScrollCaptureCallback.android.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL}, m = "scrollBy", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RelativeScroller this$0;

        public AnonymousClass1(RelativeScroller r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return RelativeScroller.access$scrollBy(this.this$0, 0.0f, this);
        }
    }

    public final void reset() {
        this.scrollAmount = 0.0f;
    }

    public final float getScrollAmount() {
        return this.scrollAmount;
    }

    public final int mapOffsetToViewport(int r100) {
        return RangesKt.coerceIn(r100 - MathKt.roundToInt(this.scrollAmount), 0, this.viewportSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RelativeScroller(int r100, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> r101) {
        this.viewportSize = r100;
        this.scrollBy = r101;
    }

    private final Object scrollBy(float r100, Continuation<? super Unit> r101) {
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
        ResultKt.throwOnFailure(r104);
    L17:
        this.scrollAmount += ((Number) r104).floatValue();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Function2<Float, Continuation<? super Float>, Object> r107 = this.scrollBy;
        Float r108 = Boxing.boxFloat(r100);
        r102.label = 1;
        r104 = r107.invoke(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }

    public final Object scrollTo(float r100, Continuation<? super Unit> r101) {
        Object r102 = scrollBy(r100 - this.scrollAmount, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$scrollBy(RelativeScroller r100, float r101, Continuation r102) {
        return r100.scrollBy(r101, r102);
    }

    public final Object scrollRangeIntoView(int r100, int r101, Continuation<? super Unit> r102) {
        boolean r103 = true;
        if (r100 > r101) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L30;
        int r105 = r101 - r100;
        int r106 = this.viewportSize;
        if (r105 <= r106) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L28;
        float r107 = r100;
        float r108 = this.scrollAmount;
        if (r107 < r108) goto L19;
        if (r101 > (r106 + r108)) goto L19;
        return Unit.INSTANCE;
    L19:
        if (r107 < r108) goto L22;
        r100 = r101 - r106;
    L22:
        Object r109 = scrollTo(r100, r102);
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        return r109;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalArgumentException(("Expected range (" + r105 + ") to be ≤ viewportSize=" + this.viewportSize).toString());
    L30:
        throw new IllegalArgumentException(("Expected min=" + r100 + " ≤ max=" + r101).toString());
    L5:
        r104 = false;
        goto L6
    }
}
