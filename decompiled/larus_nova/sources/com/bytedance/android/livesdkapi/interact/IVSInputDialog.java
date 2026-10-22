package com.bytedance.android.livesdkapi.interact;

import android.app.Activity;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface IVSInputDialog {

    public interface InputListener {
        void onDismiss(InputDraft r100, boolean r101);

        void onSendMessage(String r100, Map<String, Object> r101, boolean r102);
    }

    void dismissAllowingStateLoss();

    void dismissInputDialog();

    void hideSoftKeyBoard();

    void onSendFailed();

    void onSendSuccess();

    void setDataCenter(DataCenter r100);

    void setInputListener(InputListener r100);

    void show(Activity r100, String r101);

    void updateInput(String r100);
}
