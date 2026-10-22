package com.bytedance.bdinstall.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Constants.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r<SharedPreferences> f6299a = null;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Constants.java */
    public static class C0146a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f6300a = "verify";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f6301b = "register";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static String f6302c = "activate";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static String f6303d = "params";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static String f6304e = "dr_register_result";
        public static String f = "dr_active_result";
        public static String g = "dr_register_param";
        public static String h = "dr_verify_result";

        static {
        }
    }

    static {
        f6299a = new AnonymousClass1();
    }

    public static SharedPreferences a(Context r2, an r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L10;
        if (r3.o() == false) goto L8;
        return a(r4);
    L8:
        return a(r4, String.valueOf(r3.a()));
    L10:
        return a(r4);
    }

    public static SharedPreferences a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(f6299a.c(new Object[]{r5}), SharedPreferences.class, "com.obric.aiagent.plugin");
    }

    public static SharedPreferences a(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("ug_install_settings_pref_" + r3, 0);
    }

    public static String a(String r1, com.bytedance.bdinstall.b r2) {
        if (r2.b() == false) goto L6;
        r1 = r1 + "_i18n";
    L6:
        if (r2.c() == false) goto L9;
        r1 = r1 + "_boe";
    L9:
        if (r2.d() == true) goto L11;
        return r1;
    L11:
        return r1 + "_cm";
    }

    public static String a(com.bytedance.bdinstall.b r1) {
        return a("ug_install_settings_pref", r1);
    }

    public static String a(com.bytedance.bdinstall.b r2, String r3) {
        return a("ug_install_settings_pref", r2) + "_" + r3;
    }
}
