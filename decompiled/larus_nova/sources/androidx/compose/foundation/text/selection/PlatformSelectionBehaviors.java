package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0004\b\u000b\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "", "suggestSelectionForLongPressOrDoubleClick", "Landroidx/compose/ui/text/TextRange;", "text", "", "selection", "suggestSelectionForLongPressOrDoubleClick-pYaCw-w", "(Ljava/lang/CharSequence;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowContextMenu", "", "onShowContextMenu-Sb-Bc2M", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PlatformSelectionBehaviors {
    /* JADX INFO: renamed from: onShowContextMenu-Sb-Bc2M, reason: not valid java name */
    Object mo1446onShowContextMenuSbBc2M(CharSequence r100, long r101, Continuation<? super Unit> r102);

    /* JADX INFO: renamed from: suggestSelectionForLongPressOrDoubleClick-pYaCw-w, reason: not valid java name */
    Object mo1447suggestSelectionForLongPressOrDoubleClickpYaCww(CharSequence r100, long r101, Continuation<? super TextRange> r102);
}
