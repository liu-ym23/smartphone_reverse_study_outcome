package ob;

import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22547a = null;

    static {
        int[] r10 = new int[SmoothCornerHelper.Companion.CurveType.values().length];
        f22547a = r10;
        r10[SmoothCornerHelper.Companion.CurveType.BASIC.ordinal()] = 1;
        r10[SmoothCornerHelper.Companion.CurveType.QUADRATIC.ordinal()] = 2;
        r10[SmoothCornerHelper.Companion.CurveType.SKETCH.ordinal()] = 3;
        r10[SmoothCornerHelper.Companion.CurveType.FIGMA.ordinal()] = 4;
        r10[SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE.ordinal()] = 5;
    }
}
