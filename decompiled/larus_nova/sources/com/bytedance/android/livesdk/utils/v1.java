package com.bytedance.android.livesdk.utils;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f159188a;

    public v1() {
        this.f159188a = new HashMap();
    }

    public final void a(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L6;
        this.f159188a.put(r100, r101);
        return;
    }
}
