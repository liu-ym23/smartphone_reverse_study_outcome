package b;

import android.os.Build;
import android.window.BackEvent;
import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f2986a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2987b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2988c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2989d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2990e;

    public a(BackEvent backEvent) {
        kotlin.jvm.internal.g.f(backEvent, "backEvent");
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        float progress = backEvent.getProgress();
        int swipeEdge = backEvent.getSwipeEdge();
        long jK = Build.VERSION.SDK_INT >= 36 ? b1.K(backEvent) : 0L;
        this.f2986a = touchX;
        this.f2987b = touchY;
        this.f2988c = progress;
        this.f2989d = swipeEdge;
        this.f2990e = jK;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.f2986a + ", touchY=" + this.f2987b + ", progress=" + this.f2988c + ", swipeEdge=" + this.f2989d + ", frameTimeMillis=" + this.f2990e + '}';
    }
}
