package com.bytedance.android.live.service.prerequest;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.NewProfileDialogLauncher;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.repository.NewProfileApi;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kc0.j;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rs0.k0;
import rs0.q0;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements com.bytedance.android.live.service.prerequest.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f100896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> f100897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Boolean> f100898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Integer> f100899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f100900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f100901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1537b f100902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f100903h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.service.prerequest.b$b, reason: collision with other inner class name */
    public static final class C1537b implements kc0.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f100904a;

        public C1537b(b r100) {
            this.f100904a = r100;
        }

        @Override // kc0.f
        public final void a(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "userIds");
            this.f100904a.getClass();
            if (b.f() == true) goto L5;
            return;
        L5:
            m<IRoom> r101 = this.f100904a.f100903h.getRoom();
            if (r101 == null) goto L13;
            IRoom r102 = r101.getValue();
            if (r102 == null) goto L13;
            if (r102.isMergeVSRoom() != true) goto L13;
            return;
        L13:
            if (q0.f539075a.getValue().c() == false) goto L20;
            ((ArrayList) this.f100904a.f100901f).clear();
            ((ArrayList) this.f100904a.f100901f).addAll(r100);
            Iterator r103 = ((ArrayList) this.f100904a.f100901f).iterator();
        L16:
            if (r103.hasNext() == false) goto L26;
            String r104 = (String) r103.next();
            if (((LinkedHashMap) this.f100904a.f100897b).get(r104) != null) goto L16;
            this.f100904a.g(r104, false);
            ALogger.i("NewUserProfile_ProfilePre", "PreRequestManager onLinkAnchorsChanged, preRequest anchorId : " + r104);
            goto L16
        L26:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f100905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f100906b;

        public c(b r100, String r101) {
            this.f100905a = r100;
            this.f100906b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BaseResponse r101 = (BaseResponse) r100;
            ALogger.i("NewUserProfile_ProfilePre", "进房预请求mock成功");
            ProfileMonitor.a r102 = ProfileMonitor.f86091g;
            String r103 = this.f100906b;
            IMiddlewareUserService r104 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
            String r105 = null;
            if (r104 == null) goto L7;
            com.bytedance.android.livesdk.user.e r106 = r104.user();
            if (r106 == null) goto L7;
            String r107 = r106.n();
        L8:
            String r108 = String.valueOf(r107);
            m<IRoom> r109 = this.f100905a.f100903h.getRoom();
            if (r109 == null) goto L15;
            IRoom r110 = r109.getValue();
            if (r110 == null) goto L15;
            IBaseUser r111 = r110.getOwner();
            if (r111 == null) goto L15;
            r105 = r111.getIdString();
        L15:
            String r112 = String.valueOf(r105);
            m<IRoom> r113 = this.f100905a.f100903h.getRoom();
            if (r113 == null) goto L20;
            IRoom r114 = r113.getValue();
            if (r114 == null) goto L20;
            long r115 = r114.getRoomId();
        L21:
            r102.getClass();
            ProfileMonitor.a.b(r103, r108, r112, r115, "");
            return;
        L20:
            r115 = 0;
        L7:
            r107 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f100907a = null;

        static {
            f100907a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            StringBuilder r102 = new StringBuilder("进房预请求mock失败，error: ");
            if (r101 == null) goto L5;
            String r103 = r101.getMessage();
        L6:
            r102.append(r103);
            ALogger.e("NewUserProfile_ProfilePre", r102.toString());
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f100908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f100909b;

        public e(b r100, String r101) {
            this.f100908a = r100;
            this.f100909b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BaseResponse r101 = (BaseResponse) r100;
            ALogger.i("NewUserProfile_ProfilePre", "进房预请求成功: 预请求uid   " + this.f100909b);
            ((HashMap) this.f100908a.f100897b).put(this.f100909b, r101);
            ProfileMonitor.a r102 = ProfileMonitor.f86091g;
            String r103 = this.f100909b;
            IMiddlewareUserService r104 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
            String r105 = null;
            if (r104 == null) goto L7;
            com.bytedance.android.livesdk.user.e r106 = r104.user();
            if (r106 == null) goto L7;
            String r107 = r106.n();
        L8:
            String r108 = String.valueOf(r107);
            m<IRoom> r109 = this.f100908a.f100903h.getRoom();
            if (r109 == null) goto L15;
            IRoom r110 = r109.getValue();
            if (r110 == null) goto L15;
            IBaseUser r111 = r110.getOwner();
            if (r111 == null) goto L15;
            r105 = r111.getIdString();
        L15:
            String r112 = String.valueOf(r105);
            m<IRoom> r113 = this.f100908a.f100903h.getRoom();
            if (r113 == null) goto L20;
            IRoom r114 = r113.getValue();
            if (r114 == null) goto L20;
            long r115 = r114.getRoomId();
        L21:
            String r116 = r101.logId;
            if (r116 != null) goto L24;
            r116 = "";
        L24:
            r102.getClass();
            ProfileMonitor.a.b(r103, r108, r112, r115, r116);
            return;
        L20:
            r115 = 0;
        L7:
            r107 = null;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f100910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f100911b;

        public f(b r100, String r101) {
            this.f100910a = r100;
            this.f100911b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            StringBuilder r102 = new StringBuilder("PreRequestManager request error: ");
            if (r101 == null) goto L5;
            String r103 = r101.getMessage();
        L6:
            r102.append(r103);
            r102.append(' ');
            ALogger.e("NewUserProfile_ProfilePre", r102.toString());
            ProfileMonitor.a r104 = ProfileMonitor.f86091g;
            String r105 = this.f100911b;
            IMiddlewareUserService r106 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
            if (r106 == null) goto L11;
            com.bytedance.android.livesdk.user.e r107 = r106.user();
            if (r107 == null) goto L11;
            String r108 = r107.n();
        L12:
            String r109 = String.valueOf(r108);
            m<IRoom> r110 = this.f100910a.f100903h.getRoom();
            if (r110 == null) goto L19;
            IRoom r111 = r110.getValue();
            if (r111 == null) goto L19;
            IBaseUser r112 = r111.getOwner();
            if (r112 == null) goto L19;
            String r113 = r112.getIdString();
        L20:
            String r114 = String.valueOf(r113);
            m<IRoom> r115 = this.f100910a.f100903h.getRoom();
            if (r115 == null) goto L25;
            IRoom r116 = r115.getValue();
            if (r116 == null) goto L25;
            long r117 = r116.getRoomId();
        L27:
            if ((r101 instanceof CustomApiServerException) == true) goto L29;
            r101 = null;
        L29:
            CustomApiServerException r118 = (CustomApiServerException) r101;
            if (r118 == null) goto L33;
            String r119 = r118.getXTtLogId();
            if (r119 == null) goto L33;
        L34:
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "preRequestUid");
            Intrinsics.checkNotNullParameter(r109, "currentId");
            Intrinsics.checkNotNullParameter(r114, "anchorId");
            Intrinsics.checkNotNullParameter(r119, "logId");
            Map<String, String> r120 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pre_uid", String.valueOf(r105)), TuplesKt.to("current_id", r109), TuplesKt.to("anchor_id", r114), TuplesKt.to("room_id", String.valueOf(r117)), TuplesKt.to("log_id", r119)});
            ProfileMonitor.a.a(r120);
            j0.l().sendLog("livesdk_profile_pre_request_fail", r120, new Object[0]);
            return;
        L33:
            r119 = "";
        L25:
            r117 = 0;
        L19:
            r113 = null;
        L11:
            r108 = null;
            goto L12
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    public static boolean f() {
        return q0.f539075a.getValue().b();
    }

    public b(o r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        this.f100903h = r100;
        this.f100896a = new CompositeDisposable();
        this.f100897b = new LruHashMap(10);
        this.f100898c = new HashMap();
        this.f100899d = new HashMap();
        this.f100901f = new ArrayList();
        this.f100902g = new C1537b(this);
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return ((ArrayList) this.f100901f).contains(r100);
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        ((HashMap) this.f100897b).remove(r100);
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final Pair<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>, Integer> d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Integer r100 = (Integer) ((HashMap) this.f100899d).get(r110);
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        int r102 = r101 + 1;
        ((HashMap) this.f100899d).put(r110, Integer.valueOf(r102));
        BaseResponse r103 = (BaseResponse) ((LinkedHashMap) this.f100897b).get(r110);
        String r104 = null;
        if (((ArrayList) this.f100901f).contains(r110) == false) goto L12;
        boolean r105 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        if (((j) com.bytedance.android.live.revenue.core.util.h.d(j.class)).getRevLinkControlService().n() == true) goto L12;
        return TuplesKt.to(null, Integer.valueOf(r102));
    L12:
        if (r103 == null) goto L36;
        if (Intrinsics.areEqual((Boolean) ((HashMap) this.f100898c).get(r110), Boolean.FALSE) == false) goto L36;
        ProfileMonitor.a r106 = ProfileMonitor.f86091g;
        IMiddlewareUserService r107 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r107 == null) goto L20;
        com.bytedance.android.livesdk.user.e r108 = r107.user();
        if (r108 == null) goto L20;
        String r109 = r108.n();
    L21:
        String r111 = String.valueOf(r109);
        m<IRoom> r112 = this.f100903h.getRoom();
        if (r112 == null) goto L28;
        IRoom r113 = r112.getValue();
        if (r113 == null) goto L28;
        IBaseUser r114 = r113.getOwner();
        if (r114 == null) goto L28;
        r104 = r114.getIdString();
    L28:
        String r115 = String.valueOf(r104);
        m<IRoom> r116 = this.f100903h.getRoom();
        if (r116 == null) goto L33;
        IRoom r117 = r116.getValue();
        if (r117 == null) goto L33;
        long r118 = r117.getRoomId();
    L34:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r110, "preRequestUid");
        Intrinsics.checkNotNullParameter(r111, "currentId");
        Intrinsics.checkNotNullParameter(r115, "anchorId");
        Map<String, String> r119 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pre_uid", r110), TuplesKt.to("current_id", r111), TuplesKt.to("anchor_id", r115), TuplesKt.to("room_id", String.valueOf(r118))});
        ProfileMonitor.a.a(r119);
        j0.l().sendLog("livesdk_profile_pre_request_hit", r119, new Object[0]);
    L33:
        r118 = 0;
    L20:
        r109 = null;
    L36:
        return TuplesKt.to(r103, Integer.valueOf(r102));
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final boolean c(IRoom r100, UserProfileEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (f() == true) goto L5;
        return false;
    L5:
        IBaseUser r102 = r101.user;
        if (r102 != null) goto L8;
        String r103 = r101.getUserIdStr();
    L9:
        String r104 = r100.getOwnerUserIdString();
        IMiddlewareUserService r105 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r105 == null) goto L14;
        com.bytedance.android.livesdk.user.e r106 = r105.user();
        if (r106 == null) goto L14;
        String r107 = r106.n();
    L16:
        if (q0.f539075a.getValue().c() == false) goto L24;
        if ((!Intrinsics.areEqual(r107, r104)) == true) goto L20;
        return false;
    L20:
        if (r100.isMergeVSRoom() == true) goto L32;
        return true;
    L32:
        return false;
    L24:
        if (Intrinsics.areEqual(r103, r104) == true) goto L26;
        return false;
    L26:
        if ((!Intrinsics.areEqual(r107, r104)) == true) goto L28;
        return false;
    L28:
        if (r100.isMergeVSRoom() == true) goto L35;
        return true;
    L35:
        return false;
    L14:
        r107 = null;
        goto L16
    L8:
        r103 = r102.getIdString();
        goto L9
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final void e(String r100, BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "response");
        if (f() == true) goto L5;
        return;
    L5:
        if (q0.f539075a.getValue().g() == false) goto L10;
        Map<String, Boolean> r102 = this.f100898c;
        HashMap r103 = (HashMap) r102;
        r103.put(r100, Boolean.TRUE);
        ALogger.i("NewUserProfile_ProfilePre", "缓存更新成功，uid :  ".concat(r100));
        ((HashMap) this.f100897b).put(r100, r101);
        return;
    }

    public final void g(String r410, boolean r411) {
        Integer r100 = (Integer) ((HashMap) this.f100899d).get(r410);
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        if (r102 <= 0) goto L10;
        ALogger.i("NewUserProfile_ProfilePre", "pre request return: getCacheCount = " + r102 + ", isRecycled = " + this.f100898c);
        return;
    L10:
        if (ys0.c.a() == false) goto L23;
        ys0.a r103 = ys0.b.f568985a.getValue();
        NewProfileApi r104 = (NewProfileApi) os0.b.c().getTestHttpClientService(NewProfileApi.class);
        if (r104 == null) goto L178;
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r105 = r104.mockQuery(r103.b(), r103.a());
        if (r105 == null) goto L179;
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r106 = r105.subscribeOn(Schedulers.io());
        if (r106 == null) goto L180;
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r107 = r106.observeOn(AndroidSchedulers.mainThread());
        if (r107 == null) goto L181;
        Disposable r108 = r107.subscribe(new c(this, r410), d.f100907a);
        if (r108 == null) goto L182;
        RxUtilKt.c(r108, this.f100896a);
        return;
    L182:
        return;
    L181:
        return;
    L180:
        return;
    L179:
        return;
    L178:
        return;
    L23:
        m<IRoom> r109 = this.f100903h.getRoom();
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r110 = null;
        if (r109 == null) goto L30;
        IRoom r111 = r109.getValue();
        if (r111 == null) goto L30;
        IBaseUser r112 = r111.getOwner();
        if (r112 == null) goto L30;
        String r113 = r112.getIdString();
    L31:
        boolean r114 = TextUtils.equals(r410, r113);
        if (r114 == false) goto L104;
        qs0.e r115 = os0.b.c().getIHostCommerceServiceLive();
        if (r115 == null) goto L36;
        JSONObject r116 = r115.i();
    L37:
        if (r116 == null) goto L101;
        int r117 = NewProfileDialogLauncher.f85947f;
        Object r118 = r116.opt("live_click_products");
        if ((r118 instanceof ArrayList) == true) goto L42;
        r118 = null;
    L42:
        ArrayList r119 = (ArrayList) r118;
        String r120 = r116.optString("live_explain_product");
        Object r121 = r116.opt("live_show_products");
        if ((r121 instanceof ArrayList) == true) goto L45;
        r121 = null;
    L45:
        ArrayList r122 = (ArrayList) r121;
        ArrayList r123 = new ArrayList();
        if (r119 == null) goto L66;
        if (r119.size() > 0) goto L50;
    L52:
        boolean r124 = false;
    L53:
        if (r124 == true) goto L56;
        r119 = null;
    L56:
        if (r119 == null) goto L66;
        Iterator r125 = r119.iterator();
    L59:
        if (r125.hasNext() == false) goto L66;
        Object r126 = r125.next();
        if (r126 == null) goto L64;
        r123.add((String) r126);
        goto L59
    L64:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L50:
        if ((ListProtector.get(r119, 0) instanceof String) == false) goto L52;
        r124 = true;
    L66:
        if (r120.length() <= 0) goto L68;
        boolean r127 = true;
    L69:
        if (r127 == false) goto L71;
        r123.add(r120);
    L71:
        if (r122 != null) goto L73;
    L90:
        Iterator r128 = r123.iterator();
        if (r128.hasNext() == true) goto L93;
        String r129 = "";
    L100:
        if (r129 == null) goto L101;
    L102:
        String r310 = r129;
    L105:
        if (r114 == false) goto L109;
        if (r411 == false) goto L108;
        String r130 = "pre_request_manager_predict";
    L110:
        String r412 = r130;
        NewProfileApi r131 = (NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class);
        if (r131 != null) goto L113;
    L164:
        if (r110 == null) goto L183;
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r132 = r110.subscribeOn(Schedulers.io());
        if (r132 == null) goto L184;
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r133 = r132.observeOn(AndroidSchedulers.mainThread());
        if (r133 == null) goto L185;
        Disposable r134 = r133.subscribe(new e(this, r410), new f(this, r410));
        if (r134 == null) goto L186;
        RxUtilKt.c(r134, this.f100896a);
        return;
    L186:
        return;
    L185:
        return;
    L184:
        return;
    L183:
        return;
    L113:
        if (r410 == null) goto L117;
        Long r135 = StringsKt.toLongOrNull(r410);
        if (r135 == null) goto L117;
        long r136 = r135.longValue();
    L118:
        m<IRoom> r137 = this.f100903h.getRoom();
        if (r137 == null) goto L129;
        IRoom r138 = r137.getValue();
        if (r138 == null) goto L129;
        IBaseUser r139 = r138.getOwner();
        if (r139 == null) goto L129;
        String r140 = r139.getIdString();
        if (r140 == null) goto L129;
        Long r141 = StringsKt.toLongOrNull(r140);
        if (r141 == null) goto L129;
        long r142 = r141.longValue();
    L130:
        m<IRoom> r143 = this.f100903h.getRoom();
        if (r143 == null) goto L140;
        IRoom r144 = r143.getValue();
        if (r144 == null) goto L140;
        IBaseUser r145 = r144.getOwner();
        if (r145 == null) goto L140;
        Intrinsics.checkNotNullParameter(r145, "$this$secUidExt");
        String r146 = r145.getCastSecUid();
        if (r146 == null) goto L140;
        String r147 = r146;
    L141:
        m<IRoom> r148 = this.f100903h.getRoom();
        if (r148 == null) goto L146;
        IRoom r149 = r148.getValue();
        if (r149 == null) goto L146;
        long r150 = r149.getRoomId();
    L147:
        IMiddlewareUserService r151 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r151 == null) goto L156;
        com.bytedance.android.livesdk.user.e r152 = r151.user();
        if (r152 == null) goto L156;
        String r153 = r152.n();
        if (r153 == null) goto L156;
        Long r154 = StringsKt.toLongOrNull(r153);
        if (r154 == null) goto L156;
        long r210 = r154.longValue();
    L157:
        long r311 = k0.f539063a.getValue().longValue();
        int r155 = gv1.a.f482816a;
        if (ev1.e.f474215a.getValue().intValue() <= 0) goto L160;
        r101 = true;
    L160:
        if (r101 == false) goto L162;
        long r413 = 1;
    L163:
        r110 = r131.queryOpenPreloadProfile(r136, "", r142, r147, r150, r210, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, r310, r311, r413, r412, false);
        goto L164
    L162:
        r413 = 0;
    L156:
        r210 = 0;
    L146:
        r150 = 0;
    L140:
        r147 = "";
    L129:
        r142 = 0;
    L117:
        r136 = 0;
        goto L118
    L108:
        r130 = "pre_request_manager";
        goto L110
    L109:
        r130 = "pre_request_other_anchor";
        goto L110
    L93:
        StringBuilder r156 = new StringBuilder();
    L94:
        Object r157 = r128.next();
        if (r157 != r123) goto L97;
        r157 = "(this Collection)";
    L97:
        r156.append(r157);
        if (r128.hasNext() == false) goto L99;
        r156.append(',');
        goto L94
    L99:
        r129 = r156.toString();
        goto L100
    L73:
        if (r122.size() > 0) goto L75;
    L77:
        boolean r158 = false;
    L78:
        if (r158 == true) goto L81;
        r122 = null;
    L81:
        if (r122 == null) goto L90;
        Iterator r159 = r122.iterator();
    L84:
        if (r159.hasNext() == false) goto L90;
        Object r160 = r159.next();
        if (r160 == null) goto L89;
        r123.add((String) r160);
        goto L84
    L89:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L75:
        if ((ListProtector.get(r122, 0) instanceof String) == false) goto L77;
        r158 = true;
        goto L78
    L68:
        r127 = false;
    L101:
        r129 = "";
        goto L102
    L36:
        r116 = null;
        goto L37
    L104:
        r310 = "";
    L30:
        r113 = null;
        goto L31
    L5:
        r102 = 0;
        goto L6
    }
}
