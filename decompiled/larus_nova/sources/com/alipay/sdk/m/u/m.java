package com.alipay.sdk.m.u;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes28.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25866a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public m() {
    }

    public static String a(Context r100) {
        Cursor r101 = com_alipay_sdk_m_u_m_android_content_ContentResolver_query(r100.getContentResolver(), UriProtector.parse(f25866a), null, null, null, null);
        String r102 = null;
        if (r101 != null) goto L5;
    L10:
        return r102;
    L5:
        if (r101.getCount() <= 0) goto L10;
        if (r101.moveToFirst() == false) goto L9;
        r102 = r101.getString(r101.getColumnIndex("url"));
    L9:
        r101.close();
        goto L10
    }

    public static String b(Context r100) {
        if (EnvUtils.isPreSandBox() == false) goto L7;
        return com.alipay.sdk.m.l.a.f25454b;
    L7:
        if (EnvUtils.isNewSanBox() == false) goto L10;
        return com.alipay.sdk.m.l.a.f25455c;
    L10:
        if (r100 == null) goto L12;
        String r101 = com.alipay.sdk.m.l.a.f25453a;
        if (TextUtils.isEmpty(r101) == true) goto L16;
        return r101;
    L16:
        return com.alipay.sdk.m.l.a.f25453a;
    L12:
        return com.alipay.sdk.m.l.a.f25453a;
    }

    private static Cursor com_alipay_sdk_m_u_m_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
