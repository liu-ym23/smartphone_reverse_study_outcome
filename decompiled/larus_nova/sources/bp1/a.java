package bp1;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.ShopGuideApi;
import com.bytedance.android.livesdk.chatroom.model.k3;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5;
import com.bytedance.android.livesdk.config.setting.o;
import com.bytedance.android.livesdk.config.setting.p;
import com.bytedance.android.livesdk.config.tr0;
import com.bytedance.android.livesdk.config.y9;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.utils.i1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements s<Object> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f19927h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f19928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f19929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f19930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DouyinLoadingLayout f19931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MultiTypeAdapter f19932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bp1.e f19934g;

    /* JADX INFO: renamed from: bp1.a$a, reason: collision with other inner class name */
    public static final class C0326a {
    }

    public static final class b implements bp1.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Context> f19935a;

        /* JADX INFO: renamed from: bp1.a$b$a, reason: collision with other inner class name */
        public static final class C0327a<T1, T2, R> implements BiFunction {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0327a f19936a = null;

            static {
                f19936a = new C0327a();
            }

            public C0327a() {
            }

            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object r100, Object r101) {
                List r102 = (List) r100;
                List r103 = (List) r101;
                Intrinsics.checkNotNullParameter(r102, "userList");
                Intrinsics.checkNotNullParameter(r103, "thirdPartList");
                ArrayList r104 = new ArrayList();
                List r105 = r103;
                Iterator r106 = r105.iterator();
            L3:
                Object r107 = null;
                if (r106.hasNext() == false) goto L8;
                Object r108 = r106.next();
                if (Intrinsics.areEqual(((bp1.d) r108).getType(), IBaseHostShare.SHARE_TO_DAILY) == false) goto L3;
            L9:
                bp1.d r109 = (bp1.d) r108;
                if (r109 == null) goto L12;
                r104.add(r109);
            L12:
                Iterator r110 = r105.iterator();
            L14:
                if (r110.hasNext() == false) goto L18;
                Object r111 = r110.next();
                if (Intrinsics.areEqual(((bp1.d) r111).getType(), "weixin") == false) goto L14;
            L19:
                bp1.d r112 = (bp1.d) r111;
                if (r112 == null) goto L22;
                r104.add(r112);
            L22:
                Iterator r113 = r105.iterator();
            L24:
                if (r113.hasNext() == false) goto L28;
                Object r114 = r113.next();
                if (Intrinsics.areEqual(((bp1.d) r114).getType(), "qq") == false) goto L24;
                r107 = r114;
            L28:
                bp1.d r115 = (bp1.d) r107;
                if (r115 == null) goto L31;
                r104.add(r115);
            L31:
                r104.addAll(r102);
                return r104;
            L18:
                r111 = null;
                goto L19
            L8:
                r108 = null;
                goto L9
            }
        }

        /* JADX INFO: renamed from: bp1.a$b$b, reason: collision with other inner class name */
        public static final class C0328b<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0328b f19937a = null;

            static {
                f19937a = new C0328b();
            }

            public C0328b() {
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                Intrinsics.checkNotNullParameter((Throwable) r100, "it");
                int r101 = a.f19927h;
                ALogger.e("ExtShareEnhancePanel", "zip list error.");
                return CollectionsKt.emptyList();
            }
        }

        @Override // bp1.h
        public final Observable<List<bp1.d>> a() {
            return Observable.zip(Observable.create(c.C0329a.f19938a).compose(RxUtil.rxSchedulerHelper()).onErrorReturn(c.b.f19940a), new d(this.f19935a).a(), C0327a.f19936a).compose(RxUtil.rxSchedulerHelper()).onErrorReturn(C0328b.f19937a);
        }

        public b(WeakReference<Context> r100) {
            Intrinsics.checkNotNullParameter(r100, "contextRef");
            this.f19935a = r100;
        }
    }

    public static final class c implements bp1.h {

        /* JADX INFO: renamed from: bp1.a$c$a, reason: collision with other inner class name */
        public static final class C0329a<T> implements ObservableOnSubscribe {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0329a f19938a = null;

            /* JADX INFO: renamed from: bp1.a$c$a$a, reason: collision with other inner class name */
            public static final class C0330a implements q {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ObservableEmitter f19939a;

                public C0330a(ObservableEmitter r100) {
                    this.f19939a = r100;
                }

                @Override // com.bytedance.android.live.base.model.user.q
                public final void a(List<com.bytedance.android.live.base.model.user.f> r100) {
                    ArrayList r101 = new ArrayList();
                    if ((!r100.isEmpty()) == false) goto L5;
                    List<com.bytedance.android.live.base.model.user.f> r102 = r100;
                L6:
                    if (r102 == null) goto L11;
                    Iterator<T> r103 = r102.iterator();
                L9:
                    if (r103.hasNext() == false) goto L11;
                    ((com.bytedance.android.live.base.model.user.f) r103.next()).getClass();
                L11:
                    int r104 = r101.size();
                    int r105 = a.f19927h;
                    if (r104 < 25) goto L14;
                    r101.add(new bp1.f("chat_merge", s1.B(R.string.ttlive_core_more_panel_share_more), Integer.valueOf(R.drawable.ttlive_ic_share_more_entrance)));
                L14:
                    this.f19939a.onNext(r101);
                    this.f19939a.onComplete();
                    RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
                    if (r106 == null) goto L25;
                    n<h80.d<Pair<Fragment, FragmentManager>>> r107 = r106.getFragmentInfoGetter();
                    if (r107 == null) goto L25;
                    h80.d<Pair<Fragment, FragmentManager>> r108 = r107.getValue();
                    if (r108 == null) goto L25;
                    Pair<Fragment, FragmentManager> r109 = r108.get();
                    if (r109 == null) goto L25;
                    Fragment r110 = r109.getFirst();
                    if (r110 == null) goto L25;
                    TTLiveSDK.hostService().user().fetchActiveStatusList(r110, r100);
                L25:
                    ALogger.i("ExtShareEnhancePanel", "recent user ok.");
                    return;
                L5:
                    r102 = null;
                    goto L6
                }
            }

            static {
                f19938a = new C0329a();
            }

            public C0329a() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter<List<bp1.d>> r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                IHostUser r101 = TTLiveSDK.hostService().user();
                int r102 = a.f19927h;
                r101.loadRecentContact(25, new C0330a(r100));
            }
        }

        public static final class b<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f19940a = null;

            static {
                f19940a = new b();
            }

            public b() {
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                Throwable r101 = (Throwable) r100;
                Intrinsics.checkNotNullParameter(r101, "it");
                int r102 = a.f19927h;
                ALogger.e("ExtShareEnhancePanel", "get recent user list error: " + r101);
                return CollectionsKt.emptyList();
            }
        }

        public c() {
        }

        @Override // bp1.h
        public final Observable<List<bp1.d>> a() {
            return Observable.create(C0329a.f19938a).compose(RxUtil.rxSchedulerHelper()).onErrorReturn(b.f19940a);
        }
    }

    public static final class d implements bp1.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Context> f19941a;

        /* JADX INFO: renamed from: bp1.a$d$a, reason: collision with other inner class name */
        public static final class C0331a<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0331a f19942a = null;

            static {
                f19942a = new C0331a();
            }

            public C0331a() {
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                Intrinsics.checkNotNullParameter((Throwable) r100, "it");
                int r101 = a.f19927h;
                ALogger.e("ExtShareEnhancePanel", "get 3rd list error.");
                return CollectionsKt.emptyList();
            }
        }

        @Override // bp1.h
        public final Observable<List<bp1.d>> a() {
            Context r100 = this.f19941a.get();
            ArrayList r101 = new ArrayList();
            Room r102 = null;
            RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r103 == null) goto L7;
            m<Room> r104 = r103.getRoom();
            if (r104 == null) goto L7;
            r102 = r104.getValue();
        L7:
            Map r105 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.b.a(r102);
            if (p.a() == false) goto L20;
            if (r105 == null) goto L20;
            String r106 = (String) r105.get("ShareStory");
            if (r106 == null) goto L20;
            if (r106.equals("1") != true) goto L20;
            IMiddlewareHostApp r107 = (IMiddlewareHostApp) k.f(IMiddlewareHostApp.class);
            if (r107 == null) goto L18;
            String r108 = r107.replaceBrand(R.string.ttlive_share_to_daily);
            if (r108 == null) goto L18;
        L19:
            r101.add(new bp1.f(IBaseHostShare.SHARE_TO_DAILY, r108, Integer.valueOf(R.drawable.ttlive_ic_share_as_story)));
        L18:
            r108 = "转发日常";
        L20:
            r101.add(new bp1.f("chat_merge", s1.B(R.string.ttlive_core_hs_im), Integer.valueOf(R.drawable.ttlive_ic_share_send_to_douyin)));
            if (puc.a.isInstalledApp(r100, "com.tencent.mm") == false) goto L23;
            r101.add(new bp1.f("weixin", s1.B(R.string.ttlive_third_part_wechat), Integer.valueOf(R.drawable.ttlive_ic_share_wechat)));
            r101.add(new bp1.f("weixin_moments", s1.B(R.string.ttlive_third_part_wechat_friend), Integer.valueOf(R.drawable.ttlive_ic_share_wechat_friends)));
        L23:
            r101.add(new bp1.f("link", s1.B(R.string.ttlive_more_share_to_link_url), Integer.valueOf(R.drawable.ttlive_ic_share_copy_link)));
            if (puc.a.isInstalledApp(r100, "com.tencent.mobileqq") == false) goto L27;
            r101.add(new bp1.f("qq", s1.B(R.string.ttlive_third_part_qq), Integer.valueOf(R.drawable.ttlive_ic_share_qq)));
            r101.add(new bp1.f("qzone", s1.B(R.string.ttlive_third_part_to_qq_zone), Integer.valueOf(R.drawable.ttlive_ic_share_qq_zone)));
        L27:
            if (puc.a.isInstalledApp(r100, "com.sina.weibo") == false) goto L29;
            r101.add(new bp1.f("weibo", s1.B(R.string.ttlive_third_part_weibo), Integer.valueOf(R.drawable.ttlive_ic_share_weibo)));
        L29:
            r101.add(new bp1.f("qr_code", s1.B(R.string.ttlive_more_share_to_qr_code), Integer.valueOf(R.drawable.ttlive_ic_share_qr_code)));
            return Observable.just(CollectionsKt.toList(r101)).compose(RxUtil.rxSchedulerHelper()).onErrorReturn(C0331a.f19942a);
        }

        public d(WeakReference<Context> r100) {
            Intrinsics.checkNotNullParameter(r100, "contextRef");
            this.f19941a = r100;
        }
    }

    public static final class e<T1, T2, R> implements BiFunction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19943a;

        public e(a r100) {
            this.f19943a = r100;
        }

        @Override // io.reactivex.functions.BiFunction
        public final Object apply(Object r100, Object r101) {
            bp1.i r102 = (bp1.i) r100;
            List r103 = (List) r101;
            Intrinsics.checkNotNullParameter(r102, "shopData");
            Intrinsics.checkNotNullParameter(r103, "itemList");
            a r104 = this.f19943a;
            r104.f19933f = true;
            if (r102.f19965c == false) goto L7;
            TextView r105 = r104.f19929b;
            if (r105 == null) goto L10;
            r105.setText(R.string.ttlive_share_shop_id_title);
        L10:
            int r106 = a.f19927h;
            ALogger.i("ExtShareEnhancePanel", "data is ok.");
            Iterator r107 = r103.iterator();
        L12:
            if (r107.hasNext() == false) goto L14;
            ((bp1.d) r107.next()).f19959h = r102;
            goto L12
        L14:
            return r103;
        L7:
            TextView r108 = r104.f19929b;
            if (r108 == null) goto L10;
            r108.setText(R.string.ttlive_enhance_share_area_title);
            goto L10
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f19945b;

        public f(a r100, DataCenter r101) {
            this.f19944a = r100;
            this.f19945b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            a r102 = this.f19944a;
            r102.f19933f = true;
            DouyinLoadingLayout r103 = r102.f19931d;
            if (r103 == null) goto L5;
            r103.c();
        L5:
            ArrayList r104 = new ArrayList();
            if (r101 == null) goto L10;
            List r105 = r101;
            if ((!r105.isEmpty()) != true) goto L10;
            r104.addAll(r105);
        L10:
            Iterator r106 = r104.iterator();
        L11:
            String r107 = null;
            if (r106.hasNext() == false) goto L16;
            Object r108 = r106.next();
            if (Intrinsics.areEqual(((bp1.d) r108).getType(), IBaseHostShare.SHARE_TO_DAILY) == false) goto L11;
        L18:
            if (((bp1.d) r108) == null) goto L40;
            a r109 = this.f19944a;
            DataCenter r110 = this.f19945b;
            r109.getClass();
            if (r110 == null) goto L22;
            Room r111 = (Room) r110.get("data_room", null);
        L23:
            HashMap r112 = new HashMap();
            if (r111 == null) goto L26;
            String r113 = r111.getOwnerUserIdString();
        L27:
            r112.put("anchor_id", String.valueOf(r113));
            if (r111 == null) goto L30;
            r107 = r111.getIdStr();
        L30:
            r112.put("room_id", String.valueOf(r107));
            r112.put("enter_from_merge", String.valueOf(u.l().c(x.class).getMap().get("enter_from_merge")));
            r112.put("enter_method", String.valueOf(u.l().c(x.class).getMap().get("enter_method")));
            r112.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
            r112.put("request_page", "more");
            if (r111 == null) goto L37;
            User r114 = r111.mo8271getOwner();
            if (r114 == null) goto L37;
            if (r114.isFollowing() != true) goto L37;
            String r115 = "1";
        L38:
            r112.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_FANS, r115);
            u.l().sendLog("livesdk_share_to_diary_show", r112, new Object[]{new x(), Room.class});
        L37:
            r115 = "0";
            goto L38
        L26:
            r113 = null;
            goto L27
        L22:
            r111 = null;
        L40:
            if (r104.size() <= 3) goto L44;
            View r116 = this.f19944a.f19930c;
            if (r116 == null) goto L48;
            UtilityKotlinExtentionsKt.w(r116);
        L48:
            MultiTypeAdapter r117 = this.f19944a.f19932e;
            if (r117 == null) goto L51;
            r117.f513437a = r104;
        L51:
            if (r117 == null) goto L53;
            r117.notifyDataSetChanged();
        L53:
            int r118 = a.f19927h;
            ALogger.i("ExtShareEnhancePanel", "load success.");
            return;
        L44:
            View r119 = this.f19944a.f19930c;
            if (r119 == null) goto L47;
            UtilityKotlinExtentionsKt.u(r119);
        L47:
            this.f19944a.getClass();
            r104.add(new bp1.f("host_share_dialog", s1.B(R.string.ttlive_more_share_to_more_share_dialog), Integer.valueOf(R.drawable.ttlive_enhance_share_icon)));
            goto L48
        L16:
            r108 = null;
            goto L18
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19946a;

        public g(a r100) {
            this.f19946a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            a r102 = this.f19946a;
            r102.f19933f = true;
            DouyinLoadingLayout r103 = r102.f19931d;
            if (r103 == null) goto L5;
            r103.c();
        L5:
            int r104 = a.f19927h;
            ALogger.e("ExtShareEnhancePanel", "load share panel data error.");
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataCenter f19947a;

        public h(DataCenter r100) {
            this.f19947a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c0.b r101 = y3.f(this.f19947a).t(ToolbarButton.SHARE);
            if ((r101 instanceof e5) == true) goto L5;
            r101 = null;
        L5:
            e5 r102 = (e5) r101;
            if (r102 == null) goto L8;
            r102.f117146o = "ext_more";
            r102.onClick(null);
            r102.f117146o = "";
        L8:
            DataCenter r103 = this.f19947a;
            if (r103 == null) goto L12;
            r103.put("cmd_live_toolbarmore_dialog_dismiss", Boolean.TRUE);
            return;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19948a;

        public i(a r100) {
            this.f19948a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f19948a;     // Catch: Throwable -> L8
            if (r100.f19933f == true) goto L11;
            DouyinLoadingLayout r101 = r100.f19931d;     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.b();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void j() {
        this.f19928a = null;
        this.f19932e = null;
    }

    public a() {
        this.f19934g = new bp1.e();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final View x(ViewGroup r100, float r101, com.bytedance.android.livesdk.chatroom.e r102) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_toolbar_enhance_share_area, r100, false);
        DouyinLoadingLayout r104 = null;
        if (r103 == null) goto L5;
        TextView r105 = (TextView) r103.findViewById(R.id.area_title);
    L6:
        this.f19929b = r105;
        if (r103 == null) goto L9;
        RecyclerView r106 = (RecyclerView) r103.findViewById(R.id.area_content_rv);
    L10:
        this.f19928a = r106;
        if (r103 == null) goto L13;
        View r107 = r103.findViewById(R.id.ext_panel_share_behavior);
    L14:
        this.f19930c = r107;
        if (r103 == null) goto L17;
        r104 = (DouyinLoadingLayout) r103.findViewById(R.id.ext_share_panel_loading_view);
    L17:
        this.f19931d = r104;
        if (r104 == null) goto L20;
        r104.postDelayed(new i(this), 300);
    L20:
        RecyclerView r108 = this.f19928a;
        if (r108 == null) goto L26;
        r108.setLayoutManager(new LinearLayoutManager(r108.getContext(), 0, false));
        MultiTypeAdapter r109 = new MultiTypeAdapter();
        r109.z2(bp1.d.class, this.f19934g);
        Unit r110 = Unit.INSTANCE;
        this.f19932e = r109;
        RecyclerView r111 = this.f19928a;
        if (r111 == null) goto L26;
        r111.setAdapter(r109);
    L26:
        return r103;
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void o(WeakReference<b2> r110, Object r111, View r210, int r211) {
        Intrinsics.checkNotNullParameter(r111, "button");
        Intrinsics.checkNotNullParameter(r210, "itemView");
        if (r110 == null) goto L76;
        b2 r100 = r110.get();
        if (r100 == null) goto L78;
        DataCenter r101 = r100.getDataCenter();
        if (r101 != null) goto L10;
        return;
    L10:
        this.f19934g.f19960b = r101;
        Room r102 = z.o(r101);
        if (r102 == null) goto L13;
        i1.d(r102, "click");
    L13:
        CompositeDisposable r103 = r100.getCompositeDisposable();
        if (r103 != null) goto L16;
        r103 = new CompositeDisposable();
    L16:
        boolean r104 = false;
        Single r105 = Single.just(new bp1.i(0));
        int r106 = com.bytedance.android.livesdk.chatroom.utils.y3.f114673a;
        bp1.h r107 = null;
        Context r108 = null;
        Context r109 = null;
        if (y9.f121666a.getValue().booleanValue() == true) goto L19;
    L34:
        Observable r112 = r105.toObservable();
        if (o.b() == true) goto L37;
    L39:
        boolean r113 = false;
    L40:
        if (r113 == false) goto L43;
        r107 = new c();
    L64:
        if (r107 == null) goto L68;
        Observable<List<bp1.d>> r114 = r107.a();
        if (r114 == null) goto L68;
    L69:
        Disposable r115 = Observable.zip(r112, r114, new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r101), new g(this));
        if (r115 == null) goto L72;
        RxUtilKt.c(r115, r103);
    L72:
        View r116 = this.f19930c;
        if (r116 == null) goto L77;
        r116.setOnClickListener(new h(r101));
        return;
    L77:
        return;
    L68:
        r114 = Observable.just(CollectionsKt.emptyList());
        goto L69
    L43:
        if (o.b() == true) goto L45;
    L47:
        boolean r117 = false;
    L48:
        if (r117 == false) goto L55;
        RecyclerView r118 = this.f19928a;
        if (r118 == null) goto L52;
        r108 = r118.getContext();
    L52:
        bp1.h r119 = new d(new WeakReference(r108));
    L53:
        r107 = r119;
        goto L64
    L55:
        if (o.b() == true) goto L57;
    L59:
        if (r104 == false) goto L64;
        RecyclerView r120 = this.f19928a;
        if (r120 == null) goto L63;
        r109 = r120.getContext();
    L63:
        r119 = new b(new WeakReference(r109));
        goto L53
    L57:
        if (tr0.f121321a.getValue().c() != 3) goto L59;
        r104 = true;
        goto L59
    L45:
        if (tr0.f121321a.getValue().c() != 2) goto L47;
        r117 = true;
        goto L48
    L37:
        if (tr0.f121321a.getValue().c() != 1) goto L39;
        r113 = true;
        goto L40
    L19:
        if (((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().isLogin() == false) goto L34;
        if (tb1.c.f545235g == false) goto L34;
        long r121 = z.o(r101).getId();
        String r122 = z.o(r101).getOwnerUserIdString();
        Intrinsics.checkNotNullParameter(r122, "userId");
        l.d().getClass();
        ShopGuideApi r123 = (ShopGuideApi) com.bytedance.android.live.network.c.b().e(ShopGuideApi.class);
        if (r123 == null) goto L25;
        Single<Response<k3>> r124 = r123.queryShopGuideId(r121, r122, null, null, null, null, null, null);
    L26:
        if (r124 == null) goto L34;
        Single<R> r125 = r124.compose(RxUtil.rxSchedulerHelper());
        if (r125 == 0) goto L34;
        Single r126 = r125.map(bp1.b.f19949a);
        if (r126 == null) goto L34;
        Single r127 = r126.onErrorReturn(bp1.c.f19950a);
        if (r127 == null) goto L34;
        r105 = r127;
        goto L34
    L25:
        r124 = null;
        goto L26
    L78:
        return;
    }
}
