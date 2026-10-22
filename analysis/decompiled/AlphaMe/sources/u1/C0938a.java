package u1;

import android.content.Context;
import com.stepos.alphame.R;
import f1.AbstractC0557a;

/* renamed from: u1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0938a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f15476f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f15477a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15478b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15479c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15480d;

    /* renamed from: e, reason: collision with root package name */
    public final float f15481e;

    public C0938a(Context context) {
        boolean zW = AbstractC0557a.W(context, R.attr.elevationOverlayEnabled, false);
        Integer numY = AbstractC0557a.y(R.attr.elevationOverlayColor, context);
        int iIntValue = numY != null ? numY.intValue() : 0;
        Integer numY2 = AbstractC0557a.y(R.attr.elevationOverlayAccentColor, context);
        int iIntValue2 = numY2 != null ? numY2.intValue() : 0;
        Integer numY3 = AbstractC0557a.y(R.attr.colorSurface, context);
        int iIntValue3 = numY3 != null ? numY3.intValue() : 0;
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f15477a = zW;
        this.f15478b = iIntValue;
        this.f15479c = iIntValue2;
        this.f15480d = iIntValue3;
        this.f15481e = f4;
    }
}
