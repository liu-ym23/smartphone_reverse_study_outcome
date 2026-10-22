package com.android.ttcjpaysdk.base.ui.Utils.keepdialog;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/keepdialog/CJPayKeepDialogActionListenerAdapter;", "Lcom/android/ttcjpaysdk/base/ui/Utils/keepdialog/CJPayKeepDialogActionListener;", "()V", "onAnotherVerify", "", "keepDialogType", "", "keepDialogParams", "Lorg/json/JSONObject;", "onClose", "hasVoucher", "", "onContinue", SendEventContainerMethodParamModel.EventKinds.onShow, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJPayKeepDialogActionListenerAdapter implements CJPayKeepDialogActionListener {
    public CJPayKeepDialogActionListenerAdapter() {
    }

    @Override // com.android.ttcjpaysdk.base.ui.Utils.keepdialog.CJPayKeepDialogActionListener
    public void onAnotherVerify(int r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "keepDialogParams");
    }

    @Override // com.android.ttcjpaysdk.base.ui.Utils.keepdialog.CJPayKeepDialogActionListener
    public void onClose(boolean r100, int r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r102, "keepDialogParams");
    }

    @Override // com.android.ttcjpaysdk.base.ui.Utils.keepdialog.CJPayKeepDialogActionListener
    public void onContinue(boolean r100, int r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r102, "keepDialogParams");
    }

    @Override // com.android.ttcjpaysdk.base.ui.Utils.keepdialog.CJPayKeepDialogActionListener
    public void onShow(boolean r100, int r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r102, "keepDialogParams");
    }
}
