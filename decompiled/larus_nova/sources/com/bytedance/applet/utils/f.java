package com.bytedance.applet.utils;

import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f192283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f192284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function3<Integer, String, String, Boolean> f192285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f192286d;

    @Override // com.bytedance.applet.utils.d
    public final void a(boolean r310, boolean r311, boolean r312) {
        if (r310 == false) goto L5;
        String r100 = "Location has succeeded.";
    L10:
        FLogger.f375446a.i("LocationUiAppActionInterceptor", "location uiu result success=" + r310 + " permissionDenied=" + r311 + " isPermissionServiceDisabled=" + r312 + " msgId=" + this.f192283a + " questionId=" + this.f192284b);
        boolean r101 = false;
        if (r310 == false) goto L13;
        int r102 = 0;
    L18:
        Function3<Integer, String, String, Boolean> r103 = this.f192285c;
        e r104 = this.f192286d;
        JSONObject r105 = new JSONObject();
        JSONArray r106 = new JSONArray();
        JSONObject r107 = new JSONObject();
        r107.put("type", "text");
        r107.put("text", r100);
        Unit r110 = Unit.INSTANCE;
        r105.put("content", r106.put(r107));
        if (r102 == 0) goto L21;
        r101 = true;
    L21:
        r105.put("isError", r101);
        JSONObject r108 = new JSONObject();
        r108.put("errorCode", r102);
        r108.put("errorMsg", r100);
        r105.put("structuredContent", r108);
        String r109 = r105.toString();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r109, "jsonString");
        r103.invoke(0, "", StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r109, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null), "\t", "\\t", false, 4, null));
        return;
    L13:
        if (r311 == false) goto L15;
        r102 = TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY;
        goto L18
    L15:
        if (r312 == false) goto L17;
        r102 = TTVideoEngineInterface.ALGO_OPTION_INT_CACHE_TIMESTAMP;
        goto L18
    L17:
        r102 = TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND;
        goto L18
    L5:
        if (r311 == false) goto L7;
        r100 = "Location failed for lack of application permission.";
        goto L10
    L7:
        if (r312 == false) goto L9;
        r100 = "Location failed because location service is disabled.";
        goto L10
    L9:
        r100 = "Location failed to get result.";
        goto L10
    }

    public f(String r100, String r101, com.bytedance.applet.event.a r102, e r103) {
        this.f192283a = r100;
        this.f192284b = r101;
        this.f192285c = r102;
        this.f192286d = r103;
    }
}
