package androidx.compose.foundation;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0091\u0001\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0088\u0001\u0010\u001d\u001a\u00020\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00102\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010\u001fJ\u0013\u0010#\u001a\u00020\f*\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0013\u0010*\u001a\u00020\f*\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010\u001fJ\u000f\u0010-\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010\u001fJ\u000f\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b.\u0010\u001fR.\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010/\u001a\u0004\b4\u00101\"\u0004\b5\u00103R0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0012\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0014\u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R(\u0010\u0015\u001a\u00020\u00138\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0015\u00108\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010=\u001a\u0004\bK\u0010?\"\u0004\bL\u0010AR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR/\u0010`\u001a\u0004\u0018\u00010%2\b\u0010Z\u001a\u0004\u0018\u00010%8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010(R\u001e\u0010b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010d\u001a\u00020\b8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bd\u0010BR\u001e\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bf\u0010gR\u001e\u0010i\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010l\u001a\u00020\b8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bk\u0010D\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006m"}, d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "sourceCenter", "magnifierCenter", "Landroidx/compose/ui/unit/DpSize;", "LC7/r;", "onSizeChanged", "", "zoom", "", "useTextDefault", "size", "Landroidx/compose/ui/unit/Dp;", "cornerRadius", "elevation", "clippingEnabled", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "platformMagnifierFactory", AppAgent.CONSTRUCT, "(LS7/k;LS7/k;LS7/k;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/e;)V", "update-5F03MCQ", "(LS7/k;LS7/k;FZJFFZLS7/k;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "update", "onAttach", "()V", "onDetach", "onObservedReadsChanged", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "onGloballyPositioned", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "recreateMagnifier", "updateMagnifier", "updateSizeIfNecessary", "LS7/k;", "getSourceCenter", "()LS7/k;", "setSourceCenter", "(LS7/k;)V", "getMagnifierCenter", "setMagnifierCenter", "getOnSizeChanged", "setOnSizeChanged", "F", "getZoom", "()F", "setZoom", "(F)V", "Z", "getUseTextDefault", "()Z", "setUseTextDefault", "(Z)V", "J", "getSize-MYxV2XQ", "()J", "setSize-EaSLcWc", "(J)V", "getCornerRadius-D9Ej5fM", "setCornerRadius-0680j_4", "getElevation-D9Ej5fM", "setElevation-0680j_4", "getClippingEnabled", "setClippingEnabled", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "Landroid/view/View;", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/foundation/PlatformMagnifier;", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "<set-?>", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "layoutCoordinates", "Landroidx/compose/runtime/State;", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "sourceCenterInRoot", "Landroidx/compose/ui/unit/IntSize;", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "Lo9/e;", "drawSignalChannel", "Lo9/e;", "getAnchorPositionInRoot-F1C5BW0", "anchorPositionInRoot", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private State<Offset> anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    private InterfaceC1779e drawSignalChannel;
    private float elevation;

    /* renamed from: layoutCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState layoutCoordinates;
    private PlatformMagnifier magnifier;
    private k magnifierCenter;
    private k onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private k sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;

    @c(c = "androidx.compose.foundation.MagnifierNode$onAttach$1", f = "Magnifier.android.kt", l = {380, 384}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.MagnifierNode$onAttach$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03811 extends SuspendLambda implements n {
        int label;

        public C03811(H7.c<? super C03811> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return MagnifierNode.this.new C03811(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
        
            if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r5, r4) == r0) goto L20;
         */
        /* JADX WARN: Path cross not found for [B:13:0x0027, B:16:0x0030], limit reached: 23 */
        /* JADX WARN: Path cross not found for [B:16:0x0030, B:13:0x0027], limit reached: 23 */
        /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0036 -> B:11:0x001f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0040 -> B:21:0x0043). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.b.b(r5)
                goto L43
            L10:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L18:
                kotlin.b.b(r5)
                goto L30
            L1c:
                kotlin.b.b(r5)
            L1f:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                o9.e r5 = androidx.compose.foundation.MagnifierNode.access$getDrawSignalChannel$p(r5)
                if (r5 == 0) goto L30
                r4.label = r3
                java.lang.Object r5 = r5.u(r4)
                if (r5 != r0) goto L30
                goto L42
            L30:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                androidx.compose.foundation.PlatformMagnifier r5 = androidx.compose.foundation.MagnifierNode.access$getMagnifier$p(r5)
                if (r5 == 0) goto L1f
                androidx.compose.foundation.MagnifierNode$onAttach$1$1 r5 = new S7.k() { // from class: androidx.compose.foundation.MagnifierNode.onAttach.1.1
                    static {
                        /*
                            androidx.compose.foundation.MagnifierNode$onAttach$1$1 r0 = new androidx.compose.foundation.MagnifierNode$onAttach$1$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:androidx.compose.foundation.MagnifierNode$onAttach$1$1) androidx.compose.foundation.MagnifierNode.onAttach.1.1.INSTANCE androidx.compose.foundation.MagnifierNode$onAttach$1$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.C03811.C00111.<clinit>():void");
                    }

                    {
                        /*
                            r1 = this;
                            r0 = 1
                            r1.<init>(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.C03811.C00111.<init>():void");
                    }

                    public final void invoke(long r1) {
                        /*
                            r0 = this;
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.C03811.C00111.invoke(long):void");
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r3) {
                        /*
                            r2 = this;
                            java.lang.Number r3 = (java.lang.Number) r3
                            long r0 = r3.longValue()
                            r2.invoke(r0)
                            C7.r r2 = C7.r.f317a
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.C03811.C00111.invoke(java.lang.Object):java.lang.Object");
                    }
                }
                r4.label = r2
                java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r5, r4)
                if (r5 != r0) goto L43
            L42:
                return r0
            L43:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                androidx.compose.foundation.PlatformMagnifier r5 = androidx.compose.foundation.MagnifierNode.access$getMagnifier$p(r5)
                if (r5 == 0) goto L1f
                r5.updateContent()
                goto L1f
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.C03811.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C03811) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public /* synthetic */ MagnifierNode(k kVar, k kVar2, k kVar3, float f, boolean z10, long j5, float f7, float f9, boolean z11, PlatformMagnifierFactory platformMagnifierFactory, e eVar) {
        this(kVar, kVar2, kVar3, f, z10, j5, f7, f9, z11, platformMagnifierFactory);
    }

    /* renamed from: getAnchorPositionInRoot-F1C5BW0, reason: not valid java name */
    private final long m299getAnchorPositionInRootF1C5BW0() {
        if (this.anchorPositionInRootState == null) {
            this.anchorPositionInRootState = SnapshotStateKt.derivedStateOf(new S7.a() { // from class: androidx.compose.foundation.MagnifierNode$anchorPositionInRoot$1
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.m3884boximpl(m307invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                public final long m307invokeF1C5BW0() {
                    LayoutCoordinates layoutCoordinates = this.this$0.getLayoutCoordinates();
                    return layoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(layoutCoordinates) : Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
                }
            });
        }
        State<Offset> state = this.anchorPositionInRootState;
        return state != null ? state.getValue().m3905unboximpl() : Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getLayoutCoordinates() {
        return (LayoutCoordinates) this.layoutCoordinates.getValue();
    }

    private final void recreateMagnifier() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View viewRequireView = this.view;
        if (viewRequireView == null) {
            viewRequireView = DelegatableNode_androidKt.requireView(this);
        }
        View view = viewRequireView;
        this.view = view;
        Density densityRequireDensity = this.density;
        if (densityRequireDensity == null) {
            densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        }
        Density density = densityRequireDensity;
        this.density = density;
        this.magnifier = this.platformMagnifierFactory.mo334createnHHXs2Y(view, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density, this.zoom);
        updateSizeIfNecessary();
    }

    private final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates.setValue(layoutCoordinates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateMagnifier() {
        /*
            r8 = this;
            androidx.compose.ui.unit.Density r0 = r8.density
            if (r0 != 0) goto La
            androidx.compose.ui.unit.Density r0 = androidx.compose.ui.node.DelegatableNodeKt.requireDensity(r8)
            r8.density = r0
        La:
            S7.k r1 = r8.sourceCenter
            java.lang.Object r1 = r1.invoke(r0)
            androidx.compose.ui.geometry.Offset r1 = (androidx.compose.ui.geometry.Offset) r1
            long r1 = r1.m3905unboximpl()
            boolean r3 = androidx.compose.ui.geometry.OffsetKt.m3914isSpecifiedk4lQ0M(r1)
            if (r3 == 0) goto L7b
            long r3 = r8.m299getAnchorPositionInRootF1C5BW0()
            boolean r3 = androidx.compose.ui.geometry.OffsetKt.m3914isSpecifiedk4lQ0M(r3)
            if (r3 == 0) goto L7b
            long r3 = r8.m299getAnchorPositionInRootF1C5BW0()
            long r1 = androidx.compose.ui.geometry.Offset.m3900plusMKHz9U(r3, r1)
            r8.sourceCenterInRoot = r1
            S7.k r1 = r8.magnifierCenter
            if (r1 == 0) goto L5e
            java.lang.Object r0 = r1.invoke(r0)
            androidx.compose.ui.geometry.Offset r0 = (androidx.compose.ui.geometry.Offset) r0
            long r0 = r0.m3905unboximpl()
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m3884boximpl(r0)
            long r1 = r0.m3905unboximpl()
            boolean r1 = androidx.compose.ui.geometry.OffsetKt.m3914isSpecifiedk4lQ0M(r1)
            if (r1 == 0) goto L4d
            goto L4e
        L4d:
            r0 = 0
        L4e:
            if (r0 == 0) goto L5e
            long r0 = r0.m3905unboximpl()
            long r2 = r8.m299getAnchorPositionInRootF1C5BW0()
            long r0 = androidx.compose.ui.geometry.Offset.m3900plusMKHz9U(r2, r0)
        L5c:
            r5 = r0
            goto L65
        L5e:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r0 = r0.m3910getUnspecifiedF1C5BW0()
            goto L5c
        L65:
            androidx.compose.foundation.PlatformMagnifier r0 = r8.magnifier
            if (r0 != 0) goto L6c
            r8.recreateMagnifier()
        L6c:
            androidx.compose.foundation.PlatformMagnifier r2 = r8.magnifier
            if (r2 == 0) goto L77
            long r3 = r8.sourceCenterInRoot
            float r7 = r8.zoom
            r2.mo333updateWko1d7g(r3, r5, r7)
        L77:
            r8.updateSizeIfNecessary()
            return
        L7b:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r0 = r0.m3910getUnspecifiedF1C5BW0()
            r8.sourceCenterInRoot = r0
            androidx.compose.foundation.PlatformMagnifier r8 = r8.magnifier
            if (r8 == 0) goto L8a
            r8.dismiss()
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.updateMagnifier():void");
    }

    private final void updateSizeIfNecessary() {
        Density density;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier == null || (density = this.density) == null || IntSize.m7012equalsimpl(platformMagnifier.mo332getSizeYbymL2g(), this.previousSize)) {
            return;
        }
        k kVar = this.onSizeChanged;
        if (kVar != null) {
            kVar.invoke(DpSize.m6930boximpl(density.mo379toDpSizekrfVVM(IntSizeKt.m7027toSizeozmzZPI(platformMagnifier.mo332getSizeYbymL2g()))));
        }
        this.previousSize = IntSize.m7007boximpl(platformMagnifier.mo332getSizeYbymL2g());
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new S7.a() { // from class: androidx.compose.foundation.MagnifierNode.applySemantics.1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                return Offset.m3884boximpl(m308invokeF1C5BW0());
            }

            /* renamed from: invoke-F1C5BW0, reason: not valid java name */
            public final long m308invokeF1C5BW0() {
                return MagnifierNode.this.sourceCenterInRoot;
            }
        });
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        InterfaceC1779e interfaceC1779e = this.drawSignalChannel;
        if (interfaceC1779e != null) {
            interfaceC1779e.a(r.f317a);
        }
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    /* renamed from: getCornerRadius-D9Ej5fM, reason: not valid java name and from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getElevation() {
        return this.elevation;
    }

    public final k getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final k getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    /* renamed from: getSize-MYxV2XQ, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    public final k getSourceCenter() {
        return this.sourceCenter;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final float getZoom() {
        return this.zoom;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = Z6.k.b(0, 7, null);
        AbstractC1683A.n(getCoroutineScope(), null, new C03811(null), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.magnifier = null;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        setLayoutCoordinates(coordinates);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new S7.a() { // from class: androidx.compose.foundation.MagnifierNode.onObservedReadsChanged.1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m309invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m309invoke() {
                MagnifierNode.this.updateMagnifier();
            }
        });
    }

    public final void setClippingEnabled(boolean z10) {
        this.clippingEnabled = z10;
    }

    /* renamed from: setCornerRadius-0680j_4, reason: not valid java name */
    public final void m303setCornerRadius0680j_4(float f) {
        this.cornerRadius = f;
    }

    /* renamed from: setElevation-0680j_4, reason: not valid java name */
    public final void m304setElevation0680j_4(float f) {
        this.elevation = f;
    }

    public final void setMagnifierCenter(k kVar) {
        this.magnifierCenter = kVar;
    }

    public final void setOnSizeChanged(k kVar) {
        this.onSizeChanged = kVar;
    }

    public final void setPlatformMagnifierFactory(PlatformMagnifierFactory platformMagnifierFactory) {
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    /* renamed from: setSize-EaSLcWc, reason: not valid java name */
    public final void m305setSizeEaSLcWc(long j5) {
        this.size = j5;
    }

    public final void setSourceCenter(k kVar) {
        this.sourceCenter = kVar;
    }

    public final void setUseTextDefault(boolean z10) {
        this.useTextDefault = z10;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    /* renamed from: update-5F03MCQ, reason: not valid java name */
    public final void m306update5F03MCQ(k sourceCenter, k magnifierCenter, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, k onSizeChanged, PlatformMagnifierFactory platformMagnifierFactory) {
        float f = this.zoom;
        long j5 = this.size;
        float f7 = this.cornerRadius;
        boolean z10 = this.useTextDefault;
        float f9 = this.elevation;
        boolean z11 = this.clippingEnabled;
        PlatformMagnifierFactory platformMagnifierFactory2 = this.platformMagnifierFactory;
        View view = this.view;
        Density density = this.density;
        this.sourceCenter = sourceCenter;
        this.magnifierCenter = magnifierCenter;
        this.zoom = zoom;
        this.useTextDefault = useTextDefault;
        this.size = size;
        this.cornerRadius = cornerRadius;
        this.elevation = elevation;
        this.clippingEnabled = clippingEnabled;
        this.onSizeChanged = onSizeChanged;
        this.platformMagnifierFactory = platformMagnifierFactory;
        View viewRequireView = DelegatableNode_androidKt.requireView(this);
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        if (this.magnifier != null && ((!Magnifier_androidKt.equalsIncludingNaN(zoom, f) && !platformMagnifierFactory.getCanUpdateZoom()) || !DpSize.m6939equalsimpl0(size, j5) || !Dp.m6849equalsimpl0(cornerRadius, f7) || !Dp.m6849equalsimpl0(elevation, f9) || useTextDefault != z10 || clippingEnabled != z11 || !kotlin.jvm.internal.k.b(platformMagnifierFactory, platformMagnifierFactory2) || !kotlin.jvm.internal.k.b(viewRequireView, view) || !kotlin.jvm.internal.k.b(densityRequireDensity, density))) {
            recreateMagnifier();
        }
        updateMagnifier();
    }

    public /* synthetic */ MagnifierNode(k kVar, k kVar2, k kVar3, float f, boolean z10, long j5, float f7, float f9, boolean z11, PlatformMagnifierFactory platformMagnifierFactory, int i, e eVar) {
        this(kVar, (i & 2) != 0 ? null : kVar2, (i & 4) != 0 ? null : kVar3, (i & 8) != 0 ? Float.NaN : f, (i & 16) != 0 ? false : z10, (i & 32) != 0 ? DpSize.INSTANCE.m6951getUnspecifiedMYxV2XQ() : j5, (i & 64) != 0 ? Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM() : f7, (i & 128) != 0 ? Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM() : f9, (i & 256) != 0 ? true : z11, (i & 512) != 0 ? PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform() : platformMagnifierFactory, null);
    }

    private MagnifierNode(k kVar, k kVar2, k kVar3, float f, boolean z10, long j5, float f7, float f9, boolean z11, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = kVar;
        this.magnifierCenter = kVar2;
        this.onSizeChanged = kVar3;
        this.zoom = f;
        this.useTextDefault = z10;
        this.size = j5;
        this.cornerRadius = f7;
        this.elevation = f9;
        this.clippingEnabled = z11;
        this.platformMagnifierFactory = platformMagnifierFactory;
        this.layoutCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
    }
}
