package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostOCRProxy;
import com.bytedance.android.livehostapi.business.depend.IHostReady;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&J,\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&JT\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00152\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostAliYunVerifyProxy;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livehostapi/business/base/IBaseHostOCRProxy;", "Lcom/bytedance/android/livehostapi/business/depend/IHostReady;", "getMetaInfos", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getSession", "Lorg/json/JSONObject;", "install", "", "verify", "certifyId", "useMsgBox", "", "callback", "Lcom/bytedance/android/livehostapi/business/IHostAliYunVerifyProxy$ProxyZIMCallback;", "zimId", "extParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ProxyZIMCallback", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostAliYunVerifyProxy extends IService, IBaseHostOCRProxy, IHostReady {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostAliYunVerifyProxy$ProxyZIMCallback;", "", "response", "", "jsonObject", "Lorg/json/JSONObject;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ProxyZIMCallback {
        boolean response(JSONObject r100);
    }

    String getMetaInfos(Context r100);

    JSONObject getSession(Context r100);

    void install(Context r100);

    void verify(Context r100, String r101, boolean r102, ProxyZIMCallback r103);

    void verify(Context r100, String r101, boolean r102, HashMap<String, String> r103, ProxyZIMCallback r104);
}
