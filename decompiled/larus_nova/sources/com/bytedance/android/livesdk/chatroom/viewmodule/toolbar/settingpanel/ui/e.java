package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OptionNormalView f116778a;

    public e(OptionNormalView r100) {
        this.f116778a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        TextView r102 = this.f116778a.getTvDesc();
        if (r102 == null) goto L5;
        r102.setText(r101);
    L5:
        TextView r103 = this.f116778a.getTvDesc();
        if (r103 == null) goto L18;
        int r104 = 0;
        if (r101 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        r104 = 8;
    L16:
        r103.setVisibility(r104);
        return;
    L10:
        if (r101.length() == 0) goto L13;
        r105 = false;
        goto L14
    }
}
