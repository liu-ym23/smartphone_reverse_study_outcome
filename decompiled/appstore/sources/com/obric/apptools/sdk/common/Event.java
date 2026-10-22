package com.obric.apptools.sdk.common;

import java.util.Map;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class Event {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f11128j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f11133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f11134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f11135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f11136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f11137i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f11128j = new a(null);
    }

    public Event(String r10, String r11, String r12) {
        q.g(r10, "action");
        q.g(r11, "scene");
        q.g(r12, "appPackage");
        this.f11129a = r10;
        this.f11130b = r11;
        this.f11131c = r12;
        this.f11132d = r12 + '_' + r11 + '_' + r10;
        this.f11133e = b.b(Event$categoryParams$2.INSTANCE);
        this.f11134f = b.b(Event$metricsParams$2.INSTANCE);
        this.f11135g = b.b(Event$extraParams$2.INSTANCE);
    }

    public final String a() {
        return this.f11129a;
    }

    public final String b() {
        return this.f11131c;
    }

    public final Map c() {
        return (Map) this.f11133e.getValue();
    }

    public final long d() {
        return this.f11137i;
    }

    public final String e() {
        return this.f11132d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Event) == true) goto L8;
        return false;
    L8:
        Event r11 = (Event) r10;
        if (q.b(this.f11129a, r11.f11129a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f11130b, r11.f11130b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f11131c, r11.f11131c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Map f() {
        return (Map) this.f11135g.getValue();
    }

    public final Map g() {
        return (Map) this.f11134f.getValue();
    }

    public final String h() {
        return this.f11130b;
    }

    public int hashCode() {
        return (((this.f11129a.hashCode() * 31) + this.f11130b.hashCode()) * 31) + this.f11131c.hashCode();
    }

    public final long i() {
        return this.f11136h;
    }

    public final void j(long r10) {
        this.f11137i = r10;
    }

    public final void k(long r10) {
        this.f11136h = r10;
    }

    public String toString() {
        return "Event(action=" + this.f11129a + ", scene=" + this.f11130b + ", appPackage=" + this.f11131c + ')';
    }
}
