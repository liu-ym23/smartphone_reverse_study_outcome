package com.android.ttcjpaysdk.base.service;

import android.view.View;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ITTCJPayComponent;", "", "confirm", "", "invokeData", "Lorg/json/JSONObject;", "getDynamicBizParams", "getPayParams", "getPayView", "Landroid/view/View;", "componentData", "refresh", "", "release", "setHostApi", "hostApi", "Lcom/android/ttcjpaysdk/base/service/IHostApi;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITTCJPayComponent {
    void confirm(JSONObject r100);

    JSONObject getDynamicBizParams();

    JSONObject getPayParams();

    View getPayView(JSONObject r100);

    boolean refresh(JSONObject r100);

    void release();

    void setHostApi(IHostApi r100);
}
