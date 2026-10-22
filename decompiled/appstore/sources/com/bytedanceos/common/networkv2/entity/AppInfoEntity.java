package com.bytedanceos.common.networkv2.entity;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfoEntity extends AppEntity {
    private String apk_file;
    private String banner;
    private String brief;
    private List<AppCategoryEntity> category_info;
    private String cid;
    private String cname;
    private String comments;
    private String create_time;
    private String developer;
    private String dever_id;
    private String download;
    private String draw;
    private String draw_logo;
    private String first_pub;
    private String game_type;
    private String gift_num;
    private String ifcollect;
    private String ifgift;
    private String new_features;
    private String operation_status;
    private String pay_type;
    private List<String> permission;
    private String pkg_id;
    private List<String> printscreen;
    private String py_cname;
    private String py_name;
    private String raw_signature;
    private String scalable;
    private List<AppScoreDetailEntity> scores_detail;
    private String signature;
    private String size;
    private String spread;
    private String update_time;
    private VideoEntity video;

    public AppInfoEntity() {
        this.pkg_id = "";
        this.dever_id = "";
        this.cname = "";
        this.banner = "";
        this.draw_logo = "";
        this.apk_file = "";
        this.create_time = "";
        this.update_time = "";
        this.developer = "";
        this.pay_type = "";
        this.py_name = "";
        this.py_cname = "";
        this.brief = "";
        this.download = "";
        this.draw = "";
        this.first_pub = "";
        this.spread = "";
        this.game_type = "";
        this.operation_status = "";
        this.gift_num = "";
        this.cid = "";
        this.scalable = "";
        this.comments = "";
        this.ifcollect = "";
        this.size = "";
        this.new_features = "";
        this.signature = "";
        this.raw_signature = "";
        this.ifgift = "";
        this.printscreen = new ArrayList();
        this.permission = new ArrayList();
        this.category_info = new ArrayList();
        this.scores_detail = new ArrayList();
    }

    public String getApk_file() {
        return this.apk_file;
    }

    public String getBanner() {
        return this.banner;
    }

    public String getBrief() {
        return this.brief;
    }

    public List<AppCategoryEntity> getCategory_info() {
        return this.category_info;
    }

    public String getCid() {
        return this.cid;
    }

    public String getCname() {
        return this.cname;
    }

    public String getComments() {
        return this.comments;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public String getDever_id() {
        return this.dever_id;
    }

    public String getDownload() {
        return this.download;
    }

    public String getDraw() {
        return this.draw;
    }

    public String getDraw_logo() {
        return this.draw_logo;
    }

    public String getFirst_pub() {
        return this.first_pub;
    }

    public String getGame_type() {
        return this.game_type;
    }

    public String getGift_num() {
        return this.gift_num;
    }

    public String getIfcollect() {
        return this.ifcollect;
    }

    public String getIfgift() {
        return this.ifgift;
    }

    public String getNew_features() {
        return this.new_features;
    }

    public String getOperation_status() {
        return this.operation_status;
    }

    public String getPay_type() {
        return this.pay_type;
    }

    public List<String> getPermission() {
        return this.permission;
    }

    public String getPkg_id() {
        return this.pkg_id;
    }

    public List<String> getPrintscreen() {
        return this.printscreen;
    }

    public String getPy_cname() {
        return this.py_cname;
    }

    public String getPy_name() {
        return this.py_name;
    }

    public String getRaw_signature() {
        return this.raw_signature;
    }

    public String getScalable() {
        return this.scalable;
    }

    public List<AppScoreDetailEntity> getScores_detail() {
        return this.scores_detail;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getSize() {
        return this.size;
    }

    public String getSpread() {
        return this.spread;
    }

    public String getUpdate_time() {
        return this.update_time;
    }

    public VideoEntity getVideo() {
        return this.video;
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(getPkg());
    }

    public void setApk_file(String r10) {
        this.apk_file = r10;
    }

    public void setBanner(String r10) {
        this.banner = r10;
    }

    public void setBrief(String r10) {
        this.brief = r10;
    }

    public void setCategory_info(List<AppCategoryEntity> r10) {
        this.category_info = r10;
    }

    public void setCid(String r10) {
        this.cid = r10;
    }

    public void setCname(String r10) {
        this.cname = r10;
    }

    public void setComments(String r10) {
        this.comments = r10;
    }

    public void setCreate_time(String r10) {
        this.create_time = r10;
    }

    public void setDeveloper(String r10) {
        this.developer = r10;
    }

    public void setDever_id(String r10) {
        this.dever_id = r10;
    }

    public void setDownload(String r10) {
        this.download = r10;
    }

    public void setDraw(String r10) {
        this.draw = r10;
    }

    public void setDraw_logo(String r10) {
        this.draw_logo = r10;
    }

    public void setFirst_pub(String r10) {
        this.first_pub = r10;
    }

    public void setGame_type(String r10) {
        this.game_type = r10;
    }

    public void setGift_num(String r10) {
        this.gift_num = r10;
    }

    public void setIfcollect(String r10) {
        this.ifcollect = r10;
    }

    public void setIfgift(String r10) {
        this.ifgift = r10;
    }

    public void setNew_features(String r10) {
        this.new_features = r10;
    }

    public void setOperation_status(String r10) {
        this.operation_status = r10;
    }

    public void setPay_type(String r10) {
        this.pay_type = r10;
    }

    public void setPermission(List<String> r10) {
        this.permission = r10;
    }

    public void setPkg_id(String r10) {
        this.pkg_id = r10;
    }

    public void setPrintscreen(List<String> r10) {
        this.printscreen = r10;
    }

    public void setPy_cname(String r10) {
        this.py_cname = r10;
    }

    public void setPy_name(String r10) {
        this.py_name = r10;
    }

    public void setRaw_signature(String r10) {
        this.raw_signature = r10;
    }

    public void setScalable(String r10) {
        this.scalable = r10;
    }

    public void setScores_detail(List<AppScoreDetailEntity> r10) {
        this.scores_detail = r10;
    }

    public void setSignature(String r10) {
        this.signature = r10;
    }

    public void setSize(String r10) {
        this.size = r10;
    }

    public void setSpread(String r10) {
        this.spread = r10;
    }

    public void setUpdate_time(String r10) {
        this.update_time = r10;
    }

    public void setVideo(VideoEntity r10) {
        this.video = r10;
    }
}
