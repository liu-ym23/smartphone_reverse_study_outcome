package com.bytedance.android.shopping.anchorv4.ai;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class m implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f165672a;

    public m(Function1 r100) {
        this.f165672a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f165672a.invoke(r100);
    }
}
