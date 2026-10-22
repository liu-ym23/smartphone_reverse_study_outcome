package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BubbleComponent f115530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ om3.e f115531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int[] f115532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f115533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f115534e;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f115531b.isShowing() == true) goto L6;
        this.f115530a.f115504d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L6:
        this.f115530a.f115504d.getLocationOnScreen(this.f115532c);
        int[] r100 = this.f115532c;
        if (r100.length == 2) goto L9;
        return;
    L9:
        Ref.IntRef r101 = this.f115533d;
        int r102 = r101.element;
        if (r102 != (-1)) goto L14;
        r101.element = r100[0];
        Ref.IntRef r103 = this.f115534e;
        r103.element = r100[1];
        return;
    L14:
        if (r102 == r100[0]) goto L16;
    L17:
        this.f115530a.f115504d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f115531b.b();
        return;
    L16:
        if (this.f115534e.element != r100[1]) goto L17;
    }

    public b(BubbleComponent r100, com.bytedance.android.livesdk.chatroom.view.k r101, int[] r102, Ref.IntRef r103, Ref.IntRef r104) {
        this.f115530a = r100;
        this.f115531b = r101;
        this.f115532c = r102;
        this.f115533d = r103;
        this.f115534e = r104;
    }
}
