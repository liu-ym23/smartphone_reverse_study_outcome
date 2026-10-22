package com.bytedance.android.live.browser.jsbridge.newmethods;

import androidx.core.app.NotificationCompat;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j5 implements Callback<JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetVisualEventTrackingSettingsMethod f63466a;

    public j5(GetVisualEventTrackingSettingsMethod r100) {
        this.f63466a = r100;
    }

    @Override // com.bytedance.retrofit2.Callback
    public final void onFailure(Call<JsonObject> r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "t");
        this.f63466a.finishWithFailure(r101);
    }

    @Override // com.bytedance.retrofit2.Callback
    public final void onResponse(Call<JsonObject> r100, SsResponse<JsonObject> r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "response");
        JsonArray r102 = r101.body().getAsJsonArray("data");
        this.f63466a.j(r102);
        GetVisualEventTrackingSettingsMethod.f63247a = r102;
    }
}
