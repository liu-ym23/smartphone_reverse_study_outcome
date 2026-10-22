package com.bytedanceos.common.ad.entity.rep;

/* JADX INFO: loaded from: classes2.dex */
public class RepSetEntity {
    private int atype;
    private Settings settings;

    public static class Settings {
        private String aid;
        private int display_time;
        private int enable_click;
        private int enable_skip;
        private int frame_index;
        private int show_ad_number;
        private int show_category_name;
        private int show_filesize;
        private int show_recmd_brief;

        public Settings() {
            this.frame_index = 0;
            this.display_time = 0;
            this.enable_click = 0;
            this.enable_skip = 1;
            this.aid = "";
            this.show_ad_number = 0;
            this.show_recmd_brief = 0;
            this.show_filesize = 0;
            this.show_category_name = 0;
        }

        public String getAid() {
            return this.aid;
        }

        public int getDisplay_time() {
            return this.display_time;
        }

        public int getEnable_click() {
            return this.enable_click;
        }

        public int getEnable_skip() {
            return this.enable_skip;
        }

        public int getFrame_index() {
            return this.frame_index;
        }

        public int getShow_ad_number() {
            return this.show_ad_number;
        }

        public int getShow_category_name() {
            return this.show_category_name;
        }

        public int getShow_filesize() {
            return this.show_filesize;
        }

        public int getShow_recmd_brief() {
            return this.show_recmd_brief;
        }

        public void setAid(String r10) {
            this.aid = r10;
        }

        public void setDisplay_time(int r10) {
            this.display_time = r10;
        }

        public void setEnable_click(int r10) {
            this.enable_click = r10;
        }

        public void setEnable_skip(int r10) {
            this.enable_skip = r10;
        }

        public void setFrame_index(int r10) {
            this.frame_index = r10;
        }

        public void setShow_ad_number(int r10) {
            this.show_ad_number = r10;
        }

        public void setShow_category_name(int r10) {
            this.show_category_name = r10;
        }

        public void setShow_filesize(int r10) {
            this.show_filesize = r10;
        }

        public void setShow_recmd_brief(int r10) {
            this.show_recmd_brief = r10;
        }
    }

    public RepSetEntity() {
        this.atype = 0;
    }

    public int getAtype() {
        return this.atype;
    }

    public Settings getSettings() {
        Settings r10 = this.settings;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new Settings();
    }

    public void setAtype(int r10) {
        this.atype = r10;
    }

    public void setSettings(Settings r10) {
        this.settings = r10;
    }
}
