package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.a;
import S7.n;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import ca.AbstractC0897f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.CoroutineStart;
import m9.AbstractC1683A;
import m9.C1718k;
import m9.C1732y;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;
import m9.c0;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001TB)\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\"\u0010 \u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010$\u001a\u00020\t*\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\"\u0010(\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001f\u0010-\u001a\u00020**\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020**\u00020.2\u0006\u0010)\u001a\u00020.H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010,J\u0017\u00101\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016¢\u0006\u0004\b1\u00102J \u00104\u001a\u00020\u00142\u000e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001103H\u0096@¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b8\u00109J\u001a\u0010<\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b:\u0010;J'\u0010=\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b=\u0010>R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010?R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010@R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010AR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010BR\u001a\u0010C\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\bC\u0010A\u001a\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010AR*\u0010O\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u001c8\u0000@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010A\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006U"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "scrollingLogic", "", "reverseDirection", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "bringIntoViewSpec", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollingLogic;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "requireBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "Landroidx/compose/ui/geometry/Rect;", "getFocusedChildBounds", "()Landroidx/compose/ui/geometry/Rect;", "LC7/r;", "launchAnimation", "()V", "", "calculateScrollDelta", "(Landroidx/compose/foundation/gestures/BringIntoViewSpec;)F", "findBringIntoViewRequest", "childBounds", "Landroidx/compose/ui/unit/IntSize;", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "computeDestination", "size", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "isMaxVisible", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "relocationOffset", "other", "", "compareTo-TemP2vQ", "(JJ)I", "compareTo", "Landroidx/compose/ui/geometry/Size;", "compareTo-iLBOSCw", "localRect", "calculateRectForParent", "(Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "Lkotlin/Function0;", "bringChildIntoView", "(LS7/a;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "newBounds", "onFocusBoundsChanged", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "onRemeasured-ozmzZPI", "(J)V", "onRemeasured", "update", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "Landroidx/compose/foundation/gestures/Orientation;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "Z", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "focusedChild", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "trackingFocusedChild", "<set-?>", "viewportSize", "J", "getViewportSize-YbymL2g$foundation_release", "()J", "isAnimationRunning", "Request", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private BringIntoViewSpec bringIntoViewSpec;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    private boolean isAnimationRunning;
    private Orientation orientation;
    private boolean reverseDirection;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    private boolean trackingFocusedChild;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
    private long viewportSize = IntSize.INSTANCE.m7020getZeroYbymL2g();

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "currentBounds", "Lm9/j;", "LC7/r;", "continuation", AppAgent.CONSTRUCT, "(LS7/a;Lm9/j;)V", "", "toString", "()Ljava/lang/String;", "LS7/a;", "getCurrentBounds", "()LS7/a;", "Lm9/j;", "getContinuation", "()Lm9/j;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Request {
        public static final int $stable = 8;
        private final InterfaceC1717j continuation;
        private final a currentBounds;

        public Request(a aVar, InterfaceC1717j interfaceC1717j) {
            this.currentBounds = aVar;
            this.continuation = interfaceC1717j;
        }

        public final InterfaceC1717j getContinuation() {
            return this.continuation;
        }

        public final a getCurrentBounds() {
            return this.currentBounds;
        }

        public String toString() {
            String strM;
            C1732y c1732y = (C1732y) this.continuation.getContext().get(C1732y.b);
            String str = c1732y != null ? c1732y.f5339a : null;
            StringBuilder sb = new StringBuilder("Request@");
            int iHashCode = hashCode();
            AbstractC0897f.r(16);
            String string = Integer.toString(iHashCode, 16);
            k.e(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            if (str == null || (strM = B7.a.m("[", str, "](")) == null) {
                strM = "(";
            }
            sb.append(strM);
            sb.append("currentBounds()=");
            sb.append(this.currentBounds.invoke());
            sb.append(", continuation=");
            sb.append(this.continuation);
            sb.append(')');
            return sb.toString();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @c(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", l = {196}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ UpdatableAnimationState $animationState;
        final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", l = {ComposerKt.providerKey}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/NestedScrollScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/NestedScrollScope;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ c0 $animationJob;
            final /* synthetic */ UpdatableAnimationState $animationState;
            final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContentInViewNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, c0 c0Var, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$animationState = updatableAnimationState;
                this.this$0 = contentInViewNode;
                this.$bringIntoViewSpec = bringIntoViewSpec;
                this.$animationJob = c0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.$animationJob, cVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // S7.n
            public final Object invoke(NestedScrollScope nestedScrollScope, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(nestedScrollScope, cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
                    this.$animationState.setValue(this.this$0.calculateScrollDelta(this.$bringIntoViewSpec));
                    final UpdatableAnimationState updatableAnimationState = this.$animationState;
                    final ContentInViewNode contentInViewNode = this.this$0;
                    final c0 c0Var = this.$animationJob;
                    S7.k kVar = new S7.k() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke(((Number) obj2).floatValue());
                            return r.f317a;
                        }

                        public final void invoke(float f) {
                            float f7 = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
                            ScrollingLogic scrollingLogic = contentInViewNode.scrollingLogic;
                            float fM517toFloatk4lQ0M = scrollingLogic.m517toFloatk4lQ0M(scrollingLogic.m515reverseIfNeededMKHz9U(nestedScrollScope.mo472scrollByOzD1aCk(scrollingLogic.m515reverseIfNeededMKHz9U(scrollingLogic.m518toOffsettuRUvjQ(f7 * f)), NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI()))) * f7;
                            if (Math.abs(fM517toFloatk4lQ0M) < Math.abs(f)) {
                                c0 c0Var2 = c0Var;
                                CancellationException cancellationException = new CancellationException("Scroll animation cancelled because scroll was not consumed (" + fM517toFloatk4lQ0M + " < " + f + ')');
                                cancellationException.initCause(null);
                                c0Var2.cancel(cancellationException);
                            }
                        }
                    };
                    final ContentInViewNode contentInViewNode2 = this.this$0;
                    final UpdatableAnimationState updatableAnimationState2 = this.$animationState;
                    final BringIntoViewSpec bringIntoViewSpec = this.$bringIntoViewSpec;
                    a aVar = new a() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // S7.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m410invoke();
                            return r.f317a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m410invoke() {
                            BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = contentInViewNode2.bringIntoViewRequests;
                            ContentInViewNode contentInViewNode3 = contentInViewNode2;
                            while (true) {
                                if (!bringIntoViewRequestPriorityQueue.requests.isNotEmpty()) {
                                    break;
                                }
                                Rect rect = (Rect) ((Request) bringIntoViewRequestPriorityQueue.requests.last()).getCurrentBounds().invoke();
                                if (!(rect == null ? true : ContentInViewNode.m407isMaxVisibleO0kMr_c$default(contentInViewNode3, rect, 0L, 1, null))) {
                                    break;
                                } else {
                                    ((Request) bringIntoViewRequestPriorityQueue.requests.removeAt(bringIntoViewRequestPriorityQueue.requests.getSize() - 1)).getContinuation().resumeWith(r.f317a);
                                }
                            }
                            if (contentInViewNode2.trackingFocusedChild) {
                                Rect focusedChildBounds = contentInViewNode2.getFocusedChildBounds();
                                if (focusedChildBounds != null && ContentInViewNode.m407isMaxVisibleO0kMr_c$default(contentInViewNode2, focusedChildBounds, 0L, 1, null)) {
                                    contentInViewNode2.trackingFocusedChild = false;
                                }
                            }
                            updatableAnimationState2.setValue(contentInViewNode2.calculateScrollDelta(bringIntoViewSpec));
                        }
                    };
                    this.label = 1;
                    if (updatableAnimationState.animateToZero(kVar, aVar, this) == coroutineSingletons) {
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$animationState = updatableAnimationState;
            this.$bringIntoViewSpec = bringIntoViewSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = ContentInViewNode.this.new AnonymousClass2(this.$animationState, this.$bringIntoViewSpec, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            CancellationException cancellationException = null;
            try {
                try {
                    if (i == 0) {
                        b.b(obj);
                        c0 c0VarI = kotlinx.coroutines.a.i(((InterfaceC1733z) this.L$0).getCoroutineContext());
                        ContentInViewNode.this.isAnimationRunning = true;
                        ScrollingLogic scrollingLogic = ContentInViewNode.this.scrollingLogic;
                        MutatePriority mutatePriority = MutatePriority.Default;
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, ContentInViewNode.this, this.$bringIntoViewSpec, c0VarI, null);
                        this.label = 1;
                        if (scrollingLogic.scroll(mutatePriority, anonymousClass1, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        b.b(obj);
                    }
                    ContentInViewNode.this.bringIntoViewRequests.resumeAndRemoveAll();
                    ContentInViewNode.this.isAnimationRunning = false;
                    ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(null);
                    ContentInViewNode.this.trackingFocusedChild = false;
                    return r.f317a;
                } catch (CancellationException e) {
                    cancellationException = e;
                    throw cancellationException;
                }
            } catch (Throwable th) {
                ContentInViewNode.this.isAnimationRunning = false;
                ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                ContentInViewNode.this.trackingFocusedChild = false;
                throw th;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public ContentInViewNode(Orientation orientation, ScrollingLogic scrollingLogic, boolean z10, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.scrollingLogic = scrollingLogic;
        this.reverseDirection = z10;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float calculateScrollDelta(BringIntoViewSpec bringIntoViewSpec) {
        if (IntSize.m7013equalsimpl0(this.viewportSize, IntSize.INSTANCE.m7020getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect rectFindBringIntoViewRequest = findBringIntoViewRequest();
        if (rectFindBringIntoViewRequest == null) {
            rectFindBringIntoViewRequest = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (rectFindBringIntoViewRequest == null) {
                return 0.0f;
            }
        }
        long jM7027toSizeozmzZPI = IntSizeKt.m7027toSizeozmzZPI(this.viewportSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return bringIntoViewSpec.calculateScrollDistance(rectFindBringIntoViewRequest.getTop(), rectFindBringIntoViewRequest.getBottom() - rectFindBringIntoViewRequest.getTop(), Size.m3961getHeightimpl(jM7027toSizeozmzZPI));
        }
        if (i == 2) {
            return bringIntoViewSpec.calculateScrollDistance(rectFindBringIntoViewRequest.getLeft(), rectFindBringIntoViewRequest.getRight() - rectFindBringIntoViewRequest.getLeft(), Size.m3964getWidthimpl(jM7027toSizeozmzZPI));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: compareTo-TemP2vQ, reason: not valid java name */
    private final int m403compareToTemP2vQ(long j5, long j6) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return k.g(IntSize.m7014getHeightimpl(j5), IntSize.m7014getHeightimpl(j6));
        }
        if (i == 2) {
            return k.g(IntSize.m7015getWidthimpl(j5), IntSize.m7015getWidthimpl(j6));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: compareTo-iLBOSCw, reason: not valid java name */
    private final int m404compareToiLBOSCw(long j5, long j6) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return Float.compare(Size.m3961getHeightimpl(j5), Size.m3961getHeightimpl(j6));
        }
        if (i == 2) {
            return Float.compare(Size.m3964getWidthimpl(j5), Size.m3964getWidthimpl(j6));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m405computeDestinationO0kMr_c(Rect childBounds, long containerSize) {
        return childBounds.m3932translatek4lQ0M(Offset.m3904unaryMinusF1C5BW0(m408relocationOffsetBMxPBkI(childBounds, containerSize)));
    }

    private final Rect findBringIntoViewRequest() {
        MutableVector mutableVector = this.bringIntoViewRequests.requests;
        int size = mutableVector.getSize();
        Rect rect = null;
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                Rect rect2 = (Rect) ((Request) content[i]).getCurrentBounds().invoke();
                if (rect2 != null) {
                    if (m404compareToiLBOSCw(rect2.m3928getSizeNHjbRc(), IntSizeKt.m7027toSizeozmzZPI(this.viewportSize)) > 0) {
                        return rect == null ? rect2 : rect;
                    }
                    rect = rect2;
                }
                i--;
            } while (i >= 0);
        }
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getFocusedChildBounds() {
        if (!getIsAttached()) {
            return null;
        }
        LayoutCoordinates layoutCoordinatesRequireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(this);
        LayoutCoordinates layoutCoordinates = this.focusedChild;
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached()) {
                layoutCoordinates = null;
            }
            if (layoutCoordinates != null) {
                return layoutCoordinatesRequireLayoutCoordinates.localBoundingBoxOf(layoutCoordinates, false);
            }
        }
        return null;
    }

    /* renamed from: isMaxVisible-O0kMr_c, reason: not valid java name */
    private final boolean m406isMaxVisibleO0kMr_c(Rect rect, long j5) {
        long jM408relocationOffsetBMxPBkI = m408relocationOffsetBMxPBkI(rect, j5);
        return Math.abs(Offset.m3895getXimpl(jM408relocationOffsetBMxPBkI)) <= 0.5f && Math.abs(Offset.m3896getYimpl(jM408relocationOffsetBMxPBkI)) <= 0.5f;
    }

    /* renamed from: isMaxVisible-O0kMr_c$default, reason: not valid java name */
    public static /* synthetic */ boolean m407isMaxVisibleO0kMr_c$default(ContentInViewNode contentInViewNode, Rect rect, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = contentInViewNode.viewportSize;
        }
        return contentInViewNode.m406isMaxVisibleO0kMr_c(rect, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchAnimation() {
        BringIntoViewSpec bringIntoViewSpecRequireBringIntoViewSpec = requireBringIntoViewSpec();
        if (this.isAnimationRunning) {
            throw new IllegalStateException("launchAnimation called when previous animation was running");
        }
        UpdatableAnimationState updatableAnimationState = new UpdatableAnimationState(bringIntoViewSpecRequireBringIntoViewSpec.getScrollAnimationSpec());
        InterfaceC1733z coroutineScope = getCoroutineScope();
        CoroutineStart coroutineStart = CoroutineStart.f5175a;
        AbstractC1683A.n(coroutineScope, null, new AnonymousClass2(updatableAnimationState, bringIntoViewSpecRequireBringIntoViewSpec, null), 1);
    }

    /* renamed from: relocationOffset-BMxPBkI, reason: not valid java name */
    private final long m408relocationOffsetBMxPBkI(Rect childBounds, long containerSize) {
        long jM7027toSizeozmzZPI = IntSizeKt.m7027toSizeozmzZPI(containerSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return OffsetKt.Offset(0.0f, requireBringIntoViewSpec().calculateScrollDistance(childBounds.getTop(), childBounds.getBottom() - childBounds.getTop(), Size.m3961getHeightimpl(jM7027toSizeozmzZPI)));
        }
        if (i == 2) {
            return OffsetKt.Offset(requireBringIntoViewSpec().calculateScrollDistance(childBounds.getLeft(), childBounds.getRight() - childBounds.getLeft(), Size.m3964getWidthimpl(jM7027toSizeozmzZPI)), 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final BringIntoViewSpec requireBringIntoViewSpec() {
        BringIntoViewSpec bringIntoViewSpec = this.bringIntoViewSpec;
        return bringIntoViewSpec == null ? (BringIntoViewSpec) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec()) : bringIntoViewSpec;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(a aVar, H7.c<? super r> cVar) {
        Rect rect = (Rect) aVar.invoke();
        if (rect != null && !m407isMaxVisibleO0kMr_c$default(this, rect, 0L, 1, null)) {
            C1718k c1718k = new C1718k(1, U7.a.I(cVar));
            c1718k.y();
            if (this.bringIntoViewRequests.enqueue(new Request(aVar, c1718k)) && !this.isAnimationRunning) {
                launchAnimation();
            }
            Object objX = c1718k.x();
            if (objX == CoroutineSingletons.f4909a) {
                return objX;
            }
        }
        return r.f317a;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        if (IntSize.m7013equalsimpl0(this.viewportSize, IntSize.INSTANCE.m7020getZeroYbymL2g())) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
        }
        return m405computeDestinationO0kMr_c(localRect, this.viewportSize);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* renamed from: getViewportSize-YbymL2g$foundation_release, reason: not valid java name and from getter */
    public final long getViewportSize() {
        return this.viewportSize;
    }

    public final void onFocusBoundsChanged(LayoutCoordinates newBounds) {
        this.focusedChild = newBounds;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo371onRemeasuredozmzZPI(long size) {
        Rect focusedChildBounds;
        long j5 = this.viewportSize;
        this.viewportSize = size;
        if (m403compareToTemP2vQ(size, j5) < 0 && (focusedChildBounds = getFocusedChildBounds()) != null) {
            Rect rect = this.focusedChildBoundsFromPreviousRemeasure;
            if (rect == null) {
                rect = focusedChildBounds;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m406isMaxVisibleO0kMr_c(rect, j5) && !m406isMaxVisibleO0kMr_c(focusedChildBounds, size)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChildBounds;
        }
    }

    public final void update(Orientation orientation, boolean reverseDirection, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }
}
