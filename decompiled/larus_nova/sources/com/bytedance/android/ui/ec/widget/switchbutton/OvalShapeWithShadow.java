package com.bytedance.android.ui.ec.widget.switchbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/switchbutton/OvalShapeWithShadow;", "Landroid/graphics/drawable/shapes/OvalShape;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OvalShapeWithShadow extends OvalShape {
    private Context context;

    public final Context getContext() {
        return this.context;
    }

    public OvalShapeWithShadow(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
    }

    public final void setContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.context = r100;
    }

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas r100, Paint r101) {
        if (r101 == null) goto L4;
        r101.setColor(ContextCompat.getColor(this.context, R.color.ec_dux_text_inverse));
    L4:
        if (r101 == null) goto L6;
        r101.setShadowLayer(2.0f, 0.0f, 1.0f, ContextCompat.getColor(this.context, R.color.ec_color_black_25));
    L6:
        super.draw(r100, r101);
    }
}
