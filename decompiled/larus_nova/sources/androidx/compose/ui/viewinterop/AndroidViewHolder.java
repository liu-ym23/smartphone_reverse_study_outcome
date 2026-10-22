package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttm.player.MediaPlayer;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u0000 ´\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002´\u0001B9\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0016\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0017J\b\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020\u001aH\u0016J\b\u0010d\u001a\u00020\u001aH\u0016J\b\u0010e\u001a\u00020\u001aH\u0016J\u0018\u0010f\u001a\u00020\u001a2\u0006\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u000bH\u0014J\u0006\u0010i\u001a\u00020\u001aJ0\u0010j\u001a\u00020\u001a2\u0006\u0010k\u001a\u00020!2\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020\u000bH\u0014J\n\u0010p\u001a\u0004\u0018\u00010qH\u0016J\u0010\u0010r\u001a\u00020\u001a2\u0006\u0010s\u001a\u00020!H\u0016J\b\u0010t\u001a\u00020\u001aH\u0014J\b\u0010u\u001a\u00020\u001aH\u0014J\u001e\u0010v\u001a\u0004\u0018\u00010w2\b\u0010Y\u001a\u0004\u0018\u00010J2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J\u0018\u0010z\u001a\u00020\u001a2\u0006\u0010{\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\u000fH\u0016J\u0006\u0010}\u001a\u00020\u001aJ\u0010\u0010~\u001a\u00020\u001a2\u0006\u0010\u007f\u001a\u00020\u000bH\u0014J\u0015\u0010\u0080\u0001\u001a\u00020!2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J$\u0010\u0087\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000b2\u0007\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010\u008a\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u008b\u0001\u001a\u00020!H\u0016J+\u0010\u008c\u0001\u001a\u00020!2\u0006\u0010{\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\u000f2\u0007\u0010\u008d\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u008f\u0001\u001a\u00020\u000bH\u0016J+\u0010\u0090\u0001\u001a\u00020\u001a2\u0006\u0010{\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\u000f2\u0007\u0010\u008d\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000bH\u0016J\u001a\u0010\u0091\u0001\u001a\u00020\u001a2\u0006\u0010|\u001a\u00020\u000f2\u0007\u0010\u008e\u0001\u001a\u00020\u000bH\u0016JG\u0010\u0092\u0001\u001a\u00020\u001a2\u0006\u0010|\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u000b2\u0007\u0010\u0096\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000b2\u0007\u0010\u0097\u0001\u001a\u00020JH\u0016J>\u0010\u0092\u0001\u001a\u00020\u001a2\u0006\u0010|\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u000b2\u0007\u0010\u0096\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000bH\u0016J5\u0010\u0098\u0001\u001a\u00020\u001a2\u0006\u0010|\u001a\u00020\u000f2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\u0007\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010\u0097\u0001\u001a\u00020J2\u0007\u0010\u008e\u0001\u001a\u00020\u000bH\u0016J.\u0010\u009b\u0001\u001a\u00020!2\u0006\u0010|\u001a\u00020\u000f2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u0097\u0001\u001a\u00020!H\u0016J%\u0010\u009f\u0001\u001a\u00020!2\u0006\u0010|\u001a\u00020\u000f2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009d\u0001H\u0016J\t\u0010 \u0001\u001a\u00020!H\u0016J\u001a\u0010¡\u0001\u001a\u00020O2\u0007\u0010¢\u0001\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020OH\u0016J\u0011\u0010£\u0001\u001a\u00020O2\u0006\u0010N\u001a\u00020OH\u0002J\u0014\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010¦\u0001\u001a\u00030¥\u0001H\u0002J\u008e\u0001\u0010§\u0001\u001a\u0003H¨\u0001\"\u0005\b\u0000\u0010¨\u00012\u0007\u0010\u0018\u001a\u0003H¨\u00012k\u0010©\u0001\u001af\u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\b«\u0001\u0012\t\b¬\u0001\u0012\u0004\b\b(l\u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\b«\u0001\u0012\t\b¬\u0001\u0012\u0004\b\b(m\u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\b«\u0001\u0012\t\b¬\u0001\u0012\u0004\b\b(n\u0012\u0015\u0012\u00130\u000b¢\u0006\u000e\b«\u0001\u0012\t\b¬\u0001\u0012\u0004\b\b(o\u0012\u0005\u0012\u0003H¨\u00010ª\u0001H\u0082\b¢\u0006\u0003\u0010\u00ad\u0001J3\u0010®\u0001\u001a\u00030¯\u0001*\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020\u000b2\u0007\u0010±\u0001\u001a\u00020\u000b2\u0007\u0010²\u0001\u001a\u00020\u000b2\u0007\u0010³\u0001\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR0\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR$\u0010)\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020(@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010.\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0002042\u0006\u0010\u0018\u001a\u000204@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010:\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001a\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00101\"\u0004\b<\u00103R(\u0010>\u001a\u0004\u0018\u00010=2\b\u0010\u0018\u001a\u0004\u0018\u00010=@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010D\u001a\u0004\u0018\u00010C2\b\u0010\u0018\u001a\u0004\u0018\u00010C@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u00020Q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010V\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001a\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00101\"\u0004\bX\u00103R\u000e\u0010Y\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0015\u0010\u0083\u0001\u001a\u00030\u0084\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006µ\u0001"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/core/view/OnApplyWindowInsetsListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHash", "", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "view", "Landroid/view/View;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;ILandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroid/view/View;Landroidx/compose/ui/node/Owner;)V", "getView", "()Landroid/view/View;", "getInteropView", "Landroidx/compose/ui/viewinterop/InteropView;", "value", "Lkotlin/Function0;", "", "update", "getUpdate", "()Lkotlin/jvm/functions/Function0;", "setUpdate", "(Lkotlin/jvm/functions/Function0;)V", "hasUpdateBlock", "", BasicTestActionHandler.TEST_ACTION_RESET, "getReset", "setReset", "release", "getRelease", "setRelease", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "onModifierChanged", "Lkotlin/Function1;", "getOnModifierChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnModifierChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "onDensityChanged", "getOnDensityChanged$ui_release", "setOnDensityChanged$ui_release", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "position", "", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "insets", "Landroidx/core/view/WindowInsetsCompat;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "runUpdate", "runInvalidate", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "location", "lastWidthMeasureSpec", "lastHeightMeasureSpec", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "isDrawing", "isValidOwnerScope", "()Z", "getAccessibilityClassName", "", "onReuse", "onDeactivate", "onRelease", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "remeasure", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "requestDisallowInterceptTouchEvent", "disallowIntercept", "onAttachedToWindow", "onDetachedFromWindow", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "onDescendantInvalidated", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, PickerReporterConstants.KEY.TARGET, "invalidateOrDefer", "onWindowVisibilityChanged", RemoteMessageConst.Notification.VISIBILITY, "gatherTransparentRegion", EffectConfiguration.KEY_REGION, "Landroid/graphics/Region;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "obtainMeasureSpec", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "preferred", "shouldDelayChildPressedState", "onStartNestedScroll", "axes", "type", "getNestedScrollAxes", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "consumed", "onNestedPreScroll", "dx", "dy", "onNestedFling", "velocityX", "", "velocityY", "onNestedPreFling", "isNestedScrollingEnabled", "onApplyWindowInsets", BaseSwitches.V, "insetToLayoutPosition", "insetBounds", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "insetValue", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "inset", "Landroidx/core/graphics/Insets;", "left", "top", "right", "bottom", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback, OwnerScope, OnApplyWindowInsetsListener {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Function1<AndroidViewHolder, Unit> OnCommitAffectingUpdate = null;
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
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    private final Owner owner;
    private final int[] position;
    private Function0<Unit> release;
    private Function0<Unit> reset;
    private final Function0<Unit> runInvalidate;
    private final Function0<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private long size;
    private Function0<Unit> update;
    private final View view;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder$Companion;", "", "<init>", "()V", "OnCommitAffectingUpdate", "Lkotlin/Function1;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", i = {}, l = {618, 620}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $consumed;
        final /* synthetic */ long $viewVelocity;
        int label;
        final /* synthetic */ AndroidViewHolder this$0;

        public AnonymousClass1(boolean r100, AndroidViewHolder r101, long r102, Continuation<? super AnonymousClass1> r103) {
            this.$consumed = r100;
            this.this$0 = r101;
            this.$viewVelocity = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$consumed, this.this$0, this.$viewVelocity, r101);
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
        L19:
            ((Velocity) r110).m7795unboximpl();
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
        L15:
            ((Velocity) r110).m7795unboximpl();
            goto L21
        L10:
            ResultKt.throwOnFailure(r110);
            if (this.$consumed == true) goto L16;
            NestedScrollDispatcher r102 = AndroidViewHolder.access$getDispatcher$p(this.this$0);
            long r103 = Velocity.Companion.m7797getZero9UxMQ8M();
            long r104 = this.$viewVelocity;
            this.label = 1;
            r110 = r102.m5999dispatchPostFlingRZ2iAVY(r103, r104, this);
            if (r110 != r100) goto L15;
            return r100;
        L16:
            NestedScrollDispatcher r105 = AndroidViewHolder.access$getDispatcher$p(this.this$0);
            long r106 = this.$viewVelocity;
            long r107 = Velocity.Companion.m7797getZero9UxMQ8M();
            this.label = 2;
            r110 = r105.m5999dispatchPostFlingRZ2iAVY(r106, r107, this);
            if (r110 != r100) goto L19;
            return r100;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1", f = "AndroidViewHolder.android.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class C87721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $toBeConsumed;
        int label;
        final /* synthetic */ AndroidViewHolder this$0;

        public C87721(AndroidViewHolder r100, long r101, Continuation<? super C87721> r102) {
            this.this$0 = r100;
            this.$toBeConsumed = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C87721(this.this$0, this.$toBeConsumed, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C87721) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            NestedScrollDispatcher r103 = AndroidViewHolder.access$getDispatcher$p(this.this$0);
            long r104 = this.$toBeConsumed;
            this.label = 1;
            if (r103.m6001dispatchPreFlingQWom1Mo(r104, this) != r101) goto L12;
            return r101;
        }
    }

    public static /* synthetic */ void b(Function0 r100) {
        invalidateOrDefer$lambda$2(r100);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        return true;
    L5:
        if ((r102 & 1) != 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        OnCommitAffectingUpdate = AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.INSTANCE;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams r100 = this.view.getLayoutParams();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    public final void invalidateOrDefer() {
        if (this.isDrawing == false) goto L5;
        View r100 = this.view;
        final Function0<Unit> r101 = this.runInvalidate;
        r100.postOnAnimation(new a(r101));
        return;
    L5:
        this.layoutNode.invalidateLayer$ui_release();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        this.release.invoke();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (this.view.getParent() == this) goto L5;
        addView(this.view);
        return;
    L5:
        this.reset.invoke();
    }

    public final void remeasure() {
        int r100 = this.lastWidthMeasureSpec;
        if (r100 == Integer.MIN_VALUE) goto L9;
        int r101 = this.lastHeightMeasureSpec;
        if (r101 == Integer.MIN_VALUE) goto L10;
        measure(r100, r101);
        return;
    L10:
        return;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        if (isAttachedToWindow() == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("Expected AndroidViewHolder to be attached when observing reads.");
    L6:
        return this.owner.getSnapshotObserver();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().clear$ui_release(this);
    }

    public static final /* synthetic */ Function1 access$getOnCommitAffectingUpdate$cp() {
        return OnCommitAffectingUpdate;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final View getInteropView() {
        return this.view;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final Function0<Unit> getRelease() {
        return this.release;
    }

    public final Function0<Unit> getReset() {
        return this.reset;
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    public final View getView() {
        return this.view;
    }

    public static final /* synthetic */ NestedScrollDispatcher access$getDispatcher$p(AndroidViewHolder r100) {
        return r100.dispatcher;
    }

    public static final /* synthetic */ boolean access$getHasUpdateBlock$p(AndroidViewHolder r100) {
        return r100.hasUpdateBlock;
    }

    public static final /* synthetic */ WindowInsetsCompat access$getInsets$p(AndroidViewHolder r100) {
        return r100.insets;
    }

    public static final /* synthetic */ Owner access$getOwner$p(AndroidViewHolder r100) {
        return r100.owner;
    }

    public static final /* synthetic */ int[] access$getPosition$p(AndroidViewHolder r100) {
        return r100.position;
    }

    public static final /* synthetic */ Function0 access$getRunUpdate$p(AndroidViewHolder r100) {
        return r100.runUpdate;
    }

    public static final /* synthetic */ long access$getSize$p(AndroidViewHolder r100) {
        return r100.size;
    }

    public static final /* synthetic */ OwnerSnapshotObserver access$getSnapshotObserver(AndroidViewHolder r100) {
        return r100.getSnapshotObserver();
    }

    private final WindowInsetsAnimationCompat.BoundsCompat insetBounds(WindowInsetsAnimationCompat.BoundsCompat r110) {
        NodeCoordinator r100 = this.layoutNode.getInnerCoordinator$ui_release();
        if (r100.isAttached() == false) goto L28;
        long r101 = IntOffsetKt.m7693roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(r100));
        int r102 = IntOffset.m7676getXimpl(r101);
        if (r102 >= 0) goto L8;
        int r103 = 0;
    L9:
        int r104 = IntOffset.m7677getYimpl(r101);
        if (r104 >= 0) goto L12;
        int r105 = 0;
    L13:
        long r106 = LayoutCoordinatesKt.findRootCoordinates(r100).mo6258getSizeYbymL2g();
        int r107 = (int) (r106 >> 32);
        int r108 = (int) (r106 & BodyPartID.bodyIdMax);
        long r111 = r100.mo6258getSizeYbymL2g();
        int r109 = (int) (r111 >> 32);
        float r112 = (int) (r111 & BodyPartID.bodyIdMax);
        long r113 = Float.floatToRawIntBits(r109);
        long r114 = IntOffsetKt.m7693roundk4lQ0M(r100.mo6261localToRootMKHz9U(Offset.m4574constructorimpl((BodyPartID.bodyIdMax & Float.floatToRawIntBits(r112)) | (r113 << 32))));
        int r115 = r107 - IntOffset.m7676getXimpl(r114);
        if (r115 >= 0) goto L16;
        int r116 = 0;
    L17:
        int r117 = r108 - IntOffset.m7677getYimpl(r114);
        if (r117 >= 0) goto L20;
        int r118 = 0;
    L21:
        if (r103 != 0) goto L26;
        if (r105 != 0) goto L26;
        if (r116 != 0) goto L26;
        if (r118 == 0) goto L28;
    L26:
        int r119 = r103;
        int r120 = r105;
        int r121 = r116;
        int r122 = r118;
        return new WindowInsetsAnimationCompat.BoundsCompat(inset(r110.getLowerBound(), r119, r120, r121, r122), inset(r110.getUpperBound(), r119, r120, r121, r122));
    L20:
        r118 = r117;
        goto L21
    L16:
        r116 = r115;
        goto L17
    L12:
        r105 = r104;
        goto L13
    L8:
        r103 = r102;
    L28:
        return r110;
    }

    private final WindowInsetsCompat insetToLayoutPosition(WindowInsetsCompat r110) {
        if (r110.hasInsets() == true) goto L5;
        return r110;
    L5:
        NodeCoordinator r100 = this.layoutNode.getInnerCoordinator$ui_release();
        if (r100.isAttached() == false) goto L28;
        long r101 = IntOffsetKt.m7693roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(r100));
        int r102 = IntOffset.m7676getXimpl(r101);
        if (r102 >= 0) goto L11;
        r102 = 0;
    L11:
        int r103 = IntOffset.m7677getYimpl(r101);
        if (r103 >= 0) goto L14;
        r103 = 0;
    L14:
        long r104 = LayoutCoordinatesKt.findRootCoordinates(r100).mo6258getSizeYbymL2g();
        int r111 = (int) (r104 >> 32);
        int r105 = (int) (r104 & BodyPartID.bodyIdMax);
        long r112 = r100.mo6258getSizeYbymL2g();
        float r106 = (int) (r112 & BodyPartID.bodyIdMax);
        long r113 = Float.floatToRawIntBits((int) (r112 >> 32));
        long r107 = IntOffsetKt.m7693roundk4lQ0M(r100.mo6261localToRootMKHz9U(Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r106)) & BodyPartID.bodyIdMax) | (r113 << 32))));
        int r114 = r111 - IntOffset.m7676getXimpl(r107);
        if (r114 >= 0) goto L17;
        r114 = 0;
    L17:
        int r108 = r105 - IntOffset.m7677getYimpl(r107);
        if (r108 >= 0) goto L20;
        int r109 = 0;
    L21:
        if (r102 != 0) goto L27;
        if (r103 != 0) goto L27;
        if (r114 != 0) goto L27;
        if (r109 != 0) goto L27;
        return r110;
    L27:
        return r110.inset(r102, r103, r114, r109);
    L20:
        r109 = r108;
        goto L21
    L28:
        return r110;
    }

    private static final void invalidateOrDefer$lambda$2(Function0 r100) {
        r100.invoke();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region r110) {
        if (r110 != null) goto L5;
        return true;
    L5:
        getLocationInWindow(this.location);
        int[] r100 = this.location;
        int r101 = r100[0];
        r110.op(r101, r100[1], r101 + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        if (r100 != 0) goto L8;
        this.layoutNode.invalidateLayer$ui_release();
        return;
    L8:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
        Function1<? super Boolean, Unit> r101 = this.onRequestDisallowInterceptTouchEvent;
        if (r101 == null) goto L5;
        r101.invoke(Boolean.valueOf(r100));
    L5:
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public final void setDensity(Density r100) {
        if (r100 == this.density) goto L8;
        this.density = r100;
        Function1<? super Density, Unit> r101 = this.onDensityChanged;
        if (r101 == null) goto L9;
        r101.invoke(r100);
        return;
    L9:
        return;
    }

    public final void setLifecycleOwner(LifecycleOwner r100) {
        if (r100 == this.lifecycleOwner) goto L6;
        this.lifecycleOwner = r100;
        ViewTreeLifecycleOwner.set(this, r100);
        return;
    }

    public final void setModifier(Modifier r100) {
        if (r100 == this.modifier) goto L8;
        this.modifier = r100;
        Function1<? super Modifier, Unit> r101 = this.onModifierChanged;
        if (r101 == null) goto L9;
        r101.invoke(r100);
        return;
    L9:
        return;
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> r100) {
        this.onDensityChanged = r100;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> r100) {
        this.onModifierChanged = r100;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> r100) {
        this.onRequestDisallowInterceptTouchEvent = r100;
    }

    public final void setRelease(Function0<Unit> r100) {
        this.release = r100;
    }

    public final void setReset(Function0<Unit> r100) {
        this.reset = r100;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner r100) {
        if (r100 == this.savedStateRegistryOwner) goto L6;
        this.savedStateRegistryOwner = r100;
        ViewTreeSavedStateRegistryOwner.set(this, r100);
        return;
    }

    public final void setUpdate(Function0<Unit> r100) {
        this.update = r100;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public static final /* synthetic */ WindowInsetsAnimationCompat.BoundsCompat access$insetBounds(AndroidViewHolder r100, WindowInsetsAnimationCompat.BoundsCompat r101) {
        return r100.insetBounds(r101);
    }

    public static final /* synthetic */ WindowInsetsCompat access$insetToLayoutPosition(AndroidViewHolder r100, WindowInsetsCompat r101) {
        return r100.insetToLayoutPosition(r101);
    }

    public static final /* synthetic */ void access$setDrawing$p(AndroidViewHolder r100, boolean r101) {
        r100.isDrawing = r101;
    }

    public static final /* synthetic */ void access$setSize$p(AndroidViewHolder r100, long r101) {
        r100.size = r101;
    }

    private final <T> T insetValue(T r110, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> r111) {
        NodeCoordinator r100 = this.layoutNode.getInnerCoordinator$ui_release();
        if (r100.isAttached() == true) goto L5;
        return r110;
    L5:
        long r101 = IntOffsetKt.m7693roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(r100));
        int r102 = IntOffset.m7676getXimpl(r101);
        int r103 = 0;
        if (r102 >= 0) goto L8;
        r102 = 0;
    L8:
        int r104 = IntOffset.m7677getYimpl(r101);
        if (r104 >= 0) goto L11;
        r104 = 0;
    L11:
        long r105 = LayoutCoordinatesKt.findRootCoordinates(r100).mo6258getSizeYbymL2g();
        int r106 = (int) (r105 >> 32);
        int r107 = (int) (r105 & BodyPartID.bodyIdMax);
        long r112 = r100.mo6258getSizeYbymL2g();
        float r108 = (int) (r112 & BodyPartID.bodyIdMax);
        long r113 = Float.floatToRawIntBits((int) (r112 >> 32));
        long r114 = IntOffsetKt.m7693roundk4lQ0M(r100.mo6261localToRootMKHz9U(Offset.m4574constructorimpl((BodyPartID.bodyIdMax & ((long) Float.floatToRawIntBits(r108))) | (r113 << 32))));
        int r109 = r106 - IntOffset.m7676getXimpl(r114);
        if (r109 >= 0) goto L14;
        r109 = 0;
    L14:
        int r115 = r107 - IntOffset.m7677getYimpl(r114);
        if (r115 < 0) goto L18;
        r103 = r115;
    L18:
        if (r102 != 0) goto L24;
        if (r104 != 0) goto L24;
        if (r109 != 0) goto L24;
        if (r103 != 0) goto L24;
        return r110;
    L24:
        return r111.invoke(Integer.valueOf(r102), Integer.valueOf(r104), Integer.valueOf(r109), Integer.valueOf(r103));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] r100, Rect r101) {
        super.invalidateChildInParent(r100, r101);
        invalidateOrDefer();
        return null;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        this.insets = new WindowInsetsCompat(r101);
        return insetToLayoutPosition(r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View r100, View r101) {
        super.onDescendantInvalidated(r100, r101);
        invalidateOrDefer();
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.view.getParent() == this) goto L7;
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        return;
    L7:
        if (this.view.getVisibility() != 8) goto L10;
        setMeasuredDimension(0, 0);
        return;
    L10:
        this.view.measure(r100, r101);
        setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.lastWidthMeasureSpec = r100;
        this.lastHeightMeasureSpec = r101;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r100, int r101) {
        this.nestedScrollingParentHelper.onStopNestedScroll(r100, r101);
    }

    private final int obtainMeasureSpec(int r100, int r101, int r102) {
        if (r102 >= 0) goto L16;
        if (r100 == r101) goto L16;
        if (r102 != (-2)) goto L11;
        if (r101 == Integer.MAX_VALUE) goto L11;
        return View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE);
    L11:
        if (r102 != (-1)) goto L19;
        if (r101 == Integer.MAX_VALUE) goto L19;
        return View.MeasureSpec.makeMeasureSpec(r101, 1073741824);
    L19:
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    L16:
        return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(r102, r100, r101), 1073741824);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r100, float r101, float r110) {
        if (isNestedScrollingEnabled() == true) goto L5;
        return false;
    L5:
        long r102 = VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(r101), AndroidViewHolder_androidKt.access$toComposeVelocity(r110));
        BuildersKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new C87721(this, r102, null), 3, null);
        return false;
    }

    public static final /* synthetic */ int access$obtainMeasureSpec(AndroidViewHolder r100, int r101, int r102, int r103) {
        return r100.obtainMeasureSpec(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r110, float r111, float r112, boolean r113) {
        if (isNestedScrollingEnabled() == true) goto L5;
        return false;
    L5:
        long r100 = VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(r111), AndroidViewHolder_androidKt.access$toComposeVelocity(r112));
        BuildersKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AnonymousClass1(r113, this, r100, null), 3, null);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    private final Insets inset(Insets r100, int r101, int r102, int r103, int r104) {
        int r105 = r100.left - r101;
        int r106 = 0;
        if (r105 >= 0) goto L5;
        r105 = 0;
    L5:
        int r107 = r100.top - r102;
        if (r107 >= 0) goto L8;
        r107 = 0;
    L8:
        int r108 = r100.right - r103;
        if (r108 >= 0) goto L11;
        r108 = 0;
    L11:
        int r109 = r100.bottom - r104;
        if (r109 < 0) goto L16;
        r106 = r109;
    L16:
        return Insets.of(r105, r107, r108, r106);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        this.view.layout(0, 0, r103 - r101, r104 - r102);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r110) {
        if (isNestedScrollingEnabled() == true) goto L5;
        return;
    L5:
        NestedScrollDispatcher r104 = this.dispatcher;
        float r105 = AndroidViewHolder_androidKt.access$toComposeOffset(r101);
        float r106 = AndroidViewHolder_androidKt.access$toComposeOffset(r102);
        long r107 = Float.floatToRawIntBits(r105);
        long r108 = r104.m6002dispatchPreScrollOzD1aCk(Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r106)) & BodyPartID.bodyIdMax) | (r107 << 32)), AndroidViewHolder_androidKt.access$toNestedScrollSource(r110));
        r103[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r108 >> 32)));
        r103[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r108 & BodyPartID.bodyIdMax)));
    }

    public AndroidViewHolder(Context r100, CompositionContext r101, int r102, NestedScrollDispatcher r103, View r104, Owner r105) {
        super(r100);
        this.compositeKeyHash = r102;
        this.dispatcher = r103;
        this.view = r104;
        this.owner = r105;
        if (r101 == null) goto L5;
        WindowRecomposer_androidKt.setCompositionContext(this, r101);
    L5:
        setSaveFromParentEnabled(false);
        addView(r104);
        ViewCompat.setWindowInsetsAnimationCallback(this, new AnonymousClass2(this));
        ViewCompat.setOnApplyWindowInsetsListener(this, this);
        this.update = AndroidViewHolder$update$1.INSTANCE;
        this.reset = AndroidViewHolder$reset$1.INSTANCE;
        this.release = AndroidViewHolder$release$1.INSTANCE;
        Modifier.Companion r106 = Modifier.Companion;
        this.modifier = r106;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.position = new int[2];
        this.size = IntSize.Companion.m7724getZeroYbymL2g();
        this.runUpdate = new AndroidViewHolder$runUpdate$1(this);
        this.runInvalidate = new AndroidViewHolder$runInvalidate$1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        final LayoutNode r107 = new LayoutNode(false, 0, 3, null);
        r107.setInteropViewFactoryHolder$ui_release(this);
        final Modifier r108 = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(r106, AndroidViewHolder_androidKt.access$getNoOpScrollConnection$p(), r103), true, AndroidViewHolder$layoutNode$1$coreModifier$1.INSTANCE), this), new AndroidViewHolder$layoutNode$1$coreModifier$2(this, r107, this)), new AndroidViewHolder$layoutNode$1$coreModifier$3(this, r107));
        r107.setCompositeKeyHash(r102);
        r107.setModifier(this.modifier.then(r108));
        this.onModifierChanged = new AndroidViewHolder$layoutNode$1$1(r107, r108);
        r107.setDensity(this.density);
        this.onDensityChanged = new AndroidViewHolder$layoutNode$1$2(r107);
        r107.setOnAttach$ui_release(new AndroidViewHolder$layoutNode$1$3(this, r107));
        r107.setOnDetach$ui_release(new AndroidViewHolder$layoutNode$1$4(this));
        r107.setMeasurePolicy(new AndroidViewHolder$layoutNode$1$5(this, r107));
        this.layoutNode = r107;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r100, int r101, int r102, int r110, int r111, int r112) {
        if (isNestedScrollingEnabled() == true) goto L5;
        return;
    L5:
        NestedScrollDispatcher r103 = this.dispatcher;
        float r104 = AndroidViewHolder_androidKt.access$toComposeOffset(r101);
        float r105 = AndroidViewHolder_androidKt.access$toComposeOffset(r102);
        long r106 = Float.floatToRawIntBits(r104);
        long r107 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r105)) & BodyPartID.bodyIdMax) | (r106 << 32));
        float r108 = AndroidViewHolder_androidKt.access$toComposeOffset(r110);
        float r109 = AndroidViewHolder_androidKt.access$toComposeOffset(r111);
        long r113 = Float.floatToRawIntBits(r108);
        r103.m6000dispatchPostScrollDzOQY0M(r107, Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r109)) & BodyPartID.bodyIdMax) | (r113 << 32)), AndroidViewHolder_androidKt.access$toNestedScrollSource(r112));
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r100, int r110, int r111, int r112, int r113, int r114, int[] r115) {
        if (isNestedScrollingEnabled() == true) goto L5;
        return;
    L5:
        NestedScrollDispatcher r101 = this.dispatcher;
        float r102 = AndroidViewHolder_androidKt.access$toComposeOffset(r110);
        float r116 = AndroidViewHolder_androidKt.access$toComposeOffset(r111);
        long r103 = Float.floatToRawIntBits(r102);
        long r104 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r116)) & BodyPartID.bodyIdMax) | (r103 << 32));
        float r105 = AndroidViewHolder_androidKt.access$toComposeOffset(r112);
        float r117 = AndroidViewHolder_androidKt.access$toComposeOffset(r113);
        long r118 = Float.floatToRawIntBits(r105);
        long r106 = r101.m6000dispatchPostScrollDzOQY0M(r104, Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r117)) & BodyPartID.bodyIdMax) | (r118 << 32)), AndroidViewHolder_androidKt.access$toNestedScrollSource(r114));
        r115[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r106 >> 32)));
        r115[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (r106 & BodyPartID.bodyIdMax)));
    }
}
