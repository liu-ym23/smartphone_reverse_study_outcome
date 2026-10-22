package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class QrCodeData implements CJPayObject {
    public String data;
    public String image_url;
    public String logo;
    public String share_desc;
    public ShareImage share_image;
    public boolean share_image_switch;
    public String theme_color;

    public static class ShareImage implements CJPayObject {
        public String payee_name;
        public String username_desc;
        public String validity_desc;

        public ShareImage() {
            this.payee_name = "";
            this.username_desc = "";
            this.validity_desc = "";
        }
    }

    public QrCodeData() {
        this.image_url = "";
        this.data = "";
        this.logo = "";
        this.theme_color = "";
        this.share_image_switch = false;
        this.share_desc = "";
        this.share_image = new ShareImage();
    }
}
