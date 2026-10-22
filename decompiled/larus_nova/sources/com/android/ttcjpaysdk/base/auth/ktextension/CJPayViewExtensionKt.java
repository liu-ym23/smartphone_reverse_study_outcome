package com.android.ttcjpaysdk.base.auth.ktextension;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a.\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\r"}, d2 = {"createDrawable", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/content/Context;", "start", "", "end", "corner", "setBgStyle", "", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "startBgColor", "endBgColor", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayViewExtensionKt {
    public static final GradientDrawable createDrawable(Context r100, int r101, int r102, int r103) {
        float r104 = CJPayBasicExtensionKt.dip2px(r103, r100);
        GradientDrawable r105 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{r101, r102});
        r105.setCornerRadii(new float[]{r104, r104, r104, r104, r104, r104, r104, r104});
        return r105;
    }

    public static final void setBgStyle(View r100, Context r101, int r102, int r103, int r104) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r100.setBackground(createDrawable(r101, r102, r103, r104));
        return;
    L8:
        return;
    }
}
