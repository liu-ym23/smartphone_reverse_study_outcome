package com.bytedance.applog.util;

import com.bytedance.applog.q;
import com.bytedance.bdinstall.u;

/* JADX INFO: compiled from: UriConstants.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q f6048a = null;

    public static final q a(int r0) {
        return f6048a;
    }

    static {
        f6048a = new q.a().a(u.f6448c).a(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}).b("https://log.zijieapi.com" + q.a()).b(new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}).a("https://log.zijieapi.com/service/2/log_settings/").a();
    }
}
