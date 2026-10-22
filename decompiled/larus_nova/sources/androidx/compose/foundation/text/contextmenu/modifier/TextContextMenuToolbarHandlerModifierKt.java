package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0082\u0001\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052 \b\u0002\u0010\u0006\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00072 \b\u0002\u0010\u000b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00072#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007H\u0000¢\u0006\u0002\u0010\u0012\u001a \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"ToolbarRequesterNotInitialized", "", "textContextMenuToolbarHandler", "Landroidx/compose/ui/Modifier;", "requester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", SendEventContainerMethodParamModel.EventKinds.onShow, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onHide", "computeContentBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Lkotlin/ParameterName;", "name", "destinationCoordinates", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "translateRootToDestination", "rootContentBounds", "localCoordinates", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuToolbarHandlerModifierKt {
    private static final String ToolbarRequesterNotInitialized = "ToolbarRequester is not initialized.";

    public static final Rect translateRootToDestination(Rect r100, LayoutCoordinates r101, LayoutCoordinates r102) {
        if (r101.isAttached() == false) goto L10;
        if (r102.isAttached() == false) goto L10;
        long r103 = r100.m4617getTopLeftF1C5BW0();
        return RectKt.m4622Recttz77jQw(r102.mo6259localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(r101), r103), r100.m4615getSizeNHjbRc());
    L10:
        return Rect.Companion.getZero();
    }

    public static final Modifier textContextMenuToolbarHandler(Modifier r100, ToolbarRequester r101, Function1<? super Continuation<? super Unit>, ? extends Object> r102, Function1<? super Continuation<? super Unit>, ? extends Object> r103, Function1<? super LayoutCoordinates, Rect> r104) {
        return r100.then(new TextContextMenuToolbarHandlerElement(r101, r102, r103, r104));
    }

    public static /* synthetic */ Modifier textContextMenuToolbarHandler$default(Modifier r100, ToolbarRequester r101, Function1 r102, Function1 r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        return textContextMenuToolbarHandler(r100, r101, r102, r103, r104);
    }
}
