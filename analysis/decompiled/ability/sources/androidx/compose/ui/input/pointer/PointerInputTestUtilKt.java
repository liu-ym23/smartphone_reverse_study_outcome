package androidx.compose.ui.input.pointer;

import D7.q;
import S7.o;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000F\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\u001aG\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\f\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\f\u0010\r\u001a/\u0010\u0010\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0010\u0010\r\u001a\u001b\u0010\u0011\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aA\u0010\u001d\u001a\u00020\u0017*\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0013j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001aI\u0010!\u001a\u00020\u0017*\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0013j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001f\u0010 \u001aU\u0010&\u001a\u00020\u0017*\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0013j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\"\"\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u0016H\u0000¢\u0006\u0004\b$\u0010%\u001aO\u0010&\u001a\u00020\u0017*\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0013j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u0016H\u0000¢\u0006\u0004\b$\u0010'*<\b\u0000\u0010(\"\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00132\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0013¨\u0006)"}, d2 = {"", "id", "durationMillis", "", "x", "y", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "historicalData", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "down", "(JJFFLjava/util/List;)Landroidx/compose/ui/input/pointer/PointerInputChange;", "moveTo", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JFF)Landroidx/compose/ui/input/pointer/PointerInputChange;", "dx", "dy", "moveBy", "up", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "Lkotlin/Function3;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "Landroidx/compose/ui/unit/IntSize;", "LC7/r;", "Landroidx/compose/ui/input/pointer/PointerInputHandler;", "pointerEvent", "size", "invokeOverAllPasses-H0pRuoY", "(LS7/o;Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "invokeOverAllPasses", "pointerEventPass", "invokeOverPass-hUlJWOE", "(LS7/o;Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "invokeOverPass", "", "pointerEventPasses", "invokeOverPasses-hUlJWOE", "(LS7/o;Landroidx/compose/ui/input/pointer/PointerEvent;[Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "invokeOverPasses", "(LS7/o;Landroidx/compose/ui/input/pointer/PointerEvent;Ljava/util/List;J)V", "PointerInputHandler", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputTestUtilKt {
    public static final PointerInputChange down(long j5, long j6, float f, float f7, List<HistoricalChange> list) {
        PointerInputChange pointerInputChange = new PointerInputChange(PointerId.m5401constructorimpl(j5), j6, Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L)), true, 1.0f, j6, Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L)), false, false, 0, 0L, 1536, (e) null);
        List<HistoricalChange> list2 = list;
        return (list2 == null || list2.isEmpty()) ? pointerInputChange : PointerInputChange.m5410copyOHpmEuE$default(pointerInputChange, 0L, 0L, 0L, false, 0L, 0L, false, 0, list, 0L, 767, null);
    }

    public static /* synthetic */ PointerInputChange down$default(long j5, long j6, float f, float f7, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            j6 = 0;
        }
        long j10 = j6;
        float f9 = (i & 4) != 0 ? 0.0f : f;
        float f10 = (i & 8) != 0 ? 0.0f : f7;
        if ((i & 16) != 0) {
            list = null;
        }
        return down(j5, j10, f9, f10, list);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY, reason: not valid java name */
    public static final void m5471invokeOverAllPassesH0pRuoY(o oVar, PointerEvent pointerEvent, long j5) {
        m5475invokeOverPasseshUlJWOE(oVar, pointerEvent, (List<? extends PointerEventPass>) H4.o.N(PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final), j5);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY$default, reason: not valid java name */
    public static /* synthetic */ void m5472invokeOverAllPassesH0pRuoY$default(o oVar, PointerEvent pointerEvent, long j5, int i, Object obj) {
        if ((i & 2) != 0) {
            long j6 = Integer.MAX_VALUE;
            j5 = IntSize.m7010constructorimpl((j6 & 4294967295L) | (j6 << 32));
        }
        m5471invokeOverAllPassesH0pRuoY(oVar, pointerEvent, j5);
    }

    /* renamed from: invokeOverPass-hUlJWOE, reason: not valid java name */
    public static final void m5473invokeOverPasshUlJWOE(o oVar, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j5) {
        m5475invokeOverPasseshUlJWOE(oVar, pointerEvent, (List<? extends PointerEventPass>) H4.o.M(pointerEventPass), j5);
    }

    /* renamed from: invokeOverPass-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m5474invokeOverPasshUlJWOE$default(o oVar, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j5, int i, Object obj) {
        if ((i & 4) != 0) {
            long j6 = Integer.MAX_VALUE;
            j5 = IntSize.m7010constructorimpl((j6 & 4294967295L) | (j6 << 32));
        }
        m5473invokeOverPasshUlJWOE(oVar, pointerEvent, pointerEventPass, j5);
    }

    /* renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m5476invokeOverPasseshUlJWOE(o oVar, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j5) {
        m5475invokeOverPasseshUlJWOE(oVar, pointerEvent, (List<? extends PointerEventPass>) q.I0(pointerEventPassArr), j5);
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m5478invokeOverPasseshUlJWOE$default(o oVar, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j5, int i, Object obj) {
        if ((i & 4) != 0) {
            long j6 = Integer.MAX_VALUE;
            j5 = IntSize.m7010constructorimpl((j6 & 4294967295L) | (j6 << 32));
        }
        m5476invokeOverPasseshUlJWOE(oVar, pointerEvent, pointerEventPassArr, j5);
    }

    public static final PointerInputChange moveBy(PointerInputChange pointerInputChange, long j5, float f, float f7) {
        long id = pointerInputChange.getId();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        long position = pointerInputChange.getPosition();
        long uptimeMillis2 = pointerInputChange.getUptimeMillis() + j5;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32)) + f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (pointerInputChange.getPosition() & 4294967295L)) + f7;
        return new PointerInputChange(id, uptimeMillis2, Offset.m3887constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), true, 1.0f, uptimeMillis, position, pressed, false, 0, 0L, 1536, (e) null);
    }

    public static /* synthetic */ PointerInputChange moveBy$default(PointerInputChange pointerInputChange, long j5, float f, float f7, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f7 = 0.0f;
        }
        return moveBy(pointerInputChange, j5, f, f7);
    }

    public static final PointerInputChange moveTo(PointerInputChange pointerInputChange, long j5, float f, float f7) {
        return new PointerInputChange(pointerInputChange.getId(), j5, Offset.m3887constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L)), true, 1.0f, pointerInputChange.getUptimeMillis(), pointerInputChange.getPosition(), pointerInputChange.getPressed(), false, 0, 0L, 1536, (e) null);
    }

    public static /* synthetic */ PointerInputChange moveTo$default(PointerInputChange pointerInputChange, long j5, float f, float f7, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f7 = 0.0f;
        }
        return moveTo(pointerInputChange, j5, f, f7);
    }

    public static final PointerInputChange up(PointerInputChange pointerInputChange, long j5) {
        long id = pointerInputChange.getId();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(id, j5, pointerInputChange.getPosition(), false, 1.0f, uptimeMillis, pointerInputChange.getPosition(), pressed, false, 0, 0L, 1536, (e) null);
    }

    /* renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m5475invokeOverPasseshUlJWOE(o oVar, PointerEvent pointerEvent, List<? extends PointerEventPass> list, long j5) {
        if (pointerEvent.getChanges().isEmpty()) {
            throw new IllegalArgumentException("invokeOverPasses called with no changes");
        }
        List<? extends PointerEventPass> list2 = list;
        if (list2.isEmpty()) {
            throw new IllegalArgumentException("invokeOverPasses called with no passes");
        }
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            oVar.invoke(pointerEvent, list.get(i), IntSize.m7007boximpl(j5));
        }
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m5477invokeOverPasseshUlJWOE$default(o oVar, PointerEvent pointerEvent, List list, long j5, int i, Object obj) {
        if ((i & 4) != 0) {
            long j6 = Integer.MAX_VALUE;
            j5 = IntSize.m7010constructorimpl((j6 & 4294967295L) | (j6 << 32));
        }
        m5475invokeOverPasseshUlJWOE(oVar, pointerEvent, (List<? extends PointerEventPass>) list, j5);
    }
}
