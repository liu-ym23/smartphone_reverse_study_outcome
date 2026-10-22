package com.bytedance.android.live.room.navi.userinfo_p.element;

import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserInfoFlipTabElement f99899a;

    public e(UserInfoFlipTabElement r100) {
        this.f99899a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IFollowPair r101 = (IFollowPair) r100;
        if (this.f99899a.f99855d == null) goto L16;
        if (r101 != null) goto L6;
    L7:
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.getFollowStatus() != 0) goto L19;
        com.bytedance.android.livesdk.interactivity.api.base.b.a r102 = com.bytedance.android.livesdk.interactivity.api.base.b.f132890m;
        q r103 = q.f133747a;
        r102.getClass();
        com.bytedance.android.livesdk.interactivity.api.base.b.a.f();
        return;
    L19:
        return;
    L9:
        if (r101.getFollowStatus() != 2) goto L11;
    L10:
        com.bytedance.android.livesdk.interactivity.api.base.b.a r104 = com.bytedance.android.livesdk.interactivity.api.base.b.f132890m;
        q r105 = q.f133747a;
        r104.getClass();
        com.bytedance.android.livesdk.interactivity.api.base.b.a.b();
        return;
    L6:
        if (r101.getFollowStatus() == 1) goto L10;
    }
}
