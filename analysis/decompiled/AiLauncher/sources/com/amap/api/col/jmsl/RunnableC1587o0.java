package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.C1551f0;
import com.amap.api.maps.AMapCallback;

/* renamed from: com.amap.api.col.jmsl.o0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC1587o0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f16788a;

    /* renamed from: b, reason: collision with root package name */
    public Context f16789b;

    /* renamed from: c, reason: collision with root package name */
    public C1551f0 f16790c;

    /* renamed from: d, reason: collision with root package name */
    public AMapCallback<C1551f0.a> f16791d;

    public RunnableC1587o0(Context context, AMapCallback<C1551f0.a> aMapCallback, String str, String str2) {
        this.f16789b = context;
        this.f16791d = aMapCallback;
        this.f16788a = str2;
        if (this.f16790c == null) {
            this.f16790c = new C1551f0(context, str);
        }
    }

    public void a() {
        this.f16789b = null;
        if (this.f16790c != null) {
            this.f16790c = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        C1551f0.a aVar;
        try {
            C1551f0 c1551f0 = this.f16790c;
            if (c1551f0 == null || (aVar = (C1551f0.a) c1551f0.f()) == null || aVar.f16623a == null) {
                return;
            }
            aVar.f16624b = this.f16788a;
            AMapCallback<C1551f0.a> aMapCallback = this.f16791d;
            if (aMapCallback != null) {
                aMapCallback.onCallback(aVar);
            }
        } catch (Throwable th) {
            C1541c2.b(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
