package com.obric.agent.intents.music.netease;

import android.content.Context;
import android.content.pm.PackageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: NetEaseAppChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f14846a = null;

    static {
        f14846a = new l();
    }

    private l() {
    }

    public final boolean a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        r1.getPackageManager().getPackageInfo("com.netease.cloudmusic", 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L9:
        return false;
    }

    public final boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        if (r1.getPackageManager().getPackageInfo("com.netease.cloudmusic", 0).versionCode >= 9005020) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }
}
