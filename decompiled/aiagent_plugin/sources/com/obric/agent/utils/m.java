package com.obric.agent.utils;

import android.cypress.mediacontext.ICypressMediaContext;
import android.cypress.mediacontext.MediaSessionData;
import android.os.IBinder;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CypressMediaContextHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private static final String TAG = "CypressMediaContextHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f16044a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ICypressMediaContext f16045b;

    private m() {
    }

    static {
        m r0 = new m();
        f16044a = r0;
        r0.b();
    }

    private final void b() {
        if (f16045b == null) goto L5;
        return;
    L5:
        ILogDepend.Companion.i(TAG, "init");
        IBinder r3 = null;
        Object r0 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cypressmedia.mediacontext"});     // Catch: Exception -> L11
        if (ZeusTransformUtils.instanceOf(r0, IBinder.class) == false) goto L9;
        r3 = (IBinder) ZeusTransformUtils.preCheckCast(r0, IBinder.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
    L9:
        f16045b = ICypressMediaContext.Stub.asInterface(r3);     // Catch: Exception -> L11
        ILogDepend.Companion.i(TAG, "init success");     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "init error: " + e);
    }

    public final MediaSessionData a() {
        if (f16045b != null) goto L5;
        b();
    L5:
        MediaSessionData r4 = new MediaSessionData();
        ICypressMediaContext r0 = f16045b;
        if (r0 == null) goto L8;
        Integer r1 = Integer.valueOf(r0.getCurrentMediaSessionData(r4));
    L9:
        if (r1 != null) goto L12;
    L13:
        ILogDepend.Companion.e(TAG, "getCurrentMediaSessionData error: " + r1);
        return null;
    L12:
        if (r1.intValue() != 0) goto L13;
        return r4;
    L8:
        r1 = null;
        goto L9
    }
}
