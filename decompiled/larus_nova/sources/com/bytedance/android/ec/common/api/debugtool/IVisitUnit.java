package com.bytedance.android.ec.common.api.debugtool;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/common/api/debugtool/IVisitUnit;", "", "hookToDirectCall", "", "routeName", "", "params", "Lkotlin/Function0;", "Lorg/json/JSONObject;", "hookToRequest", "hookToSchema", "schema", "startDisplayRoutesDebug", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "jsonObject", "startDisplayRoutesRecords", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IVisitUnit {
    void hookToDirectCall(String r100, Function0<? extends JSONObject> r101);

    void hookToRequest(String r100, Function0<? extends JSONObject> r101);

    void hookToSchema(String r100, Function0<String> r101);

    void startDisplayRoutesDebug(FrameLayout r100, Function0<? extends JSONObject> r101);

    void startDisplayRoutesRecords(Context r100);
}
