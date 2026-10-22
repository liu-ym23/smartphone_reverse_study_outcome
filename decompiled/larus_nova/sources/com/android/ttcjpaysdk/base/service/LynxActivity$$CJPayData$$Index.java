package com.android.ttcjpaysdk.base.service;

import android.os.Bundle;
import com.android.ttcjpaysdk.base.h5.ui.LynxActivity;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;

/* JADX INFO: loaded from: classes28.dex */
public class LynxActivity$$CJPayData$$Index {
    public LynxActivity$$CJPayData$$Index() {
    }

    public static void autoWiredData(Object r100, Object r101) {
        Bundle r102 = (Bundle) r100;
        LynxActivity r103 = (LynxActivity) r101;
        if (r103.getIntent().getStringExtra("schema") != null) goto L5;
        String r104 = r103.schema;
    L6:
        r103.schema = r104;
        r103.callbackId = r103.getIntent().getIntExtra(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID, r103.callbackId);
        if (r103.getIntent().getStringExtra("cj_initial_props") != null) goto L9;
        String r105 = r103.cjInitialProps;
    L10:
        r103.cjInitialProps = r105;
        return;
    L9:
        r105 = r103.getIntent().getStringExtra("cj_initial_props");
        goto L10
    L5:
        r104 = r103.getIntent().getStringExtra("schema");
        goto L6
    }

    public static void restoreData(Object r100, Object r101) {
        Bundle r102 = (Bundle) r100;
        LynxActivity r103 = (LynxActivity) r101;
        if (r102.getString("schema") != null) goto L5;
        String r104 = r103.schema;
    L6:
        r103.schema = r104;
        r103.callbackId = r102.getInt(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID);
        if (r102.getString("cj_initial_props") != null) goto L9;
        String r105 = r103.cjInitialProps;
    L10:
        r103.cjInitialProps = r105;
        return;
    L9:
        r105 = r102.getString("cj_initial_props");
        goto L10
    L5:
        r104 = r102.getString("schema");
        goto L6
    }

    public static void saveData(Object r100, Object r101) {
        Bundle r102 = (Bundle) r100;
        LynxActivity r103 = (LynxActivity) r101;
        r102.putString("schema", r103.schema);
        r102.putInt(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID, r103.callbackId);
        r102.putString("cj_initial_props", r103.cjInitialProps);
    }
}
