package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.net.Uri;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133000a = 0;

    static {
    }

    public static String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "pageFrom");
        Uri r102 = UriProtector.parse(r100);
        Uri.Builder r103 = r102.buildUpon();
        Set<String> r104 = r102.getQueryParameterNames();     // Catch: Exception -> L16 Throwable -> L21
        Uri.Builder r105 = r102.buildUpon().clearQuery();     // Catch: Exception -> L16 Throwable -> L21
        Iterator<String> r106 = r104.iterator();     // Catch: Exception -> L16 Throwable -> L21
    L4:
        if (r106.hasNext() == false) goto L15;
        String r107 = r106.next();     // Catch: Exception -> L16 Throwable -> L21
        if (Intrinsics.areEqual(r107, "url") == false) goto L12;
        String r108 = r102.getQueryParameter(r107);     // Catch: Exception -> L16 Throwable -> L21
        if (r108 == null) goto L11;
        String r109 = b(r108, "page_from", r101);     // Catch: Exception -> L16 Throwable -> L21
    L13:
        r105.appendQueryParameter(r107, r109);     // Catch: Exception -> L16 Throwable -> L21
        goto L4
    L11:
        r109 = null;
        goto L13
    L12:
        r109 = r102.getQueryParameter(r107);     // Catch: Exception -> L16 Throwable -> L21
        goto L13
    L15:
        Uri r110 = r105.build();
    L20:
        return r110.toString();
    L16:
        e = move-exception;
        SafetyGuard.a(null, e, "origin schema is " + r100);     // Catch: Throwable -> L21
    L18:
        r110 = r103.build();
        goto L20
    }

    public static String b(String r100, String r101, String r102) {
        Uri r103 = UriProtector.parse(r100);
        Uri.Builder r104 = r103.buildUpon();
        Set<String> r105 = r103.getQueryParameterNames();     // Catch: Exception -> L15 Throwable -> L20
        Uri.Builder r106 = r103.buildUpon().clearQuery();     // Catch: Exception -> L15 Throwable -> L20
        Iterator<String> r107 = r105.iterator();     // Catch: Exception -> L15 Throwable -> L20
    L5:
        if (r107.hasNext() == false) goto L12;
        String r108 = r107.next();     // Catch: Exception -> L15 Throwable -> L20
        if (Intrinsics.areEqual(r108, r101) == false) goto L9;
        String r109 = r102;
    L10:
        r106.appendQueryParameter(r108, r109);     // Catch: Exception -> L15 Throwable -> L20
        goto L5
    L9:
        r109 = r103.getQueryParameter(r108);     // Catch: Exception -> L15 Throwable -> L20
        goto L10
    L12:
        if (r105.contains(r101) == true) goto L14;
        r106.appendQueryParameter(r101, r102);     // Catch: Exception -> L15 Throwable -> L20
    L14:
        Uri r110 = r106.build();
    L19:
        return r110.toString();
    L15:
        e = move-exception;
        SafetyGuard.a(null, e, "real schema is " + r100);     // Catch: Throwable -> L20
    L17:
        r110 = r104.build();
        goto L19
    }
}
