package com.stepos.activeview.json;

/* loaded from: classes.dex */
public class Event {
    public static final String ACTION_TYPE_BROADCAST = "sendBroadcast";
    public static final String ACTION_TYPE_LOCAL_BROADCAST = "sendLocalBroadcast";
    public static final String ACTION_TYPE_NATIVE = "startActivity";
    public static final String ACTION_TYPE_SERVICE = "startService";
    public static final String ACTION_TYPE_TOAST = "showToast";
    public static final String TYPE_CLICK = "click";
    public static final String TYPE_TOUCH = "touch";
    private String action;
    private String args;
    private String type;

    public String getAction() {
        return this.action;
    }

    public String getArgs() {
        return this.args;
    }

    public String getType() {
        return this.type;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setArgs(String str) {
        this.args = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
