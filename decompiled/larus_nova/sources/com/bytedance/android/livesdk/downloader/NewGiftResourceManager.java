package com.bytedance.android.livesdk.downloader;

import com.bytedance.android.live.revenue.common.h;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.f;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class NewGiftResourceManager implements e, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static NewGiftResourceManager f122286m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, f> f122287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d f122288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b> f122289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> f122290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f122291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f122292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f122293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f122294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f122295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f122296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f122297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ed6.a<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> f122298l;

    public static final class a {
    }

    public static final class b implements Comparator<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r101) {
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r102 = r100;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r103 = r101;
            if (r102 == null) goto L17;
            if (r103 == null) goto L17;
            long r104 = r103.f129094d - r102.f129094d;
            if (r104 <= 0) goto L10;
            return 1;
        L10:
            if (r104 >= 0) goto L12;
        L11:
            return -1;
        L12:
            long r105 = r103.f129095e - r102.f129095e;
            if (r105 > 0) goto L11;
            if (r105 >= 0) goto L17;
            return 1;
        L17:
            return 0;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGiftResourceManager f122299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e f122300b;

        public c(NewGiftResourceManager r100, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r101) {
            this.f122299a = r100;
            this.f122300b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            NewGiftResourceManager r102 = this.f122299a;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r103 = this.f122300b;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "request");
            long r104 = r103.f129099i;
            String r105 = r102.o(r103);
            f r106 = r102.f122287a.get(Long.valueOf(r104));
            if (r106 == null) goto L8;
            Iterator<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c> r107 = r106.b().iterator();
        L6:
            if (r107.hasNext() == false) goto L8;
            r107.next().c(r103.f129099i, r105);
        L8:
            r102.f122287a.remove(Long.valueOf(r104));
            Iterator r108 = ((ArrayList) r102.f122289c).iterator();
        L10:
            if (r108.hasNext() == false) goto L12;
            ((com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b) r108.next()).c(r103.f129099i, r103);
            goto L10
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f122301a;

        public d(Function0 r100) {
            this.f122301a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f122301a.invoke();
        }
    }

    static {
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void j() {
        this.f122297k = false;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void k() {
        this.f122297k = true;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a a() {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r100 = this.f122288b;
        Intrinsics.checkNotNull(r100);
        return r100.f252397a;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void clear() {
        this.f122287a.clear();
    }

    public final void p() {
    L3:
        if (this.f122298l.f472215a.peek() == null) goto L15;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100 = this.f122298l.f472215a.poll();
        if (r100 == null) goto L3;
        f r101 = this.f122287a.get(Long.valueOf(r100.f129099i));
        if (r101 == null) goto L3;
        Iterator<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c> r102 = r101.b().iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        r102.next().a(r100.f129099i);
        goto L12
    L14:
        this.f122287a.remove(Long.valueOf(r100.f129099i));
        goto L3
    }

    public final void q() {
        if (this.f122298l.f472215a.isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = this.f122293g;
        if (r100 >= 1) goto L13;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r101 = this.f122288b;
        Intrinsics.checkNotNull(r101);
        r100 = r101.f252401e;
        if (r100 > 0) goto L13;
        r100 = 3;
    L13:
        if (this.f122291e >= r100) goto L15;
    L28:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r102 = this.f122288b;
        Intrinsics.checkNotNull(r102);
        if (r102.f252402f <= 0) goto L34;
        int r103 = this.f122292f;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r104 = this.f122288b;
        Intrinsics.checkNotNull(r104);
        if (r103 < r104.f252402f) goto L34;
        p();
        this.f122292f = 0;
        return;
    L34:
        int r105 = this.f122296j;
        if (r105 > 0) goto L37;
    L39:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r106 = this.f122298l.f472215a.poll();
        if (r106 != null) goto L46;
        if (this.f122298l.f472215a.isEmpty() == true) goto L57;
        q();
        return;
    L57:
        return;
    L46:
        if (this.f122297k == true) goto L48;
    L51:
        com.bytedance.live.kmp.util.c r107 = com.bytedance.live.kmp.util.c.f255167a;
        r106.f129096f = System.currentTimeMillis();
        if (e(r106) == false) goto L54;
        l r108 = l.f267516a;
        Observable r109 = Observable.just(Unit.INSTANCE);
        int r110 = p.f267522a;
        r109.observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r106));
        q();
        return;
    L54:
        this.f122291e++;
        n(r106);
        return;
    L48:
        if (r106.f129094d != 1) goto L51;
        s(new NewGiftResourceManager$onCancel$1(this, r106), null);
        q();
        return;
    L37:
        if (this.f122291e < r105) goto L39;
        return;
    L15:
        if (this.f122296j <= 0) goto L27;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r111 = this.f122298l.f472215a.peek();
        if (r111 != null) goto L19;
    L25:
        boolean r112 = false;
    L26:
        if (r112 == true) goto L28;
        return;
    L19:
        if (r111.f129091a != true) goto L25;
        int r113 = this.f122296j;
        if (r113 <= 0) goto L25;
        if (this.f122291e >= (r100 + r113)) goto L25;
        r112 = true;
        goto L26
    }

    public final void r() {
        this.f122290d.iterator();
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r100 = this.f122288b;
        Intrinsics.checkNotNull(r100);
        if (r100.f252403g == false) goto L7;
        p();
        return;
    L7:
        if (this.f122290d.firstOrNull() == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r101 = this.f122290d.removeFirstOrNull();
        if (r101 == null) goto L7;
        f r102 = this.f122287a.get(Long.valueOf(r101.f129099i));
        if (r102 == null) goto L7;
        Iterator<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c> r103 = r102.b().iterator();
    L16:
        if (r103.hasNext() == false) goto L18;
        r103.next().a(r101.f129099i);
        goto L16
    L18:
        this.f122287a.remove(Long.valueOf(r101.f129099i));
        goto L7
    }

    public final void t() {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r100 = this.f122288b;
        Intrinsics.checkNotNull(r100);
        if (r100.f252403g == false) goto L6;
        q();
        return;
    L6:
        int r101 = this.f122291e;
        int r102 = this.f122293g;
        if (r102 >= 1) goto L13;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r103 = this.f122288b;
        Intrinsics.checkNotNull(r103);
        r102 = r103.f252401e;
        if (r102 > 0) goto L13;
        r102 = 3;
    L13:
        if (r101 < r102) goto L15;
        return;
    L15:
        if (this.f122290d.isEmpty() == true) goto L47;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r104 = this.f122288b;
        Intrinsics.checkNotNull(r104);
        if (r104.f252402f <= 0) goto L23;
        int r105 = this.f122292f;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r106 = this.f122288b;
        Intrinsics.checkNotNull(r106);
        if (r105 < r106.f252402f) goto L23;
        r();
        this.f122292f = 0;
        return;
    L23:
        int r107 = this.f122296j;
        if (r107 > 0) goto L26;
    L28:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r108 = this.f122290d.removeFirstOrNull();
        if (r108 != null) goto L35;
        if (this.f122290d.isEmpty() == true) goto L35;
        t();
        return;
    L35:
        if (this.f122297k == false) goto L40;
        Intrinsics.checkNotNull(r108);
        if (r108.f129091a == true) goto L40;
        s(new NewGiftResourceManager$onCancel$1(this, r108), null);
        t();
        return;
    L40:
        Intrinsics.checkNotNull(r108);
        com.bytedance.live.kmp.util.c r109 = com.bytedance.live.kmp.util.c.f255167a;
        r108.f129096f = System.currentTimeMillis();
        if (e(r108) == false) goto L43;
        t();
        return;
    L43:
        this.f122291e++;
        n(r108);
        return;
    L26:
        if (this.f122291e < r107) goto L28;
        return;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void f() {
        clear();
        r();
    }

    public NewGiftResourceManager(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r100) {
        this.f122287a = new LinkedHashMap();
        this.f122289c = new ArrayList();
        this.f122290d = new ArrayDeque();
        this.f122294h = LazyKt.lazy(NewGiftResourceManager$downloaderManagerTypeOpt$2.INSTANCE);
        this.f122295i = LazyKt.lazy(NewGiftResourceManager$resManagerAnrOpt$2.INSTANCE);
        this.f122298l = new ed6.a(new b());
        this.f122288b = r100;
        Intrinsics.checkNotNull(r100);
        if (r100.f252403g == false) goto L6;
        this.f122287a = new ConcurrentHashMap();
        return;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void d(int r100) {
        this.f122293g = r100;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final boolean e(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.a() != 1) goto L9;
        return true;
    L9:
        if (r100.a() != 2) goto L11;
        return false;
    L11:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r101 = this.f122288b;
        Intrinsics.checkNotNull(r101);
        String r102 = uy0.a.a(r101.f252397a.b(r100));
        return ((uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class)).Y4(r102 + ".fetched");
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void g(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.f122289c).contains(r100) == true) goto L8;
        ((ArrayList) this.f122289c).add(r100);
        return;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void i(int r100) {
        this.f122296j = r100;
    }

    public final void n(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100) {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r101 = this.f122288b;
        if (r101 != null) goto L5;
        return;
    L5:
        fd6.b<String> r102 = null;
        if (r101 == null) goto L10;
        fd6.a<String> r103 = r101.f252398b;
        if (r103 == null) goto L10;
        Intrinsics.checkNotNull(r101);
        fd6.b<String> r104 = r103.a(r100, r101);
    L12:
        if ((r104 instanceof fd6.b) == false) goto L15;
        r102 = r104;
    L15:
        if (r102 != null) goto L17;
        return;
    L17:
        r100.f129097g = true;
        r102.a(r100, this);
        return;
    L10:
        r104 = null;
        goto L12
    }

    public final String o(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r101 = this.f122288b;
        Intrinsics.checkNotNull(r101);
        String r102 = uy0.a.a(r101.f252397a.b(r100));
        if (r100.f129103m == true) goto L11;
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L6
        r103.append(r102);     // Catch: Exception -> L6
        int r104 = h.f90835a;     // Catch: Exception -> L6
        r103.append(h.a(r100.f129100j[0]));     // Catch: Exception -> L6
        return r103.toString();
    L6:
        e = move-exception;
        e.printStackTrace();
        return r102;
    L11:
        return r102;
    }

    public static final void m(final NewGiftResourceManager r100, final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r101) {
        r100.getClass();
        Function0<Unit> r102 = new NewGiftResourceManager$retryFetchResource$1(r100, r101);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r103 = r100.f122288b;
        Intrinsics.checkNotNull(r103);
        r100.s(r102, Long.valueOf(r103.f252400d * 1000));
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a
    public final void b(final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "s");
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r102 = this.f122288b;
        Intrinsics.checkNotNull(r102);
        String r103 = uy0.a.a(r102.f252397a.b(r100));
        ((uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class)).L(r103 + ".fetched");
        s(new NewGiftResourceManager$onResult$1(this, r100), null);
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void c(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c r101) {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r102 = this.f122288b;
        Intrinsics.checkNotNull(r102);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r103 = null;
        if (r102.f252403g == false) goto L28;
        if (this.f122297k == false) goto L10;
        if (r100.f129094d != 1) goto L10;
        r101.a(r100.f129099i);
        return;
    L10:
        if (e(r100) == false) goto L12;
        r101.c(r100.f129099i, o(r100));
        return;
    L12:
        long r104 = r100.f129099i;
        if (this.f122287a.containsKey(Long.valueOf(r104)) == false) goto L25;
        f r105 = this.f122287a.get(Long.valueOf(r104));
        if (r105 == null) goto L17;
        r103 = r105.f252412b;
    L17:
        if (r103 != null) goto L19;
        return;
    L19:
        if (r103.f129094d >= r100.f129094d) goto L24;
        r100.c();
        this.f122298l.f472215a.remove(r103);
        this.f122298l.f472215a.add(r100);
        f r106 = new f(r100);
        Intrinsics.checkNotNull(r105);
        List<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c> r107 = r105.b();
        Intrinsics.checkNotNullParameter(r107, "list");
        List<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c> r108 = r107;
        if ((!r108.isEmpty()) == false) goto L23;
        ((CopyOnWriteArrayList) r106.f252411a).addAll(r108);
    L23:
        r106.a(r101);
        this.f122287a.remove(Long.valueOf(r104));
        this.f122287a.put(Long.valueOf(r104), r106);
        return;
    L24:
        r103.c();
        Intrinsics.checkNotNull(r105);
        r105.a(r101);
        return;
    L25:
        f r109 = new f(r100);
        r109.a(r101);
        this.f122287a.put(Long.valueOf(r104), r109);
        r100.c();
        this.f122298l.f472215a.add(r100);
        q();
        return;
    L28:
        if (this.f122297k == false) goto L34;
        if (r100.f129091a == true) goto L34;
        r101.a(r100.f129099i);
        return;
    L34:
        if (e(r100) == false) goto L37;
        r101.c(r100.f129099i, o(r100));
        return;
    L37:
        long r110 = r100.f129099i;
        if (this.f122297k == false) goto L49;
        if (this.f122287a.containsKey(Long.valueOf(r110)) == false) goto L49;
        if (r100.f129091a == false) goto L49;
        f r111 = this.f122287a.get(Long.valueOf(r110));
        Intrinsics.checkNotNull(r111);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r112 = r111.f252412b;
        if (r112 == null) goto L49;
        if (r112.f129091a == true) goto L49;
        this.f122287a.remove(Long.valueOf(r110));
    L49:
        if (this.f122287a.containsKey(Long.valueOf(r110)) == true) goto L51;
        f r113 = new f(r100);
        r113.a(r101);
        this.f122287a.put(Long.valueOf(r110), r113);
        r100.c();
        if (r100.f129091a == false) goto L66;
        this.f122290d.addFirst(r100);
    L67:
        t();
        return;
    L66:
        this.f122290d.add(r100);
        goto L67
    L51:
        if (r100.f129091a == false) goto L60;
        f r114 = this.f122287a.get(Long.valueOf(r110));
        if (r114 == null) goto L55;
        r103 = r114.f252412b;
    L55:
        if (r103 != null) goto L57;
    L59:
        r100.c();
        this.f122290d.addFirst(r100);
        goto L60
    L57:
        if (this.f122290d.contains(r103) == false) goto L59;
        this.f122290d.remove(r103);
    L60:
        f r115 = this.f122287a.get(Long.valueOf(r110));
        if (r115 == null) goto L74;
        r115.a(r101);
        return;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final String h(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, boolean r101) {
        if (e(r100) == true) goto L5;
        if (r101 == false) goto L12;
        long r102 = r100.f129099i;
        if (this.f122287a.containsKey(Long.valueOf(r102)) == true) goto L13;
        f r103 = new f(r100);
        this.f122287a.put(Long.valueOf(r102), r103);
        r100.c();
        n(r100);
        return null;
    L13:
        return null;
    L12:
        return null;
    L5:
        return o(r100);
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a
    public final void l(final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, final BaseGetResourceException r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "e");
        if (e(r100) == true) goto L5;
        s(new NewGiftResourceManager$onFailure$2(this, r100, r101), null);
        return;
    L5:
        if (((Boolean) this.f122295i.getValue()).booleanValue() == false) goto L8;
        s(new NewGiftResourceManager$onFailure$1(this), null);
        return;
    L8:
        this.f122291e--;
        t();
    }

    public final void s(Function0<Unit> r100, Long r101) {
        if (r101 != null) goto L4;
    L6:
        l r102 = l.f267516a;
        Observable<Long> r103 = Observable.just(Unit.INSTANCE);
    L7:
        int r104 = p.f267522a;
        r103.observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r100));
        return;
    L4:
        if (r101.longValue() <= 0) goto L6;
        l r105 = l.f267516a;
        long r106 = r101.longValue();
        int r107 = p.f267522a;
        Scheduler r108 = Schedulers.computation();
        r103 = Observable.timer(r106, TimeUnit.MILLISECONDS, r108);
        goto L7
    }
}
