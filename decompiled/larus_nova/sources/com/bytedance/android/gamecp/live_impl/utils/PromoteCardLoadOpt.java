package com.bytedance.android.gamecp.live_impl.utils;

import android.os.SystemClock;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceRequestType;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class PromoteCardLoadOpt {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<String, PromoteCardLoadOpt> f58055i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f58056j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f58057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f58058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f58059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.gamecp.host_api.model.introducecard.g f58060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f58061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f58062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f58063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Function3<? super com.bytedance.android.gamecp.host_api.model.introducecard.g, ? super Boolean, ? super Pair<Long, Long>, Unit> f58064h;

    public static final class a {
        public a() {
        }
    }

    static {
        f58056j = new a();
        f58055i = new ConcurrentHashMap();
    }

    public PromoteCardLoadOpt() {
        this.f58059c = new CompositeDisposable();
        this.f58061e = Boolean.FALSE;
        this.f58062f = -1;
        this.f58063g = -1;
    }

    public final Pair<Boolean, String> a(final String r100, final Function3<? super com.bytedance.android.gamecp.host_api.model.introducecard.g, ? super Boolean, ? super Pair<Long, Long>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (UtilsKt.c(r100) == false) goto L19;
        PromoteCardLoadOpt r102 = f58055i.get(r100);
        if (r102 != null) goto L7;
        yr.b.b(6, "game-promote-backend", " not find value for the key,roomId=" + r100);
        return new Pair(Boolean.FALSE, "map_value_empty");
    L7:
        if (r102.f58057a == false) goto L10;
        r102.f58064h = new PromoteCardLoadOpt$getCachedGameIntroduceCard$$inlined$let$lambda$1(this, r101, r100);
        return new Pair(Boolean.TRUE, "loading");
    L10:
        if (r102.f58058b == false) goto L15;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r103 = r102.f58060d;
        if (r103 == null) goto L14;
        Intrinsics.checkNotNull(r103);
        Boolean r104 = Boolean.TRUE;
        r101.invoke(r103, r104, new Pair(Long.valueOf(r102.f58062f), Long.valueOf(r102.f58063g)));
        return new Pair(r104, "cache_valid");
    L14:
        Boolean r105 = this.f58061e;
        Boolean r106 = Boolean.TRUE;
        r101.invoke(null, Boolean.valueOf(Intrinsics.areEqual(r105, r106)), new Pair(Long.valueOf(r102.f58062f), Long.valueOf(r102.f58063g)));
        return new Pair(r106, "cache_invalid");
    L15:
        yr.b.b(6, "game-promote-backend", "roomId=" + r100 + ", loading=false and cache not available.");
        return new Pair(Boolean.FALSE, "cache_status_exception");
    L19:
        yr.b.b(6, "game-promote-backend", "roomId=" + r100 + "  is empty or null.");
        return new Pair(Boolean.FALSE, "room_id_empty");
    }

    public final void b(String r110, String r111, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r111, "anchorId");
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "gameId");
        Intrinsics.checkNotNullParameter(r212, "uniqueKey");
        if (this.f58057a == false) goto L5;
    L9:
        yr.b.b(4, "game-promote-backend", "roomEnterPreload  is loading, return." + this.f58057a + " and " + this.f58058b + ' ');
        return;
    L5:
        if (this.f58058b == true) goto L9;
        yr.b.b(4, "game-promote-backend", "roomEnterPreload  start request roomId=" + r110 + ",enterFrom=" + r210);
        this.f58057a = true;
        this.f58062f = SystemClock.elapsedRealtime();
        int r100 = IntroduceCardDataUtils.f58020a;
        IntroduceCardDataUtils.e(r110, r111, r211, r212, 0, IntroduceRequestType.MANUAL.getType(), "", false, new PromoteCardLoadOpt$roomEnterPreload$1(this), new PromoteCardLoadOpt$roomEnterPreload$2(this), ILiveRoomControllerProvider.ProviderSource.DEFAULT, this.f58059c);
    }
}
