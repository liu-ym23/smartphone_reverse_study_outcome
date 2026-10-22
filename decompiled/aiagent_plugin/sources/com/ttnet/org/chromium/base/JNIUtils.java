package com.ttnet.org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class JNIUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37628a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f37629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ClassLoader f37630c;

    static {
    }

    public JNIUtils() {
    }

    private static ClassLoader a() {
        ClassLoader r0 = f37630c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return JNIUtils.class.getClassLoader();
    }

    public static ClassLoader getSplitClassLoader(String r3) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L9;
        if (BundleUtils.a(r0, r3) == false) goto L9;
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BundleUtils.b(r0, r3), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getClassLoader();
    L9:
        return a();
    }

    public static boolean isSelectiveJniRegistrationEnabled() {
        if (f37629b != null) goto L6;
        f37629b = false;
    L6:
        return f37629b.booleanValue();
    }
}
