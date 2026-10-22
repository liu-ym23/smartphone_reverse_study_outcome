package com.bytedanceos.common.ad.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class ReqDeviceEntity {
    private String android_id;
    private int conn_type;
    private String geo;
    private String imei;
    private String imei_enc;
    private String ip;
    private String language;
    private String mac;
    private String mobile_country_code;
    private String mobile_network_code;
    private String model;
    private int orientation;
    private int os;
    private String os_version;
    private float pixel_ratio;
    private String resolution;
    private String screen_size;
    private int type;
    private String uuid;
    private String vendor;

    public ReqDeviceEntity() {
        this.type = 0;
        this.conn_type = 0;
        this.resolution = "";
        this.imei = "";
        this.imei_enc = "";
        this.android_id = "";
        this.uuid = "";
        this.vendor = "";
        this.model = "";
        this.os = 1;
        this.os_version = "";
        this.language = "";
        this.mobile_network_code = "";
        this.orientation = 0;
        this.screen_size = "";
        this.mac = "";
        this.pixel_ratio = 1.0f;
        this.mobile_country_code = "";
        this.ip = "";
        this.geo = "";
    }

    public String getAndroid_id() {
        return this.android_id;
    }

    public int getConn_type() {
        return this.conn_type;
    }

    public String getGeo() {
        return this.geo;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImei_enc() {
        return this.imei_enc;
    }

    public String getIp() {
        return this.ip;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMobile_country_code() {
        return this.mobile_country_code;
    }

    public String getMobile_network_code() {
        return this.mobile_network_code;
    }

    public String getModel() {
        return this.model;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getOs() {
        return this.os;
    }

    public String getOs_version() {
        return this.os_version;
    }

    public float getPixel_ratio() {
        return this.pixel_ratio;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getScreen_size() {
        return this.screen_size;
    }

    public int getType() {
        return this.type;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setAndroid_id(String r10) {
        this.android_id = r10;
    }

    public void setConn_type(int r10) {
        this.conn_type = r10;
    }

    public void setGeo(String r10) {
        this.geo = r10;
    }

    public void setImei(String r10) {
        this.imei = r10;
    }

    public void setImei_enc(String r10) {
        this.imei_enc = r10;
    }

    public void setIp(String r10) {
        this.ip = r10;
    }

    public void setLanguage(String r10) {
        this.language = r10;
    }

    public void setMac(String r10) {
        this.mac = r10;
    }

    public void setMobile_country_code(String r10) {
        this.mobile_country_code = r10;
    }

    public void setMobile_network_code(String r10) {
        this.mobile_network_code = r10;
    }

    public void setModel(String r10) {
        this.model = r10;
    }

    public void setOrientation(int r10) {
        this.orientation = r10;
    }

    public void setOs(int r10) {
        this.os = r10;
    }

    public void setOs_version(String r10) {
        this.os_version = r10;
    }

    public void setPixel_ratio(float r10) {
        this.pixel_ratio = r10;
    }

    public void setResolution(String r10) {
        this.resolution = r10;
    }

    public void setScreen_size(String r10) {
        this.screen_size = r10;
    }

    public void setType(int r10) {
        this.type = r10;
    }

    public void setUuid(String r10) {
        this.uuid = r10;
    }

    public void setVendor(String r10) {
        this.vendor = r10;
    }
}
