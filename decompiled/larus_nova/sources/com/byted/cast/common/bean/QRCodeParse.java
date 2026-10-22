package com.byted.cast.common.bean;

import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class QRCodeParse {
    private String cast_id;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    private List<String> f33704ip;
    private Integer mpt;

    /* JADX INFO: renamed from: net, reason: collision with root package name */
    private String f33705net;
    private String pcl;
    private String pio;
    private Integer port;
    private String protocols;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private String f33706se;
    private String svn;

    public String toString() {
        return "QRCodeParse{se='" + this.f33706se + "', pcl='" + this.pcl + "', svn='" + this.svn + "', net='" + this.f33705net + "', ip=" + this.f33704ip + ", port=" + this.port + ", mpt=" + this.mpt + ", protocols='" + this.protocols + "', pio='" + this.pio + "', cast_id='" + this.cast_id + "'}";
    }

    public QRCodeParse() {
        this.pcl = "";
    }

    public String getCast_id() {
        return this.cast_id;
    }

    public List<String> getIp() {
        return this.f33704ip;
    }

    public Integer getMpt() {
        return this.mpt;
    }

    public String getNet() {
        return this.f33705net;
    }

    public String getPcl() {
        return this.pcl;
    }

    public String getPio() {
        return this.pio;
    }

    public Integer getPort() {
        return this.port;
    }

    public String getProtocols() {
        return this.protocols;
    }

    public String getSe() {
        return this.f33706se;
    }

    public String getSvn() {
        return this.svn;
    }

    public void setCast_id(String r100) {
        this.cast_id = r100;
    }

    public void setIp(List<String> r100) {
        this.f33704ip = r100;
    }

    public void setMpt(Integer r100) {
        this.mpt = r100;
    }

    public void setNet(String r100) {
        this.f33705net = r100;
    }

    public void setPcl(String r100) {
        this.pcl = r100;
    }

    public void setPio(String r100) {
        this.pio = r100;
    }

    public void setPort(Integer r100) {
        this.port = r100;
    }

    public void setProtocols(String r100) {
        this.protocols = r100;
    }

    public void setSe(String r100) {
        this.f33706se = r100;
    }

    public void setSvn(String r100) {
        this.svn = r100;
    }
}
