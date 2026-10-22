package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.extensions.layout.WindowLayoutInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5306a = null;

    static {
        f5306a = new d();
    }

    public d() {
    }

    public final FoldingFeature a(Activity r10, androidx.window.extensions.layout.FoldingFeature r11) {
        q.g(r10, "activity");
        q.g(r11, "oemFeature");
        int r12 = r11.getType();
        if (r12 == 1) goto L7;
        if (r12 == 2) goto L6;
        return null;
    L6:
        e.b r13 = e.b.f5311b.b();
    L8:
        int r14 = r11.getState();
        if (r14 == 1) goto L13;
        if (r14 == 2) goto L12;
        return null;
    L12:
        FoldingFeature.c r15 = FoldingFeature.c.f5261d;
    L14:
        Rect r16 = r11.getBounds();
        q.f(r16, "oemFeature.bounds");
        if (c(r10, new androidx.window.core.b(r16)) == false) goto L18;
        Rect r17 = r11.getBounds();
        q.f(r17, "oemFeature.bounds");
        return new e(new androidx.window.core.b(r17), r13, r15);
    L18:
        return null;
    L13:
        r15 = FoldingFeature.c.f5260c;
        goto L14
    L7:
        r13 = e.b.f5311b.a();
        goto L8
    }

    public final i b(Activity r10, WindowLayoutInfo r11) {
        q.g(r10, "activity");
        q.g(r11, ServerElements.INFO);
        List r12 = r11.getDisplayFeatures();
        q.f(r12, "info.displayFeatures");
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L13;
        androidx.window.extensions.layout.FoldingFeature r15 = (androidx.window.extensions.layout.DisplayFeature) r14.next();
        if ((r15 instanceof androidx.window.extensions.layout.FoldingFeature) == false) goto L8;
        d r16 = f5306a;
        q.f(r15, "feature");
        FoldingFeature r17 = r16.a(r10, r15);
    L9:
        if (r17 == null) goto L4;
        r13.add(r17);
        goto L4
    L8:
        r17 = null;
        goto L9
    L13:
        return new i(r13);
    }

    public final boolean c(Activity r10, androidx.window.core.b r11) {
        Rect r12 = k.f5330a.computeCurrentWindowMetrics(r10).a();
        if (r11.e() == false) goto L6;
        return false;
    L6:
        if (r11.d() == r12.width()) goto L11;
        if (r11.a() == r12.height()) goto L11;
        return false;
    L11:
        if (r11.d() >= r12.width()) goto L16;
        if (r11.a() >= r12.height()) goto L16;
        return false;
    L16:
        if (r11.d() == r12.width()) goto L18;
        return true;
    L18:
        if (r11.a() != r12.height()) goto L22;
        return false;
    L22:
        return true;
    }
}
