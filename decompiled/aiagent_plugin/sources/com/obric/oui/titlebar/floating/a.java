package com.obric.oui.titlebar.floating;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FloatingTransitionFeature.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f36762a;

    private a() {
    }

    public static boolean a() {
        Boolean r0 = f36762a;
        if (r0 != null) goto L15;
        monitor-enter(a.class);
        r0 = f36762a;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = Boolean.valueOf(a("persist.sys.floating.transition", false));     // Catch: Throwable -> L11
        f36762a = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return r0.booleanValue();
    }

    private static boolean a(String r8, boolean r9) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke(null, new Object[]{r8, Boolean.valueOf(r9)}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        return r9;
    }
}
