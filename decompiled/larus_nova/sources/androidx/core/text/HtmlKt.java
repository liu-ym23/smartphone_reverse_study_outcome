package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b¨\u0006\u000b"}, d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HtmlKt {
    public static final String toHtml(Spanned r100, int r101) {
        return HtmlCompat.toHtml(r100, r101);
    }

    public static final Spanned parseAsHtml(String r100, int r101, Html.ImageGetter r102, Html.TagHandler r103) {
        return HtmlCompat.fromHtml(r100, r101, r102, r103);
    }

    public static /* synthetic */ String toHtml$default(Spanned r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return HtmlCompat.toHtml(r100, r101);
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String r100, int r101, Html.ImageGetter r102, Html.TagHandler r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = null;
    L12:
        return HtmlCompat.fromHtml(r100, r101, r102, r103);
    }
}
