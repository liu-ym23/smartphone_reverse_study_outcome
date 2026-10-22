package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.e;

/* JADX INFO: loaded from: classes.dex */
public class a extends n4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f7143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f7144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IRequest.Priority f7145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f7146h;

    public a(String r10, IRequest.Priority r11, int r12, Runnable r13, boolean r14) {
        this.f7145g = r11;
        if (e.b(r10) == false) goto L5;
        r10 = getClass().getSimpleName();
    L5:
        this.f22388c = r12;
        this.f7146h = r10;
        this.f7144f = r13;
        this.f7143e = r14;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return f((IRequest) r10);
    }

    @Override // n4.a
    public /* bridge */ /* synthetic */ n4.a e(int r10) {
        return g(r10);
    }

    public int f(IRequest r10) {
        IRequest.Priority r11 = getPriority();
        IRequest.Priority r12 = r10.getPriority();
        if (r11 != null) goto L5;
        r11 = IRequest.Priority.NORMAL;
    L5:
        if (r12 != null) goto L7;
        r12 = IRequest.Priority.NORMAL;
    L7:
        if (r11 != r12) goto L10;
        int r13 = getSequence();
        int r14 = r10.getSequence();
    L11:
        return r13 - r14;
    L10:
        r13 = r12.ordinal();
        r14 = r11.ordinal();
        goto L11
    }

    public a g(int r10) {
        this.f22389d = r10;
        return this;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public IRequest.Priority getPriority() {
        return this.f7145g;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public int getSequence() {
        return this.f22389d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7144f != null) goto L5;
        return;
    L5:
        if (b() == true) goto L9;
        this.f7144f.run();
        return;
    }
}
