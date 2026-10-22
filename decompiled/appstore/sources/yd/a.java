package yd;

import android.app.Activity;
import android.graphics.Rect;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26247a = null;

    static {
        f26247a = new a();
    }

    public a() {
    }

    public final Rect a(Activity r10) {
        q.g(r10, "activity");
        Rect r11 = r10.getWindowManager().getCurrentWindowMetrics().getBounds();
        q.f(r11, "activity.windowManager.currentWindowMetrics.bounds");
        return r11;
    }
}
