package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f168484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f168485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f168486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f168487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f168488e;

    public b() {
        this(null, null, null, false, null, 31);
    }

    public final String a() {
        String r100 = this.f168484a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        StringBuilder r101 = new StringBuilder(r100);
        Iterator<T> r102 = this.f168486c.iterator();
    L7:
        if (r102.hasNext() == false) goto L25;
        c r103 = (c) r102.next();
        ECUrlModel r104 = r103.f168529b;
        String r105 = null;
        if (r104 == null) goto L11;
        String r106 = r104.getUri();
    L12:
        r101.append(r106);
        ECUrlModel r107 = r103.f168530c;
        if (r107 == null) goto L15;
        String r108 = r107.getUri();
    L16:
        r101.append(r108);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r109 = r103.f168536i;
        if (r109 == null) goto L19;
        String r110 = r109.j();
    L20:
        r101.append(r110);
        ECUrlModel r111 = r103.f168535h;
        if (r111 == null) goto L23;
        r105 = r111.getUri();
    L23:
        r101.append(r105);
        goto L7
    L19:
        r110 = null;
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    L25:
        return r101.toString();
    }

    public b(String r100, String r101, List<c> r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "nodeList");
        this.f168484a = r100;
        this.f168485b = r101;
        this.f168486c = r102;
        this.f168487d = r103;
        this.f168488e = r104;
    }

    public /* synthetic */ b(String r100, String r101, List r102, boolean r103, String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = CollectionsKt.emptyList();
    L13:
        List r106 = r102;
        if ((r111 & 8) == 0) goto L16;
        boolean r107 = false;
    L18:
        if ((r111 & 16) == 0) goto L20;
        String r112 = null;
    L21:
        this(r104, r105, r106, r107, r112);
        return;
    L20:
        r112 = r110;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L9:
        r105 = r101;
        goto L11
    L5:
        r104 = r100;
        goto L7
    }
}
