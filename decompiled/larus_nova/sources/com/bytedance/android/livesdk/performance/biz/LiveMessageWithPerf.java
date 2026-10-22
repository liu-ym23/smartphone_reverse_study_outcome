package com.bytedance.android.livesdk.performance.biz;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.performance.degrade.LiveDegradeConfigHelper;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import l61.d;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveMessageWithPerf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f154473c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f154474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f154475b;

    public static final class a {
    }

    static {
        f154473c = "1";
    }

    public LiveMessageWithPerf() {
        this.f154474a = new CompositeDisposable();
        this.f154475b = LiveDegradeConfigHelper.a().enablePerfMessage;
    }

    public final void b(RoomContext r100) {
        boolean r101 = this.f154475b;
        if (r101 == true) goto L5;
        return;
    L5:
        if (r101 == false) goto L17;
        ILiveExpOptService r102 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        if (r102 == null) goto L12;
        Disposable r103 = r102.registerExpBizListener(d.a.d1.f507608e, new com.bytedance.android.livesdk.performance.biz.a(this));
        if (r103 == null) goto L12;
        RxUtilKt.c(r103, this.f154474a);
    L12:
        ILiveExpOptService r104 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        if (r104 == null) goto L17;
        Disposable r105 = r104.registerExpBizListener(d.a.i1.f507623e, new b(this));
        if (r105 == null) goto L17;
        RxUtilKt.c(r105, this.f154474a);
    L17:
        if (r100 == null) goto L22;
        j<vlc.d> r106 = r100.getMessageManager();
        if (r106 == null) goto L23;
        r106.c(LiveMessageWithPerf$enterRoomNotify$1.INSTANCE);
        return;
    L23:
        return;
    }

    public static final void a(LiveMessageWithPerf r100, String r101) {
        r100.getClass();
        f154473c = r101;
        vlc.d r102 = n3.b();
        if (r102 == null) goto L6;
        d4.j(r102, MapsKt.mapOf(TuplesKt.to("PL", f154473c)));
        return;
    }
}
