package com.bytedance.android.live.revlink.impl.pk.ui;

import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkTagsContainerView f97065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f97066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f97067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f97068d;

    public t(PkTagsContainerView r100, List r101, int r102, boolean r103) {
        this.f97065a = r100;
        this.f97066b = r101;
        this.f97067c = r102;
        this.f97068d = r103;
    }

    public final void a() {
        PkTagsContainerView r100 = this.f97065a;
        if (r100.f97015c <= 0) goto L5;
        return;
    L5:
        r100.f97015c = PkTagsContainerView.c(r100);
        PkTagsContainerView r101 = this.f97065a;
        r101.f97014b = r101.f97015c;
        Iterator r102 = this.f97066b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        IBattleRivalTag r103 = (IBattleRivalTag) r102.next();
        this.f97065a.d(r103, this.f97067c, this.f97068d);
        goto L7
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
