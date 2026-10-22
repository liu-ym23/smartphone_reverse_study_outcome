package com.bytedance.android.livesdk.gamesticker.t01;

import com.bytedance.android.livesdk.chatroom.model.p3;
import com.bytedance.android.livesdk.chatroom.model.q3;
import com.bytedance.android.livesdk.chatroom.model.r3;
import com.bytedance.android.livesdk.chatroom.model.t0;
import com.bytedance.android.livesdk.chatroom.model.t3;
import com.bytedance.android.livesdk.gamesticker.t01.anim.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class T01GameViewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t3 f125735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<r3> f125736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f125737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f125738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p3 f125739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f125740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f125741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f125742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f125743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f125744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final T01GameStickerView f125745k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f125746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f125747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f125748c;

        public a(long r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "action");
            this.f125747b = r100;
            this.f125748c = r101;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T01GameViewController f125749a;

        public b(T01GameViewController r100) {
            this.f125749a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f125749a.getClass();
            this.f125749a.f125745k.h(true);
        }
    }

    public final void a() {
        p3 r100 = this.f125739e;
        if (r100 == null) goto L5;
        int r101 = r100.b();
    L7:
        if (r101 <= 0) goto L12;
        this.f125740f = 8;
        Disposable r102 = Observable.timer(r101, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        if (r102 == null) goto L13;
        this.f125741g = r102;
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r101 = 0;
        goto L7
    }

    public T01GameViewController(T01GameStickerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f125745k = r100;
        this.f125737c = -1;
        this.f125742h = -1;
        this.f125743i = -1;
    }

    public final void b(t0 r210) {
        Intrinsics.checkNotNullParameter(r210, "info");
        q3 r100 = r210.a();
        if (r100 == null) goto L116;
        int r101 = r100.b();
        q3 r102 = r210.a();
        if (r102 == null) goto L7;
        t3 r103 = r102.d();
    L9:
        if (r103 == null) goto L19;
        String r104 = r103.b();
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L19;
    L20:
        if (r103 != null) goto L22;
        return;
    L22:
        q3 r106 = r210.a();
        if (r106 == null) goto L25;
        List<r3> r107 = r106.c();
    L26:
        if (r107 != null) goto L28;
        List<r3> r108 = null;
    L29:
        if (r108 != null) goto L31;
        return;
    L31:
        int r109 = r108.size();
        List<r3> r110 = this.f125736b;
        if (r110 != null) goto L34;
    L37:
        boolean r111 = true;
    L38:
        this.f125735a = r103;
        this.f125736b = r108;
        int r112 = this.f125737c;
        if (r112 == (-1)) goto L44;
        if (r112 != r101) goto L44;
        if (r111 == true) goto L44;
        this.f125737c = r101;
        T01GameStickerView r113 = this.f125745k;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r103, "roleInfo");
        Intrinsics.checkNotNullParameter(r108, "liveInfos");
        r113.f125732j.a(new h(r103, r108));
        r113.g();
    L76:
        q3 r114 = r210.a();
        if (r114 == null) goto L88;
        List<p3> r115 = r114.a();
        if (r115 == null) goto L88;
        Iterator<T> r116 = r115.iterator();
    L82:
        if (r116.hasNext() == false) goto L86;
        Object r117 = r116.next();
        if (Intrinsics.areEqual(((p3) r117).c(), "portrait") == false) goto L82;
    L87:
        p3 r118 = (p3) r117;
    L89:
        this.f125739e = r118;
        if (r118 == null) goto L92;
        int r119 = r118.a();
    L93:
        int r120 = this.f125742h;
        if (r120 == (-1)) goto L102;
        if (r120 == r119) goto L102;
        if (this.f125743i != 0) goto L102;
        Disposable r121 = this.f125741g;
        if (r121 == null) goto L101;
        r121.dispose();
    L101:
        this.f125741g = null;
        this.f125745k.k(true);
        a();
    L102:
        this.f125742h = r119;
        return;
    L92:
        r119 = -1;
        goto L93
    L86:
        r117 = null;
    L88:
        r118 = null;
    L44:
        this.f125737c = r101;
        Disposable r122 = this.f125738d;
        if (r122 == null) goto L47;
        r122.dispose();
    L47:
        List<a> r123 = c(r108);
        if (((ArrayList) r123).size() != 1) goto L50;
        ((a) ListProtector.get(r123, 0)).f125748c.invoke();
        goto L76
    L50:
        List<a> r124 = c(r108);
        ArrayList r125 = (ArrayList) r124;
        Iterator r126 = r125.iterator();
        long r127 = 0;
    L52:
        if (r126.hasNext() == false) goto L54;
        r127 = r127 + ((a) r126.next()).f125747b;
        goto L52
    L54:
        long r128 = 1 + r127;
        ArrayList r129 = new ArrayList();
        int r130 = r125.size();
        int r131 = 0;
    L55:
        if (r131 >= r130) goto L60;
        if (r131 != 0) goto L58;
        ListProtector.add(r129, r131, 0L);
    L59:
        ((a) ListProtector.get(r124, r131)).f125746a = ((Number) ListProtector.get(r129, r131)).longValue();
        Long r132 = (Long) ListProtector.get(r129, r131);
        r131 = r131 + 1;
        r130 = r130;
        goto L55
    L58:
        int r133 = r131 - 1;
        ListProtector.add(r129, r131, Long.valueOf(((a) ListProtector.get(r124, r133)).f125747b + ((Number) ListProtector.get(r129, r133)).longValue()));
        goto L59
    L60:
        this.f125744j = true;
        Iterator r134 = r125.iterator();
    L62:
        if (r134.hasNext() == false) goto L69;
        Object r135 = r134.next();
        if (((a) r135).f125746a != 0) goto L66;
        boolean r136 = true;
    L67:
        if (r136 == false) goto L62;
    L70:
        a r137 = (a) r135;
        if (r137 == null) goto L75;
        Function0<Unit> r138 = r137.f125748c;
        if (r138 == null) goto L75;
        Unit r139 = r138.invoke();
    L75:
        this.f125738d = Observable.intervalRange(0, r128, 0, 1, TimeUnit.SECONDS).repeat().filter(new com.bytedance.android.livesdk.gamesticker.t01.b(r129)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r124));
        goto L76
    L66:
        r136 = false;
        goto L67
    L69:
        r135 = null;
        goto L70
    L34:
        if (r109 != r110.size()) goto L37;
        r111 = false;
        goto L38
    L28:
        r108 = CollectionsKt.sortedWith(r107, new com.bytedance.android.livesdk.gamesticker.t01.a());
        goto L29
    L25:
        r107 = null;
        goto L26
    L14:
        if (r104.length() == 0) goto L17;
        r105 = false;
    L19:
        r103 = null;
        goto L20
    L7:
        r103 = null;
        goto L9
    }

    public final List<a> c(List<r3> r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.size();
        final int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        Long r104 = ((r3) ListProtector.get(r100, r103)).b();
        if (r104 == null) goto L7;
        long r105 = r104.longValue();
    L8:
        r101.add(new a(r105, new T01GameViewController$transformInfoToTask$1(this, r103)));
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = 10;
        goto L8
    L9:
        return r101;
    }
}
