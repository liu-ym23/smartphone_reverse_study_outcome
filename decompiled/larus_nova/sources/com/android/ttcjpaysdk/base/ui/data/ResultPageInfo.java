package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class ResultPageInfo implements CJPayObject, Serializable {
    public Assets assets;
    public ResultButtonInfo button_info;
    public ArrayList<DynamicComponent> dynamic_components;
    public String dynamic_data;
    public MoreShowInfo more_show_info;
    public RenderInfo render_info;
    public ArrayList<ShowInfo> show_infos;
    public VoucherOptions voucher_options;

    public static class Assets implements CJPayObject, Serializable {
        public String bg_image;
        public String show_image;
        public String tip_image;

        public Assets() {
        }
    }

    public static class DynamicComponent implements CJPayObject, Serializable {
        public String name;
        public String schema;
        public String url;

        public DynamicComponent() {
        }
    }

    public static class MoreShowInfo implements CJPayObject, Serializable {
        public String desc;
        public String name;
        public String show_num;

        public MoreShowInfo() {
        }
    }

    public static class RenderInfo implements CJPayObject, Serializable {
        public String h5_url;
        public String lynx_url;
        public String type;

        public RenderInfo() {
        }
    }

    public static class ResultButtonInfo implements CJPayObject, Serializable {
        public String action;
        public String desc;
        public String type;

        public ResultButtonInfo() {
        }
    }

    public static class ShowInfo implements CJPayObject, Serializable {
        public String desc;
        public String icon;
        public String name;

        public ShowInfo() {
        }
    }

    public static class VoucherOptions implements CJPayObject, Serializable {
        public String desc;

        public VoucherOptions() {
        }
    }

    public ResultPageInfo() {
        this.button_info = new ResultButtonInfo();
        this.assets = new Assets();
        this.show_infos = new ArrayList();
        this.voucher_options = new VoucherOptions();
        this.render_info = new RenderInfo();
        this.dynamic_components = new ArrayList();
        this.dynamic_data = "";
    }
}
