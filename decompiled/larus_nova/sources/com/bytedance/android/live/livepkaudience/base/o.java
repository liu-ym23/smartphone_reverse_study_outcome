package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.livesdk.chatroom.model.interact.l2;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public class o implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vlc.d f81474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f81475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Room f81476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f81477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<g> f81478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<String> f81479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet<String> f81480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f81481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f81482i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f81483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f81484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f81485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f81486d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f81487e;

        public a(o r100, String r101, String r102, long r103, String r104) {
            this.f81483a = r100;
            this.f81484b = r101;
            this.f81485c = r102;
            this.f81486d = r103;
            this.f81487e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.network.response.e r111 = (com.bytedance.android.live.network.response.e) r110;
            Iterator<g> r100 = this.f81483a.f81478e.iterator();
        L4:
            if (r100.hasNext() == false) goto L12;
            g r101 = r100.next();
            String r102 = this.f81484b;
            if (r111 == null) goto L10;
            l2 r103 = (l2) r111.data;
            if (r103 == null) goto L10;
            String r104 = r103.getOpenId();
        L11:
            r101.c7(r102, r104);
        L10:
            r104 = null;
            goto L11
        L12:
            String r105 = this.f81484b;
            String r106 = this.f81485c;
            long r107 = this.f81486d;
            long r108 = System.currentTimeMillis() - r107;
            String r112 = r111.logId;
            if (this.f81483a.f81477d == false) goto L15;
            String r109 = "anchor";
        L16:
            String r113 = this.f81487e;
            dl0.m r114 = dl0.m.f469074a;
            Intrinsics.checkNotNullParameter(r105, "userId");
            Intrinsics.checkNotNullParameter(r112, "logId");
            Intrinsics.checkNotNullParameter(r109, "role");
            Intrinsics.checkNotNullParameter(r113, "reqFrom");
            JSONObject r115 = new JSONObject();
            BaseMonitor.add(r115, com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r105);
            if (r106 != null) goto L19;
            r106 = "";
        L19:
            BaseMonitor.add(r115, "sec_to_user_id", r106);
            BaseMonitor.add(r115, "api_log_id", r112);
            BaseMonitor.add(r115, "operate_role_type", r109);
            BaseMonitor.add(r115, "request_source", r113);
            dl0.m.f469074a.getClass();
            dl0.m.z("audience_kick_out", 0, "", r108, r115);
            return;
        L15:
            r109 = "administrator";
            goto L16
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f81488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f81489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f81490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f81491d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f81492e;

        public b(o r100, String r101, String r102, long r103, String r104) {
            this.f81488a = r100;
            this.f81489b = r101;
            this.f81490c = r102;
            this.f81491d = r103;
            this.f81492e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            Iterator<g> r100 = this.f81488a.f81478e.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().k5(this.f81489b, r111);
            goto L4
        L6:
            String r101 = this.f81489b;
            String r102 = this.f81490c;
            long r103 = this.f81491d;
            long r104 = System.currentTimeMillis() - r103;
            if (this.f81488a.f81477d == false) goto L9;
            String r105 = "anchor";
        L10:
            String r106 = this.f81492e;
            dl0.m r107 = dl0.m.f469074a;
            Intrinsics.checkNotNullParameter(r101, "userId");
            Intrinsics.checkNotNullParameter(r105, "role");
            Intrinsics.checkNotNullParameter(r106, "reqFrom");
            JSONObject r112 = new JSONObject();
            BaseMonitor.add(r112, com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101);
            if (r102 != null) goto L13;
            r102 = "";
        L13:
            BaseMonitor.add(r112, "sec_to_user_id", r102);
            BaseMonitor.add(r112, "operate_role_type", r105);
            BaseMonitor.add(r112, "request_source", r106);
            if (r111 != null) goto L16;
            return;
        L16:
            if ((r111 instanceof ApiServerException) == false) goto L22;
            dl0.m r108 = dl0.m.f469074a;
            ApiServerException r113 = (ApiServerException) r111;
            int r109 = r113.getErrorCode();
            String r114 = r113.getErrorMsg();
            if (r114 != null) goto L20;
            String r115 = "";
        L21:
            r108.getClass();
            dl0.m.z("audience_kick_out", r109, r115, r104, r112);
            return;
        L20:
            r115 = r114;
            goto L21
        L22:
            dl0.m r116 = dl0.m.f469074a;
            String r117 = r111.toString();
            r116.getClass();
            dl0.m.z("audience_kick_out", 1, r117, r104, r112);
            return;
        L9:
            r105 = "administrator";
            goto L10
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f81493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f81494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f81495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f81496d;

        public c(o r100, String r101, String r102, long r103) {
            this.f81493a = r100;
            this.f81494b = r101;
            this.f81495c = r102;
            this.f81496d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.network.response.e r111 = (com.bytedance.android.live.network.response.e) r110;
            this.f81493a.f81479f.remove(this.f81494b);
            if (r111 != null) goto L5;
            return;
        L5:
            if (((t2) r111.data) == null) goto L18;
            Iterator<g> r112 = this.f81493a.f81478e.iterator();
        L8:
            if (r112.hasNext() == false) goto L10;
            r112.next().onPermitSuccess(this.f81494b);
            goto L8
        L10:
            String r113 = this.f81494b;
            String r100 = this.f81495c;
            long r101 = this.f81496d;
            long r102 = System.currentTimeMillis() - r101;
            if (this.f81493a.f81477d == false) goto L13;
            String r103 = "anchor";
        L14:
            dl0.m r104 = dl0.m.f469074a;
            Intrinsics.checkNotNullParameter(r113, "toUserId");
            Intrinsics.checkNotNullParameter("", "permitType");
            Intrinsics.checkNotNullParameter(r103, "role");
            JSONObject r114 = new JSONObject();
            BaseMonitor.add(r114, com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r113.toString());
            BaseMonitor.add(r114, "sec_to_user_id", String.valueOf(r100));
            BaseMonitor.add(r114, "permit_type", "");
            BaseMonitor.add(r114, "operate_role_type", r103);
            dl0.m.f469074a.getClass();
            dl0.m.z("audience_permit", 0, "", r102, r114);
            return;
        L13:
            r103 = "administrator";
            goto L14
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f81497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f81498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f81499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f81500d;

        public d(o r100, String r101, String r102, long r103) {
            this.f81497a = r100;
            this.f81498b = r101;
            this.f81499c = r102;
            this.f81500d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            this.f81497a.f81479f.remove(this.f81498b);
            Iterator<g> r100 = this.f81497a.f81478e.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().l(this.f81498b, r111);
            goto L4
        L6:
            String r101 = this.f81498b;
            String r102 = this.f81499c;
            long r103 = this.f81500d;
            long r104 = System.currentTimeMillis() - r103;
            if (this.f81497a.f81477d == false) goto L9;
            String r105 = "anchor";
        L10:
            dl0.m r106 = dl0.m.f469074a;
            Intrinsics.checkNotNullParameter(r101, "toUserId");
            Intrinsics.checkNotNullParameter("", "permitType");
            Intrinsics.checkNotNullParameter(r105, "role");
            JSONObject r112 = new JSONObject();
            BaseMonitor.add(r112, com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101.toString());
            BaseMonitor.add(r112, "sec_to_user_id", String.valueOf(r102));
            BaseMonitor.add(r112, "permit_type", "");
            BaseMonitor.add(r112, "operate_role_type", r105);
            if (r111 != null) goto L13;
            return;
        L13:
            if ((r111 instanceof ApiServerException) == false) goto L19;
            dl0.m r107 = dl0.m.f469074a;
            ApiServerException r113 = (ApiServerException) r111;
            int r108 = r113.getErrorCode();
            String r114 = r113.getErrorMsg();
            if (r114 != null) goto L17;
            String r109 = "";
        L18:
            r107.getClass();
            dl0.m.z("audience_permit", r108, r109, r104, r112);
            return;
        L17:
            r109 = r114;
            goto L18
        L19:
            dl0.m r115 = dl0.m.f469074a;
            String r116 = r111.toString();
            r115.getClass();
            dl0.m.z("audience_permit", 1, r116, r104, r112);
            return;
        L9:
            r105 = "administrator";
            goto L10
        }
    }

    public final void b() {
        vlc.d r100 = this.f81474a;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
    L6:
        if (this.f81475b.isDisposed() == true) goto L8;
        this.f81475b.dispose();
    L8:
        this.f81478e.clear();
        this.f81479f.clear();
        this.f81480g.clear();
    }

    public o(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f81482i = r100;
        this.f81474a = (vlc.d) r100.get("data_message_manager");
        this.f81475b = new CompositeDisposable();
        this.f81476c = (Room) r100.get("data_room", new Room());
        this.f81477d = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.f81478e = new ArrayList();
        this.f81479f = new HashSet();
        this.f81480g = new HashSet();
    }

    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "linkListener");
        this.f81478e.add(r100);
    }

    public final void f(g r100) {
        Intrinsics.checkNotNullParameter(r100, "linkListener");
        if (this.f81478e.contains(r100) == false) goto L6;
        this.f81478e.remove(r100);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        if ((r110 instanceof xe) == false) goto L17;
        xe r111 = (xe) r110;
        int r100 = (int) r111.getType2();
        if (r100 != 13) goto L7;
        int r101 = r111.getReplyType();
        dl0.m r102 = dl0.m.f469074a;
        Intrinsics.checkNotNullParameter(r111, "message");
        JSONObject r103 = new JSONObject();
        BaseMonitor.add(r103, "reply_type", r101);
        dl0.m.x(r111, r111.getChannelId(), (int) r111.getType2(), System.currentTimeMillis(), r103);
        Intrinsics.checkNotNullParameter(r111, "message");
        dl0.m.y(r111, r111.getChannelId(), (int) r111.getType2(), System.currentTimeMillis());
        Iterator<g> r104 = this.f81478e.iterator();
    L15:
        if (r104.hasNext() == false) goto L22;
        r104.next().Em(r111);
        goto L15
    L22:
        return;
    L7:
        if (r100 != 14) goto L20;
        Intrinsics.checkNotNullParameter(r111, "message");
        dl0.m.y(r111, r111.getChannelId(), (int) r111.getType2(), System.currentTimeMillis());
        Iterator<g> r105 = this.f81478e.iterator();
    L11:
        if (r105.hasNext() == false) goto L21;
        r105.next().nm(r111);
        goto L11
    L21:
        return;
    L20:
        return;
    }

    public final void e(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "uid");
        if (this.f81479f.contains(r110) == false) goto L7;
        ALogger.e("ttlive_pk", "permit request already sent for " + r110);
        return;
    L7:
        if (dl0.p.a().getChannelId() != 0) goto L9;
    L12:
        this.f81479f.add(r110);
        long r100 = System.currentTimeMillis();
        this.f81475b.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).permit(this.f81476c.f162599id, r110, r110.toString(), r111).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r110, r111, r100), new d(this, r110, r111, r100)));
        return;
    L9:
        if (us1.b.a() == true) goto L12;
        f2.b(R.string.ttlive_interact_audience_pk_reject, 0);
    }

    public final void d(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "uid");
        Intrinsics.checkNotNullParameter(r112, "requestFrom");
        long r100 = System.currentTimeMillis();
        Disposable r113 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).kickOut(this.f81476c.f162599id, r110, r110, r111, r112).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r110, r111, r100, r112), new b(this, r110, r111, r100, r112));
        this.f81475b.add(r113);
    }

    public static void c(o r110, long r111, String r112, String r210, int r211, long r212, int r213) {
        if ((r213 & 64) == 0) goto L5;
        long r113 = 0;
    L6:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r112, "uid");
        if (dl0.k.a() == false) goto L10;
        f2.c(s1.B(R.string.ttlive_interact_no_invite_audience_in_break_through), 0);
        return;
    L10:
        if (r110.f81480g.contains(r112) == false) goto L12;
        ALogger.e("ttlive_link", "invite request already sent for " + r112);
        return;
    L12:
        r110.f81480g.add(r112);
        long r114 = System.currentTimeMillis();
        r110.f81475b.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).invite(r111, r210, r211, -1, 0, r113).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r110, r112, r210, r114, 0, r113), new n(r110, r112, r210, r114)));
        return;
    L5:
        r113 = r212;
        goto L6
    }
}
