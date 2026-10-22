package com.bytedance.android.live.browser.debug.mock;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.utils.t6;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/BaseDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseDialogFragment extends LiveDialogFragment {
    public BaseDialogFragment() {
        setNoTitleAndCancelOutside(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        Dialog r101 = getDialog();
        super.onActivityCreated(r100);
        if (r101 == null) goto L5;
        Window r102 = r101.getWindow();
    L6:
        if (r102 == null) goto L12;
        int r103 = t6.c(getContext());
        int r104 = t6.b(getContext());
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(8388629);
        r102.setLayout(r103, r104);
        WindowManager.LayoutParams r105 = r102.getAttributes();
        if (getContext() == null) goto L10;
        r105.horizontalMargin = t6.a(getContext(), 8.0f) / t6.b(getContext());
    L10:
        r102.setAttributes(r105);
        r102.setFlags(1024, 1024);
        WindowManager.LayoutParams r106 = r102.getAttributes();
        r106.dimAmount = 0.0f;
        r102.setAttributes(r106);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
