package com.android.ttcjpaysdk.thirdparty.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class FastPayGuideInfo implements CJPayObject, Serializable {
    public String button_text;
    public String button_text_after_open;
    public List<GuideBarItem> guide_bar;
    public MoreBean more;
    public boolean need_guide;
    public Map<String, String> protocol_group_names;
    public List<ProtocolItem> protocol_list;
    public String title;

    public static class GuideBarItem implements CJPayObject, Serializable {
        public String msg;
        public String title;

        public GuideBarItem() {
            this.title = "";
            this.msg = "";
        }
    }

    public static class MoreBean implements CJPayObject, Serializable {
        public DescriptionBean description;
        public PromotionInfoBean promotion_info;
        public String title;

        public static class DescriptionBean implements CJPayObject, Serializable {
            public List<ContentBean> content;
            public String title;

            public static class ContentBean implements CJPayObject, Serializable {
                public String description;
                public String summary;

                public ContentBean() {
                    this.summary = "";
                    this.description = "";
                }
            }

            public DescriptionBean() {
                this.title = "";
                this.content = new ArrayList();
            }
        }

        public static class PromotionInfoBean implements CJPayObject, Serializable {
            public String description;
            public String summary;
            public String title;

            public PromotionInfoBean() {
                this.title = "";
                this.summary = "";
                this.description = "";
            }
        }

        public MoreBean() {
            this.title = "";
            this.promotion_info = new PromotionInfoBean();
            this.description = new DescriptionBean();
        }
    }

    public static class ProtocolItem implements CJPayObject, Serializable {
        public String group;
        public String name;
        public String template_url;

        public ProtocolItem() {
            this.group = "";
            this.name = "";
            this.template_url = "";
        }
    }

    public FastPayGuideInfo() {
        this.need_guide = false;
        this.title = "";
        this.more = new MoreBean();
        this.guide_bar = new ArrayList();
        this.protocol_group_names = new HashMap();
        this.protocol_list = new ArrayList();
        this.button_text = "";
        this.button_text_after_open = "";
    }

    public ArrayList<JSONObject> getProtocolJsonListByGroup(String r100) {
        ArrayList<JSONObject> r101 = new ArrayList();
        List<ProtocolItem> r102 = this.protocol_list;     // Catch: Exception -> L14
        if (r102 != null) goto L6;
    L16:
        return r101;
    L6:
        if (r102.size() <= 0) goto L16;
        int r103 = 0;
    L9:
        if (r103 >= this.protocol_list.size()) goto L16;
        if (r100.equals(((ProtocolItem) ListProtector.get(this.protocol_list, r103)).group) == false) goto L13;
        r101.add(CJPayJsonParser.toJsonObject((ProtocolItem) ListProtector.get(this.protocol_list, r103)));     // Catch: Exception -> L14
    L13:
        r103 = r103 + 1;
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FastPayGuideInfo#getProtocolJsonListByGroup", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FastPayGuideInfo#getProtocolJsonListByGroup", e);
        goto L16
    }
}
