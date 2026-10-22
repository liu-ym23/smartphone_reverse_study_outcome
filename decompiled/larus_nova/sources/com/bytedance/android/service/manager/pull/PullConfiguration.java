package com.bytedance.android.service.manager.pull;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class PullConfiguration {
    public static final String PROCESS_NAME_MAIN = "main";
    public static final String PROCESS_NAME_PUSH = "push";
    public static final String PROCESS_NAME_SMP = "smp";
    public static final int SCENE_ALLIANCE = 2;
    public static final int SCENE_ONLINE = 1;
    private String did;
    private String fromAid;
    private String fromDid;
    private boolean isActive;
    private JSONObject mSettingsFromCompose;
    private String processName;
    private int sceneId;

    public String getPullAidAndDids() {
        if (TextUtils.isEmpty(this.fromAid) == true) goto L9;
        if (TextUtils.isEmpty(this.fromDid) == true) goto L9;
        return this.fromAid + ":" + this.fromDid;
    L9:
        if (TextUtils.isEmpty(this.fromAid) == false) goto L15;
        if (TextUtils.isEmpty(this.fromDid) == false) goto L15;
        return "";
    L15:
        if (TextUtils.isEmpty(this.fromAid) == false) goto L19;
        return ":" + this.fromDid;
    L19:
        return this.fromAid + ":";
    }

    public String getDid() {
        return this.did;
    }

    public String getFromAid() {
        return this.fromAid;
    }

    public String getFromDid() {
        return this.fromDid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public JSONObject getSettingsFromCompose() {
        return this.mSettingsFromCompose;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public PullConfiguration setDid(String r100) {
        this.did = r100;
        return this;
    }

    public PullConfiguration setFromAid(String r100) {
        this.fromAid = r100;
        return this;
    }

    public PullConfiguration setFromDid(String r100) {
        this.fromDid = r100;
        return this;
    }

    public PullConfiguration setIsActive(boolean r100) {
        this.isActive = r100;
        return this;
    }

    public PullConfiguration setSettingsFromCompose(JSONObject r100) {
        this.mSettingsFromCompose = r100;
        return this;
    }

    public PullConfiguration(String r100, int r101, String r102) {
        this.processName = r100;
        this.sceneId = r101;
        this.did = r102;
        this.fromAid = "";
        this.fromDid = "";
    }
}
