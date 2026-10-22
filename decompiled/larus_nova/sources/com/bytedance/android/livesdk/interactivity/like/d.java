package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements u32.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f137653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f137654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.like.api.a f137655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f137656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f137657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f137658f;

    public static final class a {
    }

    static {
    }

    @Override // u32.j
    public final void dispose() {
        Disposable r100 = this.f137653a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Long r101 = null;
        this.f137653a = null;
        if (this.f137654b <= 0) goto L23;
        ALogger.i("DiggHandler", "postRemainingDiggCount, current diggCount: " + this.f137654b);
        DiggApi r102 = (DiggApi) com.bytedance.android.live.network.c.b().e(DiggApi.class);
        long r103 = this.f137656d;
        int r104 = this.f137654b;
        nm1.m r105 = pm1.f.l();
        long r106 = 0;
        if (r105 == null) goto L21;
        RoomContext.a r107 = RoomContext.Companion;
        RoomContext r110 = RoomContext.a.c(r107, null, 0, 3);
        if (r110 == null) goto L14;
        com.bytedance.live.datacontext.m<Room> r111 = r110.getRoom();
        if (r111 == null) goto L14;
        Room r112 = r111.getValue();
    L15:
        RoomContext r108 = RoomContext.a.c(r107, null, 0, 3);
        if (r108 == null) goto L20;
        com.bytedance.live.datacontext.m<Long> r109 = r108.getCameraId();
        if (r109 == null) goto L20;
        r101 = r109.getValue();
    L20:
        r106 = r105.k(r112, r101);
    L14:
        r112 = null;
    L21:
        DiggApi.a.a(r102, r103, r104, r106, "linkmic_guest_like", this.f137657e, 32).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this));
        return;
    }

    @Override // u32.j
    public final void onDiggButtonClick() {
        if (this.f137655c != null) goto L5;
        this.f137655c = (com.bytedance.android.livesdk.interactivity.like.api.a) JsonUtil.parse(this.f137658f, com.bytedance.android.livesdk.interactivity.like.api.a.class);
    L5:
        this.f137654b++;
        ALogger.i("DiggHandler", "onDiggButtonClick, current diggCount: " + this.f137654b);
        Disposable r100 = this.f137653a;
        if (r100 != null) goto L8;
    L10:
        this.f137653a = Observable.interval(2, 2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).filter(new g(this)).map(new h(this)).observeOn(Schedulers.io()).flatMap(new i(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), new k(this));
        return;
    L8:
        if (r100.isDisposed() == true) goto L10;
    }

    @Override // u32.j
    public final void a(DataCenter r100) {
        if (r100 == null) goto L5;
        Room r101 = com.bytedance.android.live.core.utils.z.o(r100);
    L6:
        int r102 = 0;
        if (r100 == null) goto L9;
        boolean r103 = com.bytedance.android.live.core.utils.z.e(r100, false);
    L10:
        if (r100 == null) goto L29;
        int r104 = com.bytedance.android.livesdk.interactivity.like.utils.b.f137723a;
        boolean r105 = ((Boolean) r100.get("data_is_portrait", Boolean.FALSE)).booleanValue();
        if (((IUserService) jc1.k.n(IUserService.class)).user().isLogin() == true) goto L14;
        r102 = 1;
    L27:
        InteractivityMonitor.c(InteractivityMonitor.Event.ProfileDiggDisable, r101, Integer.valueOf(r102), null, 24);
        return;
    L14:
        if (r101 == null) goto L21;
        RoomAuthStatus r106 = r101.getRoomAuthStatus();
        if (r106 == null) goto L21;
        if (r106.getEnableDigg() == true) goto L21;
        r102 = 2;
    L21:
        if (l42.a.f507320g.getValue().booleanValue() == false) goto L23;
    L24:
        if (r105 == true) goto L27;
        if (r103 == true) goto L27;
        r102 = 4;
        goto L27
    L23:
        if (com.bytedance.android.livesdk.sharedpref.b.G0.getValue().booleanValue() == false) goto L27;
    L29:
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public d(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "diggTargetUid");
        this.f137656d = r100;
        this.f137657e = r101;
        this.f137658f = r102;
    }
}
