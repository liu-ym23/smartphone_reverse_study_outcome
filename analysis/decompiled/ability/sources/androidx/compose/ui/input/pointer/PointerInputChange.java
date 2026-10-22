package androidx.compose.ui.input.pointer;

import C7.c;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b0\b\u0007\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014B]\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0015BS\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0018Bw\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 Ji\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b%\u0010&Jg\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)Jq\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b*\u0010+Jq\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-Jw\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b.\u0010/J\u0081\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00107R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00105\u001a\u0004\b8\u00107R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00105\u001a\u0004\b9\u00107R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u00105\u001a\u0004\b@\u00107R\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u00105\u001a\u0004\bA\u00107R\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010:\u001a\u0004\bB\u0010<R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\u0012\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u00105\u001a\u0004\bF\u00107R\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010\u001c\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u00105\u001a\u0004\bI\u00107\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bL\u0010:\u001a\u0004\bM\u0010<\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010:\u001a\u0004\bQ\u0010<\"\u0004\bR\u0010OR$\u0010S\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010Y\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bY\u0010Z\u0012\u0004\b[\u0010 R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198F¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0011\u0010^\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b^\u0010<R\u001a\u0010\u0017\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010 \u001a\u0004\b_\u0010`¨\u0006b"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "Landroidx/compose/ui/input/pointer/PointerId;", "id", "", "uptimeMillis", "Landroidx/compose/ui/geometry/Offset;", "position", "", "pressed", "", "pressure", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "Landroidx/compose/ui/input/pointer/PointerType;", "type", "scrollDelta", AppAgent.CONSTRUCT, "(JJJZFJJZZIJLkotlin/jvm/internal/e;)V", "(JJJZJJZZIJLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/input/pointer/ConsumedData;", "consumed", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/e;)V", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "historical", "originalEventPosition", "(JJJZFJJZZILjava/util/List;JJLkotlin/jvm/internal/e;)V", "LC7/r;", "consume", "()V", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Tn9QgHE", "(JJJZFJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "toString", "()Ljava/lang/String;", "J", "getId-J3iCeTQ", "()J", "getUptimeMillis", "getPosition-F1C5BW0", "Z", "getPressed", "()Z", "F", "getPressure", "()F", "getPreviousUptimeMillis", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "I", "getType-T8wyACA", "()I", "getScrollDelta-F1C5BW0", "_historical", "Ljava/util/List;", "getOriginalEventPosition-F1C5BW0$ui_release", "setOriginalEventPosition-k-4lQ0M$ui_release", "(J)V", "downChange", "getDownChange$ui_release", "setDownChange$ui_release", "(Z)V", "positionChange", "getPositionChange$ui_release", "setPositionChange$ui_release", "consumedDelegate", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "getConsumedDelegate$ui_release", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setConsumedDelegate$ui_release", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "_consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "get_consumed$annotations", "getHistorical", "()Ljava/util/List;", "isConsumed", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getConsumed$annotations", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputChange {
    public static final int $stable = 0;
    private ConsumedData _consumed;
    private List<HistoricalChange> _historical;
    private PointerInputChange consumedDelegate;
    private boolean downChange;
    private final long id;
    private long originalEventPosition;
    private final long position;
    private boolean positionChange;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j5, long j6, long j10, boolean z10, float f, long j11, long j12, boolean z11, boolean z12, int i, long j13, e eVar) {
        this(j5, j6, j10, z10, f, j11, j12, z11, z12, i, j13);
    }

    /* renamed from: copy-0GkPj7c$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5407copy0GkPj7c$default(PointerInputChange pointerInputChange, long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, ConsumedData consumedData, int i, long j13, int i6, Object obj) {
        long j14;
        long j15 = (i6 & 1) != 0 ? pointerInputChange.id : j5;
        long j16 = (i6 & 2) != 0 ? pointerInputChange.uptimeMillis : j6;
        long j17 = (i6 & 4) != 0 ? pointerInputChange.position : j10;
        boolean z12 = (i6 & 8) != 0 ? pointerInputChange.pressed : z10;
        long j18 = (i6 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j11;
        long j19 = (i6 & 32) != 0 ? pointerInputChange.previousPosition : j12;
        boolean z13 = (i6 & 64) != 0 ? pointerInputChange.previousPressed : z11;
        int i10 = (i6 & 256) != 0 ? pointerInputChange.type : i;
        if ((i6 & 512) != 0) {
            j14 = pointerInputChange.scrollDelta;
            j15 = j15;
        } else {
            j14 = j13;
        }
        return pointerInputChange.m5413copy0GkPj7c(j15, j16, j17, z12, j18, j19, z13, consumedData, i10, j14);
    }

    /* renamed from: copy-JKmWfYY$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5409copyJKmWfYY$default(PointerInputChange pointerInputChange, long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, int i, long j13, int i6, Object obj) {
        long j14;
        long j15;
        long j16 = (i6 & 1) != 0 ? pointerInputChange.id : j5;
        long j17 = (i6 & 2) != 0 ? pointerInputChange.uptimeMillis : j6;
        long j18 = (i6 & 4) != 0 ? pointerInputChange.position : j10;
        boolean z12 = (i6 & 8) != 0 ? pointerInputChange.pressed : z10;
        long j19 = (i6 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j11;
        long j20 = (i6 & 32) != 0 ? pointerInputChange.previousPosition : j12;
        boolean z13 = (i6 & 64) != 0 ? pointerInputChange.previousPressed : z11;
        int i10 = (i6 & 128) != 0 ? pointerInputChange.type : i;
        if ((i6 & 256) != 0) {
            j14 = pointerInputChange.scrollDelta;
            j15 = j16;
        } else {
            j14 = j13;
            j15 = j16;
        }
        return pointerInputChange.m5415copyJKmWfYY(j15, j17, j18, z12, j19, j20, z13, i10, j14);
    }

    /* renamed from: copy-OHpmEuE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5410copyOHpmEuE$default(PointerInputChange pointerInputChange, long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, int i, List list, long j13, int i6, Object obj) {
        long j14;
        long j15 = (i6 & 1) != 0 ? pointerInputChange.id : j5;
        long j16 = (i6 & 2) != 0 ? pointerInputChange.uptimeMillis : j6;
        long j17 = (i6 & 4) != 0 ? pointerInputChange.position : j10;
        boolean z12 = (i6 & 8) != 0 ? pointerInputChange.pressed : z10;
        long j18 = (i6 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j11;
        long j19 = (i6 & 32) != 0 ? pointerInputChange.previousPosition : j12;
        boolean z13 = (i6 & 64) != 0 ? pointerInputChange.previousPressed : z11;
        int i10 = (i6 & 128) != 0 ? pointerInputChange.type : i;
        if ((i6 & 512) != 0) {
            j14 = pointerInputChange.scrollDelta;
            j15 = j15;
        } else {
            j14 = j13;
        }
        return pointerInputChange.m5416copyOHpmEuE(j15, j16, j17, z12, j18, j19, z13, i10, list, j14);
    }

    /* renamed from: copy-Tn9QgHE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5411copyTn9QgHE$default(PointerInputChange pointerInputChange, long j5, long j6, long j10, boolean z10, float f, long j11, long j12, boolean z11, int i, long j13, int i6, Object obj) {
        long j14;
        long j15;
        long j16 = (i6 & 1) != 0 ? pointerInputChange.id : j5;
        long j17 = (i6 & 2) != 0 ? pointerInputChange.uptimeMillis : j6;
        long j18 = (i6 & 4) != 0 ? pointerInputChange.position : j10;
        boolean z12 = (i6 & 8) != 0 ? pointerInputChange.pressed : z10;
        float f7 = (i6 & 16) != 0 ? pointerInputChange.pressure : f;
        long j19 = (i6 & 32) != 0 ? pointerInputChange.previousUptimeMillis : j11;
        long j20 = (i6 & 64) != 0 ? pointerInputChange.previousPosition : j12;
        boolean z13 = (i6 & 128) != 0 ? pointerInputChange.previousPressed : z11;
        int i10 = (i6 & 256) != 0 ? pointerInputChange.type : i;
        if ((i6 & 512) != 0) {
            j14 = pointerInputChange.scrollDelta;
            j15 = j16;
        } else {
            j14 = j13;
            j15 = j16;
        }
        return pointerInputChange.m5417copyTn9QgHE(j15, j17, j18, z12, f7, j19, j20, z13, i10, j14);
    }

    /* renamed from: copy-wbzehF4$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5412copywbzehF4$default(PointerInputChange pointerInputChange, long j5, long j6, long j10, boolean z10, float f, long j11, long j12, boolean z11, int i, List list, long j13, int i6, Object obj) {
        long j14;
        List list2;
        long j15 = (i6 & 1) != 0 ? pointerInputChange.id : j5;
        long j16 = (i6 & 2) != 0 ? pointerInputChange.uptimeMillis : j6;
        long j17 = (i6 & 4) != 0 ? pointerInputChange.position : j10;
        boolean z12 = (i6 & 8) != 0 ? pointerInputChange.pressed : z10;
        float f7 = (i6 & 16) != 0 ? pointerInputChange.pressure : f;
        long j18 = (i6 & 32) != 0 ? pointerInputChange.previousUptimeMillis : j11;
        long j19 = (i6 & 64) != 0 ? pointerInputChange.previousPosition : j12;
        boolean z13 = (i6 & 128) != 0 ? pointerInputChange.previousPressed : z11;
        int i10 = (i6 & 256) != 0 ? pointerInputChange.type : i;
        long j20 = j15;
        List historical = (i6 & 512) != 0 ? pointerInputChange.getHistorical() : list;
        if ((i6 & 1024) != 0) {
            list2 = historical;
            j14 = pointerInputChange.scrollDelta;
        } else {
            j14 = j13;
            list2 = historical;
        }
        return pointerInputChange.m5418copywbzehF4(j20, j16, j17, z12, f7, j18, j19, z13, i10, list2, j14);
    }

    @c
    public static /* synthetic */ void getConsumed$annotations() {
    }

    private static /* synthetic */ void get_consumed$annotations() {
    }

    public final void consume() {
        PointerInputChange pointerInputChange = this.consumedDelegate;
        if (pointerInputChange == null) {
            this.downChange = true;
            this.positionChange = true;
        } else if (pointerInputChange != null) {
            pointerInputChange.consume();
        }
    }

    @c
    /* renamed from: copy-0GkPj7c, reason: not valid java name */
    public final PointerInputChange m5413copy0GkPj7c(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, ConsumedData consumed, int type, long scrollDelta) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, consumed.getDownChange() || consumed.getPositionChange(), type, getHistorical(), scrollDelta, this.originalEventPosition, null);
        pointerInputChange.positionChange = this.positionChange;
        pointerInputChange.downChange = this.downChange;
        return pointerInputChange;
    }

    @c
    /* renamed from: copy-Ezr-O64, reason: not valid java name */
    public final /* synthetic */ PointerInputChange m5414copyEzrO64(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, ConsumedData consumed, int type) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, consumed.getDownChange() || consumed.getPositionChange(), type, getHistorical(), this.scrollDelta, this.originalEventPosition, null);
        pointerInputChange.positionChange = this.positionChange;
        pointerInputChange.downChange = this.downChange;
        return pointerInputChange;
    }

    /* renamed from: copy-JKmWfYY, reason: not valid java name */
    public final PointerInputChange m5415copyJKmWfYY(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, long scrollDelta) {
        PointerInputChange pointerInputChange = this;
        PointerInputChange pointerInputChangeM5418copywbzehF4 = pointerInputChange.m5418copywbzehF4(id, currentTime, currentPosition, currentPressed, pointerInputChange.pressure, previousTime, previousPosition, previousPressed, type, pointerInputChange.getHistorical(), scrollDelta);
        PointerInputChange pointerInputChange2 = pointerInputChange.consumedDelegate;
        if (pointerInputChange2 != null) {
            pointerInputChange = pointerInputChange2;
        }
        pointerInputChangeM5418copywbzehF4.consumedDelegate = pointerInputChange;
        return pointerInputChangeM5418copywbzehF4;
    }

    @ExperimentalComposeUiApi
    /* renamed from: copy-OHpmEuE, reason: not valid java name */
    public final PointerInputChange m5416copyOHpmEuE(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, List<HistoricalChange> historical, long scrollDelta) {
        PointerInputChange pointerInputChange = this;
        PointerInputChange pointerInputChangeM5418copywbzehF4 = pointerInputChange.m5418copywbzehF4(id, currentTime, currentPosition, currentPressed, pointerInputChange.pressure, previousTime, previousPosition, previousPressed, type, historical, scrollDelta);
        PointerInputChange pointerInputChange2 = pointerInputChange.consumedDelegate;
        if (pointerInputChange2 != null) {
            pointerInputChange = pointerInputChange2;
        }
        pointerInputChangeM5418copywbzehF4.consumedDelegate = pointerInputChange;
        return pointerInputChangeM5418copywbzehF4;
    }

    /* renamed from: copy-Tn9QgHE, reason: not valid java name */
    public final PointerInputChange m5417copyTn9QgHE(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, long scrollDelta) {
        PointerInputChange pointerInputChange = this;
        PointerInputChange pointerInputChange2 = new PointerInputChange(id, currentTime, currentPosition, currentPressed, pressure, previousTime, previousPosition, previousPressed, false, type, pointerInputChange.getHistorical(), scrollDelta, pointerInputChange.originalEventPosition, null);
        PointerInputChange pointerInputChange3 = pointerInputChange.consumedDelegate;
        if (pointerInputChange3 != null) {
            pointerInputChange = pointerInputChange3;
        }
        pointerInputChange2.consumedDelegate = pointerInputChange;
        return pointerInputChange2;
    }

    /* renamed from: copy-wbzehF4, reason: not valid java name */
    public final PointerInputChange m5418copywbzehF4(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, List<HistoricalChange> historical, long scrollDelta) {
        PointerInputChange pointerInputChange = this;
        PointerInputChange pointerInputChange2 = new PointerInputChange(id, currentTime, currentPosition, currentPressed, pressure, previousTime, previousPosition, previousPressed, false, type, historical, scrollDelta, pointerInputChange.originalEventPosition, null);
        PointerInputChange pointerInputChange3 = pointerInputChange.consumedDelegate;
        if (pointerInputChange3 != null) {
            pointerInputChange = pointerInputChange3;
        }
        pointerInputChange2.consumedDelegate = pointerInputChange;
        return pointerInputChange2;
    }

    public final ConsumedData getConsumed() {
        if (this._consumed == null) {
            this._consumed = new ConsumedData(this);
        }
        ConsumedData consumedData = this._consumed;
        k.c(consumedData);
        return consumedData;
    }

    /* renamed from: getConsumedDelegate$ui_release, reason: from getter */
    public final PointerInputChange getConsumedDelegate() {
        return this.consumedDelegate;
    }

    /* renamed from: getDownChange$ui_release, reason: from getter */
    public final boolean getDownChange() {
        return this.downChange;
    }

    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? EmptyList.f4893a : list;
    }

    /* renamed from: getId-J3iCeTQ, reason: not valid java name and from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: getOriginalEventPosition-F1C5BW0$ui_release, reason: not valid java name and from getter */
    public final long getOriginalEventPosition() {
        return this.originalEventPosition;
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPosition() {
        return this.position;
    }

    /* renamed from: getPositionChange$ui_release, reason: from getter */
    public final boolean getPositionChange() {
        return this.positionChange;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: getPreviousPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPreviousPosition() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* renamed from: getScrollDelta-F1C5BW0, reason: not valid java name and from getter */
    public final long getScrollDelta() {
        return this.scrollDelta;
    }

    /* renamed from: getType-T8wyACA, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final boolean isConsumed() {
        PointerInputChange pointerInputChange = this.consumedDelegate;
        return pointerInputChange != null ? pointerInputChange.isConsumed() : this.downChange || this.positionChange;
    }

    public final void setConsumedDelegate$ui_release(PointerInputChange pointerInputChange) {
        this.consumedDelegate = pointerInputChange;
    }

    public final void setDownChange$ui_release(boolean z10) {
        this.downChange = z10;
    }

    /* renamed from: setOriginalEventPosition-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m5425setOriginalEventPositionk4lQ0M$ui_release(long j5) {
        this.originalEventPosition = j5;
    }

    public final void setPositionChange$ui_release(boolean z10) {
        this.positionChange = z10;
    }

    public String toString() {
        return "PointerInputChange(id=" + ((Object) PointerId.m5405toStringimpl(this.id)) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + ((Object) Offset.m3903toStringimpl(this.position)) + ", pressed=" + this.pressed + ", pressure=" + this.pressure + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + ((Object) Offset.m3903toStringimpl(this.previousPosition)) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + ((Object) PointerType.m5494toStringimpl(this.type)) + ", historical=" + getHistorical() + ",scrollDelta=" + ((Object) Offset.m3903toStringimpl(this.scrollDelta)) + ')';
    }

    public /* synthetic */ PointerInputChange(long j5, long j6, long j10, boolean z10, float f, long j11, long j12, boolean z11, boolean z12, int i, List list, long j13, long j14, e eVar) {
        this(j5, j6, j10, z10, f, j11, j12, z11, z12, i, (List<HistoricalChange>) list, j13, j14);
    }

    @c
    public /* synthetic */ PointerInputChange(long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, ConsumedData consumedData, int i, e eVar) {
        this(j5, j6, j10, z10, j11, j12, z11, consumedData, i);
    }

    public /* synthetic */ PointerInputChange(long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, boolean z12, int i, long j13, e eVar) {
        this(j5, j6, j10, z10, j11, j12, z11, z12, i, j13);
    }

    private PointerInputChange(long j5, long j6, long j10, boolean z10, float f, long j11, long j12, boolean z11, boolean z12, int i, long j13) {
        this.id = j5;
        this.uptimeMillis = j6;
        this.position = j10;
        this.pressed = z10;
        this.pressure = f;
        this.previousUptimeMillis = j11;
        this.previousPosition = j12;
        this.previousPressed = z11;
        this.type = i;
        this.scrollDelta = j13;
        this.originalEventPosition = Offset.INSTANCE.m3911getZeroF1C5BW0();
        this.downChange = z12;
        this.positionChange = z12;
    }

    public /* synthetic */ PointerInputChange(long j5, long j6, long j10, boolean z10, float f, long j11, long j12, boolean z11, boolean z12, int i, long j13, int i6, e eVar) {
        this(j5, j6, j10, z10, f, j11, j12, z11, z12, (i6 & 512) != 0 ? PointerType.INSTANCE.m5499getTouchT8wyACA() : i, (i6 & 1024) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j13, (e) null);
    }

    public /* synthetic */ PointerInputChange(long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, boolean z12, int i, long j13, int i6, e eVar) {
        this(j5, j6, j10, z10, j11, j12, z11, z12, (i6 & 256) != 0 ? PointerType.INSTANCE.m5499getTouchT8wyACA() : i, (i6 & 512) != 0 ? Offset.INSTANCE.m3911getZeroF1C5BW0() : j13, (e) null);
    }

    private PointerInputChange(long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, boolean z12, int i, long j13) {
        this(j5, j6, j10, z10, 1.0f, j11, j12, z11, z12, i, j13, (e) null);
    }

    public /* synthetic */ PointerInputChange(long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, ConsumedData consumedData, int i, int i6, e eVar) {
        this(j5, j6, j10, z10, j11, j12, z11, consumedData, (i6 & 256) != 0 ? PointerType.INSTANCE.m5499getTouchT8wyACA() : i, (e) null);
    }

    private PointerInputChange(long j5, long j6, long j10, boolean z10, long j11, long j12, boolean z11, ConsumedData consumedData, int i) {
        this(j5, j6, j10, z10, 1.0f, j11, j12, z11, consumedData.getDownChange() || consumedData.getPositionChange(), i, Offset.INSTANCE.m3911getZeroF1C5BW0(), (e) null);
    }

    private PointerInputChange(long j5, long j6, long j10, boolean z10, float f, long j11, long j12, boolean z11, boolean z12, int i, List<HistoricalChange> list, long j13, long j14) {
        this(j5, j6, j10, z10, f, j11, j12, z11, z12, i, j13, (e) null);
        this._historical = list;
        this.originalEventPosition = j14;
    }
}
