package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f162966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f162967b;

    @Override // java.lang.Runnable
    public final void run() {
        Map<WebView, List<cz2.a>> r100 = this.f162967b.f162977j;     // Catch: Throwable -> L11
        WeakHashMap r101 = (WeakHashMap) r100;     // Catch: Throwable -> L11
        List r102 = (List) r101.get(this.f162966a);     // Catch: Throwable -> L11
        if (r102 == null) goto L14;
        Iterator r103 = r102.iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L24;
        cz2.a r104 = (cz2.a) r103.next();     // Catch: Throwable -> L11
        if (r104 == null) goto L6;
        r104.a();     // Catch: Throwable -> L11
        goto L6
    L24:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }

    public o(p r100, WebView r101, ez2.d r102) {
        this.f162967b = r100;
        this.f162966a = r101;
    }
}
