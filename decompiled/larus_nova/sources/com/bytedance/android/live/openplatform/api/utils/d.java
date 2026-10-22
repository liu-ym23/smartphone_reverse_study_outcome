package com.bytedance.android.live.openplatform.api.utils;

import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class d {
    public d() {
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract boolean g();

    public final boolean h() {
        if (c() == false) goto L5;
    L18:
        return true;
    L5:
        if (f() == true) goto L18;
        if (d() == true) goto L18;
        if (a() == true) goto L18;
        if (b() == true) goto L18;
        if (g() == true) goto L18;
        if (e() == true) goto L18;
        return false;
    }

    public final boolean i() {
        if (d() == false) goto L5;
    L8:
        return true;
    L5:
        if (a() == true) goto L8;
        return false;
    }

    public final boolean j() {
        if (b() == false) goto L5;
    L8:
        return true;
    L5:
        if (g() == true) goto L8;
        return false;
    }

    public final List<ProductIntroductionInfo> k(List<ProductIntroductionInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (d() == true) goto L15;
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (((ProductIntroductionInfo) r103).introductionType == 1) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        r104 = false;
        goto L11
    L13:
        r100 = r101;
    L15:
        if (a() == true) goto L37;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r100.iterator();
    L18:
        if (r106.hasNext() == false) goto L26;
        Object r107 = r106.next();
        if (((ProductIntroductionInfo) r107).introductionType == 2) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L18;
        r105.add(r107);
        goto L18
    L22:
        r108 = false;
        goto L23
    L26:
        return r105;
    L37:
        return r100;
    }

    public final List<ProductLabelInfo> l(List<ProductLabelInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (b() == true) goto L15;
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (((ProductLabelInfo) r103).labelType == 2) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        r104 = false;
        goto L11
    L13:
        r100 = r101;
    L15:
        if (g() == true) goto L37;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r100.iterator();
    L18:
        if (r106.hasNext() == false) goto L26;
        Object r107 = r106.next();
        if (((ProductLabelInfo) r107).labelType == 3) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L18;
        r105.add(r107);
        goto L18
    L22:
        r108 = false;
        goto L23
    L26:
        return r105;
    L37:
        return r100;
    }
}
