package wd;

import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.NOPLogger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements ud.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13680a;

    /* renamed from: b, reason: collision with root package name */
    public volatile ud.a f13681b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f13682c;

    /* renamed from: d, reason: collision with root package name */
    public Method f13683d;

    /* renamed from: e, reason: collision with root package name */
    public vd.a f13684e;
    public final Queue<vd.c> h;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f13685j;

    public a(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z) {
        this.f13680a = str;
        this.h = linkedBlockingQueue;
        this.f13685j = z;
    }

    @Override // ud.a
    public final void a(String str) {
        f().a(str);
    }

    @Override // ud.a
    public final void b(String str, String str2, Object obj) {
        f().b(str, str2, obj);
    }

    @Override // ud.a
    public final void c(Integer num, Long l10) {
        f().c(num, l10);
    }

    @Override // ud.a
    public final void d(String str) {
        f().d(str);
    }

    @Override // ud.a
    public final void e(Integer num, Integer num2) {
        f().e(num, num2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && a.class == obj.getClass() && this.f13680a.equals(((a) obj).f13680a);
    }

    public final ud.a f() {
        if (this.f13681b != null) {
            return this.f13681b;
        }
        if (this.f13685j) {
            return NOPLogger.f11340a;
        }
        if (this.f13684e == null) {
            Queue<vd.c> queue = this.h;
            vd.a aVar = new vd.a();
            aVar.f13523b = this;
            aVar.f13522a = this.f13680a;
            aVar.f13524c = queue;
            this.f13684e = aVar;
        }
        return this.f13684e;
    }

    public final boolean g() {
        Boolean bool = this.f13682c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f13683d = this.f13681b.getClass().getMethod("log", vd.b.class);
            this.f13682c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f13682c = Boolean.FALSE;
        }
        return this.f13682c.booleanValue();
    }

    @Override // ud.a
    public final String getName() {
        return this.f13680a;
    }

    public final int hashCode() {
        return this.f13680a.hashCode();
    }
}
