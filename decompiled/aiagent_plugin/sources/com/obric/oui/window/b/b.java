package com.obric.oui.window.b;

import android.app.Activity;
import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: WindowSizeCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f36871a = null;

    static {
        f36871a = new b();
    }

    private b() {
    }

    public final Rect a(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        o.e(r1, "activity");
        Rect r3 = r1.getWindowManager().getCurrentWindowMetrics().getBounds();
        o.c(r3, "activity.windowManager.currentWindowMetrics.bounds");
        return r3;
    }
}
