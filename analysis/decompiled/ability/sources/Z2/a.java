package Z2;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import c3.AbstractC0872b;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class a {
    public static final int f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1583a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public a(Context context) {
        boolean zB = AbstractC0872b.b(context, R.attr.elevationOverlayEnabled, false);
        Integer numB = W2.a.b(R.attr.elevationOverlayColor, context);
        int iIntValue = numB != null ? numB.intValue() : 0;
        Integer numB2 = W2.a.b(R.attr.elevationOverlayAccentColor, context);
        int iIntValue2 = numB2 != null ? numB2.intValue() : 0;
        Integer numB3 = W2.a.b(R.attr.colorSurface, context);
        int iIntValue3 = numB3 != null ? numB3.intValue() : 0;
        float f7 = context.getResources().getDisplayMetrics().density;
        this.f1583a = zB;
        this.b = iIntValue;
        this.c = iIntValue2;
        this.d = iIntValue3;
        this.e = f7;
    }

    public final int a(float f7, int i) {
        int i6;
        if (!this.f1583a || ColorUtils.setAlphaComponent(i, 255) != this.d) {
            return i;
        }
        float fMin = (this.e <= 0.0f || f7 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f7 / r1)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iC = W2.a.c(fMin, ColorUtils.setAlphaComponent(i, 255), this.b);
        if (fMin > 0.0f && (i6 = this.c) != 0) {
            iC = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i6, f), iC);
        }
        return ColorUtils.setAlphaComponent(iC, iAlpha);
    }
}
