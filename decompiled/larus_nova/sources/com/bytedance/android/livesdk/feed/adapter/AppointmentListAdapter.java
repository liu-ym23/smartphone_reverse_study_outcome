package com.bytedance.android.livesdk.feed.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import io.reactivex.disposables.CompositeDisposable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kw1.c;
import xs2.b;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/AppointmentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "AppointmentDateViewHolder", "AppointmentItemViewHolder", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/AppointmentListAdapter$AppointmentDateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AppointmentDateViewHolder extends RecyclerView.ViewHolder {
        public AppointmentDateViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            TextView r101 = (TextView) r100.findViewById(R.id.program_date);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/AppointmentListAdapter$AppointmentItemViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "Landroid/view/View$OnClickListener;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AppointmentItemViewHolder extends BaseViewHolder<FeedItem> implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f123578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f123579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f123580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f123581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f123582e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final LottieAnimationView f123583f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Appointment f123584g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final CompositeDisposable f123585h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f123586i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f123587j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final AppointmentService f123588k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f123589l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public DoubleBallSwipeRefreshLayout f123590m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public List<Integer> f123591n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Context f123592o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Integer f123593p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final BaseDrawerFeedFragment f123594q;

        @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
        public final void onViewAttachedToWindow() {
            super.onViewAttachedToWindow();
            DoubleBallSwipeRefreshLayout r100 = this.f123590m;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.f113780c == true) goto L31;
            List<Integer> r101 = this.f123591n;
            if (r101 != null) goto L9;
        L10:
            AppointmentService r102 = this.f123588k;
            String r103 = this.f123586i;
            String r104 = this.f123587j;
            Appointment r105 = this.f123584g;
            Long r106 = null;
            if (r105 == null) goto L13;
            Long r107 = Long.valueOf(r105.appointmentId);
        L14:
            r102.logAppointmentShow(null, r103, r104, r107);
            Integer r108 = this.f123589l;
            if (r108 == null) goto L19;
            int r109 = r108.intValue();
            List<Integer> r110 = this.f123591n;
            if (r110 == null) goto L19;
            r110.add(Integer.valueOf(r109));
        L19:
            Appointment r111 = this.f123584g;
            if (r111 == null) goto L22;
            Boolean r112 = r111.isLiving;
        L24:
            if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L33;
            HashMap r113 = new HashMap();
            r113.put("enter_method", "live_program_list");
            r113.put("enter_from_merge", "drawer_chosen");
            Appointment r114 = this.f123584g;
            if (r114 == null) goto L28;
            r106 = Long.valueOf(r114.appointmentId);
        L28:
            r113.put(ILiveRoomPlayFragmentConstant.PROGRAM_ID, String.valueOf(r106));
            c.d("livesdk_live_show", r113);
            return;
        L33:
            return;
        L22:
            r112 = null;
            goto L24
        L13:
            r107 = null;
            goto L14
        L9:
            if (CollectionsKt.contains(r101, this.f123589l) != true) goto L10;
            return;
        }

        @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
        public final void onViewDetachedFromWindow() {
            super.onViewDetachedFromWindow();
            this.f123585h.clear();
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
        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            Appointment r100 = this.f123584g;
            Map<Long, Appointment.LiveFragments> r101 = null;
            Long r102 = null;
            Boolean r103 = null;
            Long r104 = null;
            Long r105 = null;
            if (r100 == null) goto L5;
            Boolean r106 = r100.isLiving;
        L6:
            String r107 = "";
            if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L28;
            List<e> r111 = p.f().c();
            if (TTLiveService.getLiveService() == null) goto L17;
            ILiveService r108 = TTLiveService.getLiveService();
            if (r108 == null) goto L15;
            ILiveOntologyInfoManager r109 = r108.getLiveOntologyRecord();
            if (r109 == null) goto L15;
            r107 = r109.getInnerUrl();
        L15:
            r107 = null;
        L17:
            if (TextUtils.isEmpty(r107) == false) goto L24;
            Iterator<e> r112 = r111.iterator();
        L20:
            if (r112.hasNext() == false) goto L24;
            e r113 = r112.next();
            if (r113.getType() != 5) goto L20;
            r107 = r113.h();
        L24:
            String r114 = r107;
            AppointmentService r115 = this.f123588k;
            Appointment r116 = this.f123584g;
            if (r116 == null) goto L27;
            r102 = Long.valueOf(r116.roomId);
        L27:
            r115.openLive(r102, r114, this.f123593p, null, this.f123584g, this.f123592o, this.f123586i);
            return;
        L28:
            Appointment r117 = this.f123584g;
            if (r117 == null) goto L31;
            Map<Long, Appointment.LiveFragments> r118 = r117.liveExtractsMap;
        L32:
            boolean r119 = false;
            if (r118 != null) goto L35;
        L38:
            boolean r120 = true;
        L39:
            if (r120 == false) goto L69;
            if (r110 != null) goto L42;
        L47:
            Appointment r121 = this.f123584g;
            if (r121 == null) goto L56;
            String r122 = r121.programJumpUrl;
            if (r122 == null) goto L56;
            ((IBrowserService) k.n(IBrowserService.class)).buildFullScreenWebPage(s1.getContext(), r122).b();
            AppointmentService r123 = this.f123588k;
            String r124 = this.f123586i;
            Appointment r125 = this.f123584g;
            if (r125 == null) goto L54;
            r104 = Long.valueOf(r125.appointmentId);
        L54:
            r123.logClickReserve("others", null, r124, r104, "H5");
            return;
        L56:
            if (r121 == null) goto L90;
            String r126 = r121.getAnchorIdStr();
            if (r126 == null) goto L91;
            HashMap r127 = new HashMap(1);
            Appointment r128 = this.f123584g;
            if (r128 == null) goto L65;
            String r129 = r128.secAnchorId;
            if (r129 == null) goto L65;
            r107 = r129;
        L65:
            r127.put("sec_user_id", r107);
            ((IRoomService) k.n(IRoomService.class)).actionHandler().showUserProfile(r126, null, r127);
            AppointmentService r130 = this.f123588k;
            String r131 = this.f123586i;
            Appointment r132 = this.f123584g;
            if (r132 == null) goto L68;
            r105 = Long.valueOf(r132.appointmentId);
        L68:
            r130.logClickReserve("others", null, r131, r105, "personal_page");
            return;
        L91:
            return;
        L90:
            return;
        L42:
            if (r110.getId() != R.id.program_button) goto L47;
            AppointmentService r133 = this.f123588k;
            Appointment r134 = this.f123584g;
            if (r134 == null) goto L46;
            r103 = r134.isReserved;
        L46:
            r133.reserve(r103, this.f123592o, this.f123593p, this.f123582e, null, r134, this.f123586i, this.f123585h);
            return;
        L69:
            Appointment r135 = this.f123584g;
            if (r135 == null) goto L72;
            r101 = r135.liveExtractsMap;
        L72:
            if (r101 != null) goto L74;
        L75:
            r119 = true;
        L76:
            if (r119 == true) goto L93;
            Appointment r136 = this.f123584g;
            if (r136 == null) goto L94;
            Map<Long, Appointment.LiveFragments> r137 = r136.liveExtractsMap;
            if (r137 == null) goto L95;
            this.f123588k.openVideo(r137, this.f123592o, null, this.f123586i, r136);
            return;
        L95:
            return;
        L94:
            return;
        L93:
            return;
        L74:
            if (r101.isEmpty() == false) goto L76;
        L35:
            if (r118.isEmpty() == true) goto L38;
            r120 = false;
            goto L39
        L31:
            r118 = null;
            goto L32
        L5:
            r106 = null;
            goto L6
        }

        public final void T3(FeedItem r110, int r111) {
            this.f123589l = Integer.valueOf(r111);
            BaseDrawerFeedFragment r112 = this.f123594q;
            Drawable r100 = null;
            if (r112 == null) goto L5;
            DoubleBallSwipeRefreshLayout r113 = r112.aa0();
        L6:
            this.f123590m = r113;
            BaseDrawerFeedFragment r114 = this.f123594q;
            if (r114 == null) goto L9;
            List<Integer> r115 = r114.Z90();
        L10:
            this.f123591n = r115;
            if (r110 == null) goto L13;
            Appointment r116 = r110.appointment;
        L14:
            Integer r117 = this.f123593p;
            boolean r101 = true;
            if (r117 != null) goto L18;
        L20:
            if (r117 != null) goto L23;
        L25:
            if (r117 == null) goto L28;
            r117.intValue();
        L28:
            Integer r118 = this.f123593p;
            if (r118 != null) goto L32;
        L34:
            if (r118 != null) goto L37;
        L39:
            if (r118 != null) goto L42;
        L44:
            String r119 = "";
        L45:
            this.f123586i = r119;
            this.f123584g = r116;
            this.f123583f.pauseAnimation();
            this.f123583f.setVisibility(8);
            Drawable r120 = this.f123582e.getBackground();
            if ((r120 instanceof GradientDrawable) == true) goto L48;
            r120 = null;
        L48:
            GradientDrawable r121 = (GradientDrawable) r120;
            if (r121 == null) goto L51;
            r121.setColor(s1.h(R.color.ttlive_normal_btn_red_bg));
        L51:
            this.f123581d.setTextColor(s1.h(R.color.ttlive_white_50));
            this.f123581d.getPaint().setShader(null);
            this.f123581d.setTypeface(Typeface.DEFAULT);
            this.f123581d.setVisibility(0);
            HSImageView r122 = this.f123578a;
            Appointment r102 = this.f123584g;
            if (r102 == null) goto L54;
            String r103 = r102.coverImgUrl;
        L55:
            ImageLoader.bindImage(r122, r103);
            Appointment r123 = this.f123584g;
            if (r123 == null) goto L58;
            String r124 = r123.subTitle;
        L60:
            if (TextUtils.isEmpty(r124) == true) goto L66;
            TextView r125 = this.f123580c;
            Appointment r104 = this.f123584g;
            if (r104 == null) goto L64;
            String r105 = r104.subTitle;
        L65:
            r125.setText(r105);
            this.f123580c.setVisibility(0);
        L67:
            TextView r126 = this.f123579b;
            Appointment r106 = this.f123584g;
            if (r106 == null) goto L70;
            String r107 = r106.title;
        L71:
            r126.setText(r107);
            Appointment r127 = this.f123584g;
            if (r127 == null) goto L74;
            String r128 = r127.dueStartTime;
        L76:
            if (TextUtils.isEmpty(r128) == true) goto L84;
            String r129 = s1.B(R.string.ttlive_start_time);
            TextView r108 = this.f123581d;
            StringCompanionObject r109 = StringCompanionObject.INSTANCE;
            Object[] r130 = new Object[1];
            SimpleDateFormat r131 = new SimpleDateFormat("HH:mm");
            Appointment r132 = this.f123584g;
            if (r132 == null) goto L82;
            String r133 = r132.dueStartTime;
            if (r133 == null) goto L82;
            Long r134 = Long.valueOf(CastLongProtector.parseLong(r133) * ((long) 1000));
        L83:
            r130[0] = r131.format(r134);
            r108.setText(String.format(r129, Arrays.copyOf(r130, 1)));
        L82:
            r134 = null;
        L84:
            Appointment r135 = this.f123584g;
            if (r135 == null) goto L87;
            Boolean r136 = r135.isLiving;
        L88:
            Boolean r137 = Boolean.TRUE;
            if (Intrinsics.areEqual(r136, r137) == false) goto L91;
            this.f123587j = "play";
            this.f123582e.setText(s1.B(R.string.ttlive_open_live));
            this.f123583f.playAnimation();
            this.f123583f.setVisibility(0);
            this.f123581d.setText(s1.B(R.string.ttlive_living));
            this.f123581d.setTextColor(ColorProtector.parseColor("#E6ED3495"));
            this.f123581d.setTypeface(Typeface.DEFAULT_BOLD);
        L123:
            this.f123582e.setOnClickListener(this);
            this.itemView.setOnClickListener(this);
            this.f123578a.setOnClickListener(this);
            ((ObservableSubscribeProxy) b.a().b(qm1.a.class).as(AutoDispose.bind(this.f123594q))).subscribe(new a(this));
            return;
        L91:
            Appointment r138 = this.f123584g;
            if (r138 == null) goto L94;
            Map<Long, Appointment.LiveFragments> r139 = r138.liveExtractsMap;
        L95:
            if (r139 == null) goto L101;
            if (r139.isEmpty() == true) goto L101;
            r101 = false;
        L101:
            if (r101 == true) goto L109;
            this.f123587j = VideoEventOneOutSync.END_TYPE_FINISH;
            this.f123581d.setVisibility(8);
            this.f123582e.setText(s1.B(R.string.ttlive_open_fragments));
            Drawable r140 = this.f123582e.getBackground();
            if ((r140 instanceof GradientDrawable) == false) goto L106;
            r100 = r140;
        L106:
            GradientDrawable r141 = (GradientDrawable) r100;
            if (r141 == null) goto L123;
            r141.setColor(s1.h(R.color.ttlive_std_bg_1));
            goto L123
        L109:
            Appointment r142 = this.f123584g;
            if (r142 == null) goto L112;
            Boolean r143 = r142.isReserved;
        L114:
            if (Intrinsics.areEqual(r143, r137) == false) goto L122;
            this.f123587j = "cancel_reserve";
            this.f123582e.setText(s1.B(R.string.ttlive_has_reserved));
            Drawable r144 = this.f123582e.getBackground();
            if ((r144 instanceof GradientDrawable) == false) goto L119;
            r100 = r144;
        L119:
            GradientDrawable r145 = (GradientDrawable) r100;
            if (r145 == null) goto L123;
            r145.setColor(s1.h(R.color.ttlive_std_bg_1));
            goto L123
        L122:
            this.f123587j = "reserve";
            this.f123582e.setText(s1.B(R.string.ttlive_reserve));
            goto L123
        L112:
            r143 = null;
            goto L114
        L94:
            r139 = null;
            goto L95
        L87:
            r136 = null;
            goto L88
        L74:
            r128 = null;
            goto L76
        L70:
            r107 = null;
            goto L71
        L64:
            r105 = null;
            goto L65
        L66:
            this.f123580c.setVisibility(8);
            goto L67
        L58:
            r124 = null;
            goto L60
        L54:
            r103 = null;
            goto L55
        L42:
            if (r118.intValue() != 3) goto L44;
            r119 = "research_activity_page";
            goto L45
        L37:
            if (r118.intValue() != 2) goto L39;
            r119 = "drawer_chosen_tab";
            goto L45
        L32:
            if (r118.intValue() != 1) goto L34;
            r119 = "live_end_page";
            goto L45
        L23:
            if (r117.intValue() != 2) goto L25;
        L18:
            if (r117.intValue() != 1) goto L20;
        L13:
            r116 = null;
            goto L14
        L9:
            r115 = null;
            goto L10
        L5:
            r113 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
        public final /* bridge */ /* synthetic */ void bind(FeedItem r100, int r101) {
            T3(r100, r101);
        }

        public AppointmentItemViewHolder(View r100, Context r101, Integer r102, BaseDrawerFeedFragment r103) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f123592o = r101;
            this.f123593p = r102;
            this.f123594q = r103;
            this.f123578a = (HSImageView) r100.findViewById(R.id.program_cover);
            this.f123579b = (TextView) r100.findViewById(R.id.program_title);
            this.f123580c = (TextView) r100.findViewById(R.id.program_sub_title);
            this.f123581d = (TextView) r100.findViewById(R.id.program_time);
            this.f123582e = (TextView) r100.findViewById(R.id.program_button);
            this.f123583f = (LottieAnimationView) r100.findViewById(R.id.live_lottie);
            this.f123585h = new CompositeDisposable();
            this.f123586i = "";
            this.f123587j = "";
            this.f123588k = new AppointmentService();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        if ((r100 instanceof AppointmentItemViewHolder) == true) goto L5;
        r100 = null;
    L5:
        AppointmentItemViewHolder r102 = (AppointmentItemViewHolder) r100;
        if (r102 == null) goto L9;
        r102.T3(null, r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 11) goto L6;
        return new AppointmentDateViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_appointment_date_vh_layout, r100, false));
    L6:
        return new AppointmentItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_appointment_item_vh_layout, r100, false), null, null, null);
    }
}
