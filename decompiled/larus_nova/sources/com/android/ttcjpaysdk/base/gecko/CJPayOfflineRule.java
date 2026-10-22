package com.android.ttcjpaysdk.base.gecko;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayOfflineRule implements CJPayObject {
    public List<CustomConfigBean> custom_config;
    public List<FalconConfigBean> falcon_config;
    public boolean offline_open;

    public static class CustomConfigBean implements CJPayObject {
        public String asset_path;
        public String channel;
        public boolean custom_open;
        public List<String> host;
        public List<HtmlFilesBean> html_files;
        public boolean intercept_html;

        public static class HtmlFilesBean implements CJPayObject {
            public String file;
            public String path;

            public HtmlFilesBean() {
            }
        }

        public CustomConfigBean() {
            this.html_files = new ArrayList();
            this.host = new ArrayList();
        }
    }

    public static class FalconConfigBean implements CJPayObject {
        public boolean falcon_open;
        public List<String> prefix;

        public FalconConfigBean() {
            this.prefix = new ArrayList();
        }
    }

    public CJPayOfflineRule() {
        this.custom_config = new ArrayList();
        this.falcon_config = new ArrayList();
    }
}
