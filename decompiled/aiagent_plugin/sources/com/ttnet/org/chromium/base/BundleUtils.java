package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.LayoutInflater;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class BundleUtils {
    private static final String TAG = "BundleUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37606a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f37607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f37608c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final androidx.b.g<String, ClassLoader> f37609d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, ClassLoader> f37610e = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.BundleUtils$1, reason: invalid class name */
    class AnonymousClass1 extends ContextWrapper {
        final /* synthetic */ ClassLoader val$splitClassLoader;

        AnonymousClass1(Context r3, ClassLoader r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.val$splitClassLoader = r4;
            super(r5);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public ClassLoader getClassLoader() {
            return this.val$splitClassLoader;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String r3) {
            Object r0 = super.getSystemService(r3);
            if ("layout_inflater".equals(r3) == true) goto L5;
            return r0;
        L5:
            return ((LayoutInflater) ZeusTransformUtils.preCheckCast(r0, LayoutInflater.class, "com.obric.aiagent.plugin")).cloneInContext(this);
        }
    }

    public static Context b(Context r1, String r2) {
        return (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
    }

    public static String getNativeLibraryPath(String r0, String r1) {
        return "";
    }

    public BundleUtils() {
    }

    static {
        f37608c = new Object();
        f37609d = new androidx.b.g();
        f37610e = Collections.synchronizedMap(new androidx.b.a());
    }

    public static boolean isBundleForNative() {
        return a();
    }

    public static boolean a() {
        if (BuildConfig.BUNDLES_SUPPORTED == true) goto L7;
        return false;
    L7:
        if (f37606a == true) goto L14;
        if (f37607b != null) goto L14;
        throw new AssertionError();
    L14:
        return f37607b.booleanValue();
    }

    public static boolean a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        String[] r6 = com.ttnet.org.chromium.base.compat.c.a(r5.getApplicationInfo());
        if (r6 != null) goto L8;
        return false;
    L8:
        if (Arrays.asList(r6).contains(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
