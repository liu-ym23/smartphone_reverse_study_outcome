package com.bytedance.android.ec.window.base.floatlayout;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowFloatLayout f49335a;

    public c(WindowFloatLayout r100) {
        this.f49335a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (Intrinsics.areEqual(r100.optString("tag"), this.f49335a.getContainerID()) == false) goto L6;
        this.f49335a.a(r100);
        return;
    }
}
