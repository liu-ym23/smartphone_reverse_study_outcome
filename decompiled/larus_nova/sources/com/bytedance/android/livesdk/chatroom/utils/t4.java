package com.bytedance.android.livesdk.chatroom.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t4 {
    static {
    }

    @JvmStatic
    public static final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        Uri r103 = UriProtector.parse(r100);     // Catch: Exception -> L18
        Set<String> r104 = UriProtector.getQueryParameterNames(r103);     // Catch: Exception -> L18
        Uri.Builder r105 = r103.buildUpon().clearQuery();     // Catch: Exception -> L18
        Iterator<String> r106 = r104.iterator();     // Catch: Exception -> L18
        boolean r107 = false;
    L5:
        if (r106.hasNext() == false) goto L14;
        String r108 = r106.next();     // Catch: Exception -> L18
        if (Intrinsics.areEqual(r108, r101) == false) goto L10;
        r107 = true;
    L10:
        if (Intrinsics.areEqual(r108, r101) == false) goto L12;
        String r109 = r102;
    L13:
        r105.appendQueryParameter(r108, r109);     // Catch: Exception -> L18
        goto L5
    L12:
        r109 = UriProtector.getQueryParameter(r103, r108);     // Catch: Exception -> L18
        goto L13
    L14:
        if (r107 == true) goto L16;
        r105.appendQueryParameter(r101, r102);     // Catch: Exception -> L18
    L16:
        return r105.build().toString();
    L24:
        return r100;
    }
}
