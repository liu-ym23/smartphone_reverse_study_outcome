package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class DefaultTextContextMenuDropdownProvider_androidKt$OpenContextMenu$2$data$2$1 extends FunctionReferenceImpl implements Function0<TextContextMenuData> {
    public DefaultTextContextMenuDropdownProvider_androidKt$OpenContextMenu$2$data$2$1(Object r100) {
        super(0, r100, TextContextMenuDataProvider.class, "data", "data()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TextContextMenuData invoke() {
        return ((TextContextMenuDataProvider) this.receiver).data();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ TextContextMenuData invoke() {
        return invoke();
    }
}
