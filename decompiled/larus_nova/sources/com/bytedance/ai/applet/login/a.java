package com.bytedance.ai.applet.login;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f34736a = 0;

    static {
    }

    public static c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "authLink");
        Uri r101 = UriProtector.parse(r100);
        return new c(r101.getScheme(), r101.getHost(), UriProtector.getQueryParameter(r101, "state"), UriProtector.getQueryParameter(r101, "client_key"), UriProtector.getQueryParameter(r101, "biz"), UriProtector.getQueryParameter(r101, "scope"));
    }
}
