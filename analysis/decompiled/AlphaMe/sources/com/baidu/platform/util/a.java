package com.baidu.platform.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.stepos.alphame.utils.Consts;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements ParamBuilder<a> {

    /* renamed from: a, reason: collision with root package name */
    protected Map<String, String> f9402a;

    public a a(String str, String str2) {
        if (this.f9402a == null) {
            this.f9402a = new LinkedHashMap();
        }
        this.f9402a.put(str, str2);
        return this;
    }

    public String a() {
        Map<String, String> map = this.f9402a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i4 = 0;
        for (String str2 : this.f9402a.keySet()) {
            String strEncodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f9402a.get(str2));
            str = i4 == 0 ? str + str2 + Consts.SPLITTER_EQUAL + strEncodeUrlParamsValue : str + "&" + str2 + Consts.SPLITTER_EQUAL + strEncodeUrlParamsValue;
            i4++;
        }
        return str;
    }
}
