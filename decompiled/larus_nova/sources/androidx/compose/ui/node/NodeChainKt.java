package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a$\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\n0\f2\u0006\u0010\r\u001a\u00020\u000bH\u0002\u001a.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"ActionReplace", "", "ActionUpdate", "ActionReuse", "actionForModifiers", "prev", "Landroidx/compose/ui/Modifier$Element;", TeaEventTrack.ACTION_DRAMA_NEXT, "updateUnsafe", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ModifierNodeElement;", "node", "fillVector", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier;", "result", "stack", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NodeChainKt {
    private static final int ActionReplace = 0;
    private static final int ActionReuse = 2;
    private static final int ActionUpdate = 1;

    public static final /* synthetic */ void access$updateUnsafe(ModifierNodeElement r100, Modifier.Node r101) {
        updateUnsafe(r100, r101);
    }

    public static final int actionForModifiers(Modifier.Element r100, Modifier.Element r101) {
        if (Intrinsics.areEqual(r100, r101) == false) goto L6;
        return 2;
    L6:
        if (Actual_jvmKt.areObjectsOfSameType(r100, r101) == false) goto L8;
        return 1;
    L8:
        return 0;
    }

    private static final <T extends Modifier.Node> void updateUnsafe(ModifierNodeElement<T> r100, Modifier.Node r101) {
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        r100.update(r101);
    }

    public static final /* synthetic */ MutableVector access$fillVector(Modifier r100, MutableVector r101, MutableVector r102) {
        return fillVector(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final MutableVector<Modifier.Element> fillVector(Modifier r100, final MutableVector<Modifier.Element> r101, MutableVector<Modifier> r102) {
        r102.add(r100);
        Function1<Modifier.Element, Boolean> r103 = null;
    L4:
        if (r102.getSize() == 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L17;
        Modifier r105 = r102.removeAt(r102.getSize() - 1);
        if ((r105 instanceof CombinedModifier) == true) goto L10;
        if ((r105 instanceof Modifier.Element) == true) goto L13;
        if (r103 != null) goto L16;
        r103 = new AnonymousClass1(r101);
    L16:
        r105.all(r103);
        r103 = r103;
        goto L4
    L13:
        r101.add(r105);
        goto L4
    L10:
        CombinedModifier r106 = (CombinedModifier) r105;
        r102.add(r106.getInner$ui_release());
        r102.add(r106.getOuter$ui_release());
        goto L4
    L17:
        return r101;
    L6:
        r104 = false;
        goto L7
    }
}
