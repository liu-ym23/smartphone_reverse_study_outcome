package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TooltipCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class aa {

    /* JADX INFO: compiled from: TooltipCompat.java */
    static class a {
        static void a(View r2, CharSequence r3) {
            r2.setTooltipText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }
    }

    public static void a(View r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        a.a(r2, r4);
        return;
    L5:
        TooltipCompatHandler.setTooltipText(r2, r4);
    }
}
