package u0;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f9894a;

    public d(Bitmap bitmap) {
        this.f9894a = bitmap;
    }

    public final int a() {
        Bitmap.Config config = this.f9894a.getConfig();
        q7.k.b(config);
        if (config == Bitmap.Config.ALPHA_8) {
            return 1;
        }
        if (config == Bitmap.Config.RGB_565) {
            return 2;
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return 0;
        }
        if (config == Bitmap.Config.RGBA_F16) {
            return 3;
        }
        return config == Bitmap.Config.HARDWARE ? 4 : 0;
    }
}
