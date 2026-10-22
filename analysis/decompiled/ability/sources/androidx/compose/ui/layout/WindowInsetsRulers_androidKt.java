package androidx.compose.ui.layout;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.WindowInsetsRulers;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.NodeKindKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u001a\u001a\u00020\u0017*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\"\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementScope", "", "Landroidx/compose/ui/layout/RectRulers;", "findDisplayCutouts", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Ljava/util/List;", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "windowInsetsRulers", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "findInsetsAnimationProperties", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/ui/layout/WindowInsetsRulers;)Landroidx/compose/ui/layout/WindowInsetsAnimation;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/InsetsListener;", "insetsListener", "applyWindowInsetsRulers", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/InsetsListener;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "Landroidx/compose/ui/layout/ValueInsets;", "insets", "", "width", "height", "LC7/r;", "provideInsetsValues-cytEWk0", "(Landroidx/compose/ui/layout/RulerScope;Landroidx/compose/ui/layout/RectRulers;JII)V", "provideInsetsValues", "", "RulerKey", "Ljava/lang/String;", "Landroidx/collection/IntObjectMap;", "WindowInsetsTypeMap", "Landroidx/collection/IntObjectMap;", "", "AnimatableInsetsRulers", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "Landroidx/collection/MutableIntObjectMap;", "AnimatableRulers", "Landroidx/collection/MutableIntObjectMap;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WindowInsetsRulers_androidKt {
    private static final WindowInsetsRulers[] AnimatableInsetsRulers;
    private static final MutableIntObjectMap<WindowInsetsRulers> AnimatableRulers;
    private static final String RulerKey = "androidx.compose.ui.layout.WindowInsetsRulers";
    private static final IntObjectMap<WindowInsetsRulers> WindowInsetsTypeMap;

    static {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(8);
        int iStatusBars = WindowInsetsCompat.Type.statusBars();
        WindowInsetsRulers.Companion companion = WindowInsetsRulers.INSTANCE;
        mutableIntObjectMap.set(iStatusBars, companion.getStatusBars());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.navigationBars(), companion.getNavigationBars());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.captionBar(), companion.getCaptionBar());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.ime(), companion.getIme());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.systemGestures(), companion.getSystemGestures());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.mandatorySystemGestures(), companion.getMandatorySystemGestures());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.tappableElement(), companion.getTappableElement());
        WindowInsetsTypeMap = mutableIntObjectMap;
        AnimatableInsetsRulers = new WindowInsetsRulers[]{companion.getStatusBars(), companion.getNavigationBars(), companion.getCaptionBar(), companion.getTappableElement(), companion.getSystemGestures(), companion.getMandatorySystemGestures(), companion.getIme(), companion.getWaterfall(), companion.getDisplayCutout()};
        MutableIntObjectMap<WindowInsetsRulers> mutableIntObjectMap2 = new MutableIntObjectMap<>(7);
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.statusBars(), companion.getStatusBars());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.navigationBars(), companion.getNavigationBars());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.captionBar(), companion.getCaptionBar());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.systemGestures(), companion.getSystemGestures());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.tappableElement(), companion.getTappableElement());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.mandatorySystemGestures(), companion.getMandatorySystemGestures());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.ime(), companion.getIme());
        AnimatableRulers = mutableIntObjectMap2;
    }

    public static final Modifier applyWindowInsetsRulers(Modifier modifier, InsetsListener insetsListener) {
        return modifier.then(new RulerProviderModifierElement(insetsListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    public static final List<RectRulers> findDisplayCutouts(Placeable.PlacementScope placementScope) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = coordinates != null ? LayoutCoordinatesKt.findRootCoordinates(coordinates) : null;
        for (NodeCoordinator wrapped = layoutCoordinatesFindRootCoordinates instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinatesFindRootCoordinates : null; wrapped != null; wrapped = wrapped.getWrapped()) {
            int iM5862constructorimpl = NodeKind.m5862constructorimpl(262144);
            boolean zM5871getIncludeSelfInTraversalH91voCI = NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(iM5862constructorimpl);
            Modifier.Node tail = wrapped.getTail();
            if (zM5871getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
                for (Modifier.Node nodeHeadNode = wrapped.headNode(zM5871getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM5862constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                    if ((nodeHeadNode.getKindSet() & iM5862constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        DelegatingNode delegatingNodePop = nodeHeadNode;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNodePop;
                                if (traversableNode.getTraverseKey() == RulerKey) {
                                    return ((RulerProviderModifierNode) traversableNode).getCutoutRulers();
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                mutableVector.add(delegatingNodePop);
                                                delegatingNodePop = 0;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (nodeHeadNode != tail) {
                    }
                }
            }
        }
        return EmptyList.f4893a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    public static final WindowInsetsAnimation findInsetsAnimationProperties(Placeable.PlacementScope placementScope, WindowInsetsRulers windowInsetsRulers) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = coordinates != null ? LayoutCoordinatesKt.findRootCoordinates(coordinates) : null;
        for (NodeCoordinator wrapped = layoutCoordinatesFindRootCoordinates instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinatesFindRootCoordinates : null; wrapped != null; wrapped = wrapped.getWrapped()) {
            int iM5862constructorimpl = NodeKind.m5862constructorimpl(262144);
            boolean zM5871getIncludeSelfInTraversalH91voCI = NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(iM5862constructorimpl);
            Modifier.Node tail = wrapped.getTail();
            if (zM5871getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
                for (Modifier.Node nodeHeadNode = wrapped.headNode(zM5871getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM5862constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                    if ((nodeHeadNode.getKindSet() & iM5862constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        DelegatingNode delegatingNodePop = nodeHeadNode;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNodePop;
                                if (traversableNode.getTraverseKey() == RulerKey) {
                                    WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = ((RulerProviderModifierNode) traversableNode).getInsetsValues().get(windowInsetsRulers);
                                    return windowWindowInsetsAnimationValues != null ? windowWindowInsetsAnimationValues : NoWindowInsetsAnimation.INSTANCE;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                mutableVector.add(delegatingNodePop);
                                                delegatingNodePop = 0;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (nodeHeadNode != tail) {
                    }
                }
            }
        }
        return NoWindowInsetsAnimation.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: provideInsetsValues-cytEWk0, reason: not valid java name */
    public static final void m5672provideInsetsValuescytEWk0(RulerScope rulerScope, RectRulers rectRulers, long j5, int i, int i6) {
        if (ValueInsets.m5663equalsimpl0(j5, ValueInsets_androidKt.getUnsetValueInsets())) {
            return;
        }
        rulerScope.provides(rectRulers.getLeft(), (int) ((j5 >>> 48) & 65535));
        rulerScope.provides(rectRulers.getTop(), (int) ((j5 >>> 32) & 65535));
        rulerScope.provides(rectRulers.getRight(), i - ((int) ((j5 >>> 16) & 65535)));
        rulerScope.provides(rectRulers.getBottom(), i6 - ((int) (j5 & 65535)));
    }
}
