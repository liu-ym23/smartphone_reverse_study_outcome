package com.bytedance.android.ec.core.monitor;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f45193b;

    public q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneNameStr");
        this.f45192a = r100;
        this.f45193b = null;
    }

    public q(MonitorScenes r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = r100.getSceneName();
    L12:
        this.f45192a = r104;
        this.f45193b = r102;
        return;
    L11:
        r104 = r100.getSceneName() + "_" + r101;
        goto L12
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L9
    }
}
