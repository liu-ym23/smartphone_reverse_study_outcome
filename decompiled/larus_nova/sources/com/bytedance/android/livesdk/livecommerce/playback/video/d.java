package com.bytedance.android.livesdk.livecommerce.playback.video;

import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<e> f150010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set<String> f150011b;

    static {
    }

    public static void a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return;
    L11:
        if (f150011b != null) goto L13;
        f150011b = new LinkedHashSet();
    L13:
        Set<String> r102 = f150011b;
        if (r102 == null) goto L17;
        r102.add(r100);
        return;
    L17:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void b(e r100) {
        int r101 = bj2.a.f19209a;
        bj2.a.b("ReplayVideoManager", "setVideoPlayBackPlayController:" + r100);
        f150010a = new WeakReference(r100);
    }
}
