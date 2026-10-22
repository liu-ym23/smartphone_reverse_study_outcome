package cf;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m {
    public static final float[] a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$centerLocationInScreen");
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        return new float[]{r101[0] + (r100.getWidth() / 2.0f), r101[1] + (r100.getHeight() / 2.0f)};
    }
}
