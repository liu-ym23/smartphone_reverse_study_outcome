package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.sva.sdk.data.ISmModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0000\u001a(\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u001a(\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aA\u0010\u0016\u001a\u00020\u0015*\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aI\u0010\u001c\u001a\u00020\u0015*\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aU\u0010 \u001a\u00020\u0015*\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\"\"\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u0014H\u0000¢\u0006\u0004\b#\u0010$\u001aO\u0010 \u001a\u00020\u0015*\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\b\b\u0002\u0010\u0019\u001a\u00020\u0014H\u0000¢\u0006\u0004\b#\u0010%*<\b\u0000\u0010\u0010\"\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00112\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011¨\u0006&"}, d2 = {ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "Landroidx/compose/ui/input/pointer/PointerInputChange;", "id", "", "durationMillis", "x", "", "y", "historicalData", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "moveTo", "moveBy", "dx", "dy", "up", "PointerInputHandler", "Lkotlin/Function3;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "Landroidx/compose/ui/unit/IntSize;", "", "invokeOverAllPasses", "Landroidx/compose/ui/input/pointer/PointerInputHandler;", "pointerEvent", "size", "invokeOverAllPasses-H0pRuoY", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "invokeOverPass", "pointerEventPass", "invokeOverPass-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "invokeOverPasses", "pointerEventPasses", "", "invokeOverPasses-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;[Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Ljava/util/List;J)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PointerInputTestUtilKt {
    public static final PointerInputChange up(PointerInputChange r210, long r211) {
        long r100 = r210.m6124getIdJ3iCeTQ();
        long r101 = r210.getUptimeMillis();
        boolean r110 = r210.getPressed();
        long r111 = r210.m6126getPositionF1C5BW0();
        return new PointerInputChange(r100, r211, r210.m6126getPositionF1C5BW0(), false, 1.0f, r101, r111, r110, false, 0, 0, ISmModel.VERSION_0600, null);
    }

    /* JADX INFO: renamed from: invokeOverAllPasses-H0pRuoY, reason: not valid java name */
    public static final void m6177invokeOverAllPassesH0pRuoY(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> r100, PointerEvent r101, long r102) {
        m6181invokeOverPasseshUlJWOE(r100, r101, CollectionsKt.listOf(new PointerEventPass[]{PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final}), r102);
    }

    /* JADX INFO: renamed from: invokeOverPass-hUlJWOE, reason: not valid java name */
    public static final void m6179invokeOverPasshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> r100, PointerEvent r101, PointerEventPass r102, long r103) {
        m6181invokeOverPasseshUlJWOE(r100, r101, CollectionsKt.listOf(r102), r103);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m6181invokeOverPasseshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> r100, PointerEvent r101, List<? extends PointerEventPass> r102, long r103) {
        if ((!r101.getChanges().isEmpty()) == false) goto L13;
        List<? extends PointerEventPass> r104 = r102;
        if ((!r104.isEmpty()) == false) goto L11;
        int r105 = r104.size();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r100.invoke(r101, (PointerEventPass) ListProtector.get(r102, r106), IntSize.m7711boximpl(r103));
        r106 = r106 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new IllegalArgumentException("invokeOverPasses called with no passes".toString());
    L13:
        throw new IllegalArgumentException("invokeOverPasses called with no changes".toString());
    }

    public static final PointerInputChange moveBy(PointerInputChange r210, long r211, float r212, float r213) {
        long r100 = r210.m6124getIdJ3iCeTQ();
        long r101 = r210.getUptimeMillis();
        boolean r110 = r210.getPressed();
        long r111 = r210.m6126getPositionF1C5BW0();
        long r102 = r210.getUptimeMillis() + r211;
        float r103 = Float.intBitsToFloat((int) (r210.m6126getPositionF1C5BW0() >> 32)) + r212;
        float r104 = Float.intBitsToFloat((int) (r210.m6126getPositionF1C5BW0() & BodyPartID.bodyIdMax)) + r213;
        long r105 = Float.floatToRawIntBits(r103);
        return new PointerInputChange(r100, r102, Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r104)) & BodyPartID.bodyIdMax) | (r105 << 32)), true, 1.0f, r101, r111, r110, false, 0, 0, ISmModel.VERSION_0600, null);
    }

    public static final PointerInputChange moveTo(PointerInputChange r210, long r211, float r212, float r213) {
        long r100 = r210.m6124getIdJ3iCeTQ();
        long r101 = r210.getUptimeMillis();
        boolean r110 = r210.getPressed();
        return new PointerInputChange(r100, r211, Offset.m4574constructorimpl((Float.floatToRawIntBits(r212) << 32) | (((long) Float.floatToRawIntBits(r213)) & BodyPartID.bodyIdMax)), true, 1.0f, r101, r210.m6126getPositionF1C5BW0(), r110, false, 0, 0, ISmModel.VERSION_0600, null);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m6182invokeOverPasseshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> r100, PointerEvent r101, PointerEventPass[] r102, long r103) {
        m6181invokeOverPasseshUlJWOE(r100, r101, ArraysKt.toList(r102), r103);
    }

    public static final PointerInputChange down(long r210, long r211, float r212, float r310, List<HistoricalChange> r311) {
        long r100 = PointerId.m6106constructorimpl(r210);
        long r101 = Offset.m4574constructorimpl((Float.floatToRawIntBits(r212) << 32) | (((long) Float.floatToRawIntBits(r310)) & BodyPartID.bodyIdMax));
        long r110 = Float.floatToRawIntBits(r212);
        PointerInputChange r213 = new PointerInputChange(r100, r211, r101, true, 1.0f, r211, Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r310)) & BodyPartID.bodyIdMax) | (r110 << 32)), false, false, 0, 0, ISmModel.VERSION_0600, null);
        List<HistoricalChange> r102 = r311;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return r213;
    L11:
        return PointerInputChange.m6115copyOHpmEuE$default(r213, 0, 0, 0, false, 0, 0, false, 0, r311, 0, 767, null);
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    /* JADX INFO: renamed from: invokeOverAllPasses-H0pRuoY$default, reason: not valid java name */
    public static /* synthetic */ void m6178invokeOverAllPassesH0pRuoY$default(Function3 r100, PointerEvent r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        long r105 = Integer.MAX_VALUE;
        r102 = IntSize.m7714constructorimpl((r105 & BodyPartID.bodyIdMax) | (r105 << 32));
    L5:
        m6177invokeOverAllPassesH0pRuoY(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invokeOverPass-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m6180invokeOverPasshUlJWOE$default(Function3 r100, PointerEvent r101, PointerEventPass r102, long r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        long r106 = Integer.MAX_VALUE;
        r103 = IntSize.m7714constructorimpl((r106 & BodyPartID.bodyIdMax) | (r106 << 32));
    L5:
        m6179invokeOverPasshUlJWOE(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m6183invokeOverPasseshUlJWOE$default(Function3 r100, PointerEvent r101, List r102, long r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        long r106 = Integer.MAX_VALUE;
        r103 = IntSize.m7714constructorimpl((r106 & BodyPartID.bodyIdMax) | (r106 << 32));
    L5:
        m6181invokeOverPasseshUlJWOE(r100, r101, r102, r103);
    }

    public static /* synthetic */ PointerInputChange moveBy$default(PointerInputChange r100, long r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0.0f;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 0.0f;
    L9:
        return moveBy(r100, r101, r102, r103);
    }

    public static /* synthetic */ PointerInputChange moveTo$default(PointerInputChange r100, long r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0.0f;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 0.0f;
    L9:
        return moveTo(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m6184invokeOverPasseshUlJWOE$default(Function3 r100, PointerEvent r101, PointerEventPass[] r102, long r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        long r106 = Integer.MAX_VALUE;
        r103 = IntSize.m7714constructorimpl((r106 & BodyPartID.bodyIdMax) | (r106 << 32));
    L5:
        m6182invokeOverPasseshUlJWOE(r100, r101, r102, r103);
    }

    public static /* synthetic */ PointerInputChange down$default(long r100, long r101, float r110, float r111, List r112, int r113, Object r114) {
        if ((r113 & 2) == 0) goto L5;
        r101 = 0;
    L5:
        long r102 = r101;
        if ((r113 & 4) == 0) goto L8;
        float r103 = 0.0f;
    L10:
        if ((r113 & 8) == 0) goto L12;
        float r104 = 0.0f;
    L14:
        if ((r113 & 16) == 0) goto L17;
        r112 = null;
    L17:
        return down(r100, r102, r103, r104, r112);
    L12:
        r104 = r111;
        goto L14
    L8:
        r103 = r110;
        goto L10
    }
}
