package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentChallengeResultView f144627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f144628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f144629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f144630d;

    public d(KtvComponentChallengeResultView r100, int r101, int r102, int r103) {
        this.f144627a = r100;
        this.f144628b = r101;
        this.f144629c = r102;
        this.f144630d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvComponentChallengeResultView r100 = this.f144627a;     // Catch: Throwable -> L4
        int r101 = this.f144628b;     // Catch: Throwable -> L4
        int r102 = this.f144629c;     // Catch: Throwable -> L4
        int r103 = this.f144630d;     // Catch: Throwable -> L4
        int r104 = KtvComponentChallengeResultView.f144596g;     // Catch: Throwable -> L4
        r100.R5(r101, r102, r103);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
