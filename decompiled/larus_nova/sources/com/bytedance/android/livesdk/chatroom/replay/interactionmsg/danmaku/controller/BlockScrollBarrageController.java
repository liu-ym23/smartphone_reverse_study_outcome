package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.p;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.barrage.b;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import com.ss.ugc.live.barrage.controller.ScrollBarrageController;
import com.ss.ugc.live.barrage.util.a;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class BlockScrollBarrageController extends AbsBarrageController {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f109046n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ScrollBarrageController.b f109047o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap<AbsBarrage, ScrollBarrageController.b> f109048p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AbsBarrage f109049q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f109050r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f109051s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f109052t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ScrollBarrageController.h f109053u;

    public final Context getContext() {
        return this.f109052t.getContext();
    }

    public final void r() {
        a r100 = this.f458094a;
        if (r100 == null) goto L8;
        Iterator<AbsBarrage> r101 = r100.iterator();
    L5:
        a.C5473a r102 = (a.C5473a) r101;
        if (r102.hasNext() == false) goto L8;
        ((AbsBarrage) r102.next()).m();
    L8:
        Deque<AbsBarrage> r103 = this.f458095b;
        if (r103 == null) goto L14;
        Iterator<T> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        ((AbsBarrage) r104.next()).m();
    L14:
        Deque<AbsBarrage> r105 = this.f458096c;
        if (r105 == null) goto L20;
        Iterator<T> r106 = r105.iterator();
    L18:
        if (r106.hasNext() == false) goto L24;
        ((AbsBarrage) r106.next()).m();
        goto L18
    L24:
        return;
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void c(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Iterator<AbsBarrage> r101 = this.f458094a.iterator();
    L3:
        a.C5473a r102 = (a.C5473a) r101;
        if (r102.hasNext() == false) goto L6;
        ((AbsBarrage) r102.next()).g(r100);
        goto L3
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final boolean k(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Function1<AbsBarrage, Unit> r101 = new BlockScrollBarrageController$onTouchEvent$1(this);
        int r102 = r100.getAction();
        if (r102 == 0) goto L22;
        if (r102 != 1) goto L6;
        AbsBarrage r103 = this.f458097d;
        if (r103 == null) goto L40;
        r101.invoke2(r103);
        if (this.f109050r.contains(r100.getX(), r100.getY()) == true) goto L21;
        return false;
    L21:
        return r103.l(r100, this.f458104k);
    L40:
        return false;
    L6:
        if (r102 != 2) goto L8;
    L10:
        AbsBarrage r104 = this.f458097d;
        if (r104 == null) goto L31;
        r101.invoke2(r104);
        if (this.f109050r.contains(r100.getX(), r100.getY()) == true) goto L15;
        return false;
    L15:
        return r104.l(r100, this.f458104k);
    L31:
        return false;
    L8:
        if (r102 == 3) goto L10;
        return false;
    L22:
        ((ArrayList) this.f109051s.f458084a).isEmpty();
        Iterator<AbsBarrage> r105 = this.f458094a.iterator();
    L23:
        a.C5473a r106 = (a.C5473a) r105;
        if (r106.hasNext() == false) goto L43;
        AbsBarrage r107 = (AbsBarrage) r106.next();
        r101.invoke2(r107);
        if (this.f109050r.contains(r100.getX(), r100.getY()) == false) goto L23;
        if (r107.l(r100, this.f458104k) == false) goto L23;
        this.f458097d = r107;
        return true;
    L43:
        return false;
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void j(a r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "runningBarrageList");
        if (this.f109046n == false) goto L5;
        return;
    L5:
        int r102 = this.f109052t.getWidth();
        Iterator<AbsBarrage> r103 = r100.iterator();
    L6:
        a.C5473a r104 = (a.C5473a) r103;
        float r105 = 0.0f;
        if (r104.hasNext() == false) goto L24;
        AbsBarrage r106 = (AbsBarrage) r104.next();
        if (r106.f458058f.right < 0) goto L10;
        ScrollBarrageController.b r107 = this.f109048p.get(r106);
        if (r107 != null) goto L14;
        r107 = this.f109047o;
    L14:
        float r108 = ((r101 / r107.f458124e) * r102) * ((p) this.f109053u).a(r106);
        RectF r109 = r106.f458058f;
        float r110 = r109.right;
        AbsBarrage r111 = this.f109049q;
        if (r111 == null) goto L19;
        RectF r112 = r111.f458058f;
        if (r112 == null) goto L19;
        float r113 = r112.right;
    L21:
        if (r110 <= r113) goto L23;
        this.f109049q = r106;
    L23:
        r109.offset(-r108, 0.0f);
    L19:
        r113 = 0.0f;
        goto L21
    L10:
        this.f109048p.remove(r106);
        r104.remove();
        goto L6
    L24:
        int r114 = this.f109047o.f458121b;
        AbsBarrage r115 = this.f109049q;
        if (r115 == null) goto L30;
        RectF r116 = r115.f458058f;
        if (r116 == null) goto L30;
        r105 = r116.right;
    L30:
        if (r105 <= r102) goto L32;
        return;
    L32:
        g();
    }

    public BlockScrollBarrageController(View r100, ScrollBarrageController.b r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "barrageLayout");
        Intrinsics.checkNotNullParameter(r101, "initialDanmakuConfig");
        Intrinsics.checkNotNullParameter(r102, "speedStrategy");
        super(r100);
        this.f109052t = r100;
        this.f109053u = r102;
        this.f109047o = r101;
        this.f109048p = new HashMap();
        new Random();
        this.f109050r = new RectF();
        this.f109051s = new b();
    }
}
