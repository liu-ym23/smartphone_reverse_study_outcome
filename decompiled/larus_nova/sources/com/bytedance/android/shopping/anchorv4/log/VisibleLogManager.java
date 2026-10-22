package com.bytedance.android.shopping.anchorv4.log;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.anchorv3.q;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes12.dex */
public final class VisibleLogManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f167050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f167051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f167052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f167053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f167054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f167055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AnchorV4VM f167056g;

    public static final class a extends q {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ VisibleLogManager f167057e;

        @Override // com.bytedance.android.ec.core.anchorv3.q
        public final void c() {
            VisibleLogManager r100 = this.f167057e;
            if (r100.f167055f == false) goto L6;
            r100.d();
            return;
        }

        public a(VisibleLogManager r100) {
            this.f167057e = r100;
            super(3);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VisibleLogManager f167058a;

        public b(VisibleLogManager r100) {
            this.f167058a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            VisibleLogManager.a(this.f167058a);
        }
    }

    public final void c() {
        this.f167055f = true;
        if (PdpPerfOpt.d() == true) goto L5;
    L7:
        d();
        return;
    L5:
        if (this.f167056g.getPdpTaskManager().f43779a == true) goto L7;
        this.f167056g.getPdpTaskManager().i(new a(this), false);
    }

    public final void d() {
        int r100 = com.bytedance.android.ec.hybrid.card.service.a.f46582a;
        int r101 = bk.a.f19281a;
        long r102 = RangesKt.coerceAtLeast(-1, 500);
        this.f167054e = new CompositeDisposable();
        int r103 = ECSdk.f48106a;
        cj.b r104 = (cj.b) ECSdk.a(cj.b.class);
        if (r104 == null) goto L5;
        r104.d();
    L5:
        CompositeDisposable r105 = this.f167054e;
        if (r105 == null) goto L9;
        r105.add(com.bytedance.android.ec.core.rxjava.a.a(0, r102, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
        return;
    }

    public VisibleLogManager(AnchorV4VM r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        this.f167056g = r100;
        this.f167050a = LazyKt.lazy(VisibleLogManager$theHandler$2.INSTANCE);
        this.f167051b = new ArrayList();
        this.f167052c = LazyKt.lazy(VisibleLogManager$rect$2.INSTANCE);
        this.f167053d = -1;
    }

    public static final void a(VisibleLogManager r100) {
        ArrayList r101 = (ArrayList) r100.f167051b;
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((e) r102.next()).f167060a.onScan();
        goto L4
    L6:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (((e) r105).f167062c == true) goto L8;
        r103.add(r105);
        goto L8
    L12:
        Iterator r106 = r103.iterator();
    L14:
        if (r106.hasNext() == false) goto L31;
        e r107 = (e) r106.next();
        View r108 = r107.f167060a.t();
        if (r108 == null) goto L14;
        int r109 = r107.f167063d;
        int r110 = r107.f167060a.M0();
        r107.getIdentifier();
        r108.getGlobalVisibleRect((Rect) r100.f167052c.getValue());
        if (r109 == 0) goto L22;
        if (r109 != 1) goto L22;
        int r111 = ((Rect) r100.f167052c.getValue()).bottom;
    L23:
        int r112 = r100.f167053d - r110;
        if (1 > r111) goto L28;
        if (r112 <= r111) goto L28;
        boolean r113 = true;
    L29:
        if (r113 == false) goto L14;
        r107.f167062c = true;
        r107.f167060a.onVisible();
    L28:
        r113 = false;
    L22:
        r111 = ((Rect) r100.f167052c.getValue()).top;
        goto L23
    }

    public final void b(d r100, Object r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        ArrayList r103 = (ArrayList) this.f167051b;
        Iterator r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((e) r105).getIdentifier(), r101) == false) goto L4;
    L9:
        e r106 = (e) r105;
        if (r106 != null) goto L16;
        r106 = new e(r100, r101, r102);
        if (this.f167053d == (-1)) goto L15;
        ((Handler) this.f167050a.getValue()).post(new f(this));
    L15:
        Unit r107 = Unit.INSTANCE;
    L16:
        r103.add(r106);
        return;
    L8:
        r105 = null;
        goto L9
    }
}
