package com.bytedance.android.livesdk.player.newstrategy;

import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Disposable f155931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Disposable f155932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f155933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f155934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f155935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile long f155936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile int f155937g;

    static {
        f155934d = "";
    }

    public static boolean a() {
        Room r100 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r100 == null) goto L6;
        String r101 = r100.getOwnerUserIdString();
        if (r101 == null) goto L6;
    L7:
        String r102 = ((IUserService) jc1.k.n(IUserService.class)).user().n();
        o0.f58946a.getClass();
        return o0.a.a(r101, r102);
    L6:
        r101 = "0";
        goto L7
    }
}
