package com.bytedance.ttnet.g;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RequestDropController.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f11469a;

    public f() {
        this.f11469a = new CopyOnWriteArraySet();
    }

    public void a(JSONObject r4) {
        this.f11469a.clear();
        JSONArray r5 = r4.optJSONArray("dl");
        if (r5 == null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= r5.length()) goto L15;
        String r1 = r5.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L10;
        this.f11469a.add(r1);
    L10:
        r0 = r0 + 1;
        goto L6
    L15:
        return;
    }

    public void a(com.bytedance.retrofit2.b.c r2) {
        if (i.a(this.f11469a, r2.o()) == true) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("RequestDropController", "check drop and match " + r2.o());
    L8:
        throw new com.bytedance.frameworks.baselib.network.http.c.c();
    }

    public boolean a() {
        if (this.f11469a.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
