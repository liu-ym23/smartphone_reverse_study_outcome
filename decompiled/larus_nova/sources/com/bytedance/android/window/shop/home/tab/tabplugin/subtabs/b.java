package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowTabsSelectionJSbPluginExp f188965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f188966b;

    public b(ECWindowTabsSelectionJSbPluginExp r100, String r101) {
        this.f188965a = r100;
        this.f188966b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECWindowTabsSelectionJSbPluginExp r100 = this.f188965a;     // Catch: Throwable -> L4
        r100.f188963f.invoke(this.f188966b, r100.f188959b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
