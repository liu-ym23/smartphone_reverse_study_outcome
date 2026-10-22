package s4;

import android.content.Context;
import com.stepos.aiengine.R;
import w4.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f11883f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11884a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11885b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11886c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11887d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11888e;

    public a(Context context) {
        boolean zB = b.b(context, R.attr.elevationOverlayEnabled, false);
        Integer numT = jd.b.t(R.attr.elevationOverlayColor, context);
        int iIntValue = numT != null ? numT.intValue() : 0;
        Integer numT2 = jd.b.t(R.attr.elevationOverlayAccentColor, context);
        int iIntValue2 = numT2 != null ? numT2.intValue() : 0;
        Integer numT3 = jd.b.t(R.attr.colorSurface, context);
        int iIntValue3 = numT3 != null ? numT3.intValue() : 0;
        float f8 = context.getResources().getDisplayMetrics().density;
        this.f11884a = zB;
        this.f11885b = iIntValue;
        this.f11886c = iIntValue2;
        this.f11887d = iIntValue3;
        this.f11888e = f8;
    }
}
