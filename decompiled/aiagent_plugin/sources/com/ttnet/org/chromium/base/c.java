package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CommandLine.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    private static final String TAG = "CommandLine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37696a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<c> f37697b = null;

    public abstract boolean a(String r1);

    static {
        f37697b = new AtomicReference();
    }

    public static boolean a() {
        if (f37697b.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static c b() {
        c r0 = (c) ZeusTransformUtils.preCheckCast(f37697b.get(), c.class, "com.obric.aiagent.plugin");
        if (f37696a == true) goto L8;
        if (r0 != null) goto L8;
        throw new AssertionError();
    L8:
        return r0;
    }

    private c() {
    }
}
