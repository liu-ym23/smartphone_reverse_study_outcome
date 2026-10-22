package com.bytedance.android.service.manager.permission.boot;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface IPermissionBootDialog {

    public interface ClickListener {
        void onAgree(boolean r100);

        void onReject();

        void onShowResult(boolean r100, String r101);
    }

    boolean showDialog(JSONObject r100, ClickListener r101);
}
