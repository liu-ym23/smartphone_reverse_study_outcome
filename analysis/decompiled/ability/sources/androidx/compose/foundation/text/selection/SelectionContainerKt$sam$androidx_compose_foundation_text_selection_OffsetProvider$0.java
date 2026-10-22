package androidx.compose.foundation.text.selection;

import C7.d;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 implements OffsetProvider, g {
    private final /* synthetic */ S7.a function;

    public SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(S7.a aVar) {
        this.function = aVar;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof OffsetProvider) && (obj instanceof g)) {
            return k.b(getFunctionDelegate(), ((g) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.g
    public final d getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.compose.foundation.text.selection.OffsetProvider
    /* renamed from: provide-F1C5BW0 */
    public final /* synthetic */ long mo995provideF1C5BW0() {
        return ((Offset) this.function.invoke()).m3905unboximpl();
    }
}
