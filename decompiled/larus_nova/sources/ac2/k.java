package ac2;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2585a = 0;

    @JvmStatic
    public static final long a() {
        return com.bytedance.android.livesdk.interactivity.service.settings.j.f140998a.getValue().c();
    }

    @JvmStatic
    public static final boolean c() {
        return com.bytedance.android.livesdk.interactivity.service.settings.j.f140998a.getValue().a();
    }

    @JvmStatic
    public static final boolean b() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.livesdk.interactivity.service.settings.j.f140998a.getValue().b() != 0) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean d() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.livesdk.interactivity.service.settings.j.f140998a.getValue().b() == 2) goto L7;
        return true;
    }

    static {
    }
}
