package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.util.j;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b extends yf0.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRoom f74988c;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f74989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f74990b;

        public a(b r100, long r101) {
            this.f74989a = r100;
            this.f74990b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
            long r103 = this.f74990b;
            String r104 = r101.logId;
            r102.getClass();
            TalkRoomBusinessFullLinkMonitor.D(r103, r104);
            a1 r105 = (a1) r101.data;
            if (r105 == null) goto L8;
            BaseTalkInviteListContract$View r106 = (BaseTalkInviteListContract$View) this.f74989a.f567428b;
            if (r106 == null) goto L9;
            r106.ca0(r105);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.presenter.b$b, reason: collision with other inner class name */
    public static final class C1177b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f74991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f74992b;

        public C1177b(b r100, long r101) {
            this.f74991a = r100;
            this.f74992b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
            long r103 = this.f74992b;
            r102.getClass();
            TalkRoomBusinessFullLinkMonitor.C(r103, r101);
            BaseTalkInviteListContract$View r104 = (BaseTalkInviteListContract$View) this.f74991a.f567428b;
            if (r104 == null) goto L6;
            r104.aa0(r101);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f74993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILinkPlayerInfoBridge f74994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f74995c;

        public c(b r100, ILinkPlayerInfoBridge r101, long r102) {
            this.f74993a = r100;
            this.f74994b = r101;
            this.f74995c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            BaseTalkInviteListContract$View r102 = (BaseTalkInviteListContract$View) this.f74993a.f567428b;
            if (r102 == null) goto L5;
            IBaseUser r103 = this.f74994b.getUser();
            Intrinsics.checkNotNull(r103);
            r102.ba0(r103, ((v) r101.data).getNoticeInfoList());
        L5:
            IBaseUser r104 = this.f74994b.getUser();
            if (r104 == null) goto L9;
            String r105 = r104.getIdString();
            if (r105 == null) goto L9;
        L10:
            String r106 = r105;
            IBaseUser r107 = this.f74994b.getUser();
            if (r107 == null) goto L13;
            Intrinsics.checkNotNullParameter(r107, "$this$secUidExt");
            String r108 = r107.getCastSecUid();
        L14:
            String r109 = r108;
            long r110 = this.f74995c;
            SimpleDateFormat r111 = o.f75051a;
            InteractLinkFullLinkMonitor.o(r106, r109, System.currentTimeMillis() - r110, r101.logId, (v) r101.data);
            return;
        L13:
            r108 = null;
        L9:
            r105 = "";
            goto L10
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f74996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILinkPlayerInfoBridge f74997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f74998c;

        public d(b r100, ILinkPlayerInfoBridge r101, long r102) {
            this.f74996a = r100;
            this.f74997b = r101;
            this.f74998c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            IBaseUser r102 = this.f74997b.getUser();
            if (r102 == null) goto L6;
            String r103 = r102.getIdString();
            if (r103 == null) goto L6;
        L7:
            IBaseUser r104 = this.f74997b.getUser();
            if (r104 == null) goto L10;
            Intrinsics.checkNotNullParameter(r104, "$this$secUidExt");
            String r105 = r104.getCastSecUid();
        L11:
            String r106 = String.valueOf(r105);
            long r107 = this.f74998c;
            SimpleDateFormat r108 = o.f75051a;
            InteractLinkFullLinkMonitor.n(r103, r106, System.currentTimeMillis() - r107, r101);
            ExceptionUtils.handleException(((BaseTalkInviteListContract$View) this.f74996a.f567428b).getContext(), r101);
            return;
        L10:
            r105 = null;
        L6:
            r103 = "";
            goto L7
        }
    }

    @Override // yf0.b
    public final void d(boolean r100) {
        IRoom r101 = this.f74988c;
        if (r101 != null) goto L5;
        return;
    L5:
        long r102 = System.currentTimeMillis();
        LinkAnchorApi r103 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r104 = r101.getId();
        if (r100 == false) goto L8;
        byte r105 = (byte) 3;
    L9:
        ((SingleSubscribeProxy) r103.getInviteList(r104, r105).as(c())).subscribe(new a(this, r102), new C1177b(this, r102));
        return;
    L8:
        r105 = 2;
        goto L9
    }

    @Override // yf0.b
    public final void e(ILinkPlayerInfoBridge r210) {
        Intrinsics.checkNotNullParameter(r210, "userInfo");
        IRoom r100 = this.f74988c;
        if (r100 != null) goto L5;
        return;
    L5:
        long r110 = System.currentTimeMillis();
        IBaseUser r101 = r210.getUser();
        Intrinsics.checkNotNull(r101);
        String r102 = r101.getIdString();
        IBaseUser r103 = r210.getUser();
        Intrinsics.checkNotNull(r103);
        InteractLinkFullLinkMonitor.m(r102, com.bytedance.android.live.base.model.user.o.a(r103));
        int r104 = j.f75044a;
        j.a.a("panel_audience");
        LinkAudienceApi r105 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r106 = r100.getRoomId();
        IBaseUser r107 = r210.getUser();
        String r108 = null;
        if (r107 == null) goto L8;
        String r109 = r107.getIdString();
    L9:
        IBaseUser r111 = r210.getUser();
        if (r111 == null) goto L12;
        r108 = r111.getIdString();
    L12:
        IBaseUser r112 = r210.getUser();
        Intrinsics.checkNotNull(r112);
        String r113 = new JSONArray(CollectionsKt.listOf(r112.getIdString())).toString();
        IBaseUser r114 = r210.getUser();
        Intrinsics.checkNotNull(r114);
        ((ObservableSubscribeProxy) r105.invite(r106, r109, r108, r113, new JSONArray(CollectionsKt.listOf(r114.getIdString())).toString(), 1, -1, 0, 0, 0, 0).as(c())).subscribe(new com.bytedance.android.live.liveinteract.linkpanel.presenter.c(this, r210, r110), new com.bytedance.android.live.liveinteract.linkpanel.presenter.d(this, r210, r110));
        return;
    L8:
        r109 = null;
        goto L9
    }

    @Override // yf0.b
    public final void f(ILinkPlayerInfoBridge r210) {
        Intrinsics.checkNotNullParameter(r210, "userInfo");
        IRoom r100 = this.f74988c;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = j.f75044a;
        j.a.a("panel_friend");
        IBaseUser r102 = r210.getUser();
        if (r102 == null) goto L9;
        String r103 = r102.getIdString();
        if (r103 == null) goto L9;
    L10:
        IBaseUser r104 = r210.getUser();
        String r105 = null;
        if (r104 == null) goto L13;
        Intrinsics.checkNotNullParameter(r104, "$this$secUidExt");
        String r106 = r104.getCastSecUid();
    L14:
        InteractLinkFullLinkMonitor.m(r103, r106);
        long r107 = System.currentTimeMillis();
        LinkAudienceApi r108 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r109 = r100.getId();
        IBaseUser r110 = r210.getUser();
        if (r110 == null) goto L17;
        String r111 = r110.getIdString();
    L18:
        IBaseUser r112 = r210.getUser();
        if (r112 == null) goto L21;
        String r113 = r112.getIdString();
    L22:
        IBaseUser r114 = r210.getUser();
        if (r114 == null) goto L25;
        String r115 = r114.getIdString();
    L26:
        String r116 = new JSONArray(CollectionsKt.listOf(r115)).toString();
        IBaseUser r117 = r210.getUser();
        if (r117 == null) goto L29;
        r105 = r117.getIdString();
    L29:
        ((ObservableSubscribeProxy) r108.invite(r109, r111, r113, r116, new JSONArray(CollectionsKt.listOf(r105)).toString(), 0, 0, 0, 0, 0, 0).as(c())).subscribe(new c(this, r210, r107), new d(this, r210, r107));
        return;
    L25:
        r115 = null;
        goto L26
    L21:
        r113 = null;
        goto L22
    L17:
        r111 = null;
        goto L18
    L13:
        r106 = null;
    L9:
        r103 = "";
        goto L10
    }

    public b(IRoom r100, BaseTalkInviteListContract$View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r101);
        this.f74988c = r100;
    }
}
