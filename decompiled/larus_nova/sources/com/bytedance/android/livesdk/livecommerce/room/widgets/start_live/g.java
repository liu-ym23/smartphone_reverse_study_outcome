package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.livecommerce.event.ECEventV3;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f152810a = null;

    public static final class a extends ECEventV3 {
        public a() {
            super("livesdk_risk_popup_click");
        }
    }

    static {
        f152810a = new g();
    }

    public g() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        new a().k();
        r100.dismiss();
    }
}
