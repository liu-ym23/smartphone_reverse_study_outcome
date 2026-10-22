package Ba;

import Ca.C0202a;
import N9.j;
import android.app.Application;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import z2.l;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f269a = new ConcurrentHashMap();

    public static Point b(int i) {
        WindowMetrics currentWindowMetrics;
        int i6;
        Application application = l.b;
        Rect bounds = null;
        if (application == null) {
            k.n("application");
            throw null;
        }
        Object systemService = application.getSystemService("display");
        DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
        Display display = displayManager != null ? displayManager.getDisplay(i) : null;
        if (display != null) {
            Point point = new Point();
            display.getRealSize(point);
            int i10 = point.x;
            if (i10 > 0 && (i6 = point.y) > 0) {
                StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "Screen size from DisplayManager: displayId=", i10, ", ", " x ");
                sbS.append(i6);
                j.F(sbS.toString(), "DefaultCoordinateTransformer");
                return point;
            }
        }
        Object systemService2 = application.getSystemService("window");
        WindowManager windowManager = systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null;
        if (windowManager != null && (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) != null) {
            bounds = currentWindowMetrics.getBounds();
        }
        j.F("Screen size bounds (fallback): " + bounds, "DefaultCoordinateTransformer");
        return new Point(bounds != null ? bounds.width() : Na.d.f1028a, bounds != null ? bounds.height() : Na.d.b);
    }

    public final Point a() {
        Point pointB;
        Integer num = (Integer) C0202a.f344a.get();
        int iIntValue = num != null ? num.intValue() : 0;
        Point point = (Point) this.f269a.get(Integer.valueOf(iIntValue));
        if (point != null) {
            return point;
        }
        synchronized (this) {
            Point point2 = (Point) this.f269a.get(Integer.valueOf(iIntValue));
            if (point2 != null) {
                return point2;
            }
            try {
                pointB = b(iIntValue);
                this.f269a.put(Integer.valueOf(iIntValue), pointB);
                j.F("Screen size cached: displayId=" + iIntValue + ", " + pointB.x + " x " + pointB.y, "DefaultCoordinateTransformer");
            } catch (Exception e) {
                j.G("Failed to get screen size: " + e.getMessage(), "DefaultCoordinateTransformer");
                pointB = null;
            }
            return pointB;
        }
    }
}
