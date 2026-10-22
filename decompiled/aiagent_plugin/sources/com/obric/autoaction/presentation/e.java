package com.obric.autoaction.presentation;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SessionStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f24900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Object> f24901b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f24902c;

    private e() {
    }

    static {
        f24900a = new e();
        f24901b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        f24902c = DownloadSettingKeys.BugFix.DEFAULT;
    }

    public final <T> T a(String r1) {
        o.e(r1, "key");
        T r0 = (T) f24901b.get(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public final <T> void a(String r1, T r2) {
        o.e(r1, "key");
        f24901b.put(r1, r2);
    }

    public final void b(String r3) {
        o.e(r3, "newSessionId");
        ILogDepend.Companion.d("SessionLocalStorage", "switchSession from " + f24902c + " to " + r3);
        if (o.a(f24902c, r3) == false) goto L5;
        return;
    L5:
        f24901b.clear();
        f24902c = r3;
    }
}
