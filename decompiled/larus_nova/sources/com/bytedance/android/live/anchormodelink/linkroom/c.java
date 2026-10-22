package com.bytedance.android.live.anchormodelink.linkroom;

import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ my.d f58742b;

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        boolean r101 = iy.b.f496463a;
        iy.b.b("[LinkBasicJsbHandler] checkPermission fail linkType=" + this.f58741a);
        my.d r102 = this.f58742b;
        JsonObject r103 = new JsonObject();
        r103.addProperty(EventConstant.Value.HAS_PERMISSION, Boolean.FALSE);
        Unit r104 = Unit.INSTANCE;
        r102.a(0, "fail", r103);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        boolean r101 = iy.b.f496463a;
        iy.b.d("[LinkBasicJsbHandler] checkPermission suc linkType=" + this.f58741a);
        my.d r102 = this.f58742b;
        JsonObject r103 = new JsonObject();
        r103.addProperty(EventConstant.Value.HAS_PERMISSION, Boolean.TRUE);
        Unit r104 = Unit.INSTANCE;
        r102.a(1, "", r103);
    }

    public c(int r100, k r101) {
        this.f58741a = r100;
        this.f58742b = r101;
    }
}
