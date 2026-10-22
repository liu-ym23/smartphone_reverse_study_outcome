package hd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import kotlin.jvm.internal.q;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends OvalShape {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20412a;

    public b(Context r10) {
        this.f20412a = r10;
    }

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas r10, Paint r11) {
        if (r11 == null) goto L5;
        Context r12 = this.f20412a;
        q.d(r12);
        r11.setColor(ContextCompat.b(r12, R$color.ConstTextInverse));
    L5:
        if (r11 == null) goto L8;
        r11.setShadowLayer(2.0f, 0.0f, 1.0f, f.l("#40000000"));
    L8:
        super.draw(r10, r11);
    }
}
