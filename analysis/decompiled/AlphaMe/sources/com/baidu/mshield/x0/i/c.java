package com.baidu.mshield.x0.i;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.d.d;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends com.baidu.mshield.b.d.a {

    /* renamed from: c, reason: collision with root package name */
    public b f8430c;

    public c(Context context, Handler handler) {
        super(context, handler);
        this.f8268b = context;
        this.f8430c = b.a(context);
    }

    public boolean a(String str) {
        com.baidu.mshield.b.c.a.b("j=" + str);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            byte[] bArrD = d.d();
            String strB = this.f8430c.b(URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.d(bArrD, e.a(com.baidu.mshield.utility.c.b(this.f8268b)).getBytes()), 0)));
            byte[] bArrA = this.f8430c.a(bArrD, str);
            if (bArrA == null) {
                return true;
            }
            try {
                String strA = a(strB, bArrA);
                if (TextUtils.isEmpty(strA)) {
                    return false;
                }
                try {
                    new JSONObject(strA).getInt("response");
                    return true;
                } catch (Throwable th) {
                    d.a(th);
                    return true;
                }
            } catch (Throwable th2) {
                d.a(th2);
                return false;
            }
        } catch (Throwable th3) {
            d.a(th3);
            return true;
        }
    }
}
