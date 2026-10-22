package com.slardaros.client;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class AgentEvent {
    public String event;
    public boolean isDelete;
    public boolean isInstant;
    public JSONObject jsonParams;
    public String mLogPath;
    public String mLogType;
    public String mPackageName;
    public String mSummary;
    public String mTag;
    public String mType;
    public long timestamp;

    public AgentEvent() {
        this.isInstant = false;
    }
}
