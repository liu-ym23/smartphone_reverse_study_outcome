package com.bytedance.android.ec.store.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SortFilterExpandPanel f48966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f48967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f48968c;

    public v(SortFilterExpandPanel r100, List r101, View r102) {
        this.f48966a = r100;
        this.f48967b = r101;
        this.f48968c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f48966a.c(this.f48967b, this.f48968c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
