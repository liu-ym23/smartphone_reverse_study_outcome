package com.bytedance.android.livesdk.chatroom.resolution.tips.stall;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.resolution.tips.TipsScene;
import com.bytedance.android.livesdk.chatroom.ui.ResolutionDowngradeView;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.config.ze;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class VSStallSceneStrategy implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<com.bytedance.android.livesdk.chatroom.resolution.tips.stall.a> f110515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f110516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f110517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f110518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f110519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f110520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RoomContext f110521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f110522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final nv2.f f110523j;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSStallSceneStrategy f110524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f110525b;

        public a(VSStallSceneStrategy r100, Context r101) {
            this.f110524a = r100;
            this.f110525b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r100 = (Long) r110;
            VSStallSceneStrategy r101 = this.f110524a;
            Context r102 = this.f110525b;
            r101.getClass();
            long r103 = System.currentTimeMillis();
            Iterator<com.bytedance.android.livesdk.chatroom.resolution.tips.stall.a> r104 = r101.f110515b.iterator();
            int r105 = 0;
            long r106 = 0;
        L4:
            if (r104.hasNext() == false) goto L9;
            com.bytedance.android.livesdk.chatroom.resolution.tips.stall.a r111 = r104.next();
            if (r111.f110527b <= (r103 - ((long) ze.f121755a.getValue().e()))) goto L7;
            r106 = r106 + (r111.f110527b - r111.f110526a);
            r105 = r105 + 1;
            goto L4
        L7:
            r104.remove();
            goto L4
        L9:
            long r112 = r101.f110518e;
            if (r112 <= 0) goto L12;
            r106 = r106 + (r103 - r112);
            r105 = r105 + 1;
        L12:
            ALogger.d("PlayerTipsLog", "stallQueue.size=" + r101.f110515b.size() + ",stallTime=" + r106);
            ze r107 = ze.f121755a;
            if (r105 <= r107.getValue().b()) goto L16;
            r101.e(r102, r105, (int) r106);
            r101.f110515b.clear();
            r101.f110518e = -1;
            return;
        L16:
            if (r106 <= r107.getValue().a()) goto L26;
            r101.e(r102, r105, (int) r106);
            r101.f110515b.clear();
            r101.f110518e = -1;
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.stall.f
    public final void c() {
        ALogger.d("PlayerTipsLog", "handleStallStart");
        this.f110518e = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.stall.f
    public final void d() {
        Disposable r100 = this.f110516c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f110519f = 0;
        this.f110518e = -1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.stall.f
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Disposable r101 = this.f110516c;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        if (r101.isDisposed() == true) goto L6;
    L7:
        this.f110517d = System.currentTimeMillis();
        this.f110519f = 0;
        this.f110518e = -1;
        return;
    L6:
        this.f110516c = Flowable.interval(5000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onBackpressureDrop().subscribe(new a(this, r100));
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.stall.f
    public final void b(boolean r100) {
        ALogger.d("PlayerTipsLog", "handleStallEnd");
        if (this.f110518e > 0) goto L5;
        return;
    L5:
        long r101 = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.resolution.tips.stall.a r102 = new com.bytedance.android.livesdk.chatroom.resolution.tips.stall.a(this.f110518e, r101);
        this.f110518e = -1;
        this.f110515b.add(r102);
    }

    public VSStallSceneStrategy(DataCenter r100, nv2.f r101) {
        Intrinsics.checkNotNullParameter(r101, "stallTipsConfig");
        this.f110522i = r100;
        this.f110523j = r101;
        this.f110515b = new ConcurrentLinkedQueue();
        this.f110517d = -1;
        this.f110518e = -1;
        this.f110520g = 3000;
    }

    public final void e(Context r110, int r210, int r211) {
        int r100 = this.f110519f;
        ze r101 = ze.f121755a;
        if (r100 < r101.getValue().d()) goto L5;
        return;
    L5:
        RoomContext r102 = this.f110521h;
        long r103 = 0;
        if (r102 != null) goto L8;
        r102 = RoomContext.a.c(RoomContext.Companion, this.f110522i, 0, 2);
    L8:
        this.f110521h = r102;
        DataCenter r104 = this.f110522i;
        if (r104 == null) goto L11;
        final Room r105 = (Room) r104.get("data_room", null);
    L12:
        ALogger.d("PlayerTipsLog", "showResolutionDowngradeTip");
        int r106 = g.f110545c;
        if (g.a.a(this.f110522i, true, this.f110523j.c()) == TipsScene.VS) goto L15;
        return;
    L15:
        ArrayList<LiveCoreSDKData.Quality> r107 = AudienceVideoResolutionManager.f110412b;
        int r108 = CollectionsKt.indexOf(r107, AudienceVideoResolutionManager.c());
        int r109 = r107.size() - 1;
        if (r108 < 0) goto L20;
        if (r109 <= r108) goto L20;
        final LiveCoreSDKData.Quality r111 = (LiveCoreSDKData.Quality) ListProtector.get(r107, r108 + 1);
    L21:
        if (r111 != null) goto L23;
        return;
    L23:
        final String r112 = r111.getName();
        String r113 = r111.getSubName();
        if (r113 != null) goto L26;
    L29:
        boolean r114 = true;
    L30:
        if (r114 == false) goto L32;
        final String r115 = r112;
    L33:
        ResolutionDowngradeView r116 = new ResolutionDowngradeView(r110);
        r116.setResolutionText(r115);
        r116.setOnSelectResolutionDowngrade(new VSStallSceneStrategy$showResolutionDowngradeTip$$inlined$apply$lambda$1(this, r115, r112, r111, r105));
        if (r116.getParent() == null) goto L36;
        r116.removeView(r116);
    L36:
        this.f110519f++;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r117 = ((IVSPlayerService) k.n(IVSPlayerService.class)).provideVSPlayerTipService(this.f110522i);
        if (r117 == null) goto L39;
        r117.showPlayerTipWithCustomView("resolution_downgrade", r116);
    L39:
        r116.postDelayed(new h(this), this.f110520g);
        if (r101.getValue().e() > 0) goto L43;
        return;
    L43:
        if (this.f110517d <= 0) goto L46;
        r103 = System.currentTimeMillis() - this.f110517d;
    L46:
        float r118 = r211 / r101.getValue().e();
        d.b(AudienceVideoResolutionManager.f110413c, r112, r210, r211, r118, r103);
        return;
    L32:
        r115 = r112 + ' ' + r113;
        goto L33
    L26:
        if (r113.length() == 0) goto L29;
        r114 = false;
    L20:
        r111 = null;
        goto L21
    L11:
        r105 = null;
        goto L12
    }
}
