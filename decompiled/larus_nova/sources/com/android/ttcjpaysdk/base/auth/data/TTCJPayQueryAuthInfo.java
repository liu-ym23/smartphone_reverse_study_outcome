package com.android.ttcjpaysdk.base.auth.data;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayQueryAuthInfo;", "Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayAuthBase;", "authorization_agreement_info", "Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayAuthContent;", "is_authorize", "", "is_auth", "(Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayAuthContent;II)V", "parseJson", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTCJPayQueryAuthInfo extends TTCJPayAuthBase {
    public TTCJPayAuthContent authorization_agreement_info;
    public int is_auth;
    public int is_authorize;

    public TTCJPayQueryAuthInfo() {
        this(null, 0, 0, 7, null);
    }

    public final void parseJson(JSONObject r100) {
        if (r100 == null) goto L5;
        this.code = r100.optString("code");
        this.msg = r100.optString("msg");
        this.is_authorize = r100.optInt("is_authorize");
        this.is_auth = r100.optInt("is_auth");
        this.authorization_agreement_info.parseJson(r100.optJSONObject("authorization_agreement_info"));
        return;
    }

    public TTCJPayQueryAuthInfo(TTCJPayAuthContent r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "authorization_agreement_info");
        super(null, null, 3, null);
        this.authorization_agreement_info = r100;
        this.is_authorize = r101;
        this.is_auth = r102;
    }

    public /* synthetic */ TTCJPayQueryAuthInfo(TTCJPayAuthContent r110, int r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r110 = new TTCJPayAuthContent(null, null, null, null, 0, null, null, 127, null);
    L6:
        if ((r113 & 2) == 0) goto L9;
        r111 = 0;
    L9:
        if ((r113 & 4) == 0) goto L11;
        r112 = 0;
    L11:
        this(r110, r111, r112);
    }
}
