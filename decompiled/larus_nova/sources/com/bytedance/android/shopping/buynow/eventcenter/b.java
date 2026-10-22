package com.bytedance.android.shopping.buynow.eventcenter;

import com.bytedance.android.shopping.anchorv4.event.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f170923a;

    public b(c r100) {
        this.f170923a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Function1<JSONObject, Unit> r101 = this.f170923a.f166535b;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(r100);
        return;
    }
}
