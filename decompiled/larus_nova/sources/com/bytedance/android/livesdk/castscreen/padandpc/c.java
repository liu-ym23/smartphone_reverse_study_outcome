package com.bytedance.android.livesdk.castscreen.padandpc;

import android.widget.TextView;
import com.bytedance.android.livesdk.castscreen.utils.LivePadAndPcPlayUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadAndPcPlayDeviceListDialog f104674a;

    public c(PadAndPcPlayDeviceListDialog r100) {
        this.f104674a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        PadAndPcPlayDeviceListDialog r102 = this.f104674a;
        int r103 = PadAndPcPlayDeviceListDialog.f104624w;
        r102.getClass();
        if (LivePadAndPcPlayUtil.h() == false) goto L10;
        TextView r104 = r102.f104627e;
        if (r104 == null) goto L9;
        r104.setText(r101);
        return;
    L9:
        return;
    }
}
