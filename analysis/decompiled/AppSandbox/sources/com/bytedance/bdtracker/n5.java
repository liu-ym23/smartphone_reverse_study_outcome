package com.bytedance.bdtracker;

import android.content.Context;

/* loaded from: classes.dex */
public final class n5 implements Runnable {
    public final /* synthetic */ Context a;

    public n5(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        m5.b.b(this.a).putBoolean("_install_started_v2", true);
    }
}
