package com.bytedance.android.live.xplay.basic;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.live.xplay.basic.log.XplayLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.bytedance.android.live.broadcastgame.api.xplay.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f102845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f102846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final XplayGuestType f102847c;

    public static final class a {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final String getAppId() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final String getGameName() {
        return null;
    }

    static {
        e33.l[] r100 = x13.a.f562118a;
        com.bytedance.android.scope.m r101 = com.bytedance.android.scope.m.f163449e;
        x13.a r102 = x13.a.f562119b;
        r101.getClass();
        com.bytedance.android.scope.m.e(r102);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final void stop() {
        int r100 = XplayLog.f102848a;
        XplayLog.c("XplayInstance", "xplayDestroy, xplayScope=" + this.f102846b);
        Set<g10.b> r101 = i.f102838a;
        Intrinsics.checkNotNullParameter(this, "instance");
        XplayLog.a("XplayExtensionManager", "dispatch instance destroy: " + this);
        Iterator<T> r102 = i.f102838a.iterator();
    L3:
        g10.b r103 = null;
        if (r102.hasNext() == false) goto L12;
        g10.b r104 = (g10.b) r102.next();
        if ((r104 instanceof g10.d) == false) goto L9;
        r103 = r104;
    L9:
        g10.d r105 = (g10.d) r103;
        if (r105 == null) goto L3;
        r105.d(this);
        goto L3
    L12:
        u r106 = this.f102846b;
        if (r106 == null) goto L15;
        com.bytedance.android.scope.l.c(r106);
    L15:
        LinkedHashSet<com.bytedance.android.live.broadcastgame.api.xplay.f> r107 = b.f102774a;
        Intrinsics.checkNotNullParameter(this, "instance");
        b.f102774a.remove(this);
        this.f102846b = null;
        this.f102845a.clear();
    }

    public k() {
        this.f102845a = new CompositeDisposable();
        this.f102847c = XplayGuestType.DEFAULT;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final XplayGuestType a() {
        return this.f102847c;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        u r101 = this.f102846b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) com.bytedance.android.scope.m.f163449e.d(r101, r100);
    }
}
