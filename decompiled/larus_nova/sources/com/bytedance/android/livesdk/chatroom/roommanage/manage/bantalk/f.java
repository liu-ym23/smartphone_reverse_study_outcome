package com.bytedance.android.livesdk.chatroom.roommanage.manage.bantalk;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.api.BanTalkApi;
import com.bytedance.android.livesdk.kickout.api.BannedApiV2;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdk.widget.x1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.Items;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BanTalkApi f111426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BannedApiV2 f111427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f111428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f111429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f111430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f111431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f111432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f111433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f111434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f111435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.roommanage.manage.bantalk.a f111436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Room f111437l;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f111438a;

        public a(f r100) {
            this.f111438a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            dd2.a r101 = (dd2.a) r100;
            f r102 = this.f111438a;
            r102.f111430e = false;
            r102.f111436k.setLoadingMore(false);
            dd2.b r103 = (dd2.b) r101.extra;
            if (r103 == null) goto L6;
            List<dd2.e> r104 = r103.opStructList;
            if (r104 == null) goto L6;
        L7:
            f r105 = this.f111438a;
            dd2.b r106 = (dd2.b) r101.extra;
            if (r106 == null) goto L10;
            int r107 = r106.total;
        L11:
            r105.f111434i = r107;
            if (r106 == null) goto L14;
            int r108 = r106.maxCount;
        L15:
            r105.f111435j = r108;
            r105.f111436k.setLoadingViewShow(false);
            f r109 = this.f111438a;
            r109.f111436k.b(r109.f111434i, r109.f111435j);
            f r110 = this.f111438a;
            if (r110.f111434i != 0) goto L18;
            r110.f111436k.setEmptyViewShow(true);
            return;
        L18:
            Items r111 = new Items();
            r111.addAll(r104);
            this.f111438a.f111431f++;
            dd2.b r112 = (dd2.b) r101.extra;
            if (r112 != null) goto L21;
        L22:
            r111.add(new com.bytedance.android.livesdk.chatroom.roommanage.common.e());
        L23:
            this.f111438a.f111436k.setEmptyViewShow(false);
            this.f111438a.f111436k.setList(r111);
            f r113 = this.f111438a;
            R r114 = r101.extra;
            if (r114 == 0) goto L28;
            r113.getClass();
            if (r114.hasMore != true) goto L28;
            r113.f111436k.d();
            return;
        L28:
            r113.f111436k.e();
            return;
        L21:
            if (r112.hasMore == true) goto L23;
        L14:
            r108 = 0;
            goto L15
        L10:
            r107 = 0;
        L6:
            r104 = CollectionsKt.emptyList();
            goto L7
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f111439a;

        public b(f r100) {
            this.f111439a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            f2.b(R.string.ttlive_network_error, 0);
            this.f111439a.f111436k.setErrorViewShow(true);
        }
    }

    @Override // com.bytedance.android.livesdk.widget.x1
    public final int a() {
        return 1;
    }

    public final void b() {
        Room r100 = this.f111437l;
        if (r100 == null) goto L9;
        long r101 = r100.f162599id;
        Disposable r102 = this.f111428c;
        if (r102 == null) goto L7;
        r102.dispose();
    L7:
        this.f111436k.setLoadingViewShow(true);
        this.f111428c = this.f111427b.getBannedTalkList2(r101, this.f111432g, this.f111431f, o.a(((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().b())).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        return;
    }

    public final boolean c() {
        Room r100 = this.f111437l;
        if (r100 == null) goto L18;
        String r101 = r100.getOwnerUserIdString();
        if (r101 == null) goto L18;
        com.bytedance.android.livesdk.service.h r102 = TTLiveSDKContext.getHostService();
        if (r102 == null) goto L18;
        com.bytedance.android.livesdk.user.f r103 = ((com.bytedance.android.livesdk.service.f) r102).h();
        if (r103 == null) goto L18;
        IUser r104 = r103.b();
        if (r104 == null) goto L18;
        String r105 = r104.getIdString();
        if (r105 == null) goto L18;
        return Intrinsics.areEqual(r101, r105);
    L18:
        return false;
    }

    @Override // com.bytedance.android.livesdk.widget.x1
    public final void onLoadMore() {
        Room r100 = this.f111437l;
        if (r100 == null) goto L8;
        long r101 = r100.f162599id;
        Disposable r102 = this.f111428c;
        if (r102 == null) goto L7;
        r102.dispose();
    L7:
        this.f111428c = this.f111427b.getBannedTalkList2(r101, this.f111432g, this.f111431f, o.a(((f0) ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h()).f158651a)).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this), new h(this));
    L8:
        this.f111430e = true;
        this.f111436k.setLoadingMore(true);
    }

    @Override // com.bytedance.android.livesdk.widget.x1
    public final boolean isLoading() {
        return this.f111430e;
    }

    public f(com.bytedance.android.livesdk.chatroom.roommanage.manage.bantalk.a r100, Room r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f111436k = r100;
        this.f111437l = r101;
        l.d().getClass();
        this.f111426a = (BanTalkApi) com.bytedance.android.live.network.c.b().e(BanTalkApi.class);
        l.d().getClass();
        this.f111427b = (BannedApiV2) com.bytedance.android.live.network.c.b().e(BannedApiV2.class);
        this.f111429d = new CompositeDisposable();
        this.f111432g = 20;
    }
}
