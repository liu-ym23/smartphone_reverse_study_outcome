package androidx.compose.foundation;

import android.graphics.Rect;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/PreferKeepClearNode;", "Landroidx/compose/foundation/RectListNode;", SVGRenderEngine.RECT, "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "currentRects", "Landroidx/compose/runtime/collection/MutableVector;", "Landroid/graphics/Rect;", "updateRects", "", "rects", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PreferKeepClearNode extends RectListNode {
    @Override // androidx.compose.foundation.RectListNode
    public MutableVector<Rect> currentRects() {
        MutableVector<Rect> r100 = new MutableVector(new Rect[16], 0);
        List<Rect> r101 = getView().getPreferKeepClearRects();
        r100.addAll(r100.getSize(), r101);
        return r100;
    }

    public PreferKeepClearNode(Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> r100) {
        super(r100);
    }

    @Override // androidx.compose.foundation.RectListNode
    public void updateRects(MutableVector<Rect> r100) {
        getView().setPreferKeepClearRects(r100.asMutableList());
    }
}
