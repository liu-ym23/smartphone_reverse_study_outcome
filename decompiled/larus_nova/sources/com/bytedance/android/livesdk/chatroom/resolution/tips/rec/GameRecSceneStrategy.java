package com.bytedance.android.livesdk.chatroom.resolution.tips.rec;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.resolution.AutoResolutionManager;
import com.bytedance.android.livesdk.config.ge1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.texturerender.TextureRenderKeys;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class GameRecSceneStrategy implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f110500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nv2.e f110501c;

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.rec.d
    public final void D() {
        Disposable r100 = this.f110500b;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final void e() {
        int r100 = AudienceVideoResolutionManager.f110411a;
        boolean r101 = false;
        if (AudienceVideoResolutionManager.f110433w == null) goto L5;
        boolean r102 = AutoResolutionManager.e();
    L6:
        boolean r103 = AudienceVideoResolutionManager.o();
        ALogger.d("PlayerTipsLog", "GameRecSceneStrategy showTips hasAuto " + r102 + " isAutoOn " + r103);
        if (r102 == false) goto L25;
        if (r103 == true) goto L26;
        String r104 = this.f110501c.a();
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.length() <= 0) goto L14;
        r101 = true;
    L14:
        if (r101 != true) goto L28;
        String r105 = this.f110501c.a();
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        boolean r106 = nv2.b.c(new ge1(1, 2, r105, "切换", true, new GameRecSceneStrategy$showTips$playerTips$1(this), new GameRecSceneStrategy$showTips$playerTips$2(this)));
        ALogger.d("PlayerTipsLog", "GameRecSceneStrategy post res:" + r106);
        if (r106 == false) goto L29;
        d("livesdk_resolution_toast_show");
        long r107 = this.f110501c.b();
        Disposable r108 = this.f110500b;
        if (r108 == null) goto L23;
        r108.dispose();
    L23:
        this.f110500b = Observable.timer(r107, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    L29:
        return;
    L28:
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public GameRecSceneStrategy(nv2.e r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f110501c = r100;
    }

    public static final void c(GameRecSceneStrategy r100) {
        r100.getClass();
        ALogger.d("PlayerTipsLog", "GameRecSceneStrategy hideTips");
        nv2.b.c(new ge1(2, 0, 126));
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.rec.d
    public final void b(NetworkUtils.NetworkType r100) {
        Intrinsics.checkNotNullParameter(r100, "networkType");
        ALogger.d("PlayerTipsLog", "GameRecSceneStrategy onNetworkChanged");
        if (this.f110501c.getType() == 1) goto L5;
        return;
    L5:
        if (CollectionsKt.listOf(new NetworkUtils.NetworkType[]{NetworkUtils.NetworkType.MOBILE, NetworkUtils.NetworkType.MOBILE_2G, NetworkUtils.NetworkType.MOBILE_3G, NetworkUtils.NetworkType.MOBILE_4G, NetworkUtils.NetworkType.MOBILE_5G}).contains(r100) == false) goto L9;
        ALogger.d("PlayerTipsLog", "GameRecSceneStrategy onNetworkChanged on mobile");
        e();
        return;
    }

    public final void d(String r100) {
        Pair[] r101 = new Pair[2];
        if (this.f110501c.getType() != 1) goto L5;
        Object r102 = "notwifi";
    L6:
        r101[0] = TuplesKt.to("type", String.valueOf(r102));
        IUserService r103 = (IUserService) k.f(IUserService.class);
        if (r103 == null) goto L13;
        f r104 = r103.user();
        if (r104 == null) goto L13;
        IUser r105 = r104.b();
        if (r105 == null) goto L13;
        String r106 = r105.getIdString();
    L14:
        r101[1] = TuplesKt.to("user_id", r106);
        Map<String, String> r107 = MapsKt.mapOf(r101);
        u.l().sendLog(r100, r107, new Object[]{Room.class});
        return;
    L13:
        r106 = null;
        goto L14
    L5:
        r102 = Integer.valueOf(this.f110501c.getType());
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.rec.d
    public final void a(Context r100, TokenCert r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        ALogger.d("PlayerTipsLog", "GameRecSceneStrategy isMobile:" + NetworkUtils.d(r100, r101));
        if (this.f110501c.getType() == 1) goto L5;
    L8:
        e();
        return;
    L5:
        if (NetworkUtils.d(r100, r101) == false) goto L8;
        e();
    }
}
