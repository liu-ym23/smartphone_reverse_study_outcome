package com.android.ttcjpaysdk.base.ui.Utils.keepdialog;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/keepdialog/CJPayKeepDialogActionListener;", "", "onAnotherVerify", "", "keepDialogType", "", "keepDialogParams", "Lorg/json/JSONObject;", "onClose", "hasVoucher", "", "onContinue", SendEventContainerMethodParamModel.EventKinds.onShow, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJPayKeepDialogActionListener {
    void onAnotherVerify(int r100, JSONObject r101);

    void onClose(boolean r100, int r101, JSONObject r102);

    void onContinue(boolean r100, int r101, JSONObject r102);

    void onShow(boolean r100, int r101, JSONObject r102);
}
