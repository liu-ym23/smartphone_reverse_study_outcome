package com.bytedance.android.livesdk.announcement.highlight;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.announcement.AnnouncementApi;
import com.bytedance.android.livesdk.config.be;
import com.bytedance.android.livesdk.interactivity.api.DragContainer;
import com.bytedance.android.livesdk.k4;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.j2;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/highlight/AnnouncementHighlightAudienceWidget;", "Lcom/bytedance/android/livesdk/announcement/highlight/AbsAnnouncementHighlightWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementHighlightAudienceWidget extends AbsAnnouncementHighlightWidget {
    public static final /* synthetic */ int C = 0;
    public final CompositeDisposable A;
    public final b B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f103443v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HighlightItem.b f103444w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f103445x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f103446y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Boolean f103447z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAudienceWidget f103448a;

        public b(AnnouncementHighlightAudienceWidget r100) {
            this.f103448a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            if (r101 == null) goto L5;
            Object r102 = r101.getData();
        L7:
            if ((r102 instanceof j2) == false) goto L16;
            j2 r103 = (j2) r102;
            if (Intrinsics.areEqual(r103.f571863a, Boolean.TRUE) == false) goto L17;
            int r104 = r103.f571864b;
            if (r104 <= com.bytedance.android.livesdk.chatroom.y.f119321d) goto L18;
            DragContainer r105 = this.f103448a.f103379g;
            if (r105 == null) goto L19;
            a1.o(r105, r104);
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAudienceWidget f103449a;

        public c(AnnouncementHighlightAudienceWidget r100) {
            this.f103449a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AnnouncementHighlightAudienceWidget r101 = this.f103449a;
            boolean r102 = ((AnnouncementApi.QueryAnnouncementInfoResoponseOpt) ((BaseResponse) r100).data).getHasSubscribed();
            int r103 = AnnouncementHighlightAudienceWidget.C;
            r101.Rq(r102);
            int r104 = com.bytedance.android.livesdk.announcement.f.f103363a;
            AnnouncementHighlightAudienceWidget r105 = this.f103449a;
            HighlightItem.b r106 = r105.f103444w;
            boolean r107 = r105.f103443v;
            com.bytedance.android.livesdk.announcement.f.h(false, r106, !r107, r107);
            c0.d(false, "highlight");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f103450a = null;

        static {
            f103450a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            x8.a.c("anchor_highlight", (Throwable) r100, false);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAudienceWidget f103451a;

        public e(AnnouncementHighlightAudienceWidget r100) {
            this.f103451a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            c0.a("time_up");
            AnnouncementHighlightAudienceWidget r102 = this.f103451a;
            r102.f103445x = true;
            r102.Gq("audience_time_up");
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAudienceWidget f103452a;

        public f(AnnouncementHighlightAudienceWidget r100) {
            this.f103452a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnouncementHighlightAudienceWidget r100 = this.f103452a;     // Catch: Throwable -> L4
            int r101 = AnnouncementHighlightAudienceWidget.C;     // Catch: Throwable -> L4
            r100.Mq();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAudienceWidget f103453a;

        public g(AnnouncementHighlightAudienceWidget r100) {
            this.f103453a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            int r102 = d0.f103472a;
            ImageView r103 = this.f103453a.f103387o;
            Intrinsics.checkNotNull(r103);
            d0.a(r103);
            this.f103453a.A.add(Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this)));
        }
    }

    public final class h implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f103454a;

        public h(Function1 r100) {
            this.f103454a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f103454a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.announcement.highlight.AnnouncementHighlightAudienceWidget$onLoad$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/highlight/e0;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/announcement/highlight/e0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<e0, Unit> {
        public AnonymousClass1(AnnouncementHighlightAudienceWidget r100) {
            super(1, r100, AnnouncementHighlightAudienceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/announcement/highlight/SubscribeAnchorPlayNotifyEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(e0 r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            AnnouncementHighlightAudienceWidget r101 = (AnnouncementHighlightAudienceWidget) this.receiver;
            int r102 = AnnouncementHighlightAudienceWidget.C;
            r101.getClass();
            r101.Rq(r100.f103474a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(e0 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void Mq() {
        DragContainer r100 = this.f103379g;
        int r101 = 0;
        if (r100 != null) goto L5;
    L7:
        o32.b r102 = com.bytedance.android.livesdk.interactivity.api.o.a();
        if (r102 != null) goto L10;
    L17:
        Kq("audience announcement bottom change");
        return;
    L10:
        if ((!r102.getCleared()) == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L17;
        com.bytedance.live.datacontext.m<Integer> r103 = r102.getAnnouncementBottom();
        if (r103 == null) goto L17;
        r103.setValue(Integer.valueOf(r101));
        goto L17
    L5:
        if (r100.getVisibility() != 0) goto L7;
        r101 = (int) (r100.getY() + r100.getHeight());
        goto L7
    }

    public final void Qq() {
        if (this.f103446y == true) goto L5;
    L7:
        f2.c(s1.B(R.string.ttlive_announcement_highlight_subscribe_succeed_toast), 0);
        return;
    L5:
        if (this.f103447z.booleanValue() == false) goto L7;
        f2.c(s1.B(R.string.ttlive_announcement_highlight_red_packet_subscribe_succeed_toast), 0);
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget
    public final boolean xq() {
        return !this.f103445x;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget
    public final void yq() {
        DragContainer r100 = this.f103379g;
        if (r100 == null) goto L5;
        r100.setEnableDrag(false);
    L5:
        TextView r101 = this.f103380h;
        if (r101 == null) goto L8;
        r101.setTextColor(s1.h(R.color.ttlive_announcement_highlight_title_color_audience));
    L8:
        ImageView r102 = this.f103381i;
        if (r102 == null) goto L11;
        r102.setOnClickListener(new w0(new AnnouncementHighlightAudienceWidget$customDragView$1(this), 500));
    L11:
        TextView r103 = this.f103382j;
        if (r103 == null) goto L14;
        r103.setTextColor(s1.h(R.color.ttlive_announcement_highlight_time_color_audience));
    L14:
        ViewGroup r104 = this.f103385m;
        if (r104 == null) goto L17;
        r104.setOnClickListener(new w0(new AnnouncementHighlightAudienceWidget$customDragView$2(this), 500));
    L17:
        RelativeLayout r105 = this.f103383k;
        if (r105 == null) goto L20;
        r105.setVisibility(8);
    L20:
        ViewGroup r106 = this.f103385m;
        if (r106 == null) goto L23;
        r106.setVisibility(0);
    L23:
        DragContainer r107 = this.f103379g;
        if (r107 == null) goto L45;
        ViewGroup r108 = this.containerView;
        if (r108 == null) goto L28;
        r108.addView(r107);
    L28:
        DataCenter r109 = this.dataCenter;
        Integer r110 = null;
        if (r109 == null) goto L31;
        j2 r111 = (j2) r109.get("cmd_portrait_row_3_load", null);
    L32:
        if (r111 == null) goto L34;
        Boolean r112 = r111.f571863a;
    L36:
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L42;
        if (r111 == null) goto L40;
        r110 = Integer.valueOf(r111.f571864b);
    L40:
        if (r110.intValue() <= com.bytedance.android.livesdk.chatroom.y.f119321d) goto L42;
        int r113 = r111.f571864b;
    L43:
        a1.o(r107, r113);
        a1.m(r107, AbsAnnouncementHighlightWidget.f103371t);
        return;
    L42:
        r113 = com.bytedance.android.livesdk.chatroom.y.f119321d;
        goto L43
    L34:
        r112 = null;
        goto L36
    L31:
        r111 = null;
        goto L32
    }

    public AnnouncementHighlightAudienceWidget() {
        this.f103447z = k4.f142265a.getValue();
        this.A = new CompositeDisposable();
        this.B = new b(this);
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        super.onUnload();
        this.f103443v = false;
        this.f103446y = false;
        this.f103445x = false;
        this.f103373a.clear();
        this.A.clear();
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver("cmd_portrait_row_3_load", this.B);
    L5:
        Kq("audience announcement unload");
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget
    public final int Aq() {
        return com.bytedance.android.livesdk.chatroom.y.f119322e;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget
    public final void Cq(KVData r100) {
        Intrinsics.checkNotNullParameter(r100, "kvData");
        String r101 = r100.getKey();
        if (r101.hashCode() == (-1973635064)) goto L6;
        return;
    L6:
        if (r101.equals("cmd_update_mini_game_conflict") == false) goto L9;
        AbsAnnouncementHighlightWidget.f103370s.put("game", Boolean.valueOf(Intrinsics.areEqual((Boolean) r100.getData(), Boolean.TRUE)));
        Bq();
        return;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget
    public final void Gq(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        DragContainer r101 = this.f103379g;
        if (r101 == null) goto L5;
        r101.setVisibility(4);
    L5:
        this.f103443v = false;
        c0.b(false, r100, "");
        o32.b r102 = com.bytedance.android.livesdk.interactivity.api.o.a();
        if (r102 != null) goto L8;
    L15:
        Mq();
        return;
    L8:
        if ((!r102.getCleared()) == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.isAnnouncementShown();
        if (r103 == null) goto L15;
        r103.setValue(Boolean.FALSE);
        goto L15
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget
    public final void Iq(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Nq(r100);
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget
    public final void Jq(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Nq(r100);
        int r101 = com.bytedance.android.livesdk.announcement.f.f103363a;
        HighlightItem.b r102 = this.f103444w;
        boolean r103 = this.f103443v;
        com.bytedance.android.livesdk.announcement.f.h(false, r102, !r103, r103);
        c0.d(false, "highlight");
    }

    public final void Nq(HighlightItem r110) {
        DragContainer r100 = this.f103379g;
        String r101 = "";
        if (r100 == null) goto L10;
        StringBuilder r102 = new StringBuilder();
        r102.append(s1.B(R.string.ttlive_advance_announcement_entry_title));
        HighlightItem.b r103 = r110.getAppointmentData();
        if (r103 == null) goto L8;
        String r104 = r103.i();
        if (r104 == null) goto L8;
    L9:
        r102.append(r104);
        r100.setContentDescription(r102.toString());
    L8:
        r104 = "";
    L10:
        this.f103444w = r110.getAppointmentData();
        if (this.f103389q == false) goto L32;
        HighlightItem.b r105 = r110.getAppointmentData();
        if (r105 == null) goto L15;
        long r106 = r105.g();
    L16:
        long r107 = r106 * 1000;
        TextView r108 = this.f103382j;
        if (r108 == null) goto L25;
        HighlightItem.b r109 = this.f103444w;
        if (r109 == null) goto L23;
        String r111 = r109.h();
        if (r111 == null) goto L23;
    L24:
        r108.setText(r111);
    L23:
        r111 = new SimpleDateFormat("HH:mm").format(Long.valueOf(r107));
    L25:
        HighlightItem.b r112 = this.f103444w;
        if (r112 == null) goto L40;
        String r113 = r112.c();
        if (r113 == null) goto L40;
        TextView r114 = this.f103380h;
        if (r114 == null) goto L40;
        r114.setText(r113);
    L40:
        Boolean r115 = null;
        if (r110.getAppointmentData() == null) goto L51;
        HighlightItem.b r116 = r110.getAppointmentData();
        if (r116 != null) goto L45;
    L46:
        CompositeDisposable r117 = this.f103373a;
        AnnouncementApi r118 = (AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class);
        HighlightItem.b r119 = r110.getAppointmentData();
        if (r119 == null) goto L49;
        Long r120 = Long.valueOf(r119.a());
    L50:
        Intrinsics.checkNotNull(r120);
        r117.add(AnnouncementApi.CC.queryAnnouncementInfoOpt$default(r118, r120.longValue(), false, this.f103390r, 2, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.f103450a));
        goto L51
    L49:
        r120 = null;
        goto L50
    L45:
        if (r116.j() != true) goto L46;
    L51:
        wq(r110);
        ViewGroup r121 = this.containerView;
        int r122 = 0;
        if (r121 == null) goto L54;
        r121.setVisibility(0);
    L54:
        DragContainer r123 = this.f103379g;
        if (r123 == null) goto L57;
        r123.setVisibility(0);
    L57:
        HighlightItem.b r124 = this.f103444w;
        if (r124 == null) goto L61;
        r122 = r124.d();
    L61:
        if (be.f119860a.getValue().booleanValue() == false) goto L64;
        if (r122 <= 0) goto L64;
        this.f103373a.add(Observable.timer(r122, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)));
    L64:
        DragContainer r125 = this.f103379g;
        if (r125 == null) goto L67;
        r125.post(new f(this));
    L67:
        HighlightItem.b r126 = r110.getAppointmentData();
        if (r126 == null) goto L71;
        r115 = r126.e();
    L71:
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == true) goto L73;
        return;
    L73:
        if (this.f103447z.booleanValue() == false) goto L80;
        this.f103446y = true;
        ImageView r127 = this.f103387o;
        if (r127 == null) goto L77;
        r127.setImageResource(R.drawable.announce_highlight_red_package);
    L77:
        this.A.add(Observable.timer(5000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this)));
        return;
    L80:
        return;
    L15:
        r106 = 0;
        goto L16
    L32:
        TextView r128 = this.f103382j;
        if (r128 == null) goto L40;
        HighlightItem.b r129 = r110.getAppointmentData();
        if (r129 == null) goto L39;
        String r130 = r129.i();
        if (r130 == null) goto L39;
        r101 = r130;
    L39:
        r128.setText(r101);
        goto L40
    }

    public final void Pq(boolean r110) {
        String r100 = null;
        if (this.f103443v == true) goto L29;
        if ((com.bytedance.android.livesdk.log.u.l().c(am2.x.class) instanceof n0) == false) goto L53;
        this.A.clear();
        CompositeDisposable r101 = this.f103373a;
        AnnouncementApi r102 = (AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class);
        HighlightItem.b r103 = this.f103444w;
        if (r103 == null) goto L9;
        Long r104 = Long.valueOf(r103.a());
    L10:
        com.bytedance.android.livesdk.log.filter.o r105 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r105 instanceof n0) == true) goto L13;
        r105 = null;
    L13:
        n0 r106 = (n0) r105;
        if (r106 == null) goto L18;
        Map<String, String> r107 = r106.f153291b;
        if (r107 == null) goto L18;
        String r108 = r107.get("enter_from_merge");
    L19:
        com.bytedance.android.livesdk.log.filter.o r109 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r109 instanceof n0) == true) goto L22;
        r109 = null;
    L22:
        n0 r111 = (n0) r109;
        if (r111 == null) goto L27;
        Map<String, String> r112 = r111.f153291b;
        if (r112 == null) goto L27;
        r100 = r112.get("enter_method");
    L27:
        r101.add(AnnouncementApi.CC.subscribeAnnouncementOpt$default(r102, r104, r108, r100, null, 8, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new s(this, r110), t.f103492a));
        return;
    L18:
        r108 = null;
        goto L19
    L9:
        r104 = null;
        goto L10
    L53:
        return;
    L29:
        if ((com.bytedance.android.livesdk.log.u.l().c(am2.x.class) instanceof n0) == false) goto L55;
        this.A.clear();
        CompositeDisposable r113 = this.f103373a;
        AnnouncementApi r114 = (AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class);
        HighlightItem.b r115 = this.f103444w;
        if (r115 == null) goto L33;
        Long r116 = Long.valueOf(r115.a());
    L34:
        com.bytedance.android.livesdk.log.filter.o r117 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r117 instanceof n0) == true) goto L37;
        r117 = null;
    L37:
        n0 r118 = (n0) r117;
        if (r118 == null) goto L42;
        Map<String, String> r119 = r118.f153291b;
        if (r119 == null) goto L42;
        String r120 = r119.get("enter_from_merge");
    L43:
        com.bytedance.android.livesdk.log.filter.o r121 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r121 instanceof n0) == true) goto L46;
        r121 = null;
    L46:
        n0 r122 = (n0) r121;
        if (r122 == null) goto L51;
        Map<String, String> r123 = r122.f153291b;
        if (r123 == null) goto L51;
        r100 = r123.get("enter_method");
    L51:
        r113.add(AnnouncementApi.CC.unSubscribeAnnouncementOpt$default(r114, r116, r120, r100, null, 8, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new u(this, r110), v.f103495a));
        return;
    L42:
        r120 = null;
        goto L43
    L33:
        r116 = null;
        goto L34
    }

    public final void Rq(boolean r100) {
        if (r100 == this.f103443v) goto L50;
        this.f103443v = r100;
        if (r100 == false) goto L24;
        TextView r101 = this.f103386n;
        if (r101 != null) goto L9;
    L13:
        ViewGroup r102 = this.f103385m;
        if (r102 == null) goto L17;
        r102.setContentDescription(s1.B(R.string.ttlive_announcement_highlight_unsubscribe_content_description));
    L17:
        if (this.f103389q == false) goto L21;
        ImageView r103 = this.f103387o;
        if (r103 == null) goto L51;
        r103.setImageResource(R.drawable.ttlive_icon_announcement_tick);
        return;
    L51:
        return;
    L21:
        ImageView r104 = this.f103387o;
        if (r104 == null) goto L53;
        r104.setVisibility(0);
        return;
    L53:
        return;
    L9:
        if (this.f103389q == false) goto L11;
        String r105 = s1.B(R.string.ttlive_appointment_subscribed_hint);
    L12:
        r101.setText(r105);
        goto L13
    L11:
        r105 = "";
        goto L12
    L24:
        TextView r106 = this.f103386n;
        if (r106 == null) goto L31;
        Context r107 = this.context;
        if (this.f103389q == false) goto L29;
        int r108 = R.string.ttlive_subscribe_broadcaster;
    L30:
        r106.setText(r107.getText(r108));
        goto L31
    L29:
        r108 = R.string.ttlive_announcement_highlight_subscribe_btn;
    L31:
        ViewGroup r109 = this.f103385m;
        if (r109 == null) goto L35;
        r109.setContentDescription(s1.B(R.string.ttlive_announcement_highlight_subscribe_content_description));
    L35:
        if (this.f103389q == true) goto L37;
        ImageView r110 = this.f103387o;
        if (r110 == null) goto L59;
        r110.setVisibility(4);
        return;
    L59:
        return;
    L37:
        if (this.f103446y == true) goto L39;
    L43:
        ImageView r111 = this.f103387o;
        if (r111 == null) goto L57;
        r111.setImageResource(R.drawable.ttlive_icon_announcement_bell);
        return;
    L57:
        return;
    L39:
        if (this.f103447z.booleanValue() == false) goto L43;
        ImageView r112 = this.f103387o;
        if (r112 == null) goto L55;
        r112.setImageResource(R.drawable.announce_highlight_red_package);
        return;
    L55:
        return;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        ((ObservableSubscribeProxy) xs2.b.a().b(e0.class).as(autoDispose())).subscribe(new h(new AnonymousClass1(this)));
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L6;
        r101.observe("cmd_portrait_row_3_load", this.B, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.bytedance.android.livesdkapi.announcement.IAnnouncementService, com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService] */
    public static final void Lq(AnnouncementHighlightAudienceWidget r110, boolean r111) {
        r110.Rq(!r110.f103443v);
        if (r110.f103443v == false) goto L44;
        IUser r100 = ((Room) r110.dataCenter.get("data_room", new Room())).author();
        if (r100 == null) goto L8;
        String r101 = r100.getNickName();
        if (r101 == null) goto L8;
    L9:
        String r102 = r101;
        IUser r103 = ((Room) r110.dataCenter.get("data_room", new Room())).author();
        if (r103 == null) goto L13;
        String r104 = r103.getIdString();
        if (r104 == null) goto L13;
    L14:
        String r105 = r104;
        HighlightItem.b r106 = r110.f103444w;
        if (r106 == null) goto L36;
        long r107 = r106.g();
        ?? r108 = (IAnnouncementService) jc1.k.f(IAnnouncementService.class);
        Object r109 = null;
        if (r108 == 0) goto L38;
        Context r112 = r110.context;
        int r113 = com.bytedance.android.livesdk.utils.r.f159143a;
        Pair[] r114 = new Pair[3];
        r114[0] = TuplesKt.to("enter_from_merge", "audience_live_sticker");
        com.bytedance.android.livesdk.log.filter.o r115 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r115 instanceof n0) == true) goto L21;
        r115 = null;
    L21:
        n0 r116 = (n0) r115;
        if (r116 == null) goto L27;
        Map<String, String> r117 = r116.f153291b;
        if (r117 == null) goto L27;
        String r118 = r117.get("enter_method");
        if (r118 == null) goto L27;
    L28:
        r114[1] = TuplesKt.to("enter_method", r118);
        HighlightItem.b r119 = r110.f103444w;
        if (r119 == null) goto L31;
        Long r120 = Long.valueOf(r119.a());
    L32:
        r114[2] = TuplesKt.to("appointment_id", String.valueOf(r120));
        Map r121 = MapsKt.mutableMapOf(r114);
        HighlightItem.b r122 = r110.f103444w;
        if (r122 == null) goto L35;
        r109 = r122.f();
    L35:
        r109 = Boolean.valueOf(r108.addAudienceAnnounceCalendar(r112, r107, r105, r102, 100, r121, r109));
        goto L38
    L31:
        r120 = null;
    L27:
        r118 = "";
    L38:
        if ((!Intrinsics.areEqual(r109, Boolean.TRUE)) == false) goto L42;
        if (r111 == false) goto L41;
        r110.containerView.postDelayed(new w(r110), 5000);
        goto L42
    L41:
        r110.Qq();
    L42:
        int r123 = com.bytedance.android.livesdk.announcement.f.f103363a;
        com.bytedance.android.livesdk.announcement.f.i(r110.f103444w);
        return;
    L36:
        r109 = Boolean.FALSE;
    L13:
        r104 = "0";
    L8:
        r101 = "用户";
        goto L9
    }
}
