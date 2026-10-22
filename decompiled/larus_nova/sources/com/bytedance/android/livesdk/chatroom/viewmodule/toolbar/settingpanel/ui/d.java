package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OptionNormalView f116777a;

    public d(OptionNormalView r100) {
        this.f116777a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        TextView r102 = this.f116777a.getTvTitle();
        if (r102 == null) goto L6;
        r102.setText(r101);
        return;
    }
}
