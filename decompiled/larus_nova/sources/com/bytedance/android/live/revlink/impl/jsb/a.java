package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.BattleLaunchResultModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;
import w20.q7;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f92558a;

    public a(b r100) {
        this.f92558a = r100;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b
    public final void a(q7 r100) {
        Intrinsics.checkNotNullParameter(r100, "battleLaunchResult");
        b r101 = this.f92558a;
        BattleLaunchResultModel r102 = new BattleLaunchResultModel();
        Integer r103 = r100.f557972a;
        JsonObject r104 = null;
        if (r103 == null) goto L16;
        int r105 = r103.intValue();
        if (r105 != (-2)) goto L7;
        BattleLaunchResultModel.Code r106 = BattleLaunchResultModel.Code.NOT_REGISTER;
    L17:
        r102.a(r106);
        JSONObject r107 = r100.f557973b;
        if (r107 == null) goto L23;
        String r108 = GsonProtectorUtils.toJson(l97.a.f508113a, r107);
        if (r108 == null) goto L22;
        r104 = (JsonObject) GsonProtectorUtils.fromJson(l97.a.f508113a, r108, TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)));
    L22:
        r102.b(r104);
    L23:
        r101.finishWithResult(r102);
        return;
    L7:
        if (r105 == (-1)) goto L14;
        if (r105 != 0) goto L10;
        r106 = BattleLaunchResultModel.Code.Failed;
        goto L17
    L10:
        if (r105 == 1) goto L12;
        r106 = BattleLaunchResultModel.Code.Failed;
        goto L17
    L12:
        r106 = BattleLaunchResultModel.Code.Success;
        goto L17
    L14:
        r106 = BattleLaunchResultModel.Code.NO_PERMISSION;
        goto L17
    L16:
        r106 = null;
        goto L17
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b
    public final void onFailed(Throwable r100) {
        this.f92558a.finishWithFailure(r100);
    }
}
