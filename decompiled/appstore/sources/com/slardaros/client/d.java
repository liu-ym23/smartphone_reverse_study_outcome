package com.slardaros.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f17839a = false;

    static {
    }

    public static void a() {
        Context r10 = b();
        if (r10 != null) goto L15;
        return;
    L15:
        SharedPreferences r11 = r10.getSharedPreferences("slardar_client_sdk", 0);     // Catch: Exception -> L8
        String r12 = r11.getString("last_version_code", "");     // Catch: Exception -> L8
        String r13 = i.b(r10);     // Catch: Exception -> L8
        if (TextUtils.equals(r12, r13) == true) goto L10;
        f17839a = true;     // Catch: Exception -> L8
        r11.edit().putString("last_version_code", r13).apply();     // Catch: Exception -> L8
    L14:
        return;
    L10:
        f17839a = false;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        OLog.e("SlardarAgent", "checkWhetherFirstInstall" + e.getMessage());
    }

    public static Context b() {
        return ((h) b.a()).e();
    }

    public static void c(Context r10) {
        OLog.d("SlardarAgent", "on init");     // Catch: Throwable -> L7
        b.a().b(r10);     // Catch: Throwable -> L7
        if (i.c() == false) goto L12;
        a();     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        OLog.e("SlardarAgent", "init " + th.getMessage());
    }

    public static boolean d() {
        return f17839a;
    }

    public static void e(ArrayList r10) {
        OLog.d("SlardarAgent", "onAgentEventList");     // Catch: Throwable -> L5
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L5
        r11.addAll(r10);     // Catch: Throwable -> L5
        b.a().c(r11);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e("SlardarAgent", "onAgentEventList " + th.getMessage());
    }
}
