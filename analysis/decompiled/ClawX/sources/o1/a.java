package o1;

import android.content.Context;
import android.util.TypedValue;
import com.stepos.stepclaw.R;
import k4.v;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f4296f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4297a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4298b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4299c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final float f4300e;

    public a(Context context) {
        TypedValue typedValueD = z.D(context, R.attr.elevationOverlayEnabled);
        boolean z = (typedValueD == null || typedValueD.type != 18 || typedValueD.data == 0) ? false : true;
        int iA = v.A(context, R.attr.elevationOverlayColor, 0);
        int iA2 = v.A(context, R.attr.elevationOverlayAccentColor, 0);
        int iA3 = v.A(context, R.attr.colorSurface, 0);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.f4297a = z;
        this.f4298b = iA;
        this.f4299c = iA2;
        this.d = iA3;
        this.f4300e = f3;
    }
}
