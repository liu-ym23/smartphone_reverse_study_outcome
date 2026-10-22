package com.ss.android.deviceregister;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EgdiManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f37435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f37436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f37437d;

    static /* synthetic */ int a(i r2) {
        int r0 = r2.f37434a;
        r2.f37434a = r0 + 1;
        return r0;
    }

    public i(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f37434a = 0;
        this.f37435b = new Handler(Looper.getMainLooper());
        this.f37436c = "";
        this.f37437d = r5.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0);
    }

    public void a(final com.ss.android.deviceregister.a.e r3) {
        if (this.f37434a < 3) goto L6;
        com.ss.android.common.util.e.c("[egdi] retry count has been limited. retryCount = " + this.f37434a);
        return;
    L6:
        this.f37435b.postDelayed(new AnonymousClass1(this, r3), g.w());
    }

    public String a() {
        if (TextUtils.isEmpty(this.f37436c) == false) goto L5;
        com.ss.android.common.util.e.c("[egdi] get egdi from sp.");
        String r0 = this.f37437d.getString("klink_egdi", "");
        this.f37436c = r0;
        return r0;
    L5:
        return this.f37436c;
    }
}
