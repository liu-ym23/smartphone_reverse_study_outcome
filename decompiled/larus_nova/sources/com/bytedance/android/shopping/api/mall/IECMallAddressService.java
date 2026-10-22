package com.bytedance.android.shopping.api.mall;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0005\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J&\u0010\u0005\u001a\u0004\u0018\u00010\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J8\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallAddressService;", "", "btmNode", "", "btm", "getAddress", "", "simpleMode", "Lorg/json/JSONObject;", "address", "", "sourceType", "isSession", "Lcom/bytedance/android/shopping/api/mall/n;", "callback", "Lcom/bytedance/android/shopping/api/mall/o;", "mallExtraParams", "", "setAddress", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallAddressService {
    String getAddress(Object r100, String r101);

    JSONObject getAddress(Object r100, String r101, boolean r102);

    void setAddress(JSONObject r100, int r101, boolean r102, n r103, o r104);
}
