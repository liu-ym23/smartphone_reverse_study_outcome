package com.bytedance.android.harmony.channel;

import com.bytedance.android.harmony.Severity;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<T, R, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, a<T, R, E>.C0922a> f58166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f58167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f58168d;

    /* JADX INFO: renamed from: com.bytedance.android.harmony.channel.a$a, reason: collision with other inner class name */
    public class C0922a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f58170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f58171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayDeque<c<T, E>> f58172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f58173e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<a<T, R, E>.C0922a, Unit> f58174f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f58175g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f58176h;

        public final void a() {
            if (this.f58170b == true) goto L5;
        L7:
            boolean r100 = false;
        L8:
            if (r100 == false) goto L10;
            return;
        L10:
            String r101 = this.f58169a;
            com.bytedance.android.harmony.b.f58161a.getClass();
            com.bytedance.android.harmony.d r102 = com.bytedance.android.harmony.b.a.f58162a;
            Severity r103 = Severity.DEBUG;
            r102.getClass();
            r102.a(r103, r101, "close: channel = " + this);
            this.f58172d.addLast(new c.a(this.f58173e, true, true));
            if (this.f58172d.isEmpty() == true) goto L14;
            List<? extends c<? extends T, ? extends E>> r104 = CollectionsKt.toList(this.f58172d);
            this.f58172d.clear();
            this.f58176h.b(r104);
            String r105 = this.f58169a;
            r102.getClass();
            r102.a(r103, r105, "write buffer flushed, channel = " + this);
        L14:
            c();
            d();
            return;
        L5:
            if (this.f58171c == false) goto L7;
            r100 = true;
            goto L8
        }

        public final void c() {
            if (this.f58170b == true) goto L6;
            String r100 = this.f58169a;
            com.bytedance.android.harmony.b.f58161a.getClass();
            com.bytedance.android.harmony.d r101 = com.bytedance.android.harmony.b.a.f58162a;
            Severity r102 = Severity.DEBUG;
            r101.getClass();
            r101.a(r102, r100, "local read closed, channel = " + this.f58173e + ", channel = " + this);
            this.f58170b = true;
            b(this, true, false, 2);
            return;
        }

        public final void d() {
            if (this.f58171c == true) goto L6;
            String r100 = this.f58169a;
            com.bytedance.android.harmony.b.f58161a.getClass();
            com.bytedance.android.harmony.d r101 = com.bytedance.android.harmony.b.a.f58162a;
            Severity r102 = Severity.DEBUG;
            r101.getClass();
            r101.a(r102, r100, "local write closed, channel = " + this);
            this.f58171c = true;
            this.f58172d.clear();
            b(this, false, true, 1);
            return;
        }

        public final String toString() {
            return "Channel(id = " + this.f58173e + ", tag = " + this.f58175g.f58192a + ", readClosed = " + this.f58170b + ", writeClosed = " + this.f58171c + ')';
        }

        public final void e(String r100) {
            if (this.f58171c == false) goto L5;
            return;
        L5:
            c.d.b r101 = new c.d.b(this.f58173e, new com.bytedance.android.harmony.channel.b("rpc_internal_error", r100, null));
            this.f58172d.addLast(r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0922a(a r100, String r101, Function1<? super a<T, R, E>.C0922a, Unit> r102) {
            this.f58176h = r100;
            this.f58175g = new d();
            this.f58173e = r101;
            this.f58174f = r102;
            this.f58169a = "AbstractChannelImpl";
            this.f58172d = new ArrayDeque();
        }

        public static void b(C0922a r100, boolean r101, boolean r102, int r103) {
            boolean r104 = false;
            if ((r103 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = false;
        L8:
            if (r101 == false) goto L10;
            r100.getClass();
        L10:
            if (r102 == false) goto L13;
            r100.getClass();
        L13:
            if (r100.f58170b == true) goto L15;
        L17:
            if (r104 == false) goto L20;
            r100.f58174f.invoke(r100);
            return;
        L20:
            return;
        L15:
            if (r100.f58171c == false) goto L17;
            r104 = true;
            goto L17
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f58177a = null;

        public b() {
        }

        static {
            f58177a = new b();
        }
    }

    public abstract void b(List<? extends c<? extends T, ? extends E>> r100);

    public a() {
        this.f58168d = new d();
        this.f58165a = "AbstractChannelClient";
        this.f58166b = new HashMap();
        this.f58167c = b.f58177a;
    }

    public final void a(List<? extends c<? extends R, ? extends E>> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L50;
        c r102 = (c) r101.next();
        if ((r102 instanceof c.b) == true) goto L7;
        if ((r102 instanceof c.d.a) == true) goto L23;
        if ((r102 instanceof c.d.b) == true) goto L31;
        if ((r102 instanceof c.a) == true) goto L39;
        if ((r102 instanceof c.C0923c) == false) goto L4;
        c.C0923c r103 = (c.C0923c) r102;
        goto L4
    L39:
        c.a r104 = (c.a) r102;
        a<T, R, E>.C0922a r105 = this.f58166b.get(r104.f58181a);
        if (r105 == null) goto L4;
        if (r104.f58182b == false) goto L45;
        String r106 = this.f58165a;
        com.bytedance.android.harmony.b.f58161a.getClass();
        com.bytedance.android.harmony.d r107 = com.bytedance.android.harmony.b.a.f58162a;
        Severity r108 = Severity.DEBUG;
        r107.getClass();
        r107.a(r108, r106, "remote read closed, channel = " + r105);
        r105.d();
    L45:
        if (r104.f58183c == false) goto L4;
        String r109 = this.f58165a;
        com.bytedance.android.harmony.b.f58161a.getClass();
        com.bytedance.android.harmony.d r110 = com.bytedance.android.harmony.b.a.f58162a;
        Severity r111 = Severity.DEBUG;
        r110.getClass();
        r110.a(r111, r109, "remote write closed, channel = " + r105);
        r105.c();
        goto L4
    L31:
        c.d.b r112 = (c.d.b) r102;
        a<T, R, E>.C0922a r113 = this.f58166b.get(r112.f58190a);
        if (r113 == null) goto L4;
        String r114 = r112.f58191b.f58178a;
        if (r113.f58170b == true) goto L4;
        String r115 = r113.f58169a;
        com.bytedance.android.harmony.b.f58161a.getClass();
        com.bytedance.android.harmony.d r116 = com.bytedance.android.harmony.b.a.f58162a;
        Severity r117 = Severity.ERROR;
        r116.getClass();
        r116.a(r117, r115, "reader missed an error, channel = " + r113);
        r113.e("reader is not set");
        r113.a();
        goto L4
    L23:
        a<T, R, E>.C0922a r118 = this.f58166b.get(((c.d.a) r102).f58188a);
        if (r118 == null) goto L4;
        if (r118.f58170b == true) goto L4;
        String r119 = r118.f58169a;
        com.bytedance.android.harmony.b.f58161a.getClass();
        com.bytedance.android.harmony.d r120 = com.bytedance.android.harmony.b.a.f58162a;
        Severity r121 = Severity.ERROR;
        r120.getClass();
        r120.a(r121, r119, "reader missed data, channel = " + r118);
        r118.e("reader is not set");
        r118.a();
        goto L4
    L7:
        c.b r122 = (c.b) r102;
        if (r122.f58184a.length() != 0) goto L10;
        boolean r123 = true;
    L11:
        if (r123 == true) goto L4;
        if (this.f58166b.containsKey(r122.f58184a) == true) goto L4;
        a<T, R, E>.C0922a r124 = new C0922a(this, r122.f58184a, new AbstractChannelClient$createChannel$channel$1(this));
        Iterator<T> r125 = this.f58168d.f58192a.iterator();
    L18:
        if (r125.hasNext() == false) goto L20;
        r124.f58175g.f58192a.add(r125.next());
        goto L18
    L20:
        this.f58166b.put(r122.f58184a, r124);
        String r126 = this.f58165a;
        com.bytedance.android.harmony.b.f58161a.getClass();
        com.bytedance.android.harmony.d r127 = com.bytedance.android.harmony.b.a.f58162a;
        Severity r128 = Severity.DEBUG;
        r127.getClass();
        r127.a(r128, r126, "remote connected, channel = " + r124);
        this.f58167c.getClass();
        r124.e("connectionHandler is not set");
        r124.a();
        goto L4
    L10:
        r123 = false;
        goto L11
    }
}
