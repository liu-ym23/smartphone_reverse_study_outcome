package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.config.fh;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements com.bytedance.android.scope.o, f00.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f105508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f105509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PropertyOwner<Boolean> f105510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PropertyOwner<Boolean> f105511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner<LiveMode> f105512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f105513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f105514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final nz.j f105515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g00.b f105516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i00.a f105517j;

    public final LiveMode a() {
        return this.f105512e.f64752a;
    }

    @Override // f00.f
    public final boolean aO() {
        return this.f105511d.f64752a.booleanValue();
    }

    @Override // f00.f
    public final void hA() {
        this.f105511d.a(Boolean.TRUE);
    }

    @Override // f00.f
    public final Observable<Boolean> iK() {
        PropertyOwner<Boolean> r100 = this.f105510c;
        r100.getClass();
        return r100.startWith(Boolean.valueOf(this.f105509b));
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ALogger.i("BroadcastInLiveInstanceScope", "BroadcastRoomStatusService start");
        i00.a r100 = this.f105517j;
        r100.d(f00.f.class, r100.getScope());
        boolean r101 = this.f105513f.a().f105433f;
        this.f105509b = r101;
        this.f105510c.a(Boolean.valueOf(r101));
        int r102 = this.f105513f.a().a();
        this.f105512e.a(this.f105513f.a().f105437j);
        if (r102 == 0) goto L6;
        this.f105509b = false;
        return;
    L6:
        if (this.f105509b == false) goto L12;
        Room r103 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r103 == null) goto L13;
        Z10(r103);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Room r100 = this.f105508a;
        if (r100 == null) goto L8;
        IExternalFunctionInjector r101 = (IExternalFunctionInjector) jc1.k.f(IExternalFunctionInjector.class);
        if (r101 == null) goto L9;
        r101.clearLiveRoomController(r100.getIdStr(), 0);
        return;
    L9:
        return;
    }

    @Override // f00.f
    public final Room getRoom() {
        return this.f105508a;
    }

    @Override // f00.f
    public final void Z10(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        this.f105508a = r100;
        this.f105509b = true;
        this.f105510c.a(Boolean.TRUE);
        IRoomService r101 = (IRoomService) jc1.k.n(IRoomService.class);
        r101.setCurrentRoom(this.f105508a);
        r101.setStreamerRoom(this.f105508a);
        this.f105517j.g(fg1.k.g.f476803a);
        i r102 = this.f105514g;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "room");
        ALogger.i("BroadcastInLiveInstanceScope", "BroadcastShellRoomStateService onRoomReady");
        r102.f105519b.d(r100);
        if (fh.f120202a.getValue().booleanValue() == false) goto L6;
        this.f105515h.c();
    L6:
        if (ms1.h.a() == false) goto L9;
        this.f105516i.clear();
        return;
    }

    public h(d r100, i r101, nz.j r102, g00.b r103, i00.a r104) {
        Intrinsics.checkNotNullParameter(r100, "env");
        Intrinsics.checkNotNullParameter(r101, "roomDispatcher");
        Intrinsics.checkNotNullParameter(r102, "keyNodeService");
        Intrinsics.checkNotNullParameter(r103, "globalLastRoomDataService");
        Intrinsics.checkNotNullParameter(r104, "instance");
        this.f105513f = r100;
        this.f105514g = r101;
        this.f105515h = r102;
        this.f105516i = r103;
        this.f105517j = r104;
        Boolean r105 = Boolean.FALSE;
        this.f105510c = new PropertyOwner(r105);
        this.f105511d = new PropertyOwner(r105);
        this.f105512e = new PropertyOwner(LiveMode.UNDEFINED);
    }
}
