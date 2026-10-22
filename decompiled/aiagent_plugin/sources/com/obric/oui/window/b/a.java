package com.obric.oui.window.b;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: WindowSizeCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36870a = null;

    static {
        f36870a = new a();
    }

    private a() {
    }

    public final boolean a(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        o.e(r1, "activity");
        return r1.isInMultiWindowMode();
    }
}
