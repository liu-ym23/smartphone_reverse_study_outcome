package com.bytedance.android.ec.hybrid.monitor;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f47563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Map<String, String>> f47564c;

    public h(HybridMonitorScenes r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (StringsKt.isBlank(r101) == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        String r103 = r100.getSceneName();
    L9:
        this.f47562a = r103;
        this.f47563b = null;
        this.f47564c = null;
        return;
    L8:
        r103 = r100.getSceneName() + "_" + r101;
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public /* synthetic */ h(String r100, JSONObject r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(String r100, JSONObject r101, Function0<? extends Map<String, String>> r102) {
        Intrinsics.checkNotNullParameter(r100, "sceneNameStr");
        this.f47562a = r100;
        this.f47563b = r101;
        this.f47564c = r102;
    }
}
