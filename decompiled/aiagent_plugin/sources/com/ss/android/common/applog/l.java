package com.ss.android.common.applog;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: IAppLogApi.java */
/* JADX INFO: loaded from: classes4.dex */
public interface l {
    a a(Context r1);

    String a();

    void a(Context r1, String r2, String r3, String r4, long r5, long r7, boolean r9, JSONObject r10);

    void a(com.service.middleware.applog.a r1);

    boolean a(String r1);

    String b();

    String c();

    JSONObject d();

    JSONObject e();

    String f();

    com.service.middleware.applog.a g();

    String h();

    String i();

    com.bytedance.applog.m j();
}
