package com.bytedance.android.livesdk.model;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.g2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153923a = 0;

    static {
        new ThreadLocal();
    }

    public static boolean a() {
        Integer r100 = g2.f65304a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 3) goto L8;
        return true;
    }

    public static boolean b() {
        Integer r100 = g2.f65304a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 4) goto L8;
        return true;
    }

    public static boolean c() {
        Integer r100 = g2.f65304a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public static boolean d() {
        Integer r100 = g2.f65304a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.d("LoadMoreInhibition", r100);
    }
}
