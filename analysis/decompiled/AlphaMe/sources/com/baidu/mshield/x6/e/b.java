package com.baidu.mshield.x6.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x6.EngineImpl;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f8481a;

    /* renamed from: b, reason: collision with root package name */
    public com.baidu.mshield.x6.b.b f8482b;

    public b(Context context) {
        this.f8481a = context;
        this.f8482b = new com.baidu.mshield.x6.b.b(context);
    }

    public void a() {
        try {
            String strR = this.f8482b.r();
            String propertyByType = EngineImpl.getInstance(this.f8481a).getPropertyByType("arid");
            TextUtils.isEmpty("");
            if (TextUtils.isEmpty(propertyByType)) {
                propertyByType = "";
            }
            if (TextUtils.isEmpty(strR)) {
                String strA = com.baidu.mshield.b.f.e.a("" + propertyByType);
                if (!TextUtils.isEmpty(strA)) {
                    this.f8482b.c(strA);
                }
            } else {
                String strA2 = com.baidu.mshield.b.f.e.a("" + propertyByType);
                if (!TextUtils.equals(strR, strA2)) {
                    this.f8482b.c(strA2);
                    h.a(this.f8481a).a(3, true);
                }
            }
            this.f8482b.c(true);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}
