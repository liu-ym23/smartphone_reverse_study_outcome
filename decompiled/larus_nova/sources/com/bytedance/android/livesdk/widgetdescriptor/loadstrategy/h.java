package com.bytedance.android.livesdk.widgetdescriptor.loadstrategy;

import com.bytedance.android.live.core.setting.j0;
import com.bytedance.android.live.core.setting.p5;
import com.bytedance.android.live.core.setting.q5;
import com.bytedance.android.live.core.setting.r5;
import com.bytedance.android.live.core.setting.y5;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f162408a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f162409b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f162410c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f162411d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f162412e = false;

    static {
        f162408a = r5.f65401a.getValue().booleanValue();
        f162409b = q5.f65393a.getValue().booleanValue();
        f162410c = p5.f65384a.getValue().booleanValue();
        f162411d = j0.f65328a.getValue().a();
        f162412e = y5.f65464a.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean a() {
        if (f162408a == false) goto L5;
    L14:
        return true;
    L5:
        if (f162409b == true) goto L14;
        if (f162410c == true) goto L14;
        if (f162411d == true) goto L14;
        if (f162412e == true) goto L14;
        return false;
    }
}
