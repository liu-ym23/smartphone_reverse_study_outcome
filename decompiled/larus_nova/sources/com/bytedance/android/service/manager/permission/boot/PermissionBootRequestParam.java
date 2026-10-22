package com.bytedance.android.service.manager.permission.boot;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class PermissionBootRequestParam {
    private Activity curActivity;
    private JSONObject dialogFormData;
    private IPermissionBootDialog permissionBootDialogAbility;
    private String sceneCategory;
    private String scenes;

    public Activity getCurActivity() {
        return this.curActivity;
    }

    public JSONObject getDialogFormData() {
        return this.dialogFormData;
    }

    public IPermissionBootDialog getPermissionBootDialogAbility() {
        return this.permissionBootDialogAbility;
    }

    public String getSceneCategory() {
        return this.sceneCategory;
    }

    public String getScenes() {
        return this.scenes;
    }

    public PermissionBootRequestParam setCurActivity(Activity r100) {
        this.curActivity = r100;
        return this;
    }

    public PermissionBootRequestParam setDialogFormData(JSONObject r100) {
        this.dialogFormData = r100;
        return this;
    }

    public PermissionBootRequestParam setPermissionBootDialogAbility(IPermissionBootDialog r100) {
        this.permissionBootDialogAbility = r100;
        return this;
    }

    public PermissionBootRequestParam setSceneCategory(String r100) {
        this.sceneCategory = r100;
        return this;
    }

    public PermissionBootRequestParam setScenes(String r100) {
        this.scenes = r100;
        return this;
    }

    public PermissionBootRequestParam(String r100, String r101) {
        this.scenes = r100;
        this.sceneCategory = r101;
    }
}
