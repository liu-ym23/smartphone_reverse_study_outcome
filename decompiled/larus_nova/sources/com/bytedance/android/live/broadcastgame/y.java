package com.bytedance.android.live.broadcastgame;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class y implements com.bytedance.android.live.broadcastgame.api.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<AudienceGameWidget> f62491a;

    public y() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final void a() {
        WeakReference<AudienceGameWidget> r100 = this.f62491a;
        if (r100 == null) goto L10;
        AudienceGameWidget r101 = r100.get();
        if (r101 == null) goto L11;
        com.bytedance.android.live.broadcastgame.api.openplatform.b r102 = r101.f59227a;
        if (r102 == null) goto L12;
        r102.k();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final void b() {
        WeakReference<AudienceGameWidget> r100 = this.f62491a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L9;
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.openplatform.f("from_toolbar"));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final String getGameCategory() {
        WeakReference<AudienceGameWidget> r100 = this.f62491a;
        if (r100 == null) goto L13;
        AudienceGameWidget r101 = r100.get();
        if (r101 == null) goto L14;
        com.bytedance.android.live.broadcastgame.api.openplatform.b r102 = r101.f59227a;
        if (r102 == null) goto L15;
        String r103 = r102.getGameCategory();
        if (r103 != null) goto L12;
        return "";
    L12:
        return r103;
    L15:
        return "";
    L14:
        return "";
    L13:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final AudienceGameWidget getAudienceGameWidget(boolean r100) {
        AudienceGameWidget r101 = new AudienceGameWidget(r100);
        this.f62491a = new WeakReference(r101);
        return r101;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final void onSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "seiMsg");
        WeakReference<AudienceGameWidget> r101 = this.f62491a;
        if (r101 == null) goto L10;
        AudienceGameWidget r102 = r101.get();
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "seiMsg");
        com.bytedance.android.live.broadcastgame.api.openplatform.b r103 = r102.f59227a;
        if (r103 == null) goto L12;
        r103.j(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final void stopRunningPlugin(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        WeakReference<AudienceGameWidget> r101 = this.f62491a;
        if (r101 == null) goto L11;
        AudienceGameWidget r102 = r101.get();
        if (r102 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.bytedance.android.live.broadcastgame.api.openplatform.b r103 = r102.f59227a;
        if (r103 == null) goto L9;
        r103.b(r100);
    L9:
        com.bytedance.android.live.broadcastgame.api.xplay.n.f59498b.e(r100);
        return;
    L12:
        return;
    }
}
