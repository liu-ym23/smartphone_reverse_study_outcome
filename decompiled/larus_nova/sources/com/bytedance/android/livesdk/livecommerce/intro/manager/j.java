package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.util.SparseArray;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f148412a;

    public j(i r100) {
        this.f148412a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r101 = this.f148412a.f148399d;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.keyAt(r103);
        r101.valueAt(r103).a(r100);
        r103 = r103 + 1;
        goto L3
    }
}
