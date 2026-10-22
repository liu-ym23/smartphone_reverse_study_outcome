package com.obric.oui.oswitch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import androidx.core.content.a;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OSwitchBak.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OvalShapeWithShadow extends OvalShape {
    private Context context;

    public OvalShapeWithShadow(Context r3) {
        this.context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context r3) {
        this.context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas r5, Paint r6) {
        if (r6 == null) goto L5;
        Context r0 = this.context;
        o.a(r0);
        r6.setColor(a.c(r0, ZeusTransformUtils.mapRes(R.color.ConstTextInverse, "color", "ConstTextInverse")));
    L5:
        if (r6 == null) goto L8;
        r6.setShadowLayer(2.0f, 0.0f, 1.0f, g.a("#40000000"));
    L8:
        super.draw(r5, r6);
    }
}
