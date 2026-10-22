package com.google.android.material.datepicker;

/* renamed from: com.google.android.material.datepicker.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0433l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10692a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f10693b;

    public RunnableC0433l(s sVar, int i4) {
        this.f10693b = sVar;
        this.f10692a = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10693b.f10713j.smoothScrollToPosition(this.f10692a);
    }
}
