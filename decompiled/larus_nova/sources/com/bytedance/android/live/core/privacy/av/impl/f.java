package com.bytedance.android.live.core.privacy.av.impl;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.privacy.av.api.AudioAndVideoException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f65183a;

    public f(e r100) {
        this.f65183a = r100;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        Object r100 = null;
        boolean r101 = true;
        if ((r110.obj instanceof e.b) == false) goto L24;
        Iterator r102 = ((CopyOnWriteArrayList) this.f65183a.f65168c).iterator();
    L6:
        if (r102.hasNext() == false) goto L24;
        e.c r103 = (e.c) r102.next();
        if (r103.getType() != r110.what) goto L10;
        r103.f65182h = true;
    L10:
        Object r104 = r110.obj;
        if ((r104 instanceof e.b) == true) goto L13;
        r104 = null;
    L13:
        e.b r105 = (e.b) r104;
        if (r105 == null) goto L16;
        int r106 = r105.f65174a;
    L18:
        if (r103.f65175a == r106) goto L23;
        List r107 = (List) ((ConcurrentHashMap) this.f65183a.f65167b).get(Integer.valueOf(r106));
        if (r107 == null) goto L6;
        if (r107.contains(Integer.valueOf(r103.f65175a)) != true) goto L6;
    L23:
        r103.f65182h = true;
        goto L6
    L16:
        r106 = -1;
    L24:
        Object r108 = r110.obj;
        if ((r108 instanceof e.c) == false) goto L28;
        r100 = r108;
    L28:
        e.c r109 = (e.c) r100;
        if (r109 != null) goto L31;
        return false;
    L31:
        ((CopyOnWriteArrayList) this.f65183a.f65168c).remove(r109);
        int r111 = r110.what;
        String r112 = r109.f65176b;
        String r113 = r109.f65177c;
        com.bytedance.android.live.core.privacy.av.api.a r114 = r109.f65180f;
        Map<String, String> r115 = r109.f65178d;
        com.bytedance.android.live.core.privacy.av.api.b r116 = r109.f65179e;
        String r117 = this.f65183a.f65169d.get(Integer.valueOf(r111));
        if (r117 != null) goto L34;
        r117 = "-";
    L34:
        String r118 = r117;
        if (r109.f65182h == false) goto L38;
        r116.c(r112, r113, r118, r115, r114);
        this.f65183a.f65172g.c(r112, r113, r118, r115, r114);
        return false;
    L38:
        List<String> r119 = this.f65183a.f65173h.c();
        if (r119 != null) goto L41;
    L44:
        if (r111 != 1) goto L46;
        r101 = this.f65183a.f65171f.a(r114.b());
    L56:
        if (r101 == true) goto L58;
        AudioAndVideoException r120 = new AudioAndVideoException(r112 + '-' + r113 + '-' + r118 + " check failed");
        r116.a(r112, r113, r118, r115, r114, r120);
        this.f65183a.f65172g.a(r112, r113, r118, r115, r114, r120);
    L59:
        return false;
    L58:
        r116.d(r112, r113, r118, r115, r114);
        this.f65183a.f65172g.d(r112, r113, r118, r115, r114);
        goto L59
    L46:
        if (r111 != 2) goto L48;
        r101 = this.f65183a.f65171f.b(r114.b());
        goto L56
    L48:
        if (r111 != 3) goto L50;
        r101 = this.f65183a.f65171f.c(r114.b());
        goto L56
    L50:
        if (r111 != 4) goto L56;
        r101 = this.f65183a.f65171f.d(r114.b());
        goto L56
    L41:
        if (r119.contains(r112) != true) goto L44;
        r116.c(r112, r113, r118, r115, r114);
        this.f65183a.f65172g.c(r112, r113, r118, r115, r114);
        return false;
    }
}
