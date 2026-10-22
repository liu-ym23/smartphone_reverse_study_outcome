package com.byted.cast.common.bean.chromecast;

/* JADX INFO: loaded from: classes39.dex */
public class MessageBean {
    public static final int TYPE_GET_DEVICE_INFO = 1;
    public static final int TYPE_GET_DEVICE_INFO_FROM_USER = 2;
    public static final int TYPE_IOS_SUSPEND_SCENE = 3;
    public static final int TYPE_NORMAL = 0;
    public String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f33709id;
    public int type;

    public String toString() {
        return "MessageBean{type=" + this.type + ", id='" + this.f33709id + "', content='" + this.content + "'}";
    }

    public MessageBean() {
    }

    public MessageBean(String r100) {
        this.f33709id = r100;
    }

    public MessageBean(int r100, String r101, String r102) {
        this.type = r100;
        this.f33709id = r101;
        this.content = r102;
    }
}
