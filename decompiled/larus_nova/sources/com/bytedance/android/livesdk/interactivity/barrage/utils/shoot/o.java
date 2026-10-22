package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitedSizeHashMap;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import com.bytedance.common.utility.Logger;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o extends r22.a<q22.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<q22.a> f134001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<String, q22.a> f134002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Observable<Long> f134003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f134004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LimitedSizeHashMap<String, Disposable> f134005g;

    public static final class a {
    }

    static {
    }

    @Override // r22.a
    public final q22.a j() {
        return (q22.a) ((LinkedList) this.f134001c).pollFirst();
    }

    @Override // r22.a
    public final Queue<q22.a> h() {
        return this.f134001c;
    }

    public o(LandscapeDanmakuPresenterV2.f r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
        super(r100);
        this.f134001c = new LinkedList();
        this.f134002d = new LinkedHashMap();
        this.f134003e = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        this.f134005g = new LimitedSizeHashMap(100);
    }

    @Override // r22.a
    public final void e(q22.a r100) {
        q22.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "danmaku");
        Logger.d("GiftDanmakuShooter", "Filling: " + r101.f531396c);
        if (r101.f531398e == false) goto L25;
        Disposable r102 = this.f134004f;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        if ((!this.f134002d.isEmpty()) == false) goto L21;
        if (this.f134002d.containsKey(r101.f531397d) == true) goto L21;
        Iterator<String> r103 = this.f134002d.keySet().iterator();
    L13:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();
        StringBuilder r105 = new StringBuilder("self take 1: ");
        q22.a r106 = this.f134002d.get(r104);
        if (r106 == null) goto L17;
        String r107 = r106.f531396c;
    L18:
        r105.append(r107);
        Logger.d("GiftDanmakuShooter", r105.toString());
        l(this.f134002d.get(r104));
        goto L13
    L17:
        r107 = null;
        goto L18
    L19:
        this.f134002d.clear();
    L21:
        if (r101.f531404k == false) goto L23;
        l(r101);
        return;
    L23:
        this.f134002d.put(r101.f531397d, r101);
        this.f134004f = this.f134003e.subscribe(new r(this));
        return;
    L25:
        if (r101.f531404k == false) goto L28;
        l(r101);
        return;
    L28:
        if (this.f134005g.containsKey(r101.f531397d) == false) goto L32;
        Disposable r108 = this.f134005g.remove(r101.f531397d);
        if (r108 == null) goto L32;
        r108.dispose();
    L32:
        this.f134005g.put(r101.f531397d, Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this, r101)));
    }

    public final void l(q22.a r100) {
        if (((LinkedList) this.f134001c).size() < 100) goto L5;
        ((LinkedList) this.f134001c).removeFirst();
    L5:
        ((LinkedList) this.f134001c).add(r100);
        k();
    }

    @Override // r22.a
    public final void b(q22.a r100, r22.a.b<q22.a> r101) {
        q22.a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "notifier");
        if (r102.f531399f != null) goto L5;
        r101.a(r102);
        return;
    L5:
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r102.f531399f, new p(r102, r101));
    }
}
