package com.bytedance.android.livesdk.announcement;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f103533a = null;

    static {
        f103533a = new o();
    }

    public o() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.c("已达今日修改次数上限", 0);
    }
}
