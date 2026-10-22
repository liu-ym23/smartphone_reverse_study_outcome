package com.android.ttcjpaysdk.base.auth.data;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayCreateAuthorization;", "Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayAuthBase;", "authorize_state", "", "(I)V", "parseJson", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTCJPayCreateAuthorization extends TTCJPayAuthBase {
    public int authorize_state;

    public TTCJPayCreateAuthorization() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public TTCJPayCreateAuthorization(int r100) {
        super(null, null, 3, null);
        this.authorize_state = r100;
    }

    public final void parseJson(JSONObject r100) {
        if (r100 == null) goto L7;
        this.code = r100.optString("code");
        this.msg = r100.optString("msg");
        JSONObject r101 = r100.optJSONObject("base_authorization_info");
        if (r101 == null) goto L8;
        this.authorize_state = r101.optInt("authorize_state");
        return;
    L8:
        return;
    }

    public /* synthetic */ TTCJPayCreateAuthorization(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
