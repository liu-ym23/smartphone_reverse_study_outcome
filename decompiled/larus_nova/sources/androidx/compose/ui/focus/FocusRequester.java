package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0007J\u0017\u0010\t\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u0012H\u0000¢\u0006\u0002\b\u0014J\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u001d\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u0012H\u0082\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester;", "", "<init>", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "requestFocus", "", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "requestFocus-3ESFkO8", "(I)Z", "findFocusTargetNode", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "findFocusTargetNode$ui_release", "captureFocus", "freeFocus", "saveFocusedChild", "restoreFocusedChild", "findFocusTarget", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusRequester {
    public static final int $stable = 0;
    private static final FocusRequester Cancel = null;
    public static final Companion Companion = null;
    private static final FocusRequester Default = null;
    private static final FocusRequester Redirect = null;
    private final MutableVector<FocusRequesterModifierNode> focusRequesterNodes;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/focus/FocusRequester;", "getDefault", "()Landroidx/compose/ui/focus/FocusRequester;", "Cancel", "getCancel", "Redirect", "getRedirect$ui_release", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u0007\u001a\u00020\u0005H\u0086\u0002J\t\u0010\b\u001a\u00020\u0005H\u0086\u0002J\t\u0010\t\u001a\u00020\u0005H\u0086\u0002J\t\u0010\n\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u000b\u001a\u00020\u0005H\u0086\u0002J\t\u0010\f\u001a\u00020\u0005H\u0086\u0002J\t\u0010\r\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u000e\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u000f\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u0010\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u0011\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u0012\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u0013\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u0014\u001a\u00020\u0005H\u0086\u0002¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "", "<init>", "()V", "component1", "Landroidx/compose/ui/focus/FocusRequester;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class FocusRequesterFactory {
            public static final int $stable = 0;
            public static final FocusRequesterFactory INSTANCE = null;

            static {
                INSTANCE = new FocusRequesterFactory();
            }

            private FocusRequesterFactory() {
            }

            public final FocusRequester component1() {
                return new FocusRequester();
            }

            public final FocusRequester component10() {
                return new FocusRequester();
            }

            public final FocusRequester component11() {
                return new FocusRequester();
            }

            public final FocusRequester component12() {
                return new FocusRequester();
            }

            public final FocusRequester component13() {
                return new FocusRequester();
            }

            public final FocusRequester component14() {
                return new FocusRequester();
            }

            public final FocusRequester component15() {
                return new FocusRequester();
            }

            public final FocusRequester component16() {
                return new FocusRequester();
            }

            public final FocusRequester component2() {
                return new FocusRequester();
            }

            public final FocusRequester component3() {
                return new FocusRequester();
            }

            public final FocusRequester component4() {
                return new FocusRequester();
            }

            public final FocusRequester component5() {
                return new FocusRequester();
            }

            public final FocusRequester component6() {
                return new FocusRequester();
            }

            public final FocusRequester component7() {
                return new FocusRequester();
            }

            public final FocusRequester component8() {
                return new FocusRequester();
            }

            public final FocusRequester component9() {
                return new FocusRequester();
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final FocusRequester getCancel() {
            return FocusRequester.access$getCancel$cp();
        }

        public final FocusRequester getDefault() {
            return FocusRequester.access$getDefault$cp();
        }

        public final FocusRequester getRedirect$ui_release() {
            return FocusRequester.access$getRedirect$cp();
        }

        public final FocusRequesterFactory createRefs() {
            return FocusRequesterFactory.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
        Default = new FocusRequester();
        Cancel = new FocusRequester();
        Redirect = new FocusRequester();
    }

    public final boolean captureFocus() {
        if (this.focusRequesterNodes.getSize() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        return false;
    L9:
        MutableVector<FocusRequesterModifierNode> r101 = this.focusRequesterNodes;
        FocusRequesterModifierNode[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L15;
        if (FocusRequesterModifierNodeKt.captureFocus(r102[r104]) == true) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        return true;
    L15:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    public final boolean freeFocus() {
        if (this.focusRequesterNodes.getSize() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        return false;
    L9:
        MutableVector<FocusRequesterModifierNode> r101 = this.focusRequesterNodes;
        FocusRequesterModifierNode[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L15;
        if (FocusRequesterModifierNodeKt.freeFocus(r102[r104]) == true) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        return true;
    L15:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "use the version the has a FocusDirection", replaceWith = @ReplaceWith(expression = "this.requestFocus()", imports = {}))
    public final /* synthetic */ void requestFocus() {
        m4490requestFocus3ESFkO8(FocusDirection.Companion.m4466getEnterdhqQ8s());
    }

    public final boolean restoreFocusedChild() {
        if (this.focusRequesterNodes.getSize() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        return false;
    L9:
        MutableVector<FocusRequesterModifierNode> r101 = this.focusRequesterNodes;
        FocusRequesterModifierNode[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
        boolean r105 = false;
    L10:
        if (r104 >= r103) goto L18;
        if (FocusRequesterModifierNodeKt.restoreFocusedChild(r102[r104]) == true) goto L16;
        if (r105 == true) goto L16;
        r105 = false;
    L17:
        r104 = r104 + 1;
    L16:
        r105 = true;
        goto L17
    L18:
        return r105;
    L5:
        r100 = false;
        goto L6
    }

    public final boolean saveFocusedChild() {
        if (this.focusRequesterNodes.getSize() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        return false;
    L9:
        MutableVector<FocusRequesterModifierNode> r101 = this.focusRequesterNodes;
        FocusRequesterModifierNode[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L15;
        if (FocusRequesterModifierNodeKt.saveFocusedChild(r102[r104]) == true) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        return true;
    L15:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    public FocusRequester() {
        this.focusRequesterNodes = new MutableVector(new FocusRequesterModifierNode[16], 0);
    }

    public static final /* synthetic */ FocusRequester access$getCancel$cp() {
        return Cancel;
    }

    public static final /* synthetic */ FocusRequester access$getDefault$cp() {
        return Default;
    }

    public static final /* synthetic */ FocusRequester access$getRedirect$cp() {
        return Redirect;
    }

    public final MutableVector<FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    private final boolean findFocusTarget(Function1<? super FocusTargetNode, Boolean> r110) {
        Companion r100 = Companion;
        if (this == r100.getDefault()) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L81;
        if (this == r100.getCancel()) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L79;
        if (this.focusRequesterNodes.getSize() != 0) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L20;
        System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        return false;
    L20:
        MutableVector<FocusRequesterModifierNode> r104 = this.focusRequesterNodes;
        FocusRequesterModifierNode[] r105 = r104.content;
        int r106 = r104.getSize();
        int r107 = 0;
        boolean r108 = false;
    L21:
        if (r107 >= r106) goto L77;
        FocusRequesterModifierNode r109 = r105[r107];
        int r111 = NodeKind.m6556constructorimpl(1024);
        if (r109.getNode().isAttached() == true) goto L25;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L25:
        MutableVector r112 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r113 = r109.getNode().getChild$ui_release();
        if (r113 != null) goto L28;
        DelegatableNodeKt.access$addLayoutNodeChildren(r112, r109.getNode(), false);
    L30:
        if (r112.getSize() == 0) goto L32;
        boolean r114 = true;
    L33:
        if (r114 == false) goto L76;
        Modifier.Node r115 = (Modifier.Node) r112.removeAt(r112.getSize() - 1);
        if ((r115.getAggregateChildKindSet$ui_release() & r111) == 0) goto L36;
    L37:
        if (r115 == null) goto L30;
        if ((r115.getKindSet$ui_release() & r111) != 0) goto L40;
        r115 = r115.getChild$ui_release();
        goto L37
    L40:
        MutableVector r116 = null;
    L41:
        if (r115 == null) goto L30;
        if ((r115 instanceof FocusTargetNode) == true) goto L45;
        if ((r115.getKindSet$ui_release() & r111) == 0) goto L50;
        boolean r117 = true;
    L51:
        if (r117 == false) goto L72;
        if ((r115 instanceof DelegatingNode) == false) goto L72;
        Modifier.Node r118 = ((DelegatingNode) r115).getDelegate$ui_release();
        int r119 = 0;
    L55:
        if (r118 == null) goto L70;
        if ((r118.getKindSet$ui_release() & r111) == 0) goto L59;
        boolean r120 = true;
    L60:
        if (r120 == false) goto L69;
        r119 = r119 + 1;
        if (r119 != 1) goto L64;
        r115 = r118;
        goto L69
    L64:
        if (r116 != null) goto L66;
        r116 = new MutableVector(new Modifier.Node[16], 0);
    L66:
        if (r115 == null) goto L68;
        r116.add(r115);
        r115 = null;
    L68:
        r116.add(r118);
    L69:
        r118 = r118.getChild$ui_release();
        goto L55
    L59:
        r120 = false;
        goto L60
    L70:
        if (r119 == 1) goto L41;
    L72:
        r115 = DelegatableNodeKt.access$pop(r116);
        goto L41
    L50:
        r117 = false;
        goto L51
    L45:
        if (r110.invoke((FocusTargetNode) r115).booleanValue() == false) goto L72;
        r108 = true;
        goto L76
    L36:
        DelegatableNodeKt.access$addLayoutNodeChildren(r112, r115, false);
    L76:
        r107 = r107 + 1;
        goto L21
    L32:
        r114 = false;
        goto L33
    L28:
        r112.add(r113);
        goto L30
    L77:
        return r108;
    L16:
        r103 = false;
        goto L17
    L79:
        throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
    L11:
        r102 = false;
        goto L12
    L81:
        throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
    L5:
        r101 = false;
        goto L7
    }

    public final boolean findFocusTargetNode$ui_release(Function1<? super FocusTargetNode, Boolean> r110) {
        Companion r100 = Companion;
        if (this == r100.getDefault()) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L82;
        if (this == r100.getCancel()) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L80;
        if (this.focusRequesterNodes.getSize() != 0) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L19;
        System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        return false;
    L19:
        MutableVector<FocusRequesterModifierNode> r104 = this.focusRequesterNodes;
        FocusRequesterModifierNode[] r105 = r104.content;
        int r106 = r104.getSize();
        int r107 = 0;
        boolean r108 = false;
    L20:
        if (r107 >= r106) goto L78;
        FocusRequesterModifierNode r109 = r105[r107];
        int r111 = NodeKind.m6556constructorimpl(1024);
        if (r109.getNode().isAttached() == true) goto L24;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L24:
        MutableVector r112 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r113 = r109.getNode().getChild$ui_release();
        if (r113 != null) goto L27;
        DelegatableNodeKt.access$addLayoutNodeChildren(r112, r109.getNode(), false);
    L29:
        if (r112.getSize() == 0) goto L31;
        boolean r114 = true;
    L32:
        if (r114 == false) goto L76;
        Modifier.Node r115 = (Modifier.Node) r112.removeAt(r112.getSize() - 1);
        if ((r115.getAggregateChildKindSet$ui_release() & r111) == 0) goto L35;
    L36:
        if (r115 == null) goto L29;
        if ((r115.getKindSet$ui_release() & r111) != 0) goto L39;
        r115 = r115.getChild$ui_release();
        goto L36
    L39:
        MutableVector r116 = null;
    L40:
        if (r115 == null) goto L29;
        if ((r115 instanceof FocusTargetNode) == true) goto L43;
        if ((r115.getKindSet$ui_release() & r111) == 0) goto L52;
        boolean r117 = true;
    L53:
        if (r117 == false) goto L74;
        if ((r115 instanceof DelegatingNode) == false) goto L74;
        Modifier.Node r118 = ((DelegatingNode) r115).getDelegate$ui_release();
        int r119 = 0;
    L57:
        if (r118 == null) goto L72;
        if ((r118.getKindSet$ui_release() & r111) == 0) goto L61;
        boolean r120 = true;
    L62:
        if (r120 == false) goto L71;
        r119 = r119 + 1;
        if (r119 != 1) goto L66;
        r115 = r118;
        goto L71
    L66:
        if (r116 != null) goto L68;
        r116 = new MutableVector(new Modifier.Node[16], 0);
    L68:
        if (r115 == null) goto L70;
        r116.add(r115);
        r115 = null;
    L70:
        r116.add(r118);
    L71:
        r118 = r118.getChild$ui_release();
        goto L57
    L61:
        r120 = false;
        goto L62
    L72:
        if (r119 == 1) goto L40;
    L74:
        r115 = DelegatableNodeKt.access$pop(r116);
        goto L40
    L52:
        r117 = false;
        goto L53
    L43:
        FocusTargetNode r121 = (FocusTargetNode) r115;
        if (r121.fetchFocusProperties$ui_release().getCanFocus() == false) goto L46;
        boolean r122 = r110.invoke(r121).booleanValue();
    L47:
        if (r122 == false) goto L74;
        r108 = true;
        goto L76
    L46:
        r122 = TwoDimensionalFocusSearchKt.m4528findChildCorrespondingToFocusEnterOMvw8(r121, FocusDirection.Companion.m4466getEnterdhqQ8s(), r110);
        goto L47
    L35:
        DelegatableNodeKt.access$addLayoutNodeChildren(r112, r115, false);
    L76:
        r107 = r107 + 1;
        goto L20
    L31:
        r114 = false;
        goto L32
    L27:
        r112.add(r113);
        goto L29
    L78:
        return r108;
    L16:
        r103 = false;
        goto L17
    L80:
        throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
    L11:
        r102 = false;
        goto L12
    L82:
        throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
    L5:
        r101 = false;
        goto L7
    }

    /* JADX INFO: renamed from: requestFocus-3ESFkO8, reason: not valid java name */
    public final boolean m4490requestFocus3ESFkO8(final int r100) {
        return findFocusTargetNode$ui_release(new AnonymousClass1(r100));
    }

    /* JADX INFO: renamed from: requestFocus-3ESFkO8$default, reason: not valid java name */
    public static /* synthetic */ boolean m4489requestFocus3ESFkO8$default(FocusRequester r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = FocusDirection.Companion.m4466getEnterdhqQ8s();
    L6:
        return r100.m4490requestFocus3ESFkO8(r101);
    }
}
