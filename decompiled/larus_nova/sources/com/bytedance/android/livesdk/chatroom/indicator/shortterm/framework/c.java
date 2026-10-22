package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IconServiceImpl f106636a;

    public c(IconServiceImpl r100) {
        this.f106636a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f106636a.performClick();
    }
}
