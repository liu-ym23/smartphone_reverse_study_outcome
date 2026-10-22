package androidx.core.text;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HtmlCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: HtmlCompat.java */
    static class a {
        static Spanned a(String r0, int r1) {
            return Html.fromHtml(r0, r1);
        }

        static Spanned a(String r2, int r3, Html.ImageGetter r4, Html.TagHandler r5) {
            return Html.fromHtml(r2, r3, (Html.ImageGetter) ZeusTransformUtils.wrapperContextForParams(r4, Html.ImageGetter.class, "com.obric.aiagent.plugin"), (Html.TagHandler) ZeusTransformUtils.wrapperContextForParams(r5, Html.TagHandler.class, "com.obric.aiagent.plugin"));
        }

        static String a(Spanned r2, int r3) {
            return Html.toHtml((Spanned) ZeusTransformUtils.wrapperContextForParams(r2, Spanned.class, "com.obric.aiagent.plugin"), r3);
        }
    }

    public static Spanned a(String r2, int r3, Html.ImageGetter r4, Html.TagHandler r5) {
        Html.ImageGetter r6 = (Html.ImageGetter) ZeusTransformUtils.wrapperContextForParams(r4, Html.ImageGetter.class, "com.obric.aiagent.plugin");
        Html.TagHandler r7 = (Html.TagHandler) ZeusTransformUtils.wrapperContextForParams(r5, Html.TagHandler.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return a.a(r2, r3, r6, r7);
    L7:
        return Html.fromHtml(r2, r6, r7);
    }
}
