package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveMkStallManager$stop$1 implements IStallCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMkStallManager f110651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f110652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f110653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f110654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f110655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f110656f;

    @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
    public final void onBlockReady(long r100, int r101, long r102) {
    }

    @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
    public final void onFpsReady(double r110, JSONObject r111) {
        long r100 = System.currentTimeMillis();
        LiveMkStallManager r101 = this.f110651a;
        final long r102 = r100 - r101.f110643d;
        Map<String, Long> r103 = r101.f110644e.c();
        r101.f110687b.setupPrefDataForStop(r110, r111, r103, r102);
        LiveMkStallManager r112 = this.f110651a;
        r112.f110643d = 0;
        if (this.f110652b == true) goto L7;
        r112.f110686a = false;
        Function0 r113 = this.f110653c;
        if (r113 == null) goto L7;
        Unit r114 = (Unit) r113.invoke();
    L7:
        UtilityKotlinExtentionsKt.s(0, false, false, new LiveMkStallManager$stop$1$onFpsReady$1(this, r102), 7);
    }

    public LiveMkStallManager$stop$1(LiveMkStallManager r100, boolean r101, Function0 r102, long r103, String r104, String r105) {
        this.f110651a = r100;
        this.f110652b = r101;
        this.f110653c = r102;
        this.f110654d = r103;
        this.f110655e = r104;
        this.f110656f = r105;
    }
}
