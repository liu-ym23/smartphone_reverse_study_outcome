package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001Jx\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostVerify;", "Lcom/bytedance/android/live/base/IService;", "doFaceLive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "identityParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "verifyParams", "extraParams", "Lorg/json/JSONObject;", "faceOnly", "", "callback", "Lcom/bytedance/android/livehostapi/business/depend/ILiveFaceCertCallback;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareHostVerify extends IService {
    void doFaceLive(Context r100, HashMap<String, String> r101, HashMap<String, String> r102, JSONObject r103, boolean r104, ILiveFaceCertCallback r105);
}
