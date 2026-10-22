package vd;

import java.util.Queue;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements ud.a {

    /* renamed from: a, reason: collision with root package name */
    public Object f13522a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13523b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13524c;

    @Override // ud.a
    public void a(String str) {
        f(new Object[]{str});
    }

    @Override // ud.a
    public void b(String str, String str2, Object obj) {
        f(new Object[]{str2, obj});
    }

    @Override // ud.a
    public void c(Integer num, Long l10) {
        f(new Object[]{num, l10});
    }

    @Override // ud.a
    public void d(String str) {
        f(new Object[]{str});
    }

    @Override // ud.a
    public void e(Integer num, Integer num2) {
        f(new Object[]{num, num2});
    }

    public void f(Object[] objArr) {
        c cVar = new c();
        System.currentTimeMillis();
        cVar.f13525a = (wd.a) this.f13523b;
        cVar.f13526b = objArr;
        Thread.currentThread().getName();
        ((Queue) this.f13524c).add(cVar);
    }

    @Override // ud.a
    public String getName() {
        return (String) this.f13522a;
    }
}
