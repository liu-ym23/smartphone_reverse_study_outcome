package com.alipay.sdk.m.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes28.dex */
public class e implements com.alipay.sdk.m.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25250a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    public e() {
    }

    @Override // com.alipay.sdk.m.b.b
    public String a(Context r100) {
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Uri r102 = UriProtector.parse(f25250a);
        Cursor r103 = com_alipay_sdk_m_c_e_android_content_ContentResolver_query(r100.getContentResolver(), r102, null, null, null, null);
        if (r103 != null) goto L8;
    L11:
        return r101;
    L8:
        if (r103.moveToNext() == false) goto L10;
        r101 = r103.getString(r103.getColumnIndex("device_ids_grndid"));
    L10:
        r103.close();
        goto L11
    }

    private static Cursor com_alipay_sdk_m_c_e_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
