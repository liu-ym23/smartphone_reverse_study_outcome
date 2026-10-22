package com.bytedance.android.live.revenuelink.multimsg;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.revenuelink.connect.LinkOutManager;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.livesdk.config.z51;
import com.bytedance.android.livesdk.link.model.bridge.h2;
import com.bytedance.android.livesdk.message.model.qj;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import yz0.h;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a extends com.bytedance.android.live.revenuelink.rtc.e implements com.bytedance.android.live.revenuelink.multimsg.api.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f91850j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f91851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f91852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f91853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Set<e>> f91854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet<c> f91855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, CompositeDisposable> f91856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<Long, Integer> f91857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f91858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final yz0.f f91859i;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.multimsg.a$a, reason: collision with other inner class name */
    public static final class C1426a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.revenuelink.multimsg.api.b
    public final void f(com.bytedance.android.live.revenuelink.multimsg.api.e<?, ? extends Exception> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if ((r100 instanceof com.bytedance.android.live.revenuelink.multimsg.api.e.c) == false) goto L10;
        V r101 = ((com.bytedance.android.live.revenuelink.multimsg.api.e.c) r100).f91876b;
        if ((r101 instanceof g) == false) goto L15;
        g r102 = (g) r101;
        yh6.c r103 = r102.f91895b;
        if (r103 == null) goto L16;
        k(1, r103, r102.f91894a);
        return;
    L16:
        return;
    L15:
        return;
    L10:
        if ((r100 instanceof com.bytedance.android.live.revenuelink.multimsg.api.e.b) == false) goto L14;
        ((com.bytedance.android.live.revenuelink.multimsg.api.e.b) r100).getClass();
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public a(i r100, yz0.f r101) {
        this.f91858h = r100;
        this.f91859i = r101;
        xa1.b r102 = xa1.b.f563035d;
        r102.getClass();
        ReadOnlyProperty r103 = xa1.b.f563033b;
        KProperty<?>[] r104 = xa1.b.f563032a;
        boolean r105 = false;
        z51 r106 = (z51) r103.getValue(r102, r104[0]);
        if (r106 == null) goto L9;
        Integer r107 = r106.L1();
        if (r107 == null) goto L9;
        if ((r107.intValue() & 2) != 2) goto L9;
        boolean r108 = true;
    L10:
        this.f91851a = r108;
        z51 r109 = (z51) r103.getValue(r102, r104[0]);
        this.f91852b = true;
        z51 r110 = (z51) r103.getValue(r102, r104[0]);
        if (r110 == null) goto L13;
        Integer r111 = r110.L1();
    L14:
        if (r111 != null) goto L17;
    L19:
        this.f91853c = r105;
        this.f91854d = new HashMap();
        this.f91855e = new CopyOnWriteArraySet();
        this.f91856f = new HashMap();
        this.f91857g = new ConcurrentHashMap();
        return;
    L17:
        if (r111.intValue() != 3) goto L19;
        r105 = true;
        goto L19
    L13:
        r111 = null;
    L9:
        r108 = false;
        goto L10
    }

    public final void j(yh6.b r100, LinkOutManager r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (this.f91852b == false) goto L14;
        yz0.f r102 = this.f91859i;
        if (r102 == null) goto L14;
        Observable r103 = h.a.a(r102, r100, false, 6);
        if (r103 == null) goto L14;
        final BaseMultiMsgManager$addMessageListener$1 r104 = new BaseMultiMsgManager$addMessageListener$1(this);
        Disposable r105 = r103.subscribe(new b(r104));
        if (r105 == null) goto L14;
        HashMap<String, CompositeDisposable> r106 = this.f91856f;
        String r107 = r100.getName();
        CompositeDisposable r108 = r106.get(r107);
        if (r108 != null) goto L13;
        r108 = new CompositeDisposable();
        r106.put(r107, r108);
    L13:
        com.bytedance.revenue.platform.api.core.rx.f.a(r105, r108);
    L14:
        Set<e> r109 = this.f91854d.get(r100.getName());
        if (r109 != null) goto L17;
        r109 = new CopyOnWriteArraySet();
        this.f91854d.put(r100.getName(), r109);
    L17:
        r109.add(r101);
    }

    public final void k(int r100, yh6.c r110, h2 r111) {
        String r101 = null;
        if (r110 == null) goto L5;
        Long r102 = qj.a(r110);
    L6:
        long r103 = 0;
        if (r100 != 1) goto L16;
        if (r102 != null) goto L10;
    L11:
        if (r111 == null) goto L15;
        h2.b r112 = r111.getHeader();
        if (r112 == null) goto L15;
        r102 = Long.valueOf(r112.getMsgId());
    L15:
        r102 = null;
        goto L16
    L10:
        if (r102.longValue() == 0) goto L11;
    L16:
        if (r102 == null) goto L18;
        r103 = r102.longValue();
    L18:
        Integer r113 = this.f91857g.get(Long.valueOf(r103));
        boolean r104 = false;
        if (r113 != null) goto L21;
    L23:
        boolean r114 = false;
    L24:
        Iterator<c> r105 = this.f91855e.iterator();
    L26:
        if (r105.hasNext() == false) goto L29;
        r105.next().a(r110, r114);
        goto L26
    L29:
        if (this.f91853c == false) goto L45;
        Integer r115 = this.f91857g.get(Long.valueOf(r103));
        if (r115 != null) goto L35;
    L38:
        if (r115 != null) goto L41;
    L44:
        this.f91857g.put(Long.valueOf(r103), Integer.valueOf(r100));
        goto L45
    L41:
        if (r115.intValue() != 1) goto L44;
        if (r100 != 0) goto L46;
        this.f91857g.remove(Long.valueOf(r103));
    L46:
        if (r104 == true) goto L48;
        return;
    L48:
        HashMap<String, Set<e>> r106 = this.f91854d;
        if (r110 == null) goto L53;
        m0 r116 = r110.getCommonData();
        if (r116 == null) goto L53;
        r101 = r116.getMethod();
    L53:
        Set<e> r107 = r106.get(r101);
        if (r107 != null) goto L56;
        return;
    L56:
        if ((!r107.isEmpty()) == false) goto L64;
        Iterator<e> r108 = r107.iterator();
    L59:
        if (r108.hasNext() == false) goto L65;
        r108.next().a(r110);
        goto L59
    L65:
        return;
    L64:
        return;
    L35:
        if (r115.intValue() != 0) goto L38;
        if (r100 != 1) goto L46;
        this.f91857g.remove(Long.valueOf(r103));
    L45:
        r104 = true;
        goto L46
    L21:
        if (r113.intValue() == r100) goto L23;
        r114 = true;
        goto L24
    L5:
        r102 = null;
        goto L6
    }
}
