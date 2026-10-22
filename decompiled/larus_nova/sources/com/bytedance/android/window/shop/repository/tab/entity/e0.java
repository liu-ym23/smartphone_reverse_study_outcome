package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e0 extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f189548m = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d0 f189549j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WindowLayoutType f189550k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<d> f189551l;

    public static final class a {
        public a() {
        }

        public static e0 a(List r100, WindowLayoutType r101, List r102) {
            Intrinsics.checkNotNullParameter(r100, "sortTypeDtoList");
            Intrinsics.checkNotNullParameter(r101, "layoutType");
            int r103 = d0.f189535k;
            d0 r104 = d0.a.a(r100);
            ArrayList r105 = null;
            if (r102 == null) goto L20;
            ArrayList r106 = new ArrayList();
            Iterator r107 = r102.iterator();
        L6:
            if (r107.hasNext() == false) goto L18;
            com.bytedance.android.window.shop.repository.dto.a r108 = (com.bytedance.android.window.shop.repository.dto.a) r107.next();
            int r109 = d.f189530e;
            Intrinsics.checkNotNullParameter(r108, "dto");
            Integer r110 = r108.a();
            if (r110 == null) goto L15;
            int r111 = r110.intValue();
            String r112 = r108.b();
            if (r112 == null) goto L15;
            Boolean r113 = r108.d();
            if (r113 == null) goto L15;
            d r114 = new d(r111, r112, r113.booleanValue(), r108.c());
        L16:
            if (r114 == null) goto L6;
            r106.add(r114);
        L15:
            r114 = null;
            goto L16
        L18:
            r105 = r106;
        L20:
            return new e0(r104, r101, r105);
        }
    }

    static {
        f189548m = new a();
    }

    public e0(d0 r100, WindowLayoutType r101, List<d> r102) {
        Intrinsics.checkNotNullParameter(r100, "sortBarVO");
        Intrinsics.checkNotNullParameter(r101, "layout");
        super(2503);
        this.f189549j = r100;
        this.f189550k = r101;
        this.f189551l = r102;
    }
}
