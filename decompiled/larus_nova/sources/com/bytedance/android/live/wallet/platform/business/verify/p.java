package com.bytedance.android.live.wallet.platform.business.verify;

import android.content.DialogInterface;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class p implements DialogInterface.OnClickListener {
    public p() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        HashMap r102 = new HashMap();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "1");
        ed1.a.a("livesdk_real_name_unfinished_remind_toast_click", r102);
    }
}
