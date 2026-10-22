package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class s1 implements com.bytedance.android.gamecp.base.core.service.depend.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r1 f57535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f57536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UploadGameCPImageResultModel.a f57537c;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.j
    public final void onSuccess(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonArray");
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r100, r102);
        String r104 = r103.optString("key");
        String r105 = r103.optString("uri");
        ArrayList r106 = this.f57536b;
        UploadGameCPImageResultModel.b r107 = new UploadGameCPImageResultModel.b();
        r107.a(r104);
        r107.b(r105);
        Unit r108 = Unit.INSTANCE;
        r106.add(r107);
        r102 = r102 + 1;
        goto L3
    L5:
        this.f57537c.a(this.f57536b);
        r1 r109 = this.f57535a;
        UploadGameCPImageResultModel r110 = new UploadGameCPImageResultModel();
        r110.a(UploadGameCPImageResultModel.Code.Success);
        r110.b(this.f57537c);
        Unit r111 = Unit.INSTANCE;
        r109.finishWithResult(r110);
    }

    public s1(r1 r100, ArrayList r101, UploadGameCPImageResultModel.a r102) {
        this.f57535a = r100;
        this.f57536b = r101;
        this.f57537c = r102;
    }
}
