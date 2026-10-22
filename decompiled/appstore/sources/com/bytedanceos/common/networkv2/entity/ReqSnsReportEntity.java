package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class ReqSnsReportEntity {
    private String app_version;
    private String build_serial;
    private String cpu_abi;
    private String device_brand;
    private String device_man_ufaturer;
    private String device_model;
    private String display_density;
    private int event_type;
    private String extra;
    private int height;
    private String imei;
    private String language;
    private String mac;
    private String manufacturer;
    private int nt;
    private String openudid;
    private int os_api;
    private String os_version;
    private String rom;
    private int root;
    private int sim_op;
    private int width;

    public ReqSnsReportEntity() {
        this.event_type = 0;
        this.extra = "";
        this.os_version = "";
        this.app_version = "";
        this.mac = "";
        this.width = 0;
        this.height = 0;
        this.imei = "";
        this.openudid = "";
        this.nt = 0;
        this.display_density = "";
        this.sim_op = -1;
        this.os_api = 0;
        this.root = -1;
        this.manufacturer = "";
        this.device_model = "";
        this.device_brand = "";
        this.device_man_ufaturer = "";
        this.language = "";
        this.build_serial = "";
        this.rom = "";
        this.cpu_abi = "";
    }

    public String getApp_version() {
        return this.app_version;
    }

    public String getDevice_brand() {
        return this.device_brand;
    }

    public String getDevice_man_ufaturer() {
        return this.device_man_ufaturer;
    }

    public String getDevice_model() {
        return this.device_model;
    }

    public String getDisplay_density() {
        return this.display_density;
    }

    public int getEvent_type() {
        return this.event_type;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImei() {
        return this.imei;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMac() {
        return this.mac;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public int getNt() {
        return this.nt;
    }

    public String getOpenudid() {
        return this.openudid;
    }

    public int getOs_api() {
        return this.os_api;
    }

    public String getOs_version() {
        return this.os_version;
    }

    public int getRoot() {
        return this.root;
    }

    public int getSim_op() {
        return this.sim_op;
    }

    public int getWidth() {
        return this.width;
    }

    public void setApp_version(String r10) {
        this.app_version = r10;
    }

    public void setDevice_brand(String r10) {
        this.device_brand = r10;
    }

    public void setDevice_man_ufaturer(String r10) {
        this.device_man_ufaturer = r10;
    }

    public void setDevice_model(String r10) {
        this.device_model = r10;
    }

    public void setDisplay_density(String r10) {
        this.display_density = r10;
    }

    public void setEvent_type(int r10) {
        this.event_type = r10;
    }

    public void setExtra(String r10) {
        this.extra = r10;
    }

    public void setHeight(int r10) {
        this.height = r10;
    }

    public void setImei(String r10) {
        this.imei = r10;
    }

    public void setLanguage(String r10) {
        this.language = r10;
    }

    public void setMac(String r10) {
        this.mac = r10;
    }

    public void setManufacturer(String r10) {
        this.manufacturer = r10;
    }

    public void setNt(int r10) {
        this.nt = r10;
    }

    public void setOpenudid(String r10) {
        this.openudid = r10;
    }

    public void setOs_api(int r10) {
        this.os_api = r10;
    }

    public void setOs_version(String r10) {
        this.os_version = r10;
    }

    public void setRoot(int r10) {
        this.root = r10;
    }

    public void setSim_op(int r10) {
        this.sim_op = r10;
    }

    public void setWidth(int r10) {
        this.width = r10;
    }
}
