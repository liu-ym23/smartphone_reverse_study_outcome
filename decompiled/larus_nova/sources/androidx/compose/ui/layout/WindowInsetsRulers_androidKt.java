package androidx.compose.ui.layout;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.NodeKindKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a3\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"findDisplayCutouts", "", "Landroidx/compose/ui/layout/RectRulers;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "findInsetsAnimationProperties", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "windowInsetsRulers", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "applyWindowInsetsRulers", "Landroidx/compose/ui/Modifier;", "insetsListener", "Landroidx/compose/ui/layout/InsetsListener;", "RulerKey", "", "provideInsetsValues", "", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "insets", "Landroidx/compose/ui/layout/ValueInsets;", "width", "", "height", "provideInsetsValues-cytEWk0", "(Landroidx/compose/ui/layout/RulerScope;Landroidx/compose/ui/layout/RectRulers;JII)V", "WindowInsetsTypeMap", "Landroidx/collection/IntObjectMap;", "AnimatableInsetsRulers", "", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "AnimatableRulers", "Landroidx/collection/MutableIntObjectMap;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsRulers_androidKt {
    private static final WindowInsetsRulers[] AnimatableInsetsRulers = null;
    private static final MutableIntObjectMap<WindowInsetsRulers> AnimatableRulers = null;
    private static final String RulerKey = "androidx.compose.ui.layout.WindowInsetsRulers";
    private static final IntObjectMap<WindowInsetsRulers> WindowInsetsTypeMap = null;

    static {
        MutableIntObjectMap r100 = new MutableIntObjectMap(8);
        int r101 = WindowInsetsCompat.Type.statusBars();
        WindowInsetsRulers.Companion r102 = WindowInsetsRulers.Companion;
        r100.set(r101, r102.getStatusBars());
        r100.set(WindowInsetsCompat.Type.navigationBars(), r102.getNavigationBars());
        r100.set(WindowInsetsCompat.Type.captionBar(), r102.getCaptionBar());
        r100.set(WindowInsetsCompat.Type.ime(), r102.getIme());
        r100.set(WindowInsetsCompat.Type.systemGestures(), r102.getSystemGestures());
        r100.set(WindowInsetsCompat.Type.mandatorySystemGestures(), r102.getMandatorySystemGestures());
        r100.set(WindowInsetsCompat.Type.tappableElement(), r102.getTappableElement());
        WindowInsetsTypeMap = r100;
        AnimatableInsetsRulers = new WindowInsetsRulers[]{r102.getStatusBars(), r102.getNavigationBars(), r102.getCaptionBar(), r102.getTappableElement(), r102.getSystemGestures(), r102.getMandatorySystemGestures(), r102.getIme(), r102.getWaterfall(), r102.getDisplayCutout()};
        MutableIntObjectMap<WindowInsetsRulers> r103 = new MutableIntObjectMap(7);
        r103.set(WindowInsetsCompat.Type.statusBars(), r102.getStatusBars());
        r103.set(WindowInsetsCompat.Type.navigationBars(), r102.getNavigationBars());
        r103.set(WindowInsetsCompat.Type.captionBar(), r102.getCaptionBar());
        r103.set(WindowInsetsCompat.Type.systemGestures(), r102.getSystemGestures());
        r103.set(WindowInsetsCompat.Type.tappableElement(), r102.getTappableElement());
        r103.set(WindowInsetsCompat.Type.mandatorySystemGestures(), r102.getMandatorySystemGestures());
        r103.set(WindowInsetsCompat.Type.ime(), r102.getIme());
        AnimatableRulers = r103;
    }

    public static final /* synthetic */ WindowInsetsRulers[] access$getAnimatableInsetsRulers$p() {
        return AnimatableInsetsRulers;
    }

    public static final /* synthetic */ MutableIntObjectMap access$getAnimatableRulers$p() {
        return AnimatableRulers;
    }

    public static final /* synthetic */ IntObjectMap access$getWindowInsetsTypeMap$p() {
        return WindowInsetsTypeMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    public static final List<RectRulers> findDisplayCutouts(Placeable.PlacementScope r110) {
        LayoutCoordinates r111 = r110.getCoordinates();
        if (r111 == null) goto L5;
        LayoutCoordinates r112 = LayoutCoordinatesKt.findRootCoordinates(r111);
    L7:
        if ((r112 instanceof NodeCoordinator) == false) goto L9;
        NodeCoordinator r113 = (NodeCoordinator) r112;
    L10:
        if (r113 == null) goto L61;
        int r100 = NodeKind.m6556constructorimpl(262144);
        boolean r101 = NodeKindKt.m6565getIncludeSelfInTraversalH91voCI(r100);
        Modifier.Node r102 = r113.getTail();
        if (r101 == true) goto L17;
        r102 = r102.getParent$ui_release();
        if (r102 != null) goto L17;
    L59:
        r113 = r113.getWrapped$ui_release();
    L17:
        Modifier.Node r103 = NodeCoordinator.access$headNode(r113, r101);
    L18:
        if (r103 == null) goto L59;
        if ((r103.getAggregateChildKindSet$ui_release() & r100) == 0) goto L59;
        if ((r103.getKindSet$ui_release() & r100) == 0) goto L57;
        MutableVector r104 = null;
        Modifier.Node r105 = r103;
    L24:
        if (r105 == 0) goto L57;
        if ((r105 instanceof TraversableNode) == true) goto L27;
        if ((r105.getKindSet$ui_release() & r100) == 0) goto L34;
        boolean r106 = true;
    L35:
        if (r106 == false) goto L56;
        if ((r105 instanceof DelegatingNode) == false) goto L56;
        Modifier.Node r107 = ((DelegatingNode) r105).getDelegate$ui_release();
        int r108 = 0;
        r105 = r105;
    L39:
        if (r107 == null) goto L54;
        if ((r107.getKindSet$ui_release() & r100) == 0) goto L43;
        boolean r114 = true;
    L44:
        if (r114 == false) goto L53;
        r108 = r108 + 1;
        if (r108 != 1) goto L48;
        r105 = r107;
        goto L53
    L48:
        if (r104 != null) goto L50;
        r104 = new MutableVector(new Modifier.Node[16], 0);
    L50:
        if (r105 == 0) goto L52;
        r104.add(r105);
        r105 = 0;
    L52:
        r104.add(r107);
    L53:
        r107 = r107.getChild$ui_release();
        r105 = r105;
        goto L39
    L43:
        r114 = false;
        goto L44
    L54:
        if (r108 == 1) goto L24;
    L56:
        r105 = DelegatableNodeKt.access$pop(r104);
        goto L24
    L34:
        r106 = false;
        goto L35
    L27:
        TraversableNode r109 = (TraversableNode) r105;
        if (r109.getTraverseKey() != RulerKey) goto L56;
        return ((RulerProviderModifierNode) r109).getCutoutRulers();
    L57:
        if (r103 == r102) goto L59;
        r103 = r103.getChild$ui_release();
        goto L18
    L61:
        return CollectionsKt.emptyList();
    L9:
        r113 = null;
        goto L10
    L5:
        r112 = null;
        goto L7
    }

    public static final Modifier applyWindowInsetsRulers(Modifier r100, InsetsListener r101) {
        return r100.then(new RulerProviderModifierElement(r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    public static final WindowInsetsAnimation findInsetsAnimationProperties(Placeable.PlacementScope r110, WindowInsetsRulers r111) {
        LayoutCoordinates r112 = r110.getCoordinates();
        if (r112 == null) goto L5;
        LayoutCoordinates r113 = LayoutCoordinatesKt.findRootCoordinates(r112);
    L7:
        if ((r113 instanceof NodeCoordinator) == false) goto L9;
        NodeCoordinator r114 = (NodeCoordinator) r113;
    L10:
        if (r114 == null) goto L64;
        int r100 = NodeKind.m6556constructorimpl(262144);
        boolean r101 = NodeKindKt.m6565getIncludeSelfInTraversalH91voCI(r100);
        Modifier.Node r102 = r114.getTail();
        if (r101 == true) goto L17;
        r102 = r102.getParent$ui_release();
        if (r102 != null) goto L17;
    L62:
        r114 = r114.getWrapped$ui_release();
    L17:
        Modifier.Node r103 = NodeCoordinator.access$headNode(r114, r101);
    L18:
        if (r103 == null) goto L62;
        if ((r103.getAggregateChildKindSet$ui_release() & r100) == 0) goto L62;
        if ((r103.getKindSet$ui_release() & r100) == 0) goto L60;
        MutableVector r104 = null;
        Modifier.Node r105 = r103;
    L24:
        if (r105 == 0) goto L60;
        if ((r105 instanceof TraversableNode) == true) goto L27;
        if ((r105.getKindSet$ui_release() & r100) == 0) goto L37;
        boolean r106 = true;
    L38:
        if (r106 == false) goto L59;
        if ((r105 instanceof DelegatingNode) == false) goto L59;
        Modifier.Node r107 = ((DelegatingNode) r105).getDelegate$ui_release();
        int r108 = 0;
        r105 = r105;
    L42:
        if (r107 == null) goto L57;
        if ((r107.getKindSet$ui_release() & r100) == 0) goto L46;
        boolean r115 = true;
    L47:
        if (r115 == false) goto L56;
        r108 = r108 + 1;
        if (r108 != 1) goto L51;
        r105 = r107;
        goto L56
    L51:
        if (r104 != null) goto L53;
        r104 = new MutableVector(new Modifier.Node[16], 0);
    L53:
        if (r105 == 0) goto L55;
        r104.add(r105);
        r105 = 0;
    L55:
        r104.add(r107);
    L56:
        r107 = r107.getChild$ui_release();
        r105 = r105;
        goto L42
    L46:
        r115 = false;
        goto L47
    L57:
        if (r108 == 1) goto L24;
    L59:
        r105 = DelegatableNodeKt.access$pop(r104);
        goto L24
    L37:
        r106 = false;
        goto L38
    L27:
        TraversableNode r109 = (TraversableNode) r105;
        if (r109.getTraverseKey() != RulerKey) goto L59;
        WindowWindowInsetsAnimationValues r116 = ((RulerProviderModifierNode) r109).getInsetsValues().get(r111);
        if (r116 == null) goto L33;
        return r116;
    L33:
        return NoWindowInsetsAnimation.INSTANCE;
    L60:
        if (r103 == r102) goto L62;
        r103 = r103.getChild$ui_release();
        goto L18
    L64:
        return NoWindowInsetsAnimation.INSTANCE;
    L9:
        r114 = null;
        goto L10
    L5:
        r113 = null;
        goto L7
    }

    /* JADX INFO: renamed from: access$provideInsetsValues-cytEWk0, reason: not valid java name */
    public static final /* synthetic */ void m6382access$provideInsetsValuescytEWk0(RulerScope r100, RectRulers r101, long r102, int r103, int r104) {
        m6383provideInsetsValuescytEWk0(r100, r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: provideInsetsValues-cytEWk0, reason: not valid java name */
    private static final void m6383provideInsetsValuescytEWk0(RulerScope r100, RectRulers r101, long r102, int r110, int r111) {
        if (ValueInsets.m6374equalsimpl0(r102, ValueInsets_androidKt.getUnsetValueInsets()) == true) goto L6;
        float r103 = (int) ((r102 >>> 48) & 65535);
        float r104 = (int) ((r102 >>> 32) & 65535);
        float r112 = r110 - ((int) ((r102 >>> 16) & 65535));
        r100.provides(r101.getLeft(), r103);
        r100.provides(r101.getTop(), r104);
        r100.provides(r101.getRight(), r112);
        r100.provides(r101.getBottom(), r111 - ((int) (r102 & 65535)));
        return;
    }
}
