package arc;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static int a(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static int b(int r100, int r101) {
        if (r101 != 0) goto L6;
        return 0;
    L6:
        return (r100 + r101) % r101;
    }
}
