package com.bytedance.android.livesdk.chatroom.roommanage.admin;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.admin.api.AdminApi2;
import com.bytedance.android.livesdk.admin.prompt.PrompterDataContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.roommanage.AnchorManageAdminDataContext;
import com.bytedance.android.livesdk.chatroom.utils.q3;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.h;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.Items;
import py.t;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveRoomAdminManageListPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdminApi2 f111186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f111187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f111188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f111189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f111190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends td1.d> f111191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public td1.a f111192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f111193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.roommanage.admin.a f111194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Room f111195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.roommanage.d f111196k;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomAdminManageListPresenter f111197a;

        public a(LiveRoomAdminManageListPresenter r100) {
            this.f111197a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BaseListResponse r101 = (BaseListResponse) r100;
            LiveRoomAdminManageListPresenter r102 = this.f111197a;
            List<T> r103 = r101.data;
            if (r103 != null) goto L5;
            r103 = (List<T>) CollectionsKt.emptyList();
        L5:
            r102.f111191f = r103;
            Iterator<T> r104 = this.f111197a.f111191f.iterator();
        L7:
            if (r104.hasNext() == false) goto L11;
            td1.d r105 = (td1.d) r104.next();
            r105.f545503a = true;
            t r106 = r105.mUser.getUserAttr();
            if (r106 == null) goto L7;
            r106.setAdminPrivileges(r105.adminPrivileges);
            goto L7
        L11:
            td1.a r107 = (td1.a) r101.extra;
            if (r107 == null) goto L14;
            this.f111197a.f111192g = r107;
        L14:
            LiveRoomAdminManageListPresenter r108 = this.f111197a;
            td1.a r109 = r108.f111192g;
            r109.f545502a = r108.f111191f.size();
            this.f111197a.f111194i.setLoadingViewShow(false);
            LiveRoomAdminManageListPresenter.a(this.f111197a);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomAdminManageListPresenter f111198a;

        public b(LiveRoomAdminManageListPresenter r100) {
            this.f111198a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            f2.b(R.string.ttlive_network_error, 0);
            this.f111198a.f111194i.setErrorViewShow(true);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomAdminManageListPresenter f111199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ td1.d f111200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f111201c;

        public c(LiveRoomAdminManageListPresenter r100, td1.d r101, boolean r102) {
            this.f111199a = r100;
            this.f111200b = r101;
            this.f111201c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            g r102 = u.l();
            PrompterDataContext.a r103 = PrompterDataContext.Companion;
            User r104 = this.f111200b.mUser;
            r103.getClass();
            Map<String, String> r105 = PrompterDataContext.a.b(r104);
            r105.put("change_way", "anchor");
            if (this.f111201c == false) goto L5;
            String r106 = "delete";
        L6:
            r105.put("action_type", r106);
            r105.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_room");
            Unit r107 = Unit.INSTANCE;
            r102.f("livesdk_prompter_change", r105, new Object[]{Room.class});
            td1.d.b(this.f111200b.adminPrivileges, !this.f111201c);
            LiveRoomAdminManageListPresenter.a(this.f111199a);
            return;
        L5:
            r106 = "add";
            goto L6
        }
    }

    public final boolean b() {
        List<? extends td1.d> r100 = this.f111191f;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L9:
        if (r101.hasNext() == false) goto L16;
        if (((td1.d) r101.next()).a() == false) goto L9;
        r102 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L16:
        if (r102 >= this.f111192g.maxPrompters) goto L26;
        return true;
    L26:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        r102 = 0;
        goto L16
    }

    public final void d() {
        Room r100 = this.f111195j;
        if (r100 == null) goto L12;
        String r101 = r100.getOwnerUserIdString();
        if (r101 == null) goto L13;
        Disposable r102 = this.f111187b;
        if (r102 == null) goto L10;
        r102.dispose();
    L10:
        this.f111194i.setLoadingViewShow(true);
        this.f111187b = this.f111186a.fetchAdministrators2(r101, ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().a(r101), o.a(((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().b()), this.f111195j.f162599id).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        return;
    L13:
        return;
    }

    public final boolean e() {
        Room r100 = this.f111195j;
        if (r100 == null) goto L18;
        String r101 = r100.getOwnerUserIdString();
        if (r101 == null) goto L18;
        h r102 = TTLiveSDKContext.getHostService();
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

    public static final void a(LiveRoomAdminManageListPresenter r110) {
        r110.getClass();
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L7;
        n<RoomPermissionContext> r101 = r100.getPermissionContext();
        if (r101 == null) goto L7;
        RoomPermissionContext r102 = r101.getValue();
    L9:
        if (r102 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        com.bytedance.android.livesdk.chatroom.roommanage.admin.a r104 = r110.f111194i;
        td1.a r105 = r110.f111192g;
        r104.b(r105.f545502a, r105.a());
        if (r110.f111191f.isEmpty() == false) goto L17;
        r110.f111194i.setEmptyViewShow(true);
        return;
    L17:
        if (r103 == false) goto L24;
        DataContext r106 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(AnchorManageAdminDataContext.class));
        if ((r106 instanceof AnchorManageAdminDataContext) == true) goto L21;
        r106 = null;
    L21:
        AnchorManageAdminDataContext r107 = (AnchorManageAdminDataContext) r106;
        if (r107 == null) goto L24;
        r107.getAdmins().setValue(r110.f111191f);
        r107.getAdminManagePresenter().setValue(r110);
        r107.getAdminPrivilegeExtra().setValue(r110.f111192g.extraInfo);
        r107.getMaxSpecialPermissionAdmins().d(Integer.valueOf(r110.f111192g.maxPrompters));
    L24:
        Items r108 = new Items();
        if (r103 == true) goto L63;
        r108.add(new Object());
        List<? extends td1.d> r109 = r110.f111191f;
        if ((r109 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r111 = r109.iterator();
        int r112 = 0;
    L33:
        if (r111.hasNext() == false) goto L39;
        if (((td1.d) r111.next()).a() == false) goto L33;
        r112 = r112 + 1;
        if (r112 >= 0) goto L33;
        CollectionsKt.throwCountOverflow();
    L39:
        r108.add(new com.bytedance.android.livesdk.chatroom.roommanage.admin.binder.a(r112, r110.f111192g.maxPrompters, ((Boolean) r110.f111189d.getValue()).booleanValue()));
        List<? extends td1.d> r113 = r110.f111191f;
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r113.iterator();
    L41:
        if (r115.hasNext() == false) goto L46;
        Object r116 = r115.next();
        if (((td1.d) r116).a() == false) goto L41;
        r114.add(r116);
        goto L41
    L46:
        if ((!r114.isEmpty()) == true) goto L49;
        r114 = null;
    L49:
        if (r114 == null) goto L62;
        r108.addAll(r114);
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("should_show_admin_prompt_subtitle", Boolean.TRUE), Boolean.FALSE);
        DataContext r117 = com.bytedance.live.datacontext.d.d(PrompterDataContext.TAG);
        if ((r117 instanceof PrompterDataContext) == true) goto L53;
        r117 = null;
    L53:
        PrompterDataContext r118 = (PrompterDataContext) r117;
        if (r118 == null) goto L62;
        Set<PrompterDataContext.b> r119 = r118.getValidPrompters();
        if (r119 == null) goto L62;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r121 = r114.iterator();
    L59:
        if (r121.hasNext() == false) goto L61;
        td1.d r122 = (td1.d) r121.next();
        r120.add(new PrompterDataContext.b(r122.mUser.getIdString(), r122.mUser));
        goto L59
    L61:
        r119.addAll(r120);
    L62:
        r108.add(new Object());
        goto L63
    L29:
        if (r109.isEmpty() == false) goto L31;
        r112 = 0;
    L63:
        List<? extends td1.d> r123 = r110.f111191f;
        ArrayList r124 = new ArrayList();
        Iterator<T> r125 = r123.iterator();
    L65:
        if (r125.hasNext() == false) goto L75;
        Object r126 = r125.next();
        td1.d r127 = (td1.d) r126;
        if (r103 == false) goto L69;
    L72:
        boolean r128 = true;
    L73:
        if (r128 == false) goto L65;
        r124.add(r126);
        goto L65
    L69:
        if (r127.a() == false) goto L72;
        r128 = false;
        goto L73
    L75:
        r108.addAll(r124);
        r108.add(new com.bytedance.android.livesdk.chatroom.roommanage.common.e());
        r110.f111194i.setEmptyViewShow(false);
        r110.f111194i.setList(r108);
        Function0<Unit> r129 = r110.f111193h;
        if (r129 == null) goto L78;
        Unit r130 = r129.invoke();
    L78:
        r110.f111193h = null;
        return;
    L11:
        if (r102.getShouldRefinePermission().getValue().booleanValue() == false) goto L13;
        r103 = true;
    L7:
        r102 = null;
        goto L9
    }

    public final void c(td1.d r110, Function0 r111) {
        Intrinsics.checkNotNullParameter(r110, "adminUser");
        Intrinsics.checkNotNullParameter("admin_list", "enterMethod");
        if (this.f111190e == false) goto L5;
        return;
    L5:
        Room r100 = this.f111195j;
        if (r100 == null) goto L20;
        String r101 = r100.getOwnerUserIdString();
        if (r101 == null) goto L21;
        Room r102 = this.f111195j;
        long r103 = r102.f162599id;
        User r104 = r102.mo8271getOwner();
        if (r104 == null) goto L14;
        String r105 = r104.getCastSecUid();
        if (r105 == null) goto L14;
    L15:
        String r106 = r105;
        User r107 = r110.mUser;
        if (r107 != null) goto L18;
        return;
    L18:
        this.f111190e = true;
        Disposable r112 = this.f111186a.updateAdmin(2, r107.getIdStr(), r107.getCastSecUid(), r101, r106, r103, "room", "admin_list").compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.chatroom.roommanage.admin.b(this, r110, r111), new com.bytedance.android.livesdk.chatroom.roommanage.admin.c(this));
        this.f111188c.add(r112);
        return;
    L14:
        r105 = "";
        goto L15
    L21:
        return;
    }

    public final void f(boolean r100, td1.d r101) {
        DataContext r102 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        String r103 = null;
        if ((r102 instanceof RoomContext) == true) goto L5;
        r102 = null;
    L5:
        RoomContext r104 = (RoomContext) r102;
        if (r104 != null) goto L9;
        ALogger.e("AdminPresenter", "update prompt abort, roomContext null");
        return;
    L9:
        long r105 = r104.getRoom().getValue().f162599id;
        User r106 = r104.getRoom().getValue().mo8271getOwner();
        if (r106 == null) goto L12;
        r103 = r106.getCastSecUid();
    L12:
        if (r100 == false) goto L14;
        l.d().getClass();
        Observable<Response<Object>> r107 = ((AdminApi2) com.bytedance.android.live.network.c.b().e(AdminApi2.class)).revokePrompt(r101.mUser.getCastSecUid(), r103, r105);
    L15:
        this.f111188c.add(RxUtilKt.h(r107.subscribeOn(Schedulers.io())).subscribe(new c(this, r101, r100), q3.f114606a));
        return;
    L14:
        l.d().getClass();
        r107 = ((AdminApi2) com.bytedance.android.live.network.c.b().e(AdminApi2.class)).enablePrompt(r101.mUser.getCastSecUid(), r103, r105);
        goto L15
    }

    public LiveRoomAdminManageListPresenter(com.bytedance.android.livesdk.chatroom.roommanage.admin.a r100, Room r101, com.bytedance.android.livesdk.chatroom.roommanage.d r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "panelHandle");
        this.f111194i = r100;
        this.f111195j = r101;
        this.f111196k = r102;
        l.d().getClass();
        this.f111186a = (AdminApi2) com.bytedance.android.live.network.c.b().e(AdminApi2.class);
        this.f111188c = new CompositeDisposable();
        this.f111189d = InfraKotlinExtsKt.mainThreadLazy(LiveRoomAdminManageListPresenter$showPromptSubtitle$2.INSTANCE);
        this.f111191f = CollectionsKt.emptyList();
        this.f111192g = new td1.a();
    }
}
