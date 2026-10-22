package com.bytedance.android.livesdk.livecommerce.messagev2;

import com.bytedance.android.ec.model.live.r;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f149406a;

    public b(a r100) {
        this.f149406a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.j
    public final List<r> a(String r100) {
        List<r> r101 = this.f149406a.f149397g;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L25;
        Object r104 = r103.next();
        r r105 = (r) r104;
        boolean r106 = false;
        if (r100 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == true) goto L22;
        if (r100 != null) goto L15;
    L18:
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
    L23:
        if (r106 == false) goto L4;
        r102.add(r104);
        goto L4
    L21:
        if (Intrinsics.areEqual(r100, r105.f()) == false) goto L23;
    L15:
        if (r100.length() == 0) goto L18;
        r108 = false;
    L22:
        r106 = true;
        goto L23
    L8:
        if (r100.length() == 0) goto L11;
        r107 = false;
        goto L12
    L25:
        return r102;
    }
}
