package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"calculateNextCursorPositionAndWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "proposedCursor", "", EffectConfiguration.KEY_CURSOR, "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "(IILandroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextPreparedSelectionKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[IndexTransformationType.values().length];
            r100[IndexTransformationType.Untransformed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[IndexTransformationType.Deletion.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[IndexTransformationType.Replacement.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[IndexTransformationType.Insertion.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final long calculateNextCursorPositionAndWedgeAffinity(int r100, int r101, TransformedTextFieldState r102) {
        if (r100 != (-1)) goto L7;
        return CursorAndWedgeAffinity.m1334constructorimpl(r101);
    L7:
        if (r100 <= r101) goto L9;
        boolean r103 = true;
    L10:
        long r104 = r102.m1319mapFromTransformedjx7JFs(r100);
        long r105 = r102.m1322mapToTransformedGEjPoXI(r104);
        if (TextRange.m6992getCollapsedimpl(r104) == false) goto L16;
        if (TextRange.m6992getCollapsedimpl(r105) == false) goto L16;
        IndexTransformationType r106 = IndexTransformationType.Untransformed;
    L26:
        int r107 = WhenMappings.$EnumSwitchMapping$0[r106.ordinal()];
        if (r107 != 1) goto L29;
        if (r103 == false) goto L51;
        WedgeAffinity r108 = WedgeAffinity.Start;
    L53:
        return CursorAndWedgeAffinity.m1335constructorimpl(r100, r108);
    L51:
        r108 = WedgeAffinity.End;
        goto L53
    L29:
        if (r107 == 2) goto L60;
        if (r107 != 3) goto L33;
        if (r103 == false) goto L59;
        return CursorAndWedgeAffinity.m1335constructorimpl(TextRange.m6993getEndimpl(r105), WedgeAffinity.Start);
    L59:
        return CursorAndWedgeAffinity.m1335constructorimpl(TextRange.m6998getStartimpl(r105), WedgeAffinity.End);
    L33:
        if (r107 != 4) goto L44;
        if (r103 == false) goto L40;
        if (r100 != TextRange.m6998getStartimpl(r105)) goto L55;
        return CursorAndWedgeAffinity.m1335constructorimpl(r100, WedgeAffinity.Start);
    L55:
        return CursorAndWedgeAffinity.m1335constructorimpl(TextRange.m6993getEndimpl(r105), WedgeAffinity.End);
    L40:
        if (r100 != TextRange.m6993getEndimpl(r105)) goto L57;
        return CursorAndWedgeAffinity.m1335constructorimpl(r100, WedgeAffinity.End);
    L57:
        return CursorAndWedgeAffinity.m1335constructorimpl(TextRange.m6998getStartimpl(r105), WedgeAffinity.Start);
    L44:
        throw new NoWhenBranchMatchedException();
    L60:
        return CursorAndWedgeAffinity.m1334constructorimpl(r100);
    L16:
        if (TextRange.m6992getCollapsedimpl(r104) == true) goto L21;
        if (TextRange.m6992getCollapsedimpl(r105) == true) goto L21;
        r106 = IndexTransformationType.Replacement;
    L21:
        if (TextRange.m6992getCollapsedimpl(r104) == true) goto L23;
    L25:
        r106 = IndexTransformationType.Deletion;
        goto L26
    L23:
        if (TextRange.m6992getCollapsedimpl(r105) == true) goto L25;
        r106 = IndexTransformationType.Insertion;
        goto L26
    L9:
        r103 = false;
        goto L10
    }
}
