package com.baidu.mshield.x6.e;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public Context f8496a;

    public g(Context context, int i4) {
        this.f8496a = context;
    }

    public JSONObject a() {
        try {
            return b();
        } catch (Throwable th) {
            this.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0263 A[Catch: all -> 0x020a, TryCatch #5 {all -> 0x020a, blocks: (B:3:0x0010, B:5:0x0025, B:7:0x002e, B:9:0x0037, B:11:0x0048, B:13:0x0059, B:15:0x007b, B:20:0x008a, B:22:0x008f, B:24:0x0098, B:50:0x00fa, B:52:0x0110, B:79:0x0197, B:82:0x019e, B:84:0x01c7, B:86:0x01e2, B:88:0x01f0, B:90:0x01f6, B:91:0x01fa, B:93:0x0200, B:96:0x020d, B:97:0x0221, B:99:0x0249, B:101:0x0252, B:102:0x0259, B:104:0x0263, B:106:0x026f, B:108:0x028e, B:110:0x0294, B:111:0x0298, B:113:0x029e, B:114:0x02a8, B:115:0x02bc, B:116:0x02c1, B:71:0x0183, B:76:0x0191, B:49:0x00f7, B:73:0x0188, B:26:0x00b3, B:35:0x00da, B:40:0x00e4, B:42:0x00e9, B:46:0x00f2), top: B:130:0x0010, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c7 A[Catch: all -> 0x020a, TRY_LEAVE, TryCatch #5 {all -> 0x020a, blocks: (B:3:0x0010, B:5:0x0025, B:7:0x002e, B:9:0x0037, B:11:0x0048, B:13:0x0059, B:15:0x007b, B:20:0x008a, B:22:0x008f, B:24:0x0098, B:50:0x00fa, B:52:0x0110, B:79:0x0197, B:82:0x019e, B:84:0x01c7, B:86:0x01e2, B:88:0x01f0, B:90:0x01f6, B:91:0x01fa, B:93:0x0200, B:96:0x020d, B:97:0x0221, B:99:0x0249, B:101:0x0252, B:102:0x0259, B:104:0x0263, B:106:0x026f, B:108:0x028e, B:110:0x0294, B:111:0x0298, B:113:0x029e, B:114:0x02a8, B:115:0x02bc, B:116:0x02c1, B:71:0x0183, B:76:0x0191, B:49:0x00f7, B:73:0x0188, B:26:0x00b3, B:35:0x00da, B:40:0x00e4, B:42:0x00e9, B:46:0x00f2), top: B:130:0x0010, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject b() {
        /*
            Method dump skipped, instructions count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.e.g.b():org.json.JSONObject");
    }

    public final void a(Throwable th) {
        com.baidu.mshield.x6.f.f.b(th);
    }

    public static String a(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return null;
            }
            String stringExtra = intentRegisterReceiver.getStringExtra("technology");
            return TextUtils.isEmpty(stringExtra) ? "unknown" : stringExtra;
        } catch (Exception e4) {
            com.baidu.mshield.x6.f.f.b(e4);
            return null;
        }
    }
}
