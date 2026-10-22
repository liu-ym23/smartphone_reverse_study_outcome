package org.libpag;

import java.util.ArrayList;
import org.libpag.PAGView;

/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGView f19254a;

    p(PAGView pAGView) {
        this.f19254a = pAGView;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        synchronized (this.f19254a) {
            arrayList = new ArrayList(this.f19254a.f19213v);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((PAGView.PAGFlushListener) obj).onFlush();
        }
    }
}
