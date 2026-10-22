package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayAppUserInfo implements Serializable, CJPayObject {
    public String avatar_url;
    public String dou_yin_uid;
    public String mobile_mask;
    public String nick_name;

    public CJPayAppUserInfo() {
        this.avatar_url = "";
        this.nick_name = "";
        this.mobile_mask = "";
        this.dou_yin_uid = "";
    }
}
