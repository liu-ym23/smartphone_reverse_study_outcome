package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a^\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000626\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bH\u0080@¢\u0006\u0004\b\u000f\u0010\u0010\u001aT\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u0013H\u0082H¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010!\u001a\u00020\f*\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b#\u0010$\"\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0010\u0010\u001f\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u000e\u0010 \u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", FaceService.girlLabel, "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop = 0.0f;
    private static final float mouseSlop = 0.0f;
    private static final float mouseToTouchSlopRatio = 0.0f;

    static {
        float r100 = Dp.m7544constructorimpl((float) 0.125d);
        mouseSlop = r100;
        float r101 = Dp.m7544constructorimpl(18);
        defaultTouchSlop = r101;
        mouseToTouchSlopRatio = r100 / r101;
    }

    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m3136isPointerUpDmW0f2w(PointerEvent r100, long r101) {
        List<PointerInputChange> r102 = r100.getChanges();
        int r103 = r102.size();
        boolean r104 = false;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L8;
        Object r106 = ListProtector.get(r102, r105);
        if (PointerId.m6108equalsimpl0(((PointerInputChange) r106).m6124getIdJ3iCeTQ(), r101) == true) goto L9;
        r105 = r105 + 1;
    L9:
        PointerInputChange r107 = (PointerInputChange) r106;
        if (r107 == null) goto L15;
        if (r107.getPressed() != true) goto L15;
        r104 = true;
    L15:
        return true ^ r104;
    L8:
        r106 = null;
        goto L9
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m3137pointerSlopE8SPZFQ(ViewConfiguration r100, int r101) {
        if (PointerType.m6198equalsimpl0(r101, PointerType.Companion.m6203getMouseT8wyACA()) == false) goto L6;
        return r100.getTouchSlop() * mouseToTouchSlopRatio;
    L6:
        return r100.getTouchSlop();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0121 -> B:57:0x0175). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0168 -> B:53:0x016b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0190 -> B:57:0x0175). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final Object m3134awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope r110, long r210, int r211, Function2<? super PointerInputChange, ? super Float, Unit> r212, Continuation<? super PointerInputChange> r213) {
        if ((r213 instanceof DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) == false) goto L7;
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r100 = (DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        PointerEventPass r106 = null;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        float r107 = r100.F$1;
        float r108 = r100.F$0;
        PointerInputChange r109 = (PointerInputChange) r100.L$3;
        Ref.LongRef r111 = (Ref.LongRef) r100.L$2;
        AwaitPointerEventScope r112 = (AwaitPointerEventScope) r100.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r113 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r102);
        float r114 = r107;
        AwaitPointerEventScope r115 = r112;
        Ref.LongRef r116 = r111;
        Object r117 = r103;
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r118 = r100;
        float r119 = r108;
        Function2<? super PointerInputChange, ? super Float, Unit> r120 = r113;
    L54:
        if (r109.isConsumed() == false) goto L56;
    L55:
        return null;
    L56:
        Object r121 = r117;
        Ref.LongRef r122 = r116;
    L57:
        r105 = 1;
        r106 = null;
    L20:
        r118.L$0 = r120;
        r118.L$1 = r115;
        r118.L$2 = r122;
        r118.L$3 = r106;
        r118.F$0 = r119;
        r118.F$1 = r114;
        r118.label = r105;
        Object r123 = AwaitPointerEventScope.CC.awaitPointerEvent$default(r115, r106, r118, r105, r106);
        if (r123 != r121) goto L23;
        return r121;
    L23:
        float r124 = r119;
        float r125 = r114;
        r102 = r123;
        r116 = r122;
        r117 = r121;
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r126 = r118;
        float r127 = r124;
    L24:
        PointerEvent r128 = (PointerEvent) r102;
        List<PointerInputChange> r129 = r128.getChanges();
        int r130 = r129.size();
        int r131 = 0;
        int r132 = 0;
    L25:
        if (r132 >= r130) goto L30;
        Object r133 = ListProtector.get(r129, r132);
        if (PointerId.m6108equalsimpl0(((PointerInputChange) r133).m6124getIdJ3iCeTQ(), r116.element) == true) goto L31;
        r132 = r132 + 1;
    L31:
        Intrinsics.checkNotNull(r133);
        PointerInputChange r134 = (PointerInputChange) r133;
        if (r134.isConsumed() == true) goto L55;
        if (PointerEventKt.changedToUpIgnoreConsumed(r134) == false) goto L47;
        List<PointerInputChange> r135 = r128.getChanges();
        int r136 = r135.size();
    L37:
        if (r131 >= r136) goto L42;
        Object r137 = ListProtector.get(r135, r131);
        if (((PointerInputChange) r137).getPressed() == true) goto L43;
        r131 = r131 + 1;
    L43:
        PointerInputChange r138 = (PointerInputChange) r137;
        if (r138 == null) goto L55;
        r116.element = r138.m6124getIdJ3iCeTQ();
        r114 = r125;
        r119 = r127;
        r118 = r126;
        r121 = r117;
        r122 = r116;
        goto L57
    L42:
        r137 = null;
        goto L43
    L47:
        long r139 = r134.m6126getPositionF1C5BW0();
        long r140 = r134.m6127getPreviousPositionF1C5BW0();
        r114 = r125 + (Float.intBitsToFloat((int) (r139 >> 32)) - Float.intBitsToFloat((int) (r140 >> 32)));
        if (Math.abs(r114) >= r127) goto L58;
        PointerEventPass r141 = PointerEventPass.Final;
        r126.L$0 = r120;
        r126.L$1 = r115;
        r126.L$2 = r116;
        r126.L$3 = r134;
        r126.F$0 = r127;
        r126.F$1 = r114;
        r126.label = 2;
        if (r115.awaitPointerEvent(r141, r126) != r117) goto L52;
        return r117;
    L52:
        r119 = r127;
        r118 = r126;
        r109 = r134;
        goto L54
    L58:
        r120.invoke(r134, Boxing.boxFloat(r114 - (Math.signum(r114) * r127)));
        if (r134.isConsumed() == true) goto L61;
        r119 = r127;
        r118 = r126;
        r121 = r117;
        r122 = r116;
        r114 = 0.0f;
        goto L57
    L61:
        return r134;
    L30:
        r133 = null;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r142 = r100.F$1;
        float r143 = r100.F$0;
        Ref.LongRef r144 = (Ref.LongRef) r100.L$2;
        AwaitPointerEventScope r145 = (AwaitPointerEventScope) r100.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> r146 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r102);
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r147 = r100;
        r125 = r142;
        r115 = r145;
        r117 = r103;
        r127 = r143;
        r120 = r146;
        r116 = r144;
        r126 = r147;
        goto L24
    L16:
        ResultKt.throwOnFailure(r102);
        if (m3136isPointerUpDmW0f2w(r110.getCurrentEvent(), r210) == true) goto L68;
        float r148 = m3137pointerSlopE8SPZFQ(r110.getViewConfiguration(), r211);
        Ref.LongRef r149 = new Ref.LongRef();
        r149.element = r210;
        r115 = r110;
        r120 = r212;
        r122 = r149;
        r121 = r103;
        r118 = r100;
        r119 = r148;
        r114 = 0.0f;
        goto L20
    L68:
        return null;
    L7:
        r100 = new DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1(r213);
        goto L8
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m3135awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope r110, long r111, int r112, Function2<? super PointerInputChange, ? super Float, Unit> r210, Function1<? super Offset, Float> r211, Continuation<? super PointerInputChange> r212) {
        if (m3136isPointerUpDmW0f2w(r110.getCurrentEvent(), r111) == false) goto L5;
        return null;
    L5:
        float r100 = m3137pointerSlopE8SPZFQ(r110.getViewConfiguration(), r112);
        Ref.LongRef r101 = new Ref.LongRef();
        r101.element = r111;
        float r102 = 0.0f;
    L6:
        InlineMarker.mark(0);
        Object r113 = AwaitPointerEventScope.CC.awaitPointerEvent$default(r110, null, r212, 1, null);
        InlineMarker.mark(1);
        PointerEvent r114 = (PointerEvent) r113;
        List<PointerInputChange> r115 = r114.getChanges();
        int r116 = r115.size();
        int r117 = 0;
    L7:
        if (r117 >= r116) goto L12;
        Object r118 = ListProtector.get(r115, r117);
        float r119 = r102;
        if (Boolean.valueOf(PointerId.m6108equalsimpl0(((PointerInputChange) r118).m6124getIdJ3iCeTQ(), r101.element)).booleanValue() == true) goto L13;
        r117 = r117 + 1;
        r102 = r119;
    L13:
        Intrinsics.checkNotNull(r118);
        PointerInputChange r120 = (PointerInputChange) r118;
        if (r120.isConsumed() == true) goto L15;
        if (PointerEventKt.changedToUpIgnoreConsumed(r120) == false) goto L29;
        List<PointerInputChange> r103 = r114.getChanges();
        int r104 = r103.size();
        int r105 = 0;
    L19:
        if (r105 >= r104) goto L24;
        Object r106 = ListProtector.get(r103, r105);
        if (Boolean.valueOf(((PointerInputChange) r106).getPressed()).booleanValue() == true) goto L25;
        r105 = r105 + 1;
    L25:
        PointerInputChange r107 = (PointerInputChange) r106;
        if (r107 == null) goto L27;
        r101.element = r107.m6124getIdJ3iCeTQ();
    L40:
        r102 = r119;
        goto L6
    L27:
        return null;
    L24:
        r106 = null;
        goto L25
    L29:
        float r108 = r119 + (r211.invoke(Offset.m4571boximpl(r120.m6126getPositionF1C5BW0())).floatValue() - r211.invoke(Offset.m4571boximpl(r120.m6127getPreviousPositionF1C5BW0())).floatValue());
        if (Math.abs(r108) >= r100) goto L36;
        PointerEventPass r109 = PointerEventPass.Final;
        InlineMarker.mark(0);
        r110.awaitPointerEvent(r109, r212);
        InlineMarker.mark(1);
        if (r120.isConsumed() == true) goto L33;
        r119 = r108;
        goto L40
    L33:
        return null;
    L36:
        r210.invoke(r120, Float.valueOf(r108 - (Math.signum(r108) * r100)));
        if (r120.isConsumed() == true) goto L38;
        r119 = 0.0f;
        goto L40
    L38:
        return r120;
    L15:
        return null;
    L12:
        r119 = r102;
        r118 = null;
        goto L13
    }
}
