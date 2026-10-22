package com.bytedanceos.appstore.buss.utilities;

import android.content.Context;
import android.content.Intent;
import com.bytedanceos.appstore.download.service.AppsInstallService;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8836a = null;

    static {
        f8836a = new c();
    }

    public c() {
    }

    public final void a(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        Intent r11 = new Intent(r10, AppsInstallService.class);
        r11.putExtra("message_what", 49);
        r10.startService(r11);
    }
}
