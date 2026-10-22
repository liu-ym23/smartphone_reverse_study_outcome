package com.android.ttcjpaysdk.base.auth.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayDisplayContent;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "display_desc", "", "display_url", "(Ljava/lang/String;Ljava/lang/String;)V", "parseJson", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTCJPayDisplayContent implements CJPayObject {
    public String display_desc;
    public String display_url;

    /* JADX WARN: Multi-variable type inference failed */
    public TTCJPayDisplayContent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final void parseJson(JSONObject r100) {
        if (r100 == null) goto L5;
        this.display_desc = r100.optString("display_desc");
        this.display_url = r100.optString("display_url");
        return;
    }

    public TTCJPayDisplayContent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "display_desc");
        Intrinsics.checkNotNullParameter(r101, "display_url");
        this.display_desc = r100;
        this.display_url = r101;
    }

    public /* synthetic */ TTCJPayDisplayContent(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
