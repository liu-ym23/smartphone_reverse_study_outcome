package com.bytedance.android.annie.lynx.resource;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTemplateProvider f39524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d8a.b.a f39526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f39527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f39528e;

    public g(LynxTemplateProvider r100, String r101, d8a.b.a r102, Map<String, Object> r103, boolean r104) {
        this.f39524a = r100;
        this.f39525b = r101;
        this.f39526c = r102;
        this.f39527d = r103;
        this.f39528e = r104;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39524a.b(this.f39525b, this.f39526c, false, this.f39527d, this.f39528e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
