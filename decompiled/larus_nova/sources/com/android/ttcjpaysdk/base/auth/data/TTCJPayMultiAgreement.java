package com.android.ttcjpaysdk.base.auth.data;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayMultiAgreement;", "", "one_display_desc", "", "second_display_contents", "", "Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayDisplayContent;", "(Ljava/lang/String;Ljava/util/List;)V", "parseJson", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTCJPayMultiAgreement {
    public String one_display_desc;
    public List<TTCJPayDisplayContent> second_display_contents;

    /* JADX WARN: Multi-variable type inference failed */
    public TTCJPayMultiAgreement() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final void parseJson(JSONObject r100) {
        if (r100 == null) goto L8;
        this.one_display_desc = r100.optString("one_display_desc");
        JSONArray r101 = r100.optJSONArray("second_display_contents");
        if (r101 == null) goto L10;
        int r102 = r101.length();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        List<TTCJPayDisplayContent> r104 = this.second_display_contents;
        TTCJPayDisplayContent r105 = new TTCJPayDisplayContent(null, null, 3, null);
        r105.parseJson(r101.optJSONObject(r103));
        r104.add(r105);
        r103 = r103 + 1;
        goto L6
    L11:
        return;
    L10:
        return;
    }

    public TTCJPayMultiAgreement(String r100, List<TTCJPayDisplayContent> r101) {
        Intrinsics.checkNotNullParameter(r100, "one_display_desc");
        Intrinsics.checkNotNullParameter(r101, "second_display_contents");
        this.one_display_desc = r100;
        this.second_display_contents = r101;
    }

    public /* synthetic */ TTCJPayMultiAgreement(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        this(r100, r101);
    }
}
