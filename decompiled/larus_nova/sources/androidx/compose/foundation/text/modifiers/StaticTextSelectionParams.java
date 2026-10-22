package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0011\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001e\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "<init>", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/text/TextLayoutResult;)V", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "", "end", "shouldClip", "", "getShouldClip", "()Z", "copy", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class StaticTextSelectionParams {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final StaticTextSelectionParams Empty = null;
    private final LayoutCoordinates layoutCoordinates;
    private final TextLayoutResult textLayoutResult;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "getEmpty", "()Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final StaticTextSelectionParams getEmpty() {
            return StaticTextSelectionParams.access$getEmpty$cp();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        Empty = new StaticTextSelectionParams(null, null);
    }

    public boolean getShouldClip() {
        TextLayoutResult r100 = this.textLayoutResult;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextOverflow.m7460equalsimpl0(r100.getLayoutInput().m6965getOverflowgIe3tQ8(), TextOverflow.Companion.m7473getVisiblegIe3tQ8()) == false) goto L7;
        return false;
    L7:
        if (r100.getHasVisualOverflow() == true) goto L9;
        return false;
    L9:
        return true;
    }

    public static final /* synthetic */ StaticTextSelectionParams access$getEmpty$cp() {
        return Empty;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }

    public StaticTextSelectionParams(LayoutCoordinates r100, TextLayoutResult r101) {
        this.layoutCoordinates = r100;
        this.textLayoutResult = r101;
    }

    public final StaticTextSelectionParams copy(LayoutCoordinates r100, TextLayoutResult r101) {
        return new StaticTextSelectionParams(r100, r101);
    }

    public Path getPathForRange(int r100, int r101) {
        TextLayoutResult r102 = this.textLayoutResult;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getPathForRange(r100, r101);
    }

    public static /* synthetic */ StaticTextSelectionParams copy$default(StaticTextSelectionParams r100, LayoutCoordinates r101, TextLayoutResult r102, int r103, Object r104) {
        if (r104 != null) goto L12;
        if ((r103 & 1) == 0) goto L7;
        r101 = r100.layoutCoordinates;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r102 = r100.textLayoutResult;
    L10:
        return r100.copy(r101, r102);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }
}
