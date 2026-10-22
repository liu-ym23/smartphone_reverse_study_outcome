package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f106574a = null;

    static {
        f106574a = new e();
    }

    public e() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        r100.setVisibility(8);
        return true;
    }
}
