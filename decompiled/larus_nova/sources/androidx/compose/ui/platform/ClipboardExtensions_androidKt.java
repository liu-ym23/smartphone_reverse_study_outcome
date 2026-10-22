package androidx.compose.ui.platform;

import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"firstUriOrNull", "Landroid/net/Uri;", "Landroidx/compose/ui/platform/ClipEntry;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ClipboardExtensions_androidKt {
    public static final Uri firstUriOrNull(ClipEntry r100) {
        int r101 = r100.getClipData().getItemCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        Uri r103 = r100.getClipData().getItemAt(r102).getUri();
        if (r103 != null) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return null;
    }
}
