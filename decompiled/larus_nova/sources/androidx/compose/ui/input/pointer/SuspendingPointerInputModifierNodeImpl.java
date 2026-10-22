package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001_B=\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBZ\b\u0017\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f¢\u0006\u0002\b\u0012¢\u0006\u0004\b\f\u0010\u0013J\b\u0010I\u001a\u00020\u0011H\u0016J\b\u0010J\u001a\u00020\u0011H\u0016J\b\u0010K\u001a\u00020\u0011H\u0016J\b\u0010L\u001a\u00020\u0011H\u0016J?\u0010M\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0004\bN\u0010\rJ-\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020Q2\u001a\u0010R\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u0000\u0012\u0004\u0012\u00020\u00110SH\u0082\bJ\u0018\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u0002052\u0006\u0010P\u001a\u00020QH\u0002J'\u0010V\u001a\u00020\u00112\u0006\u0010U\u001a\u0002052\u0006\u0010P\u001a\u00020Q2\u0006\u0010W\u001a\u00020/H\u0016¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001a\u00020\u0011H\u0016J=\u0010[\u001a\u0002H\\\"\u0004\b\u0000\u0010\\2'\u0010R\u001a#\b\u0001\u0012\u0004\u0012\u00020]\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\\0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f¢\u0006\u0002\b\u0012H\u0096@¢\u0006\u0002\u0010^R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R3\u0010\u0015\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000f¢\u0006\u0002\b\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000Rl\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f¢\u0006\u0002\b\u00122'\u0010\u0018\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f¢\u0006\u0002\b\u00128V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u000007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00060\u0006j\u0002`:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u001c\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u000007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020/X\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u00101R\u001a\u0010C\u001a\u00020DX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006`"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "key1", "", "key2", "keys", "", "pointerInputEventHandler", "Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "pointerInputEvent", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "[Ljava/lang/Object;", "_deprecatedPointerInputHandler", "Lkotlin/jvm/functions/Function2;", "_pointerInputEventHandler", "value", "pointerInputHandler", "getPointerInputHandler$annotations", "()V", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "(Lkotlin/jvm/functions/Function2;)V", "getPointerInputEventHandler", "()Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "setPointerInputEventHandler", "(Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "pointerInputJob", "Lkotlinx/coroutines/Job;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "pointerHandlersLock", "Landroidx/compose/ui/platform/SynchronizedObject;", "Ljava/lang/Object;", "dispatchingPointerHandlers", "lastPointerEvent", "boundsSize", "J", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "onDetach", "onDensityChange", "onViewConfigurationChange", "resetPointerInputHandler", "update", "update$ui_release", "forEachCurrentPointerHandler", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "block", "Lkotlin/Function1;", "dispatchPointerEvent", "pointerEvent", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "awaitPointerEventScope", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PointerEventHandlerCoroutine", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements SuspendingPointerInputModifierNode, PointerInputScope, Density {
    public static final int $stable = 0;
    private Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> _deprecatedPointerInputHandler;
    private PointerInputEventHandler _pointerInputEventHandler;
    private long boundsSize;
    private PointerEvent currentEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    private Object key1;
    private Object key2;
    private Object[] keys;
    private PointerEvent lastPointerEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;
    private final Object pointerHandlersLock;
    private Job pointerInputJob;

    @Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\fJ\u0010\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!J\u001b\u0010&\u001a\u00020\u001c2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010+JG\u0010,\u001a\u0004\u0018\u0001H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u00020/2'\u00100\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-0\u0004\u0012\u0006\u0012\u0004\u0018\u00010201¢\u0006\u0002\b3H\u0096@¢\u0006\u0002\u00104JE\u00105\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u00020/2'\u00100\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-0\u0004\u0012\u0006\u0012\u0004\u0018\u00010201¢\u0006\u0002\b3H\u0096@¢\u0006\u0002\u00104J\u0014\u00106\u001a\u000207*\u000208H\u0097\u0001¢\u0006\u0004\b9\u0010:J\u0014\u00106\u001a\u000207*\u00020;H\u0097\u0001¢\u0006\u0004\b<\u0010=J\u0014\u0010>\u001a\u000208*\u000207H\u0097\u0001¢\u0006\u0004\b?\u0010@J\u0014\u0010>\u001a\u000208*\u00020AH\u0097\u0001¢\u0006\u0004\b?\u0010BJ\u0014\u0010>\u001a\u000208*\u00020;H\u0097\u0001¢\u0006\u0004\bC\u0010DJ\u0014\u0010E\u001a\u00020F*\u00020\u0019H\u0097\u0001¢\u0006\u0004\bG\u0010HJ\u0014\u0010I\u001a\u00020A*\u000208H\u0097\u0001¢\u0006\u0004\bJ\u0010BJ\u0014\u0010I\u001a\u00020A*\u00020;H\u0097\u0001¢\u0006\u0004\bK\u0010DJ\r\u0010L\u001a\u00020M*\u00020NH\u0097\u0001J\u0014\u0010O\u001a\u00020\u0019*\u00020FH\u0097\u0001¢\u0006\u0004\bP\u0010HJ\u0014\u0010Q\u001a\u00020;*\u000207H\u0097\u0001¢\u0006\u0004\bR\u0010SJ\u0014\u0010Q\u001a\u00020;*\u00020AH\u0097\u0001¢\u0006\u0004\bR\u0010TJ\u0014\u0010Q\u001a\u00020;*\u000208H\u0097\u0001¢\u0006\u0004\bU\u0010TR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013R\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010V\u001a\u00020A8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020A8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010X¨\u0006["}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "<init>", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;Lkotlin/coroutines/Continuation;)V", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "currentEvent", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "offerPointerEvent", "", "event", "pass", "cancel", "cause", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "awaitPointerEvent", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", ExifInterface.GPS_DIRECTION_TRUE, "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "density", "getDensity", "()F", "fontScale", "getFontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;
        private PointerEventPass awaitPass;
        private final Continuation<R> completion;
        private final CoroutineContext context;
        private i<? super PointerEvent> pointerAwaiter;
        final /* synthetic */ SuspendingPointerInputModifierNodeImpl this$0;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public int mo364roundToPxR2X_6o(long r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7508$default$roundToPxR2X_6o(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public int mo365roundToPx0680j_4(float r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7509$default$roundToPx0680j_4(r101, r100);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public float mo366toDpGaN1DYA(long r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo367toDpu2uoSUM(float r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7510$default$toDpu2uoSUM(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo368toDpu2uoSUM(int r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7511$default$toDpu2uoSUM(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public long mo369toDpSizekrfVVM(long r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7512$default$toDpSizekrfVVM(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public float mo370toPxR2X_6o(long r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7513$default$toPxR2X_6o(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public float mo371toPx0680j_4(float r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7514$default$toPx0680j_4(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        public Rect toRect(DpRect r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.$default$toRect(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public long mo372toSizeXkaWNTQ(long r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7515$default$toSizeXkaWNTQ(r101, r100);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public long mo373toSp0xMU5do(float r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return FontScaling.CC.m7654$default$toSp0xMU5do(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo374toSpkPz2Gy4(float r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7516$default$toSpkPz2Gy4(r101, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo375toSpkPz2Gy4(int r100) {
            SuspendingPointerInputModifierNodeImpl r101 = this.$$delegate_0;
            r101.getClass();
            return Density.CC.m7517$default$toSpkPz2Gy4(r101, r100);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public PointerEvent getCurrentEvent() {
            return SuspendingPointerInputModifierNodeImpl.access$getCurrentEvent$p(this.this$0);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo6020getExtendedTouchPaddingNHjbRc() {
            return this.this$0.mo361getExtendedTouchPaddingNHjbRc();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* JADX INFO: renamed from: getSize-YbymL2g */
        public long mo6021getSizeYbymL2g() {
            return SuspendingPointerInputModifierNodeImpl.access$getBoundsSize$p(this.this$0);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public ViewConfiguration getViewConfiguration() {
            return this.this$0.getViewConfiguration();
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.context;
        }

        public static final /* synthetic */ i access$getPointerAwaiter$p(PointerEventHandlerCoroutine r100) {
            return r100.pointerAwaiter;
        }

        public final void cancel(Throwable r100) {
            i<? super PointerEvent> r101 = this.pointerAwaiter;
            if (r101 == null) goto L5;
            r101.cancel(r100);
        L5:
            this.pointerAwaiter = null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r100) {
            Object r101 = SuspendingPointerInputModifierNodeImpl.access$getPointerHandlersLock$p(this.this$0);
            SuspendingPointerInputModifierNodeImpl r102 = this.this$0;
            monitor-enter(r101);
            SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(r102).remove(this);     // Catch: Throwable -> L8
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r101);
            this.completion.resumeWith(r100);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(SuspendingPointerInputModifierNodeImpl r100, Continuation<? super R> r101) {
            this.this$0 = r100;
            this.$$delegate_0 = r100;
            this.completion = r101;
            this.awaitPass = PointerEventPass.Main;
            this.context = EmptyCoroutineContext.INSTANCE;
        }

        public static final /* synthetic */ void access$setAwaitPass$p(PointerEventHandlerCoroutine r100, PointerEventPass r101) {
            r100.awaitPass = r101;
        }

        public static final /* synthetic */ void access$setPointerAwaiter$p(PointerEventHandlerCoroutine r100, i r101) {
            r100.pointerAwaiter = r101;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public Object awaitPointerEvent(PointerEventPass r100, Continuation<? super PointerEvent> r101) {
            j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
            r102.C();
            access$setAwaitPass$p(this, r100);
            access$setPointerAwaiter$p(this, r102);
            Object r103 = r102.B();
            if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
            DebugProbesKt.probeCoroutineSuspended(r101);
        L5:
            return r103;
        }

        public final void offerPointerEvent(PointerEvent r100, PointerEventPass r101) {
            if (r101 != this.awaitPass) goto L8;
            i<? super PointerEvent> r102 = this.pointerAwaiter;
            if (r102 == null) goto L9;
            this.pointerAwaiter = null;
            r102.resumeWith(Result.m9449constructorimpl(r100));
            return;
        L9:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [long] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r11v3, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public <T> Object withTimeout(long r110, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> r111, Continuation<? super T> r112) {
            if ((r112 instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) == false) goto L7;
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r100 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) r112;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r113 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L18;
            if (r103 != 1) goto L17;
            Job r114 = (Job) r100.L$0;
            ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L14
            r110 = r114;
        L27:
            r110.cancel(CancelTimeoutCancellationException.INSTANCE);
            return r113;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r113);
            if (r110 > 0) goto L23;
            i<? super PointerEvent> r115 = this.pointerAwaiter;
            if (r115 == null) goto L23;
            Result.Companion r104 = Result.Companion;
            r115.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(r110))));
        L23:
            Job r116 = BuildersKt.launch$default(this.this$0.getCoroutineScope(), null, null, new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(r110, this, null), 3, null);
            r100.L$0 = r116;     // Catch: Throwable -> L14
            r100.label = 1;     // Catch: Throwable -> L14
            r113 = r111.invoke(this, r100);     // Catch: Throwable -> L14
            r110 = r116;
            if (r113 != r102) goto L27;
            return r102;
        L14:
            th = move-exception;
            r110.cancel(CancelTimeoutCancellationException.INSTANCE);
            throw th;
        L7:
            r100 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, r112);
            goto L8
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public <T> Object withTimeoutOrNull(long r100, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102) {
            if ((r102 instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) == false) goto L7;
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r103 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r102;
            int r104 = r103.label;
            if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
            r103.label = r104 - Integer.MIN_VALUE;
        L8:
            Object r105 = r103.result;
            Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r107 = r103.label;
            if (r107 == 0) goto L15;
            if (r107 != 1) goto L14;
            ResultKt.throwOnFailure(r105);     // Catch: PointerEventTimeoutCancellationException -> L19
        L21:
            return r105;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r105);
            r103.label = 1;     // Catch: PointerEventTimeoutCancellationException -> L19
            r105 = withTimeout(r100, r101, r103);     // Catch: PointerEventTimeoutCancellationException -> L19
            if (r105 != r106) goto L21;
            return r106;
        L19:
            return null;
        L7:
            r103 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, r102);
            goto L8
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PointerEventPass.values().length];
            r100[PointerEventPass.Initial.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PointerEventPass.Final.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PointerEventPass.Main.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    @Deprecated(message = "Super property deprecated")
    public static /* synthetic */ void getPointerInputHandler$annotations() {
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    public final /* synthetic */ long mo195getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.CC.m6621$default$getTouchBoundsExpansionRZrCHBk(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public final /* synthetic */ int mo364roundToPxR2X_6o(long r100) {
        return Density.CC.m7508$default$roundToPxR2X_6o(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo365roundToPx0680j_4(float r100) {
        return Density.CC.m7509$default$roundToPx0680j_4(this, r100);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo366toDpGaN1DYA(long r100) {
        return FontScaling.CC.m7653$default$toDpGaN1DYA(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final /* synthetic */ float mo367toDpu2uoSUM(float r100) {
        return Density.CC.m7510$default$toDpu2uoSUM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final /* synthetic */ float mo368toDpu2uoSUM(int r100) {
        return Density.CC.m7511$default$toDpu2uoSUM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo369toDpSizekrfVVM(long r100) {
        return Density.CC.m7512$default$toDpSizekrfVVM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo370toPxR2X_6o(long r100) {
        return Density.CC.m7513$default$toPxR2X_6o(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final /* synthetic */ float mo371toPx0680j_4(float r100) {
        return Density.CC.m7514$default$toPx0680j_4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    public final /* synthetic */ Rect toRect(DpRect r100) {
        return Density.CC.$default$toRect(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo372toSizeXkaWNTQ(long r100) {
        return Density.CC.m7515$default$toSizeXkaWNTQ(this, r100);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public final /* synthetic */ long mo373toSp0xMU5do(float r100) {
        return FontScaling.CC.m7654$default$toSp0xMU5do(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final /* synthetic */ long mo374toSpkPz2Gy4(float r100) {
        return Density.CC.m7516$default$toSpkPz2Gy4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final /* synthetic */ long mo375toSpkPz2Gy4(int r100) {
        return Density.CC.m7517$default$toSpkPz2Gy4(this, r100);
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public Function2<PointerInputScope, Continuation<? super Unit>, Object> getPointerInputHandler() {
        Function2 r100 = this._deprecatedPointerInputHandler;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1(null);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        PointerEvent r100 = this.lastPointerEvent;
        if (r100 != null) goto L5;
        return;
    L5:
        List<PointerInputChange> r101 = r100.getChanges();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L6:
        boolean r105 = true;
        if (r104 >= r102) goto L12;
        if ((true ^ ((PointerInputChange) ListProtector.get(r101, r104)).getPressed()) == false) goto L10;
        r104 = r104 + 1;
        goto L6
    L10:
        r105 = false;
    L12:
        if (r105 == false) goto L14;
        return;
    L14:
        List<PointerInputChange> r106 = r100.getChanges();
        ArrayList r107 = new ArrayList(r106.size());
        int r108 = r106.size();
    L15:
        if (r103 >= r108) goto L17;
        PointerInputChange r109 = (PointerInputChange) ListProtector.get(r106, r103);
        long r110 = r109.m6124getIdJ3iCeTQ();
        long r111 = r109.m6126getPositionF1C5BW0();
        long r112 = r109.getUptimeMillis();
        float r113 = r109.getPressure();
        long r114 = r109.m6126getPositionF1C5BW0();
        r107.add(new PointerInputChange(r110, r112, r111, false, r113, r109.getUptimeMillis(), r114, r109.getPressed(), r109.getPressed(), r109.m6129getTypeT8wyACA(), 0, 1024, null));
        r103 = r103 + 1;
        goto L15
    L17:
        PointerEvent r115 = new PointerEvent(r107);
        this.currentEvent = r115;
        dispatchPointerEvent(r115, PointerEventPass.Initial);
        dispatchPointerEvent(r115, PointerEventPass.Main);
        dispatchPointerEvent(r115, PointerEventPass.Final);
        this.lastPointerEvent = null;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void resetPointerInputHandler() {
        Job r100 = this.pointerInputJob;
        if (r100 == null) goto L6;
        r100.cancel(new PointerInputResetException());
        this.pointerInputJob = null;
        return;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getDensity();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo361getExtendedTouchPaddingNHjbRc() {
        long r100 = Density.CC.m7515$default$toSizeXkaWNTQ(this, getViewConfiguration().mo6472getMinimumTouchTargetSizeMYxV2XQ());
        long r101 = mo362getSizeYbymL2g();
        float r102 = Math.max(0.0f, Float.intBitsToFloat((int) (r100 >> 32)) - ((int) (r101 >> 32))) / 2.0f;
        float r103 = Math.max(0.0f, Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) - ((int) (r101 & BodyPartID.bodyIdMax))) / 2.0f;
        return Size.m4642constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.requireLayoutNode(this).getViewConfiguration();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetPointerInputHandler();
        super.onDetach();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public PointerInputEventHandler getPointerInputEventHandler() {
        return this._pointerInputEventHandler;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo362getSizeYbymL2g() {
        return this.boundsSize;
    }

    @Override // androidx.compose.ui.Modifier.Node, androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    public static final /* synthetic */ long access$getBoundsSize$p(SuspendingPointerInputModifierNodeImpl r100) {
        return r100.boundsSize;
    }

    public static final /* synthetic */ PointerEvent access$getCurrentEvent$p(SuspendingPointerInputModifierNodeImpl r100) {
        return r100.currentEvent;
    }

    public static final /* synthetic */ MutableVector access$getPointerHandlers$p(SuspendingPointerInputModifierNodeImpl r100) {
        return r100.pointerHandlers;
    }

    public static final /* synthetic */ Object access$getPointerHandlersLock$p(SuspendingPointerInputModifierNodeImpl r100) {
        return r100.pointerHandlersLock;
    }

    public static final /* synthetic */ Function2 access$get_deprecatedPointerInputHandler$p(SuspendingPointerInputModifierNodeImpl r100) {
        return r100._deprecatedPointerInputHandler;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean r100) {
        this.interceptOutOfBoundsChildEvents = r100;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputEventHandler(PointerInputEventHandler r100) {
        resetPointerInputHandler();
        this._deprecatedPointerInputHandler = null;
        this._pointerInputEventHandler = r100;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputHandler(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> r100) {
        resetPointerInputHandler();
        this._deprecatedPointerInputHandler = r100;
    }

    private final void dispatchPointerEvent(PointerEvent r100, PointerEventPass r101) {
        Object r102 = this.pointerHandlersLock;
        monitor-enter(r102);
        MutableVector<PointerEventHandlerCoroutine<?>> r103 = this.dispatchingPointerHandlers;     // Catch: Throwable -> L27
        r103.addAll(r103.getSize(), this.pointerHandlers);     // Catch: Throwable -> L27
        monitor-exit(r102);
        int r104 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];     // Catch: Throwable -> L24
        if (r104 != 1) goto L9;
    L18:
        MutableVector<PointerEventHandlerCoroutine<?>> r105 = this.dispatchingPointerHandlers;     // Catch: Throwable -> L24
        PointerEventHandlerCoroutine<?>[] r106 = r105.content;     // Catch: Throwable -> L24
        int r107 = r105.getSize();     // Catch: Throwable -> L24
        int r108 = 0;
    L19:
        if (r108 >= r107) goto L22;
        r106[r108].offerPointerEvent(r100, r101);     // Catch: Throwable -> L24
        r108 = r108 + 1;
    L22:
        this.dispatchingPointerHandlers.clear();
        return;
    L9:
        if (r104 == 2) goto L18;
        if (r104 != 3) goto L17;
        MutableVector<PointerEventHandlerCoroutine<?>> r109 = this.dispatchingPointerHandlers;     // Catch: Throwable -> L24
        int r110 = r109.getSize() - 1;     // Catch: Throwable -> L24
        PointerEventHandlerCoroutine<?>[] r111 = r109.content;     // Catch: Throwable -> L24
        if (r110 >= r111.length) goto L22;
    L14:
        if (r110 < 0) goto L22;
        r111[r110].offerPointerEvent(r100, r101);     // Catch: Throwable -> L24
        r110 = r110 - 1;     // Catch: Throwable -> L24
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        this.dispatchingPointerHandlers.clear();
        throw th;
    L27:
        th = move-exception;
        throw th;
    }

    private final void forEachCurrentPointerHandler(PointerEventPass r100, Function1<? super PointerEventHandlerCoroutine<?>, Unit> r101) {
        Object r102 = this.pointerHandlersLock;
        monitor-enter(r102);
        MutableVector<PointerEventHandlerCoroutine<?>> r103 = this.dispatchingPointerHandlers;     // Catch: Throwable -> L30
        r103.addAll(r103.getSize(), this.pointerHandlers);     // Catch: Throwable -> L30
        InlineMarker.finallyStart(1);
        monitor-exit(r102);
        InlineMarker.finallyEnd(1);
        int r104 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];     // Catch: Throwable -> L27
        if (r104 != 1) goto L12;
    L21:
        MutableVector<PointerEventHandlerCoroutine<?>> r105 = this.dispatchingPointerHandlers;     // Catch: Throwable -> L27
        PointerEventHandlerCoroutine<?>[] r106 = r105.content;     // Catch: Throwable -> L27
        int r107 = r105.getSize();     // Catch: Throwable -> L27
        int r108 = 0;
    L22:
        if (r108 >= r107) goto L25;
        r101.invoke(r106[r108]);     // Catch: Throwable -> L27
        r108 = r108 + 1;
    L25:
        InlineMarker.finallyStart(1);
        this.dispatchingPointerHandlers.clear();
        InlineMarker.finallyEnd(1);
        return;
    L12:
        if (r104 == 2) goto L21;
        if (r104 != 3) goto L20;
        MutableVector<PointerEventHandlerCoroutine<?>> r109 = this.dispatchingPointerHandlers;     // Catch: Throwable -> L27
        int r110 = r109.getSize() - 1;     // Catch: Throwable -> L27
        PointerEventHandlerCoroutine<?>[] r111 = r109.content;     // Catch: Throwable -> L27
        if (r110 >= r111.length) goto L25;
    L17:
        if (r110 < 0) goto L25;
        r101.invoke(r111[r110]);     // Catch: Throwable -> L27
        r110 = r110 - 1;     // Catch: Throwable -> L27
        goto L17
    L20:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        InlineMarker.finallyStart(1);
        this.dispatchingPointerHandlers.clear();
        InlineMarker.finallyEnd(1);
        throw th;
    L30:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> r100, Continuation<? super R> r101) {
        j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        final PointerEventHandlerCoroutine r103 = new PointerEventHandlerCoroutine(this, r102);
        Object r104 = access$getPointerHandlersLock$p(this);
        monitor-enter(r104);
        access$getPointerHandlers$p(this).add(r103);     // Catch: Throwable -> L10
        Continuation<Unit> r105 = ContinuationKt.createCoroutine(r100, r103, r103);     // Catch: Throwable -> L10
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L10
        r105.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L10
        monitor-exit(r104);
        r102.i(new SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2(r103));
        Object r107 = r102.B();
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L9:
        return r107;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo202onPointerEventH0pRuoY(PointerEvent r100, PointerEventPass r101, long r102) {
        this.boundsSize = r102;
        if (r101 != PointerEventPass.Initial) goto L6;
        this.currentEvent = r100;
    L6:
        if (this.pointerInputJob != null) goto L8;
        this.pointerInputJob = BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
    L8:
        dispatchPointerEvent(r100, r101);
        List<PointerInputChange> r103 = r100.getChanges();
        int r104 = r103.size();
        boolean r105 = false;
        int r106 = 0;
    L10:
        if (r106 >= r104) goto L15;
        if (PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange) ListProtector.get(r103, r106)) == false) goto L17;
        r106 = r106 + 1;
    L17:
        if ((!r105) == true) goto L20;
        r100 = null;
    L20:
        this.lastPointerEvent = r100;
        return;
    L15:
        r105 = true;
        goto L17
    }

    public SuspendingPointerInputModifierNodeImpl(Object r100, Object r101, Object[] r102, PointerInputEventHandler r103) {
        this.key1 = r100;
        this.key2 = r101;
        this.keys = r102;
        this._pointerInputEventHandler = r103;
        this.currentEvent = SuspendingPointerInputFilterKt.access$getEmptyPointerEvent$p();
        MutableVector<PointerEventHandlerCoroutine<?>> r104 = new MutableVector(new PointerEventHandlerCoroutine[16], 0);
        this.pointerHandlers = r104;
        this.pointerHandlersLock = r104;
        this.dispatchingPointerHandlers = new MutableVector(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.Companion.m7724getZeroYbymL2g();
    }

    public final void update$ui_release(Object r100, Object r101, Object[] r102, PointerInputEventHandler r103) {
        boolean r104 = true;
        boolean r105 = !Intrinsics.areEqual(this.key1, r100);
        this.key1 = r100;
        if (Intrinsics.areEqual(this.key2, r101) == true) goto L5;
        r105 = true;
    L5:
        this.key2 = r101;
        Object[] r106 = this.keys;
        if (r106 == null) goto L9;
        if (r102 != null) goto L9;
        r105 = true;
    L9:
        if (r106 != null) goto L12;
        if (r102 == null) goto L12;
        r105 = true;
    L12:
        if (r106 == null) goto L17;
        if (r102 == null) goto L17;
        if (Arrays.equals(r102, r106) == true) goto L17;
        r105 = true;
    L17:
        this.keys = r102;
        if (getPointerInputEventHandler().getClass() != r103.getClass()) goto L21;
        r104 = r105;
    L21:
        if (r104 == false) goto L23;
        resetPointerInputHandler();
    L23:
        this._pointerInputEventHandler = r103;
    }

    @Deprecated(message = "Exists to maintain compatibility with previous API shape")
    public SuspendingPointerInputModifierNodeImpl(Object r100, Object r101, Object[] r102, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> r103) {
        this(r100, r101, r102, AnonymousClass1.INSTANCE);
        this._deprecatedPointerInputHandler = r103;
    }

    public /* synthetic */ SuspendingPointerInputModifierNodeImpl(Object r100, Object r101, Object[] r102, PointerInputEventHandler r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
