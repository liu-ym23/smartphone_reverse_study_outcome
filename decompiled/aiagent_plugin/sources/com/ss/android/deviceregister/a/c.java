package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.deviceregister.c.f;
import com.ss.android.deviceregister.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PrivateAgreement.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f37325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f<SharedPreferences> f37326b;

    static /* synthetic */ f a() {
        return f37326b;
    }

    public static boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (k.a() == false) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (f37325a == false) goto L12;
        return true;
    L12:
        return c(r4).getBoolean("_install_started_v2", false);
    }

    static {
        f37326b = new AnonymousClass1();
    }

    private static SharedPreferences c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(f37326b.c(new Object[]{r5}), SharedPreferences.class, "com.obric.aiagent.plugin");
    }

    public static void b(Context r2) {
        final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        f37325a = true;
        com.bytedance.common.utility.a.c.a(new AnonymousClass2(r3));
    }
}
