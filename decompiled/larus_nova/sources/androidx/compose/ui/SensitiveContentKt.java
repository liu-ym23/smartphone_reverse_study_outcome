package androidx.compose.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"sensitiveContent", "Landroidx/compose/ui/Modifier;", "isContentSensitive", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SensitiveContentKt {
    public static final Modifier sensitiveContent(Modifier r100, boolean r101) {
        return r100.then(new SensitiveNodeElement(r101));
    }

    public static /* synthetic */ Modifier sensitiveContent$default(Modifier r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = true;
    L6:
        return sensitiveContent(r100, r101);
    }
}
