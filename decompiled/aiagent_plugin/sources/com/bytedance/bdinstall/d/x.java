package com.bytedance.bdinstall.d;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: RomLoader.java */
/* JADX INFO: loaded from: classes.dex */
class x extends d {
    x() {
        super(true, false);
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r3) {
        StringBuilder r2 = new StringBuilder(16);
        if (com.bytedance.bdinstall.j.p.o() == false) goto L6;
        r2.append("MIUI-");
    L13:
        r2.append(Build.VERSION.INCREMENTAL);
        r3.put("rom", r2.toString());
        String r4 = com.bytedance.bdinstall.j.p.b();
        if (TextUtils.isEmpty(r4) == true) goto L18;
        r3.put("rom_version", r4);
        return true;
    L18:
        return true;
    L6:
        if (com.bytedance.bdinstall.j.p.g() == false) goto L8;
        r2.append("FLYME-");
        goto L13
    L8:
        String r0 = com.bytedance.bdinstall.j.p.a();
        if (com.bytedance.bdinstall.j.p.a(r0) == false) goto L13;
        r2.append("EMUI-");
        if (TextUtils.isEmpty(r0) == true) goto L13;
        r2.append(r0).append("-");
        goto L13
    }
}
