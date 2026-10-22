package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "", "bringIntoView", "", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BringIntoViewRequester {

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequester$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object bringIntoView$default(BringIntoViewRequester r100, Rect r101, Continuation r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.bringIntoView(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bringIntoView");
        }
    }

    Object bringIntoView(Rect r100, Continuation<? super Unit> r101);
}
