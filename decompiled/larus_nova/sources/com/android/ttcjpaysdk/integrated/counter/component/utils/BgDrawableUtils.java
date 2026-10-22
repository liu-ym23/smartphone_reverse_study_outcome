package com.android.ttcjpaysdk.integrated.counter.component.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ;\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/utils/BgDrawableUtils;", "", "()V", "getBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "radii", "", "bgColorString", "", "getBgCornerRadii", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "leftTop", "", "rightTop", "rightBottom", "leftBottom", "(Landroid/content/Context;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)[F", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BgDrawableUtils {
    public static final BgDrawableUtils INSTANCE = null;

    static {
        INSTANCE = new BgDrawableUtils();
    }

    private BgDrawableUtils() {
    }

    public final Drawable getBackgroundDrawable(float[] r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "radii");
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setGradientType(0);
        if (r101 != null) goto L5;
        Unit r103 = null;
    L10:
        if (r103 != null) goto L12;
        r102.setColor(ColorProtector.parseColor("#00ffffff"));
    L12:
        r102.setCornerRadii(r100);
        return r102;
    L5:
        if (Intrinsics.areEqual(ECPromotion.TRANSPARENT_BOTTON_ICON, r101) == false) goto L7;
        r102.setColor(ColorProtector.parseColor("#00ffffff"));
    L8:
        r103 = Unit.INSTANCE;
        goto L10
    L7:
        r102.setColor(ColorProtector.parseColor(r101));
        goto L8
    }

    public final float[] getBgCornerRadii(Context r100, Float r101, Float r102, Float r103, Float r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        float[] r105 = new float[8];
        if (r101 == null) goto L5;
        float r106 = CJPayBasicUtils.dipToPX(r100, r101.floatValue());
        r105[0] = r106;
        r105[1] = r106;
    L5:
        if (r102 == null) goto L7;
        float r107 = CJPayBasicUtils.dipToPX(r100, r102.floatValue());
        r105[2] = r107;
        r105[3] = r107;
    L7:
        if (r103 == null) goto L9;
        float r108 = CJPayBasicUtils.dipToPX(r100, r103.floatValue());
        r105[4] = r108;
        r105[5] = r108;
    L9:
        if (r104 == null) goto L11;
        float r109 = CJPayBasicUtils.dipToPX(r100, r104.floatValue());
        r105[6] = r109;
        r105[7] = r109;
    L11:
        return r105;
    }
}
