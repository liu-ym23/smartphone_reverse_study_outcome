package com.alipay.sdk.m.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25680b = "VMS_IDLG_SDK_DB";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25681c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25682d = "value";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25683e = "OAID";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25684f = "AAID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25685g = "VAID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f25686h = "OAIDSTATUS";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25687i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25688j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25689k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25690l = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25691a;

    public b(Context r100) {
        this.f25691a = r100;
    }

    public String a(int r100, String r101) {
        String r102 = null;
        if (r100 != 0) goto L5;
        Uri r103 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    L15:
        Uri r104 = r103;
    L16:
        Cursor r105 = com_alipay_sdk_m_p0_b_android_content_ContentResolver_query(this.f25691a.getContentResolver(), r104, null, null, null, null);
        if (r105 != null) goto L19;
    L22:
        return r102;
    L19:
        if (r105.moveToNext() == false) goto L21;
        r102 = r105.getString(r105.getColumnIndex("value"));
    L21:
        r105.close();
        goto L22
    L5:
        if (r100 != 1) goto L7;
        r103 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r101);
        goto L15
    L7:
        if (r100 != 2) goto L9;
        r103 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r101);
        goto L15
    L9:
        if (r100 == 4) goto L11;
        r104 = null;
        goto L16
    L11:
        r103 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
        goto L15
    }

    private static Cursor com_alipay_sdk_m_p0_b_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
