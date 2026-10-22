package com.bytedanceos.appstore.network;

import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.BaseAPIHelper;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends CommonAPIHelper {
    public static void h0(List r10, FetchDataCallBack r11) {
        JSONArray r12 = new JSONArray();
        int r13 = 0;
    L4:
        if (r13 >= r10.size()) goto L6;
        r12.put(r10.get(r13));
        r13 = r13 + 1;
        goto L4
    L6:
        BaseAPIHelper.k(2, 2, 1500000, null, null, r12.toString(), r11);
    }

    public static String i0(String r10) {
        HashMap r11 = new HashMap();
        r11.put("kwd", String.valueOf(r10));
        r11.put("is_share", "1");
        return BaseAPIHelper.d(2, 500001, null, r11);
    }

    public static void j0(FetchDataCallBack r10) {
    }
}
