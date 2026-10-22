package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class x extends r22.a<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> f134022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f134023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f134024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> f134025f;

    public static final class a {
    }

    static {
    }

    @Override // r22.a
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.d j() {
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) ((LinkedList) this.f134022c).pollFirst();
    }

    @Override // r22.a
    public final r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> f() {
        return this.f134025f;
    }

    @Override // r22.a
    public final Queue<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> h() {
        return this.f134022c;
    }

    public x(LandscapeDanmakuPresenterV2.p r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
        super(r100);
        this.f134025f = r100;
        this.f134022c = new LinkedList();
    }

    @Override // r22.a
    public final void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "danmaku");
        if (((LinkedList) this.f134022c).size() < 20) goto L5;
        ((LinkedList) this.f134022c).removeFirst();
    L5:
        ((LinkedList) this.f134022c).add(r101);
        k();
    }

    @Override // r22.a
    public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100, r22.a.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r101) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "notifier");
        IBaseUser r103 = r102.getUserInfo();
        String r104 = null;
        if (r103 == null) goto L5;
        py.k r105 = r103.getAvatarThumbKt();
    L6:
        if (r105 != null) goto L8;
        r101.a(r102);
        return;
    L8:
        IBaseUser r106 = r102.getUserInfo();
        if (r106 == null) goto L14;
        py.c r107 = r106.getMAuthenticationInfo();
        if (r107 == null) goto L14;
        r104 = r107.getCustomVerify();
    L14:
        if (TextUtils.isEmpty(r104) == true) goto L22;
        IBaseUser r108 = r102.getUserInfo();
        if (r108 == null) goto L23;
        py.c r109 = r108.getMAuthenticationInfo();
        if (r109 == null) goto L23;
        py.k r110 = r109.getAuthenticationBadge();
        if (r110 == null) goto L23;
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r110, new y(this, r102, r101));
    L23:
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r105, new z(this, r102, r101));
        return;
    L22:
        this.f134024e = true;
        goto L23
    L5:
        r105 = null;
        goto L6
    }
}
