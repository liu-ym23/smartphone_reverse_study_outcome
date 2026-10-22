package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public class e implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vlc.d f76180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f76181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRoom f76182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f76183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<uf0.a> f76184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<String> f76185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet<String> f76186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f76187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f76188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DataCenter f76189j;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f76190a = null;

        static {
            f76190a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            LinkMicRoomDataSyncModel r102 = LinkWRDSHelper.b();
            Intrinsics.checkNotNullParameter(r101, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.b(r102, r101));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f76191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f76192b;

        public b(e r100, long r101) {
            this.f76191a = r100;
            this.f76192b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.link.model.bridge.i0> r111 = (com.bytedance.android.live.network.response.e) r110;
            this.f76191a.f76187h = false;
            com.bytedance.android.livesdk.link.model.bridge.i0 r100 = r111.data;
            String r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.getToken();
        L6:
            com.bytedance.android.livesdk.link.model.bridge.i0 r103 = r111.data;
            if (r103 == null) goto L9;
            Long r104 = Long.valueOf(r103.getVersion());
        L10:
            com.bytedance.android.livesdk.link.model.bridge.i0 r105 = r111.data;
            if (r105 == null) goto L15;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r106 = r105.getLinkedUsers();
            if (r106 == null) goto L15;
            String r107 = je0.d.g0(r106);
        L16:
            InteractLinkFullLinkMonitor.r(r102, r104, r107, System.currentTimeMillis() - this.f76192b, r111.logId);
            long r108 = System.currentTimeMillis() - this.f76192b;
            com.bytedance.android.livesdk.link.model.bridge.i0 r109 = r111.data;
            if (r109 == null) goto L19;
            String r112 = r109.getToken();
        L20:
            com.bytedance.android.livesdk.link.model.bridge.i0 r113 = r111.data;
            if (r113 == null) goto L23;
            Long r114 = Long.valueOf(r113.getVersion());
        L24:
            com.bytedance.android.livesdk.link.model.bridge.i0 r115 = r111.data;
            if (r115 == null) goto L29;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r116 = r115.getLinkedUsers();
            if (r116 == null) goto L29;
            r101 = je0.d.g0(r116);
        L29:
            com.bytedance.android.live.liveinteract.plantform.utils.x.v(r108, r112, r114, r101);
            TalkRoomBusinessFullLinkMonitor r117 = TalkRoomBusinessFullLinkMonitor.f71456a;
            long r118 = this.f76192b;
            r117.getClass();
            TalkRoomBusinessFullLinkMonitor.N(r111, r118);
            Iterator<uf0.a> r119 = this.f76191a.f76184e.iterator();
        L31:
            if (r119.hasNext() == false) goto L33;
            r119.next().b2(r111);
            goto L31
        L33:
            return;
        L23:
            r114 = null;
            goto L24
        L19:
            r112 = null;
        L15:
            r107 = null;
            goto L16
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f76193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f76194b;

        public c(e r100, long r101) {
            this.f76193a = r100;
            this.f76194b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f76193a.f76187h = false;
            long r102 = this.f76194b;
            InteractLinkFullLinkMonitor.q(System.currentTimeMillis() - r102, r101);
            long r103 = this.f76194b;
            com.bytedance.android.live.liveinteract.plantform.utils.x.u(r101, System.currentTimeMillis() - r103);
            TalkRoomBusinessFullLinkMonitor r104 = TalkRoomBusinessFullLinkMonitor.f71456a;
            long r105 = this.f76194b;
            r104.getClass();
            TalkRoomBusinessFullLinkMonitor.M(r101, r105);
            Iterator<uf0.a> r106 = this.f76193a.f76184e.iterator();
        L4:
            if (r106.hasNext() == false) goto L6;
            r106.next().m0(r101);
            goto L4
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f76195a;

        public d(e r100) {
            this.f76195a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            if (r101 == null) goto L5;
            Boolean r102 = (Boolean) r101.getData();
        L7:
            if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L10;
            this.f76195a.d();
            return;
        L10:
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.core.e$e, reason: collision with other inner class name */
    public static final class C1189e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f76196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f76197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f76198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f76199d;

        public C1189e(e r100, String r101, long r102, String r103) {
            this.f76196a = r100;
            this.f76197b = r101;
            this.f76198c = r102;
            this.f76199d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            Iterator<uf0.a> r102 = this.f76196a.f76184e.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().If();
            goto L4
        L6:
            String r103 = this.f76197b;
            long r104 = this.f76198c;
            InteractLinkFullLinkMonitor.u(r103, System.currentTimeMillis() - r104, r101.logId);
            TalkRoomBusinessFullLinkMonitor r105 = TalkRoomBusinessFullLinkMonitor.f71456a;
            String r106 = this.f76197b;
            String r107 = this.f76199d;
            long r108 = this.f76198c;
            String r109 = r101.logId;
            r105.getClass();
            TalkRoomBusinessFullLinkMonitor.P(r106, r107, r108, r109);
            String r110 = this.f76197b;
            int r111 = com.bytedance.android.live.liveinteract.plantform.utils.x.f77572a;
            Intrinsics.checkNotNullParameter(r110, "targetId");
            LinkedHashMap r112 = new LinkedHashMap();
            r112.put("target_user_id", r110);
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("kickout_audience_success", r112);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f76200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f76201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f76202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f76203d;

        public f(e r100, String r101, long r102, String r103) {
            this.f76200a = r100;
            this.f76201b = r101;
            this.f76202c = r102;
            this.f76203d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Iterator<uf0.a> r102 = this.f76200a.f76184e.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().k5(this.f76201b, r101);
            goto L4
        L6:
            String r103 = this.f76201b;
            long r104 = this.f76202c;
            InteractLinkFullLinkMonitor.t(r103, System.currentTimeMillis() - r104, r101);
            TalkRoomBusinessFullLinkMonitor r105 = TalkRoomBusinessFullLinkMonitor.f71456a;
            String r106 = this.f76201b;
            String r107 = this.f76203d;
            long r108 = this.f76202c;
            r105.getClass();
            TalkRoomBusinessFullLinkMonitor.O(r106, r107, r108, r101);
            String r109 = this.f76201b;
            int r110 = com.bytedance.android.live.liveinteract.plantform.utils.x.f77572a;
            Intrinsics.checkNotNullParameter(r109, "targetId");
            LinkedHashMap r111 = new LinkedHashMap();
            r111.put("target_user_id", r109);
            com.bytedance.android.live.liveinteract.plantform.utils.x.X(r101, r111);
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("kickout_audience_failed", r111);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f76204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f76205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f76206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f76207d;

        public g(e r100, String r101, String r102, long r103) {
            this.f76204a = r100;
            this.f76205b = r101;
            this.f76206c = r102;
            this.f76207d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.network.response.e r111 = (com.bytedance.android.live.network.response.e) r110;
            this.f76204a.f76185f.remove(this.f76205b);
            TalkRoomBusinessFullLinkMonitor r100 = TalkRoomBusinessFullLinkMonitor.f71456a;
            String r101 = this.f76205b;
            String r102 = this.f76206c;
            long r103 = this.f76207d;
            r100.getClass();
            TalkRoomBusinessFullLinkMonitor.f0(r101, r102, r103, r111);
            if (((t2) r111.data) == null) goto L9;
            Iterator<uf0.a> r104 = this.f76204a.f76184e.iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            r104.next().onPermitSuccess(this.f76205b);
            goto L6
        L8:
            String r105 = this.f76205b;
            String r106 = this.f76206c;
            long r107 = this.f76207d;
            InteractLinkFullLinkMonitor.I(r105, r106, System.currentTimeMillis() - r107, r111.logId, (t2) r111.data);
            String r112 = this.f76205b;
            long r108 = this.f76207d;
            com.bytedance.android.live.liveinteract.plantform.utils.x.Y(r112, System.currentTimeMillis() - r108);
        L9:
            IKtvService r113 = (IKtvService) jc1.k.f(IKtvService.class);
            if (r113 == null) goto L14;
            r113.onPermitSuccess(this.f76205b);
            return;
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f76208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f76209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f76210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f76211d;

        public h(e r100, String r101, String r102, long r103) {
            this.f76208a = r100;
            this.f76209b = r101;
            this.f76210c = r102;
            this.f76211d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f76208a.f76185f.remove(this.f76209b);
            TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
            String r103 = this.f76209b;
            String r104 = this.f76210c;
            long r105 = this.f76211d;
            r102.getClass();
            JSONObject r106 = new JSONObject();
            r106.put("target_user_id", r103);
            r106.put("target_sec_user_id", r104);
            TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.PermitApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r105), r101, r106);
            Iterator<uf0.a> r107 = this.f76208a.f76184e.iterator();
        L4:
            if (r107.hasNext() == false) goto L6;
            r107.next().l(this.f76209b, r101);
            goto L4
        L6:
            String r108 = this.f76209b;
            String r109 = this.f76210c;
            long r110 = this.f76211d;
            InteractLinkFullLinkMonitor.H(r108, r109, System.currentTimeMillis() - r110, r101);
            String r111 = this.f76209b;
            long r112 = this.f76211d;
            com.bytedance.android.live.liveinteract.plantform.utils.x.Z(r111, r101, System.currentTimeMillis() - r112);
        }
    }

    public final void b() {
        vlc.d r100 = this.f76180a;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
    L6:
        if (this.f76181b.isDisposed() == true) goto L8;
        this.f76181b.dispose();
    L8:
        this.f76184e.clear();
        this.f76185f.clear();
        this.f76186g.clear();
    }

    public final void d() {
        Boolean r100 = (Boolean) this.f76189j.get("cmd_ready_starting_live", Boolean.FALSE);
        d r101 = new d(this);
        if (r100.booleanValue() == true) goto L6;
        this.f76189j.observe("cmd_ready_starting_live", r101);
        return;
    L6:
        this.f76189j.removeObserver(r101);
        if (this.f76187h == false) goto L9;
        return;
    L9:
        this.f76187h = true;
        com.bytedance.android.live.liveinteract.plantform.utils.r.a("join channel");
        long r102 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.p();
        Disposable r103 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).joinChannelV1(this.f76182c.getId()).subscribeOn(Schedulers.io()).flatMap(a.f76190a).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r102), new c(this, r102));
        this.f76181b.add(r103);
    }

    public final void a(uf0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkListener");
        this.f76184e.add(r100);
    }

    public final void g(uf0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkListener");
        if (this.f76184e.contains(r100) == false) goto L6;
        this.f76184e.remove(r100);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof z0) == false) goto L20;
        z0 r101 = (z0) r100;
        switch(((int) r101.getType2())) {
            case 13: goto L15;
            case 14: goto L11;
            case 15: goto L7;
            default: goto L30;
        };
    L7:
        InteractLinkFullLinkMonitor.J((com.bytedance.android.live.liveinteract.multianchor.model.b) r101.castToOrNull(com.bytedance.android.live.liveinteract.multianchor.model.b.class));
        Iterator<uf0.a> r102 = this.f76184e.iterator();
    L9:
        if (r102.hasNext() == false) goto L31;
        r102.next().Ba(r101);
        goto L9
    L31:
        return;
    L11:
        com.bytedance.android.live.liveinteract.plantform.utils.x.c(r101.getFromUserIdStr(), r101.getMessageId2());
        Iterator<uf0.a> r103 = this.f76184e.iterator();
    L13:
        if (r103.hasNext() == false) goto L32;
        r103.next().eo(r101);
        goto L13
    L32:
        return;
    L15:
        com.bytedance.android.live.liveinteract.plantform.utils.x.b(r101.getMessageId2(), r101.getReplyType());
        InteractLinkFullLinkMonitor.K((z0) r101.castToOrNull(com.bytedance.android.live.liveinteract.multianchor.model.b.class));
        TalkRoomBusinessFullLinkMonitor r104 = TalkRoomBusinessFullLinkMonitor.f71456a;
        z0 r105 = (z0) r101.castToOrNull(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        r104.getClass();
        TalkRoomBusinessFullLinkMonitor.o0(r105);
        Iterator<uf0.a> r106 = this.f76184e.iterator();
    L17:
        if (r106.hasNext() == false) goto L33;
        r106.next().Ff(r101);
        goto L17
    L33:
        return;
    L30:
        return;
    L20:
        if ((r100 instanceof ILinkMicGuideMessageBridge) == false) goto L25;
        Iterator<uf0.a> r107 = this.f76184e.iterator();
    L23:
        if (r107.hasNext() == false) goto L34;
        r107.next().vf((ILinkMicGuideMessageBridge) r100);
        goto L23
    L34:
        return;
    }

    public e(DataCenter r100, tf0.i r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        this.f76189j = r100;
        this.f76180a = (vlc.d) r100.get("data_message_manager");
        this.f76181b = new CompositeDisposable();
        this.f76182c = (IRoom) r100.get("data_room", vh7.f.c(IRoom.class));
        this.f76183d = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.f76184e = new ArrayList();
        this.f76185f = new HashSet();
        this.f76186g = new HashSet();
    }

    public final void f(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "uid");
        if (this.f76185f.contains(r110) == false) goto L7;
        ALogger.e("ttlive_link", "permit request already sent for " + r110);
        return;
    L7:
        if (((IMultiLinkServiceExternal) jc1.k.n(IMultiLinkServiceExternal.class)).getMultiDataHolderExternal().getChannelId() == 0) goto L10;
        f2.b(R.string.ttlive_interact_audience_pk_reject, 0);
        return;
    L10:
        this.f76185f.add(r110);
        long r100 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.G(r110, r111);
        this.f76181b.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).permit(this.f76182c.getId(), r110, r110, r111).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r110, r111, r100), new h(this, r110, r111, r100)));
    }

    public final void e(String r110, String r111, String r210) {
        Intrinsics.checkNotNullParameter(r110, "uid");
        Intrinsics.checkNotNullParameter(r210, "requestFrom");
        long r112 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.s(r110);
        Disposable r100 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).kickOut(this.f76182c.getId(), r110, r110, r111, r210).compose(RxUtil.rxSchedulerHelper()).subscribe(new C1189e(this, r110, r112, r111), new f(this, r110, r112, r111));
        this.f76181b.add(r100);
        if (this.f76183d == false) goto L5;
        String r101 = "anchor";
    L6:
        TalkRoomLogUtils.h(r110, r101, je0.d.k0(r110));
        return;
    L5:
        r101 = "administrator";
        goto L6
    }

    public static void c(e r210, long r211, String r310, String r311, long r312, int r313) {
        if ((r313 & 128) == 0) goto L5;
        long r212 = 0;
    L6:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r310, "uid");
        Intrinsics.checkNotNullParameter(r311, "secUid");
        if (r210.f76186g.contains(r310) == false) goto L9;
        ALogger.e("ttlive_link", "invite request already sent for " + r310);
        return;
    L9:
        r210.f76186g.add(r310);
        long r213 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.m(r310, r311);
        r210.f76181b.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).invite(r211, r311, r310, null, null, 1, -1, 0, 0, r212, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.plantform.core.c(r210, r310, r311, r213, 0, r212), new com.bytedance.android.live.liveinteract.plantform.core.d(r210, r310, r311, r213, r212)));
        return;
    L5:
        r212 = r312;
        goto L6
    }
}
