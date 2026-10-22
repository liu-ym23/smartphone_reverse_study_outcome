package com.bytedance.android.ec.hybrid.list.play;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.a0;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.hybrid.list.util.SortedListWithPosition;
import com.bytedance.android.ec.hybrid.list.util.p;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes44.dex */
public abstract class AbsECHybridAutoPlay implements i {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f47212s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f47213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f47214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f47215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f47216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f47217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseViewHolder f47218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<BaseViewHolder> f47219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<BaseViewHolder, CountDownTimer> f47220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.list.play.a f47221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f47222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f47223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SortedListWithPosition f47224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f47225m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f47226n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f47227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f47228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p f47229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function0<a0> f47230r;

    public static final class a {
    }

    static {
    }

    public abstract void o(BaseViewHolder r100, boolean r101, String r102);

    public final void v() {
        this.f47216d = false;
        this.f47217e = 0;
        this.f47218f = null;
        this.f47219g.clear();
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public void D() {
        this.f47229q.b(new AbsECHybridAutoPlay$stopVideo$1(this));
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void b() {
        this.f47224l.clear();
        a0 r100 = this.f47230r.invoke();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void j() {
        new Handler(Looper.getMainLooper()).post(new AbsECHybridAutoPlay$updateAutoPlayCard$1(this));
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void k() {
        final a0 r100 = this.f47230r.invoke();
        if (r100 == null) goto L6;
        new AbsECHybridAutoPlay$registerLiveStatusChecker$$inlined$let$lambda$1(r100, this);
        AbsECHybridAutoPlay$registerLiveStatusChecker$1$2 r101 = AbsECHybridAutoPlay$registerLiveStatusChecker$1$2.INSTANCE;
        r100.register();
        return;
    }

    public final void p() {
        com.bytedance.android.ec.hybrid.list.play.a r100 = this.f47221i;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f47221i = null;
        this.f47222j = false;
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void a() {
        v();
        x(new AbsECHybridAutoPlay$playVideo$1(this));
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void i() {
        D();
        Iterator<T> r100 = this.f47219g.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        w((BaseViewHolder) r100.next());
        goto L4
    L6:
        BaseViewHolder r101 = this.f47218f;
        if (r101 == null) goto L11;
        w(r101);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void m() {
        this.f47223k = 0.6d;
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f47226n = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final <T> boolean d(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        CopyOnWriteArrayList<BaseViewHolder> r101 = this.f47219g;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (r100.isInstance((BaseViewHolder) r102.next()) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return false;
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void e(final boolean r100) {
        this.f47213a.post(new AbsECHybridAutoPlay$onScrollToPosition$1(this, r100));
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        this.f47227o = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void h(boolean r100) {
        if (this.f47228p != r100) goto L5;
        return;
    L5:
        this.f47228p = r100;
        if (r100 == false) goto L9;
        D();
        v();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void n(boolean r100) {
        v();
        if (r100 == true) goto L6;
        x(new AbsECHybridAutoPlay$onFirstScreen$1(this));
        return;
    }

    public final b r(BaseViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Integer r101 = t(r100);
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        if (r102 > 0) goto L9;
        return null;
    L9:
        b r103 = new b(r100, 1000 * ((long) r102));
        r103.start();
        return r103;
    L5:
        r102 = 0;
        goto L6
    }

    public Integer t(BaseViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        ECHybridListItemVO r101 = r100.f47152c;
        if (r101 == null) goto L10;
        Integer r102 = r101.f47040n;
        if (r102 == null) goto L12;
        int r103 = r102.intValue();
        if (r103 > 0) goto L9;
        return null;
    L9:
        return Integer.valueOf(r103);
    L12:
        return null;
    L10:
        return null;
    }

    public final void u(BaseViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f47216d = true;
        this.f47217e++;
        this.f47218f = r100;
        this.f47219g.add(r100);
        ECHybridListItemVO r101 = r100.f47152c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.P != null) goto L9;
        r101.P = Long.valueOf(System.currentTimeMillis());
        return;
    }

    public final void w(BaseViewHolder r100) {
        ECHybridListItemVO r101 = r100.f47152c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f47038l == true) goto L7;
        return;
    L7:
        if (r100.f47150a != IHybridListViewHolder.ECCardPlayState.PLAYING) goto L14;
        v();
        r100.D();
        if (this.f47222j == false) goto L15;
        p();
        return;
    L15:
        return;
    }

    public void x(final Function1<? super BaseViewHolder, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        this.f47229q.b(new AbsECHybridAutoPlay$triggerCardPlay$1(r100));
    }

    public AbsECHybridAutoPlay(com.bytedance.android.ec.hybrid.list.view.c r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "rvAbility");
        Intrinsics.checkNotNullParameter(r101, "liveStatusCheckAbility");
        this.f47229q = r100;
        this.f47230r = r101;
        this.f47213a = new Handler(Looper.getMainLooper());
        ECHybridRecyclerView r102 = r100.f47430a;
        this.f47214b = r102;
        this.f47215c = LazyKt.lazy(AbsECHybridAutoPlay$liveStatusConfig$2.INSTANCE);
        this.f47219g = new CopyOnWriteArrayList();
        this.f47220h = new LinkedHashMap();
        this.f47223k = 0.8d;
        this.f47224l = new SortedListWithPosition();
        this.f47225m = -1;
        this.f47226n = "";
        this.f47227o = "";
        r102.addOnScrollListener(new AnonymousClass1(this));
        r102.addOnChildAttachStateChangeListener(new AnonymousClass2(this));
    }

    public static void q(AbsECHybridAutoPlay r100, BaseViewHolder r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        if (r100.f47221i != null) goto L14;
        Integer r102 = r100.t(r101);
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        if (r103 <= 0) goto L10;
        r100.f47221i = new com.bytedance.android.ec.hybrid.list.play.a(r100, r101, 1000 * ((long) r103));
    L10:
        com.bytedance.android.ec.hybrid.list.play.a r104 = r100.f47221i;
        if (r104 == null) goto L15;
        r104.start();
        r100.f47222j = true;
        return;
    L15:
        return;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // com.bytedance.android.ec.hybrid.list.play.i
    public final void l(boolean r100, boolean r101, final boolean r102) {
        if (r100 == false) goto L11;
        a0 r103 = this.f47230r.invoke();
        if (r103 == null) goto L6;
        r103.a();
    L6:
        v();
        x(new AbsECHybridAutoPlay$onPageVisible$1(this, r102));
        if (this.f47216d == true) goto L10;
        if (r101 == false) goto L10;
        x(new AbsECHybridAutoPlay$onPageVisible$2(this, r102));
    L10:
        this.f47225m = -1;
        this.f47227o = "";
        return;
    L11:
        D();
    }

    public static void s(AbsECHybridAutoPlay r100, BaseViewHolder r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        String r104 = "";
    L10:
        if (r100.f47228p == true) goto L14;
        r100.o(r101, r102, r104);
        return;
    L14:
        return;
    L8:
        r104 = null;
        goto L10
    }
}
