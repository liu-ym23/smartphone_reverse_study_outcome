package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f152480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f152481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f152482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f152483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f152484e;

    public s(ViewGroup r100, r r101, List r102, int r103, boolean r104) {
        this.f152480a = r100;
        this.f152481b = r101;
        this.f152482c = r102;
        this.f152483d = r103;
        this.f152484e = r104;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.E(this.f152481b, this.f152483d + 1, this.f152482c, this.f152484e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
