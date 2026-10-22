package com.bytedance.android.livesdk.model;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.l3;
import com.bytedance.android.live.core.setting.p7;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f153924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f153925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f153926c;

    @JvmStatic
    public static final boolean a() {
        if (l3.f65349a.getValue().booleanValue() == false) goto L17;
        p7 r100 = p7.f65386a;
        if (r100.getValue().a() == 0) goto L17;
        if (f153924a == false) goto L10;
        return false;
    L10:
        if (f153926c == false) goto L12;
        return false;
    L12:
        if (r100.getValue().a() != 2) goto L20;
        b("open drawer");
        return true;
    L20:
        return false;
    L17:
        b("drawer default");
        return true;
    }

    static {
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "time");
        ALogger.i("TabRequestOptHelper", "trigger request tab api when ".concat(r100));
    }
}
