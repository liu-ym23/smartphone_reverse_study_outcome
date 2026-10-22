package com.android.ttcjpaysdk.base.ui.Utils;

import android.graphics.drawable.GradientDrawable;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rJ\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPayGradientUtil;", "", "()V", "TAG", "", "getGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "fromColor", "", "toColor", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "topLeftRadius", "", "topRightRadius", "bottomRightRadius", "bottomLeftRadius", "radius", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayGradientUtil {
    public static final CJPayGradientUtil INSTANCE = null;
    public static final String TAG = "CJPayGradientUtil";

    static {
        INSTANCE = new CJPayGradientUtil();
    }

    private CJPayGradientUtil() {
    }

    public final GradientDrawable getGradientDrawable(int r100, int r101, float r102) {
        GradientDrawable r103 = new GradientDrawable();
        r103.setGradientType(0);     // Catch: Exception -> L5
        r103.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L5
        r103.setColors(new int[]{r100, r101});     // Catch: Exception -> L5
        r103.setShape(0);     // Catch: Exception -> L5
        r103.setCornerRadius(r102);     // Catch: Exception -> L5
    L7:
        return r103;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayGradientUtil#getGradientDrawable", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayGradientUtil#getGradientDrawable", e);
        goto L7
    }

    public final GradientDrawable getGradientDrawable(int r100, int r101, GradientDrawable.Orientation r102, float r103, float r104, float r105, float r110) {
        Intrinsics.checkNotNullParameter(r102, "orientation");
        GradientDrawable r106 = new GradientDrawable();
        r106.setGradientType(0);     // Catch: Exception -> L5
        r106.setOrientation(r102);     // Catch: Exception -> L5
        r106.setColors(new int[]{r100, r101});     // Catch: Exception -> L5
        r106.setShape(0);     // Catch: Exception -> L5
        r106.setCornerRadii(new float[]{r103, r103, r104, r104, r105, r105, r110, r110});     // Catch: Exception -> L5
    L7:
        return r106;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayGradientUtil#getGradientDrawable", e);
        CJLogger.b(TAG, "getGradientDrawable error, " + e.getMessage());
        goto L7
    }
}
