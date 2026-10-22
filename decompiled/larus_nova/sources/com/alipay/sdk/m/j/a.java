package com.alipay.sdk.m.j;

import android.text.TextUtils;
import com.alipay.sdk.m.u.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25356a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.alipay.sdk.m.m.a.b f25357b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.alipay.sdk.m.m.a.b f25358c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List<com.alipay.sdk.m.m.a.b> f25359d;

    static {
        com.alipay.sdk.m.m.a.b r100 = new com.alipay.sdk.m.m.a.b(n.f25868b, 73, com.alipay.sdk.m.l.a.f25464l);
        f25357b = r100;
        f25358c = new com.alipay.sdk.m.m.a.b("hk.alipay.wallet", 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");
        f25359d = Collections.singletonList(r100);
    }

    public static boolean b() {
        if (TextUtils.isEmpty(f25356a) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals("cn", f25356a) == true) goto L8;
        return false;
    }

    public a() {
    }

    public static String a() {
        return f25356a;
    }

    public static void a(String r100) {
        f25356a = r100;
        r100.getClass();
        if (r100.equals("hk") == true) goto L5;
        f25359d = Collections.singletonList(f25357b);
        return;
    L5:
        f25359d = Collections.singletonList(f25358c);
    }
}
