package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.f0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f169516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f169517b;

    public j(k r100, int r101) {
        this.f169516a = r100;
        this.f169517b = r101;
    }

    public final void a() {
        k r100 = this.f169516a;
        r100.f169518a.f169512f = null;
        List<c0> r101 = r100.f169519b.f169325c;
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        int r104 = f0.f169307a;
        if (f0.b(this.f169517b, (c0) r103) == false) goto L6;
    L11:
        c0 r105 = (c0) r103;
        if (r105 == null) goto L14;
        int r106 = f0.f169307a;
        h.a(this.f169516a.f169518a, f0.a(r105.a(this.f169517b)));
        h r107 = this.f169516a.f169518a;
        r107.f169509c.setVisibility(0);
        r107.f169509c.setAlpha(0.0f);
        r107.f169509c.animate().alpha(1.0f).setDuration(300).setListener(null).start();
        Lazy r108 = UIUtils.f45548a;
        UIUtils.c().removeCallbacks(r107.f169511e);
        UIUtils.c().postDelayed(r107.f169511e, 3000);
        goto L14
    L10:
        r103 = null;
    L14:
        this.f169516a.f169518a.f169508b.add(Integer.valueOf(this.f169517b));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
