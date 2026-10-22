package com.bytedance.applog.b;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.bytedance.bdinstall.af;
import com.bytedance.bdinstall.am;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ar;
import com.bytedance.bdinstall.as;
import com.bytedance.bdinstall.u;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: IBdInstallService.java */
/* JADX INFO: loaded from: classes.dex */
public interface d {
    String a(Context r1, StringBuilder r2, boolean r3, ar r4);

    void a();

    void a(Application r1, String r2);

    void a(Context r1, u r2, long r3, as r5);

    void a(Context r1, String r2);

    void a(Context r1, String r2, String r3);

    void a(b.InterfaceC0134b r1);

    void a(com.bytedance.applog.j.b r1, u r2, Looper r3, com.bytedance.applog.d r4);

    void a(af r1);

    void a(u r1);

    void a(HashMap<String, Object> r1);

    boolean a(Context r1);

    boolean a(JSONObject r1);

    am b();

    void b(Context r1, u r2, long r3, as r5);

    void b(u r1);

    String c();

    void c(u r1);

    String d();

    String e();

    an f();

    void g();
}
