package com.bytedanceos.common.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BaseAppInfo implements Serializable {
    private String apkfile;
    private String category;
    private String click;
    private String download_report;
    private String download_url;
    private String dsp;
    private String filemd5;
    private long filesize;
    private String from;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f9835id;
    private String ifdownload;
    private int ifgms;
    private String impression;
    private boolean is_show;
    private List<Integer> label;
    private String last_update_time;
    private String location;
    private String logo;
    private String name;
    private String operative_type;

    @SerializedName("package")
    private String pkg;
    private String recmd_brief;
    private float scores;
    private String share_download_url;
    private int soft_type;
    private String source;
    private String sstj;
    private String status;
    private int type;
    private String version;
    private int version_code;

    public BaseAppInfo() {
        this.type = 0;
        this.f9835id = "";
        this.name = "";
        this.version = "";
        this.version_code = 0;
        this.pkg = "";
        this.logo = "";
        this.scores = 0.0f;
        this.category = "";
        this.filesize = 0;
        this.status = "";
        this.ifgms = 0;
        this.from = "";
        this.download_url = "";
        this.filemd5 = "";
        this.recmd_brief = "";
        this.ifdownload = "";
        this.soft_type = 0;
        this.location = "";
        this.label = new ArrayList();
        this.operative_type = "";
        this.sstj = "";
        this.is_show = false;
        this.last_update_time = "";
        this.impression = "";
        this.click = "";
        this.download_report = "";
        this.dsp = "";
        this.share_download_url = "";
        this.apkfile = "";
        this.source = "local";
    }

    public String getApkfile() {
        return this.apkfile;
    }

    public String getCategory() {
        return this.category;
    }

    public String getClick() {
        return this.click;
    }

    public String getDownload_report() {
        return this.download_report;
    }

    public String getDownload_url() {
        return this.download_url;
    }

    public String getDsp() {
        return this.dsp;
    }

    public String getFilemd5() {
        return this.filemd5;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public String getFrom() {
        return this.from;
    }

    public String getId() {
        return this.f9835id;
    }

    public String getIfdownload() {
        return this.ifdownload;
    }

    public int getIfgms() {
        return this.ifgms;
    }

    public String getImpression() {
        return this.impression;
    }

    public List<Integer> getLabel() {
        return this.label;
    }

    public String getLast_update_time() {
        return this.last_update_time;
    }

    public String getLocation() {
        return this.location;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }

    public String getOperative_type() {
        return this.operative_type;
    }

    public String getPkg() {
        return this.pkg;
    }

    public String getRecmd_brief() {
        return this.recmd_brief;
    }

    public float getScores() {
        return this.scores;
    }

    public String getShare_download_url() {
        return this.share_download_url;
    }

    public int getSoft_type() {
        return this.soft_type;
    }

    public String getSource() {
        return this.source;
    }

    public String getSstj() {
        return this.sstj;
    }

    public String getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public int getVersion_code() {
        return this.version_code;
    }

    public boolean isIs_show() {
        return this.is_show;
    }

    public void setApkfile(String r10) {
        this.apkfile = r10;
    }

    public void setCategory(String r10) {
        this.category = r10;
    }

    public void setClick(String r10) {
        this.click = r10;
    }

    public void setDownload_report(String r10) {
        this.download_report = r10;
    }

    public void setDownload_url(String r10) {
        this.download_url = r10;
    }

    public void setDsp(String r10) {
        this.dsp = r10;
    }

    public void setFilemd5(String r10) {
        this.filemd5 = r10;
    }

    public void setFilesize(long r10) {
        this.filesize = r10;
    }

    public void setFrom(String r10) {
        this.from = r10;
    }

    public void setId(String r10) {
        this.f9835id = r10;
    }

    public void setIfdownload(String r10) {
        this.ifdownload = r10;
    }

    public void setIfgms(int r10) {
        this.ifgms = r10;
    }

    public void setImpression(String r10) {
        this.impression = r10;
    }

    public void setIs_show(boolean r10) {
        this.is_show = r10;
    }

    public void setLabel(List<Integer> r10) {
        this.label = r10;
    }

    public void setLast_update_time(String r10) {
        this.last_update_time = r10;
    }

    public void setLocation(String r10) {
        this.location = r10;
    }

    public void setLogo(String r10) {
        this.logo = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setOperative_type(String r10) {
        this.operative_type = r10;
    }

    public void setPkg(String r10) {
        this.pkg = r10;
    }

    public void setRecmd_brief(String r10) {
        this.recmd_brief = r10;
    }

    public void setScores(float r10) {
        this.scores = r10;
    }

    public void setShare_download_url(String r10) {
        this.share_download_url = r10;
    }

    public void setSoft_type(int r10) {
        this.soft_type = r10;
    }

    public void setSource(String r10) {
        this.source = r10;
    }

    public void setSstj(String r10) {
        this.sstj = r10;
    }

    public void setStatus(String r10) {
        this.status = r10;
    }

    public void setType(int r10) {
        this.type = r10;
    }

    public void setVersion(String r10) {
        this.version = r10;
    }

    public void setVersion_code(int r10) {
        this.version_code = r10;
    }
}
