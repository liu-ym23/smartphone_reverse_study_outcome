package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class y implements IFetchEffectListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f92635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f92636b;

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onStart(Effect r100) {
    }

    @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
    public final void onSuccess(Effect r100) {
        Effect r101 = r100;
        JSONObject r102 = new JSONObject();
        r102.put("error_code", 0);
        JSONArray r103 = new JSONArray();
        JSONObject r104 = new JSONObject();
        r104.put(MobConstants.EFFECT_ID, this.f92635a);
        if (r101 == null) goto L6;
        String r105 = r101.getUnzipPath();
        if (r105 == null) goto L6;
    L7:
        r104.put("file_path", r105);
        Unit r106 = Unit.INSTANCE;
        r103.put(r104);
        r102.put("effect_list", r103);
        this.f92636b.b("H5_revenueDownloadEffectsFinished", r102);
        return;
    L6:
        r105 = "";
        goto L7
    }

    public y(String r100, CallContext r101) {
        this.f92635a = r100;
        this.f92636b = r101;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onFail(Effect r100, ExceptionResult r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        JSONObject r102 = new JSONObject();
        r102.put("error_code", -1);
        r102.put("error_msg", r101.getMsg());
        JSONArray r103 = new JSONArray();
        JSONObject r104 = new JSONObject();
        r104.put(MobConstants.EFFECT_ID, this.f92635a);
        Unit r105 = Unit.INSTANCE;
        r103.put(r104);
        r102.put("effect_list", r103);
        this.f92636b.b("H5_revenueDownloadEffectsFinished", r102);
    }
}
