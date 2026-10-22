package com.bytedance.android.livesdk.jsbridge.methods;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class n2 implements v80.b.InterfaceC7971b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o2 f142160a;

    public n2(o2 r100) {
        this.f142160a = r100;
    }

    @Override // v80.b.InterfaceC7971b
    public final void a(boolean r100, int r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r103, "extra");
        if (r100 == false) goto L5;
        o2 r104 = this.f142160a;
        JSONObject r105 = new JSONObject();
        r105.put("err_code", 0);
        r105.put("ext_data", r103);
        Unit r106 = Unit.INSTANCE;
        r104.finishWithResult(r105);
        return;
    L5:
        o2 r107 = this.f142160a;
        JSONObject r108 = new JSONObject();
        r108.put("err_code", r101);
        r108.put("msg", r102);
        r108.put("ext_data", r103);
        Unit r109 = Unit.INSTANCE;
        r107.finishWithResult(r108);
    }
}
