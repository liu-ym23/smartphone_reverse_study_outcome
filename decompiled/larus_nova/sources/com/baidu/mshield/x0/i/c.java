package com.baidu.mshield.x0.i;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.d.d;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class c extends com.baidu.mshield.b.d.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f32529c;

    public boolean a(String r100) {
        com.baidu.mshield.b.c.a.b("j=" + r100);
        if (TextUtils.isEmpty(r100) == false) goto L25;
        return true;
    L25:
        byte[] r101 = d.d();     // Catch: Throwable -> L20
        String r102 = this.f32529c.b(URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.d(r101, e.a(com.baidu.mshield.utility.c.b(this.f32367b)).getBytes()), 0)));     // Catch: Throwable -> L20
        byte[] r103 = this.f32529c.a(r101, r100);     // Catch: Throwable -> L20
        if (r103 != null) goto L23;
        return true;
    L23:
        String r104 = a(r102, r103);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r104) == false) goto L27;
        return false;
    L27:
        new JSONObject(r104).getInt("response");     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        d.a(th);
        return true;
    L17:
        th = move-exception;
        d.a(th);
        return false;
    L20:
        th = move-exception;
        d.a(th);
        return true;
    }

    public c(Context r100, Handler r101) {
        super(r100, r101);
        this.f32367b = r100;
        this.f32529c = b.a(r100);
    }
}
