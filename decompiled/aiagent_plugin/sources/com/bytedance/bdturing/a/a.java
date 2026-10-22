package com.bytedance.bdturing.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.setting.g;
import com.bytedance.bdturing.setting.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SettingsManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "SettingsManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g.a f6498a;

    static /* synthetic */ void a() {
        b();
    }

    private static void b() {
        if (com.bytedance.bdturing.b.a().b() == null) goto L6;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.bdturing.b.a().b().getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
    L7:
        if (r0 == null) goto L13;
        SharedPreferences.Editor r1 = r0.getSharedPreferences("bd_turning_settings_init", 0).edit();     // Catch: Exception -> L10
        r1.putBoolean("inited", true);     // Catch: Exception -> L10
        r1.commit();     // Catch: Exception -> L10
        return;
    L13:
        return;
    L6:
        r0 = null;
    }

    static {
        f6498a = new AnonymousClass1();
    }

    public static void a(final BdTuringConfig r4) {
        h.f6610a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new AnonymousClass2(r4));
        h.f6610a.a(f6498a);
    }
}
