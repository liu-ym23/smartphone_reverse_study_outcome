package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayUnionPassParams implements Serializable, CJPayObject {
    public CJPayPassParamsExt ext;
    public boolean is_need_union_pass;
    public String url;

    public static class CJPayPassParamsExt implements Serializable, CJPayObject {
        public String redirectUrl;

        public CJPayPassParamsExt() {
            this.redirectUrl = "";
        }
    }

    public CJPayUnionPassParams() {
        this.is_need_union_pass = false;
        this.url = "";
        this.ext = new CJPayPassParamsExt();
    }
}
