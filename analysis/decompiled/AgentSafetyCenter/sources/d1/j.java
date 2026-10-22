package d1;

import android.graphics.PathMeasure;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public PathMeasure f3001a;

    public final void a(float f5, float f10, h hVar) {
        PathMeasure pathMeasure = this.f3001a;
        if (hVar != null) {
            pathMeasure.getSegment(f5, f10, hVar.f2990a, true);
        } else {
            g5.f.o("Unable to obtain android.graphics.Path");
        }
    }
}
