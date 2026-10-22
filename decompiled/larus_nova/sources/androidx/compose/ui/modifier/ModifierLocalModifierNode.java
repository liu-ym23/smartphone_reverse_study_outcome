package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\f\u001a\u0002H\tH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "provide", "", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "current", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {

    /* JADX INFO: renamed from: androidx.compose.ui.modifier.ModifierLocalModifierNode$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ModifierLocalMap $default$getProvidedValues(ModifierLocalModifierNode r100) {
            return EmptyMap.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v12 */
        public static Object $default$getCurrent(ModifierLocalModifierNode r110, ModifierLocal r111) {
            if (r110.getNode().isAttached() == true) goto L5;
            InlineClassHelperKt.throwIllegalArgumentException("ModifierLocal accessed from an unattached node");
        L5:
            int r100 = NodeKind.m6556constructorimpl(32);
            if (r110.getNode().isAttached() == true) goto L8;
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        L8:
            Modifier.Node r101 = r110.getNode().getParent$ui_release();
            LayoutNode r112 = DelegatableNodeKt.requireLayoutNode(r110);
        L9:
            if (r112 == null) goto L57;
            if ((r112.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r100) == 0) goto L50;
        L12:
            if (r101 == null) goto L50;
            if ((r101.getKindSet$ui_release() & r100) == 0) goto L49;
            Modifier.Node r102 = r101;
            MutableVector r103 = null;
        L16:
            if (r102 == 0) goto L49;
            if ((r102 instanceof ModifierLocalModifierNode) == true) goto L19;
            if ((r102.getKindSet$ui_release() & r100) == 0) goto L26;
            boolean r104 = true;
        L27:
            if (r104 == false) goto L48;
            if ((r102 instanceof DelegatingNode) == false) goto L48;
            Modifier.Node r105 = ((DelegatingNode) r102).getDelegate$ui_release();
            int r106 = 0;
            r102 = r102;
        L31:
            if (r105 == null) goto L46;
            if ((r105.getKindSet$ui_release() & r100) == 0) goto L35;
            boolean r107 = true;
        L36:
            if (r107 == false) goto L45;
            r106 = r106 + 1;
            if (r106 != 1) goto L40;
            r102 = r105;
            goto L45
        L40:
            if (r103 != null) goto L42;
            r103 = new MutableVector(new Modifier.Node[16], 0);
        L42:
            if (r102 == 0) goto L44;
            r103.add(r102);
            r102 = 0;
        L44:
            r103.add(r105);
        L45:
            r105 = r105.getChild$ui_release();
            r102 = r102;
            goto L31
        L35:
            r107 = false;
            goto L36
        L46:
            if (r106 == 1) goto L16;
        L48:
            r102 = DelegatableNodeKt.access$pop(r103);
            goto L16
        L26:
            r104 = false;
            goto L27
        L19:
            ModifierLocalModifierNode r108 = (ModifierLocalModifierNode) r102;
            if (r108.getProvidedValues().contains$ui_release(r111) == false) goto L48;
            return r108.getProvidedValues().get$ui_release(r111);
        L49:
            r101 = r101.getParent$ui_release();
        L50:
            r112 = r112.getParent$ui_release();
            if (r112 == null) goto L55;
            NodeChain r109 = r112.getNodes$ui_release();
            if (r109 == null) goto L55;
            r101 = r109.getTail$ui_release();
        L55:
            r101 = null;
            goto L9
        L57:
            return r111.getDefaultFactory$ui_release().invoke();
        }

        public static void $default$provide(ModifierLocalModifierNode r100, ModifierLocal r101, Object r102) {
            if (r100.getProvidedValues() == EmptyMap.INSTANCE) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == true) goto L9;
            InlineClassHelperKt.throwIllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap");
        L9:
            if (r100.getProvidedValues().contains$ui_release(r101) == true) goto L11;
            InlineClassHelperKt.throwIllegalArgumentException("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + r101 + " was not found.");
        L11:
            r100.getProvidedValues().mo6392set$ui_release(r101, r102);
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    <T> T getCurrent(ModifierLocal<T> r100);

    ModifierLocalMap getProvidedValues();

    <T> void provide(ModifierLocal<T> r100, T r101);
}
