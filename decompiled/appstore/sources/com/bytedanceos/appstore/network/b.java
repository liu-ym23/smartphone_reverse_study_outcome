package com.bytedanceos.appstore.network;

import android.content.Context;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f9435a;

    public b(Context r10) {
        this.f9435a = r10;
    }

    @Override // java.lang.Runnable
    public void run() {
        int r10 = e.A();
        if (r10 != 2) goto L5;
    L6:
        ArrayList r11 = e8.a.k(this.f9435a);
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.size() <= 0) goto L19;
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        j.a(" check the app that mark deleted , will sync to server : " + ((AppInfo) r12.next()));
        goto L12
    L14:
        com.bytedanceos.appstore.utils.a.H(this.f9435a, r11);
        return;
    L19:
        return;
    L5:
        if (r10 == 1) goto L6;
    }
}
