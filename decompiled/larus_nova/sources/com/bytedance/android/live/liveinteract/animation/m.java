package com.bytedance.android.live.liveinteract.animation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, CopyOnWriteArrayList<f>> f71076a;

    public final int b() {
        Iterator<CopyOnWriteArrayList<f>> r100 = this.f71076a.values().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L15;
        CopyOnWriteArrayList<f> r102 = r100.next();
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L4;
        r101 = r101 + r102.size();
        goto L4
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    L15:
        return r101;
    }

    public m() {
        this.f71076a = new HashMap();
    }

    public final int a(int r100) {
        CopyOnWriteArrayList<f> r101 = this.f71076a.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return 0;
    L12:
        return r101.size();
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final f c(int r100) {
        CopyOnWriteArrayList<f> r101 = this.f71076a.get(Integer.valueOf(r100));
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        f r104 = null;
        if (r103 == false) goto L12;
        return null;
    L12:
        if (r101 == null) goto L14;
        r104 = r101.remove(0);
    L14:
        if (r101 != null) goto L16;
    L19:
        if (r102 == false) goto L21;
        this.f71076a.remove(Integer.valueOf(r100));
    L21:
        return r104;
    L16:
        if (r101.isEmpty() == true) goto L19;
        r102 = false;
        goto L19
    L5:
        if (r101.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public final void d(f r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (this.f71076a.get(Integer.valueOf(r100.getType())) != null) goto L5;
        CopyOnWriteArrayList<f> r101 = new CopyOnWriteArrayList();
        r101.add(r100);
        this.f71076a.put(Integer.valueOf(r100.getType()), r101);
        return;
    L5:
        CopyOnWriteArrayList<f> r102 = this.f71076a.get(Integer.valueOf(r100.getType()));
        if (r102 == null) goto L10;
        r102.add(r100);
        return;
    }
}
