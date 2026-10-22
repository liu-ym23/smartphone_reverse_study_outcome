package com.bytedance.android.shopping.store.arch;

import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import uj3.j;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183499a = 0;

    static {
    }

    public static i a(ECStoreTabAreaVO r100) {
        List<j> r101 = r100.f183634b;
        Object r102 = null;
        if (r101 == null) goto L18;
        Iterator<T> r103 = r101.iterator();
        j r104 = null;
    L6:
        if (r103.hasNext() == false) goto L19;
        j r105 = (j) r103.next();
        if (r105.i() == true) goto L9;
        List<j> r106 = r105.f550298b;
        if (r106 == null) goto L6;
        Iterator<T> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L6;
        j r108 = (j) r107.next();
        if (r108.i() == false) goto L14;
        r104 = r108;
        goto L14
    L9:
        r104 = r105;
    L19:
        if (r104 == null) goto L47;
        k r109 = r104.I;
        if (r109 == null) goto L48;
        ArrayList<i> r110 = r109.f47130c;
        if (r110 == null) goto L49;
        Iterator<T> r111 = r110.iterator();
    L26:
        if (r111.hasNext() == false) goto L31;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((i) r112).f47107a, "__PRODUCTS_SECTION__") == false) goto L26;
        r102 = r112;
    L31:
        return (i) r102;
    L49:
        return null;
    L48:
        return null;
    L47:
        return null;
    L18:
        r104 = null;
        goto L19
    }
}
