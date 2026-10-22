package com.byted.cast.common.bean;

import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class SinkInfoBean {
    private String aid;
    private String app_id;
    private int audio;
    private int bitrate;
    private String business_device_id;
    private String cast_id;
    private String device_id;
    private String device_name;
    private String expand;
    private int fps;
    private int height;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    private List<String> f33708ip;
    private int landscape;
    private int mirror_port;
    private String player_info;
    private int port;
    private String private_channel;
    private String project_id;
    private String protocols;
    private String sdk_version;
    private String session_id;
    private int width;

    public SinkInfoBean() {
    }

    public String toString() {
        return "SinkInfoBean{device_name='" + this.device_name + "', ip=" + this.f33708ip + ", port=" + this.port + ", mirror_port=" + this.mirror_port + ", cast_id='" + this.cast_id + "', private_channel='" + this.private_channel + "', protocols='" + this.protocols + "', width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", audio=" + this.audio + ", bitrate=" + this.bitrate + ", landscape=" + this.landscape + ", aid=" + this.aid + ", project_id='" + this.project_id + "', session_id='" + this.session_id + "', device_id='" + this.device_id + "', sdk_version='" + this.sdk_version + "', player_info='" + this.player_info + "', expand='" + this.expand + "', business_device_id='" + this.business_device_id + "', app_id='" + this.app_id + "'}";
    }

    public String getAid() {
        return this.aid;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public int getAudio() {
        return this.audio;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getBusiness_device_id() {
        return this.business_device_id;
    }

    public String getCast_id() {
        return this.cast_id;
    }

    public String getDevice_id() {
        return this.device_id;
    }

    public String getDevice_name() {
        return this.device_name;
    }

    public String getExpand() {
        return this.expand;
    }

    public int getFps() {
        return this.fps;
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getIp() {
        return this.f33708ip;
    }

    public int getLandscape() {
        return this.landscape;
    }

    public int getMirror_port() {
        return this.mirror_port;
    }

    public String getPlayer_info() {
        return this.player_info;
    }

    public int getPort() {
        return this.port;
    }

    public String getPrivate_channel() {
        return this.private_channel;
    }

    public String getProject_id() {
        return this.project_id;
    }

    public String getProtocols() {
        return this.protocols;
    }

    public String getSdk_version() {
        return this.sdk_version;
    }

    public String getSession_id() {
        return this.session_id;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAid(String r100) {
        this.aid = r100;
    }

    public void setApp_id(String r100) {
        this.app_id = r100;
    }

    public void setAudio(int r100) {
        this.audio = r100;
    }

    public void setBitrate(int r100) {
        this.bitrate = r100;
    }

    public void setBusiness_device_id(String r100) {
        this.business_device_id = r100;
    }

    public void setCast_id(String r100) {
        this.cast_id = r100;
    }

    public void setDevice_id(String r100) {
        this.device_id = r100;
    }

    public void setDevice_name(String r100) {
        this.device_name = r100;
    }

    public void setExpand(String r100) {
        this.expand = r100;
    }

    public void setFps(int r100) {
        this.fps = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setIp(List<String> r100) {
        this.f33708ip = r100;
    }

    public void setLandscape(int r100) {
        this.landscape = r100;
    }

    public void setMirror_port(int r100) {
        this.mirror_port = r100;
    }

    public void setPlayer_info(String r100) {
        this.player_info = r100;
    }

    public void setPort(int r100) {
        this.port = r100;
    }

    public void setPrivate_channel(String r100) {
        this.private_channel = r100;
    }

    public void setProject_id(String r100) {
        this.project_id = r100;
    }

    public void setProtocols(String r100) {
        this.protocols = r100;
    }

    public void setSdk_version(String r100) {
        this.sdk_version = r100;
    }

    public void setSession_id(String r100) {
        this.session_id = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
