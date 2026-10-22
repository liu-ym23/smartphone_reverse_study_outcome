package com.bytedance.android.livesdk.announcement.highlight;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/highlight/AnnouncementHighlightAudienceWidgetOpt;", "Lcom/bytedance/android/livesdk/announcement/highlight/AbsAnnouncementHighlightWidgetOpt;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementHighlightAudienceWidgetOpt extends AbsAnnouncementHighlightWidgetOpt {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f103455z = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f103456v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HighlightItem.b f103457w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f103458x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f103459y;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAudienceWidgetOpt f103460a;

        public b(AnnouncementHighlightAudienceWidgetOpt r100) {
            this.f103460a = r100;
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
            DragContainer r105 = this.f103460a.f103404g;
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
        public final /* synthetic */ AnnouncementHighlightAudienceWidgetOpt f103461a;

        public c(AnnouncementHighlightAudienceWidgetOpt r100) {
            this.f103461a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AnnouncementHighlightAudienceWidgetOpt r101 = this.f103461a;
            boolean r102 = ((AnnouncementApi.QueryAnnouncementInfoResoponseOpt) ((BaseResponse) r100).data).getHasSubscribed();
            int r103 = AnnouncementHighlightAudienceWidgetOpt.f103455z;
            r101.Qq(r102);
            int r104 = com.bytedance.android.livesdk.announcement.f.f103363a;
            AnnouncementHighlightAudienceWidgetOpt r105 = this.f103461a;
            com.bytedance.android.livesdk.announcement.f.h(false, r105.f103457w, !r105.f103456v, false);
            c0.d(false, "highlight");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f103462a = null;

        static {
            f103462a = new d();
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
        public final /* synthetic */ AnnouncementHighlightAudienceWidgetOpt f103463a;

        public e(AnnouncementHighlightAudienceWidgetOpt r100) {
            this.f103463a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            c0.a("time_up");
            AnnouncementHighlightAudienceWidgetOpt r102 = this.f103463a;
            r102.f103458x = true;
            r102.Gq("audience_time_up");
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAudienceWidgetOpt f103464a;

        public f(AnnouncementHighlightAudienceWidgetOpt r100) {
            this.f103464a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnouncementHighlightAudienceWidgetOpt r100 = this.f103464a;     // Catch: Throwable -> L4
            int r101 = AnnouncementHighlightAudienceWidgetOpt.f103455z;     // Catch: Throwable -> L4
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

    public final class g implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f103465a;

        public g(Function1 r100) {
            this.f103465a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f103465a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.announcement.highlight.AnnouncementHighlightAudienceWidgetOpt$onLoad$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/highlight/e0;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/announcement/highlight/e0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<e0, Unit> {
        public AnonymousClass1(AnnouncementHighlightAudienceWidgetOpt r100) {
            super(1, r100, AnnouncementHighlightAudienceWidgetOpt.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/announcement/highlight/SubscribeAnchorPlayNotifyEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(e0 r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            AnnouncementHighlightAudienceWidgetOpt r101 = (AnnouncementHighlightAudienceWidgetOpt) this.receiver;
            int r102 = AnnouncementHighlightAudienceWidgetOpt.f103455z;
            r101.getClass();
            r101.Qq(r100.f103474a);
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
        DragContainer r100 = this.f103404g;
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

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final boolean xq() {
        return !this.f103458x;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void yq() {
        DragContainer r100 = this.f103404g;
        if (r100 == null) goto L5;
        r100.setEnableDrag(false);
    L5:
        ConstraintLayout r101 = this.f103414q;
        if (r101 == null) goto L8;
        r101.setBackground(s1.m(R.drawable.ttlive_bg_announcement_highlight_container_opt_audience));
    L8:
        TextView r102 = this.f103405h;
        if (r102 == null) goto L11;
        r102.setTextColor(s1.h(R.color.ttlive_announcement_highlight_color_161823));
    L11:
        ImageView r103 = this.f103408k;
        if (r103 == null) goto L14;
        r103.setImageResource(R.drawable.live_announce_highlight_close_audience_opt);
    L14:
        ImageView r104 = this.f103408k;
        if (r104 == null) goto L17;
        r104.setOnClickListener(new w0(new AnnouncementHighlightAudienceWidgetOpt$customDragView$1(this), 500));
    L17:
        ViewGroup r105 = this.f103411n;
        if (r105 == null) goto L20;
        r105.setOnClickListener(new w0(new AnnouncementHighlightAudienceWidgetOpt$customDragView$2(this), 500));
    L20:
        RelativeLayout r106 = this.f103409l;
        if (r106 == null) goto L23;
        r106.setVisibility(8);
    L23:
        ViewGroup r107 = this.f103411n;
        if (r107 == null) goto L26;
        r107.setVisibility(0);
    L26:
        View r108 = this.f103406i;
        if (r108 == null) goto L29;
        r108.setVisibility(0);
    L29:
        TextView r109 = this.f103412o;
        if (r109 == null) goto L32;
        r109.setText(this.context.getText(R.string.ttlive_subscribe_broadcaster));
    L32:
        ViewGroup r110 = this.f103411n;
        if (r110 == null) goto L35;
        r110.setContentDescription(s1.B(R.string.ttlive_announcement_highlight_subscribe_content_description));
    L35:
        ImageView r111 = this.f103413p;
        if (r111 == null) goto L38;
        r111.setVisibility(0);
    L38:
        ImageView r112 = this.f103413p;
        if (r112 == null) goto L41;
        r112.setImageResource(R.drawable.ttlive_icon_announcement_bell);
    L41:
        DragContainer r113 = this.f103404g;
        if (r113 == null) goto L63;
        ViewGroup r114 = this.containerView;
        if (r114 == null) goto L46;
        r114.addView(r113);
    L46:
        DataCenter r115 = this.dataCenter;
        Integer r116 = null;
        if (r115 == null) goto L49;
        j2 r117 = (j2) r115.get("cmd_portrait_row_3_load", null);
    L50:
        if (r117 == null) goto L52;
        Boolean r118 = r117.f571863a;
    L54:
        if (Intrinsics.areEqual(r118, Boolean.TRUE) == false) goto L60;
        if (r117 == null) goto L58;
        r116 = Integer.valueOf(r117.f571864b);
    L58:
        if (r116.intValue() <= com.bytedance.android.livesdk.chatroom.y.f119321d) goto L60;
        int r119 = r117.f571864b;
    L61:
        a1.o(r113, r119);
        a1.m(r113, AbsAnnouncementHighlightWidgetOpt.f103396t);
        return;
    L60:
        r119 = com.bytedance.android.livesdk.chatroom.y.f119321d;
        goto L61
    L52:
        r118 = null;
        goto L54
    L49:
        r117 = null;
        goto L50
    }

    public AnnouncementHighlightAudienceWidgetOpt() {
        this.f103459y = new b(this);
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        super.onUnload();
        this.f103456v = false;
        this.f103458x = false;
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver("cmd_portrait_row_3_load", this.f103459y);
    L5:
        Kq("audience announcement unload");
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final int Aq() {
        return com.bytedance.android.livesdk.chatroom.y.f119322e;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Cq(KVData r100) {
        Intrinsics.checkNotNullParameter(r100, "kvData");
        String r101 = r100.getKey();
        if (r101.hashCode() == (-1973635064)) goto L6;
        return;
    L6:
        if (r101.equals("cmd_update_mini_game_conflict") == false) goto L9;
        AbsAnnouncementHighlightWidgetOpt.f103395s.put("game", Boolean.valueOf(Intrinsics.areEqual((Boolean) r100.getData(), Boolean.TRUE)));
        Bq();
        return;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Gq(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        DragContainer r101 = this.f103404g;
        if (r101 == null) goto L5;
        r101.setVisibility(4);
    L5:
        this.f103456v = false;
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

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Iq(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f103407j = r100;
        Nq(r100);
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Jq(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f103407j = r100;
        Nq(r100);
    }

    public final void Nq(HighlightItem r110) {
        DragContainer r100 = this.f103404g;
        if (r100 == null) goto L10;
        StringBuilder r101 = new StringBuilder();
        r101.append(s1.B(R.string.ttlive_advance_announcement_entry_title));
        HighlightItem.b r102 = r110.getAppointmentData();
        if (r102 == null) goto L8;
        String r103 = r102.i();
        if (r103 == null) goto L8;
    L9:
        r101.append(r103);
        r100.setContentDescription(r101.toString());
    L8:
        r103 = "";
    L10:
        this.f103457w = r110.getAppointmentData();
        HighlightItem.b r104 = r110.getAppointmentData();
        if (r104 == null) goto L13;
        long r105 = r104.g();
    L14:
        long r106 = r105 * 1000;
        HighlightItem.b r107 = this.f103457w;
        if (r107 == null) goto L18;
        String r108 = r107.h();
        if (r108 == null) goto L18;
    L19:
        HighlightItem.b r109 = this.f103457w;
        if (r109 == null) goto L27;
        String r111 = r109.c();
        if (r111 == null) goto L27;
        TextView r112 = this.f103405h;
        if (r112 == null) goto L27;
        r112.setText(r111 + r108);
    L27:
        if (r110.getAppointmentData() == null) goto L37;
        HighlightItem.b r113 = r110.getAppointmentData();
        if (r113 != null) goto L31;
    L32:
        CompositeDisposable r114 = this.f103398a;
        AnnouncementApi r115 = (AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class);
        HighlightItem.b r116 = r110.getAppointmentData();
        if (r116 == null) goto L35;
        Long r117 = Long.valueOf(r116.a());
    L36:
        Intrinsics.checkNotNull(r117);
        r114.add(AnnouncementApi.CC.queryAnnouncementInfoOpt$default(r115, r117.longValue(), false, this.f103415r, 2, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.f103462a));
        goto L37
    L35:
        r117 = null;
        goto L36
    L31:
        if (r113.j() != true) goto L32;
    L37:
        wq(r110);
        ViewGroup r118 = this.containerView;
        int r119 = 0;
        if (r118 == null) goto L40;
        r118.setVisibility(0);
    L40:
        DragContainer r120 = this.f103404g;
        if (r120 == null) goto L43;
        r120.setVisibility(0);
    L43:
        HighlightItem.b r121 = this.f103457w;
        if (r121 == null) goto L47;
        r119 = r121.d();
    L47:
        if (be.f119860a.getValue().booleanValue() == false) goto L50;
        if (r119 <= 0) goto L50;
        this.f103398a.add(Observable.timer(r119, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)));
    L50:
        DragContainer r122 = this.f103404g;
        if (r122 == null) goto L54;
        r122.post(new f(this));
        return;
    L54:
        return;
    L18:
        r108 = new SimpleDateFormat("HH:mm").format(Long.valueOf(r106));
        goto L19
    L13:
        r105 = 0;
        goto L14
    }

    public final void Pq(boolean r110) {
        String r100 = null;
        if (this.f103456v == true) goto L29;
        if ((com.bytedance.android.livesdk.log.u.l().c(am2.x.class) instanceof n0) == false) goto L53;
        CompositeDisposable r101 = this.f103398a;
        AnnouncementApi r102 = (AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class);
        HighlightItem.b r103 = this.f103457w;
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
        r101.add(AnnouncementApi.CC.subscribeAnnouncementOpt$default(r102, r104, r108, r100, null, 8, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new x(this, r110), y.f103499a));
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
        CompositeDisposable r113 = this.f103398a;
        AnnouncementApi r114 = (AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class);
        HighlightItem.b r115 = this.f103457w;
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
        r113.add(AnnouncementApi.CC.unSubscribeAnnouncementOpt$default(r114, r116, r120, r100, null, 8, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new z(this, r110), a0.f103466a));
        return;
    L42:
        r120 = null;
        goto L43
    L33:
        r116 = null;
        goto L34
    }

    public final void Qq(boolean r100) {
        if (r100 == this.f103456v) goto L31;
        this.f103456v = r100;
        if (r100 == false) goto L18;
        TextView r101 = this.f103412o;
        if (r101 == null) goto L9;
        r101.setText(s1.B(R.string.ttlive_appointment_subscribed_hint));
    L9:
        ViewGroup r102 = this.f103411n;
        if (r102 == null) goto L12;
        r102.setContentDescription(s1.B(R.string.ttlive_announcement_highlight_unsubscribe_content_description));
    L12:
        ImageView r103 = this.f103413p;
        if (r103 == null) goto L15;
        r103.setVisibility(0);
    L15:
        ImageView r104 = this.f103413p;
        if (r104 == null) goto L32;
        r104.setImageResource(R.drawable.ttlive_icon_announcement_tick);
        return;
    L32:
        return;
    L18:
        TextView r105 = this.f103412o;
        if (r105 == null) goto L21;
        r105.setText(this.context.getText(R.string.ttlive_subscribe_broadcaster));
    L21:
        ViewGroup r106 = this.f103411n;
        if (r106 == null) goto L24;
        r106.setContentDescription(s1.B(R.string.ttlive_announcement_highlight_subscribe_content_description));
    L24:
        ImageView r107 = this.f103413p;
        if (r107 == null) goto L27;
        r107.setVisibility(0);
    L27:
        ImageView r108 = this.f103413p;
        if (r108 == null) goto L34;
        r108.setImageResource(R.drawable.ttlive_icon_announcement_bell);
        return;
    L34:
        return;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        ((ObservableSubscribeProxy) xs2.b.a().b(e0.class).as(autoDispose())).subscribe(new g(new AnonymousClass1(this)));
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L6;
        r101.observe("cmd_portrait_row_3_load", this.f103459y, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.bytedance.android.livesdkapi.announcement.IAnnouncementService, com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService] */
    public static final void Lq(AnnouncementHighlightAudienceWidgetOpt r110, boolean r111) {
        r110.Qq(!r110.f103456v);
        if (r110.f103456v == false) goto L44;
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
        HighlightItem.b r106 = r110.f103457w;
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
        HighlightItem.b r119 = r110.f103457w;
        if (r119 == null) goto L31;
        Long r120 = Long.valueOf(r119.a());
    L32:
        r114[2] = TuplesKt.to("appointment_id", String.valueOf(r120));
        Map r121 = MapsKt.mutableMapOf(r114);
        HighlightItem.b r122 = r110.f103457w;
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
        r110.containerView.postDelayed(b0.f103467a, 5000);
        goto L42
    L41:
        f2.c(s1.B(R.string.ttlive_announcement_highlight_subscribe_succeed_toast), 0);
    L42:
        int r123 = com.bytedance.android.livesdk.announcement.f.f103363a;
        com.bytedance.android.livesdk.announcement.f.i(r110.f103457w);
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
