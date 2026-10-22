package com.obric.aiagent.product.a;

import com.obric.aiagent.product.ObricProductSdk;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OfaHostConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18769a = null;

    static {
        f18769a = new a();
    }

    private a() {
    }

    public final boolean a() {
        return ObricProductSdk.INSTANCE.featureService().isEmulatorOs();
    }

    public final String b() {
        if (a() == false) goto L5;
        return "ofa.bytedance.net";
    L5:
        return "ofa.obriccloud.com";
    }

    public final String c() {
        return "https://" + b() + '/';
    }

    public final String d() {
        return a("auto_action/");
    }

    public final String a(String r4) {
        o.e(r4, DownloadConstants.PATH_KEY);
        String r5 = d.o.o.a(r4, (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return c();
    L10:
        return "https://" + b() + '/' + r5;
    L5:
        r0 = false;
        goto L6
    }
}
