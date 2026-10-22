package com.bytedance.android.livesdk.announcement.highlight;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.announcement.AnnouncementApi;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.eq0;
import com.bytedance.android.livesdk.config.xd;
import com.bytedance.android.livesdk.interactivity.api.DragContainer;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.utils.g7;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceBaseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceChooseConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import zg1.n0;
import zg1.q3;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/highlight/AnnouncementHighlightAnchorWidgetOpt;", "Lcom/bytedance/android/livesdk/announcement/highlight/AbsAnnouncementHighlightWidgetOpt;", "Ld42/b;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementHighlightAnchorWidgetOpt extends AbsAnnouncementHighlightWidgetOpt implements d42.b, vlc.l {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public int B;
    public Disposable C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f103434v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f103435w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f103436x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f103437y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d42.d f103438z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAnchorWidgetOpt f103439a;

        public b(AnnouncementHighlightAnchorWidgetOpt r100) {
            this.f103439a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            ((IAnnouncementService) jc1.k.n(IAnnouncementService.class)).openAnnouncementChooseDialogOpt(new OpenAnnounceChooseConfig(this.f103439a.context, OpenAnnounceBaseConfig.Companion.getLiveSticker(), null, null, null, null, null, null, 204, null));
            int r111 = com.bytedance.android.livesdk.announcement.f.f103363a;
            HighlightItem r112 = this.f103439a.f103407j;
            if (r112 == null) goto L5;
            HighlightItem.b r113 = r112.getAppointmentData();
        L6:
            HashMap r114 = com.bytedance.android.livesdk.announcement.f.e(true, r113, false);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_announce_card_click", r114, new Object[0]);
            return;
        L5:
            r113 = null;
            goto L6
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAnchorWidgetOpt f103440a;

        public c(AnnouncementHighlightAnchorWidgetOpt r100) {
            this.f103440a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnouncementHighlightAnchorWidgetOpt r100 = this.f103440a;     // Catch: Throwable -> L10
            int r101 = AnnouncementHighlightAnchorWidgetOpt.D;     // Catch: Throwable -> L10
            r100.Qq();     // Catch: Throwable -> L10
            AnnouncementHighlightAnchorWidgetOpt r102 = this.f103440a;     // Catch: Throwable -> L10
            if (r102.Pq() == false) goto L13;
            d42.d r103 = r102.f103438z;     // Catch: Throwable -> L10
            if (r103 == null) goto L17;
            int r104 = r102.Nq();     // Catch: Throwable -> L10
            r102.B = r104;     // Catch: Throwable -> L10
            View r105 = r102.f103437y;     // Catch: Throwable -> L10
            if (r105 == null) goto L18;
            r103.j(r105, r104);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAnchorWidgetOpt f103441a;

        public d(AnnouncementHighlightAnchorWidgetOpt r100) {
            this.f103441a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnouncementHighlightAnchorWidgetOpt r100 = this.f103441a;     // Catch: Throwable -> L10
            int r101 = AnnouncementHighlightAnchorWidgetOpt.D;     // Catch: Throwable -> L10
            r100.Qq();     // Catch: Throwable -> L10
            AnnouncementHighlightAnchorWidgetOpt r102 = this.f103441a;     // Catch: Throwable -> L10
            if (r102.Pq() == false) goto L13;
            d42.d r103 = r102.f103438z;     // Catch: Throwable -> L10
            if (r103 == null) goto L17;
            int r104 = r102.Nq();     // Catch: Throwable -> L10
            r102.B = r104;     // Catch: Throwable -> L10
            View r105 = r102.f103437y;     // Catch: Throwable -> L10
            if (r105 == null) goto L18;
            r103.j(r105, r104);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementHighlightAnchorWidgetOpt f103442a;

        public e(AnnouncementHighlightAnchorWidgetOpt r100) {
            this.f103442a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((q3) r100) == null) goto L9;
            boolean r101 = g7.f158964a;
            ConstraintLayout r102 = this.f103442a.f103414q;
            if (r102 == null) goto L8;
            g7.a(r102);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L9:
            boolean r103 = g7.f158964a;
            ConstraintLayout r104 = this.f103442a.f103414q;
            if (r104 == null) goto L14;
            g7.b(r104);
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
    }

    static {
    }

    public final int Nq() {
        DataCenter r100 = this.dataCenter;
        boolean r101 = false;
        if (r100 == null) goto L11;
        Room r102 = com.bytedance.android.live.core.utils.z.o(r100);
        if (r102 == null) goto L11;
        StreamUrl r103 = r102.getStreamUrl();
        if (r103 == null) goto L11;
        IStreamUrlExtra r104 = r103.getExtra();
        if (r104 == null) goto L11;
        int r105 = r104.getWidth();
    L12:
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L21;
        Room r107 = com.bytedance.android.live.core.utils.z.o(r106);
        if (r107 == null) goto L21;
        StreamUrl r108 = r107.getStreamUrl();
        if (r108 == null) goto L21;
        IStreamUrlExtra r109 = r108.getExtra();
        if (r109 == null) goto L21;
        int r110 = r109.getHeight();
    L23:
        if (r105 <= r110) goto L25;
        boolean r111 = true;
    L27:
        if (r111 == true) goto L29;
        int r112 = com.bytedance.android.livesdk.chatroom.y.f119322e;
    L68:
        ALogger.i("anchor_highlight", "isInGameScreencastMode  forbiddenAreaHeight = " + r112 + tb2.c.DEFAULT_TEXT);
        return r112;
    L29:
        ViewGroup r113 = this.containerView;
        Integer r114 = null;
        if (r113 == null) goto L40;
        Integer r115 = Integer.valueOf(r113.getHeight());
        if (r115.intValue() <= 0) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == true) goto L38;
        r115 = null;
    L38:
        if (r115 == null) goto L40;
        int r117 = r115.intValue();
    L41:
        DragContainer r118 = this.f103404g;
        if (r118 == null) goto L51;
        Integer r119 = Integer.valueOf(r118.getHeight());
        if (r119.intValue() <= 0) goto L46;
        boolean r120 = true;
    L47:
        if (r120 == true) goto L50;
        r119 = null;
    L50:
        if (r119 == null) goto L51;
    L57:
        if (r119 == null) goto L59;
        int r121 = r119.intValue();
    L60:
        ALogger.i("anchor_highlight", "getGameScreencastForbiddenAreaHeight containerViewHeight  = " + r117 + " dragItemViewHeight = " + r121 + tb2.c.DEFAULT_TEXT);
        Integer r122 = Integer.valueOf(((r117 - com.bytedance.android.livesdk.chatroom.y.f119321d) - r121) - UtilityKotlinExtentionsKt.i(10));
        if (r122.intValue() <= 0) goto L63;
        r101 = true;
    L63:
        if (r101 == false) goto L65;
        r114 = r122;
    L65:
        if (r114 == null) goto L67;
        r112 = r114.intValue();
        goto L68
    L67:
        r112 = com.bytedance.android.livesdk.chatroom.y.f119322e;
        goto L68
    L59:
        r121 = UtilityKotlinExtentionsKt.i(54);
        goto L60
    L46:
        r120 = false;
    L51:
        DragContainer r123 = this.f103404g;
        int r124 = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (r123 == null) goto L54;
        r123.measure(r124, r124);
    L54:
        if (r123 == null) goto L56;
        r119 = Integer.valueOf(r123.getMeasuredHeight());
        goto L57
    L56:
        r119 = null;
        goto L57
    L34:
        r116 = false;
    L40:
        ViewGroup r125 = this.containerView;
        int r126 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r125.measure(r126, r126);
        r117 = r125.getMeasuredHeight();
        goto L41
    L25:
        r111 = false;
    L21:
        r110 = 0;
    L11:
        r105 = 0;
        goto L12
    }

    public final boolean Pq() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L11;
        Room r101 = com.bytedance.android.live.core.utils.z.o(r100);
        if (r101 == null) goto L11;
        if (r101.isScreenshot() != true) goto L11;
        if (eq0.f120147a.getValue().booleanValue() == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final void Qq() {
        DragContainer r100 = this.f103404g;
        int r101 = 0;
        if (r100 != null) goto L5;
    L7:
        o32.b r102 = com.bytedance.android.livesdk.interactivity.api.o.a();
        if (r102 != null) goto L10;
    L17:
        Kq("announcement bottom change");
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
        if (this.f103400c == false) goto L7;
        r101 = (int) (r100.getY() + r100.getHeight());
        goto L7
    }

    public final void Sq() {
        Gq("anchor_cancel");
        HighlightItem r100 = this.f103407j;
        if (r100 == null) goto L17;
        HighlightItem.b r101 = r100.getAppointmentData();
        if (r101 == null) goto L18;
        long r102 = r101.a();
        if (r102 == 0) goto L19;
        this.f103401d = 2;
        CompositeDisposable r103 = this.f103398a;
        AnnouncementApi r104 = (AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class);
        IUserService r105 = (IUserService) jc1.k.f(IUserService.class);
        if (r105 == null) goto L14;
        com.bytedance.android.livesdk.user.f r106 = r105.user();
        if (r106 == null) goto L14;
        String r107 = r106.n();
        if (r107 == null) goto L14;
    L15:
        r103.add(r104.unPublishAnnouncementOpt(r107, r102).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(this), new o(this)));
        return;
    L14:
        r107 = "0";
        goto L15
    L19:
        return;
    L18:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void yq() {
        View r100 = LayoutInflater.from(this.containerView.getContext()).inflate(R.layout.ttlive_highlight_delete_area, this.containerView, false);
        this.f103435w = r100;
        i32.a r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.findViewById(R.id.delete_icon);
    L6:
        this.f103436x = r102;
        View r103 = new View(this.containerView.getContext());
        r103.setBackgroundColor(ColorProtector.parseColor("#33000000"));
        Unit r104 = Unit.INSTANCE;
        this.f103437y = r103;
        ViewParent r105 = this.containerView;
        if ((r105 instanceof d42.d) == true) goto L9;
        r105 = null;
    L9:
        d42.d r106 = (d42.d) r105;
        this.f103438z = r106;
        if (r106 == null) goto L37;
        View r107 = this.f103435w;
        if (r107 == null) goto L14;
        r106.d(r107, com.bytedance.android.livesdk.chatroom.y.f119321d);
    L14:
        int r108 = AbsAnnouncementHighlightWidgetOpt.f103396t;
        r106.a(r108, AbsAnnouncementHighlightWidgetOpt.f103397u, r108);
        DragContainer r109 = this.f103404g;
        if (r109 == null) goto L18;
        r109.setDragParentView(r106);
        r106.b(r109);
    L18:
        if (PublicScreenStyleHelper.f133624n == false) goto L30;
        DataCenter r110 = this.dataCenter;
        if (r110 == null) goto L22;
        i32.a r111 = (i32.a) r110.get("cmd_data_interact_public_screen_height_change");
    L24:
        if ((r111 instanceof i32.a) == false) goto L27;
        r101 = r111;
    L27:
        Wq(r101);
        DataCenter r112 = this.dataCenter;
        if (r112 == null) goto L36;
        r112.observe("cmd_data_interact_public_screen_height_change", this);
    L36:
        r106.setDragCallback(this);
        goto L37
    L22:
        r111 = null;
        goto L24
    L30:
        View r113 = this.f103437y;
        if (r113 == null) goto L36;
        if (Pq() == false) goto L35;
        int r114 = Nq();
        this.B = r114;
        r106.j(r113, r114);
        goto L36
    L35:
        r106.j(r113, com.bytedance.android.livesdk.chatroom.y.f119322e);
    L37:
        ConstraintLayout r115 = this.f103414q;
        if (r115 == null) goto L40;
        r115.setOnClickListener(new b(this));
    L40:
        DragContainer r116 = this.f103404g;
        if (r116 == null) goto L43;
        r116.setEnableDrag(true);
    L43:
        ConstraintLayout r117 = this.f103414q;
        if (r117 == null) goto L46;
        r117.setBackground(s1.m(R.drawable.ttlive_bg_announcement_highlight_container_opt_anchor));
    L46:
        View r118 = this.f103406i;
        if (r118 == null) goto L49;
        r118.setVisibility(4);
    L49:
        ViewGroup r119 = this.f103411n;
        if (r119 == null) goto L52;
        r119.setVisibility(8);
    L52:
        RelativeLayout r120 = this.f103409l;
        if (r120 == null) goto L55;
        r120.setVisibility(0);
    L55:
        ImageView r121 = this.f103408k;
        if (r121 == null) goto L58;
        r121.setImageResource(R.drawable.live_announce_highlight_close_anchor_opt);
    L58:
        ImageView r122 = this.f103408k;
        if (r122 == null) goto L61;
        r122.setOnClickListener(new w0(new AnnouncementHighlightAnchorWidgetOpt$customDragView$2(this), 500));
    L61:
        TextView r123 = this.f103405h;
        if (r123 == null) goto L65;
        r123.setTextColor(s1.h(R.color.ttlive_announcement_highlight_color_ffffff_80p));
        return;
    L65:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public AnnouncementHighlightAnchorWidgetOpt() {
        this.f103434v = 7;
        this.B = com.bytedance.android.livesdk.chatroom.y.f119322e;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Fq() {
        super.Fq();
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L18;
        Map<String, Boolean> r101 = AbsAnnouncementHighlightWidgetOpt.f103395s;
        Boolean r102 = Boolean.FALSE;
        r101.put("game_blink", (Boolean) r100.get("data_blink_is_playing", r102));
        r101.put("game_effect", (Boolean) r100.get("data_effect_or_wgame_is_playing", r102));
        r101.put("game_drawer_guess", (Boolean) r100.get("data_guess_game_show", r102));
        if (Pq() == false) goto L19;
        DataCenter r103 = this.dataCenter;
        zg1.m r104 = null;
        if (r103 == null) goto L9;
        r104 = (zg1.m) r103.get("data_broadcast_pause_state", null);
    L9:
        if (r104 == null) goto L15;
        int r105 = r104.f571877a;
        boolean r106 = true;
        if (r105 != 1) goto L13;
    L16:
        r101.put("game_screencast_pause", Boolean.valueOf(r106));
        return;
    L13:
        if (r105 == 2) goto L16;
    L15:
        r106 = false;
        goto L16
    L19:
        return;
    }

    @Override // d42.b
    public final void onDragStart() {
        xs2.b.a().post(new n0(true));
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        super.onUnload();
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L7;
        r100.removeObserver("data_blink_is_playing", this);
        r100.removeObserver("data_effect_or_wgame_is_playing", this);
        r100.removeObserver("data_guess_game_show", this);
        if (Pq() == false) goto L7;
        r100.removeObserver("data_broadcast_pause_state", this);
    L7:
        Kq("AnnouncementWidget unload");
        Disposable r101 = this.C;
        if (r101 == null) goto L11;
        r101.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final int Aq() {
        return this.B;
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Cq(KVData r100) {
        Intrinsics.checkNotNullParameter(r100, "kvData");
        String r101 = r100.getKey();
        zg1.m r102 = null;
        Object r103 = null;
        switch(r101.hashCode()) {
            case -2135400523: goto L26;
            case -1477684366: goto L15;
            case -1126599662: goto L12;
            case 1650649809: goto L9;
            case 1982638125: goto L6;
            default: goto L50;
        };
    L50:
        return;
    L6:
        if (r101.equals("data_guess_game_show") == false) goto L39;
        Tq("game_drawer_guess", (Boolean) r100.getData());
        return;
    L39:
        return;
    L9:
        if (r101.equals("data_blink_is_playing") == false) goto L41;
        Tq("game_blink", (Boolean) r100.getData());
        return;
    L41:
        return;
    L12:
        if (r101.equals("data_effect_or_wgame_is_playing") == false) goto L43;
        Tq("game_effect", (Boolean) r100.getData());
        return;
    L43:
        return;
    L15:
        if (r101.equals("cmd_data_interact_public_screen_height_change") == false) goto L45;
        Object r104 = r100.getData();
        if ((r104 instanceof i32.a) == false) goto L20;
        r103 = r104;
    L20:
        int r105 = this.B;
        Wq((i32.a) r103);
        if (r105 == this.B) goto L46;
        HighlightItem r106 = this.f103402e;
        if (r106 == null) goto L47;
        wq(r106);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L26:
        if (r101.equals("data_broadcast_pause_state") == false) goto L49;
        DataCenter r107 = this.dataCenter;
        if (r107 == null) goto L30;
        r102 = (zg1.m) r107.get("data_broadcast_pause_state", null);
    L30:
        if (r102 == null) goto L36;
        int r108 = r102.f571877a;
        boolean r109 = true;
        if (r108 != 1) goto L34;
    L37:
        Tq("game_screencast_pause", Boolean.valueOf(r109));
        return;
    L34:
        if (r108 == 2) goto L37;
    L36:
        r109 = false;
        goto L37
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Gq(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.getAnchorAnnounceStickerShow();
        if (r102 == null) goto L8;
        r102.setValue(Boolean.FALSE);
    L8:
        if (this.A == true) goto L13;
        DragContainer r103 = this.f103404g;
        if (r103 == null) goto L12;
        r103.setVisibility(4);
        r103.setTranslationX(r103.f132750c);
        r103.setTranslationY(r103.f132751d);
    L12:
        c0.b(true, r100, "");
    L14:
        Qq();
        return;
    L13:
        this.A = false;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Iq(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f103407j = r100;
        long r101 = 0;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.getAnchorAnnounceStickerShow();
        if (r103 == null) goto L7;
        r103.setValue(Boolean.TRUE);
    L7:
        Rq(r100);
        HighlightItem.b r104 = r100.getAppointmentData();
        if (r104 == null) goto L10;
        r101 = r104.b();
    L10:
        TextView r105 = this.f103410m;
        if (r105 == null) goto L13;
        r105.setText(Mq(r101));
    L13:
        wq(r100);
        ViewGroup r106 = this.containerView;
        if (r106 == null) goto L16;
        r106.setVisibility(0);
    L16:
        DragContainer r107 = this.f103404g;
        if (r107 == null) goto L19;
        r107.setVisibility(0);
    L19:
        DragContainer r108 = this.f103404g;
        if (r108 == null) goto L22;
        r108.post(new c(this));
    L22:
        int r109 = com.bytedance.android.livesdk.announcement.f.f103363a;
        com.bytedance.android.livesdk.announcement.f.h(true, r100.getAppointmentData(), true, false);
        c0.d(true, "highlight");
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt
    public final void Jq(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f103407j = r100;
        if (xd.f121594a.getValue().booleanValue() == false) goto L22;
        Rq(r100);
        HighlightItem.b r101 = r100.getAppointmentData();
        if (r101 == null) goto L7;
        long r102 = r101.b();
    L8:
        TextView r103 = this.f103410m;
        if (r103 == null) goto L11;
        r103.setText(Mq(r102));
    L11:
        wq(r100);
        ViewGroup r104 = this.containerView;
        if (r104 == null) goto L14;
        r104.setVisibility(0);
    L14:
        DragContainer r105 = this.f103404g;
        if (r105 == null) goto L17;
        r105.setVisibility(0);
    L17:
        DragContainer r106 = this.f103404g;
        if (r106 == null) goto L20;
        r106.post(new d(this));
    L20:
        int r107 = com.bytedance.android.livesdk.announcement.f.f103363a;
        com.bytedance.android.livesdk.announcement.f.h(true, r100.getAppointmentData(), true, false);
        c0.d(true, "highlight");
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public final void Lq(View r100) {
        int r101 = com.bytedance.android.livesdk.announcement.f.f103363a;
        HighlightItem r102 = this.f103407j;
        HighlightItem.b r103 = null;
        if (r102 == null) goto L5;
        HighlightItem.b r104 = r102.getAppointmentData();
    L6:
        com.bytedance.android.livesdk.announcement.f.g(r104, true);
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r105 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.getAnchorAnnounceStickerShow();
        if (r106 == null) goto L11;
        r106.setValue(Boolean.FALSE);
    L11:
        SharedPrefHelper r107 = SharedPrefHelper.b(s1.getContext());
        int r108 = r107.h("live.pref.PREF_ANNOUNCE_HIGHLIGHT_CLOSE_TIME", 0);
        if (r108 <= 3) goto L17;
        Sq();
        new LinkedHashMap();
        lm3.c r109 = new lm3.c();
        r109.f509864b = "取消";
        r109.f509865c = new j(this);
        lm3.c r110 = new lm3.c();
        r110.f509864b = "关闭";
        r110.f509865c = new k(this, r100);
        lm3.d.a r111 = new lm3.d.a(this.context);
        r111.f509870a = "提示";
        r111.f509871b = s1.B(R.string.ttlive_annocement_alert_dialog_highlight_close);
        r111.f509874e = CollectionsKt.listOf(new lm3.c[]{r109, r110});
        r111.f509879j = false;
        r111.f509880k = Integer.valueOf(R.drawable.ttlive_announce_templete_dialog_bg);
        r111.a();
        HighlightItem r112 = this.f103407j;
        if (r112 == null) goto L16;
        r103 = r112.getAppointmentData();
    L16:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_announce_card_cancel_popup_show", com.bytedance.android.livesdk.announcement.f.e(true, r103, true), new Object[0]);
        return;
    L17:
        r107.l("live.pref.PREF_ANNOUNCE_HIGHLIGHT_CLOSE_TIME", Integer.valueOf(r108 + 1));
        r107.a();
        Sq();
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final String Mq(long r110) {
        long r100 = 10000;
        if (r110 <= r100) goto L9;
        if ((r110 % r100) == 0) goto L10;
        StringBuilder r101 = new StringBuilder();
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        r101.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r110 / 10000)}, 1)));
        r101.append("万");
        return r101.toString();
    L10:
        return String.valueOf(r110 / r100) + "万";
    L9:
        return String.valueOf(r110);
    }

    @Override // d42.b
    public final void Op(boolean r110) {
        if (r110 == false) goto L4;
        Lq(this.containerView);
    L29:
        xs2.b.a().post(new n0(false));
        return;
    L4:
        DragContainer r111 = this.f103404g;
        if (r111 == null) goto L29;
        d42.d r100 = this.f103438z;
        if (r100 == null) goto L29;
        Pair r112 = r100.h(r111);
        if (r112 == null) goto L29;
        if (this.f103404g == null) goto L25;
        HighlightApi r101 = (HighlightApi) com.bytedance.android.live.network.c.b().e(HighlightApi.class);
        long r102 = 0;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L20;
        com.bytedance.live.datacontext.m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L20;
        Room r105 = r104.getValue();
        if (r105 == null) goto L20;
        long r106 = r105.getRoomId();
    L21:
        double r107 = ((Number) r112.getFirst()).floatValue();
        double r108 = ((Number) r112.getSecond()).floatValue();
        long r113 = this.f103403f;
        HighlightItem r109 = this.f103402e;
        if (r109 == null) goto L24;
        r102 = r109.getItemId();
    L24:
        RxUtilKt.c(r101.updateHighlightContainerPosition(r106, r107, r108, r113, r102).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(p.f103487a, q.f103488a), this.f103398a);
    L20:
        r106 = 0;
    L25:
        HighlightItem r114 = this.f103402e;
        if (r114 == null) goto L28;
        HighlightItem.g r115 = new HighlightItem.g();
        r115.c(((Number) r112.getFirst()).floatValue());
        r115.d(((Number) r112.getSecond()).floatValue());
        Unit r116 = Unit.INSTANCE;
        r114.setPosition(r115);
    L28:
        Qq();
        goto L29
    }

    public final void Rq(HighlightItem r100) {
        HighlightItem.b r101 = r100.getAppointmentData();
        if (r101 == null) goto L5;
        long r102 = r101.g();
    L6:
        long r103 = r102 * 1000;
        HighlightItem.b r104 = r100.getAppointmentData();
        if (r104 == null) goto L10;
        String r105 = r104.h();
        if (r105 == null) goto L10;
    L11:
        HighlightItem.b r106 = r100.getAppointmentData();
        if (r106 == null) goto L18;
        String r107 = r106.c();
        if (r107 == null) goto L18;
        TextView r108 = this.f103405h;
        if (r108 == null) goto L18;
        r108.setText(r107 + r105);
    L18:
        TextView r109 = this.f103405h;
        if (r109 == null) goto L21;
        r109.setVisibility(0);
    L21:
        TextView r110 = this.f103405h;
        if (r110 == null) goto L25;
        r110.setTextColor(s1.h(R.color.ttlive_announcement_highlight_color_ffffff_80p));
        return;
    L25:
        return;
    L10:
        r105 = new SimpleDateFormat("HH:mm").format(Long.valueOf(r103));
        goto L11
    L5:
        r102 = 0;
        goto L6
    }

    public final void Wq(i32.a r100) {
        boolean r101 = true;
        if (this.f103401d == 1) goto L5;
        return;
    L5:
        ALogger.i("anchor_highlight", "update forbidden area. PublicScreenHeightUpdateData=".concat(String.valueOf(r100)));
        View r102 = this.f103437y;
        if (r102 == null) goto L29;
        int r103 = com.bytedance.android.livesdk.chatroom.y.f119322e;
        if (r100 == null) goto L24;
        DragContainer r104 = this.f103404g;
        if (r104 == null) goto L24;
        r103 = (r100.f488090b + r100.f488089a) + com.bytedance.android.livesdk.interactivity.api.entity.n.f133178a;
        Integer r105 = Integer.valueOf(r104.getHeight());
        if (r105.intValue() > 0) goto L15;
        r101 = false;
    L15:
        if (r101 == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L20;
        int r106 = r105.intValue();
    L21:
        int r107 = (this.containerView.getHeight() - com.bytedance.android.livesdk.chatroom.y.f119321d) - r106;
        if (r103 <= r107) goto L24;
        r103 = r107;
        goto L24
    L20:
        int r108 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r104.measure(r108, r108);
        r106 = r104.getMeasuredHeight();
    L24:
        this.B = r103;
        d42.d r109 = this.f103438z;
        if (r109 == null) goto L27;
        r109.j(r102, r103);
    L27:
        ALogger.i("anchor_highlight", "update forbidden area. height=" + r103);
        return;
    }

    @Override // d42.b
    public final void kn(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 1.2f;
    L5:
        View r102 = this.f103436x;
        if (r102 == null) goto L13;
        ViewPropertyAnimator r103 = r102.animate();
        if (r103 == null) goto L14;
        r103.scaleX(r101).setDuration(200).start();
        ViewPropertyAnimator r104 = r103.scaleY(r101).setDuration(200);
        if (r104 == null) goto L15;
        r104.start();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L4:
        r101 = 1.0f;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.announcement.highlight.AbsAnnouncementHighlightWidgetOpt, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.j<vlc.d> r102 = r101.getMessageManager();
        if (r102 == null) goto L7;
        r102.c(new AnonymousClass1(this));
    L7:
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L12;
        r103.observe("data_effect_or_wgame_is_playing", this);
        r103.observe("data_guess_game_show", this);
        r103.observe("data_blink_is_playing", this);
        if (Pq() == false) goto L12;
        r103.observe("data_broadcast_pause_state", this);
    L12:
        Disposable r104 = this.C;
        if (r104 == null) goto L15;
        r104.dispose();
    L15:
        this.C = xs2.b.a().b(q3.class).subscribe(new e(this));
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.message.model.v) == false) goto L14;
        com.bytedance.android.livesdk.message.model.v.a r101 = ((com.bytedance.android.livesdk.message.model.v) r100).data;
        if (r101 == null) goto L7;
        long r102 = r101.a();
    L9:
        if (this.f103400c == false) goto L15;
        TextView r103 = this.f103410m;
        if (r103 == null) goto L16;
        r103.setText(Mq(r102));
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r102 = 0;
        goto L9
    }

    public final void Tq(String r100, Boolean r101) {
        AbsAnnouncementHighlightWidgetOpt.f103395s.put(r100, Boolean.valueOf(Intrinsics.areEqual(r101, Boolean.TRUE)));
        Bq();
    }
}
