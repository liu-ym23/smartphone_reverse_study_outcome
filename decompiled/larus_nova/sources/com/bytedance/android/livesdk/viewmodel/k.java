package com.bytedance.android.livesdk.viewmodel;

import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements com.bytedance.android.livesdk.chatroom.viewmodel.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.j> f159332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.j> f159333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BehaviorSubject<Integer> f159334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BehaviorSubject f159335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BehaviorSubject f159336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.viewmodel.j f159337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.k> f159338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BehaviorSubject f159339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.k> f159340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BehaviorSubject f159341k;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final com.bytedance.android.livesdk.chatroom.viewmodel.j b() {
        com.bytedance.android.livesdk.chatroom.viewmodel.j r100 = this.f159333c.getValue();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new com.bytedance.android.livesdk.chatroom.viewmodel.j(0, null, 0, false, null, false, 60);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final int getWindowCount() {
        Integer r100 = this.f159334d.getValue();
        if (r100 != null) goto L7;
        return 2;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final void reset() {
        this.f159337g = t();
        e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(0, null, 0, false, null, false, 60));
        c(new com.bytedance.android.livesdk.chatroom.viewmodel.j(0, null, 0, false, null, false, 60));
        f(new com.bytedance.android.livesdk.chatroom.viewmodel.k(0, 0, true, 2));
        g(new com.bytedance.android.livesdk.chatroom.viewmodel.k(0, 0, true, 2));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final com.bytedance.android.livesdk.chatroom.viewmodel.j t() {
        com.bytedance.android.livesdk.chatroom.viewmodel.j r100 = this.f159332b.getValue();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new com.bytedance.android.livesdk.chatroom.viewmodel.j(0, null, 0, false, null, false, 60);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final boolean k() {
        List<Integer> r100 = t().f114799b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.contains(4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final BehaviorSubject a() {
        return this.f159335e;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final BehaviorSubject d() {
        return this.f159341k;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final com.bytedance.android.livesdk.chatroom.viewmodel.j h() {
        return this.f159337g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final BehaviorSubject i() {
        return this.f159339i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final BehaviorSubject j() {
        return this.f159336f;
    }

    public k(DataCenter r110) {
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.j> r111 = BehaviorSubject.createDefault(new com.bytedance.android.livesdk.chatroom.viewmodel.j(0, null, 0, false, null, true, 28));
        this.f159332b = r111;
        this.f159333c = BehaviorSubject.createDefault(new com.bytedance.android.livesdk.chatroom.viewmodel.j(0, null, 0, false, null, false, 60));
        BehaviorSubject<Integer> r100 = BehaviorSubject.createDefault(2);
        this.f159334d = r100;
        this.f159335e = r111;
        this.f159336f = r100;
        BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.k> r112 = BehaviorSubject.createDefault(new com.bytedance.android.livesdk.chatroom.viewmodel.k(0, 0, false, 6));
        this.f159338h = r112;
        this.f159339i = r112;
        BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.k> r113 = BehaviorSubject.createDefault(new com.bytedance.android.livesdk.chatroom.viewmodel.k(0, 0, false, 6));
        this.f159340j = r113;
        this.f159341k = r113;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final void c(com.bytedance.android.livesdk.chatroom.viewmodel.j r110) {
        Intrinsics.checkNotNullParameter(r110, "value");
        BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.j> r100 = this.f159333c;
        com.bytedance.android.livesdk.chatroom.viewmodel.e.f114782a.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodel.e.a.f114783a.contains(Integer.valueOf(r110.f114798a)) == true) goto L6;
        r110 = new com.bytedance.android.livesdk.chatroom.viewmodel.j(0, null, 0, false, null, false, 60);
    L6:
        r100.onNext(r110);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final void e(com.bytedance.android.livesdk.chatroom.viewmodel.j r110) {
        Intrinsics.checkNotNullParameter(r110, "value");
        BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.j> r100 = this.f159332b;
        com.bytedance.android.livesdk.chatroom.viewmodel.e.f114782a.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodel.e.a.f114783a.contains(Integer.valueOf(r110.f114798a)) == true) goto L6;
        r110 = new com.bytedance.android.livesdk.chatroom.viewmodel.j(0, null, 0, false, null, false, 60);
    L6:
        r100.onNext(r110);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final void f(com.bytedance.android.livesdk.chatroom.viewmodel.k r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.k> r101 = this.f159338h;
        com.bytedance.android.livesdk.chatroom.viewmodel.e.f114782a.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodel.e.a.f114783a.contains(Integer.valueOf(r100.f114804a)) == true) goto L6;
        r100 = new com.bytedance.android.livesdk.chatroom.viewmodel.k(0, 0, r100.f114806c, 2);
    L6:
        r101.onNext(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.e
    public final void g(com.bytedance.android.livesdk.chatroom.viewmodel.k r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        BehaviorSubject<com.bytedance.android.livesdk.chatroom.viewmodel.k> r101 = this.f159340j;
        com.bytedance.android.livesdk.chatroom.viewmodel.e.f114782a.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodel.e.a.f114783a.contains(Integer.valueOf(r100.f114804a)) == true) goto L6;
        r100 = new com.bytedance.android.livesdk.chatroom.viewmodel.k(0, 0, r100.f114806c, 2);
    L6:
        r101.onNext(r100);
    }
}
