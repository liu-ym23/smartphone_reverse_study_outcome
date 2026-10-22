package androidx.compose.ui.viewinterop;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import S7.p;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.C0764ViewTreeLifecycleOwner;
import android.view.C0812ViewTreeSavedStateRegistryOwner;
import android.view.LifecycleOwner;
import android.view.SavedStateRegistryOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.VelocityKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000 Ù\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002Ù\u0001B9\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u001f\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u001a¢\u0006\u0004\b#\u0010\u001cJ7\u0010*\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0014¢\u0006\u0004\b*\u0010+J\u0011\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020$H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u001aH\u0014¢\u0006\u0004\b2\u0010\u001cJ\u000f\u00103\u001a\u00020\u001aH\u0014¢\u0006\u0004\b3\u0010\u001cJ%\u00109\u001a\u0004\u0018\u0001082\b\u00105\u001a\u0004\u0018\u0001042\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010=\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u001a¢\u0006\u0004\b?\u0010\u001cJ\u0017\u0010A\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\nH\u0014¢\u0006\u0004\bA\u0010BJ\u0019\u0010E\u001a\u00020$2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020$H\u0016¢\u0006\u0004\bG\u0010HJ/\u0010K\u001a\u00020$2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\nH\u0016¢\u0006\u0004\bM\u0010NJ/\u0010O\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\bO\u0010PJ\u001f\u0010Q\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\bQ\u0010RJG\u0010X\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010W\u001a\u000204H\u0016¢\u0006\u0004\bX\u0010YJ?\u0010X\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\bX\u0010ZJ7\u0010]\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010W\u001a\u0002042\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\b]\u0010^J/\u0010b\u001a\u00020$2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020_2\u0006\u0010W\u001a\u00020$H\u0016¢\u0006\u0004\bb\u0010cJ'\u0010d\u001a\u00020$2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020_H\u0016¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020$H\u0016¢\u0006\u0004\bf\u0010HJ\u001f\u0010j\u001a\u00020h2\u0006\u0010g\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020hH\u0016¢\u0006\u0004\bj\u0010kJ'\u0010o\u001a\u00020\n2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\nH\u0002¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020h2\u0006\u0010i\u001a\u00020hH\u0002¢\u0006\u0004\bq\u0010rJ\u0017\u0010u\u001a\u00020s2\u0006\u0010t\u001a\u00020sH\u0002¢\u0006\u0004\bu\u0010vJD\u0010{\u001a\u00028\u0000\"\u0004\b\u0000\u0010w2\u0006\u0010x\u001a\u00028\u00002$\u0010z\u001a \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000yH\u0082\b¢\u0006\u0004\b{\u0010|J8\u0010\u0082\u0001\u001a\u00020}*\u00020}2\u0006\u0010~\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\n2\u0007\u0010\u0081\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0015\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010\u0084\u0001R\u0015\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\r\u0010\u0085\u0001R\u0019\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\u000e\n\u0005\b\u000f\u0010\u0086\u0001\u001a\u0005\b\u0087\u0001\u0010\u0016R\u0015\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0011\u0010\u0088\u0001R?\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0089\u00012\r\u0010x\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0089\u00018\u0006@DX\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0019\u0010\u0090\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R?\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0089\u00012\r\u0010x\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0089\u00018\u0006@DX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u008b\u0001\u001a\u0006\b\u0093\u0001\u0010\u008d\u0001\"\u0006\b\u0094\u0001\u0010\u008f\u0001R?\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0089\u00012\r\u0010x\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0089\u00018\u0006@DX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u008b\u0001\u001a\u0006\b\u0096\u0001\u0010\u008d\u0001\"\u0006\b\u0097\u0001\u0010\u008f\u0001R3\u0010\u0099\u0001\u001a\u00030\u0098\u00012\u0007\u0010x\u001a\u00030\u0098\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R9\u0010 \u0001\u001a\u0012\u0012\u0005\u0012\u00030\u0098\u0001\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u009f\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R3\u0010§\u0001\u001a\u00030¦\u00012\u0007\u0010x\u001a\u00030¦\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R9\u0010\u00ad\u0001\u001a\u0012\u0012\u0005\u0012\u00030¦\u0001\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u009f\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0001\u0010¡\u0001\u001a\u0006\b®\u0001\u0010£\u0001\"\u0006\b¯\u0001\u0010¥\u0001R7\u0010±\u0001\u001a\u0005\u0018\u00010°\u00012\t\u0010x\u001a\u0005\u0018\u00010°\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R7\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00012\t\u0010x\u001a\u0005\u0018\u00010·\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u0017\u0010¾\u0001\u001a\u0002048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001a\u0010Á\u0001\u001a\u00030À\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0019\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bi\u0010Ã\u0001R\u001e\u0010Ä\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010\u008b\u0001R\u001e\u0010Å\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010\u008b\u0001R8\u0010Æ\u0001\u001a\u0011\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u009f\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÆ\u0001\u0010¡\u0001\u001a\u0006\bÇ\u0001\u0010£\u0001\"\u0006\bÈ\u0001\u0010¥\u0001R\u0015\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b5\u0010¿\u0001R\u0019\u0010É\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010\u0084\u0001R\u0019\u0010Ê\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010\u0084\u0001R\u0018\u0010Ì\u0001\u001a\u00030Ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Î\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u0091\u0001R\u001d\u0010Ð\u0001\u001a\u00030Ï\u00018\u0006¢\u0006\u0010\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001R\u0016\u0010Ô\u0001\u001a\u00020$8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÔ\u0001\u0010HR\u0018\u0010Ø\u0001\u001a\u00030Õ\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÖ\u0001\u0010×\u0001¨\u0006Ú\u0001"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/content/Context;", "context", "Landroidx/compose/runtime/CompositionContext;", "parentContext", "", "compositeKeyHash", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "dispatcher", "Landroid/view/View;", "view", "Landroidx/compose/ui/node/Owner;", "owner", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;ILandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroid/view/View;Landroidx/compose/ui/node/Owner;)V", "Landroidx/compose/ui/viewinterop/InteropView;", "getInteropView", "()Landroid/view/View;", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "LC7/r;", "onReuse", "()V", "onDeactivate", "onRelease", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "remeasure", "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "disallowIntercept", "requestDisallowInterceptTouchEvent", "(Z)V", "onAttachedToWindow", "onDetachedFromWindow", "", "location", "Landroid/graphics/Rect;", "dirty", "Landroid/view/ViewParent;", "invalidateChildInParent", "([ILandroid/graphics/Rect;)Landroid/view/ViewParent;", "child", TypedValues.AttributesType.S_TARGET, "onDescendantInvalidated", "(Landroid/view/View;Landroid/view/View;)V", "invalidateOrDefer", "visibility", "onWindowVisibilityChanged", "(I)V", "Landroid/graphics/Region;", "region", "gatherTransparentRegion", "(Landroid/graphics/Region;)Z", "shouldDelayChildPressedState", "()Z", "axes", "type", "onStartNestedScroll", "(Landroid/view/View;Landroid/view/View;II)Z", "getNestedScrollAxes", "()I", "onNestedScrollAccepted", "(Landroid/view/View;Landroid/view/View;II)V", "onStopNestedScroll", "(Landroid/view/View;I)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "consumed", "onNestedScroll", "(Landroid/view/View;IIIII[I)V", "(Landroid/view/View;IIIII)V", "dx", "dy", "onNestedPreScroll", "(Landroid/view/View;II[II)V", "", "velocityX", "velocityY", "onNestedFling", "(Landroid/view/View;FFZ)Z", "onNestedPreFling", "(Landroid/view/View;FF)Z", "isNestedScrollingEnabled", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "min", "max", "preferred", "obtainMeasureSpec", "(III)I", "insetToLayoutPosition", "(Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "insetBounds", "(Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;)Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlin/Function4;", "block", "insetValue", "(Ljava/lang/Object;LS7/p;)Ljava/lang/Object;", "Landroidx/core/graphics/Insets;", "left", "top", "right", "bottom", "inset", "(Landroidx/core/graphics/Insets;IIII)Landroidx/core/graphics/Insets;", "I", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "Landroid/view/View;", "getView", "Landroidx/compose/ui/node/Owner;", "Lkotlin/Function0;", "update", "LS7/a;", "getUpdate", "()LS7/a;", "setUpdate", "(LS7/a;)V", "hasUpdateBlock", "Z", "reset", "getReset", "setReset", "release", "getRelease", "setRelease", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "Lkotlin/Function1;", "onModifierChanged", "LS7/k;", "getOnModifierChanged$ui_release", "()LS7/k;", "setOnModifierChanged$ui_release", "(LS7/k;)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "onDensityChanged", "getOnDensityChanged$ui_release", "setOnDensityChanged$ui_release", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "position", "[I", "Landroidx/compose/ui/unit/IntSize;", "size", "J", "Landroidx/core/view/WindowInsetsCompat;", "runUpdate", "runInvalidate", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "lastWidthMeasureSpec", "lastHeightMeasureSpec", "Landroidx/core/view/NestedScrollingParentHelper;", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "isDrawing", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "isValidOwnerScope", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback, OwnerScope, OnApplyWindowInsetsListener {
    private final int compositeKeyHash;
    private Density density;
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;
    private WindowInsetsCompat insets;
    private boolean isDrawing;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    private k onDensityChanged;
    private k onModifierChanged;
    private k onRequestDisallowInterceptTouchEvent;
    private final Owner owner;
    private final int[] position;
    private S7.a release;
    private S7.a reset;
    private final S7.a runInvalidate;
    private final S7.a runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private long size;
    private S7.a update;
    private final View view;
    public static final int $stable = 8;
    private static final k OnCommitAffectingUpdate = AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.INSTANCE;

    @c(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", l = {617, 619}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ boolean $consumed;
        final /* synthetic */ long $viewVelocity;
        int label;
        final /* synthetic */ AndroidViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, AndroidViewHolder androidViewHolder, long j5, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$consumed = z10;
            this.this$0 = androidViewHolder;
            this.$viewVelocity = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$consumed, this.this$0, this.$viewVelocity, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        
            if (r11 == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        
            if (r11 == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.b.b(r11)
                goto L5a
            L10:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L18:
                kotlin.b.b(r11)
                goto L3b
            L1c:
                kotlin.b.b(r11)
                boolean r11 = r10.$consumed
                if (r11 != 0) goto L41
                androidx.compose.ui.viewinterop.AndroidViewHolder r11 = r10.this$0
                androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = androidx.compose.ui.viewinterop.AndroidViewHolder.access$getDispatcher$p(r11)
                androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.INSTANCE
                long r5 = r11.m7093getZero9UxMQ8M()
                long r7 = r10.$viewVelocity
                r10.label = r3
                r9 = r10
                java.lang.Object r11 = r4.m5293dispatchPostFlingRZ2iAVY(r5, r7, r9)
                if (r11 != r0) goto L3b
                goto L59
            L3b:
                androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
                r11.getPackedValue()
                goto L5f
            L41:
                r6 = r10
                androidx.compose.ui.viewinterop.AndroidViewHolder r10 = r6.this$0
                androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = androidx.compose.ui.viewinterop.AndroidViewHolder.access$getDispatcher$p(r10)
                r10 = r2
                long r2 = r6.$viewVelocity
                androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.INSTANCE
                long r4 = r11.m7093getZero9UxMQ8M()
                r6.label = r10
                java.lang.Object r11 = r1.m5293dispatchPostFlingRZ2iAVY(r2, r4, r6)
                if (r11 != r0) goto L5a
            L59:
                return r0
            L5a:
                androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
                r11.getPackedValue()
            L5f:
                C7.r r10 = C7.r.f317a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidViewHolder.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1", f = "AndroidViewHolder.android.kt", l = {628}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07301 extends SuspendLambda implements n {
        final /* synthetic */ long $toBeConsumed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07301(long j5, H7.c<? super C07301> cVar) {
            super(2, cVar);
            this.$toBeConsumed = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AndroidViewHolder.this.new C07301(this.$toBeConsumed, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                NestedScrollDispatcher nestedScrollDispatcher = AndroidViewHolder.this.dispatcher;
                long j5 = this.$toBeConsumed;
                this.label = 1;
                if (nestedScrollDispatcher.m5295dispatchPreFlingQWom1Mo(j5, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C07301) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidViewHolder(Context context, CompositionContext compositionContext, int i, NestedScrollDispatcher nestedScrollDispatcher, View view, Owner owner) {
        super(context);
        this.compositeKeyHash = i;
        this.dispatcher = nestedScrollDispatcher;
        this.view = view;
        this.owner = owner;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        addView(view);
        ViewCompat.setWindowInsetsAnimationCallback(this, new WindowInsetsAnimationCompat.Callback() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder.2
            {
                super(1);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                return AndroidViewHolder.this.insetToLayoutPosition(insets);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
                return AndroidViewHolder.this.insetBounds(bounds);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(this, this);
        this.update = new S7.a() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$update$1
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m7098invoke() {
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m7098invoke();
                return r.f317a;
            }
        };
        this.reset = new S7.a() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$reset$1
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m7095invoke() {
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m7095invoke();
                return r.f317a;
            }
        };
        this.release = new S7.a() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$release$1
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m7094invoke() {
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m7094invoke();
                return r.f317a;
            }
        };
        Modifier.Companion companion = Modifier.INSTANCE;
        this.modifier = companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.position = new int[2];
        this.size = IntSize.INSTANCE.m7020getZeroYbymL2g();
        this.runUpdate = new S7.a() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runUpdate$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m7097invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m7097invoke() {
                if (this.this$0.hasUpdateBlock && this.this$0.isAttachedToWindow()) {
                    ViewParent parent = this.this$0.getView().getParent();
                    AndroidViewHolder androidViewHolder = this.this$0;
                    if (parent == androidViewHolder) {
                        androidViewHolder.getSnapshotObserver().observeReads$ui_release(this.this$0, AndroidViewHolder.OnCommitAffectingUpdate, this.this$0.getUpdate());
                    }
                }
            }
        };
        this.runInvalidate = new S7.a() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runInvalidate$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m7096invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m7096invoke() {
                this.this$0.getLayoutNode().invalidateLayer$ui_release();
            }
        };
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        Object[] objArr = 0 == true ? 1 : 0;
        final LayoutNode layoutNode = new LayoutNode(false, objArr, 3, null);
        layoutNode.setInteropViewFactoryHolder$ui_release(this);
        final Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(companion, AndroidViewHolder_androidKt.NoOpScrollConnection, nestedScrollDispatcher), true, new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$1
            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }
        }), this), new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return r.f317a;
            }

            public final void invoke(DrawScope drawScope) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                LayoutNode layoutNode2 = layoutNode;
                AndroidViewHolder androidViewHolder2 = this;
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                if (androidViewHolder.getView().getVisibility() != 8) {
                    androidViewHolder.isDrawing = true;
                    Owner owner2 = layoutNode2.getOwner();
                    AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                    if (androidComposeView != null) {
                        androidComposeView.drawAndroidView(androidViewHolder2, AndroidCanvas_androidKt.getNativeCanvas(canvas));
                    }
                    androidViewHolder.isDrawing = false;
                }
            }
        }), new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return r.f317a;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                WindowInsets windowInsets;
                AndroidViewHolder_androidKt.layoutAccordingTo(this.$this_run, layoutNode);
                this.$this_run.owner.onInteropViewLayoutChange(this.$this_run);
                int i6 = this.$this_run.position[0];
                int i10 = this.$this_run.position[1];
                this.$this_run.getView().getLocationOnScreen(this.$this_run.position);
                long j5 = this.$this_run.size;
                this.$this_run.size = layoutCoordinates.mo5557getSizeYbymL2g();
                WindowInsetsCompat windowInsetsCompat = this.$this_run.insets;
                if (windowInsetsCompat != null) {
                    if ((i6 == this.$this_run.position[0] && i10 == this.$this_run.position[1] && IntSize.m7013equalsimpl0(j5, this.$this_run.size)) || (windowInsets = this.$this_run.insetToLayoutPosition(windowInsetsCompat).toWindowInsets()) == null) {
                        return;
                    }
                    this.$this_run.getView().dispatchApplyWindowInsets(windowInsets);
                }
            }
        });
        layoutNode.setCompositeKeyHash(i);
        layoutNode.setModifier(this.modifier.then(modifierOnGloballyPositioned));
        this.onModifierChanged = new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Modifier) obj);
                return r.f317a;
            }

            public final void invoke(Modifier modifier) {
                layoutNode.setModifier(modifier.then(modifierOnGloballyPositioned));
            }
        };
        layoutNode.setDensity(this.density);
        this.onDensityChanged = new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Density) obj);
                return r.f317a;
            }

            public final void invoke(Density density) {
                layoutNode.setDensity(density);
            }
        };
        layoutNode.setOnAttach$ui_release(new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Owner) obj);
                return r.f317a;
            }

            public final void invoke(Owner owner2) {
                AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                if (androidComposeView != null) {
                    androidComposeView.addAndroidView(this.$this_run, layoutNode);
                }
                ViewParent parent = this.$this_run.getView().getParent();
                AndroidViewHolder androidViewHolder = this.$this_run;
                if (parent != androidViewHolder) {
                    androidViewHolder.addView(androidViewHolder.getView());
                }
            }
        });
        layoutNode.setOnDetach$ui_release(new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Owner) obj);
                return r.f317a;
            }

            public final void invoke(Owner owner2) {
                if (ComposeUiFlags.isViewFocusFixEnabled && this.$this_run.hasFocus()) {
                    owner2.getFocusOwner().clearFocus(true);
                }
                AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                if (androidComposeView != null) {
                    androidComposeView.removeAndroidView(this.$this_run);
                }
                this.$this_run.removeAllViewsInLayout();
            }
        });
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            private final int intrinsicHeight(int width) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                kotlin.jvm.internal.k.c(layoutParams);
                androidViewHolder.measure(androidViewHolder.obtainMeasureSpec(0, width, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return this.$this_run.getMeasuredHeight();
            }

            private final int intrinsicWidth(int height) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
                kotlin.jvm.internal.k.c(layoutParams);
                androidViewHolder.measure(iMakeMeasureSpec, androidViewHolder2.obtainMeasureSpec(0, height, layoutParams.height));
                return this.$this_run.getMeasuredWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i6) {
                return intrinsicHeight(i6);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i6) {
                return intrinsicWidth(i6);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                if (this.$this_run.getChildCount() == 0) {
                    return MeasureScope.layout$default(measureScope, Constraints.m6799getMinWidthimpl(j5), Constraints.m6798getMinHeightimpl(j5), null, new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$1
                        public final void invoke(Placeable.PlacementScope placementScope) {
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return r.f317a;
                        }
                    }, 4, null);
                }
                if (Constraints.m6799getMinWidthimpl(j5) != 0) {
                    this.$this_run.getChildAt(0).setMinimumWidth(Constraints.m6799getMinWidthimpl(j5));
                }
                if (Constraints.m6798getMinHeightimpl(j5) != 0) {
                    this.$this_run.getChildAt(0).setMinimumHeight(Constraints.m6798getMinHeightimpl(j5));
                }
                AndroidViewHolder androidViewHolder = this.$this_run;
                int iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
                int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
                ViewGroup.LayoutParams layoutParams = this.$this_run.getLayoutParams();
                kotlin.jvm.internal.k.c(layoutParams);
                int iObtainMeasureSpec = androidViewHolder.obtainMeasureSpec(iM6799getMinWidthimpl, iM6797getMaxWidthimpl, layoutParams.width);
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                int iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5);
                int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
                ViewGroup.LayoutParams layoutParams2 = this.$this_run.getLayoutParams();
                kotlin.jvm.internal.k.c(layoutParams2);
                androidViewHolder.measure(iObtainMeasureSpec, androidViewHolder2.obtainMeasureSpec(iM6798getMinHeightimpl, iM6796getMaxHeightimpl, layoutParams2.height));
                int measuredWidth = this.$this_run.getMeasuredWidth();
                int measuredHeight = this.$this_run.getMeasuredHeight();
                final AndroidViewHolder androidViewHolder3 = this.$this_run;
                final LayoutNode layoutNode2 = layoutNode;
                return MeasureScope.layout$default(measureScope, measuredWidth, measuredHeight, null, new k() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return r.f317a;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        AndroidViewHolder_androidKt.layoutAccordingTo(androidViewHolder3, layoutNode2);
                    }
                }, 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i6) {
                return intrinsicHeight(i6);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i6) {
                return intrinsicWidth(i6);
            }
        });
        this.layoutNode = layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        if (!isAttachedToWindow()) {
            InlineClassHelperKt.throwIllegalStateException("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return this.owner.getSnapshotObserver();
    }

    private final Insets inset(Insets insets, int i, int i6, int i10, int i11) {
        int i12 = insets.left - i;
        if (i12 < 0) {
            i12 = 0;
        }
        int i13 = insets.top - i6;
        if (i13 < 0) {
            i13 = 0;
        }
        int i14 = insets.right - i10;
        if (i14 < 0) {
            i14 = 0;
        }
        int i15 = insets.bottom - i11;
        return Insets.of(i12, i13, i14, i15 >= 0 ? i15 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowInsetsAnimationCompat.BoundsCompat insetBounds(WindowInsetsAnimationCompat.BoundsCompat bounds) {
        NodeCoordinator innerCoordinator$ui_release = this.layoutNode.getInnerCoordinator$ui_release();
        if (innerCoordinator$ui_release.isAttached()) {
            long jM6989roundk4lQ0M = IntOffsetKt.m6989roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(innerCoordinator$ui_release));
            int iM6972getXimpl = IntOffset.m6972getXimpl(jM6989roundk4lQ0M);
            if (iM6972getXimpl < 0) {
                iM6972getXimpl = 0;
            }
            int iM6973getYimpl = IntOffset.m6973getYimpl(jM6989roundk4lQ0M);
            int i = iM6973getYimpl < 0 ? 0 : iM6973getYimpl;
            long jMo5557getSizeYbymL2g = LayoutCoordinatesKt.findRootCoordinates(innerCoordinator$ui_release).mo5557getSizeYbymL2g();
            int i6 = (int) (jMo5557getSizeYbymL2g >> 32);
            int i10 = (int) (jMo5557getSizeYbymL2g & 4294967295L);
            long jMo5557getSizeYbymL2g2 = innerCoordinator$ui_release.mo5557getSizeYbymL2g();
            long jM6989roundk4lQ0M2 = IntOffsetKt.m6989roundk4lQ0M(innerCoordinator$ui_release.mo5560localToRootMKHz9U(Offset.m3887constructorimpl((4294967295L & Float.floatToRawIntBits((int) (jMo5557getSizeYbymL2g2 & 4294967295L))) | (Float.floatToRawIntBits((int) (jMo5557getSizeYbymL2g2 >> 32)) << 32))));
            int iM6972getXimpl2 = i6 - IntOffset.m6972getXimpl(jM6989roundk4lQ0M2);
            if (iM6972getXimpl2 < 0) {
                iM6972getXimpl2 = 0;
            }
            int iM6973getYimpl2 = i10 - IntOffset.m6973getYimpl(jM6989roundk4lQ0M2);
            int i11 = iM6973getYimpl2 >= 0 ? iM6973getYimpl2 : 0;
            if (iM6972getXimpl != 0 || i != 0 || iM6972getXimpl2 != 0 || i11 != 0) {
                int i12 = iM6972getXimpl;
                int i13 = iM6972getXimpl2;
                return new WindowInsetsAnimationCompat.BoundsCompat(inset(bounds.getLowerBound(), i12, i, i13, i11), inset(bounds.getUpperBound(), i12, i, i13, i11));
            }
        }
        return bounds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowInsetsCompat insetToLayoutPosition(WindowInsetsCompat insets) {
        if (insets.hasInsets()) {
            NodeCoordinator innerCoordinator$ui_release = this.layoutNode.getInnerCoordinator$ui_release();
            if (innerCoordinator$ui_release.isAttached()) {
                long jM6989roundk4lQ0M = IntOffsetKt.m6989roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(innerCoordinator$ui_release));
                int iM6972getXimpl = IntOffset.m6972getXimpl(jM6989roundk4lQ0M);
                if (iM6972getXimpl < 0) {
                    iM6972getXimpl = 0;
                }
                int iM6973getYimpl = IntOffset.m6973getYimpl(jM6989roundk4lQ0M);
                if (iM6973getYimpl < 0) {
                    iM6973getYimpl = 0;
                }
                long jMo5557getSizeYbymL2g = LayoutCoordinatesKt.findRootCoordinates(innerCoordinator$ui_release).mo5557getSizeYbymL2g();
                int i = (int) (jMo5557getSizeYbymL2g >> 32);
                int i6 = (int) (jMo5557getSizeYbymL2g & 4294967295L);
                long jMo5557getSizeYbymL2g2 = innerCoordinator$ui_release.mo5557getSizeYbymL2g();
                long jM6989roundk4lQ0M2 = IntOffsetKt.m6989roundk4lQ0M(innerCoordinator$ui_release.mo5560localToRootMKHz9U(Offset.m3887constructorimpl((4294967295L & Float.floatToRawIntBits((int) (jMo5557getSizeYbymL2g2 & 4294967295L))) | (Float.floatToRawIntBits((int) (jMo5557getSizeYbymL2g2 >> 32)) << 32))));
                int iM6972getXimpl2 = i - IntOffset.m6972getXimpl(jM6989roundk4lQ0M2);
                if (iM6972getXimpl2 < 0) {
                    iM6972getXimpl2 = 0;
                }
                int iM6973getYimpl2 = i6 - IntOffset.m6973getYimpl(jM6989roundk4lQ0M2);
                int i10 = iM6973getYimpl2 >= 0 ? iM6973getYimpl2 : 0;
                if (iM6972getXimpl != 0 || iM6973getYimpl != 0 || iM6972getXimpl2 != 0 || i10 != 0) {
                    return insets.inset(iM6972getXimpl, iM6973getYimpl, iM6972getXimpl2, i10);
                }
            }
        }
        return insets;
    }

    private final <T> T insetValue(T value, p block) {
        NodeCoordinator innerCoordinator$ui_release = this.layoutNode.getInnerCoordinator$ui_release();
        if (innerCoordinator$ui_release.isAttached()) {
            long jM6989roundk4lQ0M = IntOffsetKt.m6989roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(innerCoordinator$ui_release));
            int iM6972getXimpl = IntOffset.m6972getXimpl(jM6989roundk4lQ0M);
            if (iM6972getXimpl < 0) {
                iM6972getXimpl = 0;
            }
            int iM6973getYimpl = IntOffset.m6973getYimpl(jM6989roundk4lQ0M);
            if (iM6973getYimpl < 0) {
                iM6973getYimpl = 0;
            }
            long jMo5557getSizeYbymL2g = LayoutCoordinatesKt.findRootCoordinates(innerCoordinator$ui_release).mo5557getSizeYbymL2g();
            int i = (int) (jMo5557getSizeYbymL2g >> 32);
            int i6 = (int) (jMo5557getSizeYbymL2g & 4294967295L);
            long jMo5557getSizeYbymL2g2 = innerCoordinator$ui_release.mo5557getSizeYbymL2g();
            long jM6989roundk4lQ0M2 = IntOffsetKt.m6989roundk4lQ0M(innerCoordinator$ui_release.mo5560localToRootMKHz9U(Offset.m3887constructorimpl((4294967295L & Float.floatToRawIntBits((int) (jMo5557getSizeYbymL2g2 & 4294967295L))) | (Float.floatToRawIntBits((int) (jMo5557getSizeYbymL2g2 >> 32)) << 32))));
            int iM6972getXimpl2 = i - IntOffset.m6972getXimpl(jM6989roundk4lQ0M2);
            if (iM6972getXimpl2 < 0) {
                iM6972getXimpl2 = 0;
            }
            int iM6973getYimpl2 = i6 - IntOffset.m6973getYimpl(jM6989roundk4lQ0M2);
            int i10 = iM6973getYimpl2 >= 0 ? iM6973getYimpl2 : 0;
            if (iM6972getXimpl != 0 || iM6973getYimpl != 0 || iM6972getXimpl2 != 0 || i10 != 0) {
                return (T) block.invoke(Integer.valueOf(iM6972getXimpl), Integer.valueOf(iM6973getYimpl), Integer.valueOf(iM6972getXimpl2), Integer.valueOf(i10));
            }
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int obtainMeasureSpec(int min, int max, int preferred) {
        return (preferred >= 0 || min == max) ? View.MeasureSpec.makeMeasureSpec(AbstractC1451a.u(preferred, min, max), BasicMeasure.EXACTLY) : (preferred != -2 || max == Integer.MAX_VALUE) ? (preferred != -1 || max == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY) : View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i = iArr[0];
        region.op(i, iArr[1], getWidth() + i, getHeight() + this.location[1], Region.Op.DIFFERENCE);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    public final Density getDensity() {
        return this.density;
    }

    /* renamed from: getInteropView, reason: from getter */
    public final View getView() {
        return this.view;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    /* renamed from: getOnDensityChanged$ui_release, reason: from getter */
    public final k getOnDensityChanged() {
        return this.onDensityChanged;
    }

    /* renamed from: getOnModifierChanged$ui_release, reason: from getter */
    public final k getOnModifierChanged() {
        return this.onModifierChanged;
    }

    /* renamed from: getOnRequestDisallowInterceptTouchEvent$ui_release, reason: from getter */
    public final k getOnRequestDisallowInterceptTouchEvent() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final S7.a getRelease() {
        return this.release;
    }

    public final S7.a getReset() {
        return this.reset;
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final S7.a getUpdate() {
        return this.update;
    }

    public final View getView() {
        return this.view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        super.invalidateChildInParent(location, dirty);
        invalidateOrDefer();
        return null;
    }

    public final void invalidateOrDefer() {
        if (!this.isDrawing) {
            this.layoutNode.invalidateLayer$ui_release();
        } else {
            this.view.postOnAnimation(new a(1, this.runInvalidate));
        }
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttachedToWindow();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v10, WindowInsetsCompat insets) {
        this.insets = new WindowInsetsCompat(insets);
        return insetToLayoutPosition(insets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View child, View target) {
        super.onDescendantInvalidated(child, target);
        invalidateOrDefer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().clear$ui_release(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t9, int r5, int b) {
        this.view.layout(0, 0, r5 - l, b - t9);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
            return;
        }
        if (this.view.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
            return;
        }
        this.view.measure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.lastWidthMeasureSpec = widthMeasureSpec;
        this.lastHeightMeasureSpec = heightMeasureSpec;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        AbstractC1683A.n(this.dispatcher.getCoroutineScope(), null, new AnonymousClass1(consumed, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(velocityX), AndroidViewHolder_androidKt.toComposeVelocity(velocityY)), null), 3);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        AbstractC1683A.n(this.dispatcher.getCoroutineScope(), null, new C07301(VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(velocityX), AndroidViewHolder_androidKt.toComposeVelocity(velocityY)), null), 3);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            float composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dx);
            float composeOffset2 = AndroidViewHolder_androidKt.toComposeOffset(dy);
            long jM5296dispatchPreScrollOzD1aCk = nestedScrollDispatcher.m5296dispatchPreScrollOzD1aCk(Offset.m3887constructorimpl((Float.floatToRawIntBits(composeOffset2) & 4294967295L) | (Float.floatToRawIntBits(composeOffset) << 32)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (jM5296dispatchPreScrollOzD1aCk >> 32)));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (jM5296dispatchPreScrollOzD1aCk & 4294967295L)));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            float composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dxConsumed);
            float composeOffset2 = AndroidViewHolder_androidKt.toComposeOffset(dyConsumed);
            long jM3887constructorimpl = Offset.m3887constructorimpl((Float.floatToRawIntBits(composeOffset2) & 4294967295L) | (Float.floatToRawIntBits(composeOffset) << 32));
            float composeOffset3 = AndroidViewHolder_androidKt.toComposeOffset(dxUnconsumed);
            float composeOffset4 = AndroidViewHolder_androidKt.toComposeOffset(dyUnconsumed);
            long jM5294dispatchPostScrollDzOQY0M = nestedScrollDispatcher.m5294dispatchPostScrollDzOQY0M(jM3887constructorimpl, Offset.m3887constructorimpl((Float.floatToRawIntBits(composeOffset4) & 4294967295L) | (Float.floatToRawIntBits(composeOffset3) << 32)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (jM5294dispatchPostScrollDzOQY0M >> 32)));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (jM5294dispatchPostScrollDzOQY0M & 4294967295L)));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        this.release.invoke();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (this.view.getParent() != this) {
            addView(this.view);
        } else {
            this.reset.invoke();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        return ((axes & 2) == 0 && (axes & 1) == 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View target, int type) {
        this.nestedScrollingParentHelper.onStopNestedScroll(target, type);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }

    public final void remeasure() {
        int i;
        int i6 = this.lastWidthMeasureSpec;
        if (i6 == Integer.MIN_VALUE || (i = this.lastHeightMeasureSpec) == Integer.MIN_VALUE) {
            return;
        }
        measure(i6, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        k kVar = this.onRequestDisallowInterceptTouchEvent;
        if (kVar != null) {
            kVar.invoke(Boolean.valueOf(disallowIntercept));
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    public final void setDensity(Density density) {
        if (density != this.density) {
            this.density = density;
            k kVar = this.onDensityChanged;
            if (kVar != null) {
                kVar.invoke(density);
            }
        }
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            C0764ViewTreeLifecycleOwner.set(this, lifecycleOwner);
        }
    }

    public final void setModifier(Modifier modifier) {
        if (modifier != this.modifier) {
            this.modifier = modifier;
            k kVar = this.onModifierChanged;
            if (kVar != null) {
                kVar.invoke(modifier);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(k kVar) {
        this.onDensityChanged = kVar;
    }

    public final void setOnModifierChanged$ui_release(k kVar) {
        this.onModifierChanged = kVar;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(k kVar) {
        this.onRequestDisallowInterceptTouchEvent = kVar;
    }

    public final void setRelease(S7.a aVar) {
        this.release = aVar;
    }

    public final void setReset(S7.a aVar) {
        this.reset = aVar;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            C0812ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner);
        }
    }

    public final void setUpdate(S7.a aVar) {
        this.update = aVar;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            float composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dxConsumed);
            float composeOffset2 = AndroidViewHolder_androidKt.toComposeOffset(dyConsumed);
            long jM3887constructorimpl = Offset.m3887constructorimpl((Float.floatToRawIntBits(composeOffset2) & 4294967295L) | (Float.floatToRawIntBits(composeOffset) << 32));
            float composeOffset3 = AndroidViewHolder_androidKt.toComposeOffset(dxUnconsumed);
            float composeOffset4 = AndroidViewHolder_androidKt.toComposeOffset(dyUnconsumed);
            nestedScrollDispatcher.m5294dispatchPostScrollDzOQY0M(jM3887constructorimpl, Offset.m3887constructorimpl((Float.floatToRawIntBits(composeOffset4) & 4294967295L) | (Float.floatToRawIntBits(composeOffset3) << 32)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
        }
    }
}
