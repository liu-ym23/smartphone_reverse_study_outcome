package com.bytedance.bdinstall.g;

import android.content.Context;
import com.bytedance.bdinstall.am;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.as;
import com.bytedance.bdinstall.u;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: IInstallService.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {
    void a();

    void a(Context r1, u r2, long r3, as r5);

    void a(Context r1, Map<String, Object> r2);

    void a(Context r1, Map<String, String> r2, boolean r3, boolean r4);

    void a(am r1);

    void a(an r1, u r2);

    void a(u r1);

    boolean a(JSONObject r1);

    am b();

    void b(u r1);

    String c();

    boolean d();

    u e();
}
