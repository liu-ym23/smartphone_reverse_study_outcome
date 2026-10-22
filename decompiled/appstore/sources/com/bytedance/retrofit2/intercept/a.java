package com.bytedance.retrofit2.intercept;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.RetrofitMetrics;
import f6.e;
import f6.f;
import g6.b;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements Interceptor.Chain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f8079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Call f8080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RetrofitMetrics f8082f;

    public a(List r10, int r11, b r12, Call r13, RetrofitMetrics r14) {
        this.f8077a = r10;
        this.f8078b = r11;
        this.f8079c = r12;
        this.f8080d = r13;
        this.f8082f = r14;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Call call() {
        return this.f8080d;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public RetrofitMetrics metrics() {
        return this.f8082f;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public f proceed(b r10) {
        if (this.f8078b >= this.f8077a.size()) goto L26;
        int r11 = this.f8081e + 1;
        this.f8081e = r11;
        if (r11 <= 1) goto L12;
        Iterator r12 = this.f8077a.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Interceptor r13 = (Interceptor) r12.next();
        if ((r13 instanceof f6.a) == false) goto L8;
        ((f6.a) r13).h();
    L12:
        a r14 = new a(this.f8077a, this.f8078b + 1, r10, this.f8080d, this.f8082f);
        Interceptor r15 = (Interceptor) this.f8077a.get(this.f8078b);
        StringBuilder r16 = new StringBuilder();
        r16.append("interceptor = ");
        if (r15 == null) goto L15;
        String r17 = r15.toString();
    L16:
        r16.append(r17);
        r16.append(" url = ");
        r16.append(r10.D());
        e.a("RealInterceptorChain", r16.toString());
        f r18 = r15.intercept(r14);
        if (r18 == null) goto L24;
        if (r18.e() == null) goto L22;
        return r18;
    L22:
        throw new IllegalStateException("interceptor " + r15 + " returned a ssResponse with no body");
    L24:
        throw new NullPointerException("interceptor " + r15 + " returned null");
    L15:
        r17 = "";
        goto L16
    L26:
        throw new AssertionError();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public b request() {
        return this.f8079c;
    }
}
