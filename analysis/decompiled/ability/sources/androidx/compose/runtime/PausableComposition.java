package androidx.compose.runtime;

import S7.n;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\u00062\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H&¢\u0006\u0004\b\t\u0010\b\u0082\u0001\u0001\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/PausableComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "Landroidx/compose/runtime/PausedComposition;", "setPausableContent", "(LS7/n;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "Landroidx/compose/runtime/CompositionImpl;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PausableComposition extends ReusableComposition {
    PausedComposition setPausableContent(n content);

    PausedComposition setPausableContentWithReuse(n content);
}
