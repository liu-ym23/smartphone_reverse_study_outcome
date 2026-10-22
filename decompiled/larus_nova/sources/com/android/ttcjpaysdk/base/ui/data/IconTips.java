package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class IconTips implements CJPayObject, Serializable {
    public String button_desc;
    public String content_alignment;
    public ArrayList<ContentInfo> content_list;
    public String error_code;
    public String error_message;
    public String icon_type;
    public String title;

    public static class ContentInfo implements CJPayObject, Serializable {
        public String sub_content;
        public String sub_title;

        public ContentInfo() {
            this.sub_title = "";
            this.sub_content = "";
        }
    }

    public IconTips() {
        this.title = "";
        this.content_list = new ArrayList();
        this.button_desc = "";
        this.content_alignment = "";
        this.icon_type = "";
        this.error_code = "";
        this.error_message = "";
    }
}
