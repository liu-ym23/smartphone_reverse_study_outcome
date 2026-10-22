package b29;

import android.animation.TypeEvaluator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements TypeEvaluator<int[]> {
    public d() {
    }

    @Override // android.animation.TypeEvaluator
    public final int[] evaluate(float r100, int[] r101, int[] r102) {
        int[] r103 = r101;
        int[] r104 = r102;
        Intrinsics.checkNotNullParameter(r103, "startValue");
        Intrinsics.checkNotNullParameter(r104, "endValue");
        int r105 = r103.length;
        int[] r106 = new int[r105];
        int r107 = 0;
    L3:
        if (r107 >= r105) goto L5;
        int r108 = r103[r107];
        r106[r107] = (int) (r108 + ((r104[r107] - r108) * r100));
        r107 = r107 + 1;
        goto L3
    L5:
        return r106;
    }
}
