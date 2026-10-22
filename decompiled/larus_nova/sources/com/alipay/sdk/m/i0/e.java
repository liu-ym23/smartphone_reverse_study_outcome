package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public final class e extends BroadcastReceiver {
    public e() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r100 == null) goto L36;
        if (r101 == null) goto L37;
        boolean r102 = false;
        int r103 = r101.getIntExtra("openIdNotifyFlag", 0);
        f.a("shouldUpdateId, notifyFlag : ".concat(String.valueOf(r103)));
        if (r103 != 1) goto L11;
        if (TextUtils.equals(r101.getStringExtra("openIdPackage"), r100.getPackageName()) == true) goto L16;
    L17:
        if (r102 == true) goto L19;
        return;
    L19:
        String r104 = r101.getStringExtra("openIdType");
        f r105 = f.a();
        if ("oaid".equals(r104) == false) goto L23;
        a r106 = r105.f25351b;
    L32:
        if (r106 != null) goto L34;
        return;
    L34:
        r106.b();
        return;
    L23:
        if ("vaid".equals(r104) == false) goto L26;
        r106 = r105.f25353d;
        goto L32
    L26:
        if ("aaid".equals(r104) == false) goto L29;
        r106 = r105.f25352c;
        goto L32
    L29:
        if ("udid".equals(r104) == false) goto L31;
        r106 = r105.f25350a;
        goto L32
    L31:
        r106 = null;
    L16:
        r102 = true;
        goto L17
    L11:
        if (r103 != 2) goto L15;
        ArrayList<String> r107 = r101.getStringArrayListExtra("openIdPackageList");
        if (r107 == null) goto L17;
        r102 = r107.contains(r100.getPackageName());
        goto L17
    L15:
        if (r103 != 0) goto L17;
    L37:
        return;
    }
}
