package com.bytedance.android.live.livepkaudience.presenter;

import android.app.Activity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListResponse;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListSource;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.livepkaudience.base.PkAudienceApi;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.config.vh1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import dl0.m;
import dl0.n;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends com.bytedance.android.live.livepkaudience.dialog.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f82120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f82121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f82122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Room f82123f;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f82124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f82125b;

        public a(long r100, b r101) {
            this.f82124a = r100;
            this.f82125b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            m.r(this.f82124a, r101.logId);
            WaitingListResponse r102 = (WaitingListResponse) r101.data;
            if (r102 == null) goto L10;
            List<WaitingListUser> r103 = r102.getMWaitingUserInfo();
            if (r103 == null) goto L11;
            ArrayList<LinkPlayerInfo> r104 = n.f(r103);
            BasePkAudienceApplyListContract$View r105 = (BasePkAudienceApplyListContract$View) this.f82125b.f81800b;
            if (r105 == null) goto L12;
            r105.X90(r104);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.presenter.b$b, reason: collision with other inner class name */
    public static final class C1252b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f82126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f82127b;

        public C1252b(long r100, b r101) {
            this.f82126a = r100;
            this.f82127b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            m.q(this.f82126a, r101);
            ((BasePkAudienceApplyListContract$View) this.f82127b.f81800b).Z90(r101);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f82128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f82129b;

        public c(long r100, b r101) {
            this.f82128a = r100;
            this.f82129b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            m.o(this.f82128a, r101.logId);
            a1 r102 = (a1) r101.data;
            if (r102 == null) goto L13;
            BasePkAudienceApplyListContract$View r103 = (BasePkAudienceApplyListContract$View) this.f82129b.f81800b;
            if (r103 == null) goto L14;
            List<ILinkPlayerInfoBridge> r104 = r102.getPlayerInfo();
            if (r104 == null) goto L15;
            List<? extends LinkPlayerInfo> r105 = jm2.a.a(r104);
            if (r105 == null) goto L16;
            r103.Y90(r105);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f82130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f82131b;

        public d(long r100, b r101) {
            this.f82130a = r100;
            this.f82131b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            m.n(this.f82130a, r101);
            ((BasePkAudienceApplyListContract$View) this.f82131b.f81800b).Z90(r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f82132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f82133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f82134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f82135d;

        public e(long r100, b r101, boolean r102, String r103) {
            this.f82132a = r100;
            this.f82133b = r101;
            this.f82134c = r102;
            this.f82135d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            m.r(this.f82132a, r101.logId);
            b r102 = this.f82133b;
            if (this.f82134c == true) goto L12;
            List<WaitingListUser> r103 = ((WaitingListResponse) r101.data).getMWaitingUserInfo();
            if (r103 == null) goto L8;
            ArrayList<LinkPlayerInfo> r104 = n.f(r103);
        L9:
            r102.getClass();
            int r105 = Integer.valueOf(r104.size()).intValue();
            if (r105 <= 0) goto L12;
            long r106 = ((LinkPlayerInfo) ListProtector.get(r104, r105 - 1)).modifyTimeInNano;
            goto L12
        L8:
            r104 = new ArrayList();
        L12:
            r102.getClass();
            WaitingListResponse r107 = (WaitingListResponse) r101.data;
            if (r107 == null) goto L34;
            tc0.c.h().Q = r107.getNow();
            this.f82133b.f82120c = r107.getHasMore();
            if (r107.getSortStrategy() != 71) goto L17;
        L20:
            com.bytedance.android.livesdk.sharedpref.e<Integer> r108 = com.bytedance.android.livesdk.sharedpref.c.f158319x1;
            r108.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r108, 41);
        L21:
            BasePkAudienceApplyListContract$View r109 = (BasePkAudienceApplyListContract$View) this.f82133b.f81800b;
            if (r109 == null) goto L31;
            List<WaitingListUser> r110 = r107.getMWaitingUserInfo();
            if (r110 == null) goto L26;
            ArrayList<LinkPlayerInfo> r111 = n.f(r110);
        L27:
            ArrayList<LinkPlayerInfo> r112 = r111;
            int r113 = (int) r107.getTotalCount();
            boolean r114 = this.f82133b.f82120c;
            String r115 = r107.getNextCursor();
            if (r115 != null) goto L30;
            r115 = "";
        L30:
            r109.aa0(r112, r113, r114, r115, this.f82135d, r107.getWaitingListType());
            goto L31
        L26:
            r111 = new ArrayList();
        L31:
            BasePkAudienceApplyListContract$View r116 = (BasePkAudienceApplyListContract$View) this.f82133b.f81800b;
            if (r116 == null) goto L34;
            r116.V90(r107.getHasPreApply());
            goto L34
        L17:
            if (r107.getSortStrategy() == 41) goto L20;
            com.bytedance.android.livesdk.sharedpref.e<Integer> r117 = com.bytedance.android.livesdk.sharedpref.c.f158319x1;
            r117.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r117, 40);
        L34:
            this.f82133b.f82121d = false;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f82136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f82137b;

        public f(long r100, b r101) {
            this.f82136a = r100;
            this.f82137b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f82137b.f82121d = false;
            m.q(this.f82136a, r101);
            ((BasePkAudienceApplyListContract$View) this.f82137b.f81800b).Z90(r101);
            ((BasePkAudienceApplyListContract$View) this.f82137b.f81800b).W90(false);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f82138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f82139b;

        public g(long r100, b r101) {
            this.f82138a = r100;
            this.f82139b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Response r111 = (Response) r110;
            if (r111 == null) goto L10;
            bl0.b r100 = (bl0.b) r111.data;
            if (r100 == null) goto L11;
            long r101 = this.f82138a;
            String r112 = r111.logId;
            m r102 = m.f469074a;
            Intrinsics.checkNotNullParameter(r112, "logId");
            JSONObject r103 = new JSONObject();
            BaseMonitor.add(r103, "api_log_id", r112);
            m r113 = m.f469074a;
            long r104 = System.currentTimeMillis() - r101;
            r113.getClass();
            m.z("linkmic_audience/list_friends", 0, "", r104, r103);
            BasePkAudienceApplyListContract$View r114 = (BasePkAudienceApplyListContract$View) this.f82139b.f81800b;
            if (r114 == null) goto L12;
            r114.ba0(r100);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f82140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f82141b;

        public h(long r100, b r101) {
            this.f82140a = r100;
            this.f82141b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            long r100 = this.f82140a;
            m r101 = m.f469074a;
            JSONObject r102 = new JSONObject();
            if (r111 != null) goto L5;
        L11:
            ((BasePkAudienceApplyListContract$View) this.f82141b.f81800b).Z90(r111);
            return;
        L5:
            if ((r111 instanceof ApiServerException) == false) goto L10;
            m r103 = m.f469074a;
            ApiServerException r104 = (ApiServerException) r111;
            int r105 = r104.getErrorCode();
            String r106 = r104.getErrorMsg();
            if (r106 != null) goto L9;
            r106 = "";
        L9:
            long r107 = System.currentTimeMillis() - r100;
            r103.getClass();
            m.z("linkmic_audience/list_friends", r105, r106, r107, r102);
            goto L11
        L10:
            m r108 = m.f469074a;
            String r109 = r111.toString();
            long r112 = System.currentTimeMillis() - r100;
            r108.getClass();
            m.z("linkmic_audience/list_friends", 1, r109, r112, r102);
            goto L11
        }
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void d() {
        Room r100 = this.f82123f;
        if (r100 == null) goto L6;
        long r101 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).getLinkWaitingList(r100.f162599id, 50, "", WaitingListType.UNKNOWN.ordinal(), WaitingListSource.ANCHOR_PANEL.ordinal()).as(c())).subscribe(new a(r101, this), new C1252b(r101, this));
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void e() {
        Room r100 = this.f82123f;
        if (r100 == null) goto L6;
        long r101 = System.currentTimeMillis();
        PkAudienceApi r102 = (PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class);
        long r103 = r100.f162599id;
        int r104 = BasePkAudienceInviteListFragment.A;
        ((SingleSubscribeProxy) r102.getInviteList(r103, 1, "").as(c())).subscribe(new c(r101, this), new d(r101, this));
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void h() {
        if (this.f82123f == null) goto L6;
        long r100 = System.currentTimeMillis();
        ((ObservableSubscribeProxy) ((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).getAnchorFriends(10).as(c())).subscribe(new g(r100, this), new h(r100, this));
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void i(Activity r210) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        ShareParams.Builder r100 = ShareParams.buildUponRoom(this.f82123f);
        IUserService r101 = (IUserService) jc1.k.f(IUserService.class);
        if (r101 == null) goto L20;
        com.bytedance.android.livesdk.user.f r102 = r101.user();
        if (r102 == null) goto L21;
        IUser r103 = r102.b();
        if (r103 == null) goto L22;
        r100.setUserId(r103.getIdString());
        r100.setAnchor(true);
        r100.setShareScene(ShareScene.LIVE);
        if (this.f82123f == null) goto L14;
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L14;
        o0.a(r104, r100);
    L14:
        ILiveMiddlewareShareService r110 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        i81.a r105 = new i81.a(null, r210, null, r100.build(), null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false);
        String r106 = this.f82122e;
        LiveShareType r107 = LiveShareType.SHARE_DIALOG;
        if (vh1.f121451a.getValue().booleanValue() == false) goto L17;
        IShareCallback r108 = new com.bytedance.android.live.livepkaudience.presenter.c(this);
    L18:
        r110.share(r105, r106, r107, r108);
        return;
    L17:
        r108 = new com.bytedance.android.live.livepkaudience.presenter.d(this);
        goto L18
    L22:
        return;
    L21:
        return;
    }

    public b(Room r100, BasePkAudienceApplyListContract$View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r101);
        this.f82123f = r100;
        this.f82120c = true;
        this.f82122e = "PkAudienceApplyListPresenter";
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void f(boolean r110, String r111, long r112, String r210, int r211) {
        Intrinsics.checkNotNullParameter(r111, "reqSource");
        Intrinsics.checkNotNullParameter(r210, EffectConfiguration.KEY_CURSOR);
        if (r110 == false) goto L5;
        this.f82120c = true;
    L7:
        if (this.f82120c == true) goto L9;
        return;
    L9:
        if (this.f82121d == true) goto L15;
        this.f82121d = true;
        Room r100 = this.f82123f;
        if (r100 == null) goto L16;
        long r101 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).getLinkWaitingList(r100.f162599id, r112, r210, r211, WaitingListSource.ANCHOR_PANEL.ordinal()).as(c())).subscribe(new e(r101, this, r110, r111), new f(r101, this));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        ((BasePkAudienceApplyListContract$View) this.f81800b).W90(this.f82120c);
        goto L7
    }
}
