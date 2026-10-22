package com.bytedance.android.ec.core.address;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f43714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f43715b;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f43716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Object> f43717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f43718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f43719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f43720e;

        public a(WeakReference r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, "topActivityHash");
            Intrinsics.checkNotNullParameter(r102, "topFragmentHash");
            this.f43717b = r100;
            this.f43718c = r101;
            this.f43719d = r102;
            this.f43720e = r103;
            this.f43716a = u.a(r100.get(), r103);
        }
    }

    public u() {
        this.f43714a = new ArrayList();
        this.f43715b = 50;
    }

    public static String a(Object r100, String r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101;
    L6:
        return "0x" + Integer.toHexString(System.identityHashCode(r100));
    }

    public final void b(Object r100, String r101) {
        String r102 = a(r100, r101);
        ArrayList r103 = new ArrayList();
        boolean r104 = false;
    L4:
        if ((!this.f43714a.isEmpty()) == false) goto L18;
        if (r104 == true) goto L26;
        a r105 = (a) CollectionsKt.lastOrNull(this.f43714a);
        if (r105 == null) goto L11;
        WeakReference<Object> r106 = r105.f43717b;
        if (r106 == null) goto L11;
        r106.get();
    L11:
        if (r105 == null) goto L13;
        String r107 = r105.f43716a;
    L15:
        if (Intrinsics.areEqual(r107, r102) == true) goto L16;
        ArrayList<a> r108 = this.f43714a;
        r103.add(ListProtector.remove(r108, CollectionsKt.getLastIndex(r108)));
        goto L4
    L16:
        r104 = true;
        goto L4
    L13:
        r107 = null;
        goto L15
    L26:
        return;
    }
}
