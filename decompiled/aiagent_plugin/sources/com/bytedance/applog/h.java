package com.bytedance.applog;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.bdinstall.af;
import com.bytedance.bdinstall.ar;
import com.bytedance.bdinstall.as;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: IAppLogInstance.java */
/* JADX INFO: loaded from: classes.dex */
public interface h {
    String a(Context r1, String r2, boolean r3, ar r4);

    void a(long r1, as r3);

    void a(Context r1, p r2);

    void a(Context r1, boolean r2, long r3, as r5);

    void a(com.bytedance.applog.collector.a r1);

    void a(i r1);

    void a(af r1);

    void a(String r1, Bundle r2);

    void a(String r1, Object r2);

    void a(String r1, JSONObject r2);

    void a(Map<String, String> r1);

    void a(boolean r1);

    boolean a(Context r1);

    String b();

    void b(String r1);

    void b(boolean r1);

    void c();

    void c(boolean r1);

    void d();

    void d(boolean r1);

    void e(boolean r1);

    void f(boolean r1);

    void g(boolean r1);

    Context getContext();

    String l();

    String m();

    String n();

    String o();

    String p();

    JSONObject r();

    String u();

    IBDAccountCallback w();
}
