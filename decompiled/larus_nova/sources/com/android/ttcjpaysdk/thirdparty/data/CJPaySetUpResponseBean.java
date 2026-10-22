package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySetUpResponseBean implements CJPayObject {
    public AuthInfo auth_info;
    public String code;
    public String msg;

    public static class AuthInfo implements CJPayObject {
        public String access_token;
        public String device_data_collection_url;
        public String reference_id;

        public AuthInfo() {
        }
    }

    public CJPaySetUpResponseBean() {
        this.code = "";
        this.msg = "";
        this.auth_info = new AuthInfo();
    }
}
