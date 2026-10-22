package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: classes9.dex */
public final class f1 implements a32.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f134870d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f134871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u22.k f134872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SingleSubject<u22.k> f134873c;

    public static final class a {
    }

    static {
    }

    @Override // a32.a
    public final void destroy() {
        this.f134872b = null;
        this.f134873c = null;
        this.f134871a.clear();
    }

    @Override // a32.a
    public final SingleSubject a() {
        if (this.f134873c != null) goto L5;
        this.f134873c = SingleSubject.create();
    L5:
        SingleSubject<u22.k> r100 = this.f134873c;
        if (r100 == null) goto L9;
        return r100;
    L9:
        return SingleSubject.create();
    }

    @Override // a32.a
    public final void b() {
        ALogger.i("ToolbarAndCommentShowCtrlManager", "notifyToolbarReady");
        u22.k r100 = d();
        if (r100 == null) goto L5;
        r100.f548427a = true;
    L5:
        e();
    }

    @Override // a32.a
    public final void c() {
        ALogger.i("ToolbarAndCommentShowCtrlManager", "notifyCommentReady");
        u22.k r100 = d();
        if (r100 == null) goto L5;
        r100.f548428b = true;
    L5:
        e();
    }

    public final u22.k d() {
        if (this.f134872b != null) goto L6;
        this.f134872b = new u22.k(0);
    L6:
        return this.f134872b;
    }

    public f1() {
        this.f134871a = new CompositeDisposable();
    }

    public final void e() {
        u22.k r100 = d();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f548427a == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 != true) goto L19;
        ALogger.i("ToolbarAndCommentShowCtrlManager", "notifyWidgetReady isAllReady");
        if (this.f134873c != null) goto L14;
        this.f134873c = SingleSubject.create();
    L14:
        SingleSubject<u22.k> r102 = this.f134873c;
        if (r102 == null) goto L20;
        r102.onSuccess(r100);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        if (r100.f548428b == false) goto L9;
        r101 = true;
        goto L10
    }
}
