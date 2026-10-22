package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<tf0.d> f76426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<tf0.d> f76427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<tf0.d> f76428d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
    }

    public d() {
        this.f76426b = new ArrayList();
        this.f76427c = new ArrayList();
        this.f76428d = new ArrayList();
    }

    public final void d(nh0.l r110) {
        Intrinsics.checkNotNullParameter(r110, "seatExtraObject");
        int r100 = e.f76430a[r110.getType().ordinal()];
        if (r100 != 1) goto L5;
        List<tf0.d> r101 = this.f76426b;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L112:
        if (r103.hasNext() == false) goto L130;
        Object r104 = r103.next();
        tf0.d r105 = (tf0.d) r104;
        List<tf0.d> r106 = r110.f519137c;
        if ((r106 instanceof Collection) == true) goto L116;
    L118:
        Iterator<T> r107 = r106.iterator();
    L120:
        if (r107.hasNext() == false) goto L127;
        if (r105.a() != ((tf0.d) r107.next()).a()) goto L124;
        boolean r111 = true;
    L125:
        if (r111 == false) goto L120;
        boolean r108 = false;
    L128:
        if (r108 == false) goto L112;
        r102.add(r104);
        goto L112
    L124:
        r111 = false;
    L127:
        r108 = true;
        goto L128
    L116:
        if (r106.isEmpty() == false) goto L118;
    L130:
        List<tf0.d> r109 = CollectionsKt.toMutableList(r102);
        this.f76426b = r109;
        r109.addAll(r110.f519137c);
    L131:
        gh0.a.b("DynamicHandler", "onSeatExtraObjectUpdate: \n updateByUidList = " + this.f76426b + ", \n updateByPosList = " + this.f76427c + ", \n updateAllList = " + this.f76428d, 4);
        a().y0(new ch0.i(r110.f519135a, this.f76426b, this.f76427c, this.f76428d));
        return;
    L5:
        if (r100 != 2) goto L7;
        Iterator<T> r112 = r110.f519137c.iterator();
    L93:
        if (r112.hasNext() == false) goto L131;
        tf0.d r113 = (tf0.d) r112.next();
        Iterator<T> r114 = this.f76427c.iterator();
    L96:
        if (r114.hasNext() == false) goto L105;
        Object r115 = r114.next();
        tf0.d r116 = (tf0.d) r115;
        if (r116.b() == r113.b()) goto L100;
    L102:
        boolean r117 = false;
    L103:
        if (r117 == false) goto L96;
    L106:
        tf0.d r118 = (tf0.d) r115;
        if (r118 == null) goto L109;
        this.f76427c.remove(r118);
    L109:
        this.f76427c.add(r113);
        goto L93
    L100:
        if (r116.a() != r113.a()) goto L102;
        r117 = true;
        goto L103
    L105:
        r115 = null;
        goto L106
    L7:
        if (r100 == 3) goto L74;
        if (r100 != 4) goto L131;
        if (r110.f519137c.isEmpty() == false) goto L13;
        this.f76426b.clear();
        this.f76427c.clear();
        this.f76428d.clear();
        goto L131
    L13:
        gh0.a.b("DynamicHandler", "onSeatExtraObjectUpdate: \n updateByUidList = " + this.f76426b + ", \n removeList = " + r110.f519137c, 4);
        List<tf0.d> r119 = this.f76426b;
        ArrayList r120 = new ArrayList();
        Iterator<T> r121 = r119.iterator();
    L15:
        if (r121.hasNext() == false) goto L33;
        Object r122 = r121.next();
        tf0.d r123 = (tf0.d) r122;
        List<tf0.d> r124 = r110.f519137c;
        if ((r124 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r125 = r124.iterator();
    L23:
        if (r125.hasNext() == false) goto L30;
        if (r123.a() != ((tf0.d) r125.next()).a()) goto L27;
        boolean r126 = true;
    L28:
        if (r126 == false) goto L23;
        boolean r127 = false;
    L31:
        if (r127 == false) goto L15;
        r120.add(r122);
        goto L15
    L27:
        r126 = false;
    L30:
        r127 = true;
        goto L31
    L19:
        if (r124.isEmpty() == false) goto L21;
    L33:
        this.f76426b = CollectionsKt.toMutableList(r120);
        List<tf0.d> r128 = this.f76427c;
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r128.iterator();
    L35:
        if (r130.hasNext() == false) goto L53;
        Object r131 = r130.next();
        tf0.d r132 = (tf0.d) r131;
        List<tf0.d> r133 = r110.f519137c;
        if ((r133 instanceof Collection) == true) goto L39;
    L41:
        Iterator<T> r134 = r133.iterator();
    L43:
        if (r134.hasNext() == false) goto L50;
        if (r132.a() != ((tf0.d) r134.next()).a()) goto L47;
        boolean r135 = true;
    L48:
        if (r135 == false) goto L43;
        boolean r136 = false;
    L51:
        if (r136 == false) goto L35;
        r129.add(r131);
        goto L35
    L47:
        r135 = false;
    L50:
        r136 = true;
        goto L51
    L39:
        if (r133.isEmpty() == false) goto L41;
    L53:
        this.f76427c = CollectionsKt.toMutableList(r129);
        List<tf0.d> r137 = this.f76428d;
        ArrayList r138 = new ArrayList();
        Iterator<T> r139 = r137.iterator();
    L55:
        if (r139.hasNext() == false) goto L73;
        Object r140 = r139.next();
        tf0.d r141 = (tf0.d) r140;
        List<tf0.d> r142 = r110.f519137c;
        if ((r142 instanceof Collection) == true) goto L59;
    L61:
        Iterator<T> r143 = r142.iterator();
    L63:
        if (r143.hasNext() == false) goto L70;
        if (r141.a() != ((tf0.d) r143.next()).a()) goto L67;
        boolean r144 = true;
    L68:
        if (r144 == false) goto L63;
        boolean r145 = false;
    L71:
        if (r145 == false) goto L55;
        r138.add(r140);
        goto L55
    L67:
        r144 = false;
    L70:
        r145 = true;
        goto L71
    L59:
        if (r142.isEmpty() == false) goto L61;
    L73:
        this.f76428d = CollectionsKt.toMutableList(r138);
        goto L131
    L74:
        Iterator<T> r146 = r110.f519137c.iterator();
    L76:
        if (r146.hasNext() == false) goto L131;
        tf0.d r147 = (tf0.d) r146.next();
        Iterator<T> r148 = this.f76428d.iterator();
    L79:
        if (r148.hasNext() == false) goto L86;
        Object r149 = r148.next();
        if (((tf0.d) r149).a() != r147.a()) goto L83;
        boolean r150 = true;
    L84:
        if (r150 == false) goto L79;
    L87:
        tf0.d r151 = (tf0.d) r149;
        if (r151 == null) goto L90;
        this.f76428d.remove(r151);
    L90:
        this.f76428d.add(r147);
        goto L76
    L83:
        r150 = false;
        goto L84
    L86:
        r149 = null;
        goto L87
    }
}
