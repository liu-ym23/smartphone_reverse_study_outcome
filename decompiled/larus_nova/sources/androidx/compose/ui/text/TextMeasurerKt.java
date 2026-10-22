package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"DefaultCacheSize", "", "isEllipsis", "", "Landroidx/compose/ui/text/style/TextOverflow;", "isEllipsis-MW5-ApA", "(I)Z", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextMeasurerKt {
    private static final int DefaultCacheSize = 8;

    /* JADX INFO: renamed from: access$isEllipsis-MW5-ApA, reason: not valid java name */
    public static final /* synthetic */ boolean m6975access$isEllipsisMW5ApA(int r100) {
        return m6976isEllipsisMW5ApA(r100);
    }

    /* JADX INFO: renamed from: isEllipsis-MW5-ApA, reason: not valid java name */
    private static final boolean m6976isEllipsisMW5ApA(int r100) {
        TextOverflow.Companion r101 = TextOverflow.Companion;
        if (TextOverflow.m7460equalsimpl0(r100, r101.m7470getEllipsisgIe3tQ8()) == false) goto L5;
    L10:
        return true;
    L5:
        if (TextOverflow.m7460equalsimpl0(r100, r101.m7472getStartEllipsisgIe3tQ8()) == true) goto L10;
        if (TextOverflow.m7460equalsimpl0(r100, r101.m7471getMiddleEllipsisgIe3tQ8()) == true) goto L10;
        return false;
    }
}
