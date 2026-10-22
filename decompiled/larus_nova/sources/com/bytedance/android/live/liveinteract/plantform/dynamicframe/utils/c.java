package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.net.Uri;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f77132a = 0;

    public c() {
    }

    static {
    }

    public static String a(String r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = -1;
    L5:
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
        Uri r103 = UriProtector.parse(r100);
        Uri.Builder r104 = r103.buildUpon();
        w0.a();
        String r105 = UriProtector.getQueryParameter(r103, "business_type");
        boolean r106 = true;
        if (r105 != null) goto L8;
    L12:
        r104.appendQueryParameter("business_type", "livelinkmic");
    L13:
        String r107 = UriProtector.getQueryParameter(r103, "business_group");
        if (r107 != null) goto L16;
    L20:
        r104.appendQueryParameter("business_group", "livelinkmic");
    L21:
        r104.appendQueryParameter("show_from", String.valueOf(r101));
        if (FoldScreenUtils.f() == false) goto L24;
        String r108 = "1";
    L25:
        r104.appendQueryParameter("is_android_fold", r108);
        return r104.build().toString();
    L24:
        r108 = "0";
        goto L25
    L16:
        if (r107.length() == 0) goto L19;
        r106 = false;
    L19:
        if (r106 == false) goto L21;
    L8:
        if (r105.length() != 0) goto L10;
        boolean r109 = true;
    L11:
        if (r109 == false) goto L13;
    L10:
        r109 = false;
        goto L11
    }

    public static String b(String r100, Long r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon();
        if (r101 == null) goto L15;
        r101.longValue();
        if (r101.longValue() <= 0) goto L7;
        r104.appendQueryParameter("multilink_room_id", String.valueOf(r101.longValue()));
    L7:
        if (r102 == false) goto L9;
        String r105 = "1";
    L10:
        r104.appendQueryParameter("multilink_is_feed", r105);
        if (r103 != null) goto L13;
        String r106 = "";
    L14:
        r104.appendQueryParameter("multilink_enter_from", r106);
        goto L15
    L13:
        r106 = r103;
        goto L14
    L9:
        r105 = "0";
    L15:
        if (r103 == null) goto L26;
        if (r103.length() <= 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L23;
        r103 = null;
    L23:
        if (r103 == null) goto L26;
        r104.appendQueryParameter("enter_from", r103);
        goto L26
    L19:
        r107 = false;
    L26:
        return r104.build().toString();
    }
}
