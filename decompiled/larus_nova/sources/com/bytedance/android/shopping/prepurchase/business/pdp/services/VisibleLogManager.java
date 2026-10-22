package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import android.graphics.Rect;
import android.view.View;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class VisibleLogManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f182030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv4.log.e> f182031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f182032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f182033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f182034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f182035f;

    public VisibleLogManager() {
        this.f182030a = LazyKt.lazy(VisibleLogManager$theHandler$2.INSTANCE);
        this.f182031b = new ArrayList();
        this.f182032c = LazyKt.lazy(VisibleLogManager$rect$2.INSTANCE);
        this.f182033d = -1;
    }

    public static final void a(VisibleLogManager r100) {
        ArrayList r101 = (ArrayList) r100.f182031b;
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.anchorv4.log.e) r102.next()).f167060a.onScan();
        goto L4
    L6:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (((com.bytedance.android.shopping.anchorv4.log.e) r105).f167062c == true) goto L8;
        r103.add(r105);
        goto L8
    L12:
        Iterator r106 = r103.iterator();
    L14:
        if (r106.hasNext() == false) goto L31;
        com.bytedance.android.shopping.anchorv4.log.e r107 = (com.bytedance.android.shopping.anchorv4.log.e) r106.next();
        View r108 = r107.f167060a.t();
        if (r108 == null) goto L14;
        int r109 = r107.f167063d;
        int r110 = r107.f167060a.M0();
        r107.getIdentifier();
        r108.getGlobalVisibleRect((Rect) r100.f182032c.getValue());
        if (r109 == 0) goto L22;
        if (r109 != 1) goto L22;
        int r111 = ((Rect) r100.f182032c.getValue()).bottom;
    L23:
        int r112 = r100.f182033d - r110;
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
        r111 = ((Rect) r100.f182032c.getValue()).top;
        goto L23
    }
}
