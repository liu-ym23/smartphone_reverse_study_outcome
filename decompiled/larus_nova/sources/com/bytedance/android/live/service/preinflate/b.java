package com.bytedance.android.live.service.preinflate;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f100891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProfilePreInflateViewInfo f100892b;

    public b(a r100, ProfilePreInflateViewInfo r101) {
        this.f100891a = r100;
        this.f100892b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<String> r100 = ProfilePreInflateUtil.f100878f;     // Catch: Throwable -> L4
        ArrayList r101 = (ArrayList) r100;     // Catch: Throwable -> L4
        r101.remove(this.f100892b.getTag());     // Catch: Throwable -> L4
        ProfilePreInflateUtil.b(this.f100891a, this.f100892b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
