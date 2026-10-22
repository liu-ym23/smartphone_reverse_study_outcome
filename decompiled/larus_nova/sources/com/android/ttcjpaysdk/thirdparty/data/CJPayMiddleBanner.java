package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayMiddleBanner implements Serializable, CJPayObject {
    public String banner_type;
    public ArrayList<MiddleDiscountBanner> discount_banner;
    public ArrayList<MiddleDiscountUser> discount_users;

    public static class MiddleDiscountBanner implements CJPayObject, Serializable {
        public MiddleDiscountBanner() {
        }
    }

    public static class MiddleDiscountUser implements CJPayObject, Serializable {
        public MiddleDiscountUser() {
        }
    }

    public CJPayMiddleBanner() {
        this.banner_type = "";
        this.discount_banner = new ArrayList();
        this.discount_users = new ArrayList();
    }
}
