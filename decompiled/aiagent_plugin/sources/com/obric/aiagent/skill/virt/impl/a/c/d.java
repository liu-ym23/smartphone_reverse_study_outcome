package com.obric.aiagent.skill.virt.impl.a.c;

import android.content.Context;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: VirtAppIdentity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "Virt/Identity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f22039a = null;

    static {
        f22039a = new d();
    }

    private d() {
    }

    public final boolean a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        int r1 = r7.getPackageManager().checkSignatures(r7.getPackageName(), "android");     // Catch: Throwable -> L9
        if (r1 != 0) goto L6;
        boolean r2 = true;
    L7:
        a(TAG, "isPlatformSigned package=" + r7.getPackageName() + " framework=android checkSignaturesCode=" + r1 + " result=" + r2);     // Catch: Throwable -> L9
        return r2;
    L6:
        r2 = false;
    L9:
        th = move-exception;
        a(TAG, "isPlatformSigned threw; treating caller as non-platform.", th);
        return false;
    }

    public final boolean b(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        if ((r2.getApplicationInfo().flags & 129) != 0) goto L13;
        return false;
    L13:
        return true;
    L7:
        th = move-exception;
        a(TAG, "isPrivileged threw; treating caller as non-privileged.", th);
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
