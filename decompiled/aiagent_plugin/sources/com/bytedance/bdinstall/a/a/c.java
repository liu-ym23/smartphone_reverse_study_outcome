package com.bytedance.bdinstall.a.a;

import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.t;
import org.json.JSONObject;

/* JADX INFO: compiled from: Monitor.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public abstract JSONObject a();

    public abstract void b();

    public c() {
    }

    public void a(an r5, String r6) {
        JSONObject r0 = a();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.E() == null) goto L14;
        r5.E().a(r6, r0);
        if (TextUtils.isEmpty(r6) == true) goto L9;
        t.a("EventTracking# " + r6 + r5.a() + ", " + r0);
    L9:
        b();
        if (TextUtils.isEmpty(r6) == true) goto L15;
        t.a("EventTracking# " + r6 + r5.a() + " reset.");
        return;
    L15:
        return;
    }
}
