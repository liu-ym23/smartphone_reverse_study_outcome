package com.android.ttcjpaysdk.ttcjpayapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public interface TTCJPayDoFaceLive {

    public static class CJPayFaceDialogParams {
        public Context ctx;
        public String message;
        public DialogInterface.OnClickListener negativeAction;
        public String negativeLabel;
        public DialogInterface.OnClickListener positiveAction;
        public String positiveLabel;
        public String title;
        public String type;

        public CJPayFaceDialogParams() {
            this.ctx = null;
            this.type = "";
            this.title = "";
            this.message = "";
            this.positiveLabel = "";
            this.negativeLabel = "";
            this.positiveAction = null;
            this.negativeAction = null;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface TTCJPayFaceLiveCallback {
        void dismissLoading();

        boolean isTranslucentFace();

        void onResult(JSONObject r100);

        boolean showDialog(CJPayFaceDialogParams r100);

        void showLoading();
    }

    void doFaceLive(Activity r100, Map<String, String> r101, TTCJPayFaceLiveCallback r102);
}
